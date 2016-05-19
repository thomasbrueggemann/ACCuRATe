package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatTextHelper;
import android.support.v7.widget.TintInfo;
import android.util.AttributeSet;
import android.widget.TextView;

class AppCompatTextHelperV17 extends AppCompatTextHelper {
   private static final int[] VIEW_ATTRS_v17 = new int[]{16843666, 16843667};
   private TintInfo mDrawableEndTint;
   private TintInfo mDrawableStartTint;

   AppCompatTextHelperV17(TextView var1) {
      super(var1);
   }

   void applyCompoundDrawablesTints() {
      super.applyCompoundDrawablesTints();
      if(this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
         Drawable[] var1 = this.mView.getCompoundDrawablesRelative();
         this.applyCompoundDrawableTint(var1[0], this.mDrawableStartTint);
         this.applyCompoundDrawableTint(var1[2], this.mDrawableEndTint);
      }

   }

   void loadFromAttributes(AttributeSet var1, int var2) {
      super.loadFromAttributes(var1, var2);
      Context var3 = this.mView.getContext();
      AppCompatDrawableManager var4 = AppCompatDrawableManager.get();
      TypedArray var5 = var3.obtainStyledAttributes(var1, VIEW_ATTRS_v17, var2, 0);
      if(var5.hasValue(0)) {
         this.mDrawableStartTint = createTintInfo(var3, var4, var5.getResourceId(0, 0));
      }

      if(var5.hasValue(1)) {
         this.mDrawableEndTint = createTintInfo(var3, var4, var5.getResourceId(1, 0));
      }

      var5.recycle();
   }
}
