package android.support.v7.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivityDelegateICS;
import android.support.v7.app.ActionBarActivityDelegateJBMR2;
import android.view.Window.Callback;

class ActionBarActivityDelegateApi20 extends ActionBarActivityDelegateJBMR2 {
   ActionBarActivityDelegateApi20(ActionBarActivity var1) {
      super(var1);
   }

   Callback createWindowCallbackWrapper(Callback var1) {
      return new ActionBarActivityDelegateApi20.WindowCallbackWrapperApi20(var1);
   }

   class WindowCallbackWrapperApi20 extends ActionBarActivityDelegateICS.WindowCallbackWrapper {
      WindowCallbackWrapperApi20(Callback var2) {
         super();
      }
   }
}
