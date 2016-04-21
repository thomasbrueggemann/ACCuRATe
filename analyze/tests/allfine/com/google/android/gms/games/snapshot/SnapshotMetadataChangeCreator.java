package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.class_1056;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

public class SnapshotMetadataChangeCreator implements Creator<SnapshotMetadataChange> {
    public static final int CONTENT_DESCRIPTION;

    // $FF: renamed from: a (com.google.android.gms.games.snapshot.SnapshotMetadataChange, android.os.Parcel, int) void
    static void method_5940(SnapshotMetadataChange var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.getDescription(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4312(var1, 2, var0.getPlayedTimeMillis(), false);
        class_823.method_4309(var1, 4, var0.getCoverImageUri(), var2, false);
        class_823.method_4309(var1, 5, var0.method_3260(), var2, false);
        class_823.method_4301(var1, var3);
    }

    public SnapshotMetadataChange createFromParcel(Parcel var1) {
        Uri var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        class_1056 var5 = null;
        Long var6 = null;
        String var7 = null;

        while(var1.dataPosition() < var3) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var7 = class_824.method_4356(var1, var8);
                    break;
                case 2:
                    var6 = class_824.method_4351(var1, var8);
                    break;
                case 4:
                    var2 = (Uri)class_824.method_4336(var1, var8, Uri.CREATOR);
                    break;
                case 5:
                    var5 = (class_1056)class_824.method_4336(var1, var8, class_1056.CREATOR);
                    break;
                case 1000:
                    var4 = class_824.method_4348(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new SnapshotMetadataChange(var4, var7, var6, var5, var2);
        }
    }

    public SnapshotMetadataChange[] newArray(int var1) {
        return new SnapshotMetadataChange[var1];
    }
}
