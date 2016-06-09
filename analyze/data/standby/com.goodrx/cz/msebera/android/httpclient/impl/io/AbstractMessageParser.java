package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.MessageConstraintException;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.BasicLineParser;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.params.HttpParamConfig;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMessageParser<T extends HttpMessage> implements HttpMessageParser<T> {
   private final List<CharArrayBuffer> headerLines;
   protected final LineParser lineParser;
   private T message;
   private final MessageConstraints messageConstraints;
   private final SessionInputBuffer sessionBuffer;
   private int state;

   @Deprecated
   public AbstractMessageParser(SessionInputBuffer var1, LineParser var2, HttpParams var3) {
      Args.notNull(var1, "Session input buffer");
      Args.notNull(var3, "HTTP parameters");
      this.sessionBuffer = var1;
      this.messageConstraints = HttpParamConfig.getMessageConstraints(var3);
      if(var2 == null) {
         var2 = BasicLineParser.INSTANCE;
      }

      this.lineParser = (LineParser)var2;
      this.headerLines = new ArrayList();
      this.state = 0;
   }

   public static Header[] parseHeaders(SessionInputBuffer var0, int var1, int var2, LineParser var3) throws HttpException, IOException {
      ArrayList var4 = new ArrayList();
      if(var3 == null) {
         var3 = BasicLineParser.INSTANCE;
      }

      return parseHeaders(var0, var1, var2, (LineParser)var3, var4);
   }

   public static Header[] parseHeaders(SessionInputBuffer var0, int var1, int var2, LineParser var3, List<CharArrayBuffer> var4) throws HttpException, IOException {
      Args.notNull(var0, "Session input buffer");
      Args.notNull(var3, "Line parser");
      Args.notNull(var4, "Header line list");
      CharArrayBuffer var8 = null;
      CharArrayBuffer var9 = null;

      do {
         if(var8 == null) {
            var8 = new CharArrayBuffer(64);
         } else {
            var8.clear();
         }

         if(var0.readLine(var8) == -1 || var8.length() < 1) {
            Header[] var10 = new Header[var4.size()];

            for(int var11 = 0; var11 < var4.size(); ++var11) {
               CharArrayBuffer var12 = (CharArrayBuffer)var4.get(var11);

               try {
                  var10[var11] = var3.parseHeader(var12);
               } catch (ParseException var17) {
                  throw new ProtocolException(var17.getMessage());
               }
            }

            return var10;
         }

         if((var8.charAt(0) == 32 || var8.charAt(0) == 9) && var9 != null) {
            int var15;
            for(var15 = 0; var15 < var8.length(); ++var15) {
               char var16 = var8.charAt(var15);
               if(var16 != 32 && var16 != 9) {
                  break;
               }
            }

            if(var2 > 0 && 1 + var9.length() + var8.length() - var15 > var2) {
               throw new MessageConstraintException("Maximum line length limit exceeded");
            }

            var9.append(' ');
            var9.append(var8, var15, var8.length() - var15);
         } else {
            var4.add(var8);
            var9 = var8;
            var8 = null;
         }
      } while(var1 <= 0 || var4.size() < var1);

      throw new MessageConstraintException("Maximum header count exceeded");
   }

   public T parse() throws IOException, HttpException {
      switch(this.state) {
      case 0:
         try {
            this.message = this.parseHead(this.sessionBuffer);
         } catch (ParseException var4) {
            throw new ProtocolException(var4.getMessage(), var4);
         }

         this.state = 1;
      case 1:
         Header[] var1 = parseHeaders(this.sessionBuffer, this.messageConstraints.getMaxHeaderCount(), this.messageConstraints.getMaxLineLength(), this.lineParser, this.headerLines);
         this.message.setHeaders(var1);
         HttpMessage var2 = this.message;
         this.message = null;
         this.headerLines.clear();
         this.state = 0;
         return var2;
      default:
         throw new IllegalStateException("Inconsistent parser state");
      }
   }

   protected abstract T parseHead(SessionInputBuffer var1) throws IOException, HttpException, ParseException;
}
