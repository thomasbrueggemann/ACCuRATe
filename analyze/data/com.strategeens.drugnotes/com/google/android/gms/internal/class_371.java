package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_354;
import com.google.android.gms.internal.class_355;
import com.google.android.gms.internal.class_356;
import com.google.android.gms.internal.class_357;
import com.google.android.gms.internal.class_359;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_464;
import com.google.android.gms.internal.class_557;
import com.google.android.gms.internal.ey;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.gu
@ey
public class class_371 extends WebView implements DownloadListener {
   // $FF: renamed from: mH java.lang.Object
   private final Object field_1125 = new Object();
   // $FF: renamed from: mR android.view.WindowManager
   private final WindowManager field_1126;
   // $FF: renamed from: qI com.google.android.gms.internal.ay
   private class_237 field_1127;
   // $FF: renamed from: qJ com.google.android.gms.internal.gs
   private final class_369 field_1128;
   // $FF: renamed from: tl com.google.android.gms.internal.k
   private final class_557 field_1129;
   // $FF: renamed from: wW com.google.android.gms.internal.gv
   private final class_356 field_1130;
   // $FF: renamed from: wX com.google.android.gms.internal.gu$a
   private final class_371.class_1612 field_1131;
   // $FF: renamed from: wY com.google.android.gms.internal.dp
   private class_464 field_1132;
   // $FF: renamed from: wZ boolean
   private boolean field_1133;
   // $FF: renamed from: xa boolean
   private boolean field_1134;
   // $FF: renamed from: xb boolean
   private boolean field_1135;
   // $FF: renamed from: xc boolean
   private boolean field_1136;

   protected class_371(class_371.class_1612 var1, class_237 var2, boolean var3, boolean var4, class_557 var5, class_369 var6) {
      super(var1);
      this.field_1131 = var1;
      this.field_1127 = var2;
      this.field_1133 = var3;
      this.field_1129 = var5;
      this.field_1128 = var6;
      this.field_1126 = (WindowManager)this.getContext().getSystemService("window");
      this.setBackgroundColor(0);
      WebSettings var7 = this.getSettings();
      var7.setJavaScriptEnabled(true);
      var7.setSavePassword(false);
      var7.setSupportMultipleWindows(true);
      var7.setJavaScriptCanOpenWindowsAutomatically(true);
      class_375.method_2554(var1, var6.field_1121, var7);
      if(VERSION.SDK_INT >= 17) {
         class_359.method_2462(this.getContext(), var7);
      } else if(VERSION.SDK_INT >= 11) {
         class_379.method_2589(this.getContext(), var7);
      }

      this.setDownloadListener(this);
      if(VERSION.SDK_INT >= 11) {
         this.field_1130 = new class_357(this, var4);
      } else {
         this.field_1130 = new class_356(this, var4);
      }

      this.setWebViewClient(this.field_1130);
      if(VERSION.SDK_INT >= 14) {
         this.setWebChromeClient(new class_355(this));
      } else if(VERSION.SDK_INT >= 11) {
         this.setWebChromeClient(new class_354(this));
      }

      this.method_2516();
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.ay, boolean, boolean, com.google.android.gms.internal.k, com.google.android.gms.internal.gs) com.google.android.gms.internal.gu
   public static class_371 method_2515(Context var0, class_237 var1, boolean var2, boolean var3, class_557 var4, class_369 var5) {
      return new class_371(new class_371.class_1612(var0), var1, var2, var3, var4, var5);
   }

   // $FF: renamed from: dJ () void
   private void method_2516() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dK () void
   private void method_2517() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dL () void
   private void method_2518() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: X (java.lang.String) void
   protected void method_2519(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.ay) void
   public void method_2520(Context param1, class_237 param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ay) void
   public void method_2521(class_237 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.dp) void
   public void method_2522(class_464 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.String, java.util.Map) void
   public void method_2523(String var1, Map<String, ?> var2) {
      JSONObject var4;
      try {
         var4 = class_375.method_2580(var2);
      } catch (JSONException var5) {
         class_368.method_2506("Could not convert parameters to JSON.");
         return;
      }

      this.method_2526(var1, var4);
   }

   // $FF: renamed from: a (java.lang.String, org.json.JSONObject) void
   public void method_2524(String var1, JSONObject var2) {
      if(var2 == null) {
         var2 = new JSONObject();
      }

      String var3 = var2.toString();
      StringBuilder var4 = new StringBuilder();
      var4.append("javascript:" + var1 + "(");
      var4.append(var3);
      var4.append(");");
      this.method_2519(var4.toString());
   }

   // $FF: renamed from: ac () com.google.android.gms.internal.ay
   public class_237 method_2525() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (java.lang.String, org.json.JSONObject) void
   public void method_2526(String var1, JSONObject var2) {
      if(var2 == null) {
         var2 = new JSONObject();
      }

      String var3 = var2.toString();
      StringBuilder var4 = new StringBuilder();
      var4.append("javascript:AFMA_ReceiveMessage(\'");
      var4.append(var1);
      var4.append("\'");
      var4.append(",");
      var4.append(var3);
      var4.append(");");
      class_368.method_2505("Dispatching AFMA event: " + var4);
      this.method_2519(var4.toString());
   }

   // $FF: renamed from: cb () void
   public void method_2527() {
      if(this.method_2531().method_2457()) {
         DisplayMetrics var1 = new DisplayMetrics();
         Display var2 = this.field_1126.getDefaultDisplay();
         var2.getMetrics(var1);
         int var3 = class_375.method_2579(this.getContext());
         float var4 = 160.0F / (float)var1.densityDpi;
         int var5 = Math.round(var4 * (float)var1.widthPixels);
         int var6 = Math.round(var4 * (float)(var1.heightPixels - var3));

         try {
            this.method_2526("onScreenInfoChanged", (new JSONObject()).put("width", var5).put("height", var6).put("density", (double)var1.density).put("rotation", var2.getRotation()));
         } catch (JSONException var8) {
            class_368.method_2508("Error occured while obtaining screen information.", var8);
         }
      }
   }

   // $FF: renamed from: ci () void
   public void method_2528() {
      HashMap var1 = new HashMap(1);
      var1.put("version", this.field_1128.field_1121);
      this.method_2523("onshow", var1);
   }

   // $FF: renamed from: cj () void
   public void method_2529() {
      HashMap var1 = new HashMap(1);
      var1.put("version", this.field_1128.field_1121);
      this.method_2523("onhide", var1);
   }

   // $FF: renamed from: dC () com.google.android.gms.internal.dp
   public class_464 method_2530() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dD () com.google.android.gms.internal.gv
   public class_356 method_2531() {
      return this.field_1130;
   }

   // $FF: renamed from: dE () boolean
   public boolean method_2532() {
      return this.field_1136;
   }

   // $FF: renamed from: dF () com.google.android.gms.internal.k
   public class_557 method_2533() {
      return this.field_1129;
   }

   // $FF: renamed from: dG () com.google.android.gms.internal.gs
   public class_369 method_2534() {
      return this.field_1128;
   }

   // $FF: renamed from: dH () boolean
   public boolean method_2535() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dI () android.content.Context
   public Context method_2536() {
      return this.field_1131.method_4814();
   }

   public void destroy() {
      // $FF: Couldn't be decompiled
   }

   public void evaluateJavascript(String param1, ValueCallback<String> param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean isDestroyed() {
      // $FF: Couldn't be decompiled
   }

   public void onDownloadStart(String var1, String var2, String var3, String var4, long var5) {
      try {
         Intent var7 = new Intent("android.intent.action.VIEW");
         var7.setDataAndType(Uri.parse(var1), var4);
         this.getContext().startActivity(var7);
      } catch (ActivityNotFoundException var9) {
         class_368.method_2502("Couldn\'t find an Activity to view url/mimetype: " + var1 + " / " + var4);
      }
   }

   protected void onMeasure(int param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if(this.field_1129 != null) {
         this.field_1129.method_3394(var1);
      }

      return super.onTouchEvent(var1);
   }

   // $FF: renamed from: q (boolean) void
   public void method_2537(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public void setContext(Context var1) {
      this.field_1131.setBaseContext(var1);
   }

   // $FF: renamed from: z (boolean) void
   public void method_2538(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   @ey
   protected static class class_1612 extends MutableContextWrapper {
      // $FF: renamed from: mO android.content.Context
      private Context field_3610;
      // $FF: renamed from: xd android.app.Activity
      private Activity field_3611;

      public class_1612(Context var1) {
         super(var1);
         this.setBaseContext(var1);
      }

      // $FF: renamed from: dI () android.content.Context
      public Context method_4814() {
         return this.field_3611;
      }

      public void setBaseContext(Context var1) {
         this.field_3610 = var1.getApplicationContext();
         Activity var2;
         if(var1 instanceof Activity) {
            var2 = (Activity)var1;
         } else {
            var2 = null;
         }

         this.field_3611 = var2;
         super.setBaseContext(this.field_3610);
      }

      public void startActivity(Intent var1) {
         if(this.field_3611 != null) {
            this.field_3611.startActivity(var1);
         } else {
            var1.setFlags(268435456);
            this.field_3610.startActivity(var1);
         }
      }
   }
}
