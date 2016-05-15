package android.support.v7.app;

import android.content.Context;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegateImplV14;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class AppCompatDelegateImplV23 extends AppCompatDelegateImplV14 {
   AppCompatDelegateImplV23(Context var1, Window var2, AppCompatCallback var3) {
      super(var1, var2, var3);
   }

   Callback wrapWindowCallback(Callback var1) {
      return new AppCompatDelegateImplV23.AppCompatWindowCallbackV23(var1);
   }

   class AppCompatWindowCallbackV23 extends AppCompatDelegateImplV14.AppCompatWindowCallbackV14 {
      AppCompatWindowCallbackV23(Callback var2) {
         super();
      }

      public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback var1) {
         return null;
      }

      public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback var1, int var2) {
         if(AppCompatDelegateImplV23.this.isHandleNativeActionModesEnabled()) {
            switch(var2) {
            case 0:
               return this.startAsSupportActionMode(var1);
            }
         }

         return super.onWindowStartingActionMode(var1, var2);
      }
   }
}
