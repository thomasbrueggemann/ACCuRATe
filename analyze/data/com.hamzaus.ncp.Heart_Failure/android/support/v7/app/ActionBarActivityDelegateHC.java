package android.support.v7.app;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivityDelegateBase;
import android.support.v7.app.ActionBarImplHC;

class ActionBarActivityDelegateHC extends ActionBarActivityDelegateBase {
   ActionBarActivityDelegateHC(ActionBarActivity var1) {
      super(var1);
   }

   public ActionBar createSupportActionBar() {
      this.ensureSubDecor();
      return new ActionBarImplHC(this.mActivity, this.mActivity);
   }
}
