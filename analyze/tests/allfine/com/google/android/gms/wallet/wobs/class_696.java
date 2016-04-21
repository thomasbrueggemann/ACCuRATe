package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_699;
import com.google.android.gms.wallet.wobs.g;

// $FF: renamed from: com.google.android.gms.wallet.wobs.g
public final class class_696 implements SafeParcelable {
    public static final Creator<g> CREATOR = new class_699();
    // $FF: renamed from: BR int
    private final int field_3399;
    int auD;
    String auE;
    double auF;
    String auG;
    long auH;
    int auI;

    class_696() {
        this.field_3399 = 1;
        this.auI = -1;
        this.auD = -1;
        this.auF = -1.0D;
    }

    class_696(int var1, int var2, String var3, double var4, String var6, long var7, int var9) {
        this.field_3399 = var1;
        this.auD = var2;
        this.auE = var3;
        this.auF = var4;
        this.auG = var6;
        this.auH = var7;
        this.auI = var9;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_3399;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_699.method_3836(this, var1, var2);
    }
}
