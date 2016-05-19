package com.google.android.gms.measurement.internal;

import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzz;
import java.io.IOException;
import java.util.Map;

public class zzu extends zzz {
   private final Map<String, Map<String, String>> zzaXF = new ArrayMap();
   private final Map<String, Map<String, Boolean>> zzaXG = new ArrayMap();
   private final Map<String, zzqa.zzb> zzaXH = new ArrayMap();

   zzu(zzw var1) {
      super(var1);
   }

   private Map<String, String> zza(zzqa.zzb var1) {
      ArrayMap var2 = new ArrayMap();
      if(var1 != null && var1.zzaZV != null) {
         zzqa.zzc[] var3 = var1.zzaZV;
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            zzqa.zzc var6 = var3[var5];
            if(var6 != null) {
               var2.put(var6.key, var6.value);
            }
         }
      }

      return var2;
   }

   private Map<String, Boolean> zzb(zzqa.zzb var1) {
      ArrayMap var2 = new ArrayMap();
      if(var1 != null && var1.zzaZW != null) {
         zzqa.zza[] var3 = var1.zzaZW;
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            zzqa.zza var6 = var3[var5];
            if(var6 != null) {
               var2.put(var6.name, var6.zzaZS);
            }
         }
      }

      return var2;
   }

   @WorkerThread
   private zzqa.zzb zzf(String var1, byte[] var2) {
      if(var2 == null) {
         return new zzqa.zzb();
      } else {
         zzsm var3 = zzsm.zzD(var2);
         zzqa.zzb var4 = new zzqa.zzb();

         try {
            var4.zzA(var3);
            this.zzAo().zzCK().zze("Parsed config. version, gmp_app_id", var4.zzaZT, var4.zzaVt);
            return var4;
         } catch (IOException var6) {
            this.zzAo().zzCF().zze("Unable to merge remote config", var1, var6);
            return null;
         }
      }
   }

   @WorkerThread
   private void zzfj(String var1) {
      this.zzjv();
      this.zzjk();
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      if(!this.zzaXH.containsKey(var1)) {
         byte[] var3 = this.zzCj().zzfa(var1);
         if(var3 != null) {
            zzqa.zzb var4 = this.zzf(var1, var3);
            this.zzaXF.put(var1, this.zza(var4));
            this.zzaXG.put(var1, this.zzb(var4));
            this.zzaXH.put(var1, var4);
            return;
         }

         this.zzaXF.put(var1, (Object)null);
         this.zzaXG.put(var1, (Object)null);
         this.zzaXH.put(var1, (Object)null);
      }

   }

   @WorkerThread
   String zzO(String var1, String var2) {
      this.zzjk();
      this.zzfj(var1);
      Map var3 = (Map)this.zzaXF.get(var1);
      return var3 != null?(String)var3.get(var2):null;
   }

   @WorkerThread
   boolean zzP(String var1, String var2) {
      this.zzjk();
      this.zzfj(var1);
      Map var3 = (Map)this.zzaXG.get(var1);
      if(var3 != null) {
         Boolean var4 = (Boolean)var3.get(var2);
         return var4 == null?false:var4.booleanValue();
      } else {
         return false;
      }
   }

   @WorkerThread
   protected boolean zze(String var1, byte[] var2) {
      this.zzjv();
      this.zzjk();
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      zzqa.zzb var4 = this.zzf(var1, var2);
      if(var4 == null) {
         return false;
      } else {
         this.zzaXG.put(var1, this.zzb(var4));
         this.zzaXH.put(var1, var4);
         this.zzaXF.put(var1, this.zza(var4));
         this.zzCe().zza(var1, var4.zzaZX);

         label15: {
            byte[] var9;
            try {
               var4.zzaZX = null;
               var9 = new byte[var4.getSerializedSize()];
               var4.writeTo(zzsn.zzE(var9));
            } catch (IOException var10) {
               this.zzAo().zzCF().zzj("Unable to serialize reduced-size config.  Storing full config instead.", var10);
               break label15;
            }

            var2 = var9;
         }

         this.zzCj().zzd(var1, var2);
         return true;
      }
   }

   @WorkerThread
   protected zzqa.zzb zzfk(String var1) {
      this.zzjv();
      this.zzjk();
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      this.zzfj(var1);
      return (zzqa.zzb)this.zzaXH.get(var1);
   }

   protected void zziJ() {
   }
}
