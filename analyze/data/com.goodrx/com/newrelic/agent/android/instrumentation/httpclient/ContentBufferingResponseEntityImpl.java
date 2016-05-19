package com.newrelic.agent.android.instrumentation.httpclient;

import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class ContentBufferingResponseEntityImpl implements HttpEntity {
   private CountingInputStream contentStream;
   final HttpEntity impl;

   public ContentBufferingResponseEntityImpl(HttpEntity var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Missing wrapped entity");
      } else {
         this.impl = var1;
      }
   }

   public void consumeContent() throws IOException {
      this.impl.consumeContent();
   }

   public InputStream getContent() throws IOException, IllegalStateException {
      if(this.contentStream != null) {
         return this.contentStream;
      } else {
         this.contentStream = new CountingInputStream(this.impl.getContent(), true);
         return this.contentStream;
      }
   }

   public Header getContentEncoding() {
      return this.impl.getContentEncoding();
   }

   public long getContentLength() {
      return this.impl.getContentLength();
   }

   public Header getContentType() {
      return this.impl.getContentType();
   }

   public boolean isChunked() {
      return this.impl.isChunked();
   }

   public boolean isRepeatable() {
      return this.impl.isRepeatable();
   }

   public boolean isStreaming() {
      return this.impl.isStreaming();
   }

   public void writeTo(OutputStream var1) throws IOException {
      this.impl.writeTo(var1);
   }
}
