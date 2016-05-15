package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class GenericDraweeHierarchyBuilder {
   public static final ScalingUtils.ScaleType DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
   public static final int DEFAULT_FADE_DURATION = 300;
   public static final ScalingUtils.ScaleType DEFAULT_SCALE_TYPE;
   private ColorFilter mActualImageColorFilter;
   private PointF mActualImageFocusPoint;
   private Matrix mActualImageMatrix;
   private ScalingUtils.ScaleType mActualImageScaleType;
   private List<Drawable> mBackgrounds;
   private int mFadeDuration;
   private Drawable mFailureImage;
   private ScalingUtils.ScaleType mFailureImageScaleType;
   private List<Drawable> mOverlays;
   private Drawable mPlaceholderImage;
   @Nullable
   private ScalingUtils.ScaleType mPlaceholderImageScaleType;
   private Drawable mPressedStateOverlay;
   private Drawable mProgressBarImage;
   private ScalingUtils.ScaleType mProgressBarImageScaleType;
   private Resources mResources;
   private Drawable mRetryImage;
   private ScalingUtils.ScaleType mRetryImageScaleType;
   private RoundingParams mRoundingParams;

   static {
      DEFAULT_SCALE_TYPE = ScalingUtils.ScaleType.CENTER_INSIDE;
      DEFAULT_ACTUAL_IMAGE_SCALE_TYPE = ScalingUtils.ScaleType.CENTER_CROP;
   }

   public GenericDraweeHierarchyBuilder(Resources var1) {
      this.mResources = var1;
      this.init();
   }

   private void init() {
      this.mFadeDuration = 300;
      this.mPlaceholderImage = null;
      this.mPlaceholderImageScaleType = null;
      this.mRetryImage = null;
      this.mRetryImageScaleType = null;
      this.mFailureImage = null;
      this.mFailureImageScaleType = null;
      this.mProgressBarImage = null;
      this.mProgressBarImageScaleType = null;
      this.mActualImageScaleType = DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
      this.mActualImageMatrix = null;
      this.mActualImageFocusPoint = null;
      this.mBackgrounds = null;
      this.mOverlays = null;
      this.mPressedStateOverlay = null;
      this.mRoundingParams = null;
      this.mActualImageColorFilter = null;
   }

   public static GenericDraweeHierarchyBuilder newInstance(Resources var0) {
      return new GenericDraweeHierarchyBuilder(var0);
   }

   private void validate() {
      if(this.mOverlays != null) {
         Iterator var3 = this.mOverlays.iterator();

         while(var3.hasNext()) {
            Preconditions.checkNotNull((Drawable)var3.next());
         }
      }

      if(this.mBackgrounds != null) {
         Iterator var1 = this.mBackgrounds.iterator();

         while(var1.hasNext()) {
            Preconditions.checkNotNull((Drawable)var1.next());
         }
      }

   }

   public GenericDraweeHierarchy build() {
      this.validate();
      return new GenericDraweeHierarchy(this);
   }

   public ColorFilter getActualImageColorFilter() {
      return this.mActualImageColorFilter;
   }

   public PointF getActualImageFocusPoint() {
      return this.mActualImageFocusPoint;
   }

   public Matrix getActualImageMatrix() {
      return this.mActualImageMatrix;
   }

   public ScalingUtils.ScaleType getActualImageScaleType() {
      return this.mActualImageScaleType;
   }

   public List<Drawable> getBackgrounds() {
      return this.mBackgrounds;
   }

   public int getFadeDuration() {
      return this.mFadeDuration;
   }

   public Drawable getFailureImage() {
      return this.mFailureImage;
   }

   public ScalingUtils.ScaleType getFailureImageScaleType() {
      return this.mFailureImageScaleType;
   }

   public List<Drawable> getOverlays() {
      return this.mOverlays;
   }

   public Drawable getPlaceholderImage() {
      return this.mPlaceholderImage;
   }

   @Nullable
   public ScalingUtils.ScaleType getPlaceholderImageScaleType() {
      return this.mPlaceholderImageScaleType;
   }

   public Drawable getPressedStateOverlay() {
      return this.mPressedStateOverlay;
   }

   public Drawable getProgressBarImage() {
      return this.mProgressBarImage;
   }

   public ScalingUtils.ScaleType getProgressBarImageScaleType() {
      return this.mProgressBarImageScaleType;
   }

   public Resources getResources() {
      return this.mResources;
   }

   public Drawable getRetryImage() {
      return this.mRetryImage;
   }

   public ScalingUtils.ScaleType getRetryImageScaleType() {
      return this.mRetryImageScaleType;
   }

   public RoundingParams getRoundingParams() {
      return this.mRoundingParams;
   }

   public GenericDraweeHierarchyBuilder reset() {
      this.init();
      return this;
   }

   public GenericDraweeHierarchyBuilder setActualImageColorFilter(ColorFilter var1) {
      this.mActualImageColorFilter = var1;
      return this;
   }

   public GenericDraweeHierarchyBuilder setActualImageFocusPoint(PointF var1) {
      this.mActualImageFocusPoint = var1;
      return this;
   }

   @Deprecated
   public GenericDraweeHierarchyBuilder setActualImageMatrix(Matrix var1) {
      this.mActualImageMatrix = var1;
      this.mActualImageScaleType = null;
      return this;
   }

   public GenericDraweeHierarchyBuilder setActualImageScaleType(ScalingUtils.ScaleType var1) {
      this.mActualImageScaleType = var1;
      this.mActualImageMatrix = null;
      return this;
   }

   public GenericDraweeHierarchyBuilder setBackground(Drawable var1) {
      this.mBackgrounds = Arrays.asList(new Drawable[]{var1});
      return this;
   }

   public GenericDraweeHierarchyBuilder setBackgrounds(List<Drawable> var1) {
      this.mBackgrounds = var1;
      return this;
   }

   public GenericDraweeHierarchyBuilder setFadeDuration(int var1) {
      this.mFadeDuration = var1;
      return this;
   }

   public GenericDraweeHierarchyBuilder setFailureImage(Drawable var1) {
      return this.setFailureImage(var1, DEFAULT_SCALE_TYPE);
   }

   public GenericDraweeHierarchyBuilder setFailureImage(Drawable var1, ScalingUtils.ScaleType var2) {
      this.mFailureImage = var1;
      this.mFailureImageScaleType = var2;
      return this;
   }

   public GenericDraweeHierarchyBuilder setOverlay(Drawable var1) {
      this.mOverlays = Arrays.asList(new Drawable[]{var1});
      return this;
   }

   public GenericDraweeHierarchyBuilder setOverlays(List<Drawable> var1) {
      this.mOverlays = var1;
      return this;
   }

   public GenericDraweeHierarchyBuilder setPlaceholderImage(Drawable var1) {
      return this.setPlaceholderImage(var1, DEFAULT_SCALE_TYPE);
   }

   public GenericDraweeHierarchyBuilder setPlaceholderImage(Drawable var1, @Nullable ScalingUtils.ScaleType var2) {
      this.mPlaceholderImage = var1;
      this.mPlaceholderImageScaleType = var2;
      return this;
   }

   public GenericDraweeHierarchyBuilder setPressedStateOverlay(Drawable var1) {
      StateListDrawable var2 = new StateListDrawable();
      var2.addState(new int[]{16842919}, var1);
      this.mPressedStateOverlay = var2;
      return this;
   }

   public GenericDraweeHierarchyBuilder setProgressBarImage(Drawable var1) {
      return this.setProgressBarImage(var1, DEFAULT_SCALE_TYPE);
   }

   public GenericDraweeHierarchyBuilder setProgressBarImage(Drawable var1, ScalingUtils.ScaleType var2) {
      this.mProgressBarImage = var1;
      this.mProgressBarImageScaleType = var2;
      return this;
   }

   public GenericDraweeHierarchyBuilder setRetryImage(Drawable var1) {
      return this.setRetryImage(var1, DEFAULT_SCALE_TYPE);
   }

   public GenericDraweeHierarchyBuilder setRetryImage(Drawable var1, ScalingUtils.ScaleType var2) {
      this.mRetryImage = var1;
      this.mRetryImageScaleType = var2;
      return this;
   }

   public GenericDraweeHierarchyBuilder setRoundingParams(RoundingParams var1) {
      this.mRoundingParams = var1;
      return this;
   }
}
