package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompatEclair;
import android.view.MotionEvent;

public class MotionEventCompat {
   public static final int ACTION_HOVER_ENTER = 9;
   public static final int ACTION_HOVER_EXIT = 10;
   public static final int ACTION_HOVER_MOVE = 7;
   public static final int ACTION_MASK = 255;
   public static final int ACTION_POINTER_DOWN = 5;
   public static final int ACTION_POINTER_INDEX_MASK = 65280;
   public static final int ACTION_POINTER_INDEX_SHIFT = 8;
   public static final int ACTION_POINTER_UP = 6;
   public static final int ACTION_SCROLL = 8;
   static final MotionEventCompat.MotionEventVersionImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 5) {
         IMPL = new MotionEventCompat.EclairMotionEventVersionImpl();
      } else {
         IMPL = new MotionEventCompat.BaseMotionEventVersionImpl();
      }
   }

   public static int findPointerIndex(MotionEvent var0, int var1) {
      return IMPL.findPointerIndex(var0, var1);
   }

   public static int getActionIndex(MotionEvent var0) {
      return ('\uff00' & var0.getAction()) >> 8;
   }

   public static int getActionMasked(MotionEvent var0) {
      return 255 & var0.getAction();
   }

   public static int getPointerCount(MotionEvent var0) {
      return IMPL.getPointerCount(var0);
   }

   public static int getPointerId(MotionEvent var0, int var1) {
      return IMPL.getPointerId(var0, var1);
   }

   public static float getX(MotionEvent var0, int var1) {
      return IMPL.getX(var0, var1);
   }

   public static float getY(MotionEvent var0, int var1) {
      return IMPL.getY(var0, var1);
   }

   static class BaseMotionEventVersionImpl implements MotionEventCompat.MotionEventVersionImpl {
      public int findPointerIndex(MotionEvent var1, int var2) {
         return var2 == 0?0:-1;
      }

      public int getPointerCount(MotionEvent var1) {
         return 1;
      }

      public int getPointerId(MotionEvent var1, int var2) {
         if(var2 == 0) {
            return 0;
         } else {
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
         }
      }

      public float getX(MotionEvent var1, int var2) {
         if(var2 == 0) {
            return var1.getX();
         } else {
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
         }
      }

      public float getY(MotionEvent var1, int var2) {
         if(var2 == 0) {
            return var1.getY();
         } else {
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
         }
      }
   }

   static class EclairMotionEventVersionImpl implements MotionEventCompat.MotionEventVersionImpl {
      public int findPointerIndex(MotionEvent var1, int var2) {
         return MotionEventCompatEclair.findPointerIndex(var1, var2);
      }

      public int getPointerCount(MotionEvent var1) {
         return MotionEventCompatEclair.getPointerCount(var1);
      }

      public int getPointerId(MotionEvent var1, int var2) {
         return MotionEventCompatEclair.getPointerId(var1, var2);
      }

      public float getX(MotionEvent var1, int var2) {
         return MotionEventCompatEclair.getX(var1, var2);
      }

      public float getY(MotionEvent var1, int var2) {
         return MotionEventCompatEclair.getY(var1, var2);
      }
   }

   interface MotionEventVersionImpl {
      int findPointerIndex(MotionEvent var1, int var2);

      int getPointerCount(MotionEvent var1);

      int getPointerId(MotionEvent var1, int var2);

      float getX(MotionEvent var1, int var2);

      float getY(MotionEvent var1, int var2);
   }
}
