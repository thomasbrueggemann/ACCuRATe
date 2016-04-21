package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.FrameReader;
import com.squareup.okhttp.internal.spdy.FrameWriter;
import com.squareup.okhttp.internal.spdy.HeadersMode;
import com.squareup.okhttp.internal.spdy.Hpack;
import com.squareup.okhttp.internal.spdy.Settings;
import com.squareup.okhttp.internal.spdy.Variant;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

final class Http20Draft06 implements Variant {
    private static final byte[] CONNECTION_HEADER;
    static final int FLAG_END_FLOW_CONTROL = 1;
    static final int FLAG_END_HEADERS = 4;
    static final int FLAG_END_STREAM = 1;
    static final int FLAG_PONG = 1;
    static final int FLAG_PRIORITY = 8;
    static final int TYPE_CONTINUATION = 10;
    static final int TYPE_DATA = 0;
    static final int TYPE_GOAWAY = 7;
    static final int TYPE_HEADERS = 1;
    static final int TYPE_PING = 6;
    static final int TYPE_PRIORITY = 2;
    static final int TYPE_PUSH_PROMISE = 5;
    static final int TYPE_RST_STREAM = 3;
    static final int TYPE_SETTINGS = 4;
    static final int TYPE_WINDOW_UPDATE = 9;

    static {
        try {
            CONNECTION_HEADER = "PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n".getBytes("UTF-8");
        } catch (UnsupportedEncodingException var1) {
            throw new AssertionError();
        }
    }

    public FrameReader newReader(InputStream var1, boolean var2) {
        return new Http20Draft06.Reader(var1, var2);
    }

    public FrameWriter newWriter(OutputStream var1, boolean var2) {
        return new Http20Draft06.Writer(var1, var2);
    }

    static final class Reader implements FrameReader {
        private final boolean client;
        private final Hpack.Reader hpackReader;
        // $FF: renamed from: in java.io.DataInputStream
        private final DataInputStream field_5120;

        Reader(InputStream var1, boolean var2) {
            this.field_5120 = new DataInputStream(var1);
            this.client = var2;
            this.hpackReader = new Hpack.Reader(this.field_5120, var2);
        }

        private static IOException ioException(String var0, Object... var1) throws IOException {
            throw new IOException(String.format(var0, var1));
        }

        private void readData(FrameReader.Handler var1, int var2, int var3, int var4) throws IOException {
            boolean var5;
            if((var2 & 1) != 0) {
                var5 = true;
            } else {
                var5 = false;
            }

            var1.data(var5, var4, this.field_5120, var3);
        }

        private void readGoAway(FrameReader.Handler var1, int var2, int var3, int var4) throws IOException {
            if(var3 < 8) {
                Object[] var10 = new Object[] {Integer.valueOf(var3)};
                throw ioException("TYPE_GOAWAY length < 8: %s", var10);
            } else {
                int var5 = this.field_5120.readInt();
                int var6 = this.field_5120.readInt();
                int var7 = var3 - 8;
                ErrorCode var8 = ErrorCode.fromHttp2(var6);
                if(var8 == null) {
                    Object[] var9 = new Object[] {Integer.valueOf(var6)};
                    throw ioException("TYPE_RST_STREAM unexpected error code: %d", var9);
                } else if(Util.skipByReading(this.field_5120, (long)var7) != (long)var7) {
                    throw new IOException("TYPE_GOAWAY opaque data was truncated");
                } else {
                    var1.goAway(var5, var8);
                }
            }
        }

        private void readHeaders(FrameReader.Handler var1, int var2, int var3, int var4) throws IOException {
            if(var4 == 0) {
                throw ioException("TYPE_HEADERS streamId == 0", new Object[0]);
            } else {
                boolean var5;
                if((var2 & 1) != 0) {
                    var5 = true;
                } else {
                    var5 = false;
                }

                int var9;
                do {
                    this.hpackReader.readHeaders(var3);
                    if((var2 & 4) != 0) {
                        this.hpackReader.emitReferenceSet();
                        var1.headers(false, var5, var4, -1, -1, this.hpackReader.getAndReset(), HeadersMode.HTTP_20_HEADERS);
                        return;
                    }

                    int var6 = this.field_5120.readInt();
                    int var7 = this.field_5120.readInt();
                    var3 = (-65536 & var6) >> 16;
                    int var8 = ('\uff00' & var6) >> 8;
                    var2 = var6 & 255;
                    if((var2 & 1) != 0) {
                        var5 = true;
                    } else {
                        var5 = false;
                    }

                    var9 = var7 & Integer.MAX_VALUE;
                    if(var8 != 10) {
                        throw ioException("TYPE_CONTINUATION didn\'t have FLAG_END_HEADERS", new Object[0]);
                    }
                } while(var9 == var4);

                throw ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        private void readPing(FrameReader.Handler var1, int var2, int var3, int var4) throws IOException {
            byte var5 = 1;
            if(var3 != 8) {
                Object[] var8 = new Object[var5];
                var8[0] = Integer.valueOf(var3);
                throw ioException("TYPE_PING length != 8: %s", var8);
            } else if(var4 != 0) {
                throw ioException("TYPE_PING streamId != 0", new Object[0]);
            } else {
                int var6 = this.field_5120.readInt();
                int var7 = this.field_5120.readInt();
                if((var2 & 1) == 0) {
                    var5 = 0;
                }

                var1.ping((boolean)var5, var6, var7);
            }
        }

        private void readPriority(FrameReader.Handler var1, int var2, int var3, int var4) throws IOException {
            if(var3 != 4) {
                Object[] var5 = new Object[] {Integer.valueOf(var3)};
                throw ioException("TYPE_PRIORITY length: %d != 4", var5);
            } else if(var4 == 0) {
                throw ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
            } else {
                var1.priority(var4, Integer.MAX_VALUE & this.field_5120.readInt());
            }
        }

        private void readPushPromise(FrameReader.Handler var1, int var2, int var3, int var4) {
        }

        private void readRstStream(FrameReader.Handler var1, int var2, int var3, int var4) throws IOException {
            if(var3 != 4) {
                Object[] var8 = new Object[] {Integer.valueOf(var3)};
                throw ioException("TYPE_RST_STREAM length: %d != 4", var8);
            } else if(var4 == 0) {
                throw ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
            } else {
                int var5 = this.field_5120.readInt();
                ErrorCode var6 = ErrorCode.fromHttp2(var5);
                if(var6 == null) {
                    Object[] var7 = new Object[] {Integer.valueOf(var5)};
                    throw ioException("TYPE_RST_STREAM unexpected error code: %d", var7);
                } else {
                    var1.rstStream(var4, var6);
                }
            }
        }

        private void readSettings(FrameReader.Handler var1, int var2, int var3, int var4) throws IOException {
            if(var3 % 8 != 0) {
                Object[] var9 = new Object[] {Integer.valueOf(var3)};
                throw ioException("TYPE_SETTINGS length %% 8 != 0: %s", var9);
            } else if(var4 != 0) {
                throw ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
            } else {
                Settings var5 = new Settings();

                for(int var6 = 0; var6 < var3; var6 += 8) {
                    int var7 = this.field_5120.readInt();
                    int var8 = this.field_5120.readInt();
                    var5.set(var7 & 16777215, 0, var8);
                }

                var1.settings(false, var5);
            }
        }

        private void readWindowUpdate(FrameReader.Handler var1, int var2, int var3, int var4) throws IOException {
            int var5 = Integer.MAX_VALUE & this.field_5120.readInt();
            boolean var6;
            if((var2 & 1) != 0) {
                var6 = true;
            } else {
                var6 = false;
            }

            var1.windowUpdate(var4, var5, var6);
        }

        public void close() throws IOException {
            this.field_5120.close();
        }

        public boolean nextFrame(FrameReader.Handler var1) throws IOException {
            int var3;
            try {
                var3 = this.field_5120.readInt();
            } catch (IOException var9) {
                return false;
            }

            int var4 = this.field_5120.readInt();
            int var5 = (-65536 & var3) >> 16;
            int var6 = ('\uff00' & var3) >> 8;
            int var7 = var3 & 255;
            int var8 = var4 & Integer.MAX_VALUE;
            switch(var6) {
                case 0:
                    this.readData(var1, var7, var5, var8);
                    return true;
                case 1:
                    this.readHeaders(var1, var7, var5, var8);
                    return true;
                case 2:
                    this.readPriority(var1, var7, var5, var8);
                    return true;
                case 3:
                    this.readRstStream(var1, var7, var5, var8);
                    return true;
                case 4:
                    this.readSettings(var1, var7, var5, var8);
                    return true;
                case 5:
                    this.readPushPromise(var1, var7, var5, var8);
                    return true;
                case 6:
                    this.readPing(var1, var7, var5, var8);
                    return true;
                case 7:
                    this.readGoAway(var1, var7, var5, var8);
                    return true;
                case 8:
                default:
                    throw new UnsupportedOperationException("TODO");
                case 9:
                    this.readWindowUpdate(var1, var7, var5, var8);
                    return true;
            }
        }

        public void readConnectionHeader() throws IOException {
            if(!this.client) {
                byte[] var1 = new byte[Http20Draft06.CONNECTION_HEADER.length];
                this.field_5120.readFully(var1);
                if(!Arrays.equals(var1, Http20Draft06.CONNECTION_HEADER)) {
                    throw ioException("Expected a connection header but was " + Arrays.toString(var1), new Object[0]);
                }
            }

        }
    }

    static final class Writer implements FrameWriter {
        private final boolean client;
        private final ByteArrayOutputStream hpackBuffer;
        private final Hpack.Writer hpackWriter;
        private final DataOutputStream out;

        Writer(OutputStream var1, boolean var2) {
            this.out = new DataOutputStream(var1);
            this.client = var2;
            this.hpackBuffer = new ByteArrayOutputStream();
            this.hpackWriter = new Hpack.Writer(this.hpackBuffer);
        }

        private void headers(boolean var1, int var2, int var3, List<String> var4) throws IOException {
            this.hpackBuffer.reset();
            this.hpackWriter.writeHeaders(var4);
            int var5 = this.hpackBuffer.size();
            int var6 = 4;
            if(var1) {
                var6 |= 1;
            }

            if(var3 != -1) {
                var6 |= 8;
            }

            this.out.writeInt(256 | ('\uffff' & var5) << 16 | var6 & 255);
            this.out.writeInt(var2 & Integer.MAX_VALUE);
            if(var3 != -1) {
                this.out.writeInt(var3 & Integer.MAX_VALUE);
            }

            this.hpackBuffer.writeTo(this.out);
        }

        public void close() throws IOException {
            this.out.close();
        }

        public void connectionHeader() throws IOException {
            // $FF: Couldn't be decompiled
        }

        public void data(boolean var1, int var2, byte[] var3) throws IOException {
            this.data(var1, var2, var3, 0, var3.length);
        }

        public void data(boolean var1, int var2, byte[] var3, int var4, int var5) throws IOException {
            synchronized(this) {}
            int var6 = 0;
            if(var1) {
                var6 = 0 | 1;
            }

            try {
                this.out.writeInt(0 | ('\uffff' & var5) << 16 | var6 & 255);
                this.out.writeInt(Integer.MAX_VALUE & var2);
                this.out.write(var3, var4, var5);
            } finally {
                ;
            }

        }

        public void flush() throws IOException {
            synchronized(this) {}

            try {
                this.out.flush();
            } finally {
                ;
            }

        }

        public void goAway(int var1, ErrorCode var2) throws IOException {
            synchronized(this) {}
        }

        public void headers(int var1, List<String> var2) throws IOException {
            synchronized(this) {}

            try {
                this.headers(false, var1, -1, var2);
            } finally {
                ;
            }

        }

        public void noop() throws IOException {
            synchronized(this) {}

            try {
                throw new UnsupportedOperationException();
            } finally {
                ;
            }
        }

        public void ping(boolean var1, int var2, int var3) throws IOException {
            synchronized(this) {}
        }

        public void rstStream(int var1, ErrorCode var2) throws IOException {
            synchronized(this) {}

            try {
                throw new UnsupportedOperationException("TODO");
            } finally {
                ;
            }
        }

        public void settings(Settings param1) throws IOException {
            // $FF: Couldn't be decompiled
        }

        public void synReply(boolean var1, int var2, List<String> var3) throws IOException {
            synchronized(this) {}

            try {
                this.headers(var1, var2, -1, var3);
            } finally {
                ;
            }

        }

        public void synStream(boolean param1, boolean param2, int param3, int param4, int param5, int param6, List<String> param7) throws IOException {
            // $FF: Couldn't be decompiled
        }

        public void windowUpdate(int var1, int var2) throws IOException {
            synchronized(this) {}
        }
    }
}
