package com.google.tagmanager.protobuf.nano;

import com.google.tagmanager.protobuf.nano.CodedInputByteBufferNano;
import com.google.tagmanager.protobuf.nano.CodedOutputByteBufferNano;
import com.google.tagmanager.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.tagmanager.protobuf.nano.MessageNanoPrinter;
import java.io.IOException;
import java.util.Arrays;

public abstract class MessageNano {
    protected int cachedSize = -1;

    public static final <T extends MessageNano> T mergeFrom(T var0, byte[] var1) throws InvalidProtocolBufferNanoException {
        return mergeFrom(var0, var1, 0, var1.length);
    }

    public static final <T extends MessageNano> T mergeFrom(T var0, byte[] var1, int var2, int var3) throws InvalidProtocolBufferNanoException {
        try {
            CodedInputByteBufferNano var6 = CodedInputByteBufferNano.newInstance(var1, var2, var3);
            var0.mergeFrom(var6);
            var6.checkLastTagWas(0);
            return var0;
        } catch (InvalidProtocolBufferNanoException var7) {
            throw var7;
        } catch (IOException var8) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final boolean messageNanoEquals(MessageNano var0, MessageNano var1) {
        boolean var2;
        if(var0 == var1) {
            var2 = true;
        } else {
            var2 = false;
            if(var0 != null) {
                var2 = false;
                if(var1 != null) {
                    Class var3 = var0.getClass();
                    Class var4 = var1.getClass();
                    var2 = false;
                    if(var3 == var4) {
                        int var5 = var0.getSerializedSize();
                        int var6 = var1.getSerializedSize();
                        var2 = false;
                        if(var6 == var5) {
                            byte[] var7 = new byte[var5];
                            byte[] var8 = new byte[var5];
                            toByteArray(var0, var7, 0, var5);
                            toByteArray(var1, var8, 0, var5);
                            return Arrays.equals(var7, var8);
                        }
                    }
                }
            }
        }

        return var2;
    }

    public static final void toByteArray(MessageNano var0, byte[] var1, int var2, int var3) {
        try {
            CodedOutputByteBufferNano var5 = CodedOutputByteBufferNano.newInstance(var1, var2, var3);
            var0.writeTo(var5);
            var5.checkNoSpaceLeft();
        } catch (IOException var6) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", var6);
        }
    }

    public static final byte[] toByteArray(MessageNano var0) {
        byte[] var1 = new byte[var0.getSerializedSize()];
        toByteArray(var0, var1, 0, var1.length);
        return var1;
    }

    public int getCachedSize() {
        if(this.cachedSize < 0) {
            this.getSerializedSize();
        }

        return this.cachedSize;
    }

    public int getSerializedSize() {
        this.cachedSize = 0;
        return 0;
    }

    public abstract MessageNano mergeFrom(CodedInputByteBufferNano var1) throws IOException;

    public String toString() {
        return MessageNanoPrinter.print(this);
    }

    public abstract void writeTo(CodedOutputByteBufferNano var1) throws IOException;
}
