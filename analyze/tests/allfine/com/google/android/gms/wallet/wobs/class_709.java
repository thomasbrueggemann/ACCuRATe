package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_710;
import com.google.android.gms.wallet.wobs.j;

// $FF: renamed from: com.google.android.gms.wallet.wobs.j
public final class class_709 implements SafeParcelable {
    public static final Creator<j> CREATOR = new class_710();
    // $FF: renamed from: BR int
    private final int field_3414;
    String auJ;
    // $FF: renamed from: tG java.lang.String
    String field_3415;

    class_709() {
        this.field_3414 = 1;
    }

    class_709(int var1, String var2, String var3) {
        this.field_3414 = var1;
        this.auJ = var2;
        this.field_3415 = var3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_3414;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_710.method_3860(this, var1, var2);
    }
}
