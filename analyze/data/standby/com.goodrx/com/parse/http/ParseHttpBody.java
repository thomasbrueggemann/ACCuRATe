package com.parse.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class ParseHttpBody {
   private final long contentLength;
   private final String contentType;

   public ParseHttpBody(String var1, long var2) {
      this.contentType = var1;
      this.contentLength = var2;
   }

   public abstract InputStream getContent() throws IOException;

   public long getContentLength() {
      return this.contentLength;
   }

   public String getContentType() {
      return this.contentType;
   }

   public abstract void writeTo(OutputStream var1) throws IOException;
}
