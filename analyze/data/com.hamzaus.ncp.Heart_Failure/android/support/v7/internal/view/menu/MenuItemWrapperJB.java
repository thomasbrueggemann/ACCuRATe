package android.support.v7.internal.view.menu;

import android.support.v4.view.ActionProvider;
import android.support.v7.internal.view.menu.MenuItemWrapperICS;
import android.view.MenuItem;
import android.view.View;
import android.view.ActionProvider.VisibilityListener;

class MenuItemWrapperJB extends MenuItemWrapperICS {
   MenuItemWrapperJB(MenuItem var1) {
      super(var1, false);
   }

   MenuItemWrapperICS.ActionProviderWrapper createActionProviderWrapper(ActionProvider var1) {
      return new MenuItemWrapperJB.ActionProviderWrapperJB(var1);
   }

   class ActionProviderWrapperJB extends MenuItemWrapperICS.ActionProviderWrapper implements ActionProvider.VisibilityListener {
      VisibilityListener mListener;

      public ActionProviderWrapperJB(ActionProvider var2) {
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

      public void setVisibilityListener(VisibilityListener var1) {
         this.mListener = var1;
         ActionProvider var2 = this.mInner;
         if(var1 == null) {
            this = null;
         }

         var2.setVisibilityListener(this);
      }
   }
}
