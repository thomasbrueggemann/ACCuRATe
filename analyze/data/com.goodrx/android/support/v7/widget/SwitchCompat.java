package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.class_22;
import android.support.v7.text.AllCapsTransformationMethod;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.ViewUtils;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.Layout.Alignment;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.Animation.AnimationListener;
import android.widget.CompoundButton;

public class SwitchCompat extends CompoundButton {
   private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
   private static final int[] CHECKED_STATE_SET = new int[]{16842912};
   private static final int MONOSPACE = 3;
   private static final int SANS = 1;
   private static final int SERIF = 2;
   private static final int THUMB_ANIMATION_DURATION = 250;
   private static final int TOUCH_MODE_DOWN = 1;
   private static final int TOUCH_MODE_DRAGGING = 2;
   private static final int TOUCH_MODE_IDLE;
   private final AppCompatDrawableManager mDrawableManager;
   private int mMinFlingVelocity;
   private Layout mOffLayout;
   private Layout mOnLayout;
   private SwitchCompat.ThumbAnimation mPositionAnimator;
   private boolean mShowText;
   private boolean mSplitTrack;
   private int mSwitchBottom;
   private int mSwitchHeight;
   private int mSwitchLeft;
   private int mSwitchMinWidth;
   private int mSwitchPadding;
   private int mSwitchRight;
   private int mSwitchTop;
   private TransformationMethod mSwitchTransformationMethod;
   private int mSwitchWidth;
   private final Rect mTempRect;
   private ColorStateList mTextColors;
   private CharSequence mTextOff;
   private CharSequence mTextOn;
   private TextPaint mTextPaint;
   private Drawable mThumbDrawable;
   private float mThumbPosition;
   private int mThumbTextPadding;
   private int mThumbWidth;
   private int mTouchMode;
   private int mTouchSlop;
   private float mTouchX;
   private float mTouchY;
   private Drawable mTrackDrawable;
   private VelocityTracker mVelocityTracker;

   public SwitchCompat(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public SwitchCompat(Context var1, AttributeSet var2) {
      this(var1, var2, class_22.attr.switchStyle);
   }

   public SwitchCompat(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mVelocityTracker = VelocityTracker.obtain();
      this.mTempRect = new Rect();
      this.mTextPaint = new TextPaint(1);
      Resources var4 = this.getResources();
      this.mTextPaint.density = var4.getDisplayMetrics().density;
      TintTypedArray var5 = TintTypedArray.obtainStyledAttributes(var1, var2, class_22.styleable.SwitchCompat, var3, 0);
      this.mThumbDrawable = var5.getDrawable(class_22.styleable.SwitchCompat_android_thumb);
      if(this.mThumbDrawable != null) {
         this.mThumbDrawable.setCallback(this);
      }

      this.mTrackDrawable = var5.getDrawable(class_22.styleable.SwitchCompat_track);
      if(this.mTrackDrawable != null) {
         this.mTrackDrawable.setCallback(this);
      }

      this.mTextOn = var5.getText(class_22.styleable.SwitchCompat_android_textOn);
      this.mTextOff = var5.getText(class_22.styleable.SwitchCompat_android_textOff);
      this.mShowText = var5.getBoolean(class_22.styleable.SwitchCompat_showText, true);
      this.mThumbTextPadding = var5.getDimensionPixelSize(class_22.styleable.SwitchCompat_thumbTextPadding, 0);
      this.mSwitchMinWidth = var5.getDimensionPixelSize(class_22.styleable.SwitchCompat_switchMinWidth, 0);
      this.mSwitchPadding = var5.getDimensionPixelSize(class_22.styleable.SwitchCompat_switchPadding, 0);
      this.mSplitTrack = var5.getBoolean(class_22.styleable.SwitchCompat_splitTrack, false);
      int var6 = var5.getResourceId(class_22.styleable.SwitchCompat_switchTextAppearance, 0);
      if(var6 != 0) {
         this.setSwitchTextAppearance(var1, var6);
      }

      this.mDrawableManager = AppCompatDrawableManager.get();
      var5.recycle();
      ViewConfiguration var7 = ViewConfiguration.get(var1);
      this.mTouchSlop = var7.getScaledTouchSlop();
      this.mMinFlingVelocity = var7.getScaledMinimumFlingVelocity();
      this.refreshDrawableState();
      this.setChecked(this.isChecked());
   }

   private void animateThumbToCheckedState(final boolean var1) {
      if(this.mPositionAnimator != null) {
         this.cancelPositionAnimator();
      }

      float var2 = this.mThumbPosition;
      float var3;
      if(var1) {
         var3 = 1.0F;
      } else {
         var3 = 0.0F;
      }

      this.mPositionAnimator = new SwitchCompat.ThumbAnimation(var2, var3, null);
      this.mPositionAnimator.setDuration(250L);
      this.mPositionAnimator.setAnimationListener(new AnimationListener() {
         public void onAnimationEnd(Animation var1x) {
            if(SwitchCompat.this.mPositionAnimator == var1x) {
               SwitchCompat var2 = SwitchCompat.this;
               float var3;
               if(var1) {
                  var3 = 1.0F;
               } else {
                  var3 = 0.0F;
               }

               var2.setThumbPosition(var3);
               SwitchCompat.this.mPositionAnimator = null;
            }

         }

         public void onAnimationRepeat(Animation var1x) {
         }

         public void onAnimationStart(Animation var1x) {
         }
      });
      this.startAnimation(this.mPositionAnimator);
   }

   private void cancelPositionAnimator() {
      if(this.mPositionAnimator != null) {
         this.clearAnimation();
         this.mPositionAnimator = null;
      }

   }

   private void cancelSuperTouch(MotionEvent var1) {
      MotionEvent var2 = MotionEvent.obtain(var1);
      var2.setAction(3);
      super.onTouchEvent(var2);
      var2.recycle();
   }

   private static float constrain(float var0, float var1, float var2) {
      return var0 < var1?var1:(var0 > var2?var2:var0);
   }

   private boolean getTargetCheckedState() {
      return this.mThumbPosition > 0.5F;
   }

   private int getThumbOffset() {
      float var1;
      if(ViewUtils.isLayoutRtl(this)) {
         var1 = 1.0F - this.mThumbPosition;
      } else {
         var1 = this.mThumbPosition;
      }

      return (int)(0.5F + var1 * (float)this.getThumbScrollRange());
   }

   private int getThumbScrollRange() {
      if(this.mTrackDrawable != null) {
         Rect var1 = this.mTempRect;
         this.mTrackDrawable.getPadding(var1);
         Rect var3;
         if(this.mThumbDrawable != null) {
            var3 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
         } else {
            var3 = DrawableUtils.INSETS_NONE;
         }

         return this.mSwitchWidth - this.mThumbWidth - var1.left - var1.right - var3.left - var3.right;
      } else {
         return 0;
      }
   }

   private boolean hitThumb(float var1, float var2) {
      if(this.mThumbDrawable != null) {
         int var3 = this.getThumbOffset();
         this.mThumbDrawable.getPadding(this.mTempRect);
         int var5 = this.mSwitchTop - this.mTouchSlop;
         int var6 = var3 + this.mSwitchLeft - this.mTouchSlop;
         int var7 = var6 + this.mThumbWidth + this.mTempRect.left + this.mTempRect.right + this.mTouchSlop;
         int var8 = this.mSwitchBottom + this.mTouchSlop;
         if(var1 > (float)var6 && var1 < (float)var7 && var2 > (float)var5 && var2 < (float)var8) {
            return true;
         }
      }

      return false;
   }

   private Layout makeLayout(CharSequence var1) {
      CharSequence var2;
      if(this.mSwitchTransformationMethod != null) {
         var2 = this.mSwitchTransformationMethod.getTransformation(var1, this);
      } else {
         var2 = var1;
      }

      TextPaint var3 = this.mTextPaint;
      int var4;
      if(var2 != null) {
         var4 = (int)Math.ceil((double)Layout.getDesiredWidth(var2, this.mTextPaint));
      } else {
         var4 = 0;
      }

      return new StaticLayout(var2, var3, var4, Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
   }

   private void setSwitchTypefaceByIndex(int var1, int var2) {
      Typeface var3 = null;
      switch(var1) {
      case 1:
         var3 = Typeface.SANS_SERIF;
         break;
      case 2:
         var3 = Typeface.SERIF;
         break;
      case 3:
         var3 = Typeface.MONOSPACE;
      }

      this.setSwitchTypeface(var3, var2);
   }

   private void setThumbPosition(float var1) {
      this.mThumbPosition = var1;
      this.invalidate();
   }

   private void stopDrag(MotionEvent var1) {
      this.mTouchMode = 0;
      boolean var2;
      if(var1.getAction() == 1 && this.isEnabled()) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var3 = this.isChecked();
      boolean var4;
      if(var2) {
         this.mVelocityTracker.computeCurrentVelocity(1000);
         float var5 = this.mVelocityTracker.getXVelocity();
         if(Math.abs(var5) > (float)this.mMinFlingVelocity) {
            if(ViewUtils.isLayoutRtl(this)) {
               if(var5 < 0.0F) {
                  var4 = true;
               } else {
                  var4 = false;
               }
            } else if(var5 > 0.0F) {
               var4 = true;
            } else {
               var4 = false;
            }
         } else {
            var4 = this.getTargetCheckedState();
         }
      } else {
         var4 = var3;
      }

      if(var4 != var3) {
         this.playSoundEffect(0);
      }

      this.setChecked(var4);
      this.cancelSuperTouch(var1);
   }

   public void draw(Canvas var1) {
      Rect var2 = this.mTempRect;
      int var3 = this.mSwitchLeft;
      int var4 = this.mSwitchTop;
      int var5 = this.mSwitchRight;
      int var6 = this.mSwitchBottom;
      int var7 = var3 + this.getThumbOffset();
      Rect var8;
      if(this.mThumbDrawable != null) {
         var8 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
      } else {
         var8 = DrawableUtils.INSETS_NONE;
      }

      if(this.mTrackDrawable != null) {
         this.mTrackDrawable.getPadding(var2);
         var7 += var2.left;
         int var14 = var3;
         int var15 = var4;
         int var16 = var5;
         int var17 = var6;
         if(var8 != null) {
            if(var8.left > var2.left) {
               var14 = var3 + (var8.left - var2.left);
            }

            if(var8.top > var2.top) {
               var15 = var4 + (var8.top - var2.top);
            }

            if(var8.right > var2.right) {
               var16 = var5 - (var8.right - var2.right);
            }

            if(var8.bottom > var2.bottom) {
               var17 = var6 - (var8.bottom - var2.bottom);
            }
         }

         this.mTrackDrawable.setBounds(var14, var15, var16, var17);
      }

      if(this.mThumbDrawable != null) {
         this.mThumbDrawable.getPadding(var2);
         int var10 = var7 - var2.left;
         int var11 = var7 + this.mThumbWidth + var2.right;
         this.mThumbDrawable.setBounds(var10, var4, var11, var6);
         Drawable var12 = this.getBackground();
         if(var12 != null) {
            DrawableCompat.setHotspotBounds(var12, var10, var4, var11, var6);
         }
      }

      super.draw(var1);
   }

   public void drawableHotspotChanged(float var1, float var2) {
      if(VERSION.SDK_INT >= 21) {
         super.drawableHotspotChanged(var1, var2);
      }

      if(this.mThumbDrawable != null) {
         DrawableCompat.setHotspot(this.mThumbDrawable, var1, var2);
      }

      if(this.mTrackDrawable != null) {
         DrawableCompat.setHotspot(this.mTrackDrawable, var1, var2);
      }

   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      int[] var1 = this.getDrawableState();
      if(this.mThumbDrawable != null) {
         this.mThumbDrawable.setState(var1);
      }

      if(this.mTrackDrawable != null) {
         this.mTrackDrawable.setState(var1);
      }

      this.invalidate();
   }

   public int getCompoundPaddingLeft() {
      int var1;
      if(!ViewUtils.isLayoutRtl(this)) {
         var1 = super.getCompoundPaddingLeft();
      } else {
         var1 = super.getCompoundPaddingLeft() + this.mSwitchWidth;
         if(!TextUtils.isEmpty(this.getText())) {
            return var1 + this.mSwitchPadding;
         }
      }

      return var1;
   }

   public int getCompoundPaddingRight() {
      int var1;
      if(ViewUtils.isLayoutRtl(this)) {
         var1 = super.getCompoundPaddingRight();
      } else {
         var1 = super.getCompoundPaddingRight() + this.mSwitchWidth;
         if(!TextUtils.isEmpty(this.getText())) {
            return var1 + this.mSwitchPadding;
         }
      }

      return var1;
   }

   public boolean getShowText() {
      return this.mShowText;
   }

   public boolean getSplitTrack() {
      return this.mSplitTrack;
   }

   public int getSwitchMinWidth() {
      return this.mSwitchMinWidth;
   }

   public int getSwitchPadding() {
      return this.mSwitchPadding;
   }

   public CharSequence getTextOff() {
      return this.mTextOff;
   }

   public CharSequence getTextOn() {
      return this.mTextOn;
   }

   public Drawable getThumbDrawable() {
      return this.mThumbDrawable;
   }

   public int getThumbTextPadding() {
      return this.mThumbTextPadding;
   }

   public Drawable getTrackDrawable() {
      return this.mTrackDrawable;
   }

   public void jumpDrawablesToCurrentState() {
      if(VERSION.SDK_INT >= 11) {
         super.jumpDrawablesToCurrentState();
         if(this.mThumbDrawable != null) {
            this.mThumbDrawable.jumpToCurrentState();
         }

         if(this.mTrackDrawable != null) {
            this.mTrackDrawable.jumpToCurrentState();
         }

         this.cancelPositionAnimator();
         float var1;
         if(this.isChecked()) {
            var1 = 1.0F;
         } else {
            var1 = 0.0F;
         }

         this.setThumbPosition(var1);
      }

   }

   protected int[] onCreateDrawableState(int var1) {
      int[] var2 = super.onCreateDrawableState(var1 + 1);
      if(this.isChecked()) {
         mergeDrawableStates(var2, CHECKED_STATE_SET);
      }

      return var2;
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      Rect var2 = this.mTempRect;
      Drawable var3 = this.mTrackDrawable;
      if(var3 != null) {
         var3.getPadding(var2);
      } else {
         var2.setEmpty();
      }

      int var4 = this.mSwitchTop;
      int var5 = this.mSwitchBottom;
      int var6 = var4 + var2.top;
      int var7 = var5 - var2.bottom;
      Drawable var8 = this.mThumbDrawable;
      if(var3 != null) {
         if(this.mSplitTrack && var8 != null) {
            Rect var16 = DrawableUtils.getOpticalBounds(var8);
            var8.copyBounds(var2);
            var2.left += var16.left;
            var2.right -= var16.right;
            int var17 = var1.save();
            var1.clipRect(var2, Op.DIFFERENCE);
            var3.draw(var1);
            var1.restoreToCount(var17);
         } else {
            var3.draw(var1);
         }
      }

      int var9 = var1.save();
      if(var8 != null) {
         var8.draw(var1);
      }

      Layout var10;
      if(this.getTargetCheckedState()) {
         var10 = this.mOnLayout;
      } else {
         var10 = this.mOffLayout;
      }

      if(var10 != null) {
         int[] var11 = this.getDrawableState();
         if(this.mTextColors != null) {
            this.mTextPaint.setColor(this.mTextColors.getColorForState(var11, 0));
         }

         this.mTextPaint.drawableState = var11;
         int var12;
         if(var8 != null) {
            Rect var15 = var8.getBounds();
            var12 = var15.left + var15.right;
         } else {
            var12 = this.getWidth();
         }

         int var13 = var12 / 2 - var10.getWidth() / 2;
         int var14 = (var6 + var7) / 2 - var10.getHeight() / 2;
         var1.translate((float)var13, (float)var14);
         var10.draw(var1);
      }

      var1.restoreToCount(var9);
   }

   @TargetApi(14)
   public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
      super.onInitializeAccessibilityEvent(var1);
      var1.setClassName("android.widget.Switch");
   }

   public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo var1) {
      if(VERSION.SDK_INT >= 14) {
         super.onInitializeAccessibilityNodeInfo(var1);
         var1.setClassName("android.widget.Switch");
         CharSequence var2;
         if(this.isChecked()) {
            var2 = this.mTextOn;
         } else {
            var2 = this.mTextOff;
         }

         if(!TextUtils.isEmpty(var2)) {
            CharSequence var3 = var1.getText();
            if(!TextUtils.isEmpty(var3)) {
               StringBuilder var4 = new StringBuilder();
               var4.append(var3).append(' ').append(var2);
               var1.setText(var4);
               return;
            }

            var1.setText(var2);
         }
      }

   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      Drawable var6 = this.mThumbDrawable;
      int var7 = 0;
      int var8 = 0;
      if(var6 != null) {
         Rect var13 = this.mTempRect;
         if(this.mTrackDrawable != null) {
            this.mTrackDrawable.getPadding(var13);
         } else {
            var13.setEmpty();
         }

         Rect var14 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
         var7 = Math.max(0, var14.left - var13.left);
         var8 = Math.max(0, var14.right - var13.right);
      }

      int var9;
      int var10;
      if(ViewUtils.isLayoutRtl(this)) {
         var10 = var7 + this.getPaddingLeft();
         var9 = var10 + this.mSwitchWidth - var7 - var8;
      } else {
         var9 = this.getWidth() - this.getPaddingRight() - var8;
         var10 = var8 + var7 + (var9 - this.mSwitchWidth);
      }

      int var11;
      int var12;
      switch(112 & this.getGravity()) {
      case 16:
         var12 = (this.getPaddingTop() + this.getHeight() - this.getPaddingBottom()) / 2 - this.mSwitchHeight / 2;
         var11 = var12 + this.mSwitchHeight;
         break;
      case 80:
         var11 = this.getHeight() - this.getPaddingBottom();
         var12 = var11 - this.mSwitchHeight;
         break;
      default:
         var12 = this.getPaddingTop();
         var11 = var12 + this.mSwitchHeight;
      }

      this.mSwitchLeft = var10;
      this.mSwitchTop = var12;
      this.mSwitchBottom = var11;
      this.mSwitchRight = var9;
   }

   public void onMeasure(int var1, int var2) {
      if(this.mShowText) {
         if(this.mOnLayout == null) {
            this.mOnLayout = this.makeLayout(this.mTextOn);
         }

         if(this.mOffLayout == null) {
            this.mOffLayout = this.makeLayout(this.mTextOff);
         }
      }

      Rect var3 = this.mTempRect;
      int var4;
      int var5;
      if(this.mThumbDrawable != null) {
         this.mThumbDrawable.getPadding(var3);
         var5 = this.mThumbDrawable.getIntrinsicWidth() - var3.left - var3.right;
         var4 = this.mThumbDrawable.getIntrinsicHeight();
      } else {
         var4 = 0;
         var5 = 0;
      }

      int var6;
      if(this.mShowText) {
         var6 = Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + 2 * this.mThumbTextPadding;
      } else {
         var6 = 0;
      }

      this.mThumbWidth = Math.max(var6, var5);
      int var7;
      if(this.mTrackDrawable != null) {
         this.mTrackDrawable.getPadding(var3);
         var7 = this.mTrackDrawable.getIntrinsicHeight();
      } else {
         var3.setEmpty();
         var7 = 0;
      }

      int var8 = var3.left;
      int var9 = var3.right;
      if(this.mThumbDrawable != null) {
         Rect var12 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
         var8 = Math.max(var8, var12.left);
         var9 = Math.max(var9, var12.right);
      }

      int var10 = Math.max(this.mSwitchMinWidth, var9 + var8 + 2 * this.mThumbWidth);
      int var11 = Math.max(var7, var4);
      this.mSwitchWidth = var10;
      this.mSwitchHeight = var11;
      super.onMeasure(var1, var2);
      if(this.getMeasuredHeight() < var11) {
         this.setMeasuredDimension(ViewCompat.getMeasuredWidthAndState(this), var11);
      }

   }

   @TargetApi(14)
   public void onPopulateAccessibilityEvent(AccessibilityEvent var1) {
      super.onPopulateAccessibilityEvent(var1);
      CharSequence var2;
      if(this.isChecked()) {
         var2 = this.mTextOn;
      } else {
         var2 = this.mTextOff;
      }

      if(var2 != null) {
         var1.getText().add(var2);
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      this.mVelocityTracker.addMovement(var1);
      switch(MotionEventCompat.getActionMasked(var1)) {
      case 0:
         float var10 = var1.getX();
         float var11 = var1.getY();
         if(this.isEnabled() && this.hitThumb(var10, var11)) {
            this.mTouchMode = 1;
            this.mTouchX = var10;
            this.mTouchY = var11;
         }
         break;
      case 1:
      case 3:
         if(this.mTouchMode == 2) {
            this.stopDrag(var1);
            super.onTouchEvent(var1);
            return true;
         }

         this.mTouchMode = 0;
         this.mVelocityTracker.clear();
         break;
      case 2:
         switch(this.mTouchMode) {
         case 0:
         default:
            break;
         case 1:
            float var8 = var1.getX();
            float var9 = var1.getY();
            if(Math.abs(var8 - this.mTouchX) <= (float)this.mTouchSlop && Math.abs(var9 - this.mTouchY) <= (float)this.mTouchSlop) {
               break;
            }

            this.mTouchMode = 2;
            this.getParent().requestDisallowInterceptTouchEvent(true);
            this.mTouchX = var8;
            this.mTouchY = var9;
            return true;
         case 2:
            float var3 = var1.getX();
            int var4 = this.getThumbScrollRange();
            float var5 = var3 - this.mTouchX;
            float var6;
            if(var4 != 0) {
               var6 = var5 / (float)var4;
            } else if(var5 > 0.0F) {
               var6 = 1.0F;
            } else {
               var6 = -1.0F;
            }

            if(ViewUtils.isLayoutRtl(this)) {
               var6 = -var6;
            }

            float var7 = constrain(var6 + this.mThumbPosition, 0.0F, 1.0F);
            if(var7 != this.mThumbPosition) {
               this.mTouchX = var3;
               this.setThumbPosition(var7);
            }

            return true;
         }
      }

      return super.onTouchEvent(var1);
   }

   public void setChecked(boolean var1) {
      super.setChecked(var1);
      boolean var2 = this.isChecked();
      if(this.getWindowToken() != null && ViewCompat.isLaidOut(this) && this.isShown()) {
         this.animateThumbToCheckedState(var2);
      } else {
         this.cancelPositionAnimator();
         float var3;
         if(var2) {
            var3 = 1.0F;
         } else {
            var3 = 0.0F;
         }

         this.setThumbPosition(var3);
      }
   }

   public void setShowText(boolean var1) {
      if(this.mShowText != var1) {
         this.mShowText = var1;
         this.requestLayout();
      }

   }

   public void setSplitTrack(boolean var1) {
      this.mSplitTrack = var1;
      this.invalidate();
   }

   public void setSwitchMinWidth(int var1) {
      this.mSwitchMinWidth = var1;
      this.requestLayout();
   }

   public void setSwitchPadding(int var1) {
      this.mSwitchPadding = var1;
      this.requestLayout();
   }

   public void setSwitchTextAppearance(Context var1, int var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_22.styleable.TextAppearance);
      ColorStateList var4 = var3.getColorStateList(class_22.styleable.TextAppearance_android_textColor);
      if(var4 != null) {
         this.mTextColors = var4;
      } else {
         this.mTextColors = this.getTextColors();
      }

      int var5 = var3.getDimensionPixelSize(class_22.styleable.TextAppearance_android_textSize, 0);
      if(var5 != 0 && (float)var5 != this.mTextPaint.getTextSize()) {
         this.mTextPaint.setTextSize((float)var5);
         this.requestLayout();
      }

      this.setSwitchTypefaceByIndex(var3.getInt(class_22.styleable.TextAppearance_android_typeface, -1), var3.getInt(class_22.styleable.TextAppearance_android_textStyle, -1));
      if(var3.getBoolean(class_22.styleable.TextAppearance_textAllCaps, false)) {
         this.mSwitchTransformationMethod = new AllCapsTransformationMethod(this.getContext());
      } else {
         this.mSwitchTransformationMethod = null;
      }

      var3.recycle();
   }

   public void setSwitchTypeface(Typeface var1) {
      if(this.mTextPaint.getTypeface() != var1) {
         this.mTextPaint.setTypeface(var1);
         this.requestLayout();
         this.invalidate();
      }

   }

   public void setSwitchTypeface(Typeface var1, int var2) {
      if(var2 > 0) {
         Typeface var3;
         if(var1 == null) {
            var3 = Typeface.defaultFromStyle(var2);
         } else {
            var3 = Typeface.create(var1, var2);
         }

         this.setSwitchTypeface(var3);
         int var4;
         if(var3 != null) {
            var4 = var3.getStyle();
         } else {
            var4 = 0;
         }

         int var5 = var2 & ~var4;
         TextPaint var6 = this.mTextPaint;
         int var7 = var5 & 1;
         boolean var8 = false;
         if(var7 != 0) {
            var8 = true;
         }

         var6.setFakeBoldText(var8);
         TextPaint var9 = this.mTextPaint;
         float var10;
         if((var5 & 2) != 0) {
            var10 = -0.25F;
         } else {
            var10 = 0.0F;
         }

         var9.setTextSkewX(var10);
      } else {
         this.mTextPaint.setFakeBoldText(false);
         this.mTextPaint.setTextSkewX(0.0F);
         this.setSwitchTypeface(var1);
      }
   }

   public void setTextOff(CharSequence var1) {
      this.mTextOff = var1;
      this.requestLayout();
   }

   public void setTextOn(CharSequence var1) {
      this.mTextOn = var1;
      this.requestLayout();
   }

   public void setThumbDrawable(Drawable var1) {
      this.mThumbDrawable = var1;
      this.requestLayout();
   }

   public void setThumbResource(int var1) {
      this.setThumbDrawable(this.mDrawableManager.getDrawable(this.getContext(), var1));
   }

   public void setThumbTextPadding(int var1) {
      this.mThumbTextPadding = var1;
      this.requestLayout();
   }

   public void setTrackDrawable(Drawable var1) {
      this.mTrackDrawable = var1;
      this.requestLayout();
   }

   public void setTrackResource(int var1) {
      this.setTrackDrawable(this.mDrawableManager.getDrawable(this.getContext(), var1));
   }

   public void toggle() {
      boolean var1;
      if(!this.isChecked()) {
         var1 = true;
      } else {
         var1 = false;
      }

      this.setChecked(var1);
   }

   protected boolean verifyDrawable(Drawable var1) {
      return super.verifyDrawable(var1) || var1 == this.mThumbDrawable || var1 == this.mTrackDrawable;
   }

   private class ThumbAnimation extends Animation {
      final float mDiff;
      final float mEndPosition;
      final float mStartPosition;

      private ThumbAnimation(float var2, float var3) {
         this.mStartPosition = var2;
         this.mEndPosition = var3;
         this.mDiff = var3 - var2;
      }

      // $FF: synthetic method
      ThumbAnimation(float var2, float var3, Object var4) {
         this();
      }

      protected void applyTransformation(float var1, Transformation var2) {
         SwitchCompat.this.setThumbPosition(this.mStartPosition + var1 * this.mDiff);
      }
   }
}
