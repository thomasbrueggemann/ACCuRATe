package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.HeadersMode;
import com.squareup.okhttp.internal.spdy.Settings;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public final class SpdyStream {
    // $FF: synthetic field
    static final boolean $assertionsDisabled = false;
    public static final int WINDOW_UPDATE_THRESHOLD = 32768;
    private final SpdyConnection connection;
    private ErrorCode errorCode = null;
    // $FF: renamed from: id int
    private final int field_4498;
    // $FF: renamed from: in com.squareup.okhttp.internal.spdy.SpdyStream$SpdyDataInputStream
    private final SpdyStream.SpdyDataInputStream field_4499 = new SpdyStream.SpdyDataInputStream();
    private final SpdyStream.SpdyDataOutputStream out = new SpdyStream.SpdyDataOutputStream();
    private final int priority;
    private long readTimeoutMillis = 0L;
    private final List<String> requestHeaders;
    private List<String> responseHeaders;
    private int writeWindowSize;

    static {
        boolean var0;
        if(!SpdyStream.class.desiredAssertionStatus()) {
            var0 = true;
        } else {
            var0 = false;
        }

        $assertionsDisabled = var0;
    }

    SpdyStream(int var1, SpdyConnection var2, boolean var3, boolean var4, int var5, List<String> var6, Settings var7) {
        if(var2 == null) {
            throw new NullPointerException("connection == null");
        } else if(var6 == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.field_4498 = var1;
            this.connection = var2;
            this.field_4499.finished = var4;
            this.out.finished = var3;
            this.priority = var5;
            this.requestHeaders = var6;
            this.setSettings(var7);
        }
    }

    // $FF: synthetic method
    static void access$1100(SpdyStream var0) throws IOException {
        var0.cancelStreamIfNecessary();
    }

    // $FF: synthetic method
    static SpdyStream.SpdyDataOutputStream access$1200(SpdyStream var0) {
        return var0.out;
    }

    // $FF: synthetic method
    static int access$1300(SpdyStream var0) {
        return var0.writeWindowSize;
    }

    // $FF: synthetic method
    static int access$700(SpdyStream var0) {
        return var0.field_4498;
    }

    // $FF: synthetic method
    static long access$900(SpdyStream var0) {
        return var0.readTimeoutMillis;
    }

    private void cancelStreamIfNecessary() throws IOException {
        // $FF: Couldn't be decompiled
    }

    private boolean closeInternal(ErrorCode param1) {
        // $FF: Couldn't be decompiled
    }

    private void setSettings(Settings var1) {
        int var2 = 65536;
        if(!$assertionsDisabled && !Thread.holdsLock(this.connection)) {
            throw new AssertionError();
        } else {
            if(var1 != null) {
                var2 = var1.getInitialWindowSize(var2);
            }

            this.writeWindowSize = var2;
        }
    }

    public void close(ErrorCode var1) throws IOException {
        if(this.closeInternal(var1)) {
            this.connection.writeSynReset(this.field_4498, var1);
        }
    }

    public void closeLater(ErrorCode var1) {
        if(this.closeInternal(var1)) {
            this.connection.writeSynResetLater(this.field_4498, var1);
        }
    }

    public SpdyConnection getConnection() {
        return this.connection;
    }

    public ErrorCode getErrorCode() {
        synchronized(this) {}

        ErrorCode var2;
        try {
            var2 = this.errorCode;
        } finally {
            ;
        }

        return var2;
    }

    public InputStream getInputStream() {
        return this.field_4499;
    }

    public OutputStream getOutputStream() {
        // $FF: Couldn't be decompiled
    }

    int getPriority() {
        return this.priority;
    }

    public long getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public List<String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public List<String> getResponseHeaders() throws IOException {
        // $FF: Couldn't be decompiled
    }

    public boolean isLocallyInitiated() {
        boolean var1;
        if(this.field_4498 % 2 == 1) {
            var1 = true;
        } else {
            var1 = false;
        }

        return this.connection.client == var1;
    }

    public boolean isOpen() {
        // $FF: Couldn't be decompiled
    }

    void receiveData(InputStream var1, int var2) throws IOException {
        if(!$assertionsDisabled && Thread.holdsLock(this)) {
            throw new AssertionError();
        } else {
            this.field_4499.receive(var1, var2);
        }
    }

    void receiveFin() {
        // $FF: Couldn't be decompiled
    }

    void receiveHeaders(List<String> param1, HeadersMode param2) {
        // $FF: Couldn't be decompiled
    }

    void receiveRstStream(ErrorCode var1) {
        synchronized(this) {}

        try {
            if(this.errorCode == null) {
                this.errorCode = var1;
                this.notifyAll();
            }
        } finally {
            ;
        }

    }

    void receiveSettings(Settings var1) {
        if(!$assertionsDisabled && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else {
            this.setSettings(var1);
            this.notifyAll();
        }
    }

    void receiveWindowUpdate(int var1) {
        synchronized(this) {}

        try {
            SpdyStream.SpdyDataOutputStream var3 = this.out;
            var3.unacknowledgedBytes = var3.unacknowledgedBytes - var1;
            this.notifyAll();
        } finally {
            ;
        }

    }

    public void reply(List<String> param1, boolean param2) throws IOException {
        // $FF: Couldn't be decompiled
    }

    public void setReadTimeout(long var1) {
        this.readTimeoutMillis = var1;
    }

    private final class SpdyDataInputStream extends InputStream {
        // $FF: synthetic field
        static final boolean $assertionsDisabled;
        private final byte[] buffer;
        private boolean closed;
        private boolean finished;
        private int limit;
        private int pos;
        private int unacknowledgedBytes;

        static {
            boolean var0;
            if(!SpdyStream.class.desiredAssertionStatus()) {
                var0 = true;
            } else {
                var0 = false;
            }

            $assertionsDisabled = var0;
        }

        private SpdyDataInputStream() {
            this.buffer = new byte[65536];
            this.pos = -1;
            this.unacknowledgedBytes = 0;
        }

        // $FF: synthetic method
        SpdyDataInputStream(Object var2) {
            this();
        }

        // $FF: synthetic method
        static boolean access$200(SpdyStream.SpdyDataInputStream var0) {
            return var0.finished;
        }

        // $FF: synthetic method
        static boolean access$400(SpdyStream.SpdyDataInputStream var0) {
            return var0.closed;
        }

        private void checkNotClosed() throws IOException {
            if(this.closed) {
                throw new IOException("stream closed");
            } else if(SpdyStream.this.errorCode != null) {
                throw new IOException("stream was reset: " + SpdyStream.this.errorCode);
            }
        }

        private void waitUntilReadable() throws IOException {
            // $FF: Couldn't be decompiled
        }

        public int available() throws IOException {
            // $FF: Couldn't be decompiled
        }

        public void close() throws IOException {
            // $FF: Couldn't be decompiled
        }

        public int read() throws IOException {
            return Util.readSingleByte(this);
        }

        public int read(byte[] param1, int param2, int param3) throws IOException {
            // $FF: Couldn't be decompiled
        }

        void receive(InputStream param1, int param2) throws IOException {
            // $FF: Couldn't be decompiled
        }
    }

    private final class SpdyDataOutputStream extends OutputStream {
        // $FF: synthetic field
        static final boolean $assertionsDisabled;
        private final byte[] buffer;
        private boolean closed;
        private boolean finished;
        private int pos;
        private int unacknowledgedBytes;

        static {
            boolean var0;
            if(!SpdyStream.class.desiredAssertionStatus()) {
                var0 = true;
            } else {
                var0 = false;
            }

            $assertionsDisabled = var0;
        }

        private SpdyDataOutputStream() {
            this.buffer = new byte[8192];
            this.pos = 0;
            this.unacknowledgedBytes = 0;
        }

        // $FF: synthetic method
        SpdyDataOutputStream(Object var2) {
            this();
        }

        // $FF: synthetic method
        static boolean access$300(SpdyStream.SpdyDataOutputStream var0) {
            return var0.finished;
        }

        // $FF: synthetic method
        static boolean access$500(SpdyStream.SpdyDataOutputStream var0) {
            return var0.closed;
        }

        private void checkNotClosed() throws IOException {
            // $FF: Couldn't be decompiled
        }

        private void waitUntilWritable(int param1, boolean param2) throws IOException {
            // $FF: Couldn't be decompiled
        }

        private void writeFrame(boolean param1) throws IOException {
            // $FF: Couldn't be decompiled
        }

        public void close() throws IOException {
            // $FF: Couldn't be decompiled
        }

        public void flush() throws IOException {
            if(!$assertionsDisabled && Thread.holdsLock(SpdyStream.this)) {
                throw new AssertionError();
            } else {
                this.checkNotClosed();
                if(this.pos > 0) {
                    this.writeFrame(false);
                    SpdyStream.this.connection.flush();
                }

            }
        }

        public void write(int var1) throws IOException {
            Util.writeSingleByte(this, var1);
        }

        public void write(byte[] var1, int var2, int var3) throws IOException {
            if(!$assertionsDisabled && Thread.holdsLock(SpdyStream.this)) {
                throw new AssertionError();
            } else {
                Util.checkOffsetAndCount(var1.length, var2, var3);
                this.checkNotClosed();

                while(var3 > 0) {
                    if(this.pos == this.buffer.length) {
                        this.writeFrame(false);
                    }

                    int var4 = Math.min(var3, this.buffer.length - this.pos);
                    System.arraycopy(var1, var2, this.buffer, this.pos, var4);
                    this.pos += var4;
                    var2 += var4;
                    var3 -= var4;
                }

            }
        }
    }
}
