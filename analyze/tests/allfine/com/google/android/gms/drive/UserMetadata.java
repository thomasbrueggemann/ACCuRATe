package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_734;

public class UserMetadata implements SafeParcelable {
    public static final Creator<UserMetadata> CREATOR = new class_734();
    // $FF: renamed from: BR int
    final int field_2954;
    // $FF: renamed from: NG java.lang.String
    final String field_2955;
    // $FF: renamed from: NH java.lang.String
    final String field_2956;
    // $FF: renamed from: NI java.lang.String
    final String field_2957;
    // $FF: renamed from: NJ boolean
    final boolean field_2958;
    // $FF: renamed from: NK java.lang.String
    final String field_2959;

    UserMetadata(int var1, String var2, String var3, String var4, boolean var5, String var6) {
        this.field_2954 = var1;
        this.field_2955 = var2;
        this.field_2956 = var3;
        this.field_2957 = var4;
        this.field_2958 = var5;
        this.field_2959 = var6;
    }

    public UserMetadata(String var1, String var2, String var3, boolean var4, String var5) {
        this(1, var1, var2, var3, var4, var5);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        Object[] var1 = new Object[] {this.field_2955, this.field_2956, this.field_2957, Boolean.valueOf(this.field_2958), this.field_2959};
        return String.format("Permission ID: \'%s\', Display Name: \'%s\', Picture URL: \'%s\', Authenticated User: %b, Email: \'%s\'", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_734.method_3972(this, var1, var2);
    }
}
