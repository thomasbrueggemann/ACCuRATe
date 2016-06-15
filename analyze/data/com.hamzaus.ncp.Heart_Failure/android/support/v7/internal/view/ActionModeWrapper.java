package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ActionMode.Callback;

public class ActionModeWrapper extends ActionMode {
   final MenuInflater mInflater;
   final android.view.ActionMode mWrappedObject;

   public ActionModeWrapper(Context var1, android.view.ActionMode var2) {
      this.mWrappedObject = var2;
      this.mInflater = new SupportMenuInflater(var1);
   }

   public void finish() {
      this.mWrappedObject.finish();
   }

   public View getCustomView() {
      return this.mWrappedObject.getCustomView();
   }

   public Menu getMenu() {
      return MenuWrapperFactory.createMenuWrapper(this.mWrappedObject.getMenu());
   }

   public MenuInflater getMenuInflater() {
      return this.mInflater;
   }

   public CharSequence getSubtitle() {
      return this.mWrappedObject.getSubtitle();
   }

   public Object getTag() {
      return this.mWrappedObject.getTag();
   }

   public CharSequence getTitle() {
      return this.mWrappedObject.getTitle();
   }

   public void invalidate() {
      this.mWrappedObject.invalidate();
   }

   public void setCustomView(View var1) {
      this.mWrappedObject.setCustomView(var1);
   }

   public void setSubtitle(int var1) {
      this.mWrappedObject.setSubtitle(var1);
   }

   public void setSubtitle(CharSequence var1) {
      this.mWrappedObject.setSubtitle(var1);
   }

   public void setTag(Object var1) {
      this.mWrappedObject.setTag(var1);
   }

   public void setTitle(int var1) {
      this.mWrappedObject.setTitle(var1);
   }

   public void setTitle(CharSequence var1) {
      this.mWrappedObject.setTitle(var1);
   }

   public static class CallbackWrapper implements Callback {
      final Context mContext;
      private ActionModeWrapper mLastStartedActionMode;
      final ActionMode.Callback mWrappedCallback;

      public CallbackWrapper(Context var1, ActionMode.Callback var2) {
         this.mContext = var1;
         this.mWrappedCallback = var2;
      }

      private ActionMode getActionModeWrapper(android.view.ActionMode var1) {
         return this.mLastStartedActionMode != null && this.mLastStartedActionMode.mWrappedObject == var1?this.mLastStartedActionMode:this.createActionModeWrapper(this.mContext, var1);
      }

      protected ActionModeWrapper createActionModeWrapper(Context var1, android.view.ActionMode var2) {
         return new ActionModeWrapper(var1, var2);
      }

      public boolean onActionItemClicked(android.view.ActionMode var1, MenuItem var2) {
         return this.mWrappedCallback.onActionItemClicked(this.getActionModeWrapper(var1), MenuWrapperFactory.createMenuItemWrapper(var2));
      }

      public boolean onCreateActionMode(android.view.ActionMode var1, Menu var2) {
         return this.mWrappedCallback.onCreateActionMode(this.getActionModeWrapper(var1), MenuWrapperFactory.createMenuWrapper(var2));
      }

      public void onDestroyActionMode(android.view.ActionMode var1) {
         this.mWrappedCallback.onDestroyActionMode(this.getActionModeWrapper(var1));
      }

      public boolean onPrepareActionMode(android.view.ActionMode var1, Menu var2) {
         return this.mWrappedCallback.onPrepareActionMode(this.getActionModeWrapper(var1), MenuWrapperFactory.createMenuWrapper(var2));
      }

      public void setLastStartedActionMode(ActionModeWrapper var1) {
         this.mLastStartedActionMode = var1;
      }
   }
}
