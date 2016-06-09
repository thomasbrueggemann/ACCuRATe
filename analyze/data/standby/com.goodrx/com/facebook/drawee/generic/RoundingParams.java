package com.facebook.drawee.generic;

import com.facebook.common.internal.Preconditions;
import java.util.Arrays;

public class RoundingParams {
   private int mBorderColor;
   private float mBorderWidth;
   private float[] mCornersRadii;
   private int mOverlayColor;
   private float mPadding;
   private boolean mRoundAsCircle;
   private RoundingParams.RoundingMethod mRoundingMethod;

   public RoundingParams() {
      this.mRoundingMethod = RoundingParams.RoundingMethod.BITMAP_ONLY;
      this.mRoundAsCircle = false;
      this.mCornersRadii = null;
      this.mOverlayColor = 0;
      this.mBorderWidth = 0.0F;
      this.mBorderColor = 0;
      this.mPadding = 0.0F;
   }

   public static RoundingParams asCircle() {
      return (new RoundingParams()).setRoundAsCircle(true);
   }

   public static RoundingParams fromCornersRadii(float var0, float var1, float var2, float var3) {
      return (new RoundingParams()).setCornersRadii(var0, var1, var2, var3);
   }

   public static RoundingParams fromCornersRadii(float[] var0) {
      return (new RoundingParams()).setCornersRadii(var0);
   }

   public static RoundingParams fromCornersRadius(float var0) {
      return (new RoundingParams()).setCornersRadius(var0);
   }

   private float[] getOrCreateRoundedCornersRadii() {
      if(this.mCornersRadii == null) {
         this.mCornersRadii = new float[8];
      }

      return this.mCornersRadii;
   }

   public boolean equals(Object var1) {
      boolean var2;
      if(this == var1) {
         var2 = true;
      } else {
         var2 = false;
         if(var1 != null) {
            Class var3 = this.getClass();
            Class var4 = var1.getClass();
            var2 = false;
            if(var3 == var4) {
               RoundingParams var5 = (RoundingParams)var1;
               boolean var6 = this.mRoundAsCircle;
               boolean var7 = var5.mRoundAsCircle;
               var2 = false;
               if(var6 == var7) {
                  int var8 = this.mOverlayColor;
                  int var9 = var5.mOverlayColor;
                  var2 = false;
                  if(var8 == var9) {
                     int var10 = Float.compare(var5.mBorderWidth, this.mBorderWidth);
                     var2 = false;
                     if(var10 == 0) {
                        int var11 = this.mBorderColor;
                        int var12 = var5.mBorderColor;
                        var2 = false;
                        if(var11 == var12) {
                           int var13 = Float.compare(var5.mPadding, this.mPadding);
                           var2 = false;
                           if(var13 == 0) {
                              RoundingParams.RoundingMethod var14 = this.mRoundingMethod;
                              RoundingParams.RoundingMethod var15 = var5.mRoundingMethod;
                              var2 = false;
                              if(var14 == var15) {
                                 return Arrays.equals(this.mCornersRadii, var5.mCornersRadii);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public int getBorderColor() {
      return this.mBorderColor;
   }

   public float getBorderWidth() {
      return this.mBorderWidth;
   }

   public float[] getCornersRadii() {
      return this.mCornersRadii;
   }

   public int getOverlayColor() {
      return this.mOverlayColor;
   }

   public float getPadding() {
      return this.mPadding;
   }

   public boolean getRoundAsCircle() {
      return this.mRoundAsCircle;
   }

   public RoundingParams.RoundingMethod getRoundingMethod() {
      return this.mRoundingMethod;
   }

   public int hashCode() {
      int var1;
      if(this.mRoundingMethod != null) {
         var1 = this.mRoundingMethod.hashCode();
      } else {
         var1 = 0;
      }

      int var2 = var1 * 31;
      byte var3;
      if(this.mRoundAsCircle) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      int var4 = 31 * (var2 + var3);
      int var5;
      if(this.mCornersRadii != null) {
         var5 = Arrays.hashCode(this.mCornersRadii);
      } else {
         var5 = 0;
      }

      int var6 = 31 * (31 * (var4 + var5) + this.mOverlayColor);
      int var7;
      if(this.mBorderWidth != 0.0F) {
         var7 = Float.floatToIntBits(this.mBorderWidth);
      } else {
         var7 = 0;
      }

      int var8 = 31 * (31 * (var6 + var7) + this.mBorderColor);
      float var11;
      int var9 = (var11 = this.mPadding - 0.0F) == 0.0F?0:(var11 < 0.0F?-1:1);
      int var10 = 0;
      if(var9 != 0) {
         var10 = Float.floatToIntBits(this.mPadding);
      }

      return var8 + var10;
   }

   public RoundingParams setBorder(int var1, float var2) {
      boolean var3;
      if(var2 >= 0.0F) {
         var3 = true;
      } else {
         var3 = false;
      }

      Preconditions.checkArgument(var3, "the border width cannot be < 0");
      this.mBorderWidth = var2;
      this.mBorderColor = var1;
      return this;
   }

   public RoundingParams setCornersRadii(float var1, float var2, float var3, float var4) {
      float[] var5 = this.getOrCreateRoundedCornersRadii();
      var5[1] = var1;
      var5[0] = var1;
      var5[3] = var2;
      var5[2] = var2;
      var5[5] = var3;
      var5[4] = var3;
      var5[7] = var4;
      var5[6] = var4;
      return this;
   }

   public RoundingParams setCornersRadii(float[] var1) {
      Preconditions.checkNotNull(var1);
      boolean var3;
      if(var1.length == 8) {
         var3 = true;
      } else {
         var3 = false;
      }

      Preconditions.checkArgument(var3, "radii should have exactly 8 values");
      System.arraycopy(var1, 0, this.getOrCreateRoundedCornersRadii(), 0, 8);
      return this;
   }

   public RoundingParams setCornersRadius(float var1) {
      Arrays.fill(this.getOrCreateRoundedCornersRadii(), var1);
      return this;
   }

   public RoundingParams setOverlayColor(int var1) {
      this.mOverlayColor = var1;
      this.mRoundingMethod = RoundingParams.RoundingMethod.OVERLAY_COLOR;
      return this;
   }

   public RoundingParams setPadding(float var1) {
      boolean var2;
      if(var1 >= 0.0F) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2, "the padding cannot be < 0");
      this.mPadding = var1;
      return this;
   }

   public RoundingParams setRoundAsCircle(boolean var1) {
      this.mRoundAsCircle = var1;
      return this;
   }

   public RoundingParams setRoundingMethod(RoundingParams.RoundingMethod var1) {
      this.mRoundingMethod = var1;
      return this;
   }

   public static enum RoundingMethod {
      BITMAP_ONLY,
      OVERLAY_COLOR;

      static {
         RoundingParams.RoundingMethod[] var0 = new RoundingParams.RoundingMethod[]{OVERLAY_COLOR, BITMAP_ONLY};
      }
   }
}
