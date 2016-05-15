package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import android.view.ActionProvider.VisibilityListener;

@TargetApi(16)
class MenuItemWrapperJB extends MenuItemWrapperICS {
   MenuItemWrapperJB(Context var1, SupportMenuItem var2) {
      super(var1, var2);
   }

   MenuItemWrapperICS.ActionProviderWrapper createActionProviderWrapper(ActionProvider var1) {
      return new MenuItemWrapperJB.ActionProviderWrapperJB(this.mContext, var1);
   }

   class ActionProviderWrapperJB extends MenuItemWrapperICS.ActionProviderWrapper implements VisibilityListener {
      android.support.v4.view.ActionProvider.VisibilityListener mListener;

      public ActionProviderWrapperJB(Context var2, ActionProvider var3) {
         super();
      }

      public boolean isVisible() {
         return this.mInner.isVisible();
      }

      public void onActionProviderVisibilityChanged(boolean var1) {
         if(this.mListener != null) {
            this.mListener.onActionProviderVisibilityChanged(var1);
         }

      }

      public View onCreateActionView(MenuItem var1) {
         return this.mInner.onCreateActionView(var1);
      }

      public boolean overridesItemVisibility() {
         return this.mInner.overridesItemVisibility();
      }

      public void refreshVisibility() {
         this.mInner.refreshVisibility();
      }

      public void setVisibilityListener(android.support.v4.view.ActionProvider.VisibilityListener var1) {
         this.mListener = var1;
         ActionProvider var2 = this.mInner;
         if(var1 == null) {
            this = null;
         }

         var2.setVisibilityListener(this);
      }
   }
}
