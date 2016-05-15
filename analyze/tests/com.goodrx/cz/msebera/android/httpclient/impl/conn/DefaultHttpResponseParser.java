package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.io.AbstractMessageParser;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

public class DefaultHttpResponseParser extends AbstractMessageParser<HttpResponse> {
   private final CharArrayBuffer lineBuf;
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());
   private final HttpResponseFactory responseFactory;

   @Deprecated
   public DefaultHttpResponseParser(SessionInputBuffer var1, LineParser var2, HttpResponseFactory var3, HttpParams var4) {
      super(var1, var2, var4);
      Args.notNull(var3, "Response factory");
      this.responseFactory = var3;
      this.lineBuf = new CharArrayBuffer(128);
   }

   protected HttpResponse parseHead(SessionInputBuffer var1) throws IOException, HttpException {
      int var2 = 0;

      while(true) {
         this.lineBuf.clear();
         int var3 = var1.readLine(this.lineBuf);
         if(var3 == -1 && var2 == 0) {
            throw new NoHttpResponseException("The target server failed to respond");
         }

         ParserCursor var4 = new ParserCursor(0, this.lineBuf.length());
         if(this.lineParser.hasProtocolVersion(this.lineBuf, var4)) {
            StatusLine var5 = this.lineParser.parseStatusLine(this.lineBuf, var4);
            return this.responseFactory.newHttpResponse(var5, (HttpContext)null);
         }

         if(var3 == -1 || this.reject(this.lineBuf, var2)) {
            throw new ProtocolException("The server failed to respond with a valid HTTP response");
         }

         if(this.log.isDebugEnabled()) {
            this.log.debug("Garbage in response: " + this.lineBuf.toString());
         }

         ++var2;
      }
   }

   protected boolean reject(CharArrayBuffer var1, int var2) {
      return false;
   }
}
