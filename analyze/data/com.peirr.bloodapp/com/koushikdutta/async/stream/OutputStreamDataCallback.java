package com.koushikdutta.async.stream;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class OutputStreamDataCallback implements DataCallback, CompletedCallback {
   private OutputStream mOutput;

   public OutputStreamDataCallback(OutputStream var1) {
      this.mOutput = var1;
   }

   public void close() {
      try {
         this.mOutput.close();
      } catch (IOException var2) {
         this.onCompleted(var2);
      }
   }

   public OutputStream getOutputStream() {
      return this.mOutput;
   }

   public void onCompleted(Exception var1) {
      var1.printStackTrace();
   }

   public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
      while(true) {
         boolean var8 = false;

         label48: {
            try {
               var8 = true;
               if(var2.size() > 0) {
                  ByteBuffer var5 = var2.remove();
                  this.mOutput.write(var5.array(), var5.arrayOffset() + var5.position(), var5.remaining());
                  ByteBufferList.reclaim(var5);
                  var8 = false;
                  continue;
               }

               var8 = false;
            } catch (Exception var9) {
               this.onCompleted(var9);
               var8 = false;
               break label48;
            } finally {
               if(var8) {
                  var2.recycle();
               }
            }

            var2.recycle();
            return;
         }

         var2.recycle();
         return;
      }
   }
}
