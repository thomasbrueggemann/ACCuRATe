package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

class ViewGroupUtilsHoneycomb {
   private static final Matrix IDENTITY = new Matrix();
   private static final ThreadLocal<Matrix> sMatrix = new ThreadLocal();
   private static final ThreadLocal<RectF> sRectF = new ThreadLocal();

   static void offsetDescendantMatrix(ViewParent var0, View var1, Matrix var2) {
      ViewParent var3 = var1.getParent();
      if(var3 instanceof View && var3 != var0) {
         View var6 = (View)var3;
         offsetDescendantMatrix(var0, var6, var2);
         var2.preTranslate((float)(-var6.getScrollX()), (float)(-var6.getScrollY()));
      }

      var2.preTranslate((float)var1.getLeft(), (float)var1.getTop());
      if(!var1.getMatrix().isIdentity()) {
         var2.preConcat(var1.getMatrix());
      }

   }

   public static void offsetDescendantRect(ViewGroup var0, View var1, Rect var2) {
      Matrix var3 = (Matrix)sMatrix.get();
      if(var3 == null) {
         var3 = new Matrix();
         sMatrix.set(var3);
      } else {
         var3.set(IDENTITY);
      }

      offsetDescendantMatrix(var0, var1, var3);
      RectF var4 = (RectF)sRectF.get();
      if(var4 == null) {
         var4 = new RectF();
      }

      var4.set(var2);
      var3.mapRect(var4);
      var2.set((int)(0.5F + var4.left), (int)(0.5F + var4.top), (int)(0.5F + var4.right), (int)(0.5F + var4.bottom));
   }
}
