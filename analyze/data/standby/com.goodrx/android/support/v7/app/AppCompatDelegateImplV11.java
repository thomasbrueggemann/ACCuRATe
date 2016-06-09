package android.support.v7.app;

import android.content.Context;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegateImplV7;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;

class AppCompatDelegateImplV11 extends AppCompatDelegateImplV7 {
   AppCompatDelegateImplV11(Context var1, Window var2, AppCompatCallback var3) {
      super(var1, var2, var3);
   }

   View callActivityOnCreateView(View var1, String var2, Context var3, AttributeSet var4) {
      return null;
   }
}
