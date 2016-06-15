package android.support.v4.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.app.ActionBarDrawerToggleHoneycomb;
import android.support.v4.app.ActionBarDrawerToggleJellybeanMR2;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;

public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
   private static final int ID_HOME = 16908332;
   private static final ActionBarDrawerToggle.ActionBarDrawerToggleImpl IMPL;
   private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334F;
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
      int var0 = VERSION.SDK_INT;
      if(var0 >= 18) {
         IMPL = new ActionBarDrawerToggle.ActionBarDrawerToggleImplJellybeanMR2();
      } else if(var0 >= 11) {
         IMPL = new ActionBarDrawerToggle.ActionBarDrawerToggleImplHC();
      } else {
         IMPL = new ActionBarDrawerToggle.ActionBarDrawerToggleImplBase();
      }
   }

   public ActionBarDrawerToggle(Activity var1, DrawerLayout var2, int var3, int var4, int var5) {
      this.mActivity = var1;
      if(var1 instanceof ActionBarDrawerToggle.DelegateProvider) {
         this.mActivityImpl = ((ActionBarDrawerToggle.DelegateProvider)var1).getDrawerToggleDelegate();
      } else {
         this.mActivityImpl = null;
      }

      this.mDrawerLayout = var2;
      this.mDrawerImageResource = var3;
      this.mOpenDrawerContentDescRes = var4;
      this.mCloseDrawerContentDescRes = var5;
      this.mThemeImage = this.getThemeUpIndicator();
      this.mDrawerImage = var1.getResources().getDrawable(var3);
      this.mSlider = new ActionBarDrawerToggle.SlideDrawable(this.mDrawerImage);
      this.mSlider.setOffset(0.33333334F);
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
      this.mSlider.setPosition(0.0F);
      if(this.mDrawerIndicatorEnabled) {
         this.setActionBarDescription(this.mOpenDrawerContentDescRes);
      }

   }

   public void onDrawerOpened(View var1) {
      this.mSlider.setPosition(1.0F);
      if(this.mDrawerIndicatorEnabled) {
         this.setActionBarDescription(this.mCloseDrawerContentDescRes);
      }

   }

   public void onDrawerSlide(View var1, float var2) {
      float var3 = this.mSlider.getPosition();
      float var4;
      if(var2 > 0.5F) {
         var4 = Math.max(var3, 2.0F * Math.max(0.0F, var2 - 0.5F));
      } else {
         var4 = Math.min(var3, var2 * 2.0F);
      }

      this.mSlider.setPosition(var4);
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
               var3 = this.mCloseDrawerContentDescRes;
            } else {
               var3 = this.mOpenDrawerContentDescRes;
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
         this.mSlider.setPosition(1.0F);
      } else {
         this.mSlider.setPosition(0.0F);
      }

      if(this.mDrawerIndicatorEnabled) {
         ActionBarDrawerToggle.SlideDrawable var1 = this.mSlider;
         int var2;
         if(this.mDrawerLayout.isDrawerOpen(8388611)) {
            var2 = this.mCloseDrawerContentDescRes;
         } else {
            var2 = this.mOpenDrawerContentDescRes;
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

   private static class ActionBarDrawerToggleImplJellybeanMR2 implements ActionBarDrawerToggle.ActionBarDrawerToggleImpl {
      private ActionBarDrawerToggleImplJellybeanMR2() {
      }

      // $FF: synthetic method
      ActionBarDrawerToggleImplJellybeanMR2(Object var1) {
         this();
      }

      public Drawable getThemeUpIndicator(Activity var1) {
         return ActionBarDrawerToggleJellybeanMR2.getThemeUpIndicator(var1);
      }

      public Object setActionBarDescription(Object var1, Activity var2, int var3) {
         return ActionBarDrawerToggleJellybeanMR2.setActionBarDescription(var1, var2, var3);
      }

      public Object setActionBarUpIndicator(Object var1, Activity var2, Drawable var3, int var4) {
         return ActionBarDrawerToggleJellybeanMR2.setActionBarUpIndicator(var1, var2, var3, var4);
      }
   }

   public interface Delegate {
      @Nullable
      Drawable getThemeUpIndicator();

      void setActionBarDescription(int var1);

      void setActionBarUpIndicator(Drawable var1, int var2);
   }

   public interface DelegateProvider {
      @Nullable
      ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
   }

   private class SlideDrawable extends InsetDrawable implements Callback {
      private final boolean mHasMirroring;
      private float mOffset;
      private float mPosition;
      private final Rect mTmpRect;

      private SlideDrawable(Drawable var2) {
         super(var2, 0);
         int var3 = VERSION.SDK_INT;
         boolean var4 = false;
         if(var3 > 18) {
            var4 = true;
         }

         this.mHasMirroring = var4;
         this.mTmpRect = new Rect();
      }

      // $FF: synthetic method
      SlideDrawable(Drawable var2, Object var3) {
         this();
      }

      public void draw(Canvas var1) {
         byte var2 = 1;
         this.copyBounds(this.mTmpRect);
         var1.save();
         byte var4;
         if(ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView()) == var2) {
            var4 = var2;
         } else {
            var4 = 0;
         }

         if(var4 != 0) {
            var2 = -1;
         }

         int var5 = this.mTmpRect.width();
         var1.translate(-this.mOffset * (float)var5 * this.mPosition * (float)var2, 0.0F);
         if(var4 != 0 && !this.mHasMirroring) {
            var1.translate((float)var5, 0.0F);
            var1.scale(-1.0F, 1.0F);
         }

         super.draw(var1);
         var1.restore();
      }

      public float getPosition() {
         return this.mPosition;
      }

      public void setOffset(float var1) {
         this.mOffset = var1;
         this.invalidateSelf();
      }

      public void setPosition(float var1) {
         this.mPosition = var1;
         this.invalidateSelf();
      }
   }
}
