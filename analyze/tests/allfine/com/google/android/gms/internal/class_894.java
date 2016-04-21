package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_892;
import com.google.android.gms.internal.mp;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.mf
public class class_894 implements SafeParcelable {
    public static final class_892 CREATOR = new class_892();
    // $FF: renamed from: BR int
    final int field_4212;
    private final boolean afn;
    private final List<mp> afo;

    class_894(int var1, boolean var2, List<mp> var3) {
        this.field_4212 = var1;
        this.afn = var2;
        this.afo = var3;
    }

    public int describeContents() {
        class_892 var10000 = CREATOR;
        return 0;
    }

    // $FF: renamed from: me () boolean
    public boolean method_4585() {
        return this.afn;
    }

    // $FF: renamed from: mf () java.util.List
    public List<mp> method_4586() {
        return this.afo;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_892 var10000 = CREATOR;
        class_892.method_4579(this, var1, var2);
    }
}
