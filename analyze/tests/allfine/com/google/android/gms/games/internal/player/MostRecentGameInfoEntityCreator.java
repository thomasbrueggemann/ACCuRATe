package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
    // $FF: renamed from: a (com.google.android.gms.games.internal.player.MostRecentGameInfoEntity, android.os.Parcel, int) void
    static void method_2629(MostRecentGameInfoEntity var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.method_196(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.method_197(), false);
        class_823.method_4305(var1, 3, var0.method_198());
        class_823.method_4309(var1, 4, var0.method_199(), var2, false);
        class_823.method_4309(var1, 5, var0.method_200(), var2, false);
        class_823.method_4309(var1, 6, var0.method_201(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cj (android.os.Parcel) com.google.android.gms.games.internal.player.MostRecentGameInfoEntity
    public MostRecentGameInfoEntity method_2630(Parcel var1) {
        Uri var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;
        long var5 = 0L;
        Uri var7 = null;
        Uri var8 = null;
        String var9 = null;
        String var10 = null;

        while(var1.dataPosition() < var3) {
            int var11 = class_824.method_4329(var1);
            switch(class_824.method_4340(var11)) {
                case 1:
                    var10 = class_824.method_4356(var1, var11);
                    break;
                case 2:
                    var9 = class_824.method_4356(var1, var11);
                    break;
                case 3:
                    var5 = class_824.method_4350(var1, var11);
                    break;
                case 4:
                    var8 = (Uri)class_824.method_4336(var1, var11, Uri.CREATOR);
                    break;
                case 5:
                    var7 = (Uri)class_824.method_4336(var1, var11, Uri.CREATOR);
                    break;
                case 6:
                    var2 = (Uri)class_824.method_4336(var1, var11, Uri.CREATOR);
                    break;
                case 1000:
                    var4 = class_824.method_4348(var1, var11);
                    break;
                default:
                    class_824.method_4341(var1, var11);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new MostRecentGameInfoEntity(var4, var10, var9, var5, var8, var7, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_2630(var1);
    }

    // $FF: renamed from: dP (int) com.google.android.gms.games.internal.player.MostRecentGameInfoEntity[]
    public MostRecentGameInfoEntity[] method_2631(int var1) {
        return new MostRecentGameInfoEntity[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_2631(var1);
    }
}
