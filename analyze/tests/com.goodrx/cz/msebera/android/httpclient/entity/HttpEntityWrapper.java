package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HttpEntityWrapper implements HttpEntity {
   protected HttpEntity wrappedEntity;

   public HttpEntityWrapper(HttpEntity var1) {
      this.wrappedEntity = (HttpEntity)Args.notNull(var1, "Wrapped entity");
   }

   @Deprecated
   public void consumeContent() throws IOException {
      this.wrappedEntity.consumeContent();
   }

   public InputStream getContent() throws IOException {
      return this.wrappedEntity.getContent();
   }

   public Header getContentEncoding() {
      return this.wrappedEntity.getContentEncoding();
   }

   public long getContentLength() {
      return this.wrappedEntity.getContentLength();
   }

   public Header getContentType() {
      return this.wrappedEntity.getContentType();
   }

   public boolean isChunked() {
      return this.wrappedEntity.isChunked();
   }

   public boolean isRepeatable() {
      return this.wrappedEntity.isRepeatable();
   }

   public boolean isStreaming() {
      return this.wrappedEntity.isStreaming();
   }

   public void writeTo(OutputStream var1) throws IOException {
      this.wrappedEntity.writeTo(var1);
   }
}
