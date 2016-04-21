package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.class_960;

public class CustomProperty implements SafeParcelable {
    public static final Creator<CustomProperty> CREATOR = new class_960();
    // $FF: renamed from: BR int
    final int field_4194;
    // $FF: renamed from: PJ com.google.android.gms.drive.metadata.CustomPropertyKey
    final CustomPropertyKey field_4195;
    final String mValue;

    CustomProperty(int var1, CustomPropertyKey var2, String var3) {
        this.field_4194 = var1;
        class_1090.method_5681(var2, "key");
        this.field_4195 = var2;
        this.mValue = var3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_960.method_5086(this, var1, var2);
    }
}
