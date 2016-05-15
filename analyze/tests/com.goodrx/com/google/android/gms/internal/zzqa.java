package com.google.android.gms.internal;

import com.google.android.gms.internal.zzpz;
import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzss;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsx;
import java.io.IOException;

public interface zzqa {
   public static final class zza extends zzsu {
      private static volatile zzqa.zza[] zzaZR;
      public String name;
      public Boolean zzaZS;

      public zza() {
         this.zzDL();
      }

      public static zzqa.zza[] zzDK() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzqa.zza)) {
               return false;
            }

            zzqa.zza var2 = (zzqa.zza)var1;
            if(this.name == null) {
               if(var2.name != null) {
                  return false;
               }
            } else if(!this.name.equals(var2.name)) {
               return false;
            }

            if(this.zzaZS == null) {
               if(var2.zzaZS != null) {
                  return false;
               }
            } else if(!this.zzaZS.equals(var2.zzaZS)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         int var2;
         if(this.name == null) {
            var2 = 0;
         } else {
            var2 = this.name.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         Boolean var4 = this.zzaZS;
         int var5 = 0;
         if(var4 != null) {
            var5 = this.zzaZS.hashCode();
         }

         return var3 + var5;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzz(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.name != null) {
            var1.zzn(1, this.name);
         }

         if(this.zzaZS != null) {
            var1.zze(2, this.zzaZS.booleanValue());
         }

         super.writeTo(var1);
      }

      public zzqa.zza zzDL() {
         this.name = null;
         this.zzaZS = null;
         this.zzbuu = -1;
         return this;
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(this.name != null) {
            var1 += zzsn.zzo(1, this.name);
         }

         if(this.zzaZS != null) {
            var1 += zzsn.zzf(2, this.zzaZS.booleanValue());
         }

         return var1;
      }

      public zzqa.zza zzz(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 10:
               this.name = var1.readString();
               break;
            case 16:
               this.zzaZS = Boolean.valueOf(var1.zzJc());
               break;
            default:
               if(zzsx.zzb(var1, var2)) {
                  break;
               }
            case 0:
               return this;
            }
         }
      }
   }

   public static final class zzb extends zzsu {
      public String zzaVt;
      public Long zzaZT;
      public Integer zzaZU;
      public zzqa.zzc[] zzaZV;
      public zzqa.zza[] zzaZW;
      public zzpz.zza[] zzaZX;

      public zzb() {
         this.zzDM();
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzqa.zzb)) {
               return false;
            }

            zzqa.zzb var2 = (zzqa.zzb)var1;
            if(this.zzaZT == null) {
               if(var2.zzaZT != null) {
                  return false;
               }
            } else if(!this.zzaZT.equals(var2.zzaZT)) {
               return false;
            }

            if(this.zzaVt == null) {
               if(var2.zzaVt != null) {
                  return false;
               }
            } else if(!this.zzaVt.equals(var2.zzaVt)) {
               return false;
            }

            if(this.zzaZU == null) {
               if(var2.zzaZU != null) {
                  return false;
               }
            } else if(!this.zzaZU.equals(var2.zzaZU)) {
               return false;
            }

            if(!zzss.equals((Object[])this.zzaZV, (Object[])var2.zzaZV)) {
               return false;
            }

            if(!zzss.equals((Object[])this.zzaZW, (Object[])var2.zzaZW)) {
               return false;
            }

            if(!zzss.equals((Object[])this.zzaZX, (Object[])var2.zzaZX)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         int var2;
         if(this.zzaZT == null) {
            var2 = 0;
         } else {
            var2 = this.zzaZT.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.zzaVt == null) {
            var4 = 0;
         } else {
            var4 = this.zzaVt.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         Integer var6 = this.zzaZU;
         int var7 = 0;
         if(var6 != null) {
            var7 = this.zzaZU.hashCode();
         }

         return 31 * (31 * (31 * (var5 + var7) + zzss.hashCode((Object[])this.zzaZV)) + zzss.hashCode((Object[])this.zzaZW)) + zzss.hashCode((Object[])this.zzaZX);
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzA(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzaZT != null) {
            var1.zzb(1, this.zzaZT.longValue());
         }

         if(this.zzaVt != null) {
            var1.zzn(2, this.zzaVt);
         }

         if(this.zzaZU != null) {
            var1.zzA(3, this.zzaZU.intValue());
         }

         if(this.zzaZV != null && this.zzaZV.length > 0) {
            for(int var7 = 0; var7 < this.zzaZV.length; ++var7) {
               zzqa.zzc var8 = this.zzaZV[var7];
               if(var8 != null) {
                  var1.zza(4, (zzsu)var8);
               }
            }
         }

         if(this.zzaZW != null && this.zzaZW.length > 0) {
            for(int var5 = 0; var5 < this.zzaZW.length; ++var5) {
               zzqa.zza var6 = this.zzaZW[var5];
               if(var6 != null) {
                  var1.zza(5, (zzsu)var6);
               }
            }
         }

         if(this.zzaZX != null) {
            int var2 = this.zzaZX.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.zzaZX.length; ++var3) {
                  zzpz.zza var4 = this.zzaZX[var3];
                  if(var4 != null) {
                     var1.zza(6, (zzsu)var4);
                  }
               }
            }
         }

         super.writeTo(var1);
      }

      public zzqa.zzb zzA(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var12;
            zzqa.zzc[] var13;
            switch(var2) {
            case 8:
               this.zzaZT = Long.valueOf(var1.zzJa());
               continue;
            case 18:
               this.zzaVt = var1.readString();
               continue;
            case 24:
               this.zzaZU = Integer.valueOf(var1.zzJb());
               continue;
            case 34:
               int var11 = zzsx.zzc(var1, 34);
               if(this.zzaZV == null) {
                  var12 = 0;
               } else {
                  var12 = this.zzaZV.length;
               }

               var13 = new zzqa.zzc[var11 + var12];
               if(var12 != 0) {
                  System.arraycopy(this.zzaZV, 0, var13, 0, var12);
               }
               break;
            case 42:
               int var7 = zzsx.zzc(var1, 42);
               int var8;
               if(this.zzaZW == null) {
                  var8 = 0;
               } else {
                  var8 = this.zzaZW.length;
               }

               zzqa.zza[] var9 = new zzqa.zza[var7 + var8];
               if(var8 != 0) {
                  System.arraycopy(this.zzaZW, 0, var9, 0, var8);
               }

               while(var8 < -1 + var9.length) {
                  var9[var8] = new zzqa.zza();
                  var1.zza(var9[var8]);
                  var1.zzIX();
                  ++var8;
               }

               var9[var8] = new zzqa.zza();
               var1.zza(var9[var8]);
               this.zzaZW = var9;
               continue;
            case 50:
               int var3 = zzsx.zzc(var1, 50);
               int var4;
               if(this.zzaZX == null) {
                  var4 = 0;
               } else {
                  var4 = this.zzaZX.length;
               }

               zzpz.zza[] var5 = new zzpz.zza[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.zzaZX, 0, var5, 0, var4);
               }

               while(var4 < -1 + var5.length) {
                  var5[var4] = new zzpz.zza();
                  var1.zza(var5[var4]);
                  var1.zzIX();
                  ++var4;
               }

               var5[var4] = new zzpz.zza();
               var1.zza(var5[var4]);
               this.zzaZX = var5;
               continue;
            default:
               if(zzsx.zzb(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var12 < -1 + var13.length) {
               var13[var12] = new zzqa.zzc();
               var1.zza(var13[var12]);
               var1.zzIX();
               ++var12;
            }

            var13[var12] = new zzqa.zzc();
            var1.zza(var13[var12]);
            this.zzaZV = var13;
         }
      }

      public zzqa.zzb zzDM() {
         this.zzaZT = null;
         this.zzaVt = null;
         this.zzaZU = null;
         this.zzaZV = zzqa.zzc.zzDN();
         this.zzaZW = zzqa.zza.zzDK();
         this.zzaZX = zzpz.zza.zzDA();
         this.zzbuu = -1;
         return this;
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(this.zzaZT != null) {
            var1 += zzsn.zzd(1, this.zzaZT.longValue());
         }

         if(this.zzaVt != null) {
            var1 += zzsn.zzo(2, this.zzaVt);
         }

         if(this.zzaZU != null) {
            var1 += zzsn.zzC(3, this.zzaZU.intValue());
         }

         if(this.zzaZV != null && this.zzaZV.length > 0) {
            int var8 = var1;

            for(int var9 = 0; var9 < this.zzaZV.length; ++var9) {
               zzqa.zzc var10 = this.zzaZV[var9];
               if(var10 != null) {
                  var8 += zzsn.zzc(4, var10);
               }
            }

            var1 = var8;
         }

         if(this.zzaZW != null && this.zzaZW.length > 0) {
            int var5 = var1;

            for(int var6 = 0; var6 < this.zzaZW.length; ++var6) {
               zzqa.zza var7 = this.zzaZW[var6];
               if(var7 != null) {
                  var5 += zzsn.zzc(5, var7);
               }
            }

            var1 = var5;
         }

         if(this.zzaZX != null) {
            int var2 = this.zzaZX.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.zzaZX.length; ++var3) {
                  zzpz.zza var4 = this.zzaZX[var3];
                  if(var4 != null) {
                     var1 += zzsn.zzc(6, var4);
                  }
               }
            }
         }

         return var1;
      }
   }

   public static final class zzc extends zzsu {
      private static volatile zzqa.zzc[] zzaZY;
      public String key;
      public String value;

      public zzc() {
         this.zzDO();
      }

      public static zzqa.zzc[] zzDN() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzqa.zzc)) {
               return false;
            }

            zzqa.zzc var2 = (zzqa.zzc)var1;
            if(this.key == null) {
               if(var2.key != null) {
                  return false;
               }
            } else if(!this.key.equals(var2.key)) {
               return false;
            }

            if(this.value == null) {
               if(var2.value != null) {
                  return false;
               }
            } else if(!this.value.equals(var2.value)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         int var2;
         if(this.key == null) {
            var2 = 0;
         } else {
            var2 = this.key.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         String var4 = this.value;
         int var5 = 0;
         if(var4 != null) {
            var5 = this.value.hashCode();
         }

         return var3 + var5;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzB(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.key != null) {
            var1.zzn(1, this.key);
         }

         if(this.value != null) {
            var1.zzn(2, this.value);
         }

         super.writeTo(var1);
      }

      public zzqa.zzc zzB(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 10:
               this.key = var1.readString();
               break;
            case 18:
               this.value = var1.readString();
               break;
            default:
               if(zzsx.zzb(var1, var2)) {
                  break;
               }
            case 0:
               return this;
            }
         }
      }

      public zzqa.zzc zzDO() {
         this.key = null;
         this.value = null;
         this.zzbuu = -1;
         return this;
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(this.key != null) {
            var1 += zzsn.zzo(1, this.key);
         }

         if(this.value != null) {
            var1 += zzsn.zzo(2, this.value);
         }

         return var1;
      }
   }
}
