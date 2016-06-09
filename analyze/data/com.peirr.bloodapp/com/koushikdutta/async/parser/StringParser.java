package com.koushikdutta.async.parser;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.parser.ByteBufferListParser;

public class StringParser implements AsyncParser<String> {
   public Future<String> parse(DataEmitter var1) {
      return (new TransformFuture() {
         protected void transform(ByteBufferList var1) throws Exception {
            this.setComplete(var1.readString());
         }
      }).from((new ByteBufferListParser()).parse(var1));
   }

   public void write(DataSink var1, String var2, CompletedCallback var3) {
      (new ByteBufferListParser()).write(var1, new ByteBufferList(var2.getBytes()), var3);
   }
}
