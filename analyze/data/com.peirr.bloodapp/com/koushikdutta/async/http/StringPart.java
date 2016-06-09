package com.koushikdutta.async.http;

import com.koushikdutta.async.http.StreamPart;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StringPart extends StreamPart {
   String value;

   public StringPart(String var1, String var2) {
      super(var1, var2.getBytes().length, (List)null);
      this.value = var2;
   }

   protected InputStream getInputStream() throws IOException {
      return new ByteArrayInputStream(this.value.getBytes());
   }
}
