package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_348;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.class_1022;
import com.google.android.gms.wallet.wobs.class_697;
import com.google.android.gms.wallet.wobs.class_711;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.j;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
    public static final Creator<LoyaltyWalletObject> CREATOR = new class_1022();
    // $FF: renamed from: BR int
    private final int field_3209;
    // $FF: renamed from: Dv java.lang.String
    String field_3210;
    String asT;
    String asU;
    String asV;
    String asW;
    String asX;
    String asY;
    String asZ;
    String ata;
    ArrayList<p> atb;
    class_711 atc;
    ArrayList<LatLng> atd;
    String ate;
    String atf;
    ArrayList<d> atg;
    boolean ath;
    ArrayList<n> ati;
    ArrayList<j> atj;
    ArrayList<n> atk;
    class_697 atl;
    // $FF: renamed from: fl java.lang.String
    String field_3211;
    int state;

    LoyaltyWalletObject() {
        this.field_3209 = 4;
        this.atb = class_348.method_2342();
        this.atd = class_348.method_2342();
        this.atg = class_348.method_2342();
        this.ati = class_348.method_2342();
        this.atj = class_348.method_2342();
        this.atk = class_348.method_2342();
    }

    LoyaltyWalletObject(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, int var12, ArrayList<p> var13, l var14, ArrayList<LatLng> var15, String var16, String var17, ArrayList<d> var18, boolean var19, ArrayList<n> var20, ArrayList<j> var21, ArrayList<n> var22, f var23) {
        this.field_3209 = var1;
        this.field_3211 = var2;
        this.asT = var3;
        this.asU = var4;
        this.asV = var5;
        this.field_3210 = var6;
        this.asW = var7;
        this.asX = var8;
        this.asY = var9;
        this.asZ = var10;
        this.ata = var11;
        this.state = var12;
        this.atb = var13;
        this.atc = var14;
        this.atd = var15;
        this.ate = var16;
        this.atf = var17;
        this.atg = var18;
        this.ath = var19;
        this.ati = var20;
        this.atj = var21;
        this.atk = var22;
        this.atl = var23;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.asT;
    }

    public String getAccountName() {
        return this.field_3210;
    }

    public String getBarcodeAlternateText() {
        return this.asW;
    }

    public String getBarcodeType() {
        return this.asX;
    }

    public String getBarcodeValue() {
        return this.asY;
    }

    public String getId() {
        return this.field_3211;
    }

    public String getIssuerName() {
        return this.asU;
    }

    public String getProgramName() {
        return this.asV;
    }

    public int getVersionCode() {
        return this.field_3209;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1022.method_5338(this, var1, var2);
    }
}
