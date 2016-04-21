package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.aq;
import com.google.android.gms.wearable.internal.class_1069;
import com.google.android.gms.wearable.internal.class_190;

// $FF: renamed from: com.google.android.gms.wearable.internal.aq
public class class_1070 implements SafeParcelable {
    public static final Creator<aq> CREATOR = new class_1069();
    // $FF: renamed from: BR int
    final int field_5095;
    public final class_190 avk;

    class_1070(int var1, IBinder var2) {
        this.field_5095 = var1;
        if(var2 != null) {
            this.avk = class_190.class_1376.method_3368(var2);
        } else {
            this.avk = null;
        }
    }

    public class_1070(class_190 var1) {
        this.field_5095 = 1;
        this.avk = var1;
    }

    public int describeContents() {
        return 0;
    }

    // $FF: renamed from: pV () android.os.IBinder
    IBinder method_5591() {
        return this.avk == null?null:this.avk.asBinder();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1069.method_5588(this, var1, var2);
    }
}
