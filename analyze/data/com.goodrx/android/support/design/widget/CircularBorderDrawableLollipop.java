package android.support.design.widget;

import android.graphics.Outline;
import android.support.design.widget.CircularBorderDrawable;

class CircularBorderDrawableLollipop extends CircularBorderDrawable {
   public void getOutline(Outline var1) {
      this.copyBounds(this.mRect);
      var1.setOval(this.mRect);
   }
}
