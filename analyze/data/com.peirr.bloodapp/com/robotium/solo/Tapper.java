package com.robotium.solo;

import android.app.Instrumentation;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;

class Tapper {
   public static final int EVENT_TIME_INTERVAL_MS = 10;
   public static final int GESTURE_DURATION_MS = 1000;
   private final Instrumentation _instrument;

   public Tapper(Instrumentation var1) {
      this._instrument = var1;
   }

   public void generateTapGesture(int var1, PointF... var2) {
      long var3 = SystemClock.uptimeMillis();
      long var5 = SystemClock.uptimeMillis();
      float var7 = var2[0].x;
      float var8 = var2[0].y;
      int var9 = var2.length;
      float var10 = 0.0F;
      float var11 = 0.0F;
      if(var9 == 2) {
         var10 = var2[1].x;
         var11 = var2[1].y;
      }

      PointerCoords[] var12 = new PointerCoords[var2.length];
      PointerCoords var13 = new PointerCoords();
      var13.x = var7;
      var13.y = var8;
      var13.pressure = 1.0F;
      var13.size = 1.0F;
      var12[0] = var13;
      PointerCoords var14 = new PointerCoords();
      if(var2.length == 2) {
         var14.x = var10;
         var14.y = var11;
         var14.pressure = 1.0F;
         var14.size = 1.0F;
         var12[1] = var14;
      }

      PointerProperties[] var15 = new PointerProperties[var2.length];
      PointerProperties var16 = new PointerProperties();
      var16.id = 0;
      var16.toolType = 1;
      var15[0] = var16;
      PointerProperties var17 = new PointerProperties();
      if(var2.length == 2) {
         var17.id = 1;
         var17.toolType = 1;
         var15[1] = var17;
      }

      for(int var18 = 0; var18 != var1; ++var18) {
         MotionEvent var19 = MotionEvent.obtain(var3, var5, 0, var2.length, var15, var12, 0, 0, 1.0F, 1.0F, 0, 0, 4098, 0);
         this._instrument.sendPointerSync(var19);
         if(var2.length == 2) {
            MotionEvent var21 = MotionEvent.obtain(var3, var5, 5 + (var17.id << 8), var2.length, var15, var12, 0, 0, 1.0F, 1.0F, 0, 0, 4098, 0);
            this._instrument.sendPointerSync(var21);
            var5 += 10L;
            MotionEvent var22 = MotionEvent.obtain(var3, var5, 6 + (var17.id << 8), var2.length, var15, var12, 0, 0, 1.0F, 1.0F, 0, 0, 4098, 0);
            this._instrument.sendPointerSync(var22);
         }

         var5 += 10L;
         MotionEvent var20 = MotionEvent.obtain(var3, var5, 1, var2.length, var15, var12, 0, 0, 1.0F, 1.0F, 0, 0, 4098, 0);
         this._instrument.sendPointerSync(var20);
      }

   }
}
