package android.support.v7.app;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivityDelegateJB;
import android.support.v7.app.ActionBarImplJBMR2;

class ActionBarActivityDelegateJBMR2 extends ActionBarActivityDelegateJB {
   ActionBarActivityDelegateJBMR2(ActionBarActivity var1) {
      super(var1);
   }

   public ActionBar createSupportActionBar() {
      return new ActionBarImplJBMR2(this.mActivity, this.mActivity);
   }
}
