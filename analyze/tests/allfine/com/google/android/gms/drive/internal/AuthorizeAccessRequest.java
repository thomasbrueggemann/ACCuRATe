package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_253;

public class AuthorizeAccessRequest implements SafeParcelable {
    public static final Creator<AuthorizeAccessRequest> CREATOR = new class_253();
    // $FF: renamed from: BR int
    final int field_4853;
    // $FF: renamed from: MW com.google.android.gms.drive.DriveId
    final DriveId field_4854;
    // $FF: renamed from: Ob long
    final long field_4855;

    AuthorizeAccessRequest(int var1, long var2, DriveId var4) {
        this.field_4853 = var1;
        this.field_4855 = var2;
        this.field_4854 = var4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_253.method_1636(this, var1, var2);
    }
}
