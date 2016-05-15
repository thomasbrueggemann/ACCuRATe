package com.facebook.datasource;

import com.facebook.datasource.DataSubscriber;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public interface DataSource<T> {
   boolean close();

   @Nullable
   Throwable getFailureCause();

   float getProgress();

   @Nullable
   T getResult();

   boolean hasFailed();

   boolean hasResult();

   boolean isClosed();

   boolean isFinished();

   void subscribe(DataSubscriber<T> var1, Executor var2);
}
