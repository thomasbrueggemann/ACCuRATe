package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

// $FF: renamed from: com.google.android.gms.internal.er
public final class class_356 {
   // $FF: renamed from: a (android.content.Context, android.webkit.WebSettings) void
   public static void method_2250(Context var0, WebSettings var1) {
      var1.setAppCachePath(var0.getCacheDir().getAbsolutePath());
      var1.setAppCacheMaxSize(0L);
      var1.setAppCacheEnabled(true);
      var1.setDatabasePath(var0.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
      var1.setDatabaseEnabled(true);
      var1.setDomStorageEnabled(true);
      var1.setDisplayZoomControls(false);
      var1.setBuiltInZoomControls(true);
      var1.setSupportZoom(true);
   }

   // $FF: renamed from: a (android.view.Window) void
   public static void method_2251(Window var0) {
      var0.setFlags(16777216, 16777216);
   }

   // $FF: renamed from: a (android.webkit.WebView) void
   public static void method_2252(WebView var0) {
      var0.onPause();
   }

   // $FF: renamed from: b (android.webkit.WebView) void
   public static void method_2253(WebView var0) {
      var0.onResume();
   }

   // $FF: renamed from: d (android.view.View) void
   public static void method_2254(View var0) {
      var0.setLayerType(1, (Paint)null);
   }

   // $FF: renamed from: e (android.view.View) void
   public static void method_2255(View var0) {
      var0.setLayerType(0, (Paint)null);
   }
}
