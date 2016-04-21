package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.class_1049;

// $FF: renamed from: com.google.android.gms.wearable.c
public class class_1048 implements SafeParcelable {
    public static final Creator<c> CREATOR = new class_1049();
    // $FF: renamed from: BR int
    final int field_4886;
    // $FF: renamed from: FD int
    private final int field_4887;
    // $FF: renamed from: Sz java.lang.String
    private final String field_4888;
    private final int auS;
    private final boolean auT;
    private boolean auU;
    private String auV;
    private final String mName;

    class_1048(int var1, String var2, String var3, int var4, int var5, boolean var6, boolean var7, String var8) {
        this.field_4886 = var1;
        this.mName = var2;
        this.field_4888 = var3;
        this.field_4887 = var4;
        this.auS = var5;
        this.auT = var6;
        this.auU = var7;
        this.auV = var8;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 instanceof class_1048) {
            class_1048 var2 = (class_1048)var1;
            if(class_1089.equal(Integer.valueOf(this.field_4886), Integer.valueOf(var2.field_4886)) && class_1089.equal(this.mName, var2.mName) && class_1089.equal(this.field_4888, var2.field_4888) && class_1089.equal(Integer.valueOf(this.field_4887), Integer.valueOf(var2.field_4887)) && class_1089.equal(Integer.valueOf(this.auS), Integer.valueOf(var2.auS)) && class_1089.equal(Boolean.valueOf(this.auT), Boolean.valueOf(var2.auT))) {
                return true;
            }
        }

        return false;
    }

    public String getAddress() {
        return this.field_4888;
    }

    public String getName() {
        return this.mName;
    }

    public int getRole() {
        return this.auS;
    }

    public int getType() {
        return this.field_4887;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Integer.valueOf(this.field_4886), this.mName, this.field_4888, Integer.valueOf(this.field_4887), Integer.valueOf(this.auS), Boolean.valueOf(this.auT)};
        return class_1089.hashCode(var1);
    }

    public boolean isConnected() {
        return this.auU;
    }

    public boolean isEnabled() {
        return this.auT;
    }

    // $FF: renamed from: pS () java.lang.String
    public String method_5485() {
        return this.auV;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder("ConnectionConfiguration[ ");
        var1.append("mName=" + this.mName);
        var1.append(", mAddress=" + this.field_4888);
        var1.append(", mType=" + this.field_4887);
        var1.append(", mRole=" + this.auS);
        var1.append(", mEnabled=" + this.auT);
        var1.append(", mIsConnected=" + this.auU);
        var1.append(", mEnabled=" + this.auV);
        var1.append("]");
        return var1.toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1049.method_5486(this, var1, var2);
    }
}
