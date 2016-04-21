package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_705;
import com.google.android.gms.wallet.wobs.class_708;
import com.google.android.gms.wallet.wobs.class_711;
import com.google.android.gms.wallet.wobs.p;

// $FF: renamed from: com.google.android.gms.wallet.wobs.p
public final class class_707 implements SafeParcelable {
    public static final Creator<p> CREATOR = new class_708();
    // $FF: renamed from: BR int
    private final int field_3412;
    String auJ;
    class_711 auN;
    class_705 auO;
    class_705 auP;
    // $FF: renamed from: tG java.lang.String
    String field_3413;

    class_707() {
        this.field_3412 = 1;
    }

    class_707(int var1, String var2, String var3, class_711 var4, class_705 var5, class_705 var6) {
        this.field_3412 = var1;
        this.auJ = var2;
        this.field_3413 = var3;
        this.auN = var4;
        this.auO = var5;
        this.auP = var6;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_3412;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_708.method_3857(this, var1, var2);
    }
}
