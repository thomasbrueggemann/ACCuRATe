package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements SimpleDraweeControllerBuilder {
   private static final NullPointerException NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
   private static final ControllerListener<Object> sAutoPlayAnimationsListener = new BaseControllerListener() {
      public void onFinalImageSet(String var1, @Nullable Object var2, @Nullable Animatable var3) {
         if(var3 != null) {
            var3.start();
         }

      }
   };
   private static final AtomicLong sIdCounter = new AtomicLong();
   private boolean mAutoPlayAnimations;
   private final Set<ControllerListener> mBoundControllerListeners;
   @Nullable
   private Object mCallerContext;
   private final Context mContext;
   @Nullable
   private ControllerListener<? super INFO> mControllerListener;
   @Nullable
   private Supplier<DataSource<IMAGE>> mDataSourceSupplier;
   @Nullable
   private REQUEST mImageRequest;
   @Nullable
   private REQUEST mLowResImageRequest;
   @Nullable
   private REQUEST[] mMultiImageRequests;
   @Nullable
   private DraweeController mOldController;
   private boolean mRetainImageOnFailure;
   private boolean mTapToRetryEnabled;
   private boolean mTryCacheOnlyFirst;

   protected AbstractDraweeControllerBuilder(Context var1, Set<ControllerListener> var2) {
      this.mContext = var1;
      this.mBoundControllerListeners = var2;
      this.init();
   }

   protected static String generateUniqueControllerId() {
      return String.valueOf(sIdCounter.getAndIncrement());
   }

   private void init() {
      this.mCallerContext = null;
      this.mImageRequest = null;
      this.mLowResImageRequest = null;
      this.mMultiImageRequests = null;
      this.mTryCacheOnlyFirst = true;
      this.mControllerListener = null;
      this.mTapToRetryEnabled = false;
      this.mAutoPlayAnimations = false;
      this.mOldController = null;
   }

   public AbstractDraweeController build() {
      this.validate();
      if(this.mImageRequest == null && this.mMultiImageRequests == null && this.mLowResImageRequest != null) {
         this.mImageRequest = this.mLowResImageRequest;
         this.mLowResImageRequest = null;
      }

      return this.buildController();
   }

   protected AbstractDraweeController buildController() {
      AbstractDraweeController var1 = this.obtainController();
      var1.setRetainImageOnFailure(this.getRetainImageOnFailure());
      this.maybeBuildAndSetRetryManager(var1);
      this.maybeAttachListeners(var1);
      return var1;
   }

   public boolean getAutoPlayAnimations() {
      return this.mAutoPlayAnimations;
   }

   @Nullable
   public Object getCallerContext() {
      return this.mCallerContext;
   }

   protected Context getContext() {
      return this.mContext;
   }

   @Nullable
   public ControllerListener<? super INFO> getControllerListener() {
      return this.mControllerListener;
   }

   protected abstract DataSource<IMAGE> getDataSourceForRequest(REQUEST var1, Object var2, boolean var3);

   @Nullable
   public Supplier<DataSource<IMAGE>> getDataSourceSupplier() {
      return this.mDataSourceSupplier;
   }

   protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(REQUEST var1) {
      return this.getDataSourceSupplierForRequest(var1, false);
   }

   protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(final REQUEST var1, final boolean var2) {
      return new Supplier() {
         // $FF: synthetic field
         final Object val$callerContext;

         {
            this.val$callerContext = var3;
         }

         public DataSource<IMAGE> get() {
            return AbstractDraweeControllerBuilder.this.getDataSourceForRequest(var1, this.val$callerContext, var2);
         }

         public String toString() {
            return Objects.toStringHelper((Object)this).add("request", var1.toString()).toString();
         }
      };
   }

   protected Supplier<DataSource<IMAGE>> getFirstAvailableDataSourceSupplier(REQUEST[] var1, boolean var2) {
      ArrayList var3 = new ArrayList(2 * var1.length);
      if(var2) {
         for(int var6 = 0; var6 < var1.length; ++var6) {
            var3.add(this.getDataSourceSupplierForRequest(var1[var6], true));
         }
      }

      for(int var4 = 0; var4 < var1.length; ++var4) {
         var3.add(this.getDataSourceSupplierForRequest(var1[var4]));
      }

      return FirstAvailableDataSourceSupplier.create(var3);
   }

   @Nullable
   public REQUEST[] getFirstAvailableImageRequests() {
      return this.mMultiImageRequests;
   }

   @Nullable
   public REQUEST getImageRequest() {
      return this.mImageRequest;
   }

   @Nullable
   public REQUEST getLowResImageRequest() {
      return this.mLowResImageRequest;
   }

   @Nullable
   public DraweeController getOldController() {
      return this.mOldController;
   }

   public boolean getRetainImageOnFailure() {
      return this.mRetainImageOnFailure;
   }

   public boolean getTapToRetryEnabled() {
      return this.mTapToRetryEnabled;
   }

   protected abstract BUILDER getThis();

   protected void maybeAttachListeners(AbstractDraweeController var1) {
      if(this.mBoundControllerListeners != null) {
         Iterator var2 = this.mBoundControllerListeners.iterator();

         while(var2.hasNext()) {
            var1.addControllerListener((ControllerListener)var2.next());
         }
      }

      if(this.mControllerListener != null) {
         var1.addControllerListener(this.mControllerListener);
      }

      if(this.mAutoPlayAnimations) {
         var1.addControllerListener(sAutoPlayAnimationsListener);
      }

   }

   protected void maybeBuildAndSetGestureDetector(AbstractDraweeController var1) {
      if(var1.getGestureDetector() == null) {
         var1.setGestureDetector(GestureDetector.newInstance(this.mContext));
      }

   }

   protected void maybeBuildAndSetRetryManager(AbstractDraweeController var1) {
      if(this.mTapToRetryEnabled) {
         RetryManager var2 = var1.getRetryManager();
         if(var2 == null) {
            var2 = new RetryManager();
            var1.setRetryManager(var2);
         }

         var2.setTapToRetryEnabled(this.mTapToRetryEnabled);
         this.maybeBuildAndSetGestureDetector(var1);
      }
   }

   protected abstract AbstractDraweeController obtainController();

   protected Supplier<DataSource<IMAGE>> obtainDataSourceSupplier() {
      Object var2;
      if(this.mDataSourceSupplier != null) {
         var2 = this.mDataSourceSupplier;
      } else {
         if(this.mImageRequest != null) {
            var2 = this.getDataSourceSupplierForRequest(this.mImageRequest);
         } else {
            Object[] var1 = this.mMultiImageRequests;
            var2 = null;
            if(var1 != null) {
               var2 = this.getFirstAvailableDataSourceSupplier(this.mMultiImageRequests, this.mTryCacheOnlyFirst);
            }
         }

         if(var2 != null && this.mLowResImageRequest != null) {
            ArrayList var3 = new ArrayList(2);
            var3.add(var2);
            var3.add(this.getDataSourceSupplierForRequest(this.mLowResImageRequest));
            var2 = IncreasingQualityDataSourceSupplier.create(var3);
         }

         if(var2 == null) {
            return DataSources.getFailedDataSourceSupplier(NO_REQUEST_EXCEPTION);
         }
      }

      return (Supplier)var2;
   }

   public BUILDER reset() {
      this.init();
      return this.getThis();
   }

   public BUILDER setAutoPlayAnimations(boolean var1) {
      this.mAutoPlayAnimations = var1;
      return this.getThis();
   }

   public BUILDER setCallerContext(Object var1) {
      this.mCallerContext = var1;
      return this.getThis();
   }

   public BUILDER setControllerListener(ControllerListener<? super INFO> var1) {
      this.mControllerListener = var1;
      return this.getThis();
   }

   public void setDataSourceSupplier(@Nullable Supplier<DataSource<IMAGE>> var1) {
      this.mDataSourceSupplier = var1;
   }

   public BUILDER setFirstAvailableImageRequests(REQUEST[] var1) {
      return this.setFirstAvailableImageRequests(var1, true);
   }

   public BUILDER setFirstAvailableImageRequests(REQUEST[] var1, boolean var2) {
      this.mMultiImageRequests = var1;
      this.mTryCacheOnlyFirst = var2;
      return this.getThis();
   }

   public BUILDER setImageRequest(REQUEST var1) {
      this.mImageRequest = var1;
      return this.getThis();
   }

   public BUILDER setLowResImageRequest(REQUEST var1) {
      this.mLowResImageRequest = var1;
      return this.getThis();
   }

   public BUILDER setOldController(@Nullable DraweeController var1) {
      this.mOldController = var1;
      return this.getThis();
   }

   public BUILDER setRetainImageOnFailure(boolean var1) {
      this.mRetainImageOnFailure = var1;
      return this.getThis();
   }

   public BUILDER setTapToRetryEnabled(boolean var1) {
      this.mTapToRetryEnabled = var1;
      return this.getThis();
   }

   protected void validate() {
      boolean var1;
      if(this.mMultiImageRequests != null && this.mImageRequest != null) {
         var1 = false;
      } else {
         var1 = true;
      }

      boolean var2;
      label21: {
         Preconditions.checkState(var1, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
         if(this.mDataSourceSupplier != null) {
            Object[] var3 = this.mMultiImageRequests;
            var2 = false;
            if(var3 != null) {
               break label21;
            }

            Object var4 = this.mImageRequest;
            var2 = false;
            if(var4 != null) {
               break label21;
            }

            Object var5 = this.mLowResImageRequest;
            var2 = false;
            if(var5 != null) {
               break label21;
            }
         }

         var2 = true;
      }

      Preconditions.checkState(var2, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
   }
}
