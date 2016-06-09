package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.tagmanager.zzaz;
import com.google.android.gms.tagmanager.zzbf;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzcb;
import com.google.android.gms.tagmanager.zzp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class zzcn implements zzp.zzf {
   private final Context mContext;
   private final String zzbhM;
   private zzbf<zzrq.zza> zzbkg;
   private final ExecutorService zzbkn;

   zzcn(Context var1, String var2) {
      this.mContext = var1;
      this.zzbhM = var2;
      this.zzbkn = Executors.newSingleThreadExecutor();
   }

   private zzrs.zzc zza(ByteArrayOutputStream var1) {
      try {
         zzrs.zzc var4 = zzaz.zzgi(var1.toString("UTF-8"));
         return var4;
      } catch (UnsupportedEncodingException var5) {
         zzbg.zzaI("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
         return null;
      } catch (JSONException var6) {
         zzbg.zzaK("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn\'t contain a JSON container");
         return null;
      }
   }

   private void zzd(zzrq.zza var1) throws IllegalArgumentException {
      if(var1.zzju == null && var1.zzbme == null) {
         throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
      }
   }

   private zzrs.zzc zzx(byte[] param1) {
      // $FF: Couldn't be decompiled
   }

   public void release() {
      synchronized(this){}

      try {
         this.zzbkn.shutdown();
      } finally {
         ;
      }

   }

   public void zzGl() {
      this.zzbkn.execute(new Runnable() {
         public void run() {
            zzcn.this.zzHc();
         }
      });
   }

   void zzHc() {
      if(this.zzbkg == null) {
         throw new IllegalStateException("Callback must be set before execute");
      } else {
         this.zzbkg.zzGk();
         zzbg.method_354("Attempting to load resource from disk");
         if((zzcb.zzGU().zzGV() == zzcb.zza.zzbjV || zzcb.zzGU().zzGV() == zzcb.zza.zzbjW) && this.zzbhM.equals(zzcb.zzGU().getContainerId())) {
            this.zzbkg.zza(zzbf.zza.zzbju);
         } else {
            FileInputStream var1;
            try {
               var1 = new FileInputStream(this.zzHd());
            } catch (FileNotFoundException var24) {
               zzbg.zzaI("Failed to find the resource in the disk");
               this.zzbkg.zza(zzbf.zza.zzbju);
               return;
            }

            try {
               ByteArrayOutputStream var2 = new ByteArrayOutputStream();
               zzrs.zzb(var1, var2);
               zzrq.zza var9 = zzrq.zza.zzy(var2.toByteArray());
               this.zzd(var9);
               this.zzbkg.zzI(var9);
            } catch (IOException var21) {
               this.zzbkg.zza(zzbf.zza.zzbjv);
               zzbg.zzaK("Failed to read the resource from disk");
            } catch (IllegalArgumentException var22) {
               this.zzbkg.zza(zzbf.zza.zzbjv);
               zzbg.zzaK("Failed to read the resource from disk. The resource is inconsistent");
            } finally {
               try {
                  var1.close();
               } catch (IOException var20) {
                  zzbg.zzaK("Error closing stream for reading resource from disk");
               }

            }

            zzbg.method_354("The Disk resource was successfully read.");
         }
      }
   }

   File zzHd() {
      String var1 = "resource_" + this.zzbhM;
      return new File(this.mContext.getDir("google_tagmanager", 0), var1);
   }

   public void zza(zzbf<zzrq.zza> var1) {
      this.zzbkg = var1;
   }

   public void zzb(final zzrq.zza var1) {
      this.zzbkn.execute(new Runnable() {
         public void run() {
            zzcn.this.zzc(var1);
         }
      });
   }

   boolean zzc(zzrq.zza var1) {
      File var2 = this.zzHd();

      FileOutputStream var3;
      try {
         var3 = new FileOutputStream(var2);
      } catch (FileNotFoundException var18) {
         zzbg.method_353("Error opening resource file for writing");
         return false;
      }

      try {
         var3.write(zzsu.toByteArray(var1));
         return true;
      } catch (IOException var19) {
         zzbg.zzaK("Error writing resource to disk. Removing resource from disk.");
         var2.delete();
      } finally {
         try {
            var3.close();
         } catch (IOException var17) {
            zzbg.zzaK("error closing stream for writing resource to disk");
         }

      }

      return false;
   }

   public zzrs.zzc zzke(int param1) {
      // $FF: Couldn't be decompiled
   }
}
