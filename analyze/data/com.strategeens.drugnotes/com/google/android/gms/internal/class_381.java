package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.class_141;
import com.google.android.gms.internal.class_225;
import com.google.android.gms.internal.class_226;
import com.google.android.gms.internal.class_228;
import com.google.android.gms.internal.class_24;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_380;
import com.google.android.gms.internal.class_382;
import com.google.android.gms.internal.class_409;
import com.google.android.gms.internal.class_431;
import com.google.android.gms.internal.class_442;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fz;
import com.google.android.gms.internal.gd;
import java.lang.Thread.UncaughtExceptionHandler;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

// $FF: renamed from: com.google.android.gms.internal.ga
@ey
public class class_381 implements class_442.class_1520 {
   // $FF: renamed from: vX com.google.android.gms.internal.ga
   private static final class_381 field_1165 = new class_381();
   // $FF: renamed from: vY java.lang.String
   public static final String field_1166;
   private Context mContext;
   // $FF: renamed from: mH java.lang.Object
   private final Object field_1167 = new Object();
   // $FF: renamed from: nE com.google.android.gms.internal.am
   private class_225 field_1168;
   // $FF: renamed from: nF com.google.android.gms.internal.al
   private class_228 field_1169;
   // $FF: renamed from: nG com.google.android.gms.internal.ex
   private class_409 field_1170;
   // $FF: renamed from: qJ com.google.android.gms.internal.gs
   private class_369 field_1171;
   // $FF: renamed from: uV boolean
   private boolean field_1172;
   // $FF: renamed from: uW boolean
   private boolean field_1173;
   // $FF: renamed from: vZ java.lang.String
   public final String field_1174;
   // $FF: renamed from: wa com.google.android.gms.internal.gb
   private final class_380 field_1175;
   // $FF: renamed from: wb com.google.android.gms.internal.ld
   private class_141 field_1176;
   // $FF: renamed from: wc java.math.BigInteger
   private BigInteger field_1177;
   // $FF: renamed from: wd java.util.HashSet
   private final HashSet<fz> field_1178;
   // $FF: renamed from: we java.util.HashMap
   private final HashMap<String, gd> field_1179;
   // $FF: renamed from: wf boolean
   private boolean field_1180;
   // $FF: renamed from: wg boolean
   private boolean field_1181;
   // $FF: renamed from: wh com.google.android.gms.internal.an
   private class_226 field_1182;
   // $FF: renamed from: wi java.util.LinkedList
   private LinkedList<Thread> field_1183;
   // $FF: renamed from: wj boolean
   private boolean field_1184;
   // $FF: renamed from: wk android.os.Bundle
   private Bundle field_1185;
   // $FF: renamed from: wl java.lang.String
   private String field_1186;

   static {
      field_1166 = field_1165.field_1174;
   }

   private class_381() {
      this.field_1177 = BigInteger.ONE;
      this.field_1178 = new HashSet();
      this.field_1179 = new HashMap();
      this.field_1180 = false;
      this.field_1172 = true;
      this.field_1181 = false;
      this.field_1173 = true;
      this.field_1168 = null;
      this.field_1182 = null;
      this.field_1169 = null;
      this.field_1183 = new LinkedList();
      this.field_1184 = false;
      this.field_1185 = class_242.method_1613();
      this.field_1170 = null;
      this.field_1174 = class_375.method_2574();
      this.field_1175 = new class_380(this.field_1174);
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.gc, java.lang.String) android.os.Bundle
   public static Bundle method_2601(Context var0, class_24 var1, String var2) {
      return field_1165.method_2617(var0, var1, var2);
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.gs) void
   public static void method_2602(Context var0, class_369 var1) {
      field_1165.method_2618(var0, var1);
   }

   // $FF: renamed from: a (android.content.Context, boolean) void
   public static void method_2603(Context var0, boolean var1) {
      field_1165.method_2619(var0, var1);
   }

   // $FF: renamed from: b (java.util.HashSet) void
   public static void method_2604(HashSet<fz> var0) {
      field_1165.method_2620(var0);
   }

   // $FF: renamed from: bN () android.os.Bundle
   public static Bundle method_2605() {
      return field_1165.method_2629();
   }

   // $FF: renamed from: c (int, java.lang.String) java.lang.String
   public static String method_2606(int var0, String var1) {
      return field_1165.method_2621(var0, var1);
   }

   // $FF: renamed from: dc () com.google.android.gms.internal.ga
   public static class_381 method_2607() {
      return field_1165;
   }

   // $FF: renamed from: df () java.lang.String
   public static String method_2608() {
      return field_1165.method_2624();
   }

   // $FF: renamed from: dh () com.google.android.gms.internal.gb
   public static class_380 method_2609() {
      return field_1165.method_2625();
   }

   // $FF: renamed from: dj () boolean
   public static boolean method_2610() {
      return field_1165.method_2626();
   }

   // $FF: renamed from: dl () boolean
   public static boolean method_2611() {
      return field_1165.method_2627();
   }

   // $FF: renamed from: dn () java.lang.String
   public static String method_2612() {
      return field_1165.method_2628();
   }

   // $FF: renamed from: e (java.lang.Throwable) void
   public static void method_2613(Throwable var0) {
      field_1165.method_2630(var0);
   }

   // $FF: renamed from: a (android.os.Bundle) void
   public void method_641(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.fz) void
   public void method_2614(class_431 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.gd) void
   public void method_2615(String param1, class_382 param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.Thread) void
   public void method_2616(Thread param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (android.content.Context, com.google.android.gms.internal.gc, java.lang.String) android.os.Bundle
   public Bundle method_2617(Context param1, class_24 param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (android.content.Context, com.google.android.gms.internal.gs) void
   public void method_2618(Context param1, class_369 param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (android.content.Context, boolean) void
   public void method_2619(Context param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (java.util.HashSet) void
   public void method_2620(HashSet<fz> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d (int, java.lang.String) java.lang.String
   public String method_2621(int var1, String var2) {
      Resources var3;
      if(this.field_1171.field_1124) {
         var3 = this.mContext.getResources();
      } else {
         var3 = GooglePlayServicesUtil.getRemoteResource(this.mContext);
      }

      return var3 == null?var2:var3.getString(var1);
   }

   // $FF: renamed from: dd () com.google.android.gms.internal.ld
   public class_141 method_2622() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: de () boolean
   public boolean method_2623() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dg () java.lang.String
   public String method_2624() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: di () com.google.android.gms.internal.gb
   public class_380 method_2625() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dk () boolean
   public boolean method_2626() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dm () boolean
   public boolean method_2627() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: do () java.lang.String
   public String method_2628() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dp () android.os.Bundle
   public Bundle method_2629() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: f (java.lang.Throwable) void
   public void method_2630(Throwable var1) {
      if(this.field_1181) {
         (new class_409(this.mContext, this.field_1171, (UncaughtExceptionHandler)null, (UncaughtExceptionHandler)null)).method_2722(var1);
      }

   }

   // $FF: renamed from: l (android.content.Context) com.google.android.gms.internal.an
   public class_226 method_2631(Context param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: x (boolean) void
   public void method_2632(boolean param1) {
      // $FF: Couldn't be decompiled
   }
}
