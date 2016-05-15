package com.loopj.android.http;

import com.loopj.android.http.AsyncHttpRequest;
import java.lang.ref.WeakReference;

public class RequestHandle {
   private final WeakReference<AsyncHttpRequest> request;

   public RequestHandle(AsyncHttpRequest var1) {
      this.request = new WeakReference(var1);
   }

   public boolean isCancelled() {
      AsyncHttpRequest var1 = (AsyncHttpRequest)this.request.get();
      return var1 == null || var1.isCancelled();
   }

   public boolean isFinished() {
      AsyncHttpRequest var1 = (AsyncHttpRequest)this.request.get();
      return var1 == null || var1.isDone();
   }

   public boolean shouldBeGarbageCollected() {
      boolean var1;
      if(!this.isCancelled() && !this.isFinished()) {
         var1 = false;
      } else {
         var1 = true;
      }

      if(var1) {
         this.request.clear();
      }

      return var1;
   }
}
