package com.koushikdutta.async.future;

import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.DependentCancellable;

public class SimpleCancellable implements DependentCancellable {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   public static final Cancellable COMPLETED;
   boolean cancelled;
   boolean complete;
   private Cancellable parent;

   static {
      boolean var0;
      if(!SimpleCancellable.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
      COMPLETED = new SimpleCancellable() {
         {
            this.setComplete();
         }
      };
   }

   public boolean cancel() {
      // $FF: Couldn't be decompiled
   }

   protected void cancelCleanup() {
   }

   protected void cleanup() {
   }

   protected void completeCleanup() {
   }

   public boolean isCancelled() {
      return this.cancelled || this.parent != null && this.parent.isCancelled();
   }

   public boolean isDone() {
      return this.complete;
   }

   public Cancellable reset() {
      this.cancel();
      this.complete = false;
      this.cancelled = false;
      return this;
   }

   public boolean setComplete() {
      // $FF: Couldn't be decompiled
   }

   public SimpleCancellable setParent(Cancellable param1) {
      // $FF: Couldn't be decompiled
   }
}
