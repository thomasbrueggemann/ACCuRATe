package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.internal.bq;
import com.google.android.gms.internal.class_11;
import com.google.android.gms.internal.class_13;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_182;
import com.google.android.gms.internal.class_193;
import com.google.android.gms.internal.class_196;
import com.google.android.gms.internal.class_197;
import com.google.android.gms.internal.class_201;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_373;

// $FF: renamed from: com.google.android.gms.internal.bq
public final class class_198 implements class_193.class_804 {
   // $FF: renamed from: kz com.google.android.gms.internal.bu
   private final class_13 field_630;
   // $FF: renamed from: lf com.google.android.gms.internal.aj
   private final class_182 field_631;
   // $FF: renamed from: lq java.lang.Object
   private final Object field_632 = new Object();
   private final Context mContext;
   // $FF: renamed from: nA java.lang.String
   private final String field_633;
   // $FF: renamed from: nB long
   private final long field_634;
   // $FF: renamed from: nC com.google.android.gms.internal.bm
   private final class_201 field_635;
   // $FF: renamed from: nD com.google.android.gms.internal.am
   private final class_172 field_636;
   // $FF: renamed from: nE com.google.android.gms.internal.ew
   private final class_373 field_637;
   // $FF: renamed from: nF com.google.android.gms.internal.bv
   private class_11 field_638;
   // $FF: renamed from: nG int
   private int field_639 = -2;

   public class_198(Context var1, String var2, class_13 var3, class_196 var4, class_201 var5, class_182 var6, class_172 var7, class_373 var8) {
      this.mContext = var1;
      if("com.google.ads.mediation.customevent.CustomEventAdapter".equals(var2)) {
         this.field_633 = this.method_1324(var5);
      } else {
         this.field_633 = var2;
      }

      this.field_630 = var3;
      long var9;
      if(var4.field_619 != -1L) {
         var9 = var4.field_619;
      } else {
         var9 = 10000L;
      }

      this.field_634 = var9;
      this.field_635 = var5;
      this.field_631 = var6;
      this.field_636 = var7;
      this.field_637 = var8;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.bq, com.google.android.gms.internal.bv) com.google.android.gms.internal.bv
   // $FF: synthetic method
   static class_11 method_1317(class_198 var0, class_11 var1) {
      var0.field_638 = var1;
      return var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.bq) java.lang.Object
   // $FF: synthetic method
   static Object method_1318(class_198 var0) {
      return var0.field_632;
   }

   // $FF: renamed from: a (long, long, long, long) void
   private void method_1319(long var1, long var3, long var5, long var7) {
      while(this.field_639 == -2) {
         this.method_1325(var1, var3, var5, var7);
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.bp) void
   private void method_1320(class_197 var1) {
      try {
         if(this.field_637.field_1609 < 4100000) {
            if(this.field_636.field_570) {
               this.field_638.method_20(class_741.method_4178(this.mContext), this.field_631, this.field_635.field_652, var1);
            } else {
               this.field_638.method_22(class_741.method_4178(this.mContext), this.field_636, this.field_631, this.field_635.field_652, var1);
            }
         } else if(this.field_636.field_570) {
            this.field_638.method_21(class_741.method_4178(this.mContext), this.field_631, this.field_635.field_652, this.field_635.field_646, var1);
         } else {
            this.field_638.method_23(class_741.method_4178(this.mContext), this.field_636, this.field_631, this.field_635.field_652, this.field_635.field_646, var1);
         }
      } catch (RemoteException var3) {
         class_370.method_2361("Could not request ad from mediation adapter.", var3);
         this.method_671(5);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.bq, com.google.android.gms.internal.bp) void
   // $FF: synthetic method
   static void method_1321(class_198 var0, class_197 var1) {
      var0.method_1320(var1);
   }

   // $FF: renamed from: aK () com.google.android.gms.internal.bv
   private class_11 method_1322() {
      class_370.method_2356("Instantiating mediation adapter: " + this.field_633);

      try {
         class_11 var2 = this.field_630.method_24(this.field_633);
         return var2;
      } catch (RemoteException var3) {
         class_370.method_2359("Could not instantiate mediation adapter: " + this.field_633, var3);
         return null;
      }
   }

   // $FF: renamed from: b (com.google.android.gms.internal.bq) int
   // $FF: synthetic method
   static int method_1323(class_198 var0) {
      return var0.field_639;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.bm) java.lang.String
   private String method_1324(class_201 var1) {
      try {
         if(!TextUtils.isEmpty(var1.field_650) && CustomEvent.class.isAssignableFrom(Class.forName(var1.field_650, false, bq.class.getClassLoader()))) {
            return "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
         }
      } catch (ClassNotFoundException var3) {
         class_370.method_2358("Could not create custom event adapter.");
      }

      return "com.google.ads.mediation.customevent.CustomEventAdapter";
   }

   // $FF: renamed from: b (long, long, long, long) void
   private void method_1325(long var1, long var3, long var5, long var7) {
      long var9 = SystemClock.elapsedRealtime();
      long var11 = var3 - (var9 - var1);
      long var13 = var7 - (var9 - var5);
      if(var11 > 0L && var13 > 0L) {
         try {
            this.field_632.wait(Math.min(var11, var13));
         } catch (InterruptedException var16) {
            this.field_639 = -1;
         }
      } else {
         class_370.method_2356("Timed out waiting for adapter.");
         this.field_639 = 3;
      }
   }

   // $FF: renamed from: c (com.google.android.gms.internal.bq) com.google.android.gms.internal.bv
   // $FF: synthetic method
   static class_11 method_1326(class_198 var0) {
      return var0.method_1322();
   }

   // $FF: renamed from: d (com.google.android.gms.internal.bq) com.google.android.gms.internal.bv
   // $FF: synthetic method
   static class_11 method_1327(class_198 var0) {
      return var0.field_638;
   }

   // $FF: renamed from: b (long, long) com.google.android.gms.internal.br
   public class_193 method_1328(long param1, long param3) {
      // $FF: Couldn't be decompiled
   }

   public void cancel() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: g (int) void
   public void method_671(int param1) {
      // $FF: Couldn't be decompiled
   }
}
