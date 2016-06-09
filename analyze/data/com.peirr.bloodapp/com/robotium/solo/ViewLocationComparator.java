package com.robotium.solo;

import android.view.View;
import java.util.Comparator;

class ViewLocationComparator implements Comparator<View> {
   // $FF: renamed from: a int[]
   private final int[] field_12;
   private final int axis1;
   private final int axis2;
   // $FF: renamed from: b int[]
   private final int[] field_13;

   public ViewLocationComparator() {
      this(true);
   }

   public ViewLocationComparator(boolean var1) {
      this.field_12 = new int[2];
      this.field_13 = new int[2];
      byte var2;
      if(var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.axis1 = var2;
      byte var3 = 0;
      if(!var1) {
         var3 = 1;
      }

      this.axis2 = var3;
   }

   public int compare(View var1, View var2) {
      byte var3 = 1;
      var1.getLocationOnScreen(this.field_12);
      var2.getLocationOnScreen(this.field_13);
      if(this.field_12[this.axis1] != this.field_13[this.axis1]) {
         if(this.field_12[this.axis1] >= this.field_13[this.axis1]) {
            return var3;
         }
      } else if(this.field_12[this.axis2] >= this.field_13[this.axis2]) {
         if(this.field_12[this.axis2] == this.field_13[this.axis2]) {
            var3 = 0;
         }

         return var3;
      }

      return -1;
   }
}
