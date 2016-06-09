package com.facebook.drawee.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.activitylistener.ActivityListener;
import com.facebook.common.activitylistener.BaseActivityListener;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import javax.annotation.Nullable;

public class DraweeHolder<DH extends DraweeHierarchy> implements VisibilityCallback {
   private final ActivityListener mActivityListener;
   private DraweeController mController = null;
   private final DraweeEventTracker mEventTracker = new DraweeEventTracker();
   private DH mHierarchy;
   private boolean mIsActivityStarted = true;
   private boolean mIsControllerAttached = false;
   private boolean mIsHolderAttached = false;
   private boolean mIsVisible = true;

   public DraweeHolder(@Nullable DH var1) {
      if(var1 != null) {
         this.setHierarchy(var1);
      }

      this.mActivityListener = new BaseActivityListener() {
         public void onStart(Activity var1) {
            DraweeHolder.this.setActivityStarted(true);
         }

         public void onStop(Activity var1) {
            DraweeHolder.this.setActivityStarted(false);
         }
      };
   }

   private void attachController() {
      if(!this.mIsControllerAttached) {
         this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
         this.mIsControllerAttached = true;
         if(this.mController != null && this.mController.getHierarchy() != null) {
            this.mController.onAttach();
            return;
         }
      }

   }

   private void attachOrDetachController() {
      if(this.mIsHolderAttached && this.mIsVisible && this.mIsActivityStarted) {
         this.attachController();
      } else {
         this.detachController();
      }
   }

   public static <DH extends DraweeHierarchy> DraweeHolder<DH> create(@Nullable DH var0, Context var1) {
      DraweeHolder var2 = new DraweeHolder(var0);
      var2.registerWithContext(var1);
      return var2;
   }

   private void detachController() {
      if(this.mIsControllerAttached) {
         this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
         this.mIsControllerAttached = false;
         if(this.mController != null) {
            this.mController.onDetach();
            return;
         }
      }

   }

   private void setActivityStarted(boolean var1) {
      DraweeEventTracker var2 = this.mEventTracker;
      DraweeEventTracker.Event var3;
      if(var1) {
         var3 = DraweeEventTracker.Event.ON_ACTIVITY_START;
      } else {
         var3 = DraweeEventTracker.Event.ON_ACTIVITY_STOP;
      }

      var2.recordEvent(var3);
      this.mIsActivityStarted = var1;
      this.attachOrDetachController();
   }

   private void setVisibilityCallback(@Nullable VisibilityCallback var1) {
      Drawable var2 = this.getTopLevelDrawable();
      if(var2 instanceof VisibilityAwareDrawable) {
         ((VisibilityAwareDrawable)var2).setVisibilityCallback(var1);
      }

   }

   @Nullable
   public DraweeController getController() {
      return this.mController;
   }

   public DH getHierarchy() {
      return (DraweeHierarchy)Preconditions.checkNotNull(this.mHierarchy);
   }

   public Drawable getTopLevelDrawable() {
      return this.mHierarchy == null?null:this.mHierarchy.getTopLevelDrawable();
   }

   public boolean hasHierarchy() {
      return this.mHierarchy != null;
   }

   public void onAttach() {
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
      this.mIsHolderAttached = true;
      this.attachOrDetachController();
   }

   public void onDetach() {
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_HOLDER_DETACH);
      this.mIsHolderAttached = false;
      this.attachOrDetachController();
   }

   public void onDraw() {
      if(!this.mIsControllerAttached) {
         Object[] var1 = new Object[]{Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mController)), this.toString()};
         FLog.wtf(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", var1);
         this.mIsHolderAttached = true;
         this.mIsVisible = true;
         this.mIsActivityStarted = true;
         this.attachOrDetachController();
      }
   }

   public boolean onTouchEvent(MotionEvent var1) {
      return this.mController == null?false:this.mController.onTouchEvent(var1);
   }

   public void onVisibilityChange(boolean var1) {
      if(this.mIsVisible != var1) {
         DraweeEventTracker var2 = this.mEventTracker;
         DraweeEventTracker.Event var3;
         if(var1) {
            var3 = DraweeEventTracker.Event.ON_DRAWABLE_SHOW;
         } else {
            var3 = DraweeEventTracker.Event.ON_DRAWABLE_HIDE;
         }

         var2.recordEvent(var3);
         this.mIsVisible = var1;
         this.attachOrDetachController();
      }
   }

   public void registerWithContext(Context var1) {
   }

   public void setController(@Nullable DraweeController var1) {
      boolean var2 = this.mIsControllerAttached;
      if(var2) {
         this.detachController();
      }

      if(this.mController != null) {
         this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
         this.mController.setHierarchy((DraweeHierarchy)null);
      }

      this.mController = var1;
      if(this.mController != null) {
         this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_CONTROLLER);
         this.mController.setHierarchy(this.mHierarchy);
      } else {
         this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
      }

      if(var2) {
         this.attachController();
      }

   }

   public void setHierarchy(DH var1) {
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SET_HIERARCHY);
      this.setVisibilityCallback((VisibilityCallback)null);
      this.mHierarchy = (DraweeHierarchy)Preconditions.checkNotNull(var1);
      this.onVisibilityChange(this.mHierarchy.getTopLevelDrawable().isVisible());
      this.setVisibilityCallback(this);
      if(this.mController != null) {
         this.mController.setHierarchy(var1);
      }

   }

   public String toString() {
      return Objects.toStringHelper((Object)this).add("controllerAttached", this.mIsControllerAttached).add("holderAttached", this.mIsHolderAttached).add("drawableVisible", this.mIsVisible).add("activityStarted", this.mIsActivityStarted).add("events", this.mEventTracker.toString()).toString();
   }
}
