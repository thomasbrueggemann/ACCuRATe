package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
    // $FF: renamed from: a (com.google.android.gms.games.PlayerEntity, android.os.Parcel, int) void
    static void method_3888(PlayerEntity var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.getPlayerId(), false);
        class_823.method_4313(var1, 2, var0.getDisplayName(), false);
        class_823.method_4309(var1, 3, var0.getIconImageUri(), var2, false);
        class_823.method_4309(var1, 4, var0.getHiResImageUri(), var2, false);
        class_823.method_4305(var1, 5, var0.getRetrievedTimestamp());
        class_823.method_4325(var1, 6, var0.method_202());
        class_823.method_4305(var1, 7, var0.getLastPlayedWithTimestamp());
        class_823.method_4313(var1, 8, var0.getIconImageUrl(), false);
        class_823.method_4313(var1, 9, var0.getHiResImageUrl(), false);
        class_823.method_4313(var1, 14, var0.getTitle(), false);
        class_823.method_4309(var1, 15, var0.method_203(), var2, false);
        class_823.method_4309(var1, 16, var0.getLevelInfo(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4316(var1, 18, var0.isProfileVisible());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: ce (android.os.Parcel) com.google.android.gms.games.PlayerEntity
    public PlayerEntity method_3889(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        String var4 = null;
        String var5 = null;
        Uri var6 = null;
        Uri var7 = null;
        long var8 = 0L;
        int var10 = 0;
        long var11 = 0L;
        String var13 = null;
        String var14 = null;
        String var15 = null;
        MostRecentGameInfoEntity var16 = null;
        PlayerLevelInfo var17 = null;
        boolean var18 = false;

        while(var1.dataPosition() < var2) {
            int var19 = class_824.method_4329(var1);
            switch(class_824.method_4340(var19)) {
                case 1:
                    var4 = class_824.method_4356(var1, var19);
                    break;
                case 2:
                    var5 = class_824.method_4356(var1, var19);
                    break;
                case 3:
                    var6 = (Uri)class_824.method_4336(var1, var19, Uri.CREATOR);
                    break;
                case 4:
                    var7 = (Uri)class_824.method_4336(var1, var19, Uri.CREATOR);
                    break;
                case 5:
                    var8 = class_824.method_4350(var1, var19);
                    break;
                case 6:
                    var10 = class_824.method_4348(var1, var19);
                    break;
                case 7:
                    var11 = class_824.method_4350(var1, var19);
                    break;
                case 8:
                    var13 = class_824.method_4356(var1, var19);
                    break;
                case 9:
                    var14 = class_824.method_4356(var1, var19);
                    break;
                case 14:
                    var15 = class_824.method_4356(var1, var19);
                    break;
                case 15:
                    var16 = (MostRecentGameInfoEntity)class_824.method_4336(var1, var19, MostRecentGameInfoEntity.CREATOR);
                    break;
                case 16:
                    var17 = (PlayerLevelInfo)class_824.method_4336(var1, var19, PlayerLevelInfo.CREATOR);
                    break;
                case 18:
                    var18 = class_824.method_4344(var1, var19);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var19);
                    break;
                default:
                    class_824.method_4341(var1, var19);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new PlayerEntity(var3, var4, var5, var6, var7, var8, var10, var11, var13, var14, var15, var16, var17, var18);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3889(var1);
    }

    // $FF: renamed from: dw (int) com.google.android.gms.games.PlayerEntity[]
    public PlayerEntity[] method_3890(int var1) {
        return new PlayerEntity[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3890(var1);
    }
}
