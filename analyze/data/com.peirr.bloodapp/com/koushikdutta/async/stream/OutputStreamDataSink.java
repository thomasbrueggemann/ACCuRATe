package com.koushikdutta.async.stream;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class OutputStreamDataSink implements DataSink {
   boolean closeReported;
   CompletedCallback mClosedCallback;
   OutputStream mStream;
   WritableCallback mWritable;

   public OutputStreamDataSink() {
   }

   public OutputStreamDataSink(OutputStream var1) {
      this.setOutputStream(var1);
   }

   public void close() {
      try {
         if(this.mStream != null) {
            this.mStream.close();
         }

         this.reportClose((Exception)null);
      } catch (IOException var2) {
         this.reportClose(var2);
      }
   }

   public void end() {
      this.close();
   }

   public CompletedCallback getClosedCallback() {
      return this.mClosedCallback;
   }

   public OutputStream getOutputStream() {
      return this.mStream;
   }

   public AsyncServer getServer() {
      return AsyncServer.getDefault();
   }

   public WritableCallback getWriteableCallback() {
      return this.mWritable;
   }

   public boolean isOpen() {
      return this.closeReported;
   }

   public void reportClose(Exception var1) {
      if(!this.closeReported) {
         this.closeReported = true;
         if(this.mClosedCallback != null) {
            this.mClosedCallback.onCompleted(var1);
            return;
         }
      }

   }

   public void setClosedCallback(CompletedCallback var1) {
      this.mClosedCallback = var1;
   }

   public void setOutputStream(OutputStream var1) {
      this.mStream = var1;
   }

   public void setWriteableCallback(WritableCallback var1) {
      this.mWritable = var1;
   }

   public void write(ByteBufferList var1) {
      while(true) {
         boolean var7 = false;

         label48: {
            try {
               var7 = true;
               if(var1.size() > 0) {
                  ByteBuffer var4 = var1.remove();
                  this.mStream.write(var4.array(), var4.arrayOffset() + var4.position(), var4.remaining());
                  ByteBufferList.reclaim(var4);
                  var7 = false;
                  continue;
               }

               var7 = false;
            } catch (IOException var8) {
               this.reportClose(var8);
               var7 = false;
               break label48;
            } finally {
               if(var7) {
                  var1.recycle();
               }
            }

            var1.recycle();
            return;
         }

         var1.recycle();
         return;
      }
   }

   public void write(ByteBuffer var1) {
      try {
         this.mStream.write(var1.array(), var1.arrayOffset() + var1.position(), var1.remaining());
      } catch (IOException var3) {
         this.reportClose(var3);
      }

      var1.position(0);
      var1.limit(0);
   }
}
