package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.c;
import com.google.android.gms.common.data.class_255;
import java.util.NoSuchElementException;

// $FF: renamed from: com.google.android.gms.common.data.h
public class class_1054<T> extends c<T> {
    // $FF: renamed from: Kr java.lang.Object
    private T field_5003;

    public class_1054(DataBuffer<T> var1) {
        super(var1);
    }

    public T next() {
        if(!this.hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.JW);
        } else {
            ++this.JW;
            if(this.JW == 0) {
                this.field_5003 = this.JV.get(0);
                if(!(this.field_5003 instanceof class_255)) {
                    throw new IllegalStateException("DataBuffer reference of type " + this.field_5003.getClass() + " is not movable");
                }
            } else {
                ((class_255)this.field_5003).method_1650(this.JW);
            }

            return this.field_5003;
        }
    }
}
