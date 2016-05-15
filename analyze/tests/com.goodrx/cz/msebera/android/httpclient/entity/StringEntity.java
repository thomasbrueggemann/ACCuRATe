package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.entity.AbstractHttpEntity;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class StringEntity extends AbstractHttpEntity implements Cloneable {
   protected final byte[] content;

   public StringEntity(String var1, ContentType var2) throws UnsupportedCharsetException {
      Args.notNull(var1, "Source string");
      Charset var4;
      if(var2 != null) {
         var4 = var2.getCharset();
      } else {
         var4 = null;
      }

      if(var4 == null) {
         var4 = HTTP.DEF_CONTENT_CHARSET;
      }

      try {
         this.content = var1.getBytes(var4.name());
      } catch (UnsupportedEncodingException var6) {
         throw new UnsupportedCharsetException(var4.name());
      }

      if(var2 != null) {
         this.setContentType(var2.toString());
      }

   }

   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   public InputStream getContent() throws IOException {
      return new ByteArrayInputStream(this.content);
   }

   public long getContentLength() {
      return (long)this.content.length;
   }

   public boolean isRepeatable() {
      return true;
   }

   public boolean isStreaming() {
      return false;
   }

   public void writeTo(OutputStream var1) throws IOException {
      Args.notNull(var1, "Output stream");
      var1.write(this.content);
      var1.flush();
   }
}
