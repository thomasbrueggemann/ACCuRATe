package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_825;
import com.google.android.gms.internal.ls;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.ma
public class class_826 implements SafeParcelable {
    public static final class_825 CREATOR = new class_825();
    static final List<ls> afh = Collections.emptyList();
    // $FF: renamed from: BR int
    private final int field_4106;
    // $FF: renamed from: UI com.google.android.gms.location.LocationRequest
    LocationRequest field_4107;
    boolean afi;
    boolean afj;
    boolean afk;
    List<ls> afl;
    final String mTag;

    class_826(int var1, LocationRequest var2, boolean var3, boolean var4, boolean var5, List<ls> var6, String var7) {
        this.field_4106 = var1;
        this.field_4107 = var2;
        this.afi = var3;
        this.afj = var4;
        this.afk = var5;
        this.afl = var6;
        this.mTag = var7;
    }

    private class_826(String var1, LocationRequest var2) {
        this(1, var2, false, true, true, afh, var1);
    }

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.location.LocationRequest) com.google.android.gms.internal.ma
    public static class_826 method_4434(String var0, LocationRequest var1) {
        return new class_826(var0, var1);
    }

    // $FF: renamed from: b (com.google.android.gms.location.LocationRequest) com.google.android.gms.internal.ma
    public static class_826 method_4435(LocationRequest var0) {
        return method_4434((String)null, var0);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 instanceof class_826) {
            class_826 var2 = (class_826)var1;
            if(class_1089.equal(this.field_4107, var2.field_4107) && this.afi == var2.afi && this.afj == var2.afj && this.afk == var2.afk && class_1089.equal(this.afl, var2.afl)) {
                return true;
            }
        }

        return false;
    }

    int getVersionCode() {
        return this.field_4106;
    }

    public int hashCode() {
        return this.field_4107.hashCode();
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append(this.field_4107.toString());
        var1.append(" requestNlpDebugInfo=");
        var1.append(this.afi);
        var1.append(" restorePendingIntentListeners=");
        var1.append(this.afj);
        var1.append(" triggerUpdate=");
        var1.append(this.afk);
        var1.append(" clients=");
        var1.append(this.afl);
        if(this.mTag != null) {
            var1.append(" tag=");
            var1.append(this.mTag);
        }

        return var1.toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_825.method_4431(this, var1, var2);
    }
}
