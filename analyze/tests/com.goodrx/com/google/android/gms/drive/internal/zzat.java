package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzsq;
import com.google.android.gms.internal.zzsu;
import java.io.IOException;

public final class zzat extends zzso<zzat> {
   public int versionCode;
   public long zzarW;
   public String zzarY;
   public long zzarZ;
   public int zzasa;

   public zzat() {
      this.zztl();
   }

   public boolean equals(Object var1) {
      boolean var3;
      if(var1 == this) {
         var3 = true;
      } else {
         boolean var2 = var1 instanceof zzat;
         var3 = false;
         if(var2) {
            zzat var4 = (zzat)var1;
            int var5 = this.versionCode;
            int var6 = var4.versionCode;
            var3 = false;
            if(var5 == var6) {
               if(this.zzarY == null) {
                  String var12 = var4.zzarY;
                  var3 = false;
                  if(var12 != null) {
                     return var3;
                  }
               } else if(!this.zzarY.equals(var4.zzarY)) {
                  return false;
               }

               long var13;
               int var7 = (var13 = this.zzarZ - var4.zzarZ) == 0L?0:(var13 < 0L?-1:1);
               var3 = false;
               if(var7 == 0) {
                  long var14;
                  int var8 = (var14 = this.zzarW - var4.zzarW) == 0L?0:(var14 < 0L?-1:1);
                  var3 = false;
                  if(var8 == 0) {
                     int var9 = this.zzasa;
                     int var10 = var4.zzasa;
                     var3 = false;
                     if(var9 == var10) {
                        if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
                           return this.zzbuj.equals(var4.zzbuj);
                        }

                        if(var4.zzbuj != null) {
                           boolean var11 = var4.zzbuj.isEmpty();
                           var3 = false;
                           if(!var11) {
                              return var3;
                           }
                        }

                        return true;
                     }
                  }
               }
            }
         }
      }

      return var3;
   }

   public int hashCode() {
      int var1 = 31 * (31 * (527 + this.getClass().getName().hashCode()) + this.versionCode);
      int var2;
      if(this.zzarY == null) {
         var2 = 0;
      } else {
         var2 = this.zzarY.hashCode();
      }

      int var3 = 31 * (31 * (31 * (31 * (var2 + var1) + (int)(this.zzarZ ^ this.zzarZ >>> 32)) + (int)(this.zzarW ^ this.zzarW >>> 32)) + this.zzasa);
      zzsq var4 = this.zzbuj;
      int var5 = 0;
      if(var4 != null) {
         boolean var6 = this.zzbuj.isEmpty();
         var5 = 0;
         if(!var6) {
            var5 = this.zzbuj.hashCode();
         }
      }

      return var3 + var5;
   }

   // $FF: synthetic method
   public zzsu mergeFrom(zzsm var1) throws IOException {
      return this.zzm(var1);
   }

   public void writeTo(zzsn var1) throws IOException {
      var1.zzA(1, this.versionCode);
      var1.zzn(2, this.zzarY);
      var1.zzc(3, this.zzarZ);
      var1.zzc(4, this.zzarW);
      if(this.zzasa != -1) {
         var1.zzA(5, this.zzasa);
      }

      super.writeTo(var1);
   }

   public zzat zzm(zzsm var1) throws IOException {
      while(true) {
         int var2 = var1.zzIX();
         switch(var2) {
         case 8:
            this.versionCode = var1.zzJb();
            break;
         case 18:
            this.zzarY = var1.readString();
            break;
         case 24:
            this.zzarZ = var1.zzJe();
            break;
         case 32:
            this.zzarW = var1.zzJe();
            break;
         case 40:
            this.zzasa = var1.zzJb();
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

   public zzat zztl() {
      this.versionCode = 1;
      this.zzarY = "";
      this.zzarZ = -1L;
      this.zzarW = -1L;
      this.zzasa = -1;
      this.zzbuj = null;
      this.zzbuu = -1;
      return this;
   }

   protected int zzz() {
      int var1 = super.zzz() + zzsn.zzC(1, this.versionCode) + zzsn.zzo(2, this.zzarY) + zzsn.zze(3, this.zzarZ) + zzsn.zze(4, this.zzarW);
      if(this.zzasa != -1) {
         var1 += zzsn.zzC(5, this.zzasa);
      }

      return var1;
   }
}
