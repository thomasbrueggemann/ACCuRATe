package com.flipboard.bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.KeyEvent.DispatcherState;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.flipboard.bottomsheet.BaseViewTransformer;
import com.flipboard.bottomsheet.OnSheetDismissedListener;
import com.flipboard.bottomsheet.ViewTransformer;
import flipboard.bottomsheet.R.bool;
import flipboard.bottomsheet.R.dimen;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class BottomSheetLayout extends FrameLayout {
   private static final Property<BottomSheetLayout, Float> SHEET_TRANSLATION = new Property(Float.class, "sheetTranslation") {
      public Float get(BottomSheetLayout var1) {
         return Float.valueOf(var1.sheetTranslation);
      }

      public void set(BottomSheetLayout var1, Float var2) {
         var1.setSheetTranslation(var2.floatValue());
      }
   };
   private TimeInterpolator animationInterpolator;
   public boolean bottomSheetOwnsTouch;
   private Rect contentClipRect;
   private Animator currentAnimator;
   private int currentSheetViewHeight;
   private final int defaultSheetWidth;
   private ViewTransformer defaultViewTransformer;
   private View dimView;
   private float downSheetTranslation;
   private BottomSheetLayout.State downState;
   private float downX;
   private float downY;
   private boolean hasIntercepted;
   private boolean interceptContentTouch;
   private final boolean isTablet;
   private float minFlingVelocity;
   private CopyOnWriteArraySet<OnSheetDismissedListener> onSheetDismissedListeners;
   private CopyOnWriteArraySet<BottomSheetLayout.OnSheetStateChangeListener> onSheetStateChangeListeners;
   private float peek;
   private boolean peekOnDismiss;
   private Runnable runAfterDismiss;
   private int screenWidth;
   private int sheetEndX;
   private int sheetStartX;
   private float sheetTranslation;
   private OnLayoutChangeListener sheetViewOnLayoutChangeListener;
   private boolean sheetViewOwnsTouch;
   private boolean shouldDimContentView;
   private BottomSheetLayout.State state;
   private float touchSlop;
   private boolean useHardwareLayerWhileAnimating;
   private VelocityTracker velocityTracker;
   private ViewTransformer viewTransformer;

   public BottomSheetLayout(Context var1) {
      super(var1);
      this.contentClipRect = new Rect();
      this.state = BottomSheetLayout.State.HIDDEN;
      this.peekOnDismiss = false;
      this.animationInterpolator = new DecelerateInterpolator(1.6F);
      this.defaultViewTransformer = new BottomSheetLayout.IdentityViewTransformer(null);
      this.shouldDimContentView = true;
      this.useHardwareLayerWhileAnimating = true;
      this.onSheetDismissedListeners = new CopyOnWriteArraySet();
      this.onSheetStateChangeListeners = new CopyOnWriteArraySet();
      this.interceptContentTouch = true;
      this.screenWidth = 0;
      this.isTablet = this.getResources().getBoolean(bool.bottomsheet_is_tablet);
      this.defaultSheetWidth = this.getResources().getDimensionPixelSize(dimen.bottomsheet_default_sheet_width);
      this.sheetStartX = 0;
      this.sheetEndX = 0;
      this.init();
   }

   public BottomSheetLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public BottomSheetLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.contentClipRect = new Rect();
      this.state = BottomSheetLayout.State.HIDDEN;
      this.peekOnDismiss = false;
      this.animationInterpolator = new DecelerateInterpolator(1.6F);
      this.defaultViewTransformer = new BottomSheetLayout.IdentityViewTransformer(null);
      this.shouldDimContentView = true;
      this.useHardwareLayerWhileAnimating = true;
      this.onSheetDismissedListeners = new CopyOnWriteArraySet();
      this.onSheetStateChangeListeners = new CopyOnWriteArraySet();
      this.interceptContentTouch = true;
      this.screenWidth = 0;
      this.isTablet = this.getResources().getBoolean(bool.bottomsheet_is_tablet);
      this.defaultSheetWidth = this.getResources().getDimensionPixelSize(dimen.bottomsheet_default_sheet_width);
      this.sheetStartX = 0;
      this.sheetEndX = 0;
      this.init();
   }

   @TargetApi(21)
   public BottomSheetLayout(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3, var4);
      this.contentClipRect = new Rect();
      this.state = BottomSheetLayout.State.HIDDEN;
      this.peekOnDismiss = false;
      this.animationInterpolator = new DecelerateInterpolator(1.6F);
      this.defaultViewTransformer = new BottomSheetLayout.IdentityViewTransformer(null);
      this.shouldDimContentView = true;
      this.useHardwareLayerWhileAnimating = true;
      this.onSheetDismissedListeners = new CopyOnWriteArraySet();
      this.onSheetStateChangeListeners = new CopyOnWriteArraySet();
      this.interceptContentTouch = true;
      this.screenWidth = 0;
      this.isTablet = this.getResources().getBoolean(bool.bottomsheet_is_tablet);
      this.defaultSheetWidth = this.getResources().getDimensionPixelSize(dimen.bottomsheet_default_sheet_width);
      this.sheetStartX = 0;
      this.sheetEndX = 0;
      this.init();
   }

   private boolean canScrollUp(View var1, float var2, float var3) {
      if(var1 instanceof ViewGroup) {
         ViewGroup var4 = (ViewGroup)var1;

         for(int var5 = 0; var5 < var4.getChildCount(); ++var5) {
            View var6 = var4.getChildAt(var5);
            int var7 = var6.getLeft();
            int var8 = var6.getTop();
            int var9 = var6.getRight();
            int var10 = var6.getBottom();
            boolean var11;
            if(var2 > (float)var7 && var2 < (float)var9 && var3 > (float)var8 && var3 < (float)var10) {
               var11 = true;
            } else {
               var11 = false;
            }

            if(var11 && this.canScrollUp(var6, var2 - (float)var7, var3 - (float)var8)) {
               return true;
            }
         }
      }

      return var1.canScrollVertically(-1);
   }

   private void cancelCurrentAnimation() {
      if(this.currentAnimator != null) {
         this.currentAnimator.cancel();
      }

   }

   private void dismissSheet(Runnable var1) {
      if(this.state == BottomSheetLayout.State.HIDDEN) {
         this.runAfterDismiss = null;
      } else {
         this.runAfterDismiss = var1;
         final View var2 = this.getSheetView();
         var2.removeOnLayoutChangeListener(this.sheetViewOnLayoutChangeListener);
         this.cancelCurrentAnimation();
         ObjectAnimator var3 = ObjectAnimator.ofFloat(this, SHEET_TRANSLATION, new float[]{0.0F});
         var3.setDuration(300L);
         var3.setInterpolator(this.animationInterpolator);
         var3.addListener(new BottomSheetLayout.CancelDetectionAnimationListener(null) {
            public void onAnimationEnd(Animator var1) {
               if(!this.canceled) {
                  BottomSheetLayout.this.currentAnimator = null;
                  BottomSheetLayout.this.setState(BottomSheetLayout.State.HIDDEN);
                  BottomSheetLayout.this.setSheetLayerTypeIfEnabled(0);
                  BottomSheetLayout.this.removeView(var2);
                  Iterator var3 = BottomSheetLayout.this.onSheetDismissedListeners.iterator();

                  while(var3.hasNext()) {
                     ((OnSheetDismissedListener)var3.next()).onDismissed(BottomSheetLayout.this);
                  }

                  BottomSheetLayout.this.viewTransformer = null;
                  BottomSheetLayout.this.onSheetDismissedListeners.clear();
                  BottomSheetLayout.this.onSheetStateChangeListeners.clear();
                  if(BottomSheetLayout.this.runAfterDismiss != null) {
                     BottomSheetLayout.this.runAfterDismiss.run();
                     BottomSheetLayout.this.runAfterDismiss = null;
                  }
               }

            }
         });
         var3.start();
         this.currentAnimator = var3;
         this.sheetStartX = 0;
         this.sheetEndX = this.screenWidth;
      }
   }

   private float getDefaultPeekTranslation() {
      return this.hasFullHeightSheet()?(float)(this.getHeight() / 3):(float)this.getSheetView().getHeight();
   }

   private float getDimAlpha(float var1) {
      return this.viewTransformer != null?this.viewTransformer.getDimAlpha(var1, this.getMaxSheetTranslation(), this.getPeekSheetTranslation(), this, this.getContentView()):(this.defaultViewTransformer != null?this.defaultViewTransformer.getDimAlpha(var1, this.getMaxSheetTranslation(), this.getPeekSheetTranslation(), this, this.getContentView()):0.0F);
   }

   private boolean hasFullHeightSheet() {
      return this.getSheetView() == null || this.getSheetView().getHeight() == this.getHeight();
   }

   private void init() {
      ViewConfiguration var1 = ViewConfiguration.get(this.getContext());
      this.minFlingVelocity = (float)var1.getScaledMinimumFlingVelocity();
      this.touchSlop = (float)var1.getScaledTouchSlop();
      this.dimView = new View(this.getContext());
      this.dimView.setBackgroundColor(-16777216);
      this.dimView.setAlpha(0.0F);
      this.dimView.setVisibility(4);
      this.peek = 0.0F;
      this.setFocusableInTouchMode(true);
      Point var2 = new Point();
      ((WindowManager)this.getContext().getSystemService("window")).getDefaultDisplay().getSize(var2);
      this.screenWidth = var2.x;
      this.sheetEndX = this.screenWidth;
   }

   private void initializeSheetValues() {
      this.sheetTranslation = 0.0F;
      this.contentClipRect.set(0, 0, this.getWidth(), this.getHeight());
      this.getSheetView().setTranslationY((float)this.getHeight());
      this.dimView.setAlpha(0.0F);
      this.dimView.setVisibility(4);
   }

   private boolean isAnimating() {
      return this.currentAnimator != null;
   }

   private boolean isXInSheet(float var1) {
      return !this.isTablet || var1 >= (float)this.sheetStartX && var1 <= (float)this.sheetEndX;
   }

   private void setSheetLayerTypeIfEnabled(int var1) {
      if(this.useHardwareLayerWhileAnimating) {
         this.getSheetView().setLayerType(var1, (Paint)null);
      }

   }

   private void setSheetTranslation(float var1) {
      this.sheetTranslation = var1;
      int var2 = (int)((double)this.getHeight() - Math.ceil((double)var1));
      this.contentClipRect.set(0, 0, this.getWidth(), var2);
      this.getSheetView().setTranslationY((float)this.getHeight() - var1);
      this.transformView(var1);
      if(this.shouldDimContentView) {
         float var3 = this.getDimAlpha(var1);
         this.dimView.setAlpha(var3);
         View var4 = this.dimView;
         float var7;
         int var5 = (var7 = var3 - 0.0F) == 0.0F?0:(var7 < 0.0F?-1:1);
         byte var6 = 0;
         if(var5 <= 0) {
            var6 = 4;
         }

         var4.setVisibility(var6);
      }

   }

   private void setState(BottomSheetLayout.State var1) {
      this.state = var1;
      Iterator var2 = this.onSheetStateChangeListeners.iterator();

      while(var2.hasNext()) {
         ((BottomSheetLayout.OnSheetStateChangeListener)var2.next()).onSheetStateChanged(var1);
      }

   }

   private void transformView(float var1) {
      if(this.viewTransformer != null) {
         this.viewTransformer.transformView(var1, this.getMaxSheetTranslation(), this.getPeekSheetTranslation(), this, this.getContentView());
      } else if(this.defaultViewTransformer != null) {
         this.defaultViewTransformer.transformView(var1, this.getMaxSheetTranslation(), this.getPeekSheetTranslation(), this, this.getContentView());
         return;
      }

   }

   public void addView(@NonNull View var1) {
      if(this.getChildCount() > 0) {
         throw new IllegalArgumentException("You may not declare more then one child of bottom sheet. The sheet view must be added dynamically with showWithSheetView()");
      } else {
         this.setContentView(var1);
      }
   }

   public void addView(@NonNull View var1, int var2) {
      this.addView(var1);
   }

   public void addView(@NonNull View var1, int var2, int var3) {
      this.addView(var1);
   }

   public void addView(@NonNull View var1, int var2, @NonNull LayoutParams var3) {
      this.addView(var1);
   }

   public void addView(@NonNull View var1, @NonNull LayoutParams var2) {
      this.addView(var1);
   }

   public void dismissSheet() {
      this.dismissSheet((Runnable)null);
   }

   public void expandSheet() {
      this.cancelCurrentAnimation();
      this.setSheetLayerTypeIfEnabled(0);
      Property var1 = SHEET_TRANSLATION;
      float[] var2 = new float[]{this.getMaxSheetTranslation()};
      ObjectAnimator var3 = ObjectAnimator.ofFloat(this, var1, var2);
      var3.setDuration(300L);
      var3.setInterpolator(this.animationInterpolator);
      var3.addListener(new BottomSheetLayout.CancelDetectionAnimationListener(null) {
         public void onAnimationEnd(@NonNull Animator var1) {
            if(!this.canceled) {
               BottomSheetLayout.this.currentAnimator = null;
            }

         }
      });
      var3.start();
      this.currentAnimator = var3;
      this.setState(BottomSheetLayout.State.EXPANDED);
   }

   public View getContentView() {
      return this.getChildCount() > 0?this.getChildAt(0):null;
   }

   public boolean getInterceptContentTouch() {
      return this.interceptContentTouch;
   }

   public float getMaxSheetTranslation() {
      return this.hasFullHeightSheet()?(float)(this.getHeight() - this.getPaddingTop()):(float)this.getSheetView().getHeight();
   }

   public boolean getPeekOnDismiss() {
      return this.peekOnDismiss;
   }

   public float getPeekSheetTranslation() {
      return this.peek == 0.0F?this.getDefaultPeekTranslation():this.peek;
   }

   public View getSheetView() {
      return this.getChildCount() > 2?this.getChildAt(2):null;
   }

   public BottomSheetLayout.State getState() {
      return this.state;
   }

   public boolean isSheetShowing() {
      return this.state != BottomSheetLayout.State.HIDDEN;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.velocityTracker = VelocityTracker.obtain();
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.velocityTracker.clear();
      this.cancelCurrentAnimation();
   }

   public boolean onInterceptTouchEvent(@NonNull MotionEvent var1) {
      boolean var2 = true;
      boolean var3;
      if(var1.getActionMasked() == 0) {
         var3 = var2;
      } else {
         var3 = false;
      }

      if(var3) {
         this.hasIntercepted = false;
      }

      if(!this.interceptContentTouch && (var1.getY() <= (float)this.getHeight() - this.sheetTranslation || !this.isXInSheet(var1.getX()))) {
         this.hasIntercepted = false;
      } else {
         if(!var3 || !this.isSheetShowing()) {
            var2 = false;
         }

         this.hasIntercepted = var2;
      }

      return this.hasIntercepted;
   }

   public boolean onKeyPreIme(int var1, @NonNull KeyEvent var2) {
      if(var1 == 4 && this.isSheetShowing()) {
         if(var2.getAction() == 0 && var2.getRepeatCount() == 0) {
            DispatcherState var4 = this.getKeyDispatcherState();
            if(var4 != null) {
               var4.startTracking(var2, this);
            }

            return true;
         }

         if(var2.getAction() == 1) {
            DispatcherState var3 = this.getKeyDispatcherState();
            if(var3 != null) {
               var3.handleUpEvent(var2);
            }

            if(this.isSheetShowing() && var2.isTracking() && !var2.isCanceled()) {
               if(this.state == BottomSheetLayout.State.EXPANDED && this.peekOnDismiss) {
                  this.peekSheet();
                  return true;
               }

               this.dismissSheet();
               return true;
            }
         }
      }

      return super.onKeyPreIme(var1, var2);
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      int var6 = (int)((double)this.getHeight() - Math.ceil((double)this.sheetTranslation));
      this.contentClipRect.set(0, 0, this.getWidth(), var6);
   }

   public boolean onTouchEvent(@NonNull MotionEvent var1) {
      if(!this.isSheetShowing()) {
         return false;
      } else if(this.isAnimating()) {
         return false;
      } else if(!this.hasIntercepted) {
         return this.onInterceptTouchEvent(var1);
      } else {
         if(var1.getAction() == 0) {
            this.bottomSheetOwnsTouch = false;
            this.sheetViewOwnsTouch = false;
            this.downY = var1.getY();
            this.downX = var1.getX();
            this.downSheetTranslation = this.sheetTranslation;
            this.downState = this.state;
            this.velocityTracker.clear();
         }

         this.velocityTracker.addMovement(var1);
         float var2 = this.getMaxSheetTranslation();
         float var3 = this.getPeekSheetTranslation();
         float var4 = this.downY - var1.getY();
         float var5 = this.downX - var1.getX();
         if(!this.bottomSheetOwnsTouch && !this.sheetViewOwnsTouch) {
            boolean var18;
            if(Math.abs(var4) > this.touchSlop) {
               var18 = true;
            } else {
               var18 = false;
            }

            this.bottomSheetOwnsTouch = var18;
            boolean var19;
            if(Math.abs(var5) > this.touchSlop) {
               var19 = true;
            } else {
               var19 = false;
            }

            this.sheetViewOwnsTouch = var19;
            if(this.bottomSheetOwnsTouch) {
               if(this.state == BottomSheetLayout.State.PEEKED) {
                  MotionEvent var20 = MotionEvent.obtain(var1);
                  var20.offsetLocation(0.0F, this.sheetTranslation - (float)this.getHeight());
                  var20.setAction(3);
                  this.getSheetView().dispatchTouchEvent(var20);
                  var20.recycle();
               }

               this.sheetViewOwnsTouch = false;
               this.downY = var1.getY();
               this.downX = var1.getX();
               var4 = 0.0F;
            }
         }

         float var6 = var4 + this.downSheetTranslation;
         if(this.bottomSheetOwnsTouch) {
            boolean var10;
            if(var4 < 0.0F) {
               var10 = true;
            } else {
               var10 = false;
            }

            boolean var11 = this.canScrollUp(this.getSheetView(), var1.getX(), var1.getY() + (this.sheetTranslation - (float)this.getHeight()));
            if(this.state == BottomSheetLayout.State.EXPANDED && var10 && !var11) {
               this.downY = var1.getY();
               this.downSheetTranslation = this.sheetTranslation;
               this.velocityTracker.clear();
               this.setState(BottomSheetLayout.State.PEEKED);
               this.setSheetLayerTypeIfEnabled(2);
               var6 = this.sheetTranslation;
               MotionEvent var16 = MotionEvent.obtain(var1);
               var16.setAction(3);
               this.getSheetView().dispatchTouchEvent(var16);
               var16.recycle();
            }

            if(this.state == BottomSheetLayout.State.PEEKED && var6 > var2) {
               this.setSheetTranslation(var2);
               var6 = Math.min(var2, var6);
               MotionEvent var14 = MotionEvent.obtain(var1);
               var14.setAction(0);
               this.getSheetView().dispatchTouchEvent(var14);
               var14.recycle();
               this.setState(BottomSheetLayout.State.EXPANDED);
               this.setSheetLayerTypeIfEnabled(0);
            }

            if(this.state == BottomSheetLayout.State.EXPANDED) {
               var1.offsetLocation(0.0F, this.sheetTranslation - (float)this.getHeight());
               this.getSheetView().dispatchTouchEvent(var1);
            } else {
               if(var6 < var3) {
                  var6 = var3 - (var3 - var6) / 4.0F;
               }

               this.setSheetTranslation(var6);
               if(var1.getAction() == 3) {
                  if(this.downState == BottomSheetLayout.State.EXPANDED) {
                     this.expandSheet();
                  } else {
                     this.peekSheet();
                  }
               }

               if(var1.getAction() == 1) {
                  if(var6 < var3) {
                     this.dismissSheet();
                  } else {
                     this.velocityTracker.computeCurrentVelocity(1000);
                     float var12 = this.velocityTracker.getYVelocity();
                     if(Math.abs(var12) < this.minFlingVelocity) {
                        if(this.sheetTranslation > (float)(this.getHeight() / 2)) {
                           this.expandSheet();
                        } else {
                           this.peekSheet();
                        }
                     } else if(var12 < 0.0F) {
                        this.expandSheet();
                     } else {
                        this.peekSheet();
                     }
                  }
               }
            }
         } else {
            boolean var7;
            if(var1.getY() >= (float)this.getHeight() - this.sheetTranslation && this.isXInSheet(var1.getX())) {
               var7 = false;
            } else {
               var7 = true;
            }

            if(var1.getAction() == 1 && var7 && this.interceptContentTouch) {
               this.dismissSheet();
               return true;
            }

            float var8;
            if(this.isTablet) {
               var8 = this.getX() - (float)this.sheetStartX;
            } else {
               var8 = 0.0F;
            }

            var1.offsetLocation(var8, this.sheetTranslation - (float)this.getHeight());
            this.getSheetView().dispatchTouchEvent(var1);
         }

         return true;
      }
   }

   public void peekSheet() {
      this.cancelCurrentAnimation();
      this.setSheetLayerTypeIfEnabled(2);
      Property var1 = SHEET_TRANSLATION;
      float[] var2 = new float[]{this.getPeekSheetTranslation()};
      ObjectAnimator var3 = ObjectAnimator.ofFloat(this, var1, var2);
      var3.setDuration(300L);
      var3.setInterpolator(this.animationInterpolator);
      var3.addListener(new BottomSheetLayout.CancelDetectionAnimationListener(null) {
         public void onAnimationEnd(@NonNull Animator var1) {
            if(!this.canceled) {
               BottomSheetLayout.this.currentAnimator = null;
            }

         }
      });
      var3.start();
      this.currentAnimator = var3;
      this.setState(BottomSheetLayout.State.PEEKED);
   }

   public void setContentView(View var1) {
      super.addView(var1, -1, this.generateDefaultLayoutParams());
      super.addView(this.dimView, -1, this.generateDefaultLayoutParams());
   }

   public void setDefaultViewTransformer(ViewTransformer var1) {
      this.defaultViewTransformer = var1;
   }

   public void setInterceptContentTouch(boolean var1) {
      this.interceptContentTouch = var1;
   }

   public void setPeekOnDismiss(boolean var1) {
      this.peekOnDismiss = var1;
   }

   public void setPeekSheetTranslation(float var1) {
      this.peek = var1;
   }

   public void setShouldDimContentView(boolean var1) {
      this.shouldDimContentView = var1;
   }

   public void setUseHardwareLayerWhileAnimating(boolean var1) {
      this.useHardwareLayerWhileAnimating = var1;
   }

   public void showWithSheetView(View var1) {
      this.showWithSheetView(var1, (ViewTransformer)null);
   }

   public void showWithSheetView(final View var1, final ViewTransformer var2) {
      if(this.state != BottomSheetLayout.State.HIDDEN) {
         this.dismissSheet(new Runnable() {
            public void run() {
               BottomSheetLayout.this.showWithSheetView(var1, var2);
            }
         });
      } else {
         this.setState(BottomSheetLayout.State.PREPARING);
         android.widget.FrameLayout.LayoutParams var3 = (android.widget.FrameLayout.LayoutParams)var1.getLayoutParams();
         if(var3 == null) {
            byte var4;
            if(this.isTablet) {
               var4 = -2;
            } else {
               var4 = -1;
            }

            var3 = new android.widget.FrameLayout.LayoutParams(var4, -2, 1);
         }

         if(this.isTablet && var3.width == -2) {
            if(var3.gravity == -1) {
               var3.gravity = 1;
            }

            var3.width = this.defaultSheetWidth;
            this.sheetStartX = (this.screenWidth - this.defaultSheetWidth) / 2;
            this.sheetEndX = this.screenWidth - this.sheetStartX;
         }

         super.addView(var1, -1, var3);
         this.initializeSheetValues();
         this.viewTransformer = var2;
         this.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public boolean onPreDraw() {
               BottomSheetLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
               BottomSheetLayout.this.post(new Runnable() {
                  public void run() {
                     if(BottomSheetLayout.this.getSheetView() != null) {
                        BottomSheetLayout.this.peekSheet();
                     }

                  }
               });
               return true;
            }
         });
         this.currentSheetViewHeight = var1.getMeasuredHeight();
         this.sheetViewOnLayoutChangeListener = new OnLayoutChangeListener() {
            public void onLayoutChange(View var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
               int var10 = var1.getMeasuredHeight();
               if(BottomSheetLayout.this.state != BottomSheetLayout.State.HIDDEN && var10 < BottomSheetLayout.this.currentSheetViewHeight) {
                  if(BottomSheetLayout.this.state == BottomSheetLayout.State.EXPANDED) {
                     BottomSheetLayout.this.setState(BottomSheetLayout.State.PEEKED);
                  }

                  BottomSheetLayout.this.setSheetTranslation((float)var10);
               }

               BottomSheetLayout.this.currentSheetViewHeight = var10;
            }
         };
         var1.addOnLayoutChangeListener(this.sheetViewOnLayoutChangeListener);
      }
   }

   private static class CancelDetectionAnimationListener extends AnimatorListenerAdapter {
      protected boolean canceled;

      private CancelDetectionAnimationListener() {
      }

      // $FF: synthetic method
      CancelDetectionAnimationListener(Object var1) {
         this();
      }

      public void onAnimationCancel(Animator var1) {
         this.canceled = true;
      }
   }

   private static class IdentityViewTransformer extends BaseViewTransformer {
      private IdentityViewTransformer() {
      }

      // $FF: synthetic method
      IdentityViewTransformer(Object var1) {
         this();
      }

      public void transformView(float var1, float var2, float var3, BottomSheetLayout var4, View var5) {
      }
   }

   public interface OnSheetStateChangeListener {
      void onSheetStateChanged(BottomSheetLayout.State var1);
   }

   public static enum State {
      EXPANDED,
      HIDDEN,
      PEEKED,
      PREPARING;

      static {
         BottomSheetLayout.State[] var0 = new BottomSheetLayout.State[]{HIDDEN, PREPARING, PEEKED, EXPANDED};
      }
   }
}
