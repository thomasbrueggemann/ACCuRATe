package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzsq;
import com.google.android.gms.internal.zzss;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsx;
import java.io.IOException;

public interface zzpm {
   public static final class zza extends zzso<zzpm.zza> {
      public zzpm.zza[] zzaMo;

      public zza() {
         this.zzyp();
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzpm.zza;
            var3 = false;
            if(var2) {
               zzpm.zza var4 = (zzpm.zza)var1;
               boolean var5 = zzss.equals((Object[])this.zzaMo, (Object[])var4.zzaMo);
               var3 = false;
               if(var5) {
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
         int var1 = 31 * (31 * (527 + this.getClass().getName().hashCode()) + zzss.hashCode((Object[])this.zzaMo));
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
         return this.zzo(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzaMo != null && this.zzaMo.length > 0) {
            for(int var2 = 0; var2 < this.zzaMo.length; ++var2) {
               zzpm.zza var3 = this.zzaMo[var2];
               if(var3 != null) {
                  var1.zza(1, (zzsu)var3);
               }
            }
         }

         super.writeTo(var1);
      }

      public zzpm.zza zzo(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var4;
            zzpm.zza[] var5;
            switch(var2) {
            case 10:
               int var3 = zzsx.zzc(var1, 10);
               if(this.zzaMo == null) {
                  var4 = 0;
               } else {
                  var4 = this.zzaMo.length;
               }

               var5 = new zzpm.zza[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.zzaMo, 0, var5, 0, var4);
               }
               break;
            default:
               if(this.zza(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var4 < -1 + var5.length) {
               var5[var4] = new zzpm.zza();
               var1.zza(var5[var4]);
               var1.zzIX();
               ++var4;
            }

            var5[var4] = new zzpm.zza();
            var1.zza(var5[var4]);
            this.zzaMo = var5;
         }
      }

      public zzpm.zza zzyp() {
         this.zzaMo = zzpm.zza.zzyq();
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(this.zzaMo != null && this.zzaMo.length > 0) {
            for(int var2 = 0; var2 < this.zzaMo.length; ++var2) {
               zzpm.zza var3 = this.zzaMo[var2];
               if(var3 != null) {
                  var1 += zzsn.zzc(1, var3);
               }
            }
         }

         return var1;
      }
   }

   public static final class zza extends zzso<zzpm.zza> {
      private static volatile zzpm.zza[] zzaMp;
      public int viewId;
      public String zzaMq;
      public String zzaMr;

      public zza() {
         this.zzyr();
      }

      public static zzpm.zza[] zzyq() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzpm.zza;
            var3 = false;
            if(var2) {
               zzpm.zza var4 = (zzpm.zza)var1;
               if(this.zzaMq == null) {
                  String var9 = var4.zzaMq;
                  var3 = false;
                  if(var9 != null) {
                     return var3;
                  }
               } else if(!this.zzaMq.equals(var4.zzaMq)) {
                  return false;
               }

               if(this.zzaMr == null) {
                  String var8 = var4.zzaMr;
                  var3 = false;
                  if(var8 != null) {
                     return var3;
                  }
               } else if(!this.zzaMr.equals(var4.zzaMr)) {
                  return false;
               }

               int var5 = this.viewId;
               int var6 = var4.viewId;
               var3 = false;
               if(var5 == var6) {
                  if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
                     return this.zzbuj.equals(var4.zzbuj);
                  }

                  if(var4.zzbuj != null) {
                     boolean var7 = var4.zzbuj.isEmpty();
                     var3 = false;
                     if(!var7) {
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
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         int var2;
         if(this.zzaMq == null) {
            var2 = 0;
         } else {
            var2 = this.zzaMq.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.zzaMr == null) {
            var4 = 0;
         } else {
            var4 = this.zzaMr.hashCode();
         }

         int var5 = 31 * (31 * (var4 + var3) + this.viewId);
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
         return this.zzp(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(!this.zzaMq.equals("")) {
            var1.zzn(1, this.zzaMq);
         }

         if(!this.zzaMr.equals("")) {
            var1.zzn(2, this.zzaMr);
         }

         if(this.viewId != 0) {
            var1.zzA(3, this.viewId);
         }

         super.writeTo(var1);
      }

      public zzpm.zza zzp(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 10:
               this.zzaMq = var1.readString();
               break;
            case 18:
               this.zzaMr = var1.readString();
               break;
            case 24:
               this.viewId = var1.zzJb();
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

      public zzpm.zza zzyr() {
         this.zzaMq = "";
         this.zzaMr = "";
         this.viewId = 0;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(!this.zzaMq.equals("")) {
            var1 += zzsn.zzo(1, this.zzaMq);
         }

         if(!this.zzaMr.equals("")) {
            var1 += zzsn.zzo(2, this.zzaMr);
         }

         if(this.viewId != 0) {
            var1 += zzsn.zzC(3, this.viewId);
         }

         return var1;
      }
   }

   public static final class zzb extends zzso<zzpm.zzb> {
      private static volatile zzpm.zzb[] zzaMs;
      public String name;
      public zzpm.zzd zzaMt;

      public zzb() {
         this.zzyt();
      }

      public static zzpm.zzb[] zzys() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzpm.zzb;
            var3 = false;
            if(var2) {
               zzpm.zzb var4 = (zzpm.zzb)var1;
               if(this.name == null) {
                  String var7 = var4.name;
                  var3 = false;
                  if(var7 != null) {
                     return var3;
                  }
               } else if(!this.name.equals(var4.name)) {
                  return false;
               }

               if(this.zzaMt == null) {
                  zzpm.zzd var6 = var4.zzaMt;
                  var3 = false;
                  if(var6 != null) {
                     return var3;
                  }
               } else if(!this.zzaMt.equals(var4.zzaMt)) {
                  return false;
               }

               if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
                  return this.zzbuj.equals(var4.zzbuj);
               }

               if(var4.zzbuj != null) {
                  boolean var5 = var4.zzbuj.isEmpty();
                  var3 = false;
                  if(!var5) {
                     return var3;
                  }
               }

               return true;
            }
         }

         return var3;
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
         if(this.zzaMt == null) {
            var4 = 0;
         } else {
            var4 = this.zzaMt.hashCode();
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
         return this.zzq(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(!this.name.equals("")) {
            var1.zzn(1, this.name);
         }

         if(this.zzaMt != null) {
            var1.zza(2, (zzsu)this.zzaMt);
         }

         super.writeTo(var1);
      }

      public zzpm.zzb zzq(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 10:
               this.name = var1.readString();
               break;
            case 18:
               if(this.zzaMt == null) {
                  this.zzaMt = new zzpm.zzd();
               }

               var1.zza(this.zzaMt);
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

      public zzpm.zzb zzyt() {
         this.name = "";
         this.zzaMt = null;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(!this.name.equals("")) {
            var1 += zzsn.zzo(1, this.name);
         }

         if(this.zzaMt != null) {
            var1 += zzsn.zzc(2, this.zzaMt);
         }

         return var1;
      }
   }

   public static final class zzc extends zzso<zzpm.zzc> {
      public String type;
      public zzpm.zzb[] zzaMu;

      public zzc() {
         this.zzyu();
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzpm.zzc;
            var3 = false;
            if(var2) {
               zzpm.zzc var4 = (zzpm.zzc)var1;
               if(this.type == null) {
                  String var7 = var4.type;
                  var3 = false;
                  if(var7 != null) {
                     return var3;
                  }
               } else if(!this.type.equals(var4.type)) {
                  return false;
               }

               boolean var5 = zzss.equals((Object[])this.zzaMu, (Object[])var4.zzaMu);
               var3 = false;
               if(var5) {
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
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         int var2;
         if(this.type == null) {
            var2 = 0;
         } else {
            var2 = this.type.hashCode();
         }

         int var3 = 31 * (31 * (var2 + var1) + zzss.hashCode((Object[])this.zzaMu));
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
         return this.zzr(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(!this.type.equals("")) {
            var1.zzn(1, this.type);
         }

         if(this.zzaMu != null && this.zzaMu.length > 0) {
            for(int var2 = 0; var2 < this.zzaMu.length; ++var2) {
               zzpm.zzb var3 = this.zzaMu[var2];
               if(var3 != null) {
                  var1.zza(2, (zzsu)var3);
               }
            }
         }

         super.writeTo(var1);
      }

      public zzpm.zzc zzr(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var4;
            zzpm.zzb[] var5;
            switch(var2) {
            case 10:
               this.type = var1.readString();
               continue;
            case 18:
               int var3 = zzsx.zzc(var1, 18);
               if(this.zzaMu == null) {
                  var4 = 0;
               } else {
                  var4 = this.zzaMu.length;
               }

               var5 = new zzpm.zzb[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.zzaMu, 0, var5, 0, var4);
               }
               break;
            default:
               if(this.zza(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var4 < -1 + var5.length) {
               var5[var4] = new zzpm.zzb();
               var1.zza(var5[var4]);
               var1.zzIX();
               ++var4;
            }

            var5[var4] = new zzpm.zzb();
            var1.zza(var5[var4]);
            this.zzaMu = var5;
         }
      }

      public zzpm.zzc zzyu() {
         this.type = "";
         this.zzaMu = zzpm.zzb.zzys();
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(!this.type.equals("")) {
            var1 += zzsn.zzo(1, this.type);
         }

         if(this.zzaMu != null && this.zzaMu.length > 0) {
            int var2 = var1;

            for(int var3 = 0; var3 < this.zzaMu.length; ++var3) {
               zzpm.zzb var4 = this.zzaMu[var3];
               if(var4 != null) {
                  var2 += zzsn.zzc(2, var4);
               }
            }

            var1 = var2;
         }

         return var1;
      }
   }

   public static final class zzd extends zzso<zzpm.zzd> {
      public boolean zzaMv;
      public long zzaMw;
      public double zzaMx;
      public zzpm.zzc zzaMy;
      public String zzamJ;

      public zzd() {
         this.zzyv();
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzpm.zzd;
            var3 = false;
            if(var2) {
               zzpm.zzd var4 = (zzpm.zzd)var1;
               boolean var5 = this.zzaMv;
               boolean var6 = var4.zzaMv;
               var3 = false;
               if(var5 == var6) {
                  if(this.zzamJ == null) {
                     String var11 = var4.zzamJ;
                     var3 = false;
                     if(var11 != null) {
                        return var3;
                     }
                  } else if(!this.zzamJ.equals(var4.zzamJ)) {
                     return false;
                  }

                  long var12;
                  int var7 = (var12 = this.zzaMw - var4.zzaMw) == 0L?0:(var12 < 0L?-1:1);
                  var3 = false;
                  if(var7 == 0) {
                     long var13;
                     int var8 = (var13 = Double.doubleToLongBits(this.zzaMx) - Double.doubleToLongBits(var4.zzaMx)) == 0L?0:(var13 < 0L?-1:1);
                     var3 = false;
                     if(var8 == 0) {
                        if(this.zzaMy == null) {
                           zzpm.zzc var10 = var4.zzaMy;
                           var3 = false;
                           if(var10 != null) {
                              return var3;
                           }
                        } else if(!this.zzaMy.equals(var4.zzaMy)) {
                           return false;
                        }

                        if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
                           return this.zzbuj.equals(var4.zzbuj);
                        }

                        if(var4.zzbuj == null) {
                           return true;
                        }

                        boolean var9 = var4.zzbuj.isEmpty();
                        var3 = false;
                        if(var9) {
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
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         short var2;
         if(this.zzaMv) {
            var2 = 1231;
         } else {
            var2 = 1237;
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.zzamJ == null) {
            var4 = 0;
         } else {
            var4 = this.zzamJ.hashCode();
         }

         int var5 = 31 * (var4 + var3) + (int)(this.zzaMw ^ this.zzaMw >>> 32);
         long var6 = Double.doubleToLongBits(this.zzaMx);
         int var8 = 31 * (var5 * 31 + (int)(var6 ^ var6 >>> 32));
         int var9;
         if(this.zzaMy == null) {
            var9 = 0;
         } else {
            var9 = this.zzaMy.hashCode();
         }

         int var10 = 31 * (var9 + var8);
         zzsq var11 = this.zzbuj;
         int var12 = 0;
         if(var11 != null) {
            boolean var13 = this.zzbuj.isEmpty();
            var12 = 0;
            if(!var13) {
               var12 = this.zzbuj.hashCode();
            }
         }

         return var10 + var12;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzs(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzaMv) {
            var1.zze(1, this.zzaMv);
         }

         if(!this.zzamJ.equals("")) {
            var1.zzn(2, this.zzamJ);
         }

         if(this.zzaMw != 0L) {
            var1.zzb(3, this.zzaMw);
         }

         if(Double.doubleToLongBits(this.zzaMx) != Double.doubleToLongBits(0.0D)) {
            var1.zza(4, this.zzaMx);
         }

         if(this.zzaMy != null) {
            var1.zza(5, (zzsu)this.zzaMy);
         }

         super.writeTo(var1);
      }

      public zzpm.zzd zzs(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 8:
               this.zzaMv = var1.zzJc();
               break;
            case 18:
               this.zzamJ = var1.readString();
               break;
            case 24:
               this.zzaMw = var1.zzJa();
               break;
            case 33:
               this.zzaMx = var1.readDouble();
               break;
            case 42:
               if(this.zzaMy == null) {
                  this.zzaMy = new zzpm.zzc();
               }

               var1.zza(this.zzaMy);
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

      public zzpm.zzd zzyv() {
         this.zzaMv = false;
         this.zzamJ = "";
         this.zzaMw = 0L;
         this.zzaMx = 0.0D;
         this.zzaMy = null;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(this.zzaMv) {
            var1 += zzsn.zzf(1, this.zzaMv);
         }

         if(!this.zzamJ.equals("")) {
            var1 += zzsn.zzo(2, this.zzamJ);
         }

         if(this.zzaMw != 0L) {
            var1 += zzsn.zzd(3, this.zzaMw);
         }

         if(Double.doubleToLongBits(this.zzaMx) != Double.doubleToLongBits(0.0D)) {
            var1 += zzsn.zzb(4, this.zzaMx);
         }

         if(this.zzaMy != null) {
            var1 += zzsn.zzc(5, this.zzaMy);
         }

         return var1;
      }
   }
}
