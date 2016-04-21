package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.ez;
import java.util.Collections;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.fk
@ez
public final class class_447 implements SafeParcelable {
    public static final class_445 CREATOR = new class_445();
    public final int errorCode;
    public final int orientation;
    // $FF: renamed from: qf java.util.List
    public final List<String> field_1692;
    // $FF: renamed from: qg java.util.List
    public final List<String> field_1693;
    // $FF: renamed from: qj long
    public final long field_1694;
    // $FF: renamed from: rP java.lang.String
    public final String field_1695;
    // $FF: renamed from: tF boolean
    public final boolean field_1696;
    // $FF: renamed from: tG java.lang.String
    public final String field_1697;
    // $FF: renamed from: tH long
    public final long field_1698;
    // $FF: renamed from: tI boolean
    public final boolean field_1699;
    // $FF: renamed from: tJ long
    public final long field_1700;
    // $FF: renamed from: tK java.util.List
    public final List<String> field_1701;
    // $FF: renamed from: tL java.lang.String
    public final String field_1702;
    // $FF: renamed from: tM long
    public final long field_1703;
    // $FF: renamed from: tN java.lang.String
    public final String field_1704;
    // $FF: renamed from: tO boolean
    public final boolean field_1705;
    // $FF: renamed from: tP java.lang.String
    public final String field_1706;
    // $FF: renamed from: tQ java.lang.String
    public final String field_1707;
    // $FF: renamed from: tR boolean
    public final boolean field_1708;
    // $FF: renamed from: tS boolean
    public final boolean field_1709;
    // $FF: renamed from: tT boolean
    public final boolean field_1710;
    public final int versionCode;

    public class_447(int var1) {
        this(10, (String)null, (String)null, (List)null, var1, (List)null, -1L, false, -1L, (List)null, -1L, -1, (String)null, -1L, (String)null, false, (String)null, (String)null, false, false, false, false);
    }

    public class_447(int var1, long var2) {
        this(10, (String)null, (String)null, (List)null, var1, (List)null, -1L, false, -1L, (List)null, var2, -1, (String)null, -1L, (String)null, false, (String)null, (String)null, false, false, false, false);
    }

    class_447(int var1, String var2, String var3, List<String> var4, int var5, List<String> var6, long var7, boolean var9, long var10, List<String> var12, long var13, int var15, String var16, long var17, String var19, boolean var20, String var21, String var22, boolean var23, boolean var24, boolean var25, boolean var26) {
        this.versionCode = var1;
        this.field_1695 = var2;
        this.field_1697 = var3;
        List var27;
        if(var4 != null) {
            var27 = Collections.unmodifiableList(var4);
        } else {
            var27 = null;
        }

        this.field_1692 = var27;
        this.errorCode = var5;
        List var28;
        if(var6 != null) {
            var28 = Collections.unmodifiableList(var6);
        } else {
            var28 = null;
        }

        this.field_1693 = var28;
        this.field_1698 = var7;
        this.field_1699 = var9;
        this.field_1700 = var10;
        List var29;
        if(var12 != null) {
            var29 = Collections.unmodifiableList(var12);
        } else {
            var29 = null;
        }

        this.field_1701 = var29;
        this.field_1694 = var13;
        this.orientation = var15;
        this.field_1702 = var16;
        this.field_1703 = var17;
        this.field_1704 = var19;
        this.field_1705 = var20;
        this.field_1706 = var21;
        this.field_1707 = var22;
        this.field_1708 = var23;
        this.field_1709 = var24;
        this.field_1696 = var25;
        this.field_1710 = var26;
    }

    public class_447(String var1, String var2, List<String> var3, List<String> var4, long var5, boolean var7, long var8, List<String> var10, long var11, int var13, String var14, long var15, String var17, String var18, boolean var19, boolean var20, boolean var21, boolean var22) {
        this(10, var1, var2, var3, -2, var4, var5, var7, var8, var10, var11, var13, var14, var15, var17, false, (String)null, var18, var19, var20, var21, var22);
    }

    public class_447(String var1, String var2, List<String> var3, List<String> var4, long var5, boolean var7, long var8, List<String> var10, long var11, int var13, String var14, long var15, String var17, boolean var18, String var19, String var20, boolean var21, boolean var22, boolean var23, boolean var24) {
        this(10, var1, var2, var3, -2, var4, var5, var7, var8, var10, var11, var13, var14, var15, var17, var18, var19, var20, var21, var22, var23, var24);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_445.method_2798(this, var1, var2);
    }
}
