package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.VelocityTrackerCompatHoneycomb;
import android.view.VelocityTracker;

public class VelocityTrackerCompat {
   static final VelocityTrackerCompat.VelocityTrackerVersionImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 11) {
         IMPL = new VelocityTrackerCompat.HoneycombVelocityTrackerVersionImpl();
      } else {
         IMPL = new VelocityTrackerCompat.BaseVelocityTrackerVersionImpl();
      }
   }

   public static float getXVelocity(VelocityTracker var0, int var1) {
      return IMPL.getXVelocity(var0, var1);
   }

   public static float getYVelocity(VelocityTracker var0, int var1) {
      return IMPL.getYVelocity(var0, var1);
   }

   static class BaseVelocityTrackerVersionImpl implements VelocityTrackerCompat.VelocityTrackerVersionImpl {
      public float getXVelocity(VelocityTracker var1, int var2) {
         return var1.getXVelocity();
      }

      public float getYVelocity(VelocityTracker var1, int var2) {
         return var1.getYVelocity();
      }
   }

   static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerCompat.VelocityTrackerVersionImpl {
      public float getXVelocity(VelocityTracker var1, int var2) {
         return VelocityTrackerCompatHoneycomb.getXVelocity(var1, var2);
      }

      public float getYVelocity(VelocityTracker var1, int var2) {
         return VelocityTrackerCompatHoneycomb.getYVelocity(var1, var2);
      }
   }

   interface VelocityTrackerVersionImpl {
      float getXVelocity(VelocityTracker var1, int var2);

      float getYVelocity(VelocityTracker var1, int var2);
   }
}
