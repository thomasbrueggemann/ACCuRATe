package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_348;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.class_704;
import com.google.android.gms.wallet.wobs.class_711;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.j;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public class CommonWalletObject implements SafeParcelable {
    public static final Creator<CommonWalletObject> CREATOR = new class_704();
    // $FF: renamed from: BR int
    private final int field_5284;
    String asU;
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
    // $FF: renamed from: fl java.lang.String
    String field_5285;
    String name;
    int state;

    CommonWalletObject() {
        this.field_5284 = 1;
        this.atb = class_348.method_2342();
        this.atd = class_348.method_2342();
        this.atg = class_348.method_2342();
        this.ati = class_348.method_2342();
        this.atj = class_348.method_2342();
        this.atk = class_348.method_2342();
    }

    CommonWalletObject(int var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, int var10, ArrayList<p> var11, l var12, ArrayList<LatLng> var13, String var14, String var15, ArrayList<d> var16, boolean var17, ArrayList<n> var18, ArrayList<j> var19, ArrayList<n> var20) {
        this.field_5284 = var1;
        this.field_5285 = var2;
        this.ata = var3;
        this.name = var4;
        this.asU = var5;
        this.asW = var6;
        this.asX = var7;
        this.asY = var8;
        this.asZ = var9;
        this.state = var10;
        this.atb = var11;
        this.atc = var12;
        this.atd = var13;
        this.ate = var14;
        this.atf = var15;
        this.atg = var16;
        this.ath = var17;
        this.ati = var18;
        this.atj = var19;
        this.atk = var20;
    }

    // $FF: renamed from: pQ () com.google.android.gms.wallet.wobs.CommonWalletObject$a
    public static CommonWalletObject.class_1324 method_5937() {
        CommonWalletObject var0 = new CommonWalletObject();
        return var0.new class_1324();
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.field_5285;
    }

    public int getVersionCode() {
        return this.field_5284;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_704.method_3845(this, var1, var2);
    }

    public final class class_1324 {
        private class_1324() {
        }

        // $FF: synthetic method
        class_1324(Object var2) {
            this();
        }

        // $FF: renamed from: df (java.lang.String) com.google.android.gms.wallet.wobs.CommonWalletObject$a
        public CommonWalletObject.class_1324 method_3182(String var1) {
            CommonWalletObject.this.field_5285 = var1;
            return this;
        }

        // $FF: renamed from: pR () com.google.android.gms.wallet.wobs.CommonWalletObject
        public CommonWalletObject method_3183() {
            return CommonWalletObject.this;
        }
    }
}
