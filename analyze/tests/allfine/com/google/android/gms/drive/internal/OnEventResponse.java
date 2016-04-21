package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.class_1111;

public class OnEventResponse implements SafeParcelable {
    public static final Creator<OnEventResponse> CREATOR = new class_1111();
    // $FF: renamed from: BR int
    final int field_3150;
    // $FF: renamed from: Oa int
    final int field_3151;
    // $FF: renamed from: Ps com.google.android.gms.drive.events.ChangeEvent
    final ChangeEvent field_3152;
    // $FF: renamed from: Pt com.google.android.gms.drive.events.CompletionEvent
    final CompletionEvent field_3153;

    OnEventResponse(int var1, int var2, ChangeEvent var3, CompletionEvent var4) {
        this.field_3150 = var1;
        this.field_3151 = var2;
        this.field_3152 = var3;
        this.field_3153 = var4;
    }

    public int describeContents() {
        return 0;
    }

    // $FF: renamed from: ih () com.google.android.gms.drive.events.DriveEvent
    public DriveEvent method_3527() {
        switch(this.field_3151) {
            case 1:
                return this.field_3152;
            case 2:
                return this.field_3153;
            default:
                throw new IllegalStateException("Unexpected event type " + this.field_3151);
        }
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1111.method_5757(this, var1, var2);
    }
}
