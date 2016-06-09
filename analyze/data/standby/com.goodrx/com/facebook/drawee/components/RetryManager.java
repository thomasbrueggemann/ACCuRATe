package com.facebook.drawee.components;

public class RetryManager {
   private static final int MAX_TAP_TO_RETRY_ATTEMPTS = 4;
   private int mMaxTapToRetryAttempts;
   private int mTapToRetryAttempts;
   private boolean mTapToRetryEnabled;

   public RetryManager() {
      this.init();
   }

   public static RetryManager newInstance() {
      return new RetryManager();
   }

   public void init() {
      this.mTapToRetryEnabled = false;
      this.mMaxTapToRetryAttempts = 4;
      this.reset();
   }

   public boolean isTapToRetryEnabled() {
      return this.mTapToRetryEnabled;
   }

   public void notifyTapToRetry() {
      ++this.mTapToRetryAttempts;
   }

   public void reset() {
      this.mTapToRetryAttempts = 0;
   }

   public void setTapToRetryEnabled(boolean var1) {
      this.mTapToRetryEnabled = var1;
   }

   public boolean shouldRetryOnTap() {
      return this.mTapToRetryEnabled && this.mTapToRetryAttempts < this.mMaxTapToRetryAttempts;
   }
}
