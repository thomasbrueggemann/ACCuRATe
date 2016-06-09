package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public abstract class AbstractDraweeController<T, INFO> implements DeferredReleaser.Releasable, GestureDetector.ClickListener, DraweeController {
   private static final Class<?> TAG = AbstractDraweeController.class;
   private Object mCallerContext;
   @Nullable
   private ControllerListener<INFO> mControllerListener;
   @Nullable
   private Drawable mControllerOverlay;
   @Nullable
   private DataSource<T> mDataSource;
   private final DeferredReleaser mDeferredReleaser;
   @Nullable
   private Drawable mDrawable;
   private final DraweeEventTracker mEventTracker = new DraweeEventTracker();
   @Nullable
   private T mFetchedImage;
   @Nullable
   private GestureDetector mGestureDetector;
   private boolean mHasFetchFailed;
   private String mId;
   private boolean mIsAttached;
   private boolean mIsRequestSubmitted;
   private boolean mRetainImageOnFailure;
   @Nullable
   private RetryManager mRetryManager;
   @Nullable
   private SettableDraweeHierarchy mSettableDraweeHierarchy;
   private final Executor mUiThreadImmediateExecutor;

   public AbstractDraweeController(DeferredReleaser var1, Executor var2, String var3, Object var4) {
      this.mDeferredReleaser = var1;
      this.mUiThreadImmediateExecutor = var2;
      this.init(var3, var4, true);
   }

   private void init(String var1, Object var2, boolean var3) {
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
      if(!var3 && this.mDeferredReleaser != null) {
         this.mDeferredReleaser.cancelDeferredRelease(this);
      }

      this.mIsAttached = false;
      this.releaseFetch();
      this.mRetainImageOnFailure = false;
      if(this.mRetryManager != null) {
         this.mRetryManager.init();
      }

      if(this.mGestureDetector != null) {
         this.mGestureDetector.init();
         this.mGestureDetector.setClickListener(this);
      }

      if(this.mControllerListener instanceof AbstractDraweeController.InternalForwardingListener) {
         ((AbstractDraweeController.InternalForwardingListener)this.mControllerListener).clearListeners();
      } else {
         this.mControllerListener = null;
      }

      if(this.mSettableDraweeHierarchy != null) {
         this.mSettableDraweeHierarchy.reset();
         this.mSettableDraweeHierarchy.setControllerOverlay((Drawable)null);
         this.mSettableDraweeHierarchy = null;
      }

      this.mControllerOverlay = null;
      if(FLog.isLoggable(2)) {
         FLog.method_420(TAG, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, var1);
      }

      this.mId = var1;
      this.mCallerContext = var2;
   }

   private boolean isExpectedDataSource(String var1, DataSource<T> var2) {
      return var1.equals(this.mId) && var2 == this.mDataSource && this.mIsRequestSubmitted;
   }

   private void logMessageAndFailure(String var1, Throwable var2) {
      if(FLog.isLoggable(2)) {
         FLog.method_421(TAG, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, var1, var2);
      }

   }

   private void logMessageAndImage(String var1, T var2) {
      if(FLog.isLoggable(2)) {
         Class var3 = TAG;
         Object[] var4 = new Object[]{Integer.valueOf(System.identityHashCode(this)), this.mId, var1, this.getImageClass(var2), Integer.valueOf(this.getImageHash(var2))};
         FLog.method_423(var3, "controller %x %s: %s: image: %s %x", var4);
      }

   }

   private void onFailureInternal(String var1, DataSource<T> var2, Throwable var3, boolean var4) {
      if(!this.isExpectedDataSource(var1, var2)) {
         this.logMessageAndFailure("ignore_old_datasource @ onFailure", var3);
         var2.close();
      } else {
         DraweeEventTracker var5 = this.mEventTracker;
         DraweeEventTracker.Event var6;
         if(var4) {
            var6 = DraweeEventTracker.Event.ON_DATASOURCE_FAILURE;
         } else {
            var6 = DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT;
         }

         var5.recordEvent(var6);
         if(!var4) {
            this.logMessageAndFailure("intermediate_failed @ onFailure", var3);
            this.getControllerListener().onIntermediateImageFailed(this.mId, var3);
         } else {
            this.logMessageAndFailure("final_failed @ onFailure", var3);
            this.mDataSource = null;
            this.mHasFetchFailed = true;
            if(this.mRetainImageOnFailure && this.mDrawable != null) {
               this.mSettableDraweeHierarchy.setImage(this.mDrawable, 1.0F, true);
            } else if(this.shouldRetryOnTap()) {
               this.mSettableDraweeHierarchy.setRetry(var3);
            } else {
               this.mSettableDraweeHierarchy.setFailure(var3);
            }

            this.getControllerListener().onFailure(this.mId, var3);
         }
      }
   }

   private void onNewResultInternal(String param1, DataSource<T> param2, @Nullable T param3, float param4, boolean param5, boolean param6) {
      // $FF: Couldn't be decompiled
   }

   private void onProgressUpdateInternal(String var1, DataSource<T> var2, float var3, boolean var4) {
      if(!this.isExpectedDataSource(var1, var2)) {
         this.logMessageAndFailure("ignore_old_datasource @ onProgress", (Throwable)null);
         var2.close();
      } else if(!var4) {
         this.mSettableDraweeHierarchy.setProgress(var3, false);
         return;
      }

   }

   private void releaseFetch() {
      boolean var1 = this.mIsRequestSubmitted;
      this.mIsRequestSubmitted = false;
      this.mHasFetchFailed = false;
      if(this.mDataSource != null) {
         this.mDataSource.close();
         this.mDataSource = null;
      }

      if(this.mDrawable != null) {
         this.releaseDrawable(this.mDrawable);
      }

      this.mDrawable = null;
      if(this.mFetchedImage != null) {
         this.logMessageAndImage("release", this.mFetchedImage);
         this.releaseImage(this.mFetchedImage);
         this.mFetchedImage = null;
      }

      if(var1) {
         this.getControllerListener().onRelease(this.mId);
      }

   }

   private boolean shouldRetryOnTap() {
      return this.mHasFetchFailed && this.mRetryManager != null && this.mRetryManager.shouldRetryOnTap();
   }

   public void addControllerListener(ControllerListener<? super INFO> var1) {
      Preconditions.checkNotNull(var1);
      if(this.mControllerListener instanceof AbstractDraweeController.InternalForwardingListener) {
         ((AbstractDraweeController.InternalForwardingListener)this.mControllerListener).addListener(var1);
      } else if(this.mControllerListener != null) {
         this.mControllerListener = AbstractDraweeController.InternalForwardingListener.createInternal(this.mControllerListener, var1);
      } else {
         this.mControllerListener = var1;
      }
   }

   protected abstract Drawable createDrawable(T var1);

   @Nullable
   public Animatable getAnimatable() {
      return this.mDrawable instanceof Animatable?(Animatable)this.mDrawable:null;
   }

   public Object getCallerContext() {
      return this.mCallerContext;
   }

   protected ControllerListener<INFO> getControllerListener() {
      return this.mControllerListener == null?BaseControllerListener.getNoOpListener():this.mControllerListener;
   }

   @Nullable
   protected Drawable getControllerOverlay() {
      return this.mControllerOverlay;
   }

   protected abstract DataSource<T> getDataSource();

   @Nullable
   protected GestureDetector getGestureDetector() {
      return this.mGestureDetector;
   }

   @Nullable
   public DraweeHierarchy getHierarchy() {
      return this.mSettableDraweeHierarchy;
   }

   public String getId() {
      return this.mId;
   }

   protected String getImageClass(@Nullable T var1) {
      return var1 != null?var1.getClass().getSimpleName():"<null>";
   }

   protected int getImageHash(@Nullable T var1) {
      return System.identityHashCode(var1);
   }

   @Nullable
   protected abstract INFO getImageInfo(T var1);

   @Nullable
   protected RetryManager getRetryManager() {
      return this.mRetryManager;
   }

   protected void initialize(String var1, Object var2) {
      this.init(var1, var2, false);
   }

   public void onAttach() {
      if(FLog.isLoggable(2)) {
         Class var2 = TAG;
         Integer var3 = Integer.valueOf(System.identityHashCode(this));
         String var4 = this.mId;
         String var5;
         if(this.mIsRequestSubmitted) {
            var5 = "request already submitted";
         } else {
            var5 = "request needs submit";
         }

         FLog.method_420(var2, "controller %x %s: onAttach: %s", var3, var4, var5);
      }

      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
      Preconditions.checkNotNull(this.mSettableDraweeHierarchy);
      this.mDeferredReleaser.cancelDeferredRelease(this);
      this.mIsAttached = true;
      if(!this.mIsRequestSubmitted) {
         this.submitRequest();
      }

   }

   public boolean onClick() {
      if(FLog.isLoggable(2)) {
         FLog.method_419(TAG, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
      }

      if(this.shouldRetryOnTap()) {
         this.mRetryManager.notifyTapToRetry();
         this.mSettableDraweeHierarchy.reset();
         this.submitRequest();
         return true;
      } else {
         return false;
      }
   }

   public void onDetach() {
      if(FLog.isLoggable(2)) {
         FLog.method_419(TAG, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
      }

      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
      this.mIsAttached = false;
      this.mDeferredReleaser.scheduleDeferredRelease(this);
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if(FLog.isLoggable(2)) {
         FLog.method_420(TAG, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, var1);
      }

      if(this.mGestureDetector != null && (this.mGestureDetector.isCapturingGesture() || this.shouldHandleGesture())) {
         this.mGestureDetector.onTouchEvent(var1);
         return true;
      } else {
         return false;
      }
   }

   public void release() {
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
      if(this.mRetryManager != null) {
         this.mRetryManager.reset();
      }

      if(this.mGestureDetector != null) {
         this.mGestureDetector.reset();
      }

      if(this.mSettableDraweeHierarchy != null) {
         this.mSettableDraweeHierarchy.reset();
      }

      this.releaseFetch();
   }

   protected abstract void releaseDrawable(@Nullable Drawable var1);

   protected abstract void releaseImage(@Nullable T var1);

   public void removeControllerListener(ControllerListener<? super INFO> var1) {
      Preconditions.checkNotNull(var1);
      if(this.mControllerListener instanceof AbstractDraweeController.InternalForwardingListener) {
         ((AbstractDraweeController.InternalForwardingListener)this.mControllerListener).removeListener(var1);
      } else if(this.mControllerListener == var1) {
         this.mControllerListener = null;
         return;
      }

   }

   protected void setControllerOverlay(@Nullable Drawable var1) {
      this.mControllerOverlay = var1;
      if(this.mSettableDraweeHierarchy != null) {
         this.mSettableDraweeHierarchy.setControllerOverlay(this.mControllerOverlay);
      }

   }

   protected void setGestureDetector(@Nullable GestureDetector var1) {
      this.mGestureDetector = var1;
      if(this.mGestureDetector != null) {
         this.mGestureDetector.setClickListener(this);
      }

   }

   public void setHierarchy(@Nullable DraweeHierarchy var1) {
      if(FLog.isLoggable(2)) {
         FLog.method_420(TAG, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, var1);
      }

      DraweeEventTracker var2 = this.mEventTracker;
      DraweeEventTracker.Event var3;
      if(var1 != null) {
         var3 = DraweeEventTracker.Event.ON_SET_HIERARCHY;
      } else {
         var3 = DraweeEventTracker.Event.ON_CLEAR_HIERARCHY;
      }

      var2.recordEvent(var3);
      if(this.mIsRequestSubmitted) {
         this.mDeferredReleaser.cancelDeferredRelease(this);
         this.release();
      }

      if(this.mSettableDraweeHierarchy != null) {
         this.mSettableDraweeHierarchy.setControllerOverlay((Drawable)null);
         this.mSettableDraweeHierarchy = null;
      }

      if(var1 != null) {
         Preconditions.checkArgument(var1 instanceof SettableDraweeHierarchy);
         this.mSettableDraweeHierarchy = (SettableDraweeHierarchy)var1;
         this.mSettableDraweeHierarchy.setControllerOverlay(this.mControllerOverlay);
      }

   }

   protected void setRetainImageOnFailure(boolean var1) {
      this.mRetainImageOnFailure = var1;
   }

   protected void setRetryManager(@Nullable RetryManager var1) {
      this.mRetryManager = var1;
   }

   protected boolean shouldHandleGesture() {
      return this.shouldRetryOnTap();
   }

   protected void submitRequest() {
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
      this.getControllerListener().onSubmit(this.mId, this.mCallerContext);
      this.mSettableDraweeHierarchy.setProgress(0.0F, true);
      this.mIsRequestSubmitted = true;
      this.mHasFetchFailed = false;
      this.mDataSource = this.getDataSource();
      if(FLog.isLoggable(2)) {
         FLog.method_420(TAG, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.mDataSource)));
      }

      BaseDataSubscriber var1 = new BaseDataSubscriber() {
         // $FF: synthetic field
         final String val$id;
         // $FF: synthetic field
         final boolean val$wasImmediate;

         {
            this.val$id = var2;
            this.val$wasImmediate = var3;
         }

         public void onFailureImpl(DataSource<T> var1) {
            AbstractDraweeController.this.onFailureInternal(this.val$id, var1, var1.getFailureCause(), true);
         }

         public void onNewResultImpl(DataSource<T> var1) {
            boolean var2 = var1.isFinished();
            float var3 = var1.getProgress();
            Object var4 = var1.getResult();
            if(var4 != null) {
               AbstractDraweeController.this.onNewResultInternal(this.val$id, var1, var4, var3, var2, this.val$wasImmediate);
            } else if(var2) {
               AbstractDraweeController.this.onFailureInternal(this.val$id, var1, new NullPointerException(), true);
               return;
            }

         }

         public void onProgressUpdate(DataSource<T> var1) {
            boolean var2 = var1.isFinished();
            float var3 = var1.getProgress();
            AbstractDraweeController.this.onProgressUpdateInternal(this.val$id, var1, var3, var2);
         }
      };
      this.mDataSource.subscribe(var1, this.mUiThreadImmediateExecutor);
   }

   public String toString() {
      return Objects.toStringHelper((Object)this).add("isAttached", this.mIsAttached).add("isRequestSubmitted", this.mIsRequestSubmitted).add("hasFetchFailed", this.mHasFetchFailed).add("fetchedImage", this.getImageHash(this.mFetchedImage)).add("events", this.mEventTracker.toString()).toString();
   }

   private static class InternalForwardingListener<INFO> extends ForwardingControllerListener<INFO> {
      public static <INFO> AbstractDraweeController.InternalForwardingListener<INFO> createInternal(ControllerListener<? super INFO> var0, ControllerListener<? super INFO> var1) {
         AbstractDraweeController.InternalForwardingListener var2 = new AbstractDraweeController.InternalForwardingListener();
         var2.addListener(var0);
         var2.addListener(var1);
         return var2;
      }
   }
}
