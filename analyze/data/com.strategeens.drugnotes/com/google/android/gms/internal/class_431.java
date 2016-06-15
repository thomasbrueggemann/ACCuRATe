package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.internal.class_218;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.ey;
import java.util.LinkedList;

// $FF: renamed from: com.google.android.gms.internal.fz
@ey
public class class_431 {
   // $FF: renamed from: mH java.lang.Object
   private final Object field_1374;
   // $FF: renamed from: uQ boolean
   private boolean field_1375;
   // $FF: renamed from: vL com.google.android.gms.internal.ga
   private final class_381 field_1376;
   // $FF: renamed from: vM java.util.LinkedList
   private final LinkedList<class_431.class_1525> field_1377;
   // $FF: renamed from: vN java.lang.String
   private final String field_1378;
   // $FF: renamed from: vO java.lang.String
   private final String field_1379;
   // $FF: renamed from: vP long
   private long field_1380;
   // $FF: renamed from: vQ long
   private long field_1381;
   // $FF: renamed from: vR long
   private long field_1382;
   // $FF: renamed from: vS long
   private long field_1383;
   // $FF: renamed from: vT long
   private long field_1384;
   // $FF: renamed from: vU long
   private long field_1385;

   public class_431(class_381 var1, String var2, String var3) {
      this.field_1374 = new Object();
      this.field_1380 = -1L;
      this.field_1381 = -1L;
      this.field_1375 = false;
      this.field_1382 = -1L;
      this.field_1383 = 0L;
      this.field_1384 = -1L;
      this.field_1385 = -1L;
      this.field_1376 = var1;
      this.field_1378 = var2;
      this.field_1379 = var3;
      this.field_1377 = new LinkedList();
   }

   public class_431(String var1, String var2) {
      this(class_381.method_2607(), var1, var2);
   }

   // $FF: renamed from: cW () void
   public void method_2848() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cX () void
   public void method_2849() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cY () void
   public void method_2850() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: e (com.google.android.gms.internal.av) void
   public void method_2851(class_218 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: j (long) void
   public void method_2852(long param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: k (long) void
   public void method_2853(long param1) {
      // $FF: Couldn't be decompiled
   }

   public Bundle toBundle() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: v (boolean) void
   public void method_2854(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: w (boolean) void
   public void method_2855(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   @ey
   private static final class class_1525 {
      // $FF: renamed from: vV long
      private long field_4360 = -1L;
      // $FF: renamed from: vW long
      private long field_4361 = -1L;

      // $FF: renamed from: cZ () long
      public long method_5694() {
         return this.field_4361;
      }

      // $FF: renamed from: da () void
      public void method_5695() {
         this.field_4361 = SystemClock.elapsedRealtime();
      }

      // $FF: renamed from: db () void
      public void method_5696() {
         this.field_4360 = SystemClock.elapsedRealtime();
      }

      public Bundle toBundle() {
         Bundle var1 = new Bundle();
         var1.putLong("topen", this.field_4360);
         var1.putLong("tclose", this.field_4361);
         return var1;
      }
   }
}
