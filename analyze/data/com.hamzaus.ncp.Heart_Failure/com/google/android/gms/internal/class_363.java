package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;
import com.google.android.gms.internal.class_356;

// $FF: renamed from: com.google.android.gms.internal.es
public final class class_363 {
   // $FF: renamed from: a (android.content.Context, android.webkit.WebSettings) void
   public static void method_2285(Context var0, WebSettings var1) {
      class_356.method_2250(var0, var1);
      var1.setMediaPlaybackRequiresUserGesture(false);
   }

   public static String getDefaultUserAgent(Context var0) {
      return WebSettings.getDefaultUserAgent(var0);
   }
}
