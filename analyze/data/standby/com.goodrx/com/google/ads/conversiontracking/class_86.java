package com.google.ads.conversiontracking;

import android.content.Intent;
import android.net.Uri;

// $FF: renamed from: com.google.ads.conversiontracking.o
public class class_86 {
   // $FF: renamed from: a android.net.Uri
   private static final Uri field_604 = Uri.parse("http://plus.google.com/");
   // $FF: renamed from: b android.net.Uri
   private static final Uri field_605;

   static {
      field_605 = field_604.buildUpon().appendPath("circles").appendPath("find").build();
   }

   // $FF: renamed from: a () android.content.Intent
   public static Intent method_562() {
      return new Intent("android.settings.DATE_SETTINGS");
   }

   // $FF: renamed from: a (java.lang.String) android.content.Intent
   public static Intent method_563(String var0) {
      Uri var1 = Uri.fromParts("package", var0, (String)null);
      Intent var2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      var2.setData(var1);
      return var2;
   }

   // $FF: renamed from: b (java.lang.String) android.content.Intent
   public static Intent method_564(String var0) {
      Intent var1 = new Intent("android.intent.action.VIEW");
      var1.setData(method_566(var0));
      var1.setPackage("com.android.vending");
      var1.addFlags(524288);
      return var1;
   }

   // $FF: renamed from: c (java.lang.String) android.content.Intent
   public static Intent method_565(String var0) {
      Uri var1 = Uri.parse("bazaar://search?q=pname:" + var0);
      Intent var2 = new Intent("android.intent.action.VIEW");
      var2.setData(var1);
      var2.setFlags(524288);
      return var2;
   }

   // $FF: renamed from: d (java.lang.String) android.net.Uri
   private static Uri method_566(String var0) {
      return Uri.parse("market://details").buildUpon().appendQueryParameter("id", var0).build();
   }
}
