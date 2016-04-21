package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_729;
import java.util.List;

public class RealtimeDocumentSyncRequest implements SafeParcelable {
    public static final Creator<RealtimeDocumentSyncRequest> CREATOR = new class_729();
    // $FF: renamed from: BR int
    final int field_4648;
    // $FF: renamed from: NA java.util.List
    final List<String> field_4649;
    // $FF: renamed from: Nz java.util.List
    final List<String> field_4650;

    RealtimeDocumentSyncRequest(int var1, List<String> var2, List<String> var3) {
        this.field_4648 = var1;
        this.field_4650 = (List)class_1090.method_5685(var2);
        this.field_4649 = (List)class_1090.method_5685(var3);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_729.method_3960(this, var1, var2);
    }
}
