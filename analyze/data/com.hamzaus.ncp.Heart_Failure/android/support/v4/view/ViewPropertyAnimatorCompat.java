package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompatICS;
import android.support.v4.view.ViewPropertyAnimatorCompatJB;
import android.support.v4.view.ViewPropertyAnimatorCompatJellybeanMr2;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public class ViewPropertyAnimatorCompat {
   static final ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl IMPL;
   private static final String TAG = "ViewAnimatorCompat";
   private WeakReference<View> mView;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 18) {
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
         IMPL.alpha(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat alphaBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.alphaBy(var2, var1);
      }

      return this;
   }

   public void cancel() {
      View var1 = (View)this.mView.get();
      if(var1 != null) {
         IMPL.cancel(var1);
      }

   }

   public long getDuration() {
      View var1 = (View)this.mView.get();
      return var1 != null?IMPL.getDuration(var1):0L;
   }

   public Interpolator getInterpolator() {
      View var1 = (View)this.mView.get();
      return var1 != null?IMPL.getInterpolator(var1):null;
   }

   public long getStartDelay() {
      View var1 = (View)this.mView.get();
      return var1 != null?IMPL.getStartDelay(var1):0L;
   }

   public ViewPropertyAnimatorCompat rotation(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotation(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationBy(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationX(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationX(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationXBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationXBy(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationY(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationY(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat rotationYBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.rotationYBy(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat scaleX(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.scaleX(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat scaleXBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.scaleXBy(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat scaleY(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.scaleY(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat scaleYBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.scaleYBy(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat setDuration(long var1) {
      View var3 = (View)this.mView.get();
      if(var3 != null) {
         IMPL.setDuration(var3, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat setInterpolator(Interpolator var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.setInterpolator(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.setListener(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat setStartDelay(long var1) {
      View var3 = (View)this.mView.get();
      if(var3 != null) {
         IMPL.setStartDelay(var3, var1);
      }

      return this;
   }

   public void start() {
      View var1 = (View)this.mView.get();
      if(var1 != null) {
         IMPL.start(var1);
      }

   }

   public ViewPropertyAnimatorCompat translationX(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationX(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat translationXBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationXBy(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat translationY(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationY(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat translationYBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.translationYBy(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat withEndAction(Runnable var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.withEndAction(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat withLayer() {
      View var1 = (View)this.mView.get();
      if(var1 != null) {
         IMPL.withLayer(var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat withStartAction(Runnable var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.withStartAction(var2, var1);
      }

      return this;
   }

   // $FF: renamed from: x (float) android.support.v4.view.ViewPropertyAnimatorCompat
   public ViewPropertyAnimatorCompat method_3774(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.method_774(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat xBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.xBy(var2, var1);
      }

      return this;
   }

   // $FF: renamed from: y (float) android.support.v4.view.ViewPropertyAnimatorCompat
   public ViewPropertyAnimatorCompat method_3775(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.method_775(var2, var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat yBy(float var1) {
      View var2 = (View)this.mView.get();
      if(var2 != null) {
         IMPL.yBy(var2, var1);
      }

      return this;
   }

   static class BaseViewPropertyAnimatorCompatImpl implements ViewPropertyAnimatorCompat.ViewPropertyAnimatorCompatImpl {
      public void alpha(View var1, float var2) {
      }

      public void alphaBy(View var1, float var2) {
      }

      public void cancel(View var1) {
      }

      public long getDuration(View var1) {
         return 0L;
      }

      public Interpolator getInterpolator(View var1) {
         return null;
      }

      public long getStartDelay(View var1) {
         return 0L;
      }

      public void rotation(View var1, float var2) {
      }

      public void rotationBy(View var1, float var2) {
      }

      public void rotationX(View var1, float var2) {
      }

      public void rotationXBy(View var1, float var2) {
      }

      public void rotationY(View var1, float var2) {
      }

      public void rotationYBy(View var1, float var2) {
      }

      public void scaleX(View var1, float var2) {
      }

      public void scaleXBy(View var1, float var2) {
      }

      public void scaleY(View var1, float var2) {
      }

      public void scaleYBy(View var1, float var2) {
      }

      public void setDuration(View var1, long var2) {
      }

      public void setInterpolator(View var1, Interpolator var2) {
      }

      public void setListener(View var1, ViewPropertyAnimatorListener var2) {
      }

      public void setStartDelay(View var1, long var2) {
      }

      public void start(View var1) {
      }

      public void translationX(View var1, float var2) {
      }

      public void translationXBy(View var1, float var2) {
      }

      public void translationY(View var1, float var2) {
      }

      public void translationYBy(View var1, float var2) {
      }

      public void withEndAction(View var1, Runnable var2) {
         var2.run();
      }

      public void withLayer(View var1) {
      }

      public void withStartAction(View var1, Runnable var2) {
         var2.run();
      }

      // $FF: renamed from: x (android.view.View, float) void
      public void method_774(View var1, float var2) {
      }

      public void xBy(View var1, float var2) {
      }

      // $FF: renamed from: y (android.view.View, float) void
      public void method_775(View var1, float var2) {
      }

      public void yBy(View var1, float var2) {
      }
   }

   static class ICSViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat.BaseViewPropertyAnimatorCompatImpl {
      public void alpha(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.alpha(var1, var2);
      }

      public void alphaBy(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.alphaBy(var1, var2);
      }

      public void cancel(View var1) {
         ViewPropertyAnimatorCompatICS.cancel(var1);
      }

      public long getDuration(View var1) {
         return ViewPropertyAnimatorCompatICS.getDuration(var1);
      }

      public long getStartDelay(View var1) {
         return ViewPropertyAnimatorCompatICS.getStartDelay(var1);
      }

      public void rotation(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.rotation(var1, var2);
      }

      public void rotationBy(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.rotationBy(var1, var2);
      }

      public void rotationX(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.rotationX(var1, var2);
      }

      public void rotationXBy(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.rotationXBy(var1, var2);
      }

      public void rotationY(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.rotationY(var1, var2);
      }

      public void rotationYBy(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.rotationYBy(var1, var2);
      }

      public void scaleX(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.scaleX(var1, var2);
      }

      public void scaleXBy(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.scaleXBy(var1, var2);
      }

      public void scaleY(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.scaleY(var1, var2);
      }

      public void scaleYBy(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.scaleYBy(var1, var2);
      }

      public void setDuration(View var1, long var2) {
         ViewPropertyAnimatorCompatICS.setDuration(var1, var2);
      }

      public void setInterpolator(View var1, Interpolator var2) {
         ViewPropertyAnimatorCompatICS.setInterpolator(var1, var2);
      }

      public void setListener(View var1, ViewPropertyAnimatorListener var2) {
         ViewPropertyAnimatorCompatICS.setListener(var1, var2);
      }

      public void setStartDelay(View var1, long var2) {
         ViewPropertyAnimatorCompatICS.setStartDelay(var1, var2);
      }

      public void start(View var1) {
         ViewPropertyAnimatorCompatICS.start(var1);
      }

      public void translationX(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.translationX(var1, var2);
      }

      public void translationXBy(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.translationXBy(var1, var2);
      }

      public void translationY(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.translationY(var1, var2);
      }

      public void translationYBy(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.translationYBy(var1, var2);
      }

      public void withEndAction(View var1, final Runnable var2) {
         this.setListener(var1, new ViewPropertyAnimatorListener() {
            public void onAnimationCancel(View var1) {
            }

            public void onAnimationEnd(View var1) {
               var2.run();
               ICSViewPropertyAnimatorCompatImpl.this.setListener(var1, (ViewPropertyAnimatorListener)null);
            }

            public void onAnimationStart(View var1) {
            }
         });
      }

      public void withLayer(View var1) {
         this.setListener(var1, new ViewPropertyAnimatorListener() {
            // $FF: synthetic field
            final int val$currentLayerType;

            {
               this.val$currentLayerType = var2;
            }

            public void onAnimationCancel(View var1) {
            }

            public void onAnimationEnd(View var1) {
               ViewCompat.setLayerType(var1, this.val$currentLayerType, (Paint)null);
               ICSViewPropertyAnimatorCompatImpl.this.setListener(var1, (ViewPropertyAnimatorListener)null);
            }

            public void onAnimationStart(View var1) {
               ViewCompat.setLayerType(var1, 2, (Paint)null);
            }
         });
      }

      public void withStartAction(View var1, final Runnable var2) {
         this.setListener(var1, new ViewPropertyAnimatorListener() {
            public void onAnimationCancel(View var1) {
            }

            public void onAnimationEnd(View var1) {
            }

            public void onAnimationStart(View var1) {
               var2.run();
               ICSViewPropertyAnimatorCompatImpl.this.setListener(var1, (ViewPropertyAnimatorListener)null);
            }
         });
      }

      // $FF: renamed from: x (android.view.View, float) void
      public void method_774(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.method_4431(var1, var2);
      }

      public void xBy(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.xBy(var1, var2);
      }

      // $FF: renamed from: y (android.view.View, float) void
      public void method_775(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.method_4432(var1, var2);
      }

      public void yBy(View var1, float var2) {
         ViewPropertyAnimatorCompatICS.yBy(var1, var2);
      }
   }

   static class JBMr2ViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat.JBViewPropertyAnimatorCompatImpl {
      public Interpolator getInterpolator(View var1) {
         return ViewPropertyAnimatorCompatJellybeanMr2.getInterpolator(var1);
      }
   }

   static class JBViewPropertyAnimatorCompatImpl extends ViewPropertyAnimatorCompat.ICSViewPropertyAnimatorCompatImpl {
      public void withEndAction(View var1, Runnable var2) {
         ViewPropertyAnimatorCompatJB.withEndAction(var1, var2);
      }

      public void withLayer(View var1) {
         ViewPropertyAnimatorCompatJB.withLayer(var1);
      }

      public void withStartAction(View var1, Runnable var2) {
         ViewPropertyAnimatorCompatJB.withStartAction(var1, var2);
      }
   }

   interface ViewPropertyAnimatorCompatImpl {
      void alpha(View var1, float var2);

      void alphaBy(View var1, float var2);

      void cancel(View var1);

      long getDuration(View var1);

      Interpolator getInterpolator(View var1);

      long getStartDelay(View var1);

      void rotation(View var1, float var2);

      void rotationBy(View var1, float var2);

      void rotationX(View var1, float var2);

      void rotationXBy(View var1, float var2);

      void rotationY(View var1, float var2);

      void rotationYBy(View var1, float var2);

      void scaleX(View var1, float var2);

      void scaleXBy(View var1, float var2);

      void scaleY(View var1, float var2);

      void scaleYBy(View var1, float var2);

      void setDuration(View var1, long var2);

      void setInterpolator(View var1, Interpolator var2);

      void setListener(View var1, ViewPropertyAnimatorListener var2);

      void setStartDelay(View var1, long var2);

      void start(View var1);

      void translationX(View var1, float var2);

      void translationXBy(View var1, float var2);

      void translationY(View var1, float var2);

      void translationYBy(View var1, float var2);

      void withEndAction(View var1, Runnable var2);

      void withLayer(View var1);

      void withStartAction(View var1, Runnable var2);

      // $FF: renamed from: x (android.view.View, float) void
      void method_774(View var1, float var2);

      void xBy(View var1, float var2);

      // $FF: renamed from: y (android.view.View, float) void
      void method_775(View var1, float var2);

      void yBy(View var1, float var2);
   }
}
