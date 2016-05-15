package bolts;

import bolts.Task;

public class TaskCompletionSource<TResult> {
   private final Task<TResult> task = new Task();

   public Task<TResult> getTask() {
      return this.task;
   }

   public void setCancelled() {
      if(!this.trySetCancelled()) {
         throw new IllegalStateException("Cannot cancel a completed task.");
      }
   }

   public void setError(Exception var1) {
      if(!this.trySetError(var1)) {
         throw new IllegalStateException("Cannot set the error on a completed task.");
      }
   }

   public void setResult(TResult var1) {
      if(!this.trySetResult(var1)) {
         throw new IllegalStateException("Cannot set the result of a completed task.");
      }
   }

   public boolean trySetCancelled() {
      return this.task.trySetCancelled();
   }

   public boolean trySetError(Exception var1) {
      return this.task.trySetError(var1);
   }

   public boolean trySetResult(TResult var1) {
      return this.task.trySetResult(var1);
   }
}
