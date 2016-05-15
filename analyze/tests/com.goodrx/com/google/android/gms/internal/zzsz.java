package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzsq;
import com.google.android.gms.internal.zzss;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsx;
import java.io.IOException;
import java.util.Arrays;

public interface zzsz {
   public static final class zza extends zzso<zzsz.zza> {
      public String[] zzbuI;
      public String[] zzbuJ;
      public int[] zzbuK;
      public long[] zzbuL;

      public zza() {
         this.zzJC();
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzsz.zza;
            var3 = false;
            if(var2) {
               zzsz.zza var4 = (zzsz.zza)var1;
               boolean var5 = zzss.equals((Object[])this.zzbuI, (Object[])var4.zzbuI);
               var3 = false;
               if(var5) {
                  boolean var6 = zzss.equals((Object[])this.zzbuJ, (Object[])var4.zzbuJ);
                  var3 = false;
                  if(var6) {
                     boolean var7 = zzss.equals(this.zzbuK, var4.zzbuK);
                     var3 = false;
                     if(var7) {
                        boolean var8 = zzss.equals(this.zzbuL, var4.zzbuL);
                        var3 = false;
                        if(var8) {
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
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (31 * (31 * (31 * (31 * (527 + this.getClass().getName().hashCode()) + zzss.hashCode((Object[])this.zzbuI)) + zzss.hashCode((Object[])this.zzbuJ)) + zzss.hashCode(this.zzbuK)) + zzss.hashCode(this.zzbuL));
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
         return this.zzS(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzbuI != null && this.zzbuI.length > 0) {
            for(int var7 = 0; var7 < this.zzbuI.length; ++var7) {
               String var8 = this.zzbuI[var7];
               if(var8 != null) {
                  var1.zzn(1, var8);
               }
            }
         }

         if(this.zzbuJ != null && this.zzbuJ.length > 0) {
            for(int var5 = 0; var5 < this.zzbuJ.length; ++var5) {
               String var6 = this.zzbuJ[var5];
               if(var6 != null) {
                  var1.zzn(2, var6);
               }
            }
         }

         if(this.zzbuK != null && this.zzbuK.length > 0) {
            for(int var4 = 0; var4 < this.zzbuK.length; ++var4) {
               var1.zzA(3, this.zzbuK[var4]);
            }
         }

         if(this.zzbuL != null) {
            int var2 = this.zzbuL.length;
            int var3 = 0;
            if(var2 > 0) {
               while(var3 < this.zzbuL.length) {
                  var1.zzb(4, this.zzbuL[var3]);
                  ++var3;
               }
            }
         }

         super.writeTo(var1);
      }

      public zzsz.zza zzJC() {
         this.zzbuI = zzsx.zzbuB;
         this.zzbuJ = zzsx.zzbuB;
         this.zzbuK = zzsx.zzbuw;
         this.zzbuL = zzsx.zzbux;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzsz.zza zzS(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var29;
            String[] var30;
            switch(var2) {
            case 10:
               int var28 = zzsx.zzc(var1, 10);
               if(this.zzbuI == null) {
                  var29 = 0;
               } else {
                  var29 = this.zzbuI.length;
               }

               var30 = new String[var28 + var29];
               if(var29 != 0) {
                  System.arraycopy(this.zzbuI, 0, var30, 0, var29);
               }
               break;
            case 18:
               int var24 = zzsx.zzc(var1, 18);
               int var25;
               if(this.zzbuJ == null) {
                  var25 = 0;
               } else {
                  var25 = this.zzbuJ.length;
               }

               String[] var26 = new String[var24 + var25];
               if(var25 != 0) {
                  System.arraycopy(this.zzbuJ, 0, var26, 0, var25);
               }

               while(var25 < -1 + var26.length) {
                  var26[var25] = var1.readString();
                  var1.zzIX();
                  ++var25;
               }

               var26[var25] = var1.readString();
               this.zzbuJ = var26;
               continue;
            case 24:
               int var20 = zzsx.zzc(var1, 24);
               int var21;
               if(this.zzbuK == null) {
                  var21 = 0;
               } else {
                  var21 = this.zzbuK.length;
               }

               int[] var22 = new int[var20 + var21];
               if(var21 != 0) {
                  System.arraycopy(this.zzbuK, 0, var22, 0, var21);
               }

               while(var21 < -1 + var22.length) {
                  var22[var21] = var1.zzJb();
                  var1.zzIX();
                  ++var21;
               }

               var22[var21] = var1.zzJb();
               this.zzbuK = var22;
               continue;
            case 26:
               int var14 = var1.zzmq(var1.zzJf());
               int var15 = var1.getPosition();

               int var16;
               for(var16 = 0; var1.zzJk() > 0; ++var16) {
                  var1.zzJb();
               }

               var1.zzms(var15);
               int var17;
               if(this.zzbuK == null) {
                  var17 = 0;
               } else {
                  var17 = this.zzbuK.length;
               }

               int[] var18 = new int[var16 + var17];
               if(var17 != 0) {
                  System.arraycopy(this.zzbuK, 0, var18, 0, var17);
               }

               while(var17 < var18.length) {
                  var18[var17] = var1.zzJb();
                  ++var17;
               }

               this.zzbuK = var18;
               var1.zzmr(var14);
               continue;
            case 32:
               int var10 = zzsx.zzc(var1, 32);
               int var11;
               if(this.zzbuL == null) {
                  var11 = 0;
               } else {
                  var11 = this.zzbuL.length;
               }

               long[] var12 = new long[var10 + var11];
               if(var11 != 0) {
                  System.arraycopy(this.zzbuL, 0, var12, 0, var11);
               }

               while(var11 < -1 + var12.length) {
                  var12[var11] = var1.zzJa();
                  var1.zzIX();
                  ++var11;
               }

               var12[var11] = var1.zzJa();
               this.zzbuL = var12;
               continue;
            case 34:
               int var3 = var1.zzmq(var1.zzJf());
               int var4 = var1.getPosition();

               int var5;
               for(var5 = 0; var1.zzJk() > 0; ++var5) {
                  var1.zzJa();
               }

               var1.zzms(var4);
               int var6;
               if(this.zzbuL == null) {
                  var6 = 0;
               } else {
                  var6 = this.zzbuL.length;
               }

               long[] var7 = new long[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.zzbuL, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.zzJa();
                  ++var6;
               }

               this.zzbuL = var7;
               var1.zzmr(var3);
               continue;
            default:
               if(this.zza(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var29 < -1 + var30.length) {
               var30[var29] = var1.readString();
               var1.zzIX();
               ++var29;
            }

            var30[var29] = var1.readString();
            this.zzbuI = var30;
         }
      }

      protected int zzz() {
         int var1 = 0;
         int var2 = super.zzz();
         int var3;
         if(this.zzbuI != null && this.zzbuI.length > 0) {
            int var11 = 0;
            int var12 = 0;

            int var13;
            for(var13 = 0; var11 < this.zzbuI.length; ++var11) {
               String var14 = this.zzbuI[var11];
               if(var14 != null) {
                  ++var13;
                  var12 += zzsn.zzgO(var14);
               }
            }

            var3 = var2 + var12 + var13 * 1;
         } else {
            var3 = var2;
         }

         if(this.zzbuJ != null && this.zzbuJ.length > 0) {
            int var7 = 0;
            int var8 = 0;

            int var9;
            for(var9 = 0; var7 < this.zzbuJ.length; ++var7) {
               String var10 = this.zzbuJ[var7];
               if(var10 != null) {
                  ++var9;
                  var8 += zzsn.zzgO(var10);
               }
            }

            var3 = var3 + var8 + var9 * 1;
         }

         if(this.zzbuK != null && this.zzbuK.length > 0) {
            int var5 = 0;

            int var6;
            for(var6 = 0; var5 < this.zzbuK.length; ++var5) {
               var6 += zzsn.zzmx(this.zzbuK[var5]);
            }

            var3 = var3 + var6 + 1 * this.zzbuK.length;
         }

         if(this.zzbuL != null && this.zzbuL.length > 0) {
            int var4;
            for(var4 = 0; var1 < this.zzbuL.length; ++var1) {
               var4 += zzsn.zzas(this.zzbuL[var1]);
            }

            var3 = var3 + var4 + 1 * this.zzbuL.length;
         }

         return var3;
      }
   }

   public static final class zzb extends zzso<zzsz.zzb> {
      public String version;
      public int zzbuM;
      public String zzbuN;

      public zzb() {
         this.zzJD();
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzsz.zzb;
            var3 = false;
            if(var2) {
               zzsz.zzb var4 = (zzsz.zzb)var1;
               int var5 = this.zzbuM;
               int var6 = var4.zzbuM;
               var3 = false;
               if(var5 == var6) {
                  if(this.zzbuN == null) {
                     String var9 = var4.zzbuN;
                     var3 = false;
                     if(var9 != null) {
                        return var3;
                     }
                  } else if(!this.zzbuN.equals(var4.zzbuN)) {
                     return false;
                  }

                  if(this.version == null) {
                     String var8 = var4.version;
                     var3 = false;
                     if(var8 != null) {
                        return var3;
                     }
                  } else if(!this.version.equals(var4.version)) {
                     return false;
                  }

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
         int var1 = 31 * (31 * (527 + this.getClass().getName().hashCode()) + this.zzbuM);
         int var2;
         if(this.zzbuN == null) {
            var2 = 0;
         } else {
            var2 = this.zzbuN.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.version == null) {
            var4 = 0;
         } else {
            var4 = this.version.hashCode();
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
         return this.zzT(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzbuM != 0) {
            var1.zzA(1, this.zzbuM);
         }

         if(!this.zzbuN.equals("")) {
            var1.zzn(2, this.zzbuN);
         }

         if(!this.version.equals("")) {
            var1.zzn(3, this.version);
         }

         super.writeTo(var1);
      }

      public zzsz.zzb zzJD() {
         this.zzbuM = 0;
         this.zzbuN = "";
         this.version = "";
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzsz.zzb zzT(zzsm var1) throws IOException {
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
               case 5:
               case 6:
               case 7:
               case 8:
               case 9:
               case 10:
               case 11:
               case 12:
               case 13:
               case 14:
               case 15:
               case 16:
               case 17:
               case 18:
               case 19:
               case 20:
               case 21:
               case 22:
               case 23:
               case 24:
               case 25:
               case 26:
                  this.zzbuM = var3;
               default:
                  continue;
               }
            case 18:
               this.zzbuN = var1.readString();
               break;
            case 26:
               this.version = var1.readString();
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
         if(this.zzbuM != 0) {
            var1 += zzsn.zzC(1, this.zzbuM);
         }

         if(!this.zzbuN.equals("")) {
            var1 += zzsn.zzo(2, this.zzbuN);
         }

         if(!this.version.equals("")) {
            var1 += zzsn.zzo(3, this.version);
         }

         return var1;
      }
   }

   public static final class zzc extends zzso<zzsz.zzc> {
      public byte[] zzbuO;
      public byte[][] zzbuP;
      public boolean zzbuQ;

      public zzc() {
         this.zzJE();
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzsz.zzc;
            var3 = false;
            if(var2) {
               zzsz.zzc var4 = (zzsz.zzc)var1;
               boolean var5 = Arrays.equals(this.zzbuO, var4.zzbuO);
               var3 = false;
               if(var5) {
                  boolean var6 = zzss.zza(this.zzbuP, var4.zzbuP);
                  var3 = false;
                  if(var6) {
                     boolean var7 = this.zzbuQ;
                     boolean var8 = var4.zzbuQ;
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
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (31 * (31 * (527 + this.getClass().getName().hashCode()) + Arrays.hashCode(this.zzbuO)) + zzss.zza(this.zzbuP));
         short var2;
         if(this.zzbuQ) {
            var2 = 1231;
         } else {
            var2 = 1237;
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
            var4 = this.zzbuj.hashCode();
         } else {
            var4 = 0;
         }

         return var4 + var3;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzU(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(!Arrays.equals(this.zzbuO, zzsx.zzbuD)) {
            var1.zza(1, (byte[])this.zzbuO);
         }

         if(this.zzbuP != null && this.zzbuP.length > 0) {
            for(int var2 = 0; var2 < this.zzbuP.length; ++var2) {
               byte[] var3 = this.zzbuP[var2];
               if(var3 != null) {
                  var1.zza(2, (byte[])var3);
               }
            }
         }

         if(this.zzbuQ) {
            var1.zze(3, this.zzbuQ);
         }

         super.writeTo(var1);
      }

      public zzsz.zzc zzJE() {
         this.zzbuO = zzsx.zzbuD;
         this.zzbuP = zzsx.zzbuC;
         this.zzbuQ = false;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzsz.zzc zzU(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var4;
            byte[][] var5;
            switch(var2) {
            case 10:
               this.zzbuO = var1.readBytes();
               continue;
            case 18:
               int var3 = zzsx.zzc(var1, 18);
               if(this.zzbuP == null) {
                  var4 = 0;
               } else {
                  var4 = this.zzbuP.length;
               }

               var5 = new byte[var3 + var4][];
               if(var4 != 0) {
                  System.arraycopy(this.zzbuP, 0, var5, 0, var4);
               }
               break;
            case 24:
               this.zzbuQ = var1.zzJc();
               continue;
            default:
               if(this.zza(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var4 < -1 + var5.length) {
               var5[var4] = var1.readBytes();
               var1.zzIX();
               ++var4;
            }

            var5[var4] = var1.readBytes();
            this.zzbuP = var5;
         }
      }

      protected int zzz() {
         int var1 = 0;
         int var2 = super.zzz();
         if(!Arrays.equals(this.zzbuO, zzsx.zzbuD)) {
            var2 += zzsn.zzb(1, (byte[])this.zzbuO);
         }

         if(this.zzbuP != null && this.zzbuP.length > 0) {
            int var3 = 0;

            int var4;
            for(var4 = 0; var1 < this.zzbuP.length; ++var1) {
               byte[] var5 = this.zzbuP[var1];
               if(var5 != null) {
                  ++var4;
                  var3 += zzsn.zzG(var5);
               }
            }

            var2 = var2 + var3 + var4 * 1;
         }

         if(this.zzbuQ) {
            var2 += zzsn.zzf(3, this.zzbuQ);
         }

         return var2;
      }
   }

   public static final class zzd extends zzso<zzsz.zzd> {
      public String tag;
      public long zzbuR;
      public long zzbuS;
      public long zzbuT;
      public int zzbuU;
      public boolean zzbuV;
      public zzsz.zze[] zzbuW;
      public zzsz.zzb zzbuX;
      public byte[] zzbuY;
      public byte[] zzbuZ;
      public byte[] zzbva;
      public zzsz.zza zzbvb;
      public String zzbvc;
      public long zzbvd;
      public zzsz.zzc zzbve;
      public byte[] zzbvf;
      public int zzbvg;
      public int[] zzbvh;
      public long zzbvi;
      public int zzob;

      public zzd() {
         this.zzJF();
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzsz.zzd;
            var3 = false;
            if(var2) {
               zzsz.zzd var4 = (zzsz.zzd)var1;
               long var30;
               int var5 = (var30 = this.zzbuR - var4.zzbuR) == 0L?0:(var30 < 0L?-1:1);
               var3 = false;
               if(var5 == 0) {
                  long var31;
                  int var6 = (var31 = this.zzbuS - var4.zzbuS) == 0L?0:(var31 < 0L?-1:1);
                  var3 = false;
                  if(var6 == 0) {
                     long var32;
                     int var7 = (var32 = this.zzbuT - var4.zzbuT) == 0L?0:(var32 < 0L?-1:1);
                     var3 = false;
                     if(var7 == 0) {
                        if(this.tag == null) {
                           String var29 = var4.tag;
                           var3 = false;
                           if(var29 != null) {
                              return var3;
                           }
                        } else if(!this.tag.equals(var4.tag)) {
                           return false;
                        }

                        int var8 = this.zzbuU;
                        int var9 = var4.zzbuU;
                        var3 = false;
                        if(var8 == var9) {
                           int var10 = this.zzob;
                           int var11 = var4.zzob;
                           var3 = false;
                           if(var10 == var11) {
                              boolean var12 = this.zzbuV;
                              boolean var13 = var4.zzbuV;
                              var3 = false;
                              if(var12 == var13) {
                                 boolean var14 = zzss.equals((Object[])this.zzbuW, (Object[])var4.zzbuW);
                                 var3 = false;
                                 if(var14) {
                                    if(this.zzbuX == null) {
                                       zzsz.zzb var28 = var4.zzbuX;
                                       var3 = false;
                                       if(var28 != null) {
                                          return var3;
                                       }
                                    } else if(!this.zzbuX.equals(var4.zzbuX)) {
                                       return false;
                                    }

                                    boolean var15 = Arrays.equals(this.zzbuY, var4.zzbuY);
                                    var3 = false;
                                    if(var15) {
                                       boolean var16 = Arrays.equals(this.zzbuZ, var4.zzbuZ);
                                       var3 = false;
                                       if(var16) {
                                          boolean var17 = Arrays.equals(this.zzbva, var4.zzbva);
                                          var3 = false;
                                          if(var17) {
                                             if(this.zzbvb == null) {
                                                zzsz.zza var27 = var4.zzbvb;
                                                var3 = false;
                                                if(var27 != null) {
                                                   return var3;
                                                }
                                             } else if(!this.zzbvb.equals(var4.zzbvb)) {
                                                return false;
                                             }

                                             if(this.zzbvc == null) {
                                                String var26 = var4.zzbvc;
                                                var3 = false;
                                                if(var26 != null) {
                                                   return var3;
                                                }
                                             } else if(!this.zzbvc.equals(var4.zzbvc)) {
                                                return false;
                                             }

                                             long var33;
                                             int var18 = (var33 = this.zzbvd - var4.zzbvd) == 0L?0:(var33 < 0L?-1:1);
                                             var3 = false;
                                             if(var18 == 0) {
                                                if(this.zzbve == null) {
                                                   zzsz.zzc var25 = var4.zzbve;
                                                   var3 = false;
                                                   if(var25 != null) {
                                                      return var3;
                                                   }
                                                } else if(!this.zzbve.equals(var4.zzbve)) {
                                                   return false;
                                                }

                                                boolean var19 = Arrays.equals(this.zzbvf, var4.zzbvf);
                                                var3 = false;
                                                if(var19) {
                                                   int var20 = this.zzbvg;
                                                   int var21 = var4.zzbvg;
                                                   var3 = false;
                                                   if(var20 == var21) {
                                                      boolean var22 = zzss.equals(this.zzbvh, var4.zzbvh);
                                                      var3 = false;
                                                      if(var22) {
                                                         long var34;
                                                         int var23 = (var34 = this.zzbvi - var4.zzbvi) == 0L?0:(var34 < 0L?-1:1);
                                                         var3 = false;
                                                         if(var23 == 0) {
                                                            if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
                                                               return this.zzbuj.equals(var4.zzbuj);
                                                            }

                                                            if(var4.zzbuj == null) {
                                                               return true;
                                                            }

                                                            boolean var24 = var4.zzbuj.isEmpty();
                                                            var3 = false;
                                                            if(var24) {
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
                  }
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (31 * (31 * (31 * (527 + this.getClass().getName().hashCode()) + (int)(this.zzbuR ^ this.zzbuR >>> 32)) + (int)(this.zzbuS ^ this.zzbuS >>> 32)) + (int)(this.zzbuT ^ this.zzbuT >>> 32));
         int var2;
         if(this.tag == null) {
            var2 = 0;
         } else {
            var2 = this.tag.hashCode();
         }

         int var3 = 31 * (31 * (31 * (var2 + var1) + this.zzbuU) + this.zzob);
         short var4;
         if(this.zzbuV) {
            var4 = 1231;
         } else {
            var4 = 1237;
         }

         int var5 = 31 * (31 * (var4 + var3) + zzss.hashCode((Object[])this.zzbuW));
         int var6;
         if(this.zzbuX == null) {
            var6 = 0;
         } else {
            var6 = this.zzbuX.hashCode();
         }

         int var7 = 31 * (31 * (31 * (31 * (var6 + var5) + Arrays.hashCode(this.zzbuY)) + Arrays.hashCode(this.zzbuZ)) + Arrays.hashCode(this.zzbva));
         int var8;
         if(this.zzbvb == null) {
            var8 = 0;
         } else {
            var8 = this.zzbvb.hashCode();
         }

         int var9 = 31 * (var8 + var7);
         int var10;
         if(this.zzbvc == null) {
            var10 = 0;
         } else {
            var10 = this.zzbvc.hashCode();
         }

         int var11 = 31 * (31 * (var10 + var9) + (int)(this.zzbvd ^ this.zzbvd >>> 32));
         int var12;
         if(this.zzbve == null) {
            var12 = 0;
         } else {
            var12 = this.zzbve.hashCode();
         }

         int var13 = 31 * (31 * (31 * (31 * (31 * (var12 + var11) + Arrays.hashCode(this.zzbvf)) + this.zzbvg) + zzss.hashCode(this.zzbvh)) + (int)(this.zzbvi ^ this.zzbvi >>> 32));
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
         return this.zzV(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(this.zzbuR != 0L) {
            var1.zzb(1, this.zzbuR);
         }

         if(!this.tag.equals("")) {
            var1.zzn(2, this.tag);
         }

         if(this.zzbuW != null && this.zzbuW.length > 0) {
            for(int var4 = 0; var4 < this.zzbuW.length; ++var4) {
               zzsz.zze var5 = this.zzbuW[var4];
               if(var5 != null) {
                  var1.zza(3, (zzsu)var5);
               }
            }
         }

         if(!Arrays.equals(this.zzbuY, zzsx.zzbuD)) {
            var1.zza(6, (byte[])this.zzbuY);
         }

         if(this.zzbvb != null) {
            var1.zza(7, (zzsu)this.zzbvb);
         }

         if(!Arrays.equals(this.zzbuZ, zzsx.zzbuD)) {
            var1.zza(8, (byte[])this.zzbuZ);
         }

         if(this.zzbuX != null) {
            var1.zza(9, (zzsu)this.zzbuX);
         }

         if(this.zzbuV) {
            var1.zze(10, this.zzbuV);
         }

         if(this.zzbuU != 0) {
            var1.zzA(11, this.zzbuU);
         }

         if(this.zzob != 0) {
            var1.zzA(12, this.zzob);
         }

         if(!Arrays.equals(this.zzbva, zzsx.zzbuD)) {
            var1.zza(13, (byte[])this.zzbva);
         }

         if(!this.zzbvc.equals("")) {
            var1.zzn(14, this.zzbvc);
         }

         if(this.zzbvd != 180000L) {
            var1.zzc(15, this.zzbvd);
         }

         if(this.zzbve != null) {
            var1.zza(16, (zzsu)this.zzbve);
         }

         if(this.zzbuS != 0L) {
            var1.zzb(17, this.zzbuS);
         }

         if(!Arrays.equals(this.zzbvf, zzsx.zzbuD)) {
            var1.zza(18, (byte[])this.zzbvf);
         }

         if(this.zzbvg != 0) {
            var1.zzA(19, this.zzbvg);
         }

         if(this.zzbvh != null) {
            int var2 = this.zzbvh.length;
            int var3 = 0;
            if(var2 > 0) {
               while(var3 < this.zzbvh.length) {
                  var1.zzA(20, this.zzbvh[var3]);
                  ++var3;
               }
            }
         }

         if(this.zzbuT != 0L) {
            var1.zzb(21, this.zzbuT);
         }

         if(this.zzbvi != 0L) {
            var1.zzb(22, this.zzbvi);
         }

         super.writeTo(var1);
      }

      public zzsz.zzd zzJF() {
         this.zzbuR = 0L;
         this.zzbuS = 0L;
         this.zzbuT = 0L;
         this.tag = "";
         this.zzbuU = 0;
         this.zzob = 0;
         this.zzbuV = false;
         this.zzbuW = zzsz.zze.zzJG();
         this.zzbuX = null;
         this.zzbuY = zzsx.zzbuD;
         this.zzbuZ = zzsx.zzbuD;
         this.zzbva = zzsx.zzbuD;
         this.zzbvb = null;
         this.zzbvc = "";
         this.zzbvd = 180000L;
         this.zzbve = null;
         this.zzbvf = zzsx.zzbuD;
         this.zzbvg = 0;
         this.zzbvh = zzsx.zzbuw;
         this.zzbvi = 0L;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzsz.zzd zzV(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            zzsz.zze[] var16;
            int var15;
            switch(var2) {
            case 8:
               this.zzbuR = var1.zzJa();
               continue;
            case 18:
               this.tag = var1.readString();
               continue;
            case 26:
               int var14 = zzsx.zzc(var1, 26);
               if(this.zzbuW == null) {
                  var15 = 0;
               } else {
                  var15 = this.zzbuW.length;
               }

               var16 = new zzsz.zze[var14 + var15];
               if(var15 != 0) {
                  System.arraycopy(this.zzbuW, 0, var16, 0, var15);
               }
               break;
            case 50:
               this.zzbuY = var1.readBytes();
               continue;
            case 58:
               if(this.zzbvb == null) {
                  this.zzbvb = new zzsz.zza();
               }

               var1.zza(this.zzbvb);
               continue;
            case 66:
               this.zzbuZ = var1.readBytes();
               continue;
            case 74:
               if(this.zzbuX == null) {
                  this.zzbuX = new zzsz.zzb();
               }

               var1.zza(this.zzbuX);
               continue;
            case 80:
               this.zzbuV = var1.zzJc();
               continue;
            case 88:
               this.zzbuU = var1.zzJb();
               continue;
            case 96:
               this.zzob = var1.zzJb();
               continue;
            case 106:
               this.zzbva = var1.readBytes();
               continue;
            case 114:
               this.zzbvc = var1.readString();
               continue;
            case 120:
               this.zzbvd = var1.zzJe();
               continue;
            case 130:
               if(this.zzbve == null) {
                  this.zzbve = new zzsz.zzc();
               }

               var1.zza(this.zzbve);
               continue;
            case 136:
               this.zzbuS = var1.zzJa();
               continue;
            case 146:
               this.zzbvf = var1.readBytes();
               continue;
            case 152:
               int var13 = var1.zzJb();
               switch(var13) {
               case 0:
               case 1:
               case 2:
                  this.zzbvg = var13;
               default:
                  continue;
               }
            case 160:
               int var9 = zzsx.zzc(var1, 160);
               int var10;
               if(this.zzbvh == null) {
                  var10 = 0;
               } else {
                  var10 = this.zzbvh.length;
               }

               int[] var11 = new int[var9 + var10];
               if(var10 != 0) {
                  System.arraycopy(this.zzbvh, 0, var11, 0, var10);
               }

               while(var10 < -1 + var11.length) {
                  var11[var10] = var1.zzJb();
                  var1.zzIX();
                  ++var10;
               }

               var11[var10] = var1.zzJb();
               this.zzbvh = var11;
               continue;
            case 162:
               int var3 = var1.zzmq(var1.zzJf());
               int var4 = var1.getPosition();

               int var5;
               for(var5 = 0; var1.zzJk() > 0; ++var5) {
                  var1.zzJb();
               }

               var1.zzms(var4);
               int var6;
               if(this.zzbvh == null) {
                  var6 = 0;
               } else {
                  var6 = this.zzbvh.length;
               }

               int[] var7 = new int[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.zzbvh, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.zzJb();
                  ++var6;
               }

               this.zzbvh = var7;
               var1.zzmr(var3);
               continue;
            case 168:
               this.zzbuT = var1.zzJa();
               continue;
            case 176:
               this.zzbvi = var1.zzJa();
               continue;
            default:
               if(this.zza(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var15 < -1 + var16.length) {
               var16[var15] = new zzsz.zze();
               var1.zza(var16[var15]);
               var1.zzIX();
               ++var15;
            }

            var16[var15] = new zzsz.zze();
            var1.zza(var16[var15]);
            this.zzbuW = var16;
         }
      }

      protected int zzz() {
         int var1 = 0;
         int var2 = super.zzz();
         if(this.zzbuR != 0L) {
            var2 += zzsn.zzd(1, this.zzbuR);
         }

         if(!this.tag.equals("")) {
            var2 += zzsn.zzo(2, this.tag);
         }

         if(this.zzbuW != null && this.zzbuW.length > 0) {
            int var4 = var2;

            for(int var5 = 0; var5 < this.zzbuW.length; ++var5) {
               zzsz.zze var6 = this.zzbuW[var5];
               if(var6 != null) {
                  var4 += zzsn.zzc(3, var6);
               }
            }

            var2 = var4;
         }

         if(!Arrays.equals(this.zzbuY, zzsx.zzbuD)) {
            var2 += zzsn.zzb(6, (byte[])this.zzbuY);
         }

         if(this.zzbvb != null) {
            var2 += zzsn.zzc(7, this.zzbvb);
         }

         if(!Arrays.equals(this.zzbuZ, zzsx.zzbuD)) {
            var2 += zzsn.zzb(8, (byte[])this.zzbuZ);
         }

         if(this.zzbuX != null) {
            var2 += zzsn.zzc(9, this.zzbuX);
         }

         if(this.zzbuV) {
            var2 += zzsn.zzf(10, this.zzbuV);
         }

         if(this.zzbuU != 0) {
            var2 += zzsn.zzC(11, this.zzbuU);
         }

         if(this.zzob != 0) {
            var2 += zzsn.zzC(12, this.zzob);
         }

         if(!Arrays.equals(this.zzbva, zzsx.zzbuD)) {
            var2 += zzsn.zzb(13, (byte[])this.zzbva);
         }

         if(!this.zzbvc.equals("")) {
            var2 += zzsn.zzo(14, this.zzbvc);
         }

         if(this.zzbvd != 180000L) {
            var2 += zzsn.zze(15, this.zzbvd);
         }

         if(this.zzbve != null) {
            var2 += zzsn.zzc(16, this.zzbve);
         }

         if(this.zzbuS != 0L) {
            var2 += zzsn.zzd(17, this.zzbuS);
         }

         if(!Arrays.equals(this.zzbvf, zzsx.zzbuD)) {
            var2 += zzsn.zzb(18, (byte[])this.zzbvf);
         }

         if(this.zzbvg != 0) {
            var2 += zzsn.zzC(19, this.zzbvg);
         }

         if(this.zzbvh != null && this.zzbvh.length > 0) {
            int var3;
            for(var3 = 0; var1 < this.zzbvh.length; ++var1) {
               var3 += zzsn.zzmx(this.zzbvh[var1]);
            }

            var2 = var2 + var3 + 2 * this.zzbvh.length;
         }

         if(this.zzbuT != 0L) {
            var2 += zzsn.zzd(21, this.zzbuT);
         }

         if(this.zzbvi != 0L) {
            var2 += zzsn.zzd(22, this.zzbvi);
         }

         return var2;
      }
   }

   public static final class zze extends zzso<zzsz.zze> {
      private static volatile zzsz.zze[] zzbvj;
      public String key;
      public String value;

      public zze() {
         this.zzJH();
      }

      public static zzsz.zze[] zzJG() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzsz.zze;
            var3 = false;
            if(var2) {
               zzsz.zze var4 = (zzsz.zze)var1;
               if(this.key == null) {
                  String var7 = var4.key;
                  var3 = false;
                  if(var7 != null) {
                     return var3;
                  }
               } else if(!this.key.equals(var4.key)) {
                  return false;
               }

               if(this.value == null) {
                  String var6 = var4.value;
                  var3 = false;
                  if(var6 != null) {
                     return var3;
                  }
               } else if(!this.value.equals(var4.value)) {
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
         if(this.key == null) {
            var2 = 0;
         } else {
            var2 = this.key.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.value == null) {
            var4 = 0;
         } else {
            var4 = this.value.hashCode();
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
         return this.zzW(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         if(!this.key.equals("")) {
            var1.zzn(1, this.key);
         }

         if(!this.value.equals("")) {
            var1.zzn(2, this.value);
         }

         super.writeTo(var1);
      }

      public zzsz.zze zzJH() {
         this.key = "";
         this.value = "";
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzsz.zze zzW(zzsm var1) throws IOException {
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

         if(!this.value.equals("")) {
            var1 += zzsn.zzo(2, this.value);
         }

         return var1;
      }
   }
}
