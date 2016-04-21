package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_398;
import com.google.android.gms.internal.class_399;
import com.google.android.gms.internal.class_402;

// $FF: renamed from: com.google.android.gms.internal.hi
public class class_403 implements SafeParcelable {
    public static final class_402 CREATOR = new class_402();
    // $FF: renamed from: Cc int
    public static final int field_1498 = Integer.parseInt("-1");
    // $FF: renamed from: Cd com.google.android.gms.internal.hq
    private static final class_399 field_1499 = (new class_399.class_1737("SsbContext")).method_4919(true).method_4922("blob").method_4924();
    // $FF: renamed from: BR int
    final int field_1500;
    // $FF: renamed from: Ce java.lang.String
    public final String field_1501;
    // $FF: renamed from: Cf com.google.android.gms.internal.hq
    final class_399 field_1502;
    // $FF: renamed from: Cg int
    public final int field_1503;
    // $FF: renamed from: Ch byte[]
    public final byte[] field_1504;

    class_403(int var1, String var2, class_399 var3, int var4, byte[] var5) {
        boolean var6;
        if(var4 != field_1498 && class_398.method_2623(var4) == null) {
            var6 = false;
        } else {
            var6 = true;
        }

        class_1090.method_5683(var6, "Invalid section type " + var4);
        this.field_1500 = var1;
        this.field_1501 = var2;
        this.field_1502 = var3;
        this.field_1503 = var4;
        this.field_1504 = var5;
        String var7 = this.method_2635();
        if(var7 != null) {
            throw new IllegalArgumentException(var7);
        }
    }

    public class_403(String var1, class_399 var2) {
        this(1, var1, var2, field_1498, (byte[])null);
    }

    public class_403(String var1, class_399 var2, String var3) {
        this(1, var1, var2, class_398.method_2624(var3), (byte[])null);
    }

    public class_403(byte[] var1, class_399 var2) {
        this(1, (String)null, var2, field_1498, var1);
    }

    public int describeContents() {
        class_402 var10000 = CREATOR;
        return 0;
    }

    // $FF: renamed from: fk () java.lang.String
    public String method_2635() {
        return this.field_1503 != field_1498 && class_398.method_2623(this.field_1503) == null?"Invalid section type " + this.field_1503:(this.field_1501 != null && this.field_1504 != null?"Both content and blobContent set":null);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_402 var10000 = CREATOR;
        class_402.method_2632(this, var1, var2);
    }
}
