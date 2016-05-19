package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.class_22;
import android.support.v7.text.AllCapsTransformationMethod;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatTextHelperV17;
import android.support.v7.widget.TintInfo;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class AppCompatTextHelper {
   private static final int[] TEXT_APPEARANCE_ATTRS;
   private static final int[] VIEW_ATTRS = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
   private TintInfo mDrawableBottomTint;
   private TintInfo mDrawableLeftTint;
   private TintInfo mDrawableRightTint;
   private TintInfo mDrawableTopTint;
   final TextView mView;

   static {
      int[] var0 = new int[]{class_22.attr.textAllCaps};
      TEXT_APPEARANCE_ATTRS = var0;
   }

   AppCompatTextHelper(TextView var1) {
      this.mView = var1;
   }

   static AppCompatTextHelper create(TextView var0) {
      return (AppCompatTextHelper)(VERSION.SDK_INT >= 17?new AppCompatTextHelperV17(var0):new AppCompatTextHelper(var0));
   }

   protected static TintInfo createTintInfo(Context var0, AppCompatDrawableManager var1, int var2) {
      ColorStateList var3 = var1.getTintList(var0, var2);
      if(var3 != null) {
         TintInfo var4 = new TintInfo();
         var4.mHasTintList = true;
         var4.mTintList = var3;
         return var4;
      } else {
         return null;
      }
   }

   final void applyCompoundDrawableTint(Drawable var1, TintInfo var2) {
      if(var1 != null && var2 != null) {
         AppCompatDrawableManager.tintDrawable(var1, var2, this.mView.getDrawableState());
      }

   }

   void applyCompoundDrawablesTints() {
      if(this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
         Drawable[] var1 = this.mView.getCompoundDrawables();
         this.applyCompoundDrawableTint(var1[0], this.mDrawableLeftTint);
         this.applyCompoundDrawableTint(var1[1], this.mDrawableTopTint);
         this.applyCompoundDrawableTint(var1[2], this.mDrawableRightTint);
         this.applyCompoundDrawableTint(var1[3], this.mDrawableBottomTint);
      }

   }

   void loadFromAttributes(AttributeSet var1, int var2) {
      Context var3 = this.mView.getContext();
      AppCompatDrawableManager var4 = AppCompatDrawableManager.get();
      TypedArray var5 = var3.obtainStyledAttributes(var1, VIEW_ATTRS, var2, 0);
      int var6 = var5.getResourceId(0, -1);
      if(var5.hasValue(1)) {
         this.mDrawableLeftTint = createTintInfo(var3, var4, var5.getResourceId(1, 0));
      }

      if(var5.hasValue(2)) {
         this.mDrawableTopTint = createTintInfo(var3, var4, var5.getResourceId(2, 0));
      }

      if(var5.hasValue(3)) {
         this.mDrawableRightTint = createTintInfo(var3, var4, var5.getResourceId(3, 0));
      }

      if(var5.hasValue(4)) {
         this.mDrawableBottomTint = createTintInfo(var3, var4, var5.getResourceId(4, 0));
      }

      var5.recycle();
      if(!(this.mView.getTransformationMethod() instanceof PasswordTransformationMethod)) {
         boolean var7 = false;
         if(var6 != -1) {
            TypedArray var9 = var3.obtainStyledAttributes(var6, class_22.styleable.TextAppearance);
            boolean var10 = var9.hasValue(class_22.styleable.TextAppearance_textAllCaps);
            var7 = false;
            if(var10) {
               var7 = var9.getBoolean(class_22.styleable.TextAppearance_textAllCaps, false);
            }

            var9.recycle();
         }

         TypedArray var8 = var3.obtainStyledAttributes(var1, TEXT_APPEARANCE_ATTRS, var2, 0);
         if(var8.hasValue(0)) {
            var7 = var8.getBoolean(0, false);
         }

         var8.recycle();
         if(var7) {
            this.setAllCaps(true);
         }
      }

   }

   void onSetTextAppearance(Context var1, int var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, TEXT_APPEARANCE_ATTRS);
      if(var3.getBoolean(0, false)) {
         this.setAllCaps(true);
      }

      var3.recycle();
   }

   void setAllCaps(boolean var1) {
      TextView var2 = this.mView;
      AllCapsTransformationMethod var3;
      if(var1) {
         var3 = new AllCapsTransformationMethod(this.mView.getContext());
      } else {
         var3 = null;
      }

      var2.setTransformationMethod(var3);
   }
}
