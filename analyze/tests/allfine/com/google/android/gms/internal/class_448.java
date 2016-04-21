package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.class_223;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_446;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.gt;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.fi
@ez
public final class class_448 implements SafeParcelable {
    public static final class_446 CREATOR = new class_446();
    public final ApplicationInfo applicationInfo;
    // $FF: renamed from: lA java.lang.String
    public final String field_1711;
    // $FF: renamed from: lD com.google.android.gms.internal.gt
    public final class_379 field_1712;
    // $FF: renamed from: lH com.google.android.gms.internal.ay
    public final class_242 field_1713;
    // $FF: renamed from: lS java.util.List
    public final List<String> field_1714;
    // $FF: renamed from: tA java.lang.String
    public final String field_1715;
    // $FF: renamed from: tB java.lang.String
    public final String field_1716;
    // $FF: renamed from: tC android.os.Bundle
    public final Bundle field_1717;
    // $FF: renamed from: tD int
    public final int field_1718;
    // $FF: renamed from: tE android.os.Bundle
    public final Bundle field_1719;
    // $FF: renamed from: tF boolean
    public final boolean field_1720;
    // $FF: renamed from: tw android.os.Bundle
    public final Bundle field_1721;
    // $FF: renamed from: tx com.google.android.gms.internal.av
    public final class_223 field_1722;
    // $FF: renamed from: ty android.content.pm.PackageInfo
    public final PackageInfo field_1723;
    // $FF: renamed from: tz java.lang.String
    public final String field_1724;
    public final int versionCode;

    class_448(int var1, Bundle var2, av var3, ay var4, String var5, ApplicationInfo var6, PackageInfo var7, String var8, String var9, String var10, gt var11, Bundle var12, int var13, List<String> var14, Bundle var15, boolean var16) {
        this.versionCode = var1;
        this.field_1721 = var2;
        this.field_1722 = var3;
        this.field_1713 = var4;
        this.field_1711 = var5;
        this.applicationInfo = var6;
        this.field_1723 = var7;
        this.field_1724 = var8;
        this.field_1715 = var9;
        this.field_1716 = var10;
        this.field_1712 = var11;
        this.field_1717 = var12;
        this.field_1718 = var13;
        this.field_1714 = var14;
        this.field_1719 = var15;
        this.field_1720 = var16;
    }

    public class_448(Bundle var1, av var2, ay var3, String var4, ApplicationInfo var5, PackageInfo var6, String var7, String var8, String var9, gt var10, Bundle var11, int var12, List<String> var13, Bundle var14, boolean var15) {
        this(4, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
    }

    public class_448(class_448.class_1629 var1, String var2) {
        this(var1.field_4973, var1.field_4974, var1.field_4965, var1.field_4963, var1.applicationInfo, var1.field_4975, var2, var1.field_4967, var1.field_4968, var1.field_4964, var1.field_4969, var1.field_4970, var1.field_4966, var1.field_4971, var1.field_4972);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_446.method_2801(this, var1, var2);
    }

    @ez
    public static final class class_1629 {
        public final ApplicationInfo applicationInfo;
        // $FF: renamed from: lA java.lang.String
        public final String field_4963;
        // $FF: renamed from: lD com.google.android.gms.internal.gt
        public final class_379 field_4964;
        // $FF: renamed from: lH com.google.android.gms.internal.ay
        public final class_242 field_4965;
        // $FF: renamed from: lS java.util.List
        public final List<String> field_4966;
        // $FF: renamed from: tA java.lang.String
        public final String field_4967;
        // $FF: renamed from: tB java.lang.String
        public final String field_4968;
        // $FF: renamed from: tC android.os.Bundle
        public final Bundle field_4969;
        // $FF: renamed from: tD int
        public final int field_4970;
        // $FF: renamed from: tE android.os.Bundle
        public final Bundle field_4971;
        // $FF: renamed from: tF boolean
        public final boolean field_4972;
        // $FF: renamed from: tw android.os.Bundle
        public final Bundle field_4973;
        // $FF: renamed from: tx com.google.android.gms.internal.av
        public final class_223 field_4974;
        // $FF: renamed from: ty android.content.pm.PackageInfo
        public final PackageInfo field_4975;

        public class_1629(Bundle var1, av var2, ay var3, String var4, ApplicationInfo var5, PackageInfo var6, String var7, String var8, gt var9, Bundle var10, List<String> var11, Bundle var12, boolean var13) {
            this.field_4973 = var1;
            this.field_4974 = var2;
            this.field_4965 = var3;
            this.field_4963 = var4;
            this.applicationInfo = var5;
            this.field_4975 = var6;
            this.field_4967 = var7;
            this.field_4968 = var8;
            this.field_4964 = var9;
            this.field_4969 = var10;
            this.field_4972 = var13;
            if(var11 != null && var11.size() > 0) {
                this.field_4970 = 2;
                this.field_4966 = var11;
            } else {
                this.field_4970 = 0;
                this.field_4966 = null;
            }

            this.field_4971 = var12;
        }
    }
}
