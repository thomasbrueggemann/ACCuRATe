package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzsq;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import java.io.IOException;

public interface zzrq {
   public static final class zza extends zzso<zzrq.zza> {
      public long zzbmd;
      public zzaf.zzj zzbme;
      public zzaf.zzf zzju;

      public zza() {
         this.zzHG();
      }

      public static zzrq.zza zzy(byte[] var0) throws zzst {
         return (zzrq.zza)zzsu.mergeFrom(new zzrq.zza(), var0);
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzrq.zza;
            var3 = false;
            if(var2) {
               zzrq.zza var4 = (zzrq.zza)var1;
               long var9;
               int var5 = (var9 = this.zzbmd - var4.zzbmd) == 0L?0:(var9 < 0L?-1:1);
               var3 = false;
               if(var5 == 0) {
                  if(this.zzju == null) {
                     zzaf.zzf var8 = var4.zzju;
                     var3 = false;
                     if(var8 != null) {
                        return var3;
                     }
                  } else if(!this.zzju.equals(var4.zzju)) {
                     return false;
                  }

                  if(this.zzbme == null) {
                     zzaf.zzj var7 = var4.zzbme;
                     var3 = false;
                     if(var7 != null) {
                        return var3;
                     }
                  } else if(!this.zzbme.equals(var4.zzbme)) {
                     return false;
                  }

                  if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
                     return this.zzbuj.equals(var4.zzbuj);
                  }

                  if(var4.zzbuj != null) {
                     boolean var6 = var4.zzbuj.isEmpty();
                     var3 = false;
                     if(!var6) {
                        return var3;
                     }
                  }

                  return true;
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (31 * (527 + this.getClass().getName().hashCode()) + (int)(this.zzbmd ^ this.zzbmd >>> 32));
         int var2;
         if(this.zzju == null) {
            var2 = 0;
         } else {
            var2 = this.zzju.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.zzbme == null) {
            var4 = 0;
         } else {
            var4 = this.zzbme.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         zzsq var6 = this.zzbuj;
         int var7 = 0;
         if(var6 != null) {
            boolean var8 = this.zzbuj.isEmpty();
            var7 = 0;
            if(!var8) {
               var7 = this.zzbuj.hashCode();
            }
         }

         return var5 + var7;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzJ(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         var1.zzb(1, this.zzbmd);
         if(this.zzju != null) {
            var1.zza(2, (zzsu)this.zzju);
         }

         if(this.zzbme != null) {
            var1.zza(3, (zzsu)this.zzbme);
         }

         super.writeTo(var1);
      }

      public zzrq.zza zzHG() {
         this.zzbmd = 0L;
         this.zzju = null;
         this.zzbme = null;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzrq.zza zzJ(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 8:
               this.zzbmd = var1.zzJa();
               break;
            case 18:
               if(this.zzju == null) {
                  this.zzju = new zzaf.zzf();
               }

               var1.zza(this.zzju);
               break;
            case 26:
               if(this.zzbme == null) {
                  this.zzbme = new zzaf.zzj();
               }

               var1.zza(this.zzbme);
               break;
            default:
               if(this.zza(var1, var2)) {
                  break;
               }
            case 0:
               return this;
            }
         }
      }

      protected int zzz() {
         int var1 = super.zzz() + zzsn.zzd(1, this.zzbmd);
         if(this.zzju != null) {
            var1 += zzsn.zzc(2, this.zzju);
         }

         if(this.zzbme != null) {
            var1 += zzsn.zzc(3, this.zzbme);
         }

         return var1;
      }
   }
}
