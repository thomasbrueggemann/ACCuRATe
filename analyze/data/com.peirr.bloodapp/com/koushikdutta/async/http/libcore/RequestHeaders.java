package com.koushikdutta.async.http.libcore;

import com.koushikdutta.async.http.libcore.HeaderParser;
import com.koushikdutta.async.http.libcore.HttpDate;
import com.koushikdutta.async.http.libcore.RawHeaders;
import java.net.URI;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class RequestHeaders {
   private String acceptEncoding;
   private String connection;
   private int contentLength = -1;
   private String contentType;
   private boolean hasAuthorization;
   private final RawHeaders headers;
   private String host;
   private String ifModifiedSince;
   private String ifNoneMatch;
   private int maxAgeSeconds = -1;
   private int maxStaleSeconds = -1;
   private int minFreshSeconds = -1;
   private boolean noCache;
   private boolean onlyIfCached;
   private String proxyAuthorization;
   private String transferEncoding;
   private final URI uri;
   private String userAgent;

   public RequestHeaders(URI var1, RawHeaders var2) {
      this.uri = var1;
      this.headers = var2;
      HeaderParser.CacheControlHandler var3 = new HeaderParser.CacheControlHandler() {
         public void handle(String var1, String var2) {
            if(var1.equalsIgnoreCase("no-cache")) {
               RequestHeaders.this.noCache = true;
            } else {
               if(var1.equalsIgnoreCase("max-age")) {
                  RequestHeaders.this.maxAgeSeconds = HeaderParser.parseSeconds(var2);
                  return;
               }

               if(var1.equalsIgnoreCase("max-stale")) {
                  RequestHeaders.this.maxStaleSeconds = HeaderParser.parseSeconds(var2);
                  return;
               }

               if(var1.equalsIgnoreCase("min-fresh")) {
                  RequestHeaders.this.minFreshSeconds = HeaderParser.parseSeconds(var2);
                  return;
               }

               if(var1.equalsIgnoreCase("only-if-cached")) {
                  RequestHeaders.this.onlyIfCached = true;
                  return;
               }
            }

         }
      };

      for(int var4 = 0; var4 < var2.length(); ++var4) {
         String var5 = var2.getFieldName(var4);
         String var6 = var2.getValue(var4);
         if("Cache-Control".equalsIgnoreCase(var5)) {
            HeaderParser.parseCacheControl(var6, var3);
         } else if("Pragma".equalsIgnoreCase(var5)) {
            if(var6.equalsIgnoreCase("no-cache")) {
               this.noCache = true;
            }
         } else if("If-None-Match".equalsIgnoreCase(var5)) {
            this.ifNoneMatch = var6;
         } else if("If-Modified-Since".equalsIgnoreCase(var5)) {
            this.ifModifiedSince = var6;
         } else if("Authorization".equalsIgnoreCase(var5)) {
            this.hasAuthorization = true;
         } else if("Content-Length".equalsIgnoreCase(var5)) {
            try {
               this.contentLength = Integer.parseInt(var6);
            } catch (NumberFormatException var8) {
               ;
            }
         } else if("Transfer-Encoding".equalsIgnoreCase(var5)) {
            this.transferEncoding = var6;
         } else if("User-Agent".equalsIgnoreCase(var5)) {
            this.userAgent = var6;
         } else if("Host".equalsIgnoreCase(var5)) {
            this.host = var6;
         } else if("Connection".equalsIgnoreCase(var5)) {
            this.connection = var6;
         } else if("Accept-Encoding".equalsIgnoreCase(var5)) {
            this.acceptEncoding = var6;
         } else if("Content-Type".equalsIgnoreCase(var5)) {
            this.contentType = var6;
         } else if("Proxy-Authorization".equalsIgnoreCase(var5)) {
            this.proxyAuthorization = var6;
         }
      }

   }

   public void addCookies(Map<String, List<String>> var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(true) {
         Entry var3;
         String var4;
         do {
            if(!var2.hasNext()) {
               return;
            }

            var3 = (Entry)var2.next();
            var4 = (String)var3.getKey();
         } while(!"Cookie".equalsIgnoreCase(var4) && !"Cookie2".equalsIgnoreCase(var4));

         this.headers.addAll(var4, (List)var3.getValue());
      }
   }

   public String getAcceptEncoding() {
      return this.acceptEncoding;
   }

   public String getConnection() {
      return this.connection;
   }

   public int getContentLength() {
      return this.contentLength;
   }

   public String getContentType() {
      return this.contentType;
   }

   public RawHeaders getHeaders() {
      return this.headers;
   }

   public String getHost() {
      return this.host;
   }

   public String getIfModifiedSince() {
      return this.ifModifiedSince;
   }

   public String getIfNoneMatch() {
      return this.ifNoneMatch;
   }

   public int getMaxAgeSeconds() {
      return this.maxAgeSeconds;
   }

   public int getMaxStaleSeconds() {
      return this.maxStaleSeconds;
   }

   public int getMinFreshSeconds() {
      return this.minFreshSeconds;
   }

   public String getProxyAuthorization() {
      return this.proxyAuthorization;
   }

   public String getTransferEncoding() {
      return this.transferEncoding;
   }

   public URI getUri() {
      return this.uri;
   }

   public String getUserAgent() {
      return this.userAgent;
   }

   public boolean hasAuthorization() {
      return this.hasAuthorization;
   }

   public boolean hasConditions() {
      return this.ifModifiedSince != null || this.ifNoneMatch != null;
   }

   public boolean hasConnectionClose() {
      return "close".equalsIgnoreCase(this.connection);
   }

   public boolean isChunked() {
      return "chunked".equalsIgnoreCase(this.transferEncoding);
   }

   public boolean isNoCache() {
      return this.noCache;
   }

   public boolean isOnlyIfCached() {
      return this.onlyIfCached;
   }

   public void setAcceptEncoding(String var1) {
      if(this.acceptEncoding != null) {
         this.headers.removeAll("Accept-Encoding");
      }

      this.headers.add("Accept-Encoding", var1);
      this.acceptEncoding = var1;
   }

   public void setChunked() {
      if(this.transferEncoding != null) {
         this.headers.removeAll("Transfer-Encoding");
      }

      this.headers.add("Transfer-Encoding", "chunked");
      this.transferEncoding = "chunked";
   }

   public void setConnection(String var1) {
      if(this.connection != null) {
         this.headers.removeAll("Connection");
      }

      this.headers.add("Connection", var1);
      this.connection = var1;
   }

   public void setContentLength(int var1) {
      if(this.contentLength != -1) {
         this.headers.removeAll("Content-Length");
      }

      this.headers.add("Content-Length", Integer.toString(var1));
      this.contentLength = var1;
   }

   public void setContentType(String var1) {
      if(this.contentType != null) {
         this.headers.removeAll("Content-Type");
      }

      this.headers.add("Content-Type", var1);
      this.contentType = var1;
   }

   public void setHost(String var1) {
      if(this.host != null) {
         this.headers.removeAll("Host");
      }

      this.headers.add("Host", var1);
      this.host = var1;
   }

   public void setIfModifiedSince(Date var1) {
      if(this.ifModifiedSince != null) {
         this.headers.removeAll("If-Modified-Since");
      }

      String var2 = HttpDate.format(var1);
      this.headers.add("If-Modified-Since", var2);
      this.ifModifiedSince = var2;
   }

   public void setIfNoneMatch(String var1) {
      if(this.ifNoneMatch != null) {
         this.headers.removeAll("If-None-Match");
      }

      this.headers.add("If-None-Match", var1);
      this.ifNoneMatch = var1;
   }

   public void setUserAgent(String var1) {
      if(this.userAgent != null) {
         this.headers.removeAll("User-Agent");
      }

      this.headers.add("User-Agent", var1);
      this.userAgent = var1;
   }
}
