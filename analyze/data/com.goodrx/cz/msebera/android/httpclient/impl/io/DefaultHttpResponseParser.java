package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.StatusLine;
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
   private final HttpResponseFactory responseFactory;

   @Deprecated
   public DefaultHttpResponseParser(SessionInputBuffer var1, LineParser var2, HttpResponseFactory var3, HttpParams var4) {
      super(var1, var2, var4);
      this.responseFactory = (HttpResponseFactory)Args.notNull(var3, "Response factory");
      this.lineBuf = new CharArrayBuffer(128);
   }

   protected HttpResponse parseHead(SessionInputBuffer var1) throws IOException, HttpException, ParseException {
      this.lineBuf.clear();
      if(var1.readLine(this.lineBuf) == -1) {
         throw new NoHttpResponseException("The target server failed to respond");
      } else {
         ParserCursor var2 = new ParserCursor(0, this.lineBuf.length());
         StatusLine var3 = this.lineParser.parseStatusLine(this.lineBuf, var2);
         return this.responseFactory.newHttpResponse(var3, (HttpContext)null);
      }
   }
}
