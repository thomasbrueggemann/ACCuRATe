package com.parse.http;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ParseHttpResponse {
   private final InputStream content;
   private final String contentType;
   private final Map<String, String> headers;
   private final String reasonPhrase;
   private final int statusCode;
   private final long totalSize;

   private ParseHttpResponse(ParseHttpResponse.Builder var1) {
      this.statusCode = var1.statusCode;
      this.content = var1.content;
      this.totalSize = var1.totalSize;
      this.reasonPhrase = var1.reasonPhrase;
      this.headers = Collections.unmodifiableMap(new HashMap(var1.headers));
      this.contentType = var1.contentType;
   }

   // $FF: synthetic method
   ParseHttpResponse(ParseHttpResponse.Builder var1, Object var2) {
      this(var1);
   }

   public Map<String, String> getAllHeaders() {
      return this.headers;
   }

   public InputStream getContent() {
      return this.content;
   }

   public String getContentType() {
      return this.contentType;
   }

   public String getHeader(String var1) {
      return (String)this.headers.get(var1);
   }

   public String getReasonPhrase() {
      return this.reasonPhrase;
   }

   public int getStatusCode() {
      return this.statusCode;
   }

   public long getTotalSize() {
      return this.totalSize;
   }

   public static final class Builder {
      private InputStream content;
      private String contentType;
      private Map<String, String> headers;
      private String reasonPhrase;
      private int statusCode;
      private long totalSize;

      public Builder() {
         this.totalSize = -1L;
         this.headers = new HashMap();
      }

      public Builder(ParseHttpResponse var1) {
         this.setStatusCode(var1.getStatusCode());
         this.setContent(var1.getContent());
         this.setTotalSize(var1.getTotalSize());
         this.setContentType(var1.getContentType());
         this.setHeaders(var1.getAllHeaders());
         this.setReasonPhrase(var1.getReasonPhrase());
      }

      public ParseHttpResponse.Builder addHeader(String var1, String var2) {
         this.headers.put(var1, var2);
         return this;
      }

      public ParseHttpResponse.Builder addHeaders(Map<String, String> var1) {
         this.headers.putAll(var1);
         return this;
      }

      public ParseHttpResponse build() {
         return new ParseHttpResponse(this);
      }

      public ParseHttpResponse.Builder setContent(InputStream var1) {
         this.content = var1;
         return this;
      }

      public ParseHttpResponse.Builder setContentType(String var1) {
         this.contentType = var1;
         return this;
      }

      public ParseHttpResponse.Builder setHeaders(Map<String, String> var1) {
         this.headers = new HashMap(var1);
         return this;
      }

      public ParseHttpResponse.Builder setReasonPhrase(String var1) {
         this.reasonPhrase = var1;
         return this;
      }

      public ParseHttpResponse.Builder setStatusCode(int var1) {
         this.statusCode = var1;
         return this;
      }

      public ParseHttpResponse.Builder setTotalSize(long var1) {
         this.totalSize = var1;
         return this;
      }
   }
}
