package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.FrameReader;
import com.squareup.okhttp.internal.spdy.FrameWriter;
import com.squareup.okhttp.internal.spdy.HeadersMode;
import com.squareup.okhttp.internal.spdy.NameValueBlockReader;
import com.squareup.okhttp.internal.spdy.Settings;
import com.squareup.okhttp.internal.spdy.Variant;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Deflater;

final class Spdy3 implements Variant {
    static final byte[] DICTIONARY;
    static final int FLAG_FIN = 1;
    static final int FLAG_UNIDIRECTIONAL = 2;
    static final int TYPE_CREDENTIAL = 16;
    static final int TYPE_DATA = 0;
    static final int TYPE_GOAWAY = 7;
    static final int TYPE_HEADERS = 8;
    static final int TYPE_NOOP = 5;
    static final int TYPE_PING = 6;
    static final int TYPE_RST_STREAM = 3;
    static final int TYPE_SETTINGS = 4;
    static final int TYPE_SYN_REPLY = 2;
    static final int TYPE_SYN_STREAM = 1;
    static final int TYPE_WINDOW_UPDATE = 9;
    static final int VERSION = 3;

    static {
        try {
            DICTIONARY = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Util.UTF_8.name());
        } catch (UnsupportedEncodingException var1) {
            throw new AssertionError();
        }
    }

    public FrameReader newReader(InputStream var1, boolean var2) {
        return new Spdy3.Reader(var1, var2);
    }

    public FrameWriter newWriter(OutputStream var1, boolean var2) {
        return new Spdy3.Writer(var1, var2);
    }

    static final class Reader implements FrameReader {
        private final boolean client;
        // $FF: renamed from: in java.io.DataInputStream
        private final DataInputStream field_4484;
        private final NameValueBlockReader nameValueBlockReader;

        Reader(InputStream var1, boolean var2) {
            this.field_4484 = new DataInputStream(var1);
            this.nameValueBlockReader = new NameValueBlockReader(var1);
            this.client = var2;
        }

        private static IOException ioException(String var0, Object... var1) throws IOException {
            throw new IOException(String.format(var0, var1));
        }

        private void readGoAway(FrameReader.Handler var1, int var2, int var3) throws IOException {
            if(var3 != 8) {
                Object[] var8 = new Object[] {Integer.valueOf(var3)};
                throw ioException("TYPE_GOAWAY length: %d != 8", var8);
            } else {
                int var4 = Integer.MAX_VALUE & this.field_4484.readInt();
                int var5 = this.field_4484.readInt();
                ErrorCode var6 = ErrorCode.fromSpdyGoAway(var5);
                if(var6 == null) {
                    Object[] var7 = new Object[] {Integer.valueOf(var5)};
                    throw ioException("TYPE_GOAWAY unexpected error code: %d", var7);
                } else {
                    var1.goAway(var4, var6);
                }
            }
        }

        private void readHeaders(FrameReader.Handler var1, int var2, int var3) throws IOException {
            var1.headers(false, false, Integer.MAX_VALUE & this.field_4484.readInt(), -1, -1, this.nameValueBlockReader.readNameValueBlock(var3 - 4), HeadersMode.SPDY_HEADERS);
        }

        private void readPing(FrameReader.Handler var1, int var2, int var3) throws IOException {
            byte var4 = 1;
            if(var3 != 4) {
                Object[] var8 = new Object[var4];
                var8[0] = Integer.valueOf(var3);
                throw ioException("TYPE_PING length: %d != 4", var8);
            } else {
                int var5 = this.field_4484.readInt();
                byte var6 = this.client;
                byte var7;
                if(var5 % 2 == var4) {
                    var7 = var4;
                } else {
                    var7 = 0;
                }

                if(var6 != var7) {
                    var4 = 0;
                }

                var1.ping((boolean)var4, var5, 0);
            }
        }

        private void readRstStream(FrameReader.Handler var1, int var2, int var3) throws IOException {
            if(var3 != 8) {
                Object[] var8 = new Object[] {Integer.valueOf(var3)};
                throw ioException("TYPE_RST_STREAM length: %d != 8", var8);
            } else {
                int var4 = Integer.MAX_VALUE & this.field_4484.readInt();
                int var5 = this.field_4484.readInt();
                ErrorCode var6 = ErrorCode.fromSpdy3Rst(var5);
                if(var6 == null) {
                    Object[] var7 = new Object[] {Integer.valueOf(var5)};
                    throw ioException("TYPE_RST_STREAM unexpected error code: %d", var7);
                } else {
                    var1.rstStream(var4, var6);
                }
            }
        }

        private void readSettings(FrameReader.Handler var1, int var2, int var3) throws IOException {
            byte var4 = 1;
            int var5 = this.field_4484.readInt();
            if(var3 != 4 + var5 * 8) {
                Object[] var11 = new Object[] {Integer.valueOf(var3), null};
                var11[var4] = Integer.valueOf(var5);
                throw ioException("TYPE_SETTINGS length: %d != 4 + 8 * %d", var11);
            } else {
                Settings var6 = new Settings();

                for(int var7 = 0; var7 < var5; ++var7) {
                    int var8 = this.field_4484.readInt();
                    int var9 = this.field_4484.readInt();
                    int var10 = (-16777216 & var8) >>> 24;
                    var6.set(var8 & 16777215, var10, var9);
                }

                if((var2 & 1) == 0) {
                    var4 = 0;
                }

                var1.settings((boolean)var4, var6);
            }
        }

        private void readSynReply(FrameReader.Handler var1, int var2, int var3) throws IOException {
            int var4 = Integer.MAX_VALUE & this.field_4484.readInt();
            List var5 = this.nameValueBlockReader.readNameValueBlock(var3 - 4);
            boolean var6;
            if((var2 & 1) != 0) {
                var6 = true;
            } else {
                var6 = false;
            }

            var1.headers(false, var6, var4, -1, -1, var5, HeadersMode.SPDY_REPLY);
        }

        private void readSynStream(FrameReader.Handler var1, int var2, int var3) throws IOException {
            int var4 = this.field_4484.readInt();
            int var5 = this.field_4484.readInt();
            short var6 = this.field_4484.readShort();
            int var7 = var4 & Integer.MAX_VALUE;
            int var8 = var5 & Integer.MAX_VALUE;
            int var9 = ('\ue000' & var6) >>> 13;
            int var10000 = var6 & 255;
            List var11 = this.nameValueBlockReader.readNameValueBlock(var3 - 10);
            boolean var12;
            if((var2 & 1) != 0) {
                var12 = true;
            } else {
                var12 = false;
            }

            boolean var13;
            if((var2 & 2) != 0) {
                var13 = true;
            } else {
                var13 = false;
            }

            var1.headers(var13, var12, var7, var8, var9, var11, HeadersMode.SPDY_SYN_STREAM);
        }

        private void readWindowUpdate(FrameReader.Handler var1, int var2, int var3) throws IOException {
            if(var3 != 8) {
                Object[] var6 = new Object[] {Integer.valueOf(var3)};
                throw ioException("TYPE_WINDOW_UPDATE length: %d != 8", var6);
            } else {
                int var4 = this.field_4484.readInt();
                int var5 = this.field_4484.readInt();
                var1.windowUpdate(var4 & Integer.MAX_VALUE, var5 & Integer.MAX_VALUE, false);
            }
        }

        public void close() throws IOException {
            Util.closeAll(this.field_4484, this.nameValueBlockReader);
        }

        public boolean nextFrame(FrameReader.Handler var1) throws IOException {
            int var3;
            try {
                var3 = this.field_4484.readInt();
            } catch (IOException var16) {
                return false;
            }

            int var4 = this.field_4484.readInt();
            boolean var5;
            if((Integer.MIN_VALUE & var3) != 0) {
                var5 = true;
            } else {
                var5 = false;
            }

            int var6 = (-16777216 & var4) >>> 24;
            int var7 = var4 & 16777215;
            if(var5) {
                int var11 = (2147418112 & var3) >>> 16;
                int var12 = var3 & '\uffff';
                if(var11 != 3) {
                    throw new ProtocolException("version != 3: " + var11);
                } else {
                    switch(var12) {
                        case 1:
                            this.readSynStream(var1, var6, var7);
                            return true;
                        case 2:
                            this.readSynReply(var1, var6, var7);
                            return true;
                        case 3:
                            this.readRstStream(var1, var6, var7);
                            return true;
                        case 4:
                            this.readSettings(var1, var6, var7);
                            return true;
                        case 5:
                            if(var7 != 0) {
                                Object[] var15 = new Object[] {Integer.valueOf(var7)};
                                throw ioException("TYPE_NOOP length: %d != 0", var15);
                            }

                            var1.noop();
                            return true;
                        case 6:
                            this.readPing(var1, var6, var7);
                            return true;
                        case 7:
                            this.readGoAway(var1, var6, var7);
                            return true;
                        case 8:
                            this.readHeaders(var1, var6, var7);
                            return true;
                        case 9:
                            this.readWindowUpdate(var1, var6, var7);
                            return true;
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        default:
                            throw new IOException("Unexpected frame");
                        case 16:
                            Util.skipByReading(this.field_4484, (long)var7);
                            throw new UnsupportedOperationException("TODO");
                    }
                }
            } else {
                int var8 = var3 & Integer.MAX_VALUE;
                int var9 = var6 & 1;
                boolean var10 = false;
                if(var9 != 0) {
                    var10 = true;
                }

                var1.data(var10, var8, this.field_4484, var7);
                return true;
            }
        }

        public void readConnectionHeader() {
        }
    }

    static final class Writer implements FrameWriter {
        private final boolean client;
        private final ByteArrayOutputStream nameValueBlockBuffer;
        private final DataOutputStream nameValueBlockOut;
        private final DataOutputStream out;

        Writer(OutputStream var1, boolean var2) {
            this.out = new DataOutputStream(var1);
            this.client = var2;
            Deflater var3 = new Deflater();
            var3.setDictionary(Spdy3.DICTIONARY);
            this.nameValueBlockBuffer = new ByteArrayOutputStream();
            this.nameValueBlockOut = new DataOutputStream(Platform.get().newDeflaterOutputStream(this.nameValueBlockBuffer, var3, true));
        }

        private void writeNameValueBlockToBuffer(List<String> var1) throws IOException {
            this.nameValueBlockBuffer.reset();
            int var2 = var1.size() / 2;
            this.nameValueBlockOut.writeInt(var2);
            Iterator var3 = var1.iterator();

            while(var3.hasNext()) {
                String var4 = (String)var3.next();
                this.nameValueBlockOut.writeInt(var4.length());
                this.nameValueBlockOut.write(var4.getBytes("UTF-8"));
            }

            this.nameValueBlockOut.flush();
        }

        public void close() throws IOException {
            Util.closeAll(this.out, this.nameValueBlockOut);
        }

        public void connectionHeader() {
            synchronized(this) {}
        }

        public void data(boolean var1, int var2, byte[] var3) throws IOException {
            synchronized(this) {}

            try {
                this.data(var1, var2, var3, 0, var3.length);
            } finally {
                ;
            }

        }

        public void data(boolean var1, int var2, byte[] var3, int var4, int var5) throws IOException {
            synchronized(this) {}
            byte var6;
            if(var1) {
                var6 = 1;
            } else {
                var6 = 0;
            }

            try {
                this.out.writeInt(Integer.MAX_VALUE & var2);
                this.out.writeInt((var6 & 255) << 24 | 16777215 & var5);
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

            try {
                if(var2.spdyGoAwayCode == -1) {
                    throw new IllegalArgumentException();
                }

                this.out.writeInt(-2147287033);
                this.out.writeInt(8);
                this.out.writeInt(var1);
                this.out.writeInt(var2.spdyGoAwayCode);
                this.out.flush();
            } finally {
                ;
            }

        }

        public void headers(int var1, List<String> var2) throws IOException {
            synchronized(this) {}

            try {
                this.writeNameValueBlockToBuffer(var2);
                int var4 = 4 + this.nameValueBlockBuffer.size();
                this.out.writeInt(-2147287032);
                this.out.writeInt(0 | 16777215 & var4);
                this.out.writeInt(Integer.MAX_VALUE & var1);
                this.nameValueBlockBuffer.writeTo(this.out);
                this.out.flush();
            } finally {
                ;
            }

        }

        public void noop() throws IOException {
            synchronized(this) {}

            try {
                this.out.writeInt(-2147287035);
                this.out.writeInt(0);
                this.out.flush();
            } finally {
                ;
            }

        }

        public void ping(boolean param1, int param2, int param3) throws IOException {
            // $FF: Couldn't be decompiled
        }

        public void rstStream(int var1, ErrorCode var2) throws IOException {
            synchronized(this) {}

            try {
                if(var2.spdyRstCode == -1) {
                    throw new IllegalArgumentException();
                }

                this.out.writeInt(-2147287037);
                this.out.writeInt(8);
                this.out.writeInt(Integer.MAX_VALUE & var1);
                this.out.writeInt(var2.spdyRstCode);
                this.out.flush();
            } finally {
                ;
            }

        }

        public void settings(Settings param1) throws IOException {
            // $FF: Couldn't be decompiled
        }

        public void synReply(boolean param1, int param2, List<String> param3) throws IOException {
            // $FF: Couldn't be decompiled
        }

        public void synStream(boolean param1, boolean param2, int param3, int param4, int param5, int param6, List<String> param7) throws IOException {
            // $FF: Couldn't be decompiled
        }

        public void windowUpdate(int var1, int var2) throws IOException {
            synchronized(this) {}

            try {
                this.out.writeInt(-2147287031);
                this.out.writeInt(8);
                this.out.writeInt(var1);
                this.out.writeInt(var2);
                this.out.flush();
            } finally {
                ;
            }

        }
    }
}
