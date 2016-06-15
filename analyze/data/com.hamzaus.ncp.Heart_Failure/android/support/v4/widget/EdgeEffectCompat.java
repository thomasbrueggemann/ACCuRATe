package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.widget.EdgeEffectCompatIcs;

public class EdgeEffectCompat {
   private static final EdgeEffectCompat.EdgeEffectImpl IMPL;
   private Object mEdgeEffect;

   static {
      if(VERSION.SDK_INT >= 14) {
         IMPL = new EdgeEffectCompat.EdgeEffectIcsImpl();
      } else {
         IMPL = new EdgeEffectCompat.BaseEdgeEffectImpl();
      }
   }

   public EdgeEffectCompat(Context var1) {
      this.mEdgeEffect = IMPL.newEdgeEffect(var1);
   }

   public boolean draw(Canvas var1) {
      return IMPL.draw(this.mEdgeEffect, var1);
   }

   public void finish() {
      IMPL.finish(this.mEdgeEffect);
   }

   public boolean isFinished() {
      return IMPL.isFinished(this.mEdgeEffect);
   }

   public boolean onAbsorb(int var1) {
      return IMPL.onAbsorb(this.mEdgeEffect, var1);
   }

   public boolean onPull(float var1) {
      return IMPL.onPull(this.mEdgeEffect, var1);
   }

   public boolean onRelease() {
      return IMPL.onRelease(this.mEdgeEffect);
   }

   public void setSize(int var1, int var2) {
      IMPL.setSize(this.mEdgeEffect, var1, var2);
   }

   static class BaseEdgeEffectImpl implements EdgeEffectCompat.EdgeEffectImpl {
      public boolean draw(Object var1, Canvas var2) {
         return false;
      }

      public void finish(Object var1) {
      }

      public boolean isFinished(Object var1) {
         return true;
      }

      public Object newEdgeEffect(Context var1) {
         return null;
      }

      public boolean onAbsorb(Object var1, int var2) {
         return false;
      }

      public boolean onPull(Object var1, float var2) {
         return false;
      }

      public boolean onRelease(Object var1) {
         return false;
      }

      public void setSize(Object var1, int var2, int var3) {
      }
   }

   static class EdgeEffectIcsImpl implements EdgeEffectCompat.EdgeEffectImpl {
      public boolean draw(Object var1, Canvas var2) {
         return EdgeEffectCompatIcs.draw(var1, var2);
      }

      public void finish(Object var1) {
         EdgeEffectCompatIcs.finish(var1);
      }

      public boolean isFinished(Object var1) {
         return EdgeEffectCompatIcs.isFinished(var1);
      }

      public Object newEdgeEffect(Context var1) {
         return EdgeEffectCompatIcs.newEdgeEffect(var1);
      }

      public boolean onAbsorb(Object var1, int var2) {
         return EdgeEffectCompatIcs.onAbsorb(var1, var2);
      }

      public boolean onPull(Object var1, float var2) {
         return EdgeEffectCompatIcs.onPull(var1, var2);
      }

      public boolean onRelease(Object var1) {
         return EdgeEffectCompatIcs.onRelease(var1);
      }

      public void setSize(Object var1, int var2, int var3) {
         EdgeEffectCompatIcs.setSize(var1, var2, var3);
      }
   }

   interface EdgeEffectImpl {
      boolean draw(Object var1, Canvas var2);

      void finish(Object var1);

      boolean isFinished(Object var1);

      Object newEdgeEffect(Context var1);

      boolean onAbsorb(Object var1, int var2);

      boolean onPull(Object var1, float var2);

      boolean onRelease(Object var1);

      void setSize(Object var1, int var2, int var3);
   }
}
