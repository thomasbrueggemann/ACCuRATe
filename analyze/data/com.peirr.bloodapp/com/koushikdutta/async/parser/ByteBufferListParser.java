package com.koushikdutta.async.parser;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.parser.AsyncParser;

public class ByteBufferListParser implements AsyncParser<ByteBufferList> {
   public Future<ByteBufferList> parse(final DataEmitter var1) {
      final ByteBufferList var2 = new ByteBufferList();
      final SimpleFuture var3 = new SimpleFuture() {
         protected void cancelCleanup() {
            var1.close();
         }
      };
      var1.setDataCallback(new DataCallback() {
         public void onDataAvailable(DataEmitter var1, ByteBufferList var2x) {
            var2x.get(var2);
         }
      });
      var1.setEndCallback(new CompletedCallback() {
         public void onCompleted(Exception var1) {
            if(var1 != null) {
               var3.setComplete(var1);
            } else {
               try {
                  var3.setComplete((Object)var2);
               } catch (Exception var3x) {
                  var3.setComplete(var3x);
               }
            }
         }
      });
      return var3;
   }

   public void write(DataSink var1, ByteBufferList var2, CompletedCallback var3) {
      Util.writeAll(var1, var2, var3);
   }
}
