package com.google.android.gms.internal;

import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.cl;
import com.google.android.gms.internal.class_223;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_248;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_41;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.class_448;
import com.google.android.gms.internal.class_450;
import com.google.android.gms.internal.class_452;
import com.google.android.gms.internal.class_454;
import com.google.android.gms.internal.cm;
import com.google.android.gms.internal.co;
import com.google.android.gms.internal.cu;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.gv;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.fz
@ez
public final class class_438 {
    public final int errorCode;
    public final int orientation;
    // $FF: renamed from: qA java.lang.String
    public final String field_1626;
    // $FF: renamed from: qB com.google.android.gms.internal.co
    public final class_454 field_1627;
    // $FF: renamed from: qf java.util.List
    public final List<String> field_1628;
    // $FF: renamed from: qg java.util.List
    public final List<String> field_1629;
    // $FF: renamed from: qj long
    public final long field_1630;
    // $FF: renamed from: qy com.google.android.gms.internal.cl
    public final class_450 field_1631;
    // $FF: renamed from: qz com.google.android.gms.internal.cu
    public final class_41 field_1632;
    // $FF: renamed from: rN com.google.android.gms.internal.gv
    public final class_381 field_1633;
    // $FF: renamed from: tA java.lang.String
    public final String field_1634;
    // $FF: renamed from: tH long
    public final long field_1635;
    // $FF: renamed from: tI boolean
    public final boolean field_1636;
    // $FF: renamed from: tJ long
    public final long field_1637;
    // $FF: renamed from: tK java.util.List
    public final List<String> field_1638;
    // $FF: renamed from: tN java.lang.String
    public final String field_1639;
    // $FF: renamed from: tx com.google.android.gms.internal.av
    public final class_223 field_1640;
    // $FF: renamed from: vp org.json.JSONObject
    public final JSONObject field_1641;
    // $FF: renamed from: vq com.google.android.gms.internal.cm
    public final class_452 field_1642;
    // $FF: renamed from: vr com.google.android.gms.internal.ay
    public final class_242 field_1643;
    // $FF: renamed from: vs long
    public final long field_1644;
    // $FF: renamed from: vt long
    public final long field_1645;
    // $FF: renamed from: vu com.google.android.gms.internal.bq$a
    public final class_248.class_1288 field_1646;

    public class_438(av var1, gv var2, List<String> var3, int var4, List<String> var5, List<String> var6, int var7, long var8, String var10, boolean var11, cl var12, cu var13, String var14, cm var15, co var16, long var17, ay var19, long var20, long var22, long var24, String var26, JSONObject var27, class_248.class_1288 var28) {
        this.field_1640 = var1;
        this.field_1633 = var2;
        List var29;
        if(var3 != null) {
            var29 = Collections.unmodifiableList(var3);
        } else {
            var29 = null;
        }

        this.field_1628 = var29;
        this.errorCode = var4;
        List var30;
        if(var5 != null) {
            var30 = Collections.unmodifiableList(var5);
        } else {
            var30 = null;
        }

        this.field_1629 = var30;
        List var31;
        if(var6 != null) {
            var31 = Collections.unmodifiableList(var6);
        } else {
            var31 = null;
        }

        this.field_1638 = var31;
        this.orientation = var7;
        this.field_1630 = var8;
        this.field_1634 = var10;
        this.field_1636 = var11;
        this.field_1631 = var12;
        this.field_1632 = var13;
        this.field_1626 = var14;
        this.field_1642 = var15;
        this.field_1627 = var16;
        this.field_1637 = var17;
        this.field_1643 = var19;
        this.field_1635 = var20;
        this.field_1644 = var22;
        this.field_1645 = var24;
        this.field_1639 = var26;
        this.field_1641 = var27;
        this.field_1646 = var28;
    }

    public class_438(class_438.class_1623 var1, class_381 var2, class_450 var3, class_41 var4, String var5, class_454 var6, class_248.class_1288 var7) {
        this(var1.field_5209.field_1722, var2, var1.field_5210.field_1692, var1.errorCode, var1.field_5210.field_1693, var1.field_5210.field_1701, var1.field_5210.orientation, var1.field_5210.field_1694, var1.field_5209.field_1715, var1.field_5210.field_1699, var3, var4, var5, var1.field_5206, var6, var1.field_5210.field_1700, var1.field_5204, var1.field_5210.field_1698, var1.field_5207, var1.field_5208, var1.field_5210.field_1704, var1.field_5205, var7);
    }

    @ez
    public static final class class_1623 {
        public final int errorCode;
        // $FF: renamed from: lH com.google.android.gms.internal.ay
        public final class_242 field_5204;
        // $FF: renamed from: vp org.json.JSONObject
        public final JSONObject field_5205;
        // $FF: renamed from: vq com.google.android.gms.internal.cm
        public final class_452 field_5206;
        // $FF: renamed from: vs long
        public final long field_5207;
        // $FF: renamed from: vt long
        public final long field_5208;
        // $FF: renamed from: vv com.google.android.gms.internal.fi
        public final class_448 field_5209;
        // $FF: renamed from: vw com.google.android.gms.internal.fk
        public final class_447 field_5210;

        public class_1623(class_448 var1, class_447 var2, class_452 var3, class_242 var4, int var5, long var6, long var8, JSONObject var10) {
            this.field_5209 = var1;
            this.field_5210 = var2;
            this.field_5206 = var3;
            this.field_5204 = var4;
            this.errorCode = var5;
            this.field_5207 = var6;
            this.field_5208 = var8;
            this.field_5205 = var10;
        }
    }
}
