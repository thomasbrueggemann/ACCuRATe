package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.class_34;
import com.google.android.gms.internal.class_365;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_380;
import com.google.android.gms.internal.class_384;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.el;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;

// $FF: renamed from: com.google.android.gms.internal.ei
public class class_378 {
   // $FF: renamed from: rM com.google.android.gms.internal.ei
   private static final class_378 field_1665 = new class_378();
   // $FF: renamed from: rN java.lang.String
   public static final String field_1666;
   // $FF: renamed from: lq java.lang.Object
   private final Object field_1667 = new Object();
   // $FF: renamed from: rO java.lang.String
   public final String field_1668;
   // $FF: renamed from: rP com.google.android.gms.internal.ej
   private final class_379 field_1669;
   // $FF: renamed from: rQ java.math.BigInteger
   private BigInteger field_1670;
   // $FF: renamed from: rR java.util.HashSet
   private final HashSet<eh> field_1671;
   // $FF: renamed from: rS java.util.HashMap
   private final HashMap<String, el> field_1672;
   // $FF: renamed from: rT boolean
   private boolean field_1673;

   static {
      field_1666 = field_1665.field_1668;
   }

   private class_378() {
      this.field_1670 = BigInteger.ONE;
      this.field_1671 = new HashSet();
      this.field_1672 = new HashMap();
      this.field_1673 = false;
      this.field_1668 = class_365.method_2306();
      this.field_1669 = new class_379(this.field_1668);
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.ek, java.lang.String) android.os.Bundle
   public static Bundle method_2405(Context var0, class_34 var1, String var2) {
      return field_1665.method_2413(var0, var1, var2);
   }

   // $FF: renamed from: b (java.util.HashSet) void
   public static void method_2406(HashSet<eh> var0) {
      field_1665.method_2417(var0);
   }

   // $FF: renamed from: bC () com.google.android.gms.internal.ei
   public static class_378 method_2407() {
      return field_1665;
   }

   // $FF: renamed from: bD () java.lang.String
   public static String method_2408() {
      return field_1665.method_2414();
   }

   // $FF: renamed from: bF () com.google.android.gms.internal.ej
   public static class_379 method_2409() {
      return field_1665.method_2415();
   }

   // $FF: renamed from: bH () boolean
   public static boolean method_2410() {
      return field_1665.method_2416();
   }

   // $FF: renamed from: a (com.google.android.gms.internal.eh) void
   public void method_2411(class_384 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.el) void
   public void method_2412(String param1, class_380 param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (android.content.Context, com.google.android.gms.internal.ek, java.lang.String) android.os.Bundle
   public Bundle method_2413(Context param1, class_34 param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bE () java.lang.String
   public String method_2414() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bG () com.google.android.gms.internal.ej
   public class_379 method_2415() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bI () boolean
   public boolean method_2416() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (java.util.HashSet) void
   public void method_2417(HashSet<eh> param1) {
      // $FF: Couldn't be decompiled
   }
}
