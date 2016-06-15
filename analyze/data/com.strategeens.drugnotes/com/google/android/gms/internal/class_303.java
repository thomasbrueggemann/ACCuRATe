package com.google.android.gms.internal;

import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_822;
import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.class_827;
import com.google.android.gms.internal.class_833;
import com.google.android.gms.internal.class_834;
import com.google.android.gms.internal.qm;
import com.google.android.gms.internal.qq;
import java.io.IOException;
import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.internal.qm
public final class class_303 extends qq<qm> {
   public class_303.class_1352[] ayq;

   public class_303() {
      this.method_2128();
   }

   // $FF: renamed from: n (byte[]) com.google.android.gms.internal.qm
   public static class_303 method_2127(byte[] var0) throws class_833 {
      return (class_303)class_300.method_2085(new class_303(), var0);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.qp) void
   public void method_2089(class_826 var1) throws IOException {
      if(this.ayq != null && this.ayq.length > 0) {
         for(int var2 = 0; var2 < this.ayq.length; ++var2) {
            class_303.class_1352 var3 = this.ayq[var2];
            if(var3 != null) {
               var1.method_4532(1, var3);
            }
         }
      }

      super.method_2089(var1);
   }

   // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
   // $FF: synthetic method
   public class_300 method_2090(class_827 var1) throws IOException {
      return this.method_2129(var1);
   }

   // $FF: renamed from: c () int
   protected int method_2091() {
      int var1 = super.method_2091();
      if(this.ayq != null && this.ayq.length > 0) {
         for(int var2 = 0; var2 < this.ayq.length; ++var2) {
            class_303.class_1352 var3 = this.ayq[var2];
            if(var3 != null) {
               var1 += class_826.method_4507(1, var3);
            }
         }
      }

      return var1;
   }

   public boolean equals(Object var1) {
      boolean var3;
      if(var1 == this) {
         var3 = true;
      } else {
         boolean var2 = var1 instanceof class_303;
         var3 = false;
         if(var2) {
            class_303 var4 = (class_303)var1;
            boolean var5 = class_834.equals((Object[])this.ayq, (Object[])var4.ayq);
            var3 = false;
            if(var5) {
               return this.a(var4);
            }
         }
      }

      return var3;
   }

   public int hashCode() {
      return 31 * (527 + class_834.hashCode((Object[])this.ayq)) + this.rQ();
   }

   // $FF: renamed from: rt () com.google.android.gms.internal.qm
   public class_303 method_2128() {
      this.ayq = class_303.class_1352.method_2124();
      this.ayW = null;
      this.azh = -1;
      return this;
   }

   // $FF: renamed from: t (com.google.android.gms.internal.qo) com.google.android.gms.internal.qm
   public class_303 method_2129(class_827 var1) throws IOException {
      while(true) {
         int var2 = var1.method_4585();
         int var4;
         class_303.class_1352[] var5;
         switch(var2) {
         case 10:
            int var3 = class_822.method_4484(var1, 10);
            if(this.ayq == null) {
               var4 = 0;
            } else {
               var4 = this.ayq.length;
            }

            var5 = new class_303.class_1352[var3 + var4];
            if(var4 != 0) {
               System.arraycopy(this.ayq, 0, var5, 0, var4);
            }
            break;
         default:
            if(this.a(var1, var2)) {
               continue;
            }
         case 0:
            return this;
         }

         while(var4 < -1 + var5.length) {
            var5[var4] = new class_303.class_1352();
            var1.method_4563(var5[var4]);
            var1.method_4585();
            ++var4;
         }

         var5[var4] = new class_303.class_1352();
         var1.method_4563(var5[var4]);
         this.ayq = var5;
      }
   }

   public static final class class_1352 extends qq<class_303.class_1352> {
      private static volatile class_303.class_1352[] ayr;
      public class_303.class_1353 ays;
      public String name;

      public class_1352() {
         this.method_2125();
      }

      // $FF: renamed from: ru () com.google.android.gms.internal.qm$a[]
      public static class_303.class_1352[] method_2124() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         var1.method_4537(1, this.name);
         if(this.ays != null) {
            var1.method_4532(2, this.ays);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2126(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091() + class_826.method_4521(1, this.name);
         if(this.ays != null) {
            var1 += class_826.method_4507(2, this.ays);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_303.class_1352;
            var3 = false;
            if(var2) {
               class_303.class_1352 var4 = (class_303.class_1352)var1;
               if(this.name == null) {
                  String var6 = var4.name;
                  var3 = false;
                  if(var6 != null) {
                     return var3;
                  }
               } else if(!this.name.equals(var4.name)) {
                  return false;
               }

               if(this.ays == null) {
                  class_303.class_1353 var5 = var4.ays;
                  var3 = false;
                  if(var5 != null) {
                     return var3;
                  }
               } else if(!this.ays.equals(var4.ays)) {
                  return false;
               }

               return this.a(var4);
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1;
         if(this.name == null) {
            var1 = 0;
         } else {
            var1 = this.name.hashCode();
         }

         int var2 = 31 * (var1 + 527);
         class_303.class_1353 var3 = this.ays;
         int var4 = 0;
         if(var3 != null) {
            var4 = this.ays.hashCode();
         }

         return 31 * (var2 + var4) + this.rQ();
      }

      // $FF: renamed from: rv () com.google.android.gms.internal.qm$a
      public class_303.class_1352 method_2125() {
         this.name = "";
         this.ays = null;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      // $FF: renamed from: u (com.google.android.gms.internal.qo) com.google.android.gms.internal.qm$a
      public class_303.class_1352 method_2126(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            switch(var2) {
            case 10:
               this.name = var1.readString();
               break;
            case 18:
               if(this.ays == null) {
                  this.ays = new class_303.class_1353();
               }

               var1.method_4563(this.ays);
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

   public static final class class_1353 extends qq<class_303.class_1353> {
      private static volatile class_303.class_1353[] ayt;
      public class_303.class_1354 ayu;
      public int type;

      public class_1353() {
         this.method_2131();
      }

      // $FF: renamed from: rw () com.google.android.gms.internal.qm$a$a[]
      public static class_303.class_1353[] method_2130() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         var1.method_4554(1, this.type);
         if(this.ayu != null) {
            var1.method_4532(2, this.ayu);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2132(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091() + class_826.method_4524(1, this.type);
         if(this.ayu != null) {
            var1 += class_826.method_4507(2, this.ayu);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_303.class_1353;
            var3 = false;
            if(var2) {
               class_303.class_1353 var4 = (class_303.class_1353)var1;
               int var5 = this.type;
               int var6 = var4.type;
               var3 = false;
               if(var5 == var6) {
                  if(this.ayu == null) {
                     class_303.class_1354 var7 = var4.ayu;
                     var3 = false;
                     if(var7 != null) {
                        return var3;
                     }
                  } else if(!this.ayu.equals(var4.ayu)) {
                     return false;
                  }

                  return this.a(var4);
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (527 + this.type);
         int var2;
         if(this.ayu == null) {
            var2 = 0;
         } else {
            var2 = this.ayu.hashCode();
         }

         return 31 * (var2 + var1) + this.rQ();
      }

      // $FF: renamed from: rx () com.google.android.gms.internal.qm$a$a
      public class_303.class_1353 method_2131() {
         this.type = 1;
         this.ayu = null;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      // $FF: renamed from: v (com.google.android.gms.internal.qo) com.google.android.gms.internal.qm$a$a
      public class_303.class_1353 method_2132(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            switch(var2) {
            case 8:
               int var3 = var1.method_4574();
               switch(var3) {
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
                  this.type = var3;
               default:
                  continue;
               }
            case 18:
               if(this.ayu == null) {
                  this.ayu = new class_303.class_1354();
               }

               var1.method_4563(this.ayu);
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

   public static final class class_1354 extends qq<class_303.class_1354> {
      public int ayA;
      public int ayB;
      public boolean ayC;
      public class_303.class_1352[] ayD;
      public class_303.class_1353[] ayE;
      public String[] ayF;
      public long[] ayG;
      public float[] ayH;
      public long ayI;
      public byte[] ayv;
      public String ayw;
      public double ayx;
      public float ayy;
      public long ayz;

      public class_1354() {
         this.method_2098();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(!Arrays.equals(this.ayv, class_822.azq)) {
            var1.method_4533(1, this.ayv);
         }

         if(!this.ayw.equals("")) {
            var1.method_4537(2, this.ayw);
         }

         if(Double.doubleToLongBits(this.ayx) != Double.doubleToLongBits(0.0D)) {
            var1.method_4531(3, this.ayx);
         }

         if(Float.floatToIntBits(this.ayy) != Float.floatToIntBits(0.0F)) {
            var1.method_4535(4, this.ayy);
         }

         if(this.ayz != 0L) {
            var1.method_4536(5, this.ayz);
         }

         if(this.ayA != 0) {
            var1.method_4554(6, this.ayA);
         }

         if(this.ayB != 0) {
            var1.method_4556(7, this.ayB);
         }

         if(this.ayC) {
            var1.method_4538(8, this.ayC);
         }

         if(this.ayD != null && this.ayD.length > 0) {
            for(int var9 = 0; var9 < this.ayD.length; ++var9) {
               class_303.class_1352 var10 = this.ayD[var9];
               if(var10 != null) {
                  var1.method_4532(9, var10);
               }
            }
         }

         if(this.ayE != null && this.ayE.length > 0) {
            for(int var7 = 0; var7 < this.ayE.length; ++var7) {
               class_303.class_1353 var8 = this.ayE[var7];
               if(var8 != null) {
                  var1.method_4532(10, var8);
               }
            }
         }

         if(this.ayF != null && this.ayF.length > 0) {
            for(int var5 = 0; var5 < this.ayF.length; ++var5) {
               String var6 = this.ayF[var5];
               if(var6 != null) {
                  var1.method_4537(11, var6);
               }
            }
         }

         if(this.ayG != null && this.ayG.length > 0) {
            for(int var4 = 0; var4 < this.ayG.length; ++var4) {
               var1.method_4536(12, this.ayG[var4]);
            }
         }

         if(this.ayI != 0L) {
            var1.method_4536(13, this.ayI);
         }

         if(this.ayH != null) {
            int var2 = this.ayH.length;
            int var3 = 0;
            if(var2 > 0) {
               while(var3 < this.ayH.length) {
                  var1.method_4535(14, this.ayH[var3]);
                  ++var3;
               }
            }
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2099(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = 0;
         int var2 = super.method_2091();
         if(!Arrays.equals(this.ayv, class_822.azq)) {
            var2 += class_826.method_4504(1, this.ayv);
         }

         if(!this.ayw.equals("")) {
            var2 += class_826.method_4521(2, this.ayw);
         }

         if(Double.doubleToLongBits(this.ayx) != Double.doubleToLongBits(0.0D)) {
            var2 += class_826.method_4502(3, this.ayx);
         }

         if(Float.floatToIntBits(this.ayy) != Float.floatToIntBits(0.0F)) {
            var2 += class_826.method_4506(4, this.ayy);
         }

         if(this.ayz != 0L) {
            var2 += class_826.method_4509(5, this.ayz);
         }

         if(this.ayA != 0) {
            var2 += class_826.method_4524(6, this.ayA);
         }

         if(this.ayB != 0) {
            var2 += class_826.method_4525(7, this.ayB);
         }

         if(this.ayC) {
            var2 += class_826.method_4508(8, this.ayC);
         }

         if(this.ayD != null && this.ayD.length > 0) {
            int var11 = var2;

            for(int var12 = 0; var12 < this.ayD.length; ++var12) {
               class_303.class_1352 var13 = this.ayD[var12];
               if(var13 != null) {
                  var11 += class_826.method_4507(9, var13);
               }
            }

            var2 = var11;
         }

         if(this.ayE != null && this.ayE.length > 0) {
            int var8 = var2;

            for(int var9 = 0; var9 < this.ayE.length; ++var9) {
               class_303.class_1353 var10 = this.ayE[var9];
               if(var10 != null) {
                  var8 += class_826.method_4507(10, var10);
               }
            }

            var2 = var8;
         }

         if(this.ayF != null && this.ayF.length > 0) {
            int var4 = 0;
            int var5 = 0;

            int var6;
            for(var6 = 0; var4 < this.ayF.length; ++var4) {
               String var7 = this.ayF[var4];
               if(var7 != null) {
                  ++var6;
                  var5 += class_826.method_4511(var7);
               }
            }

            var2 = var2 + var5 + var6 * 1;
         }

         if(this.ayG != null && this.ayG.length > 0) {
            int var3;
            for(var3 = 0; var1 < this.ayG.length; ++var1) {
               var3 += class_826.method_4497(this.ayG[var1]);
            }

            var2 = var2 + var3 + 1 * this.ayG.length;
         }

         if(this.ayI != 0L) {
            var2 += class_826.method_4509(13, this.ayI);
         }

         if(this.ayH != null && this.ayH.length > 0) {
            var2 = var2 + 4 * this.ayH.length + 1 * this.ayH.length;
         }

         return var2;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_303.class_1354;
            var3 = false;
            if(var2) {
               class_303.class_1354 var4 = (class_303.class_1354)var1;
               boolean var5 = Arrays.equals(this.ayv, var4.ayv);
               var3 = false;
               if(var5) {
                  if(this.ayw == null) {
                     String var22 = var4.ayw;
                     var3 = false;
                     if(var22 != null) {
                        return var3;
                     }
                  } else if(!this.ayw.equals(var4.ayw)) {
                     return false;
                  }

                  long var23;
                  int var6 = (var23 = Double.doubleToLongBits(this.ayx) - Double.doubleToLongBits(var4.ayx)) == 0L?0:(var23 < 0L?-1:1);
                  var3 = false;
                  if(var6 == 0) {
                     int var7 = Float.floatToIntBits(this.ayy);
                     int var8 = Float.floatToIntBits(var4.ayy);
                     var3 = false;
                     if(var7 == var8) {
                        long var24;
                        int var9 = (var24 = this.ayz - var4.ayz) == 0L?0:(var24 < 0L?-1:1);
                        var3 = false;
                        if(var9 == 0) {
                           int var10 = this.ayA;
                           int var11 = var4.ayA;
                           var3 = false;
                           if(var10 == var11) {
                              int var12 = this.ayB;
                              int var13 = var4.ayB;
                              var3 = false;
                              if(var12 == var13) {
                                 boolean var14 = this.ayC;
                                 boolean var15 = var4.ayC;
                                 var3 = false;
                                 if(var14 == var15) {
                                    boolean var16 = class_834.equals((Object[])this.ayD, (Object[])var4.ayD);
                                    var3 = false;
                                    if(var16) {
                                       boolean var17 = class_834.equals((Object[])this.ayE, (Object[])var4.ayE);
                                       var3 = false;
                                       if(var17) {
                                          boolean var18 = class_834.equals((Object[])this.ayF, (Object[])var4.ayF);
                                          var3 = false;
                                          if(var18) {
                                             boolean var19 = class_834.equals(this.ayG, var4.ayG);
                                             var3 = false;
                                             if(var19) {
                                                boolean var20 = class_834.equals(this.ayH, var4.ayH);
                                                var3 = false;
                                                if(var20) {
                                                   long var25;
                                                   int var21 = (var25 = this.ayI - var4.ayI) == 0L?0:(var25 < 0L?-1:1);
                                                   var3 = false;
                                                   if(var21 == 0) {
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
                  }
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (527 + Arrays.hashCode(this.ayv));
         int var2;
         if(this.ayw == null) {
            var2 = 0;
         } else {
            var2 = this.ayw.hashCode();
         }

         int var3 = var2 + var1;
         long var4 = Double.doubleToLongBits(this.ayx);
         int var6 = 31 * (31 * (31 * (31 * (31 * (var3 * 31 + (int)(var4 ^ var4 >>> 32)) + Float.floatToIntBits(this.ayy)) + (int)(this.ayz ^ this.ayz >>> 32)) + this.ayA) + this.ayB);
         short var7;
         if(this.ayC) {
            var7 = 1231;
         } else {
            var7 = 1237;
         }

         return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (var7 + var6) + class_834.hashCode((Object[])this.ayD)) + class_834.hashCode((Object[])this.ayE)) + class_834.hashCode((Object[])this.ayF)) + class_834.hashCode(this.ayG)) + class_834.hashCode(this.ayH)) + (int)(this.ayI ^ this.ayI >>> 32)) + this.rQ();
      }

      // $FF: renamed from: ry () com.google.android.gms.internal.qm$a$a$a
      public class_303.class_1354 method_2098() {
         this.ayv = class_822.azq;
         this.ayw = "";
         this.ayx = 0.0D;
         this.ayy = 0.0F;
         this.ayz = 0L;
         this.ayA = 0;
         this.ayB = 0;
         this.ayC = false;
         this.ayD = class_303.class_1352.method_2124();
         this.ayE = class_303.class_1353.method_2130();
         this.ayF = class_822.azo;
         this.ayG = class_822.azk;
         this.ayH = class_822.azl;
         this.ayI = 0L;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      // $FF: renamed from: w (com.google.android.gms.internal.qo) com.google.android.gms.internal.qm$a$a$a
      public class_303.class_1354 method_2099(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            int var32;
            class_303.class_1352[] var33;
            switch(var2) {
            case 10:
               this.ayv = var1.readBytes();
               continue;
            case 18:
               this.ayw = var1.readString();
               continue;
            case 25:
               this.ayx = var1.readDouble();
               continue;
            case 37:
               this.ayy = var1.readFloat();
               continue;
            case 40:
               this.ayz = var1.method_4573();
               continue;
            case 48:
               this.ayA = var1.method_4574();
               continue;
            case 56:
               this.ayB = var1.method_4576();
               continue;
            case 64:
               this.ayC = var1.method_4575();
               continue;
            case 74:
               int var31 = class_822.method_4484(var1, 74);
               if(this.ayD == null) {
                  var32 = 0;
               } else {
                  var32 = this.ayD.length;
               }

               var33 = new class_303.class_1352[var31 + var32];
               if(var32 != 0) {
                  System.arraycopy(this.ayD, 0, var33, 0, var32);
               }
               break;
            case 82:
               int var27 = class_822.method_4484(var1, 82);
               int var28;
               if(this.ayE == null) {
                  var28 = 0;
               } else {
                  var28 = this.ayE.length;
               }

               class_303.class_1353[] var29 = new class_303.class_1353[var27 + var28];
               if(var28 != 0) {
                  System.arraycopy(this.ayE, 0, var29, 0, var28);
               }

               while(var28 < -1 + var29.length) {
                  var29[var28] = new class_303.class_1353();
                  var1.method_4563(var29[var28]);
                  var1.method_4585();
                  ++var28;
               }

               var29[var28] = new class_303.class_1353();
               var1.method_4563(var29[var28]);
               this.ayE = var29;
               continue;
            case 90:
               int var23 = class_822.method_4484(var1, 90);
               int var24;
               if(this.ayF == null) {
                  var24 = 0;
               } else {
                  var24 = this.ayF.length;
               }

               String[] var25 = new String[var23 + var24];
               if(var24 != 0) {
                  System.arraycopy(this.ayF, 0, var25, 0, var24);
               }

               while(var24 < -1 + var25.length) {
                  var25[var24] = var1.readString();
                  var1.method_4585();
                  ++var24;
               }

               var25[var24] = var1.readString();
               this.ayF = var25;
               continue;
            case 96:
               int var19 = class_822.method_4484(var1, 96);
               int var20;
               if(this.ayG == null) {
                  var20 = 0;
               } else {
                  var20 = this.ayG.length;
               }

               long[] var21 = new long[var19 + var20];
               if(var20 != 0) {
                  System.arraycopy(this.ayG, 0, var21, 0, var20);
               }

               while(var20 < -1 + var21.length) {
                  var21[var20] = var1.method_4573();
                  var1.method_4585();
                  ++var20;
               }

               var21[var20] = var1.method_4573();
               this.ayG = var21;
               continue;
            case 98:
               int var12 = var1.method_4567(var1.method_4578());
               int var13 = var1.getPosition();

               int var14;
               for(var14 = 0; var1.method_4582() > 0; ++var14) {
                  var1.method_4573();
               }

               var1.method_4569(var13);
               int var15;
               if(this.ayG == null) {
                  var15 = 0;
               } else {
                  var15 = this.ayG.length;
               }

               long[] var16 = new long[var14 + var15];
               if(var15 != 0) {
                  System.arraycopy(this.ayG, 0, var16, 0, var15);
               }

               while(var15 < var16.length) {
                  var16[var15] = var1.method_4573();
                  ++var15;
               }

               this.ayG = var16;
               var1.method_4568(var12);
               continue;
            case 104:
               this.ayI = var1.method_4573();
               continue;
            case 114:
               int var3 = var1.method_4578();
               int var4 = var1.method_4567(var3);
               int var5 = var3 / 4;
               int var6;
               if(this.ayH == null) {
                  var6 = 0;
               } else {
                  var6 = this.ayH.length;
               }

               float[] var7 = new float[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.ayH, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.readFloat();
                  ++var6;
               }

               this.ayH = var7;
               var1.method_4568(var4);
               continue;
            case 117:
               int var8 = class_822.method_4484(var1, 117);
               int var9;
               if(this.ayH == null) {
                  var9 = 0;
               } else {
                  var9 = this.ayH.length;
               }

               float[] var10 = new float[var8 + var9];
               if(var9 != 0) {
                  System.arraycopy(this.ayH, 0, var10, 0, var9);
               }

               while(var9 < -1 + var10.length) {
                  var10[var9] = var1.readFloat();
                  var1.method_4585();
                  ++var9;
               }

               var10[var9] = var1.readFloat();
               this.ayH = var10;
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var32 < -1 + var33.length) {
               var33[var32] = new class_303.class_1352();
               var1.method_4563(var33[var32]);
               var1.method_4585();
               ++var32;
            }

            var33[var32] = new class_303.class_1352();
            var1.method_4563(var33[var32]);
            this.ayD = var33;
         }
      }
   }
}
