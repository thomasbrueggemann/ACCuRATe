package com.koushikdutta.async;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;

public interface DataEmitter {
   void close();

   DataCallback getDataCallback();

   CompletedCallback getEndCallback();

   AsyncServer getServer();

   boolean isChunked();

   boolean isPaused();

   void pause();

   void resume();

   void setDataCallback(DataCallback var1);

   void setEndCallback(CompletedCallback var1);
}
