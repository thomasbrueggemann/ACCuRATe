package com.koushikdutta.ion;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.BitmapCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.IonRequestBuilder;
import com.koushikdutta.ion.bitmap.BitmapInfo;

class LoadBitmap extends BitmapCallback implements FutureCallback<ByteBufferList> {
   IonRequestBuilder.EmitterTransform<ByteBufferList> emitterTransform;
   int resizeHeight;
   int resizeWidth;

   public LoadBitmap(Ion var1, String var2, boolean var3, int var4, int var5, IonRequestBuilder.EmitterTransform<ByteBufferList> var6) {
      super(var1, var2, var3);
      this.resizeWidth = var4;
      this.resizeHeight = var5;
      this.emitterTransform = var6;
   }

   public void onCompleted(Exception var1, final ByteBufferList var2) {
      if(var1 != null) {
         this.report(var1, (BitmapInfo)null);
      } else {
         this.ion.getServer().getExecutorService().execute(new Runnable() {
            public void run() {
               // $FF: Couldn't be decompiled
            }
         });
      }
   }
}
