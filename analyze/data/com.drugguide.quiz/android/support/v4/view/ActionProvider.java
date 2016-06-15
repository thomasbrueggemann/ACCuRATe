package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class ActionProvider {
   private static final String TAG = "ActionProvider(support)";
   private final Context mContext;
   private ActionProvider.SubUiVisibilityListener mSubUiVisibilityListener;
   private ActionProvider.VisibilityListener mVisibilityListener;

   public ActionProvider(Context var1) {
      this.mContext = var1;
   }

   public Context getContext() {
      return this.mContext;
   }

   public boolean hasSubMenu() {
      return false;
   }

   public boolean isVisible() {
      return true;
   }

   public abstract View onCreateActionView();

   public View onCreateActionView(MenuItem var1) {
      return this.onCreateActionView();
   }

   public boolean onPerformDefaultAction() {
      return false;
   }

   public void onPrepareSubMenu(SubMenu var1) {
   }

   public boolean overridesItemVisibility() {
      return false;
   }

   public void refreshVisibility() {
      if(this.mVisibilityListener != null && this.overridesItemVisibility()) {
         this.mVisibilityListener.onActionProviderVisibilityChanged(this.isVisible());
      }

   }

   public void setSubUiVisibilityListener(ActionProvider.SubUiVisibilityListener var1) {
      this.mSubUiVisibilityListener = var1;
   }

   public void setVisibilityListener(ActionProvider.VisibilityListener var1) {
      if(this.mVisibilityListener != null && var1 != null) {
         Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + this.getClass().getSimpleName() + " instance while it is still in use somewhere else?");
      }

      this.mVisibilityListener = var1;
   }

   public void subUiVisibilityChanged(boolean var1) {
      if(this.mSubUiVisibilityListener != null) {
         this.mSubUiVisibilityListener.onSubUiVisibilityChanged(var1);
      }

   }

   public interface SubUiVisibilityListener {
      void onSubUiVisibilityChanged(boolean var1);
   }

   public interface VisibilityListener {
      void onActionProviderVisibilityChanged(boolean var1);
   }
}
