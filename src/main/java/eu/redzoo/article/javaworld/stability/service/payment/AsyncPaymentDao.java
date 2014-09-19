/*
 * Copyright (c) 2014, Gregor Roth, All rights reserved.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 */ 
package eu.redzoo.article.javaworld.stability.service.payment;


import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.google.common.collect.ImmutableList;





interface AsyncPaymentDao {

    CompletableFuture<ImmutableList<Payment>> getPaymentsAsync(String address, int max);
    
    CompletableFuture<Optional<Payment>> getPaymentAsync(String id);
}