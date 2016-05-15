package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzsq;
import com.google.android.gms.internal.zzss;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsx;
import java.io.IOException;

public interface zzag {
   public static final class zza extends zzso<zzag.zza> {
      private static volatile zzag.zza[] zzjw;
      public int type;
      public zzag.zza[] zzjA;
      public String zzjB;
      public String zzjC;
      public long zzjD;
      public boolean zzjE;
      public zzag.zza[] zzjF;
      public int[] zzjG;
      public boolean zzjH;
      public String zzjx;
      public zzag.zza[] zzjy;
      public zzag.zza[] zzjz;

      public zza() {
         this.zzR();
      }

      public static zzag.zza[] zzQ() {
         // $FF: Couldn't be decompiled
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof zzag.zza;
            var3 = false;
            if(var2) {
               zzag.zza var4 = (zzag.zza)var1;
               int var5 = this.type;
               int var6 = var4.type;
               var3 = false;
               if(var5 == var6) {
                  if(this.zzjx == null) {
                     String var20 = var4.zzjx;
                     var3 = false;
                     if(var20 != null) {
                        return var3;
                     }
                  } else if(!this.zzjx.equals(var4.zzjx)) {
                     return false;
                  }

                  boolean var7 = zzss.equals((Object[])this.zzjy, (Object[])var4.zzjy);
                  var3 = false;
                  if(var7) {
                     boolean var8 = zzss.equals((Object[])this.zzjz, (Object[])var4.zzjz);
                     var3 = false;
                     if(var8) {
                        boolean var9 = zzss.equals((Object[])this.zzjA, (Object[])var4.zzjA);
                        var3 = false;
                        if(var9) {
                           if(this.zzjB == null) {
                              String var19 = var4.zzjB;
                              var3 = false;
                              if(var19 != null) {
                                 return var3;
                              }
                           } else if(!this.zzjB.equals(var4.zzjB)) {
                              return false;
                           }

                           if(this.zzjC == null) {
                              String var18 = var4.zzjC;
                              var3 = false;
                              if(var18 != null) {
                                 return var3;
                              }
                           } else if(!this.zzjC.equals(var4.zzjC)) {
                              return false;
                           }

                           long var21;
                           int var10 = (var21 = this.zzjD - var4.zzjD) == 0L?0:(var21 < 0L?-1:1);
                           var3 = false;
                           if(var10 == 0) {
                              boolean var11 = this.zzjE;
                              boolean var12 = var4.zzjE;
                              var3 = false;
                              if(var11 == var12) {
                                 boolean var13 = zzss.equals((Object[])this.zzjF, (Object[])var4.zzjF);
                                 var3 = false;
                                 if(var13) {
                                    boolean var14 = zzss.equals(this.zzjG, var4.zzjG);
                                    var3 = false;
                                    if(var14) {
                                       boolean var15 = this.zzjH;
                                       boolean var16 = var4.zzjH;
                                       var3 = false;
                                       if(var15 == var16) {
                                          if(this.zzbuj != null && !this.zzbuj.isEmpty()) {
                                             return this.zzbuj.equals(var4.zzbuj);
                                          }

                                          if(var4.zzbuj != null) {
                                             boolean var17 = var4.zzbuj.isEmpty();
                                             var3 = false;
                                             if(!var17) {
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

         return var3;
      }

      public int hashCode() {
         short var1 = 1231;
         int var2 = 31 * (31 * (527 + this.getClass().getName().hashCode()) + this.type);
         int var3;
         if(this.zzjx == null) {
            var3 = 0;
         } else {
            var3 = this.zzjx.hashCode();
         }

         int var4 = 31 * (31 * (31 * (31 * (var3 + var2) + zzss.hashCode((Object[])this.zzjy)) + zzss.hashCode((Object[])this.zzjz)) + zzss.hashCode((Object[])this.zzjA));
         int var5;
         if(this.zzjB == null) {
            var5 = 0;
         } else {
            var5 = this.zzjB.hashCode();
         }

         int var6 = 31 * (var5 + var4);
         int var7;
         if(this.zzjC == null) {
            var7 = 0;
         } else {
            var7 = this.zzjC.hashCode();
         }

         int var8 = 31 * (31 * (var7 + var6) + (int)(this.zzjD ^ this.zzjD >>> 32));
         short var9;
         if(this.zzjE) {
            var9 = var1;
         } else {
            var9 = 1237;
         }

         int var10 = 31 * (31 * (31 * (var9 + var8) + zzss.hashCode((Object[])this.zzjF)) + zzss.hashCode(this.zzjG));
         if(!this.zzjH) {
            var1 = 1237;
         }

         int var11 = 31 * (var10 + var1);
         zzsq var12 = this.zzbuj;
         int var13 = 0;
         if(var12 != null) {
            boolean var14 = this.zzbuj.isEmpty();
            var13 = 0;
            if(!var14) {
               var13 = this.zzbuj.hashCode();
            }
         }

         return var11 + var13;
      }

      // $FF: synthetic method
      public zzsu mergeFrom(zzsm var1) throws IOException {
         return this.zzk(var1);
      }

      public void writeTo(zzsn var1) throws IOException {
         var1.zzA(1, this.type);
         if(!this.zzjx.equals("")) {
            var1.zzn(2, this.zzjx);
         }

         if(this.zzjy != null && this.zzjy.length > 0) {
            for(int var10 = 0; var10 < this.zzjy.length; ++var10) {
               zzag.zza var11 = this.zzjy[var10];
               if(var11 != null) {
                  var1.zza(3, (zzsu)var11);
               }
            }
         }

         if(this.zzjz != null && this.zzjz.length > 0) {
            for(int var8 = 0; var8 < this.zzjz.length; ++var8) {
               zzag.zza var9 = this.zzjz[var8];
               if(var9 != null) {
                  var1.zza(4, (zzsu)var9);
               }
            }
         }

         if(this.zzjA != null && this.zzjA.length > 0) {
            for(int var6 = 0; var6 < this.zzjA.length; ++var6) {
               zzag.zza var7 = this.zzjA[var6];
               if(var7 != null) {
                  var1.zza(5, (zzsu)var7);
               }
            }
         }

         if(!this.zzjB.equals("")) {
            var1.zzn(6, this.zzjB);
         }

         if(!this.zzjC.equals("")) {
            var1.zzn(7, this.zzjC);
         }

         if(this.zzjD != 0L) {
            var1.zzb(8, this.zzjD);
         }

         if(this.zzjH) {
            var1.zze(9, this.zzjH);
         }

         if(this.zzjG != null && this.zzjG.length > 0) {
            for(int var5 = 0; var5 < this.zzjG.length; ++var5) {
               var1.zzA(10, this.zzjG[var5]);
            }
         }

         if(this.zzjF != null) {
            int var2 = this.zzjF.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.zzjF.length; ++var3) {
                  zzag.zza var4 = this.zzjF[var3];
                  if(var4 != null) {
                     var1.zza(11, (zzsu)var4);
                  }
               }
            }
         }

         if(this.zzjE) {
            var1.zze(12, this.zzjE);
         }

         super.writeTo(var1);
      }

      public zzag.zza zzR() {
         this.type = 1;
         this.zzjx = "";
         this.zzjy = zzQ();
         this.zzjz = zzQ();
         this.zzjA = zzQ();
         this.zzjB = "";
         this.zzjC = "";
         this.zzjD = 0L;
         this.zzjE = false;
         this.zzjF = zzQ();
         this.zzjG = zzsx.zzbuw;
         this.zzjH = false;
         this.zzbuj = null;
         this.zzbuu = -1;
         return this;
      }

      public zzag.zza zzk(zzsm var1) throws IOException {
         while(true) {
            int var2 = var1.zzIX();
            int var32;
            zzag.zza[] var33;
            switch(var2) {
            case 8:
               int var35 = var1.zzJb();
               switch(var35) {
               case 1:
               case 2:
               case 3:
               case 4:
               case 5:
               case 6:
               case 7:
               case 8:
                  this.type = var35;
               default:
                  continue;
               }
            case 18:
               this.zzjx = var1.readString();
               continue;
            case 26:
               int var31 = zzsx.zzc(var1, 26);
               if(this.zzjy == null) {
                  var32 = 0;
               } else {
                  var32 = this.zzjy.length;
               }

               var33 = new zzag.zza[var31 + var32];
               if(var32 != 0) {
                  System.arraycopy(this.zzjy, 0, var33, 0, var32);
               }
               break;
            case 34:
               int var27 = zzsx.zzc(var1, 34);
               int var28;
               if(this.zzjz == null) {
                  var28 = 0;
               } else {
                  var28 = this.zzjz.length;
               }

               zzag.zza[] var29 = new zzag.zza[var27 + var28];
               if(var28 != 0) {
                  System.arraycopy(this.zzjz, 0, var29, 0, var28);
               }

               while(var28 < -1 + var29.length) {
                  var29[var28] = new zzag.zza();
                  var1.zza(var29[var28]);
                  var1.zzIX();
                  ++var28;
               }

               var29[var28] = new zzag.zza();
               var1.zza(var29[var28]);
               this.zzjz = var29;
               continue;
            case 42:
               int var23 = zzsx.zzc(var1, 42);
               int var24;
               if(this.zzjA == null) {
                  var24 = 0;
               } else {
                  var24 = this.zzjA.length;
               }

               zzag.zza[] var25 = new zzag.zza[var23 + var24];
               if(var24 != 0) {
                  System.arraycopy(this.zzjA, 0, var25, 0, var24);
               }

               while(var24 < -1 + var25.length) {
                  var25[var24] = new zzag.zza();
                  var1.zza(var25[var24]);
                  var1.zzIX();
                  ++var24;
               }

               var25[var24] = new zzag.zza();
               var1.zza(var25[var24]);
               this.zzjA = var25;
               continue;
            case 50:
               this.zzjB = var1.readString();
               continue;
            case 58:
               this.zzjC = var1.readString();
               continue;
            case 64:
               this.zzjD = var1.zzJa();
               continue;
            case 72:
               this.zzjH = var1.zzJc();
               continue;
            case 80:
               int var14 = zzsx.zzc(var1, 80);
               int[] var15 = new int[var14];
               int var16 = 0;

               int var17;
               int var21;
               for(var17 = 0; var16 < var14; var17 = var21) {
                  if(var16 != 0) {
                     var1.zzIX();
                  }

                  int var20 = var1.zzJb();
                  switch(var20) {
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
                     var21 = var17 + 1;
                     var15[var17] = var20;
                     break;
                  default:
                     var21 = var17;
                  }

                  ++var16;
               }

               if(var17 == 0) {
                  continue;
               }

               int var18;
               if(this.zzjG == null) {
                  var18 = 0;
               } else {
                  var18 = this.zzjG.length;
               }

               if(var18 == 0 && var17 == var15.length) {
                  this.zzjG = var15;
                  continue;
               }

               int[] var19 = new int[var18 + var17];
               if(var18 != 0) {
                  System.arraycopy(this.zzjG, 0, var19, 0, var18);
               }

               System.arraycopy(var15, 0, var19, var18, var17);
               this.zzjG = var19;
               continue;
            case 82:
               int var7 = var1.zzmq(var1.zzJf());
               int var8 = var1.getPosition();
               int var9 = 0;

               while(var1.zzJk() > 0) {
                  switch(var1.zzJb()) {
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
                     ++var9;
                  }
               }

               if(var9 != 0) {
                  var1.zzms(var8);
                  int var10;
                  if(this.zzjG == null) {
                     var10 = 0;
                  } else {
                     var10 = this.zzjG.length;
                  }

                  int[] var11 = new int[var9 + var10];
                  if(var10 != 0) {
                     System.arraycopy(this.zzjG, 0, var11, 0, var10);
                  }

                  while(var1.zzJk() > 0) {
                     int var12 = var1.zzJb();
                     switch(var12) {
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
                        int var13 = var10 + 1;
                        var11[var10] = var12;
                        var10 = var13;
                     }
                  }

                  this.zzjG = var11;
               }

               var1.zzmr(var7);
               continue;
            case 90:
               int var3 = zzsx.zzc(var1, 90);
               int var4;
               if(this.zzjF == null) {
                  var4 = 0;
               } else {
                  var4 = this.zzjF.length;
               }

               zzag.zza[] var5 = new zzag.zza[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.zzjF, 0, var5, 0, var4);
               }

               while(var4 < -1 + var5.length) {
                  var5[var4] = new zzag.zza();
                  var1.zza(var5[var4]);
                  var1.zzIX();
                  ++var4;
               }

               var5[var4] = new zzag.zza();
               var1.zza(var5[var4]);
               this.zzjF = var5;
               continue;
            case 96:
               this.zzjE = var1.zzJc();
               continue;
            default:
               if(this.zza(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var32 < -1 + var33.length) {
               var33[var32] = new zzag.zza();
               var1.zza(var33[var32]);
               var1.zzIX();
               ++var32;
            }

            var33[var32] = new zzag.zza();
            var1.zza(var33[var32]);
            this.zzjy = var33;
         }
      }

      protected int zzz() {
         int var1 = super.zzz() + zzsn.zzC(1, this.type);
         if(!this.zzjx.equals("")) {
            var1 += zzsn.zzo(2, this.zzjx);
         }

         if(this.zzjy != null && this.zzjy.length > 0) {
            int var13 = var1;

            for(int var14 = 0; var14 < this.zzjy.length; ++var14) {
               zzag.zza var15 = this.zzjy[var14];
               if(var15 != null) {
                  var13 += zzsn.zzc(3, var15);
               }
            }

            var1 = var13;
         }

         if(this.zzjz != null && this.zzjz.length > 0) {
            int var10 = var1;

            for(int var11 = 0; var11 < this.zzjz.length; ++var11) {
               zzag.zza var12 = this.zzjz[var11];
               if(var12 != null) {
                  var10 += zzsn.zzc(4, var12);
               }
            }

            var1 = var10;
         }

         if(this.zzjA != null && this.zzjA.length > 0) {
            int var7 = var1;

            for(int var8 = 0; var8 < this.zzjA.length; ++var8) {
               zzag.zza var9 = this.zzjA[var8];
               if(var9 != null) {
                  var7 += zzsn.zzc(5, var9);
               }
            }

            var1 = var7;
         }

         if(!this.zzjB.equals("")) {
            var1 += zzsn.zzo(6, this.zzjB);
         }

         if(!this.zzjC.equals("")) {
            var1 += zzsn.zzo(7, this.zzjC);
         }

         if(this.zzjD != 0L) {
            var1 += zzsn.zzd(8, this.zzjD);
         }

         if(this.zzjH) {
            var1 += zzsn.zzf(9, this.zzjH);
         }

         if(this.zzjG != null && this.zzjG.length > 0) {
            int var5 = 0;

            int var6;
            for(var6 = 0; var5 < this.zzjG.length; ++var5) {
               var6 += zzsn.zzmx(this.zzjG[var5]);
            }

            var1 = var1 + var6 + 1 * this.zzjG.length;
         }

         if(this.zzjF != null) {
            int var2 = this.zzjF.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.zzjF.length; ++var3) {
                  zzag.zza var4 = this.zzjF[var3];
                  if(var4 != null) {
                     var1 += zzsn.zzc(11, var4);
                  }
               }
            }
         }

         if(this.zzjE) {
            var1 += zzsn.zzf(12, this.zzjE);
         }

         return var1;
      }
   }
}
