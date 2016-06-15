package android.support.v7.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarImplJB;

public class ActionBarImplJBMR2 extends ActionBarImplJB {
   public ActionBarImplJBMR2(Activity var1, ActionBar.Callback var2) {
      super(var1, var2);
   }

   public void setHomeActionContentDescription(int var1) {
      this.mActionBar.setHomeActionContentDescription(var1);
   }

   public void setHomeActionContentDescription(CharSequence var1) {
      this.mActionBar.setHomeActionContentDescription(var1);
   }

   public void setHomeAsUpIndicator(int var1) {
      this.mActionBar.setHomeAsUpIndicator(var1);
   }

   public void setHomeAsUpIndicator(Drawable var1) {
      this.mActionBar.setHomeAsUpIndicator(var1);
   }
}
