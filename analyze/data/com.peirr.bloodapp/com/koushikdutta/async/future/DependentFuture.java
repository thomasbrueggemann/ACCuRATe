package com.koushikdutta.async.future;

import com.koushikdutta.async.future.DependentCancellable;
import com.koushikdutta.async.future.Future;

public interface DependentFuture<T> extends Future<T>, DependentCancellable {
}
