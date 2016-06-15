package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.AbstractOutputStream;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.AbstractHttpInputStream;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RawHeaders;
import com.squareup.okhttp.internal.http.ResponseHeaders;
import com.squareup.okhttp.internal.http.RetryableOutputStream;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.http.UnknownLengthHttpInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.ProtocolException;

public final class HttpTransport implements Transport {
   public static final int DEFAULT_CHUNK_LENGTH = 1024;
   private static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;
   private final HttpEngine httpEngine;
   private OutputStream requestOut;
   private final InputStream socketIn;
   private final OutputStream socketOut;

   public HttpTransport(HttpEngine var1, OutputStream var2, InputStream var3) {
      this.httpEngine = var1;
      this.socketOut = var2;
      this.requestOut = var2;
      this.socketIn = var3;
   }

   private static boolean discardStream(HttpEngine param0, InputStream param1) {
      // $FF: Couldn't be decompiled
   }

   public OutputStream createRequestBody() throws IOException {
      boolean var1 = this.httpEngine.requestHeaders.isChunked();
      if(!var1 && this.httpEngine.policy.getChunkLength() > 0 && this.httpEngine.connection.getHttpMinorVersion() != 0) {
         this.httpEngine.requestHeaders.setChunked();
         var1 = true;
      }

      if(var1) {
         int var6 = this.httpEngine.policy.getChunkLength();
         if(var6 == -1) {
            var6 = 1024;
         }

         this.writeRequestHeaders();
         return new HttpTransport.ChunkedOutputStream(this.requestOut, var6);
      } else {
         long var2 = this.httpEngine.policy.getFixedContentLength();
         if(var2 != -1L) {
            this.httpEngine.requestHeaders.setContentLength(var2);
            this.writeRequestHeaders();
            return new HttpTransport.FixedLengthOutputStream(this.requestOut, var2);
         } else {
            long var4 = this.httpEngine.requestHeaders.getContentLength();
            if(var4 > 2147483647L) {
               throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
            } else if(var4 != -1L) {
               this.writeRequestHeaders();
               return new RetryableOutputStream((int)var4);
            } else {
               return new RetryableOutputStream();
            }
         }
      }
   }

   public void flushRequest() throws IOException {
      this.requestOut.flush();
      this.requestOut = this.socketOut;
   }

   public InputStream getTransferStream(CacheRequest var1) throws IOException {
      return (InputStream)(!this.httpEngine.hasResponseBody()?new HttpTransport.FixedLengthInputStream(this.socketIn, var1, this.httpEngine, 0L):(this.httpEngine.responseHeaders.isChunked()?new HttpTransport.ChunkedInputStream(this.socketIn, var1, this):(this.httpEngine.responseHeaders.getContentLength() != -1L?new HttpTransport.FixedLengthInputStream(this.socketIn, var1, this.httpEngine, this.httpEngine.responseHeaders.getContentLength()):new UnknownLengthHttpInputStream(this.socketIn, var1, this.httpEngine))));
   }

   public boolean makeReusable(boolean var1, OutputStream var2, InputStream var3) {
      return !var1 && (var2 == null || ((AbstractOutputStream)var2).isClosed()) && !this.httpEngine.requestHeaders.hasConnectionClose() && (this.httpEngine.responseHeaders == null || !this.httpEngine.responseHeaders.hasConnectionClose()) && !(var3 instanceof UnknownLengthHttpInputStream)?(var3 != null?discardStream(this.httpEngine, var3):true):false;
   }

   public ResponseHeaders readResponseHeaders() throws IOException {
      RawHeaders var1 = RawHeaders.fromBytes(this.socketIn);
      this.httpEngine.connection.setHttpMinorVersion(var1.getHttpMinorVersion());
      this.httpEngine.receiveHeaders(var1);
      ResponseHeaders var2 = new ResponseHeaders(this.httpEngine.uri, var1);
      var2.setTransport("http/1.1");
      return var2;
   }

   public void writeRequestBody(RetryableOutputStream var1) throws IOException {
      var1.writeToSocket(this.requestOut);
   }

   public void writeRequestHeaders() throws IOException {
      this.httpEngine.writingRequestHeaders();
      byte[] var1 = this.httpEngine.requestHeaders.getHeaders().toBytes();
      this.requestOut.write(var1);
   }

   private static class ChunkedInputStream extends AbstractHttpInputStream {
      private static final int NO_CHUNK_YET = -1;
      private int bytesRemainingInChunk = -1;
      private boolean hasMoreChunks = true;
      private final HttpTransport transport;

      ChunkedInputStream(InputStream var1, CacheRequest var2, HttpTransport var3) throws IOException {
         super(var1, var3.httpEngine, var2);
         this.transport = var3;
      }

      private void readChunkSize() throws IOException {
         if(this.bytesRemainingInChunk != -1) {
            Util.readAsciiLine(this.in);
         }

         String var1 = Util.readAsciiLine(this.in);
         int var2 = var1.indexOf(";");
         if(var2 != -1) {
            var1 = var1.substring(0, var2);
         }

         try {
            this.bytesRemainingInChunk = Integer.parseInt(var1.trim(), 16);
         } catch (NumberFormatException var5) {
            throw new ProtocolException("Expected a hex chunk size but was " + var1);
         }

         if(this.bytesRemainingInChunk == 0) {
            this.hasMoreChunks = false;
            RawHeaders var4 = this.httpEngine.responseHeaders.getHeaders();
            RawHeaders.readHeaders(this.transport.socketIn, var4);
            this.httpEngine.receiveHeaders(var4);
            this.endOfInput();
         }

      }

      public int available() throws IOException {
         this.checkNotClosed();
         return this.hasMoreChunks && this.bytesRemainingInChunk != -1?Math.min(this.in.available(), this.bytesRemainingInChunk):0;
      }

      public void close() throws IOException {
         if(!this.closed) {
            if(this.hasMoreChunks && !HttpTransport.discardStream(this.httpEngine, this)) {
               this.unexpectedEndOfInput();
            }

            this.closed = true;
         }
      }

      public int read(byte[] var1, int var2, int var3) throws IOException {
         Util.checkOffsetAndCount(var1.length, var2, var3);
         this.checkNotClosed();
         if(!this.hasMoreChunks) {
            return -1;
         } else {
            if(this.bytesRemainingInChunk == 0 || this.bytesRemainingInChunk == -1) {
               this.readChunkSize();
               if(!this.hasMoreChunks) {
                  return -1;
               }
            }

            int var4 = this.in.read(var1, var2, Math.min(var3, this.bytesRemainingInChunk));
            if(var4 == -1) {
               this.unexpectedEndOfInput();
               throw new IOException("unexpected end of stream");
            } else {
               this.bytesRemainingInChunk -= var4;
               this.cacheWrite(var1, var2, var4);
               return var4;
            }
         }
      }
   }

   private static final class ChunkedOutputStream extends AbstractOutputStream {
      private static final byte[] CRLF = new byte[]{(byte)13, (byte)10};
      private static final byte[] FINAL_CHUNK = new byte[]{(byte)48, (byte)13, (byte)10, (byte)13, (byte)10};
      private static final byte[] HEX_DIGITS = new byte[]{(byte)48, (byte)49, (byte)50, (byte)51, (byte)52, (byte)53, (byte)54, (byte)55, (byte)56, (byte)57, (byte)97, (byte)98, (byte)99, (byte)100, (byte)101, (byte)102};
      private final ByteArrayOutputStream bufferedChunk;
      private final byte[] hex;
      private final int maxChunkLength;
      private final OutputStream socketOut;

      private ChunkedOutputStream(OutputStream var1, int var2) {
         this.hex = new byte[]{(byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)13, (byte)10};
         this.socketOut = var1;
         this.maxChunkLength = Math.max(1, this.dataLength(var2));
         this.bufferedChunk = new ByteArrayOutputStream(var2);
      }

      // $FF: synthetic method
      ChunkedOutputStream(OutputStream var1, int var2, Object var3) {
         this(var1, var2);
      }

      private int dataLength(int var1) {
         int var2 = 4;

         for(int var3 = var1 - var2; var3 > 0; var3 >>= 4) {
            ++var2;
         }

         return var1 - var2;
      }

      private void writeBufferedChunkToSocket() throws IOException {
         int var1 = this.bufferedChunk.size();
         if(var1 > 0) {
            this.writeHex(var1);
            this.bufferedChunk.writeTo(this.socketOut);
            this.bufferedChunk.reset();
            this.socketOut.write(CRLF);
         }
      }

      private void writeHex(int var1) throws IOException {
         int var2 = 8;

         do {
            byte[] var3 = this.hex;
            --var2;
            var3[var2] = HEX_DIGITS[var1 & 15];
            var1 >>>= 4;
         } while(var1 != 0);

         this.socketOut.write(this.hex, var2, this.hex.length - var2);
      }

      public void close() throws IOException {
         // $FF: Couldn't be decompiled
      }

      public void flush() throws IOException {
         // $FF: Couldn't be decompiled
      }

      public void write(byte[] param1, int param2, int param3) throws IOException {
         // $FF: Couldn't be decompiled
      }
   }

   private static class FixedLengthInputStream extends AbstractHttpInputStream {
      private long bytesRemaining;

      public FixedLengthInputStream(InputStream var1, CacheRequest var2, HttpEngine var3, long var4) throws IOException {
         super(var1, var3, var2);
         this.bytesRemaining = var4;
         if(this.bytesRemaining == 0L) {
            this.endOfInput();
         }

      }

      public int available() throws IOException {
         this.checkNotClosed();
         return this.bytesRemaining == 0L?0:(int)Math.min((long)this.in.available(), this.bytesRemaining);
      }

      public void close() throws IOException {
         if(!this.closed) {
            if(this.bytesRemaining != 0L && !HttpTransport.discardStream(this.httpEngine, this)) {
               this.unexpectedEndOfInput();
            }

            this.closed = true;
         }
      }

      public int read(byte[] var1, int var2, int var3) throws IOException {
         Util.checkOffsetAndCount(var1.length, var2, var3);
         this.checkNotClosed();
         int var4;
         if(this.bytesRemaining == 0L) {
            var4 = -1;
         } else {
            var4 = this.in.read(var1, var2, (int)Math.min((long)var3, this.bytesRemaining));
            if(var4 == -1) {
               this.unexpectedEndOfInput();
               throw new ProtocolException("unexpected end of stream");
            }

            this.bytesRemaining -= (long)var4;
            this.cacheWrite(var1, var2, var4);
            if(this.bytesRemaining == 0L) {
               this.endOfInput();
               return var4;
            }
         }

         return var4;
      }
   }

   private static final class FixedLengthOutputStream extends AbstractOutputStream {
      private long bytesRemaining;
      private final OutputStream socketOut;

      private FixedLengthOutputStream(OutputStream var1, long var2) {
         this.socketOut = var1;
         this.bytesRemaining = var2;
      }

      // $FF: synthetic method
      FixedLengthOutputStream(OutputStream var1, long var2, Object var4) {
         this(var1, var2);
      }

      public void close() throws IOException {
         if(!this.closed) {
            this.closed = true;
            if(this.bytesRemaining > 0L) {
               throw new ProtocolException("unexpected end of stream");
            }
         }

      }

      public void flush() throws IOException {
         if(!this.closed) {
            this.socketOut.flush();
         }
      }

      public void write(byte[] var1, int var2, int var3) throws IOException {
         this.checkNotClosed();
         Util.checkOffsetAndCount(var1.length, var2, var3);
         if((long)var3 > this.bytesRemaining) {
            throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + var3);
         } else {
            this.socketOut.write(var1, var2, var3);
            this.bytesRemaining -= (long)var3;
         }
      }
   }
}
