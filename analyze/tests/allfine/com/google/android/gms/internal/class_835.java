package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_831;

// $FF: renamed from: com.google.android.gms.internal.ls
public class class_835 implements SafeParcelable {
    public static final class_831 CREATOR = new class_831();
    // $FF: renamed from: BR int
    private final int field_4119;
    public final String packageName;
    public final int uid;

    class_835(int var1, int var2, String var3) {
        this.field_4119 = var1;
        this.uid = var2;
        this.packageName = var3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 instanceof class_835) {
            class_835 var2 = (class_835)var1;
            if(var2.uid == this.uid && class_1089.equal(var2.packageName, this.packageName)) {
                return true;
            }
        }

        return false;
    }

    int getVersionCode() {
        return this.field_4119;
    }

    public int hashCode() {
        return this.uid;
    }

    public String toString() {
        Object[] var1 = new Object[] {Integer.valueOf(this.uid), this.packageName};
        return String.format("%d:%s", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_831.method_4453(this, var1, var2);
    }
}
