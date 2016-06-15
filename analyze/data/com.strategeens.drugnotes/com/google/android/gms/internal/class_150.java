package com.google.android.gms.internal;

import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_822;
import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.class_827;
import com.google.android.gms.internal.class_834;
import com.google.android.gms.internal.qq;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.mv
public interface class_150 {
   public static final class class_1434 extends qq<class_150.class_1434> {
      public class_150.class_1435[] afu;

      public class_1434() {
         this.method_2110();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(this.afu != null && this.afu.length > 0) {
            for(int var2 = 0; var2 < this.afu.length; ++var2) {
               class_150.class_1435 var3 = this.afu[var2];
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
         return this.method_2111(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091();
         if(this.afu != null && this.afu.length > 0) {
            for(int var2 = 0; var2 < this.afu.length; ++var2) {
               class_150.class_1435 var3 = this.afu[var2];
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
            boolean var2 = var1 instanceof class_150.class_1434;
            var3 = false;
            if(var2) {
               class_150.class_1434 var4 = (class_150.class_1434)var1;
               boolean var5 = class_834.equals((Object[])this.afu, (Object[])var4.afu);
               var3 = false;
               if(var5) {
                  return this.a(var4);
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         return 31 * (527 + class_834.hashCode((Object[])this.afu)) + this.rQ();
      }

      // $FF: renamed from: mW () com.google.android.gms.internal.mv$a
      public class_150.class_1434 method_2110() {
         this.afu = class_150.class_1435.method_2103();
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      // $FF: renamed from: n (com.google.android.gms.internal.qo) com.google.android.gms.internal.mv$a
      public class_150.class_1434 method_2111(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            int var4;
            class_150.class_1435[] var5;
            switch(var2) {
            case 10:
               int var3 = class_822.method_4484(var1, 10);
               if(this.afu == null) {
                  var4 = 0;
               } else {
                  var4 = this.afu.length;
               }

               var5 = new class_150.class_1435[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.afu, 0, var5, 0, var4);
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
               var5[var4] = new class_150.class_1435();
               var1.method_4563(var5[var4]);
               var1.method_4585();
               ++var4;
            }

            var5[var4] = new class_150.class_1435();
            var1.method_4563(var5[var4]);
            this.afu = var5;
         }
      }
   }

   public static final class class_1435 extends qq<class_150.class_1435> {
      private static volatile class_150.class_1435[] afv;
      public String afw;
      public String afx;
      public int viewId;

      public class_1435() {
         this.method_2104();
      }

      // $FF: renamed from: mX () com.google.android.gms.internal.mv$a$a[]
      public static class_150.class_1435[] method_2103() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(!this.afw.equals("")) {
            var1.method_4537(1, this.afw);
         }

         if(!this.afx.equals("")) {
            var1.method_4537(2, this.afx);
         }

         if(this.viewId != 0) {
            var1.method_4554(3, this.viewId);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2105(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091();
         if(!this.afw.equals("")) {
            var1 += class_826.method_4521(1, this.afw);
         }

         if(!this.afx.equals("")) {
            var1 += class_826.method_4521(2, this.afx);
         }

         if(this.viewId != 0) {
            var1 += class_826.method_4524(3, this.viewId);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_150.class_1435;
            var3 = false;
            if(var2) {
               class_150.class_1435 var4 = (class_150.class_1435)var1;
               if(this.afw == null) {
                  String var8 = var4.afw;
                  var3 = false;
                  if(var8 != null) {
                     return var3;
                  }
               } else if(!this.afw.equals(var4.afw)) {
                  return false;
               }

               if(this.afx == null) {
                  String var7 = var4.afx;
                  var3 = false;
                  if(var7 != null) {
                     return var3;
                  }
               } else if(!this.afx.equals(var4.afx)) {
                  return false;
               }

               int var5 = this.viewId;
               int var6 = var4.viewId;
               var3 = false;
               if(var5 == var6) {
                  return this.a(var4);
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1;
         if(this.afw == null) {
            var1 = 0;
         } else {
            var1 = this.afw.hashCode();
         }

         int var2 = 31 * (var1 + 527);
         String var3 = this.afx;
         int var4 = 0;
         if(var3 != null) {
            var4 = this.afx.hashCode();
         }

         return 31 * (31 * (var2 + var4) + this.viewId) + this.rQ();
      }

      // $FF: renamed from: mY () com.google.android.gms.internal.mv$a$a
      public class_150.class_1435 method_2104() {
         this.afw = "";
         this.afx = "";
         this.viewId = 0;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      // $FF: renamed from: o (com.google.android.gms.internal.qo) com.google.android.gms.internal.mv$a$a
      public class_150.class_1435 method_2105(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            switch(var2) {
            case 10:
               this.afw = var1.readString();
               break;
            case 18:
               this.afx = var1.readString();
               break;
            case 24:
               this.viewId = var1.method_4574();
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

   public static final class class_1436 extends qq<class_150.class_1436> {
      private static volatile class_150.class_1436[] afy;
      public class_150.class_1438 afz;
      public String name;

      public class_1436() {
         this.method_2113();
      }

      // $FF: renamed from: mZ () com.google.android.gms.internal.mv$b[]
      public static class_150.class_1436[] method_2112() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(!this.name.equals("")) {
            var1.method_4537(1, this.name);
         }

         if(this.afz != null) {
            var1.method_4532(2, this.afz);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2114(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091();
         if(!this.name.equals("")) {
            var1 += class_826.method_4521(1, this.name);
         }

         if(this.afz != null) {
            var1 += class_826.method_4507(2, this.afz);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_150.class_1436;
            var3 = false;
            if(var2) {
               class_150.class_1436 var4 = (class_150.class_1436)var1;
               if(this.name == null) {
                  String var6 = var4.name;
                  var3 = false;
                  if(var6 != null) {
                     return var3;
                  }
               } else if(!this.name.equals(var4.name)) {
                  return false;
               }

               if(this.afz == null) {
                  class_150.class_1438 var5 = var4.afz;
                  var3 = false;
                  if(var5 != null) {
                     return var3;
                  }
               } else if(!this.afz.equals(var4.afz)) {
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
         class_150.class_1438 var3 = this.afz;
         int var4 = 0;
         if(var3 != null) {
            var4 = this.afz.hashCode();
         }

         return 31 * (var2 + var4) + this.rQ();
      }

      // $FF: renamed from: na () com.google.android.gms.internal.mv$b
      public class_150.class_1436 method_2113() {
         this.name = "";
         this.afz = null;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      // $FF: renamed from: p (com.google.android.gms.internal.qo) com.google.android.gms.internal.mv$b
      public class_150.class_1436 method_2114(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            switch(var2) {
            case 10:
               this.name = var1.readString();
               break;
            case 18:
               if(this.afz == null) {
                  this.afz = new class_150.class_1438();
               }

               var1.method_4563(this.afz);
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

   public static final class class_1437 extends qq<class_150.class_1437> {
      public class_150.class_1436[] afA;
      public String type;

      public class_1437() {
         this.method_2108();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(!this.type.equals("")) {
            var1.method_4537(1, this.type);
         }

         if(this.afA != null && this.afA.length > 0) {
            for(int var2 = 0; var2 < this.afA.length; ++var2) {
               class_150.class_1436 var3 = this.afA[var2];
               if(var3 != null) {
                  var1.method_4532(2, var3);
               }
            }
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2109(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091();
         if(!this.type.equals("")) {
            var1 += class_826.method_4521(1, this.type);
         }

         if(this.afA != null && this.afA.length > 0) {
            int var2 = var1;

            for(int var3 = 0; var3 < this.afA.length; ++var3) {
               class_150.class_1436 var4 = this.afA[var3];
               if(var4 != null) {
                  var2 += class_826.method_4507(2, var4);
               }
            }

            var1 = var2;
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_150.class_1437;
            var3 = false;
            if(var2) {
               class_150.class_1437 var4 = (class_150.class_1437)var1;
               if(this.type == null) {
                  String var6 = var4.type;
                  var3 = false;
                  if(var6 != null) {
                     return var3;
                  }
               } else if(!this.type.equals(var4.type)) {
                  return false;
               }

               boolean var5 = class_834.equals((Object[])this.afA, (Object[])var4.afA);
               var3 = false;
               if(var5) {
                  return this.a(var4);
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1;
         if(this.type == null) {
            var1 = 0;
         } else {
            var1 = this.type.hashCode();
         }

         return 31 * (31 * (var1 + 527) + class_834.hashCode((Object[])this.afA)) + this.rQ();
      }

      // $FF: renamed from: nb () com.google.android.gms.internal.mv$c
      public class_150.class_1437 method_2108() {
         this.type = "";
         this.afA = class_150.class_1436.method_2112();
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      // $FF: renamed from: q (com.google.android.gms.internal.qo) com.google.android.gms.internal.mv$c
      public class_150.class_1437 method_2109(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            int var4;
            class_150.class_1436[] var5;
            switch(var2) {
            case 10:
               this.type = var1.readString();
               continue;
            case 18:
               int var3 = class_822.method_4484(var1, 18);
               if(this.afA == null) {
                  var4 = 0;
               } else {
                  var4 = this.afA.length;
               }

               var5 = new class_150.class_1436[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.afA, 0, var5, 0, var4);
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
               var5[var4] = new class_150.class_1436();
               var1.method_4563(var5[var4]);
               var1.method_4585();
               ++var4;
            }

            var5[var4] = new class_150.class_1436();
            var1.method_4563(var5[var4]);
            this.afA = var5;
         }
      }
   }

   public static final class class_1438 extends qq<class_150.class_1438> {
      // $FF: renamed from: NJ java.lang.String
      public String field_664;
      public boolean afB;
      public long afC;
      public double afD;
      public class_150.class_1437 afE;

      public class_1438() {
         this.method_2106();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         if(this.afB) {
            var1.method_4538(1, this.afB);
         }

         if(!this.field_664.equals("")) {
            var1.method_4537(2, this.field_664);
         }

         if(this.afC != 0L) {
            var1.method_4536(3, this.afC);
         }

         if(Double.doubleToLongBits(this.afD) != Double.doubleToLongBits(0.0D)) {
            var1.method_4531(4, this.afD);
         }

         if(this.afE != null) {
            var1.method_4532(5, this.afE);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2107(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091();
         if(this.afB) {
            var1 += class_826.method_4508(1, this.afB);
         }

         if(!this.field_664.equals("")) {
            var1 += class_826.method_4521(2, this.field_664);
         }

         if(this.afC != 0L) {
            var1 += class_826.method_4509(3, this.afC);
         }

         if(Double.doubleToLongBits(this.afD) != Double.doubleToLongBits(0.0D)) {
            var1 += class_826.method_4502(4, this.afD);
         }

         if(this.afE != null) {
            var1 += class_826.method_4507(5, this.afE);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_150.class_1438;
            var3 = false;
            if(var2) {
               class_150.class_1438 var4 = (class_150.class_1438)var1;
               boolean var5 = this.afB;
               boolean var6 = var4.afB;
               var3 = false;
               if(var5 == var6) {
                  if(this.field_664 == null) {
                     String var10 = var4.field_664;
                     var3 = false;
                     if(var10 != null) {
                        return var3;
                     }
                  } else if(!this.field_664.equals(var4.field_664)) {
                     return false;
                  }

                  long var11;
                  int var7 = (var11 = this.afC - var4.afC) == 0L?0:(var11 < 0L?-1:1);
                  var3 = false;
                  if(var7 == 0) {
                     long var12;
                     int var8 = (var12 = Double.doubleToLongBits(this.afD) - Double.doubleToLongBits(var4.afD)) == 0L?0:(var12 < 0L?-1:1);
                     var3 = false;
                     if(var8 == 0) {
                        if(this.afE == null) {
                           class_150.class_1437 var9 = var4.afE;
                           var3 = false;
                           if(var9 != null) {
                              return var3;
                           }
                        } else if(!this.afE.equals(var4.afE)) {
                           return false;
                        }

                        return this.a(var4);
                     }
                  }
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         short var1;
         if(this.afB) {
            var1 = 1231;
         } else {
            var1 = 1237;
         }

         int var2 = 31 * (var1 + 527);
         int var3;
         if(this.field_664 == null) {
            var3 = 0;
         } else {
            var3 = this.field_664.hashCode();
         }

         int var4 = 31 * (var3 + var2) + (int)(this.afC ^ this.afC >>> 32);
         long var5 = Double.doubleToLongBits(this.afD);
         int var7 = 31 * (var4 * 31 + (int)(var5 ^ var5 >>> 32));
         class_150.class_1437 var8 = this.afE;
         int var9 = 0;
         if(var8 != null) {
            var9 = this.afE.hashCode();
         }

         return 31 * (var7 + var9) + this.rQ();
      }

      // $FF: renamed from: nc () com.google.android.gms.internal.mv$d
      public class_150.class_1438 method_2106() {
         this.afB = false;
         this.field_664 = "";
         this.afC = 0L;
         this.afD = 0.0D;
         this.afE = null;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      // $FF: renamed from: r (com.google.android.gms.internal.qo) com.google.android.gms.internal.mv$d
      public class_150.class_1438 method_2107(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            switch(var2) {
            case 8:
               this.afB = var1.method_4575();
               break;
            case 18:
               this.field_664 = var1.readString();
               break;
            case 24:
               this.afC = var1.method_4573();
               break;
            case 33:
               this.afD = var1.readDouble();
               break;
            case 42:
               if(this.afE == null) {
                  this.afE = new class_150.class_1437();
               }

               var1.method_4563(this.afE);
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
}
