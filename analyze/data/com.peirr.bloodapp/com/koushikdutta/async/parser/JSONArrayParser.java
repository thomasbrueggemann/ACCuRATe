package com.koushikdutta.async.parser;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.parser.AsyncParser;
import com.koushikdutta.async.parser.StringParser;
import org.json.JSONArray;

public class JSONArrayParser implements AsyncParser<JSONArray> {
   public Future<JSONArray> parse(DataEmitter var1) {
      return (new TransformFuture() {
         protected void transform(String var1) throws Exception {
            this.setComplete(new JSONArray(var1));
         }
      }).from((new StringParser()).parse(var1));
   }

   public void write(DataSink var1, JSONArray var2, CompletedCallback var3) {
      (new StringParser()).write(var1, var2.toString(), var3);
   }
}
