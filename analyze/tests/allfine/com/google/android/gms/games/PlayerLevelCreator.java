package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.games.PlayerLevel;

public class PlayerLevelCreator implements Creator<PlayerLevel> {
    public static final int CONTENT_DESCRIPTION;

    // $FF: renamed from: a (com.google.android.gms.games.PlayerLevel, android.os.Parcel, int) void
    static void method_4408(PlayerLevel var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getLevelNumber());
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4305(var1, 2, var0.getMinXp());
        class_823.method_4305(var1, 3, var0.getMaxXp());
        class_823.method_4301(var1, var3);
    }

    public PlayerLevel createFromParcel(Parcel var1) {
        long var2 = 0L;
        int var4 = 0;
        int var5 = class_824.method_4331(var1);
        long var6 = var2;
        int var8 = 0;

        while(var1.dataPosition() < var5) {
            int var9 = class_824.method_4329(var1);
            switch(class_824.method_4340(var9)) {
                case 1:
                    var4 = class_824.method_4348(var1, var9);
                    break;
                case 2:
                    var6 = class_824.method_4350(var1, var9);
                    break;
                case 3:
                    var2 = class_824.method_4350(var1, var9);
                    break;
                case 1000:
                    var8 = class_824.method_4348(var1, var9);
                    break;
                default:
                    class_824.method_4341(var1, var9);
            }
        }

        if(var1.dataPosition() != var5) {
            throw new class_824.class_1307("Overread allowed size end=" + var5, var1);
        } else {
            return new PlayerLevel(var8, var4, var6, var2);
        }
    }

    public PlayerLevel[] newArray(int var1) {
        return new PlayerLevel[var1];
    }
}
