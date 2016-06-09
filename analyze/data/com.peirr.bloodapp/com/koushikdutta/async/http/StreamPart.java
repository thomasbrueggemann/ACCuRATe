package com.koushikdutta.async.http;

import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.http.NameValuePair;

public abstract class StreamPart extends Part {
   public StreamPart(String var1, int var2, List<NameValuePair> var3) {
      super(var1, var2, var3);
   }

   protected abstract InputStream getInputStream() throws IOException;

   public void write(DataSink var1, CompletedCallback var2) {
      try {
         Util.pump(this.getInputStream(), var1, var2);
      } catch (Exception var4) {
         var2.onCompleted(var4);
      }
   }
}
