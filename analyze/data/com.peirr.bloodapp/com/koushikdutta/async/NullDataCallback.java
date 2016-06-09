package com.koushikdutta.async;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.DataCallback;

public class NullDataCallback implements DataCallback {
   public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
      var2.recycle();
   }
}
