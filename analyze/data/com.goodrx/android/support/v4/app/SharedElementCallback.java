package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;
import java.util.Map;

public abstract class SharedElementCallback {
   private static final String BUNDLE_SNAPSHOT_BITMAP = "sharedElement:snapshot:bitmap";
   private static final String BUNDLE_SNAPSHOT_IMAGE_MATRIX = "sharedElement:snapshot:imageMatrix";
   private static final String BUNDLE_SNAPSHOT_IMAGE_SCALETYPE = "sharedElement:snapshot:imageScaleType";
   private static int MAX_IMAGE_SIZE = 1048576;
   private Matrix mTempMatrix;

   private static Bitmap createDrawableBitmap(Drawable var0) {
      int var1 = var0.getIntrinsicWidth();
      int var2 = var0.getIntrinsicHeight();
      if(var1 > 0 && var2 > 0) {
         float var3 = Math.min(1.0F, (float)MAX_IMAGE_SIZE / (float)(var1 * var2));
         if(var0 instanceof BitmapDrawable && var3 == 1.0F) {
            return ((BitmapDrawable)var0).getBitmap();
         } else {
            int var4 = (int)(var3 * (float)var1);
            int var5 = (int)(var3 * (float)var2);
            Bitmap var6 = Bitmap.createBitmap(var4, var5, Config.ARGB_8888);
            Canvas var7 = new Canvas(var6);
            Rect var8 = var0.getBounds();
            int var9 = var8.left;
            int var10 = var8.top;
            int var11 = var8.right;
            int var12 = var8.bottom;
            var0.setBounds(0, 0, var4, var5);
            var0.draw(var7);
            var0.setBounds(var9, var10, var11, var12);
            return var6;
         }
      } else {
         return null;
      }
   }

   public Parcelable onCaptureSharedElementSnapshot(View var1, Matrix var2, RectF var3) {
      if(var1 instanceof ImageView) {
         ImageView var13 = (ImageView)var1;
         Drawable var14 = var13.getDrawable();
         Drawable var15 = var13.getBackground();
         if(var14 != null && var15 == null) {
            Bitmap var16 = createDrawableBitmap(var14);
            if(var16 != null) {
               Bundle var17 = new Bundle();
               var17.putParcelable("sharedElement:snapshot:bitmap", var16);
               var17.putString("sharedElement:snapshot:imageScaleType", var13.getScaleType().toString());
               if(var13.getScaleType() == ScaleType.MATRIX) {
                  Matrix var18 = var13.getImageMatrix();
                  float[] var19 = new float[9];
                  var18.getValues(var19);
                  var17.putFloatArray("sharedElement:snapshot:imageMatrix", var19);
               }

               return var17;
            }
         }
      }

      int var4 = Math.round(var3.width());
      int var5 = Math.round(var3.height());
      Bitmap var6 = null;
      if(var4 > 0) {
         var6 = null;
         if(var5 > 0) {
            float var7 = Math.min(1.0F, (float)MAX_IMAGE_SIZE / (float)(var4 * var5));
            int var8 = (int)(var7 * (float)var4);
            int var9 = (int)(var7 * (float)var5);
            if(this.mTempMatrix == null) {
               this.mTempMatrix = new Matrix();
            }

            this.mTempMatrix.set(var2);
            this.mTempMatrix.postTranslate(-var3.left, -var3.top);
            this.mTempMatrix.postScale(var7, var7);
            var6 = Bitmap.createBitmap(var8, var9, Config.ARGB_8888);
            Canvas var12 = new Canvas(var6);
            var12.concat(this.mTempMatrix);
            var1.draw(var12);
         }
      }

      return var6;
   }

   public View onCreateSnapshotView(Context var1, Parcelable var2) {
      ImageView var4;
      if(var2 instanceof Bundle) {
         Bundle var6 = (Bundle)var2;
         Bitmap var7 = (Bitmap)var6.getParcelable("sharedElement:snapshot:bitmap");
         if(var7 == null) {
            return null;
         }

         ImageView var8 = new ImageView(var1);
         var4 = var8;
         var8.setImageBitmap(var7);
         var8.setScaleType(ScaleType.valueOf(var6.getString("sharedElement:snapshot:imageScaleType")));
         if(var8.getScaleType() == ScaleType.MATRIX) {
            float[] var9 = var6.getFloatArray("sharedElement:snapshot:imageMatrix");
            Matrix var10 = new Matrix();
            var10.setValues(var9);
            var8.setImageMatrix(var10);
         }
      } else {
         boolean var3 = var2 instanceof Bitmap;
         var4 = null;
         if(var3) {
            Bitmap var5 = (Bitmap)var2;
            var4 = new ImageView(var1);
            var4.setImageBitmap(var5);
         }
      }

      return var4;
   }

   public void onMapSharedElements(List<String> var1, Map<String, View> var2) {
   }

   public void onRejectSharedElements(List<View> var1) {
   }

   public void onSharedElementEnd(List<String> var1, List<View> var2, List<View> var3) {
   }

   public void onSharedElementStart(List<String> var1, List<View> var2, List<View> var3) {
   }
}
