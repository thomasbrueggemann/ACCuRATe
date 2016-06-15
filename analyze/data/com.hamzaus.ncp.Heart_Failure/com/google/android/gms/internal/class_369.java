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
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_356;
import com.google.android.gms.internal.class_363;
import com.google.android.gms.internal.class_365;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_373;
import com.google.android.gms.internal.class_396;
import com.google.android.gms.internal.class_397;
import com.google.android.gms.internal.class_422;
import com.google.android.gms.internal.class_457;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.ey
public class class_369 extends WebView implements DownloadListener {
   // $FF: renamed from: lA android.view.WindowManager
   private final WindowManager field_1595;
   // $FF: renamed from: lq java.lang.Object
   private final Object field_1596 = new Object();
   // $FF: renamed from: nD com.google.android.gms.internal.am
   private class_172 field_1597;
   // $FF: renamed from: nE com.google.android.gms.internal.ew
   private final class_373 field_1598;
   // $FF: renamed from: py com.google.android.gms.internal.l
   private final class_457 field_1599;
   // $FF: renamed from: sA boolean
   private boolean field_1600;
   // $FF: renamed from: sB boolean
   private boolean field_1601;
   // $FF: renamed from: sC boolean
   private boolean field_1602;
   // $FF: renamed from: sx com.google.android.gms.internal.ez
   private final class_367 field_1603;
   // $FF: renamed from: sy com.google.android.gms.internal.ey$a
   private final class_369.class_1263 field_1604;
   // $FF: renamed from: sz com.google.android.gms.internal.cg
   private class_422 field_1605;

   private class_369(class_369.class_1263 var1, class_172 var2, boolean var3, boolean var4, class_457 var5, class_373 var6) {
      super(var1);
      this.field_1604 = var1;
      this.field_1597 = var2;
      this.field_1600 = var3;
      this.field_1599 = var5;
      this.field_1598 = var6;
      this.field_1595 = (WindowManager)this.getContext().getSystemService("window");
      this.setBackgroundColor(0);
      WebSettings var7 = this.getSettings();
      var7.setJavaScriptEnabled(true);
      var7.setSavePassword(false);
      var7.setSupportMultipleWindows(true);
      var7.setJavaScriptCanOpenWindowsAutomatically(true);
      class_365.method_2292(var1, var6.field_1607, var7);
      if(VERSION.SDK_INT >= 17) {
         class_363.method_2285(this.getContext(), var7);
      } else if(VERSION.SDK_INT >= 11) {
         class_356.method_2250(this.getContext(), var7);
      }

      this.setDownloadListener(this);
      if(VERSION.SDK_INT >= 11) {
         this.field_1603 = new class_368(this, var4);
      } else {
         this.field_1603 = new class_367(this, var4);
      }

      this.setWebViewClient(this.field_1603);
      if(VERSION.SDK_INT >= 14) {
         this.setWebChromeClient(new class_397(this));
      } else if(VERSION.SDK_INT >= 11) {
         this.setWebChromeClient(new class_396(this));
      }

      this.method_2334();
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.am, boolean, boolean, com.google.android.gms.internal.l, com.google.android.gms.internal.ew) com.google.android.gms.internal.ey
   public static class_369 method_2333(Context var0, class_172 var1, boolean var2, boolean var3, class_457 var4, class_373 var5) {
      return new class_369(new class_369.class_1263(var0), var1, var2, var3, var4, var5);
   }

   // $FF: renamed from: cb () void
   private void method_2334() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cc () void
   private void method_2335() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cd () void
   private void method_2336() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: E (java.lang.String) void
   protected void method_2337(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: Q () com.google.android.gms.internal.am
   public class_172 method_2338() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.am) void
   public void method_2339(Context param1, class_172 param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.am) void
   public void method_2340(class_172 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.cg) void
   public void method_2341(class_422 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.String, java.util.Map) void
   public void method_2342(String var1, Map<String, ?> var2) {
      JSONObject var4;
      try {
         var4 = class_365.method_2314(var2);
      } catch (JSONException var5) {
         class_370.method_2358("Could not convert parameters to JSON.");
         return;
      }

      this.method_2344(var1, var4);
   }

   // $FF: renamed from: a (java.lang.String, org.json.JSONObject) void
   public void method_2343(String var1, JSONObject var2) {
      if(var2 == null) {
         var2 = new JSONObject();
      }

      String var3 = var2.toString();
      StringBuilder var4 = new StringBuilder();
      var4.append("javascript:" + var1 + "(");
      var4.append(var3);
      var4.append(");");
      this.method_2337(var4.toString());
   }

   // $FF: renamed from: b (java.lang.String, org.json.JSONObject) void
   public void method_2344(String var1, JSONObject var2) {
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
      class_370.method_2357("Dispatching AFMA event: " + var4);
      this.method_2337(var4.toString());
   }

   // $FF: renamed from: bS () void
   public void method_2345() {
      if(this.method_2349().method_2330()) {
         DisplayMetrics var1 = new DisplayMetrics();
         Display var2 = this.field_1595.getDefaultDisplay();
         var2.getMetrics(var1);
         int var3 = class_365.method_2312(this.getContext());
         float var4 = 160.0F / (float)var1.densityDpi;
         int var5 = (int)(var4 * (float)var1.widthPixels);
         int var6 = (int)(var4 * (float)(var1.heightPixels - var3));

         try {
            this.method_2344("onScreenInfoChanged", (new JSONObject()).put("width", var5).put("height", var6).put("density", (double)var1.density).put("rotation", var2.getRotation()));
         } catch (JSONException var8) {
            class_370.method_2360("Error occured while obtaining screen information.", var8);
         }
      }
   }

   // $FF: renamed from: bT () void
   public void method_2346() {
      HashMap var1 = new HashMap(1);
      var1.put("version", this.field_1598.field_1607);
      this.method_2342("onhide", var1);
   }

   // $FF: renamed from: bU () void
   public void method_2347() {
      HashMap var1 = new HashMap(1);
      var1.put("version", this.field_1598.field_1607);
      this.method_2342("onshow", var1);
   }

   // $FF: renamed from: bV () com.google.android.gms.internal.cg
   public class_422 method_2348() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bW () com.google.android.gms.internal.ez
   public class_367 method_2349() {
      return this.field_1603;
   }

   // $FF: renamed from: bX () com.google.android.gms.internal.l
   public class_457 method_2350() {
      return this.field_1599;
   }

   // $FF: renamed from: bY () com.google.android.gms.internal.ew
   public class_373 method_2351() {
      return this.field_1598;
   }

   // $FF: renamed from: bZ () boolean
   public boolean method_2352() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ca () android.content.Context
   public Context method_2353() {
      return this.field_1604.method_4478();
   }

   public void destroy() {
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
         class_370.method_2363("Couldn\'t find an Activity to view url/mimetype: " + var1 + " / " + var4);
      }
   }

   protected void onMeasure(int param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if(this.field_1599 != null) {
         this.field_1599.method_2830(var1);
      }

      return super.onTouchEvent(var1);
   }

   // $FF: renamed from: q (boolean) void
   public void method_2354(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public void setContext(Context var1) {
      this.field_1604.setBaseContext(var1);
   }

   private static class class_1263 extends MutableContextWrapper {
      // $FF: renamed from: lx android.content.Context
      private Context field_4232;
      // $FF: renamed from: sD android.app.Activity
      private Activity field_4233;

      public class_1263(Context var1) {
         super(var1);
         this.setBaseContext(var1);
      }

      // $FF: renamed from: ca () android.content.Context
      public Context method_4478() {
         return this.field_4233;
      }

      public void setBaseContext(Context var1) {
         this.field_4232 = var1.getApplicationContext();
         Activity var2;
         if(var1 instanceof Activity) {
            var2 = (Activity)var1;
         } else {
            var2 = null;
         }

         this.field_4233 = var2;
         super.setBaseContext(this.field_4232);
      }

      public void startActivity(Intent var1) {
         if(this.field_4233 != null) {
            this.field_4233.startActivity(var1);
         } else {
            var1.setFlags(268435456);
            this.field_4232.startActivity(var1);
         }
      }
   }
}
