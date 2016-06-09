package com.koushikdutta.async.http;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequestBody;
import com.koushikdutta.async.http.JSONObjectBody;
import com.koushikdutta.async.http.MultipartFormDataBody;
import com.koushikdutta.async.http.StringBody;
import com.koushikdutta.async.http.UrlEncodedFormBody;
import com.koushikdutta.async.http.filter.ChunkedInputFilter;
import com.koushikdutta.async.http.filter.ContentLengthFilter;
import com.koushikdutta.async.http.filter.GZIPInputFilter;
import com.koushikdutta.async.http.filter.InflaterInputFilter;
import com.koushikdutta.async.http.libcore.RawHeaders;
import com.koushikdutta.async.http.server.UnknownRequestBody;

public class HttpUtil {
   public static AsyncHttpRequestBody getBody(DataEmitter var0, CompletedCallback var1, RawHeaders var2) {
      String var3 = var2.get("Content-Type");
      if(var3 != null) {
         String[] var4 = var3.split(";");

         for(int var5 = 0; var5 < var4.length; ++var5) {
            var4[var5] = var4[var5].trim();
         }

         int var6 = var4.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            String var8 = var4[var7];
            if("application/x-www-form-urlencoded".equals(var8)) {
               return new UrlEncodedFormBody();
            }

            if("application/json".equals(var8)) {
               return new JSONObjectBody();
            }

            if("text/plain".equals(var8)) {
               return new StringBody();
            }

            if("multipart/form-data".equals(var8)) {
               return new MultipartFormDataBody(var3, var4);
            }
         }
      }

      return new UnknownRequestBody(var3);
   }

   public static DataEmitter getBodyDecoder(DataEmitter var0, RawHeaders var1, boolean var2) {
      int var4;
      label45: {
         int var13;
         try {
            var13 = Integer.parseInt(var1.get("Content-Length"));
         } catch (Exception var14) {
            var4 = -1;
            break label45;
         }

         var4 = var13;
      }

      if(-1 != var4) {
         if(var4 < 0) {
            HttpUtil.EndEmitter var12 = HttpUtil.EndEmitter.create(((DataEmitter)var0).getServer(), new Exception("not using chunked encoding, and no content-length found."));
            var12.setDataEmitter((DataEmitter)var0);
            var0 = var12;
            return (DataEmitter)var0;
         }

         if(var4 == 0) {
            HttpUtil.EndEmitter var11 = HttpUtil.EndEmitter.create(((DataEmitter)var0).getServer(), (Exception)null);
            var11.setDataEmitter((DataEmitter)var0);
            return var11;
         }

         ContentLengthFilter var10 = new ContentLengthFilter(var4);
         var10.setDataEmitter((DataEmitter)var0);
         var0 = var10;
      } else if("chunked".equalsIgnoreCase(var1.get("Transfer-Encoding"))) {
         ChunkedInputFilter var6 = new ChunkedInputFilter();
         var6.setDataEmitter((DataEmitter)var0);
         var0 = var6;
      } else if(var2 || var1.getStatusLine().contains("HTTP/1.1")) {
         HttpUtil.EndEmitter var9 = HttpUtil.EndEmitter.create(((DataEmitter)var0).getServer(), (Exception)null);
         var9.setDataEmitter((DataEmitter)var0);
         return var9;
      }

      if("gzip".equals(var1.get("Content-Encoding"))) {
         GZIPInputFilter var7 = new GZIPInputFilter();
         var7.setDataEmitter((DataEmitter)var0);
         return var7;
      } else if("deflate".equals(var1.get("Content-Encoding"))) {
         InflaterInputFilter var8 = new InflaterInputFilter();
         var8.setDataEmitter((DataEmitter)var0);
         return var8;
      } else {
         return (DataEmitter)var0;
      }
   }

   private static class EndEmitter extends FilteredDataEmitter {
      public static HttpUtil.EndEmitter create(AsyncServer var0, final Exception var1) {
         final HttpUtil.EndEmitter var2 = new HttpUtil.EndEmitter();
         var0.post(new Runnable() {
            public void run() {
               var2.report(var1);
            }
         });
         return var2;
      }
   }
}
