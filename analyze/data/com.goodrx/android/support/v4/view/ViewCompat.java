package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewCompatBase;
import android.support.v4.view.ViewCompatEclairMr1;
import android.support.v4.view.ViewCompatGingerbread;
import android.support.v4.view.ViewCompatHC;
import android.support.v4.view.ViewCompatICS;
import android.support.v4.view.ViewCompatICSMr1;
import android.support.v4.view.ViewCompatJB;
import android.support.v4.view.ViewCompatJellybeanMr1;
import android.support.v4.view.ViewCompatJellybeanMr2;
import android.support.v4.view.ViewCompatKitKat;
import android.support.v4.view.ViewCompatLollipop;
import android.support.v4.view.ViewCompatMarshmallow;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public final class ViewCompat {
   public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
   public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
   public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
   private static final long FAKE_FRAME_TIME = 10L;
   static final ViewCompat.ViewCompatImpl IMPL;
   public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
   public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
   public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
   public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
   public static final int LAYER_TYPE_HARDWARE = 2;
   public static final int LAYER_TYPE_NONE = 0;
   public static final int LAYER_TYPE_SOFTWARE = 1;
   public static final int LAYOUT_DIRECTION_INHERIT = 2;
   public static final int LAYOUT_DIRECTION_LOCALE = 3;
   public static final int LAYOUT_DIRECTION_LTR = 0;
   public static final int LAYOUT_DIRECTION_RTL = 1;
   public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
   public static final int MEASURED_SIZE_MASK = 16777215;
   public static final int MEASURED_STATE_MASK = -16777216;
   public static final int MEASURED_STATE_TOO_SMALL = 16777216;
   public static final int OVER_SCROLL_ALWAYS = 0;
   public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
   public static final int OVER_SCROLL_NEVER = 2;
   public static final int SCROLL_AXIS_HORIZONTAL = 1;
   public static final int SCROLL_AXIS_NONE = 0;
   public static final int SCROLL_AXIS_VERTICAL = 2;
   public static final int SCROLL_INDICATOR_BOTTOM = 2;
   public static final int SCROLL_INDICATOR_END = 32;
   public static final int SCROLL_INDICATOR_LEFT = 4;
   public static final int SCROLL_INDICATOR_RIGHT = 8;
   public static final int SCROLL_INDICATOR_START = 16;
   public static final int SCROLL_INDICATOR_TOP = 1;
   private static final String TAG = "ViewCompat";

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 23) {
         IMPL = new ViewCompat.MarshmallowViewCompatImpl();
      } else if(var0 >= 21) {
         IMPL = new ViewCompat.LollipopViewCompatImpl();
      } else if(var0 >= 19) {
         IMPL = new ViewCompat.KitKatViewCompatImpl();
      } else if(var0 >= 17) {
         IMPL = new ViewCompat.JbMr1ViewCompatImpl();
      } else if(var0 >= 16) {
         IMPL = new ViewCompat.JBViewCompatImpl();
      } else if(var0 >= 15) {
         IMPL = new ViewCompat.ICSMr1ViewCompatImpl();
      } else if(var0 >= 14) {
         IMPL = new ViewCompat.ICSViewCompatImpl();
      } else if(var0 >= 11) {
         IMPL = new ViewCompat.HCViewCompatImpl();
      } else if(var0 >= 9) {
         IMPL = new ViewCompat.GBViewCompatImpl();
      } else if(var0 >= 7) {
         IMPL = new ViewCompat.EclairMr1ViewCompatImpl();
      } else {
         IMPL = new ViewCompat.BaseViewCompatImpl();
      }
   }

   public static ViewPropertyAnimatorCompat animate(View var0) {
      return IMPL.animate(var0);
   }

   public static boolean canScrollHorizontally(View var0, int var1) {
      return IMPL.canScrollHorizontally(var0, var1);
   }

   public static boolean canScrollVertically(View var0, int var1) {
      return IMPL.canScrollVertically(var0, var1);
   }

   public static int combineMeasuredStates(int var0, int var1) {
      return IMPL.combineMeasuredStates(var0, var1);
   }

   public static WindowInsetsCompat dispatchApplyWindowInsets(View var0, WindowInsetsCompat var1) {
      return IMPL.dispatchApplyWindowInsets(var0, var1);
   }

   public static void dispatchFinishTemporaryDetach(View var0) {
      IMPL.dispatchFinishTemporaryDetach(var0);
   }

   public static boolean dispatchNestedFling(View var0, float var1, float var2, boolean var3) {
      return IMPL.dispatchNestedFling(var0, var1, var2, var3);
   }

   public static boolean dispatchNestedPreFling(View var0, float var1, float var2) {
      return IMPL.dispatchNestedPreFling(var0, var1, var2);
   }

   public static boolean dispatchNestedPreScroll(View var0, int var1, int var2, int[] var3, int[] var4) {
      return IMPL.dispatchNestedPreScroll(var0, var1, var2, var3, var4);
   }

   public static boolean dispatchNestedScroll(View var0, int var1, int var2, int var3, int var4, int[] var5) {
      return IMPL.dispatchNestedScroll(var0, var1, var2, var3, var4, var5);
   }

   public static void dispatchStartTemporaryDetach(View var0) {
      IMPL.dispatchStartTemporaryDetach(var0);
   }

   public static int getAccessibilityLiveRegion(View var0) {
      return IMPL.getAccessibilityLiveRegion(var0);
   }

   public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View var0) {
      return IMPL.getAccessibilityNodeProvider(var0);
   }

   public static float getAlpha(View var0) {
      return IMPL.getAlpha(var0);
   }

   public static ColorStateList getBackgroundTintList(View var0) {
      return IMPL.getBackgroundTintList(var0);
   }

   public static Mode getBackgroundTintMode(View var0) {
      return IMPL.getBackgroundTintMode(var0);
   }

   public static Rect getClipBounds(View var0) {
      return IMPL.getClipBounds(var0);
   }

   public static float getElevation(View var0) {
      return IMPL.getElevation(var0);
   }

   public static boolean getFitsSystemWindows(View var0) {
      return IMPL.getFitsSystemWindows(var0);
   }

   public static int getImportantForAccessibility(View var0) {
      return IMPL.getImportantForAccessibility(var0);
   }

   public static int getLabelFor(View var0) {
      return IMPL.getLabelFor(var0);
   }

   public static int getLayerType(View var0) {
      return IMPL.getLayerType(var0);
   }

   public static int getLayoutDirection(View var0) {
      return IMPL.getLayoutDirection(var0);
   }

   public static int getMeasuredHeightAndState(View var0) {
      return IMPL.getMeasuredHeightAndState(var0);
   }

   public static int getMeasuredState(View var0) {
      return IMPL.getMeasuredState(var0);
   }

   public static int getMeasuredWidthAndState(View var0) {
      return IMPL.getMeasuredWidthAndState(var0);
   }

   public static int getMinimumHeight(View var0) {
      return IMPL.getMinimumHeight(var0);
   }

   public static int getMinimumWidth(View var0) {
      return IMPL.getMinimumWidth(var0);
   }

   public static int getOverScrollMode(View var0) {
      return IMPL.getOverScrollMode(var0);
   }

   public static int getPaddingEnd(View var0) {
      return IMPL.getPaddingEnd(var0);
   }

   public static int getPaddingStart(View var0) {
      return IMPL.getPaddingStart(var0);
   }

   public static ViewParent getParentForAccessibility(View var0) {
      return IMPL.getParentForAccessibility(var0);
   }

   public static float getPivotX(View var0) {
      return IMPL.getPivotX(var0);
   }

   public static float getPivotY(View var0) {
      return IMPL.getPivotY(var0);
   }

   public static float getRotation(View var0) {
      return IMPL.getRotation(var0);
   }

   public static float getRotationX(View var0) {
      return IMPL.getRotationX(var0);
   }

   public static float getRotationY(View var0) {
      return IMPL.getRotationY(var0);
   }

   public static float getScaleX(View var0) {
      return IMPL.getScaleX(var0);
   }

   public static float getScaleY(View var0) {
      return IMPL.getScaleY(var0);
   }

   public static int getScrollIndicators(@NonNull View var0) {
      return IMPL.getScrollIndicators(var0);
   }

   public static String getTransitionName(View var0) {
      return IMPL.getTransitionName(var0);
   }

   public static float getTranslationX(View var0) {
      return IMPL.getTranslationX(var0);
   }

   public static float getTranslationY(View var0) {
      return IMPL.getTranslationY(var0);
   }

   public static float getTranslationZ(View var0) {
      return IMPL.getTranslationZ(var0);
   }

   public static int getWindowSystemUiVisibility(View var0) {
      return IMPL.getWindowSystemUiVisibility(var0);
   }

   public static float getX(View var0) {
      return IMPL.getX(var0);
   }

   public static float getY(View var0) {
      return IMPL.getY(var0);
   }

   public static float getZ(View var0) {
      return IMPL.getZ(var0);
   }

   public static boolean hasAccessibilityDelegate(View var0) {
      return IMPL.hasAccessibilityDelegate(var0);
   }

   public static boolean hasNestedScrollingParent(View var0) {
      return IMPL.hasNestedScrollingParent(var0);
   }

   public static boolean hasOnClickListeners(View var0) {
      return IMPL.hasOnClickListeners(var0);
   }

   public static boolean hasOverlappingRendering(View var0) {
      return IMPL.hasOverlappingRendering(var0);
   }

   public static boolean hasTransientState(View var0) {
      return IMPL.hasTransientState(var0);
   }

   public static boolean isAttachedToWindow(View var0) {
      return IMPL.isAttachedToWindow(var0);
   }

   public static boolean isLaidOut(View var0) {
      return IMPL.isLaidOut(var0);
   }

   public static boolean isNestedScrollingEnabled(View var0) {
      return IMPL.isNestedScrollingEnabled(var0);
   }

   public static boolean isOpaque(View var0) {
      return IMPL.isOpaque(var0);
   }

   public static boolean isPaddingRelative(View var0) {
      return IMPL.isPaddingRelative(var0);
   }

   public static void jumpDrawablesToCurrentState(View var0) {
      IMPL.jumpDrawablesToCurrentState(var0);
   }

   public static void offsetLeftAndRight(View var0, int var1) {
      IMPL.offsetLeftAndRight(var0, var1);
   }

   public static void offsetTopAndBottom(View var0, int var1) {
      IMPL.offsetTopAndBottom(var0, var1);
   }

   public static WindowInsetsCompat onApplyWindowInsets(View var0, WindowInsetsCompat var1) {
      return IMPL.onApplyWindowInsets(var0, var1);
   }

   public static void onInitializeAccessibilityEvent(View var0, AccessibilityEvent var1) {
      IMPL.onInitializeAccessibilityEvent(var0, var1);
   }

   public static void onInitializeAccessibilityNodeInfo(View var0, AccessibilityNodeInfoCompat var1) {
      IMPL.onInitializeAccessibilityNodeInfo(var0, var1);
   }

   public static void onPopulateAccessibilityEvent(View var0, AccessibilityEvent var1) {
      IMPL.onPopulateAccessibilityEvent(var0, var1);
   }

   public static boolean performAccessibilityAction(View var0, int var1, Bundle var2) {
      return IMPL.performAccessibilityAction(var0, var1, var2);
   }

   public static void postInvalidateOnAnimation(View var0) {
      IMPL.postInvalidateOnAnimation(var0);
   }

   public static void postInvalidateOnAnimation(View var0, int var1, int var2, int var3, int var4) {
      IMPL.postInvalidateOnAnimation(var0, var1, var2, var3, var4);
   }

   public static void postOnAnimation(View var0, Runnable var1) {
      IMPL.postOnAnimation(var0, var1);
   }

   public static void postOnAnimationDelayed(View var0, Runnable var1, long var2) {
      IMPL.postOnAnimationDelayed(var0, var1, var2);
   }

   public static void requestApplyInsets(View var0) {
      IMPL.requestApplyInsets(var0);
   }

   public static int resolveSizeAndState(int var0, int var1, int var2) {
      return IMPL.resolveSizeAndState(var0, var1, var2);
   }

   public static void setAccessibilityDelegate(View var0, AccessibilityDelegateCompat var1) {
      IMPL.setAccessibilityDelegate(var0, var1);
   }

   public static void setAccessibilityLiveRegion(View var0, int var1) {
      IMPL.setAccessibilityLiveRegion(var0, var1);
   }

   public static void setActivated(View var0, boolean var1) {
      IMPL.setActivated(var0, var1);
   }

   public static void setAlpha(View var0, @FloatRange(
   from = 0.0D,
   to = 1.0D
) float var1) {
      IMPL.setAlpha(var0, var1);
   }

   public static void setBackgroundTintList(View var0, ColorStateList var1) {
      IMPL.setBackgroundTintList(var0, var1);
   }

   public static void setBackgroundTintMode(View var0, Mode var1) {
      IMPL.setBackgroundTintMode(var0, var1);
   }

   public static void setChildrenDrawingOrderEnabled(ViewGroup var0, boolean var1) {
      IMPL.setChildrenDrawingOrderEnabled(var0, var1);
   }

   public static void setClipBounds(View var0, Rect var1) {
      IMPL.setClipBounds(var0, var1);
   }

   public static void setElevation(View var0, float var1) {
      IMPL.setElevation(var0, var1);
   }

   public static void setFitsSystemWindows(View var0, boolean var1) {
      IMPL.setFitsSystemWindows(var0, var1);
   }

   public static void setHasTransientState(View var0, boolean var1) {
      IMPL.setHasTransientState(var0, var1);
   }

   public static void setImportantForAccessibility(View var0, int var1) {
      IMPL.setImportantForAccessibility(var0, var1);
   }

   public static void setLabelFor(View var0, @IdRes int var1) {
      IMPL.setLabelFor(var0, var1);
   }

   public static void setLayerPaint(View var0, Paint var1) {
      IMPL.setLayerPaint(var0, var1);
   }

   public static void setLayerType(View var0, int var1, Paint var2) {
      IMPL.setLayerType(var0, var1, var2);
   }

   public static void setLayoutDirection(View var0, int var1) {
      IMPL.setLayoutDirection(var0, var1);
   }

   public static void setNestedScrollingEnabled(View var0, boolean var1) {
      IMPL.setNestedScrollingEnabled(var0, var1);
   }

   public static void setOnApplyWindowInsetsListener(View var0, OnApplyWindowInsetsListener var1) {
      IMPL.setOnApplyWindowInsetsListener(var0, var1);
   }

   public static void setOverScrollMode(View var0, int var1) {
      IMPL.setOverScrollMode(var0, var1);
   }

   public static void setPaddingRelative(View var0, int var1, int var2, int var3, int var4) {
      IMPL.setPaddingRelative(var0, var1, var2, var3, var4);
   }

   public static void setPivotX(View var0, float var1) {
      IMPL.setPivotX(var0, var1);
   }

   public static void setPivotY(View var0, float var1) {
      IMPL.setPivotY(var0, var1);
   }

   public static void setRotation(View var0, float var1) {
      IMPL.setRotation(var0, var1);
   }

   public static void setRotationX(View var0, float var1) {
      IMPL.setRotationX(var0, var1);
   }

   public static void setRotationY(View var0, float var1) {
      IMPL.setRotationY(var0, var1);
   }

   public static void setSaveFromParentEnabled(View var0, boolean var1) {
      IMPL.setSaveFromParentEnabled(var0, var1);
   }

   public static void setScaleX(View var0, float var1) {
      IMPL.setScaleX(var0, var1);
   }

   public static void setScaleY(View var0, float var1) {
      IMPL.setScaleY(var0, var1);
   }

   public static void setScrollIndicators(@NonNull View var0, int var1) {
      IMPL.setScrollIndicators(var0, var1);
   }

   public static void setScrollIndicators(@NonNull View var0, int var1, int var2) {
      IMPL.setScrollIndicators(var0, var1, var2);
   }

   public static void setTransitionName(View var0, String var1) {
      IMPL.setTransitionName(var0, var1);
   }

   public static void setTranslationX(View var0, float var1) {
      IMPL.setTranslationX(var0, var1);
   }

   public static void setTranslationY(View var0, float var1) {
      IMPL.setTranslationY(var0, var1);
   }

   public static void setTranslationZ(View var0, float var1) {
      IMPL.setTranslationZ(var0, var1);
   }

   public static void setX(View var0, float var1) {
      IMPL.setX(var0, var1);
   }

   public static void setY(View var0, float var1) {
      IMPL.setY(var0, var1);
   }

   public static boolean startNestedScroll(View var0, int var1) {
      return IMPL.startNestedScroll(var0, var1);
   }

   public static void stopNestedScroll(View var0) {
      IMPL.stopNestedScroll(var0);
   }

   static class BaseViewCompatImpl implements ViewCompat.ViewCompatImpl {
      private Method mDispatchFinishTemporaryDetach;
      private Method mDispatchStartTemporaryDetach;
      private boolean mTempDetachBound;
      WeakHashMap<View, ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;

      private void bindTempDetach() {
         try {
            this.mDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
            this.mDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
         } catch (NoSuchMethodException var2) {
            Log.e("ViewCompat", "Couldn\'t find method", var2);
         }

         this.mTempDetachBound = true;
      }

      private boolean canScrollingViewScrollHorizontally(ScrollingView var1, int var2) {
         boolean var3 = true;
         int var4 = var1.computeHorizontalScrollOffset();
         int var5 = var1.computeHorizontalScrollRange() - var1.computeHorizontalScrollExtent();
         if(var5 == 0) {
            var3 = false;
         } else if(var2 < 0) {
            if(var4 <= 0) {
               return false;
            }
         } else if(var4 >= var5 - 1) {
            return false;
         }

         return var3;
      }

      private boolean canScrollingViewScrollVertically(ScrollingView var1, int var2) {
         boolean var3 = true;
         int var4 = var1.computeVerticalScrollOffset();
         int var5 = var1.computeVerticalScrollRange() - var1.computeVerticalScrollExtent();
         if(var5 == 0) {
            var3 = false;
         } else if(var2 < 0) {
            if(var4 <= 0) {
               return false;
            }
         } else if(var4 >= var5 - 1) {
            return false;
         }

         return var3;
      }

      public ViewPropertyAnimatorCompat animate(View var1) {
         return new ViewPropertyAnimatorCompat(var1);
      }

      public boolean canScrollHorizontally(View var1, int var2) {
         return var1 instanceof ScrollingView && this.canScrollingViewScrollHorizontally((ScrollingView)var1, var2);
      }

      public boolean canScrollVertically(View var1, int var2) {
         return var1 instanceof ScrollingView && this.canScrollingViewScrollVertically((ScrollingView)var1, var2);
      }

      public int combineMeasuredStates(int var1, int var2) {
         return var1 | var2;
      }

      public WindowInsetsCompat dispatchApplyWindowInsets(View var1, WindowInsetsCompat var2) {
         return var2;
      }

      public void dispatchFinishTemporaryDetach(View var1) {
         if(!this.mTempDetachBound) {
            this.bindTempDetach();
         }

         if(this.mDispatchFinishTemporaryDetach != null) {
            try {
               this.mDispatchFinishTemporaryDetach.invoke(var1, new Object[0]);
            } catch (Exception var3) {
               Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", var3);
            }
         } else {
            var1.onFinishTemporaryDetach();
         }
      }

      public boolean dispatchNestedFling(View var1, float var2, float var3, boolean var4) {
         return var1 instanceof NestedScrollingChild?((NestedScrollingChild)var1).dispatchNestedFling(var2, var3, var4):false;
      }

      public boolean dispatchNestedPreFling(View var1, float var2, float var3) {
         return var1 instanceof NestedScrollingChild?((NestedScrollingChild)var1).dispatchNestedPreFling(var2, var3):false;
      }

      public boolean dispatchNestedPreScroll(View var1, int var2, int var3, int[] var4, int[] var5) {
         return var1 instanceof NestedScrollingChild?((NestedScrollingChild)var1).dispatchNestedPreScroll(var2, var3, var4, var5):false;
      }

      public boolean dispatchNestedScroll(View var1, int var2, int var3, int var4, int var5, int[] var6) {
         return var1 instanceof NestedScrollingChild?((NestedScrollingChild)var1).dispatchNestedScroll(var2, var3, var4, var5, var6):false;
      }

      public void dispatchStartTemporaryDetach(View var1) {
         if(!this.mTempDetachBound) {
            this.bindTempDetach();
         }

         if(this.mDispatchStartTemporaryDetach != null) {
            try {
               this.mDispatchStartTemporaryDetach.invoke(var1, new Object[0]);
            } catch (Exception var3) {
               Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", var3);
            }
         } else {
            var1.onStartTemporaryDetach();
         }
      }

      public int getAccessibilityLiveRegion(View var1) {
         return 0;
      }

      public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View var1) {
         return null;
      }

      public float getAlpha(View var1) {
         return 1.0F;
      }

      public ColorStateList getBackgroundTintList(View var1) {
         return ViewCompatBase.getBackgroundTintList(var1);
      }

      public Mode getBackgroundTintMode(View var1) {
         return ViewCompatBase.getBackgroundTintMode(var1);
      }

      public Rect getClipBounds(View var1) {
         return null;
      }

      public float getElevation(View var1) {
         return 0.0F;
      }

      public boolean getFitsSystemWindows(View var1) {
         return false;
      }

      long getFrameTime() {
         return 10L;
      }

      public int getImportantForAccessibility(View var1) {
         return 0;
      }

      public int getLabelFor(View var1) {
         return 0;
      }

      public int getLayerType(View var1) {
         return 0;
      }

      public int getLayoutDirection(View var1) {
         return 0;
      }

      public int getMeasuredHeightAndState(View var1) {
         return var1.getMeasuredHeight();
      }

      public int getMeasuredState(View var1) {
         return 0;
      }

      public int getMeasuredWidthAndState(View var1) {
         return var1.getMeasuredWidth();
      }

      public int getMinimumHeight(View var1) {
         return ViewCompatBase.getMinimumHeight(var1);
      }

      public int getMinimumWidth(View var1) {
         return ViewCompatBase.getMinimumWidth(var1);
      }

      public int getOverScrollMode(View var1) {
         return 2;
      }

      public int getPaddingEnd(View var1) {
         return var1.getPaddingRight();
      }

      public int getPaddingStart(View var1) {
         return var1.getPaddingLeft();
      }

      public ViewParent getParentForAccessibility(View var1) {
         return var1.getParent();
      }

      public float getPivotX(View var1) {
         return 0.0F;
      }

      public float getPivotY(View var1) {
         return 0.0F;
      }

      public float getRotation(View var1) {
         return 0.0F;
      }

      public float getRotationX(View var1) {
         return 0.0F;
      }

      public float getRotationY(View var1) {
         return 0.0F;
      }

      public float getScaleX(View var1) {
         return 0.0F;
      }

      public float getScaleY(View var1) {
         return 0.0F;
      }

      public int getScrollIndicators(View var1) {
         return 0;
      }

      public String getTransitionName(View var1) {
         return null;
      }

      public float getTranslationX(View var1) {
         return 0.0F;
      }

      public float getTranslationY(View var1) {
         return 0.0F;
      }

      public float getTranslationZ(View var1) {
         return 0.0F;
      }

      public int getWindowSystemUiVisibility(View var1) {
         return 0;
      }

      public float getX(View var1) {
         return 0.0F;
      }

      public float getY(View var1) {
         return 0.0F;
      }

      public float getZ(View var1) {
         return this.getTranslationZ(var1) + this.getElevation(var1);
      }

      public boolean hasAccessibilityDelegate(View var1) {
         return false;
      }

      public boolean hasNestedScrollingParent(View var1) {
         return var1 instanceof NestedScrollingChild?((NestedScrollingChild)var1).hasNestedScrollingParent():false;
      }

      public boolean hasOnClickListeners(View var1) {
         return false;
      }

      public boolean hasOverlappingRendering(View var1) {
         return true;
      }

      public boolean hasTransientState(View var1) {
         return false;
      }

      public boolean isAttachedToWindow(View var1) {
         return ViewCompatBase.isAttachedToWindow(var1);
      }

      public boolean isImportantForAccessibility(View var1) {
         return true;
      }

      public boolean isLaidOut(View var1) {
         return ViewCompatBase.isLaidOut(var1);
      }

      public boolean isNestedScrollingEnabled(View var1) {
         return var1 instanceof NestedScrollingChild?((NestedScrollingChild)var1).isNestedScrollingEnabled():false;
      }

      public boolean isOpaque(View var1) {
         Drawable var2 = var1.getBackground();
         boolean var3 = false;
         if(var2 != null) {
            int var4 = var2.getOpacity();
            var3 = false;
            if(var4 == -1) {
               var3 = true;
            }
         }

         return var3;
      }

      public boolean isPaddingRelative(View var1) {
         return false;
      }

      public void jumpDrawablesToCurrentState(View var1) {
      }

      public void offsetLeftAndRight(View var1, int var2) {
         ViewCompatBase.offsetLeftAndRight(var1, var2);
      }

      public void offsetTopAndBottom(View var1, int var2) {
         ViewCompatBase.offsetTopAndBottom(var1, var2);
      }

      public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
         return var2;
      }

      public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
      }

      public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
      }

      public void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      }

      public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
         return false;
      }

      public void postInvalidateOnAnimation(View var1) {
         var1.invalidate();
      }

      public void postInvalidateOnAnimation(View var1, int var2, int var3, int var4, int var5) {
         var1.invalidate(var2, var3, var4, var5);
      }

      public void postOnAnimation(View var1, Runnable var2) {
         var1.postDelayed(var2, this.getFrameTime());
      }

      public void postOnAnimationDelayed(View var1, Runnable var2, long var3) {
         var1.postDelayed(var2, var3 + this.getFrameTime());
      }

      public void requestApplyInsets(View var1) {
      }

      public int resolveSizeAndState(int var1, int var2, int var3) {
         return View.resolveSize(var1, var2);
      }

      public void setAccessibilityDelegate(View var1, AccessibilityDelegateCompat var2) {
      }

      public void setAccessibilityLiveRegion(View var1, int var2) {
      }

      public void setActivated(View var1, boolean var2) {
      }

      public void setAlpha(View var1, float var2) {
      }

      public void setBackgroundTintList(View var1, ColorStateList var2) {
         ViewCompatBase.setBackgroundTintList(var1, var2);
      }

      public void setBackgroundTintMode(View var1, Mode var2) {
         ViewCompatBase.setBackgroundTintMode(var1, var2);
      }

      public void setChildrenDrawingOrderEnabled(ViewGroup var1, boolean var2) {
      }

      public void setClipBounds(View var1, Rect var2) {
      }

      public void setElevation(View var1, float var2) {
      }

      public void setFitsSystemWindows(View var1, boolean var2) {
      }

      public void setHasTransientState(View var1, boolean var2) {
      }

      public void setImportantForAccessibility(View var1, int var2) {
      }

      public void setLabelFor(View var1, int var2) {
      }

      public void setLayerPaint(View var1, Paint var2) {
      }

      public void setLayerType(View var1, int var2, Paint var3) {
      }

      public void setLayoutDirection(View var1, int var2) {
      }

      public void setNestedScrollingEnabled(View var1, boolean var2) {
         if(var1 instanceof NestedScrollingChild) {
            ((NestedScrollingChild)var1).setNestedScrollingEnabled(var2);
         }

      }

      public void setOnApplyWindowInsetsListener(View var1, OnApplyWindowInsetsListener var2) {
      }

      public void setOverScrollMode(View var1, int var2) {
      }

      public void setPaddingRelative(View var1, int var2, int var3, int var4, int var5) {
         var1.setPadding(var2, var3, var4, var5);
      }

      public void setPivotX(View var1, float var2) {
      }

      public void setPivotY(View var1, float var2) {
      }

      public void setRotation(View var1, float var2) {
      }

      public void setRotationX(View var1, float var2) {
      }

      public void setRotationY(View var1, float var2) {
      }

      public void setSaveFromParentEnabled(View var1, boolean var2) {
      }

      public void setScaleX(View var1, float var2) {
      }

      public void setScaleY(View var1, float var2) {
      }

      public void setScrollIndicators(View var1, int var2) {
      }

      public void setScrollIndicators(View var1, int var2, int var3) {
      }

      public void setTransitionName(View var1, String var2) {
      }

      public void setTranslationX(View var1, float var2) {
      }

      public void setTranslationY(View var1, float var2) {
      }

      public void setTranslationZ(View var1, float var2) {
      }

      public void setX(View var1, float var2) {
      }

      public void setY(View var1, float var2) {
      }

      public boolean startNestedScroll(View var1, int var2) {
         return var1 instanceof NestedScrollingChild?((NestedScrollingChild)var1).startNestedScroll(var2):false;
      }

      public void stopNestedScroll(View var1) {
         if(var1 instanceof NestedScrollingChild) {
            ((NestedScrollingChild)var1).stopNestedScroll();
         }

      }
   }

   static class EclairMr1ViewCompatImpl extends ViewCompat.BaseViewCompatImpl {
      public boolean isOpaque(View var1) {
         return ViewCompatEclairMr1.isOpaque(var1);
      }

      public void setChildrenDrawingOrderEnabled(ViewGroup var1, boolean var2) {
         ViewCompatEclairMr1.setChildrenDrawingOrderEnabled(var1, var2);
      }
   }

   static class GBViewCompatImpl extends ViewCompat.EclairMr1ViewCompatImpl {
      public int getOverScrollMode(View var1) {
         return ViewCompatGingerbread.getOverScrollMode(var1);
      }

      public void setOverScrollMode(View var1, int var2) {
         ViewCompatGingerbread.setOverScrollMode(var1, var2);
      }
   }

   static class HCViewCompatImpl extends ViewCompat.GBViewCompatImpl {
      public int combineMeasuredStates(int var1, int var2) {
         return ViewCompatHC.combineMeasuredStates(var1, var2);
      }

      public float getAlpha(View var1) {
         return ViewCompatHC.getAlpha(var1);
      }

      long getFrameTime() {
         return ViewCompatHC.getFrameTime();
      }

      public int getLayerType(View var1) {
         return ViewCompatHC.getLayerType(var1);
      }

      public int getMeasuredHeightAndState(View var1) {
         return ViewCompatHC.getMeasuredHeightAndState(var1);
      }

      public int getMeasuredState(View var1) {
         return ViewCompatHC.getMeasuredState(var1);
      }

      public int getMeasuredWidthAndState(View var1) {
         return ViewCompatHC.getMeasuredWidthAndState(var1);
      }

      public float getPivotX(View var1) {
         return ViewCompatHC.getPivotX(var1);
      }

      public float getPivotY(View var1) {
         return ViewCompatHC.getPivotY(var1);
      }

      public float getRotation(View var1) {
         return ViewCompatHC.getRotation(var1);
      }

      public float getRotationX(View var1) {
         return ViewCompatHC.getRotationX(var1);
      }

      public float getRotationY(View var1) {
         return ViewCompatHC.getRotationY(var1);
      }

      public float getScaleX(View var1) {
         return ViewCompatHC.getScaleX(var1);
      }

      public float getScaleY(View var1) {
         return ViewCompatHC.getScaleY(var1);
      }

      public float getTranslationX(View var1) {
         return ViewCompatHC.getTranslationX(var1);
      }

      public float getTranslationY(View var1) {
         return ViewCompatHC.getTranslationY(var1);
      }

      public float getX(View var1) {
         return ViewCompatHC.getX(var1);
      }

      public float getY(View var1) {
         return ViewCompatHC.getY(var1);
      }

      public void jumpDrawablesToCurrentState(View var1) {
         ViewCompatHC.jumpDrawablesToCurrentState(var1);
      }

      public void offsetLeftAndRight(View var1, int var2) {
         ViewCompatHC.offsetLeftAndRight(var1, var2);
      }

      public void offsetTopAndBottom(View var1, int var2) {
         ViewCompatHC.offsetTopAndBottom(var1, var2);
      }

      public int resolveSizeAndState(int var1, int var2, int var3) {
         return ViewCompatHC.resolveSizeAndState(var1, var2, var3);
      }

      public void setActivated(View var1, boolean var2) {
         ViewCompatHC.setActivated(var1, var2);
      }

      public void setAlpha(View var1, float var2) {
         ViewCompatHC.setAlpha(var1, var2);
      }

      public void setLayerPaint(View var1, Paint var2) {
         this.setLayerType(var1, this.getLayerType(var1), var2);
         var1.invalidate();
      }

      public void setLayerType(View var1, int var2, Paint var3) {
         ViewCompatHC.setLayerType(var1, var2, var3);
      }

      public void setPivotX(View var1, float var2) {
         ViewCompatHC.setPivotX(var1, var2);
      }

      public void setPivotY(View var1, float var2) {
         ViewCompatHC.setPivotY(var1, var2);
      }

      public void setRotation(View var1, float var2) {
         ViewCompatHC.setRotation(var1, var2);
      }

      public void setRotationX(View var1, float var2) {
         ViewCompatHC.setRotationX(var1, var2);
      }

      public void setRotationY(View var1, float var2) {
         ViewCompatHC.setRotationY(var1, var2);
      }

      public void setSaveFromParentEnabled(View var1, boolean var2) {
         ViewCompatHC.setSaveFromParentEnabled(var1, var2);
      }

      public void setScaleX(View var1, float var2) {
         ViewCompatHC.setScaleX(var1, var2);
      }

      public void setScaleY(View var1, float var2) {
         ViewCompatHC.setScaleY(var1, var2);
      }

      public void setTranslationX(View var1, float var2) {
         ViewCompatHC.setTranslationX(var1, var2);
      }

      public void setTranslationY(View var1, float var2) {
         ViewCompatHC.setTranslationY(var1, var2);
      }

      public void setX(View var1, float var2) {
         ViewCompatHC.setX(var1, var2);
      }

      public void setY(View var1, float var2) {
         ViewCompatHC.setY(var1, var2);
      }
   }

   static class ICSMr1ViewCompatImpl extends ViewCompat.ICSViewCompatImpl {
      public boolean hasOnClickListeners(View var1) {
         return ViewCompatICSMr1.hasOnClickListeners(var1);
      }
   }

   static class ICSViewCompatImpl extends ViewCompat.HCViewCompatImpl {
      static boolean accessibilityDelegateCheckFailed = false;
      static Field mAccessibilityDelegateField;

      public ViewPropertyAnimatorCompat animate(View var1) {
         if(this.mViewPropertyAnimatorCompatMap == null) {
            this.mViewPropertyAnimatorCompatMap = new WeakHashMap();
         }

         ViewPropertyAnimatorCompat var2 = (ViewPropertyAnimatorCompat)this.mViewPropertyAnimatorCompatMap.get(var1);
         if(var2 == null) {
            var2 = new ViewPropertyAnimatorCompat(var1);
            this.mViewPropertyAnimatorCompatMap.put(var1, var2);
         }

         return var2;
      }

      public boolean canScrollHorizontally(View var1, int var2) {
         return ViewCompatICS.canScrollHorizontally(var1, var2);
      }

      public boolean canScrollVertically(View var1, int var2) {
         return ViewCompatICS.canScrollVertically(var1, var2);
      }

      public boolean hasAccessibilityDelegate(View var1) {
         boolean var2 = true;
         if(accessibilityDelegateCheckFailed) {
            return false;
         } else {
            if(mAccessibilityDelegateField == null) {
               try {
                  mAccessibilityDelegateField = View.class.getDeclaredField("mAccessibilityDelegate");
                  mAccessibilityDelegateField.setAccessible(true);
               } catch (Throwable var7) {
                  accessibilityDelegateCheckFailed = var2;
                  return false;
               }
            }

            Object var4;
            try {
               var4 = mAccessibilityDelegateField.get(var1);
            } catch (Throwable var6) {
               accessibilityDelegateCheckFailed = var2;
               return false;
            }

            if(var4 == null) {
               var2 = false;
            }

            return var2;
         }
      }

      public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
         ViewCompatICS.onInitializeAccessibilityEvent(var1, var2);
      }

      public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
         ViewCompatICS.onInitializeAccessibilityNodeInfo(var1, var2.getInfo());
      }

      public void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
         ViewCompatICS.onPopulateAccessibilityEvent(var1, var2);
      }

      public void setAccessibilityDelegate(View var1, @Nullable AccessibilityDelegateCompat var2) {
         Object var3;
         if(var2 == null) {
            var3 = null;
         } else {
            var3 = var2.getBridge();
         }

         ViewCompatICS.setAccessibilityDelegate(var1, var3);
      }

      public void setFitsSystemWindows(View var1, boolean var2) {
         ViewCompatICS.setFitsSystemWindows(var1, var2);
      }
   }

   static class JBViewCompatImpl extends ViewCompat.ICSMr1ViewCompatImpl {
      public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View var1) {
         Object var2 = ViewCompatJB.getAccessibilityNodeProvider(var1);
         return var2 != null?new AccessibilityNodeProviderCompat(var2):null;
      }

      public boolean getFitsSystemWindows(View var1) {
         return ViewCompatJB.getFitsSystemWindows(var1);
      }

      public int getImportantForAccessibility(View var1) {
         return ViewCompatJB.getImportantForAccessibility(var1);
      }

      public int getMinimumHeight(View var1) {
         return ViewCompatJB.getMinimumHeight(var1);
      }

      public int getMinimumWidth(View var1) {
         return ViewCompatJB.getMinimumWidth(var1);
      }

      public ViewParent getParentForAccessibility(View var1) {
         return ViewCompatJB.getParentForAccessibility(var1);
      }

      public boolean hasOverlappingRendering(View var1) {
         return ViewCompatJB.hasOverlappingRendering(var1);
      }

      public boolean hasTransientState(View var1) {
         return ViewCompatJB.hasTransientState(var1);
      }

      public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
         return ViewCompatJB.performAccessibilityAction(var1, var2, var3);
      }

      public void postInvalidateOnAnimation(View var1) {
         ViewCompatJB.postInvalidateOnAnimation(var1);
      }

      public void postInvalidateOnAnimation(View var1, int var2, int var3, int var4, int var5) {
         ViewCompatJB.postInvalidateOnAnimation(var1, var2, var3, var4, var5);
      }

      public void postOnAnimation(View var1, Runnable var2) {
         ViewCompatJB.postOnAnimation(var1, var2);
      }

      public void postOnAnimationDelayed(View var1, Runnable var2, long var3) {
         ViewCompatJB.postOnAnimationDelayed(var1, var2, var3);
      }

      public void requestApplyInsets(View var1) {
         ViewCompatJB.requestApplyInsets(var1);
      }

      public void setHasTransientState(View var1, boolean var2) {
         ViewCompatJB.setHasTransientState(var1, var2);
      }

      public void setImportantForAccessibility(View var1, int var2) {
         if(var2 == 4) {
            var2 = 2;
         }

         ViewCompatJB.setImportantForAccessibility(var1, var2);
      }
   }

   static class JbMr1ViewCompatImpl extends ViewCompat.JBViewCompatImpl {
      public int getLabelFor(View var1) {
         return ViewCompatJellybeanMr1.getLabelFor(var1);
      }

      public int getLayoutDirection(View var1) {
         return ViewCompatJellybeanMr1.getLayoutDirection(var1);
      }

      public int getPaddingEnd(View var1) {
         return ViewCompatJellybeanMr1.getPaddingEnd(var1);
      }

      public int getPaddingStart(View var1) {
         return ViewCompatJellybeanMr1.getPaddingStart(var1);
      }

      public int getWindowSystemUiVisibility(View var1) {
         return ViewCompatJellybeanMr1.getWindowSystemUiVisibility(var1);
      }

      public boolean isPaddingRelative(View var1) {
         return ViewCompatJellybeanMr1.isPaddingRelative(var1);
      }

      public void setLabelFor(View var1, int var2) {
         ViewCompatJellybeanMr1.setLabelFor(var1, var2);
      }

      public void setLayerPaint(View var1, Paint var2) {
         ViewCompatJellybeanMr1.setLayerPaint(var1, var2);
      }

      public void setLayoutDirection(View var1, int var2) {
         ViewCompatJellybeanMr1.setLayoutDirection(var1, var2);
      }

      public void setPaddingRelative(View var1, int var2, int var3, int var4, int var5) {
         ViewCompatJellybeanMr1.setPaddingRelative(var1, var2, var3, var4, var5);
      }
   }

   static class JbMr2ViewCompatImpl extends ViewCompat.JbMr1ViewCompatImpl {
      public Rect getClipBounds(View var1) {
         return ViewCompatJellybeanMr2.getClipBounds(var1);
      }

      public void setClipBounds(View var1, Rect var2) {
         ViewCompatJellybeanMr2.setClipBounds(var1, var2);
      }
   }

   static class KitKatViewCompatImpl extends ViewCompat.JbMr2ViewCompatImpl {
      public int getAccessibilityLiveRegion(View var1) {
         return ViewCompatKitKat.getAccessibilityLiveRegion(var1);
      }

      public boolean isAttachedToWindow(View var1) {
         return ViewCompatKitKat.isAttachedToWindow(var1);
      }

      public boolean isLaidOut(View var1) {
         return ViewCompatKitKat.isLaidOut(var1);
      }

      public void setAccessibilityLiveRegion(View var1, int var2) {
         ViewCompatKitKat.setAccessibilityLiveRegion(var1, var2);
      }

      public void setImportantForAccessibility(View var1, int var2) {
         ViewCompatJB.setImportantForAccessibility(var1, var2);
      }
   }

   static class LollipopViewCompatImpl extends ViewCompat.KitKatViewCompatImpl {
      public WindowInsetsCompat dispatchApplyWindowInsets(View var1, WindowInsetsCompat var2) {
         return ViewCompatLollipop.dispatchApplyWindowInsets(var1, var2);
      }

      public boolean dispatchNestedFling(View var1, float var2, float var3, boolean var4) {
         return ViewCompatLollipop.dispatchNestedFling(var1, var2, var3, var4);
      }

      public boolean dispatchNestedPreFling(View var1, float var2, float var3) {
         return ViewCompatLollipop.dispatchNestedPreFling(var1, var2, var3);
      }

      public boolean dispatchNestedPreScroll(View var1, int var2, int var3, int[] var4, int[] var5) {
         return ViewCompatLollipop.dispatchNestedPreScroll(var1, var2, var3, var4, var5);
      }

      public boolean dispatchNestedScroll(View var1, int var2, int var3, int var4, int var5, int[] var6) {
         return ViewCompatLollipop.dispatchNestedScroll(var1, var2, var3, var4, var5, var6);
      }

      public ColorStateList getBackgroundTintList(View var1) {
         return ViewCompatLollipop.getBackgroundTintList(var1);
      }

      public Mode getBackgroundTintMode(View var1) {
         return ViewCompatLollipop.getBackgroundTintMode(var1);
      }

      public float getElevation(View var1) {
         return ViewCompatLollipop.getElevation(var1);
      }

      public String getTransitionName(View var1) {
         return ViewCompatLollipop.getTransitionName(var1);
      }

      public float getTranslationZ(View var1) {
         return ViewCompatLollipop.getTranslationZ(var1);
      }

      public float getZ(View var1) {
         return ViewCompatLollipop.getZ(var1);
      }

      public boolean hasNestedScrollingParent(View var1) {
         return ViewCompatLollipop.hasNestedScrollingParent(var1);
      }

      public boolean isImportantForAccessibility(View var1) {
         return ViewCompatLollipop.isImportantForAccessibility(var1);
      }

      public boolean isNestedScrollingEnabled(View var1) {
         return ViewCompatLollipop.isNestedScrollingEnabled(var1);
      }

      public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
         return ViewCompatLollipop.onApplyWindowInsets(var1, var2);
      }

      public void requestApplyInsets(View var1) {
         ViewCompatLollipop.requestApplyInsets(var1);
      }

      public void setBackgroundTintList(View var1, ColorStateList var2) {
         ViewCompatLollipop.setBackgroundTintList(var1, var2);
      }

      public void setBackgroundTintMode(View var1, Mode var2) {
         ViewCompatLollipop.setBackgroundTintMode(var1, var2);
      }

      public void setElevation(View var1, float var2) {
         ViewCompatLollipop.setElevation(var1, var2);
      }

      public void setNestedScrollingEnabled(View var1, boolean var2) {
         ViewCompatLollipop.setNestedScrollingEnabled(var1, var2);
      }

      public void setOnApplyWindowInsetsListener(View var1, OnApplyWindowInsetsListener var2) {
         ViewCompatLollipop.setOnApplyWindowInsetsListener(var1, var2);
      }

      public void setTransitionName(View var1, String var2) {
         ViewCompatLollipop.setTransitionName(var1, var2);
      }

      public void setTranslationZ(View var1, float var2) {
         ViewCompatLollipop.setTranslationZ(var1, var2);
      }

      public boolean startNestedScroll(View var1, int var2) {
         return ViewCompatLollipop.startNestedScroll(var1, var2);
      }

      public void stopNestedScroll(View var1) {
         ViewCompatLollipop.stopNestedScroll(var1);
      }
   }

   static class MarshmallowViewCompatImpl extends ViewCompat.LollipopViewCompatImpl {
      public int getScrollIndicators(View var1) {
         return ViewCompatMarshmallow.getScrollIndicators(var1);
      }

      public void offsetLeftAndRight(View var1, int var2) {
         ViewCompatMarshmallow.offsetLeftAndRight(var1, var2);
      }

      public void offsetTopAndBottom(View var1, int var2) {
         ViewCompatMarshmallow.offsetTopAndBottom(var1, var2);
      }

      public void setScrollIndicators(View var1, int var2) {
         ViewCompatMarshmallow.setScrollIndicators(var1, var2);
      }

      public void setScrollIndicators(View var1, int var2, int var3) {
         ViewCompatMarshmallow.setScrollIndicators(var1, var2, var3);
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface ScrollIndicators {
   }

   interface ViewCompatImpl {
      ViewPropertyAnimatorCompat animate(View var1);

      boolean canScrollHorizontally(View var1, int var2);

      boolean canScrollVertically(View var1, int var2);

      int combineMeasuredStates(int var1, int var2);

      WindowInsetsCompat dispatchApplyWindowInsets(View var1, WindowInsetsCompat var2);

      void dispatchFinishTemporaryDetach(View var1);

      boolean dispatchNestedFling(View var1, float var2, float var3, boolean var4);

      boolean dispatchNestedPreFling(View var1, float var2, float var3);

      boolean dispatchNestedPreScroll(View var1, int var2, int var3, int[] var4, int[] var5);

      boolean dispatchNestedScroll(View var1, int var2, int var3, int var4, int var5, int[] var6);

      void dispatchStartTemporaryDetach(View var1);

      int getAccessibilityLiveRegion(View var1);

      AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View var1);

      float getAlpha(View var1);

      ColorStateList getBackgroundTintList(View var1);

      Mode getBackgroundTintMode(View var1);

      Rect getClipBounds(View var1);

      float getElevation(View var1);

      boolean getFitsSystemWindows(View var1);

      int getImportantForAccessibility(View var1);

      int getLabelFor(View var1);

      int getLayerType(View var1);

      int getLayoutDirection(View var1);

      int getMeasuredHeightAndState(View var1);

      int getMeasuredState(View var1);

      int getMeasuredWidthAndState(View var1);

      int getMinimumHeight(View var1);

      int getMinimumWidth(View var1);

      int getOverScrollMode(View var1);

      int getPaddingEnd(View var1);

      int getPaddingStart(View var1);

      ViewParent getParentForAccessibility(View var1);

      float getPivotX(View var1);

      float getPivotY(View var1);

      float getRotation(View var1);

      float getRotationX(View var1);

      float getRotationY(View var1);

      float getScaleX(View var1);

      float getScaleY(View var1);

      int getScrollIndicators(View var1);

      String getTransitionName(View var1);

      float getTranslationX(View var1);

      float getTranslationY(View var1);

      float getTranslationZ(View var1);

      int getWindowSystemUiVisibility(View var1);

      float getX(View var1);

      float getY(View var1);

      float getZ(View var1);

      boolean hasAccessibilityDelegate(View var1);

      boolean hasNestedScrollingParent(View var1);

      boolean hasOnClickListeners(View var1);

      boolean hasOverlappingRendering(View var1);

      boolean hasTransientState(View var1);

      boolean isAttachedToWindow(View var1);

      boolean isImportantForAccessibility(View var1);

      boolean isLaidOut(View var1);

      boolean isNestedScrollingEnabled(View var1);

      boolean isOpaque(View var1);

      boolean isPaddingRelative(View var1);

      void jumpDrawablesToCurrentState(View var1);

      void offsetLeftAndRight(View var1, int var2);

      void offsetTopAndBottom(View var1, int var2);

      WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2);

      void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2);

      void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2);

      void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2);

      boolean performAccessibilityAction(View var1, int var2, Bundle var3);

      void postInvalidateOnAnimation(View var1);

      void postInvalidateOnAnimation(View var1, int var2, int var3, int var4, int var5);

      void postOnAnimation(View var1, Runnable var2);

      void postOnAnimationDelayed(View var1, Runnable var2, long var3);

      void requestApplyInsets(View var1);

      int resolveSizeAndState(int var1, int var2, int var3);

      void setAccessibilityDelegate(View var1, @Nullable AccessibilityDelegateCompat var2);

      void setAccessibilityLiveRegion(View var1, int var2);

      void setActivated(View var1, boolean var2);

      void setAlpha(View var1, float var2);

      void setBackgroundTintList(View var1, ColorStateList var2);

      void setBackgroundTintMode(View var1, Mode var2);

      void setChildrenDrawingOrderEnabled(ViewGroup var1, boolean var2);

      void setClipBounds(View var1, Rect var2);

      void setElevation(View var1, float var2);

      void setFitsSystemWindows(View var1, boolean var2);

      void setHasTransientState(View var1, boolean var2);

      void setImportantForAccessibility(View var1, int var2);

      void setLabelFor(View var1, int var2);

      void setLayerPaint(View var1, Paint var2);

      void setLayerType(View var1, int var2, Paint var3);

      void setLayoutDirection(View var1, int var2);

      void setNestedScrollingEnabled(View var1, boolean var2);

      void setOnApplyWindowInsetsListener(View var1, OnApplyWindowInsetsListener var2);

      void setOverScrollMode(View var1, int var2);

      void setPaddingRelative(View var1, int var2, int var3, int var4, int var5);

      void setPivotX(View var1, float var2);

      void setPivotY(View var1, float var2);

      void setRotation(View var1, float var2);

      void setRotationX(View var1, float var2);

      void setRotationY(View var1, float var2);

      void setSaveFromParentEnabled(View var1, boolean var2);

      void setScaleX(View var1, float var2);

      void setScaleY(View var1, float var2);

      void setScrollIndicators(View var1, int var2);

      void setScrollIndicators(View var1, int var2, int var3);

      void setTransitionName(View var1, String var2);

      void setTranslationX(View var1, float var2);

      void setTranslationY(View var1, float var2);

      void setTranslationZ(View var1, float var2);

      void setX(View var1, float var2);

      void setY(View var1, float var2);

      boolean startNestedScroll(View var1, int var2);

      void stopNestedScroll(View var1);
   }
}
