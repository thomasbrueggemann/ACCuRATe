package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.SpdyStream;
import java.io.IOException;

public interface IncomingStreamHandler {
    IncomingStreamHandler REFUSE_INCOMING_STREAMS = new IncomingStreamHandler() {
        public void receive(SpdyStream var1) throws IOException {
            var1.close(ErrorCode.REFUSED_STREAM);
        }
    };

    void receive(SpdyStream var1) throws IOException;
}
