package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import javax.annotation.Nullable;

public class WrappingUtils {
   private static final Drawable sEmptyDrawable = new ColorDrawable(0);

   private static Drawable applyLeafRounding(Drawable var0, RoundingParams var1, Resources var2) {
      if(var0 instanceof BitmapDrawable) {
         RoundedBitmapDrawable var4 = RoundedBitmapDrawable.fromBitmapDrawable(var2, (BitmapDrawable)var0);
         applyRoundingParams(var4, var1);
         return var4;
      } else if(var0 instanceof ColorDrawable && VERSION.SDK_INT >= 11) {
         RoundedColorDrawable var3 = RoundedColorDrawable.fromColorDrawable((ColorDrawable)var0);
         applyRoundingParams(var3, var1);
         return var3;
      } else {
         return var0;
      }
   }

   static void applyRoundingParams(Rounded var0, RoundingParams var1) {
      var0.setCircle(var1.getRoundAsCircle());
      var0.setRadii(var1.getCornersRadii());
      var0.setBorder(var1.getBorderColor(), var1.getBorderWidth());
      var0.setPadding(var1.getPadding());
   }

   static DrawableParent findDrawableParentForLeaf(DrawableParent var0) {
      while(true) {
         Drawable var1 = var0.getDrawable();
         if(var1 == var0 || !(var1 instanceof DrawableParent)) {
            return var0;
         }

         var0 = (DrawableParent)var1;
      }
   }

   static Drawable maybeApplyLeafRounding(@Nullable Drawable var0, @Nullable RoundingParams var1, Resources var2) {
      if(var0 != null && var1 != null && var1.getRoundingMethod() == RoundingParams.RoundingMethod.BITMAP_ONLY) {
         if(var0 instanceof ForwardingDrawable) {
            DrawableParent var3 = findDrawableParentForLeaf((ForwardingDrawable)var0);
            var3.setDrawable(applyLeafRounding(var3.setDrawable(sEmptyDrawable), var1, var2));
            return var0;
         } else {
            return applyLeafRounding(var0, var1, var2);
         }
      } else {
         return var0;
      }
   }

   @Nullable
   static Drawable maybeWrapWithMatrix(@Nullable Drawable var0, @Nullable Matrix var1) {
      return (Drawable)(var0 != null && var1 != null?new MatrixDrawable(var0, var1):var0);
   }

   static Drawable maybeWrapWithRoundedOverlayColor(@Nullable Drawable var0, @Nullable RoundingParams var1) {
      if(var0 != null && var1 != null && var1.getRoundingMethod() == RoundingParams.RoundingMethod.OVERLAY_COLOR) {
         RoundedCornersDrawable var2 = new RoundedCornersDrawable(var0);
         applyRoundingParams(var2, var1);
         var2.setOverlayColor(var1.getOverlayColor());
         return var2;
      } else {
         return var0;
      }
   }

   @Nullable
   static Drawable maybeWrapWithScaleType(@Nullable Drawable var0, @Nullable ScalingUtils.ScaleType var1) {
      return maybeWrapWithScaleType(var0, var1, (PointF)null);
   }

   @Nullable
   static Drawable maybeWrapWithScaleType(@Nullable Drawable var0, @Nullable ScalingUtils.ScaleType var1, @Nullable PointF var2) {
      Object var3;
      if(var0 != null && var1 != null) {
         var3 = new ScaleTypeDrawable(var0, var1);
         if(var2 != null) {
            ((ScaleTypeDrawable)var3).setFocusPoint(var2);
            return (Drawable)var3;
         }
      } else {
         var3 = var0;
      }

      return (Drawable)var3;
   }

   static void resetRoundingParams(Rounded var0) {
      var0.setCircle(false);
      var0.setRadius(0.0F);
      var0.setBorder(0, 0.0F);
      var0.setPadding(0.0F);
   }

   static void updateLeafRounding(DrawableParent var0, @Nullable RoundingParams var1, Resources var2) {
      DrawableParent var3 = findDrawableParentForLeaf(var0);
      Drawable var4 = var3.getDrawable();
      if(var1 != null && var1.getRoundingMethod() == RoundingParams.RoundingMethod.BITMAP_ONLY) {
         if(var4 instanceof Rounded) {
            applyRoundingParams((Rounded)var4, var1);
         } else if(var4 != null) {
            var3.setDrawable(sEmptyDrawable);
            var3.setDrawable(applyLeafRounding(var4, var1, var2));
            return;
         }
      } else if(var4 instanceof Rounded) {
         resetRoundingParams((Rounded)var4);
         return;
      }

   }

   static void updateOverlayColorRounding(DrawableParent var0, @Nullable RoundingParams var1) {
      Drawable var2 = var0.getDrawable();
      if(var1 != null && var1.getRoundingMethod() == RoundingParams.RoundingMethod.OVERLAY_COLOR) {
         if(!(var2 instanceof RoundedCornersDrawable)) {
            var0.setDrawable(maybeWrapWithRoundedOverlayColor(var0.setDrawable(sEmptyDrawable), var1));
            return;
         }

         RoundedCornersDrawable var5 = (RoundedCornersDrawable)var2;
         applyRoundingParams(var5, var1);
         var5.setOverlayColor(var1.getOverlayColor());
      } else if(var2 instanceof RoundedCornersDrawable) {
         var0.setDrawable(((RoundedCornersDrawable)var2).setCurrent(sEmptyDrawable));
         sEmptyDrawable.setCallback((Callback)null);
         return;
      }

   }

   static ScaleTypeDrawable wrapChildWithScaleType(DrawableParent var0, ScalingUtils.ScaleType var1) {
      Drawable var2 = maybeWrapWithScaleType(var0.setDrawable(sEmptyDrawable), var1);
      var0.setDrawable(var2);
      Preconditions.checkNotNull(var2, "Parent has no child drawable!");
      return (ScaleTypeDrawable)var2;
   }
}
