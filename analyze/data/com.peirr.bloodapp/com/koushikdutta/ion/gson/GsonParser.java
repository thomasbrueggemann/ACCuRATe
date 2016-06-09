package com.koushikdutta.ion.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.parser.ByteBufferListParser;
import com.koushikdutta.async.parser.StringParser;
import com.koushikdutta.async.stream.ByteBufferListInputStream;
import java.io.InputStreamReader;

public class GsonParser<T extends JsonElement> implements AsyncParser<T> {
   public Future<T> parse(DataEmitter var1) {
      return (new TransformFuture() {
         protected void transform(ByteBufferList var1) throws Exception {
            JsonElement var2 = (new JsonParser()).parse(new JsonReader(new InputStreamReader(new ByteBufferListInputStream(var1))));
            if(!var2.isJsonNull() && !var2.isJsonPrimitive()) {
               this.setComplete((Exception)null, var2);
            } else {
               throw new JsonParseException("unable to parse json");
            }
         }
      }).from((new ByteBufferListParser()).parse(var1));
   }

   public void write(DataSink var1, T var2, CompletedCallback var3) {
      (new StringParser()).write(var1, var2.toString(), var3);
   }
}
