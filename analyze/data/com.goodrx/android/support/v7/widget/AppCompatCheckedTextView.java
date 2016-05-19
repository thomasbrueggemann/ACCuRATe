package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatTextHelper;
import android.support.v7.widget.TintContextWrapper;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView {
   private static final int[] TINT_ATTRS = new int[]{16843016};
   private AppCompatDrawableManager mDrawableManager;
   private AppCompatTextHelper mTextHelper;

   public AppCompatCheckedTextView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppCompatCheckedTextView(Context var1, AttributeSet var2) {
      this(var1, var2, 16843720);
   }

   public AppCompatCheckedTextView(Context var1, AttributeSet var2, int var3) {
      super(TintContextWrapper.wrap(var1), var2, var3);
      this.mTextHelper = AppCompatTextHelper.create(this);
      this.mTextHelper.loadFromAttributes(var2, var3);
      this.mTextHelper.applyCompoundDrawablesTints();
      this.mDrawableManager = AppCompatDrawableManager.get();
      TintTypedArray var4 = TintTypedArray.obtainStyledAttributes(this.getContext(), var2, TINT_ATTRS, var3, 0);
      this.setCheckMarkDrawable(var4.getDrawable(0));
      var4.recycle();
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      if(this.mTextHelper != null) {
         this.mTextHelper.applyCompoundDrawablesTints();
      }

   }

   public void setCheckMarkDrawable(@DrawableRes int var1) {
      if(this.mDrawableManager != null) {
         this.setCheckMarkDrawable(this.mDrawableManager.getDrawable(this.getContext(), var1));
      } else {
         super.setCheckMarkDrawable(var1);
      }
   }

   public void setTextAppearance(Context var1, int var2) {
      super.setTextAppearance(var1, var2);
      if(this.mTextHelper != null) {
         this.mTextHelper.onSetTextAppearance(var1, var2);
      }

   }
}
