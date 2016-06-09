package com.koushikdutta.async;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;
import java.nio.ByteBuffer;

public interface DataSink {
   void close();

   void end();

   CompletedCallback getClosedCallback();

   AsyncServer getServer();

   WritableCallback getWriteableCallback();

   boolean isOpen();

   void setClosedCallback(CompletedCallback var1);

   void setWriteableCallback(WritableCallback var1);

   void write(ByteBufferList var1);

   void write(ByteBuffer var1);
}
