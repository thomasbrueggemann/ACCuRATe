package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_883;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.mx
public class class_880 implements SafeParcelable {
    public static final class_883 CREATOR = new class_883();
    // $FF: renamed from: Dv java.lang.String
    public final String field_4199;
    public final String aij;
    public final String aik;
    public final int versionCode;

    public class_880(int var1, String var2, String var3, String var4) {
        this.versionCode = var1;
        this.aij = var2;
        this.aik = var3;
        this.field_4199 = var4;
    }

    public class_880(String var1, Locale var2, String var3) {
        this.versionCode = 0;
        this.aij = var1;
        this.aik = var2.toString();
        this.field_4199 = var3;
    }

    public int describeContents() {
        class_883 var10000 = CREATOR;
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(var1 != null && var1 instanceof class_880) {
                class_880 var2 = (class_880)var1;
                if(this.aik.equals(var2.aik) && this.aij.equals(var2.aij) && class_1089.equal(this.field_4199, var2.field_4199)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.aij, this.aik, this.field_4199};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("clientPackageName", this.aij).method_5425("locale", this.aik).method_5425("accountName", this.field_4199).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_883 var10000 = CREATOR;
        class_883.method_4558(this, var1, var2);
    }
}
