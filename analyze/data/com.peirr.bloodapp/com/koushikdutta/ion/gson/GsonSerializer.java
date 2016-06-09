package com.koushikdutta.ion.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.parser.ByteBufferListParser;
import com.koushikdutta.async.stream.ByteBufferListInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

public class GsonSerializer<T> implements AsyncParser<T> {
   Gson gson;
   Type type;

   public GsonSerializer(Gson var1, TypeToken<T> var2) {
      this.gson = var1;
      this.type = var2.getType();
   }

   public GsonSerializer(Gson var1, Class<T> var2) {
      this.gson = var1;
      this.type = var2;
   }

   public Future<T> parse(DataEmitter var1) {
      return (new TransformFuture() {
         protected void transform(ByteBufferList var1) throws Exception {
            ByteBufferListInputStream var2 = new ByteBufferListInputStream(var1);
            this.setComplete(GsonSerializer.this.gson.fromJson(new JsonReader(new InputStreamReader(var2)), GsonSerializer.this.type));
         }
      }).from((new ByteBufferListParser()).parse(var1));
   }

   public void write(DataSink var1, T var2, CompletedCallback var3) {
      ByteArrayOutputStream var4 = new ByteArrayOutputStream();
      OutputStreamWriter var5 = new OutputStreamWriter(var4);
      this.gson.toJson(var2, this.type, (Appendable)var5);
      Util.writeAll(var1, var4.toByteArray(), var3);
   }
}
