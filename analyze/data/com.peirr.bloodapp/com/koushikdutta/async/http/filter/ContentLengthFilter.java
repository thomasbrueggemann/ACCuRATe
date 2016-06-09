package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;

public class ContentLengthFilter extends FilteredDataEmitter {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   int contentLength;
   int totalRead;
   ByteBufferList transformed = new ByteBufferList();

   static {
      boolean var0;
      if(!ContentLengthFilter.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public ContentLengthFilter(int var1) {
      this.contentLength = var1;
   }

   public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
      if(!$assertionsDisabled && this.totalRead >= this.contentLength) {
         throw new AssertionError();
      } else {
         int var3 = var2.remaining();
         int var4 = Math.min(this.contentLength - this.totalRead, var3);
         var2.get(this.transformed, var4);
         this.totalRead += this.transformed.remaining();
         super.onDataAvailable(var1, this.transformed);
         if(this.totalRead == this.contentLength) {
            this.report((Exception)null);
         }

      }
   }

   protected void report(Exception var1) {
      if(var1 == null && this.totalRead != this.contentLength) {
         var1 = new Exception("End of data reached before content length was read");
      }

      super.report(var1);
   }
}
