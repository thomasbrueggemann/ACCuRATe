package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.class_944;

public final class UserAddress implements SafeParcelable {
    public static final Creator<UserAddress> CREATOR = new class_944();
    // $FF: renamed from: BR int
    private final int field_4512;
    String adN;
    String adO;
    String adP;
    String adQ;
    String adR;
    String adS;
    String adT;
    String adU;
    String adV;
    String adW;
    boolean adX;
    String adY;
    String adZ;
    String name;
    // $FF: renamed from: uW java.lang.String
    String field_4513;

    UserAddress() {
        this.field_4512 = 1;
    }

    UserAddress(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, boolean var14, String var15, String var16) {
        this.field_4512 = var1;
        this.name = var2;
        this.adN = var3;
        this.adO = var4;
        this.adP = var5;
        this.adQ = var6;
        this.adR = var7;
        this.adS = var8;
        this.adT = var9;
        this.field_4513 = var10;
        this.adU = var11;
        this.adV = var12;
        this.adW = var13;
        this.adX = var14;
        this.adY = var15;
        this.adZ = var16;
    }

    public static UserAddress fromIntent(Intent var0) {
        return var0 != null && var0.hasExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS")?(UserAddress)var0.getParcelableExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS"):null;
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

    public String getAddress4() {
        return this.adQ;
    }

    public String getAddress5() {
        return this.adR;
    }

    public String getAdministrativeArea() {
        return this.adS;
    }

    public String getCompanyName() {
        return this.adY;
    }

    public String getCountryCode() {
        return this.field_4513;
    }

    public String getEmailAddress() {
        return this.adZ;
    }

    public String getLocality() {
        return this.adT;
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

    public String getSortingCode() {
        return this.adV;
    }

    public int getVersionCode() {
        return this.field_4512;
    }

    public boolean isPostBox() {
        return this.adX;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_944.method_4929(this, var1, var2);
    }
}
