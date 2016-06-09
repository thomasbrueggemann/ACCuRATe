package com.koushikdutta.async.future;

public interface Cancellable {
   boolean cancel();

   boolean isCancelled();

   boolean isDone();
}
