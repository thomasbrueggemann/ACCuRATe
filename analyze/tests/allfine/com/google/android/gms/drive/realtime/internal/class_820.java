package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.realtime.internal.ParcelableCollaborator;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.p
public class class_820 implements Creator<ParcelableCollaborator> {
    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.ParcelableCollaborator, android.os.Parcel, int) void
    static void method_4255(ParcelableCollaborator var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4013);
        class_823.method_4316(var1, 2, var0.field_4015);
        class_823.method_4316(var1, 3, var0.field_4016);
        class_823.method_4313(var1, 4, var0.field_4020, false);
        class_823.method_4313(var1, 5, var0.field_4017, false);
        class_823.method_4313(var1, 6, var0.field_4014, false);
        class_823.method_4313(var1, 7, var0.field_4018, false);
        class_823.method_4313(var1, 8, var0.field_4019, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: aW (android.os.Parcel) com.google.android.gms.drive.realtime.internal.ParcelableCollaborator
    public ParcelableCollaborator method_4256(Parcel var1) {
        boolean var2 = false;
        String var3 = null;
        int var4 = class_824.method_4331(var1);
        String var5 = null;
        String var6 = null;
        String var7 = null;
        String var8 = null;
        boolean var9 = false;
        int var10 = 0;

        while(var1.dataPosition() < var4) {
            int var11 = class_824.method_4329(var1);
            switch(class_824.method_4340(var11)) {
                case 1:
                    var10 = class_824.method_4348(var1, var11);
                    break;
                case 2:
                    var9 = class_824.method_4344(var1, var11);
                    break;
                case 3:
                    var2 = class_824.method_4344(var1, var11);
                    break;
                case 4:
                    var8 = class_824.method_4356(var1, var11);
                    break;
                case 5:
                    var7 = class_824.method_4356(var1, var11);
                    break;
                case 6:
                    var6 = class_824.method_4356(var1, var11);
                    break;
                case 7:
                    var5 = class_824.method_4356(var1, var11);
                    break;
                case 8:
                    var3 = class_824.method_4356(var1, var11);
                    break;
                default:
                    class_824.method_4341(var1, var11);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new ParcelableCollaborator(var10, var9, var2, var8, var7, var6, var5, var3);
        }
    }

    // $FF: renamed from: cj (int) com.google.android.gms.drive.realtime.internal.ParcelableCollaborator[]
    public ParcelableCollaborator[] method_4257(int var1) {
        return new ParcelableCollaborator[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4256(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4257(var1);
    }
}
