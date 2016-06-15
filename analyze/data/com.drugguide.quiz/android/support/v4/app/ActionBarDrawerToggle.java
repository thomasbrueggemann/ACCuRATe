package android.support.v4.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.app.ActionBarDrawerToggleHoneycomb;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;

public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
   private static final int ID_HOME = 16908332;
   private static final ActionBarDrawerToggle.ActionBarDrawerToggleImpl IMPL;
   private final Activity mActivity;
   private final ActionBarDrawerToggle.Delegate mActivityImpl;
   private final int mCloseDrawerContentDescRes;
   private Drawable mDrawerImage;
   private final int mDrawerImageResource;
   private boolean mDrawerIndicatorEnabled = true;
   private final DrawerLayout mDrawerLayout;
   private final int mOpenDrawerContentDescRes;
   private Object mSetIndicatorInfo;
   private ActionBarDrawerToggle.SlideDrawable mSlider;
   private Drawable mThemeImage;

   static {
      if(VERSION.SDK_INT >= 11) {
         IMPL = new ActionBarDrawerToggle.ActionBarDrawerToggleImplHC();
      } else {
         IMPL = new ActionBarDrawerToggle.ActionBarDrawerToggleImplBase();
      }
   }

   public ActionBarDrawerToggle(Activity var1, DrawerLayout var2, int var3, int var4, int var5) {
      this.mActivity = var1;
      this.mDrawerLayout = var2;
      this.mDrawerImageResource = var3;
      this.mOpenDrawerContentDescRes = var4;
      this.mCloseDrawerContentDescRes = var5;
      this.mThemeImage = this.getThemeUpIndicator();
      this.mDrawerImage = var1.getResources().getDrawable(var3);
      this.mSlider = new ActionBarDrawerToggle.SlideDrawable(this.mDrawerImage);
      this.mSlider.setOffsetBy(0.33333334F);
      if(var1 instanceof ActionBarDrawerToggle.DelegateProvider) {
         this.mActivityImpl = ((ActionBarDrawerToggle.DelegateProvider)var1).getDrawerToggleDelegate();
      } else {
         this.mActivityImpl = null;
      }
   }

   Drawable getThemeUpIndicator() {
      return this.mActivityImpl != null?this.mActivityImpl.getThemeUpIndicator():IMPL.getThemeUpIndicator(this.mActivity);
   }

   public boolean isDrawerIndicatorEnabled() {
      return this.mDrawerIndicatorEnabled;
   }

   public void onConfigurationChanged(Configuration var1) {
      this.mThemeImage = this.getThemeUpIndicator();
      this.mDrawerImage = this.mActivity.getResources().getDrawable(this.mDrawerImageResource);
      this.syncState();
   }

   public void onDrawerClosed(View var1) {
      this.mSlider.setOffset(0.0F);
      if(this.mDrawerIndicatorEnabled) {
         this.setActionBarDescription(this.mCloseDrawerContentDescRes);
      }

   }

   public void onDrawerOpened(View var1) {
      this.mSlider.setOffset(1.0F);
      if(this.mDrawerIndicatorEnabled) {
         this.setActionBarDescription(this.mOpenDrawerContentDescRes);
      }

   }

   public void onDrawerSlide(View var1, float var2) {
      float var3 = this.mSlider.getOffset();
      float var4;
      if(var2 > 0.5F) {
         var4 = Math.max(var3, 2.0F * Math.max(0.0F, var2 - 0.5F));
      } else {
         var4 = Math.min(var3, var2 * 2.0F);
      }

      this.mSlider.setOffset(var4);
   }

   public void onDrawerStateChanged(int var1) {
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1 != null && var1.getItemId() == 16908332 && this.mDrawerIndicatorEnabled) {
         if(this.mDrawerLayout.isDrawerVisible(8388611)) {
            this.mDrawerLayout.closeDrawer(8388611);
         } else {
            this.mDrawerLayout.openDrawer(8388611);
         }

         return true;
      } else {
         return false;
      }
   }

   void setActionBarDescription(int var1) {
      if(this.mActivityImpl != null) {
         this.mActivityImpl.setActionBarDescription(var1);
      } else {
         this.mSetIndicatorInfo = IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, var1);
      }
   }

   void setActionBarUpIndicator(Drawable var1, int var2) {
      if(this.mActivityImpl != null) {
         this.mActivityImpl.setActionBarUpIndicator(var1, var2);
      } else {
         this.mSetIndicatorInfo = IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, var1, var2);
      }
   }

   public void setDrawerIndicatorEnabled(boolean var1) {
      if(var1 != this.mDrawerIndicatorEnabled) {
         if(var1) {
            ActionBarDrawerToggle.SlideDrawable var2 = this.mSlider;
            int var3;
            if(this.mDrawerLayout.isDrawerOpen(8388611)) {
               var3 = this.mOpenDrawerContentDescRes;
            } else {
               var3 = this.mCloseDrawerContentDescRes;
            }

            this.setActionBarUpIndicator(var2, var3);
         } else {
            this.setActionBarUpIndicator(this.mThemeImage, 0);
         }

         this.mDrawerIndicatorEnabled = var1;
      }

   }

   public void syncState() {
      if(this.mDrawerLayout.isDrawerOpen(8388611)) {
         this.mSlider.setOffset(1.0F);
      } else {
         this.mSlider.setOffset(0.0F);
      }

      if(this.mDrawerIndicatorEnabled) {
         ActionBarDrawerToggle.SlideDrawable var1 = this.mSlider;
         int var2;
         if(this.mDrawerLayout.isDrawerOpen(8388611)) {
            var2 = this.mOpenDrawerContentDescRes;
         } else {
            var2 = this.mCloseDrawerContentDescRes;
         }

         this.setActionBarUpIndicator(var1, var2);
      }

   }

   private interface ActionBarDrawerToggleImpl {
      Drawable getThemeUpIndicator(Activity var1);

      Object setActionBarDescription(Object var1, Activity var2, int var3);

      Object setActionBarUpIndicator(Object var1, Activity var2, Drawable var3, int var4);
   }

   private static class ActionBarDrawerToggleImplBase implements ActionBarDrawerToggle.ActionBarDrawerToggleImpl {
      private ActionBarDrawerToggleImplBase() {
      }

      // $FF: synthetic method
      ActionBarDrawerToggleImplBase(Object var1) {
         this();
      }

      public Drawable getThemeUpIndicator(Activity var1) {
         return null;
      }

      public Object setActionBarDescription(Object var1, Activity var2, int var3) {
         return var1;
      }

      public Object setActionBarUpIndicator(Object var1, Activity var2, Drawable var3, int var4) {
         return var1;
      }
   }

   private static class ActionBarDrawerToggleImplHC implements ActionBarDrawerToggle.ActionBarDrawerToggleImpl {
      private ActionBarDrawerToggleImplHC() {
      }

      // $FF: synthetic method
      ActionBarDrawerToggleImplHC(Object var1) {
         this();
      }

      public Drawable getThemeUpIndicator(Activity var1) {
         return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(var1);
      }

      public Object setActionBarDescription(Object var1, Activity var2, int var3) {
         return ActionBarDrawerToggleHoneycomb.setActionBarDescription(var1, var2, var3);
      }

      public Object setActionBarUpIndicator(Object var1, Activity var2, Drawable var3, int var4) {
         return ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(var1, var2, var3, var4);
      }
   }

   public interface Delegate {
      Drawable getThemeUpIndicator();

      void setActionBarDescription(int var1);

      void setActionBarUpIndicator(Drawable var1, int var2);
   }

   public interface DelegateProvider {
      ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
   }

   private static class SlideDrawable extends Drawable implements Callback {
      private float mOffset;
      private float mOffsetBy;
      private final Rect mTmpRect = new Rect();
      private Drawable mWrapped;

      public SlideDrawable(Drawable var1) {
         this.mWrapped = var1;
      }

      public void clearColorFilter() {
         this.mWrapped.clearColorFilter();
      }

      public void draw(Canvas var1) {
         this.mWrapped.copyBounds(this.mTmpRect);
         var1.save();
         var1.translate(this.mOffsetBy * (float)this.mTmpRect.width() * -this.mOffset, 0.0F);
         this.mWrapped.draw(var1);
         var1.restore();
      }

      public int getChangingConfigurations() {
         return this.mWrapped.getChangingConfigurations();
      }

      public ConstantState getConstantState() {
         return super.getConstantState();
      }

      public Drawable getCurrent() {
         return this.mWrapped.getCurrent();
      }

      public int getIntrinsicHeight() {
         return this.mWrapped.getIntrinsicHeight();
      }

      public int getIntrinsicWidth() {
         return this.mWrapped.getIntrinsicWidth();
      }

      public int getMinimumHeight() {
         return this.mWrapped.getMinimumHeight();
      }

      public int getMinimumWidth() {
         return this.mWrapped.getMinimumWidth();
      }

      public float getOffset() {
         return this.mOffset;
      }

      public int getOpacity() {
         return this.mWrapped.getOpacity();
      }

      public boolean getPadding(Rect var1) {
         return this.mWrapped.getPadding(var1);
      }

      public int[] getState() {
         return this.mWrapped.getState();
      }

      public Region getTransparentRegion() {
         return this.mWrapped.getTransparentRegion();
      }

      public void invalidateDrawable(Drawable var1) {
         if(var1 == this.mWrapped) {
            this.invalidateSelf();
         }

      }

      public boolean isStateful() {
         return this.mWrapped.isStateful();
      }

      protected void onBoundsChange(Rect var1) {
         super.onBoundsChange(var1);
         this.mWrapped.setBounds(var1);
      }

      protected boolean onStateChange(int[] var1) {
         this.mWrapped.setState(var1);
         return super.onStateChange(var1);
      }

      public void scheduleDrawable(Drawable var1, Runnable var2, long var3) {
         if(var1 == this.mWrapped) {
            this.scheduleSelf(var2, var3);
         }

      }

      public void setAlpha(int var1) {
         this.mWrapped.setAlpha(var1);
      }

      public void setChangingConfigurations(int var1) {
         this.mWrapped.setChangingConfigurations(var1);
      }

      public void setColorFilter(int var1, Mode var2) {
         this.mWrapped.setColorFilter(var1, var2);
      }

      public void setColorFilter(ColorFilter var1) {
         this.mWrapped.setColorFilter(var1);
      }

      public void setDither(boolean var1) {
         this.mWrapped.setDither(var1);
      }

      public void setFilterBitmap(boolean var1) {
         this.mWrapped.setFilterBitmap(var1);
      }

      public void setOffset(float var1) {
         this.mOffset = var1;
         this.invalidateSelf();
      }

      public void setOffsetBy(float var1) {
         this.mOffsetBy = var1;
         this.invalidateSelf();
      }

      public boolean setState(int[] var1) {
         return this.mWrapped.setState(var1);
      }

      public boolean setVisible(boolean var1, boolean var2) {
         return super.setVisible(var1, var2);
      }

      public void unscheduleDrawable(Drawable var1, Runnable var2) {
         if(var1 == this.mWrapped) {
            this.unscheduleSelf(var2);
         }

      }
   }
}
