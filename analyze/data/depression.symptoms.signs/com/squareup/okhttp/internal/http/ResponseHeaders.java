package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.ResponseSource;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HeaderParser;
import com.squareup.okhttp.internal.http.HttpDate;
import com.squareup.okhttp.internal.http.RawHeaders;
import com.squareup.okhttp.internal.http.RequestHeaders;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public final class ResponseHeaders {
   private static final String RECEIVED_MILLIS = Platform.get().getPrefix() + "-Received-Millis";
   static final String RESPONSE_SOURCE = Platform.get().getPrefix() + "-Response-Source";
   static final String SELECTED_TRANSPORT = Platform.get().getPrefix() + "-Selected-Transport";
   private static final String SENT_MILLIS = Platform.get().getPrefix() + "-Sent-Millis";
   private int ageSeconds = -1;
   private String connection;
   private String contentEncoding;
   private long contentLength = -1L;
   private String contentType;
   private String etag;
   private Date expires;
   private final RawHeaders headers;
   private boolean isPublic;
   private Date lastModified;
   private int maxAgeSeconds = -1;
   private boolean mustRevalidate;
   private boolean noCache;
   private boolean noStore;
   private long receivedResponseMillis;
   private int sMaxAgeSeconds = -1;
   private long sentRequestMillis;
   private Date servedDate;
   private String transferEncoding;
   private final URI uri;
   private Set<String> varyFields = Collections.emptySet();

   public ResponseHeaders(URI var1, RawHeaders var2) {
      this.uri = var1;
      this.headers = var2;
      HeaderParser.CacheControlHandler var3 = new HeaderParser.CacheControlHandler() {
         public void handle(String var1, String var2) {
            if("no-cache".equalsIgnoreCase(var1)) {
               ResponseHeaders.this.noCache = true;
            } else {
               if("no-store".equalsIgnoreCase(var1)) {
                  ResponseHeaders.this.noStore = true;
                  return;
               }

               if("max-age".equalsIgnoreCase(var1)) {
                  ResponseHeaders.this.maxAgeSeconds = HeaderParser.parseSeconds(var2);
                  return;
               }

               if("s-maxage".equalsIgnoreCase(var1)) {
                  ResponseHeaders.this.sMaxAgeSeconds = HeaderParser.parseSeconds(var2);
                  return;
               }

               if("public".equalsIgnoreCase(var1)) {
                  ResponseHeaders.this.isPublic = true;
                  return;
               }

               if("must-revalidate".equalsIgnoreCase(var1)) {
                  ResponseHeaders.this.mustRevalidate = true;
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
         } else if("Date".equalsIgnoreCase(var5)) {
            this.servedDate = HttpDate.parse(var6);
         } else if("Expires".equalsIgnoreCase(var5)) {
            this.expires = HttpDate.parse(var6);
         } else if("Last-Modified".equalsIgnoreCase(var5)) {
            this.lastModified = HttpDate.parse(var6);
         } else if("ETag".equalsIgnoreCase(var5)) {
            this.etag = var6;
         } else if("Pragma".equalsIgnoreCase(var5)) {
            if("no-cache".equalsIgnoreCase(var6)) {
               this.noCache = true;
            }
         } else if("Age".equalsIgnoreCase(var5)) {
            this.ageSeconds = HeaderParser.parseSeconds(var6);
         } else if("Vary".equalsIgnoreCase(var5)) {
            if(this.varyFields.isEmpty()) {
               this.varyFields = new TreeSet(String.CASE_INSENSITIVE_ORDER);
            }

            String[] var8 = var6.split(",");
            int var9 = var8.length;

            for(int var10 = 0; var10 < var9; ++var10) {
               String var11 = var8[var10];
               this.varyFields.add(var11.trim());
            }
         } else if("Content-Encoding".equalsIgnoreCase(var5)) {
            this.contentEncoding = var6;
         } else if("Transfer-Encoding".equalsIgnoreCase(var5)) {
            this.transferEncoding = var6;
         } else if("Content-Length".equalsIgnoreCase(var5)) {
            try {
               this.contentLength = Long.parseLong(var6);
            } catch (NumberFormatException var12) {
               ;
            }
         } else if("Content-Type".equalsIgnoreCase(var5)) {
            this.contentType = var6;
         } else if("Connection".equalsIgnoreCase(var5)) {
            this.connection = var6;
         } else if(SENT_MILLIS.equalsIgnoreCase(var5)) {
            this.sentRequestMillis = Long.parseLong(var6);
         } else if(RECEIVED_MILLIS.equalsIgnoreCase(var5)) {
            this.receivedResponseMillis = Long.parseLong(var6);
         }
      }

   }

   private long computeAge(long var1) {
      long var3 = 0L;
      if(this.servedDate != null) {
         var3 = Math.max(var3, this.receivedResponseMillis - this.servedDate.getTime());
      }

      long var5;
      if(this.ageSeconds != -1) {
         var5 = Math.max(var3, TimeUnit.SECONDS.toMillis((long)this.ageSeconds));
      } else {
         var5 = var3;
      }

      long var7 = this.receivedResponseMillis - this.sentRequestMillis;
      return var1 - this.receivedResponseMillis + var5 + var7;
   }

   private long computeFreshnessLifetime() {
      long var1 = 0L;
      if(this.maxAgeSeconds != -1) {
         var1 = TimeUnit.SECONDS.toMillis((long)this.maxAgeSeconds);
      } else {
         if(this.expires != null) {
            long var7;
            if(this.servedDate != null) {
               var7 = this.servedDate.getTime();
            } else {
               var7 = this.receivedResponseMillis;
            }

            long var9 = this.expires.getTime() - var7;
            if(var9 <= var1) {
               var9 = var1;
            }

            return var9;
         }

         if(this.lastModified != null && this.uri.getRawQuery() == null) {
            long var3;
            if(this.servedDate != null) {
               var3 = this.servedDate.getTime();
            } else {
               var3 = this.sentRequestMillis;
            }

            long var5 = var3 - this.lastModified.getTime();
            if(var5 > var1) {
               return var5 / 10L;
            }
         }
      }

      return var1;
   }

   private static boolean isEndToEnd(String var0) {
      return !"Connection".equalsIgnoreCase(var0) && !"Keep-Alive".equalsIgnoreCase(var0) && !"Proxy-Authenticate".equalsIgnoreCase(var0) && !"Proxy-Authorization".equalsIgnoreCase(var0) && !"TE".equalsIgnoreCase(var0) && !"Trailers".equalsIgnoreCase(var0) && !"Transfer-Encoding".equalsIgnoreCase(var0) && !"Upgrade".equalsIgnoreCase(var0);
   }

   private boolean isFreshnessLifetimeHeuristic() {
      return this.maxAgeSeconds == -1 && this.expires == null;
   }

   public ResponseSource chooseResponseSource(long var1, RequestHeaders var3) {
      if(!this.isCacheable(var3)) {
         return ResponseSource.NETWORK;
      } else if(!var3.isNoCache() && !var3.hasConditions()) {
         long var4 = this.computeAge(var1);
         long var6 = this.computeFreshnessLifetime();
         if(var3.getMaxAgeSeconds() != -1) {
            var6 = Math.min(var6, TimeUnit.SECONDS.toMillis((long)var3.getMaxAgeSeconds()));
         }

         long var8 = 0L;
         if(var3.getMinFreshSeconds() != -1) {
            var8 = TimeUnit.SECONDS.toMillis((long)var3.getMinFreshSeconds());
         }

         long var10 = 0L;
         if(!this.mustRevalidate && var3.getMaxStaleSeconds() != -1) {
            var10 = TimeUnit.SECONDS.toMillis((long)var3.getMaxStaleSeconds());
         }

         if(!this.noCache && var4 + var8 < var6 + var10) {
            if(var4 + var8 >= var6) {
               this.headers.add("Warning", "110 HttpURLConnection \"Response is stale\"");
            }

            if(var4 > 86400000L && this.isFreshnessLifetimeHeuristic()) {
               this.headers.add("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            }

            return ResponseSource.CACHE;
         } else {
            if(this.lastModified != null) {
               var3.setIfModifiedSince(this.lastModified);
            } else if(this.servedDate != null) {
               var3.setIfModifiedSince(this.servedDate);
            }

            if(this.etag != null) {
               var3.setIfNoneMatch(this.etag);
            }

            return var3.hasConditions()?ResponseSource.CONDITIONAL_CACHE:ResponseSource.NETWORK;
         }
      } else {
         return ResponseSource.NETWORK;
      }
   }

   public ResponseHeaders combine(ResponseHeaders var1) throws IOException {
      RawHeaders var2 = new RawHeaders();
      var2.setStatusLine(this.headers.getStatusLine());

      for(int var3 = 0; var3 < this.headers.length(); ++var3) {
         String var6 = this.headers.getFieldName(var3);
         String var7 = this.headers.getValue(var3);
         if((!"Warning".equals(var6) || !var7.startsWith("1")) && (!isEndToEnd(var6) || var1.headers.get(var6) == null)) {
            var2.add(var6, var7);
         }
      }

      for(int var4 = 0; var4 < var1.headers.length(); ++var4) {
         String var5 = var1.headers.getFieldName(var4);
         if(isEndToEnd(var5)) {
            var2.add(var5, var1.headers.getValue(var4));
         }
      }

      return new ResponseHeaders(this.uri, var2);
   }

   public String getConnection() {
      return this.connection;
   }

   public String getContentEncoding() {
      return this.contentEncoding;
   }

   public long getContentLength() {
      return this.contentLength;
   }

   public String getContentType() {
      return this.contentType;
   }

   public String getEtag() {
      return this.etag;
   }

   public Date getExpires() {
      return this.expires;
   }

   public RawHeaders getHeaders() {
      return this.headers;
   }

   public Date getLastModified() {
      return this.lastModified;
   }

   public int getMaxAgeSeconds() {
      return this.maxAgeSeconds;
   }

   public int getSMaxAgeSeconds() {
      return this.sMaxAgeSeconds;
   }

   public Date getServedDate() {
      return this.servedDate;
   }

   public URI getUri() {
      return this.uri;
   }

   public Set<String> getVaryFields() {
      return this.varyFields;
   }

   public boolean hasConnectionClose() {
      return "close".equalsIgnoreCase(this.connection);
   }

   public boolean hasVaryAll() {
      return this.varyFields.contains("*");
   }

   public boolean isCacheable(RequestHeaders var1) {
      int var2 = this.headers.getResponseCode();
      return (var2 == 200 || var2 == 203 || var2 == 300 || var2 == 301 || var2 == 410) && (!var1.hasAuthorization() || this.isPublic || this.mustRevalidate || this.sMaxAgeSeconds != -1) && !this.noStore;
   }

   public boolean isChunked() {
      return "chunked".equalsIgnoreCase(this.transferEncoding);
   }

   public boolean isContentEncodingGzip() {
      return "gzip".equalsIgnoreCase(this.contentEncoding);
   }

   public boolean isMustRevalidate() {
      return this.mustRevalidate;
   }

   public boolean isNoCache() {
      return this.noCache;
   }

   public boolean isNoStore() {
      return this.noStore;
   }

   public boolean isPublic() {
      return this.isPublic;
   }

   public void setLocalTimestamps(long var1, long var3) {
      this.sentRequestMillis = var1;
      this.headers.add(SENT_MILLIS, Long.toString(var1));
      this.receivedResponseMillis = var3;
      this.headers.add(RECEIVED_MILLIS, Long.toString(var3));
   }

   public void setResponseSource(ResponseSource var1) {
      this.headers.set(RESPONSE_SOURCE, var1.toString() + " " + this.headers.getResponseCode());
   }

   public void setTransport(String var1) {
      this.headers.set(SELECTED_TRANSPORT, var1);
   }

   public void stripContentEncoding() {
      this.contentEncoding = null;
      this.headers.removeAll("Content-Encoding");
   }

   public void stripContentLength() {
      this.contentLength = -1L;
      this.headers.removeAll("Content-Length");
   }

   public boolean validate(ResponseHeaders var1) {
      return var1.headers.getResponseCode() == 304 || this.lastModified != null && var1.lastModified != null && var1.lastModified.getTime() < this.lastModified.getTime();
   }

   public boolean varyMatches(Map<String, List<String>> var1, Map<String, List<String>> var2) {
      Iterator var3 = this.varyFields.iterator();

      String var4;
      do {
         if(!var3.hasNext()) {
            return true;
         }

         var4 = (String)var3.next();
      } while(Util.equal(var1.get(var4), var2.get(var4)));

      return false;
   }
}
