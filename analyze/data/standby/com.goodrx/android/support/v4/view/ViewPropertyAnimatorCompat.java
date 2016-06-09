package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompatICS;
import android.support.v4.view.ViewPropertyAnimatorCompatJB;
import android.support.v4.view.ViewPropertyAnimatorCompatJellybeanMr2;
import android.support.v4.view.ViewPropertyAnimatorCompatKK;
import android.support.v4.view.ViewPropertyAnimatorCompatLollipop;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class ViewPropertyAnimatorCompat {
   static final ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl IMPL;
   static final int LISTENER_TAG_ID = 2113929216;
   private static final String TAG = "ViewAnimatorCompat";
   private Runnable mEndAction = null;
   private int mOldLayerType = -1;
   private Runnable mStartAction = null;
   private WeakReference<View> mView;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 21) {
         IMPL = new ViewPropertyAnimatorCompat.LollipopViewPropertyAnimatorCompatImpl();
      } else if(var0 >= 19) {
         IMPL = new ViewPropertyAnimatorCompat.KitKatViewPropertyAnimatorCompatImpl();
      } else if(var0 >= 18) {
         IMPL = new ViewPropertyAnimatorCompat.JBMr2ViewPropertyAnimatorCompatImpl();
      } else if(var0 >= 16) {
         IMPL = new ViewPropertyAnimatorCompat.JBViewPropertyAnimatorCompatImpl();
      } else if(var0 >= 14) {
         IMPL = new ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl();
      } else {
         IMPL = new ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl();
      }
   }

   ViewPropertyAnimatorCompat(View var1) {
      this.mView = new WeakReference(var1);
   }

   public ViewPropertyAnimatorCompat alpha(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.alpha(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat alphaBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.alphaBy(this, var2, var1);
      }

      return this;
   }

   public void cancel() {
      View var1 = (View)this.mView.get();
      if(var1 != null) {
         IMPL.cancel(this, var1);
      }

   }

   public long getDuration() {
      View var1 = (View)this.mView.get();
      return var1 != null?IMPL.getDuration(this, var1):0L;
   }

   public Interpolator getInterpolator() {
      View var1 = (View)this.mView.get();
      return var1 != null?IMPL.getInterpolator(this, var1):null;
   }

   public long getStartDelay() {
      View var1 = (View)this.mView.get();
      return var1 != null?IMPL.getStartDelay(this, var1):0L;
   }

   public ViewPropertyAnimatorCompat rotation(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotation(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationX(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationX(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationXBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationXBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationY(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationY(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationYBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationYBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat scaleX(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.scaleX(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat scaleXBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.scaleXBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat scaleY(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.scaleY(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat scaleYBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.scaleYBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat setDuration(long var1) {
      View var3 = (View)this.mView.get();
      if(var3 != null) {
         IMPL.setDuration(this, var3, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat setInterpolator(Interpolator var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.setInterpolator(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.setListener(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat setStartDelay(long var1) {
      View var3 = (View)this.mView.get();
      if(var3 != null) {
         IMPL.setStartDelay(this, var3, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.setUpdateListener(this, var2, var1);
      }

      return this;
   }

   public void start() {
      View var1 = (View)this.mView.get();
      if(var1 != null) {
         IMPL.start(this, var1);
      }

   }

   public ViewPropertyAnimatorCompat translationX(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationX(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat translationXBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationXBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat translationY(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationY(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat translationYBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationYBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat translationZ(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationZ(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat translationZBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationZBy(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat withEndAction(Runnable var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.withEndAction(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat withLayer() {
      View var1 = (View)this.mView.get();
      if(var1 != null) {
         IMPL.withLayer(this, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat withStartAction(Runnable var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.withStartAction(this, var2, var1);
      }

      return this;
   }

   // $FF: renamed from: x (float) android.support.v4.view.ViewPropertyAnimatorCompat
   public ViewPropertyAnimatorCompat method_355(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.method_21(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat xBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.xBy(this, var2, var1);
      }

      return this;
   }

   // $FF: renamed from: y (float) android.support.v4.view.ViewPropertyAnimatorCompat
   public ViewPropertyAnimatorCompat method_356(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.method_22(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat yBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.yBy(this, var2, var1);
      }

      return this;
   }

   // $FF: renamed from: z (float) android.support.v4.view.ViewPropertyAnimatorCompat
   public ViewPropertyAnimatorCompat method_357(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.method_23(this, var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat zBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.zBy(this, var2, var1);
      }

      return this;
   }

   static class BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl {
      WeakHashMap<View, Runnable> mStarterMap = null;

      private void postStartMessage(ViewPropertyAnimatorCompat var1, View var2) {
         WeakHashMap var3 = this.mStarterMap;
         Object var4 = null;
         if(var3 != null) {
            var4 = (Runnable)this.mStarterMap.get(var2);
         }

         if(var4 == null) {
            var4 = new ViewPropertyAnimatorCompat.Starter(var1, var2);
            if(this.mStarterMap == null) {
               this.mStarterMap = new WeakHashMap();
            }

            this.mStarterMap.put(var2, var4);
         }

         var2.removeCallbacks((Runnable)var4);
         var2.post((Runnable)var4);
      }

      private void removeStartMessage(View var1) {
         if(this.mStarterMap != null) {
            Runnable var2 = (Runnable)this.mStarterMap.get(var1);
            if(var2 != null) {
               var1.removeCallbacks(var2);
            }
         }

      }

      private void startAnimation(ViewPropertyAnimatorCompat var1, View var2) {
         Object var3 = var2.getTag(2113929216);
         boolean var4 = var3 instanceof ViewPropertyAnimatorListener;
         ViewPropertyAnimatorListener var5 = null;
         if(var4) {
            var5 = (ViewPropertyAnimatorListener)var3;
         }

         Runnable var6 = var1.mStartAction;
         Runnable var7 = var1.mEndAction;
         var1.mStartAction = null;
         var1.mEndAction = null;
         if(var6 != null) {
            var6.run();
         }

         if(var5 != null) {
            var5.onAnimationStart(var2);
            var5.onAnimationEnd(var2);
         }

         if(var7 != null) {
            var7.run();
         }

         if(this.mStarterMap != null) {
            this.mStarterMap.remove(var2);
         }

      }

      public void alpha(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void alphaBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void cancel(ViewPropertyAnimatorCompat var1, View var2) {
         this.postStartMessage(var1, var2);
      }

      public long getDuration(ViewPropertyAnimatorCompat var1, View var2) {
         return 0L;
      }

      public Interpolator getInterpolator(ViewPropertyAnimatorCompat var1, View var2) {
         return null;
      }

      public long getStartDelay(ViewPropertyAnimatorCompat var1, View var2) {
         return 0L;
      }

      public void rotation(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void rotationBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void rotationX(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void rotationXBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void rotationY(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void rotationYBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void scaleX(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void scaleXBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void scaleY(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void scaleYBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void setDuration(ViewPropertyAnimatorCompat var1, View var2, long var3) {
      }

      public void setInterpolator(ViewPropertyAnimatorCompat var1, View var2, Interpolator var3) {
      }

      public void setListener(ViewPropertyAnimatorCompat var1, View var2, ViewPropertyAnimatorListener var3) {
         var2.setTag(2113929216, var3);
      }

      public void setStartDelay(ViewPropertyAnimatorCompat var1, View var2, long var3) {
      }

      public void setUpdateListener(ViewPropertyAnimatorCompat var1, View var2, ViewPropertyAnimatorUpdateListener var3) {
      }

      public void start(ViewPropertyAnimatorCompat var1, View var2) {
         this.removeStartMessage(var2);
         this.startAnimation(var1, var2);
      }

      public void translationX(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void translationXBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void translationY(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void translationYBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void translationZ(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      }

      public void translationZBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      }

      public void withEndAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3) {
         var1.mEndAction = var3;
         this.postStartMessage(var1, var2);
      }

      public void withLayer(ViewPropertyAnimatorCompat var1, View var2) {
      }

      public void withStartAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3) {
         var1.mStartAction = var3;
         this.postStartMessage(var1, var2);
      }

      // $FF: renamed from: x (android.support.v4.view.ViewPropertyAnimatorCompat, android.view.View, float) void
      public void method_21(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void xBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      // $FF: renamed from: y (android.support.v4.view.ViewPropertyAnimatorCompat, android.view.View, float) void
      public void method_22(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      public void yBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         this.postStartMessage(var1, var2);
      }

      // $FF: renamed from: z (android.support.v4.view.ViewPropertyAnimatorCompat, android.view.View, float) void
      public void method_23(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      }

      public void zBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
      }
   }

   class Starter implements Runnable {
      WeakReference<View> mViewRef;
      ViewPropertyAnimatorCompat mVpa;

      private Starter(ViewPropertyAnimatorCompat var2, View var3) {
         this.mViewRef = new WeakReference(var3);
         this.mVpa = var2;
      }

      // $FF: synthetic method
      Starter(ViewPropertyAnimatorCompat var2, View var3, Object var4) {
         this();
      }

      public void run() {
         View var1 = (View)this.mViewRef.get();
         if(var1 != null) {
            ViewPropertyAnimatorCompat.super.startAnimation(this.mVpa, var1);
         }

      }
   }

   static class ICSViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl {
      WeakHashMap<View, Integer> mLayerMap = null;

      public void alpha(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.alpha(var2, var3);
      }

      public void alphaBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.alphaBy(var2, var3);
      }

      public void cancel(ViewPropertyAnimatorCompat var1, View var2) {
         ViewPropertyAnimatorCompatICS.cancel(var2);
      }

      public long getDuration(ViewPropertyAnimatorCompat var1, View var2) {
         return ViewPropertyAnimatorCompatICS.getDuration(var2);
      }

      public long getStartDelay(ViewPropertyAnimatorCompat var1, View var2) {
         return ViewPropertyAnimatorCompatICS.getStartDelay(var2);
      }

      public void rotation(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.rotation(var2, var3);
      }

      public void rotationBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.rotationBy(var2, var3);
      }

      public void rotationX(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.rotationX(var2, var3);
      }

      public void rotationXBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.rotationXBy(var2, var3);
      }

      public void rotationY(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.rotationY(var2, var3);
      }

      public void rotationYBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.rotationYBy(var2, var3);
      }

      public void scaleX(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.scaleX(var2, var3);
      }

      public void scaleXBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.scaleXBy(var2, var3);
      }

      public void scaleY(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.scaleY(var2, var3);
      }

      public void scaleYBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.scaleYBy(var2, var3);
      }

      public void setDuration(ViewPropertyAnimatorCompat var1, View var2, long var3) {
         ViewPropertyAnimatorCompatICS.setDuration(var2, var3);
      }

      public void setInterpolator(ViewPropertyAnimatorCompat var1, View var2, Interpolator var3) {
         ViewPropertyAnimatorCompatICS.setInterpolator(var2, var3);
      }

      public void setListener(ViewPropertyAnimatorCompat var1, View var2, ViewPropertyAnimatorListener var3) {
         var2.setTag(2113929216, var3);
         ViewPropertyAnimatorCompatICS.setListener(var2, new ViewPropertyAnimatorCompat.MyVpaListener(var1));
      }

      public void setStartDelay(ViewPropertyAnimatorCompat var1, View var2, long var3) {
         ViewPropertyAnimatorCompatICS.setStartDelay(var2, var3);
      }

      public void start(ViewPropertyAnimatorCompat var1, View var2) {
         ViewPropertyAnimatorCompatICS.start(var2);
      }

      public void translationX(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.translationX(var2, var3);
      }

      public void translationXBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.translationXBy(var2, var3);
      }

      public void translationY(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.translationY(var2, var3);
      }

      public void translationYBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.translationYBy(var2, var3);
      }

      public void withEndAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3) {
         ViewPropertyAnimatorCompatICS.setListener(var2, new ViewPropertyAnimatorCompat.MyVpaListener(var1));
         var1.mEndAction = var3;
      }

      public void withLayer(ViewPropertyAnimatorCompat var1, View var2) {
         var1.mOldLayerType = ViewCompat.getLayerType(var2);
         ViewPropertyAnimatorCompatICS.setListener(var2, new ViewPropertyAnimatorCompat.MyVpaListener(var1));
      }

      public void withStartAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3) {
         ViewPropertyAnimatorCompatICS.setListener(var2, new ViewPropertyAnimatorCompat.MyVpaListener(var1));
         var1.mStartAction = var3;
      }

      // $FF: renamed from: x (android.support.v4.view.ViewPropertyAnimatorCompat, android.view.View, float) void
      public void method_21(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.method_571(var2, var3);
      }

      public void xBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.xBy(var2, var3);
      }

      // $FF: renamed from: y (android.support.v4.view.ViewPropertyAnimatorCompat, android.view.View, float) void
      public void method_22(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.method_572(var2, var3);
      }

      public void yBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatICS.yBy(var2, var3);
      }
   }

   static class MyVpaListener implements ViewPropertyAnimatorListener {
      boolean mAnimEndCalled;
      ViewPropertyAnimatorCompat mVpa;

      MyVpaListener(ViewPropertyAnimatorCompat var1) {
         this.mVpa = var1;
      }

      public void onAnimationCancel(View var1) {
         Object var2 = var1.getTag(2113929216);
         boolean var3 = var2 instanceof ViewPropertyAnimatorListener;
         ViewPropertyAnimatorListener var4 = null;
         if(var3) {
            var4 = (ViewPropertyAnimatorListener)var2;
         }

         if(var4 != null) {
            var4.onAnimationCancel(var1);
         }

      }

      public void onAnimationEnd(View var1) {
         if(this.mVpa.mOldLayerType >= 0) {
            ViewCompat.setLayerType(var1, this.mVpa.mOldLayerType, (Paint)null);
            this.mVpa.mOldLayerType = -1;
         }

         if(VERSION.SDK_INT >= 16 || !this.mAnimEndCalled) {
            if(this.mVpa.mEndAction != null) {
               Runnable var5 = this.mVpa.mEndAction;
               this.mVpa.mEndAction = null;
               var5.run();
            }

            Object var2 = var1.getTag(2113929216);
            boolean var3 = var2 instanceof ViewPropertyAnimatorListener;
            ViewPropertyAnimatorListener var4 = null;
            if(var3) {
               var4 = (ViewPropertyAnimatorListener)var2;
            }

            if(var4 != null) {
               var4.onAnimationEnd(var1);
            }

            this.mAnimEndCalled = true;
         }

      }

      public void onAnimationStart(View var1) {
         this.mAnimEndCalled = false;
         if(this.mVpa.mOldLayerType >= 0) {
            ViewCompat.setLayerType(var1, 2, (Paint)null);
         }

         if(this.mVpa.mStartAction != null) {
            Runnable var5 = this.mVpa.mStartAction;
            this.mVpa.mStartAction = null;
            var5.run();
         }

         Object var2 = var1.getTag(2113929216);
         boolean var3 = var2 instanceof ViewPropertyAnimatorListener;
         ViewPropertyAnimatorListener var4 = null;
         if(var3) {
            var4 = (ViewPropertyAnimatorListener)var2;
         }

         if(var4 != null) {
            var4.onAnimationStart(var1);
         }

      }
   }

   static class JBMr2ViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat.JBViewPropertyAnimatorCompatImpl {
      public Interpolator getInterpolator(ViewPropertyAnimatorCompat var1, View var2) {
         return ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(var2);
      }
   }

   static class JBViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl {
      public void setListener(ViewPropertyAnimatorCompat var1, View var2, ViewPropertyAnimatorListener var3) {
         ViewPropertyAnimatorCompatJB.setListener(var2, var3);
      }

      public void withEndAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3) {
         ViewPropertyAnimatorCompatJB.withEndAction(var2, var3);
      }

      public void withLayer(ViewPropertyAnimatorCompat var1, View var2) {
         ViewPropertyAnimatorCompatJB.withLayer(var2);
      }

      public void withStartAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3) {
         ViewPropertyAnimatorCompatJB.withStartAction(var2, var3);
      }
   }

   static class KitKatViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat.JBMr2ViewPropertyAnimatorCompatImpl {
      public void setUpdateListener(ViewPropertyAnimatorCompat var1, View var2, ViewPropertyAnimatorUpdateListener var3) {
         ViewPropertyAnimatorCompatKK.setUpdateListener(var2, var3);
      }
   }

   static class LollipopViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat.KitKatViewPropertyAnimatorCompatImpl {
      public void translationZ(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatLollipop.translationZ(var2, var3);
      }

      public void translationZBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatLollipop.translationZBy(var2, var3);
      }

      // $FF: renamed from: z (android.support.v4.view.ViewPropertyAnimatorCompat, android.view.View, float) void
      public void method_23(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatLollipop.method_185(var2, var3);
      }

      public void zBy(ViewPropertyAnimatorCompat var1, View var2, float var3) {
         ViewPropertyAnimatorCompatLollipop.zBy(var2, var3);
      }
   }

   interface ViewPropertyAnimatorCompatImpl {
      void alpha(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void alphaBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void cancel(ViewPropertyAnimatorCompat var1, View var2);

      long getDuration(ViewPropertyAnimatorCompat var1, View var2);

      Interpolator getInterpolator(ViewPropertyAnimatorCompat var1, View var2);

      long getStartDelay(ViewPropertyAnimatorCompat var1, View var2);

      void rotation(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void rotationBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void rotationX(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void rotationXBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void rotationY(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void rotationYBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void scaleX(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void scaleXBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void scaleY(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void scaleYBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void setDuration(ViewPropertyAnimatorCompat var1, View var2, long var3);

      void setInterpolator(ViewPropertyAnimatorCompat var1, View var2, Interpolator var3);

      void setListener(ViewPropertyAnimatorCompat var1, View var2, ViewPropertyAnimatorListener var3);

      void setStartDelay(ViewPropertyAnimatorCompat var1, View var2, long var3);

      void setUpdateListener(ViewPropertyAnimatorCompat var1, View var2, ViewPropertyAnimatorUpdateListener var3);

      void start(ViewPropertyAnimatorCompat var1, View var2);

      void translationX(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void translationXBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void translationY(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void translationYBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void translationZ(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void translationZBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void withEndAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3);

      void withLayer(ViewPropertyAnimatorCompat var1, View var2);

      void withStartAction(ViewPropertyAnimatorCompat var1, View var2, Runnable var3);

      // $FF: renamed from: x (android.support.v4.view.ViewPropertyAnimatorCompat, android.view.View, float) void
      void method_21(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void xBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

      // $FF: renamed from: y (android.support.v4.view.ViewPropertyAnimatorCompat, android.view.View, float) void
      void method_22(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void yBy(ViewPropertyAnimatorCompat var1, View var2, float var3);

      // $FF: renamed from: z (android.support.v4.view.ViewPropertyAnimatorCompat, android.view.View, float) void
      void method_23(ViewPropertyAnimatorCompat var1, View var2, float var3);

      void zBy(ViewPropertyAnimatorCompat var1, View var2, float var3);
   }
}
