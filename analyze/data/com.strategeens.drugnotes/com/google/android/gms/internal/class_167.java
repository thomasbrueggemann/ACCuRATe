package com.google.android.gms.internal;

import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_822;
import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.class_827;
import com.google.android.gms.internal.class_834;
import com.google.android.gms.internal.qq;
import java.io.IOException;
import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.internal.ra
public interface class_167 {
   public static final class class_1428 extends qq<class_167.class_1428> {
      public String[] azr;
      public String[] azs;
      public int[] azt;

      public class_1428() {
         this.method_2117();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(this.azr != null && this.azr.length > 0) {
            for(int var6 = 0; var6 < this.azr.length; ++var6) {
               String var7 = this.azr[var6];
               if(var7 != null) {
                  var1.method_4537(1, var7);
               }
            }
         }

         if(this.azs != null && this.azs.length > 0) {
            for(int var4 = 0; var4 < this.azs.length; ++var4) {
               String var5 = this.azs[var4];
               if(var5 != null) {
                  var1.method_4537(2, var5);
               }
            }
         }

         if(this.azt != null) {
            int var2 = this.azt.length;
            int var3 = 0;
            if(var2 > 0) {
               while(var3 < this.azt.length) {
                  var1.method_4554(3, this.azt[var3]);
                  ++var3;
               }
            }
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2118(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = 0;
         int var2 = super.method_2091();
         int var3;
         if(this.azr != null && this.azr.length > 0) {
            int var9 = 0;
            int var10 = 0;

            int var11;
            for(var11 = 0; var9 < this.azr.length; ++var9) {
               String var12 = this.azr[var9];
               if(var12 != null) {
                  ++var11;
                  var10 += class_826.method_4511(var12);
               }
            }

            var3 = var2 + var10 + var11 * 1;
         } else {
            var3 = var2;
         }

         if(this.azs != null && this.azs.length > 0) {
            int var5 = 0;
            int var6 = 0;

            int var7;
            for(var7 = 0; var5 < this.azs.length; ++var5) {
               String var8 = this.azs[var5];
               if(var8 != null) {
                  ++var7;
                  var6 += class_826.method_4511(var8);
               }
            }

            var3 = var3 + var6 + var7 * 1;
         }

         if(this.azt != null && this.azt.length > 0) {
            int var4;
            for(var4 = 0; var1 < this.azt.length; ++var1) {
               var4 += class_826.method_4516(this.azt[var1]);
            }

            var3 = var3 + var4 + 1 * this.azt.length;
         }

         return var3;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_167.class_1428;
            var3 = false;
            if(var2) {
               class_167.class_1428 var4 = (class_167.class_1428)var1;
               boolean var5 = class_834.equals((Object[])this.azr, (Object[])var4.azr);
               var3 = false;
               if(var5) {
                  boolean var6 = class_834.equals((Object[])this.azs, (Object[])var4.azs);
                  var3 = false;
                  if(var6) {
                     boolean var7 = class_834.equals(this.azt, var4.azt);
                     var3 = false;
                     if(var7) {
                        return this.a(var4);
                     }
                  }
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         return 31 * (31 * (31 * (527 + class_834.hashCode((Object[])this.azr)) + class_834.hashCode((Object[])this.azs)) + class_834.hashCode(this.azt)) + this.rQ();
      }

      // $FF: renamed from: sa () com.google.android.gms.internal.ra$a
      public class_167.class_1428 method_2117() {
         this.azr = class_822.azo;
         this.azs = class_822.azo;
         this.azt = class_822.azj;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      // $FF: renamed from: y (com.google.android.gms.internal.qo) com.google.android.gms.internal.ra$a
      public class_167.class_1428 method_2118(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            String[] var19;
            int var18;
            switch(var2) {
            case 10:
               int var17 = class_822.method_4484(var1, 10);
               if(this.azr == null) {
                  var18 = 0;
               } else {
                  var18 = this.azr.length;
               }

               var19 = new String[var17 + var18];
               if(var18 != 0) {
                  System.arraycopy(this.azr, 0, var19, 0, var18);
               }
               break;
            case 18:
               int var13 = class_822.method_4484(var1, 18);
               int var14;
               if(this.azs == null) {
                  var14 = 0;
               } else {
                  var14 = this.azs.length;
               }

               String[] var15 = new String[var13 + var14];
               if(var14 != 0) {
                  System.arraycopy(this.azs, 0, var15, 0, var14);
               }

               while(var14 < -1 + var15.length) {
                  var15[var14] = var1.readString();
                  var1.method_4585();
                  ++var14;
               }

               var15[var14] = var1.readString();
               this.azs = var15;
               continue;
            case 24:
               int var9 = class_822.method_4484(var1, 24);
               int var10;
               if(this.azt == null) {
                  var10 = 0;
               } else {
                  var10 = this.azt.length;
               }

               int[] var11 = new int[var9 + var10];
               if(var10 != 0) {
                  System.arraycopy(this.azt, 0, var11, 0, var10);
               }

               while(var10 < -1 + var11.length) {
                  var11[var10] = var1.method_4574();
                  var1.method_4585();
                  ++var10;
               }

               var11[var10] = var1.method_4574();
               this.azt = var11;
               continue;
            case 26:
               int var3 = var1.method_4567(var1.method_4578());
               int var4 = var1.getPosition();

               int var5;
               for(var5 = 0; var1.method_4582() > 0; ++var5) {
                  var1.method_4574();
               }

               var1.method_4569(var4);
               int var6;
               if(this.azt == null) {
                  var6 = 0;
               } else {
                  var6 = this.azt.length;
               }

               int[] var7 = new int[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.azt, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.method_4574();
                  ++var6;
               }

               this.azt = var7;
               var1.method_4568(var3);
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var18 < -1 + var19.length) {
               var19[var18] = var1.readString();
               var1.method_4585();
               ++var18;
            }

            var19[var18] = var1.readString();
            this.azr = var19;
         }
      }
   }

   public static final class class_1429 extends qq<class_167.class_1429> {
      public int azu;
      public String azv;
      public String version;

      public class_1429() {
         this.method_2115();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(this.azu != 0) {
            var1.method_4554(1, this.azu);
         }

         if(!this.azv.equals("")) {
            var1.method_4537(2, this.azv);
         }

         if(!this.version.equals("")) {
            var1.method_4537(3, this.version);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2116(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091();
         if(this.azu != 0) {
            var1 += class_826.method_4524(1, this.azu);
         }

         if(!this.azv.equals("")) {
            var1 += class_826.method_4521(2, this.azv);
         }

         if(!this.version.equals("")) {
            var1 += class_826.method_4521(3, this.version);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_167.class_1429;
            var3 = false;
            if(var2) {
               class_167.class_1429 var4 = (class_167.class_1429)var1;
               int var5 = this.azu;
               int var6 = var4.azu;
               var3 = false;
               if(var5 == var6) {
                  if(this.azv == null) {
                     String var8 = var4.azv;
                     var3 = false;
                     if(var8 != null) {
                        return var3;
                     }
                  } else if(!this.azv.equals(var4.azv)) {
                     return false;
                  }

                  if(this.version == null) {
                     String var7 = var4.version;
                     var3 = false;
                     if(var7 != null) {
                        return var3;
                     }
                  } else if(!this.version.equals(var4.version)) {
                     return false;
                  }

                  return this.a(var4);
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (527 + this.azu);
         int var2;
         if(this.azv == null) {
            var2 = 0;
         } else {
            var2 = this.azv.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         String var4 = this.version;
         int var5 = 0;
         if(var4 != null) {
            var5 = this.version.hashCode();
         }

         return 31 * (var3 + var5) + this.rQ();
      }

      // $FF: renamed from: sb () com.google.android.gms.internal.ra$b
      public class_167.class_1429 method_2115() {
         this.azu = 0;
         this.azv = "";
         this.version = "";
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      // $FF: renamed from: z (com.google.android.gms.internal.qo) com.google.android.gms.internal.ra$b
      public class_167.class_1429 method_2116(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            switch(var2) {
            case 8:
               int var3 = var1.method_4574();
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
                  this.azu = var3;
               default:
                  continue;
               }
            case 18:
               this.azv = var1.readString();
               break;
            case 26:
               this.version = var1.readString();
               break;
            default:
               if(this.a(var1, var2)) {
                  break;
               }
            case 0:
               return this;
            }
         }
      }
   }

   public static final class class_1430 extends qq<class_167.class_1430> {
      public class_167.class_1431[] azA;
      public class_167.class_1429 azB;
      public byte[] azC;
      public byte[] azD;
      public byte[] azE;
      public class_167.class_1428 azF;
      public String azG;
      public long azH;
      public long azw;
      public int azx;
      public int azy;
      public boolean azz;
      public String tag;

      public class_1430() {
         this.method_2123();
      }

      // $FF: renamed from: A (com.google.android.gms.internal.qo) com.google.android.gms.internal.ra$c
      public class_167.class_1430 method_2122(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            int var4;
            class_167.class_1431[] var5;
            switch(var2) {
            case 8:
               this.azw = var1.method_4573();
               continue;
            case 18:
               this.tag = var1.readString();
               continue;
            case 26:
               int var3 = class_822.method_4484(var1, 26);
               if(this.azA == null) {
                  var4 = 0;
               } else {
                  var4 = this.azA.length;
               }

               var5 = new class_167.class_1431[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.azA, 0, var5, 0, var4);
               }
               break;
            case 50:
               this.azC = var1.readBytes();
               continue;
            case 58:
               if(this.azF == null) {
                  this.azF = new class_167.class_1428();
               }

               var1.method_4563(this.azF);
               continue;
            case 66:
               this.azD = var1.readBytes();
               continue;
            case 74:
               if(this.azB == null) {
                  this.azB = new class_167.class_1429();
               }

               var1.method_4563(this.azB);
               continue;
            case 80:
               this.azz = var1.method_4575();
               continue;
            case 88:
               this.azx = var1.method_4574();
               continue;
            case 96:
               this.azy = var1.method_4574();
               continue;
            case 106:
               this.azE = var1.readBytes();
               continue;
            case 114:
               this.azG = var1.readString();
               continue;
            case 120:
               this.azH = var1.method_4577();
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var4 < -1 + var5.length) {
               var5[var4] = new class_167.class_1431();
               var1.method_4563(var5[var4]);
               var1.method_4585();
               ++var4;
            }

            var5[var4] = new class_167.class_1431();
            var1.method_4563(var5[var4]);
            this.azA = var5;
         }
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(this.azw != 0L) {
            var1.method_4536(1, this.azw);
         }

         if(!this.tag.equals("")) {
            var1.method_4537(2, this.tag);
         }

         if(this.azA != null && this.azA.length > 0) {
            for(int var2 = 0; var2 < this.azA.length; ++var2) {
               class_167.class_1431 var3 = this.azA[var2];
               if(var3 != null) {
                  var1.method_4532(3, var3);
               }
            }
         }

         if(!Arrays.equals(this.azC, class_822.azq)) {
            var1.method_4533(6, this.azC);
         }

         if(this.azF != null) {
            var1.method_4532(7, this.azF);
         }

         if(!Arrays.equals(this.azD, class_822.azq)) {
            var1.method_4533(8, this.azD);
         }

         if(this.azB != null) {
            var1.method_4532(9, this.azB);
         }

         if(this.azz) {
            var1.method_4538(10, this.azz);
         }

         if(this.azx != 0) {
            var1.method_4554(11, this.azx);
         }

         if(this.azy != 0) {
            var1.method_4554(12, this.azy);
         }

         if(!Arrays.equals(this.azE, class_822.azq)) {
            var1.method_4533(13, this.azE);
         }

         if(!this.azG.equals("")) {
            var1.method_4537(14, this.azG);
         }

         if(this.azH != 0L) {
            var1.method_4540(15, this.azH);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2122(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091();
         if(this.azw != 0L) {
            var1 += class_826.method_4509(1, this.azw);
         }

         if(!this.tag.equals("")) {
            var1 += class_826.method_4521(2, this.tag);
         }

         if(this.azA != null && this.azA.length > 0) {
            int var2 = var1;

            for(int var3 = 0; var3 < this.azA.length; ++var3) {
               class_167.class_1431 var4 = this.azA[var3];
               if(var4 != null) {
                  var2 += class_826.method_4507(3, var4);
               }
            }

            var1 = var2;
         }

         if(!Arrays.equals(this.azC, class_822.azq)) {
            var1 += class_826.method_4504(6, this.azC);
         }

         if(this.azF != null) {
            var1 += class_826.method_4507(7, this.azF);
         }

         if(!Arrays.equals(this.azD, class_822.azq)) {
            var1 += class_826.method_4504(8, this.azD);
         }

         if(this.azB != null) {
            var1 += class_826.method_4507(9, this.azB);
         }

         if(this.azz) {
            var1 += class_826.method_4508(10, this.azz);
         }

         if(this.azx != 0) {
            var1 += class_826.method_4524(11, this.azx);
         }

         if(this.azy != 0) {
            var1 += class_826.method_4524(12, this.azy);
         }

         if(!Arrays.equals(this.azE, class_822.azq)) {
            var1 += class_826.method_4504(13, this.azE);
         }

         if(!this.azG.equals("")) {
            var1 += class_826.method_4521(14, this.azG);
         }

         if(this.azH != 0L) {
            var1 += class_826.method_4513(15, this.azH);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_167.class_1430;
            var3 = false;
            if(var2) {
               class_167.class_1430 var4 = (class_167.class_1430)var1;
               long var21;
               int var5 = (var21 = this.azw - var4.azw) == 0L?0:(var21 < 0L?-1:1);
               var3 = false;
               if(var5 == 0) {
                  if(this.tag == null) {
                     String var20 = var4.tag;
                     var3 = false;
                     if(var20 != null) {
                        return var3;
                     }
                  } else if(!this.tag.equals(var4.tag)) {
                     return false;
                  }

                  int var6 = this.azx;
                  int var7 = var4.azx;
                  var3 = false;
                  if(var6 == var7) {
                     int var8 = this.azy;
                     int var9 = var4.azy;
                     var3 = false;
                     if(var8 == var9) {
                        boolean var10 = this.azz;
                        boolean var11 = var4.azz;
                        var3 = false;
                        if(var10 == var11) {
                           boolean var12 = class_834.equals((Object[])this.azA, (Object[])var4.azA);
                           var3 = false;
                           if(var12) {
                              if(this.azB == null) {
                                 class_167.class_1429 var19 = var4.azB;
                                 var3 = false;
                                 if(var19 != null) {
                                    return var3;
                                 }
                              } else if(!this.azB.equals(var4.azB)) {
                                 return false;
                              }

                              boolean var13 = Arrays.equals(this.azC, var4.azC);
                              var3 = false;
                              if(var13) {
                                 boolean var14 = Arrays.equals(this.azD, var4.azD);
                                 var3 = false;
                                 if(var14) {
                                    boolean var15 = Arrays.equals(this.azE, var4.azE);
                                    var3 = false;
                                    if(var15) {
                                       if(this.azF == null) {
                                          class_167.class_1428 var18 = var4.azF;
                                          var3 = false;
                                          if(var18 != null) {
                                             return var3;
                                          }
                                       } else if(!this.azF.equals(var4.azF)) {
                                          return false;
                                       }

                                       if(this.azG == null) {
                                          String var17 = var4.azG;
                                          var3 = false;
                                          if(var17 != null) {
                                             return var3;
                                          }
                                       } else if(!this.azG.equals(var4.azG)) {
                                          return false;
                                       }

                                       long var22;
                                       int var16 = (var22 = this.azH - var4.azH) == 0L?0:(var22 < 0L?-1:1);
                                       var3 = false;
                                       if(var16 == 0) {
                                          return this.a(var4);
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
         int var1 = 31 * (527 + (int)(this.azw ^ this.azw >>> 32));
         int var2;
         if(this.tag == null) {
            var2 = 0;
         } else {
            var2 = this.tag.hashCode();
         }

         int var3 = 31 * (31 * (31 * (var2 + var1) + this.azx) + this.azy);
         short var4;
         if(this.azz) {
            var4 = 1231;
         } else {
            var4 = 1237;
         }

         int var5 = 31 * (31 * (var4 + var3) + class_834.hashCode((Object[])this.azA));
         int var6;
         if(this.azB == null) {
            var6 = 0;
         } else {
            var6 = this.azB.hashCode();
         }

         int var7 = 31 * (31 * (31 * (31 * (var6 + var5) + Arrays.hashCode(this.azC)) + Arrays.hashCode(this.azD)) + Arrays.hashCode(this.azE));
         int var8;
         if(this.azF == null) {
            var8 = 0;
         } else {
            var8 = this.azF.hashCode();
         }

         int var9 = 31 * (var8 + var7);
         String var10 = this.azG;
         int var11 = 0;
         if(var10 != null) {
            var11 = this.azG.hashCode();
         }

         return 31 * (31 * (var9 + var11) + (int)(this.azH ^ this.azH >>> 32)) + this.rQ();
      }

      // $FF: renamed from: sc () com.google.android.gms.internal.ra$c
      public class_167.class_1430 method_2123() {
         this.azw = 0L;
         this.tag = "";
         this.azx = 0;
         this.azy = 0;
         this.azz = false;
         this.azA = class_167.class_1431.method_2119();
         this.azB = null;
         this.azC = class_822.azq;
         this.azD = class_822.azq;
         this.azE = class_822.azq;
         this.azF = null;
         this.azG = "";
         this.azH = 0L;
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }

   public static final class class_1431 extends qq<class_167.class_1431> {
      private static volatile class_167.class_1431[] azI;
      // $FF: renamed from: fv java.lang.String
      public String field_665;
      public String value;

      public class_1431() {
         this.method_2121();
      }

      // $FF: renamed from: sd () com.google.android.gms.internal.ra$d[]
      public static class_167.class_1431[] method_2119() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: B (com.google.android.gms.internal.qo) com.google.android.gms.internal.ra$d
      public class_167.class_1431 method_2120(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            switch(var2) {
            case 10:
               this.field_665 = var1.readString();
               break;
            case 18:
               this.value = var1.readString();
               break;
            default:
               if(this.a(var1, var2)) {
                  break;
               }
            case 0:
               return this;
            }
         }
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(!this.field_665.equals("")) {
            var1.method_4537(1, this.field_665);
         }

         if(!this.value.equals("")) {
            var1.method_4537(2, this.value);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2120(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091();
         if(!this.field_665.equals("")) {
            var1 += class_826.method_4521(1, this.field_665);
         }

         if(!this.value.equals("")) {
            var1 += class_826.method_4521(2, this.value);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_167.class_1431;
            var3 = false;
            if(var2) {
               class_167.class_1431 var4 = (class_167.class_1431)var1;
               if(this.field_665 == null) {
                  String var6 = var4.field_665;
                  var3 = false;
                  if(var6 != null) {
                     return var3;
                  }
               } else if(!this.field_665.equals(var4.field_665)) {
                  return false;
               }

               if(this.value == null) {
                  String var5 = var4.value;
                  var3 = false;
                  if(var5 != null) {
                     return var3;
                  }
               } else if(!this.value.equals(var4.value)) {
                  return false;
               }

               return this.a(var4);
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1;
         if(this.field_665 == null) {
            var1 = 0;
         } else {
            var1 = this.field_665.hashCode();
         }

         int var2 = 31 * (var1 + 527);
         String var3 = this.value;
         int var4 = 0;
         if(var3 != null) {
            var4 = this.value.hashCode();
         }

         return 31 * (var2 + var4) + this.rQ();
      }

      // $FF: renamed from: se () com.google.android.gms.internal.ra$d
      public class_167.class_1431 method_2121() {
         this.field_665 = "";
         this.value = "";
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }
}
