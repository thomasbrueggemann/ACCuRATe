package com.google.android.gms.internal;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.cd;
import com.google.android.gms.internal.class_247;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_45;
import com.google.android.gms.internal.class_452;
import com.google.android.gms.internal.class_453;
import com.google.android.gms.internal.class_454;
import com.google.android.gms.internal.class_455;
import com.google.android.gms.internal.class_456;
import com.google.android.gms.internal.class_458;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_461;
import com.google.android.gms.internal.class_462;
import com.google.android.gms.internal.class_464;
import com.google.android.gms.internal.class_47;
import com.google.android.gms.internal.class_48;
import com.google.android.gms.internal.class_49;
import com.google.android.gms.internal.class_50;
import com.google.android.gms.internal.class_549;
import com.google.android.gms.internal.class_67;
import com.google.android.gms.internal.ey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.gv
@ey
public class class_356 extends WebViewClient {
   // $FF: renamed from: mH java.lang.Object
   private final Object field_1060;
   // $FF: renamed from: mo com.google.android.gms.internal.gu
   protected final class_371 field_1061;
   // $FF: renamed from: pP com.google.android.gms.internal.cb
   private class_45 field_1062;
   // $FF: renamed from: qa com.google.android.gms.internal.cg
   private class_48 field_1063;
   // $FF: renamed from: qc com.google.android.gms.internal.ce
   private class_47 field_1064;
   // $FF: renamed from: qd com.google.android.gms.internal.v
   private class_549 field_1065;
   // $FF: renamed from: tu com.google.android.gms.internal.gv$a
   private class_356.class_1535 field_1066;
   // $FF: renamed from: xe java.util.HashMap
   private final HashMap<String, cd> field_1067;
   // $FF: renamed from: xf com.google.android.gms.internal.t
   private class_67 field_1068;
   // $FF: renamed from: xg com.google.android.gms.internal.ds
   private class_49 field_1069;
   // $FF: renamed from: xh boolean
   private boolean field_1070;
   // $FF: renamed from: xi boolean
   private boolean field_1071;
   // $FF: renamed from: xj com.google.android.gms.internal.dv
   private class_50 field_1072;
   // $FF: renamed from: xk com.google.android.gms.internal.dl
   private final class_461 field_1073;

   public class_356(class_371 var1, boolean var2) {
      this(var1, var2, new class_461(var1, var1.getContext(), new class_247(var1.getContext())));
   }

   class_356(class_371 var1, boolean var2, class_461 var3) {
      this.field_1067 = new HashMap();
      this.field_1060 = new Object();
      this.field_1070 = false;
      this.field_1061 = var1;
      this.field_1071 = var2;
      this.field_1073 = var3;
   }

   // $FF: renamed from: d (android.net.Uri) boolean
   private static boolean method_2443(Uri var0) {
      String var1 = var0.getScheme();
      return "http".equalsIgnoreCase(var1) || "https".equalsIgnoreCase(var1);
   }

   // $FF: renamed from: e (android.net.Uri) void
   private void method_2444(Uri var1) {
      String var2 = var1.getPath();
      class_46 var3 = (class_46)this.field_1067.get(var2);
      if(var3 == null) {
         class_368.method_2505("No GMSG handler found for GMSG: " + var1);
      } else {
         Map var4 = class_375.method_2567(var1);
         if(class_368.method_2511(2)) {
            class_368.method_2505("Received GMSG: " + var2);
            Iterator var5 = var4.keySet().iterator();

            while(var5.hasNext()) {
               String var6 = (String)var5.next();
               class_368.method_2505("  " + var6 + ": " + (String)var4.get(var6));
            }
         }

         var3.method_213(this.field_1061, var4);
      }
   }

   // $FF: renamed from: A (boolean) void
   public final void method_2445(boolean var1) {
      this.field_1070 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.do) void
   public final void method_2446(class_458 var1) {
      boolean var2 = this.field_1061.method_2535();
      class_67 var3;
      if(var2 && !this.field_1061.method_2525().field_447) {
         var3 = null;
      } else {
         var3 = this.field_1068;
      }

      class_49 var4 = null;
      if(!var2) {
         var4 = this.field_1069;
      }

      this.method_2447(new class_462(var1, var3, var4, this.field_1072, this.field_1061.method_2534()));
   }

   // $FF: renamed from: a (com.google.android.gms.internal.dr) void
   protected void method_2447(class_462 var1) {
      class_464.method_2949(this.field_1061.getContext(), var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gv$a) void
   public final void method_2448(class_356.class_1535 var1) {
      this.field_1066 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.t, com.google.android.gms.internal.ds, com.google.android.gms.internal.cb, com.google.android.gms.internal.dv, boolean, com.google.android.gms.internal.ce, com.google.android.gms.internal.cg, com.google.android.gms.internal.v) void
   public void method_2449(class_67 var1, class_49 var2, class_45 var3, class_50 var4, boolean var5, class_47 var6, class_48 var7, class_549 var8) {
      this.method_2450(var1, var2, var3, var4, var5, var6, var8);
      this.method_2451("/setInterstitialProperties", new class_454(var7));
      this.field_1063 = var7;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.t, com.google.android.gms.internal.ds, com.google.android.gms.internal.cb, com.google.android.gms.internal.dv, boolean, com.google.android.gms.internal.ce, com.google.android.gms.internal.v) void
   public void method_2450(class_67 var1, class_49 var2, class_45 var3, class_50 var4, boolean var5, class_47 var6, class_549 var7) {
      if(var7 == null) {
         var7 = new class_549(false);
      }

      this.method_2451("/appEvent", new class_452(var3));
      this.method_2451("/canOpenURLs", class_453.field_1525);
      this.method_2451("/canOpenIntents", class_453.field_1526);
      this.method_2451("/click", class_453.field_1527);
      this.method_2451("/close", class_453.field_1528);
      this.method_2451("/customClose", class_453.field_1529);
      this.method_2451("/httpTrack", class_453.field_1530);
      this.method_2451("/log", class_453.field_1531);
      this.method_2451("/open", new class_456(var6, var7));
      this.method_2451("/touch", class_453.field_1532);
      this.method_2451("/video", class_453.field_1533);
      this.method_2451("/mraid", new class_455());
      this.field_1068 = var1;
      this.field_1069 = var2;
      this.field_1062 = var3;
      this.field_1064 = var6;
      this.field_1072 = var4;
      this.field_1065 = var7;
      this.method_2445(var5);
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.cd) void
   public final void method_2451(String var1, class_46 var2) {
      this.field_1067.put(var1, var2);
   }

   // $FF: renamed from: a (boolean, int) void
   public final void method_2452(boolean var1, int var2) {
      class_67 var3;
      if(this.field_1061.method_2535() && !this.field_1061.method_2525().field_447) {
         var3 = null;
      } else {
         var3 = this.field_1068;
      }

      this.method_2447(new class_462(var3, this.field_1069, this.field_1072, this.field_1061, var1, var2, this.field_1061.method_2534()));
   }

   // $FF: renamed from: a (boolean, int, java.lang.String) void
   public final void method_2453(boolean var1, int var2, String var3) {
      boolean var4 = this.field_1061.method_2535();
      class_67 var5;
      if(var4 && !this.field_1061.method_2525().field_447) {
         var5 = null;
      } else {
         var5 = this.field_1068;
      }

      class_49 var6 = null;
      if(!var4) {
         var6 = this.field_1069;
      }

      this.method_2447(new class_462(var5, var6, this.field_1062, this.field_1072, this.field_1061, var1, var2, var3, this.field_1061.method_2534(), this.field_1064));
   }

   // $FF: renamed from: a (boolean, int, java.lang.String, java.lang.String) void
   public final void method_2454(boolean var1, int var2, String var3, String var4) {
      boolean var5 = this.field_1061.method_2535();
      class_67 var6;
      if(var5 && !this.field_1061.method_2525().field_447) {
         var6 = null;
      } else {
         var6 = this.field_1068;
      }

      class_49 var7;
      if(var5) {
         var7 = null;
      } else {
         var7 = this.field_1069;
      }

      this.method_2447(new class_462(var6, var7, this.field_1062, this.field_1072, this.field_1061, var1, var2, var3, var4, this.field_1061.method_2534(), this.field_1064));
   }

   // $FF: renamed from: cg () void
   public final void method_2455() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dM () com.google.android.gms.internal.v
   public class_549 method_2456() {
      return this.field_1065;
   }

   // $FF: renamed from: dN () boolean
   public boolean method_2457() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dO () void
   public void method_2458() {
      if(this.method_2457()) {
         this.field_1073.method_2931();
      }

   }

   public final void onLoadResource(WebView var1, String var2) {
      class_368.method_2505("Loading resource: " + var2);
      Uri var3 = Uri.parse(var2);
      if("gmsg".equalsIgnoreCase(var3.getScheme()) && "mobileads.google.com".equalsIgnoreCase(var3.getHost())) {
         this.method_2444(var3);
      }

   }

   public final void onPageFinished(WebView var1, String var2) {
      if(this.field_1066 != null) {
         this.field_1066.method_729(this.field_1061);
         this.field_1066 = null;
      }

   }

   public final void reset() {
      // $FF: Couldn't be decompiled
   }

   public final boolean shouldOverrideUrlLoading(WebView param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public interface class_1535 {
      // $FF: renamed from: a (com.google.android.gms.internal.gu) void
      void method_729(class_371 var1);
   }
}
