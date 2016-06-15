package android.support.v7.app;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivityDelegateICS;
import android.support.v7.app.ActionBarImplJB;
import android.support.v7.internal.view.ActionModeWrapper;
import android.support.v7.internal.view.ActionModeWrapperJB;
import android.support.v7.view.ActionMode;

class ActionBarActivityDelegateJB extends ActionBarActivityDelegateICS {
   ActionBarActivityDelegateJB(ActionBarActivity var1) {
      super(var1);
   }

   ActionModeWrapper.CallbackWrapper createActionModeCallbackWrapper(Context var1, ActionMode.Callback var2) {
      return new ActionModeWrapperJB.CallbackWrapper(var1, var2);
   }

   ActionModeWrapper createActionModeWrapper(Context var1, android.view.ActionMode var2) {
      return new ActionModeWrapperJB(var1, var2);
   }

   public ActionBar createSupportActionBar() {
      return new ActionBarImplJB(this.mActivity, this.mActivity);
   }
}
