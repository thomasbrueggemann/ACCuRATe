package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.go
@ey
public final class class_359 {
   // $FF: renamed from: a (android.content.Context, android.webkit.WebSettings) void
   public static void method_2462(Context var0, WebSettings var1) {
      class_379.method_2589(var0, var1);
      var1.setMediaPlaybackRequiresUserGesture(false);
   }

   public static String getDefaultUserAgent(Context var0) {
      return WebSettings.getDefaultUserAgent(var0);
   }
}
