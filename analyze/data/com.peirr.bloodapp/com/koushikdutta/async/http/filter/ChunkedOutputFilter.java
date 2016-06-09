package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.FilteredDataSink;
import java.nio.ByteBuffer;

public class ChunkedOutputFilter extends FilteredDataSink {
   public ChunkedOutputFilter(DataSink var1) {
      super(var1);
   }

   public ByteBufferList filter(ByteBufferList var1) {
      var1.addFirst(ByteBuffer.wrap((Integer.toString(var1.remaining(), 16) + "\r\n").getBytes()));
      var1.add(ByteBuffer.wrap("\r\n".getBytes()));
      return var1;
   }
}
