package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.class_51;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchUIUtil;
import android.view.View;

class ItemTouchUIUtilImpl {
   static class Gingerbread implements ItemTouchUIUtil {
      private void draw(Canvas var1, RecyclerView var2, View var3, float var4, float var5) {
         var1.save();
         var1.translate(var4, var5);
         var2.drawChild(var1, var3, 0L);
         var1.restore();
      }

      public void clearView(View var1) {
         var1.setVisibility(0);
      }

      public void onDraw(Canvas var1, RecyclerView var2, View var3, float var4, float var5, int var6, boolean var7) {
         if(var6 != 2) {
            this.draw(var1, var2, var3, var4, var5);
         }

      }

      public void onDrawOver(Canvas var1, RecyclerView var2, View var3, float var4, float var5, int var6, boolean var7) {
         if(var6 == 2) {
            this.draw(var1, var2, var3, var4, var5);
         }

      }

      public void onSelected(View var1) {
         var1.setVisibility(4);
      }
   }

   static class Honeycomb implements ItemTouchUIUtil {
      public void clearView(View var1) {
         ViewCompat.setTranslationX(var1, 0.0F);
         ViewCompat.setTranslationY(var1, 0.0F);
      }

      public void onDraw(Canvas var1, RecyclerView var2, View var3, float var4, float var5, int var6, boolean var7) {
         ViewCompat.setTranslationX(var3, var4);
         ViewCompat.setTranslationY(var3, var5);
      }

      public void onDrawOver(Canvas var1, RecyclerView var2, View var3, float var4, float var5, int var6, boolean var7) {
      }

      public void onSelected(View var1) {
      }
   }

   static class Lollipop extends ItemTouchUIUtilImpl.Honeycomb {
      private float findMaxElevation(RecyclerView var1, View var2) {
         int var3 = var1.getChildCount();
         float var4 = 0.0F;

         for(int var5 = 0; var5 < var3; ++var5) {
            View var6 = var1.getChildAt(var5);
            if(var6 != var2) {
               float var7 = ViewCompat.getElevation(var6);
               if(var7 > var4) {
                  var4 = var7;
               }
            }
         }

         return var4;
      }

      public void clearView(View var1) {
         Object var2 = var1.getTag(class_51.class_105.item_touch_helper_previous_elevation);
         if(var2 != null && var2 instanceof Float) {
            ViewCompat.setElevation(var1, ((Float)var2).floatValue());
         }

         var1.setTag(class_51.class_105.item_touch_helper_previous_elevation, (Object)null);
         super.clearView(var1);
      }

      public void onDraw(Canvas var1, RecyclerView var2, View var3, float var4, float var5, int var6, boolean var7) {
         if(var7 && var3.getTag(class_51.class_105.item_touch_helper_previous_elevation) == null) {
            Float var8 = Float.valueOf(ViewCompat.getElevation(var3));
            ViewCompat.setElevation(var3, 1.0F + this.findMaxElevation(var2, var3));
            var3.setTag(class_51.class_105.item_touch_helper_previous_elevation, var8);
         }

         super.onDraw(var1, var2, var3, var4, var5, var6, var7);
      }
   }
}
