package com.loopj.android.http;

import android.text.TextUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.ResponseHandlerInterface;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class SimpleMultipartEntity implements HttpEntity {
   private static final byte[] CR_LF = "\r\n".getBytes();
   private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
   private static final byte[] TRANSFER_ENCODING_BINARY = "Content-Transfer-Encoding: binary\r\n".getBytes();
   private final String boundary;
   private final byte[] boundaryEnd;
   private final byte[] boundaryLine;
   private long bytesWritten;
   private final List<SimpleMultipartEntity.FilePart> fileParts = new ArrayList();
   private boolean isRepeatable;
   private final ByteArrayOutputStream out = new ByteArrayOutputStream();
   private final ResponseHandlerInterface progressHandler;
   private long totalSize;

   public SimpleMultipartEntity(ResponseHandlerInterface var1) {
      StringBuilder var2 = new StringBuilder();
      Random var3 = new Random();

      for(int var4 = 0; var4 < 30; ++var4) {
         var2.append(MULTIPART_CHARS[var3.nextInt(MULTIPART_CHARS.length)]);
      }

      this.boundary = var2.toString();
      this.boundaryLine = ("--" + this.boundary + "\r\n").getBytes();
      this.boundaryEnd = ("--" + this.boundary + "--" + "\r\n").getBytes();
      this.progressHandler = var1;
   }

   private byte[] createContentDisposition(String var1) {
      return ("Content-Disposition: form-data; name=\"" + var1 + "\"" + "\r\n").getBytes();
   }

   private byte[] createContentDisposition(String var1, String var2) {
      return ("Content-Disposition: form-data; name=\"" + var1 + "\"" + "; filename=\"" + var2 + "\"" + "\r\n").getBytes();
   }

   private byte[] createContentType(String var1) {
      return ("Content-Type: " + this.normalizeContentType(var1) + "\r\n").getBytes();
   }

   private String normalizeContentType(String var1) {
      if(var1 == null) {
         var1 = "application/octet-stream";
      }

      return var1;
   }

   private void updateProgress(long var1) {
      this.bytesWritten += var1;
      this.progressHandler.sendProgressMessage(this.bytesWritten, this.totalSize);
   }

   public void addPart(String var1, File var2, String var3, String var4) {
      this.fileParts.add(new SimpleMultipartEntity.FilePart(var1, var2, this.normalizeContentType(var3), var4));
   }

   public void addPart(String var1, String var2, InputStream var3, String var4) throws IOException {
      this.out.write(this.boundaryLine);
      this.out.write(this.createContentDisposition(var1, var2));
      this.out.write(this.createContentType(var4));
      this.out.write(TRANSFER_ENCODING_BINARY);
      this.out.write(CR_LF);
      byte[] var5 = new byte[4096];

      while(true) {
         int var6 = var3.read(var5);
         if(var6 == -1) {
            this.out.write(CR_LF);
            this.out.flush();
            return;
         }

         this.out.write(var5, 0, var6);
      }
   }

   public void addPart(String var1, String var2, String var3) {
      try {
         this.out.write(this.boundaryLine);
         this.out.write(this.createContentDisposition(var1));
         this.out.write(this.createContentType(var3));
         this.out.write(CR_LF);
         this.out.write(var2.getBytes());
         this.out.write(CR_LF);
      } catch (IOException var5) {
         AsyncHttpClient.log.method_4("SimpleMultipartEntity", "addPart ByteArrayOutputStream exception", var5);
      }
   }

   public void addPartWithCharset(String var1, String var2, String var3) {
      if(var3 == null) {
         var3 = "UTF-8";
      }

      this.addPart(var1, var2, "text/plain; charset=" + var3);
   }

   public void consumeContent() throws IOException, UnsupportedOperationException {
      if(this.isStreaming()) {
         throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
      }
   }

   public InputStream getContent() throws IOException, UnsupportedOperationException {
      throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
   }

   public Header getContentEncoding() {
      return null;
   }

   public long getContentLength() {
      long var1 = (long)this.out.size();

      long var4;
      for(Iterator var3 = this.fileParts.iterator(); var3.hasNext(); var1 += var4) {
         var4 = ((SimpleMultipartEntity.FilePart)var3.next()).getTotalLength();
         if(var4 < 0L) {
            return -1L;
         }
      }

      return var1 + (long)this.boundaryEnd.length;
   }

   public Header getContentType() {
      return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.boundary);
   }

   public boolean isChunked() {
      return false;
   }

   public boolean isRepeatable() {
      return this.isRepeatable;
   }

   public boolean isStreaming() {
      return false;
   }

   public void setIsRepeatable(boolean var1) {
      this.isRepeatable = var1;
   }

   public void writeTo(OutputStream var1) throws IOException {
      this.bytesWritten = 0L;
      this.totalSize = (long)((int)this.getContentLength());
      this.out.writeTo(var1);
      this.updateProgress((long)this.out.size());
      Iterator var2 = this.fileParts.iterator();

      while(var2.hasNext()) {
         ((SimpleMultipartEntity.FilePart)var2.next()).writeTo(var1);
      }

      var1.write(this.boundaryEnd);
      this.updateProgress((long)this.boundaryEnd.length);
   }

   private class FilePart {
      public final File file;
      public final byte[] header;

      public FilePart(String var2, File var3, String var4, String var5) {
         if(TextUtils.isEmpty(var5)) {
            var5 = var3.getName();
         }

         this.header = this.createHeader(var2, var5, var4);
         this.file = var3;
      }

      private byte[] createHeader(String var1, String var2, String var3) {
         ByteArrayOutputStream var4 = new ByteArrayOutputStream();

         try {
            var4.write(SimpleMultipartEntity.this.boundaryLine);
            var4.write(SimpleMultipartEntity.this.createContentDisposition(var1, var2));
            var4.write(SimpleMultipartEntity.this.createContentType(var3));
            var4.write(SimpleMultipartEntity.TRANSFER_ENCODING_BINARY);
            var4.write(SimpleMultipartEntity.CR_LF);
         } catch (IOException var6) {
            AsyncHttpClient.log.method_4("SimpleMultipartEntity", "createHeader ByteArrayOutputStream exception", var6);
         }

         return var4.toByteArray();
      }

      public long getTotalLength() {
         return this.file.length() + (long)SimpleMultipartEntity.CR_LF.length + (long)this.header.length;
      }

      public void writeTo(OutputStream var1) throws IOException {
         var1.write(this.header);
         SimpleMultipartEntity.this.updateProgress((long)this.header.length);
         FileInputStream var2 = new FileInputStream(this.file);
         byte[] var3 = new byte[4096];

         while(true) {
            int var4 = var2.read(var3);
            if(var4 == -1) {
               var1.write(SimpleMultipartEntity.CR_LF);
               SimpleMultipartEntity.this.updateProgress((long)SimpleMultipartEntity.CR_LF.length);
               var1.flush();
               AsyncHttpClient.silentCloseInputStream(var2);
               return;
            }

            var1.write(var3, 0, var4);
            SimpleMultipartEntity.this.updateProgress((long)var4);
         }
      }
   }
}
