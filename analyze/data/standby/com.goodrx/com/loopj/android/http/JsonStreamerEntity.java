package com.loopj.android.http;

import android.text.TextUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.Base64OutputStream;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class JsonStreamerEntity implements HttpEntity {
   private static final UnsupportedOperationException ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
   private static final Header HEADER_GZIP_ENCODING = new BasicHeader("Content-Encoding", "gzip");
   private static final Header HEADER_JSON_CONTENT = new BasicHeader("Content-Type", "application/json");
   private static final byte[] JSON_FALSE = "false".getBytes();
   private static final byte[] JSON_NULL = "null".getBytes();
   private static final byte[] JSON_TRUE = "true".getBytes();
   private static final byte[] STREAM_CONTENTS = escape("contents");
   private static final byte[] STREAM_NAME = escape("name");
   private static final byte[] STREAM_TYPE = escape("type");
   private final byte[] buffer = new byte[4096];
   private final Header contentEncoding;
   private final byte[] elapsedField;
   private final Map<String, Object> jsonParams = new HashMap();
   private final ResponseHandlerInterface progressHandler;

   public JsonStreamerEntity(ResponseHandlerInterface var1, boolean var2, String var3) {
      this.progressHandler = var1;
      Header var4;
      if(var2) {
         var4 = HEADER_GZIP_ENCODING;
      } else {
         var4 = null;
      }

      this.contentEncoding = var4;
      boolean var5 = TextUtils.isEmpty(var3);
      byte[] var6 = null;
      if(!var5) {
         var6 = escape(var3);
      }

      this.elapsedField = var6;
   }

   private void endMetaData(OutputStream var1) throws IOException {
      var1.write(34);
   }

   static byte[] escape(String var0) {
      if(var0 == null) {
         return JSON_NULL;
      } else {
         StringBuilder var1 = new StringBuilder(128);
         var1.append('\"');
         int var3 = var0.length();
         int var4 = -1;

         while(true) {
            while(true) {
               ++var4;
               if(var4 >= var3) {
                  var1.append('\"');
                  return var1.toString().getBytes();
               }

               char var6 = var0.charAt(var4);
               switch(var6) {
               case '\b':
                  var1.append("\\b");
                  continue;
               case '\t':
                  var1.append("\\t");
                  continue;
               case '\n':
                  var1.append("\\n");
                  continue;
               case '\f':
                  var1.append("\\f");
                  continue;
               case '\r':
                  var1.append("\\r");
                  continue;
               case '\"':
                  var1.append("\\\"");
                  continue;
               case '\\':
                  var1.append("\\\\");
                  continue;
               }

               if(var6 <= 31 || var6 >= 127 && var6 <= 159 || var6 >= 8192 && var6 <= 8447) {
                  String var14 = Integer.toHexString(var6);
                  var1.append("\\u");
                  int var16 = 4 - var14.length();

                  for(int var17 = 0; var17 < var16; ++var17) {
                     var1.append('0');
                  }

                  var1.append(var14.toUpperCase(Locale.US));
               } else {
                  var1.append(var6);
               }
            }
         }
      }
   }

   private void writeMetaData(OutputStream var1, String var2, String var3) throws IOException {
      var1.write(STREAM_NAME);
      var1.write(58);
      var1.write(escape(var2));
      var1.write(44);
      var1.write(STREAM_TYPE);
      var1.write(58);
      var1.write(escape(var3));
      var1.write(44);
      var1.write(STREAM_CONTENTS);
      var1.write(58);
      var1.write(34);
   }

   private void writeToFromFile(OutputStream var1, RequestParams.FileWrapper var2) throws IOException {
      this.writeMetaData(var1, var2.file.getName(), var2.contentType);
      long var3 = 0L;
      long var5 = var2.file.length();
      FileInputStream var7 = new FileInputStream(var2.file);
      Base64OutputStream var8 = new Base64OutputStream(var1, 18);

      while(true) {
         int var9 = var7.read(this.buffer);
         if(var9 == -1) {
            AsyncHttpClient.silentCloseOutputStream(var8);
            this.endMetaData(var1);
            AsyncHttpClient.silentCloseInputStream(var7);
            return;
         }

         var8.write(this.buffer, 0, var9);
         var3 += (long)var9;
         this.progressHandler.sendProgressMessage(var3, var5);
      }
   }

   private void writeToFromStream(OutputStream var1, RequestParams.StreamWrapper var2) throws IOException {
      this.writeMetaData(var1, var2.name, var2.contentType);
      Base64OutputStream var3 = new Base64OutputStream(var1, 18);

      while(true) {
         int var4 = var2.inputStream.read(this.buffer);
         if(var4 == -1) {
            AsyncHttpClient.silentCloseOutputStream(var3);
            this.endMetaData(var1);
            if(var2.autoClose) {
               AsyncHttpClient.silentCloseInputStream(var2.inputStream);
            }

            return;
         }

         var3.write(this.buffer, 0, var4);
      }
   }

   public void addPart(String var1, Object var2) {
      this.jsonParams.put(var1, var2);
   }

   public void consumeContent() throws IOException, UnsupportedOperationException {
   }

   public InputStream getContent() throws IOException, UnsupportedOperationException {
      throw ERR_UNSUPPORTED;
   }

   public Header getContentEncoding() {
      return this.contentEncoding;
   }

   public long getContentLength() {
      return -1L;
   }

   public Header getContentType() {
      return HEADER_JSON_CONTENT;
   }

   public boolean isChunked() {
      return false;
   }

   public boolean isRepeatable() {
      return false;
   }

   public boolean isStreaming() {
      return false;
   }

   public void writeTo(OutputStream param1) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
