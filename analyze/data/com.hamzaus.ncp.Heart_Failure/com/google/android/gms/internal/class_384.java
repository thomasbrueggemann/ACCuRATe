package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.internal.class_182;
import com.google.android.gms.internal.class_378;
import java.util.LinkedList;

// $FF: renamed from: com.google.android.gms.internal.eh
public class class_384 {
   // $FF: renamed from: lq java.lang.Object
   private final Object field_1729;
   // $FF: renamed from: qL boolean
   private boolean field_1730;
   // $FF: renamed from: rA com.google.android.gms.internal.ei
   private final class_378 field_1731;
   // $FF: renamed from: rB java.util.LinkedList
   private final LinkedList<class_384.class_1255> field_1732;
   // $FF: renamed from: rC java.lang.String
   private final String field_1733;
   // $FF: renamed from: rD java.lang.String
   private final String field_1734;
   // $FF: renamed from: rE long
   private long field_1735;
   // $FF: renamed from: rF long
   private long field_1736;
   // $FF: renamed from: rG long
   private long field_1737;
   // $FF: renamed from: rH long
   private long field_1738;
   // $FF: renamed from: rI long
   private long field_1739;
   // $FF: renamed from: rJ long
   private long field_1740;

   public class_384(class_378 var1, String var2, String var3) {
      this.field_1729 = new Object();
      this.field_1735 = -1L;
      this.field_1736 = -1L;
      this.field_1730 = false;
      this.field_1737 = -1L;
      this.field_1738 = 0L;
      this.field_1739 = -1L;
      this.field_1740 = -1L;
      this.field_1731 = var1;
      this.field_1733 = var2;
      this.field_1734 = var3;
      this.field_1732 = new LinkedList();
   }

   public class_384(String var1, String var2) {
      this(class_378.method_2407(), var1, var2);
   }

   // $FF: renamed from: bw () void
   public void method_2446() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bx () void
   public void method_2447() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: by () void
   public void method_2448() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: f (com.google.android.gms.internal.aj) void
   public void method_2449(class_182 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: j (long) void
   public void method_2450(long param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: k (long) void
   public void method_2451(long param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: n (boolean) void
   public void method_2452(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: o (boolean) void
   public void method_2453(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public Bundle toBundle() {
      // $FF: Couldn't be decompiled
   }

   private static final class class_1255 {
      // $FF: renamed from: rK long
      private long field_4005 = -1L;
      // $FF: renamed from: rL long
      private long field_4006 = -1L;

      // $FF: renamed from: bA () void
      public void method_4269() {
         this.field_4006 = SystemClock.elapsedRealtime();
      }

      // $FF: renamed from: bB () void
      public void method_4270() {
         this.field_4005 = SystemClock.elapsedRealtime();
      }

      // $FF: renamed from: bz () long
      public long method_4271() {
         return this.field_4006;
      }

      public Bundle toBundle() {
         Bundle var1 = new Bundle();
         var1.putLong("topen", this.field_4005);
         var1.putLong("tclose", this.field_4006);
         return var1;
      }
   }
}
