package com.koushikdutta.async;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;

public interface AsyncSocket extends DataEmitter, DataSink {
   AsyncServer getServer();
}
