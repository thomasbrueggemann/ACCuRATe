package com.koushikdutta.async;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.DataCallback;

public class LineEmitter implements DataCallback {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   StringBuilder data = new StringBuilder();
   LineEmitter.StringCallback mLineCallback;

   static {
      boolean var0;
      if(!LineEmitter.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public LineEmitter.StringCallback getLineCallback() {
      return this.mLineCallback;
   }

   public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
      while(true) {
         if(var2.remaining() > 0) {
            byte var3 = var2.get();
            if(var3 != 10) {
               this.data.append((char)var3);
               continue;
            }

            if(!$assertionsDisabled && this.mLineCallback == null) {
               throw new AssertionError();
            }

            this.mLineCallback.onStringAvailable(this.data.toString());
            this.data = new StringBuilder();
         }

         return;
      }
   }

   public void setLineCallback(LineEmitter.StringCallback var1) {
      this.mLineCallback = var1;
   }

   public interface StringCallback {
      void onStringAvailable(String var1);
   }
}
