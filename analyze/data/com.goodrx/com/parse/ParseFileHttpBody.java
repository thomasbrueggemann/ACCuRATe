package com.parse;

import com.parse.ParseIOUtils;
import com.parse.http.ParseHttpBody;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class ParseFileHttpBody extends ParseHttpBody {
   final File file;

   public ParseFileHttpBody(File var1) {
      this(var1, (String)null);
   }

   public ParseFileHttpBody(File var1, String var2) {
      super(var2, var1.length());
      this.file = var1;
   }

   public InputStream getContent() throws IOException {
      return new FileInputStream(this.file);
   }

   public void writeTo(OutputStream var1) throws IOException {
      if(var1 == null) {
         throw new IllegalArgumentException("Output stream can not be null");
      } else {
         FileInputStream var2 = new FileInputStream(this.file);

         try {
            ParseIOUtils.copy(var2, var1);
         } finally {
            ParseIOUtils.closeQuietly((InputStream)var2);
         }

      }
   }
}
