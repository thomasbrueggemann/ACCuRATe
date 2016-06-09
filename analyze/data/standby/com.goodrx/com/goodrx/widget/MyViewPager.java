package com.goodrx.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class MyViewPager extends ViewPager {
   public MyViewPager(Context var1) {
      super(var1);
   }

   public MyViewPager(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   protected void onMeasure(int var1, int var2) {
      int var3 = 0;

      for(int var4 = 0; var4 < this.getChildCount(); ++var4) {
         View var5 = this.getChildAt(var4);
         var5.measure(var1, MeasureSpec.makeMeasureSpec(0, 0));
         int var6 = var5.getMeasuredHeight();
         if(var6 > var3) {
            var3 = var6;
         }
      }

      super.onMeasure(var1, MeasureSpec.makeMeasureSpec(var3, 1073741824));
   }
}
