package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.class_816;
import com.google.android.gms.maps.model.class_967;
import com.google.android.gms.maps.model.class_970;

public final class Tile implements SafeParcelable {
    public static final class_967 CREATOR = new class_967();
    // $FF: renamed from: BR int
    private final int field_5253;
    public final byte[] data;
    public final int height;
    public final int width;

    Tile(int var1, int var2, int var3, byte[] var4) {
        this.field_5253 = var1;
        this.width = var2;
        this.height = var3;
        this.data = var4;
    }

    public Tile(int var1, int var2, byte[] var3) {
        this(1, var1, var2, var3);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.field_5253;
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(class_816.method_4241()) {
            class_970.method_5128(this, var1, var2);
        } else {
            class_967.method_5119(this, var1, var2);
        }
    }
}
