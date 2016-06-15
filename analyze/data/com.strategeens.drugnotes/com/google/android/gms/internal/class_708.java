package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.internal.lt
public class class_708 {
   // $FF: renamed from: TS java.util.List
   private static final List<TimeUnit> field_3288;

   static {
      TimeUnit[] var0 = new TimeUnit[]{TimeUnit.NANOSECONDS, TimeUnit.MICROSECONDS, TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS};
      field_3288 = Arrays.asList(var0);
   }

   // $FF: renamed from: a (long, java.util.concurrent.TimeUnit, java.util.concurrent.TimeUnit) long
   public static long method_4172(long var0, TimeUnit var2, TimeUnit var3) {
      return var2.convert(var3.convert(var0, var2), var3);
   }

   // $FF: renamed from: a (java.util.concurrent.TimeUnit) boolean
   public static boolean method_4173(TimeUnit var0) {
      return method_4174(var0, TimeUnit.MILLISECONDS);
   }

   // $FF: renamed from: a (java.util.concurrent.TimeUnit, java.util.concurrent.TimeUnit) boolean
   private static boolean method_4174(TimeUnit var0, TimeUnit var1) {
      return field_3288.indexOf(var0) < field_3288.indexOf(var1);
   }
}
