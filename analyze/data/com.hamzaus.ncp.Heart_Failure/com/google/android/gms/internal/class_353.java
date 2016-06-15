package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;

// $FF: renamed from: com.google.android.gms.internal.hf
public class class_353 {
   // $FF: renamed from: GD android.net.Uri
   private static final Uri field_1527 = Uri.parse("http://plus.google.com/");
   // $FF: renamed from: GE android.net.Uri
   private static final Uri field_1528;

   static {
      field_1528 = field_1527.buildUpon().appendPath("circles").appendPath("find").build();
   }

   // $FF: renamed from: aB (java.lang.String) android.content.Intent
   public static Intent method_2236(String var0) {
      Uri var1 = Uri.fromParts("package", var0, (String)null);
      Intent var2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      var2.setData(var1);
      return var2;
   }

   // $FF: renamed from: aC (java.lang.String) android.net.Uri
   private static Uri method_2237(String var0) {
      return Uri.parse("market://details").buildUpon().appendQueryParameter("id", var0).build();
   }

   // $FF: renamed from: aD (java.lang.String) android.content.Intent
   public static Intent method_2238(String var0) {
      Intent var1 = new Intent("android.intent.action.VIEW");
      var1.setData(method_2237(var0));
      var1.setPackage("com.android.vending");
      var1.addFlags(524288);
      return var1;
   }

   // $FF: renamed from: fv () android.content.Intent
   public static Intent method_2239() {
      return new Intent("android.settings.DATE_SETTINGS");
   }
}
