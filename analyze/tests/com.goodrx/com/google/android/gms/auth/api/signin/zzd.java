package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.class_54;

public enum zzd {
   zzXh,
   zzXi;

   private final String zzVY;
   private final String zzXj;
   private final int zzXk;

   static {
      zzXh = new zzd("GOOGLE", 0, "google.com", class_54.string.auth_google_play_services_client_google_display_name, "https://accounts.google.com");
      zzXi = new zzd("FACEBOOK", 1, "facebook.com", class_54.string.auth_google_play_services_client_facebook_display_name, "https://www.facebook.com");
      zzd[] var0 = new zzd[]{zzXh, zzXi};
   }

   private zzd(String var3, int var4, String var5) {
      this.zzXj = var3;
      this.zzXk = var4;
      this.zzVY = var5;
   }

   public static zzd zzbL(String var0) {
      if(var0 != null) {
         zzd[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            zzd var5 = var1[var3];
            if(var5.zzmT().equals(var0)) {
               return var5;
            }
         }

         Log.w("IdProvider", "Unrecognized providerId: " + var0);
      }

      return null;
   }

   public String toString() {
      return this.zzXj;
   }

   public CharSequence zzae(Context var1) {
      return var1.getResources().getString(this.zzXk);
   }

   public String zzmT() {
      return this.zzXj;
   }
}
