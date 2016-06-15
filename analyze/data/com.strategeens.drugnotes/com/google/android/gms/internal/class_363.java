package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.class_226;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_360;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_406;
import com.google.android.gms.internal.class_435;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_440;
import com.google.android.gms.internal.class_446;
import com.google.android.gms.internal.class_557;
import com.google.android.gms.internal.ey;
import org.json.JSONException;

// $FF: renamed from: com.google.android.gms.internal.fa
@ey
public class class_363 extends class_360 implements class_435.class_1523 {
   private final Context mContext;
   // $FF: renamed from: mH java.lang.Object
   private final Object field_1091 = new Object();
   // $FF: renamed from: qi com.google.android.gms.internal.cr
   private class_446 field_1092;
   // $FF: renamed from: ti com.google.android.gms.internal.ez$a
   private final class_406.class_1529 field_1093;
   // $FF: renamed from: tj java.lang.Object
   private final Object field_1094 = new Object();
   // $FF: renamed from: tk com.google.android.gms.internal.fh$a
   private final class_440.class_1527 field_1095;
   // $FF: renamed from: tl com.google.android.gms.internal.k
   private final class_557 field_1096;
   // $FF: renamed from: tm com.google.android.gms.internal.gf
   private class_360 field_1097;
   // $FF: renamed from: tn com.google.android.gms.internal.fj
   private class_438 field_1098;

   public class_363(Context var1, class_440.class_1527 var2, class_557 var3, class_406.class_1529 var4) {
      this.field_1093 = var4;
      this.mContext = var1;
      this.field_1095 = var2;
      this.field_1096 = var3;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.fh) com.google.android.gms.internal.ay
   private class_237 method_2470(class_440 var1) throws class_363.class_1415 {
      if(this.field_1098.field_1450 == null) {
         throw new class_363.class_1415("The ad response must specify one of the supported ad sizes.", 0);
      } else {
         String[] var2 = this.field_1098.field_1450.split("x");
         if(var2.length != 2) {
            throw new class_363.class_1415("Could not parse the ad size from the ad response: " + this.field_1098.field_1450, 0);
         } else {
            int var4;
            int var5;
            try {
               var4 = Integer.parseInt(var2[0]);
               var5 = Integer.parseInt(var2[1]);
            } catch (NumberFormatException var13) {
               throw new class_363.class_1415("Could not parse the ad size from the ad response: " + this.field_1098.field_1450, 0);
            }

            class_237[] var6 = var1.field_1461.field_448;
            int var7 = var6.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               class_237 var9 = var6[var8];
               float var10 = this.mContext.getResources().getDisplayMetrics().density;
               int var11;
               if(var9.width == -1) {
                  var11 = (int)((float)var9.widthPixels / var10);
               } else {
                  var11 = var9.width;
               }

               int var12;
               if(var9.height == -2) {
                  var12 = (int)((float)var9.heightPixels / var10);
               } else {
                  var12 = var9.height;
               }

               if(var4 == var11 && var5 == var12) {
                  return new class_237(var9, var1.field_1461.field_448);
               }
            }

            throw new class_363.class_1415("The ad size from the ad response was not one of the requested sizes: " + this.field_1098.field_1450, 0);
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.fa) java.lang.Object
   // $FF: synthetic method
   static Object method_2471(class_363 var0) {
      return var0.field_1091;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.fa) com.google.android.gms.internal.ez$a
   // $FF: synthetic method
   static class_406.class_1529 method_2472(class_363 var0) {
      return var0.field_1093;
   }

   // $FF: renamed from: c (long) boolean
   private boolean method_2473(long var1) throws class_363.class_1415 {
      long var3 = 60000L - (SystemClock.elapsedRealtime() - var1);
      if(var3 <= 0L) {
         return false;
      } else {
         try {
            this.field_1091.wait(var3);
            return true;
         } catch (InterruptedException var6) {
            throw new class_363.class_1415("Ad request cancelled.", -1);
         }
      }
   }

   // $FF: renamed from: cE () void
   private void method_2474() throws class_363.class_1415 {
      if(this.field_1098.errorCode != -3) {
         if(TextUtils.isEmpty(this.field_1098.field_1445)) {
            throw new class_363.class_1415("No fill from ad server.", 3);
         }

         class_381.method_2603(this.mContext, this.field_1098.field_1444);
         if(this.field_1098.field_1447) {
            try {
               this.field_1092 = new class_446(this.field_1098.field_1445);
               return;
            } catch (JSONException var2) {
               throw new class_363.class_1415("Could not parse mediation config: " + this.field_1098.field_1445, 0);
            }
         }
      }

   }

   // $FF: renamed from: e (long) void
   private void method_2475(long param1) throws class_363.class_1415 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: t (boolean) void
   private void method_2476(boolean var1) {
      class_381.method_2607().method_2632(var1);
      class_226 var2 = class_381.method_2607().method_2631(this.mContext);
      if(var2 != null && !var2.isAlive()) {
         class_368.method_2502("start fetching content...");
         var2.method_1555();
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.fj) void
   public void method_666(class_438 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cx () void
   public void method_2464() {
      // $FF: Couldn't be decompiled
   }

   public void onStop() {
      // $FF: Couldn't be decompiled
   }

   @ey
   private static final class class_1415 extends Exception {
      // $FF: renamed from: tq int
      private final int field_2816;

      public class_1415(String var1, int var2) {
         super(var1);
         this.field_2816 = var2;
      }

      public int getErrorCode() {
         return this.field_2816;
      }
   }
}
