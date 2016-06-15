package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.internal.class_218;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_43;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_446;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.class_448;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.cu
@ey
public final class class_449 implements class_448.class_1526 {
   // $FF: renamed from: lA com.google.android.gms.internal.cy
   private final class_43 field_1509;
   private final Context mContext;
   // $FF: renamed from: mH java.lang.Object
   private final Object field_1510 = new Object();
   // $FF: renamed from: mw com.google.android.gms.internal.av
   private final class_218 field_1511;
   // $FF: renamed from: qF java.lang.String
   private final String field_1512;
   // $FF: renamed from: qG long
   private final long field_1513;
   // $FF: renamed from: qH com.google.android.gms.internal.cq
   private final class_447 field_1514;
   // $FF: renamed from: qI com.google.android.gms.internal.ay
   private final class_237 field_1515;
   // $FF: renamed from: qJ com.google.android.gms.internal.gs
   private final class_369 field_1516;
   // $FF: renamed from: qK com.google.android.gms.internal.cz
   private class_42 field_1517;
   // $FF: renamed from: qL int
   private int field_1518 = -2;

   public class_449(Context var1, String var2, class_43 var3, class_446 var4, class_447 var5, class_218 var6, class_237 var7, class_369 var8) {
      this.mContext = var1;
      this.field_1509 = var3;
      this.field_1514 = var5;
      if("com.google.ads.mediation.customevent.CustomEventAdapter".equals(var2)) {
         this.field_1512 = this.method_2908();
      } else {
         this.field_1512 = var2;
      }

      long var9;
      if(var4.field_1488 != -1L) {
         var9 = var4.field_1488;
      } else {
         var9 = 10000L;
      }

      this.field_1513 = var9;
      this.field_1511 = var6;
      this.field_1515 = var7;
      this.field_1516 = var8;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.cu, com.google.android.gms.internal.cz) com.google.android.gms.internal.cz
   // $FF: synthetic method
   static class_42 method_2901(class_449 var0, class_42 var1) {
      var0.field_1517 = var1;
      return var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.cu) java.lang.Object
   // $FF: synthetic method
   static Object method_2902(class_449 var0) {
      return var0.field_1510;
   }

   // $FF: renamed from: a (long, long, long, long) void
   private void method_2903(long var1, long var3, long var5, long var7) {
      while(this.field_1518 == -2) {
         this.method_2907(var1, var3, var5, var7);
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.ct) void
   private void method_2904(class_445 var1) {
      try {
         if(this.field_1516.field_1123 < 4100000) {
            if(this.field_1515.field_447) {
               this.field_1517.method_206(class_960.method_5293(this.mContext), this.field_1511, this.field_1514.field_1499, var1);
            } else {
               this.field_1517.method_208(class_960.method_5293(this.mContext), this.field_1515, this.field_1511, this.field_1514.field_1499, var1);
            }
         } else if(this.field_1515.field_447) {
            this.field_1517.method_207(class_960.method_5293(this.mContext), this.field_1511, this.field_1514.field_1499, this.field_1514.field_1493, var1);
         } else {
            this.field_1517.method_209(class_960.method_5293(this.mContext), this.field_1515, this.field_1511, this.field_1514.field_1499, this.field_1514.field_1493, var1);
         }
      } catch (RemoteException var3) {
         class_368.method_2510("Could not request ad from mediation adapter.", var3);
         this.method_1073(5);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.cu, com.google.android.gms.internal.ct) void
   // $FF: synthetic method
   static void method_2905(class_449 var0, class_445 var1) {
      var0.method_2904(var1);
   }

   // $FF: renamed from: b (com.google.android.gms.internal.cu) int
   // $FF: synthetic method
   static int method_2906(class_449 var0) {
      return var0.field_1518;
   }

   // $FF: renamed from: b (long, long, long, long) void
   private void method_2907(long var1, long var3, long var5, long var7) {
      long var9 = SystemClock.elapsedRealtime();
      long var11 = var3 - (var9 - var1);
      long var13 = var7 - (var9 - var5);
      if(var11 > 0L && var13 > 0L) {
         try {
            this.field_1510.wait(Math.min(var11, var13));
         } catch (InterruptedException var16) {
            this.field_1518 = -1;
         }
      } else {
         class_368.method_2504("Timed out waiting for adapter.");
         this.field_1518 = 3;
      }
   }

   // $FF: renamed from: bO () java.lang.String
   private String method_2908() {
      try {
         if(!TextUtils.isEmpty(this.field_1514.field_1497)) {
            if(this.field_1509.method_211(this.field_1514.field_1497)) {
               return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
            }

            return "com.google.ads.mediation.customevent.CustomEventAdapter";
         }
      } catch (RemoteException var2) {
         class_368.method_2506("Fail to determine the custom event\'s version, assuming the old one.");
      }

      return "com.google.ads.mediation.customevent.CustomEventAdapter";
   }

   // $FF: renamed from: bP () com.google.android.gms.internal.cz
   private class_42 method_2909() {
      class_368.method_2504("Instantiating mediation adapter: " + this.field_1512);

      try {
         class_42 var2 = this.field_1509.method_210(this.field_1512);
         return var2;
      } catch (RemoteException var3) {
         class_368.method_2507("Could not instantiate mediation adapter: " + this.field_1512, var3);
         return null;
      }
   }

   // $FF: renamed from: c (com.google.android.gms.internal.cu) com.google.android.gms.internal.cz
   // $FF: synthetic method
   static class_42 method_2910(class_449 var0) {
      return var0.method_2909();
   }

   // $FF: renamed from: d (com.google.android.gms.internal.cu) com.google.android.gms.internal.cz
   // $FF: synthetic method
   static class_42 method_2911(class_449 var0) {
      return var0.field_1517;
   }

   // $FF: renamed from: b (long, long) com.google.android.gms.internal.cv
   public class_448 method_2912(long param1, long param3) {
      // $FF: Couldn't be decompiled
   }

   public void cancel() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: k (int) void
   public void method_1073(int param1) {
      // $FF: Couldn't be decompiled
   }
}
