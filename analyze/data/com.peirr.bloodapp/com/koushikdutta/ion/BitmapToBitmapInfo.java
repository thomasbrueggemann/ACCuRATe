package com.koushikdutta.ion;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.BitmapCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.Transform;
import java.util.ArrayList;

class BitmapToBitmapInfo extends BitmapCallback implements FutureCallback<BitmapInfo> {
   ArrayList<Transform> transforms;

   public BitmapToBitmapInfo(Ion var1, String var2, ArrayList<Transform> var3) {
      super(var1, var2, true);
      this.transforms = var3;
   }

   public void onCompleted(Exception var1, final BitmapInfo var2) {
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
