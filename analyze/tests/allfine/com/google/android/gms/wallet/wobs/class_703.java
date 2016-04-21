package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_348;
import com.google.android.gms.wallet.wobs.b;
import com.google.android.gms.wallet.wobs.class_702;
import com.google.android.gms.wallet.wobs.d;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wallet.wobs.d
public final class class_703 implements SafeParcelable {
    public static final Creator<d> CREATOR = new class_702();
    // $FF: renamed from: BR int
    private final int field_3402;
    String auA;
    ArrayList<b> auB;
    String auz;

    class_703() {
        this.field_3402 = 1;
        this.auB = class_348.method_2342();
    }

    class_703(int var1, String var2, String var3, ArrayList<b> var4) {
        this.field_3402 = var1;
        this.auz = var2;
        this.auA = var3;
        this.auB = var4;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_3402;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_702.method_3842(this, var1, var2);
    }
}
