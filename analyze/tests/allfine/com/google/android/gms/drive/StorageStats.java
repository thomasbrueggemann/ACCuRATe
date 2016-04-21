package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_733;

public class StorageStats implements SafeParcelable {
    public static final Creator<StorageStats> CREATOR = new class_733();
    // $FF: renamed from: BR int
    final int field_3393;
    // $FF: renamed from: NB long
    final long field_3394;
    // $FF: renamed from: NC long
    final long field_3395;
    // $FF: renamed from: ND long
    final long field_3396;
    // $FF: renamed from: NE long
    final long field_3397;
    // $FF: renamed from: NF int
    final int field_3398;

    StorageStats(int var1, long var2, long var4, long var6, long var8, int var10) {
        this.field_3393 = var1;
        this.field_3394 = var2;
        this.field_3395 = var4;
        this.field_3396 = var6;
        this.field_3397 = var8;
        this.field_3398 = var10;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_733.method_3969(this, var1, var2);
    }
}
