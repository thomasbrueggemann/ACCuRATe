package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.game.ExtendedGameEntity;
import com.google.android.gms.games.internal.game.GameBadgeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public class ExtendedGameEntityCreator implements Creator<ExtendedGameEntity> {
    // $FF: renamed from: a (com.google.android.gms.games.internal.game.ExtendedGameEntity, android.os.Parcel, int) void
    static void method_5571(ExtendedGameEntity var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.method_3209(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4325(var1, 2, var0.method_211());
        class_823.method_4316(var1, 3, var0.method_212());
        class_823.method_4325(var1, 4, var0.method_213());
        class_823.method_4305(var1, 5, var0.method_214());
        class_823.method_4305(var1, 6, var0.method_215());
        class_823.method_4313(var1, 7, var0.method_216(), false);
        class_823.method_4305(var1, 8, var0.method_217());
        class_823.method_4313(var1, 9, var0.method_218(), false);
        class_823.method_4326(var1, 10, var0.method_210(), false);
        class_823.method_4309(var1, 11, var0.method_219(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cg (android.os.Parcel) com.google.android.gms.games.internal.game.ExtendedGameEntity
    public ExtendedGameEntity method_5572(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        GameEntity var4 = null;
        int var5 = 0;
        boolean var6 = false;
        int var7 = 0;
        long var8 = 0L;
        long var10 = 0L;
        String var12 = null;
        long var13 = 0L;
        String var15 = null;
        ArrayList var16 = null;
        SnapshotMetadataEntity var17 = null;

        while(var1.dataPosition() < var2) {
            int var18 = class_824.method_4329(var1);
            switch(class_824.method_4340(var18)) {
                case 1:
                    var4 = (GameEntity)class_824.method_4336(var1, var18, GameEntity.CREATOR);
                    break;
                case 2:
                    var5 = class_824.method_4348(var1, var18);
                    break;
                case 3:
                    var6 = class_824.method_4344(var1, var18);
                    break;
                case 4:
                    var7 = class_824.method_4348(var1, var18);
                    break;
                case 5:
                    var8 = class_824.method_4350(var1, var18);
                    break;
                case 6:
                    var10 = class_824.method_4350(var1, var18);
                    break;
                case 7:
                    var12 = class_824.method_4356(var1, var18);
                    break;
                case 8:
                    var13 = class_824.method_4350(var1, var18);
                    break;
                case 9:
                    var15 = class_824.method_4356(var1, var18);
                    break;
                case 10:
                    var16 = class_824.method_4343(var1, var18, GameBadgeEntity.CREATOR);
                    break;
                case 11:
                    var17 = (SnapshotMetadataEntity)class_824.method_4336(var1, var18, SnapshotMetadataEntity.CREATOR);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var18);
                    break;
                default:
                    class_824.method_4341(var1, var18);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new ExtendedGameEntity(var3, var4, var5, var6, var7, var8, var10, var12, var13, var15, var16, var17);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5572(var1);
    }

    // $FF: renamed from: dJ (int) com.google.android.gms.games.internal.game.ExtendedGameEntity[]
    public ExtendedGameEntity[] method_5573(int var1) {
        return new ExtendedGameEntity[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5573(var1);
    }
}
