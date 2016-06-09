package com.koushikdutta.async.http;

import com.koushikdutta.async.http.StreamPart;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;

public class FilePart extends StreamPart {
   File file;

   public FilePart(String var1, final File var2) {
      super(var1, (int)var2.length(), new ArrayList() {
         {
            this.add(new BasicNameValuePair("filename", var2.getName()));
         }
      });
      this.file = var2;
   }

   protected InputStream getInputStream() throws IOException {
      return new FileInputStream(this.file);
   }
}
