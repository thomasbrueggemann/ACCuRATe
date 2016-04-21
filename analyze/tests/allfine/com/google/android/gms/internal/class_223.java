package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.bj;
import com.google.android.gms.internal.class_214;
import com.google.android.gms.internal.class_249;
import com.google.android.gms.internal.ez;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.av
@ez
public final class class_223 implements SafeParcelable {
    public static final class_214 CREATOR = new class_214();
    public final Bundle extras;
    // $FF: renamed from: nT long
    public final long field_550;
    // $FF: renamed from: nU int
    public final int field_551;
    // $FF: renamed from: nV java.util.List
    public final List<String> field_552;
    // $FF: renamed from: nW boolean
    public final boolean field_553;
    // $FF: renamed from: nX int
    public final int field_554;
    // $FF: renamed from: nY boolean
    public final boolean field_555;
    // $FF: renamed from: nZ java.lang.String
    public final String field_556;
    // $FF: renamed from: oa com.google.android.gms.internal.bj
    public final class_249 field_557;
    // $FF: renamed from: ob android.location.Location
    public final Location field_558;
    // $FF: renamed from: oc java.lang.String
    public final String field_559;
    // $FF: renamed from: od android.os.Bundle
    public final Bundle field_560;
    public final int versionCode;

    public class_223(int var1, long var2, Bundle var4, int var5, List<String> var6, boolean var7, int var8, boolean var9, String var10, bj var11, Location var12, String var13, Bundle var14) {
        this.versionCode = var1;
        this.field_550 = var2;
        this.extras = var4;
        this.field_551 = var5;
        this.field_552 = var6;
        this.field_553 = var7;
        this.field_554 = var8;
        this.field_555 = var9;
        this.field_556 = var10;
        this.field_557 = var11;
        this.field_558 = var12;
        this.field_559 = var13;
        this.field_560 = var14;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_214.method_1500(this, var1, var2);
    }
}
