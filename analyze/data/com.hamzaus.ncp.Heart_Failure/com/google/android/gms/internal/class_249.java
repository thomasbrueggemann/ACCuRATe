package com.google.android.gms.internal;

import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_601;
import com.google.android.gms.internal.class_602;
import com.google.android.gms.internal.class_605;
import com.google.android.gms.internal.class_637;
import com.google.android.gms.internal.class_638;
import com.google.android.gms.internal.lx;
import com.google.android.gms.internal.mb;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.lx
public final class class_249 extends mb<lx> {
   public class_249.class_881[] amo;

   public class_249() {
      this.method_1737();
   }

   // $FF: renamed from: n (byte[]) com.google.android.gms.internal.lx
   public static class_249 method_1736(byte[] var0) throws class_637 {
      return (class_249)class_246.method_1717(new class_249(), var0);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ma) void
   public void method_1721(class_601 var1) throws IOException {
      if(this.amo != null && this.amo.length > 0) {
         for(int var2 = 0; var2 < this.amo.length; ++var2) {
            class_249.class_881 var3 = this.amo[var2];
            if(var3 != null) {
               var1.method_3515(1, var3);
            }
         }
      }

      super.method_1721(var1);
   }

   // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
   // $FF: synthetic method
   public class_246 method_1722(class_605 var1) throws IOException {
      return this.method_1738(var1);
   }

   // $FF: renamed from: c () int
   protected int method_1723() {
      int var1 = super.method_1723();
      if(this.amo != null && this.amo.length > 0) {
         for(int var2 = 0; var2 < this.amo.length; ++var2) {
            class_249.class_881 var3 = this.amo[var2];
            if(var3 != null) {
               var1 += class_601.method_3488(1, var3);
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
         boolean var2 = var1 instanceof class_249;
         var3 = false;
         if(var2) {
            class_249 var4 = (class_249)var1;
            boolean var5 = class_602.equals((Object[])this.amo, (Object[])var4.amo);
            var3 = false;
            if(var5) {
               if(this.amU != null && !this.amU.isEmpty()) {
                  return this.amU.equals(var4.amU);
               }

               if(var4.amU != null) {
                  boolean var6 = var4.amU.isEmpty();
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
      int var1 = 31 * (527 + class_602.hashCode((Object[])this.amo));
      int var2;
      if(this.amU != null && !this.amU.isEmpty()) {
         var2 = this.amU.hashCode();
      } else {
         var2 = 0;
      }

      return var2 + var1;
   }

   // $FF: renamed from: nq () com.google.android.gms.internal.lx
   public class_249 method_1737() {
      this.amo = class_249.class_881.method_1774();
      this.amU = null;
      this.amY = -1;
      return this;
   }

   // $FF: renamed from: q (com.google.android.gms.internal.lz) com.google.android.gms.internal.lx
   public class_249 method_1738(class_605 var1) throws IOException {
      while(true) {
         int var2 = var1.method_3570();
         int var4;
         class_249.class_881[] var5;
         switch(var2) {
         case 10:
            int var3 = class_638.method_3656(var1, 10);
            if(this.amo == null) {
               var4 = 0;
            } else {
               var4 = this.amo.length;
            }

            var5 = new class_249.class_881[var3 + var4];
            if(var4 != 0) {
               System.arraycopy(this.amo, 0, var5, 0, var4);
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
            var5[var4] = new class_249.class_881();
            var1.method_3551(var5[var4]);
            var1.method_3570();
            ++var4;
         }

         var5[var4] = new class_249.class_881();
         var1.method_3551(var5[var4]);
         this.amo = var5;
      }
   }

   public static final class class_881 extends mb<class_249.class_881> {
      private static volatile class_249.class_881[] amp;
      public class_249.class_882 amq;
      public String name;

      public class_881() {
         this.method_1775();
      }

      // $FF: renamed from: nr () com.google.android.gms.internal.lx$a[]
      public static class_249.class_881[] method_1774() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         var1.method_3521(1, this.name);
         if(this.amq != null) {
            var1.method_3515(2, this.amq);
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1776(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = super.method_1723() + class_601.method_3504(1, this.name);
         if(this.amq != null) {
            var1 += class_601.method_3488(2, this.amq);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_249.class_881;
            var3 = false;
            if(var2) {
               class_249.class_881 var4 = (class_249.class_881)var1;
               if(this.name == null) {
                  String var7 = var4.name;
                  var3 = false;
                  if(var7 != null) {
                     return var3;
                  }
               } else if(!this.name.equals(var4.name)) {
                  return false;
               }

               if(this.amq == null) {
                  class_249.class_882 var6 = var4.amq;
                  var3 = false;
                  if(var6 != null) {
                     return var3;
                  }
               } else if(!this.amq.equals(var4.amq)) {
                  return false;
               }

               if(this.amU != null && !this.amU.isEmpty()) {
                  return this.amU.equals(var4.amU);
               }

               if(var4.amU != null) {
                  boolean var5 = var4.amU.isEmpty();
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
         int var1;
         if(this.name == null) {
            var1 = 0;
         } else {
            var1 = this.name.hashCode();
         }

         int var2 = 31 * (var1 + 527);
         int var3;
         if(this.amq == null) {
            var3 = 0;
         } else {
            var3 = this.amq.hashCode();
         }

         int var4 = 31 * (var3 + var2);
         List var5 = this.amU;
         int var6 = 0;
         if(var5 != null) {
            boolean var7 = this.amU.isEmpty();
            var6 = 0;
            if(!var7) {
               var6 = this.amU.hashCode();
            }
         }

         return var4 + var6;
      }

      // $FF: renamed from: ns () com.google.android.gms.internal.lx$a
      public class_249.class_881 method_1775() {
         this.name = "";
         this.amq = null;
         this.amU = null;
         this.amY = -1;
         return this;
      }

      // $FF: renamed from: r (com.google.android.gms.internal.lz) com.google.android.gms.internal.lx$a
      public class_249.class_881 method_1776(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            switch(var2) {
            case 10:
               this.name = var1.readString();
               break;
            case 18:
               if(this.amq == null) {
                  this.amq = new class_249.class_882();
               }

               var1.method_3551(this.amq);
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

   public static final class class_882 extends mb<class_249.class_882> {
      private static volatile class_249.class_882[] amr;
      public class_249.class_883 ams;
      public int type;

      public class_882() {
         this.method_1745();
      }

      // $FF: renamed from: nt () com.google.android.gms.internal.lx$a$a[]
      public static class_249.class_882[] method_1744() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         var1.method_3535(1, this.type);
         if(this.ams != null) {
            var1.method_3515(2, this.ams);
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1746(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = super.method_1723() + class_601.method_3506(1, this.type);
         if(this.ams != null) {
            var1 += class_601.method_3488(2, this.ams);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_249.class_882;
            var3 = false;
            if(var2) {
               class_249.class_882 var4 = (class_249.class_882)var1;
               int var5 = this.type;
               int var6 = var4.type;
               var3 = false;
               if(var5 == var6) {
                  if(this.ams == null) {
                     class_249.class_883 var8 = var4.ams;
                     var3 = false;
                     if(var8 != null) {
                        return var3;
                     }
                  } else if(!this.ams.equals(var4.ams)) {
                     return false;
                  }

                  if(this.amU != null && !this.amU.isEmpty()) {
                     return this.amU.equals(var4.amU);
                  }

                  if(var4.amU != null) {
                     boolean var7 = var4.amU.isEmpty();
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
         int var1 = 31 * (527 + this.type);
         int var2;
         if(this.ams == null) {
            var2 = 0;
         } else {
            var2 = this.ams.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         List var4 = this.amU;
         int var5 = 0;
         if(var4 != null) {
            boolean var6 = this.amU.isEmpty();
            var5 = 0;
            if(!var6) {
               var5 = this.amU.hashCode();
            }
         }

         return var3 + var5;
      }

      // $FF: renamed from: nu () com.google.android.gms.internal.lx$a$a
      public class_249.class_882 method_1745() {
         this.type = 1;
         this.ams = null;
         this.amU = null;
         this.amY = -1;
         return this;
      }

      // $FF: renamed from: s (com.google.android.gms.internal.lz) com.google.android.gms.internal.lx$a$a
      public class_249.class_882 method_1746(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            switch(var2) {
            case 8:
               int var3 = var1.method_3573();
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
               if(this.ams == null) {
                  this.ams = new class_249.class_883();
               }

               var1.method_3551(this.ams);
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

   public static final class class_883 extends mb<class_249.class_883> {
      public boolean amA;
      public class_249.class_881[] amB;
      public class_249.class_882[] amC;
      public String[] amD;
      public long[] amE;
      public float[] amF;
      public long amG;
      public byte[] amt;
      public String amu;
      public double amv;
      public float amw;
      public long amx;
      public int amy;
      public int amz;

      public class_883() {
         this.method_1734();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         if(!Arrays.equals(this.amt, class_638.anh)) {
            var1.method_3517(1, this.amt);
         }

         if(!this.amu.equals("")) {
            var1.method_3521(2, this.amu);
         }

         if(Double.doubleToLongBits(this.amv) != Double.doubleToLongBits(0.0D)) {
            var1.method_3514(3, this.amv);
         }

         if(Float.floatToIntBits(this.amw) != Float.floatToIntBits(0.0F)) {
            var1.method_3519(4, this.amw);
         }

         if(this.amx != 0L) {
            var1.method_3520(5, this.amx);
         }

         if(this.amy != 0) {
            var1.method_3535(6, this.amy);
         }

         if(this.amz != 0) {
            var1.method_3536(7, this.amz);
         }

         if(this.amA) {
            var1.method_3516(8, this.amA);
         }

         if(this.amB != null && this.amB.length > 0) {
            for(int var9 = 0; var9 < this.amB.length; ++var9) {
               class_249.class_881 var10 = this.amB[var9];
               if(var10 != null) {
                  var1.method_3515(9, var10);
               }
            }
         }

         if(this.amC != null && this.amC.length > 0) {
            for(int var7 = 0; var7 < this.amC.length; ++var7) {
               class_249.class_882 var8 = this.amC[var7];
               if(var8 != null) {
                  var1.method_3515(10, var8);
               }
            }
         }

         if(this.amD != null && this.amD.length > 0) {
            for(int var5 = 0; var5 < this.amD.length; ++var5) {
               String var6 = this.amD[var5];
               if(var6 != null) {
                  var1.method_3521(11, var6);
               }
            }
         }

         if(this.amE != null && this.amE.length > 0) {
            for(int var4 = 0; var4 < this.amE.length; ++var4) {
               var1.method_3520(12, this.amE[var4]);
            }
         }

         if(this.amG != 0L) {
            var1.method_3520(13, this.amG);
         }

         if(this.amF != null) {
            int var2 = this.amF.length;
            int var3 = 0;
            if(var2 > 0) {
               while(var3 < this.amF.length) {
                  var1.method_3519(14, this.amF[var3]);
                  ++var3;
               }
            }
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1735(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = 0;
         int var2 = super.method_1723();
         if(!Arrays.equals(this.amt, class_638.anh)) {
            var2 += class_601.method_3490(1, this.amt);
         }

         if(!this.amu.equals("")) {
            var2 += class_601.method_3504(2, this.amu);
         }

         if(Double.doubleToLongBits(this.amv) != Double.doubleToLongBits(0.0D)) {
            var2 += class_601.method_3487(3, this.amv);
         }

         if(Float.floatToIntBits(this.amw) != Float.floatToIntBits(0.0F)) {
            var2 += class_601.method_3492(4, this.amw);
         }

         if(this.amx != 0L) {
            var2 += class_601.method_3495(5, this.amx);
         }

         if(this.amy != 0) {
            var2 += class_601.method_3506(6, this.amy);
         }

         if(this.amz != 0) {
            var2 += class_601.method_3507(7, this.amz);
         }

         if(this.amA) {
            var2 += class_601.method_3489(8, this.amA);
         }

         if(this.amB != null && this.amB.length > 0) {
            int var11 = var2;

            for(int var12 = 0; var12 < this.amB.length; ++var12) {
               class_249.class_881 var13 = this.amB[var12];
               if(var13 != null) {
                  var11 += class_601.method_3488(9, var13);
               }
            }

            var2 = var11;
         }

         if(this.amC != null && this.amC.length > 0) {
            int var8 = var2;

            for(int var9 = 0; var9 < this.amC.length; ++var9) {
               class_249.class_882 var10 = this.amC[var9];
               if(var10 != null) {
                  var8 += class_601.method_3488(10, var10);
               }
            }

            var2 = var8;
         }

         if(this.amD != null && this.amD.length > 0) {
            int var4 = 0;
            int var5 = 0;

            int var6;
            for(var6 = 0; var4 < this.amD.length; ++var4) {
               String var7 = this.amD[var4];
               if(var7 != null) {
                  ++var6;
                  var5 += class_601.method_3494(var7);
               }
            }

            var2 = var2 + var5 + var6 * 1;
         }

         if(this.amE != null && this.amE.length > 0) {
            int var3;
            for(var3 = 0; var1 < this.amE.length; ++var1) {
               var3 += class_601.method_3482(this.amE[var1]);
            }

            var2 = var2 + var3 + 1 * this.amE.length;
         }

         if(this.amG != 0L) {
            var2 += class_601.method_3495(13, this.amG);
         }

         if(this.amF != null && this.amF.length > 0) {
            var2 = var2 + 4 * this.amF.length + 1 * this.amF.length;
         }

         return var2;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_249.class_883;
            var3 = false;
            if(var2) {
               class_249.class_883 var4 = (class_249.class_883)var1;
               boolean var5 = Arrays.equals(this.amt, var4.amt);
               var3 = false;
               if(var5) {
                  if(this.amu == null) {
                     String var23 = var4.amu;
                     var3 = false;
                     if(var23 != null) {
                        return var3;
                     }
                  } else if(!this.amu.equals(var4.amu)) {
                     return false;
                  }

                  long var24;
                  int var6 = (var24 = Double.doubleToLongBits(this.amv) - Double.doubleToLongBits(var4.amv)) == 0L?0:(var24 < 0L?-1:1);
                  var3 = false;
                  if(var6 == 0) {
                     int var7 = Float.floatToIntBits(this.amw);
                     int var8 = Float.floatToIntBits(var4.amw);
                     var3 = false;
                     if(var7 == var8) {
                        long var25;
                        int var9 = (var25 = this.amx - var4.amx) == 0L?0:(var25 < 0L?-1:1);
                        var3 = false;
                        if(var9 == 0) {
                           int var10 = this.amy;
                           int var11 = var4.amy;
                           var3 = false;
                           if(var10 == var11) {
                              int var12 = this.amz;
                              int var13 = var4.amz;
                              var3 = false;
                              if(var12 == var13) {
                                 boolean var14 = this.amA;
                                 boolean var15 = var4.amA;
                                 var3 = false;
                                 if(var14 == var15) {
                                    boolean var16 = class_602.equals((Object[])this.amB, (Object[])var4.amB);
                                    var3 = false;
                                    if(var16) {
                                       boolean var17 = class_602.equals((Object[])this.amC, (Object[])var4.amC);
                                       var3 = false;
                                       if(var17) {
                                          boolean var18 = class_602.equals((Object[])this.amD, (Object[])var4.amD);
                                          var3 = false;
                                          if(var18) {
                                             boolean var19 = class_602.equals(this.amE, var4.amE);
                                             var3 = false;
                                             if(var19) {
                                                boolean var20 = class_602.equals(this.amF, var4.amF);
                                                var3 = false;
                                                if(var20) {
                                                   long var26;
                                                   int var21 = (var26 = this.amG - var4.amG) == 0L?0:(var26 < 0L?-1:1);
                                                   var3 = false;
                                                   if(var21 == 0) {
                                                      if(this.amU != null && !this.amU.isEmpty()) {
                                                         return this.amU.equals(var4.amU);
                                                      }

                                                      if(var4.amU != null) {
                                                         boolean var22 = var4.amU.isEmpty();
                                                         var3 = false;
                                                         if(!var22) {
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
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (527 + Arrays.hashCode(this.amt));
         int var2;
         if(this.amu == null) {
            var2 = 0;
         } else {
            var2 = this.amu.hashCode();
         }

         int var3 = var2 + var1;
         long var4 = Double.doubleToLongBits(this.amv);
         int var6 = 31 * (31 * (31 * (31 * (31 * (var3 * 31 + (int)(var4 ^ var4 >>> 32)) + Float.floatToIntBits(this.amw)) + (int)(this.amx ^ this.amx >>> 32)) + this.amy) + this.amz);
         short var7;
         if(this.amA) {
            var7 = 1231;
         } else {
            var7 = 1237;
         }

         int var8 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (var7 + var6) + class_602.hashCode((Object[])this.amB)) + class_602.hashCode((Object[])this.amC)) + class_602.hashCode((Object[])this.amD)) + class_602.hashCode(this.amE)) + class_602.hashCode(this.amF)) + (int)(this.amG ^ this.amG >>> 32));
         List var9 = this.amU;
         int var10 = 0;
         if(var9 != null) {
            boolean var11 = this.amU.isEmpty();
            var10 = 0;
            if(!var11) {
               var10 = this.amU.hashCode();
            }
         }

         return var8 + var10;
      }

      // $FF: renamed from: nv () com.google.android.gms.internal.lx$a$a$a
      public class_249.class_883 method_1734() {
         this.amt = class_638.anh;
         this.amu = "";
         this.amv = 0.0D;
         this.amw = 0.0F;
         this.amx = 0L;
         this.amy = 0;
         this.amz = 0;
         this.amA = false;
         this.amB = class_249.class_881.method_1774();
         this.amC = class_249.class_882.method_1744();
         this.amD = class_638.anf;
         this.amE = class_638.anb;
         this.amF = class_638.anc;
         this.amG = 0L;
         this.amU = null;
         this.amY = -1;
         return this;
      }

      // $FF: renamed from: t (com.google.android.gms.internal.lz) com.google.android.gms.internal.lx$a$a$a
      public class_249.class_883 method_1735(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            int var32;
            class_249.class_881[] var33;
            switch(var2) {
            case 10:
               this.amt = var1.readBytes();
               continue;
            case 18:
               this.amu = var1.readString();
               continue;
            case 25:
               this.amv = var1.readDouble();
               continue;
            case 37:
               this.amw = var1.readFloat();
               continue;
            case 40:
               this.amx = var1.method_3572();
               continue;
            case 48:
               this.amy = var1.method_3573();
               continue;
            case 56:
               this.amz = var1.method_3561();
               continue;
            case 64:
               this.amA = var1.method_3560();
               continue;
            case 74:
               int var31 = class_638.method_3656(var1, 74);
               if(this.amB == null) {
                  var32 = 0;
               } else {
                  var32 = this.amB.length;
               }

               var33 = new class_249.class_881[var31 + var32];
               if(var32 != 0) {
                  System.arraycopy(this.amB, 0, var33, 0, var32);
               }
               break;
            case 82:
               int var27 = class_638.method_3656(var1, 82);
               int var28;
               if(this.amC == null) {
                  var28 = 0;
               } else {
                  var28 = this.amC.length;
               }

               class_249.class_882[] var29 = new class_249.class_882[var27 + var28];
               if(var28 != 0) {
                  System.arraycopy(this.amC, 0, var29, 0, var28);
               }

               while(var28 < -1 + var29.length) {
                  var29[var28] = new class_249.class_882();
                  var1.method_3551(var29[var28]);
                  var1.method_3570();
                  ++var28;
               }

               var29[var28] = new class_249.class_882();
               var1.method_3551(var29[var28]);
               this.amC = var29;
               continue;
            case 90:
               int var23 = class_638.method_3656(var1, 90);
               int var24;
               if(this.amD == null) {
                  var24 = 0;
               } else {
                  var24 = this.amD.length;
               }

               String[] var25 = new String[var23 + var24];
               if(var24 != 0) {
                  System.arraycopy(this.amD, 0, var25, 0, var24);
               }

               while(var24 < -1 + var25.length) {
                  var25[var24] = var1.readString();
                  var1.method_3570();
                  ++var24;
               }

               var25[var24] = var1.readString();
               this.amD = var25;
               continue;
            case 96:
               int var19 = class_638.method_3656(var1, 96);
               int var20;
               if(this.amE == null) {
                  var20 = 0;
               } else {
                  var20 = this.amE.length;
               }

               long[] var21 = new long[var19 + var20];
               if(var20 != 0) {
                  System.arraycopy(this.amE, 0, var21, 0, var20);
               }

               while(var20 < -1 + var21.length) {
                  var21[var20] = var1.method_3572();
                  var1.method_3570();
                  ++var20;
               }

               var21[var20] = var1.method_3572();
               this.amE = var21;
               continue;
            case 98:
               int var12 = var1.method_3557(var1.method_3563());
               int var13 = var1.getPosition();

               int var14;
               for(var14 = 0; var1.method_3567() > 0; ++var14) {
                  var1.method_3572();
               }

               var1.method_3559(var13);
               int var15;
               if(this.amE == null) {
                  var15 = 0;
               } else {
                  var15 = this.amE.length;
               }

               long[] var16 = new long[var14 + var15];
               if(var15 != 0) {
                  System.arraycopy(this.amE, 0, var16, 0, var15);
               }

               while(var15 < var16.length) {
                  var16[var15] = var1.method_3572();
                  ++var15;
               }

               this.amE = var16;
               var1.method_3558(var12);
               continue;
            case 104:
               this.amG = var1.method_3572();
               continue;
            case 114:
               int var3 = var1.method_3563();
               int var4 = var1.method_3557(var3);
               int var5 = var3 / 4;
               int var6;
               if(this.amF == null) {
                  var6 = 0;
               } else {
                  var6 = this.amF.length;
               }

               float[] var7 = new float[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.amF, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.readFloat();
                  ++var6;
               }

               this.amF = var7;
               var1.method_3558(var4);
               continue;
            case 117:
               int var8 = class_638.method_3656(var1, 117);
               int var9;
               if(this.amF == null) {
                  var9 = 0;
               } else {
                  var9 = this.amF.length;
               }

               float[] var10 = new float[var8 + var9];
               if(var9 != 0) {
                  System.arraycopy(this.amF, 0, var10, 0, var9);
               }

               while(var9 < -1 + var10.length) {
                  var10[var9] = var1.readFloat();
                  var1.method_3570();
                  ++var9;
               }

               var10[var9] = var1.readFloat();
               this.amF = var10;
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var32 < -1 + var33.length) {
               var33[var32] = new class_249.class_881();
               var1.method_3551(var33[var32]);
               var1.method_3570();
               ++var32;
            }

            var33[var32] = new class_249.class_881();
            var1.method_3551(var33[var32]);
            this.amB = var33;
         }
      }
   }
}
