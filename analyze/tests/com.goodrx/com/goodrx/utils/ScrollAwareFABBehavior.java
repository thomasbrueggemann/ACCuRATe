package com.goodrx.utils;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {
   public ScrollAwareFABBehavior(Context var1, AttributeSet var2) {
   }

   public void onNestedScroll(CoordinatorLayout var1, FloatingActionButton var2, View var3, int var4, int var5, int var6, int var7) {
      super.onNestedScroll(var1, var2, var3, var4, var5, var6, var7);
      if(var5 > 0 && var2.getVisibility() == 0) {
         var2.hide();
      } else if(var5 < 0 && var2.isEnabled() && var2.getVisibility() != 0) {
         var2.show();
         return;
      }

   }

   public boolean onStartNestedScroll(CoordinatorLayout var1, FloatingActionButton var2, View var3, View var4, int var5) {
      return var5 == 2 || super.onStartNestedScroll(var1, var2, var3, var4, var5);
   }
}
