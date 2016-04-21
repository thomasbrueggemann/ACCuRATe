package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_888;
import com.google.android.gms.internal.mp;
import com.google.android.gms.internal.mr;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.mr
public class class_891 implements SafeParcelable {
    public static final Creator<mr> CREATOR = new class_888();
    // $FF: renamed from: BR int
    final int field_4209;
    // $FF: renamed from: Sz java.lang.String
    private final String field_4210;
    private final LatLng ahY;
    private final List<mp> ahZ;
    private final String aia;
    private final String aib;
    private final String mName;

    class_891(int var1, String var2, LatLng var3, String var4, List<mp> var5, String var6, String var7) {
        this.field_4209 = var1;
        this.mName = var2;
        this.ahY = var3;
        this.field_4210 = var4;
        this.ahZ = new ArrayList(var5);
        this.aia = var6;
        this.aib = var7;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.field_4210;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.aia;
    }

    // $FF: renamed from: ml () com.google.android.gms.maps.model.LatLng
    public LatLng method_4576() {
        return this.ahY;
    }

    // $FF: renamed from: mm () java.util.List
    public List<mp> method_4577() {
        return this.ahZ;
    }

    // $FF: renamed from: mn () java.lang.String
    public String method_4578() {
        return this.aib;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_888.method_4569(this, var1, var2);
    }
}
