package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.common.data.g
public abstract class class_478<T> extends DataBuffer<T> {
    // $FF: renamed from: Kp boolean
    private boolean field_1844 = false;
    // $FF: renamed from: Kq java.util.ArrayList
    private ArrayList<Integer> field_1845;

    protected class_478(DataHolder var1) {
        super(var1);
    }

    // $FF: renamed from: gE () void
    private void method_2900() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: au (int) int
    int method_2901(int var1) {
        if(var1 >= 0 && var1 < this.field_1845.size()) {
            return ((Integer)this.field_1845.get(var1)).intValue();
        } else {
            throw new IllegalArgumentException("Position " + var1 + " is out of bounds for this buffer");
        }
    }

    // $FF: renamed from: av (int) int
    protected int method_2902(int var1) {
        int var2;
        if(var1 >= 0 && var1 != this.field_1845.size()) {
            if(var1 == -1 + this.field_1845.size()) {
                var2 = this.II.getCount() - ((Integer)this.field_1845.get(var1)).intValue();
            } else {
                var2 = ((Integer)this.field_1845.get(var1 + 1)).intValue() - ((Integer)this.field_1845.get(var1)).intValue();
            }

            if(var2 == 1) {
                int var3 = this.method_2901(var1);
                int var4 = this.II.method_5987(var3);
                String var5 = this.method_2905();
                if(var5 != null && this.II.method_5989(var5, var3, var4) == null) {
                    return 0;
                }
            }
        } else {
            var2 = 0;
        }

        return var2;
    }

    // $FF: renamed from: f (int, int) java.lang.Object
    protected abstract T method_2903(int var1, int var2);

    // $FF: renamed from: gD () java.lang.String
    protected abstract String method_2904();

    // $FF: renamed from: gF () java.lang.String
    protected String method_2905() {
        return null;
    }

    public final T get(int var1) {
        this.method_2900();
        return this.method_2903(this.method_2901(var1), this.method_2902(var1));
    }

    public int getCount() {
        this.method_2900();
        return this.field_1845.size();
    }
}
