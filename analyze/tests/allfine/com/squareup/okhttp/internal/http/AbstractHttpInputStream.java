package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;

abstract class AbstractHttpInputStream extends InputStream {
    private final OutputStream cacheBody;
    private final CacheRequest cacheRequest;
    protected boolean closed;
    protected final HttpEngine httpEngine;
    // $FF: renamed from: in java.io.InputStream
    protected final InputStream field_3930;

    AbstractHttpInputStream(InputStream var1, HttpEngine var2, CacheRequest var3) throws IOException {
        this.field_3930 = var1;
        this.httpEngine = var2;
        OutputStream var4;
        if(var3 != null) {
            var4 = var3.getBody();
        } else {
            var4 = null;
        }

        if(var4 == null) {
            var3 = null;
        }

        this.cacheBody = var4;
        this.cacheRequest = var3;
    }

    protected final void cacheWrite(byte[] var1, int var2, int var3) throws IOException {
        if(this.cacheBody != null) {
            this.cacheBody.write(var1, var2, var3);
        }

    }

    protected final void checkNotClosed() throws IOException {
        if(this.closed) {
            throw new IOException("stream closed");
        }
    }

    protected final void endOfInput() throws IOException {
        if(this.cacheRequest != null) {
            this.cacheBody.close();
        }

        this.httpEngine.release(false);
    }

    public final int read() throws IOException {
        return Util.readSingleByte(this);
    }

    protected final void unexpectedEndOfInput() {
        if(this.cacheRequest != null) {
            this.cacheRequest.abort();
        }

        this.httpEngine.release(true);
    }
}
