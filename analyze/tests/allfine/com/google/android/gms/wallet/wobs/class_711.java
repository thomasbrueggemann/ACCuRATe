package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_712;
import com.google.android.gms.wallet.wobs.l;

// $FF: renamed from: com.google.android.gms.wallet.wobs.l
public final class class_711 implements SafeParcelable {
    public static final Creator<l> CREATOR = new class_712();
    // $FF: renamed from: BR int
    private final int field_3416;
    long auK;
    long auL;

    class_711() {
        this.field_3416 = 1;
    }

    class_711(int var1, long var2, long var4) {
        this.field_3416 = var1;
        this.auK = var2;
        this.auL = var4;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_3416;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_712.method_3863(this, var1, var2);
    }
}
