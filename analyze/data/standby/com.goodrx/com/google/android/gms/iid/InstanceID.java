package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.iid.zzc;
import com.google.android.gms.iid.zzd;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class InstanceID {
   static Map<String, InstanceID> zzaMP = new HashMap();
   private static zzd zzaMQ;
   private static zzc zzaMR;
   static String zzaMV;
   Context mContext;
   KeyPair zzaMS;
   String zzaMT = "";
   long zzaMU;

   protected InstanceID(Context var1, String var2, Bundle var3) {
      this.mContext = var1.getApplicationContext();
      this.zzaMT = var2;
   }

   public static InstanceID getInstance(Context var0) {
      return zza(var0, (Bundle)null);
   }

   public static InstanceID zza(Context param0, Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   static String zza(KeyPair var0) {
      byte[] var1 = var0.getPublic().getEncoded();

      try {
         byte[] var4 = MessageDigest.getInstance("SHA1").digest(var1);
         var4[0] = (byte)(255 & 112 + (15 & var4[0]));
         String var5 = Base64.encodeToString(var4, 0, 8, 11);
         return var5;
      } catch (NoSuchAlgorithmException var6) {
         Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
         return null;
      }
   }

   static int zzaL(Context var0) {
      try {
         int var3 = var0.getPackageManager().getPackageInfo(var0.getPackageName(), 0).versionCode;
         return var3;
      } catch (NameNotFoundException var4) {
         Log.w("InstanceID", "Never happens: can\'t find own package " + var4);
         return 0;
      }
   }

   static String zzn(byte[] var0) {
      return Base64.encodeToString(var0, 11);
   }

   public String getId() {
      return zza(this.zzyz());
   }

   public String getToken(String var1, String var2, Bundle var3) throws IOException {
      if(Looper.getMainLooper() == Looper.myLooper()) {
         throw new IOException("MAIN_THREAD");
      } else {
         boolean var4 = true;
         String var5;
         if(this.zzyD()) {
            var5 = null;
         } else {
            var5 = zzaMQ.zzi(this.zzaMT, var1, var2);
         }

         if(var5 == null) {
            if(var3 == null) {
               var3 = new Bundle();
            }

            if(var3.getString("ttl") != null) {
               var4 = false;
            }

            boolean var6 = "jwt".equals(var3.getString("type"));
            boolean var7 = false;
            if(!var6) {
               var7 = var4;
            }

            var5 = this.zzc(var1, var2, var3);
            Log.w("InstanceID", "token: " + var5);
            if(var5 != null && var7) {
               zzaMQ.zza(this.zzaMT, var1, var2, var5, zzaMV);
               return var5;
            }
         }

         return var5;
      }
   }

   public String zzc(String var1, String var2, Bundle var3) throws IOException {
      if(var2 != null) {
         var3.putString("scope", var2);
      }

      var3.putString("sender", var1);
      String var4;
      if("".equals(this.zzaMT)) {
         var4 = var1;
      } else {
         var4 = this.zzaMT;
      }

      if(!var3.containsKey("legacy.register")) {
         var3.putString("subscription", var1);
         var3.putString("subtype", var4);
         var3.putString("X-subscription", var1);
         var3.putString("X-subtype", var4);
      }

      Intent var5 = zzaMR.zza(var3, this.zzyz());
      return zzaMR.zzu(var5);
   }

   void zzyA() {
      this.zzaMU = 0L;
      zzaMQ.zzee(this.zzaMT);
      this.zzaMS = null;
   }

   public zzd zzyB() {
      return zzaMQ;
   }

   zzc zzyC() {
      return zzaMR;
   }

   boolean zzyD() {
      String var1 = zzaMQ.get("appVersion");
      if(var1 != null && var1.equals(zzaMV)) {
         String var2 = zzaMQ.get("lastToken");
         if(var2 != null) {
            Long var3 = Long.valueOf(Long.parseLong(var2));
            if(System.currentTimeMillis() / 1000L - var3.longValue() <= 604800L) {
               return false;
            }
         }
      }

      return true;
   }

   KeyPair zzyz() {
      if(this.zzaMS == null) {
         this.zzaMS = zzaMQ.zzed(this.zzaMT);
      }

      if(this.zzaMS == null) {
         this.zzaMU = System.currentTimeMillis();
         this.zzaMS = zzaMQ.zzd(this.zzaMT, this.zzaMU);
      }

      return this.zzaMS;
   }
}
