package com.robotium.solo;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.view.View;
import com.robotium.solo.Reflect;
import java.nio.IntBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class GLRenderWrapper implements Renderer {
   private int glVersion;
   private int height;
   private CountDownLatch latch;
   private Renderer renderer;
   private boolean takeScreenshot = true;
   private final GLSurfaceView view;
   private int width;

   public GLRenderWrapper(GLSurfaceView var1, Renderer var2, CountDownLatch var3) {
      this.view = var1;
      this.renderer = var2;
      this.latch = var3;
      this.width = var1.getWidth();
      this.height = var1.getHeight();
      Integer var4 = (Integer)(new Reflect(var1)).field("mEGLContextClientVersion").out(Integer.class);
      if(var4 != null) {
         this.glVersion = var4.intValue();
      } else {
         this.glVersion = -1;
         this.takeScreenshot = false;
      }
   }

   private Bitmap savePixels(int var1, int var2, int var3, int var4) {
      int[] var5 = new int[var3 * (var2 + var4)];
      int[] var6 = new int[var3 * var4];
      IntBuffer var7 = IntBuffer.wrap(var5);
      var7.position(0);
      GLES20.glReadPixels(var1, 0, var3, var2 + var4, 6408, 5121, var7);
      int var9 = 0;

      for(int var10 = 0; var9 < var4; ++var10) {
         for(int var11 = 0; var11 < var3; ++var11) {
            int var12 = var5[var11 + var9 * var3];
            int var13 = 255 & var12 >> 16 | 16711680 & var12 << 16 | -16711936 & var12;
            var6[var11 + var3 * (-1 + (var4 - var10))] = var13;
         }

         ++var9;
      }

      return Bitmap.createBitmap(var6, var3, var4, Config.ARGB_8888);
   }

   private static Bitmap savePixels(int var0, int var1, int var2, int var3, GL10 var4) {
      int[] var5 = new int[var2 * (var1 + var3)];
      int[] var6 = new int[var2 * var3];
      IntBuffer var7 = IntBuffer.wrap(var5);
      var7.position(0);
      var4.glReadPixels(var0, 0, var2, var1 + var3, 6408, 5121, var7);
      int var9 = 0;

      for(int var10 = 0; var9 < var3; ++var10) {
         for(int var11 = 0; var11 < var2; ++var11) {
            int var12 = var5[var11 + var9 * var2];
            int var13 = 255 & var12 >> 16 | 16711680 & var12 << 16 | -16711936 & var12;
            var6[var11 + var2 * (-1 + (var3 - var10))] = var13;
         }

         ++var9;
      }

      return Bitmap.createBitmap(var6, var2, var3, Config.ARGB_8888);
   }

   public void onDrawFrame(GL10 var1) {
      this.renderer.onDrawFrame(var1);
      if(this.takeScreenshot) {
         Bitmap var2;
         if(this.glVersion >= 2) {
            var2 = this.savePixels(0, 0, this.width, this.height);
         } else {
            var2 = savePixels(0, 0, this.width, this.height, var1);
         }

         (new Reflect(this.view)).field("mDrawingCache").type(View.class).method_6(var2);
         this.latch.countDown();
         this.takeScreenshot = false;
      }

   }

   public void onSurfaceChanged(GL10 var1, int var2, int var3) {
      this.width = var2;
      this.height = var3;
      this.renderer.onSurfaceChanged(var1, var2, var3);
   }

   public void onSurfaceCreated(GL10 var1, EGLConfig var2) {
      this.renderer.onSurfaceCreated(var1, var2);
   }

   public void setLatch(CountDownLatch var1) {
      this.latch = var1;
   }

   public void setTakeScreenshot() {
      this.takeScreenshot = true;
   }
}
