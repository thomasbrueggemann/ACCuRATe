package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.class_821;

public class ParcelableIndexReference implements SafeParcelable {
    public static final Creator<ParcelableIndexReference> CREATOR = new class_821();
    // $FF: renamed from: BR int
    final int field_4451;
    // $FF: renamed from: Rp java.lang.String
    final String field_4452;
    // $FF: renamed from: Rq boolean
    final boolean field_4453;
    final int mIndex;

    ParcelableIndexReference(int var1, String var2, int var3, boolean var4) {
        this.field_4451 = var1;
        this.field_4452 = var2;
        this.mIndex = var3;
        this.field_4453 = var4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_821.method_4258(this, var1, var2);
    }
}
