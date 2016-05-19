package com.loopj.android.http;

public class Base64 {
   abstract static class Coder {
      // $FF: renamed from: op int
      public int field_114;
      public byte[] output;

      public abstract int maxOutputSize(int var1);

      public abstract boolean process(byte[] var1, int var2, int var3, boolean var4);
   }

   static class Decoder extends Base64.Coder {
      private static final int[] DECODE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
      private static final int[] DECODE_WEBSAFE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
      private final int[] alphabet;
      private int state;
      private int value;

      public Decoder(int var1, byte[] var2) {
         this.output = var2;
         int[] var3;
         if((var1 & 8) == 0) {
            var3 = DECODE;
         } else {
            var3 = DECODE_WEBSAFE;
         }

         this.alphabet = var3;
         this.state = 0;
         this.value = 0;
      }

      public int maxOutputSize(int var1) {
         return 10 + var1 * 3 / 4;
      }

      public boolean process(byte[] var1, int var2, int var3, boolean var4) {
         if(this.state == 6) {
            return false;
         } else {
            int var5 = var2;
            int var6 = var3 + var2;
            int var7 = this.state;
            int var8 = this.value;
            int var9 = 0;
            byte[] var10 = this.output;
            int[] var11 = this.alphabet;

            int var12;
            while(true) {
               if(var5 >= var6) {
                  var12 = var9;
                  break;
               }

               if(var7 == 0) {
                  while(var5 + 4 <= var6) {
                     var8 = var11[255 & var1[var5]] << 18 | var11[255 & var1[var5 + 1]] << 12 | var11[255 & var1[var5 + 2]] << 6 | var11[255 & var1[var5 + 3]];
                     if(var8 < 0) {
                        break;
                     }

                     var10[var9 + 2] = (byte)var8;
                     var10[var9 + 1] = (byte)(var8 >> 8);
                     var10[var9] = (byte)(var8 >> 16);
                     var9 += 3;
                     var5 += 4;
                  }

                  if(var5 >= var6) {
                     var12 = var9;
                     break;
                  }
               }

               int var16 = var5 + 1;
               int var17 = var11[255 & var1[var5]];
               switch(var7) {
               case 0:
                  if(var17 >= 0) {
                     var8 = var17;
                     ++var7;
                  } else if(var17 != -1) {
                     this.state = 6;
                     return false;
                  }
                  break;
               case 1:
                  if(var17 >= 0) {
                     var8 = var17 | var8 << 6;
                     ++var7;
                  } else if(var17 != -1) {
                     this.state = 6;
                     return false;
                  }
                  break;
               case 2:
                  if(var17 >= 0) {
                     var8 = var17 | var8 << 6;
                     ++var7;
                  } else if(var17 == -2) {
                     int var18 = var9 + 1;
                     var10[var9] = (byte)(var8 >> 4);
                     var7 = 4;
                     var9 = var18;
                  } else if(var17 != -1) {
                     this.state = 6;
                     return false;
                  }
                  break;
               case 3:
                  if(var17 >= 0) {
                     var8 = var17 | var8 << 6;
                     var10[var9 + 2] = (byte)var8;
                     var10[var9 + 1] = (byte)(var8 >> 8);
                     var10[var9] = (byte)(var8 >> 16);
                     var9 += 3;
                     var7 = 0;
                  } else if(var17 == -2) {
                     var10[var9 + 1] = (byte)(var8 >> 2);
                     var10[var9] = (byte)(var8 >> 10);
                     var9 += 2;
                     var7 = 5;
                  } else if(var17 != -1) {
                     this.state = 6;
                     return false;
                  }
                  break;
               case 4:
                  if(var17 == -2) {
                     ++var7;
                  } else if(var17 != -1) {
                     this.state = 6;
                     return false;
                  }
                  break;
               case 5:
                  if(var17 != -1) {
                     this.state = 6;
                     return false;
                  }
               }

               var5 = var16;
            }

            if(!var4) {
               this.state = var7;
               this.value = var8;
               this.op = var12;
               return true;
            } else {
               int var15;
               switch(var7) {
               case 0:
                  var15 = var12;
                  break;
               case 1:
                  this.state = 6;
                  return false;
               case 2:
                  var15 = var12 + 1;
                  var10[var12] = (byte)(var8 >> 4);
                  break;
               case 3:
                  int var13 = var12 + 1;
                  var10[var12] = (byte)(var8 >> 10);
                  int var14 = var13 + 1;
                  var10[var13] = (byte)(var8 >> 2);
                  var15 = var14;
                  break;
               case 4:
                  this.state = 6;
                  return false;
               default:
                  var15 = var12;
               }

               this.state = var7;
               this.op = var15;
               return true;
            }
         }
      }
   }

   static class Encoder extends Base64.Coder {
      private static final byte[] ENCODE = new byte[]{(byte)65, (byte)66, (byte)67, (byte)68, (byte)69, (byte)70, (byte)71, (byte)72, (byte)73, (byte)74, (byte)75, (byte)76, (byte)77, (byte)78, (byte)79, (byte)80, (byte)81, (byte)82, (byte)83, (byte)84, (byte)85, (byte)86, (byte)87, (byte)88, (byte)89, (byte)90, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102, (byte)103, (byte)104, (byte)105, (byte)106, (byte)107, (byte)108, (byte)109, (byte)110, (byte)111, (byte)112, (byte)113, (byte)114, (byte)115, (byte)116, (byte)117, (byte)118, (byte)119, (byte)120, (byte)121, (byte)122, (byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)43, (byte)47};
      private static final byte[] ENCODE_WEBSAFE = new byte[]{(byte)65, (byte)66, (byte)67, (byte)68, (byte)69, (byte)70, (byte)71, (byte)72, (byte)73, (byte)74, (byte)75, (byte)76, (byte)77, (byte)78, (byte)79, (byte)80, (byte)81, (byte)82, (byte)83, (byte)84, (byte)85, (byte)86, (byte)87, (byte)88, (byte)89, (byte)90, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102, (byte)103, (byte)104, (byte)105, (byte)106, (byte)107, (byte)108, (byte)109, (byte)110, (byte)111, (byte)112, (byte)113, (byte)114, (byte)115, (byte)116, (byte)117, (byte)118, (byte)119, (byte)120, (byte)121, (byte)122, (byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)45, (byte)95};
      private final byte[] alphabet;
      private int count;
      public final boolean do_cr;
      public final boolean do_newline;
      public final boolean do_padding;
      private final byte[] tail;
      int tailLen;

      public Encoder(int var1, byte[] var2) {
         boolean var3 = true;
         super();
         this.output = var2;
         boolean var4;
         if((var1 & 1) == 0) {
            var4 = var3;
         } else {
            var4 = false;
         }

         this.do_padding = var4;
         boolean var5;
         if((var1 & 2) == 0) {
            var5 = var3;
         } else {
            var5 = false;
         }

         this.do_newline = var5;
         if((var1 & 4) == 0) {
            var3 = false;
         }

         this.do_cr = var3;
         byte[] var6;
         if((var1 & 8) == 0) {
            var6 = ENCODE;
         } else {
            var6 = ENCODE_WEBSAFE;
         }

         this.alphabet = var6;
         this.tail = new byte[2];
         this.tailLen = 0;
         byte var7;
         if(this.do_newline) {
            var7 = 19;
         } else {
            var7 = -1;
         }

         this.count = var7;
      }

      public int maxOutputSize(int var1) {
         return 10 + var1 * 8 / 5;
      }

      public boolean process(byte[] var1, int var2, int var3, boolean var4) {
         byte[] var5 = this.alphabet;
         byte[] var6 = this.output;
         int var7 = this.count;
         int var8 = var2;
         int var9 = var3 + var2;
         int var10 = -1;
         switch(this.tailLen) {
         case 0:
         default:
            break;
         case 1:
            if(var2 + 2 <= var9) {
               int var61 = (255 & this.tail[0]) << 16;
               int var62 = var2 + 1;
               int var63 = var61 | (255 & var1[var2]) << 8;
               var8 = var62 + 1;
               var10 = var63 | 255 & var1[var62];
               this.tailLen = 0;
            }
            break;
         case 2:
            if(var2 + 1 <= var9) {
               int var11 = (255 & this.tail[0]) << 16 | (255 & this.tail[1]) << 8;
               int var12 = var2 + 1;
               var10 = var11 | 255 & var1[var2];
               this.tailLen = 0;
               var8 = var12;
            }
         }

         byte var13 = 0;
         int var14;
         int var15;
         int var64;
         if(var10 != -1) {
            int var57 = 0 + 1;
            var6[0] = var5[63 & var10 >> 18];
            int var58 = var57 + 1;
            var6[var57] = var5[63 & var10 >> 12];
            int var59 = var58 + 1;
            var6[var58] = var5[63 & var10 >> 6];
            var64 = var59 + 1;
            var6[var59] = var5[var10 & 63];
            --var7;
            if(var7 == 0) {
               if(this.do_cr) {
                  int var60 = var64 + 1;
                  var6[var64] = 13;
                  var64 = var60;
               }

               var15 = var64 + 1;
               var6[var64] = 10;
               var7 = 19;
               var14 = var8;
            } else {
               var14 = var8;
               var15 = var64;
            }
         } else {
            var14 = var8;
            var15 = var13;
         }

         while(var14 + 3 <= var9) {
            int var55 = (255 & var1[var14]) << 16 | (255 & var1[var14 + 1]) << 8 | 255 & var1[var14 + 2];
            var6[var15] = var5[63 & var55 >> 18];
            var6[var15 + 1] = var5[63 & var55 >> 12];
            var6[var15 + 2] = var5[63 & var55 >> 6];
            var6[var15 + 3] = var5[var55 & 63];
            var8 = var14 + 3;
            var64 = var15 + 4;
            --var7;
            if(var7 == 0) {
               if(this.do_cr) {
                  int var56 = var64 + 1;
                  var6[var64] = 13;
                  var64 = var56;
               }

               var15 = var64 + 1;
               var6[var64] = 10;
               var7 = 19;
               var14 = var8;
            } else {
               var14 = var8;
               var15 = var64;
            }
         }

         int var17;
         label121: {
            if(var4) {
               label98: {
                  int var37;
                  int var10000;
                  if(var14 - this.tailLen == var9 - 1) {
                     int var46;
                     byte var45;
                     if(this.tailLen > 0) {
                        byte[] var52 = this.tail;
                        int var53 = 0 + 1;
                        var45 = var52[0];
                        var46 = var53;
                     } else {
                        var10000 = var14 + 1;
                        var45 = var1[var14];
                        var46 = 0;
                     }

                     int var47 = (var45 & 255) << 4;
                     this.tailLen -= var46;
                     int var48 = var15 + 1;
                     var6[var15] = var5[63 & var47 >> 6];
                     int var49 = var48 + 1;
                     var6[var48] = var5[var47 & 63];
                     if(this.do_padding) {
                        int var51 = var49 + 1;
                        var6[var49] = 61;
                        var49 = var51 + 1;
                        var6[var51] = 61;
                     }

                     var17 = var49;
                     if(!this.do_newline) {
                        break label121;
                     }

                     if(this.do_cr) {
                        int var50 = var49 + 1;
                        var6[var49] = 13;
                        var17 = var50;
                     }

                     var37 = var17 + 1;
                     var6[var17] = 10;
                  } else {
                     if(var14 - this.tailLen != var9 - 2) {
                        if(this.do_newline && var15 > 0 && var7 != 19) {
                           int var25;
                           if(this.do_cr) {
                              var25 = var15 + 1;
                              var6[var15] = 13;
                           } else {
                              var25 = var15;
                           }

                           int var26 = var25 + 1;
                           var6[var25] = 10;
                           var17 = var26;
                           break label121;
                        }
                        break label98;
                     }

                     byte var29;
                     int var28;
                     int var30;
                     if(this.tailLen > 1) {
                        byte[] var42 = this.tail;
                        int var43 = 0 + 1;
                        var29 = var42[0];
                        var30 = var43;
                        var28 = var14;
                     } else {
                        var28 = var14 + 1;
                        var29 = var1[var14];
                        var30 = 0;
                     }

                     int var31 = (var29 & 255) << 10;
                     byte var33;
                     if(this.tailLen > 0) {
                        byte[] var40 = this.tail;
                        int var41 = var30 + 1;
                        var33 = var40[var30];
                        var30 = var41;
                     } else {
                        var10000 = var28 + 1;
                        var33 = var1[var28];
                     }

                     int var34 = var31 | (var33 & 255) << 2;
                     this.tailLen -= var30;
                     int var35 = var15 + 1;
                     var6[var15] = var5[63 & var34 >> 12];
                     int var36 = var35 + 1;
                     var6[var35] = var5[63 & var34 >> 6];
                     var17 = var36 + 1;
                     var6[var36] = var5[var34 & 63];
                     if(this.do_padding) {
                        int var39 = var17 + 1;
                        var6[var17] = 61;
                        var17 = var39;
                     }

                     if(!this.do_newline) {
                        break label121;
                     }

                     if(this.do_cr) {
                        int var38 = var17 + 1;
                        var6[var17] = 13;
                        var17 = var38;
                     }

                     var37 = var17 + 1;
                     var6[var17] = 10;
                  }

                  var17 = var37;
                  break label121;
               }
            } else {
               if(var14 == var9 - 1) {
                  byte[] var22 = this.tail;
                  int var23 = this.tailLen;
                  this.tailLen = var23 + 1;
                  var22[var23] = var1[var14];
                  var17 = var15;
                  break label121;
               }

               if(var14 == var9 - 2) {
                  byte[] var18 = this.tail;
                  int var19 = this.tailLen;
                  this.tailLen = var19 + 1;
                  var18[var19] = var1[var14];
                  byte[] var20 = this.tail;
                  int var21 = this.tailLen;
                  this.tailLen = var21 + 1;
                  var20[var21] = var1[var14 + 1];
               }
            }

            var17 = var15;
         }

         this.op = var17;
         this.count = var7;
         return true;
      }
   }
}
