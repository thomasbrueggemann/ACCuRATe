package com.koushikdutta.ion;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import java.util.ArrayList;
import java.util.Iterator;

class BitmapCallback {
   Ion ion;
   String key;
   boolean put;

   public BitmapCallback(Ion var1, String var2, boolean var3) {
      this.key = var2;
      this.put = var3;
      this.ion = var1;
   }

   boolean put() {
      return this.put;
   }

   void report(final Exception var1, final BitmapInfo var2) {
      AsyncServer.post(Ion.mainHandler, new Runnable() {
         public void run() {
            BitmapInfo var1x = var2;
            if(var1x == null) {
               var1x = new BitmapInfo();
               var1x.bitmap = null;
               var1x.key = BitmapCallback.this.key;
               BitmapCallback.this.ion.getBitmapCache().put(var1x);
            } else if(BitmapCallback.this.put()) {
               BitmapCallback.this.ion.getBitmapCache().put(var1x);
            }

            ArrayList var2x = (ArrayList)BitmapCallback.this.ion.bitmapsPending.remove(BitmapCallback.this.key);
            if(var2x != null && var2x.size() != 0) {
               Iterator var3 = var2x.iterator();

               while(var3.hasNext()) {
                  ((FutureCallback)var3.next()).onCompleted(var1, var1x);
               }
            }

         }
      });
   }
}
