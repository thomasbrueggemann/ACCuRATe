package com.google.tagmanager.protobuf.nano;

import com.google.tagmanager.protobuf.nano.MessageNano;
import com.google.tagmanager.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class CodedOutputByteBufferNano {
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    public static final int LITTLE_ENDIAN_64_SIZE = 8;
    private final byte[] buffer;
    private final int limit;
    private int position;

    private CodedOutputByteBufferNano(byte[] var1, int var2, int var3) {
        this.buffer = var1;
        this.position = var2;
        this.limit = var2 + var3;
    }

    public static int computeBoolSize(int var0, boolean var1) {
        return computeTagSize(var0) + computeBoolSizeNoTag(var1);
    }

    public static int computeBoolSizeNoTag(boolean var0) {
        return 1;
    }

    public static int computeByteArraySize(int var0, byte[] var1) {
        return computeTagSize(var0) + computeByteArraySizeNoTag(var1);
    }

    public static int computeByteArraySizeNoTag(byte[] var0) {
        return computeRawVarint32Size(var0.length) + var0.length;
    }

    public static int computeBytesSize(int var0, byte[] var1) {
        return computeTagSize(var0) + computeBytesSizeNoTag(var1);
    }

    public static int computeBytesSizeNoTag(byte[] var0) {
        return computeRawVarint32Size(var0.length) + var0.length;
    }

    public static int computeDoubleSize(int var0, double var1) {
        return computeTagSize(var0) + computeDoubleSizeNoTag(var1);
    }

    public static int computeDoubleSizeNoTag(double var0) {
        return 8;
    }

    public static int computeEnumSize(int var0, int var1) {
        return computeTagSize(var0) + computeEnumSizeNoTag(var1);
    }

    public static int computeEnumSizeNoTag(int var0) {
        return computeRawVarint32Size(var0);
    }

    public static int computeFixed32Size(int var0, int var1) {
        return computeTagSize(var0) + computeFixed32SizeNoTag(var1);
    }

    public static int computeFixed32SizeNoTag(int var0) {
        return 4;
    }

    public static int computeFixed64Size(int var0, long var1) {
        return computeTagSize(var0) + computeFixed64SizeNoTag(var1);
    }

    public static int computeFixed64SizeNoTag(long var0) {
        return 8;
    }

    public static int computeFloatSize(int var0, float var1) {
        return computeTagSize(var0) + computeFloatSizeNoTag(var1);
    }

    public static int computeFloatSizeNoTag(float var0) {
        return 4;
    }

    public static int computeGroupSize(int var0, MessageNano var1) {
        return 2 * computeTagSize(var0) + computeGroupSizeNoTag(var1);
    }

    public static int computeGroupSizeNoTag(MessageNano var0) {
        return var0.getSerializedSize();
    }

    public static int computeInt32Size(int var0, int var1) {
        return computeTagSize(var0) + computeInt32SizeNoTag(var1);
    }

    public static int computeInt32SizeNoTag(int var0) {
        return var0 >= 0?computeRawVarint32Size(var0):10;
    }

    public static int computeInt64Size(int var0, long var1) {
        return computeTagSize(var0) + computeInt64SizeNoTag(var1);
    }

    public static int computeInt64SizeNoTag(long var0) {
        return computeRawVarint64Size(var0);
    }

    public static int computeMessageSize(int var0, MessageNano var1) {
        return computeTagSize(var0) + computeMessageSizeNoTag(var1);
    }

    public static int computeMessageSizeNoTag(MessageNano var0) {
        int var1 = var0.getSerializedSize();
        return var1 + computeRawVarint32Size(var1);
    }

    public static int computeRawVarint32Size(int var0) {
        return (var0 & -128) == 0?1:((var0 & -16384) == 0?2:((-2097152 & var0) == 0?3:((-268435456 & var0) == 0?4:5)));
    }

    public static int computeRawVarint64Size(long var0) {
        return (-128L & var0) == 0L?1:((-16384L & var0) == 0L?2:((-2097152L & var0) == 0L?3:((-268435456L & var0) == 0L?4:((-34359738368L & var0) == 0L?5:((-4398046511104L & var0) == 0L?6:((-562949953421312L & var0) == 0L?7:((-72057594037927936L & var0) == 0L?8:((Long.MIN_VALUE & var0) == 0L?9:10))))))));
    }

    public static int computeSFixed32Size(int var0, int var1) {
        return computeTagSize(var0) + computeSFixed32SizeNoTag(var1);
    }

    public static int computeSFixed32SizeNoTag(int var0) {
        return 4;
    }

    public static int computeSFixed64Size(int var0, long var1) {
        return computeTagSize(var0) + computeSFixed64SizeNoTag(var1);
    }

    public static int computeSFixed64SizeNoTag(long var0) {
        return 8;
    }

    public static int computeSInt32Size(int var0, int var1) {
        return computeTagSize(var0) + computeSInt32SizeNoTag(var1);
    }

    public static int computeSInt32SizeNoTag(int var0) {
        return computeRawVarint32Size(encodeZigZag32(var0));
    }

    public static int computeSInt64Size(int var0, long var1) {
        return computeTagSize(var0) + computeSInt64SizeNoTag(var1);
    }

    public static int computeSInt64SizeNoTag(long var0) {
        return computeRawVarint64Size(encodeZigZag64(var0));
    }

    public static int computeStringSize(int var0, String var1) {
        return computeTagSize(var0) + computeStringSizeNoTag(var1);
    }

    public static int computeStringSizeNoTag(String var0) {
        int var3;
        int var4;
        try {
            byte[] var2 = var0.getBytes("UTF-8");
            var3 = computeRawVarint32Size(var2.length);
            var4 = var2.length;
        } catch (UnsupportedEncodingException var5) {
            throw new RuntimeException("UTF-8 not supported.");
        }

        return var3 + var4;
    }

    public static int computeTagSize(int var0) {
        return computeRawVarint32Size(WireFormatNano.makeTag(var0, 0));
    }

    public static int computeUInt32Size(int var0, int var1) {
        return computeTagSize(var0) + computeUInt32SizeNoTag(var1);
    }

    public static int computeUInt32SizeNoTag(int var0) {
        return computeRawVarint32Size(var0);
    }

    public static int computeUInt64Size(int var0, long var1) {
        return computeTagSize(var0) + computeUInt64SizeNoTag(var1);
    }

    public static int computeUInt64SizeNoTag(long var0) {
        return computeRawVarint64Size(var0);
    }

    public static int encodeZigZag32(int var0) {
        return var0 << 1 ^ var0 >> 31;
    }

    public static long encodeZigZag64(long var0) {
        return var0 << 1 ^ var0 >> 63;
    }

    public static CodedOutputByteBufferNano newInstance(byte[] var0) {
        return newInstance(var0, 0, var0.length);
    }

    public static CodedOutputByteBufferNano newInstance(byte[] var0, int var1, int var2) {
        return new CodedOutputByteBufferNano(var0, var1, var2);
    }

    public void checkNoSpaceLeft() {
        if(this.spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public int spaceLeft() {
        return this.limit - this.position;
    }

    public void writeBool(int var1, boolean var2) throws IOException {
        this.writeTag(var1, 0);
        this.writeBoolNoTag(var2);
    }

    public void writeBoolNoTag(boolean var1) throws IOException {
        byte var2;
        if(var1) {
            var2 = 1;
        } else {
            var2 = 0;
        }

        this.writeRawByte((int)var2);
    }

    public void writeByteArray(int var1, byte[] var2) throws IOException {
        this.writeTag(var1, 2);
        this.writeByteArrayNoTag(var2);
    }

    public void writeByteArrayNoTag(byte[] var1) throws IOException {
        this.writeRawVarint32(var1.length);
        this.writeRawBytes(var1);
    }

    public void writeBytes(int var1, byte[] var2) throws IOException {
        this.writeTag(var1, 2);
        this.writeBytesNoTag(var2);
    }

    public void writeBytesNoTag(byte[] var1) throws IOException {
        this.writeRawVarint32(var1.length);
        this.writeRawBytes(var1);
    }

    public void writeDouble(int var1, double var2) throws IOException {
        this.writeTag(var1, 1);
        this.writeDoubleNoTag(var2);
    }

    public void writeDoubleNoTag(double var1) throws IOException {
        this.writeRawLittleEndian64(Double.doubleToLongBits(var1));
    }

    public void writeEnum(int var1, int var2) throws IOException {
        this.writeTag(var1, 0);
        this.writeEnumNoTag(var2);
    }

    public void writeEnumNoTag(int var1) throws IOException {
        this.writeRawVarint32(var1);
    }

    public void writeFixed32(int var1, int var2) throws IOException {
        this.writeTag(var1, 5);
        this.writeFixed32NoTag(var2);
    }

    public void writeFixed32NoTag(int var1) throws IOException {
        this.writeRawLittleEndian32(var1);
    }

    public void writeFixed64(int var1, long var2) throws IOException {
        this.writeTag(var1, 1);
        this.writeFixed64NoTag(var2);
    }

    public void writeFixed64NoTag(long var1) throws IOException {
        this.writeRawLittleEndian64(var1);
    }

    public void writeFloat(int var1, float var2) throws IOException {
        this.writeTag(var1, 5);
        this.writeFloatNoTag(var2);
    }

    public void writeFloatNoTag(float var1) throws IOException {
        this.writeRawLittleEndian32(Float.floatToIntBits(var1));
    }

    public void writeGroup(int var1, MessageNano var2) throws IOException {
        this.writeTag(var1, 3);
        this.writeGroupNoTag(var2);
        this.writeTag(var1, 4);
    }

    public void writeGroupNoTag(MessageNano var1) throws IOException {
        var1.writeTo(this);
    }

    public void writeInt32(int var1, int var2) throws IOException {
        this.writeTag(var1, 0);
        this.writeInt32NoTag(var2);
    }

    public void writeInt32NoTag(int var1) throws IOException {
        if(var1 >= 0) {
            this.writeRawVarint32(var1);
        } else {
            this.writeRawVarint64((long)var1);
        }
    }

    public void writeInt64(int var1, long var2) throws IOException {
        this.writeTag(var1, 0);
        this.writeInt64NoTag(var2);
    }

    public void writeInt64NoTag(long var1) throws IOException {
        this.writeRawVarint64(var1);
    }

    public void writeMessage(int var1, MessageNano var2) throws IOException {
        this.writeTag(var1, 2);
        this.writeMessageNoTag(var2);
    }

    public void writeMessageNoTag(MessageNano var1) throws IOException {
        this.writeRawVarint32(var1.getCachedSize());
        var1.writeTo(this);
    }

    public void writeRawByte(byte var1) throws IOException {
        if(this.position == this.limit) {
            throw new CodedOutputByteBufferNano.OutOfSpaceException(this.position, this.limit);
        } else {
            byte[] var2 = this.buffer;
            int var3 = this.position;
            this.position = var3 + 1;
            var2[var3] = var1;
        }
    }

    public void writeRawByte(int var1) throws IOException {
        this.writeRawByte((byte)var1);
    }

    public void writeRawBytes(byte[] var1) throws IOException {
        this.writeRawBytes(var1, 0, var1.length);
    }

    public void writeRawBytes(byte[] var1, int var2, int var3) throws IOException {
        if(this.limit - this.position >= var3) {
            System.arraycopy(var1, var2, this.buffer, this.position, var3);
            this.position += var3;
        } else {
            throw new CodedOutputByteBufferNano.OutOfSpaceException(this.position, this.limit);
        }
    }

    public void writeRawLittleEndian32(int var1) throws IOException {
        this.writeRawByte(var1 & 255);
        this.writeRawByte(255 & var1 >> 8);
        this.writeRawByte(255 & var1 >> 16);
        this.writeRawByte(255 & var1 >> 24);
    }

    public void writeRawLittleEndian64(long var1) throws IOException {
        this.writeRawByte(255 & (int)var1);
        this.writeRawByte(255 & (int)(var1 >> 8));
        this.writeRawByte(255 & (int)(var1 >> 16));
        this.writeRawByte(255 & (int)(var1 >> 24));
        this.writeRawByte(255 & (int)(var1 >> 32));
        this.writeRawByte(255 & (int)(var1 >> 40));
        this.writeRawByte(255 & (int)(var1 >> 48));
        this.writeRawByte(255 & (int)(var1 >> 56));
    }

    public void writeRawVarint32(int var1) throws IOException {
        while((var1 & -128) != 0) {
            this.writeRawByte(128 | var1 & 127);
            var1 >>>= 7;
        }

        this.writeRawByte(var1);
    }

    public void writeRawVarint64(long var1) throws IOException {
        while((-128L & var1) != 0L) {
            this.writeRawByte(128 | 127 & (int)var1);
            var1 >>>= 7;
        }

        this.writeRawByte((int)var1);
    }

    public void writeSFixed32(int var1, int var2) throws IOException {
        this.writeTag(var1, 5);
        this.writeSFixed32NoTag(var2);
    }

    public void writeSFixed32NoTag(int var1) throws IOException {
        this.writeRawLittleEndian32(var1);
    }

    public void writeSFixed64(int var1, long var2) throws IOException {
        this.writeTag(var1, 1);
        this.writeSFixed64NoTag(var2);
    }

    public void writeSFixed64NoTag(long var1) throws IOException {
        this.writeRawLittleEndian64(var1);
    }

    public void writeSInt32(int var1, int var2) throws IOException {
        this.writeTag(var1, 0);
        this.writeSInt32NoTag(var2);
    }

    public void writeSInt32NoTag(int var1) throws IOException {
        this.writeRawVarint32(encodeZigZag32(var1));
    }

    public void writeSInt64(int var1, long var2) throws IOException {
        this.writeTag(var1, 0);
        this.writeSInt64NoTag(var2);
    }

    public void writeSInt64NoTag(long var1) throws IOException {
        this.writeRawVarint64(encodeZigZag64(var1));
    }

    public void writeString(int var1, String var2) throws IOException {
        this.writeTag(var1, 2);
        this.writeStringNoTag(var2);
    }

    public void writeStringNoTag(String var1) throws IOException {
        byte[] var2 = var1.getBytes("UTF-8");
        this.writeRawVarint32(var2.length);
        this.writeRawBytes(var2);
    }

    public void writeTag(int var1, int var2) throws IOException {
        this.writeRawVarint32(WireFormatNano.makeTag(var1, var2));
    }

    public void writeUInt32(int var1, int var2) throws IOException {
        this.writeTag(var1, 0);
        this.writeUInt32NoTag(var2);
    }

    public void writeUInt32NoTag(int var1) throws IOException {
        this.writeRawVarint32(var1);
    }

    public void writeUInt64(int var1, long var2) throws IOException {
        this.writeTag(var1, 0);
        this.writeUInt64NoTag(var2);
    }

    public void writeUInt64NoTag(long var1) throws IOException {
        this.writeRawVarint64(var1);
    }

    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException(int var1, int var2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + var1 + " limit " + var2 + ").");
        }
    }
}
