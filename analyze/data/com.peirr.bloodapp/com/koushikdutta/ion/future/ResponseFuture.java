package com.koushikdutta.ion.future;

import com.koushikdutta.async.future.Future;
import com.koushikdutta.ion.Response;

public interface ResponseFuture<T> extends Future<T> {
   Future<Response<T>> withResponse();
}
