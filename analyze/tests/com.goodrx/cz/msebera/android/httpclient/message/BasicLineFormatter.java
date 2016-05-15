package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.message.LineFormatter;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

public class BasicLineFormatter implements LineFormatter {
   @Deprecated
   public static final BasicLineFormatter DEFAULT = new BasicLineFormatter();
   public static final BasicLineFormatter INSTANCE = new BasicLineFormatter();

   public CharArrayBuffer appendProtocolVersion(CharArrayBuffer var1, ProtocolVersion var2) {
      Args.notNull(var2, "Protocol version");
      CharArrayBuffer var4 = var1;
      int var5 = this.estimateProtocolVersionLen(var2);
      if(var1 == null) {
         var4 = new CharArrayBuffer(var5);
      } else {
         var1.ensureCapacity(var5);
      }

      var4.append(var2.getProtocol());
      var4.append('/');
      var4.append(Integer.toString(var2.getMajor()));
      var4.append('.');
      var4.append(Integer.toString(var2.getMinor()));
      return var4;
   }

   protected void doFormatHeader(CharArrayBuffer var1, Header var2) {
      String var3 = var2.getName();
      String var4 = var2.getValue();
      int var5 = 2 + var3.length();
      if(var4 != null) {
         var5 += var4.length();
      }

      var1.ensureCapacity(var5);
      var1.append(var3);
      var1.append(": ");
      if(var4 != null) {
         var1.append(var4);
      }

   }

   protected void doFormatRequestLine(CharArrayBuffer var1, RequestLine var2) {
      String var3 = var2.getMethod();
      String var4 = var2.getUri();
      var1.ensureCapacity(1 + 1 + var3.length() + var4.length() + this.estimateProtocolVersionLen(var2.getProtocolVersion()));
      var1.append(var3);
      var1.append(' ');
      var1.append(var4);
      var1.append(' ');
      this.appendProtocolVersion(var1, var2.getProtocolVersion());
   }

   protected void doFormatStatusLine(CharArrayBuffer var1, StatusLine var2) {
      int var3 = 1 + 3 + 1 + this.estimateProtocolVersionLen(var2.getProtocolVersion());
      String var4 = var2.getReasonPhrase();
      if(var4 != null) {
         var3 += var4.length();
      }

      var1.ensureCapacity(var3);
      this.appendProtocolVersion(var1, var2.getProtocolVersion());
      var1.append(' ');
      var1.append(Integer.toString(var2.getStatusCode()));
      var1.append(' ');
      if(var4 != null) {
         var1.append(var4);
      }

   }

   protected int estimateProtocolVersionLen(ProtocolVersion var1) {
      return 4 + var1.getProtocol().length();
   }

   public CharArrayBuffer formatHeader(CharArrayBuffer var1, Header var2) {
      Args.notNull(var2, "Header");
      if(var2 instanceof FormattedHeader) {
         return ((FormattedHeader)var2).getBuffer();
      } else {
         CharArrayBuffer var4 = this.initBuffer(var1);
         this.doFormatHeader(var4, var2);
         return var4;
      }
   }

   public CharArrayBuffer formatRequestLine(CharArrayBuffer var1, RequestLine var2) {
      Args.notNull(var2, "Request line");
      CharArrayBuffer var4 = this.initBuffer(var1);
      this.doFormatRequestLine(var4, var2);
      return var4;
   }

   public CharArrayBuffer formatStatusLine(CharArrayBuffer var1, StatusLine var2) {
      Args.notNull(var2, "Status line");
      CharArrayBuffer var4 = this.initBuffer(var1);
      this.doFormatStatusLine(var4, var2);
      return var4;
   }

   protected CharArrayBuffer initBuffer(CharArrayBuffer var1) {
      if(var1 != null) {
         var1.clear();
         return var1;
      } else {
         return new CharArrayBuffer(64);
      }
   }
}
