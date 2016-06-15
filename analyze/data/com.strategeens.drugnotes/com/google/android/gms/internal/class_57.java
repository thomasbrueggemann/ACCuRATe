package com.google.android.gms.internal;

import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_822;
import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.class_827;
import com.google.android.gms.internal.class_834;
import com.google.android.gms.internal.qq;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.d
public interface class_57 {
   public static final class class_1084 extends qq<class_57.class_1084> {
      // $FF: renamed from: gu com.google.android.gms.internal.d$a[]
      private static volatile class_57.class_1084[] field_726;
      // $FF: renamed from: gA java.lang.String
      public String field_727;
      // $FF: renamed from: gB long
      public long field_728;
      // $FF: renamed from: gC boolean
      public boolean field_729;
      // $FF: renamed from: gD com.google.android.gms.internal.d$a[]
      public class_57.class_1084[] field_730;
      // $FF: renamed from: gE int[]
      public int[] field_731;
      // $FF: renamed from: gF boolean
      public boolean field_732;
      // $FF: renamed from: gv java.lang.String
      public String field_733;
      // $FF: renamed from: gw com.google.android.gms.internal.d$a[]
      public class_57.class_1084[] field_734;
      // $FF: renamed from: gx com.google.android.gms.internal.d$a[]
      public class_57.class_1084[] field_735;
      // $FF: renamed from: gy com.google.android.gms.internal.d$a[]
      public class_57.class_1084[] field_736;
      // $FF: renamed from: gz java.lang.String
      public String field_737;
      public int type;

      public class_1084() {
         this.method_2165();
      }

      // $FF: renamed from: r () com.google.android.gms.internal.d$a[]
      public static class_57.class_1084[] method_2163() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         var1.method_4554(1, this.type);
         if(!this.field_733.equals("")) {
            var1.method_4537(2, this.field_733);
         }

         if(this.field_734 != null && this.field_734.length > 0) {
            for(int var10 = 0; var10 < this.field_734.length; ++var10) {
               class_57.class_1084 var11 = this.field_734[var10];
               if(var11 != null) {
                  var1.method_4532(3, var11);
               }
            }
         }

         if(this.field_735 != null && this.field_735.length > 0) {
            for(int var8 = 0; var8 < this.field_735.length; ++var8) {
               class_57.class_1084 var9 = this.field_735[var8];
               if(var9 != null) {
                  var1.method_4532(4, var9);
               }
            }
         }

         if(this.field_736 != null && this.field_736.length > 0) {
            for(int var6 = 0; var6 < this.field_736.length; ++var6) {
               class_57.class_1084 var7 = this.field_736[var6];
               if(var7 != null) {
                  var1.method_4532(5, var7);
               }
            }
         }

         if(!this.field_737.equals("")) {
            var1.method_4537(6, this.field_737);
         }

         if(!this.field_727.equals("")) {
            var1.method_4537(7, this.field_727);
         }

         if(this.field_728 != 0L) {
            var1.method_4536(8, this.field_728);
         }

         if(this.field_732) {
            var1.method_4538(9, this.field_732);
         }

         if(this.field_731 != null && this.field_731.length > 0) {
            for(int var5 = 0; var5 < this.field_731.length; ++var5) {
               var1.method_4554(10, this.field_731[var5]);
            }
         }

         if(this.field_730 != null) {
            int var2 = this.field_730.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.field_730.length; ++var3) {
                  class_57.class_1084 var4 = this.field_730[var3];
                  if(var4 != null) {
                     var1.method_4532(11, var4);
                  }
               }
            }
         }

         if(this.field_729) {
            var1.method_4538(12, this.field_729);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2164(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091() + class_826.method_4524(1, this.type);
         if(!this.field_733.equals("")) {
            var1 += class_826.method_4521(2, this.field_733);
         }

         if(this.field_734 != null && this.field_734.length > 0) {
            int var13 = var1;

            for(int var14 = 0; var14 < this.field_734.length; ++var14) {
               class_57.class_1084 var15 = this.field_734[var14];
               if(var15 != null) {
                  var13 += class_826.method_4507(3, var15);
               }
            }

            var1 = var13;
         }

         if(this.field_735 != null && this.field_735.length > 0) {
            int var10 = var1;

            for(int var11 = 0; var11 < this.field_735.length; ++var11) {
               class_57.class_1084 var12 = this.field_735[var11];
               if(var12 != null) {
                  var10 += class_826.method_4507(4, var12);
               }
            }

            var1 = var10;
         }

         if(this.field_736 != null && this.field_736.length > 0) {
            int var7 = var1;

            for(int var8 = 0; var8 < this.field_736.length; ++var8) {
               class_57.class_1084 var9 = this.field_736[var8];
               if(var9 != null) {
                  var7 += class_826.method_4507(5, var9);
               }
            }

            var1 = var7;
         }

         if(!this.field_737.equals("")) {
            var1 += class_826.method_4521(6, this.field_737);
         }

         if(!this.field_727.equals("")) {
            var1 += class_826.method_4521(7, this.field_727);
         }

         if(this.field_728 != 0L) {
            var1 += class_826.method_4509(8, this.field_728);
         }

         if(this.field_732) {
            var1 += class_826.method_4508(9, this.field_732);
         }

         if(this.field_731 != null && this.field_731.length > 0) {
            int var5 = 0;

            int var6;
            for(var6 = 0; var5 < this.field_731.length; ++var5) {
               var6 += class_826.method_4516(this.field_731[var5]);
            }

            var1 = var1 + var6 + 1 * this.field_731.length;
         }

         if(this.field_730 != null) {
            int var2 = this.field_730.length;
            int var3 = 0;
            if(var2 > 0) {
               for(; var3 < this.field_730.length; ++var3) {
                  class_57.class_1084 var4 = this.field_730[var3];
                  if(var4 != null) {
                     var1 += class_826.method_4507(11, var4);
                  }
               }
            }
         }

         if(this.field_729) {
            var1 += class_826.method_4508(12, this.field_729);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_57.class_1084;
            var3 = false;
            if(var2) {
               class_57.class_1084 var4 = (class_57.class_1084)var1;
               int var5 = this.type;
               int var6 = var4.type;
               var3 = false;
               if(var5 == var6) {
                  if(this.field_733 == null) {
                     String var19 = var4.field_733;
                     var3 = false;
                     if(var19 != null) {
                        return var3;
                     }
                  } else if(!this.field_733.equals(var4.field_733)) {
                     return false;
                  }

                  boolean var7 = class_834.equals((Object[])this.field_734, (Object[])var4.field_734);
                  var3 = false;
                  if(var7) {
                     boolean var8 = class_834.equals((Object[])this.field_735, (Object[])var4.field_735);
                     var3 = false;
                     if(var8) {
                        boolean var9 = class_834.equals((Object[])this.field_736, (Object[])var4.field_736);
                        var3 = false;
                        if(var9) {
                           if(this.field_737 == null) {
                              String var18 = var4.field_737;
                              var3 = false;
                              if(var18 != null) {
                                 return var3;
                              }
                           } else if(!this.field_737.equals(var4.field_737)) {
                              return false;
                           }

                           if(this.field_727 == null) {
                              String var17 = var4.field_727;
                              var3 = false;
                              if(var17 != null) {
                                 return var3;
                              }
                           } else if(!this.field_727.equals(var4.field_727)) {
                              return false;
                           }

                           long var20;
                           int var10 = (var20 = this.field_728 - var4.field_728) == 0L?0:(var20 < 0L?-1:1);
                           var3 = false;
                           if(var10 == 0) {
                              boolean var11 = this.field_729;
                              boolean var12 = var4.field_729;
                              var3 = false;
                              if(var11 == var12) {
                                 boolean var13 = class_834.equals((Object[])this.field_730, (Object[])var4.field_730);
                                 var3 = false;
                                 if(var13) {
                                    boolean var14 = class_834.equals(this.field_731, var4.field_731);
                                    var3 = false;
                                    if(var14) {
                                       boolean var15 = this.field_732;
                                       boolean var16 = var4.field_732;
                                       var3 = false;
                                       if(var15 == var16) {
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
         short var1 = 1231;
         int var2 = 31 * (527 + this.type);
         int var3;
         if(this.field_733 == null) {
            var3 = 0;
         } else {
            var3 = this.field_733.hashCode();
         }

         int var4 = 31 * (31 * (31 * (31 * (var3 + var2) + class_834.hashCode((Object[])this.field_734)) + class_834.hashCode((Object[])this.field_735)) + class_834.hashCode((Object[])this.field_736));
         int var5;
         if(this.field_737 == null) {
            var5 = 0;
         } else {
            var5 = this.field_737.hashCode();
         }

         int var6 = 31 * (var5 + var4);
         String var7 = this.field_727;
         int var8 = 0;
         if(var7 != null) {
            var8 = this.field_727.hashCode();
         }

         int var9 = 31 * (31 * (var6 + var8) + (int)(this.field_728 ^ this.field_728 >>> 32));
         short var10;
         if(this.field_729) {
            var10 = var1;
         } else {
            var10 = 1237;
         }

         int var11 = 31 * (31 * (31 * (var10 + var9) + class_834.hashCode((Object[])this.field_730)) + class_834.hashCode(this.field_731));
         if(!this.field_732) {
            var1 = 1237;
         }

         return 31 * (var11 + var1) + this.rQ();
      }

      // $FF: renamed from: l (com.google.android.gms.internal.qo) com.google.android.gms.internal.d$a
      public class_57.class_1084 method_2164(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            int var32;
            class_57.class_1084[] var33;
            switch(var2) {
            case 8:
               int var35 = var1.method_4574();
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
               this.field_733 = var1.readString();
               continue;
            case 26:
               int var31 = class_822.method_4484(var1, 26);
               if(this.field_734 == null) {
                  var32 = 0;
               } else {
                  var32 = this.field_734.length;
               }

               var33 = new class_57.class_1084[var31 + var32];
               if(var32 != 0) {
                  System.arraycopy(this.field_734, 0, var33, 0, var32);
               }
               break;
            case 34:
               int var27 = class_822.method_4484(var1, 34);
               int var28;
               if(this.field_735 == null) {
                  var28 = 0;
               } else {
                  var28 = this.field_735.length;
               }

               class_57.class_1084[] var29 = new class_57.class_1084[var27 + var28];
               if(var28 != 0) {
                  System.arraycopy(this.field_735, 0, var29, 0, var28);
               }

               while(var28 < -1 + var29.length) {
                  var29[var28] = new class_57.class_1084();
                  var1.method_4563(var29[var28]);
                  var1.method_4585();
                  ++var28;
               }

               var29[var28] = new class_57.class_1084();
               var1.method_4563(var29[var28]);
               this.field_735 = var29;
               continue;
            case 42:
               int var23 = class_822.method_4484(var1, 42);
               int var24;
               if(this.field_736 == null) {
                  var24 = 0;
               } else {
                  var24 = this.field_736.length;
               }

               class_57.class_1084[] var25 = new class_57.class_1084[var23 + var24];
               if(var24 != 0) {
                  System.arraycopy(this.field_736, 0, var25, 0, var24);
               }

               while(var24 < -1 + var25.length) {
                  var25[var24] = new class_57.class_1084();
                  var1.method_4563(var25[var24]);
                  var1.method_4585();
                  ++var24;
               }

               var25[var24] = new class_57.class_1084();
               var1.method_4563(var25[var24]);
               this.field_736 = var25;
               continue;
            case 50:
               this.field_737 = var1.readString();
               continue;
            case 58:
               this.field_727 = var1.readString();
               continue;
            case 64:
               this.field_728 = var1.method_4573();
               continue;
            case 72:
               this.field_732 = var1.method_4575();
               continue;
            case 80:
               int var14 = class_822.method_4484(var1, 80);
               int[] var15 = new int[var14];
               int var16 = 0;

               int var17;
               int var21;
               for(var17 = 0; var16 < var14; var17 = var21) {
                  if(var16 != 0) {
                     var1.method_4585();
                  }

                  int var20 = var1.method_4574();
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
               if(this.field_731 == null) {
                  var18 = 0;
               } else {
                  var18 = this.field_731.length;
               }

               if(var18 == 0 && var17 == var15.length) {
                  this.field_731 = var15;
                  continue;
               }

               int[] var19 = new int[var18 + var17];
               if(var18 != 0) {
                  System.arraycopy(this.field_731, 0, var19, 0, var18);
               }

               System.arraycopy(var15, 0, var19, var18, var17);
               this.field_731 = var19;
               continue;
            case 82:
               int var7 = var1.method_4567(var1.method_4578());
               int var8 = var1.getPosition();
               int var9 = 0;

               while(var1.method_4582() > 0) {
                  switch(var1.method_4574()) {
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
                  var1.method_4569(var8);
                  int var10;
                  if(this.field_731 == null) {
                     var10 = 0;
                  } else {
                     var10 = this.field_731.length;
                  }

                  int[] var11 = new int[var9 + var10];
                  if(var10 != 0) {
                     System.arraycopy(this.field_731, 0, var11, 0, var10);
                  }

                  while(var1.method_4582() > 0) {
                     int var12 = var1.method_4574();
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

                  this.field_731 = var11;
               }

               var1.method_4568(var7);
               continue;
            case 90:
               int var3 = class_822.method_4484(var1, 90);
               int var4;
               if(this.field_730 == null) {
                  var4 = 0;
               } else {
                  var4 = this.field_730.length;
               }

               class_57.class_1084[] var5 = new class_57.class_1084[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.field_730, 0, var5, 0, var4);
               }

               while(var4 < -1 + var5.length) {
                  var5[var4] = new class_57.class_1084();
                  var1.method_4563(var5[var4]);
                  var1.method_4585();
                  ++var4;
               }

               var5[var4] = new class_57.class_1084();
               var1.method_4563(var5[var4]);
               this.field_730 = var5;
               continue;
            case 96:
               this.field_729 = var1.method_4575();
               continue;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var32 < -1 + var33.length) {
               var33[var32] = new class_57.class_1084();
               var1.method_4563(var33[var32]);
               var1.method_4585();
               ++var32;
            }

            var33[var32] = new class_57.class_1084();
            var1.method_4563(var33[var32]);
            this.field_734 = var33;
         }
      }

      // $FF: renamed from: s () com.google.android.gms.internal.d$a
      public class_57.class_1084 method_2165() {
         this.type = 1;
         this.field_733 = "";
         this.field_734 = method_2163();
         this.field_735 = method_2163();
         this.field_736 = method_2163();
         this.field_737 = "";
         this.field_727 = "";
         this.field_728 = 0L;
         this.field_729 = false;
         this.field_730 = method_2163();
         this.field_731 = class_822.azj;
         this.field_732 = false;
         this.ayW = null;
         this.azh = -1;
         return this;
      }
   }
}
