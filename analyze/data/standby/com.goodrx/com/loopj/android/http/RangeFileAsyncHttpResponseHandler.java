package com.loopj.android.http;

import com.loopj.android.http.FileAsyncHttpResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;

public abstract class RangeFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler {
   private boolean append;
   private long current;

   public void updateRequestHeaders(HttpUriRequest var1) {
      if(this.file.exists() && this.file.canWrite()) {
         this.current = this.file.length();
      }

      if(this.current > 0L) {
         this.append = true;
         var1.setHeader("Range", "bytes=" + this.current + "-");
      }

   }
}
