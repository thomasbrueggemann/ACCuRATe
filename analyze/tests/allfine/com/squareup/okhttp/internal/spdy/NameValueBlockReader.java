package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.Spdy3;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

class NameValueBlockReader implements Closeable {
    private int compressedLimit;
    private final NameValueBlockReader.FillableInflaterInputStream fillableInflaterInputStream;
    private final DataInputStream nameValueBlockIn;

    NameValueBlockReader(final InputStream var1) {
        this.fillableInflaterInputStream = new NameValueBlockReader.FillableInflaterInputStream(new InputStream() {
            public void close() throws IOException {
                var1.close();
            }

            public int read() throws IOException {
                return Util.readSingleByte(this);
            }

            public int read(byte[] var1x, int var2, int var3) throws IOException {
                int var4 = Math.min(var3, NameValueBlockReader.this.compressedLimit);
                int var5 = var1.read(var1x, var2, var4);
                NameValueBlockReader.this.compressedLimit = NameValueBlockReader.this.compressedLimit - var5;
                return var5;
            }
        }, new Inflater() {
            public int inflate(byte[] var1, int var2, int var3) throws DataFormatException {
                int var4 = super.inflate(var1, var2, var3);
                if(var4 == 0 && this.needsDictionary()) {
                    this.setDictionary(Spdy3.DICTIONARY);
                    var4 = super.inflate(var1, var2, var3);
                }

                return var4;
            }
        });
        this.nameValueBlockIn = new DataInputStream(this.fillableInflaterInputStream);
    }

    private void doneReading() throws IOException {
        if(this.compressedLimit != 0) {
            this.fillableInflaterInputStream.fill();
            if(this.compressedLimit != 0) {
                throw new IOException("compressedLimit > 0: " + this.compressedLimit);
            }
        }

    }

    private String readString() throws DataFormatException, IOException {
        int var1 = this.nameValueBlockIn.readInt();
        byte[] var2 = new byte[var1];
        Util.readFully(this.nameValueBlockIn, var2);
        return new String(var2, 0, var1, "UTF-8");
    }

    public void close() throws IOException {
        this.nameValueBlockIn.close();
    }

    public List<String> readNameValueBlock(int param1) throws IOException {
        // $FF: Couldn't be decompiled
    }

    static class FillableInflaterInputStream extends InflaterInputStream {
        public FillableInflaterInputStream(InputStream var1, Inflater var2) {
            super(var1, var2);
        }

        public void fill() throws IOException {
            super.fill();
        }
    }
}
