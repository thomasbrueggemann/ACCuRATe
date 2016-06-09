package com.koushikdutta.async.wrapper;

import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.wrapper.DataEmitterWrapper;

public interface AsyncSocketWrapper extends AsyncSocket, DataEmitterWrapper {
   AsyncSocket getSocket();
}
