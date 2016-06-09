package com.robotium.solo;

import android.content.Context;
import android.widget.TextView;

class RobotiumTextView extends TextView {
   private int locationX = 0;
   private int locationY = 0;

   public RobotiumTextView(Context var1) {
      super(var1);
   }

   public RobotiumTextView(Context var1, String var2, int var3, int var4) {
      super(var1);
      this.setText(var2);
      this.setLocationX(var3);
      this.setLocationY(var4);
   }

   public void getLocationOnScreen(int[] var1) {
      var1[0] = this.locationX;
      var1[1] = this.locationY;
   }

   public void setLocationX(int var1) {
      this.locationX = var1;
   }

   public void setLocationY(int var1) {
      this.locationY = var1;
   }
}
