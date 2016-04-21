package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_895;
import com.google.android.gms.internal.mp;
import com.google.android.gms.internal.mt;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.mj
public final class class_898 implements SafeParcelable {
    public static final class_895 CREATOR = new class_895();
    // $FF: renamed from: BR int
    final int field_4214;
    final List<mp> afr;
    private final String afs;
    private final boolean aft;
    final List<mt> afu;
    final List<String> afv;
    private final Set<mp> afw;
    private final Set<mt> afx;
    private final Set<String> afy;

    class_898(int var1, List<mp> var2, String var3, boolean var4, List<mt> var5, List<String> var6) {
        this.field_4214 = var1;
        List var7;
        if(var2 == null) {
            var7 = Collections.emptyList();
        } else {
            var7 = Collections.unmodifiableList(var2);
        }

        this.afr = var7;
        if(var3 == null) {
            var3 = "";
        }

        this.afs = var3;
        this.aft = var4;
        List var8;
        if(var5 == null) {
            var8 = Collections.emptyList();
        } else {
            var8 = Collections.unmodifiableList(var5);
        }

        this.afu = var8;
        List var9;
        if(var6 == null) {
            var9 = Collections.emptyList();
        } else {
            var9 = Collections.unmodifiableList(var6);
        }

        this.afv = var9;
        this.afw = method_4594(this.afr);
        this.afx = method_4594(this.afu);
        this.afy = method_4594(this.afv);
    }

    // $FF: renamed from: f (java.util.List) java.util.Set
    private static <E> Set<E> method_4594(List<E> var0) {
        return var0.isEmpty()?Collections.emptySet():Collections.unmodifiableSet(new HashSet(var0));
    }

    public int describeContents() {
        class_895 var10000 = CREATOR;
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(!(var1 instanceof class_898)) {
                return false;
            }

            class_898 var2 = (class_898)var1;
            if(!this.afw.equals(var2.afw) || this.aft != var2.aft || !this.afx.equals(var2.afx) || !this.afy.equals(var2.afy)) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.afw, Boolean.valueOf(this.aft), this.afx, this.afy};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: mi () java.lang.String
    @Deprecated
    public String method_4595() {
        return this.afs;
    }

    // $FF: renamed from: mj () boolean
    public boolean method_4596() {
        return this.aft;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("types", this.afw).method_5425("placeIds", this.afy).method_5425("requireOpenNow", Boolean.valueOf(this.aft)).method_5425("requestedUserDataTypes", this.afx).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_895 var10000 = CREATOR;
        class_895.method_4587(this, var1, var2);
    }
}
