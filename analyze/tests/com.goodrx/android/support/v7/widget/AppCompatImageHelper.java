package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.DrawableUtils;
import android.util.AttributeSet;
import android.widget.ImageView;

class AppCompatImageHelper {
   private final AppCompatDrawableManager mDrawableManager;
   private final ImageView mView;

   AppCompatImageHelper(ImageView var1, AppCompatDrawableManager var2) {
      this.mView = var1;
      this.mDrawableManager = var2;
   }

   void loadFromAttributes(AttributeSet param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   void setImageResource(int var1) {
      if(var1 != 0) {
         Drawable var2;
         if(this.mDrawableManager != null) {
            var2 = this.mDrawableManager.getDrawable(this.mView.getContext(), var1);
         } else {
            var2 = ContextCompat.getDrawable(this.mView.getContext(), var1);
         }

         if(var2 != null) {
            DrawableUtils.fixDrawable(var2);
         }

         this.mView.setImageDrawable(var2);
      } else {
         this.mView.setImageDrawable((Drawable)null);
      }
   }
}
