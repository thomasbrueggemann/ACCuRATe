package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DeferredReleaser {
   private static DeferredReleaser sInstance = null;
   private final Set<DeferredReleaser.Releasable> mPendingReleasables = new HashSet();
   private final Handler mUiHandler = new Handler(Looper.getMainLooper());
   private final Runnable releaseRunnable = new Runnable() {
      public void run() {
         DeferredReleaser.ensureOnUiThread();
         Iterator var1 = DeferredReleaser.this.mPendingReleasables.iterator();

         while(var1.hasNext()) {
            ((DeferredReleaser.Releasable)var1.next()).release();
         }

         DeferredReleaser.this.mPendingReleasables.clear();
      }
   };

   private static void ensureOnUiThread() {
      boolean var0;
      if(Looper.getMainLooper().getThread() == Thread.currentThread()) {
         var0 = true;
      } else {
         var0 = false;
      }

      Preconditions.checkState(var0);
   }

   public static DeferredReleaser getInstance() {
      synchronized(DeferredReleaser.class){}

      DeferredReleaser var1;
      try {
         if(sInstance == null) {
            sInstance = new DeferredReleaser();
         }

         var1 = sInstance;
      } finally {
         ;
      }

      return var1;
   }

   public void cancelDeferredRelease(DeferredReleaser.Releasable var1) {
      ensureOnUiThread();
      this.mPendingReleasables.remove(var1);
   }

   public void scheduleDeferredRelease(DeferredReleaser.Releasable var1) {
      ensureOnUiThread();
      if(this.mPendingReleasables.add(var1) && this.mPendingReleasables.size() == 1) {
         this.mUiHandler.post(this.releaseRunnable);
      }
   }

   public interface Releasable {
      void release();
   }
}
