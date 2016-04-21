package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_274;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
    public static final Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new class_274();
    // $FF: renamed from: BR int
    final int field_4864;
    // $FF: renamed from: Ph java.lang.String
    final String field_4865;
    // $FF: renamed from: Pi boolean
    final boolean field_4866;

    GetDriveIdFromUniqueIdentifierRequest(int var1, String var2, boolean var3) {
        this.field_4864 = var1;
        this.field_4865 = var2;
        this.field_4866 = var3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_274.method_1728(this, var1, var2);
    }
}
