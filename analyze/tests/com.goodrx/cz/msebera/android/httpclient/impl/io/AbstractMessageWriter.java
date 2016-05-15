package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.io.HttpMessageWriter;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.BasicLineFormatter;
import cz.msebera.android.httpclient.message.LineFormatter;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

public abstract class AbstractMessageWriter<T extends HttpMessage> implements HttpMessageWriter<T> {
   protected final CharArrayBuffer lineBuf;
   protected final LineFormatter lineFormatter;
   protected final SessionOutputBuffer sessionBuffer;

   @Deprecated
   public AbstractMessageWriter(SessionOutputBuffer var1, LineFormatter var2, HttpParams var3) {
      Args.notNull(var1, "Session input buffer");
      this.sessionBuffer = var1;
      this.lineBuf = new CharArrayBuffer(128);
      if(var2 == null) {
         var2 = BasicLineFormatter.INSTANCE;
      }

      this.lineFormatter = (LineFormatter)var2;
   }

   public void write(T var1) throws IOException, HttpException {
      Args.notNull(var1, "HTTP message");
      this.writeHeadLine(var1);
      HeaderIterator var3 = var1.headerIterator();

      while(var3.hasNext()) {
         Header var4 = var3.nextHeader();
         this.sessionBuffer.writeLine(this.lineFormatter.formatHeader(this.lineBuf, var4));
      }

      this.lineBuf.clear();
      this.sessionBuffer.writeLine(this.lineBuf);
   }

   protected abstract void writeHeadLine(T var1) throws IOException;
}
