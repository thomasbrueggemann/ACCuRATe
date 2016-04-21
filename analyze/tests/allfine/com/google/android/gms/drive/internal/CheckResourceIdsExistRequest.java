package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_279;
import java.util.List;

public class CheckResourceIdsExistRequest implements SafeParcelable {
    public static final Creator<CheckResourceIdsExistRequest> CREATOR = new class_279();
    // $FF: renamed from: BR int
    private final int field_3160;
    // $FF: renamed from: Oc java.util.List
    private final List<String> field_3161;

    CheckResourceIdsExistRequest(int var1, List<String> var2) {
        this.field_3160 = var1;
        this.field_3161 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_3160;
    }

    // $FF: renamed from: hX () java.util.List
    public List<String> method_3581() {
        return this.field_3161;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_279.method_1735(this, var1, var2);
    }
}
