package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.c
public class class_319 implements Creator<ParcelableEventList> {
    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ParcelableEventList, android.os.Parcel, int) void
    static void method_2208(ParcelableEventList var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_3838);
        class_823.method_4326(var1, 2, var0.field_3842, false);
        class_823.method_4309(var1, 3, var0.field_3839, var2, false);
        class_823.method_4316(var1, 4, var0.field_3840);
        class_823.method_4324(var1, 5, var0.field_3841, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: ba (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ParcelableEventList
    public ParcelableEventList method_2209(Parcel var1) {
        boolean var2 = false;
        ArrayList var3 = null;
        int var4 = class_824.method_4331(var1);
        DataHolder var5 = null;
        ArrayList var6 = null;
        int var7 = 0;

        while(var1.dataPosition() < var4) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var7 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var6 = class_824.method_4343(var1, var8, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    var5 = (DataHolder)class_824.method_4336(var1, var8, DataHolder.CREATOR);
                    break;
                case 4:
                    var2 = class_824.method_4344(var1, var8);
                    break;
                case 5:
                    var3 = class_824.method_4332(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new ParcelableEventList(var7, var6, var5, var2, var3);
        }
    }

    // $FF: renamed from: cn (int) com.google.android.gms.drive.realtime.internal.event.ParcelableEventList[]
    public ParcelableEventList[] method_2210(int var1) {
        return new ParcelableEventList[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2209(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2210(var1);
    }
}
