package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_334;
import com.google.android.gms.internal.class_337;
import com.google.android.gms.internal.ig;

// $FF: renamed from: com.google.android.gms.internal.ig
public class class_338 implements SafeParcelable {
    public static final Creator<ig> CREATOR = new class_337();
    // $FF: renamed from: BR int
    private final int field_1195;
    // $FF: renamed from: Gn java.lang.String
    private String field_1196;

    public class_338() {
        this(1, (String)null);
    }

    class_338(int var1, String var2) {
        this.field_1195 = var1;
        this.field_1196 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 == this) {
            return true;
        } else if(!(var1 instanceof class_338)) {
            return false;
        } else {
            class_338 var2 = (class_338)var1;
            return class_334.method_2300(this.field_1196, var2.field_1196);
        }
    }

    // $FF: renamed from: fy () java.lang.String
    public String method_2312() {
        return this.field_1196;
    }

    public int getVersionCode() {
        return this.field_1195;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_1196};
        return class_1089.hashCode(var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_337.method_2309(this, var1, var2);
    }
}
