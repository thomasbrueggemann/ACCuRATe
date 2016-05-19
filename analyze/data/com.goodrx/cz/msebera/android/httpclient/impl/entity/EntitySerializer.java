package cz.msebera.android.httpclient.impl.entity;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.impl.io.ChunkedOutputStream;
import cz.msebera.android.httpclient.impl.io.ContentLengthOutputStream;
import cz.msebera.android.httpclient.impl.io.IdentityOutputStream;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.OutputStream;

@Deprecated
public class EntitySerializer {
   private final ContentLengthStrategy lenStrategy;

   public EntitySerializer(ContentLengthStrategy var1) {
      this.lenStrategy = (ContentLengthStrategy)Args.notNull(var1, "Content length strategy");
   }

   protected OutputStream doSerialize(SessionOutputBuffer var1, HttpMessage var2) throws HttpException, IOException {
      long var3 = this.lenStrategy.determineLength(var2);
      return (OutputStream)(var3 == -2L?new ChunkedOutputStream(var1):(var3 == -1L?new IdentityOutputStream(var1):new ContentLengthOutputStream(var1, var3)));
   }

   public void serialize(SessionOutputBuffer var1, HttpMessage var2, HttpEntity var3) throws HttpException, IOException {
      Args.notNull(var1, "Session output buffer");
      Args.notNull(var2, "HTTP message");
      Args.notNull(var3, "HTTP entity");
      OutputStream var7 = this.doSerialize(var1, var2);
      var3.writeTo(var7);
      var7.close();
   }
}
