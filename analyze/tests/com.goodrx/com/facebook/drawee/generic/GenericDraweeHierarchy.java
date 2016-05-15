package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RootDrawable;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.generic.WrappingUtils;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class GenericDraweeHierarchy implements SettableDraweeHierarchy {
   private final int mActualImageIndex;
   private final ForwardingDrawable mActualImageWrapper;
   private final Drawable mEmptyActualImageDrawable = new ColorDrawable(0);
   private final FadeDrawable mFadeDrawable;
   private final int mFailureImageIndex;
   private final int mPlaceholderImageIndex;
   private final int mProgressBarImageIndex;
   private final Resources mResources;
   private final int mRetryImageIndex;
   private RoundingParams mRoundingParams;
   private final RootDrawable mTopLevelDrawable;

   GenericDraweeHierarchy(GenericDraweeHierarchyBuilder var1) {
      this.mResources = var1.getResources();
      this.mRoundingParams = var1.getRoundingParams();
      this.mActualImageWrapper = new ForwardingDrawable(this.mEmptyActualImageDrawable);
      int var2;
      if(var1.getBackgrounds() != null) {
         var2 = var1.getBackgrounds().size();
      } else {
         var2 = 0;
      }

      int var3;
      if(var1.getOverlays() != null) {
         var3 = var1.getOverlays().size();
      } else {
         var3 = 0;
      }

      byte var4;
      if(var1.getPressedStateOverlay() != null) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      int var5 = var3 + var4;
      int var6 = 0 + var2;
      int var7 = var6 + 1;
      this.mPlaceholderImageIndex = var6;
      int var8 = var7 + 1;
      this.mActualImageIndex = var7;
      int var9 = var8 + 1;
      this.mProgressBarImageIndex = var8;
      int var10 = var9 + 1;
      this.mRetryImageIndex = var9;
      int var11 = var10 + 1;
      this.mFailureImageIndex = var10;
      Drawable[] var12 = new Drawable[var11 + var5];
      if(var2 > 0) {
         int var19 = 0;

         int var22;
         for(Iterator var20 = var1.getBackgrounds().iterator(); var20.hasNext(); var19 = var22) {
            Drawable var21 = (Drawable)var20.next();
            var22 = var19 + 1;
            var12[var19 + 0] = this.buildBranch(var21, (ScalingUtils.ScaleType)null);
         }
      }

      var12[this.mPlaceholderImageIndex] = this.buildBranch(var1.getPlaceholderImage(), var1.getPlaceholderImageScaleType());
      var12[this.mActualImageIndex] = this.buildActualImageBranch(this.mActualImageWrapper, var1.getActualImageScaleType(), var1.getActualImageFocusPoint(), var1.getActualImageMatrix(), var1.getActualImageColorFilter());
      var12[this.mProgressBarImageIndex] = this.buildBranch(var1.getProgressBarImage(), var1.getProgressBarImageScaleType());
      var12[this.mRetryImageIndex] = this.buildBranch(var1.getRetryImage(), var1.getRetryImageScaleType());
      var12[this.mFailureImageIndex] = this.buildBranch(var1.getFailureImage(), var1.getFailureImageScaleType());
      if(var5 > 0) {
         List var14 = var1.getOverlays();
         int var15 = 0;
         int var18;
         if(var14 != null) {
            for(Iterator var16 = var1.getOverlays().iterator(); var16.hasNext(); var15 = var18) {
               Drawable var17 = (Drawable)var16.next();
               var18 = var15 + 1;
               var12[var11 + var15] = this.buildBranch(var17, (ScalingUtils.ScaleType)null);
            }
         }

         if(var1.getPressedStateOverlay() != null) {
            var12[var11 + var15] = this.buildBranch(var1.getPressedStateOverlay(), (ScalingUtils.ScaleType)null);
         }
      }

      this.mFadeDrawable = new FadeDrawable(var12);
      this.mFadeDrawable.setTransitionDuration(var1.getFadeDuration());
      this.mTopLevelDrawable = new RootDrawable(WrappingUtils.maybeWrapWithRoundedOverlayColor(this.mFadeDrawable, this.mRoundingParams));
      this.mTopLevelDrawable.mutate();
      this.resetFade();
   }

   @Nullable
   private Drawable buildActualImageBranch(Drawable var1, @Nullable ScalingUtils.ScaleType var2, @Nullable PointF var3, @Nullable Matrix var4, @Nullable ColorFilter var5) {
      var1.setColorFilter(var5);
      return WrappingUtils.maybeWrapWithMatrix(WrappingUtils.maybeWrapWithScaleType(var1, var2, var3), var4);
   }

   @Nullable
   private Drawable buildBranch(@Nullable Drawable var1, @Nullable ScalingUtils.ScaleType var2) {
      return WrappingUtils.maybeWrapWithScaleType(WrappingUtils.maybeApplyLeafRounding(var1, this.mRoundingParams, this.mResources), var2);
   }

   private void fadeInLayer(int var1) {
      if(var1 >= 0) {
         this.mFadeDrawable.fadeInLayer(var1);
      }

   }

   private void fadeOutBranches() {
      this.fadeOutLayer(this.mPlaceholderImageIndex);
      this.fadeOutLayer(this.mActualImageIndex);
      this.fadeOutLayer(this.mProgressBarImageIndex);
      this.fadeOutLayer(this.mRetryImageIndex);
      this.fadeOutLayer(this.mFailureImageIndex);
   }

   private void fadeOutLayer(int var1) {
      if(var1 >= 0) {
         this.mFadeDrawable.fadeOutLayer(var1);
      }

   }

   private DrawableParent getLayerParentDrawable(int var1) {
      Object var2 = this.mFadeDrawable.getDrawableParentForIndex(var1);
      if(((DrawableParent)var2).getDrawable() instanceof MatrixDrawable) {
         var2 = (MatrixDrawable)((DrawableParent)var2).getDrawable();
      }

      if(((DrawableParent)var2).getDrawable() instanceof ScaleTypeDrawable) {
         var2 = (ScaleTypeDrawable)((DrawableParent)var2).getDrawable();
      }

      return (DrawableParent)var2;
   }

   private ScaleTypeDrawable getLayerScaleTypeDrawable(int var1) {
      DrawableParent var2 = this.getLayerParentDrawable(var1);
      return var2 instanceof ScaleTypeDrawable?(ScaleTypeDrawable)var2:WrappingUtils.wrapChildWithScaleType(var2, ScalingUtils.ScaleType.FIT_XY);
   }

   private void resetActualImages() {
      this.mActualImageWrapper.setDrawable(this.mEmptyActualImageDrawable);
   }

   private void resetFade() {
      if(this.mFadeDrawable != null) {
         this.mFadeDrawable.beginBatchMode();
         this.mFadeDrawable.fadeInAllLayers();
         this.fadeOutBranches();
         this.fadeInLayer(this.mPlaceholderImageIndex);
         this.mFadeDrawable.finishTransitionImmediately();
         this.mFadeDrawable.endBatchMode();
      }

   }

   private void setLayerChildDrawable(int var1, @Nullable Drawable var2) {
      if(var2 == null) {
         this.mFadeDrawable.setDrawable(var1, (Drawable)null);
      } else {
         Drawable var3 = WrappingUtils.maybeApplyLeafRounding(var2, this.mRoundingParams, this.mResources);
         this.getLayerParentDrawable(var1).setDrawable(var3);
      }
   }

   private void setProgress(float var1) {
      Drawable var2 = this.getLayerParentDrawable(this.mProgressBarImageIndex).getDrawable();
      if(var2 != null) {
         if(var1 >= 0.999F) {
            if(var2 instanceof Animatable) {
               ((Animatable)var2).stop();
            }

            this.fadeOutLayer(this.mProgressBarImageIndex);
         } else {
            if(var2 instanceof Animatable) {
               ((Animatable)var2).start();
            }

            this.fadeInLayer(this.mProgressBarImageIndex);
         }

         var2.setLevel(Math.round(10000.0F * var1));
      }
   }

   public void getActualImageBounds(RectF var1) {
      this.mActualImageWrapper.getTransformedBounds(var1);
   }

   public RoundingParams getRoundingParams() {
      return this.mRoundingParams;
   }

   public Drawable getTopLevelDrawable() {
      return this.mTopLevelDrawable;
   }

   public void reset() {
      this.resetActualImages();
      this.resetFade();
   }

   public void setActualImageColorFilter(ColorFilter var1) {
      this.mActualImageWrapper.setColorFilter(var1);
   }

   public void setActualImageFocusPoint(PointF var1) {
      Preconditions.checkNotNull(var1);
      this.getLayerScaleTypeDrawable(this.mActualImageIndex).setFocusPoint(var1);
   }

   public void setActualImageScaleType(ScalingUtils.ScaleType var1) {
      Preconditions.checkNotNull(var1);
      this.getLayerScaleTypeDrawable(this.mActualImageIndex).setScaleType(var1);
   }

   public void setControllerOverlay(@Nullable Drawable var1) {
      this.mTopLevelDrawable.setControllerOverlay(var1);
   }

   public void setFadeDuration(int var1) {
      this.mFadeDrawable.setTransitionDuration(var1);
   }

   public void setFailure(Throwable var1) {
      this.mFadeDrawable.beginBatchMode();
      this.fadeOutBranches();
      if(this.mFadeDrawable.getDrawable(this.mFailureImageIndex) != null) {
         this.fadeInLayer(this.mFailureImageIndex);
      } else {
         this.fadeInLayer(this.mPlaceholderImageIndex);
      }

      this.mFadeDrawable.endBatchMode();
   }

   public void setFailureImage(@Nullable Drawable var1) {
      this.setLayerChildDrawable(this.mFailureImageIndex, var1);
   }

   public void setFailureImage(Drawable var1, ScalingUtils.ScaleType var2) {
      this.setLayerChildDrawable(this.mFailureImageIndex, var1);
      this.getLayerScaleTypeDrawable(this.mFailureImageIndex).setScaleType(var2);
   }

   public void setImage(Drawable var1, float var2, boolean var3) {
      Drawable var4 = WrappingUtils.maybeApplyLeafRounding(var1, this.mRoundingParams, this.mResources);
      var4.mutate();
      this.mActualImageWrapper.setDrawable(var4);
      this.mFadeDrawable.beginBatchMode();
      this.fadeOutBranches();
      this.fadeInLayer(this.mActualImageIndex);
      this.setProgress(var2);
      if(var3) {
         this.mFadeDrawable.finishTransitionImmediately();
      }

      this.mFadeDrawable.endBatchMode();
   }

   public void setPlaceholderImage(int var1) {
      this.setPlaceholderImage(this.mResources.getDrawable(var1));
   }

   public void setPlaceholderImage(@Nullable Drawable var1) {
      this.setLayerChildDrawable(this.mPlaceholderImageIndex, var1);
   }

   public void setPlaceholderImage(Drawable var1, ScalingUtils.ScaleType var2) {
      this.setLayerChildDrawable(this.mPlaceholderImageIndex, var1);
      this.getLayerScaleTypeDrawable(this.mPlaceholderImageIndex).setScaleType(var2);
   }

   public void setPlaceholderImageFocusPoint(PointF var1) {
      Preconditions.checkNotNull(var1);
      this.getLayerScaleTypeDrawable(this.mPlaceholderImageIndex).setFocusPoint(var1);
   }

   public void setProgress(float var1, boolean var2) {
      this.mFadeDrawable.beginBatchMode();
      this.setProgress(var1);
      if(var2) {
         this.mFadeDrawable.finishTransitionImmediately();
      }

      this.mFadeDrawable.endBatchMode();
   }

   public void setProgressBarImage(@Nullable Drawable var1) {
      this.setLayerChildDrawable(this.mProgressBarImageIndex, var1);
   }

   public void setProgressBarImage(Drawable var1, ScalingUtils.ScaleType var2) {
      this.setLayerChildDrawable(this.mProgressBarImageIndex, var1);
      this.getLayerScaleTypeDrawable(this.mProgressBarImageIndex).setScaleType(var2);
   }

   public void setRetry(Throwable var1) {
      this.mFadeDrawable.beginBatchMode();
      this.fadeOutBranches();
      if(this.mFadeDrawable.getDrawable(this.mRetryImageIndex) != null) {
         this.fadeInLayer(this.mRetryImageIndex);
      } else {
         this.fadeInLayer(this.mPlaceholderImageIndex);
      }

      this.mFadeDrawable.endBatchMode();
   }

   public void setRetryImage(@Nullable Drawable var1) {
      this.setLayerChildDrawable(this.mRetryImageIndex, var1);
   }

   public void setRetryImage(Drawable var1, ScalingUtils.ScaleType var2) {
      this.setLayerChildDrawable(this.mRetryImageIndex, var1);
      this.getLayerScaleTypeDrawable(this.mRetryImageIndex).setScaleType(var2);
   }

   public void setRoundingParams(RoundingParams var1) {
      this.mRoundingParams = var1;
      WrappingUtils.updateOverlayColorRounding(this.mTopLevelDrawable, this.mRoundingParams);

      for(int var2 = 0; var2 < this.mFadeDrawable.getNumberOfLayers(); ++var2) {
         WrappingUtils.updateLeafRounding(this.getLayerParentDrawable(var2), this.mRoundingParams, this.mResources);
      }

   }
}
