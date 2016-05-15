package com.newrelic.agent.android.instrumentation.retrofit;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import retrofit.mime.TypedInput;

public class EmptyBodyTypedInput implements TypedInput {
   // $FF: renamed from: in () java.io.InputStream
   public InputStream method_452() throws IOException {
      return new ByteArrayInputStream(new byte[0]);
   }

   public long length() {
      return 0L;
   }

   public String mimeType() {
      return "text/html;charset=utf-8";
   }
}
