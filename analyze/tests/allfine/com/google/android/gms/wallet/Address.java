package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_1028;

@Deprecated
public final class Address implements SafeParcelable {
    public static final Creator<Address> CREATOR = new class_1028();
    // $FF: renamed from: BR int
    private final int field_4007;
    String adN;
    String adO;
    String adP;
    String adU;
    String adW;
    boolean adX;
    String adY;
    String ast;
    String asu;
    String name;
    // $FF: renamed from: uW java.lang.String
    String field_4008;

    Address() {
        this.field_4007 = 1;
    }

    Address(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, boolean var11, String var12) {
        this.field_4007 = var1;
        this.name = var2;
        this.adN = var3;
        this.adO = var4;
        this.adP = var5;
        this.field_4008 = var6;
        this.ast = var7;
        this.asu = var8;
        this.adU = var9;
        this.adW = var10;
        this.adX = var11;
        this.adY = var12;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.adN;
    }

    public String getAddress2() {
        return this.adO;
    }

    public String getAddress3() {
        return this.adP;
    }

    public String getCity() {
        return this.ast;
    }

    public String getCompanyName() {
        return this.adY;
    }

    public String getCountryCode() {
        return this.field_4008;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.adW;
    }

    public String getPostalCode() {
        return this.adU;
    }

    public String getState() {
        return this.asu;
    }

    public int getVersionCode() {
        return this.field_4007;
    }

    public boolean isPostBox() {
        return this.adX;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1028.method_5358(this, var1, var2);
    }
}
