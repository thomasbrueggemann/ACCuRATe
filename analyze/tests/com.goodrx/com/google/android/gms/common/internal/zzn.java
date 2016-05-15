package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public class zzn {
   private static final Uri zzamj = Uri.parse("http://plus.google.com/");
   private static final Uri zzamk;

   static {
      zzamk = zzamj.buildUpon().appendPath("circles").appendPath("find").build();
   }

   public static Intent zzcJ(String var0) {
      Uri var1 = Uri.fromParts("package", var0, (String)null);
      Intent var2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      var2.setData(var1);
      return var2;
   }

   public static Intent zzqU() {
      Intent var0 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
      var0.setPackage("com.google.android.wearable.app");
      return var0;
   }

   private static Uri zzw(String var0, @Nullable String var1) {
      Builder var2 = Uri.parse("market://details").buildUpon().appendQueryParameter("id", var0);
      if(!TextUtils.isEmpty(var1)) {
         var2.appendQueryParameter("pcampaignid", var1);
      }

      return var2.build();
   }

   public static Intent zzx(String var0, @Nullable String var1) {
      Intent var2 = new Intent("android.intent.action.VIEW");
      var2.setData(zzw(var0, var1));
      var2.setPackage("com.android.vending");
      var2.addFlags(524288);
      return var2;
   }
}
