package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.internal.class_358;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_409;
import com.google.android.gms.internal.class_412;
import com.google.android.gms.internal.class_413;
import com.google.android.gms.internal.class_414;
import com.google.android.gms.internal.class_415;
import com.google.android.gms.internal.class_439;
import com.google.android.gms.internal.class_50;
import com.google.android.gms.internal.cw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.ct
public class class_361 extends class_358 implements ServiceConnection {
   // $FF: renamed from: lq java.lang.Object
   private final Object field_1563 = new Object();
   private Context mContext;
   // $FF: renamed from: oU boolean
   private boolean field_1564 = false;
   // $FF: renamed from: oV com.google.android.gms.internal.dh
   private class_50 field_1565;
   // $FF: renamed from: oW com.google.android.gms.internal.cs
   private class_409 field_1566;
   // $FF: renamed from: oX com.google.android.gms.internal.cy
   private class_415 field_1567;
   // $FF: renamed from: oY java.util.List
   private List<cw> field_1568 = null;
   // $FF: renamed from: oZ com.google.android.gms.internal.da
   private class_439 field_1569;

   public class_361(Context var1, class_50 var2, class_439 var3) {
      this.mContext = var1;
      this.field_1565 = var2;
      this.field_1569 = var3;
      this.field_1566 = new class_409(var1);
      this.field_1567 = class_415.method_2537(this.mContext);
      this.field_1568 = this.field_1567.method_2542(10L);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.cw, java.lang.String, java.lang.String) void
   private void method_2278(final class_413 var1, String var2, String var3) {
      final Intent var4 = new Intent();
      var4.putExtra("RESPONSE_CODE", 0);
      var4.putExtra("INAPP_PURCHASE_DATA", var2);
      var4.putExtra("INAPP_DATA_SIGNATURE", var3);
      class_371.field_1606.post(new Runnable() {
         public void run() {
            try {
               if(class_361.this.field_1569.method_2671(var1.field_1825, -1, var4)) {
                  class_361.this.field_1565.method_209(new class_412(class_361.this.mContext, var1.field_1826, true, -1, var4, var1));
               } else {
                  class_361.this.field_1565.method_209(new class_412(class_361.this.mContext, var1.field_1826, false, -1, var4, var1));
               }
            } catch (RemoteException var2) {
               class_370.method_2358("Fail to verify and dispatch pending transaction");
            }
         }
      });
   }

   // $FF: renamed from: b (long) void
   private void method_2280(long var1) {
      do {
         if(!this.method_2283(var1)) {
            class_370.method_2358("Timeout waiting for pending transaction to be processed.");
         }
      } while(!this.field_1564);

   }

   // $FF: renamed from: bd () void
   private void method_2281() {
      if(!this.field_1568.isEmpty()) {
         HashMap var1 = new HashMap();
         Iterator var2 = this.field_1568.iterator();

         while(var2.hasNext()) {
            class_413 var18 = (class_413)var2.next();
            var1.put(var18.field_1826, var18);
         }

         String var3 = null;

         while(true) {
            Bundle var4 = this.field_1566.method_2519(this.mContext.getPackageName(), var3);
            if(var4 == null || class_414.method_2530(var4) != 0) {
               break;
            }

            ArrayList var5 = var4.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList var6 = var4.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList var7 = var4.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            String var8 = var4.getString("INAPP_CONTINUATION_TOKEN");

            for(int var9 = 0; var9 < var5.size(); ++var9) {
               if(var1.containsKey(var5.get(var9))) {
                  String var12 = (String)var5.get(var9);
                  String var13 = (String)var6.get(var9);
                  String var14 = (String)var7.get(var9);
                  class_413 var15 = (class_413)var1.get(var12);
                  String var16 = class_414.method_2534(var13);
                  if(var15.field_1825.equals(var16)) {
                     this.method_2278(var15, var13, var14);
                     var1.remove(var12);
                  }
               }
            }

            if(var8 == null || var1.isEmpty()) {
               break;
            }

            var3 = var8;
         }

         Iterator var10 = var1.keySet().iterator();

         while(var10.hasNext()) {
            String var11 = (String)var10.next();
            this.field_1567.method_2539((class_413)var1.get(var11));
         }
      }

   }

   // $FF: renamed from: c (long) boolean
   private boolean method_2283(long var1) {
      long var3 = 60000L - (SystemClock.elapsedRealtime() - var1);
      if(var3 <= 0L) {
         return false;
      } else {
         try {
            this.field_1563.wait(var3);
         } catch (InterruptedException var6) {
            class_370.method_2358("waitWithTimeout_lock interrupted");
         }

         return true;
      }
   }

   // $FF: renamed from: bc () void
   public void method_2261() {
      // $FF: Couldn't be decompiled
   }

   public void onServiceConnected(ComponentName param1, IBinder param2) {
      // $FF: Couldn't be decompiled
   }

   public void onServiceDisconnected(ComponentName var1) {
      class_370.method_2356("In-app billing service disconnected.");
      this.field_1566.destroy();
   }

   public void onStop() {
      // $FF: Couldn't be decompiled
   }
}
