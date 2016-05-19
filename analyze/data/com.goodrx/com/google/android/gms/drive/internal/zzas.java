package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzsu;
import java.io.IOException;

public final class zzas extends zzso<zzas> {
   public int versionCode;
   public long zzarV;
   public long zzarW;
   public long zzarX;

   public zzas() {
      this.zztk();
   }

   public boolean equals(Object var1) {
      boolean var3;
      if(var1 == this) {
         var3 = true;
      } else {
         boolean var2 = var1 instanceof zzas;
         var3 = false;
         if(var2) {
            zzas var4 = (zzas)var1;
            int var5 = this.versionCode;
            int var6 = var4.versionCode;
            var3 = false;
            if(var5 == var6) {
               long var11;
               int var7 = (var11 = this.zzarV - var4.zzarV) == 0L?0:(var11 < 0L?-1:1);
               var3 = false;
               if(var7 == 0) {
                  long var12;
                  int var8 = (var12 = this.zzarW - var4.zzarW) == 0L?0:(var12 < 0L?-1:1);
                  var3 = false;
                  if(var8 == 0) {
                     long var13;
                     int var9 = (var13 = this.zzarX - var4.zzarX) == 0L?0:(var13 < 0L?-1:1);
                     var3 = false;
                     if(var9 == 0) {
                        if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
                           return this.zzbuj.equals(var4.zzbuj);
                        }

                        if(var4.zzbuj != null) {
                           boolean var10 = var4.zzbuj.isEmpty();
                           var3 = false;
                           if(!var10) {
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
      int var1 = 31 * (31 * (31 * (31 * (31 * (527 + this.getClass().getName().hashCode()) + this.versionCode) + (int)(this.zzarV ^ this.zzarV >>> 32)) + (int)(this.zzarW ^ this.zzarW >>> 32)) + (int)(this.zzarX ^ this.zzarX >>> 32));
      int var2;
      if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
         var2 = this.zzbuj.hashCode();
      } else {
         var2 = 0;
      }

      return var2 + var1;
   }

   // $FF: synthetic method
   public zzsu mergeFrom(zzsm var1) throws IOException {
      return this.zzl(var1);
   }

   public void writeTo(zzsn var1) throws IOException {
      var1.zzA(1, this.versionCode);
      var1.zzc(2, this.zzarV);
      var1.zzc(3, this.zzarW);
      var1.zzc(4, this.zzarX);
      super.writeTo(var1);
   }

   public zzas zzl(zzsm var1) throws IOException {
      while(true) {
         int var2 = var1.zzIX();
         switch(var2) {
         case 8:
            this.versionCode = var1.zzJb();
            break;
         case 16:
            this.zzarV = var1.zzJe();
            break;
         case 24:
            this.zzarW = var1.zzJe();
            break;
         case 32:
            this.zzarX = var1.zzJe();
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

   public zzas zztk() {
      this.versionCode = 1;
      this.zzarV = -1L;
      this.zzarW = -1L;
      this.zzarX = -1L;
      this.zzbuj = null;
      this.zzbuu = -1;
      return this;
   }

   protected int zzz() {
      return super.zzz() + zzsn.zzC(1, this.versionCode) + zzsn.zze(2, this.zzarV) + zzsn.zze(3, this.zzarW) + zzsn.zze(4, this.zzarX);
   }
}
