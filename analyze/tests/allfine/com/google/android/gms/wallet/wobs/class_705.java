package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_706;
import com.google.android.gms.wallet.wobs.n;

// $FF: renamed from: com.google.android.gms.wallet.wobs.n
public final class class_705 implements SafeParcelable {
    public static final Creator<n> CREATOR = new class_706();
    // $FF: renamed from: BR int
    private final int field_3411;
    String auM;
    String description;

    class_705() {
        this.field_3411 = 1;
    }

    class_705(int var1, String var2, String var3) {
        this.field_3411 = var1;
        this.auM = var2;
        this.description = var3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_3411;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_706.method_3854(this, var1, var2);
    }
}
