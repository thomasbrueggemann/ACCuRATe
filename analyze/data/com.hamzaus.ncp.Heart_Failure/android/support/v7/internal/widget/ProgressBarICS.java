package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class ProgressBarICS extends View {
   private static final int ANIMATION_RESOLUTION = 200;
   private static final int MAX_LEVEL = 10000;
   private static final int[] android_R_styleable_ProgressBar = new int[]{16843062, 16843063, 16843064, 16843065, 16843066, 16843067, 16843068, 16843069, 16843070, 16843071, 16843039, 16843072, 16843040, 16843073};
   private AlphaAnimation mAnimation;
   private int mBehavior;
   private Drawable mCurrentDrawable;
   private int mDuration;
   private boolean mInDrawing;
   private boolean mIndeterminate;
   private Drawable mIndeterminateDrawable;
   private Interpolator mInterpolator;
   private long mLastDrawTime;
   private int mMax;
   int mMaxHeight;
   int mMaxWidth;
   int mMinHeight;
   int mMinWidth;
   private boolean mNoInvalidate;
   private boolean mOnlyIndeterminate;
   private int mProgress;
   private Drawable mProgressDrawable;
   private ProgressBarICS.RefreshProgressRunnable mRefreshProgressRunnable;
   Bitmap mSampleTile;
   private int mSecondaryProgress;
   private boolean mShouldStartAnimationDrawable;
   private Transformation mTransformation;
   private long mUiThreadId = Thread.currentThread().getId();

   public ProgressBarICS(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3);
      this.initProgressBar();
      TypedArray var5 = var1.obtainStyledAttributes(var2, android_R_styleable_ProgressBar, var3, var4);
      this.mNoInvalidate = true;
      this.setMax(var5.getInt(0, this.mMax));
      this.setProgress(var5.getInt(1, this.mProgress));
      this.setSecondaryProgress(var5.getInt(2, this.mSecondaryProgress));
      boolean var6 = var5.getBoolean(3, this.mIndeterminate);
      this.mOnlyIndeterminate = var5.getBoolean(4, this.mOnlyIndeterminate);
      Drawable var7 = var5.getDrawable(5);
      if(var7 != null) {
         this.setIndeterminateDrawable(this.tileifyIndeterminate(var7));
      }

      Drawable var8 = var5.getDrawable(6);
      if(var8 != null) {
         this.setProgressDrawable(this.tileify(var8, false));
      }

      this.mDuration = var5.getInt(7, this.mDuration);
      this.mBehavior = var5.getInt(8, this.mBehavior);
      this.mMinWidth = var5.getDimensionPixelSize(9, this.mMinWidth);
      this.mMaxWidth = var5.getDimensionPixelSize(10, this.mMaxWidth);
      this.mMinHeight = var5.getDimensionPixelSize(11, this.mMinHeight);
      this.mMaxHeight = var5.getDimensionPixelSize(12, this.mMaxHeight);
      int var9 = var5.getResourceId(13, 17432587);
      if(var9 > 0) {
         this.setInterpolator(var1, var9);
      }

      boolean var10;
      label19: {
         var5.recycle();
         this.mNoInvalidate = false;
         if(!this.mOnlyIndeterminate) {
            var10 = false;
            if(!var6) {
               break label19;
            }
         }

         var10 = true;
      }

      this.setIndeterminate(var10);
   }

   private void doRefreshProgress(int param1, int param2, boolean param3, boolean param4) {
      // $FF: Couldn't be decompiled
   }

   private void initProgressBar() {
      this.mMax = 100;
      this.mProgress = 0;
      this.mSecondaryProgress = 0;
      this.mIndeterminate = false;
      this.mOnlyIndeterminate = false;
      this.mDuration = 4000;
      this.mBehavior = 1;
      this.mMinWidth = 24;
      this.mMaxWidth = 48;
      this.mMinHeight = 24;
      this.mMaxHeight = 48;
   }

   private void refreshProgress(int param1, int param2, boolean param3) {
      // $FF: Couldn't be decompiled
   }

   private Drawable tileify(Drawable var1, boolean var2) {
      Object var7;
      if(var1 instanceof LayerDrawable) {
         LayerDrawable var8 = (LayerDrawable)var1;
         int var9 = var8.getNumberOfLayers();
         Drawable[] var10 = new Drawable[var9];

         for(int var11 = 0; var11 < var9; ++var11) {
            int var13 = var8.getId(var11);
            Drawable var14 = var8.getDrawable(var11);
            boolean var15;
            if(var13 != 16908301 && var13 != 16908303) {
               var15 = false;
            } else {
               var15 = true;
            }

            var10[var11] = this.tileify(var14, var15);
         }

         var7 = new LayerDrawable(var10);

         for(int var12 = 0; var12 < var9; ++var12) {
            ((LayerDrawable)var7).setId(var12, var8.getId(var12));
         }
      } else {
         if(!(var1 instanceof BitmapDrawable)) {
            return var1;
         }

         Bitmap var3 = ((BitmapDrawable)var1).getBitmap();
         if(this.mSampleTile == null) {
            this.mSampleTile = var3;
         }

         Object var4 = new ShapeDrawable(this.getDrawableShape());
         BitmapShader var5 = new BitmapShader(var3, TileMode.REPEAT, TileMode.CLAMP);
         ((ShapeDrawable)var4).getPaint().setShader(var5);
         if(var2) {
            var4 = new ClipDrawable((Drawable)var4, 3, 1);
         }

         var7 = var4;
      }

      return (Drawable)var7;
   }

   private Drawable tileifyIndeterminate(Drawable var1) {
      if(var1 instanceof AnimationDrawable) {
         AnimationDrawable var2 = (AnimationDrawable)var1;
         int var3 = var2.getNumberOfFrames();
         AnimationDrawable var4 = new AnimationDrawable();
         var4.setOneShot(var2.isOneShot());

         for(int var5 = 0; var5 < var3; ++var5) {
            Drawable var7 = this.tileify(var2.getFrame(var5), true);
            var7.setLevel(10000);
            var4.addFrame(var7, var2.getDuration(var5));
         }

         var4.setLevel(10000);
         var1 = var4;
      }

      return (Drawable)var1;
   }

   private void updateDrawableBounds(int var1, int var2) {
      int var3 = var1 - this.getPaddingRight() - this.getPaddingLeft();
      int var4 = var2 - this.getPaddingBottom() - this.getPaddingTop();
      if(this.mIndeterminateDrawable != null) {
         boolean var5 = this.mOnlyIndeterminate;
         int var6 = 0;
         int var7 = 0;
         if(var5) {
            boolean var8 = this.mIndeterminateDrawable instanceof AnimationDrawable;
            var6 = 0;
            var7 = 0;
            if(!var8) {
               int var9 = this.mIndeterminateDrawable.getIntrinsicWidth();
               int var10 = this.mIndeterminateDrawable.getIntrinsicHeight();
               float var11 = (float)var9 / (float)var10;
               float var12 = (float)var1 / (float)var2;
               float var16;
               int var13 = (var16 = var11 - var12) == 0.0F?0:(var16 < 0.0F?-1:1);
               var6 = 0;
               var7 = 0;
               if(var13 != 0) {
                  if(var12 > var11) {
                     int var15 = (int)(var11 * (float)var2);
                     var6 = (var1 - var15) / 2;
                     var3 = var6 + var15;
                  } else {
                     int var14 = (int)((float)var1 * (1.0F / var11));
                     var7 = (var2 - var14) / 2;
                     var4 = var7 + var14;
                     var6 = 0;
                  }
               }
            }
         }

         this.mIndeterminateDrawable.setBounds(var6, var7, var3, var4);
      }

      if(this.mProgressDrawable != null) {
         this.mProgressDrawable.setBounds(0, 0, var3, var4);
      }

   }

   private void updateDrawableState() {
      int[] var1 = this.getDrawableState();
      if(this.mProgressDrawable != null && this.mProgressDrawable.isStateful()) {
         this.mProgressDrawable.setState(var1);
      }

      if(this.mIndeterminateDrawable != null && this.mIndeterminateDrawable.isStateful()) {
         this.mIndeterminateDrawable.setState(var1);
      }

   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      this.updateDrawableState();
   }

   Shape getDrawableShape() {
      return new RoundRectShape(new float[]{5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F}, (RectF)null, (float[])null);
   }

   public Drawable getIndeterminateDrawable() {
      return this.mIndeterminateDrawable;
   }

   public Interpolator getInterpolator() {
      return this.mInterpolator;
   }

   public int getMax() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.mMax;
      } finally {
         ;
      }

      return var2;
   }

   public int getProgress() {
      // $FF: Couldn't be decompiled
   }

   public Drawable getProgressDrawable() {
      return this.mProgressDrawable;
   }

   public int getSecondaryProgress() {
      // $FF: Couldn't be decompiled
   }

   public final void incrementProgressBy(int var1) {
      synchronized(this){}

      try {
         this.setProgress(var1 + this.mProgress);
      } finally {
         ;
      }

   }

   public final void incrementSecondaryProgressBy(int var1) {
      synchronized(this){}

      try {
         this.setSecondaryProgress(var1 + this.mSecondaryProgress);
      } finally {
         ;
      }

   }

   public void invalidateDrawable(Drawable var1) {
      if(!this.mInDrawing) {
         if(!this.verifyDrawable(var1)) {
            super.invalidateDrawable(var1);
            return;
         }

         Rect var2 = var1.getBounds();
         int var3 = this.getScrollX() + this.getPaddingLeft();
         int var4 = this.getScrollY() + this.getPaddingTop();
         this.invalidate(var3 + var2.left, var4 + var2.top, var3 + var2.right, var4 + var2.bottom);
      }

   }

   public boolean isIndeterminate() {
      synchronized(this){}

      boolean var2;
      try {
         var2 = this.mIndeterminate;
      } finally {
         ;
      }

      return var2;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if(this.mIndeterminate) {
         this.startAnimation();
      }

   }

   protected void onDetachedFromWindow() {
      if(this.mIndeterminate) {
         this.stopAnimation();
      }

      if(this.mRefreshProgressRunnable != null) {
         this.removeCallbacks(this.mRefreshProgressRunnable);
      }

      super.onDetachedFromWindow();
   }

   protected void onDraw(Canvas param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onMeasure(int param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public void onRestoreInstanceState(Parcelable var1) {
      ProgressBarICS.SavedState var2 = (ProgressBarICS.SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      this.setProgress(var2.progress);
      this.setSecondaryProgress(var2.secondaryProgress);
   }

   public Parcelable onSaveInstanceState() {
      ProgressBarICS.SavedState var1 = new ProgressBarICS.SavedState(super.onSaveInstanceState());
      var1.progress = this.mProgress;
      var1.secondaryProgress = this.mSecondaryProgress;
      return var1;
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      this.updateDrawableBounds(var1, var2);
   }

   protected void onVisibilityChanged(View var1, int var2) {
      super.onVisibilityChanged(var1, var2);
      if(this.mIndeterminate) {
         if(var2 != 8 && var2 != 4) {
            this.startAnimation();
            return;
         }

         this.stopAnimation();
      }

   }

   public void postInvalidate() {
      if(!this.mNoInvalidate) {
         super.postInvalidate();
      }

   }

   public void setIndeterminate(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public void setIndeterminateDrawable(Drawable var1) {
      if(var1 != null) {
         var1.setCallback(this);
      }

      this.mIndeterminateDrawable = var1;
      if(this.mIndeterminate) {
         this.mCurrentDrawable = var1;
         this.postInvalidate();
      }

   }

   public void setInterpolator(Context var1, int var2) {
      this.setInterpolator(AnimationUtils.loadInterpolator(var1, var2));
   }

   public void setInterpolator(Interpolator var1) {
      this.mInterpolator = var1;
   }

   public void setMax(int var1) {
      synchronized(this){}
      if(var1 < 0) {
         var1 = 0;
      }

      try {
         if(var1 != this.mMax) {
            this.mMax = var1;
            this.postInvalidate();
            if(this.mProgress > var1) {
               this.mProgress = var1;
            }

            this.refreshProgress(16908301, this.mProgress, false);
         }
      } finally {
         ;
      }

   }

   public void setProgress(int var1) {
      synchronized(this){}

      try {
         this.setProgress(var1, false);
      } finally {
         ;
      }

   }

   void setProgress(int param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public void setProgressDrawable(Drawable var1) {
      boolean var2;
      if(this.mProgressDrawable != null && var1 != this.mProgressDrawable) {
         this.mProgressDrawable.setCallback((Callback)null);
         var2 = true;
      } else {
         var2 = false;
      }

      if(var1 != null) {
         var1.setCallback(this);
         int var3 = var1.getMinimumHeight();
         if(this.mMaxHeight < var3) {
            this.mMaxHeight = var3;
            this.requestLayout();
         }
      }

      this.mProgressDrawable = var1;
      if(!this.mIndeterminate) {
         this.mCurrentDrawable = var1;
         this.postInvalidate();
      }

      if(var2) {
         this.updateDrawableBounds(this.getWidth(), this.getHeight());
         this.updateDrawableState();
         this.doRefreshProgress(16908301, this.mProgress, false, false);
         this.doRefreshProgress(16908303, this.mSecondaryProgress, false, false);
      }

   }

   public void setSecondaryProgress(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void setVisibility(int var1) {
      if(this.getVisibility() != var1) {
         super.setVisibility(var1);
         if(this.mIndeterminate) {
            if(var1 != 8 && var1 != 4) {
               this.startAnimation();
               return;
            }

            this.stopAnimation();
         }
      }

   }

   void startAnimation() {
      if(this.getVisibility() == 0) {
         if(this.mIndeterminateDrawable instanceof Animatable) {
            this.mShouldStartAnimationDrawable = true;
            this.mAnimation = null;
         } else {
            if(this.mInterpolator == null) {
               this.mInterpolator = new LinearInterpolator();
            }

            this.mTransformation = new Transformation();
            this.mAnimation = new AlphaAnimation(0.0F, 1.0F);
            this.mAnimation.setRepeatMode(this.mBehavior);
            this.mAnimation.setRepeatCount(-1);
            this.mAnimation.setDuration((long)this.mDuration);
            this.mAnimation.setInterpolator(this.mInterpolator);
            this.mAnimation.setStartTime(-1L);
         }

         this.postInvalidate();
      }
   }

   void stopAnimation() {
      this.mAnimation = null;
      this.mTransformation = null;
      if(this.mIndeterminateDrawable instanceof Animatable) {
         ((Animatable)this.mIndeterminateDrawable).stop();
         this.mShouldStartAnimationDrawable = false;
      }

      this.postInvalidate();
   }

   protected boolean verifyDrawable(Drawable var1) {
      return var1 == this.mProgressDrawable || var1 == this.mIndeterminateDrawable || super.verifyDrawable(var1);
   }

   private class RefreshProgressRunnable implements Runnable {
      private boolean mFromUser;
      private int mId;
      private int mProgress;

      RefreshProgressRunnable(int var2, int var3, boolean var4) {
         this.mId = var2;
         this.mProgress = var3;
         this.mFromUser = var4;
      }

      public void run() {
         ProgressBarICS.this.doRefreshProgress(this.mId, this.mProgress, this.mFromUser, true);
         ProgressBarICS.this.mRefreshProgressRunnable = this;
      }

      public void setup(int var1, int var2, boolean var3) {
         this.mId = var1;
         this.mProgress = var2;
         this.mFromUser = var3;
      }
   }

   static class SavedState extends BaseSavedState {
      public static final Creator<ProgressBarICS.SavedState> CREATOR = new Creator() {
         public ProgressBarICS.SavedState createFromParcel(Parcel var1) {
            return new ProgressBarICS.SavedState(var1);
         }

         public ProgressBarICS.SavedState[] newArray(int var1) {
            return new ProgressBarICS.SavedState[var1];
         }
      };
      int progress;
      int secondaryProgress;

      private SavedState(Parcel var1) {
         super(var1);
         this.progress = var1.readInt();
         this.secondaryProgress = var1.readInt();
      }

      // $FF: synthetic method
      SavedState(Parcel var1, Object var2) {
         this(var1);
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeInt(this.progress);
         var1.writeInt(this.secondaryProgress);
      }
   }
}
