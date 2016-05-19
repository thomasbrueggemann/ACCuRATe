package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzss;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsx;
import java.io.IOException;

public interface zzpz {
   public static final class zza extends zzsu {
      private static volatile zzpz.zza[] zzaZq;
      public Integer zzaZr;
      public zzpz.zze[] zzaZs;
      public zzpz.zzb[] zzaZt;

      public zza() {
         this.zzDB();
      }

      public static zzpz.zza[] zzDA() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzpz.zza)) {
               return false;
            }

            zzpz.zza var2 = (zzpz.zza)var1;
            if(this.zzaZr == null) {
               if(var2.zzaZr != null) {
                  return false;
               }
            } else if(!this.zzaZr.equals(var2.zzaZr)) {
               return false;
            }

            if(!zzss.equals((Object[])this.zzaZs, (Object[])var2.zzaZs)) {
               return false;
            }

            if(!zzss.equals((Object[])this.zzaZt, (Object[])var2.zzaZt)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         int var2;
         if(this.zzaZr == null) {
            var2 = 0;
         } else {
            var2 = this.zzaZr.hashCode();
         }

         return 31 * (31 * (var2 + var1) + zzss.hashCode((Object[])this.zzaZs)) + zzss.hashCode((Object[])this.zzaZt);
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzt(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzaZr != null) {
            var1.zzA(1, this.zzaZr.intValue());
         }

         if(this.zzaZs != null && this.zzaZs.length > 0) {
            for(int var5 = 0; var5 < this.zzaZs.length; ++var5) {
               zzpz.zze var6 = this.zzaZs[var5];
               if(var6 != null) {
                  var1.zza(2, (zzsu)var6);
               }
            }
         }

         if(this.zzaZt != null) {
            int var2 = this.zzaZt.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.zzaZt.length; ++var3) {
                  zzpz.zzb var4 = this.zzaZt[var3];
                  if(var4 != null) {
                     var1.zza(3, (zzsu)var4);
                  }
               }
            }
         }

         super.writeTo(var1);
      }

      public zzpz.zza zzDB() {
         this.zzaZr = null;
         this.zzaZs = zzpz.zze.zzDH();
         this.zzaZt = zzpz.zzb.zzDC();
         this.zzbuu = -1;
         return this;
      }

      public zzpz.zza zzt(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var8;
            zzpz.zze[] var9;
            switch(var2) {
            case 8:
               this.zzaZr = Integer.valueOf(var1.zzJb());
               continue;
            case 18:
               int var7 = zzsx.zzc(var1, 18);
               if(this.zzaZs == null) {
                  var8 = 0;
               } else {
                  var8 = this.zzaZs.length;
               }

               var9 = new zzpz.zze[var7 + var8];
               if(var8 != 0) {
                  System.arraycopy(this.zzaZs, 0, var9, 0, var8);
               }
               break;
            case 26:
               int var3 = zzsx.zzc(var1, 26);
               int var4;
               if(this.zzaZt == null) {
                  var4 = 0;
               } else {
                  var4 = this.zzaZt.length;
               }

               zzpz.zzb[] var5 = new zzpz.zzb[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.zzaZt, 0, var5, 0, var4);
               }

               while(var4 < -1 + var5.length) {
                  var5[var4] = new zzpz.zzb();
                  var1.zza(var5[var4]);
                  var1.zzIX();
                  ++var4;
               }

               var5[var4] = new zzpz.zzb();
               var1.zza(var5[var4]);
               this.zzaZt = var5;
               continue;
            default:
               if(zzsx.zzb(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var8 < -1 + var9.length) {
               var9[var8] = new zzpz.zze();
               var1.zza(var9[var8]);
               var1.zzIX();
               ++var8;
            }

            var9[var8] = new zzpz.zze();
            var1.zza(var9[var8]);
            this.zzaZs = var9;
         }
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(this.zzaZr != null) {
            var1 += zzsn.zzC(1, this.zzaZr.intValue());
         }

         if(this.zzaZs != null && this.zzaZs.length > 0) {
            int var5 = var1;

            for(int var6 = 0; var6 < this.zzaZs.length; ++var6) {
               zzpz.zze var7 = this.zzaZs[var6];
               if(var7 != null) {
                  var5 += zzsn.zzc(2, var7);
               }
            }

            var1 = var5;
         }

         if(this.zzaZt != null) {
            int var2 = this.zzaZt.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.zzaZt.length; ++var3) {
                  zzpz.zzb var4 = this.zzaZt[var3];
                  if(var4 != null) {
                     var1 += zzsn.zzc(3, var4);
                  }
               }
            }
         }

         return var1;
      }
   }

   public static final class zzb extends zzsu {
      private static volatile zzpz.zzb[] zzaZu;
      public Integer zzaZv;
      public String zzaZw;
      public zzpz.zzc[] zzaZx;
      public Boolean zzaZy;
      public zzpz.zzd zzaZz;

      public zzb() {
         this.zzDD();
      }

      public static zzpz.zzb[] zzDC() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzpz.zzb)) {
               return false;
            }

            zzpz.zzb var2 = (zzpz.zzb)var1;
            if(this.zzaZv == null) {
               if(var2.zzaZv != null) {
                  return false;
               }
            } else if(!this.zzaZv.equals(var2.zzaZv)) {
               return false;
            }

            if(this.zzaZw == null) {
               if(var2.zzaZw != null) {
                  return false;
               }
            } else if(!this.zzaZw.equals(var2.zzaZw)) {
               return false;
            }

            if(!zzss.equals((Object[])this.zzaZx, (Object[])var2.zzaZx)) {
               return false;
            }

            if(this.zzaZy == null) {
               if(var2.zzaZy != null) {
                  return false;
               }
            } else if(!this.zzaZy.equals(var2.zzaZy)) {
               return false;
            }

            if(this.zzaZz == null) {
               if(var2.zzaZz != null) {
                  return false;
               }
            } else if(!this.zzaZz.equals(var2.zzaZz)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         int var2;
         if(this.zzaZv == null) {
            var2 = 0;
         } else {
            var2 = this.zzaZv.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.zzaZw == null) {
            var4 = 0;
         } else {
            var4 = this.zzaZw.hashCode();
         }

         int var5 = 31 * (31 * (var4 + var3) + zzss.hashCode((Object[])this.zzaZx));
         int var6;
         if(this.zzaZy == null) {
            var6 = 0;
         } else {
            var6 = this.zzaZy.hashCode();
         }

         int var7 = 31 * (var6 + var5);
         zzpz.zzd var8 = this.zzaZz;
         int var9 = 0;
         if(var8 != null) {
            var9 = this.zzaZz.hashCode();
         }

         return var7 + var9;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzu(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzaZv != null) {
            var1.zzA(1, this.zzaZv.intValue());
         }

         if(this.zzaZw != null) {
            var1.zzn(2, this.zzaZw);
         }

         if(this.zzaZx != null && this.zzaZx.length > 0) {
            for(int var2 = 0; var2 < this.zzaZx.length; ++var2) {
               zzpz.zzc var3 = this.zzaZx[var2];
               if(var3 != null) {
                  var1.zza(3, (zzsu)var3);
               }
            }
         }

         if(this.zzaZy != null) {
            var1.zze(4, this.zzaZy.booleanValue());
         }

         if(this.zzaZz != null) {
            var1.zza(5, (zzsu)this.zzaZz);
         }

         super.writeTo(var1);
      }

      public zzpz.zzb zzDD() {
         this.zzaZv = null;
         this.zzaZw = null;
         this.zzaZx = zzpz.zzc.zzDE();
         this.zzaZy = null;
         this.zzaZz = null;
         this.zzbuu = -1;
         return this;
      }

      public zzpz.zzb zzu(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var4;
            zzpz.zzc[] var5;
            switch(var2) {
            case 8:
               this.zzaZv = Integer.valueOf(var1.zzJb());
               continue;
            case 18:
               this.zzaZw = var1.readString();
               continue;
            case 26:
               int var3 = zzsx.zzc(var1, 26);
               if(this.zzaZx == null) {
                  var4 = 0;
               } else {
                  var4 = this.zzaZx.length;
               }

               var5 = new zzpz.zzc[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.zzaZx, 0, var5, 0, var4);
               }
               break;
            case 32:
               this.zzaZy = Boolean.valueOf(var1.zzJc());
               continue;
            case 42:
               if(this.zzaZz == null) {
                  this.zzaZz = new zzpz.zzd();
               }

               var1.zza(this.zzaZz);
               continue;
            default:
               if(zzsx.zzb(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var4 < -1 + var5.length) {
               var5[var4] = new zzpz.zzc();
               var1.zza(var5[var4]);
               var1.zzIX();
               ++var4;
            }

            var5[var4] = new zzpz.zzc();
            var1.zza(var5[var4]);
            this.zzaZx = var5;
         }
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(this.zzaZv != null) {
            var1 += zzsn.zzC(1, this.zzaZv.intValue());
         }

         if(this.zzaZw != null) {
            var1 += zzsn.zzo(2, this.zzaZw);
         }

         if(this.zzaZx != null && this.zzaZx.length > 0) {
            int var2 = var1;

            for(int var3 = 0; var3 < this.zzaZx.length; ++var3) {
               zzpz.zzc var4 = this.zzaZx[var3];
               if(var4 != null) {
                  var2 += zzsn.zzc(3, var4);
               }
            }

            var1 = var2;
         }

         if(this.zzaZy != null) {
            var1 += zzsn.zzf(4, this.zzaZy.booleanValue());
         }

         if(this.zzaZz != null) {
            var1 += zzsn.zzc(5, this.zzaZz);
         }

         return var1;
      }
   }

   public static final class zzc extends zzsu {
      private static volatile zzpz.zzc[] zzaZA;
      public zzpz.zzf zzaZB;
      public zzpz.zzd zzaZC;
      public Boolean zzaZD;
      public String zzaZE;

      public zzc() {
         this.zzDF();
      }

      public static zzpz.zzc[] zzDE() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzpz.zzc)) {
               return false;
            }

            zzpz.zzc var2 = (zzpz.zzc)var1;
            if(this.zzaZB == null) {
               if(var2.zzaZB != null) {
                  return false;
               }
            } else if(!this.zzaZB.equals(var2.zzaZB)) {
               return false;
            }

            if(this.zzaZC == null) {
               if(var2.zzaZC != null) {
                  return false;
               }
            } else if(!this.zzaZC.equals(var2.zzaZC)) {
               return false;
            }

            if(this.zzaZD == null) {
               if(var2.zzaZD != null) {
                  return false;
               }
            } else if(!this.zzaZD.equals(var2.zzaZD)) {
               return false;
            }

            if(this.zzaZE == null) {
               if(var2.zzaZE != null) {
                  return false;
               }
            } else if(!this.zzaZE.equals(var2.zzaZE)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         int var2;
         if(this.zzaZB == null) {
            var2 = 0;
         } else {
            var2 = this.zzaZB.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.zzaZC == null) {
            var4 = 0;
         } else {
            var4 = this.zzaZC.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         int var6;
         if(this.zzaZD == null) {
            var6 = 0;
         } else {
            var6 = this.zzaZD.hashCode();
         }

         int var7 = 31 * (var6 + var5);
         String var8 = this.zzaZE;
         int var9 = 0;
         if(var8 != null) {
            var9 = this.zzaZE.hashCode();
         }

         return var7 + var9;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzv(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzaZB != null) {
            var1.zza(1, (zzsu)this.zzaZB);
         }

         if(this.zzaZC != null) {
            var1.zza(2, (zzsu)this.zzaZC);
         }

         if(this.zzaZD != null) {
            var1.zze(3, this.zzaZD.booleanValue());
         }

         if(this.zzaZE != null) {
            var1.zzn(4, this.zzaZE);
         }

         super.writeTo(var1);
      }

      public zzpz.zzc zzDF() {
         this.zzaZB = null;
         this.zzaZC = null;
         this.zzaZD = null;
         this.zzaZE = null;
         this.zzbuu = -1;
         return this;
      }

      public zzpz.zzc zzv(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 10:
               if(this.zzaZB == null) {
                  this.zzaZB = new zzpz.zzf();
               }

               var1.zza(this.zzaZB);
               break;
            case 18:
               if(this.zzaZC == null) {
                  this.zzaZC = new zzpz.zzd();
               }

               var1.zza(this.zzaZC);
               break;
            case 24:
               this.zzaZD = Boolean.valueOf(var1.zzJc());
               break;
            case 34:
               this.zzaZE = var1.readString();
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

      protected int zzz() {
         int var1 = super.zzz();
         if(this.zzaZB != null) {
            var1 += zzsn.zzc(1, this.zzaZB);
         }

         if(this.zzaZC != null) {
            var1 += zzsn.zzc(2, this.zzaZC);
         }

         if(this.zzaZD != null) {
            var1 += zzsn.zzf(3, this.zzaZD.booleanValue());
         }

         if(this.zzaZE != null) {
            var1 += zzsn.zzo(4, this.zzaZE);
         }

         return var1;
      }
   }

   public static final class zzd extends zzsu {
      public Integer zzaZF;
      public Boolean zzaZG;
      public String zzaZH;
      public String zzaZI;
      public String zzaZJ;

      public zzd() {
         this.zzDG();
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzpz.zzd)) {
               return false;
            }

            zzpz.zzd var2 = (zzpz.zzd)var1;
            if(this.zzaZF == null) {
               if(var2.zzaZF != null) {
                  return false;
               }
            } else if(!this.zzaZF.equals(var2.zzaZF)) {
               return false;
            }

            if(this.zzaZG == null) {
               if(var2.zzaZG != null) {
                  return false;
               }
            } else if(!this.zzaZG.equals(var2.zzaZG)) {
               return false;
            }

            if(this.zzaZH == null) {
               if(var2.zzaZH != null) {
                  return false;
               }
            } else if(!this.zzaZH.equals(var2.zzaZH)) {
               return false;
            }

            if(this.zzaZI == null) {
               if(var2.zzaZI != null) {
                  return false;
               }
            } else if(!this.zzaZI.equals(var2.zzaZI)) {
               return false;
            }

            if(this.zzaZJ == null) {
               if(var2.zzaZJ != null) {
                  return false;
               }
            } else if(!this.zzaZJ.equals(var2.zzaZJ)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         int var2;
         if(this.zzaZF == null) {
            var2 = 0;
         } else {
            var2 = this.zzaZF.intValue();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.zzaZG == null) {
            var4 = 0;
         } else {
            var4 = this.zzaZG.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         int var6;
         if(this.zzaZH == null) {
            var6 = 0;
         } else {
            var6 = this.zzaZH.hashCode();
         }

         int var7 = 31 * (var6 + var5);
         int var8;
         if(this.zzaZI == null) {
            var8 = 0;
         } else {
            var8 = this.zzaZI.hashCode();
         }

         int var9 = 31 * (var8 + var7);
         String var10 = this.zzaZJ;
         int var11 = 0;
         if(var10 != null) {
            var11 = this.zzaZJ.hashCode();
         }

         return var9 + var11;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzw(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzaZF != null) {
            var1.zzA(1, this.zzaZF.intValue());
         }

         if(this.zzaZG != null) {
            var1.zze(2, this.zzaZG.booleanValue());
         }

         if(this.zzaZH != null) {
            var1.zzn(3, this.zzaZH);
         }

         if(this.zzaZI != null) {
            var1.zzn(4, this.zzaZI);
         }

         if(this.zzaZJ != null) {
            var1.zzn(5, this.zzaZJ);
         }

         super.writeTo(var1);
      }

      public zzpz.zzd zzDG() {
         this.zzaZF = null;
         this.zzaZG = null;
         this.zzaZH = null;
         this.zzaZI = null;
         this.zzaZJ = null;
         this.zzbuu = -1;
         return this;
      }

      public zzpz.zzd zzw(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 8:
               int var3 = var1.zzJb();
               switch(var3) {
               case 0:
               case 1:
               case 2:
               case 3:
               case 4:
                  this.zzaZF = Integer.valueOf(var3);
               default:
                  continue;
               }
            case 16:
               this.zzaZG = Boolean.valueOf(var1.zzJc());
               break;
            case 26:
               this.zzaZH = var1.readString();
               break;
            case 34:
               this.zzaZI = var1.readString();
               break;
            case 42:
               this.zzaZJ = var1.readString();
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

      protected int zzz() {
         int var1 = super.zzz();
         if(this.zzaZF != null) {
            var1 += zzsn.zzC(1, this.zzaZF.intValue());
         }

         if(this.zzaZG != null) {
            var1 += zzsn.zzf(2, this.zzaZG.booleanValue());
         }

         if(this.zzaZH != null) {
            var1 += zzsn.zzo(3, this.zzaZH);
         }

         if(this.zzaZI != null) {
            var1 += zzsn.zzo(4, this.zzaZI);
         }

         if(this.zzaZJ != null) {
            var1 += zzsn.zzo(5, this.zzaZJ);
         }

         return var1;
      }
   }

   public static final class zze extends zzsu {
      private static volatile zzpz.zze[] zzaZK;
      public String zzaZL;
      public zzpz.zzc zzaZM;
      public Integer zzaZv;

      public zze() {
         this.zzDI();
      }

      public static zzpz.zze[] zzDH() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzpz.zze)) {
               return false;
            }

            zzpz.zze var2 = (zzpz.zze)var1;
            if(this.zzaZv == null) {
               if(var2.zzaZv != null) {
                  return false;
               }
            } else if(!this.zzaZv.equals(var2.zzaZv)) {
               return false;
            }

            if(this.zzaZL == null) {
               if(var2.zzaZL != null) {
                  return false;
               }
            } else if(!this.zzaZL.equals(var2.zzaZL)) {
               return false;
            }

            if(this.zzaZM == null) {
               if(var2.zzaZM != null) {
                  return false;
               }
            } else if(!this.zzaZM.equals(var2.zzaZM)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         int var2;
         if(this.zzaZv == null) {
            var2 = 0;
         } else {
            var2 = this.zzaZv.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.zzaZL == null) {
            var4 = 0;
         } else {
            var4 = this.zzaZL.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         zzpz.zzc var6 = this.zzaZM;
         int var7 = 0;
         if(var6 != null) {
            var7 = this.zzaZM.hashCode();
         }

         return var5 + var7;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzx(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzaZv != null) {
            var1.zzA(1, this.zzaZv.intValue());
         }

         if(this.zzaZL != null) {
            var1.zzn(2, this.zzaZL);
         }

         if(this.zzaZM != null) {
            var1.zza(3, (zzsu)this.zzaZM);
         }

         super.writeTo(var1);
      }

      public zzpz.zze zzDI() {
         this.zzaZv = null;
         this.zzaZL = null;
         this.zzaZM = null;
         this.zzbuu = -1;
         return this;
      }

      public zzpz.zze zzx(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 8:
               this.zzaZv = Integer.valueOf(var1.zzJb());
               break;
            case 18:
               this.zzaZL = var1.readString();
               break;
            case 26:
               if(this.zzaZM == null) {
                  this.zzaZM = new zzpz.zzc();
               }

               var1.zza(this.zzaZM);
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

      protected int zzz() {
         int var1 = super.zzz();
         if(this.zzaZv != null) {
            var1 += zzsn.zzC(1, this.zzaZv.intValue());
         }

         if(this.zzaZL != null) {
            var1 += zzsn.zzo(2, this.zzaZL);
         }

         if(this.zzaZM != null) {
            var1 += zzsn.zzc(3, this.zzaZM);
         }

         return var1;
      }
   }

   public static final class zzf extends zzsu {
      public Integer zzaZN;
      public String zzaZO;
      public Boolean zzaZP;
      public String[] zzaZQ;

      public zzf() {
         this.zzDJ();
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzpz.zzf)) {
               return false;
            }

            zzpz.zzf var2 = (zzpz.zzf)var1;
            if(this.zzaZN == null) {
               if(var2.zzaZN != null) {
                  return false;
               }
            } else if(!this.zzaZN.equals(var2.zzaZN)) {
               return false;
            }

            if(this.zzaZO == null) {
               if(var2.zzaZO != null) {
                  return false;
               }
            } else if(!this.zzaZO.equals(var2.zzaZO)) {
               return false;
            }

            if(this.zzaZP == null) {
               if(var2.zzaZP != null) {
                  return false;
               }
            } else if(!this.zzaZP.equals(var2.zzaZP)) {
               return false;
            }

            if(!zzss.equals((Object[])this.zzaZQ, (Object[])var2.zzaZQ)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         int var2;
         if(this.zzaZN == null) {
            var2 = 0;
         } else {
            var2 = this.zzaZN.intValue();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.zzaZO == null) {
            var4 = 0;
         } else {
            var4 = this.zzaZO.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         Boolean var6 = this.zzaZP;
         int var7 = 0;
         if(var6 != null) {
            var7 = this.zzaZP.hashCode();
         }

         return 31 * (var5 + var7) + zzss.hashCode((Object[])this.zzaZQ);
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzy(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzaZN != null) {
            var1.zzA(1, this.zzaZN.intValue());
         }

         if(this.zzaZO != null) {
            var1.zzn(2, this.zzaZO);
         }

         if(this.zzaZP != null) {
            var1.zze(3, this.zzaZP.booleanValue());
         }

         if(this.zzaZQ != null && this.zzaZQ.length > 0) {
            for(int var2 = 0; var2 < this.zzaZQ.length; ++var2) {
               String var3 = this.zzaZQ[var2];
               if(var3 != null) {
                  var1.zzn(4, var3);
               }
            }
         }

         super.writeTo(var1);
      }

      public zzpz.zzf zzDJ() {
         this.zzaZN = null;
         this.zzaZO = null;
         this.zzaZP = null;
         this.zzaZQ = zzsx.zzbuB;
         this.zzbuu = -1;
         return this;
      }

      public zzpz.zzf zzy(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var4;
            String[] var5;
            switch(var2) {
            case 8:
               int var7 = var1.zzJb();
               switch(var7) {
               case 0:
               case 1:
               case 2:
               case 3:
               case 4:
               case 5:
               case 6:
                  this.zzaZN = Integer.valueOf(var7);
               default:
                  continue;
               }
            case 18:
               this.zzaZO = var1.readString();
               continue;
            case 24:
               this.zzaZP = Boolean.valueOf(var1.zzJc());
               continue;
            case 34:
               int var3 = zzsx.zzc(var1, 34);
               if(this.zzaZQ == null) {
                  var4 = 0;
               } else {
                  var4 = this.zzaZQ.length;
               }

               var5 = new String[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.zzaZQ, 0, var5, 0, var4);
               }
               break;
            default:
               if(zzsx.zzb(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var4 < -1 + var5.length) {
               var5[var4] = var1.readString();
               var1.zzIX();
               ++var4;
            }

            var5[var4] = var1.readString();
            this.zzaZQ = var5;
         }
      }

      protected int zzz() {
         int var1 = 0;
         int var2 = super.zzz();
         if(this.zzaZN != null) {
            var2 += zzsn.zzC(1, this.zzaZN.intValue());
         }

         if(this.zzaZO != null) {
            var2 += zzsn.zzo(2, this.zzaZO);
         }

         if(this.zzaZP != null) {
            var2 += zzsn.zzf(3, this.zzaZP.booleanValue());
         }

         if(this.zzaZQ != null && this.zzaZQ.length > 0) {
            int var3 = 0;

            int var4;
            for(var4 = 0; var1 < this.zzaZQ.length; ++var1) {
               String var5 = this.zzaZQ[var1];
               if(var5 != null) {
                  ++var4;
                  var3 += zzsn.zzgO(var5);
               }
            }

            var2 = var2 + var3 + var4 * 1;
         }

         return var2;
      }
   }
}
