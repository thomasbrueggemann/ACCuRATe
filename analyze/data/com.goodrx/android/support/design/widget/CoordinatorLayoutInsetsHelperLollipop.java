package android.support.design.widget;

import android.support.design.widget.CoordinatorLayoutInsetsHelper;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.view.View;

class CoordinatorLayoutInsetsHelperLollipop implements CoordinatorLayoutInsetsHelper {
   public void setupForWindowInsets(View var1, OnApplyWindowInsetsListener var2) {
      if(ViewCompat.getFitsSystemWindows(var1)) {
         ViewCompat.setOnApplyWindowInsetsListener(var1, var2);
         var1.setSystemUiVisibility(1280);
      }

   }
}
