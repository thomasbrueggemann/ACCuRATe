package com.koushikdutta.async;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.FilteredDataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDataSink extends FilteredDataSink {
   ByteArrayOutputStream bout = new ByteArrayOutputStream();
   boolean first;
   ZipOutputStream zop;

   public ZipDataSink(DataSink var1) {
      super(var1);
      this.zop = new ZipOutputStream(this.bout);
      this.first = true;
   }

   public void close() {
      try {
         this.zop.close();
      } catch (IOException var2) {
         this.report(var2);
         return;
      }

      this.setMaxBuffer(Integer.MAX_VALUE);
      this.write(new ByteBufferList());
      super.close();
   }

   public void closeEntry() throws IOException {
      this.zop.closeEntry();
   }

   public ByteBufferList filter(ByteBufferList param1) {
      // $FF: Couldn't be decompiled
   }

   public void putNextEntry(ZipEntry var1) throws IOException {
      this.zop.putNextEntry(var1);
   }

   protected void report(Exception var1) {
      CompletedCallback var2 = this.getClosedCallback();
      if(var2 != null) {
         var2.onCompleted(var1);
      }

   }
}
