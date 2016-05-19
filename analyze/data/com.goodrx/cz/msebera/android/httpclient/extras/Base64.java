package cz.msebera.android.httpclient.extras;

public class Base64 {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;

   static {
      boolean var0;
      if(!Base64.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public static byte[] decode(byte[] var0, int var1) {
      return decode(var0, 0, var0.length, var1);
   }

   public static byte[] decode(byte[] var0, int var1, int var2, int var3) {
      Base64.Decoder var4 = new Base64.Decoder(var3, new byte[var2 * 3 / 4]);
      if(!var4.process(var0, var1, var2, true)) {
         throw new IllegalArgumentException("bad base-64");
      } else if(var4.op == var4.output.length) {
         return var4.output;
      } else {
         byte[] var5 = new byte[var4.op];
         System.arraycopy(var4.output, 0, var5, 0, var4.op);
         return var5;
      }
   }

   public static byte[] encode(byte[] var0, int var1) {
      return encode(var0, 0, var0.length, var1);
   }

   public static byte[] encode(byte[] var0, int var1, int var2, int var3) {
      Base64.Encoder var4 = new Base64.Encoder(var3, (byte[])null);
      int var5 = 4 * (var2 / 3);
      if(var4.do_padding) {
         if(var2 % 3 > 0) {
            var5 += 4;
         }
      } else {
         switch(var2 % 3) {
         case 0:
         default:
            break;
         case 1:
            var5 += 2;
            break;
         case 2:
            var5 += 3;
         }
      }

      if(var4.do_newline && var2 > 0) {
         int var7 = 1 + (var2 - 1) / 57;
         byte var8;
         if(var4.do_cr) {
            var8 = 2;
         } else {
            var8 = 1;
         }

         var5 += var8 * var7;
      }

      var4.output = new byte[var5];
      var4.process(var0, var1, var2, true);
      if(!$assertionsDisabled && var4.op != var5) {
         throw new AssertionError();
      } else {
         return var4.output;
      }
   }

   abstract static class Coder {
      // $FF: renamed from: op int
      public int field_0;
      public byte[] output;
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
      // $FF: synthetic field
      static final boolean $assertionsDisabled;
      private static final byte[] ENCODE;
      private static final byte[] ENCODE_WEBSAFE;
      private final byte[] alphabet;
      private int count;
      public final boolean do_cr;
      public final boolean do_newline;
      public final boolean do_padding;
      private final byte[] tail;
      int tailLen;

      static {
         boolean var0;
         if(!Base64.class.desiredAssertionStatus()) {
            var0 = true;
         } else {
            var0 = false;
         }

         $assertionsDisabled = var0;
         ENCODE = new byte[]{(byte)65, (byte)66, (byte)67, (byte)68, (byte)69, (byte)70, (byte)71, (byte)72, (byte)73, (byte)74, (byte)75, (byte)76, (byte)77, (byte)78, (byte)79, (byte)80, (byte)81, (byte)82, (byte)83, (byte)84, (byte)85, (byte)86, (byte)87, (byte)88, (byte)89, (byte)90, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102, (byte)103, (byte)104, (byte)105, (byte)106, (byte)107, (byte)108, (byte)109, (byte)110, (byte)111, (byte)112, (byte)113, (byte)114, (byte)115, (byte)116, (byte)117, (byte)118, (byte)119, (byte)120, (byte)121, (byte)122, (byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)43, (byte)47};
         ENCODE_WEBSAFE = new byte[]{(byte)65, (byte)66, (byte)67, (byte)68, (byte)69, (byte)70, (byte)71, (byte)72, (byte)73, (byte)74, (byte)75, (byte)76, (byte)77, (byte)78, (byte)79, (byte)80, (byte)81, (byte)82, (byte)83, (byte)84, (byte)85, (byte)86, (byte)87, (byte)88, (byte)89, (byte)90, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102, (byte)103, (byte)104, (byte)105, (byte)106, (byte)107, (byte)108, (byte)109, (byte)110, (byte)111, (byte)112, (byte)113, (byte)114, (byte)115, (byte)116, (byte)117, (byte)118, (byte)119, (byte)120, (byte)121, (byte)122, (byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)45, (byte)95};
      }

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
               int var57 = (255 & this.tail[0]) << 16;
               int var58 = var2 + 1;
               int var59 = var57 | (255 & var1[var2]) << 8;
               var8 = var58 + 1;
               var10 = var59 | 255 & var1[var58];
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
         int var60;
         if(var10 != -1) {
            int var53 = 0 + 1;
            var6[0] = var5[63 & var10 >> 18];
            int var54 = var53 + 1;
            var6[var53] = var5[63 & var10 >> 12];
            int var55 = var54 + 1;
            var6[var54] = var5[63 & var10 >> 6];
            var60 = var55 + 1;
            var6[var55] = var5[var10 & 63];
            --var7;
            if(var7 == 0) {
               if(this.do_cr) {
                  int var56 = var60 + 1;
                  var6[var60] = 13;
                  var60 = var56;
               }

               var15 = var60 + 1;
               var6[var60] = 10;
               var7 = 19;
               var14 = var8;
            } else {
               var14 = var8;
               var15 = var60;
            }
         } else {
            var14 = var8;
            var15 = var13;
         }

         while(var14 + 3 <= var9) {
            int var51 = (255 & var1[var14]) << 16 | (255 & var1[var14 + 1]) << 8 | 255 & var1[var14 + 2];
            var6[var15] = var5[63 & var51 >> 18];
            var6[var15 + 1] = var5[63 & var51 >> 12];
            var6[var15 + 2] = var5[63 & var51 >> 6];
            var6[var15 + 3] = var5[var51 & 63];
            var8 = var14 + 3;
            var60 = var15 + 4;
            --var7;
            if(var7 == 0) {
               if(this.do_cr) {
                  int var52 = var60 + 1;
                  var6[var60] = 13;
                  var60 = var52;
               }

               var15 = var60 + 1;
               var6[var60] = 10;
               var7 = 19;
               var14 = var8;
            } else {
               var14 = var8;
               var15 = var60;
            }
         }

         int var17;
         if(var4) {
            int var25;
            label110: {
               int var35;
               if(var14 - this.tailLen == var9 - 1) {
                  byte var42;
                  int var43;
                  if(this.tailLen > 0) {
                     byte[] var49 = this.tail;
                     int var50 = 0 + 1;
                     var42 = var49[0];
                     var43 = var50;
                     var25 = var14;
                  } else {
                     var25 = var14 + 1;
                     var42 = var1[var14];
                     var43 = 0;
                  }

                  int var44 = (var42 & 255) << 4;
                  this.tailLen -= var43;
                  int var45 = var15 + 1;
                  var6[var15] = var5[63 & var44 >> 6];
                  int var46 = var45 + 1;
                  var6[var45] = var5[var44 & 63];
                  if(this.do_padding) {
                     int var48 = var46 + 1;
                     var6[var46] = 61;
                     var46 = var48 + 1;
                     var6[var48] = 61;
                  }

                  var17 = var46;
                  if(!this.do_newline) {
                     break label110;
                  }

                  if(this.do_cr) {
                     int var47 = var46 + 1;
                     var6[var46] = 13;
                     var17 = var47;
                  }

                  var35 = var17 + 1;
                  var6[var17] = 10;
               } else {
                  if(var14 - this.tailLen != var9 - 2) {
                     if(this.do_newline && var15 > 0 && var7 != 19) {
                        int var26;
                        if(this.do_cr) {
                           var26 = var15 + 1;
                           var6[var15] = 13;
                        } else {
                           var26 = var15;
                        }

                        var15 = var26 + 1;
                        var6[var26] = 10;
                     }

                     var25 = var14;
                     var17 = var15;
                     break label110;
                  }

                  byte var27;
                  int var28;
                  if(this.tailLen > 1) {
                     byte[] var40 = this.tail;
                     int var41 = 0 + 1;
                     var27 = var40[0];
                     var28 = var41;
                     var25 = var14;
                  } else {
                     var25 = var14 + 1;
                     var27 = var1[var14];
                     var28 = 0;
                  }

                  int var29 = (var27 & 255) << 10;
                  byte var31;
                  if(this.tailLen > 0) {
                     byte[] var38 = this.tail;
                     int var39 = var28 + 1;
                     var31 = var38[var28];
                     var28 = var39;
                  } else {
                     int var30 = var25 + 1;
                     var31 = var1[var25];
                     var25 = var30;
                  }

                  int var32 = var29 | (var31 & 255) << 2;
                  this.tailLen -= var28;
                  int var33 = var15 + 1;
                  var6[var15] = var5[63 & var32 >> 12];
                  int var34 = var33 + 1;
                  var6[var33] = var5[63 & var32 >> 6];
                  var17 = var34 + 1;
                  var6[var34] = var5[var32 & 63];
                  if(this.do_padding) {
                     int var37 = var17 + 1;
                     var6[var17] = 61;
                     var17 = var37;
                  }

                  if(!this.do_newline) {
                     break label110;
                  }

                  if(this.do_cr) {
                     int var36 = var17 + 1;
                     var6[var17] = 13;
                     var17 = var36;
                  }

                  var35 = var17 + 1;
                  var6[var17] = 10;
               }

               var17 = var35;
            }

            if(!$assertionsDisabled && this.tailLen != 0) {
               throw new AssertionError();
            }

            if(!$assertionsDisabled && var25 != var9) {
               throw new AssertionError();
            }
         } else if(var14 == var9 - 1) {
            byte[] var22 = this.tail;
            int var23 = this.tailLen;
            this.tailLen = var23 + 1;
            var22[var23] = var1[var14];
            var17 = var15;
         } else {
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

            var17 = var15;
         }

         this.op = var17;
         this.count = var7;
         return true;
      }
   }
}
