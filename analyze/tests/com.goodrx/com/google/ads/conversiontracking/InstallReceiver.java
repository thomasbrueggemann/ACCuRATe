package com.google.ads.conversiontracking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.google.ads.conversiontracking.AdWordsConversionReporter;

public class InstallReceiver extends BroadcastReceiver {
   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getStringExtra("referrer");
      if("com.android.vending.INSTALL_REFERRER".equals(var2.getAction()) && var3 != null) {
         String var4 = String.valueOf(var3);
         String var5;
         if(var4.length() != 0) {
            var5 = "Received install referrer: ".concat(var4);
         } else {
            var5 = new String("Received install referrer: ");
         }

         Log.i("GoogleConversionReporter", var5);
         AdWordsConversionReporter.registerReferrer(var1, Uri.parse("http://hostname/").buildUpon().appendQueryParameter("referrer", var3).build());
      }
   }
}
