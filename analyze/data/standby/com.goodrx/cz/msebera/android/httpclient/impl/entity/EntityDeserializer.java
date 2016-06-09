package cz.msebera.android.httpclient.impl.entity;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.entity.BasicHttpEntity;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.ChunkedInputStream;
import cz.msebera.android.httpclient.impl.io.ContentLengthInputStream;
import cz.msebera.android.httpclient.impl.io.IdentityInputStream;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

@Deprecated
public class EntityDeserializer {
   private final ContentLengthStrategy lenStrategy;

   public EntityDeserializer(ContentLengthStrategy var1) {
      this.lenStrategy = (ContentLengthStrategy)Args.notNull(var1, "Content length strategy");
   }

   public HttpEntity deserialize(SessionInputBuffer var1, HttpMessage var2) throws HttpException, IOException {
      Args.notNull(var1, "Session input buffer");
      Args.notNull(var2, "HTTP message");
      return this.doDeserialize(var1, var2);
   }

   protected BasicHttpEntity doDeserialize(SessionInputBuffer var1, HttpMessage var2) throws HttpException, IOException {
      BasicHttpEntity var3 = new BasicHttpEntity();
      long var4 = this.lenStrategy.determineLength(var2);
      if(var4 == -2L) {
         var3.setChunked(true);
         var3.setContentLength(-1L);
         var3.setContent(new ChunkedInputStream(var1));
      } else if(var4 == -1L) {
         var3.setChunked(false);
         var3.setContentLength(-1L);
         var3.setContent(new IdentityInputStream(var1));
      } else {
         var3.setChunked(false);
         var3.setContentLength(var4);
         var3.setContent(new ContentLengthInputStream(var1, var4));
      }

      Header var6 = var2.getFirstHeader("Content-Type");
      if(var6 != null) {
         var3.setContentType(var6);
      }

      Header var7 = var2.getFirstHeader("Content-Encoding");
      if(var7 != null) {
         var3.setContentEncoding(var7);
      }

      return var3;
   }
}
