package com.robotium.solo;

import android.app.Instrumentation;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;

class Swiper {
   public static final int EVENT_TIME_INTERVAL_MS = 10;
   public static final int GESTURE_DURATION_MS = 1000;
   private final Instrumentation _instrument;

   public Swiper(Instrumentation var1) {
      this._instrument = var1;
   }

   public void generateSwipeGesture(PointF var1, PointF var2, PointF var3, PointF var4) {
      long var5 = SystemClock.uptimeMillis();
      long var7 = SystemClock.uptimeMillis();
      float var9 = var1.x;
      float var10 = var1.y;
      float var11 = var2.x;
      float var12 = var2.y;
      float var13 = var3.x;
      float var14 = var3.y;
      float var15 = var4.x;
      float var16 = var4.y;
      PointerCoords[] var17 = new PointerCoords[2];
      PointerCoords var18 = new PointerCoords();
      PointerCoords var19 = new PointerCoords();
      var18.x = var9;
      var18.y = var10;
      var18.pressure = 1.0F;
      var18.size = 1.0F;
      var19.x = var11;
      var19.y = var12;
      var19.pressure = 1.0F;
      var19.size = 1.0F;
      var17[0] = var18;
      var17[1] = var19;
      PointerProperties[] var20 = new PointerProperties[2];
      PointerProperties var21 = new PointerProperties();
      PointerProperties var22 = new PointerProperties();
      var21.id = 0;
      var21.toolType = 1;
      var22.id = 1;
      var22.toolType = 1;
      var20[0] = var21;
      var20[1] = var22;
      MotionEvent var23 = MotionEvent.obtain(var5, var7, 0, 1, var20, var17, 0, 0, 1.0F, 1.0F, 0, 0, 0, 0);
      this._instrument.sendPointerSync(var23);
      MotionEvent var24 = MotionEvent.obtain(var5, var7, 5 + (var22.id << 8), 2, var20, var17, 0, 0, 1.0F, 1.0F, 0, 0, 0, 0);
      this._instrument.sendPointerSync(var24);
      float var25 = (var13 - var9) / (float)100;
      float var26 = (var14 - var10) / (float)100;
      float var27 = (var15 - var11) / (float)100;
      float var28 = (var16 - var12) / (float)100;

      for(int var29 = 0; var29 < 100; ++var29) {
         var7 += 10L;
         PointerCoords var30 = var17[0];
         var30.x += var25;
         PointerCoords var31 = var17[0];
         var31.y += var26;
         PointerCoords var32 = var17[1];
         var32.x += var27;
         PointerCoords var33 = var17[1];
         var33.y += var28;
         MotionEvent var34 = MotionEvent.obtain(var5, var7, 2, 2, var20, var17, 0, 0, 1.0F, 1.0F, 0, 0, 0, 0);
         this._instrument.sendPointerSync(var34);
      }

   }
}
