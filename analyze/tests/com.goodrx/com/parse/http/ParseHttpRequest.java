package com.parse.http;

import com.parse.http.ParseHttpBody;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ParseHttpRequest {
   private final ParseHttpBody body;
   private final Map<String, String> headers;
   private final ParseHttpRequest.Method method;
   private final String url;

   private ParseHttpRequest(ParseHttpRequest.Builder var1) {
      this.url = var1.url;
      this.method = var1.method;
      this.headers = Collections.unmodifiableMap(new HashMap(var1.headers));
      this.body = var1.body;
   }

   // $FF: synthetic method
   ParseHttpRequest(ParseHttpRequest.Builder var1, Object var2) {
      this(var1);
   }

   public Map<String, String> getAllHeaders() {
      return this.headers;
   }

   public ParseHttpBody getBody() {
      return this.body;
   }

   public String getHeader(String var1) {
      return (String)this.headers.get(var1);
   }

   public ParseHttpRequest.Method getMethod() {
      return this.method;
   }

   public String getUrl() {
      return this.url;
   }

   public static final class Builder {
      private ParseHttpBody body;
      private Map<String, String> headers;
      private ParseHttpRequest.Method method;
      private String url;

      public Builder() {
         this.headers = new HashMap();
      }

      public Builder(ParseHttpRequest var1) {
         this.url = var1.url;
         this.method = var1.method;
         this.headers = new HashMap(var1.headers);
         this.body = var1.body;
      }

      public ParseHttpRequest.Builder addHeader(String var1, String var2) {
         this.headers.put(var1, var2);
         return this;
      }

      public ParseHttpRequest.Builder addHeaders(Map<String, String> var1) {
         this.headers.putAll(var1);
         return this;
      }

      public ParseHttpRequest build() {
         return new ParseHttpRequest(this, null);
      }

      public ParseHttpRequest.Builder setBody(ParseHttpBody var1) {
         this.body = var1;
         return this;
      }

      public ParseHttpRequest.Builder setHeaders(Map<String, String> var1) {
         this.headers = new HashMap(var1);
         return this;
      }

      public ParseHttpRequest.Builder setMethod(ParseHttpRequest.Method var1) {
         this.method = var1;
         return this;
      }

      public ParseHttpRequest.Builder setUrl(String var1) {
         this.url = var1;
         return this;
      }
   }

   public static enum Method {
      DELETE,
      GET,
      POST,
      PUT;

      static {
         ParseHttpRequest.Method[] var0 = new ParseHttpRequest.Method[]{GET, POST, PUT, DELETE};
      }

      public static ParseHttpRequest.Method fromString(String var0) {
         byte var1 = -1;
         switch(var0.hashCode()) {
         case 70454:
            if(var0.equals("GET")) {
               var1 = 0;
            }
            break;
         case 79599:
            if(var0.equals("PUT")) {
               var1 = 2;
            }
            break;
         case 2461856:
            if(var0.equals("POST")) {
               var1 = 1;
            }
            break;
         case 2012838315:
            if(var0.equals("DELETE")) {
               var1 = 3;
            }
         }

         switch(var1) {
         case 0:
            return GET;
         case 1:
            return POST;
         case 2:
            return PUT;
         case 3:
            return DELETE;
         default:
            throw new IllegalArgumentException("Invalid http method: <" + var0 + ">");
         }
      }

      public String toString() {
         switch(null.$SwitchMap$com$parse$http$ParseHttpRequest$Method[this.ordinal()]) {
         case 1:
            return "GET";
         case 2:
            return "POST";
         case 3:
            return "PUT";
         case 4:
            return "DELETE";
         default:
            throw new IllegalArgumentException("Invalid http method: <" + this + ">");
         }
      }
   }
}
