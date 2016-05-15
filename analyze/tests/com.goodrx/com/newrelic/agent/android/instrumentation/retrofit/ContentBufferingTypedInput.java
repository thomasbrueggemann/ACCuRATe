package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.instrumentation.retrofit.EmptyBodyTypedInput;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import retrofit.mime.TypedInput;

public class ContentBufferingTypedInput implements TypedInput {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private TypedInput impl;
   private CountingInputStream inputStream;

   public ContentBufferingTypedInput(TypedInput var1) {
      if(var1 == null) {
         var1 = new EmptyBodyTypedInput();
      }

      this.impl = (TypedInput)var1;
      this.inputStream = null;
   }

   private void prepareInputStream() throws IOException {
      if(this.inputStream == null) {
         Object var1 = this.impl.in();
         if(var1 == null) {
            var1 = new ByteArrayInputStream(new byte[0]);
         }

         this.inputStream = new CountingInputStream((InputStream)var1, true);
      }

   }

   // $FF: renamed from: in () java.io.InputStream
   public InputStream method_472() throws IOException {
      this.prepareInputStream();
      return this.inputStream;
   }

   public long length() {
      int var2;
      try {
         this.prepareInputStream();
         var2 = this.inputStream.available();
      } catch (IOException var3) {
         log.error("ContentBufferingTypedInput generated an IO exception: ", var3);
         return -1L;
      }

      return (long)var2;
   }

   public String mimeType() {
      return this.impl.mimeType();
   }
}
