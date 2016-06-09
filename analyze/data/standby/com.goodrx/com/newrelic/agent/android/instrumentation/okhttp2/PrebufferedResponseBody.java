package com.newrelic.agent.android.instrumentation.okhttp2;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import okio.BufferedSource;

public class PrebufferedResponseBody extends ResponseBody {
   private ResponseBody impl;
   private BufferedSource source;

   public PrebufferedResponseBody(ResponseBody var1, BufferedSource var2) {
      this.impl = var1;
      this.source = var2;
   }

   public void close() throws IOException {
      this.impl.close();
   }

   public long contentLength() {
      return this.source.buffer().size();
   }

   public MediaType contentType() {
      return this.impl.contentType();
   }

   public BufferedSource source() {
      return this.source;
   }
}
