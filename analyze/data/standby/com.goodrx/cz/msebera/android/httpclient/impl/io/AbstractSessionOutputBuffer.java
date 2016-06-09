package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.impl.io.HttpTransportMetricsImpl;
import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

@Deprecated
public abstract class AbstractSessionOutputBuffer implements BufferInfo, SessionOutputBuffer {
   private static final byte[] CRLF = new byte[]{(byte)13, (byte)10};
   private boolean ascii;
   private ByteBuffer bbuf;
   private ByteArrayBuffer buffer;
   private Charset charset;
   private CharsetEncoder encoder;
   private HttpTransportMetricsImpl metrics;
   private int minChunkLimit;
   private CodingErrorAction onMalformedCharAction;
   private CodingErrorAction onUnmappableCharAction;
   private OutputStream outstream;

   private void handleEncodingResult(CoderResult var1) throws IOException {
      if(var1.isError()) {
         var1.throwException();
      }

      this.bbuf.flip();

      while(this.bbuf.hasRemaining()) {
         this.write(this.bbuf.get());
      }

      this.bbuf.compact();
   }

   private void writeEncoded(CharBuffer var1) throws IOException {
      if(var1.hasRemaining()) {
         if(this.encoder == null) {
            this.encoder = this.charset.newEncoder();
            this.encoder.onMalformedInput(this.onMalformedCharAction);
            this.encoder.onUnmappableCharacter(this.onUnmappableCharAction);
         }

         if(this.bbuf == null) {
            this.bbuf = ByteBuffer.allocate(1024);
         }

         this.encoder.reset();

         while(var1.hasRemaining()) {
            this.handleEncodingResult(this.encoder.encode(var1, this.bbuf, true));
         }

         this.handleEncodingResult(this.encoder.flush(this.bbuf));
         this.bbuf.clear();
      }
   }

   protected HttpTransportMetricsImpl createTransportMetrics() {
      return new HttpTransportMetricsImpl();
   }

   public void flush() throws IOException {
      this.flushBuffer();
      this.outstream.flush();
   }

   protected void flushBuffer() throws IOException {
      int var1 = this.buffer.length();
      if(var1 > 0) {
         this.outstream.write(this.buffer.buffer(), 0, var1);
         this.buffer.clear();
         this.metrics.incrementBytesTransferred((long)var1);
      }

   }

   public HttpTransportMetrics getMetrics() {
      return this.metrics;
   }

   protected void init(OutputStream var1, int var2, HttpParams var3) {
      Args.notNull(var1, "Input stream");
      Args.notNegative(var2, "Buffer size");
      Args.notNull(var3, "HTTP parameters");
      this.outstream = var1;
      this.buffer = new ByteArrayBuffer(var2);
      String var7 = (String)var3.getParameter("http.protocol.element-charset");
      Charset var8;
      if(var7 != null) {
         var8 = Charset.forName(var7);
      } else {
         var8 = Consts.ASCII;
      }

      this.charset = var8;
      this.ascii = this.charset.equals(Consts.ASCII);
      this.encoder = null;
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
      return this.buffer.length();
   }

   public void write(int var1) throws IOException {
      if(this.buffer.isFull()) {
         this.flushBuffer();
      }

      this.buffer.append(var1);
   }

   public void write(byte[] var1) throws IOException {
      if(var1 != null) {
         this.write(var1, 0, var1.length);
      }
   }

   public void write(byte[] var1, int var2, int var3) throws IOException {
      if(var1 != null) {
         if(var3 <= this.minChunkLimit && var3 <= this.buffer.capacity()) {
            if(var3 > this.buffer.capacity() - this.buffer.length()) {
               this.flushBuffer();
            }

            this.buffer.append(var1, var2, var3);
         } else {
            this.flushBuffer();
            this.outstream.write(var1, var2, var3);
            this.metrics.incrementBytesTransferred((long)var3);
         }
      }
   }

   public void writeLine(CharArrayBuffer var1) throws IOException {
      if(var1 != null) {
         if(this.ascii) {
            int var2 = 0;

            int var4;
            for(int var3 = var1.length(); var3 > 0; var3 -= var4) {
               var4 = Math.min(this.buffer.capacity() - this.buffer.length(), var3);
               if(var4 > 0) {
                  this.buffer.append(var1, var2, var4);
               }

               if(this.buffer.isFull()) {
                  this.flushBuffer();
               }

               var2 += var4;
            }
         } else {
            this.writeEncoded(CharBuffer.wrap(var1.buffer(), 0, var1.length()));
         }

         this.write(CRLF);
      }
   }

   public void writeLine(String var1) throws IOException {
      if(var1 != null) {
         if(var1.length() > 0) {
            if(this.ascii) {
               for(int var2 = 0; var2 < var1.length(); ++var2) {
                  this.write(var1.charAt(var2));
               }
            } else {
               this.writeEncoded(CharBuffer.wrap(var1));
            }
         }

         this.write(CRLF);
      }
   }
}
