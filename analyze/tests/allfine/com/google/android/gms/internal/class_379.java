package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_380;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.gt
@ez
public final class class_379 implements SafeParcelable {
    public static final class_380 CREATOR = new class_380();
    public final int versionCode;
    // $FF: renamed from: wD java.lang.String
    public String field_1387;
    // $FF: renamed from: wE int
    public int field_1388;
    // $FF: renamed from: wF int
    public int field_1389;
    // $FF: renamed from: wG boolean
    public boolean field_1390;

    public class_379(int var1, int var2, boolean var3) {
        StringBuilder var4 = (new StringBuilder()).append("afma-sdk-a-v").append(var1).append(".").append(var2).append(".");
        String var5;
        if(var3) {
            var5 = "0";
        } else {
            var5 = "1";
        }

        this(1, var4.append(var5).toString(), var1, var2, var3);
    }

    class_379(int var1, String var2, int var3, int var4, boolean var5) {
        this.versionCode = var1;
        this.field_1387 = var2;
        this.field_1388 = var3;
        this.field_1389 = var4;
        this.field_1390 = var5;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_380.method_2467(this, var1, var2);
    }
}
