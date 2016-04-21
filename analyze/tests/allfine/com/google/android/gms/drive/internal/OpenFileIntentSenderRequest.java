package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1102;

public class OpenFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<OpenFileIntentSenderRequest> CREATOR = new class_1102();
    // $FF: renamed from: BR int
    final int field_4849;
    // $FF: renamed from: Nw java.lang.String
    final String field_4850;
    // $FF: renamed from: Nx java.lang.String[]
    final String[] field_4851;
    // $FF: renamed from: Ny com.google.android.gms.drive.DriveId
    final DriveId field_4852;

    OpenFileIntentSenderRequest(int var1, String var2, String[] var3, DriveId var4) {
        this.field_4849 = var1;
        this.field_4850 = var2;
        this.field_4851 = var3;
        this.field_4852 = var4;
    }

    public OpenFileIntentSenderRequest(String var1, String[] var2, DriveId var3) {
        this(1, var1, var2, var3);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1102.method_5730(this, var1, var2);
    }
}
