package android.support.v4.os;

import android.support.v4.os.OperationCanceledException;

public final class CancellationSignal {
   private boolean mCancelInProgress;
   private Object mCancellationSignalObj;
   private boolean mIsCanceled;
   private CancellationSignal.OnCancelListener mOnCancelListener;

   private void waitForCancelFinishedLocked() {
      while(this.mCancelInProgress) {
         try {
            this.wait();
         } catch (InterruptedException var2) {
            ;
         }
      }

   }

   public void cancel() {
      // $FF: Couldn't be decompiled
   }

   public Object getCancellationSignalObject() {
      // $FF: Couldn't be decompiled
   }

   public boolean isCanceled() {
      // $FF: Couldn't be decompiled
   }

   public void setOnCancelListener(CancellationSignal.OnCancelListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void throwIfCanceled() {
      if(this.isCanceled()) {
         throw new OperationCanceledException();
      }
   }

   public interface OnCancelListener {
      void onCancel();
   }
}
