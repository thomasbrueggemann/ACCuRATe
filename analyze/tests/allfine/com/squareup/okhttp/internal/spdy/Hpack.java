package com.squareup.okhttp.internal.spdy;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

final class Hpack {
    static final List<Hpack.HeaderEntry> INITIAL_CLIENT_TO_SERVER_HEADER_TABLE;
    static final int INITIAL_CLIENT_TO_SERVER_HEADER_TABLE_LENGTH = 1262;
    static final List<Hpack.HeaderEntry> INITIAL_SERVER_TO_CLIENT_HEADER_TABLE;
    static final int INITIAL_SERVER_TO_CLIENT_HEADER_TABLE_LENGTH = 1304;
    static final int PREFIX_5_BITS = 31;
    static final int PREFIX_6_BITS = 63;
    static final int PREFIX_7_BITS = 127;
    static final int PREFIX_8_BITS = 255;

    static {
        Hpack.HeaderEntry[] var0 = new Hpack.HeaderEntry[] {new Hpack.HeaderEntry(":scheme", "http"), new Hpack.HeaderEntry(":scheme", "https"), new Hpack.HeaderEntry(":host", ""), new Hpack.HeaderEntry(":path", "/"), new Hpack.HeaderEntry(":method", "GET"), new Hpack.HeaderEntry("accept", ""), new Hpack.HeaderEntry("accept-charset", ""), new Hpack.HeaderEntry("accept-encoding", ""), new Hpack.HeaderEntry("accept-language", ""), new Hpack.HeaderEntry("cookie", ""), new Hpack.HeaderEntry("if-modified-since", ""), new Hpack.HeaderEntry("user-agent", ""), new Hpack.HeaderEntry("referer", ""), new Hpack.HeaderEntry("authorization", ""), new Hpack.HeaderEntry("allow", ""), new Hpack.HeaderEntry("cache-control", ""), new Hpack.HeaderEntry("connection", ""), new Hpack.HeaderEntry("content-length", ""), new Hpack.HeaderEntry("content-type", ""), new Hpack.HeaderEntry("date", ""), new Hpack.HeaderEntry("expect", ""), new Hpack.HeaderEntry("from", ""), new Hpack.HeaderEntry("if-match", ""), new Hpack.HeaderEntry("if-none-match", ""), new Hpack.HeaderEntry("if-range", ""), new Hpack.HeaderEntry("if-unmodified-since", ""), new Hpack.HeaderEntry("max-forwards", ""), new Hpack.HeaderEntry("proxy-authorization", ""), new Hpack.HeaderEntry("range", ""), new Hpack.HeaderEntry("via", "")};
        INITIAL_CLIENT_TO_SERVER_HEADER_TABLE = Arrays.asList(var0);
        Hpack.HeaderEntry[] var1 = new Hpack.HeaderEntry[] {new Hpack.HeaderEntry(":status", "200"), new Hpack.HeaderEntry("age", ""), new Hpack.HeaderEntry("cache-control", ""), new Hpack.HeaderEntry("content-length", ""), new Hpack.HeaderEntry("content-type", ""), new Hpack.HeaderEntry("date", ""), new Hpack.HeaderEntry("etag", ""), new Hpack.HeaderEntry("expires", ""), new Hpack.HeaderEntry("last-modified", ""), new Hpack.HeaderEntry("server", ""), new Hpack.HeaderEntry("set-cookie", ""), new Hpack.HeaderEntry("vary", ""), new Hpack.HeaderEntry("via", ""), new Hpack.HeaderEntry("access-control-allow-origin", ""), new Hpack.HeaderEntry("accept-ranges", ""), new Hpack.HeaderEntry("allow", ""), new Hpack.HeaderEntry("connection", ""), new Hpack.HeaderEntry("content-disposition", ""), new Hpack.HeaderEntry("content-encoding", ""), new Hpack.HeaderEntry("content-language", ""), new Hpack.HeaderEntry("content-location", ""), new Hpack.HeaderEntry("content-range", ""), new Hpack.HeaderEntry("link", ""), new Hpack.HeaderEntry("location", ""), new Hpack.HeaderEntry("proxy-authenticate", ""), new Hpack.HeaderEntry("refresh", ""), new Hpack.HeaderEntry("retry-after", ""), new Hpack.HeaderEntry("strict-transport-security", ""), new Hpack.HeaderEntry("transfer-encoding", ""), new Hpack.HeaderEntry("www-authenticate", "")};
        INITIAL_SERVER_TO_CLIENT_HEADER_TABLE = Arrays.asList(var1);
    }

    static class HeaderEntry {
        private final String name;
        private final String value;

        HeaderEntry(String var1, String var2) {
            this.name = var1;
            this.value = var2;
        }

        int length() {
            return 32 + this.name.length() + this.value.length();
        }
    }

    static class Reader {
        private long bufferSize = 0L;
        private long bytesLeft = 0L;
        private final List<String> emittedHeaders = new ArrayList();
        private final List<Hpack.HeaderEntry> headerTable;
        // $FF: renamed from: in java.io.DataInputStream
        private final DataInputStream field_4897;
        private final long maxBufferSize = 4096L;
        private final BitSet referenceSet = new BitSet();

        Reader(DataInputStream var1, boolean var2) {
            this.field_4897 = var1;
            if(var2) {
                this.headerTable = new ArrayList(Hpack.INITIAL_SERVER_TO_CLIENT_HEADER_TABLE);
                this.bufferSize = 1304L;
            } else {
                this.headerTable = new ArrayList(Hpack.INITIAL_CLIENT_TO_SERVER_HEADER_TABLE);
                this.bufferSize = 1262L;
            }
        }

        private String getName(int var1) {
            return ((Hpack.HeaderEntry)this.headerTable.get(var1)).name;
        }

        private String getValue(int var1) {
            return ((Hpack.HeaderEntry)this.headerTable.get(var1)).value;
        }

        private void insertIntoHeaderTable(int var1, Hpack.HeaderEntry var2) {
            int var3 = var2.length();
            if(var1 != this.headerTable.size()) {
                var3 -= ((Hpack.HeaderEntry)this.headerTable.get(var1)).length();
            }

            if((long)var3 > 4096L) {
                this.headerTable.clear();
                this.bufferSize = 0L;
                this.emittedHeaders.add(var2.name);
                this.emittedHeaders.add(var2.value);
            } else {
                while(this.bufferSize + (long)var3 > 4096L) {
                    this.remove(0);
                    --var1;
                }

                if(var1 < 0) {
                    var1 = 0;
                    this.headerTable.add(0, var2);
                } else if(var1 == this.headerTable.size()) {
                    this.headerTable.add(var1, var2);
                } else {
                    this.headerTable.set(var1, var2);
                }

                this.bufferSize += (long)var3;
                this.referenceSet.set(var1);
            }
        }

        private int readByte() throws IOException {
            --this.bytesLeft;
            return 255 & this.field_4897.readByte();
        }

        private void readIndexedHeader(int var1) {
            if(this.referenceSet.get(var1)) {
                this.referenceSet.clear(var1);
            } else {
                this.referenceSet.set(var1);
            }
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int var1) throws IOException {
            String var2 = this.getName(var1);
            String var3 = this.readString();
            this.insertIntoHeaderTable(this.headerTable.size(), new Hpack.HeaderEntry(var2, var3));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            String var1 = this.readString();
            String var2 = this.readString();
            this.insertIntoHeaderTable(this.headerTable.size(), new Hpack.HeaderEntry(var1, var2));
        }

        private void readLiteralHeaderWithSubstitutionIndexingIndexedName(int var1) throws IOException {
            this.insertIntoHeaderTable(this.readInt(this.readByte(), 255), new Hpack.HeaderEntry(this.getName(var1), this.readString()));
        }

        private void readLiteralHeaderWithSubstitutionIndexingNewName() throws IOException {
            String var1 = this.readString();
            this.insertIntoHeaderTable(this.readInt(this.readByte(), 255), new Hpack.HeaderEntry(var1, this.readString()));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int var1) throws IOException {
            String var2 = this.getName(var1);
            String var3 = this.readString();
            this.emittedHeaders.add(var2);
            this.emittedHeaders.add(var3);
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            String var1 = this.readString();
            String var2 = this.readString();
            this.emittedHeaders.add(var1);
            this.emittedHeaders.add(var2);
        }

        private void remove(int var1) {
            this.bufferSize -= (long)((Hpack.HeaderEntry)this.headerTable.remove(var1)).length();
        }

        public void emitReferenceSet() {
            for(int var1 = this.referenceSet.nextSetBit(0); var1 != -1; var1 = this.referenceSet.nextSetBit(var1 + 1)) {
                this.emittedHeaders.add(this.getName(var1));
                this.emittedHeaders.add(this.getValue(var1));
            }

        }

        public List<String> getAndReset() {
            ArrayList var1 = new ArrayList(this.emittedHeaders);
            this.emittedHeaders.clear();
            return var1;
        }

        public void readHeaders(int var1) throws IOException {
            this.bytesLeft += (long)var1;

            while(this.bytesLeft > 0L) {
                int var2 = this.readByte();
                if((var2 & 128) != 0) {
                    this.readIndexedHeader(this.readInt(var2, 127));
                } else if(var2 == 96) {
                    this.readLiteralHeaderWithoutIndexingNewName();
                } else if((var2 & 224) == 96) {
                    this.readLiteralHeaderWithoutIndexingIndexedName(-1 + this.readInt(var2, 31));
                } else if(var2 == 64) {
                    this.readLiteralHeaderWithIncrementalIndexingNewName();
                } else if((var2 & 224) == 64) {
                    this.readLiteralHeaderWithIncrementalIndexingIndexedName(-1 + this.readInt(var2, 31));
                } else if(var2 == 0) {
                    this.readLiteralHeaderWithSubstitutionIndexingNewName();
                } else {
                    if((var2 & 192) != 0) {
                        throw new AssertionError();
                    }

                    this.readLiteralHeaderWithSubstitutionIndexingIndexedName(-1 + this.readInt(var2, 63));
                }
            }

        }

        int readInt(int var1, int var2) throws IOException {
            int var3 = var1 & var2;
            if(var3 < var2) {
                return var3;
            } else {
                int var4 = var2;
                int var5 = 0;

                while(true) {
                    int var6 = this.readByte();
                    if((var6 & 128) == 0) {
                        return var4 + (var6 << var5);
                    }

                    var4 += (var6 & 127) << var5;
                    var5 += 7;
                }
            }
        }

        public String readString() throws IOException {
            int var1 = this.readInt(this.readByte(), 255);
            byte[] var2 = new byte[var1];
            this.bytesLeft -= (long)var1;
            this.field_4897.readFully(var2);
            return new String(var2, "UTF-8");
        }
    }

    static class Writer {
        private final OutputStream out;

        Writer(OutputStream var1) {
            this.out = var1;
        }

        public void writeHeaders(List<String> var1) throws IOException {
            int var2 = 0;

            for(int var3 = var1.size(); var2 < var3; var2 += 2) {
                this.out.write(96);
                this.writeString((String)var1.get(var2));
                this.writeString((String)var1.get(var2 + 1));
            }

        }

        public void writeInt(int var1, int var2, int var3) throws IOException {
            if(var1 < var2) {
                this.out.write(var3 | var1);
            } else {
                this.out.write(var3 | var2);

                int var4;
                for(var4 = var1 - var2; var4 >= 128; var4 >>>= 7) {
                    int var5 = var4 & 127;
                    this.out.write(var5 | 128);
                }

                this.out.write(var4);
            }
        }

        public void writeString(String var1) throws IOException {
            byte[] var2 = var1.getBytes("UTF-8");
            this.writeInt(var2.length, 255, 0);
            this.out.write(var2);
        }
    }
}
