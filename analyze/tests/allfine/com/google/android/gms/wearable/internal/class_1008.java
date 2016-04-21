package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.b;
import com.google.android.gms.wearable.internal.class_1009;
import com.google.android.gms.wearable.internal.class_190;
import com.google.android.gms.wearable.internal.class_549;

// $FF: renamed from: com.google.android.gms.wearable.internal.b
public class class_1008 implements SafeParcelable {
    public static final Creator<b> CREATOR = new class_1009();
    // $FF: renamed from: BR int
    final int field_4596;
    public final class_190 avk;
    public final IntentFilter[] avl;

    class_1008(int var1, IBinder var2, IntentFilter[] var3) {
        this.field_4596 = var1;
        if(var2 != null) {
            this.avk = class_190.class_1376.method_3368(var2);
        } else {
            this.avk = null;
        }

        this.avl = var3;
    }

    public class_1008(class_549 var1) {
        this.field_4596 = 1;
        this.avk = var1;
        this.avl = var1.method_3372();
    }

    public int describeContents() {
        return 0;
    }

    // $FF: renamed from: pV () android.os.IBinder
    IBinder method_5247() {
        return this.avk == null?null:this.avk.asBinder();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1009.method_5248(this, var1, var2);
    }
}
