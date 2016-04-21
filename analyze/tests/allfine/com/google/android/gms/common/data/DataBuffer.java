package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_1053;
import com.google.android.gms.common.data.class_1054;
import java.util.Iterator;

public abstract class DataBuffer<T> implements Releasable, Iterable<T> {
    // $FF: renamed from: II com.google.android.gms.common.data.DataHolder
    protected final DataHolder field_1839;

    protected DataBuffer(DataHolder var1) {
        this.field_1839 = var1;
        if(this.field_1839 != null) {
            this.field_1839.method_5992(this);
        }

    }

    @Deprecated
    public final void close() {
        this.release();
    }

    public int describeContents() {
        return 0;
    }

    public abstract T get(int var1);

    public int getCount() {
        return this.field_1839 == null?0:this.field_1839.getCount();
    }

    // $FF: renamed from: gy () android.os.Bundle
    public Bundle method_2892() {
        return this.field_1839.method_5998();
    }

    @Deprecated
    public boolean isClosed() {
        return this.field_1839 == null?true:this.field_1839.isClosed();
    }

    public Iterator<T> iterator() {
        return new class_1053(this);
    }

    public void release() {
        if(this.field_1839 != null) {
            this.field_1839.close();
        }

    }

    public Iterator<T> singleRefIterator() {
        return new class_1054(this);
    }
}
