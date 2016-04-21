package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.AbstractOutputStream;
import com.squareup.okhttp.internal.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ProtocolException;

final class RetryableOutputStream extends AbstractOutputStream {
    private final ByteArrayOutputStream content;
    private final int limit;

    public RetryableOutputStream() {
        this.limit = -1;
        this.content = new ByteArrayOutputStream();
    }

    public RetryableOutputStream(int var1) {
        this.limit = var1;
        this.content = new ByteArrayOutputStream(var1);
    }

    public void close() throws IOException {
        // $FF: Couldn't be decompiled
    }

    public int contentLength() throws IOException {
        synchronized(this) {}

        int var2;
        try {
            this.close();
            var2 = this.content.size();
        } finally {
            ;
        }

        return var2;
    }

    public void write(byte[] var1, int var2, int var3) throws IOException {
        synchronized(this) {}

        try {
            this.checkNotClosed();
            Util.checkOffsetAndCount(var1.length, var2, var3);
            if(this.limit != -1 && this.content.size() > this.limit - var3) {
                throw new ProtocolException("exceeded content-length limit of " + this.limit + " bytes");
            }

            this.content.write(var1, var2, var3);
        } finally {
            ;
        }

    }

    public void writeToSocket(OutputStream var1) throws IOException {
        this.content.writeTo(var1);
    }
}
