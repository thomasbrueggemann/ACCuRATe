package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_404;

// $FF: renamed from: com.google.android.gms.internal.hg
public class class_411 implements SafeParcelable {
    public static final class_404 CREATOR = new class_404();
    // $FF: renamed from: BR int
    final int field_1527;
    // $FF: renamed from: BZ java.lang.String
    final String field_1528;
    // $FF: renamed from: Ca java.lang.String
    final String field_1529;
    // $FF: renamed from: Cb java.lang.String
    final String field_1530;

    class_411(int var1, String var2, String var3, String var4) {
        this.field_1527 = var1;
        this.field_1528 = var2;
        this.field_1529 = var3;
        this.field_1530 = var4;
    }

    public class_411(String var1, String var2, String var3) {
        this(1, var1, var2, var3);
    }

    public int describeContents() {
        class_404 var10000 = CREATOR;
        return 0;
    }

    public String toString() {
        Object[] var1 = new Object[] {this.field_1528, this.field_1529, this.field_1530};
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_404 var10000 = CREATOR;
        class_404.method_2636(this, var1, var2);
    }
}
