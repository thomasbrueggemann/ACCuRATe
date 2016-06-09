package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ValueAnimatorCompatImplEclairMr1;
import android.support.design.widget.ValueAnimatorCompatImplHoneycombMr1;
import android.support.design.widget.ViewUtilsLollipop;
import android.view.View;

class ViewUtils {
   static final ValueAnimatorCompat.Creator DEFAULT_ANIMATOR_CREATOR = new ValueAnimatorCompat.Creator() {
      public ValueAnimatorCompat createAnimator() {
         Object var1;
         if(VERSION.SDK_INT >= 12) {
            var1 = new ValueAnimatorCompatImplHoneycombMr1();
         } else {
            var1 = new ValueAnimatorCompatImplEclairMr1();
         }

         return new ValueAnimatorCompat((ValueAnimatorCompat.Impl)var1);
      }
   };
   private static final ViewUtils.ViewUtilsImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 21) {
         IMPL = new ViewUtils.ViewUtilsImplLollipop(null);
      } else {
         IMPL = new ViewUtils.ViewUtilsImplBase(null);
      }
   }

   static ValueAnimatorCompat createAnimator() {
      return DEFAULT_ANIMATOR_CREATOR.createAnimator();
   }

   static void setBoundsViewOutlineProvider(View var0) {
      IMPL.setBoundsViewOutlineProvider(var0);
   }

   private interface ViewUtilsImpl {
      void setBoundsViewOutlineProvider(View var1);
   }

   private static class ViewUtilsImplBase implements ViewUtils.ViewUtilsImpl {
      private ViewUtilsImplBase() {
      }

      // $FF: synthetic method
      ViewUtilsImplBase(Object var1) {
         this();
      }

      public void setBoundsViewOutlineProvider(View var1) {
      }
   }

   private static class ViewUtilsImplLollipop implements ViewUtils.ViewUtilsImpl {
      private ViewUtilsImplLollipop() {
      }

      // $FF: synthetic method
      ViewUtilsImplLollipop(Object var1) {
         this();
      }

      public void setBoundsViewOutlineProvider(View var1) {
         ViewUtilsLollipop.setBoundsViewOutlineProvider(var1);
      }
   }
}
