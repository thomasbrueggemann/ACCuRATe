package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzsp;
import com.google.android.gms.internal.zzsq;
import com.google.android.gms.internal.zzss;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsx;
import java.io.IOException;

public interface zzaf {
   public static final class zza extends zzso<zzaf.zza> {
      public int level;
      public int zziq;
      public int zzir;

      public zza() {
         this.zzB();
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzaf.zza;
            var3 = false;
            if(var2) {
               zzaf.zza var4 = (zzaf.zza)var1;
               int var5 = this.level;
               int var6 = var4.level;
               var3 = false;
               if(var5 == var6) {
                  int var7 = this.zziq;
                  int var8 = var4.zziq;
                  var3 = false;
                  if(var7 == var8) {
                     int var9 = this.zzir;
                     int var10 = var4.zzir;
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

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (31 * (31 * (31 * (527 + this.getClass().getName().hashCode()) + this.level) + this.zziq) + this.zzir);
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
         return this.zza(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.level != 1) {
            var1.zzA(1, this.level);
         }

         if(this.zziq != 0) {
            var1.zzA(2, this.zziq);
         }

         if(this.zzir != 0) {
            var1.zzA(3, this.zzir);
         }

         super.writeTo(var1);
      }

      public zzaf.zza zzB() {
         this.level = 1;
         this.zziq = 0;
         this.zzir = 0;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzaf.zza zza(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 8:
               int var3 = var1.zzJb();
               switch(var3) {
               case 1:
               case 2:
               case 3:
                  this.level = var3;
               default:
                  continue;
               }
            case 16:
               this.zziq = var1.zzJb();
               break;
            case 24:
               this.zzir = var1.zzJb();
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
         int var1 = super.zzz();
         if(this.level != 1) {
            var1 += zzsn.zzC(1, this.level);
         }

         if(this.zziq != 0) {
            var1 += zzsn.zzC(2, this.zziq);
         }

         if(this.zzir != 0) {
            var1 += zzsn.zzC(3, this.zzir);
         }

         return var1;
      }
   }

   public static final class zzb extends zzso<zzaf.zzb> {
      private static volatile zzaf.zzb[] zzis;
      public int name;
      public int[] zzit;
      public int zziu;
      public boolean zziv;
      public boolean zziw;

      public zzb() {
         this.zzD();
      }

      public static zzaf.zzb[] zzC() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzaf.zzb;
            var3 = false;
            if(var2) {
               zzaf.zzb var4 = (zzaf.zzb)var1;
               boolean var5 = zzss.equals(this.zzit, var4.zzit);
               var3 = false;
               if(var5) {
                  int var6 = this.zziu;
                  int var7 = var4.zziu;
                  var3 = false;
                  if(var6 == var7) {
                     int var8 = this.name;
                     int var9 = var4.name;
                     var3 = false;
                     if(var8 == var9) {
                        boolean var10 = this.zziv;
                        boolean var11 = var4.zziv;
                        var3 = false;
                        if(var10 == var11) {
                           boolean var12 = this.zziw;
                           boolean var13 = var4.zziw;
                           var3 = false;
                           if(var12 == var13) {
                              if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
                                 return this.zzbuj.equals(var4.zzbuj);
                              }

                              if(var4.zzbuj != null) {
                                 boolean var14 = var4.zzbuj.isEmpty();
                                 var3 = false;
                                 if(!var14) {
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
         }

         return var3;
      }

      public int hashCode() {
         short var1 = 1231;
         int var2 = 31 * (31 * (31 * (31 * (527 + this.getClass().getName().hashCode()) + zzss.hashCode(this.zzit)) + this.zziu) + this.name);
         short var3;
         if(this.zziv) {
            var3 = var1;
         } else {
            var3 = 1237;
         }

         int var4 = 31 * (var3 + var2);
         if(!this.zziw) {
            var1 = 1237;
         }

         int var5 = 31 * (var4 + var1);
         int var6;
         if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
            var6 = this.zzbuj.hashCode();
         } else {
            var6 = 0;
         }

         return var6 + var5;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzb(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zziw) {
            var1.zze(1, this.zziw);
         }

         var1.zzA(2, this.zziu);
         if(this.zzit != null && this.zzit.length > 0) {
            for(int var2 = 0; var2 < this.zzit.length; ++var2) {
               var1.zzA(3, this.zzit[var2]);
            }
         }

         if(this.name != 0) {
            var1.zzA(4, this.name);
         }

         if(this.zziv) {
            var1.zze(6, this.zziv);
         }

         super.writeTo(var1);
      }

      public zzaf.zzb zzD() {
         this.zzit = zzsx.zzbuw;
         this.zziu = 0;
         this.name = 0;
         this.zziv = false;
         this.zziw = false;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzaf.zzb zzb(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var10;
            int[] var11;
            switch(var2) {
            case 8:
               this.zziw = var1.zzJc();
               continue;
            case 16:
               this.zziu = var1.zzJb();
               continue;
            case 24:
               int var9 = zzsx.zzc(var1, 24);
               if(this.zzit == null) {
                  var10 = 0;
               } else {
                  var10 = this.zzit.length;
               }

               var11 = new int[var9 + var10];
               if(var10 != 0) {
                  System.arraycopy(this.zzit, 0, var11, 0, var10);
               }
               break;
            case 26:
               int var3 = var1.zzmq(var1.zzJf());
               int var4 = var1.getPosition();

               int var5;
               for(var5 = 0; var1.zzJk() > 0; ++var5) {
                  var1.zzJb();
               }

               var1.zzms(var4);
               int var6;
               if(this.zzit == null) {
                  var6 = 0;
               } else {
                  var6 = this.zzit.length;
               }

               int[] var7 = new int[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.zzit, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.zzJb();
                  ++var6;
               }

               this.zzit = var7;
               var1.zzmr(var3);
               continue;
            case 32:
               this.name = var1.zzJb();
               continue;
            case 48:
               this.zziv = var1.zzJc();
               continue;
            default:
               if(this.zza(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var10 < -1 + var11.length) {
               var11[var10] = var1.zzJb();
               var1.zzIX();
               ++var10;
            }

            var11[var10] = var1.zzJb();
            this.zzit = var11;
         }
      }

      protected int zzz() {
         int var1 = 0;
         int var2 = super.zzz();
         if(this.zziw) {
            var2 += zzsn.zzf(1, this.zziw);
         }

         int var3 = var2 + zzsn.zzC(2, this.zziu);
         int var4;
         if(this.zzit != null && this.zzit.length > 0) {
            for(int var5 = 0; var5 < this.zzit.length; ++var5) {
               var1 += zzsn.zzmx(this.zzit[var5]);
            }

            var4 = var3 + var1 + 1 * this.zzit.length;
         } else {
            var4 = var3;
         }

         if(this.name != 0) {
            var4 += zzsn.zzC(4, this.name);
         }

         if(this.zziv) {
            var4 += zzsn.zzf(6, this.zziv);
         }

         return var4;
      }
   }

   public static final class zzc extends zzso<zzaf.zzc> {
      private static volatile zzaf.zzc[] zzix;
      public String key;
      public boolean zziA;
      public long zziB;
      public long zziy;
      public long zziz;

      public zzc() {
         this.zzF();
      }

      public static zzaf.zzc[] zzE() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzaf.zzc;
            var3 = false;
            if(var2) {
               zzaf.zzc var4 = (zzaf.zzc)var1;
               if(this.key == null) {
                  String var11 = var4.key;
                  var3 = false;
                  if(var11 != null) {
                     return var3;
                  }
               } else if(!this.key.equals(var4.key)) {
                  return false;
               }

               long var12;
               int var5 = (var12 = this.zziy - var4.zziy) == 0L?0:(var12 < 0L?-1:1);
               var3 = false;
               if(var5 == 0) {
                  long var13;
                  int var6 = (var13 = this.zziz - var4.zziz) == 0L?0:(var13 < 0L?-1:1);
                  var3 = false;
                  if(var6 == 0) {
                     boolean var7 = this.zziA;
                     boolean var8 = var4.zziA;
                     var3 = false;
                     if(var7 == var8) {
                        long var14;
                        int var9 = (var14 = this.zziB - var4.zziB) == 0L?0:(var14 < 0L?-1:1);
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
         int var1 = 31 * (527 + this.getClass().getName().hashCode());
         int var2;
         if(this.key == null) {
            var2 = 0;
         } else {
            var2 = this.key.hashCode();
         }

         int var3 = 31 * (31 * (31 * (var2 + var1) + (int)(this.zziy ^ this.zziy >>> 32)) + (int)(this.zziz ^ this.zziz >>> 32));
         short var4;
         if(this.zziA) {
            var4 = 1231;
         } else {
            var4 = 1237;
         }

         int var5 = 31 * (31 * (var4 + var3) + (int)(this.zziB ^ this.zziB >>> 32));
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
         return this.zzc(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(!this.key.equals("")) {
            var1.zzn(1, this.key);
         }

         if(this.zziy != 0L) {
            var1.zzb(2, this.zziy);
         }

         if(this.zziz != 2147483647L) {
            var1.zzb(3, this.zziz);
         }

         if(this.zziA) {
            var1.zze(4, this.zziA);
         }

         if(this.zziB != 0L) {
            var1.zzb(5, this.zziB);
         }

         super.writeTo(var1);
      }

      public zzaf.zzc zzF() {
         this.key = "";
         this.zziy = 0L;
         this.zziz = 2147483647L;
         this.zziA = false;
         this.zziB = 0L;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzaf.zzc zzc(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 10:
               this.key = var1.readString();
               break;
            case 16:
               this.zziy = var1.zzJa();
               break;
            case 24:
               this.zziz = var1.zzJa();
               break;
            case 32:
               this.zziA = var1.zzJc();
               break;
            case 40:
               this.zziB = var1.zzJa();
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
         int var1 = super.zzz();
         if(!this.key.equals("")) {
            var1 += zzsn.zzo(1, this.key);
         }

         if(this.zziy != 0L) {
            var1 += zzsn.zzd(2, this.zziy);
         }

         if(this.zziz != 2147483647L) {
            var1 += zzsn.zzd(3, this.zziz);
         }

         if(this.zziA) {
            var1 += zzsn.zzf(4, this.zziA);
         }

         if(this.zziB != 0L) {
            var1 += zzsn.zzd(5, this.zziB);
         }

         return var1;
      }
   }

   public static final class zzd extends zzso<zzaf.zzd> {
      public zzag.zza[] zziC;
      public zzag.zza[] zziD;
      public zzaf.zzc[] zziE;

      public zzd() {
         this.zzG();
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzaf.zzd;
            var3 = false;
            if(var2) {
               zzaf.zzd var4 = (zzaf.zzd)var1;
               boolean var5 = zzss.equals((Object[])this.zziC, (Object[])var4.zziC);
               var3 = false;
               if(var5) {
                  boolean var6 = zzss.equals((Object[])this.zziD, (Object[])var4.zziD);
                  var3 = false;
                  if(var6) {
                     boolean var7 = zzss.equals((Object[])this.zziE, (Object[])var4.zziE);
                     var3 = false;
                     if(var7) {
                        if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
                           return this.zzbuj.equals(var4.zzbuj);
                        }

                        if(var4.zzbuj != null) {
                           boolean var8 = var4.zzbuj.isEmpty();
                           var3 = false;
                           if(!var8) {
                              return var3;
                           }
                        }

                        return true;
                     }
                  }
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (31 * (31 * (31 * (527 + this.getClass().getName().hashCode()) + zzss.hashCode((Object[])this.zziC)) + zzss.hashCode((Object[])this.zziD)) + zzss.hashCode((Object[])this.zziE));
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
         return this.zzd(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zziC != null && this.zziC.length > 0) {
            for(int var7 = 0; var7 < this.zziC.length; ++var7) {
               zzag.zza var8 = this.zziC[var7];
               if(var8 != null) {
                  var1.zza(1, (zzsu)var8);
               }
            }
         }

         if(this.zziD != null && this.zziD.length > 0) {
            for(int var5 = 0; var5 < this.zziD.length; ++var5) {
               zzag.zza var6 = this.zziD[var5];
               if(var6 != null) {
                  var1.zza(2, (zzsu)var6);
               }
            }
         }

         if(this.zziE != null) {
            int var2 = this.zziE.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.zziE.length; ++var3) {
                  zzaf.zzc var4 = this.zziE[var3];
                  if(var4 != null) {
                     var1.zza(3, (zzsu)var4);
                  }
               }
            }
         }

         super.writeTo(var1);
      }

      public zzaf.zzd zzG() {
         this.zziC = zzag.zza.zzQ();
         this.zziD = zzag.zza.zzQ();
         this.zziE = zzaf.zzc.zzE();
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzaf.zzd zzd(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var12;
            zzag.zza[] var13;
            switch(var2) {
            case 10:
               int var11 = zzsx.zzc(var1, 10);
               if(this.zziC == null) {
                  var12 = 0;
               } else {
                  var12 = this.zziC.length;
               }

               var13 = new zzag.zza[var11 + var12];
               if(var12 != 0) {
                  System.arraycopy(this.zziC, 0, var13, 0, var12);
               }
               break;
            case 18:
               int var7 = zzsx.zzc(var1, 18);
               int var8;
               if(this.zziD == null) {
                  var8 = 0;
               } else {
                  var8 = this.zziD.length;
               }

               zzag.zza[] var9 = new zzag.zza[var7 + var8];
               if(var8 != 0) {
                  System.arraycopy(this.zziD, 0, var9, 0, var8);
               }

               while(var8 < -1 + var9.length) {
                  var9[var8] = new zzag.zza();
                  var1.zza(var9[var8]);
                  var1.zzIX();
                  ++var8;
               }

               var9[var8] = new zzag.zza();
               var1.zza(var9[var8]);
               this.zziD = var9;
               continue;
            case 26:
               int var3 = zzsx.zzc(var1, 26);
               int var4;
               if(this.zziE == null) {
                  var4 = 0;
               } else {
                  var4 = this.zziE.length;
               }

               zzaf.zzc[] var5 = new zzaf.zzc[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.zziE, 0, var5, 0, var4);
               }

               while(var4 < -1 + var5.length) {
                  var5[var4] = new zzaf.zzc();
                  var1.zza(var5[var4]);
                  var1.zzIX();
                  ++var4;
               }

               var5[var4] = new zzaf.zzc();
               var1.zza(var5[var4]);
               this.zziE = var5;
               continue;
            default:
               if(this.zza(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var12 < -1 + var13.length) {
               var13[var12] = new zzag.zza();
               var1.zza(var13[var12]);
               var1.zzIX();
               ++var12;
            }

            var13[var12] = new zzag.zza();
            var1.zza(var13[var12]);
            this.zziC = var13;
         }
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(this.zziC != null && this.zziC.length > 0) {
            int var8 = var1;

            for(int var9 = 0; var9 < this.zziC.length; ++var9) {
               zzag.zza var10 = this.zziC[var9];
               if(var10 != null) {
                  var8 += zzsn.zzc(1, var10);
               }
            }

            var1 = var8;
         }

         if(this.zziD != null && this.zziD.length > 0) {
            int var5 = var1;

            for(int var6 = 0; var6 < this.zziD.length; ++var6) {
               zzag.zza var7 = this.zziD[var6];
               if(var7 != null) {
                  var5 += zzsn.zzc(2, var7);
               }
            }

            var1 = var5;
         }

         if(this.zziE != null) {
            int var2 = this.zziE.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.zziE.length; ++var3) {
                  zzaf.zzc var4 = this.zziE[var3];
                  if(var4 != null) {
                     var1 += zzsn.zzc(3, var4);
                  }
               }
            }
         }

         return var1;
      }
   }

   public static final class zze extends zzso<zzaf.zze> {
      private static volatile zzaf.zze[] zziF;
      public int key;
      public int value;

      public zze() {
         this.zzI();
      }

      public static zzaf.zze[] zzH() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzaf.zze;
            var3 = false;
            if(var2) {
               zzaf.zze var4 = (zzaf.zze)var1;
               int var5 = this.key;
               int var6 = var4.key;
               var3 = false;
               if(var5 == var6) {
                  int var7 = this.value;
                  int var8 = var4.value;
                  var3 = false;
                  if(var7 == var8) {
                     if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
                        return this.zzbuj.equals(var4.zzbuj);
                     }

                     if(var4.zzbuj != null) {
                        boolean var9 = var4.zzbuj.isEmpty();
                        var3 = false;
                        if(!var9) {
                           return var3;
                        }
                     }

                     return true;
                  }
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (31 * (31 * (527 + this.getClass().getName().hashCode()) + this.key) + this.value);
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
         return this.zze(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         var1.zzA(1, this.key);
         var1.zzA(2, this.value);
         super.writeTo(var1);
      }

      public zzaf.zze zzI() {
         this.key = 0;
         this.value = 0;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzaf.zze zze(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 8:
               this.key = var1.zzJb();
               break;
            case 16:
               this.value = var1.zzJb();
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
         return super.zzz() + zzsn.zzC(1, this.key) + zzsn.zzC(2, this.value);
      }
   }

   public static final class zzf extends zzso<zzaf.zzf> {
      public String version;
      public String[] zziG;
      public String[] zziH;
      public zzag.zza[] zziI;
      public zzaf.zze[] zziJ;
      public zzaf.zzb[] zziK;
      public zzaf.zzb[] zziL;
      public zzaf.zzb[] zziM;
      public zzaf.zzg[] zziN;
      public String zziO;
      public String zziP;
      public String zziQ;
      public zzaf.zza zziR;
      public float zziS;
      public boolean zziT;
      public String[] zziU;
      public int zziV;

      public zzf() {
         this.zzJ();
      }

      public static zzaf.zzf zzc(byte[] var0) throws zzst {
         return (zzaf.zzf)zzsu.mergeFrom(new zzaf.zzf(), var0);
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzaf.zzf;
            var3 = false;
            if(var2) {
               zzaf.zzf var4 = (zzaf.zzf)var1;
               boolean var5 = zzss.equals((Object[])this.zziG, (Object[])var4.zziG);
               var3 = false;
               if(var5) {
                  boolean var6 = zzss.equals((Object[])this.zziH, (Object[])var4.zziH);
                  var3 = false;
                  if(var6) {
                     boolean var7 = zzss.equals((Object[])this.zziI, (Object[])var4.zziI);
                     var3 = false;
                     if(var7) {
                        boolean var8 = zzss.equals((Object[])this.zziJ, (Object[])var4.zziJ);
                        var3 = false;
                        if(var8) {
                           boolean var9 = zzss.equals((Object[])this.zziK, (Object[])var4.zziK);
                           var3 = false;
                           if(var9) {
                              boolean var10 = zzss.equals((Object[])this.zziL, (Object[])var4.zziL);
                              var3 = false;
                              if(var10) {
                                 boolean var11 = zzss.equals((Object[])this.zziM, (Object[])var4.zziM);
                                 var3 = false;
                                 if(var11) {
                                    boolean var12 = zzss.equals((Object[])this.zziN, (Object[])var4.zziN);
                                    var3 = false;
                                    if(var12) {
                                       if(this.zziO == null) {
                                          String var25 = var4.zziO;
                                          var3 = false;
                                          if(var25 != null) {
                                             return var3;
                                          }
                                       } else if(!this.zziO.equals(var4.zziO)) {
                                          return false;
                                       }

                                       if(this.zziP == null) {
                                          String var24 = var4.zziP;
                                          var3 = false;
                                          if(var24 != null) {
                                             return var3;
                                          }
                                       } else if(!this.zziP.equals(var4.zziP)) {
                                          return false;
                                       }

                                       if(this.zziQ == null) {
                                          String var23 = var4.zziQ;
                                          var3 = false;
                                          if(var23 != null) {
                                             return var3;
                                          }
                                       } else if(!this.zziQ.equals(var4.zziQ)) {
                                          return false;
                                       }

                                       if(this.version == null) {
                                          String var22 = var4.version;
                                          var3 = false;
                                          if(var22 != null) {
                                             return var3;
                                          }
                                       } else if(!this.version.equals(var4.version)) {
                                          return false;
                                       }

                                       if(this.zziR == null) {
                                          zzaf.zza var21 = var4.zziR;
                                          var3 = false;
                                          if(var21 != null) {
                                             return var3;
                                          }
                                       } else if(!this.zziR.equals(var4.zziR)) {
                                          return false;
                                       }

                                       int var13 = Float.floatToIntBits(this.zziS);
                                       int var14 = Float.floatToIntBits(var4.zziS);
                                       var3 = false;
                                       if(var13 == var14) {
                                          boolean var15 = this.zziT;
                                          boolean var16 = var4.zziT;
                                          var3 = false;
                                          if(var15 == var16) {
                                             boolean var17 = zzss.equals((Object[])this.zziU, (Object[])var4.zziU);
                                             var3 = false;
                                             if(var17) {
                                                int var18 = this.zziV;
                                                int var19 = var4.zziV;
                                                var3 = false;
                                                if(var18 == var19) {
                                                   if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
                                                      return this.zzbuj.equals(var4.zzbuj);
                                                   }

                                                   if(var4.zzbuj != null) {
                                                      boolean var20 = var4.zzbuj.isEmpty();
                                                      var3 = false;
                                                      if(!var20) {
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
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + this.getClass().getName().hashCode()) + zzss.hashCode((Object[])this.zziG)) + zzss.hashCode((Object[])this.zziH)) + zzss.hashCode((Object[])this.zziI)) + zzss.hashCode((Object[])this.zziJ)) + zzss.hashCode((Object[])this.zziK)) + zzss.hashCode((Object[])this.zziL)) + zzss.hashCode((Object[])this.zziM)) + zzss.hashCode((Object[])this.zziN));
         int var2;
         if(this.zziO == null) {
            var2 = 0;
         } else {
            var2 = this.zziO.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.zziP == null) {
            var4 = 0;
         } else {
            var4 = this.zziP.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         int var6;
         if(this.zziQ == null) {
            var6 = 0;
         } else {
            var6 = this.zziQ.hashCode();
         }

         int var7 = 31 * (var6 + var5);
         int var8;
         if(this.version == null) {
            var8 = 0;
         } else {
            var8 = this.version.hashCode();
         }

         int var9 = 31 * (var8 + var7);
         int var10;
         if(this.zziR == null) {
            var10 = 0;
         } else {
            var10 = this.zziR.hashCode();
         }

         int var11 = 31 * (31 * (var10 + var9) + Float.floatToIntBits(this.zziS));
         short var12;
         if(this.zziT) {
            var12 = 1231;
         } else {
            var12 = 1237;
         }

         int var13 = 31 * (31 * (31 * (var12 + var11) + zzss.hashCode((Object[])this.zziU)) + this.zziV);
         zzsq var14 = this.zzbuj;
         int var15 = 0;
         if(var14 != null) {
            boolean var16 = this.zzbuj.isEmpty();
            var15 = 0;
            if(!var16) {
               var15 = this.zzbuj.hashCode();
            }
         }

         return var13 + var15;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzf(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zziH != null && this.zziH.length > 0) {
            for(int var19 = 0; var19 < this.zziH.length; ++var19) {
               String var20 = this.zziH[var19];
               if(var20 != null) {
                  var1.zzn(1, var20);
               }
            }
         }

         if(this.zziI != null && this.zziI.length > 0) {
            for(int var17 = 0; var17 < this.zziI.length; ++var17) {
               zzag.zza var18 = this.zziI[var17];
               if(var18 != null) {
                  var1.zza(2, (zzsu)var18);
               }
            }
         }

         if(this.zziJ != null && this.zziJ.length > 0) {
            for(int var15 = 0; var15 < this.zziJ.length; ++var15) {
               zzaf.zze var16 = this.zziJ[var15];
               if(var16 != null) {
                  var1.zza(3, (zzsu)var16);
               }
            }
         }

         if(this.zziK != null && this.zziK.length > 0) {
            for(int var13 = 0; var13 < this.zziK.length; ++var13) {
               zzaf.zzb var14 = this.zziK[var13];
               if(var14 != null) {
                  var1.zza(4, (zzsu)var14);
               }
            }
         }

         if(this.zziL != null && this.zziL.length > 0) {
            for(int var11 = 0; var11 < this.zziL.length; ++var11) {
               zzaf.zzb var12 = this.zziL[var11];
               if(var12 != null) {
                  var1.zza(5, (zzsu)var12);
               }
            }
         }

         if(this.zziM != null && this.zziM.length > 0) {
            for(int var9 = 0; var9 < this.zziM.length; ++var9) {
               zzaf.zzb var10 = this.zziM[var9];
               if(var10 != null) {
                  var1.zza(6, (zzsu)var10);
               }
            }
         }

         if(this.zziN != null && this.zziN.length > 0) {
            for(int var7 = 0; var7 < this.zziN.length; ++var7) {
               zzaf.zzg var8 = this.zziN[var7];
               if(var8 != null) {
                  var1.zza(7, (zzsu)var8);
               }
            }
         }

         if(!this.zziO.equals("")) {
            var1.zzn(9, this.zziO);
         }

         if(!this.zziP.equals("")) {
            var1.zzn(10, this.zziP);
         }

         if(!this.zziQ.equals("0")) {
            var1.zzn(12, this.zziQ);
         }

         if(!this.version.equals("")) {
            var1.zzn(13, this.version);
         }

         if(this.zziR != null) {
            var1.zza(14, (zzsu)this.zziR);
         }

         if(Float.floatToIntBits(this.zziS) != Float.floatToIntBits(0.0F)) {
            var1.zzb(15, this.zziS);
         }

         if(this.zziU != null && this.zziU.length > 0) {
            for(int var5 = 0; var5 < this.zziU.length; ++var5) {
               String var6 = this.zziU[var5];
               if(var6 != null) {
                  var1.zzn(16, var6);
               }
            }
         }

         if(this.zziV != 0) {
            var1.zzA(17, this.zziV);
         }

         if(this.zziT) {
            var1.zze(18, this.zziT);
         }

         if(this.zziG != null) {
            int var2 = this.zziG.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.zziG.length; ++var3) {
                  String var4 = this.zziG[var3];
                  if(var4 != null) {
                     var1.zzn(19, var4);
                  }
               }
            }
         }

         super.writeTo(var1);
      }

      public zzaf.zzf zzJ() {
         this.zziG = zzsx.zzbuB;
         this.zziH = zzsx.zzbuB;
         this.zziI = zzag.zza.zzQ();
         this.zziJ = zzaf.zze.zzH();
         this.zziK = zzaf.zzb.zzC();
         this.zziL = zzaf.zzb.zzC();
         this.zziM = zzaf.zzb.zzC();
         this.zziN = zzaf.zzg.zzK();
         this.zziO = "";
         this.zziP = "";
         this.zziQ = "0";
         this.version = "";
         this.zziR = null;
         this.zziS = 0.0F;
         this.zziT = false;
         this.zziU = zzsx.zzbuB;
         this.zziV = 0;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzaf.zzf zzf(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var36;
            String[] var37;
            switch(var2) {
            case 10:
               int var35 = zzsx.zzc(var1, 10);
               if(this.zziH == null) {
                  var36 = 0;
               } else {
                  var36 = this.zziH.length;
               }

               var37 = new String[var35 + var36];
               if(var36 != 0) {
                  System.arraycopy(this.zziH, 0, var37, 0, var36);
               }
               break;
            case 18:
               int var31 = zzsx.zzc(var1, 18);
               int var32;
               if(this.zziI == null) {
                  var32 = 0;
               } else {
                  var32 = this.zziI.length;
               }

               zzag.zza[] var33 = new zzag.zza[var31 + var32];
               if(var32 != 0) {
                  System.arraycopy(this.zziI, 0, var33, 0, var32);
               }

               while(var32 < -1 + var33.length) {
                  var33[var32] = new zzag.zza();
                  var1.zza(var33[var32]);
                  var1.zzIX();
                  ++var32;
               }

               var33[var32] = new zzag.zza();
               var1.zza(var33[var32]);
               this.zziI = var33;
               continue;
            case 26:
               int var27 = zzsx.zzc(var1, 26);
               int var28;
               if(this.zziJ == null) {
                  var28 = 0;
               } else {
                  var28 = this.zziJ.length;
               }

               zzaf.zze[] var29 = new zzaf.zze[var27 + var28];
               if(var28 != 0) {
                  System.arraycopy(this.zziJ, 0, var29, 0, var28);
               }

               while(var28 < -1 + var29.length) {
                  var29[var28] = new zzaf.zze();
                  var1.zza(var29[var28]);
                  var1.zzIX();
                  ++var28;
               }

               var29[var28] = new zzaf.zze();
               var1.zza(var29[var28]);
               this.zziJ = var29;
               continue;
            case 34:
               int var23 = zzsx.zzc(var1, 34);
               int var24;
               if(this.zziK == null) {
                  var24 = 0;
               } else {
                  var24 = this.zziK.length;
               }

               zzaf.zzb[] var25 = new zzaf.zzb[var23 + var24];
               if(var24 != 0) {
                  System.arraycopy(this.zziK, 0, var25, 0, var24);
               }

               while(var24 < -1 + var25.length) {
                  var25[var24] = new zzaf.zzb();
                  var1.zza(var25[var24]);
                  var1.zzIX();
                  ++var24;
               }

               var25[var24] = new zzaf.zzb();
               var1.zza(var25[var24]);
               this.zziK = var25;
               continue;
            case 42:
               int var19 = zzsx.zzc(var1, 42);
               int var20;
               if(this.zziL == null) {
                  var20 = 0;
               } else {
                  var20 = this.zziL.length;
               }

               zzaf.zzb[] var21 = new zzaf.zzb[var19 + var20];
               if(var20 != 0) {
                  System.arraycopy(this.zziL, 0, var21, 0, var20);
               }

               while(var20 < -1 + var21.length) {
                  var21[var20] = new zzaf.zzb();
                  var1.zza(var21[var20]);
                  var1.zzIX();
                  ++var20;
               }

               var21[var20] = new zzaf.zzb();
               var1.zza(var21[var20]);
               this.zziL = var21;
               continue;
            case 50:
               int var15 = zzsx.zzc(var1, 50);
               int var16;
               if(this.zziM == null) {
                  var16 = 0;
               } else {
                  var16 = this.zziM.length;
               }

               zzaf.zzb[] var17 = new zzaf.zzb[var15 + var16];
               if(var16 != 0) {
                  System.arraycopy(this.zziM, 0, var17, 0, var16);
               }

               while(var16 < -1 + var17.length) {
                  var17[var16] = new zzaf.zzb();
                  var1.zza(var17[var16]);
                  var1.zzIX();
                  ++var16;
               }

               var17[var16] = new zzaf.zzb();
               var1.zza(var17[var16]);
               this.zziM = var17;
               continue;
            case 58:
               int var11 = zzsx.zzc(var1, 58);
               int var12;
               if(this.zziN == null) {
                  var12 = 0;
               } else {
                  var12 = this.zziN.length;
               }

               zzaf.zzg[] var13 = new zzaf.zzg[var11 + var12];
               if(var12 != 0) {
                  System.arraycopy(this.zziN, 0, var13, 0, var12);
               }

               while(var12 < -1 + var13.length) {
                  var13[var12] = new zzaf.zzg();
                  var1.zza(var13[var12]);
                  var1.zzIX();
                  ++var12;
               }

               var13[var12] = new zzaf.zzg();
               var1.zza(var13[var12]);
               this.zziN = var13;
               continue;
            case 74:
               this.zziO = var1.readString();
               continue;
            case 82:
               this.zziP = var1.readString();
               continue;
            case 98:
               this.zziQ = var1.readString();
               continue;
            case 106:
               this.version = var1.readString();
               continue;
            case 114:
               if(this.zziR == null) {
                  this.zziR = new zzaf.zza();
               }

               var1.zza(this.zziR);
               continue;
            case 125:
               this.zziS = var1.readFloat();
               continue;
            case 130:
               int var7 = zzsx.zzc(var1, 130);
               int var8;
               if(this.zziU == null) {
                  var8 = 0;
               } else {
                  var8 = this.zziU.length;
               }

               String[] var9 = new String[var7 + var8];
               if(var8 != 0) {
                  System.arraycopy(this.zziU, 0, var9, 0, var8);
               }

               while(var8 < -1 + var9.length) {
                  var9[var8] = var1.readString();
                  var1.zzIX();
                  ++var8;
               }

               var9[var8] = var1.readString();
               this.zziU = var9;
               continue;
            case 136:
               this.zziV = var1.zzJb();
               continue;
            case 144:
               this.zziT = var1.zzJc();
               continue;
            case 154:
               int var3 = zzsx.zzc(var1, 154);
               int var4;
               if(this.zziG == null) {
                  var4 = 0;
               } else {
                  var4 = this.zziG.length;
               }

               String[] var5 = new String[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.zziG, 0, var5, 0, var4);
               }

               while(var4 < -1 + var5.length) {
                  var5[var4] = var1.readString();
                  var1.zzIX();
                  ++var4;
               }

               var5[var4] = var1.readString();
               this.zziG = var5;
               continue;
            default:
               if(this.zza(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var36 < -1 + var37.length) {
               var37[var36] = var1.readString();
               var1.zzIX();
               ++var36;
            }

            var37[var36] = var1.readString();
            this.zziH = var37;
         }
      }

      protected int zzz() {
         int var1 = 0;
         int var2 = super.zzz();
         int var3;
         if(this.zziH != null && this.zziH.length > 0) {
            int var29 = 0;
            int var30 = 0;

            int var31;
            for(var31 = 0; var29 < this.zziH.length; ++var29) {
               String var32 = this.zziH[var29];
               if(var32 != null) {
                  ++var31;
                  var30 += zzsn.zzgO(var32);
               }
            }

            var3 = var2 + var30 + var31 * 1;
         } else {
            var3 = var2;
         }

         if(this.zziI != null && this.zziI.length > 0) {
            int var26 = var3;

            for(int var27 = 0; var27 < this.zziI.length; ++var27) {
               zzag.zza var28 = this.zziI[var27];
               if(var28 != null) {
                  var26 += zzsn.zzc(2, var28);
               }
            }

            var3 = var26;
         }

         if(this.zziJ != null && this.zziJ.length > 0) {
            int var23 = var3;

            for(int var24 = 0; var24 < this.zziJ.length; ++var24) {
               zzaf.zze var25 = this.zziJ[var24];
               if(var25 != null) {
                  var23 += zzsn.zzc(3, var25);
               }
            }

            var3 = var23;
         }

         if(this.zziK != null && this.zziK.length > 0) {
            int var20 = var3;

            for(int var21 = 0; var21 < this.zziK.length; ++var21) {
               zzaf.zzb var22 = this.zziK[var21];
               if(var22 != null) {
                  var20 += zzsn.zzc(4, var22);
               }
            }

            var3 = var20;
         }

         if(this.zziL != null && this.zziL.length > 0) {
            int var17 = var3;

            for(int var18 = 0; var18 < this.zziL.length; ++var18) {
               zzaf.zzb var19 = this.zziL[var18];
               if(var19 != null) {
                  var17 += zzsn.zzc(5, var19);
               }
            }

            var3 = var17;
         }

         if(this.zziM != null && this.zziM.length > 0) {
            int var14 = var3;

            for(int var15 = 0; var15 < this.zziM.length; ++var15) {
               zzaf.zzb var16 = this.zziM[var15];
               if(var16 != null) {
                  var14 += zzsn.zzc(6, var16);
               }
            }

            var3 = var14;
         }

         if(this.zziN != null && this.zziN.length > 0) {
            int var11 = var3;

            for(int var12 = 0; var12 < this.zziN.length; ++var12) {
               zzaf.zzg var13 = this.zziN[var12];
               if(var13 != null) {
                  var11 += zzsn.zzc(7, var13);
               }
            }

            var3 = var11;
         }

         if(!this.zziO.equals("")) {
            var3 += zzsn.zzo(9, this.zziO);
         }

         if(!this.zziP.equals("")) {
            var3 += zzsn.zzo(10, this.zziP);
         }

         if(!this.zziQ.equals("0")) {
            var3 += zzsn.zzo(12, this.zziQ);
         }

         if(!this.version.equals("")) {
            var3 += zzsn.zzo(13, this.version);
         }

         if(this.zziR != null) {
            var3 += zzsn.zzc(14, this.zziR);
         }

         if(Float.floatToIntBits(this.zziS) != Float.floatToIntBits(0.0F)) {
            var3 += zzsn.zzc(15, this.zziS);
         }

         if(this.zziU != null && this.zziU.length > 0) {
            int var7 = 0;
            int var8 = 0;

            int var9;
            for(var9 = 0; var7 < this.zziU.length; ++var7) {
               String var10 = this.zziU[var7];
               if(var10 != null) {
                  ++var9;
                  var8 += zzsn.zzgO(var10);
               }
            }

            var3 = var3 + var8 + var9 * 2;
         }

         if(this.zziV != 0) {
            var3 += zzsn.zzC(17, this.zziV);
         }

         if(this.zziT) {
            var3 += zzsn.zzf(18, this.zziT);
         }

         if(this.zziG != null && this.zziG.length > 0) {
            int var4 = 0;

            int var5;
            for(var5 = 0; var1 < this.zziG.length; ++var1) {
               String var6 = this.zziG[var1];
               if(var6 != null) {
                  ++var5;
                  var4 += zzsn.zzgO(var6);
               }
            }

            var3 = var3 + var4 + var5 * 2;
         }

         return var3;
      }
   }

   public static final class zzg extends zzso<zzaf.zzg> {
      private static volatile zzaf.zzg[] zziW;
      public int[] zziX;
      public int[] zziY;
      public int[] zziZ;
      public int[] zzja;
      public int[] zzjb;
      public int[] zzjc;
      public int[] zzjd;
      public int[] zzje;
      public int[] zzjf;
      public int[] zzjg;

      public zzg() {
         this.zzL();
      }

      public static zzaf.zzg[] zzK() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzaf.zzg;
            var3 = false;
            if(var2) {
               zzaf.zzg var4 = (zzaf.zzg)var1;
               boolean var5 = zzss.equals(this.zziX, var4.zziX);
               var3 = false;
               if(var5) {
                  boolean var6 = zzss.equals(this.zziY, var4.zziY);
                  var3 = false;
                  if(var6) {
                     boolean var7 = zzss.equals(this.zziZ, var4.zziZ);
                     var3 = false;
                     if(var7) {
                        boolean var8 = zzss.equals(this.zzja, var4.zzja);
                        var3 = false;
                        if(var8) {
                           boolean var9 = zzss.equals(this.zzjb, var4.zzjb);
                           var3 = false;
                           if(var9) {
                              boolean var10 = zzss.equals(this.zzjc, var4.zzjc);
                              var3 = false;
                              if(var10) {
                                 boolean var11 = zzss.equals(this.zzjd, var4.zzjd);
                                 var3 = false;
                                 if(var11) {
                                    boolean var12 = zzss.equals(this.zzje, var4.zzje);
                                    var3 = false;
                                    if(var12) {
                                       boolean var13 = zzss.equals(this.zzjf, var4.zzjf);
                                       var3 = false;
                                       if(var13) {
                                          boolean var14 = zzss.equals(this.zzjg, var4.zzjg);
                                          var3 = false;
                                          if(var14) {
                                             if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
                                                return this.zzbuj.equals(var4.zzbuj);
                                             }

                                             if(var4.zzbuj == null) {
                                                return true;
                                             }

                                             boolean var15 = var4.zzbuj.isEmpty();
                                             var3 = false;
                                             if(var15) {
                                                return true;
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + this.getClass().getName().hashCode()) + zzss.hashCode(this.zziX)) + zzss.hashCode(this.zziY)) + zzss.hashCode(this.zziZ)) + zzss.hashCode(this.zzja)) + zzss.hashCode(this.zzjb)) + zzss.hashCode(this.zzjc)) + zzss.hashCode(this.zzjd)) + zzss.hashCode(this.zzje)) + zzss.hashCode(this.zzjf)) + zzss.hashCode(this.zzjg));
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
         return this.zzg(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zziX != null && this.zziX.length > 0) {
            for(int var12 = 0; var12 < this.zziX.length; ++var12) {
               var1.zzA(1, this.zziX[var12]);
            }
         }

         if(this.zziY != null && this.zziY.length > 0) {
            for(int var11 = 0; var11 < this.zziY.length; ++var11) {
               var1.zzA(2, this.zziY[var11]);
            }
         }

         if(this.zziZ != null && this.zziZ.length > 0) {
            for(int var10 = 0; var10 < this.zziZ.length; ++var10) {
               var1.zzA(3, this.zziZ[var10]);
            }
         }

         if(this.zzja != null && this.zzja.length > 0) {
            for(int var9 = 0; var9 < this.zzja.length; ++var9) {
               var1.zzA(4, this.zzja[var9]);
            }
         }

         if(this.zzjb != null && this.zzjb.length > 0) {
            for(int var8 = 0; var8 < this.zzjb.length; ++var8) {
               var1.zzA(5, this.zzjb[var8]);
            }
         }

         if(this.zzjc != null && this.zzjc.length > 0) {
            for(int var7 = 0; var7 < this.zzjc.length; ++var7) {
               var1.zzA(6, this.zzjc[var7]);
            }
         }

         if(this.zzjd != null && this.zzjd.length > 0) {
            for(int var6 = 0; var6 < this.zzjd.length; ++var6) {
               var1.zzA(7, this.zzjd[var6]);
            }
         }

         if(this.zzje != null && this.zzje.length > 0) {
            for(int var5 = 0; var5 < this.zzje.length; ++var5) {
               var1.zzA(8, this.zzje[var5]);
            }
         }

         if(this.zzjf != null && this.zzjf.length > 0) {
            for(int var4 = 0; var4 < this.zzjf.length; ++var4) {
               var1.zzA(9, this.zzjf[var4]);
            }
         }

         if(this.zzjg != null) {
            int var2 = this.zzjg.length;
            int var3 = 0;
            if(var2 > 0) {
               while(var3 < this.zzjg.length) {
                  var1.zzA(10, this.zzjg[var3]);
                  ++var3;
               }
            }
         }

         super.writeTo(var1);
      }

      public zzaf.zzg zzL() {
         this.zziX = zzsx.zzbuw;
         this.zziY = zzsx.zzbuw;
         this.zziZ = zzsx.zzbuw;
         this.zzja = zzsx.zzbuw;
         this.zzjb = zzsx.zzbuw;
         this.zzjc = zzsx.zzbuw;
         this.zzjd = zzsx.zzbuw;
         this.zzje = zzsx.zzbuw;
         this.zzjf = zzsx.zzbuw;
         this.zzjg = zzsx.zzbuw;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzaf.zzg zzg(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var100;
            int[] var101;
            switch(var2) {
            case 8:
               int var99 = zzsx.zzc(var1, 8);
               if(this.zziX == null) {
                  var100 = 0;
               } else {
                  var100 = this.zziX.length;
               }

               var101 = new int[var99 + var100];
               if(var100 != 0) {
                  System.arraycopy(this.zziX, 0, var101, 0, var100);
               }
               break;
            case 10:
               int var93 = var1.zzmq(var1.zzJf());
               int var94 = var1.getPosition();

               int var95;
               for(var95 = 0; var1.zzJk() > 0; ++var95) {
                  var1.zzJb();
               }

               var1.zzms(var94);
               int var96;
               if(this.zziX == null) {
                  var96 = 0;
               } else {
                  var96 = this.zziX.length;
               }

               int[] var97 = new int[var95 + var96];
               if(var96 != 0) {
                  System.arraycopy(this.zziX, 0, var97, 0, var96);
               }

               while(var96 < var97.length) {
                  var97[var96] = var1.zzJb();
                  ++var96;
               }

               this.zziX = var97;
               var1.zzmr(var93);
               continue;
            case 16:
               int var89 = zzsx.zzc(var1, 16);
               int var90;
               if(this.zziY == null) {
                  var90 = 0;
               } else {
                  var90 = this.zziY.length;
               }

               int[] var91 = new int[var89 + var90];
               if(var90 != 0) {
                  System.arraycopy(this.zziY, 0, var91, 0, var90);
               }

               while(var90 < -1 + var91.length) {
                  var91[var90] = var1.zzJb();
                  var1.zzIX();
                  ++var90;
               }

               var91[var90] = var1.zzJb();
               this.zziY = var91;
               continue;
            case 18:
               int var83 = var1.zzmq(var1.zzJf());
               int var84 = var1.getPosition();

               int var85;
               for(var85 = 0; var1.zzJk() > 0; ++var85) {
                  var1.zzJb();
               }

               var1.zzms(var84);
               int var86;
               if(this.zziY == null) {
                  var86 = 0;
               } else {
                  var86 = this.zziY.length;
               }

               int[] var87 = new int[var85 + var86];
               if(var86 != 0) {
                  System.arraycopy(this.zziY, 0, var87, 0, var86);
               }

               while(var86 < var87.length) {
                  var87[var86] = var1.zzJb();
                  ++var86;
               }

               this.zziY = var87;
               var1.zzmr(var83);
               continue;
            case 24:
               int var79 = zzsx.zzc(var1, 24);
               int var80;
               if(this.zziZ == null) {
                  var80 = 0;
               } else {
                  var80 = this.zziZ.length;
               }

               int[] var81 = new int[var79 + var80];
               if(var80 != 0) {
                  System.arraycopy(this.zziZ, 0, var81, 0, var80);
               }

               while(var80 < -1 + var81.length) {
                  var81[var80] = var1.zzJb();
                  var1.zzIX();
                  ++var80;
               }

               var81[var80] = var1.zzJb();
               this.zziZ = var81;
               continue;
            case 26:
               int var73 = var1.zzmq(var1.zzJf());
               int var74 = var1.getPosition();

               int var75;
               for(var75 = 0; var1.zzJk() > 0; ++var75) {
                  var1.zzJb();
               }

               var1.zzms(var74);
               int var76;
               if(this.zziZ == null) {
                  var76 = 0;
               } else {
                  var76 = this.zziZ.length;
               }

               int[] var77 = new int[var75 + var76];
               if(var76 != 0) {
                  System.arraycopy(this.zziZ, 0, var77, 0, var76);
               }

               while(var76 < var77.length) {
                  var77[var76] = var1.zzJb();
                  ++var76;
               }

               this.zziZ = var77;
               var1.zzmr(var73);
               continue;
            case 32:
               int var69 = zzsx.zzc(var1, 32);
               int var70;
               if(this.zzja == null) {
                  var70 = 0;
               } else {
                  var70 = this.zzja.length;
               }

               int[] var71 = new int[var69 + var70];
               if(var70 != 0) {
                  System.arraycopy(this.zzja, 0, var71, 0, var70);
               }

               while(var70 < -1 + var71.length) {
                  var71[var70] = var1.zzJb();
                  var1.zzIX();
                  ++var70;
               }

               var71[var70] = var1.zzJb();
               this.zzja = var71;
               continue;
            case 34:
               int var63 = var1.zzmq(var1.zzJf());
               int var64 = var1.getPosition();

               int var65;
               for(var65 = 0; var1.zzJk() > 0; ++var65) {
                  var1.zzJb();
               }

               var1.zzms(var64);
               int var66;
               if(this.zzja == null) {
                  var66 = 0;
               } else {
                  var66 = this.zzja.length;
               }

               int[] var67 = new int[var65 + var66];
               if(var66 != 0) {
                  System.arraycopy(this.zzja, 0, var67, 0, var66);
               }

               while(var66 < var67.length) {
                  var67[var66] = var1.zzJb();
                  ++var66;
               }

               this.zzja = var67;
               var1.zzmr(var63);
               continue;
            case 40:
               int var59 = zzsx.zzc(var1, 40);
               int var60;
               if(this.zzjb == null) {
                  var60 = 0;
               } else {
                  var60 = this.zzjb.length;
               }

               int[] var61 = new int[var59 + var60];
               if(var60 != 0) {
                  System.arraycopy(this.zzjb, 0, var61, 0, var60);
               }

               while(var60 < -1 + var61.length) {
                  var61[var60] = var1.zzJb();
                  var1.zzIX();
                  ++var60;
               }

               var61[var60] = var1.zzJb();
               this.zzjb = var61;
               continue;
            case 42:
               int var53 = var1.zzmq(var1.zzJf());
               int var54 = var1.getPosition();

               int var55;
               for(var55 = 0; var1.zzJk() > 0; ++var55) {
                  var1.zzJb();
               }

               var1.zzms(var54);
               int var56;
               if(this.zzjb == null) {
                  var56 = 0;
               } else {
                  var56 = this.zzjb.length;
               }

               int[] var57 = new int[var55 + var56];
               if(var56 != 0) {
                  System.arraycopy(this.zzjb, 0, var57, 0, var56);
               }

               while(var56 < var57.length) {
                  var57[var56] = var1.zzJb();
                  ++var56;
               }

               this.zzjb = var57;
               var1.zzmr(var53);
               continue;
            case 48:
               int var49 = zzsx.zzc(var1, 48);
               int var50;
               if(this.zzjc == null) {
                  var50 = 0;
               } else {
                  var50 = this.zzjc.length;
               }

               int[] var51 = new int[var49 + var50];
               if(var50 != 0) {
                  System.arraycopy(this.zzjc, 0, var51, 0, var50);
               }

               while(var50 < -1 + var51.length) {
                  var51[var50] = var1.zzJb();
                  var1.zzIX();
                  ++var50;
               }

               var51[var50] = var1.zzJb();
               this.zzjc = var51;
               continue;
            case 50:
               int var43 = var1.zzmq(var1.zzJf());
               int var44 = var1.getPosition();

               int var45;
               for(var45 = 0; var1.zzJk() > 0; ++var45) {
                  var1.zzJb();
               }

               var1.zzms(var44);
               int var46;
               if(this.zzjc == null) {
                  var46 = 0;
               } else {
                  var46 = this.zzjc.length;
               }

               int[] var47 = new int[var45 + var46];
               if(var46 != 0) {
                  System.arraycopy(this.zzjc, 0, var47, 0, var46);
               }

               while(var46 < var47.length) {
                  var47[var46] = var1.zzJb();
                  ++var46;
               }

               this.zzjc = var47;
               var1.zzmr(var43);
               continue;
            case 56:
               int var39 = zzsx.zzc(var1, 56);
               int var40;
               if(this.zzjd == null) {
                  var40 = 0;
               } else {
                  var40 = this.zzjd.length;
               }

               int[] var41 = new int[var39 + var40];
               if(var40 != 0) {
                  System.arraycopy(this.zzjd, 0, var41, 0, var40);
               }

               while(var40 < -1 + var41.length) {
                  var41[var40] = var1.zzJb();
                  var1.zzIX();
                  ++var40;
               }

               var41[var40] = var1.zzJb();
               this.zzjd = var41;
               continue;
            case 58:
               int var33 = var1.zzmq(var1.zzJf());
               int var34 = var1.getPosition();

               int var35;
               for(var35 = 0; var1.zzJk() > 0; ++var35) {
                  var1.zzJb();
               }

               var1.zzms(var34);
               int var36;
               if(this.zzjd == null) {
                  var36 = 0;
               } else {
                  var36 = this.zzjd.length;
               }

               int[] var37 = new int[var35 + var36];
               if(var36 != 0) {
                  System.arraycopy(this.zzjd, 0, var37, 0, var36);
               }

               while(var36 < var37.length) {
                  var37[var36] = var1.zzJb();
                  ++var36;
               }

               this.zzjd = var37;
               var1.zzmr(var33);
               continue;
            case 64:
               int var29 = zzsx.zzc(var1, 64);
               int var30;
               if(this.zzje == null) {
                  var30 = 0;
               } else {
                  var30 = this.zzje.length;
               }

               int[] var31 = new int[var29 + var30];
               if(var30 != 0) {
                  System.arraycopy(this.zzje, 0, var31, 0, var30);
               }

               while(var30 < -1 + var31.length) {
                  var31[var30] = var1.zzJb();
                  var1.zzIX();
                  ++var30;
               }

               var31[var30] = var1.zzJb();
               this.zzje = var31;
               continue;
            case 66:
               int var23 = var1.zzmq(var1.zzJf());
               int var24 = var1.getPosition();

               int var25;
               for(var25 = 0; var1.zzJk() > 0; ++var25) {
                  var1.zzJb();
               }

               var1.zzms(var24);
               int var26;
               if(this.zzje == null) {
                  var26 = 0;
               } else {
                  var26 = this.zzje.length;
               }

               int[] var27 = new int[var25 + var26];
               if(var26 != 0) {
                  System.arraycopy(this.zzje, 0, var27, 0, var26);
               }

               while(var26 < var27.length) {
                  var27[var26] = var1.zzJb();
                  ++var26;
               }

               this.zzje = var27;
               var1.zzmr(var23);
               continue;
            case 72:
               int var19 = zzsx.zzc(var1, 72);
               int var20;
               if(this.zzjf == null) {
                  var20 = 0;
               } else {
                  var20 = this.zzjf.length;
               }

               int[] var21 = new int[var19 + var20];
               if(var20 != 0) {
                  System.arraycopy(this.zzjf, 0, var21, 0, var20);
               }

               while(var20 < -1 + var21.length) {
                  var21[var20] = var1.zzJb();
                  var1.zzIX();
                  ++var20;
               }

               var21[var20] = var1.zzJb();
               this.zzjf = var21;
               continue;
            case 74:
               int var13 = var1.zzmq(var1.zzJf());
               int var14 = var1.getPosition();

               int var15;
               for(var15 = 0; var1.zzJk() > 0; ++var15) {
                  var1.zzJb();
               }

               var1.zzms(var14);
               int var16;
               if(this.zzjf == null) {
                  var16 = 0;
               } else {
                  var16 = this.zzjf.length;
               }

               int[] var17 = new int[var15 + var16];
               if(var16 != 0) {
                  System.arraycopy(this.zzjf, 0, var17, 0, var16);
               }

               while(var16 < var17.length) {
                  var17[var16] = var1.zzJb();
                  ++var16;
               }

               this.zzjf = var17;
               var1.zzmr(var13);
               continue;
            case 80:
               int var9 = zzsx.zzc(var1, 80);
               int var10;
               if(this.zzjg == null) {
                  var10 = 0;
               } else {
                  var10 = this.zzjg.length;
               }

               int[] var11 = new int[var9 + var10];
               if(var10 != 0) {
                  System.arraycopy(this.zzjg, 0, var11, 0, var10);
               }

               while(var10 < -1 + var11.length) {
                  var11[var10] = var1.zzJb();
                  var1.zzIX();
                  ++var10;
               }

               var11[var10] = var1.zzJb();
               this.zzjg = var11;
               continue;
            case 82:
               int var3 = var1.zzmq(var1.zzJf());
               int var4 = var1.getPosition();

               int var5;
               for(var5 = 0; var1.zzJk() > 0; ++var5) {
                  var1.zzJb();
               }

               var1.zzms(var4);
               int var6;
               if(this.zzjg == null) {
                  var6 = 0;
               } else {
                  var6 = this.zzjg.length;
               }

               int[] var7 = new int[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.zzjg, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.zzJb();
                  ++var6;
               }

               this.zzjg = var7;
               var1.zzmr(var3);
               continue;
            default:
               if(this.zza(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var100 < -1 + var101.length) {
               var101[var100] = var1.zzJb();
               var1.zzIX();
               ++var100;
            }

            var101[var100] = var1.zzJb();
            this.zziX = var101;
         }
      }

      protected int zzz() {
         int var1 = 0;
         int var2 = super.zzz();
         int var3;
         if(this.zziX != null && this.zziX.length > 0) {
            int var21 = 0;

            int var22;
            for(var22 = 0; var21 < this.zziX.length; ++var21) {
               var22 += zzsn.zzmx(this.zziX[var21]);
            }

            var3 = var2 + var22 + 1 * this.zziX.length;
         } else {
            var3 = var2;
         }

         if(this.zziY != null && this.zziY.length > 0) {
            int var19 = 0;

            int var20;
            for(var20 = 0; var19 < this.zziY.length; ++var19) {
               var20 += zzsn.zzmx(this.zziY[var19]);
            }

            var3 = var3 + var20 + 1 * this.zziY.length;
         }

         if(this.zziZ != null && this.zziZ.length > 0) {
            int var17 = 0;

            int var18;
            for(var18 = 0; var17 < this.zziZ.length; ++var17) {
               var18 += zzsn.zzmx(this.zziZ[var17]);
            }

            var3 = var3 + var18 + 1 * this.zziZ.length;
         }

         if(this.zzja != null && this.zzja.length > 0) {
            int var15 = 0;

            int var16;
            for(var16 = 0; var15 < this.zzja.length; ++var15) {
               var16 += zzsn.zzmx(this.zzja[var15]);
            }

            var3 = var3 + var16 + 1 * this.zzja.length;
         }

         if(this.zzjb != null && this.zzjb.length > 0) {
            int var13 = 0;

            int var14;
            for(var14 = 0; var13 < this.zzjb.length; ++var13) {
               var14 += zzsn.zzmx(this.zzjb[var13]);
            }

            var3 = var3 + var14 + 1 * this.zzjb.length;
         }

         if(this.zzjc != null && this.zzjc.length > 0) {
            int var11 = 0;

            int var12;
            for(var12 = 0; var11 < this.zzjc.length; ++var11) {
               var12 += zzsn.zzmx(this.zzjc[var11]);
            }

            var3 = var3 + var12 + 1 * this.zzjc.length;
         }

         if(this.zzjd != null && this.zzjd.length > 0) {
            int var9 = 0;

            int var10;
            for(var10 = 0; var9 < this.zzjd.length; ++var9) {
               var10 += zzsn.zzmx(this.zzjd[var9]);
            }

            var3 = var3 + var10 + 1 * this.zzjd.length;
         }

         if(this.zzje != null && this.zzje.length > 0) {
            int var7 = 0;

            int var8;
            for(var8 = 0; var7 < this.zzje.length; ++var7) {
               var8 += zzsn.zzmx(this.zzje[var7]);
            }

            var3 = var3 + var8 + 1 * this.zzje.length;
         }

         if(this.zzjf != null && this.zzjf.length > 0) {
            int var5 = 0;

            int var6;
            for(var6 = 0; var5 < this.zzjf.length; ++var5) {
               var6 += zzsn.zzmx(this.zzjf[var5]);
            }

            var3 = var3 + var6 + 1 * this.zzjf.length;
         }

         if(this.zzjg != null && this.zzjg.length > 0) {
            int var4;
            for(var4 = 0; var1 < this.zzjg.length; ++var1) {
               var4 += zzsn.zzmx(this.zzjg[var1]);
            }

            var3 = var3 + var4 + 1 * this.zzjg.length;
         }

         return var3;
      }
   }

   public static final class zzh extends zzso<zzaf.zzh> {
      public static final zzsp<zzag.zza, zzaf.zzh> zzjh = zzsp.zza(11, zzaf.zzh.class, 810L);
      private static final zzaf.zzh[] zzji = new zzaf.zzh[0];
      public int[] zzjj;
      public int[] zzjk;
      public int[] zzjl;
      public int zzjm;
      public int[] zzjn;
      public int zzjo;
      public int zzjp;

      public zzh() {
         this.zzM();
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzaf.zzh;
            var3 = false;
            if(var2) {
               zzaf.zzh var4 = (zzaf.zzh)var1;
               boolean var5 = zzss.equals(this.zzjj, var4.zzjj);
               var3 = false;
               if(var5) {
                  boolean var6 = zzss.equals(this.zzjk, var4.zzjk);
                  var3 = false;
                  if(var6) {
                     boolean var7 = zzss.equals(this.zzjl, var4.zzjl);
                     var3 = false;
                     if(var7) {
                        int var8 = this.zzjm;
                        int var9 = var4.zzjm;
                        var3 = false;
                        if(var8 == var9) {
                           boolean var10 = zzss.equals(this.zzjn, var4.zzjn);
                           var3 = false;
                           if(var10) {
                              int var11 = this.zzjo;
                              int var12 = var4.zzjo;
                              var3 = false;
                              if(var11 == var12) {
                                 int var13 = this.zzjp;
                                 int var14 = var4.zzjp;
                                 var3 = false;
                                 if(var13 == var14) {
                                    if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
                                       return this.zzbuj.equals(var4.zzbuj);
                                    }

                                    if(var4.zzbuj == null) {
                                       return true;
                                    }

                                    boolean var15 = var4.zzbuj.isEmpty();
                                    var3 = false;
                                    if(var15) {
                                       return true;
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + this.getClass().getName().hashCode()) + zzss.hashCode(this.zzjj)) + zzss.hashCode(this.zzjk)) + zzss.hashCode(this.zzjl)) + this.zzjm) + zzss.hashCode(this.zzjn)) + this.zzjo) + this.zzjp);
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
         return this.zzh(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzjj != null && this.zzjj.length > 0) {
            for(int var6 = 0; var6 < this.zzjj.length; ++var6) {
               var1.zzA(1, this.zzjj[var6]);
            }
         }

         if(this.zzjk != null && this.zzjk.length > 0) {
            for(int var5 = 0; var5 < this.zzjk.length; ++var5) {
               var1.zzA(2, this.zzjk[var5]);
            }
         }

         if(this.zzjl != null && this.zzjl.length > 0) {
            for(int var4 = 0; var4 < this.zzjl.length; ++var4) {
               var1.zzA(3, this.zzjl[var4]);
            }
         }

         if(this.zzjm != 0) {
            var1.zzA(4, this.zzjm);
         }

         if(this.zzjn != null) {
            int var2 = this.zzjn.length;
            int var3 = 0;
            if(var2 > 0) {
               while(var3 < this.zzjn.length) {
                  var1.zzA(5, this.zzjn[var3]);
                  ++var3;
               }
            }
         }

         if(this.zzjo != 0) {
            var1.zzA(6, this.zzjo);
         }

         if(this.zzjp != 0) {
            var1.zzA(7, this.zzjp);
         }

         super.writeTo(var1);
      }

      public zzaf.zzh zzM() {
         this.zzjj = zzsx.zzbuw;
         this.zzjk = zzsx.zzbuw;
         this.zzjl = zzsx.zzbuw;
         this.zzjm = 0;
         this.zzjn = zzsx.zzbuw;
         this.zzjo = 0;
         this.zzjp = 0;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzaf.zzh zzh(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var40;
            int[] var41;
            switch(var2) {
            case 8:
               int var39 = zzsx.zzc(var1, 8);
               if(this.zzjj == null) {
                  var40 = 0;
               } else {
                  var40 = this.zzjj.length;
               }

               var41 = new int[var39 + var40];
               if(var40 != 0) {
                  System.arraycopy(this.zzjj, 0, var41, 0, var40);
               }
               break;
            case 10:
               int var33 = var1.zzmq(var1.zzJf());
               int var34 = var1.getPosition();

               int var35;
               for(var35 = 0; var1.zzJk() > 0; ++var35) {
                  var1.zzJb();
               }

               var1.zzms(var34);
               int var36;
               if(this.zzjj == null) {
                  var36 = 0;
               } else {
                  var36 = this.zzjj.length;
               }

               int[] var37 = new int[var35 + var36];
               if(var36 != 0) {
                  System.arraycopy(this.zzjj, 0, var37, 0, var36);
               }

               while(var36 < var37.length) {
                  var37[var36] = var1.zzJb();
                  ++var36;
               }

               this.zzjj = var37;
               var1.zzmr(var33);
               continue;
            case 16:
               int var29 = zzsx.zzc(var1, 16);
               int var30;
               if(this.zzjk == null) {
                  var30 = 0;
               } else {
                  var30 = this.zzjk.length;
               }

               int[] var31 = new int[var29 + var30];
               if(var30 != 0) {
                  System.arraycopy(this.zzjk, 0, var31, 0, var30);
               }

               while(var30 < -1 + var31.length) {
                  var31[var30] = var1.zzJb();
                  var1.zzIX();
                  ++var30;
               }

               var31[var30] = var1.zzJb();
               this.zzjk = var31;
               continue;
            case 18:
               int var23 = var1.zzmq(var1.zzJf());
               int var24 = var1.getPosition();

               int var25;
               for(var25 = 0; var1.zzJk() > 0; ++var25) {
                  var1.zzJb();
               }

               var1.zzms(var24);
               int var26;
               if(this.zzjk == null) {
                  var26 = 0;
               } else {
                  var26 = this.zzjk.length;
               }

               int[] var27 = new int[var25 + var26];
               if(var26 != 0) {
                  System.arraycopy(this.zzjk, 0, var27, 0, var26);
               }

               while(var26 < var27.length) {
                  var27[var26] = var1.zzJb();
                  ++var26;
               }

               this.zzjk = var27;
               var1.zzmr(var23);
               continue;
            case 24:
               int var19 = zzsx.zzc(var1, 24);
               int var20;
               if(this.zzjl == null) {
                  var20 = 0;
               } else {
                  var20 = this.zzjl.length;
               }

               int[] var21 = new int[var19 + var20];
               if(var20 != 0) {
                  System.arraycopy(this.zzjl, 0, var21, 0, var20);
               }

               while(var20 < -1 + var21.length) {
                  var21[var20] = var1.zzJb();
                  var1.zzIX();
                  ++var20;
               }

               var21[var20] = var1.zzJb();
               this.zzjl = var21;
               continue;
            case 26:
               int var13 = var1.zzmq(var1.zzJf());
               int var14 = var1.getPosition();

               int var15;
               for(var15 = 0; var1.zzJk() > 0; ++var15) {
                  var1.zzJb();
               }

               var1.zzms(var14);
               int var16;
               if(this.zzjl == null) {
                  var16 = 0;
               } else {
                  var16 = this.zzjl.length;
               }

               int[] var17 = new int[var15 + var16];
               if(var16 != 0) {
                  System.arraycopy(this.zzjl, 0, var17, 0, var16);
               }

               while(var16 < var17.length) {
                  var17[var16] = var1.zzJb();
                  ++var16;
               }

               this.zzjl = var17;
               var1.zzmr(var13);
               continue;
            case 32:
               this.zzjm = var1.zzJb();
               continue;
            case 40:
               int var9 = zzsx.zzc(var1, 40);
               int var10;
               if(this.zzjn == null) {
                  var10 = 0;
               } else {
                  var10 = this.zzjn.length;
               }

               int[] var11 = new int[var9 + var10];
               if(var10 != 0) {
                  System.arraycopy(this.zzjn, 0, var11, 0, var10);
               }

               while(var10 < -1 + var11.length) {
                  var11[var10] = var1.zzJb();
                  var1.zzIX();
                  ++var10;
               }

               var11[var10] = var1.zzJb();
               this.zzjn = var11;
               continue;
            case 42:
               int var3 = var1.zzmq(var1.zzJf());
               int var4 = var1.getPosition();

               int var5;
               for(var5 = 0; var1.zzJk() > 0; ++var5) {
                  var1.zzJb();
               }

               var1.zzms(var4);
               int var6;
               if(this.zzjn == null) {
                  var6 = 0;
               } else {
                  var6 = this.zzjn.length;
               }

               int[] var7 = new int[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.zzjn, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.zzJb();
                  ++var6;
               }

               this.zzjn = var7;
               var1.zzmr(var3);
               continue;
            case 48:
               this.zzjo = var1.zzJb();
               continue;
            case 56:
               this.zzjp = var1.zzJb();
               continue;
            default:
               if(this.zza(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var40 < -1 + var41.length) {
               var41[var40] = var1.zzJb();
               var1.zzIX();
               ++var40;
            }

            var41[var40] = var1.zzJb();
            this.zzjj = var41;
         }
      }

      protected int zzz() {
         int var1 = 0;
         int var2 = super.zzz();
         int var3;
         if(this.zzjj != null && this.zzjj.length > 0) {
            int var9 = 0;

            int var10;
            for(var10 = 0; var9 < this.zzjj.length; ++var9) {
               var10 += zzsn.zzmx(this.zzjj[var9]);
            }

            var3 = var2 + var10 + 1 * this.zzjj.length;
         } else {
            var3 = var2;
         }

         if(this.zzjk != null && this.zzjk.length > 0) {
            int var7 = 0;

            int var8;
            for(var8 = 0; var7 < this.zzjk.length; ++var7) {
               var8 += zzsn.zzmx(this.zzjk[var7]);
            }

            var3 = var3 + var8 + 1 * this.zzjk.length;
         }

         if(this.zzjl != null && this.zzjl.length > 0) {
            int var5 = 0;

            int var6;
            for(var6 = 0; var5 < this.zzjl.length; ++var5) {
               var6 += zzsn.zzmx(this.zzjl[var5]);
            }

            var3 = var3 + var6 + 1 * this.zzjl.length;
         }

         if(this.zzjm != 0) {
            var3 += zzsn.zzC(4, this.zzjm);
         }

         if(this.zzjn != null && this.zzjn.length > 0) {
            int var4;
            for(var4 = 0; var1 < this.zzjn.length; ++var1) {
               var4 += zzsn.zzmx(this.zzjn[var1]);
            }

            var3 = var3 + var4 + 1 * this.zzjn.length;
         }

         if(this.zzjo != 0) {
            var3 += zzsn.zzC(6, this.zzjo);
         }

         if(this.zzjp != 0) {
            var3 += zzsn.zzC(7, this.zzjp);
         }

         return var3;
      }
   }

   public static final class zzi extends zzso<zzaf.zzi> {
      private static volatile zzaf.zzi[] zzjq;
      public String name;
      public zzag.zza zzjr;
      public zzaf.zzd zzjs;

      public zzi() {
         this.zzO();
      }

      public static zzaf.zzi[] zzN() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzaf.zzi;
            var3 = false;
            if(var2) {
               zzaf.zzi var4 = (zzaf.zzi)var1;
               if(this.name == null) {
                  String var8 = var4.name;
                  var3 = false;
                  if(var8 != null) {
                     return var3;
                  }
               } else if(!this.name.equals(var4.name)) {
                  return false;
               }

               if(this.zzjr == null) {
                  zzag.zza var7 = var4.zzjr;
                  var3 = false;
                  if(var7 != null) {
                     return var3;
                  }
               } else if(!this.zzjr.equals(var4.zzjr)) {
                  return false;
               }

               if(this.zzjs == null) {
                  zzaf.zzd var6 = var4.zzjs;
                  var3 = false;
                  if(var6 != null) {
                     return var3;
                  }
               } else if(!this.zzjs.equals(var4.zzjs)) {
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
         if(this.zzjr == null) {
            var4 = 0;
         } else {
            var4 = this.zzjr.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         int var6;
         if(this.zzjs == null) {
            var6 = 0;
         } else {
            var6 = this.zzjs.hashCode();
         }

         int var7 = 31 * (var6 + var5);
         zzsq var8 = this.zzbuj;
         int var9 = 0;
         if(var8 != null) {
            boolean var10 = this.zzbuj.isEmpty();
            var9 = 0;
            if(!var10) {
               var9 = this.zzbuj.hashCode();
            }
         }

         return var7 + var9;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzi(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(!this.name.equals("")) {
            var1.zzn(1, this.name);
         }

         if(this.zzjr != null) {
            var1.zza(2, (zzsu)this.zzjr);
         }

         if(this.zzjs != null) {
            var1.zza(3, (zzsu)this.zzjs);
         }

         super.writeTo(var1);
      }

      public zzaf.zzi zzO() {
         this.name = "";
         this.zzjr = null;
         this.zzjs = null;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzaf.zzi zzi(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            switch(var2) {
            case 10:
               this.name = var1.readString();
               break;
            case 18:
               if(this.zzjr == null) {
                  this.zzjr = new zzag.zza();
               }

               var1.zza(this.zzjr);
               break;
            case 26:
               if(this.zzjs == null) {
                  this.zzjs = new zzaf.zzd();
               }

               var1.zza(this.zzjs);
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
         int var1 = super.zzz();
         if(!this.name.equals("")) {
            var1 += zzsn.zzo(1, this.name);
         }

         if(this.zzjr != null) {
            var1 += zzsn.zzc(2, this.zzjr);
         }

         if(this.zzjs != null) {
            var1 += zzsn.zzc(3, this.zzjs);
         }

         return var1;
      }
   }

   public static final class zzj extends zzso<zzaf.zzj> {
      public zzaf.zzi[] zzjt;
      public zzaf.zzf zzju;
      public String zzjv;

      public zzj() {
         this.zzP();
      }

      public static zzaf.zzj zzd(byte[] var0) throws zzst {
         return (zzaf.zzj)zzsu.mergeFrom(new zzaf.zzj(), var0);
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzaf.zzj;
            var3 = false;
            if(var2) {
               zzaf.zzj var4 = (zzaf.zzj)var1;
               boolean var5 = zzss.equals((Object[])this.zzjt, (Object[])var4.zzjt);
               var3 = false;
               if(var5) {
                  if(this.zzju == null) {
                     zzaf.zzf var8 = var4.zzju;
                     var3 = false;
                     if(var8 != null) {
                        return var3;
                     }
                  } else if(!this.zzju.equals(var4.zzju)) {
                     return false;
                  }

                  if(this.zzjv == null) {
                     String var7 = var4.zzjv;
                     var3 = false;
                     if(var7 != null) {
                        return var3;
                     }
                  } else if(!this.zzjv.equals(var4.zzjv)) {
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
         int var1 = 31 * (31 * (527 + this.getClass().getName().hashCode()) + zzss.hashCode((Object[])this.zzjt));
         int var2;
         if(this.zzju == null) {
            var2 = 0;
         } else {
            var2 = this.zzju.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.zzjv == null) {
            var4 = 0;
         } else {
            var4 = this.zzjv.hashCode();
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
         return this.zzj(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzjt != null && this.zzjt.length > 0) {
            for(int var2 = 0; var2 < this.zzjt.length; ++var2) {
               zzaf.zzi var3 = this.zzjt[var2];
               if(var3 != null) {
                  var1.zza(1, (zzsu)var3);
               }
            }
         }

         if(this.zzju != null) {
            var1.zza(2, (zzsu)this.zzju);
         }

         if(!this.zzjv.equals("")) {
            var1.zzn(3, this.zzjv);
         }

         super.writeTo(var1);
      }

      public zzaf.zzj zzP() {
         this.zzjt = zzaf.zzi.zzN();
         this.zzju = null;
         this.zzjv = "";
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzaf.zzj zzj(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var4;
            zzaf.zzi[] var5;
            switch(var2) {
            case 10:
               int var3 = zzsx.zzc(var1, 10);
               if(this.zzjt == null) {
                  var4 = 0;
               } else {
                  var4 = this.zzjt.length;
               }

               var5 = new zzaf.zzi[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.zzjt, 0, var5, 0, var4);
               }
               break;
            case 18:
               if(this.zzju == null) {
                  this.zzju = new zzaf.zzf();
               }

               var1.zza(this.zzju);
               continue;
            case 26:
               this.zzjv = var1.readString();
               continue;
            default:
               if(this.zza(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var4 < -1 + var5.length) {
               var5[var4] = new zzaf.zzi();
               var1.zza(var5[var4]);
               var1.zzIX();
               ++var4;
            }

            var5[var4] = new zzaf.zzi();
            var1.zza(var5[var4]);
            this.zzjt = var5;
         }
      }

      protected int zzz() {
         int var1 = super.zzz();
         if(this.zzjt != null && this.zzjt.length > 0) {
            for(int var2 = 0; var2 < this.zzjt.length; ++var2) {
               zzaf.zzi var3 = this.zzjt[var2];
               if(var3 != null) {
                  var1 += zzsn.zzc(1, var3);
               }
            }
         }

         if(this.zzju != null) {
            var1 += zzsn.zzc(2, this.zzju);
         }

         if(!this.zzjv.equals("")) {
            var1 += zzsn.zzo(3, this.zzjv);
         }

         return var1;
      }
   }
}
