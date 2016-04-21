package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    public static final int CONTENT_DESCRIPTION;

    // $FF: renamed from: a (com.google.android.gms.games.request.GameRequestEntity, android.os.Parcel, int) void
    static void method_3006(GameRequestEntity var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.getGame(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.getSender(), var2, false);
        class_823.method_4317(var1, 3, var0.getData(), false);
        class_823.method_4313(var1, 4, var0.getRequestId(), false);
        class_823.method_4326(var1, 5, var0.getRecipients(), false);
        class_823.method_4325(var1, 7, var0.getType());
        class_823.method_4305(var1, 9, var0.getCreationTimestamp());
        class_823.method_4305(var1, 10, var0.getExpirationTimestamp());
        class_823.method_4306(var1, 11, var0.method_4029(), false);
        class_823.method_4325(var1, 12, var0.getStatus());
        class_823.method_4301(var1, var3);
    }

    public GameRequestEntity createFromParcel(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        GameEntity var4 = null;
        PlayerEntity var5 = null;
        byte[] var6 = null;
        String var7 = null;
        ArrayList var8 = null;
        int var9 = 0;
        long var10 = 0L;
        long var12 = 0L;
        Bundle var14 = null;
        int var15 = 0;

        while(var1.dataPosition() < var2) {
            int var16 = class_824.method_4329(var1);
            switch(class_824.method_4340(var16)) {
                case 1:
                    var4 = (GameEntity)class_824.method_4336(var1, var16, GameEntity.CREATOR);
                    break;
                case 2:
                    var5 = (PlayerEntity)class_824.method_4336(var1, var16, PlayerEntity.CREATOR);
                    break;
                case 3:
                    var6 = class_824.method_4359(var1, var16);
                    break;
                case 4:
                    var7 = class_824.method_4356(var1, var16);
                    break;
                case 5:
                    var8 = class_824.method_4343(var1, var16, PlayerEntity.CREATOR);
                    break;
                case 7:
                    var9 = class_824.method_4348(var1, var16);
                    break;
                case 9:
                    var10 = class_824.method_4350(var1, var16);
                    break;
                case 10:
                    var12 = class_824.method_4350(var1, var16);
                    break;
                case 11:
                    var14 = class_824.method_4358(var1, var16);
                    break;
                case 12:
                    var15 = class_824.method_4348(var1, var16);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var16);
                    break;
                default:
                    class_824.method_4341(var1, var16);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new GameRequestEntity(var3, var4, var5, var6, var7, var8, var9, var10, var12, var14, var15);
        }
    }

    public GameRequestEntity[] newArray(int var1) {
        return new GameRequestEntity[var1];
    }
}
