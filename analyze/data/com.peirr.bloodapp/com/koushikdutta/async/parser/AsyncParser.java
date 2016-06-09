package com.koushikdutta.async.parser;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;

public interface AsyncParser<T> {
   Future<T> parse(DataEmitter var1);

   void write(DataSink var1, T var2, CompletedCallback var3);
}
