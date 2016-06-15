package com.squareup.okhttp;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.internal.http.RawHeaders;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

final class Request {
   private final Request.Body body;
   private final RawHeaders headers;
   private final String method;
   private final Object tag;
   private final URL url;

   private Request(Request.Builder var1) {
      this.url = var1.url;
      this.method = var1.method;
      this.headers = new RawHeaders(var1.headers);
      this.body = var1.body;
      Object var2;
      if(var1.tag != null) {
         var2 = var1.tag;
      } else {
         var2 = this;
      }

      this.tag = var2;
   }

   // $FF: synthetic method
   Request(Request.Builder var1, Object var2) {
      this(var1);
   }

   public Request.Body body() {
      return this.body;
   }

   public String header(String var1) {
      return this.headers.get(var1);
   }

   public int headerCount() {
      return this.headers.length();
   }

   public String headerName(int var1) {
      return this.headers.getFieldName(var1);
   }

   public Set<String> headerNames() {
      return this.headers.names();
   }

   public String headerValue(int var1) {
      return this.headers.getValue(var1);
   }

   public List<String> headers(String var1) {
      return this.headers.values(var1);
   }

   public String method() {
      return this.method;
   }

   Request.Builder newBuilder() {
      return (new Request.Builder(this.url)).method(this.method, this.body).rawHeaders(this.headers).tag(this.tag);
   }

   RawHeaders rawHeaders() {
      return new RawHeaders(this.headers);
   }

   public Object tag() {
      return this.tag;
   }

   public URL url() {
      return this.url;
   }

   public String urlString() {
      return this.url.toString();
   }

   public abstract static class Body {
      public static Request.Body create(final MediaType var0, final File var1) {
         if(var0 == null) {
            throw new NullPointerException("contentType == null");
         } else if(var1 == null) {
            throw new NullPointerException("content == null");
         } else {
            return new Request.Body() {
               public long contentLength() {
                  return var1.length();
               }

               public MediaType contentType() {
                  return var0;
               }

               public void writeTo(OutputStream param1) throws IOException {
                  // $FF: Couldn't be decompiled
               }
            };
         }
      }

      public static Request.Body create(MediaType var0, String var1) {
         if(var0.charset() == null) {
            var0 = MediaType.parse(var0 + "; charset=utf-8");
         }

         try {
            Request.Body var3 = create(var0, var1.getBytes(var0.charset().name()));
            return var3;
         } catch (UnsupportedEncodingException var4) {
            throw new AssertionError();
         }
      }

      public static Request.Body create(final MediaType var0, final byte[] var1) {
         if(var0 == null) {
            throw new NullPointerException("contentType == null");
         } else if(var1 == null) {
            throw new NullPointerException("content == null");
         } else {
            return new Request.Body() {
               public long contentLength() {
                  return (long)var1.length;
               }

               public MediaType contentType() {
                  return var0;
               }

               public void writeTo(OutputStream var1x) throws IOException {
                  var1x.write(var1);
               }
            };
         }
      }

      public long contentLength() {
         return -1L;
      }

      public abstract MediaType contentType();

      public abstract void writeTo(OutputStream var1) throws IOException;
   }

   public static class Builder {
      private Request.Body body;
      private RawHeaders headers = new RawHeaders();
      private String method = "GET";
      private Object tag;
      private URL url;

      public Builder(String var1) {
         this.url(var1);
      }

      public Builder(URL var1) {
         this.url(var1);
      }

      public Request.Builder addHeader(String var1, String var2) {
         this.headers.add(var1, var2);
         return this;
      }

      public Request build() {
         return new Request(this);
      }

      public Request.Builder get() {
         return this.method("GET", (Request.Body)null);
      }

      public Request.Builder head() {
         return this.method("HEAD", (Request.Body)null);
      }

      public Request.Builder header(String var1, String var2) {
         this.headers.set(var1, var2);
         return this;
      }

      public Request.Builder method(String var1, Request.Body var2) {
         if(var1 != null && var1.length() != 0) {
            this.method = var1;
            this.body = var2;
            return this;
         } else {
            throw new IllegalArgumentException("method == null || method.length() == 0");
         }
      }

      public Request.Builder post(Request.Body var1) {
         return this.method("POST", var1);
      }

      public Request.Builder put(Request.Body var1) {
         return this.method("PUT", var1);
      }

      Request.Builder rawHeaders(RawHeaders var1) {
         this.headers = new RawHeaders(var1);
         return this;
      }

      public Request.Builder tag(Object var1) {
         this.tag = var1;
         return this;
      }

      public Request.Builder url(String var1) {
         try {
            this.url = new URL(var1);
            return this;
         } catch (MalformedURLException var3) {
            throw new IllegalArgumentException("Malformed URL: " + var1);
         }
      }

      public Request.Builder url(URL var1) {
         if(var1 == null) {
            throw new IllegalStateException("url == null");
         } else {
            this.url = var1;
            return this;
         }
      }
   }
}
