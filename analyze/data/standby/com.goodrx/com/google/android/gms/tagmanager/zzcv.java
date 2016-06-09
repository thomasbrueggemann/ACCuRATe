package com.google.android.gms.tagmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class zzcv {
   static void zza(final Editor var0) {
      if(VERSION.SDK_INT >= 9) {
         var0.apply();
      } else {
         (new Thread(new Runnable() {
            public void run() {
               var0.commit();
            }
         })).start();
      }
   }

   @SuppressLint({"CommitPrefEdits"})
   static void zzb(Context var0, String var1, String var2, String var3) {
      Editor var4 = var0.getSharedPreferences(var1, 0).edit();
      var4.putString(var2, var3);
      zza(var4);
   }
}
