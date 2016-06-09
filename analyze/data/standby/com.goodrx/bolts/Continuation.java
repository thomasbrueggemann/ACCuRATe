package bolts;

import bolts.Task;

public interface Continuation<TTaskResult, TContinuationResult> {
   TContinuationResult then(Task<TTaskResult> var1) throws Exception;
}
