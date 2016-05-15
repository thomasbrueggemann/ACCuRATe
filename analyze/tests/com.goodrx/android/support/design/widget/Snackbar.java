package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.class_5;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SnackbarManager;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.design.widget.ThemeUtils;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Snackbar {
   static final int ANIMATION_DURATION = 250;
   static final int ANIMATION_FADE_DURATION = 180;
   public static final int LENGTH_INDEFINITE = -2;
   public static final int LENGTH_LONG = 0;
   public static final int LENGTH_SHORT = -1;
   private static final int MSG_DISMISS = 1;
   private static final int MSG_SHOW;
   private static final Handler sHandler = new Handler(Looper.getMainLooper(), new android.os.Handler.Callback() {
      public boolean handleMessage(Message var1) {
         switch(var1.what) {
         case 0:
            ((Snackbar)var1.obj).showView();
            return true;
         case 1:
            ((Snackbar)var1.obj).hideView(var1.arg1);
            return true;
         default:
            return false;
         }
      }
   });
   private final AccessibilityManager mAccessibilityManager;
   private Snackbar.Callback mCallback;
   private final Context mContext;
   private int mDuration;
   private final SnackbarManager.Callback mManagerCallback = new SnackbarManager.Callback() {
      public void dismiss(int var1) {
         Snackbar.sHandler.sendMessage(Snackbar.sHandler.obtainMessage(1, var1, 0, Snackbar.this));
      }

      public void show() {
         Snackbar.sHandler.sendMessage(Snackbar.sHandler.obtainMessage(0, Snackbar.this));
      }
   };
   private final ViewGroup mTargetParent;
   private final Snackbar.SnackbarLayout mView;

   private Snackbar(ViewGroup var1) {
      this.mTargetParent = var1;
      this.mContext = var1.getContext();
      ThemeUtils.checkAppCompatTheme(this.mContext);
      this.mView = (Snackbar.SnackbarLayout)LayoutInflater.from(this.mContext).inflate(class_5.layout.design_layout_snackbar, this.mTargetParent, false);
      this.mAccessibilityManager = (AccessibilityManager)this.mContext.getSystemService("accessibility");
   }

   private void animateViewIn() {
      if(VERSION.SDK_INT >= 14) {
         ViewCompat.setTranslationY(this.mView, (float)this.mView.getHeight());
         ViewCompat.animate(this.mView).translationY(0.0F).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setDuration(250L).setListener(new ViewPropertyAnimatorListenerAdapter() {
            public void onAnimationEnd(View var1) {
               Snackbar.this.onViewShown();
            }

            public void onAnimationStart(View var1) {
               if(!Snackbar.this.mAccessibilityManager.isEnabled()) {
                  Snackbar.this.mView.animateChildrenIn(70, 180);
               }

            }
         }).start();
      } else {
         Animation var1 = android.view.animation.AnimationUtils.loadAnimation(this.mView.getContext(), class_5.anim.design_snackbar_in);
         var1.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
         var1.setDuration(250L);
         var1.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation var1) {
               Snackbar.this.onViewShown();
            }

            public void onAnimationRepeat(Animation var1) {
            }

            public void onAnimationStart(Animation var1) {
            }
         });
         this.mView.startAnimation(var1);
      }
   }

   private void animateViewOut(final int var1) {
      if(VERSION.SDK_INT >= 14) {
         ViewCompat.animate(this.mView).translationY((float)this.mView.getHeight()).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setDuration(250L).setListener(new ViewPropertyAnimatorListenerAdapter() {
            boolean mEndCalled = false;

            public void onAnimationEnd(View var1x) {
               Snackbar.this.onViewHidden(var1);
            }

            public void onAnimationStart(View var1x) {
               if(!Snackbar.this.mAccessibilityManager.isEnabled()) {
                  Snackbar.this.mView.animateChildrenOut(0, 180);
               }

            }
         }).start();
      } else {
         Animation var2 = android.view.animation.AnimationUtils.loadAnimation(this.mView.getContext(), class_5.anim.design_snackbar_out);
         var2.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
         var2.setDuration(250L);
         var2.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation var1x) {
               Snackbar.this.onViewHidden(var1);
            }

            public void onAnimationRepeat(Animation var1x) {
            }

            public void onAnimationStart(Animation var1x) {
            }
         });
         this.mView.startAnimation(var2);
      }
   }

   private void dispatchDismiss(int var1) {
      SnackbarManager.getInstance().dismiss(this.mManagerCallback, var1);
   }

   private static ViewGroup findSuitableParent(View var0) {
      ViewGroup var1 = null;

      do {
         if(var0 instanceof CoordinatorLayout) {
            return (ViewGroup)var0;
         }

         if(var0 instanceof FrameLayout) {
            if(var0.getId() == 16908290) {
               return (ViewGroup)var0;
            }

            var1 = (ViewGroup)var0;
         }

         if(var0 != null) {
            ViewParent var2 = var0.getParent();
            if(var2 instanceof View) {
               var0 = (View)var2;
            } else {
               var0 = null;
            }
         }
      } while(var0 != null);

      return var1;
   }

   @NonNull
   public static Snackbar make(@NonNull View var0, @StringRes int var1, int var2) {
      return make(var0, var0.getResources().getText(var1), var2);
   }

   @NonNull
   public static Snackbar make(@NonNull View var0, @NonNull CharSequence var1, int var2) {
      Snackbar var3 = new Snackbar(findSuitableParent(var0));
      var3.setText(var1);
      var3.setDuration(var2);
      return var3;
   }

   private void onViewHidden(int var1) {
      SnackbarManager.getInstance().onDismissed(this.mManagerCallback);
      if(this.mCallback != null) {
         this.mCallback.onDismissed(this, var1);
      }

      ViewParent var2 = this.mView.getParent();
      if(var2 instanceof ViewGroup) {
         ((ViewGroup)var2).removeView(this.mView);
      }

   }

   private void onViewShown() {
      SnackbarManager.getInstance().onShown(this.mManagerCallback);
      if(this.mCallback != null) {
         this.mCallback.onShown(this);
      }

   }

   public void dismiss() {
      this.dispatchDismiss(3);
   }

   public int getDuration() {
      return this.mDuration;
   }

   @NonNull
   public View getView() {
      return this.mView;
   }

   final void hideView(int var1) {
      if(this.mView.getVisibility() != 0) {
         this.onViewHidden(var1);
      } else {
         this.animateViewOut(var1);
      }
   }

   public boolean isShown() {
      return SnackbarManager.getInstance().isCurrent(this.mManagerCallback);
   }

   public boolean isShownOrQueued() {
      return SnackbarManager.getInstance().isCurrentOrNext(this.mManagerCallback);
   }

   @NonNull
   public Snackbar setAction(@StringRes int var1, OnClickListener var2) {
      return this.setAction(this.mContext.getText(var1), var2);
   }

   @NonNull
   public Snackbar setAction(CharSequence var1, final OnClickListener var2) {
      Button var3 = this.mView.getActionView();
      if(!TextUtils.isEmpty(var1) && var2 != null) {
         var3.setVisibility(0);
         var3.setText(var1);
         var3.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               var2.onClick(var1);
               Snackbar.this.dispatchDismiss(1);
            }
         });
         return this;
      } else {
         var3.setVisibility(8);
         var3.setOnClickListener((OnClickListener)null);
         return this;
      }
   }

   @NonNull
   public Snackbar setActionTextColor(@ColorInt int var1) {
      this.mView.getActionView().setTextColor(var1);
      return this;
   }

   @NonNull
   public Snackbar setActionTextColor(ColorStateList var1) {
      this.mView.getActionView().setTextColor(var1);
      return this;
   }

   @NonNull
   public Snackbar setCallback(Snackbar.Callback var1) {
      this.mCallback = var1;
      return this;
   }

   @NonNull
   public Snackbar setDuration(int var1) {
      this.mDuration = var1;
      return this;
   }

   @NonNull
   public Snackbar setText(@StringRes int var1) {
      return this.setText(this.mContext.getText(var1));
   }

   @NonNull
   public Snackbar setText(@NonNull CharSequence var1) {
      this.mView.getMessageView().setText(var1);
      return this;
   }

   public void show() {
      SnackbarManager.getInstance().show(this.mDuration, this.mManagerCallback);
   }

   final void showView() {
      if(this.mView.getParent() == null) {
         LayoutParams var1 = this.mView.getLayoutParams();
         if(var1 instanceof CoordinatorLayout.LayoutParams) {
            Snackbar.Behavior var2 = new Snackbar.Behavior();
            var2.setStartAlphaSwipeDistance(0.1F);
            var2.setEndAlphaSwipeDistance(0.6F);
            var2.setSwipeDirection(0);
            var2.setListener(new SwipeDismissBehavior.OnDismissListener() {
               public void onDismiss(View var1) {
                  var1.setVisibility(8);
                  Snackbar.this.dispatchDismiss(0);
               }

               public void onDragStateChanged(int var1) {
                  switch(var1) {
                  case 0:
                     SnackbarManager.getInstance().restoreTimeout(Snackbar.this.mManagerCallback);
                     return;
                  case 1:
                  case 2:
                     SnackbarManager.getInstance().cancelTimeout(Snackbar.this.mManagerCallback);
                     return;
                  default:
                  }
               }
            });
            ((CoordinatorLayout.LayoutParams)var1).setBehavior(var2);
         }

         this.mTargetParent.addView(this.mView);
      }

      this.mView.setOnAttachStateChangeListener(new Snackbar.OnAttachStateChangeListener() {
         public void onViewAttachedToWindow(View var1) {
         }

         public void onViewDetachedFromWindow(View var1) {
            if(Snackbar.this.isShownOrQueued()) {
               Snackbar.sHandler.post(new Runnable() {
                  public void run() {
                     Snackbar.this.onViewHidden(3);
                  }
               });
            }

         }
      });
      if(ViewCompat.isLaidOut(this.mView)) {
         this.animateViewIn();
      } else {
         this.mView.setOnLayoutChangeListener(new Snackbar.OnLayoutChangeListener() {
            public void onLayoutChange(View var1, int var2, int var3, int var4, int var5) {
               Snackbar.this.animateViewIn();
               Snackbar.this.mView.setOnLayoutChangeListener((Snackbar.OnLayoutChangeListener)null);
            }
         });
      }
   }

   final class Behavior extends SwipeDismissBehavior<Snackbar.SnackbarLayout> {
      public boolean canSwipeDismissView(View var1) {
         return var1 instanceof Snackbar.SnackbarLayout;
      }

      public boolean onInterceptTouchEvent(CoordinatorLayout var1, Snackbar.SnackbarLayout var2, MotionEvent var3) {
         if(var1.isPointInChildBounds(var2, (int)var3.getX(), (int)var3.getY())) {
            switch(var3.getActionMasked()) {
            case 0:
               SnackbarManager.getInstance().cancelTimeout(Snackbar.this.mManagerCallback);
               break;
            case 1:
            case 3:
               SnackbarManager.getInstance().restoreTimeout(Snackbar.this.mManagerCallback);
            case 2:
            }
         }

         return super.onInterceptTouchEvent(var1, var2, var3);
      }
   }

   public abstract static class Callback {
      public static final int DISMISS_EVENT_ACTION = 1;
      public static final int DISMISS_EVENT_CONSECUTIVE = 4;
      public static final int DISMISS_EVENT_MANUAL = 3;
      public static final int DISMISS_EVENT_SWIPE = 0;
      public static final int DISMISS_EVENT_TIMEOUT = 2;

      public void onDismissed(Snackbar var1, int var2) {
      }

      public void onShown(Snackbar var1) {
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface DismissEvent {
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface Duration {
   }

   public static class SnackbarLayout extends LinearLayout {
      private Button mActionView;
      private int mMaxInlineActionWidth;
      private int mMaxWidth;
      private TextView mMessageView;
      private Snackbar.OnAttachStateChangeListener mOnAttachStateChangeListener;
      private Snackbar.OnLayoutChangeListener mOnLayoutChangeListener;

      public SnackbarLayout(Context var1) {
         this(var1, (AttributeSet)null);
      }

      public SnackbarLayout(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, class_5.styleable.SnackbarLayout);
         this.mMaxWidth = var3.getDimensionPixelSize(class_5.styleable.SnackbarLayout_android_maxWidth, -1);
         this.mMaxInlineActionWidth = var3.getDimensionPixelSize(class_5.styleable.SnackbarLayout_maxActionInlineWidth, -1);
         if(var3.hasValue(class_5.styleable.SnackbarLayout_elevation)) {
            ViewCompat.setElevation(this, (float)var3.getDimensionPixelSize(class_5.styleable.SnackbarLayout_elevation, 0));
         }

         var3.recycle();
         this.setClickable(true);
         LayoutInflater.from(var1).inflate(class_5.layout.design_layout_snackbar_include, this);
         ViewCompat.setAccessibilityLiveRegion(this, 1);
         ViewCompat.setImportantForAccessibility(this, 1);
      }

      private static void updateTopBottomPadding(View var0, int var1, int var2) {
         if(ViewCompat.isPaddingRelative(var0)) {
            ViewCompat.setPaddingRelative(var0, ViewCompat.getPaddingStart(var0), var1, ViewCompat.getPaddingEnd(var0), var2);
         } else {
            var0.setPadding(var0.getPaddingLeft(), var1, var0.getPaddingRight(), var2);
         }
      }

      private boolean updateViewsWithinLayout(int var1, int var2, int var3) {
         int var4 = this.getOrientation();
         boolean var5 = false;
         if(var1 != var4) {
            this.setOrientation(var1);
            var5 = true;
         }

         if(this.mMessageView.getPaddingTop() != var2 || this.mMessageView.getPaddingBottom() != var3) {
            updateTopBottomPadding(this.mMessageView, var2, var3);
            var5 = true;
         }

         return var5;
      }

      void animateChildrenIn(int var1, int var2) {
         ViewCompat.setAlpha(this.mMessageView, 0.0F);
         ViewCompat.animate(this.mMessageView).alpha(1.0F).setDuration((long)var2).setStartDelay((long)var1).start();
         if(this.mActionView.getVisibility() == 0) {
            ViewCompat.setAlpha(this.mActionView, 0.0F);
            ViewCompat.animate(this.mActionView).alpha(1.0F).setDuration((long)var2).setStartDelay((long)var1).start();
         }

      }

      void animateChildrenOut(int var1, int var2) {
         ViewCompat.setAlpha(this.mMessageView, 1.0F);
         ViewCompat.animate(this.mMessageView).alpha(0.0F).setDuration((long)var2).setStartDelay((long)var1).start();
         if(this.mActionView.getVisibility() == 0) {
            ViewCompat.setAlpha(this.mActionView, 1.0F);
            ViewCompat.animate(this.mActionView).alpha(0.0F).setDuration((long)var2).setStartDelay((long)var1).start();
         }

      }

      Button getActionView() {
         return this.mActionView;
      }

      TextView getMessageView() {
         return this.mMessageView;
      }

      protected void onAttachedToWindow() {
         super.onAttachedToWindow();
         if(this.mOnAttachStateChangeListener != null) {
            this.mOnAttachStateChangeListener.onViewAttachedToWindow(this);
         }

      }

      protected void onDetachedFromWindow() {
         super.onDetachedFromWindow();
         if(this.mOnAttachStateChangeListener != null) {
            this.mOnAttachStateChangeListener.onViewDetachedFromWindow(this);
         }

      }

      protected void onFinishInflate() {
         super.onFinishInflate();
         this.mMessageView = (TextView)this.findViewById(class_5.class_113.snackbar_text);
         this.mActionView = (Button)this.findViewById(class_5.class_113.snackbar_action);
      }

      protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
         super.onLayout(var1, var2, var3, var4, var5);
         if(this.mOnLayoutChangeListener != null) {
            this.mOnLayoutChangeListener.onLayoutChange(this, var2, var3, var4, var5);
         }

      }

      protected void onMeasure(int var1, int var2) {
         super.onMeasure(var1, var2);
         if(this.mMaxWidth > 0 && this.getMeasuredWidth() > this.mMaxWidth) {
            var1 = MeasureSpec.makeMeasureSpec(this.mMaxWidth, 1073741824);
            super.onMeasure(var1, var2);
         }

         int var3 = this.getResources().getDimensionPixelSize(class_5.dimen.design_snackbar_padding_vertical_2lines);
         int var4 = this.getResources().getDimensionPixelSize(class_5.dimen.design_snackbar_padding_vertical);
         boolean var5;
         if(this.mMessageView.getLayout().getLineCount() > 1) {
            var5 = true;
         } else {
            var5 = false;
         }

         boolean var8;
         if(var5 && this.mMaxInlineActionWidth > 0 && this.mActionView.getMeasuredWidth() > this.mMaxInlineActionWidth) {
            boolean var9 = this.updateViewsWithinLayout(1, var3, var3 - var4);
            var8 = false;
            if(var9) {
               var8 = true;
            }
         } else {
            int var6;
            if(var5) {
               var6 = var3;
            } else {
               var6 = var4;
            }

            boolean var7 = this.updateViewsWithinLayout(0, var6, var6);
            var8 = false;
            if(var7) {
               var8 = true;
            }
         }

         if(var8) {
            super.onMeasure(var1, var2);
         }

      }

      void setOnAttachStateChangeListener(Snackbar.OnAttachStateChangeListener var1) {
         this.mOnAttachStateChangeListener = var1;
      }

      void setOnLayoutChangeListener(Snackbar.OnLayoutChangeListener var1) {
         this.mOnLayoutChangeListener = var1;
      }
   }

   interface OnAttachStateChangeListener {
      void onViewAttachedToWindow(View var1);

      void onViewDetachedFromWindow(View var1);
   }

   interface OnLayoutChangeListener {
      void onLayoutChange(View var1, int var2, int var3, int var4, int var5);
   }
}
