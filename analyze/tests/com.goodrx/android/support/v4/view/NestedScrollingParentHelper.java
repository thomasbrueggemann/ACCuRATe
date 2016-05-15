package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

public class NestedScrollingParentHelper {
   private int mNestedScrollAxes;
   private final ViewGroup mViewGroup;

   public NestedScrollingParentHelper(ViewGroup var1) {
      this.mViewGroup = var1;
   }

   public int getNestedScrollAxes() {
      return this.mNestedScrollAxes;
   }

   public void onNestedScrollAccepted(View var1, View var2, int var3) {
      this.mNestedScrollAxes = var3;
   }

   public void onStopNestedScroll(View var1) {
      this.mNestedScrollAxes = 0;
   }
}
