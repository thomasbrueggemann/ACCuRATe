package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_1105;
import java.util.List;

public class OnResourceIdSetResponse implements SafeParcelable {
    public static final Creator<OnResourceIdSetResponse> CREATOR = new class_1105();
    // $FF: renamed from: BR int
    private final int field_3212;
    // $FF: renamed from: Oc java.util.List
    private final List<String> field_3213;

    OnResourceIdSetResponse(int var1, List<String> var2) {
        this.field_3212 = var1;
        this.field_3213 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_3212;
    }

    // $FF: renamed from: hX () java.util.List
    public List<String> method_3697() {
        return this.field_3213;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1105.method_5739(this, var1, var2);
    }
}
