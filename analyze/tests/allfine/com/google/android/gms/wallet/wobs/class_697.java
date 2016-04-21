package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_696;
import com.google.android.gms.wallet.wobs.class_698;
import com.google.android.gms.wallet.wobs.class_711;
import com.google.android.gms.wallet.wobs.f;

// $FF: renamed from: com.google.android.gms.wallet.wobs.f
public final class class_697 implements SafeParcelable {
    public static final Creator<f> CREATOR = new class_698();
    // $FF: renamed from: BR int
    private final int field_3400;
    class_711 atc;
    class_696 auC;
    String label;
    String type;

    class_697() {
        this.field_3400 = 1;
    }

    class_697(int var1, String var2, class_696 var3, String var4, class_711 var5) {
        this.field_3400 = var1;
        this.label = var2;
        this.auC = var3;
        this.type = var4;
        this.atc = var5;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_3400;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_698.method_3833(this, var1, var2);
    }
}
