package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class AppCompatProgressBarHelper {
   private static final int[] TINT_ATTRS = new int[]{16843067, 16843068};
   final AppCompatDrawableManager mDrawableManager;
   private Bitmap mSampleTile;
   private final ProgressBar mView;

   AppCompatProgressBarHelper(ProgressBar var1, AppCompatDrawableManager var2) {
      this.mView = var1;
      this.mDrawableManager = var2;
   }

   private Shape getDrawableShape() {
      return new RoundRectShape(new float[]{5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F}, (RectF)null, (float[])null);
   }

   private Drawable tileify(Drawable var1, boolean var2) {
      Object var9;
      if(var1 instanceof DrawableWrapper) {
         Drawable var18 = ((DrawableWrapper)var1).getWrappedDrawable();
         if(var18 != null) {
            Drawable var19 = this.tileify(var18, var2);
            ((DrawableWrapper)var1).setWrappedDrawable(var19);
         }
      } else {
         if(var1 instanceof LayerDrawable) {
            LayerDrawable var10 = (LayerDrawable)var1;
            int var11 = var10.getNumberOfLayers();
            Drawable[] var12 = new Drawable[var11];

            for(int var13 = 0; var13 < var11; ++var13) {
               int var15 = var10.getId(var13);
               Drawable var16 = var10.getDrawable(var13);
               boolean var17;
               if(var15 != 16908301 && var15 != 16908303) {
                  var17 = false;
               } else {
                  var17 = true;
               }

               var12[var13] = this.tileify(var16, var17);
            }

            var9 = new LayerDrawable(var12);

            for(int var14 = 0; var14 < var11; ++var14) {
               ((LayerDrawable)var9).setId(var14, var10.getId(var14));
            }

            return (Drawable)var9;
         }

         if(var1 instanceof BitmapDrawable) {
            BitmapDrawable var3 = (BitmapDrawable)var1;
            Bitmap var4 = var3.getBitmap();
            if(this.mSampleTile == null) {
               this.mSampleTile = var4;
            }

            Object var5 = new ShapeDrawable(this.getDrawableShape());
            BitmapShader var6 = new BitmapShader(var4, TileMode.REPEAT, TileMode.CLAMP);
            ((ShapeDrawable)var5).getPaint().setShader(var6);
            ((ShapeDrawable)var5).getPaint().setColorFilter(var3.getPaint().getColorFilter());
            if(var2) {
               var5 = new ClipDrawable((Drawable)var5, 3, 1);
            }

            return (Drawable)var5;
         }
      }

      var9 = var1;
      return (Drawable)var9;
   }

   private Drawable tileifyIndeterminate(Drawable var1) {
      if(var1 instanceof AnimationDrawable) {
         AnimationDrawable var2 = (AnimationDrawable)var1;
         int var3 = var2.getNumberOfFrames();
         AnimationDrawable var4 = new AnimationDrawable();
         var4.setOneShot(var2.isOneShot());

         for(int var5 = 0; var5 < var3; ++var5) {
            Drawable var7 = this.tileify(var2.getFrame(var5), true);
            var7.setLevel(10000);
            var4.addFrame(var7, var2.getDuration(var5));
         }

         var4.setLevel(10000);
         var1 = var4;
      }

      return (Drawable)var1;
   }

   Bitmap getSampleTime() {
      return this.mSampleTile;
   }

   void loadFromAttributes(AttributeSet var1, int var2) {
      TintTypedArray var3 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), var1, TINT_ATTRS, var2, 0);
      Drawable var4 = var3.getDrawableIfKnown(0);
      if(var4 != null) {
         this.mView.setIndeterminateDrawable(this.tileifyIndeterminate(var4));
      }

      Drawable var5 = var3.getDrawableIfKnown(1);
      if(var5 != null) {
         this.mView.setProgressDrawable(this.tileify(var5, false));
      }

      var3.recycle();
   }
}
