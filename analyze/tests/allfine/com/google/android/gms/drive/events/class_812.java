package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.events.b
public class class_812 implements Creator<CompletionEvent> {
    // $FF: renamed from: a (com.google.android.gms.drive.events.CompletionEvent, android.os.Parcel, int) void
    static void method_4209(CompletionEvent var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_706);
        class_823.method_4309(var1, 2, var0.field_709, var2, false);
        class_823.method_4313(var1, 3, var0.field_707, false);
        class_823.method_4309(var1, 4, var0.field_710, var2, false);
        class_823.method_4309(var1, 5, var0.field_711, var2, false);
        class_823.method_4309(var1, 6, var0.field_712, var2, false);
        class_823.method_4324(var1, 7, var0.field_713, false);
        class_823.method_4325(var1, 8, var0.field_708);
        class_823.method_4307(var1, 9, var0.field_714, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: U (android.os.Parcel) com.google.android.gms.drive.events.CompletionEvent
    public CompletionEvent method_4210(Parcel var1) {
        int var2 = 0;
        IBinder var3 = null;
        int var4 = class_824.method_4331(var1);
        ArrayList var5 = null;
        MetadataBundle var6 = null;
        ParcelFileDescriptor var7 = null;
        ParcelFileDescriptor var8 = null;
        String var9 = null;
        DriveId var10 = null;
        int var11 = 0;

        while(var1.dataPosition() < var4) {
            int var12 = class_824.method_4329(var1);
            switch(class_824.method_4340(var12)) {
                case 1:
                    var11 = class_824.method_4348(var1, var12);
                    break;
                case 2:
                    var10 = (DriveId)class_824.method_4336(var1, var12, DriveId.CREATOR);
                    break;
                case 3:
                    var9 = class_824.method_4356(var1, var12);
                    break;
                case 4:
                    var8 = (ParcelFileDescriptor)class_824.method_4336(var1, var12, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    var7 = (ParcelFileDescriptor)class_824.method_4336(var1, var12, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    var6 = (MetadataBundle)class_824.method_4336(var1, var12, MetadataBundle.CREATOR);
                    break;
                case 7:
                    var5 = class_824.method_4332(var1, var12);
                    break;
                case 8:
                    var2 = class_824.method_4348(var1, var12);
                    break;
                case 9:
                    var3 = class_824.method_4357(var1, var12);
                    break;
                default:
                    class_824.method_4341(var1, var12);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new CompletionEvent(var11, var10, var9, var8, var7, var6, var5, var2, var3);
        }
    }

    // $FF: renamed from: bb (int) com.google.android.gms.drive.events.CompletionEvent[]
    public CompletionEvent[] method_4211(int var1) {
        return new CompletionEvent[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4210(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4211(var1);
    }
}
