package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.class_13;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_193;
import com.google.android.gms.internal.class_196;
import com.google.android.gms.internal.class_200;
import com.google.android.gms.internal.class_358;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_425;
import com.google.android.gms.internal.class_428;
import com.google.android.gms.internal.class_429;
import com.google.android.gms.internal.class_431;
import com.google.android.gms.internal.class_433;
import com.google.android.gms.internal.class_457;
import org.json.JSONException;

// $FF: renamed from: com.google.android.gms.internal.do
public class class_360 extends class_358 implements class_428.class_826, class_367.class_1262 {
   // $FF: renamed from: kz com.google.android.gms.internal.bu
   private final class_13 field_1550;
   // $FF: renamed from: lL com.google.android.gms.internal.ey
   private final class_369 field_1551;
   // $FF: renamed from: lq java.lang.Object
   private final Object field_1552 = new Object();
   private final Context mContext;
   // $FF: renamed from: nd com.google.android.gms.internal.bn
   private class_196 field_1553;
   // $FF: renamed from: pA com.google.android.gms.internal.dv
   private class_431 field_1554;
   // $FF: renamed from: pB boolean
   private boolean field_1555 = false;
   // $FF: renamed from: pC com.google.android.gms.internal.bl
   private class_200 field_1556;
   // $FF: renamed from: pD com.google.android.gms.internal.br
   private class_193 field_1557;
   // $FF: renamed from: pv com.google.android.gms.internal.dn$a
   private final class_425.class_1152 field_1558;
   // $FF: renamed from: pw java.lang.Object
   private final Object field_1559 = new Object();
   // $FF: renamed from: px com.google.android.gms.internal.dt$a
   private final class_433.class_1158 field_1560;
   // $FF: renamed from: py com.google.android.gms.internal.l
   private final class_457 field_1561;
   // $FF: renamed from: pz com.google.android.gms.internal.en
   private class_358 field_1562;

   public class_360(Context var1, class_433.class_1158 var2, class_457 var3, class_369 var4, class_13 var5, class_425.class_1152 var6) {
      this.field_1550 = var5;
      this.field_1558 = var6;
      this.field_1551 = var4;
      this.mContext = var1;
      this.field_1560 = var2;
      this.field_1561 = var3;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.dt) com.google.android.gms.internal.am
   private class_172 method_2265(class_433 var1) throws class_360.class_1268 {
      if(this.field_1554.field_1894 == null) {
         throw new class_360.class_1268("The ad response must specify one of the supported ad sizes.", 0);
      } else {
         String[] var2 = this.field_1554.field_1894.split("x");
         if(var2.length != 2) {
            throw new class_360.class_1268("Could not parse the ad size from the ad response: " + this.field_1554.field_1894, 0);
         } else {
            int var4;
            int var5;
            try {
               var4 = Integer.parseInt(var2[0]);
               var5 = Integer.parseInt(var2[1]);
            } catch (NumberFormatException var13) {
               throw new class_360.class_1268("Could not parse the ad size from the ad response: " + this.field_1554.field_1894, 0);
            }

            class_172[] var6 = var1.field_1902.field_571;
            int var7 = var6.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               class_172 var9 = var6[var8];
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
                  return new class_172(var9, var1.field_1902.field_571);
               }
            }

            throw new class_360.class_1268("The ad size from the ad response was not one of the requested sizes: " + this.field_1554.field_1894, 0);
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.do) java.lang.Object
   // $FF: synthetic method
   static Object method_2266(class_360 var0) {
      return var0.field_1552;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.dt, long) void
   private void method_2267(class_433 param1, long param2) throws class_360.class_1268 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.internal.do) com.google.android.gms.internal.dn$a
   // $FF: synthetic method
   static class_425.class_1152 method_2268(class_360 var0) {
      return var0.field_1558;
   }

   // $FF: renamed from: bi () void
   private void method_2269() throws class_360.class_1268 {
      if(this.field_1554.errorCode != -3) {
         if(TextUtils.isEmpty(this.field_1554.field_1889)) {
            throw new class_360.class_1268("No fill from ad server.", 3);
         }

         if(this.field_1554.field_1891) {
            try {
               this.field_1553 = new class_196(this.field_1554.field_1889);
               return;
            } catch (JSONException var2) {
               throw new class_360.class_1268("Could not parse mediation config: " + this.field_1554.field_1889, 0);
            }
         }
      }

   }

   // $FF: renamed from: c (com.google.android.gms.internal.do) com.google.android.gms.internal.dv
   // $FF: synthetic method
   static class_431 method_2270(class_360 var0) {
      return var0.field_1554;
   }

   // $FF: renamed from: c (long) boolean
   private boolean method_2271(long var1) throws class_360.class_1268 {
      long var3 = 60000L - (SystemClock.elapsedRealtime() - var1);
      if(var3 <= 0L) {
         return false;
      } else {
         try {
            this.field_1552.wait(var3);
            return true;
         } catch (InterruptedException var6) {
            throw new class_360.class_1268("Ad request cancelled.", -1);
         }
      }
   }

   // $FF: renamed from: d (com.google.android.gms.internal.do) com.google.android.gms.internal.ey
   // $FF: synthetic method
   static class_369 method_2272(class_360 var0) {
      return var0.field_1551;
   }

   // $FF: renamed from: e (long) void
   private void method_2273(long var1) throws class_360.class_1268 {
      class_371.field_1606.post(new Runnable() {
         public void run() {
            // $FF: Couldn't be decompiled
         }
      });
      this.method_2275(var1);
   }

   // $FF: renamed from: g (long) void
   private void method_2274(long param1) throws class_360.class_1268 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: h (long) void
   private void method_2275(long var1) throws class_360.class_1268 {
      do {
         if(!this.method_2271(var1)) {
            throw new class_360.class_1268("Timed out waiting for WebView to finish loading.", 2);
         }
      } while(!this.field_1555);

   }

   // $FF: renamed from: a (com.google.android.gms.internal.dv) void
   public void method_71(class_431 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ey) void
   public void method_756(class_369 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bc () void
   public void method_2261() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: f (long) void
   protected void method_2276(long var1) throws class_360.class_1268 {
      class_172 var3 = this.field_1551.method_2338();
      int var4;
      int var5;
      if(var3.field_570) {
         var4 = this.mContext.getResources().getDisplayMetrics().widthPixels;
         var5 = this.mContext.getResources().getDisplayMetrics().heightPixels;
      } else {
         var4 = var3.widthPixels;
         var5 = var3.heightPixels;
      }

      final class_429 var6 = new class_429(this, this.field_1551, var4, var5);
      class_371.field_1606.post(new Runnable() {
         public void run() {
            // $FF: Couldn't be decompiled
         }
      });
      this.method_2275(var1);
      if(var6.method_2593()) {
         class_370.method_2363("Ad-Network indicated no fill with passback URL.");
         throw new class_360.class_1268("AdNetwork sent passback url", 3);
      } else if(!var6.method_2594()) {
         throw new class_360.class_1268("AdNetwork timed out", 2);
      }
   }

   public void onStop() {
      // $FF: Couldn't be decompiled
   }

   private static final class class_1268 extends Exception {
      // $FF: renamed from: pH int
      private final int field_4056;

      public class_1268(String var1, int var2) {
         super(var1);
         this.field_4056 = var2;
      }

      public int getErrorCode() {
         return this.field_4056;
      }
   }
}
