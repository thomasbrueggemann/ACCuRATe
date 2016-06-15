package android.support.v4.widget;

import android.support.v4.widget.AutoScrollHelper;
import android.view.View;
import android.widget.ListView;

public class ListViewAutoScrollHelper extends AutoScrollHelper {
   private final ListView mTarget;

   public ListViewAutoScrollHelper(ListView var1) {
      super(var1);
      this.mTarget = var1;
   }

   public boolean canTargetScrollHorizontally(int var1) {
      return false;
   }

   public boolean canTargetScrollVertically(int var1) {
      ListView var2 = this.mTarget;
      int var3 = var2.getCount();
      if(var3 != 0) {
         int var4 = var2.getChildCount();
         int var5 = var2.getFirstVisiblePosition();
         int var6 = var5 + var4;
         if(var1 > 0) {
            if(var6 >= var3 && var2.getChildAt(var4 - 1).getBottom() <= var2.getHeight()) {
               return false;
            }
         } else {
            if(var1 >= 0) {
               return false;
            }

            if(var5 <= 0 && var2.getChildAt(0).getTop() >= 0) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public void scrollTargetBy(int var1, int var2) {
      ListView var3 = this.mTarget;
      int var4 = var3.getFirstVisiblePosition();
      if(var4 != -1) {
         View var5 = var3.getChildAt(0);
         if(var5 != null) {
            var3.setSelectionFromTop(var4, var5.getTop() - var2);
            return;
         }
      }

   }
}
