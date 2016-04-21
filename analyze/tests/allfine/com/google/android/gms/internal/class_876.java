package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_864;

// $FF: renamed from: com.google.android.gms.internal.nm
public class class_876 implements SafeParcelable {
    public static final class_864 CREATOR = new class_864();
    public final int akR;
    public final int akS;
    public final String akT;
    public final String akU;
    public final boolean akV;
    public final String packageName;
    public final int versionCode;

    public class_876(int var1, String var2, int var3, int var4, String var5, String var6, boolean var7) {
        this.versionCode = var1;
        this.packageName = var2;
        this.akR = var3;
        this.akS = var4;
        this.akT = var5;
        this.akU = var6;
        this.akV = var7;
    }

    public class_876(String var1, int var2, int var3, String var4, String var5, boolean var6) {
        this.versionCode = 1;
        this.packageName = (String)class_1090.method_5685(var1);
        this.akR = var2;
        this.akS = var3;
        this.akT = var4;
        this.akU = var5;
        this.akV = var6;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(!(var1 instanceof class_876)) {
                return false;
            }

            class_876 var2 = (class_876)var1;
            if(!this.packageName.equals(var2.packageName) || this.akR != var2.akR || this.akS != var2.akS || !class_1089.equal(this.akT, var2.akT) || !class_1089.equal(this.akU, var2.akU) || this.akV != var2.akV) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.packageName, Integer.valueOf(this.akR), Integer.valueOf(this.akS), this.akT, this.akU, Boolean.valueOf(this.akV)};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("PlayLoggerContext[");
        var1.append("package=").append(this.packageName).append(',');
        var1.append("versionCode=").append(this.versionCode).append(',');
        var1.append("logSource=").append(this.akS).append(',');
        var1.append("uploadAccount=").append(this.akT).append(',');
        var1.append("loggingId=").append(this.akU).append(',');
        var1.append("logAndroidId=").append(this.akV);
        var1.append("]");
        return var1.toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_864.method_4525(this, var1, var2);
    }
}
