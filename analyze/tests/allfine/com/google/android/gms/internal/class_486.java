package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_489;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.dj
@ez
public final class class_486 implements SafeParcelable {
    public static final class_489 CREATOR = new class_489();
    public final String mimeType;
    public final String packageName;
    // $FF: renamed from: rp java.lang.String
    public final String field_1956;
    // $FF: renamed from: rq java.lang.String
    public final String field_1957;
    // $FF: renamed from: rr java.lang.String
    public final String field_1958;
    // $FF: renamed from: rs java.lang.String
    public final String field_1959;
    // $FF: renamed from: rt java.lang.String
    public final String field_1960;
    public final int versionCode;

    public class_486(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8) {
        this.versionCode = var1;
        this.field_1956 = var2;
        this.field_1957 = var3;
        this.mimeType = var4;
        this.packageName = var5;
        this.field_1958 = var6;
        this.field_1959 = var7;
        this.field_1960 = var8;
    }

    public class_486(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
        this(1, var1, var2, var3, var4, var5, var6, var7);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_489.method_2993(this, var1, var2);
    }
}
