package com.parse;

import com.parse.http.ParseHttpBody;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

class ParseByteArrayHttpBody extends ParseHttpBody {
   final byte[] content;
   final InputStream contentInputStream;

   public ParseByteArrayHttpBody(String var1, String var2) throws UnsupportedEncodingException {
      this(var1.getBytes("UTF-8"), var2);
   }

   public ParseByteArrayHttpBody(byte[] var1, String var2) {
      super(var2, (long)var1.length);
      this.content = var1;
      this.contentInputStream = new ByteArrayInputStream(var1);
   }

   public InputStream getContent() {
      return this.contentInputStream;
   }

   public void writeTo(OutputStream var1) throws IOException {
      if(var1 == null) {
         throw new IllegalArgumentException("Output stream may not be null");
      } else {
         var1.write(this.content);
      }
   }
}
