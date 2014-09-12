package eu.redzoo.article.javaworld.reliable.payment;


import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

import eu.redzoo.article.javaworld.reliable.utils.jaxrs.ResultConsumer;





@Path("Async/Payment")
public class AsyncPaymentResource {

    private final AsyncPaymentDao paymentDao;
    
    
    public AsyncPaymentResource() {
        this.paymentDao = new PaymentDaoImpl();
    }
    

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public void getPaymentAsync(@PathParam("id") String id, @Suspended AsyncResponse asyncResponse) {
        
        paymentDao.getPaymentAsync(id)
                  .thenApply(optionalPayment -> optionalPayment.orElseThrow(NotFoundException::new))
                  .whenComplete(ResultConsumer.write(asyncResponse));
    }
}