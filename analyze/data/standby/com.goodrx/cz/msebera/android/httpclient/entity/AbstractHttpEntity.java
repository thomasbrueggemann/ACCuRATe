package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.IOException;

public abstract class AbstractHttpEntity implements HttpEntity {
   protected boolean chunked;
   protected Header contentEncoding;
   protected Header contentType;

   @Deprecated
   public void consumeContent() throws IOException {
   }

   public Header getContentEncoding() {
      return this.contentEncoding;
   }

   public Header getContentType() {
      return this.contentType;
   }

   public boolean isChunked() {
      return this.chunked;
   }

   public void setChunked(boolean var1) {
      this.chunked = var1;
   }

   public void setContentEncoding(Header var1) {
      this.contentEncoding = var1;
   }

   public void setContentType(Header var1) {
      this.contentType = var1;
   }

   public void setContentType(String var1) {
      BasicHeader var2 = null;
      if(var1 != null) {
         var2 = new BasicHeader("Content-Type", var1);
      }

      this.setContentType((Header)var2);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append('[');
      if(this.contentType != null) {
         var1.append("Content-Type: ");
         var1.append(this.contentType.getValue());
         var1.append(',');
      }

      if(this.contentEncoding != null) {
         var1.append("Content-Encoding: ");
         var1.append(this.contentEncoding.getValue());
         var1.append(',');
      }

      long var3 = this.getContentLength();
      if(var3 >= 0L) {
         var1.append("Content-Length: ");
         var1.append(var3);
         var1.append(',');
      }

      var1.append("Chunked: ");
      var1.append(this.chunked);
      var1.append(']');
      return var1.toString();
   }
}
