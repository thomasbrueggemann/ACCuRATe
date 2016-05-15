package android.support.v7.widget;

import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class ScrollbarHelper {
   static int computeScrollExtent(RecyclerView.State var0, OrientationHelper var1, View var2, View var3, RecyclerView.LayoutManager var4, boolean var5) {
      if(var4.getChildCount() != 0 && var0.getItemCount() != 0 && var2 != null && var3 != null) {
         if(!var5) {
            return 1 + Math.abs(var4.getPosition(var2) - var4.getPosition(var3));
         } else {
            int var6 = var1.getDecoratedEnd(var3) - var1.getDecoratedStart(var2);
            return Math.min(var1.getTotalSpace(), var6);
         }
      } else {
         return 0;
      }
   }

   static int computeScrollOffset(RecyclerView.State var0, OrientationHelper var1, View var2, View var3, RecyclerView.LayoutManager var4, boolean var5, boolean var6) {
      int var7 = var4.getChildCount();
      int var8 = 0;
      if(var7 != 0) {
         int var9 = var0.getItemCount();
         var8 = 0;
         if(var9 != 0) {
            var8 = 0;
            if(var2 != null) {
               var8 = 0;
               if(var3 != null) {
                  int var10 = Math.min(var4.getPosition(var2), var4.getPosition(var3));
                  int var11 = Math.max(var4.getPosition(var2), var4.getPosition(var3));
                  if(var6) {
                     var8 = Math.max(0, -1 + (var0.getItemCount() - var11));
                  } else {
                     var8 = Math.max(0, var10);
                  }

                  if(var5) {
                     int var12 = Math.abs(var1.getDecoratedEnd(var3) - var1.getDecoratedStart(var2));
                     int var13 = 1 + Math.abs(var4.getPosition(var2) - var4.getPosition(var3));
                     return Math.round((float)var12 / (float)var13 * (float)var8 + (float)(var1.getStartAfterPadding() - var1.getDecoratedStart(var2)));
                  }
               }
            }
         }
      }

      return var8;
   }

   static int computeScrollRange(RecyclerView.State var0, OrientationHelper var1, View var2, View var3, RecyclerView.LayoutManager var4, boolean var5) {
      if(var4.getChildCount() != 0 && var0.getItemCount() != 0 && var2 != null && var3 != null) {
         if(!var5) {
            return var0.getItemCount();
         } else {
            int var6 = var1.getDecoratedEnd(var3) - var1.getDecoratedStart(var2);
            int var7 = 1 + Math.abs(var4.getPosition(var2) - var4.getPosition(var3));
            return (int)((float)var6 / (float)var7 * (float)var0.getItemCount());
         }
      } else {
         return 0;
      }
   }
}
