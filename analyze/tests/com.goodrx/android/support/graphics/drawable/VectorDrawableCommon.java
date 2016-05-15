package android.support.graphics.drawable;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;

@TargetApi(21)
abstract class VectorDrawableCommon extends Drawable {
   Drawable mDelegateDrawable;

   static TypedArray obtainAttributes(Resources var0, Theme var1, AttributeSet var2, int[] var3) {
      return var1 == null?var0.obtainAttributes(var2, var3):var1.obtainStyledAttributes(var2, var3, 0, 0);
   }

   public void applyTheme(Theme var1) {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.applyTheme(this.mDelegateDrawable, var1);
      }

   }

   public void clearColorFilter() {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.clearColorFilter();
      } else {
         super.clearColorFilter();
      }
   }

   public ColorFilter getColorFilter() {
      return this.mDelegateDrawable != null?DrawableCompat.getColorFilter(this.mDelegateDrawable):null;
   }

   public Drawable getCurrent() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getCurrent():super.getCurrent();
   }

   public int getLayoutDirection() {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.getLayoutDirection(this.mDelegateDrawable);
      }

      return 0;
   }

   public int getMinimumHeight() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getMinimumHeight():super.getMinimumHeight();
   }

   public int getMinimumWidth() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getMinimumWidth():super.getMinimumWidth();
   }

   public boolean getPadding(Rect var1) {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getPadding(var1):super.getPadding(var1);
   }

   public int[] getState() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getState():super.getState();
   }

   public Region getTransparentRegion() {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.getTransparentRegion():super.getTransparentRegion();
   }

   public boolean isAutoMirrored() {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.isAutoMirrored(this.mDelegateDrawable);
      }

      return false;
   }

   public void jumpToCurrentState() {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.jumpToCurrentState(this.mDelegateDrawable);
      }

   }

   protected void onBoundsChange(Rect var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setBounds(var1);
      } else {
         super.onBoundsChange(var1);
      }
   }

   protected boolean onLevelChange(int var1) {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.setLevel(var1):super.onLevelChange(var1);
   }

   public void setAutoMirrored(boolean var1) {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.setAutoMirrored(this.mDelegateDrawable, var1);
      }

   }

   public void setChangingConfigurations(int var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setChangingConfigurations(var1);
      } else {
         super.setChangingConfigurations(var1);
      }
   }

   public void setColorFilter(int var1, Mode var2) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setColorFilter(var1, var2);
      } else {
         super.setColorFilter(var1, var2);
      }
   }

   public void setFilterBitmap(boolean var1) {
      if(this.mDelegateDrawable != null) {
         this.mDelegateDrawable.setFilterBitmap(var1);
      }

   }

   public void setHotspot(float var1, float var2) {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.setHotspot(this.mDelegateDrawable, var1, var2);
      }

   }

   public void setHotspotBounds(int var1, int var2, int var3, int var4) {
      if(this.mDelegateDrawable != null) {
         DrawableCompat.setHotspotBounds(this.mDelegateDrawable, var1, var2, var3, var4);
      }

   }

   public boolean setState(int[] var1) {
      return this.mDelegateDrawable != null?this.mDelegateDrawable.setState(var1):super.setState(var1);
   }
}
