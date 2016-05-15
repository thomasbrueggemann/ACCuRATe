package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.impl.io.AbstractMessageWriter;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.LineFormatter;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;

@Deprecated
public class HttpRequestWriter extends AbstractMessageWriter<HttpRequest> {
   public HttpRequestWriter(SessionOutputBuffer var1, LineFormatter var2, HttpParams var3) {
      super(var1, var2, var3);
   }

   protected void writeHeadLine(HttpRequest var1) throws IOException {
      this.lineFormatter.formatRequestLine(this.lineBuf, var1.getRequestLine());
      this.sessionBuffer.writeLine(this.lineBuf);
   }
}
