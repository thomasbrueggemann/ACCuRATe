package com.google.tagmanager.protobuf.nano;

import com.google.tagmanager.protobuf.nano.CodedInputByteBufferNano;
import com.google.tagmanager.protobuf.nano.CodedOutputByteBufferNano;
import com.google.tagmanager.protobuf.nano.Extension;
import com.google.tagmanager.protobuf.nano.UnknownFieldData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class WireFormatNano {
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    public static final Boolean[] EMPTY_BOOLEAN_REF_ARRAY = new Boolean[0];
    public static final byte[] EMPTY_BYTES = new byte[0];
    public static final byte[][] EMPTY_BYTES_ARRAY = new byte[0][];
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    public static final Double[] EMPTY_DOUBLE_REF_ARRAY = new Double[0];
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    public static final Float[] EMPTY_FLOAT_REF_ARRAY = new Float[0];
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final Integer[] EMPTY_INT_REF_ARRAY = new Integer[0];
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final Long[] EMPTY_LONG_REF_ARRAY = new Long[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    static final int MESSAGE_SET_ITEM = 1;
    static final int MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
    static final int MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
    static final int MESSAGE_SET_MESSAGE = 3;
    static final int MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    static final int MESSAGE_SET_TYPE_ID = 2;
    static final int MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = 7;
    static final int WIRETYPE_END_GROUP = 4;
    static final int WIRETYPE_FIXED32 = 5;
    static final int WIRETYPE_FIXED64 = 1;
    static final int WIRETYPE_LENGTH_DELIMITED = 2;
    static final int WIRETYPE_START_GROUP = 3;
    static final int WIRETYPE_VARINT;

    public static int computeWireSize(List<UnknownFieldData> var0) {
        int var1;
        if(var0 == null) {
            var1 = 0;
        } else {
            var1 = 0;

            UnknownFieldData var3;
            for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 = var1 + CodedOutputByteBufferNano.computeRawVarint32Size(var3.tag) + var3.bytes.length) {
                var3 = (UnknownFieldData)var2.next();
            }
        }

        return var1;
    }

    public static <T> T getExtension(Extension<T> var0, List<UnknownFieldData> var1) {
        if(var1 != null) {
            ArrayList var2 = new ArrayList();
            Iterator var3 = var1.iterator();

            while(var3.hasNext()) {
                UnknownFieldData var9 = (UnknownFieldData)var3.next();
                if(getTagFieldNumber(var9.tag) == var0.fieldNumber) {
                    var2.add(var9);
                }
            }

            if(!var2.isEmpty()) {
                if(!var0.isRepeatedField) {
                    UnknownFieldData var8 = (UnknownFieldData)var2.get(-1 + var2.size());
                    return readData(var0.fieldType, var8.bytes);
                }

                ArrayList var4 = new ArrayList(var2.size());
                Iterator var5 = var2.iterator();

                while(var5.hasNext()) {
                    UnknownFieldData var6 = (UnknownFieldData)var5.next();
                    var4.add(readData(var0.fieldType, var6.bytes));
                }

                return var0.listType.cast(var4);
            }
        }

        return null;
    }

    public static final int getRepeatedFieldArrayLength(CodedInputByteBufferNano var0, int var1) throws IOException {
        int var2 = 1;
        int var3 = var0.getPosition();
        var0.skipField(var1);

        while(var0.getBytesUntilLimit() > 0 && var0.readTag() == var1) {
            var0.skipField(var1);
            ++var2;
        }

        var0.rewindToPosition(var3);
        return var2;
    }

    public static int getTagFieldNumber(int var0) {
        return var0 >>> 3;
    }

    static int getTagWireType(int var0) {
        return var0 & 7;
    }

    static int makeTag(int var0, int var1) {
        return var1 | var0 << 3;
    }

    public static boolean parseUnknownField(CodedInputByteBufferNano var0, int var1) throws IOException {
        return var0.skipField(var1);
    }

    private static <T> T readData(Class<T> param0, byte[] param1) {
        // $FF: Couldn't be decompiled
    }

    public static <T> void setExtension(Extension<T> var0, T var1, List<UnknownFieldData> var2) {
        Iterator var3 = var2.iterator();

        while(var3.hasNext()) {
            UnknownFieldData var8 = (UnknownFieldData)var3.next();
            if(var0.fieldNumber == getTagFieldNumber(var8.tag)) {
                var3.remove();
            }
        }

        if(var1 != null) {
            if(!(var1 instanceof List)) {
                var2.add(write(var0.fieldNumber, var1));
                return;
            }

            Iterator var5 = ((List)var1).iterator();

            while(var5.hasNext()) {
                Object var6 = var5.next();
                var2.add(write(var0.fieldNumber, var6));
            }
        }

    }

    public static boolean storeUnknownField(List<UnknownFieldData> var0, CodedInputByteBufferNano var1, int var2) throws IOException {
        int var3 = var1.getPosition();
        boolean var4 = var1.skipField(var2);
        var0.add(new UnknownFieldData(var2, var1.getData(var3, var1.getPosition() - var3)));
        return var4;
    }

    private static UnknownFieldData write(int param0, Object param1) {
        // $FF: Couldn't be decompiled
    }

    public static void writeUnknownFields(List<UnknownFieldData> var0, CodedOutputByteBufferNano var1) throws IOException {
        if(var0 != null) {
            Iterator var2 = var0.iterator();

            while(var2.hasNext()) {
                UnknownFieldData var3 = (UnknownFieldData)var2.next();
                var1.writeTag(getTagFieldNumber(var3.tag), getTagWireType(var3.tag));
                var1.writeRawBytes(var3.bytes);
            }
        }

    }
}
