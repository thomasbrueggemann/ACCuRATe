package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.internal.class_1090;
import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: com.google.android.gms.common.data.c
public class class_1053<T> implements Iterator<T> {
    // $FF: renamed from: JV com.google.android.gms.common.data.DataBuffer
    protected final DataBuffer<T> field_5001;
    // $FF: renamed from: JW int
    protected int field_5002;

    public class_1053(DataBuffer<T> var1) {
        this.field_5001 = (DataBuffer)class_1090.method_5685(var1);
        this.field_5002 = -1;
    }

    public boolean hasNext() {
        return this.field_5002 < -1 + this.field_5001.getCount();
    }

    public T next() {
        if(!this.hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.field_5002);
        } else {
            DataBuffer var1 = this.field_5001;
            int var2 = 1 + this.field_5002;
            this.field_5002 = var2;
            return var1.get(var2);
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
