package com.google.tagmanager.protobuf.nano;

import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNano;
import com.google.tagmanager.protobuf.nano.WireFormatNano;
import java.io.IOException;

public final class CodedInputByteBufferNano {
    private static final int DEFAULT_RECURSION_LIMIT = 64;
    private static final int DEFAULT_SIZE_LIMIT = 67108864;
    private final byte[] buffer;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int bufferStart;
    private int currentLimit = Integer.MAX_VALUE;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit = 64;
    private int sizeLimit = 67108864;

    private CodedInputByteBufferNano(byte[] var1, int var2, int var3) {
        this.buffer = var1;
        this.bufferStart = var2;
        this.bufferSize = var2 + var3;
        this.bufferPos = var2;
    }

    public static int decodeZigZag32(int var0) {
        return var0 >>> 1 ^ -(var0 & 1);
    }

    public static long decodeZigZag64(long var0) {
        return var0 >>> 1 ^ -(1L & var0);
    }

    public static CodedInputByteBufferNano newInstance(byte[] var0) {
        return newInstance(var0, 0, var0.length);
    }

    public static CodedInputByteBufferNano newInstance(byte[] var0, int var1, int var2) {
        return new CodedInputByteBufferNano(var0, var1, var2);
    }

    private void recomputeBufferSizeAfterLimit() {
        this.bufferSize += this.bufferSizeAfterLimit;
        int var1 = this.bufferSize;
        if(var1 > this.currentLimit) {
            this.bufferSizeAfterLimit = var1 - this.currentLimit;
            this.bufferSize -= this.bufferSizeAfterLimit;
        } else {
            this.bufferSizeAfterLimit = 0;
        }
    }

    public void checkLastTagWas(int var1) throws InvalidProtocolBufferNanoException {
        if(this.lastTag != var1) {
            throw InvalidProtocolBufferNanoException.invalidEndTag();
        }
    }

    public int getBytesUntilLimit() {
        if(this.currentLimit == Integer.MAX_VALUE) {
            return -1;
        } else {
            int var1 = this.bufferPos;
            return this.currentLimit - var1;
        }
    }

    public byte[] getData(int var1, int var2) {
        if(var2 == 0) {
            return WireFormatNano.EMPTY_BYTES;
        } else {
            byte[] var3 = new byte[var2];
            int var4 = var1 + this.bufferStart;
            System.arraycopy(this.buffer, var4, var3, 0, var2);
            return var3;
        }
    }

    public int getPosition() {
        return this.bufferPos - this.bufferStart;
    }

    public boolean isAtEnd() {
        return this.bufferPos == this.bufferSize;
    }

    public void popLimit(int var1) {
        this.currentLimit = var1;
        this.recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int var1) throws InvalidProtocolBufferNanoException {
        if(var1 < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        } else {
            int var2 = var1 + this.bufferPos;
            int var3 = this.currentLimit;
            if(var2 > var3) {
                throw InvalidProtocolBufferNanoException.truncatedMessage();
            } else {
                this.currentLimit = var2;
                this.recomputeBufferSizeAfterLimit();
                return var3;
            }
        }
    }

    public boolean readBool() throws IOException {
        return this.readRawVarint32() != 0;
    }

    public byte[] readBytes() throws IOException {
        int var1 = this.readRawVarint32();
        if(var1 <= this.bufferSize - this.bufferPos && var1 > 0) {
            byte[] var2 = new byte[var1];
            System.arraycopy(this.buffer, this.bufferPos, var2, 0, var1);
            this.bufferPos += var1;
            return var2;
        } else {
            return this.readRawBytes(var1);
        }
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(this.readRawLittleEndian64());
    }

    public int readEnum() throws IOException {
        return this.readRawVarint32();
    }

    public int readFixed32() throws IOException {
        return this.readRawLittleEndian32();
    }

    public long readFixed64() throws IOException {
        return this.readRawLittleEndian64();
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(this.readRawLittleEndian32());
    }

    public void readGroup(MessageNano var1, int var2) throws IOException {
        if(this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
        } else {
            ++this.recursionDepth;
            var1.mergeFrom(this);
            this.checkLastTagWas(WireFormatNano.makeTag(var2, 4));
            this.recursionDepth += -1;
        }
    }

    public int readInt32() throws IOException {
        return this.readRawVarint32();
    }

    public long readInt64() throws IOException {
        return this.readRawVarint64();
    }

    public void readMessage(MessageNano var1) throws IOException {
        int var2 = this.readRawVarint32();
        if(this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
        } else {
            int var3 = this.pushLimit(var2);
            ++this.recursionDepth;
            var1.mergeFrom(this);
            this.checkLastTagWas(0);
            this.recursionDepth += -1;
            this.popLimit(var3);
        }
    }

    public byte readRawByte() throws IOException {
        if(this.bufferPos == this.bufferSize) {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        } else {
            byte[] var1 = this.buffer;
            int var2 = this.bufferPos;
            this.bufferPos = var2 + 1;
            return var1[var2];
        }
    }

    public byte[] readRawBytes(int var1) throws IOException {
        if(var1 < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        } else if(var1 + this.bufferPos > this.currentLimit) {
            this.skipRawBytes(this.currentLimit - this.bufferPos);
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        } else if(var1 <= this.bufferSize - this.bufferPos) {
            byte[] var2 = new byte[var1];
            System.arraycopy(this.buffer, this.bufferPos, var2, 0, var1);
            this.bufferPos += var1;
            return var2;
        } else {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
    }

    public int readRawLittleEndian32() throws IOException {
        byte var1 = this.readRawByte();
        byte var2 = this.readRawByte();
        byte var3 = this.readRawByte();
        byte var4 = this.readRawByte();
        return var1 & 255 | (var2 & 255) << 8 | (var3 & 255) << 16 | (var4 & 255) << 24;
    }

    public long readRawLittleEndian64() throws IOException {
        byte var1 = this.readRawByte();
        byte var2 = this.readRawByte();
        byte var3 = this.readRawByte();
        byte var4 = this.readRawByte();
        byte var5 = this.readRawByte();
        byte var6 = this.readRawByte();
        byte var7 = this.readRawByte();
        byte var8 = this.readRawByte();
        return 255L & (long)var1 | (255L & (long)var2) << 8 | (255L & (long)var3) << 16 | (255L & (long)var4) << 24 | (255L & (long)var5) << 32 | (255L & (long)var6) << 40 | (255L & (long)var7) << 48 | (255L & (long)var8) << 56;
    }

    public int readRawVarint32() throws IOException {
        byte var1 = this.readRawByte();
        int var10;
        if(var1 >= 0) {
            var10 = var1;
        } else {
            int var2 = var1 & 127;
            byte var3 = this.readRawByte();
            if(var3 >= 0) {
                return var2 | var3 << 7;
            }

            int var4 = var2 | (var3 & 127) << 7;
            byte var5 = this.readRawByte();
            if(var5 >= 0) {
                return var4 | var5 << 14;
            }

            int var6 = var4 | (var5 & 127) << 14;
            byte var7 = this.readRawByte();
            if(var7 >= 0) {
                return var6 | var7 << 21;
            }

            int var8 = var6 | (var7 & 127) << 21;
            byte var9 = this.readRawByte();
            var10 = var8 | var9 << 28;
            if(var9 < 0) {
                int var11 = 0;

                while(true) {
                    if(var11 >= 5) {
                        throw InvalidProtocolBufferNanoException.malformedVarint();
                    }

                    if(this.readRawByte() >= 0) {
                        break;
                    }

                    ++var11;
                }
            }
        }

        return var10;
    }

    public long readRawVarint64() throws IOException {
        int var1 = 0;

        for(long var2 = 0L; var1 < 64; var1 += 7) {
            byte var4 = this.readRawByte();
            var2 |= (long)(var4 & 127) << var1;
            if((var4 & 128) == 0) {
                return var2;
            }
        }

        throw InvalidProtocolBufferNanoException.malformedVarint();
    }

    public int readSFixed32() throws IOException {
        return this.readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return this.readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(this.readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(this.readRawVarint64());
    }

    public String readString() throws IOException {
        int var1 = this.readRawVarint32();
        if(var1 <= this.bufferSize - this.bufferPos && var1 > 0) {
            String var2 = new String(this.buffer, this.bufferPos, var1, "UTF-8");
            this.bufferPos += var1;
            return var2;
        } else {
            return new String(this.readRawBytes(var1), "UTF-8");
        }
    }

    public int readTag() throws IOException {
        if(this.isAtEnd()) {
            this.lastTag = 0;
            return 0;
        } else {
            this.lastTag = this.readRawVarint32();
            if(this.lastTag == 0) {
                throw InvalidProtocolBufferNanoException.invalidTag();
            } else {
                return this.lastTag;
            }
        }
    }

    public int readUInt32() throws IOException {
        return this.readRawVarint32();
    }

    public long readUInt64() throws IOException {
        return this.readRawVarint64();
    }

    public void resetSizeCounter() {
    }

    public void rewindToPosition(int var1) {
        if(var1 > this.bufferPos - this.bufferStart) {
            throw new IllegalArgumentException("Position " + var1 + " is beyond current " + (this.bufferPos - this.bufferStart));
        } else if(var1 < 0) {
            throw new IllegalArgumentException("Bad position " + var1);
        } else {
            this.bufferPos = var1 + this.bufferStart;
        }
    }

    public int setRecursionLimit(int var1) {
        if(var1 < 0) {
            throw new IllegalArgumentException("Recursion limit cannot be negative: " + var1);
        } else {
            int var2 = this.recursionLimit;
            this.recursionLimit = var1;
            return var2;
        }
    }

    public int setSizeLimit(int var1) {
        if(var1 < 0) {
            throw new IllegalArgumentException("Size limit cannot be negative: " + var1);
        } else {
            int var2 = this.sizeLimit;
            this.sizeLimit = var1;
            return var2;
        }
    }

    public boolean skipField(int var1) throws IOException {
        switch(WireFormatNano.getTagWireType(var1)) {
            case 0:
                this.readInt32();
                return true;
            case 1:
                this.readRawLittleEndian64();
                return true;
            case 2:
                this.skipRawBytes(this.readRawVarint32());
                return true;
            case 3:
                this.skipMessage();
                this.checkLastTagWas(WireFormatNano.makeTag(WireFormatNano.getTagFieldNumber(var1), 4));
                return true;
            case 4:
                return false;
            case 5:
                this.readRawLittleEndian32();
                return true;
            default:
                throw InvalidProtocolBufferNanoException.invalidWireType();
        }
    }

    public void skipMessage() throws IOException {
        int var1;
        do {
            var1 = this.readTag();
        } while(var1 != 0 && this.skipField(var1));

    }

    public void skipRawBytes(int var1) throws IOException {
        if(var1 < 0) {
            throw InvalidProtocolBufferNanoException.negativeSize();
        } else if(var1 + this.bufferPos > this.currentLimit) {
            this.skipRawBytes(this.currentLimit - this.bufferPos);
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        } else if(var1 <= this.bufferSize - this.bufferPos) {
            this.bufferPos += var1;
        } else {
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
    }
}
