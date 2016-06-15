package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.ScrollerCompatGingerbread;
import android.support.v4.widget.ScrollerCompatIcs;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class ScrollerCompat {
   static final int CHASE_FRAME_TIME = 16;
   private static final String TAG = "ScrollerCompat";
   ScrollerCompat.ScrollerCompatImpl mImpl;
   Object mScroller;

   private ScrollerCompat(int var1, Context var2, Interpolator var3) {
      if(var1 >= 14) {
         this.mImpl = new ScrollerCompat.ScrollerCompatImplIcs();
      } else if(var1 >= 9) {
         this.mImpl = new ScrollerCompat.ScrollerCompatImplGingerbread();
      } else {
         this.mImpl = new ScrollerCompat.ScrollerCompatImplBase();
      }

      this.mScroller = this.mImpl.createScroller(var2, var3);
   }

   ScrollerCompat(Context var1, Interpolator var2) {
      this(VERSION.SDK_INT, var1, var2);
   }

   public static ScrollerCompat create(Context var0) {
      return create(var0, (Interpolator)null);
   }

   public static ScrollerCompat create(Context var0, Interpolator var1) {
      return new ScrollerCompat(var0, var1);
   }

   public void abortAnimation() {
      this.mImpl.abortAnimation(this.mScroller);
   }

   public boolean computeScrollOffset() {
      return this.mImpl.computeScrollOffset(this.mScroller);
   }

   public void fling(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      this.mImpl.fling(this.mScroller, var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void fling(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      this.mImpl.fling(this.mScroller, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   public float getCurrVelocity() {
      return this.mImpl.getCurrVelocity(this.mScroller);
   }

   public int getCurrX() {
      return this.mImpl.getCurrX(this.mScroller);
   }

   public int getCurrY() {
      return this.mImpl.getCurrY(this.mScroller);
   }

   public int getFinalX() {
      return this.mImpl.getFinalX(this.mScroller);
   }

   public int getFinalY() {
      return this.mImpl.getFinalY(this.mScroller);
   }

   public boolean isFinished() {
      return this.mImpl.isFinished(this.mScroller);
   }

   public boolean isOverScrolled() {
      return this.mImpl.isOverScrolled(this.mScroller);
   }

   public void notifyHorizontalEdgeReached(int var1, int var2, int var3) {
      this.mImpl.notifyHorizontalEdgeReached(this.mScroller, var1, var2, var3);
   }

   public void notifyVerticalEdgeReached(int var1, int var2, int var3) {
      this.mImpl.notifyVerticalEdgeReached(this.mScroller, var1, var2, var3);
   }

   public void startScroll(int var1, int var2, int var3, int var4) {
      this.mImpl.startScroll(this.mScroller, var1, var2, var3, var4);
   }

   public void startScroll(int var1, int var2, int var3, int var4, int var5) {
      this.mImpl.startScroll(this.mScroller, var1, var2, var3, var4, var5);
   }

   interface ScrollerCompatImpl {
      void abortAnimation(Object var1);

      boolean computeScrollOffset(Object var1);

      Object createScroller(Context var1, Interpolator var2);

      void fling(Object var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9);

      void fling(Object var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11);

      float getCurrVelocity(Object var1);

      int getCurrX(Object var1);

      int getCurrY(Object var1);

      int getFinalX(Object var1);

      int getFinalY(Object var1);

      boolean isFinished(Object var1);

      boolean isOverScrolled(Object var1);

      void notifyHorizontalEdgeReached(Object var1, int var2, int var3, int var4);

      void notifyVerticalEdgeReached(Object var1, int var2, int var3, int var4);

      void startScroll(Object var1, int var2, int var3, int var4, int var5);

      void startScroll(Object var1, int var2, int var3, int var4, int var5, int var6);
   }

   static class ScrollerCompatImplBase implements ScrollerCompat.ScrollerCompatImpl {
      public void abortAnimation(Object var1) {
         ((Scroller)var1).abortAnimation();
      }

      public boolean computeScrollOffset(Object var1) {
         return ((Scroller)var1).computeScrollOffset();
      }

      public Object createScroller(Context var1, Interpolator var2) {
         return var2 != null?new Scroller(var1, var2):new Scroller(var1);
      }

      public void fling(Object var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
         ((Scroller)var1).fling(var2, var3, var4, var5, var6, var7, var8, var9);
      }

      public void fling(Object var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
         ((Scroller)var1).fling(var2, var3, var4, var5, var6, var7, var8, var9);
      }

      public float getCurrVelocity(Object var1) {
         return 0.0F;
      }

      public int getCurrX(Object var1) {
         return ((Scroller)var1).getCurrX();
      }

      public int getCurrY(Object var1) {
         return ((Scroller)var1).getCurrY();
      }

      public int getFinalX(Object var1) {
         return ((Scroller)var1).getFinalX();
      }

      public int getFinalY(Object var1) {
         return ((Scroller)var1).getFinalY();
      }

      public boolean isFinished(Object var1) {
         return ((Scroller)var1).isFinished();
      }

      public boolean isOverScrolled(Object var1) {
         return false;
      }

      public void notifyHorizontalEdgeReached(Object var1, int var2, int var3, int var4) {
      }

      public void notifyVerticalEdgeReached(Object var1, int var2, int var3, int var4) {
      }

      public void startScroll(Object var1, int var2, int var3, int var4, int var5) {
         ((Scroller)var1).startScroll(var2, var3, var4, var5);
      }

      public void startScroll(Object var1, int var2, int var3, int var4, int var5, int var6) {
         ((Scroller)var1).startScroll(var2, var3, var4, var5, var6);
      }
   }

   static class ScrollerCompatImplGingerbread implements ScrollerCompat.ScrollerCompatImpl {
      public void abortAnimation(Object var1) {
         ScrollerCompatGingerbread.abortAnimation(var1);
      }

      public boolean computeScrollOffset(Object var1) {
         return ScrollerCompatGingerbread.computeScrollOffset(var1);
      }

      public Object createScroller(Context var1, Interpolator var2) {
         return ScrollerCompatGingerbread.createScroller(var1, var2);
      }

      public void fling(Object var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
         ScrollerCompatGingerbread.fling(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

      public void fling(Object var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
         ScrollerCompatGingerbread.fling(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
      }

      public float getCurrVelocity(Object var1) {
         return 0.0F;
      }

      public int getCurrX(Object var1) {
         return ScrollerCompatGingerbread.getCurrX(var1);
      }

      public int getCurrY(Object var1) {
         return ScrollerCompatGingerbread.getCurrY(var1);
      }

      public int getFinalX(Object var1) {
         return ScrollerCompatGingerbread.getFinalX(var1);
      }

      public int getFinalY(Object var1) {
         return ScrollerCompatGingerbread.getFinalY(var1);
      }

      public boolean isFinished(Object var1) {
         return ScrollerCompatGingerbread.isFinished(var1);
      }

      public boolean isOverScrolled(Object var1) {
         return ScrollerCompatGingerbread.isOverScrolled(var1);
      }

      public void notifyHorizontalEdgeReached(Object var1, int var2, int var3, int var4) {
         ScrollerCompatGingerbread.notifyHorizontalEdgeReached(var1, var2, var3, var4);
      }

      public void notifyVerticalEdgeReached(Object var1, int var2, int var3, int var4) {
         ScrollerCompatGingerbread.notifyVerticalEdgeReached(var1, var2, var3, var4);
      }

      public void startScroll(Object var1, int var2, int var3, int var4, int var5) {
         ScrollerCompatGingerbread.startScroll(var1, var2, var3, var4, var5);
      }

      public void startScroll(Object var1, int var2, int var3, int var4, int var5, int var6) {
         ScrollerCompatGingerbread.startScroll(var1, var2, var3, var4, var5, var6);
      }
   }

   static class ScrollerCompatImplIcs extends ScrollerCompat.ScrollerCompatImplGingerbread {
      public float getCurrVelocity(Object var1) {
         return ScrollerCompatIcs.getCurrVelocity(var1);
      }
   }
}
