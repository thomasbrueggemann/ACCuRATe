package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_282;

public class CreateContentsRequest implements SafeParcelable {
    public static final Creator<CreateContentsRequest> CREATOR = new class_282();
    // $FF: renamed from: BR int
    final int field_5039;
    // $FF: renamed from: MV int
    final int field_5040;

    public CreateContentsRequest(int var1) {
        this(1, var1);
    }

    CreateContentsRequest(int var1, int var2) {
        this.field_5039 = var1;
        boolean var3;
        if(var2 != 536870912 && var2 != 805306368) {
            var3 = false;
        } else {
            var3 = true;
        }

        class_1090.method_5683(var3, "Cannot create a new read-only contents!");
        this.field_5040 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_282.method_1767(this, var1, var2);
    }
}
