package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.zzd;
import com.google.android.gms.common.zze;

public class zzf {
   private static final zzf zzafS = new zzf();

   public static zzf zzoO() {
      return zzafS;
   }

   zzd.zza zza(PackageInfo var1, zzd.zza... var2) {
      if(var1.signatures.length != 1) {
         Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
         return null;
      } else {
         zzd.zzb var3 = new zzd.zzb(var1.signatures[0].toByteArray());

         for(int var4 = 0; var4 < var2.length; ++var4) {
            if(var2[var4].equals(var3)) {
               return var2[var4];
            }
         }

         if(Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(var3.getBytes(), 0));
         }

         return null;
      }
   }

   public boolean zza(PackageInfo var1, boolean var2) {
      if(var1 != null && var1.signatures != null) {
         zzd.zza var4;
         if(var2) {
            var4 = this.zza(var1, zzd.zzd.zzafK);
         } else {
            zzd.zza[] var3 = new zzd.zza[]{zzd.zzd.zzafK[0]};
            var4 = this.zza(var1, var3);
         }

         if(var4 != null) {
            return true;
         }
      }

      return false;
   }

   public boolean zza(PackageManager var1, PackageInfo var2) {
      boolean var3 = false;
      if(var2 != null) {
         if(zze.zzc(var1)) {
            return this.zza(var2, true);
         }

         var3 = this.zza(var2, false);
         if(!var3 && this.zza(var2, true)) {
            Log.w("GoogleSignatureVerifier", "Test-keys aren\'t accepted on this build.");
            return var3;
         }
      }

      return var3;
   }
}
