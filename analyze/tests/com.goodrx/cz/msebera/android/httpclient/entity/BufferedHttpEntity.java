package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedHttpEntity extends HttpEntityWrapper {
   private final byte[] buffer;

   public BufferedHttpEntity(HttpEntity var1) throws IOException {
      super(var1);
      if(var1.isRepeatable() && var1.getContentLength() >= 0L) {
         this.buffer = null;
      } else {
         this.buffer = EntityUtils.toByteArray(var1);
      }
   }

   public InputStream getContent() throws IOException {
      return (InputStream)(this.buffer != null?new ByteArrayInputStream(this.buffer):super.getContent());
   }

   public long getContentLength() {
      return this.buffer != null?(long)this.buffer.length:super.getContentLength();
   }

   public boolean isChunked() {
      return this.buffer == null && super.isChunked();
   }

   public boolean isRepeatable() {
      return true;
   }

   public boolean isStreaming() {
      return this.buffer == null && super.isStreaming();
   }

   public void writeTo(OutputStream var1) throws IOException {
      Args.notNull(var1, "Output stream");
      if(this.buffer != null) {
         var1.write(this.buffer);
      } else {
         super.writeTo(var1);
      }
   }
}
