package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import com.google.android.gms.drive.realtime.internal.event.class_319;
import java.util.List;

public class ParcelableEventList implements SafeParcelable {
    public static final Creator<ParcelableEventList> CREATOR = new class_319();
    // $FF: renamed from: BR int
    final int field_3838;
    // $FF: renamed from: RE com.google.android.gms.common.data.DataHolder
    final DataHolder field_3839;
    // $FF: renamed from: RF boolean
    final boolean field_3840;
    // $FF: renamed from: RG java.util.List
    final List<String> field_3841;
    // $FF: renamed from: me java.util.List
    final List<ParcelableEvent> field_3842;

    ParcelableEventList(int var1, List<ParcelableEvent> var2, DataHolder var3, boolean var4, List<String> var5) {
        this.field_3838 = var1;
        this.field_3842 = var2;
        this.field_3839 = var3;
        this.field_3840 = var4;
        this.field_3841 = var5;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_319.method_2208(this, var1, var2);
    }
}
