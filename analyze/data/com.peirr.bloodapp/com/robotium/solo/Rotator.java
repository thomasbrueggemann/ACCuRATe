package com.robotium.solo;

import android.app.Instrumentation;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;

class Rotator {
   private static final int EVENT_TIME_INTERVAL_MS = 10;
   public static final int LARGE = 0;
   public static final int SMALL = 1;
   private final Instrumentation _instrument;

   public Rotator(Instrumentation var1) {
      this._instrument = var1;
   }

   public void generateRotateGesture(int var1, PointF var2, PointF var3) {
      double var4 = 0.0D;
      float var6 = var2.x;
      float var7 = var2.y;
      float var8 = var3.x;
      float var9 = var3.y;
      long var10 = SystemClock.uptimeMillis();
      long var12 = SystemClock.uptimeMillis();
      PointerCoords[] var14 = new PointerCoords[2];
      PointerCoords var15 = new PointerCoords();
      PointerCoords var16 = new PointerCoords();
      var15.x = var6;
      var15.y = var7;
      var15.pressure = 1.0F;
      var15.size = 1.0F;
      var16.x = var8;
      var16.y = var9;
      var16.pressure = 1.0F;
      var16.size = 1.0F;
      var14[0] = var15;
      var14[1] = var16;
      PointerProperties[] var17 = new PointerProperties[2];
      PointerProperties var18 = new PointerProperties();
      PointerProperties var19 = new PointerProperties();
      var18.id = 0;
      var18.toolType = 1;
      var19.id = 1;
      var19.toolType = 1;
      var17[0] = var18;
      var17[1] = var19;
      MotionEvent var20 = MotionEvent.obtain(var10, var12, 0, 1, var17, var14, 0, 0, 1.0F, 1.0F, 0, 0, 4098, 0);
      this._instrument.sendPointerSync(var20);
      MotionEvent var21 = MotionEvent.obtain(var10, var12, 5 + (var19.id << 8), 2, var17, var14, 0, 0, 1.0F, 1.0F, 0, 0, 4098, 0);
      this._instrument.sendPointerSync(var21);
      switch(var1) {
      case 0:
         var4 = 0.01D;
         break;
      case 1:
         var4 = 0.1D;
      }

      for(double var22 = 0.0D; var22 < 3.141592653589793D; var22 += var4) {
         var12 += 10L;
         PointerCoords var28 = var14[0];
         var28.x = (float)((double)var28.x + Math.cos(var22));
         PointerCoords var29 = var14[0];
         var29.y = (float)((double)var29.y + Math.sin(var22));
         PointerCoords var30 = var14[1];
         var30.x = (float)((double)var30.x + Math.cos(3.141592653589793D + var22));
         PointerCoords var31 = var14[1];
         var31.y = (float)((double)var31.y + Math.sin(3.141592653589793D + var22));
         MotionEvent var32 = MotionEvent.obtain(var10, var12, 2, 2, var17, var14, 0, 0, 1.0F, 1.0F, 0, 0, 4098, 0);
         this._instrument.sendPointerSync(var32);
      }

      long var24 = var12 + 10L;
      MotionEvent var26 = MotionEvent.obtain(var10, var24, 6 + (var19.id << 8), 2, var17, var14, 0, 0, 1.0F, 1.0F, 0, 0, 4098, 0);
      this._instrument.sendPointerSync(var26);
      MotionEvent var27 = MotionEvent.obtain(var10, var24 + 10L, 1, 1, var17, var14, 0, 0, 1.0F, 1.0F, 0, 0, 4098, 0);
      this._instrument.sendPointerSync(var27);
   }
}
