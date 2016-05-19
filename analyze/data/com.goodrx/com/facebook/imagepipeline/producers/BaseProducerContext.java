package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerContextCallbacks;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class BaseProducerContext implements ProducerContext {
   @GuardedBy("this")
   private final List<ProducerContextCallbacks> mCallbacks;
   private final Object mCallerContext;
   private final String mId;
   private final ImageRequest mImageRequest;
   @GuardedBy("this")
   private boolean mIsCancelled;
   @GuardedBy("this")
   private boolean mIsIntermediateResultExpected;
   @GuardedBy("this")
   private boolean mIsPrefetch;
   private final ImageRequest.RequestLevel mLowestPermittedRequestLevel;
   @GuardedBy("this")
   private Priority mPriority;
   private final ProducerListener mProducerListener;

   public BaseProducerContext(ImageRequest var1, String var2, ProducerListener var3, Object var4, ImageRequest.RequestLevel var5, boolean var6, boolean var7, Priority var8) {
      this.mImageRequest = var1;
      this.mId = var2;
      this.mProducerListener = var3;
      this.mCallerContext = var4;
      this.mLowestPermittedRequestLevel = var5;
      this.mIsPrefetch = var6;
      this.mPriority = var8;
      this.mIsIntermediateResultExpected = var7;
      this.mIsCancelled = false;
      this.mCallbacks = new ArrayList();
   }

   public static void callOnCancellationRequested(@Nullable List<ProducerContextCallbacks> var0) {
      if(var0 != null) {
         Iterator var1 = var0.iterator();

         while(var1.hasNext()) {
            ((ProducerContextCallbacks)var1.next()).onCancellationRequested();
         }
      }

   }

   public static void callOnIsIntermediateResultExpectedChanged(@Nullable List<ProducerContextCallbacks> var0) {
      if(var0 != null) {
         Iterator var1 = var0.iterator();

         while(var1.hasNext()) {
            ((ProducerContextCallbacks)var1.next()).onIsIntermediateResultExpectedChanged();
         }
      }

   }

   public static void callOnIsPrefetchChanged(@Nullable List<ProducerContextCallbacks> var0) {
      if(var0 != null) {
         Iterator var1 = var0.iterator();

         while(var1.hasNext()) {
            ((ProducerContextCallbacks)var1.next()).onIsPrefetchChanged();
         }
      }

   }

   public static void callOnPriorityChanged(@Nullable List<ProducerContextCallbacks> var0) {
      if(var0 != null) {
         Iterator var1 = var0.iterator();

         while(var1.hasNext()) {
            ((ProducerContextCallbacks)var1.next()).onPriorityChanged();
         }
      }

   }

   public void addCallbacks(ProducerContextCallbacks param1) {
      // $FF: Couldn't be decompiled
   }

   public void cancel() {
      callOnCancellationRequested(this.cancelNoCallbacks());
   }

   @Nullable
   public List<ProducerContextCallbacks> cancelNoCallbacks() {
      // $FF: Couldn't be decompiled
   }

   public Object getCallerContext() {
      return this.mCallerContext;
   }

   public String getId() {
      return this.mId;
   }

   public ImageRequest getImageRequest() {
      return this.mImageRequest;
   }

   public ProducerListener getListener() {
      return this.mProducerListener;
   }

   public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
      return this.mLowestPermittedRequestLevel;
   }

   public Priority getPriority() {
      synchronized(this){}

      Priority var2;
      try {
         var2 = this.mPriority;
      } finally {
         ;
      }

      return var2;
   }

   public boolean isCancelled() {
      synchronized(this){}

      boolean var2;
      try {
         var2 = this.mIsCancelled;
      } finally {
         ;
      }

      return var2;
   }

   public boolean isIntermediateResultExpected() {
      synchronized(this){}

      boolean var2;
      try {
         var2 = this.mIsIntermediateResultExpected;
      } finally {
         ;
      }

      return var2;
   }

   public boolean isPrefetch() {
      synchronized(this){}

      boolean var2;
      try {
         var2 = this.mIsPrefetch;
      } finally {
         ;
      }

      return var2;
   }

   @Nullable
   public List<ProducerContextCallbacks> setIsIntermediateResultExpectedNoCallbacks(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   @Nullable
   public List<ProducerContextCallbacks> setIsPrefetchNoCallbacks(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   @Nullable
   public List<ProducerContextCallbacks> setPriorityNoCallbacks(Priority param1) {
      // $FF: Couldn't be decompiled
   }
}
