package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.entity.AbstractHttpEntity;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BasicHttpEntity extends AbstractHttpEntity {
   private InputStream content;
   private long length = -1L;

   public InputStream getContent() throws IllegalStateException {
      boolean var1;
      if(this.content != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      Asserts.check(var1, "Content has not been provided");
      return this.content;
   }

   public long getContentLength() {
      return this.length;
   }

   public boolean isRepeatable() {
      return false;
   }

   public boolean isStreaming() {
      return this.content != null;
   }

   public void setContent(InputStream var1) {
      this.content = var1;
   }

   public void setContentLength(long var1) {
      this.length = var1;
   }

   public void writeTo(OutputStream param1) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
