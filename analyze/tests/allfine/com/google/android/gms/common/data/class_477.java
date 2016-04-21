package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// $FF: renamed from: com.google.android.gms.common.data.e
public class class_477<T extends SafeParcelable> extends DataBuffer<T> {
    // $FF: renamed from: JZ java.lang.String[]
    private static final String[] field_1840 = new String[] {"data"};
    // $FF: renamed from: Ka android.os.Parcelable.Creator
    private final Creator<T> field_1841;

    public class_477(DataHolder var1, Creator<T> var2) {
        super(var1);
        this.field_1841 = var2;
    }

    // $FF: renamed from: aq (int) com.google.android.gms.common.internal.safeparcel.SafeParcelable
    public T method_2894(int var1) {
        byte[] var2 = this.II.method_5993("data", var1, 0);
        Parcel var3 = Parcel.obtain();
        var3.unmarshall(var2, 0, var2.length);
        var3.setDataPosition(0);
        SafeParcelable var4 = (SafeParcelable)this.field_1841.createFromParcel(var3);
        var3.recycle();
        return var4;
    }

    // $FF: synthetic method
    public Object get(int var1) {
        return this.method_2894(var1);
    }
}
