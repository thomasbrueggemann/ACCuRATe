package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.InstanceIDListenerService;
import com.google.android.gms.iid.zza;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class zzd {
   Context context;
   SharedPreferences zzaNt;

   public zzd(Context var1) {
      this(var1, "com.google.android.gms.appid");
   }

   public zzd(Context var1, String var2) {
      this.context = var1;
      this.zzaNt = var1.getSharedPreferences(var2, 4);
      this.zzeb(var2 + "-no-backup");
   }

   private void zzeb(String var1) {
      File var2 = new File((new ContextCompat()).getNoBackupFilesDir(this.context), var1);
      if(!var2.exists()) {
         try {
            if(var2.createNewFile() && !this.isEmpty()) {
               Log.i("InstanceID/Store", "App restored, clearing state");
               InstanceIDListenerService.zza(this.context, this);
               return;
            }
         } catch (IOException var4) {
            if(Log.isLoggable("InstanceID/Store", 3)) {
               Log.d("InstanceID/Store", "Error creating file in no backup dir: " + var4.getMessage());
               return;
            }
         }
      }

   }

   private String zzh(String var1, String var2, String var3) {
      return var1 + "|T|" + var2 + "|" + var3;
   }

   String get(String var1) {
      synchronized(this){}

      String var3;
      try {
         var3 = this.zzaNt.getString(var1, (String)null);
      } finally {
         ;
      }

      return var3;
   }

   String get(String var1, String var2) {
      synchronized(this){}

      String var4;
      try {
         var4 = this.zzaNt.getString(var1 + "|S|" + var2, (String)null);
      } finally {
         ;
      }

      return var4;
   }

   boolean isEmpty() {
      return this.zzaNt.getAll().isEmpty();
   }

   void zza(Editor var1, String var2, String var3, String var4) {
      synchronized(this){}

      try {
         var1.putString(var2 + "|S|" + var3, var4);
      } finally {
         ;
      }

   }

   public void zza(String var1, String var2, String var3, String var4, String var5) {
      synchronized(this){}

      try {
         String var7 = this.zzh(var1, var2, var3);
         Editor var8 = this.zzaNt.edit();
         var8.putString(var7, var4);
         var8.putString("appVersion", var5);
         var8.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000L));
         var8.commit();
      } finally {
         ;
      }

   }

   KeyPair zzd(String var1, long var2) {
      synchronized(this){}

      KeyPair var5;
      try {
         var5 = zza.zzyy();
         Editor var6 = this.zzaNt.edit();
         this.zza(var6, var1, "|P|", InstanceID.zzn(var5.getPublic().getEncoded()));
         this.zza(var6, var1, "|K|", InstanceID.zzn(var5.getPrivate().getEncoded()));
         this.zza(var6, var1, "cre", Long.toString(var2));
         var6.commit();
      } finally {
         ;
      }

      return var5;
   }

   public void zzec(String param1) {
      // $FF: Couldn't be decompiled
   }

   public KeyPair zzed(String var1) {
      return this.zzeg(var1);
   }

   void zzee(String var1) {
      this.zzec(var1 + "|");
   }

   public void zzef(String var1) {
      this.zzec(var1 + "|T|");
   }

   KeyPair zzeg(String var1) {
      String var2 = this.get(var1, "|P|");
      String var3 = this.get(var1, "|K|");
      if(var3 == null) {
         return null;
      } else {
         Object var4;
         try {
            byte[] var6 = Base64.decode(var2, 8);
            byte[] var7 = Base64.decode(var3, 8);
            KeyFactory var8 = KeyFactory.getInstance("RSA");
            KeyPair var9 = new KeyPair(var8.generatePublic(new X509EncodedKeySpec(var6)), var8.generatePrivate(new PKCS8EncodedKeySpec(var7)));
            return var9;
         } catch (InvalidKeySpecException var10) {
            var4 = var10;
         } catch (NoSuchAlgorithmException var11) {
            var4 = var11;
         }

         Log.w("InstanceID/Store", "Invalid key stored " + var4);
         InstanceIDListenerService.zza(this.context, this);
         return null;
      }
   }

   public String zzi(String var1, String var2, String var3) {
      synchronized(this){}

      String var6;
      try {
         String var5 = this.zzh(var1, var2, var3);
         var6 = this.zzaNt.getString(var5, (String)null);
      } finally {
         ;
      }

      return var6;
   }

   public void zzyG() {
      synchronized(this){}

      try {
         this.zzaNt.edit().clear().commit();
      } finally {
         ;
      }

   }
}
