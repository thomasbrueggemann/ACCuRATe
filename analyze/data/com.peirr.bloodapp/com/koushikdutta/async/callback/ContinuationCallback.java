package com.koushikdutta.async.callback;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Continuation;

public interface ContinuationCallback {
   void onContinue(Continuation var1, CompletedCallback var2) throws Exception;
}
