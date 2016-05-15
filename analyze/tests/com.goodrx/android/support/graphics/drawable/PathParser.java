package android.support.graphics.drawable;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

class PathParser {
   private static final String LOGTAG = "PathParser";

   private static void addNode(ArrayList<PathParser.PathDataNode> var0, char var1, float[] var2) {
      var0.add(new PathParser.PathDataNode(var1, var2));
   }

   public static boolean canMorph(PathParser.PathDataNode[] var0, PathParser.PathDataNode[] var1) {
      if(var0 != null && var1 != null && var0.length == var1.length) {
         int var2 = 0;

         while(true) {
            if(var2 >= var0.length) {
               return true;
            }

            if(var0[var2].type != var1[var2].type || var0[var2].params.length != var1[var2].params.length) {
               break;
            }

            ++var2;
         }
      }

      return false;
   }

   private static float[] copyOfRange(float[] var0, int var1, int var2) {
      if(var1 > var2) {
         throw new IllegalArgumentException();
      } else {
         int var3 = var0.length;
         if(var1 >= 0 && var1 <= var3) {
            int var4 = var2 - var1;
            int var5 = Math.min(var4, var3 - var1);
            float[] var6 = new float[var4];
            System.arraycopy(var0, var1, var6, 0, var5);
            return var6;
         } else {
            throw new ArrayIndexOutOfBoundsException();
         }
      }
   }

   public static PathParser.PathDataNode[] createNodesFromPathData(String var0) {
      if(var0 == null) {
         return null;
      } else {
         int var1 = 0;
         int var2 = 1;

         ArrayList var3;
         int var4;
         for(var3 = new ArrayList(); var2 < var0.length(); var2 = var4 + 1) {
            var4 = nextStart(var0, var2);
            String var5 = var0.substring(var1, var4).trim();
            if(var5.length() > 0) {
               float[] var6 = getFloats(var5);
               addNode(var3, var5.charAt(0), var6);
            }

            var1 = var4;
         }

         if(var2 - var1 == 1 && var1 < var0.length()) {
            addNode(var3, var0.charAt(var1), new float[0]);
         }

         return (PathParser.PathDataNode[])var3.toArray(new PathParser.PathDataNode[var3.size()]);
      }
   }

   public static Path createPathFromPathData(String var0) {
      Path var1 = new Path();
      PathParser.PathDataNode[] var2 = createNodesFromPathData(var0);
      if(var2 != null) {
         try {
            PathParser.PathDataNode.nodesToPath(var2, var1);
            return var1;
         } catch (RuntimeException var4) {
            throw new RuntimeException("Error in parsing " + var0, var4);
         }
      } else {
         return null;
      }
   }

   public static PathParser.PathDataNode[] deepCopyNodes(PathParser.PathDataNode[] var0) {
      PathParser.PathDataNode[] var1;
      if(var0 == null) {
         var1 = null;
      } else {
         var1 = new PathParser.PathDataNode[var0.length];

         for(int var2 = 0; var2 < var0.length; ++var2) {
            var1[var2] = new PathParser.PathDataNode(var0[var2]);
         }
      }

      return var1;
   }

   private static void extract(String var0, int var1, PathParser.ExtractFloatResult var2) {
      int var3 = var1;
      boolean var4 = false;
      var2.mEndWithNegOrDot = false;
      boolean var5 = false;

      for(boolean var6 = false; var3 < var0.length(); ++var3) {
         boolean var7 = var6;
         char var8 = var0.charAt(var3);
         var6 = false;
         switch(var8) {
         case ' ':
         case ',':
            var4 = true;
            var6 = false;
            break;
         case '-':
            var6 = false;
            if(var3 != var1) {
               var6 = false;
               if(!var7) {
                  var4 = true;
                  var2.mEndWithNegOrDot = true;
                  var6 = false;
               }
            }
            break;
         case '.':
            if(!var5) {
               var5 = true;
               var6 = false;
            } else {
               var4 = true;
               var2.mEndWithNegOrDot = true;
               var6 = false;
            }
            break;
         case 'E':
         case 'e':
            var6 = true;
         }

         if(var4) {
            break;
         }
      }

      var2.mEndPosition = var3;
   }

   private static float[] getFloats(String param0) {
      // $FF: Couldn't be decompiled
   }

   private static int nextStart(String var0, int var1) {
      while(var1 < var0.length()) {
         char var2 = var0.charAt(var1);
         if(((var2 - 65) * (var2 - 90) <= 0 || (var2 - 97) * (var2 - 122) <= 0) && var2 != 101 && var2 != 69) {
            break;
         }

         ++var1;
      }

      return var1;
   }

   public static void updateNodes(PathParser.PathDataNode[] var0, PathParser.PathDataNode[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         var0[var2].type = var1[var2].type;

         for(int var3 = 0; var3 < var1[var2].params.length; ++var3) {
            var0[var2].params[var3] = var1[var2].params[var3];
         }
      }

   }

   private static class ExtractFloatResult {
      int mEndPosition;
      boolean mEndWithNegOrDot;

      private ExtractFloatResult() {
      }

      // $FF: synthetic method
      ExtractFloatResult(Object var1) {
         this();
      }
   }

   public static class PathDataNode {
      float[] params;
      char type;

      private PathDataNode(char var1, float[] var2) {
         this.type = var1;
         this.params = var2;
      }

      // $FF: synthetic method
      PathDataNode(char var1, float[] var2, Object var3) {
         this(var1, var2);
      }

      private PathDataNode(PathParser.PathDataNode var1) {
         this.type = var1.type;
         this.params = PathParser.copyOfRange(var1.params, 0, var1.params.length);
      }

      // $FF: synthetic method
      PathDataNode(PathParser.PathDataNode var1, Object var2) {
         this(var1);
      }

      private static void addCommand(Path var0, float[] var1, char var2, char var3, float[] var4) {
         byte var5 = 2;
         float var6 = var1[0];
         float var7 = var1[1];
         float var8 = var1[2];
         float var9 = var1[3];
         float var10 = var1[4];
         float var11 = var1[5];
         switch(var3) {
         case 'A':
         case 'a':
            var5 = 7;
            break;
         case 'C':
         case 'c':
            var5 = 6;
            break;
         case 'H':
         case 'V':
         case 'h':
         case 'v':
            var5 = 1;
            break;
         case 'L':
         case 'M':
         case 'T':
         case 'l':
         case 'm':
         case 't':
            var5 = 2;
            break;
         case 'Q':
         case 'S':
         case 'q':
         case 's':
            var5 = 4;
            break;
         case 'Z':
         case 'z':
            var0.close();
            var6 = var10;
            var7 = var11;
            var8 = var10;
            var9 = var11;
            var0.moveTo(var10, var11);
         }

         int var12 = 0;

         while(true) {
            int var13 = var4.length;
            if(var12 >= var13) {
               var1[0] = var6;
               var1[1] = var7;
               var1[2] = var8;
               var1[3] = var9;
               var1[4] = var10;
               var1[5] = var11;
               return;
            }

            switch(var3) {
            case 'A':
               float var14 = var4[var12 + 5];
               float var15 = var4[var12 + 6];
               float var16 = var4[var12 + 0];
               float var17 = var4[var12 + 1];
               float var18 = var4[var12 + 2];
               boolean var19;
               if(var4[var12 + 3] != 0.0F) {
                  var19 = true;
               } else {
                  var19 = false;
               }

               boolean var20;
               if(var4[var12 + 4] != 0.0F) {
                  var20 = true;
               } else {
                  var20 = false;
               }

               drawArc(var0, var6, var7, var14, var15, var16, var17, var18, var19, var20);
               var6 = var4[var12 + 5];
               var7 = var4[var12 + 6];
               var8 = var6;
               var9 = var7;
               break;
            case 'C':
               var0.cubicTo(var4[var12 + 0], var4[var12 + 1], var4[var12 + 2], var4[var12 + 3], var4[var12 + 4], var4[var12 + 5]);
               var6 = var4[var12 + 4];
               var7 = var4[var12 + 5];
               var8 = var4[var12 + 2];
               var9 = var4[var12 + 3];
               break;
            case 'H':
               var0.lineTo(var4[var12 + 0], var7);
               var6 = var4[var12 + 0];
               break;
            case 'L':
               var0.lineTo(var4[var12 + 0], var4[var12 + 1]);
               var6 = var4[var12 + 0];
               var7 = var4[var12 + 1];
               break;
            case 'M':
               var6 = var4[var12 + 0];
               var7 = var4[var12 + 1];
               if(var12 > 0) {
                  var0.lineTo(var4[var12 + 0], var4[var12 + 1]);
               } else {
                  var0.moveTo(var4[var12 + 0], var4[var12 + 1]);
                  var10 = var6;
                  var11 = var7;
               }
               break;
            case 'Q':
               var0.quadTo(var4[var12 + 0], var4[var12 + 1], var4[var12 + 2], var4[var12 + 3]);
               var8 = var4[var12 + 0];
               var9 = var4[var12 + 1];
               var6 = var4[var12 + 2];
               var7 = var4[var12 + 3];
               break;
            case 'S':
               float var33 = var6;
               float var34 = var7;
               if(var2 == 99 || var2 == 115 || var2 == 67 || var2 == 83) {
                  var33 = 2.0F * var6 - var8;
                  var34 = 2.0F * var7 - var9;
               }

               var0.cubicTo(var33, var34, var4[var12 + 0], var4[var12 + 1], var4[var12 + 2], var4[var12 + 3]);
               var8 = var4[var12 + 0];
               var9 = var4[var12 + 1];
               var6 = var4[var12 + 2];
               var7 = var4[var12 + 3];
               break;
            case 'T':
               float var28 = var6;
               float var29 = var7;
               if(var2 == 113 || var2 == 116 || var2 == 81 || var2 == 84) {
                  var28 = 2.0F * var6 - var8;
                  var29 = 2.0F * var7 - var9;
               }

               var0.quadTo(var28, var29, var4[var12 + 0], var4[var12 + 1]);
               var8 = var28;
               var9 = var29;
               var6 = var4[var12 + 0];
               var7 = var4[var12 + 1];
               break;
            case 'V':
               float var38 = var4[var12 + 0];
               var0.lineTo(var6, var38);
               var7 = var4[var12 + 0];
               break;
            case 'a':
               float var21 = var6 + var4[var12 + 5];
               float var22 = var7 + var4[var12 + 6];
               float var23 = var4[var12 + 0];
               float var24 = var4[var12 + 1];
               float var25 = var4[var12 + 2];
               boolean var26;
               if(var4[var12 + 3] != 0.0F) {
                  var26 = true;
               } else {
                  var26 = false;
               }

               boolean var27;
               if(var4[var12 + 4] != 0.0F) {
                  var27 = true;
               } else {
                  var27 = false;
               }

               drawArc(var0, var6, var7, var21, var22, var23, var24, var25, var26, var27);
               var6 += var4[var12 + 5];
               var7 += var4[var12 + 6];
               var8 = var6;
               var9 = var7;
               break;
            case 'c':
               var0.rCubicTo(var4[var12 + 0], var4[var12 + 1], var4[var12 + 2], var4[var12 + 3], var4[var12 + 4], var4[var12 + 5]);
               var8 = var6 + var4[var12 + 2];
               var9 = var7 + var4[var12 + 3];
               var6 += var4[var12 + 4];
               var7 += var4[var12 + 5];
               break;
            case 'h':
               var0.rLineTo(var4[var12 + 0], 0.0F);
               var6 += var4[var12 + 0];
               break;
            case 'l':
               var0.rLineTo(var4[var12 + 0], var4[var12 + 1]);
               var6 += var4[var12 + 0];
               var7 += var4[var12 + 1];
               break;
            case 'm':
               var6 += var4[var12 + 0];
               var7 += var4[var12 + 1];
               if(var12 > 0) {
                  var0.rLineTo(var4[var12 + 0], var4[var12 + 1]);
               } else {
                  var0.rMoveTo(var4[var12 + 0], var4[var12 + 1]);
                  var10 = var6;
                  var11 = var7;
               }
               break;
            case 'q':
               var0.rQuadTo(var4[var12 + 0], var4[var12 + 1], var4[var12 + 2], var4[var12 + 3]);
               var8 = var6 + var4[var12 + 0];
               var9 = var7 + var4[var12 + 1];
               var6 += var4[var12 + 2];
               var7 += var4[var12 + 3];
               break;
            case 's':
               float var35;
               float var36;
               label98: {
                  if(var2 != 99 && var2 != 115 && var2 != 67) {
                     var35 = 0.0F;
                     var36 = 0.0F;
                     if(var2 != 83) {
                        break label98;
                     }
                  }

                  var35 = var6 - var8;
                  var36 = var7 - var9;
               }

               var0.rCubicTo(var35, var36, var4[var12 + 0], var4[var12 + 1], var4[var12 + 2], var4[var12 + 3]);
               var8 = var6 + var4[var12 + 0];
               var9 = var7 + var4[var12 + 1];
               var6 += var4[var12 + 2];
               var7 += var4[var12 + 3];
               break;
            case 't':
               float var31;
               float var30;
               label91: {
                  if(var2 != 113 && var2 != 116 && var2 != 81) {
                     var30 = 0.0F;
                     var31 = 0.0F;
                     if(var2 != 84) {
                        break label91;
                     }
                  }

                  var30 = var6 - var8;
                  var31 = var7 - var9;
               }

               var0.rQuadTo(var30, var31, var4[var12 + 0], var4[var12 + 1]);
               var8 = var6 + var30;
               var9 = var7 + var31;
               var6 += var4[var12 + 0];
               var7 += var4[var12 + 1];
               break;
            case 'v':
               var0.rLineTo(0.0F, var4[var12 + 0]);
               var7 += var4[var12 + 0];
            }

            var2 = var3;
            var12 += var5;
         }
      }

      private static void arcToBezier(Path var0, double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17) {
         int var19 = (int)Math.ceil(Math.abs(4.0D * var17 / 3.141592653589793D));
         double var20 = var15;
         double var22 = Math.cos(var13);
         double var24 = Math.sin(var13);
         double var26 = Math.cos(var15);
         double var28 = Math.sin(var15);
         double var30 = var28 * var22 * -var5 - var26 * var7 * var24;
         double var32 = var28 * var24 * -var5 + var26 * var7 * var22;
         double var34 = var17 / (double)var19;

         for(int var36 = 0; var36 < var19; ++var36) {
            double var37 = var20 + var34;
            double var39 = Math.sin(var37);
            double var41 = Math.cos(var37);
            double var43 = var1 + var41 * var5 * var22 - var39 * var7 * var24;
            double var45 = var3 + var41 * var5 * var24 + var39 * var7 * var22;
            double var47 = var39 * var22 * -var5 - var41 * var7 * var24;
            double var49 = var39 * var24 * -var5 + var41 * var7 * var22;
            double var51 = Math.tan((var37 - var20) / 2.0D);
            double var53 = Math.sin(var37 - var20) * (Math.sqrt(4.0D + var51 * 3.0D * var51) - 1.0D) / 3.0D;
            double var55 = var9 + var53 * var30;
            double var57 = var11 + var53 * var32;
            double var59 = var43 - var53 * var47;
            double var61 = var45 - var53 * var49;
            var0.cubicTo((float)var55, (float)var57, (float)var59, (float)var61, (float)var43, (float)var45);
            var20 = var37;
            var9 = var43;
            var11 = var45;
            var30 = var47;
            var32 = var49;
         }

      }

      private static void drawArc(Path var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, boolean var8, boolean var9) {
         double var10 = Math.toRadians((double)var7);
         double var12 = Math.cos(var10);
         double var14 = Math.sin(var10);
         double var16 = (var12 * (double)var1 + var14 * (double)var2) / (double)var5;
         double var18 = (var14 * (double)(-var1) + var12 * (double)var2) / (double)var6;
         double var20 = (var12 * (double)var3 + var14 * (double)var4) / (double)var5;
         double var22 = (var14 * (double)(-var3) + var12 * (double)var4) / (double)var6;
         double var24 = var16 - var20;
         double var26 = var18 - var22;
         double var28 = (var16 + var20) / 2.0D;
         double var30 = (var18 + var22) / 2.0D;
         double var32 = var24 * var24 + var26 * var26;
         if(var32 == 0.0D) {
            Log.w("PathParser", " Points are coincident");
         } else {
            double var34 = 1.0D / var32 - 0.25D;
            if(var34 < 0.0D) {
               Log.w("PathParser", "Points are too far apart " + var32);
               float var56 = (float)(Math.sqrt(var32) / 1.99999D);
               drawArc(var0, var1, var2, var3, var4, var5 * var56, var6 * var56, var7, var8, var9);
            } else {
               double var36 = Math.sqrt(var34);
               double var38 = var36 * var24;
               double var40 = var36 * var26;
               double var42;
               double var44;
               if(var8 == var9) {
                  var42 = var28 - var40;
                  var44 = var30 + var38;
               } else {
                  var42 = var28 + var40;
                  var44 = var30 - var38;
               }

               double var46 = Math.atan2(var18 - var44, var16 - var42);
               double var48 = Math.atan2(var22 - var44, var20 - var42) - var46;
               boolean var50;
               if(var48 >= 0.0D) {
                  var50 = true;
               } else {
                  var50 = false;
               }

               if(var9 != var50) {
                  if(var48 > 0.0D) {
                     var48 -= 6.283185307179586D;
                  } else {
                     var48 += 6.283185307179586D;
                  }
               }

               double var51 = var42 * (double)var5;
               double var53 = var44 * (double)var6;
               arcToBezier(var0, var51 * var12 - var53 * var14, var51 * var14 + var53 * var12, (double)var5, (double)var6, (double)var1, (double)var2, var10, var46, var48);
            }
         }
      }

      public static void nodesToPath(PathParser.PathDataNode[] var0, Path var1) {
         float[] var2 = new float[6];
         char var3 = 109;

         for(int var4 = 0; var4 < var0.length; ++var4) {
            addCommand(var1, var2, var3, var0[var4].type, var0[var4].params);
            var3 = var0[var4].type;
         }

      }

      public void interpolatePathDataNode(PathParser.PathDataNode var1, PathParser.PathDataNode var2, float var3) {
         for(int var4 = 0; var4 < var1.params.length; ++var4) {
            this.params[var4] = var1.params[var4] * (1.0F - var3) + var3 * var2.params[var4];
         }

      }
   }
}
