package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.internal.class_29;
import com.google.android.gms.internal.class_360;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_412;
import com.google.android.gms.internal.class_414;
import com.google.android.gms.internal.class_415;
import com.google.android.gms.internal.class_419;
import com.google.android.gms.internal.class_420;
import com.google.android.gms.internal.class_421;
import com.google.android.gms.internal.ef;
import com.google.android.gms.internal.ey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.ec
@ey
public class class_365 extends class_360 implements ServiceConnection {
   private Context mContext;
   // $FF: renamed from: mH java.lang.Object
   private final Object field_1110 = new Object();
   // $FF: renamed from: sD boolean
   private boolean field_1111 = false;
   // $FF: renamed from: sE com.google.android.gms.internal.er
   private class_29 field_1112;
   // $FF: renamed from: sF com.google.android.gms.internal.eb
   private class_412 field_1113;
   // $FF: renamed from: sG com.google.android.gms.internal.eh
   private class_421 field_1114;
   // $FF: renamed from: sH java.util.List
   private List<ef> field_1115 = null;
   // $FF: renamed from: sI com.google.android.gms.internal.ek
   private class_415 field_1116;

   public class_365(Context var1, class_29 var2, class_415 var3) {
      this.mContext = var1;
      this.field_1112 = var2;
      this.field_1116 = var3;
      this.field_1113 = new class_412(var1);
      this.field_1114 = class_421.method_2778(this.mContext);
      this.field_1115 = this.field_1114.method_2783(10L);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ef, java.lang.String, java.lang.String) void
   private void method_2487(final class_419 var1, String var2, String var3) {
      final Intent var4 = new Intent();
      var4.putExtra("RESPONSE_CODE", 0);
      var4.putExtra("INAPP_PURCHASE_DATA", var2);
      var4.putExtra("INAPP_DATA_SIGNATURE", var3);
      class_367.field_1120.post(new Runnable() {
         public void run() {
            try {
               if(class_365.this.field_1116.method_2748(var1.field_1312, -1, var4)) {
                  class_365.this.field_1112.method_189(new class_420(class_365.this.mContext, var1.field_1313, true, -1, var4, var1));
               } else {
                  class_365.this.field_1112.method_189(new class_420(class_365.this.mContext, var1.field_1313, false, -1, var4, var1));
               }
            } catch (RemoteException var2) {
               class_368.method_2506("Fail to verify and dispatch pending transaction");
            }
         }
      });
   }

   // $FF: renamed from: b (long) void
   private void method_2489(long var1) {
      do {
         if(!this.method_2491(var1)) {
            class_368.method_2506("Timeout waiting for pending transaction to be processed.");
         }
      } while(!this.field_1111);

   }

   // $FF: renamed from: c (long) boolean
   private boolean method_2491(long var1) {
      long var3 = 60000L - (SystemClock.elapsedRealtime() - var1);
      if(var3 <= 0L) {
         return false;
      } else {
         try {
            this.field_1110.wait(var3);
         } catch (InterruptedException var6) {
            class_368.method_2506("waitWithTimeout_lock interrupted");
         }

         return true;
      }
   }

   // $FF: renamed from: cy () void
   private void method_2492() {
      if(!this.field_1115.isEmpty()) {
         HashMap var1 = new HashMap();
         Iterator var2 = this.field_1115.iterator();

         while(var2.hasNext()) {
            class_419 var18 = (class_419)var2.next();
            var1.put(var18.field_1313, var18);
         }

         String var3 = null;

         while(true) {
            Bundle var4 = this.field_1113.method_2734(this.mContext.getPackageName(), var3);
            if(var4 == null || class_414.method_2743(var4) != 0) {
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
                  class_419 var15 = (class_419)var1.get(var12);
                  String var16 = class_414.method_2741(var13);
                  if(var15.field_1312.equals(var16)) {
                     this.method_2487(var15, var13, var14);
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
            this.field_1114.method_2780((class_419)var1.get(var11));
         }
      }

   }

   // $FF: renamed from: cx () void
   public void method_2464() {
      // $FF: Couldn't be decompiled
   }

   public void onServiceConnected(ComponentName param1, IBinder param2) {
      // $FF: Couldn't be decompiled
   }

   public void onServiceDisconnected(ComponentName var1) {
      class_368.method_2504("In-app billing service disconnected.");
      this.field_1113.destroy();
   }

   public void onStop() {
      // $FF: Couldn't be decompiled
   }
}
