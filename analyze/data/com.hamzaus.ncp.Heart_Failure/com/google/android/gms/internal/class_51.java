package com.google.android.gms.internal;

import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.internal.class_601;
import com.google.android.gms.internal.class_602;
import com.google.android.gms.internal.class_603;
import com.google.android.gms.internal.class_605;
import com.google.android.gms.internal.class_637;
import com.google.android.gms.internal.class_638;
import com.google.android.gms.internal.mb;
import com.google.android.gms.internal.mc;
import java.io.IOException;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.c
public interface class_51 {
   public static final class class_972 extends mb<class_51.class_972> {
      // $FF: renamed from: eE int
      public int field_824;
      // $FF: renamed from: eF int
      public int field_825;
      public int level;

      public class_972() {
         this.method_1748();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.lz) com.google.android.gms.internal.c$a
      public class_51.class_972 method_1747(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            switch(var2) {
            case 8:
               int var3 = var1.method_3573();
               switch(var3) {
               case 1:
               case 2:
               case 3:
                  this.level = var3;
               default:
                  continue;
               }
            case 16:
               this.field_824 = var1.method_3573();
               break;
            case 24:
               this.field_825 = var1.method_3573();
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

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         if(this.level != 1) {
            var1.method_3535(1, this.level);
         }

         if(this.field_824 != 0) {
            var1.method_3535(2, this.field_824);
         }

         if(this.field_825 != 0) {
            var1.method_3535(3, this.field_825);
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b () com.google.android.gms.internal.c$a
      public class_51.class_972 method_1748() {
         this.level = 1;
         this.field_824 = 0;
         this.field_825 = 0;
         this.amU = null;
         this.amY = -1;
         return this;
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1747(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = super.method_1723();
         if(this.level != 1) {
            var1 += class_601.method_3506(1, this.level);
         }

         if(this.field_824 != 0) {
            var1 += class_601.method_3506(2, this.field_824);
         }

         if(this.field_825 != 0) {
            var1 += class_601.method_3506(3, this.field_825);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_51.class_972;
            var3 = false;
            if(var2) {
               class_51.class_972 var4 = (class_51.class_972)var1;
               int var5 = this.level;
               int var6 = var4.level;
               var3 = false;
               if(var5 == var6) {
                  int var7 = this.field_824;
                  int var8 = var4.field_824;
                  var3 = false;
                  if(var7 == var8) {
                     int var9 = this.field_825;
                     int var10 = var4.field_825;
                     var3 = false;
                     if(var9 == var10) {
                        if(this.amU != null && !this.amU.isEmpty()) {
                           return this.amU.equals(var4.amU);
                        }

                        if(var4.amU != null) {
                           boolean var11 = var4.amU.isEmpty();
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
         int var1 = 31 * (31 * (31 * (527 + this.level) + this.field_824) + this.field_825);
         int var2;
         if(this.amU != null && !this.amU.isEmpty()) {
            var2 = this.amU.hashCode();
         } else {
            var2 = 0;
         }

         return var2 + var1;
      }
   }

   public static final class class_969 extends mb<class_51.class_969> {
      // $FF: renamed from: eG com.google.android.gms.internal.c$b[]
      private static volatile class_51.class_969[] field_826;
      // $FF: renamed from: eH int[]
      public int[] field_827;
      // $FF: renamed from: eI int
      public int field_828;
      // $FF: renamed from: eJ boolean
      public boolean field_829;
      // $FF: renamed from: eK boolean
      public boolean field_830;
      public int name;

      public class_969() {
         this.method_1751();
      }

      // $FF: renamed from: d () com.google.android.gms.internal.c$b[]
      public static class_51.class_969[] method_1749() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         if(this.field_830) {
            var1.method_3516(1, this.field_830);
         }

         var1.method_3535(2, this.field_828);
         if(this.field_827 != null && this.field_827.length > 0) {
            for(int var2 = 0; var2 < this.field_827.length; ++var2) {
               var1.method_3535(3, this.field_827[var2]);
            }
         }

         if(this.name != 0) {
            var1.method_3535(4, this.name);
         }

         if(this.field_829) {
            var1.method_3516(6, this.field_829);
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1750(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = 0;
         int var2 = super.method_1723();
         if(this.field_830) {
            var2 += class_601.method_3489(1, this.field_830);
         }

         int var3 = var2 + class_601.method_3506(2, this.field_828);
         int var4;
         if(this.field_827 != null && this.field_827.length > 0) {
            for(int var5 = 0; var5 < this.field_827.length; ++var5) {
               var1 += class_601.method_3498(this.field_827[var5]);
            }

            var4 = var3 + var1 + 1 * this.field_827.length;
         } else {
            var4 = var3;
         }

         if(this.name != 0) {
            var4 += class_601.method_3506(4, this.name);
         }

         if(this.field_829) {
            var4 += class_601.method_3489(6, this.field_829);
         }

         return var4;
      }

      // $FF: renamed from: c (com.google.android.gms.internal.lz) com.google.android.gms.internal.c$b
      public class_51.class_969 method_1750(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            int var10;
            int[] var11;
            switch(var2) {
            case 8:
               this.field_830 = var1.method_3560();
               continue;
            case 16:
               this.field_828 = var1.method_3573();
               continue;
            case 24:
               int var9 = class_638.method_3656(var1, 24);
               if(this.field_827 == null) {
                  var10 = 0;
               } else {
                  var10 = this.field_827.length;
               }

               var11 = new int[var9 + var10];
               if(var10 != 0) {
                  System.arraycopy(this.field_827, 0, var11, 0, var10);
               }
               break;
            case 26:
               int var3 = var1.method_3557(var1.method_3563());
               int var4 = var1.getPosition();

               int var5;
               for(var5 = 0; var1.method_3567() > 0; ++var5) {
                  var1.method_3573();
               }

               var1.method_3559(var4);
               int var6;
               if(this.field_827 == null) {
                  var6 = 0;
               } else {
                  var6 = this.field_827.length;
               }

               int[] var7 = new int[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.field_827, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.method_3573();
                  ++var6;
               }

               this.field_827 = var7;
               var1.method_3558(var3);
               continue;
            case 32:
               this.name = var1.method_3573();
               continue;
            case 48:
               this.field_829 = var1.method_3560();
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var10 < -1 + var11.length) {
               var11[var10] = var1.method_3573();
               var1.method_3570();
               ++var10;
            }

            var11[var10] = var1.method_3573();
            this.field_827 = var11;
         }
      }

      // $FF: renamed from: e () com.google.android.gms.internal.c$b
      public class_51.class_969 method_1751() {
         this.field_827 = class_638.ana;
         this.field_828 = 0;
         this.name = 0;
         this.field_829 = false;
         this.field_830 = false;
         this.amU = null;
         this.amY = -1;
         return this;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_51.class_969;
            var3 = false;
            if(var2) {
               class_51.class_969 var4 = (class_51.class_969)var1;
               boolean var5 = class_602.equals(this.field_827, var4.field_827);
               var3 = false;
               if(var5) {
                  int var6 = this.field_828;
                  int var7 = var4.field_828;
                  var3 = false;
                  if(var6 == var7) {
                     int var8 = this.name;
                     int var9 = var4.name;
                     var3 = false;
                     if(var8 == var9) {
                        boolean var10 = this.field_829;
                        boolean var11 = var4.field_829;
                        var3 = false;
                        if(var10 == var11) {
                           boolean var12 = this.field_830;
                           boolean var13 = var4.field_830;
                           var3 = false;
                           if(var12 == var13) {
                              if(this.amU != null && !this.amU.isEmpty()) {
                                 return this.amU.equals(var4.amU);
                              }

                              if(var4.amU != null) {
                                 boolean var14 = var4.amU.isEmpty();
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
         int var2 = 31 * (31 * (31 * (527 + class_602.hashCode(this.field_827)) + this.field_828) + this.name);
         short var3;
         if(this.field_829) {
            var3 = var1;
         } else {
            var3 = 1237;
         }

         int var4 = 31 * (var3 + var2);
         if(!this.field_830) {
            var1 = 1237;
         }

         int var5 = 31 * (var4 + var1);
         int var6;
         if(this.amU != null && !this.amU.isEmpty()) {
            var6 = this.amU.hashCode();
         } else {
            var6 = 0;
         }

         return var6 + var5;
      }
   }

   public static final class class_968 extends mb<class_51.class_968> {
      // $FF: renamed from: eL com.google.android.gms.internal.c$c[]
      private static volatile class_51.class_968[] field_831;
      // $FF: renamed from: eM java.lang.String
      public String field_832;
      // $FF: renamed from: eN long
      public long field_833;
      // $FF: renamed from: eO long
      public long field_834;
      // $FF: renamed from: eP boolean
      public boolean field_835;
      // $FF: renamed from: eQ long
      public long field_836;

      public class_968() {
         this.method_1754();
      }

      // $FF: renamed from: f () com.google.android.gms.internal.c$c[]
      public static class_51.class_968[] method_1752() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         if(!this.field_832.equals("")) {
            var1.method_3521(1, this.field_832);
         }

         if(this.field_833 != 0L) {
            var1.method_3520(2, this.field_833);
         }

         if(this.field_834 != 2147483647L) {
            var1.method_3520(3, this.field_834);
         }

         if(this.field_835) {
            var1.method_3516(4, this.field_835);
         }

         if(this.field_836 != 0L) {
            var1.method_3520(5, this.field_836);
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1753(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = super.method_1723();
         if(!this.field_832.equals("")) {
            var1 += class_601.method_3504(1, this.field_832);
         }

         if(this.field_833 != 0L) {
            var1 += class_601.method_3495(2, this.field_833);
         }

         if(this.field_834 != 2147483647L) {
            var1 += class_601.method_3495(3, this.field_834);
         }

         if(this.field_835) {
            var1 += class_601.method_3489(4, this.field_835);
         }

         if(this.field_836 != 0L) {
            var1 += class_601.method_3495(5, this.field_836);
         }

         return var1;
      }

      // $FF: renamed from: d (com.google.android.gms.internal.lz) com.google.android.gms.internal.c$c
      public class_51.class_968 method_1753(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            switch(var2) {
            case 10:
               this.field_832 = var1.readString();
               break;
            case 16:
               this.field_833 = var1.method_3572();
               break;
            case 24:
               this.field_834 = var1.method_3572();
               break;
            case 32:
               this.field_835 = var1.method_3560();
               break;
            case 40:
               this.field_836 = var1.method_3572();
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
            boolean var2 = var1 instanceof class_51.class_968;
            var3 = false;
            if(var2) {
               class_51.class_968 var4 = (class_51.class_968)var1;
               if(this.field_832 == null) {
                  String var11 = var4.field_832;
                  var3 = false;
                  if(var11 != null) {
                     return var3;
                  }
               } else if(!this.field_832.equals(var4.field_832)) {
                  return false;
               }

               long var12;
               int var5 = (var12 = this.field_833 - var4.field_833) == 0L?0:(var12 < 0L?-1:1);
               var3 = false;
               if(var5 == 0) {
                  long var13;
                  int var6 = (var13 = this.field_834 - var4.field_834) == 0L?0:(var13 < 0L?-1:1);
                  var3 = false;
                  if(var6 == 0) {
                     boolean var7 = this.field_835;
                     boolean var8 = var4.field_835;
                     var3 = false;
                     if(var7 == var8) {
                        long var14;
                        int var9 = (var14 = this.field_836 - var4.field_836) == 0L?0:(var14 < 0L?-1:1);
                        var3 = false;
                        if(var9 == 0) {
                           if(this.amU != null && !this.amU.isEmpty()) {
                              return this.amU.equals(var4.amU);
                           }

                           if(var4.amU != null) {
                              boolean var10 = var4.amU.isEmpty();
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

      // $FF: renamed from: g () com.google.android.gms.internal.c$c
      public class_51.class_968 method_1754() {
         this.field_832 = "";
         this.field_833 = 0L;
         this.field_834 = 2147483647L;
         this.field_835 = false;
         this.field_836 = 0L;
         this.amU = null;
         this.amY = -1;
         return this;
      }

      public int hashCode() {
         int var1;
         if(this.field_832 == null) {
            var1 = 0;
         } else {
            var1 = this.field_832.hashCode();
         }

         int var2 = 31 * (31 * (31 * (var1 + 527) + (int)(this.field_833 ^ this.field_833 >>> 32)) + (int)(this.field_834 ^ this.field_834 >>> 32));
         short var3;
         if(this.field_835) {
            var3 = 1231;
         } else {
            var3 = 1237;
         }

         int var4 = 31 * (31 * (var3 + var2) + (int)(this.field_836 ^ this.field_836 >>> 32));
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
   }

   public static final class class_967 extends mb<class_51.class_967> {
      // $FF: renamed from: eR com.google.android.gms.internal.d$a[]
      public class_52.class_816[] field_837;
      // $FF: renamed from: eS com.google.android.gms.internal.d$a[]
      public class_52.class_816[] field_838;
      // $FF: renamed from: eT com.google.android.gms.internal.c$c[]
      public class_51.class_968[] field_839;

      public class_967() {
         this.method_1756();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         if(this.field_837 != null && this.field_837.length > 0) {
            for(int var7 = 0; var7 < this.field_837.length; ++var7) {
               class_52.class_816 var8 = this.field_837[var7];
               if(var8 != null) {
                  var1.method_3515(1, var8);
               }
            }
         }

         if(this.field_838 != null && this.field_838.length > 0) {
            for(int var5 = 0; var5 < this.field_838.length; ++var5) {
               class_52.class_816 var6 = this.field_838[var5];
               if(var6 != null) {
                  var1.method_3515(2, var6);
               }
            }
         }

         if(this.field_839 != null) {
            int var2 = this.field_839.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.field_839.length; ++var3) {
                  class_51.class_968 var4 = this.field_839[var3];
                  if(var4 != null) {
                     var1.method_3515(3, var4);
                  }
               }
            }
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1755(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = super.method_1723();
         if(this.field_837 != null && this.field_837.length > 0) {
            int var8 = var1;

            for(int var9 = 0; var9 < this.field_837.length; ++var9) {
               class_52.class_816 var10 = this.field_837[var9];
               if(var10 != null) {
                  var8 += class_601.method_3488(1, var10);
               }
            }

            var1 = var8;
         }

         if(this.field_838 != null && this.field_838.length > 0) {
            int var5 = var1;

            for(int var6 = 0; var6 < this.field_838.length; ++var6) {
               class_52.class_816 var7 = this.field_838[var6];
               if(var7 != null) {
                  var5 += class_601.method_3488(2, var7);
               }
            }

            var1 = var5;
         }

         if(this.field_839 != null) {
            int var2 = this.field_839.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.field_839.length; ++var3) {
                  class_51.class_968 var4 = this.field_839[var3];
                  if(var4 != null) {
                     var1 += class_601.method_3488(3, var4);
                  }
               }
            }
         }

         return var1;
      }

      // $FF: renamed from: e (com.google.android.gms.internal.lz) com.google.android.gms.internal.c$d
      public class_51.class_967 method_1755(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            int var12;
            class_52.class_816[] var13;
            switch(var2) {
            case 10:
               int var11 = class_638.method_3656(var1, 10);
               if(this.field_837 == null) {
                  var12 = 0;
               } else {
                  var12 = this.field_837.length;
               }

               var13 = new class_52.class_816[var11 + var12];
               if(var12 != 0) {
                  System.arraycopy(this.field_837, 0, var13, 0, var12);
               }
               break;
            case 18:
               int var7 = class_638.method_3656(var1, 18);
               int var8;
               if(this.field_838 == null) {
                  var8 = 0;
               } else {
                  var8 = this.field_838.length;
               }

               class_52.class_816[] var9 = new class_52.class_816[var7 + var8];
               if(var8 != 0) {
                  System.arraycopy(this.field_838, 0, var9, 0, var8);
               }

               while(var8 < -1 + var9.length) {
                  var9[var8] = new class_52.class_816();
                  var1.method_3551(var9[var8]);
                  var1.method_3570();
                  ++var8;
               }

               var9[var8] = new class_52.class_816();
               var1.method_3551(var9[var8]);
               this.field_838 = var9;
               continue;
            case 26:
               int var3 = class_638.method_3656(var1, 26);
               int var4;
               if(this.field_839 == null) {
                  var4 = 0;
               } else {
                  var4 = this.field_839.length;
               }

               class_51.class_968[] var5 = new class_51.class_968[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.field_839, 0, var5, 0, var4);
               }

               while(var4 < -1 + var5.length) {
                  var5[var4] = new class_51.class_968();
                  var1.method_3551(var5[var4]);
                  var1.method_3570();
                  ++var4;
               }

               var5[var4] = new class_51.class_968();
               var1.method_3551(var5[var4]);
               this.field_839 = var5;
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var12 < -1 + var13.length) {
               var13[var12] = new class_52.class_816();
               var1.method_3551(var13[var12]);
               var1.method_3570();
               ++var12;
            }

            var13[var12] = new class_52.class_816();
            var1.method_3551(var13[var12]);
            this.field_837 = var13;
         }
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_51.class_967;
            var3 = false;
            if(var2) {
               class_51.class_967 var4 = (class_51.class_967)var1;
               boolean var5 = class_602.equals((Object[])this.field_837, (Object[])var4.field_837);
               var3 = false;
               if(var5) {
                  boolean var6 = class_602.equals((Object[])this.field_838, (Object[])var4.field_838);
                  var3 = false;
                  if(var6) {
                     boolean var7 = class_602.equals((Object[])this.field_839, (Object[])var4.field_839);
                     var3 = false;
                     if(var7) {
                        if(this.amU != null && !this.amU.isEmpty()) {
                           return this.amU.equals(var4.amU);
                        }

                        if(var4.amU != null) {
                           boolean var8 = var4.amU.isEmpty();
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

      // $FF: renamed from: h () com.google.android.gms.internal.c$d
      public class_51.class_967 method_1756() {
         this.field_837 = class_52.class_816.method_1777();
         this.field_838 = class_52.class_816.method_1777();
         this.field_839 = class_51.class_968.method_1752();
         this.amU = null;
         this.amY = -1;
         return this;
      }

      public int hashCode() {
         int var1 = 31 * (31 * (31 * (527 + class_602.hashCode((Object[])this.field_837)) + class_602.hashCode((Object[])this.field_838)) + class_602.hashCode((Object[])this.field_839));
         int var2;
         if(this.amU != null && !this.amU.isEmpty()) {
            var2 = this.amU.hashCode();
         } else {
            var2 = 0;
         }

         return var2 + var1;
      }
   }

   public static final class class_966 extends mb<class_51.class_966> {
      // $FF: renamed from: eU com.google.android.gms.internal.c$e[]
      private static volatile class_51.class_966[] field_840;
      public int key;
      public int value;

      public class_966() {
         this.method_1759();
      }

      // $FF: renamed from: i () com.google.android.gms.internal.c$e[]
      public static class_51.class_966[] method_1757() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         var1.method_3535(1, this.key);
         var1.method_3535(2, this.value);
         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1758(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         return super.method_1723() + class_601.method_3506(1, this.key) + class_601.method_3506(2, this.value);
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_51.class_966;
            var3 = false;
            if(var2) {
               class_51.class_966 var4 = (class_51.class_966)var1;
               int var5 = this.key;
               int var6 = var4.key;
               var3 = false;
               if(var5 == var6) {
                  int var7 = this.value;
                  int var8 = var4.value;
                  var3 = false;
                  if(var7 == var8) {
                     if(this.amU != null && !this.amU.isEmpty()) {
                        return this.amU.equals(var4.amU);
                     }

                     if(var4.amU != null) {
                        boolean var9 = var4.amU.isEmpty();
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

      // $FF: renamed from: f (com.google.android.gms.internal.lz) com.google.android.gms.internal.c$e
      public class_51.class_966 method_1758(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            switch(var2) {
            case 8:
               this.key = var1.method_3573();
               break;
            case 16:
               this.value = var1.method_3573();
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
         int var1 = 31 * (31 * (527 + this.key) + this.value);
         int var2;
         if(this.amU != null && !this.amU.isEmpty()) {
            var2 = this.amU.hashCode();
         } else {
            var2 = 0;
         }

         return var2 + var1;
      }

      // $FF: renamed from: j () com.google.android.gms.internal.c$e
      public class_51.class_966 method_1759() {
         this.key = 0;
         this.value = 0;
         this.amU = null;
         this.amY = -1;
         return this;
      }
   }

   public static final class class_965 extends mb<class_51.class_965> {
      // $FF: renamed from: eV java.lang.String[]
      public String[] field_841;
      // $FF: renamed from: eW java.lang.String[]
      public String[] field_842;
      // $FF: renamed from: eX com.google.android.gms.internal.d$a[]
      public class_52.class_816[] field_843;
      // $FF: renamed from: eY com.google.android.gms.internal.c$e[]
      public class_51.class_966[] field_844;
      // $FF: renamed from: eZ com.google.android.gms.internal.c$b[]
      public class_51.class_969[] field_845;
      // $FF: renamed from: fa com.google.android.gms.internal.c$b[]
      public class_51.class_969[] field_846;
      // $FF: renamed from: fb com.google.android.gms.internal.c$b[]
      public class_51.class_969[] field_847;
      // $FF: renamed from: fc com.google.android.gms.internal.c$g[]
      public class_51.class_964[] field_848;
      // $FF: renamed from: fd java.lang.String
      public String field_849;
      // $FF: renamed from: fe java.lang.String
      public String field_850;
      // $FF: renamed from: ff java.lang.String
      public String field_851;
      // $FF: renamed from: fg java.lang.String
      public String field_852;
      // $FF: renamed from: fh com.google.android.gms.internal.c$a
      public class_51.class_972 field_853;
      // $FF: renamed from: fi float
      public float field_854;
      // $FF: renamed from: fj boolean
      public boolean field_855;
      // $FF: renamed from: fk java.lang.String[]
      public String[] field_856;
      // $FF: renamed from: fl int
      public int field_857;

      public class_965() {
         this.method_1762();
      }

      // $FF: renamed from: a (byte[]) com.google.android.gms.internal.c$f
      public static class_51.class_965 method_1760(byte[] var0) throws class_637 {
         return (class_51.class_965)class_246.method_1717(new class_51.class_965(), var0);
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         if(this.field_842 != null && this.field_842.length > 0) {
            for(int var19 = 0; var19 < this.field_842.length; ++var19) {
               String var20 = this.field_842[var19];
               if(var20 != null) {
                  var1.method_3521(1, var20);
               }
            }
         }

         if(this.field_843 != null && this.field_843.length > 0) {
            for(int var17 = 0; var17 < this.field_843.length; ++var17) {
               class_52.class_816 var18 = this.field_843[var17];
               if(var18 != null) {
                  var1.method_3515(2, var18);
               }
            }
         }

         if(this.field_844 != null && this.field_844.length > 0) {
            for(int var15 = 0; var15 < this.field_844.length; ++var15) {
               class_51.class_966 var16 = this.field_844[var15];
               if(var16 != null) {
                  var1.method_3515(3, var16);
               }
            }
         }

         if(this.field_845 != null && this.field_845.length > 0) {
            for(int var13 = 0; var13 < this.field_845.length; ++var13) {
               class_51.class_969 var14 = this.field_845[var13];
               if(var14 != null) {
                  var1.method_3515(4, var14);
               }
            }
         }

         if(this.field_846 != null && this.field_846.length > 0) {
            for(int var11 = 0; var11 < this.field_846.length; ++var11) {
               class_51.class_969 var12 = this.field_846[var11];
               if(var12 != null) {
                  var1.method_3515(5, var12);
               }
            }
         }

         if(this.field_847 != null && this.field_847.length > 0) {
            for(int var9 = 0; var9 < this.field_847.length; ++var9) {
               class_51.class_969 var10 = this.field_847[var9];
               if(var10 != null) {
                  var1.method_3515(6, var10);
               }
            }
         }

         if(this.field_848 != null && this.field_848.length > 0) {
            for(int var7 = 0; var7 < this.field_848.length; ++var7) {
               class_51.class_964 var8 = this.field_848[var7];
               if(var8 != null) {
                  var1.method_3515(7, var8);
               }
            }
         }

         if(!this.field_849.equals("")) {
            var1.method_3521(9, this.field_849);
         }

         if(!this.field_850.equals("")) {
            var1.method_3521(10, this.field_850);
         }

         if(!this.field_851.equals("0")) {
            var1.method_3521(12, this.field_851);
         }

         if(!this.field_852.equals("")) {
            var1.method_3521(13, this.field_852);
         }

         if(this.field_853 != null) {
            var1.method_3515(14, this.field_853);
         }

         if(Float.floatToIntBits(this.field_854) != Float.floatToIntBits(0.0F)) {
            var1.method_3519(15, this.field_854);
         }

         if(this.field_856 != null && this.field_856.length > 0) {
            for(int var5 = 0; var5 < this.field_856.length; ++var5) {
               String var6 = this.field_856[var5];
               if(var6 != null) {
                  var1.method_3521(16, var6);
               }
            }
         }

         if(this.field_857 != 0) {
            var1.method_3535(17, this.field_857);
         }

         if(this.field_855) {
            var1.method_3516(18, this.field_855);
         }

         if(this.field_841 != null) {
            int var2 = this.field_841.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.field_841.length; ++var3) {
                  String var4 = this.field_841[var3];
                  if(var4 != null) {
                     var1.method_3521(19, var4);
                  }
               }
            }
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1761(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = 0;
         int var2 = super.method_1723();
         int var3;
         if(this.field_842 != null && this.field_842.length > 0) {
            int var29 = 0;
            int var30 = 0;

            int var31;
            for(var31 = 0; var29 < this.field_842.length; ++var29) {
               String var32 = this.field_842[var29];
               if(var32 != null) {
                  ++var31;
                  var30 += class_601.method_3494(var32);
               }
            }

            var3 = var2 + var30 + var31 * 1;
         } else {
            var3 = var2;
         }

         if(this.field_843 != null && this.field_843.length > 0) {
            int var26 = var3;

            for(int var27 = 0; var27 < this.field_843.length; ++var27) {
               class_52.class_816 var28 = this.field_843[var27];
               if(var28 != null) {
                  var26 += class_601.method_3488(2, var28);
               }
            }

            var3 = var26;
         }

         if(this.field_844 != null && this.field_844.length > 0) {
            int var23 = var3;

            for(int var24 = 0; var24 < this.field_844.length; ++var24) {
               class_51.class_966 var25 = this.field_844[var24];
               if(var25 != null) {
                  var23 += class_601.method_3488(3, var25);
               }
            }

            var3 = var23;
         }

         if(this.field_845 != null && this.field_845.length > 0) {
            int var20 = var3;

            for(int var21 = 0; var21 < this.field_845.length; ++var21) {
               class_51.class_969 var22 = this.field_845[var21];
               if(var22 != null) {
                  var20 += class_601.method_3488(4, var22);
               }
            }

            var3 = var20;
         }

         if(this.field_846 != null && this.field_846.length > 0) {
            int var17 = var3;

            for(int var18 = 0; var18 < this.field_846.length; ++var18) {
               class_51.class_969 var19 = this.field_846[var18];
               if(var19 != null) {
                  var17 += class_601.method_3488(5, var19);
               }
            }

            var3 = var17;
         }

         if(this.field_847 != null && this.field_847.length > 0) {
            int var14 = var3;

            for(int var15 = 0; var15 < this.field_847.length; ++var15) {
               class_51.class_969 var16 = this.field_847[var15];
               if(var16 != null) {
                  var14 += class_601.method_3488(6, var16);
               }
            }

            var3 = var14;
         }

         if(this.field_848 != null && this.field_848.length > 0) {
            int var11 = var3;

            for(int var12 = 0; var12 < this.field_848.length; ++var12) {
               class_51.class_964 var13 = this.field_848[var12];
               if(var13 != null) {
                  var11 += class_601.method_3488(7, var13);
               }
            }

            var3 = var11;
         }

         if(!this.field_849.equals("")) {
            var3 += class_601.method_3504(9, this.field_849);
         }

         if(!this.field_850.equals("")) {
            var3 += class_601.method_3504(10, this.field_850);
         }

         if(!this.field_851.equals("0")) {
            var3 += class_601.method_3504(12, this.field_851);
         }

         if(!this.field_852.equals("")) {
            var3 += class_601.method_3504(13, this.field_852);
         }

         if(this.field_853 != null) {
            var3 += class_601.method_3488(14, this.field_853);
         }

         if(Float.floatToIntBits(this.field_854) != Float.floatToIntBits(0.0F)) {
            var3 += class_601.method_3492(15, this.field_854);
         }

         if(this.field_856 != null && this.field_856.length > 0) {
            int var7 = 0;
            int var8 = 0;

            int var9;
            for(var9 = 0; var7 < this.field_856.length; ++var7) {
               String var10 = this.field_856[var7];
               if(var10 != null) {
                  ++var9;
                  var8 += class_601.method_3494(var10);
               }
            }

            var3 = var3 + var8 + var9 * 2;
         }

         if(this.field_857 != 0) {
            var3 += class_601.method_3506(17, this.field_857);
         }

         if(this.field_855) {
            var3 += class_601.method_3489(18, this.field_855);
         }

         if(this.field_841 != null && this.field_841.length > 0) {
            int var4 = 0;

            int var5;
            for(var5 = 0; var1 < this.field_841.length; ++var1) {
               String var6 = this.field_841[var1];
               if(var6 != null) {
                  ++var5;
                  var4 += class_601.method_3494(var6);
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
            boolean var2 = var1 instanceof class_51.class_965;
            var3 = false;
            if(var2) {
               class_51.class_965 var4 = (class_51.class_965)var1;
               boolean var5 = class_602.equals((Object[])this.field_841, (Object[])var4.field_841);
               var3 = false;
               if(var5) {
                  boolean var6 = class_602.equals((Object[])this.field_842, (Object[])var4.field_842);
                  var3 = false;
                  if(var6) {
                     boolean var7 = class_602.equals((Object[])this.field_843, (Object[])var4.field_843);
                     var3 = false;
                     if(var7) {
                        boolean var8 = class_602.equals((Object[])this.field_844, (Object[])var4.field_844);
                        var3 = false;
                        if(var8) {
                           boolean var9 = class_602.equals((Object[])this.field_845, (Object[])var4.field_845);
                           var3 = false;
                           if(var9) {
                              boolean var10 = class_602.equals((Object[])this.field_846, (Object[])var4.field_846);
                              var3 = false;
                              if(var10) {
                                 boolean var11 = class_602.equals((Object[])this.field_847, (Object[])var4.field_847);
                                 var3 = false;
                                 if(var11) {
                                    boolean var12 = class_602.equals((Object[])this.field_848, (Object[])var4.field_848);
                                    var3 = false;
                                    if(var12) {
                                       if(this.field_849 == null) {
                                          String var25 = var4.field_849;
                                          var3 = false;
                                          if(var25 != null) {
                                             return var3;
                                          }
                                       } else if(!this.field_849.equals(var4.field_849)) {
                                          return false;
                                       }

                                       if(this.field_850 == null) {
                                          String var24 = var4.field_850;
                                          var3 = false;
                                          if(var24 != null) {
                                             return var3;
                                          }
                                       } else if(!this.field_850.equals(var4.field_850)) {
                                          return false;
                                       }

                                       if(this.field_851 == null) {
                                          String var23 = var4.field_851;
                                          var3 = false;
                                          if(var23 != null) {
                                             return var3;
                                          }
                                       } else if(!this.field_851.equals(var4.field_851)) {
                                          return false;
                                       }

                                       if(this.field_852 == null) {
                                          String var22 = var4.field_852;
                                          var3 = false;
                                          if(var22 != null) {
                                             return var3;
                                          }
                                       } else if(!this.field_852.equals(var4.field_852)) {
                                          return false;
                                       }

                                       if(this.field_853 == null) {
                                          class_51.class_972 var21 = var4.field_853;
                                          var3 = false;
                                          if(var21 != null) {
                                             return var3;
                                          }
                                       } else if(!this.field_853.equals(var4.field_853)) {
                                          return false;
                                       }

                                       int var13 = Float.floatToIntBits(this.field_854);
                                       int var14 = Float.floatToIntBits(var4.field_854);
                                       var3 = false;
                                       if(var13 == var14) {
                                          boolean var15 = this.field_855;
                                          boolean var16 = var4.field_855;
                                          var3 = false;
                                          if(var15 == var16) {
                                             boolean var17 = class_602.equals((Object[])this.field_856, (Object[])var4.field_856);
                                             var3 = false;
                                             if(var17) {
                                                int var18 = this.field_857;
                                                int var19 = var4.field_857;
                                                var3 = false;
                                                if(var18 == var19) {
                                                   if(this.amU != null && !this.amU.isEmpty()) {
                                                      return this.amU.equals(var4.amU);
                                                   }

                                                   if(var4.amU != null) {
                                                      boolean var20 = var4.amU.isEmpty();
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

      // $FF: renamed from: g (com.google.android.gms.internal.lz) com.google.android.gms.internal.c$f
      public class_51.class_965 method_1761(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            int var36;
            String[] var37;
            switch(var2) {
            case 10:
               int var35 = class_638.method_3656(var1, 10);
               if(this.field_842 == null) {
                  var36 = 0;
               } else {
                  var36 = this.field_842.length;
               }

               var37 = new String[var35 + var36];
               if(var36 != 0) {
                  System.arraycopy(this.field_842, 0, var37, 0, var36);
               }
               break;
            case 18:
               int var31 = class_638.method_3656(var1, 18);
               int var32;
               if(this.field_843 == null) {
                  var32 = 0;
               } else {
                  var32 = this.field_843.length;
               }

               class_52.class_816[] var33 = new class_52.class_816[var31 + var32];
               if(var32 != 0) {
                  System.arraycopy(this.field_843, 0, var33, 0, var32);
               }

               while(var32 < -1 + var33.length) {
                  var33[var32] = new class_52.class_816();
                  var1.method_3551(var33[var32]);
                  var1.method_3570();
                  ++var32;
               }

               var33[var32] = new class_52.class_816();
               var1.method_3551(var33[var32]);
               this.field_843 = var33;
               continue;
            case 26:
               int var27 = class_638.method_3656(var1, 26);
               int var28;
               if(this.field_844 == null) {
                  var28 = 0;
               } else {
                  var28 = this.field_844.length;
               }

               class_51.class_966[] var29 = new class_51.class_966[var27 + var28];
               if(var28 != 0) {
                  System.arraycopy(this.field_844, 0, var29, 0, var28);
               }

               while(var28 < -1 + var29.length) {
                  var29[var28] = new class_51.class_966();
                  var1.method_3551(var29[var28]);
                  var1.method_3570();
                  ++var28;
               }

               var29[var28] = new class_51.class_966();
               var1.method_3551(var29[var28]);
               this.field_844 = var29;
               continue;
            case 34:
               int var23 = class_638.method_3656(var1, 34);
               int var24;
               if(this.field_845 == null) {
                  var24 = 0;
               } else {
                  var24 = this.field_845.length;
               }

               class_51.class_969[] var25 = new class_51.class_969[var23 + var24];
               if(var24 != 0) {
                  System.arraycopy(this.field_845, 0, var25, 0, var24);
               }

               while(var24 < -1 + var25.length) {
                  var25[var24] = new class_51.class_969();
                  var1.method_3551(var25[var24]);
                  var1.method_3570();
                  ++var24;
               }

               var25[var24] = new class_51.class_969();
               var1.method_3551(var25[var24]);
               this.field_845 = var25;
               continue;
            case 42:
               int var19 = class_638.method_3656(var1, 42);
               int var20;
               if(this.field_846 == null) {
                  var20 = 0;
               } else {
                  var20 = this.field_846.length;
               }

               class_51.class_969[] var21 = new class_51.class_969[var19 + var20];
               if(var20 != 0) {
                  System.arraycopy(this.field_846, 0, var21, 0, var20);
               }

               while(var20 < -1 + var21.length) {
                  var21[var20] = new class_51.class_969();
                  var1.method_3551(var21[var20]);
                  var1.method_3570();
                  ++var20;
               }

               var21[var20] = new class_51.class_969();
               var1.method_3551(var21[var20]);
               this.field_846 = var21;
               continue;
            case 50:
               int var15 = class_638.method_3656(var1, 50);
               int var16;
               if(this.field_847 == null) {
                  var16 = 0;
               } else {
                  var16 = this.field_847.length;
               }

               class_51.class_969[] var17 = new class_51.class_969[var15 + var16];
               if(var16 != 0) {
                  System.arraycopy(this.field_847, 0, var17, 0, var16);
               }

               while(var16 < -1 + var17.length) {
                  var17[var16] = new class_51.class_969();
                  var1.method_3551(var17[var16]);
                  var1.method_3570();
                  ++var16;
               }

               var17[var16] = new class_51.class_969();
               var1.method_3551(var17[var16]);
               this.field_847 = var17;
               continue;
            case 58:
               int var11 = class_638.method_3656(var1, 58);
               int var12;
               if(this.field_848 == null) {
                  var12 = 0;
               } else {
                  var12 = this.field_848.length;
               }

               class_51.class_964[] var13 = new class_51.class_964[var11 + var12];
               if(var12 != 0) {
                  System.arraycopy(this.field_848, 0, var13, 0, var12);
               }

               while(var12 < -1 + var13.length) {
                  var13[var12] = new class_51.class_964();
                  var1.method_3551(var13[var12]);
                  var1.method_3570();
                  ++var12;
               }

               var13[var12] = new class_51.class_964();
               var1.method_3551(var13[var12]);
               this.field_848 = var13;
               continue;
            case 74:
               this.field_849 = var1.readString();
               continue;
            case 82:
               this.field_850 = var1.readString();
               continue;
            case 98:
               this.field_851 = var1.readString();
               continue;
            case 106:
               this.field_852 = var1.readString();
               continue;
            case 114:
               if(this.field_853 == null) {
                  this.field_853 = new class_51.class_972();
               }

               var1.method_3551(this.field_853);
               continue;
            case 125:
               this.field_854 = var1.readFloat();
               continue;
            case 130:
               int var7 = class_638.method_3656(var1, 130);
               int var8;
               if(this.field_856 == null) {
                  var8 = 0;
               } else {
                  var8 = this.field_856.length;
               }

               String[] var9 = new String[var7 + var8];
               if(var8 != 0) {
                  System.arraycopy(this.field_856, 0, var9, 0, var8);
               }

               while(var8 < -1 + var9.length) {
                  var9[var8] = var1.readString();
                  var1.method_3570();
                  ++var8;
               }

               var9[var8] = var1.readString();
               this.field_856 = var9;
               continue;
            case 136:
               this.field_857 = var1.method_3573();
               continue;
            case 144:
               this.field_855 = var1.method_3560();
               continue;
            case 154:
               int var3 = class_638.method_3656(var1, 154);
               int var4;
               if(this.field_841 == null) {
                  var4 = 0;
               } else {
                  var4 = this.field_841.length;
               }

               String[] var5 = new String[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.field_841, 0, var5, 0, var4);
               }

               while(var4 < -1 + var5.length) {
                  var5[var4] = var1.readString();
                  var1.method_3570();
                  ++var4;
               }

               var5[var4] = var1.readString();
               this.field_841 = var5;
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
               var1.method_3570();
               ++var36;
            }

            var37[var36] = var1.readString();
            this.field_842 = var37;
         }
      }

      public int hashCode() {
         int var1 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + class_602.hashCode((Object[])this.field_841)) + class_602.hashCode((Object[])this.field_842)) + class_602.hashCode((Object[])this.field_843)) + class_602.hashCode((Object[])this.field_844)) + class_602.hashCode((Object[])this.field_845)) + class_602.hashCode((Object[])this.field_846)) + class_602.hashCode((Object[])this.field_847)) + class_602.hashCode((Object[])this.field_848));
         int var2;
         if(this.field_849 == null) {
            var2 = 0;
         } else {
            var2 = this.field_849.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.field_850 == null) {
            var4 = 0;
         } else {
            var4 = this.field_850.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         int var6;
         if(this.field_851 == null) {
            var6 = 0;
         } else {
            var6 = this.field_851.hashCode();
         }

         int var7 = 31 * (var6 + var5);
         int var8;
         if(this.field_852 == null) {
            var8 = 0;
         } else {
            var8 = this.field_852.hashCode();
         }

         int var9 = 31 * (var8 + var7);
         int var10;
         if(this.field_853 == null) {
            var10 = 0;
         } else {
            var10 = this.field_853.hashCode();
         }

         int var11 = 31 * (31 * (var10 + var9) + Float.floatToIntBits(this.field_854));
         short var12;
         if(this.field_855) {
            var12 = 1231;
         } else {
            var12 = 1237;
         }

         int var13 = 31 * (31 * (31 * (var12 + var11) + class_602.hashCode((Object[])this.field_856)) + this.field_857);
         List var14 = this.amU;
         int var15 = 0;
         if(var14 != null) {
            boolean var16 = this.amU.isEmpty();
            var15 = 0;
            if(!var16) {
               var15 = this.amU.hashCode();
            }
         }

         return var13 + var15;
      }

      // $FF: renamed from: k () com.google.android.gms.internal.c$f
      public class_51.class_965 method_1762() {
         this.field_841 = class_638.anf;
         this.field_842 = class_638.anf;
         this.field_843 = class_52.class_816.method_1777();
         this.field_844 = class_51.class_966.method_1757();
         this.field_845 = class_51.class_969.method_1749();
         this.field_846 = class_51.class_969.method_1749();
         this.field_847 = class_51.class_969.method_1749();
         this.field_848 = class_51.class_964.method_1763();
         this.field_849 = "";
         this.field_850 = "";
         this.field_851 = "0";
         this.field_852 = "";
         this.field_853 = null;
         this.field_854 = 0.0F;
         this.field_855 = false;
         this.field_856 = class_638.anf;
         this.field_857 = 0;
         this.amU = null;
         this.amY = -1;
         return this;
      }
   }

   public static final class class_964 extends mb<class_51.class_964> {
      // $FF: renamed from: fm com.google.android.gms.internal.c$g[]
      private static volatile class_51.class_964[] field_858;
      // $FF: renamed from: fn int[]
      public int[] field_859;
      // $FF: renamed from: fo int[]
      public int[] field_860;
      // $FF: renamed from: fp int[]
      public int[] field_861;
      // $FF: renamed from: fq int[]
      public int[] field_862;
      // $FF: renamed from: fr int[]
      public int[] field_863;
      // $FF: renamed from: fs int[]
      public int[] field_864;
      // $FF: renamed from: ft int[]
      public int[] field_865;
      // $FF: renamed from: fu int[]
      public int[] field_866;
      // $FF: renamed from: fv int[]
      public int[] field_867;
      // $FF: renamed from: fw int[]
      public int[] field_868;

      public class_964() {
         this.method_1765();
      }

      // $FF: renamed from: l () com.google.android.gms.internal.c$g[]
      public static class_51.class_964[] method_1763() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         if(this.field_859 != null && this.field_859.length > 0) {
            for(int var12 = 0; var12 < this.field_859.length; ++var12) {
               var1.method_3535(1, this.field_859[var12]);
            }
         }

         if(this.field_860 != null && this.field_860.length > 0) {
            for(int var11 = 0; var11 < this.field_860.length; ++var11) {
               var1.method_3535(2, this.field_860[var11]);
            }
         }

         if(this.field_861 != null && this.field_861.length > 0) {
            for(int var10 = 0; var10 < this.field_861.length; ++var10) {
               var1.method_3535(3, this.field_861[var10]);
            }
         }

         if(this.field_862 != null && this.field_862.length > 0) {
            for(int var9 = 0; var9 < this.field_862.length; ++var9) {
               var1.method_3535(4, this.field_862[var9]);
            }
         }

         if(this.field_863 != null && this.field_863.length > 0) {
            for(int var8 = 0; var8 < this.field_863.length; ++var8) {
               var1.method_3535(5, this.field_863[var8]);
            }
         }

         if(this.field_864 != null && this.field_864.length > 0) {
            for(int var7 = 0; var7 < this.field_864.length; ++var7) {
               var1.method_3535(6, this.field_864[var7]);
            }
         }

         if(this.field_865 != null && this.field_865.length > 0) {
            for(int var6 = 0; var6 < this.field_865.length; ++var6) {
               var1.method_3535(7, this.field_865[var6]);
            }
         }

         if(this.field_866 != null && this.field_866.length > 0) {
            for(int var5 = 0; var5 < this.field_866.length; ++var5) {
               var1.method_3535(8, this.field_866[var5]);
            }
         }

         if(this.field_867 != null && this.field_867.length > 0) {
            for(int var4 = 0; var4 < this.field_867.length; ++var4) {
               var1.method_3535(9, this.field_867[var4]);
            }
         }

         if(this.field_868 != null) {
            int var2 = this.field_868.length;
            int var3 = 0;
            if(var2 > 0) {
               while(var3 < this.field_868.length) {
                  var1.method_3535(10, this.field_868[var3]);
                  ++var3;
               }
            }
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1764(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = 0;
         int var2 = super.method_1723();
         int var3;
         if(this.field_859 != null && this.field_859.length > 0) {
            int var21 = 0;

            int var22;
            for(var22 = 0; var21 < this.field_859.length; ++var21) {
               var22 += class_601.method_3498(this.field_859[var21]);
            }

            var3 = var2 + var22 + 1 * this.field_859.length;
         } else {
            var3 = var2;
         }

         if(this.field_860 != null && this.field_860.length > 0) {
            int var19 = 0;

            int var20;
            for(var20 = 0; var19 < this.field_860.length; ++var19) {
               var20 += class_601.method_3498(this.field_860[var19]);
            }

            var3 = var3 + var20 + 1 * this.field_860.length;
         }

         if(this.field_861 != null && this.field_861.length > 0) {
            int var17 = 0;

            int var18;
            for(var18 = 0; var17 < this.field_861.length; ++var17) {
               var18 += class_601.method_3498(this.field_861[var17]);
            }

            var3 = var3 + var18 + 1 * this.field_861.length;
         }

         if(this.field_862 != null && this.field_862.length > 0) {
            int var15 = 0;

            int var16;
            for(var16 = 0; var15 < this.field_862.length; ++var15) {
               var16 += class_601.method_3498(this.field_862[var15]);
            }

            var3 = var3 + var16 + 1 * this.field_862.length;
         }

         if(this.field_863 != null && this.field_863.length > 0) {
            int var13 = 0;

            int var14;
            for(var14 = 0; var13 < this.field_863.length; ++var13) {
               var14 += class_601.method_3498(this.field_863[var13]);
            }

            var3 = var3 + var14 + 1 * this.field_863.length;
         }

         if(this.field_864 != null && this.field_864.length > 0) {
            int var11 = 0;

            int var12;
            for(var12 = 0; var11 < this.field_864.length; ++var11) {
               var12 += class_601.method_3498(this.field_864[var11]);
            }

            var3 = var3 + var12 + 1 * this.field_864.length;
         }

         if(this.field_865 != null && this.field_865.length > 0) {
            int var9 = 0;

            int var10;
            for(var10 = 0; var9 < this.field_865.length; ++var9) {
               var10 += class_601.method_3498(this.field_865[var9]);
            }

            var3 = var3 + var10 + 1 * this.field_865.length;
         }

         if(this.field_866 != null && this.field_866.length > 0) {
            int var7 = 0;

            int var8;
            for(var8 = 0; var7 < this.field_866.length; ++var7) {
               var8 += class_601.method_3498(this.field_866[var7]);
            }

            var3 = var3 + var8 + 1 * this.field_866.length;
         }

         if(this.field_867 != null && this.field_867.length > 0) {
            int var5 = 0;

            int var6;
            for(var6 = 0; var5 < this.field_867.length; ++var5) {
               var6 += class_601.method_3498(this.field_867[var5]);
            }

            var3 = var3 + var6 + 1 * this.field_867.length;
         }

         if(this.field_868 != null && this.field_868.length > 0) {
            int var4;
            for(var4 = 0; var1 < this.field_868.length; ++var1) {
               var4 += class_601.method_3498(this.field_868[var1]);
            }

            var3 = var3 + var4 + 1 * this.field_868.length;
         }

         return var3;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_51.class_964;
            var3 = false;
            if(var2) {
               class_51.class_964 var4 = (class_51.class_964)var1;
               boolean var5 = class_602.equals(this.field_859, var4.field_859);
               var3 = false;
               if(var5) {
                  boolean var6 = class_602.equals(this.field_860, var4.field_860);
                  var3 = false;
                  if(var6) {
                     boolean var7 = class_602.equals(this.field_861, var4.field_861);
                     var3 = false;
                     if(var7) {
                        boolean var8 = class_602.equals(this.field_862, var4.field_862);
                        var3 = false;
                        if(var8) {
                           boolean var9 = class_602.equals(this.field_863, var4.field_863);
                           var3 = false;
                           if(var9) {
                              boolean var10 = class_602.equals(this.field_864, var4.field_864);
                              var3 = false;
                              if(var10) {
                                 boolean var11 = class_602.equals(this.field_865, var4.field_865);
                                 var3 = false;
                                 if(var11) {
                                    boolean var12 = class_602.equals(this.field_866, var4.field_866);
                                    var3 = false;
                                    if(var12) {
                                       boolean var13 = class_602.equals(this.field_867, var4.field_867);
                                       var3 = false;
                                       if(var13) {
                                          boolean var14 = class_602.equals(this.field_868, var4.field_868);
                                          var3 = false;
                                          if(var14) {
                                             if(this.amU != null && !this.amU.isEmpty()) {
                                                return this.amU.equals(var4.amU);
                                             }

                                             if(var4.amU == null) {
                                                return true;
                                             }

                                             boolean var15 = var4.amU.isEmpty();
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

      // $FF: renamed from: h (com.google.android.gms.internal.lz) com.google.android.gms.internal.c$g
      public class_51.class_964 method_1764(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            int var100;
            int[] var101;
            switch(var2) {
            case 8:
               int var99 = class_638.method_3656(var1, 8);
               if(this.field_859 == null) {
                  var100 = 0;
               } else {
                  var100 = this.field_859.length;
               }

               var101 = new int[var99 + var100];
               if(var100 != 0) {
                  System.arraycopy(this.field_859, 0, var101, 0, var100);
               }
               break;
            case 10:
               int var93 = var1.method_3557(var1.method_3563());
               int var94 = var1.getPosition();

               int var95;
               for(var95 = 0; var1.method_3567() > 0; ++var95) {
                  var1.method_3573();
               }

               var1.method_3559(var94);
               int var96;
               if(this.field_859 == null) {
                  var96 = 0;
               } else {
                  var96 = this.field_859.length;
               }

               int[] var97 = new int[var95 + var96];
               if(var96 != 0) {
                  System.arraycopy(this.field_859, 0, var97, 0, var96);
               }

               while(var96 < var97.length) {
                  var97[var96] = var1.method_3573();
                  ++var96;
               }

               this.field_859 = var97;
               var1.method_3558(var93);
               continue;
            case 16:
               int var89 = class_638.method_3656(var1, 16);
               int var90;
               if(this.field_860 == null) {
                  var90 = 0;
               } else {
                  var90 = this.field_860.length;
               }

               int[] var91 = new int[var89 + var90];
               if(var90 != 0) {
                  System.arraycopy(this.field_860, 0, var91, 0, var90);
               }

               while(var90 < -1 + var91.length) {
                  var91[var90] = var1.method_3573();
                  var1.method_3570();
                  ++var90;
               }

               var91[var90] = var1.method_3573();
               this.field_860 = var91;
               continue;
            case 18:
               int var83 = var1.method_3557(var1.method_3563());
               int var84 = var1.getPosition();

               int var85;
               for(var85 = 0; var1.method_3567() > 0; ++var85) {
                  var1.method_3573();
               }

               var1.method_3559(var84);
               int var86;
               if(this.field_860 == null) {
                  var86 = 0;
               } else {
                  var86 = this.field_860.length;
               }

               int[] var87 = new int[var85 + var86];
               if(var86 != 0) {
                  System.arraycopy(this.field_860, 0, var87, 0, var86);
               }

               while(var86 < var87.length) {
                  var87[var86] = var1.method_3573();
                  ++var86;
               }

               this.field_860 = var87;
               var1.method_3558(var83);
               continue;
            case 24:
               int var79 = class_638.method_3656(var1, 24);
               int var80;
               if(this.field_861 == null) {
                  var80 = 0;
               } else {
                  var80 = this.field_861.length;
               }

               int[] var81 = new int[var79 + var80];
               if(var80 != 0) {
                  System.arraycopy(this.field_861, 0, var81, 0, var80);
               }

               while(var80 < -1 + var81.length) {
                  var81[var80] = var1.method_3573();
                  var1.method_3570();
                  ++var80;
               }

               var81[var80] = var1.method_3573();
               this.field_861 = var81;
               continue;
            case 26:
               int var73 = var1.method_3557(var1.method_3563());
               int var74 = var1.getPosition();

               int var75;
               for(var75 = 0; var1.method_3567() > 0; ++var75) {
                  var1.method_3573();
               }

               var1.method_3559(var74);
               int var76;
               if(this.field_861 == null) {
                  var76 = 0;
               } else {
                  var76 = this.field_861.length;
               }

               int[] var77 = new int[var75 + var76];
               if(var76 != 0) {
                  System.arraycopy(this.field_861, 0, var77, 0, var76);
               }

               while(var76 < var77.length) {
                  var77[var76] = var1.method_3573();
                  ++var76;
               }

               this.field_861 = var77;
               var1.method_3558(var73);
               continue;
            case 32:
               int var69 = class_638.method_3656(var1, 32);
               int var70;
               if(this.field_862 == null) {
                  var70 = 0;
               } else {
                  var70 = this.field_862.length;
               }

               int[] var71 = new int[var69 + var70];
               if(var70 != 0) {
                  System.arraycopy(this.field_862, 0, var71, 0, var70);
               }

               while(var70 < -1 + var71.length) {
                  var71[var70] = var1.method_3573();
                  var1.method_3570();
                  ++var70;
               }

               var71[var70] = var1.method_3573();
               this.field_862 = var71;
               continue;
            case 34:
               int var63 = var1.method_3557(var1.method_3563());
               int var64 = var1.getPosition();

               int var65;
               for(var65 = 0; var1.method_3567() > 0; ++var65) {
                  var1.method_3573();
               }

               var1.method_3559(var64);
               int var66;
               if(this.field_862 == null) {
                  var66 = 0;
               } else {
                  var66 = this.field_862.length;
               }

               int[] var67 = new int[var65 + var66];
               if(var66 != 0) {
                  System.arraycopy(this.field_862, 0, var67, 0, var66);
               }

               while(var66 < var67.length) {
                  var67[var66] = var1.method_3573();
                  ++var66;
               }

               this.field_862 = var67;
               var1.method_3558(var63);
               continue;
            case 40:
               int var59 = class_638.method_3656(var1, 40);
               int var60;
               if(this.field_863 == null) {
                  var60 = 0;
               } else {
                  var60 = this.field_863.length;
               }

               int[] var61 = new int[var59 + var60];
               if(var60 != 0) {
                  System.arraycopy(this.field_863, 0, var61, 0, var60);
               }

               while(var60 < -1 + var61.length) {
                  var61[var60] = var1.method_3573();
                  var1.method_3570();
                  ++var60;
               }

               var61[var60] = var1.method_3573();
               this.field_863 = var61;
               continue;
            case 42:
               int var53 = var1.method_3557(var1.method_3563());
               int var54 = var1.getPosition();

               int var55;
               for(var55 = 0; var1.method_3567() > 0; ++var55) {
                  var1.method_3573();
               }

               var1.method_3559(var54);
               int var56;
               if(this.field_863 == null) {
                  var56 = 0;
               } else {
                  var56 = this.field_863.length;
               }

               int[] var57 = new int[var55 + var56];
               if(var56 != 0) {
                  System.arraycopy(this.field_863, 0, var57, 0, var56);
               }

               while(var56 < var57.length) {
                  var57[var56] = var1.method_3573();
                  ++var56;
               }

               this.field_863 = var57;
               var1.method_3558(var53);
               continue;
            case 48:
               int var49 = class_638.method_3656(var1, 48);
               int var50;
               if(this.field_864 == null) {
                  var50 = 0;
               } else {
                  var50 = this.field_864.length;
               }

               int[] var51 = new int[var49 + var50];
               if(var50 != 0) {
                  System.arraycopy(this.field_864, 0, var51, 0, var50);
               }

               while(var50 < -1 + var51.length) {
                  var51[var50] = var1.method_3573();
                  var1.method_3570();
                  ++var50;
               }

               var51[var50] = var1.method_3573();
               this.field_864 = var51;
               continue;
            case 50:
               int var43 = var1.method_3557(var1.method_3563());
               int var44 = var1.getPosition();

               int var45;
               for(var45 = 0; var1.method_3567() > 0; ++var45) {
                  var1.method_3573();
               }

               var1.method_3559(var44);
               int var46;
               if(this.field_864 == null) {
                  var46 = 0;
               } else {
                  var46 = this.field_864.length;
               }

               int[] var47 = new int[var45 + var46];
               if(var46 != 0) {
                  System.arraycopy(this.field_864, 0, var47, 0, var46);
               }

               while(var46 < var47.length) {
                  var47[var46] = var1.method_3573();
                  ++var46;
               }

               this.field_864 = var47;
               var1.method_3558(var43);
               continue;
            case 56:
               int var39 = class_638.method_3656(var1, 56);
               int var40;
               if(this.field_865 == null) {
                  var40 = 0;
               } else {
                  var40 = this.field_865.length;
               }

               int[] var41 = new int[var39 + var40];
               if(var40 != 0) {
                  System.arraycopy(this.field_865, 0, var41, 0, var40);
               }

               while(var40 < -1 + var41.length) {
                  var41[var40] = var1.method_3573();
                  var1.method_3570();
                  ++var40;
               }

               var41[var40] = var1.method_3573();
               this.field_865 = var41;
               continue;
            case 58:
               int var33 = var1.method_3557(var1.method_3563());
               int var34 = var1.getPosition();

               int var35;
               for(var35 = 0; var1.method_3567() > 0; ++var35) {
                  var1.method_3573();
               }

               var1.method_3559(var34);
               int var36;
               if(this.field_865 == null) {
                  var36 = 0;
               } else {
                  var36 = this.field_865.length;
               }

               int[] var37 = new int[var35 + var36];
               if(var36 != 0) {
                  System.arraycopy(this.field_865, 0, var37, 0, var36);
               }

               while(var36 < var37.length) {
                  var37[var36] = var1.method_3573();
                  ++var36;
               }

               this.field_865 = var37;
               var1.method_3558(var33);
               continue;
            case 64:
               int var29 = class_638.method_3656(var1, 64);
               int var30;
               if(this.field_866 == null) {
                  var30 = 0;
               } else {
                  var30 = this.field_866.length;
               }

               int[] var31 = new int[var29 + var30];
               if(var30 != 0) {
                  System.arraycopy(this.field_866, 0, var31, 0, var30);
               }

               while(var30 < -1 + var31.length) {
                  var31[var30] = var1.method_3573();
                  var1.method_3570();
                  ++var30;
               }

               var31[var30] = var1.method_3573();
               this.field_866 = var31;
               continue;
            case 66:
               int var23 = var1.method_3557(var1.method_3563());
               int var24 = var1.getPosition();

               int var25;
               for(var25 = 0; var1.method_3567() > 0; ++var25) {
                  var1.method_3573();
               }

               var1.method_3559(var24);
               int var26;
               if(this.field_866 == null) {
                  var26 = 0;
               } else {
                  var26 = this.field_866.length;
               }

               int[] var27 = new int[var25 + var26];
               if(var26 != 0) {
                  System.arraycopy(this.field_866, 0, var27, 0, var26);
               }

               while(var26 < var27.length) {
                  var27[var26] = var1.method_3573();
                  ++var26;
               }

               this.field_866 = var27;
               var1.method_3558(var23);
               continue;
            case 72:
               int var19 = class_638.method_3656(var1, 72);
               int var20;
               if(this.field_867 == null) {
                  var20 = 0;
               } else {
                  var20 = this.field_867.length;
               }

               int[] var21 = new int[var19 + var20];
               if(var20 != 0) {
                  System.arraycopy(this.field_867, 0, var21, 0, var20);
               }

               while(var20 < -1 + var21.length) {
                  var21[var20] = var1.method_3573();
                  var1.method_3570();
                  ++var20;
               }

               var21[var20] = var1.method_3573();
               this.field_867 = var21;
               continue;
            case 74:
               int var13 = var1.method_3557(var1.method_3563());
               int var14 = var1.getPosition();

               int var15;
               for(var15 = 0; var1.method_3567() > 0; ++var15) {
                  var1.method_3573();
               }

               var1.method_3559(var14);
               int var16;
               if(this.field_867 == null) {
                  var16 = 0;
               } else {
                  var16 = this.field_867.length;
               }

               int[] var17 = new int[var15 + var16];
               if(var16 != 0) {
                  System.arraycopy(this.field_867, 0, var17, 0, var16);
               }

               while(var16 < var17.length) {
                  var17[var16] = var1.method_3573();
                  ++var16;
               }

               this.field_867 = var17;
               var1.method_3558(var13);
               continue;
            case 80:
               int var9 = class_638.method_3656(var1, 80);
               int var10;
               if(this.field_868 == null) {
                  var10 = 0;
               } else {
                  var10 = this.field_868.length;
               }

               int[] var11 = new int[var9 + var10];
               if(var10 != 0) {
                  System.arraycopy(this.field_868, 0, var11, 0, var10);
               }

               while(var10 < -1 + var11.length) {
                  var11[var10] = var1.method_3573();
                  var1.method_3570();
                  ++var10;
               }

               var11[var10] = var1.method_3573();
               this.field_868 = var11;
               continue;
            case 82:
               int var3 = var1.method_3557(var1.method_3563());
               int var4 = var1.getPosition();

               int var5;
               for(var5 = 0; var1.method_3567() > 0; ++var5) {
                  var1.method_3573();
               }

               var1.method_3559(var4);
               int var6;
               if(this.field_868 == null) {
                  var6 = 0;
               } else {
                  var6 = this.field_868.length;
               }

               int[] var7 = new int[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.field_868, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.method_3573();
                  ++var6;
               }

               this.field_868 = var7;
               var1.method_3558(var3);
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var100 < -1 + var101.length) {
               var101[var100] = var1.method_3573();
               var1.method_3570();
               ++var100;
            }

            var101[var100] = var1.method_3573();
            this.field_859 = var101;
         }
      }

      public int hashCode() {
         int var1 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + class_602.hashCode(this.field_859)) + class_602.hashCode(this.field_860)) + class_602.hashCode(this.field_861)) + class_602.hashCode(this.field_862)) + class_602.hashCode(this.field_863)) + class_602.hashCode(this.field_864)) + class_602.hashCode(this.field_865)) + class_602.hashCode(this.field_866)) + class_602.hashCode(this.field_867)) + class_602.hashCode(this.field_868));
         int var2;
         if(this.amU != null && !this.amU.isEmpty()) {
            var2 = this.amU.hashCode();
         } else {
            var2 = 0;
         }

         return var2 + var1;
      }

      // $FF: renamed from: m () com.google.android.gms.internal.c$g
      public class_51.class_964 method_1765() {
         this.field_859 = class_638.ana;
         this.field_860 = class_638.ana;
         this.field_861 = class_638.ana;
         this.field_862 = class_638.ana;
         this.field_863 = class_638.ana;
         this.field_864 = class_638.ana;
         this.field_865 = class_638.ana;
         this.field_866 = class_638.ana;
         this.field_867 = class_638.ana;
         this.field_868 = class_638.ana;
         this.amU = null;
         this.amY = -1;
         return this;
      }
   }

   public static final class class_963 extends mb<class_51.class_963> {
      // $FF: renamed from: fx com.google.android.gms.internal.mc
      public static final mc<class_52.class_816, class_51.class_963> field_869 = class_603.method_3540(11, class_51.class_963.class, 810);
      // $FF: renamed from: fy com.google.android.gms.internal.c$h[]
      private static final class_51.class_963[] field_870 = new class_51.class_963[0];
      // $FF: renamed from: fA int[]
      public int[] field_871;
      // $FF: renamed from: fB int[]
      public int[] field_872;
      // $FF: renamed from: fC int
      public int field_873;
      // $FF: renamed from: fD int[]
      public int[] field_874;
      // $FF: renamed from: fE int
      public int field_875;
      // $FF: renamed from: fF int
      public int field_876;
      // $FF: renamed from: fz int[]
      public int[] field_877;

      public class_963() {
         this.method_1767();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         if(this.field_877 != null && this.field_877.length > 0) {
            for(int var6 = 0; var6 < this.field_877.length; ++var6) {
               var1.method_3535(1, this.field_877[var6]);
            }
         }

         if(this.field_871 != null && this.field_871.length > 0) {
            for(int var5 = 0; var5 < this.field_871.length; ++var5) {
               var1.method_3535(2, this.field_871[var5]);
            }
         }

         if(this.field_872 != null && this.field_872.length > 0) {
            for(int var4 = 0; var4 < this.field_872.length; ++var4) {
               var1.method_3535(3, this.field_872[var4]);
            }
         }

         if(this.field_873 != 0) {
            var1.method_3535(4, this.field_873);
         }

         if(this.field_874 != null) {
            int var2 = this.field_874.length;
            int var3 = 0;
            if(var2 > 0) {
               while(var3 < this.field_874.length) {
                  var1.method_3535(5, this.field_874[var3]);
                  ++var3;
               }
            }
         }

         if(this.field_875 != 0) {
            var1.method_3535(6, this.field_875);
         }

         if(this.field_876 != 0) {
            var1.method_3535(7, this.field_876);
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1766(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = 0;
         int var2 = super.method_1723();
         int var3;
         if(this.field_877 != null && this.field_877.length > 0) {
            int var9 = 0;

            int var10;
            for(var10 = 0; var9 < this.field_877.length; ++var9) {
               var10 += class_601.method_3498(this.field_877[var9]);
            }

            var3 = var2 + var10 + 1 * this.field_877.length;
         } else {
            var3 = var2;
         }

         if(this.field_871 != null && this.field_871.length > 0) {
            int var7 = 0;

            int var8;
            for(var8 = 0; var7 < this.field_871.length; ++var7) {
               var8 += class_601.method_3498(this.field_871[var7]);
            }

            var3 = var3 + var8 + 1 * this.field_871.length;
         }

         if(this.field_872 != null && this.field_872.length > 0) {
            int var5 = 0;

            int var6;
            for(var6 = 0; var5 < this.field_872.length; ++var5) {
               var6 += class_601.method_3498(this.field_872[var5]);
            }

            var3 = var3 + var6 + 1 * this.field_872.length;
         }

         if(this.field_873 != 0) {
            var3 += class_601.method_3506(4, this.field_873);
         }

         if(this.field_874 != null && this.field_874.length > 0) {
            int var4;
            for(var4 = 0; var1 < this.field_874.length; ++var1) {
               var4 += class_601.method_3498(this.field_874[var1]);
            }

            var3 = var3 + var4 + 1 * this.field_874.length;
         }

         if(this.field_875 != 0) {
            var3 += class_601.method_3506(6, this.field_875);
         }

         if(this.field_876 != 0) {
            var3 += class_601.method_3506(7, this.field_876);
         }

         return var3;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_51.class_963;
            var3 = false;
            if(var2) {
               class_51.class_963 var4 = (class_51.class_963)var1;
               boolean var5 = class_602.equals(this.field_877, var4.field_877);
               var3 = false;
               if(var5) {
                  boolean var6 = class_602.equals(this.field_871, var4.field_871);
                  var3 = false;
                  if(var6) {
                     boolean var7 = class_602.equals(this.field_872, var4.field_872);
                     var3 = false;
                     if(var7) {
                        int var8 = this.field_873;
                        int var9 = var4.field_873;
                        var3 = false;
                        if(var8 == var9) {
                           boolean var10 = class_602.equals(this.field_874, var4.field_874);
                           var3 = false;
                           if(var10) {
                              int var11 = this.field_875;
                              int var12 = var4.field_875;
                              var3 = false;
                              if(var11 == var12) {
                                 int var13 = this.field_876;
                                 int var14 = var4.field_876;
                                 var3 = false;
                                 if(var13 == var14) {
                                    if(this.amU != null && !this.amU.isEmpty()) {
                                       return this.amU.equals(var4.amU);
                                    }

                                    if(var4.amU == null) {
                                       return true;
                                    }

                                    boolean var15 = var4.amU.isEmpty();
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
         int var1 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + class_602.hashCode(this.field_877)) + class_602.hashCode(this.field_871)) + class_602.hashCode(this.field_872)) + this.field_873) + class_602.hashCode(this.field_874)) + this.field_875) + this.field_876);
         int var2;
         if(this.amU != null && !this.amU.isEmpty()) {
            var2 = this.amU.hashCode();
         } else {
            var2 = 0;
         }

         return var2 + var1;
      }

      // $FF: renamed from: i (com.google.android.gms.internal.lz) com.google.android.gms.internal.c$h
      public class_51.class_963 method_1766(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            int var40;
            int[] var41;
            switch(var2) {
            case 8:
               int var39 = class_638.method_3656(var1, 8);
               if(this.field_877 == null) {
                  var40 = 0;
               } else {
                  var40 = this.field_877.length;
               }

               var41 = new int[var39 + var40];
               if(var40 != 0) {
                  System.arraycopy(this.field_877, 0, var41, 0, var40);
               }
               break;
            case 10:
               int var33 = var1.method_3557(var1.method_3563());
               int var34 = var1.getPosition();

               int var35;
               for(var35 = 0; var1.method_3567() > 0; ++var35) {
                  var1.method_3573();
               }

               var1.method_3559(var34);
               int var36;
               if(this.field_877 == null) {
                  var36 = 0;
               } else {
                  var36 = this.field_877.length;
               }

               int[] var37 = new int[var35 + var36];
               if(var36 != 0) {
                  System.arraycopy(this.field_877, 0, var37, 0, var36);
               }

               while(var36 < var37.length) {
                  var37[var36] = var1.method_3573();
                  ++var36;
               }

               this.field_877 = var37;
               var1.method_3558(var33);
               continue;
            case 16:
               int var29 = class_638.method_3656(var1, 16);
               int var30;
               if(this.field_871 == null) {
                  var30 = 0;
               } else {
                  var30 = this.field_871.length;
               }

               int[] var31 = new int[var29 + var30];
               if(var30 != 0) {
                  System.arraycopy(this.field_871, 0, var31, 0, var30);
               }

               while(var30 < -1 + var31.length) {
                  var31[var30] = var1.method_3573();
                  var1.method_3570();
                  ++var30;
               }

               var31[var30] = var1.method_3573();
               this.field_871 = var31;
               continue;
            case 18:
               int var23 = var1.method_3557(var1.method_3563());
               int var24 = var1.getPosition();

               int var25;
               for(var25 = 0; var1.method_3567() > 0; ++var25) {
                  var1.method_3573();
               }

               var1.method_3559(var24);
               int var26;
               if(this.field_871 == null) {
                  var26 = 0;
               } else {
                  var26 = this.field_871.length;
               }

               int[] var27 = new int[var25 + var26];
               if(var26 != 0) {
                  System.arraycopy(this.field_871, 0, var27, 0, var26);
               }

               while(var26 < var27.length) {
                  var27[var26] = var1.method_3573();
                  ++var26;
               }

               this.field_871 = var27;
               var1.method_3558(var23);
               continue;
            case 24:
               int var19 = class_638.method_3656(var1, 24);
               int var20;
               if(this.field_872 == null) {
                  var20 = 0;
               } else {
                  var20 = this.field_872.length;
               }

               int[] var21 = new int[var19 + var20];
               if(var20 != 0) {
                  System.arraycopy(this.field_872, 0, var21, 0, var20);
               }

               while(var20 < -1 + var21.length) {
                  var21[var20] = var1.method_3573();
                  var1.method_3570();
                  ++var20;
               }

               var21[var20] = var1.method_3573();
               this.field_872 = var21;
               continue;
            case 26:
               int var13 = var1.method_3557(var1.method_3563());
               int var14 = var1.getPosition();

               int var15;
               for(var15 = 0; var1.method_3567() > 0; ++var15) {
                  var1.method_3573();
               }

               var1.method_3559(var14);
               int var16;
               if(this.field_872 == null) {
                  var16 = 0;
               } else {
                  var16 = this.field_872.length;
               }

               int[] var17 = new int[var15 + var16];
               if(var16 != 0) {
                  System.arraycopy(this.field_872, 0, var17, 0, var16);
               }

               while(var16 < var17.length) {
                  var17[var16] = var1.method_3573();
                  ++var16;
               }

               this.field_872 = var17;
               var1.method_3558(var13);
               continue;
            case 32:
               this.field_873 = var1.method_3573();
               continue;
            case 40:
               int var9 = class_638.method_3656(var1, 40);
               int var10;
               if(this.field_874 == null) {
                  var10 = 0;
               } else {
                  var10 = this.field_874.length;
               }

               int[] var11 = new int[var9 + var10];
               if(var10 != 0) {
                  System.arraycopy(this.field_874, 0, var11, 0, var10);
               }

               while(var10 < -1 + var11.length) {
                  var11[var10] = var1.method_3573();
                  var1.method_3570();
                  ++var10;
               }

               var11[var10] = var1.method_3573();
               this.field_874 = var11;
               continue;
            case 42:
               int var3 = var1.method_3557(var1.method_3563());
               int var4 = var1.getPosition();

               int var5;
               for(var5 = 0; var1.method_3567() > 0; ++var5) {
                  var1.method_3573();
               }

               var1.method_3559(var4);
               int var6;
               if(this.field_874 == null) {
                  var6 = 0;
               } else {
                  var6 = this.field_874.length;
               }

               int[] var7 = new int[var5 + var6];
               if(var6 != 0) {
                  System.arraycopy(this.field_874, 0, var7, 0, var6);
               }

               while(var6 < var7.length) {
                  var7[var6] = var1.method_3573();
                  ++var6;
               }

               this.field_874 = var7;
               var1.method_3558(var3);
               continue;
            case 48:
               this.field_875 = var1.method_3573();
               continue;
            case 56:
               this.field_876 = var1.method_3573();
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var40 < -1 + var41.length) {
               var41[var40] = var1.method_3573();
               var1.method_3570();
               ++var40;
            }

            var41[var40] = var1.method_3573();
            this.field_877 = var41;
         }
      }

      // $FF: renamed from: n () com.google.android.gms.internal.c$h
      public class_51.class_963 method_1767() {
         this.field_877 = class_638.ana;
         this.field_871 = class_638.ana;
         this.field_872 = class_638.ana;
         this.field_873 = 0;
         this.field_874 = class_638.ana;
         this.field_875 = 0;
         this.field_876 = 0;
         this.amU = null;
         this.amY = -1;
         return this;
      }
   }

   public static final class class_960 extends mb<class_51.class_960> {
      // $FF: renamed from: fG com.google.android.gms.internal.c$i[]
      private static volatile class_51.class_960[] field_881;
      // $FF: renamed from: fH com.google.android.gms.internal.d$a
      public class_52.class_816 field_882;
      // $FF: renamed from: fI com.google.android.gms.internal.c$d
      public class_51.class_967 field_883;
      public String name;

      public class_960() {
         this.method_1773();
      }

      // $FF: renamed from: o () com.google.android.gms.internal.c$i[]
      public static class_51.class_960[] method_1771() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         if(!this.name.equals("")) {
            var1.method_3521(1, this.name);
         }

         if(this.field_882 != null) {
            var1.method_3515(2, this.field_882);
         }

         if(this.field_883 != null) {
            var1.method_3515(3, this.field_883);
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1772(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = super.method_1723();
         if(!this.name.equals("")) {
            var1 += class_601.method_3504(1, this.name);
         }

         if(this.field_882 != null) {
            var1 += class_601.method_3488(2, this.field_882);
         }

         if(this.field_883 != null) {
            var1 += class_601.method_3488(3, this.field_883);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_51.class_960;
            var3 = false;
            if(var2) {
               class_51.class_960 var4 = (class_51.class_960)var1;
               if(this.name == null) {
                  String var8 = var4.name;
                  var3 = false;
                  if(var8 != null) {
                     return var3;
                  }
               } else if(!this.name.equals(var4.name)) {
                  return false;
               }

               if(this.field_882 == null) {
                  class_52.class_816 var7 = var4.field_882;
                  var3 = false;
                  if(var7 != null) {
                     return var3;
                  }
               } else if(!this.field_882.equals(var4.field_882)) {
                  return false;
               }

               if(this.field_883 == null) {
                  class_51.class_967 var6 = var4.field_883;
                  var3 = false;
                  if(var6 != null) {
                     return var3;
                  }
               } else if(!this.field_883.equals(var4.field_883)) {
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
         if(this.field_882 == null) {
            var3 = 0;
         } else {
            var3 = this.field_882.hashCode();
         }

         int var4 = 31 * (var3 + var2);
         int var5;
         if(this.field_883 == null) {
            var5 = 0;
         } else {
            var5 = this.field_883.hashCode();
         }

         int var6 = 31 * (var5 + var4);
         List var7 = this.amU;
         int var8 = 0;
         if(var7 != null) {
            boolean var9 = this.amU.isEmpty();
            var8 = 0;
            if(!var9) {
               var8 = this.amU.hashCode();
            }
         }

         return var6 + var8;
      }

      // $FF: renamed from: j (com.google.android.gms.internal.lz) com.google.android.gms.internal.c$i
      public class_51.class_960 method_1772(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            switch(var2) {
            case 10:
               this.name = var1.readString();
               break;
            case 18:
               if(this.field_882 == null) {
                  this.field_882 = new class_52.class_816();
               }

               var1.method_3551(this.field_882);
               break;
            case 26:
               if(this.field_883 == null) {
                  this.field_883 = new class_51.class_967();
               }

               var1.method_3551(this.field_883);
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
      public class_51.class_960 method_1773() {
         this.name = "";
         this.field_882 = null;
         this.field_883 = null;
         this.amU = null;
         this.amY = -1;
         return this;
      }
   }

   public static final class class_961 extends mb<class_51.class_961> {
      // $FF: renamed from: fJ com.google.android.gms.internal.c$i[]
      public class_51.class_960[] field_878;
      // $FF: renamed from: fK com.google.android.gms.internal.c$f
      public class_51.class_965 field_879;
      // $FF: renamed from: fL java.lang.String
      public String field_880;

      public class_961() {
         this.method_1770();
      }

      // $FF: renamed from: b (byte[]) com.google.android.gms.internal.c$j
      public static class_51.class_961 method_1768(byte[] var0) throws class_637 {
         return (class_51.class_961)class_246.method_1717(new class_51.class_961(), var0);
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         if(this.field_878 != null && this.field_878.length > 0) {
            for(int var2 = 0; var2 < this.field_878.length; ++var2) {
               class_51.class_960 var3 = this.field_878[var2];
               if(var3 != null) {
                  var1.method_3515(1, var3);
               }
            }
         }

         if(this.field_879 != null) {
            var1.method_3515(2, this.field_879);
         }

         if(!this.field_880.equals("")) {
            var1.method_3521(3, this.field_880);
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1769(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = super.method_1723();
         if(this.field_878 != null && this.field_878.length > 0) {
            for(int var2 = 0; var2 < this.field_878.length; ++var2) {
               class_51.class_960 var3 = this.field_878[var2];
               if(var3 != null) {
                  var1 += class_601.method_3488(1, var3);
               }
            }
         }

         if(this.field_879 != null) {
            var1 += class_601.method_3488(2, this.field_879);
         }

         if(!this.field_880.equals("")) {
            var1 += class_601.method_3504(3, this.field_880);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_51.class_961;
            var3 = false;
            if(var2) {
               class_51.class_961 var4 = (class_51.class_961)var1;
               boolean var5 = class_602.equals((Object[])this.field_878, (Object[])var4.field_878);
               var3 = false;
               if(var5) {
                  if(this.field_879 == null) {
                     class_51.class_965 var8 = var4.field_879;
                     var3 = false;
                     if(var8 != null) {
                        return var3;
                     }
                  } else if(!this.field_879.equals(var4.field_879)) {
                     return false;
                  }

                  if(this.field_880 == null) {
                     String var7 = var4.field_880;
                     var3 = false;
                     if(var7 != null) {
                        return var3;
                     }
                  } else if(!this.field_880.equals(var4.field_880)) {
                     return false;
                  }

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
         int var1 = 31 * (527 + class_602.hashCode((Object[])this.field_878));
         int var2;
         if(this.field_879 == null) {
            var2 = 0;
         } else {
            var2 = this.field_879.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.field_880 == null) {
            var4 = 0;
         } else {
            var4 = this.field_880.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         List var6 = this.amU;
         int var7 = 0;
         if(var6 != null) {
            boolean var8 = this.amU.isEmpty();
            var7 = 0;
            if(!var8) {
               var7 = this.amU.hashCode();
            }
         }

         return var5 + var7;
      }

      // $FF: renamed from: k (com.google.android.gms.internal.lz) com.google.android.gms.internal.c$j
      public class_51.class_961 method_1769(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            int var4;
            class_51.class_960[] var5;
            switch(var2) {
            case 10:
               int var3 = class_638.method_3656(var1, 10);
               if(this.field_878 == null) {
                  var4 = 0;
               } else {
                  var4 = this.field_878.length;
               }

               var5 = new class_51.class_960[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.field_878, 0, var5, 0, var4);
               }
               break;
            case 18:
               if(this.field_879 == null) {
                  this.field_879 = new class_51.class_965();
               }

               var1.method_3551(this.field_879);
               continue;
            case 26:
               this.field_880 = var1.readString();
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var4 < -1 + var5.length) {
               var5[var4] = new class_51.class_960();
               var1.method_3551(var5[var4]);
               var1.method_3570();
               ++var4;
            }

            var5[var4] = new class_51.class_960();
            var1.method_3551(var5[var4]);
            this.field_878 = var5;
         }
      }

      // $FF: renamed from: q () com.google.android.gms.internal.c$j
      public class_51.class_961 method_1770() {
         this.field_878 = class_51.class_960.method_1771();
         this.field_879 = null;
         this.field_880 = "";
         this.amU = null;
         this.amY = -1;
         return this;
      }
   }
}
