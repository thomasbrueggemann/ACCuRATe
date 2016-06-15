package com.squareup.okhttp;

import com.squareup.okhttp.OkResponseCache;
import com.squareup.okhttp.ResponseSource;
import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.StrictLineReader;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpURLConnectionImpl;
import com.squareup.okhttp.internal.http.HttpsEngine;
import com.squareup.okhttp.internal.http.HttpsURLConnectionImpl;
import com.squareup.okhttp.internal.http.RawHeaders;
import com.squareup.okhttp.internal.http.ResponseHeaders;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.ResponseCache;
import java.net.SecureCacheResponse;
import java.net.URI;
import java.net.URLConnection;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

public final class HttpResponseCache extends ResponseCache {
   private static final int ENTRY_BODY = 1;
   private static final int ENTRY_COUNT = 2;
   private static final int ENTRY_METADATA = 0;
   private static final int VERSION = 201105;
   private final DiskLruCache cache;
   private int hitCount;
   private int networkCount;
   final OkResponseCache okResponseCache = new OkResponseCache() {
      public CacheResponse get(URI var1, String var2, Map<String, List<String>> var3) throws IOException {
         return HttpResponseCache.this.get(var1, var2, var3);
      }

      public void maybeRemove(String var1, URI var2) throws IOException {
         HttpResponseCache.this.maybeRemove(var1, var2);
      }

      public CacheRequest put(URI var1, URLConnection var2) throws IOException {
         return HttpResponseCache.this.put(var1, var2);
      }

      public void trackConditionalCacheHit() {
         HttpResponseCache.this.trackConditionalCacheHit();
      }

      public void trackResponse(ResponseSource var1) {
         HttpResponseCache.this.trackResponse(var1);
      }

      public void update(CacheResponse var1, HttpURLConnection var2) throws IOException {
         HttpResponseCache.this.update(var1, var2);
      }
   };
   private int requestCount;
   private int writeAbortCount;
   private int writeSuccessCount;

   public HttpResponseCache(File var1, long var2) throws IOException {
      this.cache = DiskLruCache.open(var1, 201105, 2, var2);
   }

   private void abortQuietly(DiskLruCache.Editor var1) {
      if(var1 != null) {
         try {
            var1.abort();
         } catch (IOException var3) {
            return;
         }
      }

   }

   // $FF: synthetic method
   static int access$808(HttpResponseCache var0) {
      int var1 = var0.writeSuccessCount;
      var0.writeSuccessCount = var1 + 1;
      return var1;
   }

   // $FF: synthetic method
   static int access$908(HttpResponseCache var0) {
      int var1 = var0.writeAbortCount;
      var0.writeAbortCount = var1 + 1;
      return var1;
   }

   private HttpEngine getHttpEngine(URLConnection var1) {
      return var1 instanceof HttpURLConnectionImpl?((HttpURLConnectionImpl)var1).getHttpEngine():(var1 instanceof HttpsURLConnectionImpl?((HttpsURLConnectionImpl)var1).getHttpEngine():null);
   }

   private boolean maybeRemove(String var1, URI var2) {
      if(!var1.equals("POST") && !var1.equals("PUT") && !var1.equals("DELETE")) {
         return false;
      } else {
         try {
            this.cache.remove(this.uriToKey(var2));
         } catch (IOException var4) {
            ;
         }

         return true;
      }
   }

   private static InputStream newBodyInputStream(final DiskLruCache.Snapshot var0) {
      return new FilterInputStream(var0.getInputStream(1)) {
         public void close() throws IOException {
            var0.close();
            super.close();
         }
      };
   }

   private void trackConditionalCacheHit() {
      synchronized(this){}

      try {
         ++this.hitCount;
      } finally {
         ;
      }

   }

   private void trackResponse(ResponseSource param1) {
      // $FF: Couldn't be decompiled
   }

   private void update(CacheResponse param1, HttpURLConnection param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private String uriToKey(URI var1) {
      return Util.hash(var1.toString());
   }

   public void close() throws IOException {
      this.cache.close();
   }

   public void delete() throws IOException {
      this.cache.delete();
   }

   public void flush() throws IOException {
      this.cache.flush();
   }

   public CacheResponse get(URI param1, String param2, Map<String, List<String>> param3) {
      // $FF: Couldn't be decompiled
   }

   public File getDirectory() {
      return this.cache.getDirectory();
   }

   public int getHitCount() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.hitCount;
      } finally {
         ;
      }

      return var2;
   }

   public long getMaxSize() {
      return this.cache.getMaxSize();
   }

   public int getNetworkCount() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.networkCount;
      } finally {
         ;
      }

      return var2;
   }

   public int getRequestCount() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.requestCount;
      } finally {
         ;
      }

      return var2;
   }

   public long getSize() {
      return this.cache.size();
   }

   public int getWriteAbortCount() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.writeAbortCount;
      } finally {
         ;
      }

      return var2;
   }

   public int getWriteSuccessCount() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.writeSuccessCount;
      } finally {
         ;
      }

      return var2;
   }

   public boolean isClosed() {
      return this.cache.isClosed();
   }

   public CacheRequest put(URI param1, URLConnection param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private final class CacheRequestImpl extends CacheRequest {
      private OutputStream body;
      private OutputStream cacheOut;
      private boolean done;
      private final DiskLruCache.Editor editor;

      public CacheRequestImpl(final DiskLruCache.Editor var2) throws IOException {
         this.editor = var2;
         this.cacheOut = var2.newOutputStream(1);
         this.body = new FilterOutputStream(this.cacheOut) {
            public void close() throws IOException {
               // $FF: Couldn't be decompiled
            }

            public void write(byte[] var1, int var2x, int var3) throws IOException {
               this.out.write(var1, var2x, var3);
            }
         };
      }

      // $FF: synthetic method
      static boolean access$700(HttpResponseCache.CacheRequestImpl var0) {
         return var0.done;
      }

      // $FF: synthetic method
      static boolean access$702(HttpResponseCache.CacheRequestImpl var0, boolean var1) {
         var0.done = var1;
         return var1;
      }

      public void abort() {
         // $FF: Couldn't be decompiled
      }

      public OutputStream getBody() throws IOException {
         return this.body;
      }
   }

   private static final class Entry {
      private final String cipherSuite;
      private final Certificate[] localCertificates;
      private final Certificate[] peerCertificates;
      private final String requestMethod;
      private final RawHeaders responseHeaders;
      private final String uri;
      private final RawHeaders varyHeaders;

      public Entry(InputStream param1) throws IOException {
         // $FF: Couldn't be decompiled
      }

      public Entry(URI var1, RawHeaders var2, HttpURLConnection var3) throws IOException {
         this.uri = var1.toString();
         this.varyHeaders = var2;
         this.requestMethod = var3.getRequestMethod();
         this.responseHeaders = RawHeaders.fromMultimap(var3.getHeaderFields(), true);
         SSLSocket var4 = this.getSslSocket(var3);
         if(var4 != null) {
            this.cipherSuite = var4.getSession().getCipherSuite();

            Certificate[] var6;
            label15: {
               Certificate[] var7;
               try {
                  var7 = var4.getSession().getPeerCertificates();
               } catch (SSLPeerUnverifiedException var8) {
                  var6 = null;
                  break label15;
               }

               var6 = var7;
            }

            this.peerCertificates = var6;
            this.localCertificates = var4.getSession().getLocalCertificates();
         } else {
            this.cipherSuite = null;
            this.peerCertificates = null;
            this.localCertificates = null;
         }
      }

      // $FF: synthetic method
      static boolean access$400(HttpResponseCache.Entry var0) {
         return var0.isHttps();
      }

      private SSLSocket getSslSocket(HttpURLConnection var1) {
         HttpEngine var2;
         if(var1 instanceof HttpsURLConnectionImpl) {
            var2 = ((HttpsURLConnectionImpl)var1).getHttpEngine();
         } else {
            var2 = ((HttpURLConnectionImpl)var1).getHttpEngine();
         }

         return var2 instanceof HttpsEngine?((HttpsEngine)var2).getSslSocket():null;
      }

      private boolean isHttps() {
         return this.uri.startsWith("https://");
      }

      private Certificate[] readCertArray(StrictLineReader param1) throws IOException {
         // $FF: Couldn't be decompiled
      }

      private void writeCertArray(Writer param1, Certificate[] param2) throws IOException {
         // $FF: Couldn't be decompiled
      }

      public boolean matches(URI var1, String var2, Map<String, List<String>> var3) {
         boolean var4 = this.uri.equals(var1.toString());
         boolean var5 = false;
         if(var4) {
            boolean var6 = this.requestMethod.equals(var2);
            var5 = false;
            if(var6) {
               boolean var7 = (new ResponseHeaders(var1, this.responseHeaders)).varyMatches(this.varyHeaders.toMultimap(false), var3);
               var5 = false;
               if(var7) {
                  var5 = true;
               }
            }
         }

         return var5;
      }

      public void writeTo(DiskLruCache.Editor var1) throws IOException {
         BufferedWriter var2 = new BufferedWriter(new OutputStreamWriter(var1.newOutputStream(0), Util.UTF_8));
         var2.write(this.uri + '\n');
         var2.write(this.requestMethod + '\n');
         var2.write(Integer.toString(this.varyHeaders.length()) + '\n');

         for(int var3 = 0; var3 < this.varyHeaders.length(); ++var3) {
            var2.write(this.varyHeaders.getFieldName(var3) + ": " + this.varyHeaders.getValue(var3) + '\n');
         }

         var2.write(this.responseHeaders.getStatusLine() + '\n');
         var2.write(Integer.toString(this.responseHeaders.length()) + '\n');

         for(int var4 = 0; var4 < this.responseHeaders.length(); ++var4) {
            var2.write(this.responseHeaders.getFieldName(var4) + ": " + this.responseHeaders.getValue(var4) + '\n');
         }

         if(this.isHttps()) {
            var2.write(10);
            var2.write(this.cipherSuite + '\n');
            this.writeCertArray(var2, this.peerCertificates);
            this.writeCertArray(var2, this.localCertificates);
         }

         var2.close();
      }
   }

   static class EntryCacheResponse extends CacheResponse {
      private final HttpResponseCache.Entry entry;
      // $FF: renamed from: in java.io.InputStream
      private final InputStream field_11;
      private final DiskLruCache.Snapshot snapshot;

      public EntryCacheResponse(HttpResponseCache.Entry var1, DiskLruCache.Snapshot var2) {
         this.entry = var1;
         this.snapshot = var2;
         this.field_11 = HttpResponseCache.newBodyInputStream(var2);
      }

      // $FF: synthetic method
      static DiskLruCache.Snapshot access$500(HttpResponseCache.EntryCacheResponse var0) {
         return var0.snapshot;
      }

      public InputStream getBody() {
         return this.field_11;
      }

      public Map<String, List<String>> getHeaders() {
         return this.entry.responseHeaders.toMultimap(true);
      }
   }

   static class EntrySecureCacheResponse extends SecureCacheResponse {
      private final HttpResponseCache.Entry entry;
      // $FF: renamed from: in java.io.InputStream
      private final InputStream field_18;
      private final DiskLruCache.Snapshot snapshot;

      public EntrySecureCacheResponse(HttpResponseCache.Entry var1, DiskLruCache.Snapshot var2) {
         this.entry = var1;
         this.snapshot = var2;
         this.field_18 = HttpResponseCache.newBodyInputStream(var2);
      }

      // $FF: synthetic method
      static DiskLruCache.Snapshot access$600(HttpResponseCache.EntrySecureCacheResponse var0) {
         return var0.snapshot;
      }

      public InputStream getBody() {
         return this.field_18;
      }

      public String getCipherSuite() {
         return this.entry.cipherSuite;
      }

      public Map<String, List<String>> getHeaders() {
         return this.entry.responseHeaders.toMultimap(true);
      }

      public List<Certificate> getLocalCertificateChain() {
         return this.entry.localCertificates != null && this.entry.localCertificates.length != 0?Arrays.asList((Object[])this.entry.localCertificates.clone()):null;
      }

      public Principal getLocalPrincipal() {
         return this.entry.localCertificates != null && this.entry.localCertificates.length != 0?((X509Certificate)this.entry.localCertificates[0]).getSubjectX500Principal():null;
      }

      public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
         if(this.entry.peerCertificates != null && this.entry.peerCertificates.length != 0) {
            return ((X509Certificate)this.entry.peerCertificates[0]).getSubjectX500Principal();
         } else {
            throw new SSLPeerUnverifiedException((String)null);
         }
      }

      public List<Certificate> getServerCertificateChain() throws SSLPeerUnverifiedException {
         if(this.entry.peerCertificates != null && this.entry.peerCertificates.length != 0) {
            return Arrays.asList((Object[])this.entry.peerCertificates.clone());
         } else {
            throw new SSLPeerUnverifiedException((String)null);
         }
      }
   }
}
