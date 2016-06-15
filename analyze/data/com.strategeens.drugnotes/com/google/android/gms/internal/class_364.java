package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_356;
import com.google.android.gms.internal.class_360;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_43;
import com.google.android.gms.internal.class_432;
import com.google.android.gms.internal.class_436;
import com.google.android.gms.internal.class_437;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_440;
import com.google.android.gms.internal.class_443;
import com.google.android.gms.internal.class_446;
import com.google.android.gms.internal.class_448;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.fd
@ey
public class class_364 extends class_360 implements class_356.class_1535 {
   // $FF: renamed from: lA com.google.android.gms.internal.cy
   private final class_43 field_1099;
   private final Context mContext;
   // $FF: renamed from: mH java.lang.Object
   private final Object field_1100 = new Object();
   // $FF: renamed from: mo com.google.android.gms.internal.gu
   private final class_371 field_1101;
   // $FF: renamed from: qi com.google.android.gms.internal.cr
   private class_446 field_1102;
   // $FF: renamed from: tA com.google.android.gms.internal.fc$a
   private final class_437.class_1183 field_1103;
   // $FF: renamed from: tB com.google.android.gms.internal.fy$a
   private final class_432.class_1521 field_1104;
   // $FF: renamed from: tC boolean
   private boolean field_1105 = false;
   // $FF: renamed from: tD com.google.android.gms.internal.cp
   private class_443 field_1106;
   // $FF: renamed from: tE com.google.android.gms.internal.cv
   private class_448 field_1107;
   // $FF: renamed from: tj java.lang.Object
   private final Object field_1108 = new Object();
   // $FF: renamed from: tn com.google.android.gms.internal.fj
   private class_438 field_1109;

   public class_364(Context var1, class_432.class_1521 var2, class_371 var3, class_43 var4, class_437.class_1183 var5) {
      this.mContext = var1;
      this.field_1104 = var2;
      this.field_1109 = var2.field_4105;
      this.field_1101 = var3;
      this.field_1099 = var4;
      this.field_1103 = var5;
      this.field_1102 = var2.field_4101;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.fd) java.lang.Object
   // $FF: synthetic method
   static Object method_2477(class_364 var0) {
      return var0.field_1100;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.fh, long) void
   private void method_2478(class_440 param1, long param2) throws class_364.class_1585 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.internal.fd) com.google.android.gms.internal.fc$a
   // $FF: synthetic method
   static class_437.class_1183 method_2479(class_364 var0) {
      return var0.field_1103;
   }

   // $FF: renamed from: c (com.google.android.gms.internal.fd) com.google.android.gms.internal.fj
   // $FF: synthetic method
   static class_438 method_2480(class_364 var0) {
      return var0.field_1109;
   }

   // $FF: renamed from: c (long) boolean
   private boolean method_2481(long var1) throws class_364.class_1585 {
      long var3 = 60000L - (SystemClock.elapsedRealtime() - var1);
      if(var3 <= 0L) {
         return false;
      } else {
         try {
            this.field_1100.wait(var3);
            return true;
         } catch (InterruptedException var6) {
            throw new class_364.class_1585("Ad request cancelled.", -1);
         }
      }
   }

   // $FF: renamed from: d (com.google.android.gms.internal.fd) com.google.android.gms.internal.gu
   // $FF: synthetic method
   static class_371 method_2482(class_364 var0) {
      return var0.field_1101;
   }

   // $FF: renamed from: f (long) void
   private void method_2483(long var1) throws class_364.class_1585 {
      class_367.field_1120.post(new Runnable() {
         public void run() {
            // $FF: Couldn't be decompiled
         }
      });
      this.method_2484(var1);
   }

   // $FF: renamed from: h (long) void
   private void method_2484(long var1) throws class_364.class_1585 {
      do {
         if(!this.method_2481(var1)) {
            throw new class_364.class_1585("Timed out waiting for WebView to finish loading.", 2);
         }
      } while(!this.field_1105);

   }

   // $FF: renamed from: a (com.google.android.gms.internal.gu) void
   public void method_729(class_371 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cx () void
   public void method_2464() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: g (long) void
   protected void method_2485(long var1) throws class_364.class_1585 {
      class_237 var3 = this.field_1101.method_2525();
      int var4;
      int var5;
      if(var3.field_447) {
         var4 = this.mContext.getResources().getDisplayMetrics().widthPixels;
         var5 = this.mContext.getResources().getDisplayMetrics().heightPixels;
      } else {
         var4 = var3.widthPixels;
         var5 = var3.heightPixels;
      }

      final class_436 var6 = new class_436(this, this.field_1101, var4, var5);
      class_367.field_1120.post(new Runnable() {
         public void run() {
            // $FF: Couldn't be decompiled
         }
      });
      this.method_2484(var1);
      if(var6.method_2873()) {
         class_368.method_2502("Ad-Network indicated no fill with passback URL.");
         throw new class_364.class_1585("AdNetwork sent passback url", 3);
      } else if(!var6.method_2874()) {
         throw new class_364.class_1585("AdNetwork timed out", 2);
      }
   }

   public void onStop() {
      // $FF: Couldn't be decompiled
   }

   private static final class class_1585 extends Exception {
      // $FF: renamed from: tq int
      private final int field_3374;

      public class_1585(String var1, int var2) {
         super(var1);
         this.field_3374 = var2;
      }

      public int getErrorCode() {
         return this.field_3374;
      }
   }
}
