package com.google.android.gms.internal;

import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_601;
import com.google.android.gms.internal.class_602;
import com.google.android.gms.internal.class_605;
import com.google.android.gms.internal.class_638;
import com.google.android.gms.internal.mb;
import java.io.IOException;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.d
public interface class_52 {
   public static final class class_816 extends mb<class_52.class_816> {
      // $FF: renamed from: fM com.google.android.gms.internal.d$a[]
      private static volatile class_52.class_816[] field_884;
      // $FF: renamed from: fN java.lang.String
      public String field_885;
      // $FF: renamed from: fO com.google.android.gms.internal.d$a[]
      public class_52.class_816[] field_886;
      // $FF: renamed from: fP com.google.android.gms.internal.d$a[]
      public class_52.class_816[] field_887;
      // $FF: renamed from: fQ com.google.android.gms.internal.d$a[]
      public class_52.class_816[] field_888;
      // $FF: renamed from: fR java.lang.String
      public String field_889;
      // $FF: renamed from: fS java.lang.String
      public String field_890;
      // $FF: renamed from: fT long
      public long field_891;
      // $FF: renamed from: fU boolean
      public boolean field_892;
      // $FF: renamed from: fV com.google.android.gms.internal.d$a[]
      public class_52.class_816[] field_893;
      // $FF: renamed from: fW int[]
      public int[] field_894;
      // $FF: renamed from: fX boolean
      public boolean field_895;
      public int type;

      public class_816() {
         this.method_1779();
      }

      // $FF: renamed from: r () com.google.android.gms.internal.d$a[]
      public static class_52.class_816[] method_1777() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         var1.method_3535(1, this.type);
         if(!this.field_885.equals("")) {
            var1.method_3521(2, this.field_885);
         }

         if(this.field_886 != null && this.field_886.length > 0) {
            for(int var10 = 0; var10 < this.field_886.length; ++var10) {
               class_52.class_816 var11 = this.field_886[var10];
               if(var11 != null) {
                  var1.method_3515(3, var11);
               }
            }
         }

         if(this.field_887 != null && this.field_887.length > 0) {
            for(int var8 = 0; var8 < this.field_887.length; ++var8) {
               class_52.class_816 var9 = this.field_887[var8];
               if(var9 != null) {
                  var1.method_3515(4, var9);
               }
            }
         }

         if(this.field_888 != null && this.field_888.length > 0) {
            for(int var6 = 0; var6 < this.field_888.length; ++var6) {
               class_52.class_816 var7 = this.field_888[var6];
               if(var7 != null) {
                  var1.method_3515(5, var7);
               }
            }
         }

         if(!this.field_889.equals("")) {
            var1.method_3521(6, this.field_889);
         }

         if(!this.field_890.equals("")) {
            var1.method_3521(7, this.field_890);
         }

         if(this.field_891 != 0L) {
            var1.method_3520(8, this.field_891);
         }

         if(this.field_895) {
            var1.method_3516(9, this.field_895);
         }

         if(this.field_894 != null && this.field_894.length > 0) {
            for(int var5 = 0; var5 < this.field_894.length; ++var5) {
               var1.method_3535(10, this.field_894[var5]);
            }
         }

         if(this.field_893 != null) {
            int var2 = this.field_893.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.field_893.length; ++var3) {
                  class_52.class_816 var4 = this.field_893[var3];
                  if(var4 != null) {
                     var1.method_3515(11, var4);
                  }
               }
            }
         }

         if(this.field_892) {
            var1.method_3516(12, this.field_892);
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1778(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = super.method_1723() + class_601.method_3506(1, this.type);
         if(!this.field_885.equals("")) {
            var1 += class_601.method_3504(2, this.field_885);
         }

         if(this.field_886 != null && this.field_886.length > 0) {
            int var13 = var1;

            for(int var14 = 0; var14 < this.field_886.length; ++var14) {
               class_52.class_816 var15 = this.field_886[var14];
               if(var15 != null) {
                  var13 += class_601.method_3488(3, var15);
               }
            }

            var1 = var13;
         }

         if(this.field_887 != null && this.field_887.length > 0) {
            int var10 = var1;

            for(int var11 = 0; var11 < this.field_887.length; ++var11) {
               class_52.class_816 var12 = this.field_887[var11];
               if(var12 != null) {
                  var10 += class_601.method_3488(4, var12);
               }
            }

            var1 = var10;
         }

         if(this.field_888 != null && this.field_888.length > 0) {
            int var7 = var1;

            for(int var8 = 0; var8 < this.field_888.length; ++var8) {
               class_52.class_816 var9 = this.field_888[var8];
               if(var9 != null) {
                  var7 += class_601.method_3488(5, var9);
               }
            }

            var1 = var7;
         }

         if(!this.field_889.equals("")) {
            var1 += class_601.method_3504(6, this.field_889);
         }

         if(!this.field_890.equals("")) {
            var1 += class_601.method_3504(7, this.field_890);
         }

         if(this.field_891 != 0L) {
            var1 += class_601.method_3495(8, this.field_891);
         }

         if(this.field_895) {
            var1 += class_601.method_3489(9, this.field_895);
         }

         if(this.field_894 != null && this.field_894.length > 0) {
            int var5 = 0;

            int var6;
            for(var6 = 0; var5 < this.field_894.length; ++var5) {
               var6 += class_601.method_3498(this.field_894[var5]);
            }

            var1 = var1 + var6 + 1 * this.field_894.length;
         }

         if(this.field_893 != null) {
            int var2 = this.field_893.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.field_893.length; ++var3) {
                  class_52.class_816 var4 = this.field_893[var3];
                  if(var4 != null) {
                     var1 += class_601.method_3488(11, var4);
                  }
               }
            }
         }

         if(this.field_892) {
            var1 += class_601.method_3489(12, this.field_892);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_52.class_816;
            var3 = false;
            if(var2) {
               class_52.class_816 var4 = (class_52.class_816)var1;
               int var5 = this.type;
               int var6 = var4.type;
               var3 = false;
               if(var5 == var6) {
                  if(this.field_885 == null) {
                     String var20 = var4.field_885;
                     var3 = false;
                     if(var20 != null) {
                        return var3;
                     }
                  } else if(!this.field_885.equals(var4.field_885)) {
                     return false;
                  }

                  boolean var7 = class_602.equals((Object[])this.field_886, (Object[])var4.field_886);
                  var3 = false;
                  if(var7) {
                     boolean var8 = class_602.equals((Object[])this.field_887, (Object[])var4.field_887);
                     var3 = false;
                     if(var8) {
                        boolean var9 = class_602.equals((Object[])this.field_888, (Object[])var4.field_888);
                        var3 = false;
                        if(var9) {
                           if(this.field_889 == null) {
                              String var19 = var4.field_889;
                              var3 = false;
                              if(var19 != null) {
                                 return var3;
                              }
                           } else if(!this.field_889.equals(var4.field_889)) {
                              return false;
                           }

                           if(this.field_890 == null) {
                              String var18 = var4.field_890;
                              var3 = false;
                              if(var18 != null) {
                                 return var3;
                              }
                           } else if(!this.field_890.equals(var4.field_890)) {
                              return false;
                           }

                           long var21;
                           int var10 = (var21 = this.field_891 - var4.field_891) == 0L?0:(var21 < 0L?-1:1);
                           var3 = false;
                           if(var10 == 0) {
                              boolean var11 = this.field_892;
                              boolean var12 = var4.field_892;
                              var3 = false;
                              if(var11 == var12) {
                                 boolean var13 = class_602.equals((Object[])this.field_893, (Object[])var4.field_893);
                                 var3 = false;
                                 if(var13) {
                                    boolean var14 = class_602.equals(this.field_894, var4.field_894);
                                    var3 = false;
                                    if(var14) {
                                       boolean var15 = this.field_895;
                                       boolean var16 = var4.field_895;
                                       var3 = false;
                                       if(var15 == var16) {
                                          if(this.amU != null && !this.amU.isEmpty()) {
                                             return this.amU.equals(var4.amU);
                                          }

                                          if(var4.amU != null) {
                                             boolean var17 = var4.amU.isEmpty();
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
         int var2 = 31 * (527 + this.type);
         int var3;
         if(this.field_885 == null) {
            var3 = 0;
         } else {
            var3 = this.field_885.hashCode();
         }

         int var4 = 31 * (31 * (31 * (31 * (var3 + var2) + class_602.hashCode((Object[])this.field_886)) + class_602.hashCode((Object[])this.field_887)) + class_602.hashCode((Object[])this.field_888));
         int var5;
         if(this.field_889 == null) {
            var5 = 0;
         } else {
            var5 = this.field_889.hashCode();
         }

         int var6 = 31 * (var5 + var4);
         int var7;
         if(this.field_890 == null) {
            var7 = 0;
         } else {
            var7 = this.field_890.hashCode();
         }

         int var8 = 31 * (31 * (var7 + var6) + (int)(this.field_891 ^ this.field_891 >>> 32));
         short var9;
         if(this.field_892) {
            var9 = var1;
         } else {
            var9 = 1237;
         }

         int var10 = 31 * (31 * (31 * (var9 + var8) + class_602.hashCode((Object[])this.field_893)) + class_602.hashCode(this.field_894));
         if(!this.field_895) {
            var1 = 1237;
         }

         int var11 = 31 * (var10 + var1);
         List var12 = this.amU;
         int var13 = 0;
         if(var12 != null) {
            boolean var14 = this.amU.isEmpty();
            var13 = 0;
            if(!var14) {
               var13 = this.amU.hashCode();
            }
         }

         return var11 + var13;
      }

      // $FF: renamed from: l (com.google.android.gms.internal.lz) com.google.android.gms.internal.d$a
      public class_52.class_816 method_1778(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            int var32;
            class_52.class_816[] var33;
            switch(var2) {
            case 8:
               int var35 = var1.method_3573();
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
               this.field_885 = var1.readString();
               continue;
            case 26:
               int var31 = class_638.method_3656(var1, 26);
               if(this.field_886 == null) {
                  var32 = 0;
               } else {
                  var32 = this.field_886.length;
               }

               var33 = new class_52.class_816[var31 + var32];
               if(var32 != 0) {
                  System.arraycopy(this.field_886, 0, var33, 0, var32);
               }
               break;
            case 34:
               int var27 = class_638.method_3656(var1, 34);
               int var28;
               if(this.field_887 == null) {
                  var28 = 0;
               } else {
                  var28 = this.field_887.length;
               }

               class_52.class_816[] var29 = new class_52.class_816[var27 + var28];
               if(var28 != 0) {
                  System.arraycopy(this.field_887, 0, var29, 0, var28);
               }

               while(var28 < -1 + var29.length) {
                  var29[var28] = new class_52.class_816();
                  var1.method_3551(var29[var28]);
                  var1.method_3570();
                  ++var28;
               }

               var29[var28] = new class_52.class_816();
               var1.method_3551(var29[var28]);
               this.field_887 = var29;
               continue;
            case 42:
               int var23 = class_638.method_3656(var1, 42);
               int var24;
               if(this.field_888 == null) {
                  var24 = 0;
               } else {
                  var24 = this.field_888.length;
               }

               class_52.class_816[] var25 = new class_52.class_816[var23 + var24];
               if(var24 != 0) {
                  System.arraycopy(this.field_888, 0, var25, 0, var24);
               }

               while(var24 < -1 + var25.length) {
                  var25[var24] = new class_52.class_816();
                  var1.method_3551(var25[var24]);
                  var1.method_3570();
                  ++var24;
               }

               var25[var24] = new class_52.class_816();
               var1.method_3551(var25[var24]);
               this.field_888 = var25;
               continue;
            case 50:
               this.field_889 = var1.readString();
               continue;
            case 58:
               this.field_890 = var1.readString();
               continue;
            case 64:
               this.field_891 = var1.method_3572();
               continue;
            case 72:
               this.field_895 = var1.method_3560();
               continue;
            case 80:
               int var14 = class_638.method_3656(var1, 80);
               int[] var15 = new int[var14];
               int var16 = 0;

               int var17;
               int var21;
               for(var17 = 0; var16 < var14; var17 = var21) {
                  if(var16 != 0) {
                     var1.method_3570();
                  }

                  int var20 = var1.method_3573();
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
               if(this.field_894 == null) {
                  var18 = 0;
               } else {
                  var18 = this.field_894.length;
               }

               if(var18 == 0 && var17 == var15.length) {
                  this.field_894 = var15;
                  continue;
               }

               int[] var19 = new int[var18 + var17];
               if(var18 != 0) {
                  System.arraycopy(this.field_894, 0, var19, 0, var18);
               }

               System.arraycopy(var15, 0, var19, var18, var17);
               this.field_894 = var19;
               continue;
            case 82:
               int var7 = var1.method_3557(var1.method_3563());
               int var8 = var1.getPosition();
               int var9 = 0;

               while(var1.method_3567() > 0) {
                  switch(var1.method_3573()) {
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
                  var1.method_3559(var8);
                  int var10;
                  if(this.field_894 == null) {
                     var10 = 0;
                  } else {
                     var10 = this.field_894.length;
                  }

                  int[] var11 = new int[var9 + var10];
                  if(var10 != 0) {
                     System.arraycopy(this.field_894, 0, var11, 0, var10);
                  }

                  while(var1.method_3567() > 0) {
                     int var12 = var1.method_3573();
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

                  this.field_894 = var11;
               }

               var1.method_3558(var7);
               continue;
            case 90:
               int var3 = class_638.method_3656(var1, 90);
               int var4;
               if(this.field_893 == null) {
                  var4 = 0;
               } else {
                  var4 = this.field_893.length;
               }

               class_52.class_816[] var5 = new class_52.class_816[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.field_893, 0, var5, 0, var4);
               }

               while(var4 < -1 + var5.length) {
                  var5[var4] = new class_52.class_816();
                  var1.method_3551(var5[var4]);
                  var1.method_3570();
                  ++var4;
               }

               var5[var4] = new class_52.class_816();
               var1.method_3551(var5[var4]);
               this.field_893 = var5;
               continue;
            case 96:
               this.field_892 = var1.method_3560();
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var32 < -1 + var33.length) {
               var33[var32] = new class_52.class_816();
               var1.method_3551(var33[var32]);
               var1.method_3570();
               ++var32;
            }

            var33[var32] = new class_52.class_816();
            var1.method_3551(var33[var32]);
            this.field_886 = var33;
         }
      }

      // $FF: renamed from: s () com.google.android.gms.internal.d$a
      public class_52.class_816 method_1779() {
         this.type = 1;
         this.field_885 = "";
         this.field_886 = method_1777();
         this.field_887 = method_1777();
         this.field_888 = method_1777();
         this.field_889 = "";
         this.field_890 = "";
         this.field_891 = 0L;
         this.field_892 = false;
         this.field_893 = method_1777();
         this.field_894 = class_638.ana;
         this.field_895 = false;
         this.amU = null;
         this.amY = -1;
         return this;
      }
   }
}
