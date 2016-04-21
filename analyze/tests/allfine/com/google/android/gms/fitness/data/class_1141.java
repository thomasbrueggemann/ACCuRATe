package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.a;
import com.google.android.gms.fitness.data.class_1139;
import com.google.android.gms.internal.class_848;

// $FF: renamed from: com.google.android.gms.fitness.data.a
public final class class_1141 implements SafeParcelable {
    public static final Creator<a> CREATOR = new class_1139();
    // $FF: renamed from: Sw com.google.android.gms.fitness.data.a
    public static final class_1141 field_5248 = new class_1141("com.google.android.gms", String.valueOf(6171000), (String)null);
    // $FF: renamed from: BR int
    private final int field_5249;
    // $FF: renamed from: BZ java.lang.String
    private final String field_5250;
    // $FF: renamed from: Sx java.lang.String
    private final String field_5251;
    // $FF: renamed from: Sy java.lang.String
    private final String field_5252;

    class_1141(int var1, String var2, String var3, String var4) {
        this.field_5249 = var1;
        this.field_5250 = (String)class_1090.method_5685(var2);
        this.field_5251 = "";
        this.field_5252 = var4;
    }

    public class_1141(String var1, String var2, String var3) {
        this(1, var1, "", var3);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.a) boolean
    private boolean method_5912(class_1141 var1) {
        return this.field_5250.equals(var1.field_5250) && class_1089.equal(this.field_5251, var1.field_5251) && class_1089.equal(this.field_5252, var1.field_5252);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof class_1141 && this.method_5912((class_1141)var1);
    }

    public String getPackageName() {
        return this.field_5250;
    }

    public String getVersion() {
        return this.field_5251;
    }

    int getVersionCode() {
        return this.field_5249;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_5250, this.field_5251, this.field_5252};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: iA () com.google.android.gms.fitness.data.a
    class_1141 method_5913() {
        return new class_1141(class_848.method_4469(this.field_5250), class_848.method_4469(this.field_5251), class_848.method_4469(this.field_5252));
    }

    // $FF: renamed from: iz () java.lang.String
    public String method_5914() {
        return this.field_5252;
    }

    public String toString() {
        Object[] var1 = new Object[] {this.field_5250, this.field_5251, this.field_5252};
        return String.format("Application{%s:%s:%s}", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1139.method_5906(this, var1, var2);
    }
}
