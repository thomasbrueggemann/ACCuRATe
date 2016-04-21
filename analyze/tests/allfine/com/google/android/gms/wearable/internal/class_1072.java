package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.internal.ak;
import com.google.android.gms.wearable.internal.class_1071;

// $FF: renamed from: com.google.android.gms.wearable.internal.ak
public class class_1072 implements SafeParcelable, Node {
    public static final Creator<ak> CREATOR = new class_1071();
    // $FF: renamed from: BL java.lang.String
    private final String field_5096;
    // $FF: renamed from: BR int
    final int field_5097;
    // $FF: renamed from: NH java.lang.String
    private final String field_5098;

    class_1072(int var1, String var2, String var3) {
        this.field_5097 = var1;
        this.field_5096 = var2;
        this.field_5098 = var3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 instanceof class_1072) {
            class_1072 var2 = (class_1072)var1;
            if(var2.field_5096.equals(this.field_5096) && var2.field_5098.equals(this.field_5098)) {
                return true;
            }
        }

        return false;
    }

    public String getDisplayName() {
        return this.field_5098;
    }

    public String getId() {
        return this.field_5096;
    }

    public int hashCode() {
        return 37 * (629 + this.field_5096.hashCode()) + this.field_5098.hashCode();
    }

    public String toString() {
        return "NodeParcelable{" + this.field_5096 + "," + this.field_5098 + "}";
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1071.method_5592(this, var1, var2);
    }
}
