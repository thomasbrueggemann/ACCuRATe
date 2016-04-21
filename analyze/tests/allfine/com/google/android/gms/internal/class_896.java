package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_886;

// $FF: renamed from: com.google.android.gms.internal.ml
public class class_896 implements SafeParcelable {
    public static final class_886 CREATOR = new class_886();
    // $FF: renamed from: BR int
    final int field_4213;
    private final String afz;
    private final String mTag;

    class_896(int var1, String var2, String var3) {
        this.field_4213 = var1;
        this.afz = var2;
        this.mTag = var3;
    }

    public int describeContents() {
        class_886 var10000 = CREATOR;
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 instanceof class_896) {
            class_896 var2 = (class_896)var1;
            if(class_1089.equal(this.afz, var2.afz) && class_1089.equal(this.mTag, var2.mTag)) {
                return true;
            }
        }

        return false;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.afz, this.mTag};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: mk () java.lang.String
    public String method_4590() {
        return this.afz;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("mPlaceId", this.afz).method_5425("mTag", this.mTag).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_886 var10000 = CREATOR;
        class_886.method_4565(this, var1, var2);
    }
}
