package com.koushikdutta.async.future;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ContinuationCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.DependentCancellable;
import com.koushikdutta.async.future.DependentFuture;
import com.koushikdutta.async.future.SimpleCancellable;
import java.util.LinkedList;

public class Continuation extends SimpleCancellable implements ContinuationCallback, Runnable, Cancellable {
   CompletedCallback callback;
   Runnable cancelCallback;
   private boolean inNext;
   LinkedList<ContinuationCallback> mCallbacks;
   boolean started;
   private boolean waiting;

   public Continuation() {
      this((CompletedCallback)null);
   }

   public Continuation(CompletedCallback var1) {
      this(var1, (Runnable)null);
   }

   public Continuation(CompletedCallback var1, Runnable var2) {
      this.mCallbacks = new LinkedList();
      this.cancelCallback = var2;
      this.callback = var1;
   }

   private ContinuationCallback hook(ContinuationCallback var1) {
      if(var1 instanceof DependentCancellable) {
         ((DependentCancellable)var1).setParent(this);
      }

      return var1;
   }

   private void next() {
      if(!this.inNext) {
         while(true) {
            if(this.mCallbacks.size() <= 0 || this.waiting || this.isDone() || this.isCancelled()) {
               if(!this.waiting && !this.isDone() && !this.isCancelled()) {
                  this.reportCompleted((Exception)null);
                  return;
               }
               break;
            }

            ContinuationCallback var1 = (ContinuationCallback)this.mCallbacks.remove();

            try {
               this.inNext = true;
               this.waiting = true;
               var1.onContinue(this, this.wrap());
            } catch (Exception var6) {
               this.reportCompleted(var6);
            } finally {
               this.inNext = false;
            }
         }
      }

   }

   private CompletedCallback wrap() {
      return new CompletedCallback() {
         // $FF: synthetic field
         static final boolean $assertionsDisabled;
         boolean mThisCompleted;

         static {
            boolean var0;
            if(!Continuation.class.desiredAssertionStatus()) {
               var0 = true;
            } else {
               var0 = false;
            }

            $assertionsDisabled = var0;
         }

         public void onCompleted(Exception var1) {
            if(!this.mThisCompleted) {
               this.mThisCompleted = true;
               if(!$assertionsDisabled && !Continuation.this.waiting) {
                  throw new AssertionError();
               } else {
                  Continuation.this.waiting = false;
                  if(var1 == null) {
                     Continuation.this.next();
                  } else {
                     Continuation.this.reportCompleted(var1);
                  }
               }
            }
         }
      };
   }

   public Continuation add(ContinuationCallback var1) {
      this.mCallbacks.add(this.hook(var1));
      return this;
   }

   public void add(final DependentFuture var1) {
      var1.setParent(this);
      this.add(new ContinuationCallback() {
         public void onContinue(Continuation var1x, CompletedCallback var2) throws Exception {
            var1.get();
            var2.onCompleted((Exception)null);
         }
      });
   }

   public boolean cancel() {
      if(!super.cancel()) {
         return false;
      } else {
         if(this.cancelCallback != null) {
            this.cancelCallback.run();
         }

         return true;
      }
   }

   public CompletedCallback getCallback() {
      return this.callback;
   }

   public Runnable getCancelCallback() {
      return this.cancelCallback;
   }

   public Continuation insert(ContinuationCallback var1) {
      this.mCallbacks.add(0, this.hook(var1));
      return this;
   }

   public void onContinue(Continuation var1, CompletedCallback var2) throws Exception {
      this.setCallback(var2);
      this.start();
   }

   void reportCompleted(Exception var1) {
      if(this.setComplete() && this.callback != null) {
         this.callback.onCompleted(var1);
      }
   }

   public void run() {
      this.start();
   }

   public void setCallback(CompletedCallback var1) {
      this.callback = var1;
   }

   public void setCancelCallback(final Cancellable var1) {
      if(var1 == null) {
         this.cancelCallback = null;
      } else {
         this.cancelCallback = new Runnable() {
            public void run() {
               var1.cancel();
            }
         };
      }
   }

   public void setCancelCallback(Runnable var1) {
      this.cancelCallback = var1;
   }

   public Continuation start() {
      if(this.started) {
         throw new IllegalStateException("already started");
      } else {
         this.started = true;
         this.next();
         return this;
      }
   }
}
