package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.widget.CompoundButton;

class CompoundButtonCompatLollipop {
   static ColorStateList getButtonTintList(CompoundButton var0) {
      return var0.getButtonTintList();
   }

   static Mode getButtonTintMode(CompoundButton var0) {
      return var0.getButtonTintMode();
   }

   static void setButtonTintList(CompoundButton var0, ColorStateList var1) {
      var0.setButtonTintList(var1);
   }

   static void setButtonTintMode(CompoundButton var0, Mode var1) {
      var0.setButtonTintMode(var1);
   }
}
