package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.impl.io.HttpTransportMetricsImpl;
import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

@Deprecated
public abstract class AbstractSessionInputBuffer implements BufferInfo, SessionInputBuffer {
   private boolean ascii;
   private byte[] buffer;
   private int bufferlen;
   private int bufferpos;
   private CharBuffer cbuf;
   private Charset charset;
   private CharsetDecoder decoder;
   private InputStream instream;
   private ByteArrayBuffer linebuffer;
   private int maxLineLen;
   private HttpTransportMetricsImpl metrics;
   private int minChunkLimit;
   private CodingErrorAction onMalformedCharAction;
   private CodingErrorAction onUnmappableCharAction;

   private int appendDecoded(CharArrayBuffer var1, ByteBuffer var2) throws IOException {
      if(!var2.hasRemaining()) {
         return 0;
      } else {
         if(this.decoder == null) {
            this.decoder = this.charset.newDecoder();
            this.decoder.onMalformedInput(this.onMalformedCharAction);
            this.decoder.onUnmappableCharacter(this.onUnmappableCharAction);
         }

         if(this.cbuf == null) {
            this.cbuf = CharBuffer.allocate(1024);
         }

         this.decoder.reset();

         int var4;
         for(var4 = 0; var2.hasRemaining(); var4 += this.handleDecodingResult(this.decoder.decode(var2, this.cbuf, true), var1, var2)) {
            ;
         }

         int var5 = var4 + this.handleDecodingResult(this.decoder.flush(this.cbuf), var1, var2);
         this.cbuf.clear();
         return var5;
      }
   }

   private int handleDecodingResult(CoderResult var1, CharArrayBuffer var2, ByteBuffer var3) throws IOException {
      if(var1.isError()) {
         var1.throwException();
      }

      this.cbuf.flip();
      int var5 = this.cbuf.remaining();

      while(this.cbuf.hasRemaining()) {
         var2.append(this.cbuf.get());
      }

      this.cbuf.compact();
      return var5;
   }

   private int lineFromLineBuffer(CharArrayBuffer var1) throws IOException {
      int var2 = this.linebuffer.length();
      if(var2 > 0) {
         if(this.linebuffer.byteAt(var2 - 1) == 10) {
            --var2;
         }

         if(var2 > 0 && this.linebuffer.byteAt(var2 - 1) == 13) {
            --var2;
         }
      }

      if(this.ascii) {
         var1.append(this.linebuffer, 0, var2);
      } else {
         var2 = this.appendDecoded(var1, ByteBuffer.wrap(this.linebuffer.buffer(), 0, var2));
      }

      this.linebuffer.clear();
      return var2;
   }

   private int lineFromReadBuffer(CharArrayBuffer var1, int var2) throws IOException {
      int var3 = this.bufferpos;
      int var4 = var2;
      this.bufferpos = var2 + 1;
      if(var2 > var3 && this.buffer[var2 - 1] == 13) {
         var4 = var2 - 1;
      }

      int var5 = var4 - var3;
      if(this.ascii) {
         var1.append(this.buffer, var3, var5);
         return var5;
      } else {
         return this.appendDecoded(var1, ByteBuffer.wrap(this.buffer, var3, var5));
      }
   }

   private int locateLF() {
      for(int var1 = this.bufferpos; var1 < this.bufferlen; ++var1) {
         if(this.buffer[var1] == 10) {
            return var1;
         }
      }

      return -1;
   }

   protected HttpTransportMetricsImpl createTransportMetrics() {
      return new HttpTransportMetricsImpl();
   }

   protected int fillBuffer() throws IOException {
      if(this.bufferpos > 0) {
         int var4 = this.bufferlen - this.bufferpos;
         if(var4 > 0) {
            System.arraycopy(this.buffer, this.bufferpos, this.buffer, 0, var4);
         }

         this.bufferpos = 0;
         this.bufferlen = var4;
      }

      int var1 = this.bufferlen;
      int var2 = this.buffer.length - var1;
      int var3 = this.instream.read(this.buffer, var1, var2);
      if(var3 == -1) {
         return -1;
      } else {
         this.bufferlen = var1 + var3;
         this.metrics.incrementBytesTransferred((long)var3);
         return var3;
      }
   }

   public HttpTransportMetrics getMetrics() {
      return this.metrics;
   }

   protected boolean hasBufferedData() {
      return this.bufferpos < this.bufferlen;
   }

   protected void init(InputStream var1, int var2, HttpParams var3) {
      Args.notNull(var1, "Input stream");
      Args.notNegative(var2, "Buffer size");
      Args.notNull(var3, "HTTP parameters");
      this.instream = var1;
      this.buffer = new byte[var2];
      this.bufferpos = 0;
      this.bufferlen = 0;
      this.linebuffer = new ByteArrayBuffer(var2);
      String var7 = (String)var3.getParameter("http.protocol.element-charset");
      Charset var8;
      if(var7 != null) {
         var8 = Charset.forName(var7);
      } else {
         var8 = Consts.ASCII;
      }

      this.charset = var8;
      this.ascii = this.charset.equals(Consts.ASCII);
      this.decoder = null;
      this.maxLineLen = var3.getIntParameter("http.connection.max-line-length", -1);
      this.minChunkLimit = var3.getIntParameter("http.connection.min-chunk-limit", 512);
      this.metrics = this.createTransportMetrics();
      CodingErrorAction var9 = (CodingErrorAction)var3.getParameter("http.malformed.input.action");
      if(var9 == null) {
         var9 = CodingErrorAction.REPORT;
      }

      this.onMalformedCharAction = var9;
      CodingErrorAction var10 = (CodingErrorAction)var3.getParameter("http.unmappable.input.action");
      if(var10 == null) {
         var10 = CodingErrorAction.REPORT;
      }

      this.onUnmappableCharAction = var10;
   }

   public int length() {
      return this.bufferlen - this.bufferpos;
   }

   public int read() throws IOException {
      while(true) {
         if(!this.hasBufferedData()) {
            if(this.fillBuffer() != -1) {
               continue;
            }

            return -1;
         }

         byte[] var1 = this.buffer;
         int var2 = this.bufferpos;
         this.bufferpos = var2 + 1;
         return 255 & var1[var2];
      }
   }

   public int read(byte[] var1, int var2, int var3) throws IOException {
      if(var1 == null) {
         return 0;
      } else if(this.hasBufferedData()) {
         int var6 = Math.min(var3, this.bufferlen - this.bufferpos);
         System.arraycopy(this.buffer, this.bufferpos, var1, var2, var6);
         this.bufferpos += var6;
         return var6;
      } else if(var3 > this.minChunkLimit) {
         int var5 = this.instream.read(var1, var2, var3);
         if(var5 > 0) {
            this.metrics.incrementBytesTransferred((long)var5);
         }

         return var5;
      } else {
         do {
            if(this.hasBufferedData()) {
               int var4 = Math.min(var3, this.bufferlen - this.bufferpos);
               System.arraycopy(this.buffer, this.bufferpos, var1, var2, var4);
               this.bufferpos += var4;
               return var4;
            }
         } while(this.fillBuffer() != -1);

         return -1;
      }
   }

   public int readLine(CharArrayBuffer var1) throws IOException {
      int var2 = -1;
      Args.notNull(var1, "Char array buffer");
      int var4 = 0;
      boolean var5 = true;

      while(true) {
         if(!var5) {
            if(var4 != var2 || !this.linebuffer.isEmpty()) {
               return this.lineFromLineBuffer(var1);
            }
            break;
         }

         int var6 = this.locateLF();
         if(var6 != var2) {
            if(this.linebuffer.isEmpty()) {
               var2 = this.lineFromReadBuffer(var1, var6);
               break;
            }

            var5 = false;
            int var8 = var6 + 1 - this.bufferpos;
            this.linebuffer.append(this.buffer, this.bufferpos, var8);
            this.bufferpos = var6 + 1;
         } else {
            if(this.hasBufferedData()) {
               int var7 = this.bufferlen - this.bufferpos;
               this.linebuffer.append(this.buffer, this.bufferpos, var7);
               this.bufferpos = this.bufferlen;
            }

            var4 = this.fillBuffer();
            if(var4 == var2) {
               var5 = false;
            }
         }

         if(this.maxLineLen > 0 && this.linebuffer.length() >= this.maxLineLen) {
            throw new IOException("Maximum line length limit exceeded");
         }
      }

      return var2;
   }
}
