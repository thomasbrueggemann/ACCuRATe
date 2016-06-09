package bolts;

import bolts.Task;

class UnobservedErrorNotifier {
   private Task<?> task;

   public UnobservedErrorNotifier(Task<?> var1) {
      this.task = var1;
   }

   protected void finalize() throws Throwable {
      // $FF: Couldn't be decompiled
   }

   public void setObserved() {
      this.task = null;
   }
}
