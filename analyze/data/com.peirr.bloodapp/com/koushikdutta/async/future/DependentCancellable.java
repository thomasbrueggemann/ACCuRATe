package com.koushikdutta.async.future;

import com.koushikdutta.async.future.Cancellable;

public interface DependentCancellable extends Cancellable {
   DependentCancellable setParent(Cancellable var1);
}
