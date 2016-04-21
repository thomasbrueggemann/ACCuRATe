package com.google.tagmanager.protobuf.nano;

import java.util.Arrays;

public final class UnknownFieldData {
    final byte[] bytes;
    final int tag;

    UnknownFieldData(int var1, byte[] var2) {
        this.tag = var1;
        this.bytes = var2;
    }

    public boolean equals(Object var1) {
        if(var1 != this) {
            if(!(var1 instanceof UnknownFieldData)) {
                return false;
            }

            UnknownFieldData var2 = (UnknownFieldData)var1;
            if(this.tag != var2.tag || !Arrays.equals(this.bytes, var2.bytes)) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        int var1 = 527 + this.tag;

        for(int var2 = 0; var2 < this.bytes.length; ++var2) {
            var1 = var1 * 31 + this.bytes[var2];
        }

        return var1;
    }
}
