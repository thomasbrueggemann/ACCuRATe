package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.class_958;
import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.plus.internal.h
public class class_959 implements SafeParcelable {
    public static final class_958 CREATOR = new class_958();
    // $FF: renamed from: BR int
    private final int field_4496;
    // $FF: renamed from: Dd java.lang.String
    private final String field_4497;
    private final String[] alD;
    private final String[] alE;
    private final String[] alF;
    private final String alG;
    private final String alH;
    private final String alI;
    private final String alJ;
    private final PlusCommonExtras alK;

    class_959(int var1, String var2, String[] var3, String[] var4, String[] var5, String var6, String var7, String var8, String var9, PlusCommonExtras var10) {
        this.field_4496 = var1;
        this.field_4497 = var2;
        this.alD = var3;
        this.alE = var4;
        this.alF = var5;
        this.alG = var6;
        this.alH = var7;
        this.alI = var8;
        this.alJ = var9;
        this.alK = var10;
    }

    public class_959(String var1, String[] var2, String[] var3, String[] var4, String var5, String var6, String var7, PlusCommonExtras var8) {
        this.field_4496 = 1;
        this.field_4497 = var1;
        this.alD = var2;
        this.alE = var3;
        this.alF = var4;
        this.alG = var5;
        this.alH = var6;
        this.alI = var7;
        this.alJ = null;
        this.alK = var8;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 instanceof class_959) {
            class_959 var2 = (class_959)var1;
            if(this.field_4496 == var2.field_4496 && class_1089.equal(this.field_4497, var2.field_4497) && Arrays.equals(this.alD, var2.alD) && Arrays.equals(this.alE, var2.alE) && Arrays.equals(this.alF, var2.alF) && class_1089.equal(this.alG, var2.alG) && class_1089.equal(this.alH, var2.alH) && class_1089.equal(this.alI, var2.alI) && class_1089.equal(this.alJ, var2.alJ) && class_1089.equal(this.alK, var2.alK)) {
                return true;
            }
        }

        return false;
    }

    public String getAccountName() {
        return this.field_4497;
    }

    public int getVersionCode() {
        return this.field_4496;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Integer.valueOf(this.field_4496), this.field_4497, this.alD, this.alE, this.alF, this.alG, this.alH, this.alI, this.alJ, this.alK};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: ng () java.lang.String[]
    public String[] method_5062() {
        return this.alD;
    }

    // $FF: renamed from: nh () java.lang.String[]
    public String[] method_5063() {
        return this.alE;
    }

    // $FF: renamed from: ni () java.lang.String[]
    public String[] method_5064() {
        return this.alF;
    }

    // $FF: renamed from: nj () java.lang.String
    public String method_5065() {
        return this.alG;
    }

    // $FF: renamed from: nk () java.lang.String
    public String method_5066() {
        return this.alH;
    }

    // $FF: renamed from: nl () java.lang.String
    public String method_5067() {
        return this.alI;
    }

    // $FF: renamed from: nm () java.lang.String
    public String method_5068() {
        return this.alJ;
    }

    // $FF: renamed from: nn () com.google.android.gms.plus.internal.PlusCommonExtras
    public PlusCommonExtras method_5069() {
        return this.alK;
    }

    // $FF: renamed from: no () android.os.Bundle
    public Bundle method_5070() {
        Bundle var1 = new Bundle();
        var1.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.alK.method_3004(var1);
        return var1;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("versionCode", Integer.valueOf(this.field_4496)).method_5425("accountName", this.field_4497).method_5425("requestedScopes", this.alD).method_5425("visibleActivities", this.alE).method_5425("requiredFeatures", this.alF).method_5425("packageNameForAuth", this.alG).method_5425("callingPackageName", this.alH).method_5425("applicationName", this.alI).method_5425("extra", this.alK.toString()).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_958.method_5059(this, var1, var2);
    }
}
