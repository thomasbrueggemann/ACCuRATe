package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzss;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsx;
import java.io.IOException;

public interface zzqb {
   public static final class zza extends zzsu {
      private static volatile zzqb.zza[] zzaZZ;
      public Integer zzaZr;
      public zzqb.zzf zzbaa;
      public zzqb.zzf zzbab;
      public Boolean zzbac;

      public zza() {
         this.zzDQ();
      }

      public static zzqb.zza[] zzDP() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzqb.zza)) {
               return false;
            }

            zzqb.zza var2 = (zzqb.zza)var1;
            if(this.zzaZr == null) {
               if(var2.zzaZr != null) {
                  return false;
               }
            } else if(!this.zzaZr.equals(var2.zzaZr)) {
               return false;
            }

            if(this.zzbaa == null) {
               if(var2.zzbaa != null) {
                  return false;
               }
            } else if(!this.zzbaa.equals(var2.zzbaa)) {
               return false;
            }

            if(this.zzbab == null) {
               if(var2.zzbab != null) {
                  return false;
               }
            } else if(!this.zzbab.equals(var2.zzbab)) {
               return false;
            }

            if(this.zzbac == null) {
               if(var2.zzbac != null) {
                  return false;
               }
            } else if(!this.zzbac.equals(var2.zzbac)) {
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

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.zzbaa == null) {
            var4 = 0;
         } else {
            var4 = this.zzbaa.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         int var6;
         if(this.zzbab == null) {
            var6 = 0;
         } else {
            var6 = this.zzbab.hashCode();
         }

         int var7 = 31 * (var6 + var5);
         Boolean var8 = this.zzbac;
         int var9 = 0;
         if(var8 != null) {
            var9 = this.zzbac.hashCode();
         }

         return var7 + var9;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzC(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzaZr != null) {
            var1.zzA(1, this.zzaZr.intValue());
         }

         if(this.zzbaa != null) {
            var1.zza(2, (zzsu)this.zzbaa);
         }

         if(this.zzbab != null) {
            var1.zza(3, (zzsu)this.zzbab);
         }

         if(this.zzbac != null) {
            var1.zze(4, this.zzbac.booleanValue());
         }

         super.writeTo(var1);
      }

      public zzqb.zza zzC(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 8:
               this.zzaZr = Integer.valueOf(var1.zzJb());
               break;
            case 18:
               if(this.zzbaa == null) {
                  this.zzbaa = new zzqb.zzf();
               }

               var1.zza(this.zzbaa);
               break;
            case 26:
               if(this.zzbab == null) {
                  this.zzbab = new zzqb.zzf();
               }

               var1.zza(this.zzbab);
               break;
            case 32:
               this.zzbac = Boolean.valueOf(var1.zzJc());
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

      public zzqb.zza zzDQ() {
         this.zzaZr = null;
         this.zzbaa = null;
         this.zzbab = null;
         this.zzbac = null;
         this.zzbuu = -1;
         return this;
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(this.zzaZr != null) {
            var1 += zzsn.zzC(1, this.zzaZr.intValue());
         }

         if(this.zzbaa != null) {
            var1 += zzsn.zzc(2, this.zzbaa);
         }

         if(this.zzbab != null) {
            var1 += zzsn.zzc(3, this.zzbab);
         }

         if(this.zzbac != null) {
            var1 += zzsn.zzf(4, this.zzbac.booleanValue());
         }

         return var1;
      }
   }

   public static final class zzb extends zzsu {
      private static volatile zzqb.zzb[] zzbad;
      public Integer count;
      public String name;
      public zzqb.zzc[] zzbae;
      public Long zzbaf;
      public Long zzbag;

      public zzb() {
         this.zzDS();
      }

      public static zzqb.zzb[] zzDR() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzqb.zzb)) {
               return false;
            }

            zzqb.zzb var2 = (zzqb.zzb)var1;
            if(!zzss.equals((Object[])this.zzbae, (Object[])var2.zzbae)) {
               return false;
            }

            if(this.name == null) {
               if(var2.name != null) {
                  return false;
               }
            } else if(!this.name.equals(var2.name)) {
               return false;
            }

            if(this.zzbaf == null) {
               if(var2.zzbaf != null) {
                  return false;
               }
            } else if(!this.zzbaf.equals(var2.zzbaf)) {
               return false;
            }

            if(this.zzbag == null) {
               if(var2.zzbag != null) {
                  return false;
               }
            } else if(!this.zzbag.equals(var2.zzbag)) {
               return false;
            }

            if(this.count == null) {
               if(var2.count != null) {
                  return false;
               }
            } else if(!this.count.equals(var2.count)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         int var1 = 31 * (31 * (527 + this.getClass().getName().hashCode()) + zzss.hashCode((Object[])this.zzbae));
         int var2;
         if(this.name == null) {
            var2 = 0;
         } else {
            var2 = this.name.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.zzbaf == null) {
            var4 = 0;
         } else {
            var4 = this.zzbaf.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         int var6;
         if(this.zzbag == null) {
            var6 = 0;
         } else {
            var6 = this.zzbag.hashCode();
         }

         int var7 = 31 * (var6 + var5);
         Integer var8 = this.count;
         int var9 = 0;
         if(var8 != null) {
            var9 = this.count.hashCode();
         }

         return var7 + var9;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzD(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzbae != null && this.zzbae.length > 0) {
            for(int var2 = 0; var2 < this.zzbae.length; ++var2) {
               zzqb.zzc var3 = this.zzbae[var2];
               if(var3 != null) {
                  var1.zza(1, (zzsu)var3);
               }
            }
         }

         if(this.name != null) {
            var1.zzn(2, this.name);
         }

         if(this.zzbaf != null) {
            var1.zzb(3, this.zzbaf.longValue());
         }

         if(this.zzbag != null) {
            var1.zzb(4, this.zzbag.longValue());
         }

         if(this.count != null) {
            var1.zzA(5, this.count.intValue());
         }

         super.writeTo(var1);
      }

      public zzqb.zzb zzD(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var4;
            zzqb.zzc[] var5;
            switch(var2) {
            case 10:
               int var3 = zzsx.zzc(var1, 10);
               if(this.zzbae == null) {
                  var4 = 0;
               } else {
                  var4 = this.zzbae.length;
               }

               var5 = new zzqb.zzc[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.zzbae, 0, var5, 0, var4);
               }
               break;
            case 18:
               this.name = var1.readString();
               continue;
            case 24:
               this.zzbaf = Long.valueOf(var1.zzJa());
               continue;
            case 32:
               this.zzbag = Long.valueOf(var1.zzJa());
               continue;
            case 40:
               this.count = Integer.valueOf(var1.zzJb());
               continue;
            default:
               if(zzsx.zzb(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var4 < -1 + var5.length) {
               var5[var4] = new zzqb.zzc();
               var1.zza(var5[var4]);
               var1.zzIX();
               ++var4;
            }

            var5[var4] = new zzqb.zzc();
            var1.zza(var5[var4]);
            this.zzbae = var5;
         }
      }

      public zzqb.zzb zzDS() {
         this.zzbae = zzqb.zzc.zzDT();
         this.name = null;
         this.zzbaf = null;
         this.zzbag = null;
         this.count = null;
         this.zzbuu = -1;
         return this;
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(this.zzbae != null && this.zzbae.length > 0) {
            for(int var2 = 0; var2 < this.zzbae.length; ++var2) {
               zzqb.zzc var3 = this.zzbae[var2];
               if(var3 != null) {
                  var1 += zzsn.zzc(1, var3);
               }
            }
         }

         if(this.name != null) {
            var1 += zzsn.zzo(2, this.name);
         }

         if(this.zzbaf != null) {
            var1 += zzsn.zzd(3, this.zzbaf.longValue());
         }

         if(this.zzbag != null) {
            var1 += zzsn.zzd(4, this.zzbag.longValue());
         }

         if(this.count != null) {
            var1 += zzsn.zzC(5, this.count.intValue());
         }

         return var1;
      }
   }

   public static final class zzc extends zzsu {
      private static volatile zzqb.zzc[] zzbah;
      public String name;
      public Float zzaZo;
      public String zzamJ;
      public Long zzbai;

      public zzc() {
         this.zzDU();
      }

      public static zzqb.zzc[] zzDT() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzqb.zzc)) {
               return false;
            }

            zzqb.zzc var2 = (zzqb.zzc)var1;
            if(this.name == null) {
               if(var2.name != null) {
                  return false;
               }
            } else if(!this.name.equals(var2.name)) {
               return false;
            }

            if(this.zzamJ == null) {
               if(var2.zzamJ != null) {
                  return false;
               }
            } else if(!this.zzamJ.equals(var2.zzamJ)) {
               return false;
            }

            if(this.zzbai == null) {
               if(var2.zzbai != null) {
                  return false;
               }
            } else if(!this.zzbai.equals(var2.zzbai)) {
               return false;
            }

            if(this.zzaZo == null) {
               if(var2.zzaZo != null) {
                  return false;
               }
            } else if(!this.zzaZo.equals(var2.zzaZo)) {
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
         int var4;
         if(this.zzamJ == null) {
            var4 = 0;
         } else {
            var4 = this.zzamJ.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         int var6;
         if(this.zzbai == null) {
            var6 = 0;
         } else {
            var6 = this.zzbai.hashCode();
         }

         int var7 = 31 * (var6 + var5);
         Float var8 = this.zzaZo;
         int var9 = 0;
         if(var8 != null) {
            var9 = this.zzaZo.hashCode();
         }

         return var7 + var9;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzE(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.name != null) {
            var1.zzn(1, this.name);
         }

         if(this.zzamJ != null) {
            var1.zzn(2, this.zzamJ);
         }

         if(this.zzbai != null) {
            var1.zzb(3, this.zzbai.longValue());
         }

         if(this.zzaZo != null) {
            var1.zzb(4, this.zzaZo.floatValue());
         }

         super.writeTo(var1);
      }

      public zzqb.zzc zzDU() {
         this.name = null;
         this.zzamJ = null;
         this.zzbai = null;
         this.zzaZo = null;
         this.zzbuu = -1;
         return this;
      }

      public zzqb.zzc zzE(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 10:
               this.name = var1.readString();
               break;
            case 18:
               this.zzamJ = var1.readString();
               break;
            case 24:
               this.zzbai = Long.valueOf(var1.zzJa());
               break;
            case 37:
               this.zzaZo = Float.valueOf(var1.readFloat());
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
         if(this.name != null) {
            var1 += zzsn.zzo(1, this.name);
         }

         if(this.zzamJ != null) {
            var1 += zzsn.zzo(2, this.zzamJ);
         }

         if(this.zzbai != null) {
            var1 += zzsn.zzd(3, this.zzbai.longValue());
         }

         if(this.zzaZo != null) {
            var1 += zzsn.zzc(4, this.zzaZo.floatValue());
         }

         return var1;
      }
   }

   public static final class zzd extends zzsu {
      public zzqb.zze[] zzbaj;

      public zzd() {
         this.zzDV();
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzqb.zzd)) {
               return false;
            }

            zzqb.zzd var2 = (zzqb.zzd)var1;
            if(!zzss.equals((Object[])this.zzbaj, (Object[])var2.zzbaj)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         return 31 * (527 + this.getClass().getName().hashCode()) + zzss.hashCode((Object[])this.zzbaj);
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzF(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzbaj != null && this.zzbaj.length > 0) {
            for(int var2 = 0; var2 < this.zzbaj.length; ++var2) {
               zzqb.zze var3 = this.zzbaj[var2];
               if(var3 != null) {
                  var1.zza(1, (zzsu)var3);
               }
            }
         }

         super.writeTo(var1);
      }

      public zzqb.zzd zzDV() {
         this.zzbaj = zzqb.zze.zzDW();
         this.zzbuu = -1;
         return this;
      }

      public zzqb.zzd zzF(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var4;
            zzqb.zze[] var5;
            switch(var2) {
            case 10:
               int var3 = zzsx.zzc(var1, 10);
               if(this.zzbaj == null) {
                  var4 = 0;
               } else {
                  var4 = this.zzbaj.length;
               }

               var5 = new zzqb.zze[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.zzbaj, 0, var5, 0, var4);
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
               var5[var4] = new zzqb.zze();
               var1.zza(var5[var4]);
               var1.zzIX();
               ++var4;
            }

            var5[var4] = new zzqb.zze();
            var1.zza(var5[var4]);
            this.zzbaj = var5;
         }
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(this.zzbaj != null && this.zzbaj.length > 0) {
            for(int var2 = 0; var2 < this.zzbaj.length; ++var2) {
               zzqb.zze var3 = this.zzbaj[var2];
               if(var3 != null) {
                  var1 += zzsn.zzc(1, var3);
               }
            }
         }

         return var1;
      }
   }

   public static final class zze extends zzsu {
      private static volatile zzqb.zze[] zzbak;
      public String appId;
      public String osVersion;
      public String zzaMV;
      public String zzaVt;
      public String zzaVu;
      public String zzaVx;
      public Boolean zzbaA;
      public String zzbaB;
      public Long zzbaC;
      public Integer zzbaD;
      public Boolean zzbaE;
      public zzqb.zza[] zzbaF;
      public Integer zzbal;
      public zzqb.zzb[] zzbam;
      public zzqb.zzg[] zzban;
      public Long zzbao;
      public Long zzbap;
      public Long zzbaq;
      public Long zzbar;
      public Long zzbas;
      public String zzbat;
      public String zzbau;
      public String zzbav;
      public Integer zzbaw;
      public Long zzbax;
      public Long zzbay;
      public String zzbaz;

      public zze() {
         this.zzDX();
      }

      public static zzqb.zze[] zzDW() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzqb.zze)) {
               return false;
            }

            zzqb.zze var2 = (zzqb.zze)var1;
            if(this.zzbal == null) {
               if(var2.zzbal != null) {
                  return false;
               }
            } else if(!this.zzbal.equals(var2.zzbal)) {
               return false;
            }

            if(!zzss.equals((Object[])this.zzbam, (Object[])var2.zzbam)) {
               return false;
            }

            if(!zzss.equals((Object[])this.zzban, (Object[])var2.zzban)) {
               return false;
            }

            if(this.zzbao == null) {
               if(var2.zzbao != null) {
                  return false;
               }
            } else if(!this.zzbao.equals(var2.zzbao)) {
               return false;
            }

            if(this.zzbap == null) {
               if(var2.zzbap != null) {
                  return false;
               }
            } else if(!this.zzbap.equals(var2.zzbap)) {
               return false;
            }

            if(this.zzbaq == null) {
               if(var2.zzbaq != null) {
                  return false;
               }
            } else if(!this.zzbaq.equals(var2.zzbaq)) {
               return false;
            }

            if(this.zzbar == null) {
               if(var2.zzbar != null) {
                  return false;
               }
            } else if(!this.zzbar.equals(var2.zzbar)) {
               return false;
            }

            if(this.zzbas == null) {
               if(var2.zzbas != null) {
                  return false;
               }
            } else if(!this.zzbas.equals(var2.zzbas)) {
               return false;
            }

            if(this.zzbat == null) {
               if(var2.zzbat != null) {
                  return false;
               }
            } else if(!this.zzbat.equals(var2.zzbat)) {
               return false;
            }

            if(this.osVersion == null) {
               if(var2.osVersion != null) {
                  return false;
               }
            } else if(!this.osVersion.equals(var2.osVersion)) {
               return false;
            }

            if(this.zzbau == null) {
               if(var2.zzbau != null) {
                  return false;
               }
            } else if(!this.zzbau.equals(var2.zzbau)) {
               return false;
            }

            if(this.zzbav == null) {
               if(var2.zzbav != null) {
                  return false;
               }
            } else if(!this.zzbav.equals(var2.zzbav)) {
               return false;
            }

            if(this.zzbaw == null) {
               if(var2.zzbaw != null) {
                  return false;
               }
            } else if(!this.zzbaw.equals(var2.zzbaw)) {
               return false;
            }

            if(this.zzaVu == null) {
               if(var2.zzaVu != null) {
                  return false;
               }
            } else if(!this.zzaVu.equals(var2.zzaVu)) {
               return false;
            }

            if(this.appId == null) {
               if(var2.appId != null) {
                  return false;
               }
            } else if(!this.appId.equals(var2.appId)) {
               return false;
            }

            if(this.zzaMV == null) {
               if(var2.zzaMV != null) {
                  return false;
               }
            } else if(!this.zzaMV.equals(var2.zzaMV)) {
               return false;
            }

            if(this.zzbax == null) {
               if(var2.zzbax != null) {
                  return false;
               }
            } else if(!this.zzbax.equals(var2.zzbax)) {
               return false;
            }

            if(this.zzbay == null) {
               if(var2.zzbay != null) {
                  return false;
               }
            } else if(!this.zzbay.equals(var2.zzbay)) {
               return false;
            }

            if(this.zzbaz == null) {
               if(var2.zzbaz != null) {
                  return false;
               }
            } else if(!this.zzbaz.equals(var2.zzbaz)) {
               return false;
            }

            if(this.zzbaA == null) {
               if(var2.zzbaA != null) {
                  return false;
               }
            } else if(!this.zzbaA.equals(var2.zzbaA)) {
               return false;
            }

            if(this.zzbaB == null) {
               if(var2.zzbaB != null) {
                  return false;
               }
            } else if(!this.zzbaB.equals(var2.zzbaB)) {
               return false;
            }

            if(this.zzbaC == null) {
               if(var2.zzbaC != null) {
                  return false;
               }
            } else if(!this.zzbaC.equals(var2.zzbaC)) {
               return false;
            }

            if(this.zzbaD == null) {
               if(var2.zzbaD != null) {
                  return false;
               }
            } else if(!this.zzbaD.equals(var2.zzbaD)) {
               return false;
            }

            if(this.zzaVx == null) {
               if(var2.zzaVx != null) {
                  return false;
               }
            } else if(!this.zzaVx.equals(var2.zzaVx)) {
               return false;
            }

            if(this.zzaVt == null) {
               if(var2.zzaVt != null) {
                  return false;
               }
            } else if(!this.zzaVt.equals(var2.zzaVt)) {
               return false;
            }

            if(this.zzbaE == null) {
               if(var2.zzbaE != null) {
                  return false;
               }
            } else if(!this.zzbaE.equals(var2.zzbaE)) {
               return false;
            }

            if(!zzss.equals((Object[])this.zzbaF, (Object[])var2.zzbaF)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         int var2;
         if(this.zzbal == null) {
            var2 = 0;
         } else {
            var2 = this.zzbal.hashCode();
         }

         int var3 = 31 * (31 * (31 * (var2 + var1) + zzss.hashCode((Object[])this.zzbam)) + zzss.hashCode((Object[])this.zzban));
         int var4;
         if(this.zzbao == null) {
            var4 = 0;
         } else {
            var4 = this.zzbao.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         int var6;
         if(this.zzbap == null) {
            var6 = 0;
         } else {
            var6 = this.zzbap.hashCode();
         }

         int var7 = 31 * (var6 + var5);
         int var8;
         if(this.zzbaq == null) {
            var8 = 0;
         } else {
            var8 = this.zzbaq.hashCode();
         }

         int var9 = 31 * (var8 + var7);
         int var10;
         if(this.zzbar == null) {
            var10 = 0;
         } else {
            var10 = this.zzbar.hashCode();
         }

         int var11 = 31 * (var10 + var9);
         int var12;
         if(this.zzbas == null) {
            var12 = 0;
         } else {
            var12 = this.zzbas.hashCode();
         }

         int var13 = 31 * (var12 + var11);
         int var14;
         if(this.zzbat == null) {
            var14 = 0;
         } else {
            var14 = this.zzbat.hashCode();
         }

         int var15 = 31 * (var14 + var13);
         int var16;
         if(this.osVersion == null) {
            var16 = 0;
         } else {
            var16 = this.osVersion.hashCode();
         }

         int var17 = 31 * (var16 + var15);
         int var18;
         if(this.zzbau == null) {
            var18 = 0;
         } else {
            var18 = this.zzbau.hashCode();
         }

         int var19 = 31 * (var18 + var17);
         int var20;
         if(this.zzbav == null) {
            var20 = 0;
         } else {
            var20 = this.zzbav.hashCode();
         }

         int var21 = 31 * (var20 + var19);
         int var22;
         if(this.zzbaw == null) {
            var22 = 0;
         } else {
            var22 = this.zzbaw.hashCode();
         }

         int var23 = 31 * (var22 + var21);
         int var24;
         if(this.zzaVu == null) {
            var24 = 0;
         } else {
            var24 = this.zzaVu.hashCode();
         }

         int var25 = 31 * (var24 + var23);
         int var26;
         if(this.appId == null) {
            var26 = 0;
         } else {
            var26 = this.appId.hashCode();
         }

         int var27 = 31 * (var26 + var25);
         int var28;
         if(this.zzaMV == null) {
            var28 = 0;
         } else {
            var28 = this.zzaMV.hashCode();
         }

         int var29 = 31 * (var28 + var27);
         int var30;
         if(this.zzbax == null) {
            var30 = 0;
         } else {
            var30 = this.zzbax.hashCode();
         }

         int var31 = 31 * (var30 + var29);
         int var32;
         if(this.zzbay == null) {
            var32 = 0;
         } else {
            var32 = this.zzbay.hashCode();
         }

         int var33 = 31 * (var32 + var31);
         int var34;
         if(this.zzbaz == null) {
            var34 = 0;
         } else {
            var34 = this.zzbaz.hashCode();
         }

         int var35 = 31 * (var34 + var33);
         int var36;
         if(this.zzbaA == null) {
            var36 = 0;
         } else {
            var36 = this.zzbaA.hashCode();
         }

         int var37 = 31 * (var36 + var35);
         int var38;
         if(this.zzbaB == null) {
            var38 = 0;
         } else {
            var38 = this.zzbaB.hashCode();
         }

         int var39 = 31 * (var38 + var37);
         int var40;
         if(this.zzbaC == null) {
            var40 = 0;
         } else {
            var40 = this.zzbaC.hashCode();
         }

         int var41 = 31 * (var40 + var39);
         int var42;
         if(this.zzbaD == null) {
            var42 = 0;
         } else {
            var42 = this.zzbaD.hashCode();
         }

         int var43 = 31 * (var42 + var41);
         int var44;
         if(this.zzaVx == null) {
            var44 = 0;
         } else {
            var44 = this.zzaVx.hashCode();
         }

         int var45 = 31 * (var44 + var43);
         int var46;
         if(this.zzaVt == null) {
            var46 = 0;
         } else {
            var46 = this.zzaVt.hashCode();
         }

         int var47 = 31 * (var46 + var45);
         Boolean var48 = this.zzbaE;
         int var49 = 0;
         if(var48 != null) {
            var49 = this.zzbaE.hashCode();
         }

         return 31 * (var47 + var49) + zzss.hashCode((Object[])this.zzbaF);
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzG(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzbal != null) {
            var1.zzA(1, this.zzbal.intValue());
         }

         if(this.zzbam != null && this.zzbam.length > 0) {
            for(int var7 = 0; var7 < this.zzbam.length; ++var7) {
               zzqb.zzb var8 = this.zzbam[var7];
               if(var8 != null) {
                  var1.zza(2, (zzsu)var8);
               }
            }
         }

         if(this.zzban != null && this.zzban.length > 0) {
            for(int var5 = 0; var5 < this.zzban.length; ++var5) {
               zzqb.zzg var6 = this.zzban[var5];
               if(var6 != null) {
                  var1.zza(3, (zzsu)var6);
               }
            }
         }

         if(this.zzbao != null) {
            var1.zzb(4, this.zzbao.longValue());
         }

         if(this.zzbap != null) {
            var1.zzb(5, this.zzbap.longValue());
         }

         if(this.zzbaq != null) {
            var1.zzb(6, this.zzbaq.longValue());
         }

         if(this.zzbas != null) {
            var1.zzb(7, this.zzbas.longValue());
         }

         if(this.zzbat != null) {
            var1.zzn(8, this.zzbat);
         }

         if(this.osVersion != null) {
            var1.zzn(9, this.osVersion);
         }

         if(this.zzbau != null) {
            var1.zzn(10, this.zzbau);
         }

         if(this.zzbav != null) {
            var1.zzn(11, this.zzbav);
         }

         if(this.zzbaw != null) {
            var1.zzA(12, this.zzbaw.intValue());
         }

         if(this.zzaVu != null) {
            var1.zzn(13, this.zzaVu);
         }

         if(this.appId != null) {
            var1.zzn(14, this.appId);
         }

         if(this.zzaMV != null) {
            var1.zzn(16, this.zzaMV);
         }

         if(this.zzbax != null) {
            var1.zzb(17, this.zzbax.longValue());
         }

         if(this.zzbay != null) {
            var1.zzb(18, this.zzbay.longValue());
         }

         if(this.zzbaz != null) {
            var1.zzn(19, this.zzbaz);
         }

         if(this.zzbaA != null) {
            var1.zze(20, this.zzbaA.booleanValue());
         }

         if(this.zzbaB != null) {
            var1.zzn(21, this.zzbaB);
         }

         if(this.zzbaC != null) {
            var1.zzb(22, this.zzbaC.longValue());
         }

         if(this.zzbaD != null) {
            var1.zzA(23, this.zzbaD.intValue());
         }

         if(this.zzaVx != null) {
            var1.zzn(24, this.zzaVx);
         }

         if(this.zzaVt != null) {
            var1.zzn(25, this.zzaVt);
         }

         if(this.zzbar != null) {
            var1.zzb(26, this.zzbar.longValue());
         }

         if(this.zzbaE != null) {
            var1.zze(28, this.zzbaE.booleanValue());
         }

         if(this.zzbaF != null) {
            int var2 = this.zzbaF.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.zzbaF.length; ++var3) {
                  zzqb.zza var4 = this.zzbaF[var3];
                  if(var4 != null) {
                     var1.zza(29, (zzsu)var4);
                  }
               }
            }
         }

         super.writeTo(var1);
      }

      public zzqb.zze zzDX() {
         this.zzbal = null;
         this.zzbam = zzqb.zzb.zzDR();
         this.zzban = zzqb.zzg.zzDZ();
         this.zzbao = null;
         this.zzbap = null;
         this.zzbaq = null;
         this.zzbar = null;
         this.zzbas = null;
         this.zzbat = null;
         this.osVersion = null;
         this.zzbau = null;
         this.zzbav = null;
         this.zzbaw = null;
         this.zzaVu = null;
         this.appId = null;
         this.zzaMV = null;
         this.zzbax = null;
         this.zzbay = null;
         this.zzbaz = null;
         this.zzbaA = null;
         this.zzbaB = null;
         this.zzbaC = null;
         this.zzbaD = null;
         this.zzaVx = null;
         this.zzaVt = null;
         this.zzbaE = null;
         this.zzbaF = zzqb.zza.zzDP();
         this.zzbuu = -1;
         return this;
      }

      public zzqb.zze zzG(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var12;
            zzqb.zzb[] var13;
            switch(var2) {
            case 8:
               this.zzbal = Integer.valueOf(var1.zzJb());
               continue;
            case 18:
               int var11 = zzsx.zzc(var1, 18);
               if(this.zzbam == null) {
                  var12 = 0;
               } else {
                  var12 = this.zzbam.length;
               }

               var13 = new zzqb.zzb[var11 + var12];
               if(var12 != 0) {
                  System.arraycopy(this.zzbam, 0, var13, 0, var12);
               }
               break;
            case 26:
               int var7 = zzsx.zzc(var1, 26);
               int var8;
               if(this.zzban == null) {
                  var8 = 0;
               } else {
                  var8 = this.zzban.length;
               }

               zzqb.zzg[] var9 = new zzqb.zzg[var7 + var8];
               if(var8 != 0) {
                  System.arraycopy(this.zzban, 0, var9, 0, var8);
               }

               while(var8 < -1 + var9.length) {
                  var9[var8] = new zzqb.zzg();
                  var1.zza(var9[var8]);
                  var1.zzIX();
                  ++var8;
               }

               var9[var8] = new zzqb.zzg();
               var1.zza(var9[var8]);
               this.zzban = var9;
               continue;
            case 32:
               this.zzbao = Long.valueOf(var1.zzJa());
               continue;
            case 40:
               this.zzbap = Long.valueOf(var1.zzJa());
               continue;
            case 48:
               this.zzbaq = Long.valueOf(var1.zzJa());
               continue;
            case 56:
               this.zzbas = Long.valueOf(var1.zzJa());
               continue;
            case 66:
               this.zzbat = var1.readString();
               continue;
            case 74:
               this.osVersion = var1.readString();
               continue;
            case 82:
               this.zzbau = var1.readString();
               continue;
            case 90:
               this.zzbav = var1.readString();
               continue;
            case 96:
               this.zzbaw = Integer.valueOf(var1.zzJb());
               continue;
            case 106:
               this.zzaVu = var1.readString();
               continue;
            case 114:
               this.appId = var1.readString();
               continue;
            case 130:
               this.zzaMV = var1.readString();
               continue;
            case 136:
               this.zzbax = Long.valueOf(var1.zzJa());
               continue;
            case 144:
               this.zzbay = Long.valueOf(var1.zzJa());
               continue;
            case 154:
               this.zzbaz = var1.readString();
               continue;
            case 160:
               this.zzbaA = Boolean.valueOf(var1.zzJc());
               continue;
            case 170:
               this.zzbaB = var1.readString();
               continue;
            case 176:
               this.zzbaC = Long.valueOf(var1.zzJa());
               continue;
            case 184:
               this.zzbaD = Integer.valueOf(var1.zzJb());
               continue;
            case 194:
               this.zzaVx = var1.readString();
               continue;
            case 202:
               this.zzaVt = var1.readString();
               continue;
            case 208:
               this.zzbar = Long.valueOf(var1.zzJa());
               continue;
            case 224:
               this.zzbaE = Boolean.valueOf(var1.zzJc());
               continue;
            case 234:
               int var3 = zzsx.zzc(var1, 234);
               int var4;
               if(this.zzbaF == null) {
                  var4 = 0;
               } else {
                  var4 = this.zzbaF.length;
               }

               zzqb.zza[] var5 = new zzqb.zza[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.zzbaF, 0, var5, 0, var4);
               }

               while(var4 < -1 + var5.length) {
                  var5[var4] = new zzqb.zza();
                  var1.zza(var5[var4]);
                  var1.zzIX();
                  ++var4;
               }

               var5[var4] = new zzqb.zza();
               var1.zza(var5[var4]);
               this.zzbaF = var5;
               continue;
            default:
               if(zzsx.zzb(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var12 < -1 + var13.length) {
               var13[var12] = new zzqb.zzb();
               var1.zza(var13[var12]);
               var1.zzIX();
               ++var12;
            }

            var13[var12] = new zzqb.zzb();
            var1.zza(var13[var12]);
            this.zzbam = var13;
         }
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(this.zzbal != null) {
            var1 += zzsn.zzC(1, this.zzbal.intValue());
         }

         if(this.zzbam != null && this.zzbam.length > 0) {
            int var8 = var1;

            for(int var9 = 0; var9 < this.zzbam.length; ++var9) {
               zzqb.zzb var10 = this.zzbam[var9];
               if(var10 != null) {
                  var8 += zzsn.zzc(2, var10);
               }
            }

            var1 = var8;
         }

         if(this.zzban != null && this.zzban.length > 0) {
            int var5 = var1;

            for(int var6 = 0; var6 < this.zzban.length; ++var6) {
               zzqb.zzg var7 = this.zzban[var6];
               if(var7 != null) {
                  var5 += zzsn.zzc(3, var7);
               }
            }

            var1 = var5;
         }

         if(this.zzbao != null) {
            var1 += zzsn.zzd(4, this.zzbao.longValue());
         }

         if(this.zzbap != null) {
            var1 += zzsn.zzd(5, this.zzbap.longValue());
         }

         if(this.zzbaq != null) {
            var1 += zzsn.zzd(6, this.zzbaq.longValue());
         }

         if(this.zzbas != null) {
            var1 += zzsn.zzd(7, this.zzbas.longValue());
         }

         if(this.zzbat != null) {
            var1 += zzsn.zzo(8, this.zzbat);
         }

         if(this.osVersion != null) {
            var1 += zzsn.zzo(9, this.osVersion);
         }

         if(this.zzbau != null) {
            var1 += zzsn.zzo(10, this.zzbau);
         }

         if(this.zzbav != null) {
            var1 += zzsn.zzo(11, this.zzbav);
         }

         if(this.zzbaw != null) {
            var1 += zzsn.zzC(12, this.zzbaw.intValue());
         }

         if(this.zzaVu != null) {
            var1 += zzsn.zzo(13, this.zzaVu);
         }

         if(this.appId != null) {
            var1 += zzsn.zzo(14, this.appId);
         }

         if(this.zzaMV != null) {
            var1 += zzsn.zzo(16, this.zzaMV);
         }

         if(this.zzbax != null) {
            var1 += zzsn.zzd(17, this.zzbax.longValue());
         }

         if(this.zzbay != null) {
            var1 += zzsn.zzd(18, this.zzbay.longValue());
         }

         if(this.zzbaz != null) {
            var1 += zzsn.zzo(19, this.zzbaz);
         }

         if(this.zzbaA != null) {
            var1 += zzsn.zzf(20, this.zzbaA.booleanValue());
         }

         if(this.zzbaB != null) {
            var1 += zzsn.zzo(21, this.zzbaB);
         }

         if(this.zzbaC != null) {
            var1 += zzsn.zzd(22, this.zzbaC.longValue());
         }

         if(this.zzbaD != null) {
            var1 += zzsn.zzC(23, this.zzbaD.intValue());
         }

         if(this.zzaVx != null) {
            var1 += zzsn.zzo(24, this.zzaVx);
         }

         if(this.zzaVt != null) {
            var1 += zzsn.zzo(25, this.zzaVt);
         }

         if(this.zzbar != null) {
            var1 += zzsn.zzd(26, this.zzbar.longValue());
         }

         if(this.zzbaE != null) {
            var1 += zzsn.zzf(28, this.zzbaE.booleanValue());
         }

         if(this.zzbaF != null) {
            int var2 = this.zzbaF.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.zzbaF.length; ++var3) {
                  zzqb.zza var4 = this.zzbaF[var3];
                  if(var4 != null) {
                     var1 += zzsn.zzc(29, var4);
                  }
               }
            }
         }

         return var1;
      }
   }

   public static final class zzf extends zzsu {
      public long[] zzbaG;
      public long[] zzbaH;

      public zzf() {
         this.zzDY();
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzqb.zzf)) {
               return false;
            }

            zzqb.zzf var2 = (zzqb.zzf)var1;
            if(!zzss.equals(this.zzbaG, var2.zzbaG)) {
               return false;
            }

            if(!zzss.equals(this.zzbaH, var2.zzbaH)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         return 31 * (31 * (527 + this.getClass().getName().hashCode()) + zzss.hashCode(this.zzbaG)) + zzss.hashCode(this.zzbaH);
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzH(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzbaG != null && this.zzbaG.length > 0) {
            for(int var4 = 0; var4 < this.zzbaG.length; ++var4) {
               var1.zza(1, this.zzbaG[var4]);
            }
         }

         if(this.zzbaH != null) {
            int var2 = this.zzbaH.length;
            int var3 = 0;
            if(var2 > 0) {
               while(var3 < this.zzbaH.length) {
                  var1.zza(2, this.zzbaH[var3]);
                  ++var3;
               }
            }
         }

         super.writeTo(var1);
      }

      public zzqb.zzf zzDY() {
         this.zzbaG = zzsx.zzbux;
         this.zzbaH = zzsx.zzbux;
         this.zzbuu = -1;
         return this;
      }

      public zzqb.zzf zzH(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            long[] var23;
            int var22;
            switch(var2) {
            case 8:
               int var21 = zzsx.zzc(var1, 8);
               if(this.zzbaG == null) {
                  var22 = 0;
               } else {
                  var22 = this.zzbaG.length;
               }

               var23 = new long[var21 + var22];
               if(var22 != 0) {
                  System.arraycopy(this.zzbaG, 0, var23, 0, var22);
               }
               break;
            case 10:
               int var14 = var1.zzmq(var1.zzJf());
               int var15 = var1.getPosition();

               int var16;
               for(var16 = 0; var1.zzJk() > 0; ++var16) {
                  var1.zzIZ();
               }

               var1.zzms(var15);
               int var17;
               if(this.zzbaG == null) {
                  var17 = 0;
               } else {
                  var17 = this.zzbaG.length;
               }

               long[] var18 = new long[var16 + var17];
               if(var17 != 0) {
                  System.arraycopy(this.zzbaG, 0, var18, 0, var17);
               }

               while(var17 < var18.length) {
                  var18[var17] = var1.zzIZ();
                  ++var17;
               }

               this.zzbaG = var18;
               var1.zzmr(var14);
               continue;
            case 16:
               int var10 = zzsx.zzc(var1, 16);
               int var11;
               if(this.zzbaH == null) {
                  var11 = 0;
               } else {
                  var11 = this.zzbaH.length;
               }

               long[] var12 = new long[var10 + var11];
               if(var11 != 0) {
                  System.arraycopy(this.zzbaH, 0, var12, 0, var11);
               }

               while(var11 < -1 + var12.length) {
                  var12[var11] = var1.zzIZ();
                  var1.zzIX();
                  ++var11;
               }

               var12[var11] = var1.zzIZ();
               this.zzbaH = var12;
               continue;
            case 18:
               int var3 = var1.zzmq(var1.zzJf());
               int var4 = var1.getPosition();

               int var5;
               for(var5 = 0; var1.zzJk() > 0; ++var5) {
                  var1.zzIZ();
               }

               var1.zzms(var4);
               int var6;
               if(this.zzbaH == null) {
                  var6 = 0;
               } else {
                  var6 = this.zzbaH.length;
               }

               long[] var7 = new long[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.zzbaH, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.zzIZ();
                  ++var6;
               }

               this.zzbaH = var7;
               var1.zzmr(var3);
               continue;
            default:
               if(zzsx.zzb(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var22 < -1 + var23.length) {
               var23[var22] = var1.zzIZ();
               var1.zzIX();
               ++var22;
            }

            var23[var22] = var1.zzIZ();
            this.zzbaG = var23;
         }
      }

      protected int zzz() {
         int var1 = 0;
         int var2 = super.zzz();
         int var3;
         if(this.zzbaG != null && this.zzbaG.length > 0) {
            int var5 = 0;

            int var6;
            for(var6 = 0; var5 < this.zzbaG.length; ++var5) {
               var6 += zzsn.zzar(this.zzbaG[var5]);
            }

            var3 = var2 + var6 + 1 * this.zzbaG.length;
         } else {
            var3 = var2;
         }

         if(this.zzbaH != null && this.zzbaH.length > 0) {
            int var4;
            for(var4 = 0; var1 < this.zzbaH.length; ++var1) {
               var4 += zzsn.zzar(this.zzbaH[var1]);
            }

            var3 = var3 + var4 + 1 * this.zzbaH.length;
         }

         return var3;
      }
   }

   public static final class zzg extends zzsu {
      private static volatile zzqb.zzg[] zzbaI;
      public String name;
      public Float zzaZo;
      public String zzamJ;
      public Long zzbaJ;
      public Long zzbai;

      public zzg() {
         this.zzEa();
      }

      public static zzqb.zzg[] zzDZ() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         if(var1 != this) {
            if(!(var1 instanceof zzqb.zzg)) {
               return false;
            }

            zzqb.zzg var2 = (zzqb.zzg)var1;
            if(this.zzbaJ == null) {
               if(var2.zzbaJ != null) {
                  return false;
               }
            } else if(!this.zzbaJ.equals(var2.zzbaJ)) {
               return false;
            }

            if(this.name == null) {
               if(var2.name != null) {
                  return false;
               }
            } else if(!this.name.equals(var2.name)) {
               return false;
            }

            if(this.zzamJ == null) {
               if(var2.zzamJ != null) {
                  return false;
               }
            } else if(!this.zzamJ.equals(var2.zzamJ)) {
               return false;
            }

            if(this.zzbai == null) {
               if(var2.zzbai != null) {
                  return false;
               }
            } else if(!this.zzbai.equals(var2.zzbai)) {
               return false;
            }

            if(this.zzaZo == null) {
               if(var2.zzaZo != null) {
                  return false;
               }
            } else if(!this.zzaZo.equals(var2.zzaZo)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         int var2;
         if(this.zzbaJ == null) {
            var2 = 0;
         } else {
            var2 = this.zzbaJ.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.name == null) {
            var4 = 0;
         } else {
            var4 = this.name.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         int var6;
         if(this.zzamJ == null) {
            var6 = 0;
         } else {
            var6 = this.zzamJ.hashCode();
         }

         int var7 = 31 * (var6 + var5);
         int var8;
         if(this.zzbai == null) {
            var8 = 0;
         } else {
            var8 = this.zzbai.hashCode();
         }

         int var9 = 31 * (var8 + var7);
         Float var10 = this.zzaZo;
         int var11 = 0;
         if(var10 != null) {
            var11 = this.zzaZo.hashCode();
         }

         return var9 + var11;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzI(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzbaJ != null) {
            var1.zzb(1, this.zzbaJ.longValue());
         }

         if(this.name != null) {
            var1.zzn(2, this.name);
         }

         if(this.zzamJ != null) {
            var1.zzn(3, this.zzamJ);
         }

         if(this.zzbai != null) {
            var1.zzb(4, this.zzbai.longValue());
         }

         if(this.zzaZo != null) {
            var1.zzb(5, this.zzaZo.floatValue());
         }

         super.writeTo(var1);
      }

      public zzqb.zzg zzEa() {
         this.zzbaJ = null;
         this.name = null;
         this.zzamJ = null;
         this.zzbai = null;
         this.zzaZo = null;
         this.zzbuu = -1;
         return this;
      }

      public zzqb.zzg zzI(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 8:
               this.zzbaJ = Long.valueOf(var1.zzJa());
               break;
            case 18:
               this.name = var1.readString();
               break;
            case 26:
               this.zzamJ = var1.readString();
               break;
            case 32:
               this.zzbai = Long.valueOf(var1.zzJa());
               break;
            case 45:
               this.zzaZo = Float.valueOf(var1.readFloat());
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
         if(this.zzbaJ != null) {
            var1 += zzsn.zzd(1, this.zzbaJ.longValue());
         }

         if(this.name != null) {
            var1 += zzsn.zzo(2, this.name);
         }

         if(this.zzamJ != null) {
            var1 += zzsn.zzo(3, this.zzamJ);
         }

         if(this.zzbai != null) {
            var1 += zzsn.zzd(4, this.zzbai.longValue());
         }

         if(this.zzaZo != null) {
            var1 += zzsn.zzc(5, this.zzaZo.floatValue());
         }

         return var1;
      }
   }
}
