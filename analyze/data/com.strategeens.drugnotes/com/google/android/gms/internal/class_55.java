package com.google.android.gms.internal;

import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.internal.class_822;
import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.class_827;
import com.google.android.gms.internal.class_831;
import com.google.android.gms.internal.class_833;
import com.google.android.gms.internal.class_834;
import com.google.android.gms.internal.qq;
import com.google.android.gms.internal.qr;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.c
public interface class_55 {
   public static final class class_1276 extends qq<class_55.class_1276> {
      // $FF: renamed from: fn int
      public int field_667;
      // $FF: renamed from: fo int
      public int field_668;
      public int level;

      public class_1276() {
         this.method_2137();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qo) com.google.android.gms.internal.c$a
      public class_55.class_1276 method_2136(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            switch(var2) {
            case 8:
               int var3 = var1.method_4574();
               switch(var3) {
               case 1:
               case 2:
               case 3:
                  this.level = var3;
               default:
                  continue;
               }
            case 16:
               this.field_667 = var1.method_4574();
               break;
            case 24:
               this.field_668 = var1.method_4574();
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
         if(this.level != 1) {
            var1.method_4554(1, this.level);
         }

         if(this.field_667 != 0) {
            var1.method_4554(2, this.field_667);
         }

         if(this.field_668 != 0) {
            var1.method_4554(3, this.field_668);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b () com.google.android.gms.internal.c$a
      public class_55.class_1276 method_2137() {
         this.level = 1;
         this.field_667 = 0;
         this.field_668 = 0;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2136(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091();
         if(this.level != 1) {
            var1 += class_826.method_4524(1, this.level);
         }

         if(this.field_667 != 0) {
            var1 += class_826.method_4524(2, this.field_667);
         }

         if(this.field_668 != 0) {
            var1 += class_826.method_4524(3, this.field_668);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_55.class_1276;
            var3 = false;
            if(var2) {
               class_55.class_1276 var4 = (class_55.class_1276)var1;
               int var5 = this.level;
               int var6 = var4.level;
               var3 = false;
               if(var5 == var6) {
                  int var7 = this.field_667;
                  int var8 = var4.field_667;
                  var3 = false;
                  if(var7 == var8) {
                     int var9 = this.field_668;
                     int var10 = var4.field_668;
                     var3 = false;
                     if(var9 == var10) {
                        return this.a(var4);
                     }
                  }
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         return 31 * (31 * (31 * (527 + this.level) + this.field_667) + this.field_668) + this.rQ();
      }
   }

   public static final class class_1273 extends qq<class_55.class_1273> {
      // $FF: renamed from: fp com.google.android.gms.internal.c$b[]
      private static volatile class_55.class_1273[] field_669;
      // $FF: renamed from: fq int[]
      public int[] field_670;
      // $FF: renamed from: fr int
      public int field_671;
      // $FF: renamed from: fs boolean
      public boolean field_672;
      // $FF: renamed from: ft boolean
      public boolean field_673;
      public int name;

      public class_1273() {
         this.method_2140();
      }

      // $FF: renamed from: d () com.google.android.gms.internal.c$b[]
      public static class_55.class_1273[] method_2138() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(this.field_673) {
            var1.method_4538(1, this.field_673);
         }

         var1.method_4554(2, this.field_671);
         if(this.field_670 != null && this.field_670.length > 0) {
            for(int var2 = 0; var2 < this.field_670.length; ++var2) {
               var1.method_4554(3, this.field_670[var2]);
            }
         }

         if(this.name != 0) {
            var1.method_4554(4, this.name);
         }

         if(this.field_672) {
            var1.method_4538(6, this.field_672);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2139(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = 0;
         int var2 = super.method_2091();
         if(this.field_673) {
            var2 += class_826.method_4508(1, this.field_673);
         }

         int var3 = var2 + class_826.method_4524(2, this.field_671);
         int var4;
         if(this.field_670 != null && this.field_670.length > 0) {
            for(int var5 = 0; var5 < this.field_670.length; ++var5) {
               var1 += class_826.method_4516(this.field_670[var5]);
            }

            var4 = var3 + var1 + 1 * this.field_670.length;
         } else {
            var4 = var3;
         }

         if(this.name != 0) {
            var4 += class_826.method_4524(4, this.name);
         }

         if(this.field_672) {
            var4 += class_826.method_4508(6, this.field_672);
         }

         return var4;
      }

      // $FF: renamed from: c (com.google.android.gms.internal.qo) com.google.android.gms.internal.c$b
      public class_55.class_1273 method_2139(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            int var10;
            int[] var11;
            switch(var2) {
            case 8:
               this.field_673 = var1.method_4575();
               continue;
            case 16:
               this.field_671 = var1.method_4574();
               continue;
            case 24:
               int var9 = class_822.method_4484(var1, 24);
               if(this.field_670 == null) {
                  var10 = 0;
               } else {
                  var10 = this.field_670.length;
               }

               var11 = new int[var9 + var10];
               if(var10 != 0) {
                  System.arraycopy(this.field_670, 0, var11, 0, var10);
               }
               break;
            case 26:
               int var3 = var1.method_4567(var1.method_4578());
               int var4 = var1.getPosition();

               int var5;
               for(var5 = 0; var1.method_4582() > 0; ++var5) {
                  var1.method_4574();
               }

               var1.method_4569(var4);
               int var6;
               if(this.field_670 == null) {
                  var6 = 0;
               } else {
                  var6 = this.field_670.length;
               }

               int[] var7 = new int[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.field_670, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.method_4574();
                  ++var6;
               }

               this.field_670 = var7;
               var1.method_4568(var3);
               continue;
            case 32:
               this.name = var1.method_4574();
               continue;
            case 48:
               this.field_672 = var1.method_4575();
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var10 < -1 + var11.length) {
               var11[var10] = var1.method_4574();
               var1.method_4585();
               ++var10;
            }

            var11[var10] = var1.method_4574();
            this.field_670 = var11;
         }
      }

      // $FF: renamed from: e () com.google.android.gms.internal.c$b
      public class_55.class_1273 method_2140() {
         this.field_670 = class_822.azj;
         this.field_671 = 0;
         this.name = 0;
         this.field_672 = false;
         this.field_673 = false;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_55.class_1273;
            var3 = false;
            if(var2) {
               class_55.class_1273 var4 = (class_55.class_1273)var1;
               boolean var5 = class_834.equals(this.field_670, var4.field_670);
               var3 = false;
               if(var5) {
                  int var6 = this.field_671;
                  int var7 = var4.field_671;
                  var3 = false;
                  if(var6 == var7) {
                     int var8 = this.name;
                     int var9 = var4.name;
                     var3 = false;
                     if(var8 == var9) {
                        boolean var10 = this.field_672;
                        boolean var11 = var4.field_672;
                        var3 = false;
                        if(var10 == var11) {
                           boolean var12 = this.field_673;
                           boolean var13 = var4.field_673;
                           var3 = false;
                           if(var12 == var13) {
                              return this.a(var4);
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
         int var2 = 31 * (31 * (31 * (527 + class_834.hashCode(this.field_670)) + this.field_671) + this.name);
         short var3;
         if(this.field_672) {
            var3 = var1;
         } else {
            var3 = 1237;
         }

         int var4 = 31 * (var3 + var2);
         if(!this.field_673) {
            var1 = 1237;
         }

         return 31 * (var4 + var1) + this.rQ();
      }
   }

   public static final class class_1272 extends qq<class_55.class_1272> {
      // $FF: renamed from: fu com.google.android.gms.internal.c$c[]
      private static volatile class_55.class_1272[] field_674;
      // $FF: renamed from: fv java.lang.String
      public String field_675;
      // $FF: renamed from: fw long
      public long field_676;
      // $FF: renamed from: fx long
      public long field_677;
      // $FF: renamed from: fy boolean
      public boolean field_678;
      // $FF: renamed from: fz long
      public long field_679;

      public class_1272() {
         this.method_2143();
      }

      // $FF: renamed from: f () com.google.android.gms.internal.c$c[]
      public static class_55.class_1272[] method_2141() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(!this.field_675.equals("")) {
            var1.method_4537(1, this.field_675);
         }

         if(this.field_676 != 0L) {
            var1.method_4536(2, this.field_676);
         }

         if(this.field_677 != 2147483647L) {
            var1.method_4536(3, this.field_677);
         }

         if(this.field_678) {
            var1.method_4538(4, this.field_678);
         }

         if(this.field_679 != 0L) {
            var1.method_4536(5, this.field_679);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2142(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091();
         if(!this.field_675.equals("")) {
            var1 += class_826.method_4521(1, this.field_675);
         }

         if(this.field_676 != 0L) {
            var1 += class_826.method_4509(2, this.field_676);
         }

         if(this.field_677 != 2147483647L) {
            var1 += class_826.method_4509(3, this.field_677);
         }

         if(this.field_678) {
            var1 += class_826.method_4508(4, this.field_678);
         }

         if(this.field_679 != 0L) {
            var1 += class_826.method_4509(5, this.field_679);
         }

         return var1;
      }

      // $FF: renamed from: d (com.google.android.gms.internal.qo) com.google.android.gms.internal.c$c
      public class_55.class_1272 method_2142(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            switch(var2) {
            case 10:
               this.field_675 = var1.readString();
               break;
            case 16:
               this.field_676 = var1.method_4573();
               break;
            case 24:
               this.field_677 = var1.method_4573();
               break;
            case 32:
               this.field_678 = var1.method_4575();
               break;
            case 40:
               this.field_679 = var1.method_4573();
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

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_55.class_1272;
            var3 = false;
            if(var2) {
               class_55.class_1272 var4 = (class_55.class_1272)var1;
               if(this.field_675 == null) {
                  String var10 = var4.field_675;
                  var3 = false;
                  if(var10 != null) {
                     return var3;
                  }
               } else if(!this.field_675.equals(var4.field_675)) {
                  return false;
               }

               long var11;
               int var5 = (var11 = this.field_676 - var4.field_676) == 0L?0:(var11 < 0L?-1:1);
               var3 = false;
               if(var5 == 0) {
                  long var12;
                  int var6 = (var12 = this.field_677 - var4.field_677) == 0L?0:(var12 < 0L?-1:1);
                  var3 = false;
                  if(var6 == 0) {
                     boolean var7 = this.field_678;
                     boolean var8 = var4.field_678;
                     var3 = false;
                     if(var7 == var8) {
                        long var13;
                        int var9 = (var13 = this.field_679 - var4.field_679) == 0L?0:(var13 < 0L?-1:1);
                        var3 = false;
                        if(var9 == 0) {
                           return this.a(var4);
                        }
                     }
                  }
               }
            }
         }

         return var3;
      }

      // $FF: renamed from: g () com.google.android.gms.internal.c$c
      public class_55.class_1272 method_2143() {
         this.field_675 = "";
         this.field_676 = 0L;
         this.field_677 = 2147483647L;
         this.field_678 = false;
         this.field_679 = 0L;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public int hashCode() {
         int var1;
         if(this.field_675 == null) {
            var1 = 0;
         } else {
            var1 = this.field_675.hashCode();
         }

         int var2 = 31 * (31 * (31 * (var1 + 527) + (int)(this.field_676 ^ this.field_676 >>> 32)) + (int)(this.field_677 ^ this.field_677 >>> 32));
         short var3;
         if(this.field_678) {
            var3 = 1231;
         } else {
            var3 = 1237;
         }

         return 31 * (31 * (var3 + var2) + (int)(this.field_679 ^ this.field_679 >>> 32)) + this.rQ();
      }
   }

   public static final class class_1271 extends qq<class_55.class_1271> {
      // $FF: renamed from: fA com.google.android.gms.internal.d$a[]
      public class_57.class_1084[] field_680;
      // $FF: renamed from: fB com.google.android.gms.internal.d$a[]
      public class_57.class_1084[] field_681;
      // $FF: renamed from: fC com.google.android.gms.internal.c$c[]
      public class_55.class_1272[] field_682;

      public class_1271() {
         this.method_2145();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(this.field_680 != null && this.field_680.length > 0) {
            for(int var7 = 0; var7 < this.field_680.length; ++var7) {
               class_57.class_1084 var8 = this.field_680[var7];
               if(var8 != null) {
                  var1.method_4532(1, var8);
               }
            }
         }

         if(this.field_681 != null && this.field_681.length > 0) {
            for(int var5 = 0; var5 < this.field_681.length; ++var5) {
               class_57.class_1084 var6 = this.field_681[var5];
               if(var6 != null) {
                  var1.method_4532(2, var6);
               }
            }
         }

         if(this.field_682 != null) {
            int var2 = this.field_682.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.field_682.length; ++var3) {
                  class_55.class_1272 var4 = this.field_682[var3];
                  if(var4 != null) {
                     var1.method_4532(3, var4);
                  }
               }
            }
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2144(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091();
         if(this.field_680 != null && this.field_680.length > 0) {
            int var8 = var1;

            for(int var9 = 0; var9 < this.field_680.length; ++var9) {
               class_57.class_1084 var10 = this.field_680[var9];
               if(var10 != null) {
                  var8 += class_826.method_4507(1, var10);
               }
            }

            var1 = var8;
         }

         if(this.field_681 != null && this.field_681.length > 0) {
            int var5 = var1;

            for(int var6 = 0; var6 < this.field_681.length; ++var6) {
               class_57.class_1084 var7 = this.field_681[var6];
               if(var7 != null) {
                  var5 += class_826.method_4507(2, var7);
               }
            }

            var1 = var5;
         }

         if(this.field_682 != null) {
            int var2 = this.field_682.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.field_682.length; ++var3) {
                  class_55.class_1272 var4 = this.field_682[var3];
                  if(var4 != null) {
                     var1 += class_826.method_4507(3, var4);
                  }
               }
            }
         }

         return var1;
      }

      // $FF: renamed from: e (com.google.android.gms.internal.qo) com.google.android.gms.internal.c$d
      public class_55.class_1271 method_2144(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            int var12;
            class_57.class_1084[] var13;
            switch(var2) {
            case 10:
               int var11 = class_822.method_4484(var1, 10);
               if(this.field_680 == null) {
                  var12 = 0;
               } else {
                  var12 = this.field_680.length;
               }

               var13 = new class_57.class_1084[var11 + var12];
               if(var12 != 0) {
                  System.arraycopy(this.field_680, 0, var13, 0, var12);
               }
               break;
            case 18:
               int var7 = class_822.method_4484(var1, 18);
               int var8;
               if(this.field_681 == null) {
                  var8 = 0;
               } else {
                  var8 = this.field_681.length;
               }

               class_57.class_1084[] var9 = new class_57.class_1084[var7 + var8];
               if(var8 != 0) {
                  System.arraycopy(this.field_681, 0, var9, 0, var8);
               }

               while(var8 < -1 + var9.length) {
                  var9[var8] = new class_57.class_1084();
                  var1.method_4563(var9[var8]);
                  var1.method_4585();
                  ++var8;
               }

               var9[var8] = new class_57.class_1084();
               var1.method_4563(var9[var8]);
               this.field_681 = var9;
               continue;
            case 26:
               int var3 = class_822.method_4484(var1, 26);
               int var4;
               if(this.field_682 == null) {
                  var4 = 0;
               } else {
                  var4 = this.field_682.length;
               }

               class_55.class_1272[] var5 = new class_55.class_1272[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.field_682, 0, var5, 0, var4);
               }

               while(var4 < -1 + var5.length) {
                  var5[var4] = new class_55.class_1272();
                  var1.method_4563(var5[var4]);
                  var1.method_4585();
                  ++var4;
               }

               var5[var4] = new class_55.class_1272();
               var1.method_4563(var5[var4]);
               this.field_682 = var5;
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var12 < -1 + var13.length) {
               var13[var12] = new class_57.class_1084();
               var1.method_4563(var13[var12]);
               var1.method_4585();
               ++var12;
            }

            var13[var12] = new class_57.class_1084();
            var1.method_4563(var13[var12]);
            this.field_680 = var13;
         }
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_55.class_1271;
            var3 = false;
            if(var2) {
               class_55.class_1271 var4 = (class_55.class_1271)var1;
               boolean var5 = class_834.equals((Object[])this.field_680, (Object[])var4.field_680);
               var3 = false;
               if(var5) {
                  boolean var6 = class_834.equals((Object[])this.field_681, (Object[])var4.field_681);
                  var3 = false;
                  if(var6) {
                     boolean var7 = class_834.equals((Object[])this.field_682, (Object[])var4.field_682);
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

      // $FF: renamed from: h () com.google.android.gms.internal.c$d
      public class_55.class_1271 method_2145() {
         this.field_680 = class_57.class_1084.method_2163();
         this.field_681 = class_57.class_1084.method_2163();
         this.field_682 = class_55.class_1272.method_2141();
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      public int hashCode() {
         return 31 * (31 * (31 * (527 + class_834.hashCode((Object[])this.field_680)) + class_834.hashCode((Object[])this.field_681)) + class_834.hashCode((Object[])this.field_682)) + this.rQ();
      }
   }

   public static final class class_1270 extends qq<class_55.class_1270> {
      // $FF: renamed from: fD com.google.android.gms.internal.c$e[]
      private static volatile class_55.class_1270[] field_683;
      public int key;
      public int value;

      public class_1270() {
         this.method_2148();
      }

      // $FF: renamed from: i () com.google.android.gms.internal.c$e[]
      public static class_55.class_1270[] method_2146() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         var1.method_4554(1, this.key);
         var1.method_4554(2, this.value);
         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2147(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         return super.method_2091() + class_826.method_4524(1, this.key) + class_826.method_4524(2, this.value);
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_55.class_1270;
            var3 = false;
            if(var2) {
               class_55.class_1270 var4 = (class_55.class_1270)var1;
               int var5 = this.key;
               int var6 = var4.key;
               var3 = false;
               if(var5 == var6) {
                  int var7 = this.value;
                  int var8 = var4.value;
                  var3 = false;
                  if(var7 == var8) {
                     return this.a(var4);
                  }
               }
            }
         }

         return var3;
      }

      // $FF: renamed from: f (com.google.android.gms.internal.qo) com.google.android.gms.internal.c$e
      public class_55.class_1270 method_2147(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            switch(var2) {
            case 8:
               this.key = var1.method_4574();
               break;
            case 16:
               this.value = var1.method_4574();
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

      public int hashCode() {
         return 31 * (31 * (527 + this.key) + this.value) + this.rQ();
      }

      // $FF: renamed from: j () com.google.android.gms.internal.c$e
      public class_55.class_1270 method_2148() {
         this.key = 0;
         this.value = 0;
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }

   public static final class class_1269 extends qq<class_55.class_1269> {
      // $FF: renamed from: fE java.lang.String[]
      public String[] field_684;
      // $FF: renamed from: fF java.lang.String[]
      public String[] field_685;
      // $FF: renamed from: fG com.google.android.gms.internal.d$a[]
      public class_57.class_1084[] field_686;
      // $FF: renamed from: fH com.google.android.gms.internal.c$e[]
      public class_55.class_1270[] field_687;
      // $FF: renamed from: fI com.google.android.gms.internal.c$b[]
      public class_55.class_1273[] field_688;
      // $FF: renamed from: fJ com.google.android.gms.internal.c$b[]
      public class_55.class_1273[] field_689;
      // $FF: renamed from: fK com.google.android.gms.internal.c$b[]
      public class_55.class_1273[] field_690;
      // $FF: renamed from: fL com.google.android.gms.internal.c$g[]
      public class_55.class_1268[] field_691;
      // $FF: renamed from: fM java.lang.String
      public String field_692;
      // $FF: renamed from: fN java.lang.String
      public String field_693;
      // $FF: renamed from: fO java.lang.String
      public String field_694;
      // $FF: renamed from: fP com.google.android.gms.internal.c$a
      public class_55.class_1276 field_695;
      // $FF: renamed from: fQ float
      public float field_696;
      // $FF: renamed from: fR boolean
      public boolean field_697;
      // $FF: renamed from: fS java.lang.String[]
      public String[] field_698;
      // $FF: renamed from: fT int
      public int field_699;
      public String version;

      public class_1269() {
         this.method_2151();
      }

      // $FF: renamed from: a (byte[]) com.google.android.gms.internal.c$f
      public static class_55.class_1269 method_2149(byte[] var0) throws class_833 {
         return (class_55.class_1269)class_300.method_2085(new class_55.class_1269(), var0);
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(this.field_685 != null && this.field_685.length > 0) {
            for(int var19 = 0; var19 < this.field_685.length; ++var19) {
               String var20 = this.field_685[var19];
               if(var20 != null) {
                  var1.method_4537(1, var20);
               }
            }
         }

         if(this.field_686 != null && this.field_686.length > 0) {
            for(int var17 = 0; var17 < this.field_686.length; ++var17) {
               class_57.class_1084 var18 = this.field_686[var17];
               if(var18 != null) {
                  var1.method_4532(2, var18);
               }
            }
         }

         if(this.field_687 != null && this.field_687.length > 0) {
            for(int var15 = 0; var15 < this.field_687.length; ++var15) {
               class_55.class_1270 var16 = this.field_687[var15];
               if(var16 != null) {
                  var1.method_4532(3, var16);
               }
            }
         }

         if(this.field_688 != null && this.field_688.length > 0) {
            for(int var13 = 0; var13 < this.field_688.length; ++var13) {
               class_55.class_1273 var14 = this.field_688[var13];
               if(var14 != null) {
                  var1.method_4532(4, var14);
               }
            }
         }

         if(this.field_689 != null && this.field_689.length > 0) {
            for(int var11 = 0; var11 < this.field_689.length; ++var11) {
               class_55.class_1273 var12 = this.field_689[var11];
               if(var12 != null) {
                  var1.method_4532(5, var12);
               }
            }
         }

         if(this.field_690 != null && this.field_690.length > 0) {
            for(int var9 = 0; var9 < this.field_690.length; ++var9) {
               class_55.class_1273 var10 = this.field_690[var9];
               if(var10 != null) {
                  var1.method_4532(6, var10);
               }
            }
         }

         if(this.field_691 != null && this.field_691.length > 0) {
            for(int var7 = 0; var7 < this.field_691.length; ++var7) {
               class_55.class_1268 var8 = this.field_691[var7];
               if(var8 != null) {
                  var1.method_4532(7, var8);
               }
            }
         }

         if(!this.field_692.equals("")) {
            var1.method_4537(9, this.field_692);
         }

         if(!this.field_693.equals("")) {
            var1.method_4537(10, this.field_693);
         }

         if(!this.field_694.equals("0")) {
            var1.method_4537(12, this.field_694);
         }

         if(!this.version.equals("")) {
            var1.method_4537(13, this.version);
         }

         if(this.field_695 != null) {
            var1.method_4532(14, this.field_695);
         }

         if(Float.floatToIntBits(this.field_696) != Float.floatToIntBits(0.0F)) {
            var1.method_4535(15, this.field_696);
         }

         if(this.field_698 != null && this.field_698.length > 0) {
            for(int var5 = 0; var5 < this.field_698.length; ++var5) {
               String var6 = this.field_698[var5];
               if(var6 != null) {
                  var1.method_4537(16, var6);
               }
            }
         }

         if(this.field_699 != 0) {
            var1.method_4554(17, this.field_699);
         }

         if(this.field_697) {
            var1.method_4538(18, this.field_697);
         }

         if(this.field_684 != null) {
            int var2 = this.field_684.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.field_684.length; ++var3) {
                  String var4 = this.field_684[var3];
                  if(var4 != null) {
                     var1.method_4537(19, var4);
                  }
               }
            }
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2150(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = 0;
         int var2 = super.method_2091();
         int var3;
         if(this.field_685 != null && this.field_685.length > 0) {
            int var29 = 0;
            int var30 = 0;

            int var31;
            for(var31 = 0; var29 < this.field_685.length; ++var29) {
               String var32 = this.field_685[var29];
               if(var32 != null) {
                  ++var31;
                  var30 += class_826.method_4511(var32);
               }
            }

            var3 = var2 + var30 + var31 * 1;
         } else {
            var3 = var2;
         }

         if(this.field_686 != null && this.field_686.length > 0) {
            int var26 = var3;

            for(int var27 = 0; var27 < this.field_686.length; ++var27) {
               class_57.class_1084 var28 = this.field_686[var27];
               if(var28 != null) {
                  var26 += class_826.method_4507(2, var28);
               }
            }

            var3 = var26;
         }

         if(this.field_687 != null && this.field_687.length > 0) {
            int var23 = var3;

            for(int var24 = 0; var24 < this.field_687.length; ++var24) {
               class_55.class_1270 var25 = this.field_687[var24];
               if(var25 != null) {
                  var23 += class_826.method_4507(3, var25);
               }
            }

            var3 = var23;
         }

         if(this.field_688 != null && this.field_688.length > 0) {
            int var20 = var3;

            for(int var21 = 0; var21 < this.field_688.length; ++var21) {
               class_55.class_1273 var22 = this.field_688[var21];
               if(var22 != null) {
                  var20 += class_826.method_4507(4, var22);
               }
            }

            var3 = var20;
         }

         if(this.field_689 != null && this.field_689.length > 0) {
            int var17 = var3;

            for(int var18 = 0; var18 < this.field_689.length; ++var18) {
               class_55.class_1273 var19 = this.field_689[var18];
               if(var19 != null) {
                  var17 += class_826.method_4507(5, var19);
               }
            }

            var3 = var17;
         }

         if(this.field_690 != null && this.field_690.length > 0) {
            int var14 = var3;

            for(int var15 = 0; var15 < this.field_690.length; ++var15) {
               class_55.class_1273 var16 = this.field_690[var15];
               if(var16 != null) {
                  var14 += class_826.method_4507(6, var16);
               }
            }

            var3 = var14;
         }

         if(this.field_691 != null && this.field_691.length > 0) {
            int var11 = var3;

            for(int var12 = 0; var12 < this.field_691.length; ++var12) {
               class_55.class_1268 var13 = this.field_691[var12];
               if(var13 != null) {
                  var11 += class_826.method_4507(7, var13);
               }
            }

            var3 = var11;
         }

         if(!this.field_692.equals("")) {
            var3 += class_826.method_4521(9, this.field_692);
         }

         if(!this.field_693.equals("")) {
            var3 += class_826.method_4521(10, this.field_693);
         }

         if(!this.field_694.equals("0")) {
            var3 += class_826.method_4521(12, this.field_694);
         }

         if(!this.version.equals("")) {
            var3 += class_826.method_4521(13, this.version);
         }

         if(this.field_695 != null) {
            var3 += class_826.method_4507(14, this.field_695);
         }

         if(Float.floatToIntBits(this.field_696) != Float.floatToIntBits(0.0F)) {
            var3 += class_826.method_4506(15, this.field_696);
         }

         if(this.field_698 != null && this.field_698.length > 0) {
            int var7 = 0;
            int var8 = 0;

            int var9;
            for(var9 = 0; var7 < this.field_698.length; ++var7) {
               String var10 = this.field_698[var7];
               if(var10 != null) {
                  ++var9;
                  var8 += class_826.method_4511(var10);
               }
            }

            var3 = var3 + var8 + var9 * 2;
         }

         if(this.field_699 != 0) {
            var3 += class_826.method_4524(17, this.field_699);
         }

         if(this.field_697) {
            var3 += class_826.method_4508(18, this.field_697);
         }

         if(this.field_684 != null && this.field_684.length > 0) {
            int var4 = 0;

            int var5;
            for(var5 = 0; var1 < this.field_684.length; ++var1) {
               String var6 = this.field_684[var1];
               if(var6 != null) {
                  ++var5;
                  var4 += class_826.method_4511(var6);
               }
            }

            var3 = var3 + var4 + var5 * 2;
         }

         return var3;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_55.class_1269;
            var3 = false;
            if(var2) {
               class_55.class_1269 var4 = (class_55.class_1269)var1;
               boolean var5 = class_834.equals((Object[])this.field_684, (Object[])var4.field_684);
               var3 = false;
               if(var5) {
                  boolean var6 = class_834.equals((Object[])this.field_685, (Object[])var4.field_685);
                  var3 = false;
                  if(var6) {
                     boolean var7 = class_834.equals((Object[])this.field_686, (Object[])var4.field_686);
                     var3 = false;
                     if(var7) {
                        boolean var8 = class_834.equals((Object[])this.field_687, (Object[])var4.field_687);
                        var3 = false;
                        if(var8) {
                           boolean var9 = class_834.equals((Object[])this.field_688, (Object[])var4.field_688);
                           var3 = false;
                           if(var9) {
                              boolean var10 = class_834.equals((Object[])this.field_689, (Object[])var4.field_689);
                              var3 = false;
                              if(var10) {
                                 boolean var11 = class_834.equals((Object[])this.field_690, (Object[])var4.field_690);
                                 var3 = false;
                                 if(var11) {
                                    boolean var12 = class_834.equals((Object[])this.field_691, (Object[])var4.field_691);
                                    var3 = false;
                                    if(var12) {
                                       if(this.field_692 == null) {
                                          String var24 = var4.field_692;
                                          var3 = false;
                                          if(var24 != null) {
                                             return var3;
                                          }
                                       } else if(!this.field_692.equals(var4.field_692)) {
                                          return false;
                                       }

                                       if(this.field_693 == null) {
                                          String var23 = var4.field_693;
                                          var3 = false;
                                          if(var23 != null) {
                                             return var3;
                                          }
                                       } else if(!this.field_693.equals(var4.field_693)) {
                                          return false;
                                       }

                                       if(this.field_694 == null) {
                                          String var22 = var4.field_694;
                                          var3 = false;
                                          if(var22 != null) {
                                             return var3;
                                          }
                                       } else if(!this.field_694.equals(var4.field_694)) {
                                          return false;
                                       }

                                       if(this.version == null) {
                                          String var21 = var4.version;
                                          var3 = false;
                                          if(var21 != null) {
                                             return var3;
                                          }
                                       } else if(!this.version.equals(var4.version)) {
                                          return false;
                                       }

                                       if(this.field_695 == null) {
                                          class_55.class_1276 var20 = var4.field_695;
                                          var3 = false;
                                          if(var20 != null) {
                                             return var3;
                                          }
                                       } else if(!this.field_695.equals(var4.field_695)) {
                                          return false;
                                       }

                                       int var13 = Float.floatToIntBits(this.field_696);
                                       int var14 = Float.floatToIntBits(var4.field_696);
                                       var3 = false;
                                       if(var13 == var14) {
                                          boolean var15 = this.field_697;
                                          boolean var16 = var4.field_697;
                                          var3 = false;
                                          if(var15 == var16) {
                                             boolean var17 = class_834.equals((Object[])this.field_698, (Object[])var4.field_698);
                                             var3 = false;
                                             if(var17) {
                                                int var18 = this.field_699;
                                                int var19 = var4.field_699;
                                                var3 = false;
                                                if(var18 == var19) {
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

         return var3;
      }

      // $FF: renamed from: g (com.google.android.gms.internal.qo) com.google.android.gms.internal.c$f
      public class_55.class_1269 method_2150(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            int var36;
            String[] var37;
            switch(var2) {
            case 10:
               int var35 = class_822.method_4484(var1, 10);
               if(this.field_685 == null) {
                  var36 = 0;
               } else {
                  var36 = this.field_685.length;
               }

               var37 = new String[var35 + var36];
               if(var36 != 0) {
                  System.arraycopy(this.field_685, 0, var37, 0, var36);
               }
               break;
            case 18:
               int var31 = class_822.method_4484(var1, 18);
               int var32;
               if(this.field_686 == null) {
                  var32 = 0;
               } else {
                  var32 = this.field_686.length;
               }

               class_57.class_1084[] var33 = new class_57.class_1084[var31 + var32];
               if(var32 != 0) {
                  System.arraycopy(this.field_686, 0, var33, 0, var32);
               }

               while(var32 < -1 + var33.length) {
                  var33[var32] = new class_57.class_1084();
                  var1.method_4563(var33[var32]);
                  var1.method_4585();
                  ++var32;
               }

               var33[var32] = new class_57.class_1084();
               var1.method_4563(var33[var32]);
               this.field_686 = var33;
               continue;
            case 26:
               int var27 = class_822.method_4484(var1, 26);
               int var28;
               if(this.field_687 == null) {
                  var28 = 0;
               } else {
                  var28 = this.field_687.length;
               }

               class_55.class_1270[] var29 = new class_55.class_1270[var27 + var28];
               if(var28 != 0) {
                  System.arraycopy(this.field_687, 0, var29, 0, var28);
               }

               while(var28 < -1 + var29.length) {
                  var29[var28] = new class_55.class_1270();
                  var1.method_4563(var29[var28]);
                  var1.method_4585();
                  ++var28;
               }

               var29[var28] = new class_55.class_1270();
               var1.method_4563(var29[var28]);
               this.field_687 = var29;
               continue;
            case 34:
               int var23 = class_822.method_4484(var1, 34);
               int var24;
               if(this.field_688 == null) {
                  var24 = 0;
               } else {
                  var24 = this.field_688.length;
               }

               class_55.class_1273[] var25 = new class_55.class_1273[var23 + var24];
               if(var24 != 0) {
                  System.arraycopy(this.field_688, 0, var25, 0, var24);
               }

               while(var24 < -1 + var25.length) {
                  var25[var24] = new class_55.class_1273();
                  var1.method_4563(var25[var24]);
                  var1.method_4585();
                  ++var24;
               }

               var25[var24] = new class_55.class_1273();
               var1.method_4563(var25[var24]);
               this.field_688 = var25;
               continue;
            case 42:
               int var19 = class_822.method_4484(var1, 42);
               int var20;
               if(this.field_689 == null) {
                  var20 = 0;
               } else {
                  var20 = this.field_689.length;
               }

               class_55.class_1273[] var21 = new class_55.class_1273[var19 + var20];
               if(var20 != 0) {
                  System.arraycopy(this.field_689, 0, var21, 0, var20);
               }

               while(var20 < -1 + var21.length) {
                  var21[var20] = new class_55.class_1273();
                  var1.method_4563(var21[var20]);
                  var1.method_4585();
                  ++var20;
               }

               var21[var20] = new class_55.class_1273();
               var1.method_4563(var21[var20]);
               this.field_689 = var21;
               continue;
            case 50:
               int var15 = class_822.method_4484(var1, 50);
               int var16;
               if(this.field_690 == null) {
                  var16 = 0;
               } else {
                  var16 = this.field_690.length;
               }

               class_55.class_1273[] var17 = new class_55.class_1273[var15 + var16];
               if(var16 != 0) {
                  System.arraycopy(this.field_690, 0, var17, 0, var16);
               }

               while(var16 < -1 + var17.length) {
                  var17[var16] = new class_55.class_1273();
                  var1.method_4563(var17[var16]);
                  var1.method_4585();
                  ++var16;
               }

               var17[var16] = new class_55.class_1273();
               var1.method_4563(var17[var16]);
               this.field_690 = var17;
               continue;
            case 58:
               int var11 = class_822.method_4484(var1, 58);
               int var12;
               if(this.field_691 == null) {
                  var12 = 0;
               } else {
                  var12 = this.field_691.length;
               }

               class_55.class_1268[] var13 = new class_55.class_1268[var11 + var12];
               if(var12 != 0) {
                  System.arraycopy(this.field_691, 0, var13, 0, var12);
               }

               while(var12 < -1 + var13.length) {
                  var13[var12] = new class_55.class_1268();
                  var1.method_4563(var13[var12]);
                  var1.method_4585();
                  ++var12;
               }

               var13[var12] = new class_55.class_1268();
               var1.method_4563(var13[var12]);
               this.field_691 = var13;
               continue;
            case 74:
               this.field_692 = var1.readString();
               continue;
            case 82:
               this.field_693 = var1.readString();
               continue;
            case 98:
               this.field_694 = var1.readString();
               continue;
            case 106:
               this.version = var1.readString();
               continue;
            case 114:
               if(this.field_695 == null) {
                  this.field_695 = new class_55.class_1276();
               }

               var1.method_4563(this.field_695);
               continue;
            case 125:
               this.field_696 = var1.readFloat();
               continue;
            case 130:
               int var7 = class_822.method_4484(var1, 130);
               int var8;
               if(this.field_698 == null) {
                  var8 = 0;
               } else {
                  var8 = this.field_698.length;
               }

               String[] var9 = new String[var7 + var8];
               if(var8 != 0) {
                  System.arraycopy(this.field_698, 0, var9, 0, var8);
               }

               while(var8 < -1 + var9.length) {
                  var9[var8] = var1.readString();
                  var1.method_4585();
                  ++var8;
               }

               var9[var8] = var1.readString();
               this.field_698 = var9;
               continue;
            case 136:
               this.field_699 = var1.method_4574();
               continue;
            case 144:
               this.field_697 = var1.method_4575();
               continue;
            case 154:
               int var3 = class_822.method_4484(var1, 154);
               int var4;
               if(this.field_684 == null) {
                  var4 = 0;
               } else {
                  var4 = this.field_684.length;
               }

               String[] var5 = new String[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.field_684, 0, var5, 0, var4);
               }

               while(var4 < -1 + var5.length) {
                  var5[var4] = var1.readString();
                  var1.method_4585();
                  ++var4;
               }

               var5[var4] = var1.readString();
               this.field_684 = var5;
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var36 < -1 + var37.length) {
               var37[var36] = var1.readString();
               var1.method_4585();
               ++var36;
            }

            var37[var36] = var1.readString();
            this.field_685 = var37;
         }
      }

      public int hashCode() {
         int var1 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + class_834.hashCode((Object[])this.field_684)) + class_834.hashCode((Object[])this.field_685)) + class_834.hashCode((Object[])this.field_686)) + class_834.hashCode((Object[])this.field_687)) + class_834.hashCode((Object[])this.field_688)) + class_834.hashCode((Object[])this.field_689)) + class_834.hashCode((Object[])this.field_690)) + class_834.hashCode((Object[])this.field_691));
         int var2;
         if(this.field_692 == null) {
            var2 = 0;
         } else {
            var2 = this.field_692.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.field_693 == null) {
            var4 = 0;
         } else {
            var4 = this.field_693.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         int var6;
         if(this.field_694 == null) {
            var6 = 0;
         } else {
            var6 = this.field_694.hashCode();
         }

         int var7 = 31 * (var6 + var5);
         int var8;
         if(this.version == null) {
            var8 = 0;
         } else {
            var8 = this.version.hashCode();
         }

         int var9 = 31 * (var8 + var7);
         class_55.class_1276 var10 = this.field_695;
         int var11 = 0;
         if(var10 != null) {
            var11 = this.field_695.hashCode();
         }

         int var12 = 31 * (31 * (var9 + var11) + Float.floatToIntBits(this.field_696));
         short var13;
         if(this.field_697) {
            var13 = 1231;
         } else {
            var13 = 1237;
         }

         return 31 * (31 * (31 * (var13 + var12) + class_834.hashCode((Object[])this.field_698)) + this.field_699) + this.rQ();
      }

      // $FF: renamed from: k () com.google.android.gms.internal.c$f
      public class_55.class_1269 method_2151() {
         this.field_684 = class_822.azo;
         this.field_685 = class_822.azo;
         this.field_686 = class_57.class_1084.method_2163();
         this.field_687 = class_55.class_1270.method_2146();
         this.field_688 = class_55.class_1273.method_2138();
         this.field_689 = class_55.class_1273.method_2138();
         this.field_690 = class_55.class_1273.method_2138();
         this.field_691 = class_55.class_1268.method_2152();
         this.field_692 = "";
         this.field_693 = "";
         this.field_694 = "0";
         this.version = "";
         this.field_695 = null;
         this.field_696 = 0.0F;
         this.field_697 = false;
         this.field_698 = class_822.azo;
         this.field_699 = 0;
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }

   public static final class class_1268 extends qq<class_55.class_1268> {
      // $FF: renamed from: fU com.google.android.gms.internal.c$g[]
      private static volatile class_55.class_1268[] field_700;
      // $FF: renamed from: fV int[]
      public int[] field_701;
      // $FF: renamed from: fW int[]
      public int[] field_702;
      // $FF: renamed from: fX int[]
      public int[] field_703;
      // $FF: renamed from: fY int[]
      public int[] field_704;
      // $FF: renamed from: fZ int[]
      public int[] field_705;
      // $FF: renamed from: ga int[]
      public int[] field_706;
      // $FF: renamed from: gb int[]
      public int[] field_707;
      // $FF: renamed from: gc int[]
      public int[] field_708;
      // $FF: renamed from: gd int[]
      public int[] field_709;
      // $FF: renamed from: ge int[]
      public int[] field_710;

      public class_1268() {
         this.method_2154();
      }

      // $FF: renamed from: l () com.google.android.gms.internal.c$g[]
      public static class_55.class_1268[] method_2152() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(this.field_701 != null && this.field_701.length > 0) {
            for(int var12 = 0; var12 < this.field_701.length; ++var12) {
               var1.method_4554(1, this.field_701[var12]);
            }
         }

         if(this.field_702 != null && this.field_702.length > 0) {
            for(int var11 = 0; var11 < this.field_702.length; ++var11) {
               var1.method_4554(2, this.field_702[var11]);
            }
         }

         if(this.field_703 != null && this.field_703.length > 0) {
            for(int var10 = 0; var10 < this.field_703.length; ++var10) {
               var1.method_4554(3, this.field_703[var10]);
            }
         }

         if(this.field_704 != null && this.field_704.length > 0) {
            for(int var9 = 0; var9 < this.field_704.length; ++var9) {
               var1.method_4554(4, this.field_704[var9]);
            }
         }

         if(this.field_705 != null && this.field_705.length > 0) {
            for(int var8 = 0; var8 < this.field_705.length; ++var8) {
               var1.method_4554(5, this.field_705[var8]);
            }
         }

         if(this.field_706 != null && this.field_706.length > 0) {
            for(int var7 = 0; var7 < this.field_706.length; ++var7) {
               var1.method_4554(6, this.field_706[var7]);
            }
         }

         if(this.field_707 != null && this.field_707.length > 0) {
            for(int var6 = 0; var6 < this.field_707.length; ++var6) {
               var1.method_4554(7, this.field_707[var6]);
            }
         }

         if(this.field_708 != null && this.field_708.length > 0) {
            for(int var5 = 0; var5 < this.field_708.length; ++var5) {
               var1.method_4554(8, this.field_708[var5]);
            }
         }

         if(this.field_709 != null && this.field_709.length > 0) {
            for(int var4 = 0; var4 < this.field_709.length; ++var4) {
               var1.method_4554(9, this.field_709[var4]);
            }
         }

         if(this.field_710 != null) {
            int var2 = this.field_710.length;
            int var3 = 0;
            if(var2 > 0) {
               while(var3 < this.field_710.length) {
                  var1.method_4554(10, this.field_710[var3]);
                  ++var3;
               }
            }
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2153(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = 0;
         int var2 = super.method_2091();
         int var3;
         if(this.field_701 != null && this.field_701.length > 0) {
            int var21 = 0;

            int var22;
            for(var22 = 0; var21 < this.field_701.length; ++var21) {
               var22 += class_826.method_4516(this.field_701[var21]);
            }

            var3 = var2 + var22 + 1 * this.field_701.length;
         } else {
            var3 = var2;
         }

         if(this.field_702 != null && this.field_702.length > 0) {
            int var19 = 0;

            int var20;
            for(var20 = 0; var19 < this.field_702.length; ++var19) {
               var20 += class_826.method_4516(this.field_702[var19]);
            }

            var3 = var3 + var20 + 1 * this.field_702.length;
         }

         if(this.field_703 != null && this.field_703.length > 0) {
            int var17 = 0;

            int var18;
            for(var18 = 0; var17 < this.field_703.length; ++var17) {
               var18 += class_826.method_4516(this.field_703[var17]);
            }

            var3 = var3 + var18 + 1 * this.field_703.length;
         }

         if(this.field_704 != null && this.field_704.length > 0) {
            int var15 = 0;

            int var16;
            for(var16 = 0; var15 < this.field_704.length; ++var15) {
               var16 += class_826.method_4516(this.field_704[var15]);
            }

            var3 = var3 + var16 + 1 * this.field_704.length;
         }

         if(this.field_705 != null && this.field_705.length > 0) {
            int var13 = 0;

            int var14;
            for(var14 = 0; var13 < this.field_705.length; ++var13) {
               var14 += class_826.method_4516(this.field_705[var13]);
            }

            var3 = var3 + var14 + 1 * this.field_705.length;
         }

         if(this.field_706 != null && this.field_706.length > 0) {
            int var11 = 0;

            int var12;
            for(var12 = 0; var11 < this.field_706.length; ++var11) {
               var12 += class_826.method_4516(this.field_706[var11]);
            }

            var3 = var3 + var12 + 1 * this.field_706.length;
         }

         if(this.field_707 != null && this.field_707.length > 0) {
            int var9 = 0;

            int var10;
            for(var10 = 0; var9 < this.field_707.length; ++var9) {
               var10 += class_826.method_4516(this.field_707[var9]);
            }

            var3 = var3 + var10 + 1 * this.field_707.length;
         }

         if(this.field_708 != null && this.field_708.length > 0) {
            int var7 = 0;

            int var8;
            for(var8 = 0; var7 < this.field_708.length; ++var7) {
               var8 += class_826.method_4516(this.field_708[var7]);
            }

            var3 = var3 + var8 + 1 * this.field_708.length;
         }

         if(this.field_709 != null && this.field_709.length > 0) {
            int var5 = 0;

            int var6;
            for(var6 = 0; var5 < this.field_709.length; ++var5) {
               var6 += class_826.method_4516(this.field_709[var5]);
            }

            var3 = var3 + var6 + 1 * this.field_709.length;
         }

         if(this.field_710 != null && this.field_710.length > 0) {
            int var4;
            for(var4 = 0; var1 < this.field_710.length; ++var1) {
               var4 += class_826.method_4516(this.field_710[var1]);
            }

            var3 = var3 + var4 + 1 * this.field_710.length;
         }

         return var3;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_55.class_1268;
            var3 = false;
            if(var2) {
               class_55.class_1268 var4 = (class_55.class_1268)var1;
               boolean var5 = class_834.equals(this.field_701, var4.field_701);
               var3 = false;
               if(var5) {
                  boolean var6 = class_834.equals(this.field_702, var4.field_702);
                  var3 = false;
                  if(var6) {
                     boolean var7 = class_834.equals(this.field_703, var4.field_703);
                     var3 = false;
                     if(var7) {
                        boolean var8 = class_834.equals(this.field_704, var4.field_704);
                        var3 = false;
                        if(var8) {
                           boolean var9 = class_834.equals(this.field_705, var4.field_705);
                           var3 = false;
                           if(var9) {
                              boolean var10 = class_834.equals(this.field_706, var4.field_706);
                              var3 = false;
                              if(var10) {
                                 boolean var11 = class_834.equals(this.field_707, var4.field_707);
                                 var3 = false;
                                 if(var11) {
                                    boolean var12 = class_834.equals(this.field_708, var4.field_708);
                                    var3 = false;
                                    if(var12) {
                                       boolean var13 = class_834.equals(this.field_709, var4.field_709);
                                       var3 = false;
                                       if(var13) {
                                          boolean var14 = class_834.equals(this.field_710, var4.field_710);
                                          var3 = false;
                                          if(var14) {
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

         return var3;
      }

      // $FF: renamed from: h (com.google.android.gms.internal.qo) com.google.android.gms.internal.c$g
      public class_55.class_1268 method_2153(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            int var100;
            int[] var101;
            switch(var2) {
            case 8:
               int var99 = class_822.method_4484(var1, 8);
               if(this.field_701 == null) {
                  var100 = 0;
               } else {
                  var100 = this.field_701.length;
               }

               var101 = new int[var99 + var100];
               if(var100 != 0) {
                  System.arraycopy(this.field_701, 0, var101, 0, var100);
               }
               break;
            case 10:
               int var93 = var1.method_4567(var1.method_4578());
               int var94 = var1.getPosition();

               int var95;
               for(var95 = 0; var1.method_4582() > 0; ++var95) {
                  var1.method_4574();
               }

               var1.method_4569(var94);
               int var96;
               if(this.field_701 == null) {
                  var96 = 0;
               } else {
                  var96 = this.field_701.length;
               }

               int[] var97 = new int[var95 + var96];
               if(var96 != 0) {
                  System.arraycopy(this.field_701, 0, var97, 0, var96);
               }

               while(var96 < var97.length) {
                  var97[var96] = var1.method_4574();
                  ++var96;
               }

               this.field_701 = var97;
               var1.method_4568(var93);
               continue;
            case 16:
               int var89 = class_822.method_4484(var1, 16);
               int var90;
               if(this.field_702 == null) {
                  var90 = 0;
               } else {
                  var90 = this.field_702.length;
               }

               int[] var91 = new int[var89 + var90];
               if(var90 != 0) {
                  System.arraycopy(this.field_702, 0, var91, 0, var90);
               }

               while(var90 < -1 + var91.length) {
                  var91[var90] = var1.method_4574();
                  var1.method_4585();
                  ++var90;
               }

               var91[var90] = var1.method_4574();
               this.field_702 = var91;
               continue;
            case 18:
               int var83 = var1.method_4567(var1.method_4578());
               int var84 = var1.getPosition();

               int var85;
               for(var85 = 0; var1.method_4582() > 0; ++var85) {
                  var1.method_4574();
               }

               var1.method_4569(var84);
               int var86;
               if(this.field_702 == null) {
                  var86 = 0;
               } else {
                  var86 = this.field_702.length;
               }

               int[] var87 = new int[var85 + var86];
               if(var86 != 0) {
                  System.arraycopy(this.field_702, 0, var87, 0, var86);
               }

               while(var86 < var87.length) {
                  var87[var86] = var1.method_4574();
                  ++var86;
               }

               this.field_702 = var87;
               var1.method_4568(var83);
               continue;
            case 24:
               int var79 = class_822.method_4484(var1, 24);
               int var80;
               if(this.field_703 == null) {
                  var80 = 0;
               } else {
                  var80 = this.field_703.length;
               }

               int[] var81 = new int[var79 + var80];
               if(var80 != 0) {
                  System.arraycopy(this.field_703, 0, var81, 0, var80);
               }

               while(var80 < -1 + var81.length) {
                  var81[var80] = var1.method_4574();
                  var1.method_4585();
                  ++var80;
               }

               var81[var80] = var1.method_4574();
               this.field_703 = var81;
               continue;
            case 26:
               int var73 = var1.method_4567(var1.method_4578());
               int var74 = var1.getPosition();

               int var75;
               for(var75 = 0; var1.method_4582() > 0; ++var75) {
                  var1.method_4574();
               }

               var1.method_4569(var74);
               int var76;
               if(this.field_703 == null) {
                  var76 = 0;
               } else {
                  var76 = this.field_703.length;
               }

               int[] var77 = new int[var75 + var76];
               if(var76 != 0) {
                  System.arraycopy(this.field_703, 0, var77, 0, var76);
               }

               while(var76 < var77.length) {
                  var77[var76] = var1.method_4574();
                  ++var76;
               }

               this.field_703 = var77;
               var1.method_4568(var73);
               continue;
            case 32:
               int var69 = class_822.method_4484(var1, 32);
               int var70;
               if(this.field_704 == null) {
                  var70 = 0;
               } else {
                  var70 = this.field_704.length;
               }

               int[] var71 = new int[var69 + var70];
               if(var70 != 0) {
                  System.arraycopy(this.field_704, 0, var71, 0, var70);
               }

               while(var70 < -1 + var71.length) {
                  var71[var70] = var1.method_4574();
                  var1.method_4585();
                  ++var70;
               }

               var71[var70] = var1.method_4574();
               this.field_704 = var71;
               continue;
            case 34:
               int var63 = var1.method_4567(var1.method_4578());
               int var64 = var1.getPosition();

               int var65;
               for(var65 = 0; var1.method_4582() > 0; ++var65) {
                  var1.method_4574();
               }

               var1.method_4569(var64);
               int var66;
               if(this.field_704 == null) {
                  var66 = 0;
               } else {
                  var66 = this.field_704.length;
               }

               int[] var67 = new int[var65 + var66];
               if(var66 != 0) {
                  System.arraycopy(this.field_704, 0, var67, 0, var66);
               }

               while(var66 < var67.length) {
                  var67[var66] = var1.method_4574();
                  ++var66;
               }

               this.field_704 = var67;
               var1.method_4568(var63);
               continue;
            case 40:
               int var59 = class_822.method_4484(var1, 40);
               int var60;
               if(this.field_705 == null) {
                  var60 = 0;
               } else {
                  var60 = this.field_705.length;
               }

               int[] var61 = new int[var59 + var60];
               if(var60 != 0) {
                  System.arraycopy(this.field_705, 0, var61, 0, var60);
               }

               while(var60 < -1 + var61.length) {
                  var61[var60] = var1.method_4574();
                  var1.method_4585();
                  ++var60;
               }

               var61[var60] = var1.method_4574();
               this.field_705 = var61;
               continue;
            case 42:
               int var53 = var1.method_4567(var1.method_4578());
               int var54 = var1.getPosition();

               int var55;
               for(var55 = 0; var1.method_4582() > 0; ++var55) {
                  var1.method_4574();
               }

               var1.method_4569(var54);
               int var56;
               if(this.field_705 == null) {
                  var56 = 0;
               } else {
                  var56 = this.field_705.length;
               }

               int[] var57 = new int[var55 + var56];
               if(var56 != 0) {
                  System.arraycopy(this.field_705, 0, var57, 0, var56);
               }

               while(var56 < var57.length) {
                  var57[var56] = var1.method_4574();
                  ++var56;
               }

               this.field_705 = var57;
               var1.method_4568(var53);
               continue;
            case 48:
               int var49 = class_822.method_4484(var1, 48);
               int var50;
               if(this.field_706 == null) {
                  var50 = 0;
               } else {
                  var50 = this.field_706.length;
               }

               int[] var51 = new int[var49 + var50];
               if(var50 != 0) {
                  System.arraycopy(this.field_706, 0, var51, 0, var50);
               }

               while(var50 < -1 + var51.length) {
                  var51[var50] = var1.method_4574();
                  var1.method_4585();
                  ++var50;
               }

               var51[var50] = var1.method_4574();
               this.field_706 = var51;
               continue;
            case 50:
               int var43 = var1.method_4567(var1.method_4578());
               int var44 = var1.getPosition();

               int var45;
               for(var45 = 0; var1.method_4582() > 0; ++var45) {
                  var1.method_4574();
               }

               var1.method_4569(var44);
               int var46;
               if(this.field_706 == null) {
                  var46 = 0;
               } else {
                  var46 = this.field_706.length;
               }

               int[] var47 = new int[var45 + var46];
               if(var46 != 0) {
                  System.arraycopy(this.field_706, 0, var47, 0, var46);
               }

               while(var46 < var47.length) {
                  var47[var46] = var1.method_4574();
                  ++var46;
               }

               this.field_706 = var47;
               var1.method_4568(var43);
               continue;
            case 56:
               int var39 = class_822.method_4484(var1, 56);
               int var40;
               if(this.field_707 == null) {
                  var40 = 0;
               } else {
                  var40 = this.field_707.length;
               }

               int[] var41 = new int[var39 + var40];
               if(var40 != 0) {
                  System.arraycopy(this.field_707, 0, var41, 0, var40);
               }

               while(var40 < -1 + var41.length) {
                  var41[var40] = var1.method_4574();
                  var1.method_4585();
                  ++var40;
               }

               var41[var40] = var1.method_4574();
               this.field_707 = var41;
               continue;
            case 58:
               int var33 = var1.method_4567(var1.method_4578());
               int var34 = var1.getPosition();

               int var35;
               for(var35 = 0; var1.method_4582() > 0; ++var35) {
                  var1.method_4574();
               }

               var1.method_4569(var34);
               int var36;
               if(this.field_707 == null) {
                  var36 = 0;
               } else {
                  var36 = this.field_707.length;
               }

               int[] var37 = new int[var35 + var36];
               if(var36 != 0) {
                  System.arraycopy(this.field_707, 0, var37, 0, var36);
               }

               while(var36 < var37.length) {
                  var37[var36] = var1.method_4574();
                  ++var36;
               }

               this.field_707 = var37;
               var1.method_4568(var33);
               continue;
            case 64:
               int var29 = class_822.method_4484(var1, 64);
               int var30;
               if(this.field_708 == null) {
                  var30 = 0;
               } else {
                  var30 = this.field_708.length;
               }

               int[] var31 = new int[var29 + var30];
               if(var30 != 0) {
                  System.arraycopy(this.field_708, 0, var31, 0, var30);
               }

               while(var30 < -1 + var31.length) {
                  var31[var30] = var1.method_4574();
                  var1.method_4585();
                  ++var30;
               }

               var31[var30] = var1.method_4574();
               this.field_708 = var31;
               continue;
            case 66:
               int var23 = var1.method_4567(var1.method_4578());
               int var24 = var1.getPosition();

               int var25;
               for(var25 = 0; var1.method_4582() > 0; ++var25) {
                  var1.method_4574();
               }

               var1.method_4569(var24);
               int var26;
               if(this.field_708 == null) {
                  var26 = 0;
               } else {
                  var26 = this.field_708.length;
               }

               int[] var27 = new int[var25 + var26];
               if(var26 != 0) {
                  System.arraycopy(this.field_708, 0, var27, 0, var26);
               }

               while(var26 < var27.length) {
                  var27[var26] = var1.method_4574();
                  ++var26;
               }

               this.field_708 = var27;
               var1.method_4568(var23);
               continue;
            case 72:
               int var19 = class_822.method_4484(var1, 72);
               int var20;
               if(this.field_709 == null) {
                  var20 = 0;
               } else {
                  var20 = this.field_709.length;
               }

               int[] var21 = new int[var19 + var20];
               if(var20 != 0) {
                  System.arraycopy(this.field_709, 0, var21, 0, var20);
               }

               while(var20 < -1 + var21.length) {
                  var21[var20] = var1.method_4574();
                  var1.method_4585();
                  ++var20;
               }

               var21[var20] = var1.method_4574();
               this.field_709 = var21;
               continue;
            case 74:
               int var13 = var1.method_4567(var1.method_4578());
               int var14 = var1.getPosition();

               int var15;
               for(var15 = 0; var1.method_4582() > 0; ++var15) {
                  var1.method_4574();
               }

               var1.method_4569(var14);
               int var16;
               if(this.field_709 == null) {
                  var16 = 0;
               } else {
                  var16 = this.field_709.length;
               }

               int[] var17 = new int[var15 + var16];
               if(var16 != 0) {
                  System.arraycopy(this.field_709, 0, var17, 0, var16);
               }

               while(var16 < var17.length) {
                  var17[var16] = var1.method_4574();
                  ++var16;
               }

               this.field_709 = var17;
               var1.method_4568(var13);
               continue;
            case 80:
               int var9 = class_822.method_4484(var1, 80);
               int var10;
               if(this.field_710 == null) {
                  var10 = 0;
               } else {
                  var10 = this.field_710.length;
               }

               int[] var11 = new int[var9 + var10];
               if(var10 != 0) {
                  System.arraycopy(this.field_710, 0, var11, 0, var10);
               }

               while(var10 < -1 + var11.length) {
                  var11[var10] = var1.method_4574();
                  var1.method_4585();
                  ++var10;
               }

               var11[var10] = var1.method_4574();
               this.field_710 = var11;
               continue;
            case 82:
               int var3 = var1.method_4567(var1.method_4578());
               int var4 = var1.getPosition();

               int var5;
               for(var5 = 0; var1.method_4582() > 0; ++var5) {
                  var1.method_4574();
               }

               var1.method_4569(var4);
               int var6;
               if(this.field_710 == null) {
                  var6 = 0;
               } else {
                  var6 = this.field_710.length;
               }

               int[] var7 = new int[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.field_710, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.method_4574();
                  ++var6;
               }

               this.field_710 = var7;
               var1.method_4568(var3);
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var100 < -1 + var101.length) {
               var101[var100] = var1.method_4574();
               var1.method_4585();
               ++var100;
            }

            var101[var100] = var1.method_4574();
            this.field_701 = var101;
         }
      }

      public int hashCode() {
         return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + class_834.hashCode(this.field_701)) + class_834.hashCode(this.field_702)) + class_834.hashCode(this.field_703)) + class_834.hashCode(this.field_704)) + class_834.hashCode(this.field_705)) + class_834.hashCode(this.field_706)) + class_834.hashCode(this.field_707)) + class_834.hashCode(this.field_708)) + class_834.hashCode(this.field_709)) + class_834.hashCode(this.field_710)) + this.rQ();
      }

      // $FF: renamed from: m () com.google.android.gms.internal.c$g
      public class_55.class_1268 method_2154() {
         this.field_701 = class_822.azj;
         this.field_702 = class_822.azj;
         this.field_703 = class_822.azj;
         this.field_704 = class_822.azj;
         this.field_705 = class_822.azj;
         this.field_706 = class_822.azj;
         this.field_707 = class_822.azj;
         this.field_708 = class_822.azj;
         this.field_709 = class_822.azj;
         this.field_710 = class_822.azj;
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }

   public static final class class_1267 extends qq<class_55.class_1267> {
      // $FF: renamed from: gf com.google.android.gms.internal.qr
      public static final qr<class_57.class_1084, class_55.class_1267> field_711 = class_831.method_4599(11, class_55.class_1267.class, 810);
      // $FF: renamed from: gg com.google.android.gms.internal.c$h[]
      private static final class_55.class_1267[] field_712 = new class_55.class_1267[0];
      // $FF: renamed from: gh int[]
      public int[] field_713;
      // $FF: renamed from: gi int[]
      public int[] field_714;
      // $FF: renamed from: gj int[]
      public int[] field_715;
      // $FF: renamed from: gk int
      public int field_716;
      // $FF: renamed from: gl int[]
      public int[] field_717;
      // $FF: renamed from: gm int
      public int field_718;
      // $FF: renamed from: gn int
      public int field_719;

      public class_1267() {
         this.method_2156();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(this.field_713 != null && this.field_713.length > 0) {
            for(int var6 = 0; var6 < this.field_713.length; ++var6) {
               var1.method_4554(1, this.field_713[var6]);
            }
         }

         if(this.field_714 != null && this.field_714.length > 0) {
            for(int var5 = 0; var5 < this.field_714.length; ++var5) {
               var1.method_4554(2, this.field_714[var5]);
            }
         }

         if(this.field_715 != null && this.field_715.length > 0) {
            for(int var4 = 0; var4 < this.field_715.length; ++var4) {
               var1.method_4554(3, this.field_715[var4]);
            }
         }

         if(this.field_716 != 0) {
            var1.method_4554(4, this.field_716);
         }

         if(this.field_717 != null) {
            int var2 = this.field_717.length;
            int var3 = 0;
            if(var2 > 0) {
               while(var3 < this.field_717.length) {
                  var1.method_4554(5, this.field_717[var3]);
                  ++var3;
               }
            }
         }

         if(this.field_718 != 0) {
            var1.method_4554(6, this.field_718);
         }

         if(this.field_719 != 0) {
            var1.method_4554(7, this.field_719);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2155(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = 0;
         int var2 = super.method_2091();
         int var3;
         if(this.field_713 != null && this.field_713.length > 0) {
            int var9 = 0;

            int var10;
            for(var10 = 0; var9 < this.field_713.length; ++var9) {
               var10 += class_826.method_4516(this.field_713[var9]);
            }

            var3 = var2 + var10 + 1 * this.field_713.length;
         } else {
            var3 = var2;
         }

         if(this.field_714 != null && this.field_714.length > 0) {
            int var7 = 0;

            int var8;
            for(var8 = 0; var7 < this.field_714.length; ++var7) {
               var8 += class_826.method_4516(this.field_714[var7]);
            }

            var3 = var3 + var8 + 1 * this.field_714.length;
         }

         if(this.field_715 != null && this.field_715.length > 0) {
            int var5 = 0;

            int var6;
            for(var6 = 0; var5 < this.field_715.length; ++var5) {
               var6 += class_826.method_4516(this.field_715[var5]);
            }

            var3 = var3 + var6 + 1 * this.field_715.length;
         }

         if(this.field_716 != 0) {
            var3 += class_826.method_4524(4, this.field_716);
         }

         if(this.field_717 != null && this.field_717.length > 0) {
            int var4;
            for(var4 = 0; var1 < this.field_717.length; ++var1) {
               var4 += class_826.method_4516(this.field_717[var1]);
            }

            var3 = var3 + var4 + 1 * this.field_717.length;
         }

         if(this.field_718 != 0) {
            var3 += class_826.method_4524(6, this.field_718);
         }

         if(this.field_719 != 0) {
            var3 += class_826.method_4524(7, this.field_719);
         }

         return var3;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_55.class_1267;
            var3 = false;
            if(var2) {
               class_55.class_1267 var4 = (class_55.class_1267)var1;
               boolean var5 = class_834.equals(this.field_713, var4.field_713);
               var3 = false;
               if(var5) {
                  boolean var6 = class_834.equals(this.field_714, var4.field_714);
                  var3 = false;
                  if(var6) {
                     boolean var7 = class_834.equals(this.field_715, var4.field_715);
                     var3 = false;
                     if(var7) {
                        int var8 = this.field_716;
                        int var9 = var4.field_716;
                        var3 = false;
                        if(var8 == var9) {
                           boolean var10 = class_834.equals(this.field_717, var4.field_717);
                           var3 = false;
                           if(var10) {
                              int var11 = this.field_718;
                              int var12 = var4.field_718;
                              var3 = false;
                              if(var11 == var12) {
                                 int var13 = this.field_719;
                                 int var14 = var4.field_719;
                                 var3 = false;
                                 if(var13 == var14) {
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

         return var3;
      }

      public int hashCode() {
         return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + class_834.hashCode(this.field_713)) + class_834.hashCode(this.field_714)) + class_834.hashCode(this.field_715)) + this.field_716) + class_834.hashCode(this.field_717)) + this.field_718) + this.field_719) + this.rQ();
      }

      // $FF: renamed from: i (com.google.android.gms.internal.qo) com.google.android.gms.internal.c$h
      public class_55.class_1267 method_2155(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            int var40;
            int[] var41;
            switch(var2) {
            case 8:
               int var39 = class_822.method_4484(var1, 8);
               if(this.field_713 == null) {
                  var40 = 0;
               } else {
                  var40 = this.field_713.length;
               }

               var41 = new int[var39 + var40];
               if(var40 != 0) {
                  System.arraycopy(this.field_713, 0, var41, 0, var40);
               }
               break;
            case 10:
               int var33 = var1.method_4567(var1.method_4578());
               int var34 = var1.getPosition();

               int var35;
               for(var35 = 0; var1.method_4582() > 0; ++var35) {
                  var1.method_4574();
               }

               var1.method_4569(var34);
               int var36;
               if(this.field_713 == null) {
                  var36 = 0;
               } else {
                  var36 = this.field_713.length;
               }

               int[] var37 = new int[var35 + var36];
               if(var36 != 0) {
                  System.arraycopy(this.field_713, 0, var37, 0, var36);
               }

               while(var36 < var37.length) {
                  var37[var36] = var1.method_4574();
                  ++var36;
               }

               this.field_713 = var37;
               var1.method_4568(var33);
               continue;
            case 16:
               int var29 = class_822.method_4484(var1, 16);
               int var30;
               if(this.field_714 == null) {
                  var30 = 0;
               } else {
                  var30 = this.field_714.length;
               }

               int[] var31 = new int[var29 + var30];
               if(var30 != 0) {
                  System.arraycopy(this.field_714, 0, var31, 0, var30);
               }

               while(var30 < -1 + var31.length) {
                  var31[var30] = var1.method_4574();
                  var1.method_4585();
                  ++var30;
               }

               var31[var30] = var1.method_4574();
               this.field_714 = var31;
               continue;
            case 18:
               int var23 = var1.method_4567(var1.method_4578());
               int var24 = var1.getPosition();

               int var25;
               for(var25 = 0; var1.method_4582() > 0; ++var25) {
                  var1.method_4574();
               }

               var1.method_4569(var24);
               int var26;
               if(this.field_714 == null) {
                  var26 = 0;
               } else {
                  var26 = this.field_714.length;
               }

               int[] var27 = new int[var25 + var26];
               if(var26 != 0) {
                  System.arraycopy(this.field_714, 0, var27, 0, var26);
               }

               while(var26 < var27.length) {
                  var27[var26] = var1.method_4574();
                  ++var26;
               }

               this.field_714 = var27;
               var1.method_4568(var23);
               continue;
            case 24:
               int var19 = class_822.method_4484(var1, 24);
               int var20;
               if(this.field_715 == null) {
                  var20 = 0;
               } else {
                  var20 = this.field_715.length;
               }

               int[] var21 = new int[var19 + var20];
               if(var20 != 0) {
                  System.arraycopy(this.field_715, 0, var21, 0, var20);
               }

               while(var20 < -1 + var21.length) {
                  var21[var20] = var1.method_4574();
                  var1.method_4585();
                  ++var20;
               }

               var21[var20] = var1.method_4574();
               this.field_715 = var21;
               continue;
            case 26:
               int var13 = var1.method_4567(var1.method_4578());
               int var14 = var1.getPosition();

               int var15;
               for(var15 = 0; var1.method_4582() > 0; ++var15) {
                  var1.method_4574();
               }

               var1.method_4569(var14);
               int var16;
               if(this.field_715 == null) {
                  var16 = 0;
               } else {
                  var16 = this.field_715.length;
               }

               int[] var17 = new int[var15 + var16];
               if(var16 != 0) {
                  System.arraycopy(this.field_715, 0, var17, 0, var16);
               }

               while(var16 < var17.length) {
                  var17[var16] = var1.method_4574();
                  ++var16;
               }

               this.field_715 = var17;
               var1.method_4568(var13);
               continue;
            case 32:
               this.field_716 = var1.method_4574();
               continue;
            case 40:
               int var9 = class_822.method_4484(var1, 40);
               int var10;
               if(this.field_717 == null) {
                  var10 = 0;
               } else {
                  var10 = this.field_717.length;
               }

               int[] var11 = new int[var9 + var10];
               if(var10 != 0) {
                  System.arraycopy(this.field_717, 0, var11, 0, var10);
               }

               while(var10 < -1 + var11.length) {
                  var11[var10] = var1.method_4574();
                  var1.method_4585();
                  ++var10;
               }

               var11[var10] = var1.method_4574();
               this.field_717 = var11;
               continue;
            case 42:
               int var3 = var1.method_4567(var1.method_4578());
               int var4 = var1.getPosition();

               int var5;
               for(var5 = 0; var1.method_4582() > 0; ++var5) {
                  var1.method_4574();
               }

               var1.method_4569(var4);
               int var6;
               if(this.field_717 == null) {
                  var6 = 0;
               } else {
                  var6 = this.field_717.length;
               }

               int[] var7 = new int[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.field_717, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.method_4574();
                  ++var6;
               }

               this.field_717 = var7;
               var1.method_4568(var3);
               continue;
            case 48:
               this.field_718 = var1.method_4574();
               continue;
            case 56:
               this.field_719 = var1.method_4574();
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var40 < -1 + var41.length) {
               var41[var40] = var1.method_4574();
               var1.method_4585();
               ++var40;
            }

            var41[var40] = var1.method_4574();
            this.field_713 = var41;
         }
      }

      // $FF: renamed from: n () com.google.android.gms.internal.c$h
      public class_55.class_1267 method_2156() {
         this.field_713 = class_822.azj;
         this.field_714 = class_822.azj;
         this.field_715 = class_822.azj;
         this.field_716 = 0;
         this.field_717 = class_822.azj;
         this.field_718 = 0;
         this.field_719 = 0;
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }

   public static final class class_1258 extends qq<class_55.class_1258> {
      // $FF: renamed from: go com.google.android.gms.internal.c$i[]
      private static volatile class_55.class_1258[] field_723;
      // $FF: renamed from: gp com.google.android.gms.internal.d$a
      public class_57.class_1084 field_724;
      // $FF: renamed from: gq com.google.android.gms.internal.c$d
      public class_55.class_1271 field_725;
      public String name;

      public class_1258() {
         this.method_2162();
      }

      // $FF: renamed from: o () com.google.android.gms.internal.c$i[]
      public static class_55.class_1258[] method_2160() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(!this.name.equals("")) {
            var1.method_4537(1, this.name);
         }

         if(this.field_724 != null) {
            var1.method_4532(2, this.field_724);
         }

         if(this.field_725 != null) {
            var1.method_4532(3, this.field_725);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2161(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091();
         if(!this.name.equals("")) {
            var1 += class_826.method_4521(1, this.name);
         }

         if(this.field_724 != null) {
            var1 += class_826.method_4507(2, this.field_724);
         }

         if(this.field_725 != null) {
            var1 += class_826.method_4507(3, this.field_725);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_55.class_1258;
            var3 = false;
            if(var2) {
               class_55.class_1258 var4 = (class_55.class_1258)var1;
               if(this.name == null) {
                  String var7 = var4.name;
                  var3 = false;
                  if(var7 != null) {
                     return var3;
                  }
               } else if(!this.name.equals(var4.name)) {
                  return false;
               }

               if(this.field_724 == null) {
                  class_57.class_1084 var6 = var4.field_724;
                  var3 = false;
                  if(var6 != null) {
                     return var3;
                  }
               } else if(!this.field_724.equals(var4.field_724)) {
                  return false;
               }

               if(this.field_725 == null) {
                  class_55.class_1271 var5 = var4.field_725;
                  var3 = false;
                  if(var5 != null) {
                     return var3;
                  }
               } else if(!this.field_725.equals(var4.field_725)) {
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
         int var3;
         if(this.field_724 == null) {
            var3 = 0;
         } else {
            var3 = this.field_724.hashCode();
         }

         int var4 = 31 * (var3 + var2);
         class_55.class_1271 var5 = this.field_725;
         int var6 = 0;
         if(var5 != null) {
            var6 = this.field_725.hashCode();
         }

         return 31 * (var4 + var6) + this.rQ();
      }

      // $FF: renamed from: j (com.google.android.gms.internal.qo) com.google.android.gms.internal.c$i
      public class_55.class_1258 method_2161(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            switch(var2) {
            case 10:
               this.name = var1.readString();
               break;
            case 18:
               if(this.field_724 == null) {
                  this.field_724 = new class_57.class_1084();
               }

               var1.method_4563(this.field_724);
               break;
            case 26:
               if(this.field_725 == null) {
                  this.field_725 = new class_55.class_1271();
               }

               var1.method_4563(this.field_725);
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

      // $FF: renamed from: p () com.google.android.gms.internal.c$i
      public class_55.class_1258 method_2162() {
         this.name = "";
         this.field_724 = null;
         this.field_725 = null;
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }

   public static final class class_1260 extends qq<class_55.class_1260> {
      // $FF: renamed from: gr com.google.android.gms.internal.c$i[]
      public class_55.class_1258[] field_720;
      // $FF: renamed from: gs com.google.android.gms.internal.c$f
      public class_55.class_1269 field_721;
      // $FF: renamed from: gt java.lang.String
      public String field_722;

      public class_1260() {
         this.method_2159();
      }

      // $FF: renamed from: b (byte[]) com.google.android.gms.internal.c$j
      public static class_55.class_1260 method_2157(byte[] var0) throws class_833 {
         return (class_55.class_1260)class_300.method_2085(new class_55.class_1260(), var0);
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(this.field_720 != null && this.field_720.length > 0) {
            for(int var2 = 0; var2 < this.field_720.length; ++var2) {
               class_55.class_1258 var3 = this.field_720[var2];
               if(var3 != null) {
                  var1.method_4532(1, var3);
               }
            }
         }

         if(this.field_721 != null) {
            var1.method_4532(2, this.field_721);
         }

         if(!this.field_722.equals("")) {
            var1.method_4537(3, this.field_722);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2158(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091();
         if(this.field_720 != null && this.field_720.length > 0) {
            for(int var2 = 0; var2 < this.field_720.length; ++var2) {
               class_55.class_1258 var3 = this.field_720[var2];
               if(var3 != null) {
                  var1 += class_826.method_4507(1, var3);
               }
            }
         }

         if(this.field_721 != null) {
            var1 += class_826.method_4507(2, this.field_721);
         }

         if(!this.field_722.equals("")) {
            var1 += class_826.method_4521(3, this.field_722);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_55.class_1260;
            var3 = false;
            if(var2) {
               class_55.class_1260 var4 = (class_55.class_1260)var1;
               boolean var5 = class_834.equals((Object[])this.field_720, (Object[])var4.field_720);
               var3 = false;
               if(var5) {
                  if(this.field_721 == null) {
                     class_55.class_1269 var7 = var4.field_721;
                     var3 = false;
                     if(var7 != null) {
                        return var3;
                     }
                  } else if(!this.field_721.equals(var4.field_721)) {
                     return false;
                  }

                  if(this.field_722 == null) {
                     String var6 = var4.field_722;
                     var3 = false;
                     if(var6 != null) {
                        return var3;
                     }
                  } else if(!this.field_722.equals(var4.field_722)) {
                     return false;
                  }

                  return this.a(var4);
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (527 + class_834.hashCode((Object[])this.field_720));
         int var2;
         if(this.field_721 == null) {
            var2 = 0;
         } else {
            var2 = this.field_721.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         String var4 = this.field_722;
         int var5 = 0;
         if(var4 != null) {
            var5 = this.field_722.hashCode();
         }

         return 31 * (var3 + var5) + this.rQ();
      }

      // $FF: renamed from: k (com.google.android.gms.internal.qo) com.google.android.gms.internal.c$j
      public class_55.class_1260 method_2158(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            int var4;
            class_55.class_1258[] var5;
            switch(var2) {
            case 10:
               int var3 = class_822.method_4484(var1, 10);
               if(this.field_720 == null) {
                  var4 = 0;
               } else {
                  var4 = this.field_720.length;
               }

               var5 = new class_55.class_1258[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.field_720, 0, var5, 0, var4);
               }
               break;
            case 18:
               if(this.field_721 == null) {
                  this.field_721 = new class_55.class_1269();
               }

               var1.method_4563(this.field_721);
               continue;
            case 26:
               this.field_722 = var1.readString();
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var4 < -1 + var5.length) {
               var5[var4] = new class_55.class_1258();
               var1.method_4563(var5[var4]);
               var1.method_4585();
               ++var4;
            }

            var5[var4] = new class_55.class_1258();
            var1.method_4563(var5[var4]);
            this.field_720 = var5;
         }
      }

      // $FF: renamed from: q () com.google.android.gms.internal.c$j
      public class_55.class_1260 method_2159() {
         this.field_720 = class_55.class_1258.method_2160();
         this.field_721 = null;
         this.field_722 = "";
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }
}
