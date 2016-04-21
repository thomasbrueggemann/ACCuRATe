package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import java.util.ArrayList;

public class RoomEntityCreator implements Creator<RoomEntity> {
    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomEntity, android.os.Parcel, int) void
    static void method_4074(RoomEntity var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.getRoomId(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.getCreatorId(), false);
        class_823.method_4305(var1, 3, var0.getCreationTimestamp());
        class_823.method_4325(var1, 4, var0.getStatus());
        class_823.method_4313(var1, 5, var0.getDescription(), false);
        class_823.method_4325(var1, 6, var0.getVariant());
        class_823.method_4306(var1, 7, var0.getAutoMatchCriteria(), false);
        class_823.method_4326(var1, 8, var0.getParticipants(), false);
        class_823.method_4325(var1, 9, var0.getAutoMatchWaitEstimateSeconds());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: co (android.os.Parcel) com.google.android.gms.games.multiplayer.realtime.RoomEntity
    public RoomEntity method_4075(Parcel var1) {
        int var2 = 0;
        ArrayList var3 = null;
        int var4 = class_824.method_4331(var1);
        long var5 = 0L;
        Bundle var7 = null;
        int var8 = 0;
        String var9 = null;
        int var10 = 0;
        String var11 = null;
        String var12 = null;
        int var13 = 0;

        while(var1.dataPosition() < var4) {
            int var14 = class_824.method_4329(var1);
            switch(class_824.method_4340(var14)) {
                case 1:
                    var12 = class_824.method_4356(var1, var14);
                    break;
                case 2:
                    var11 = class_824.method_4356(var1, var14);
                    break;
                case 3:
                    var5 = class_824.method_4350(var1, var14);
                    break;
                case 4:
                    var10 = class_824.method_4348(var1, var14);
                    break;
                case 5:
                    var9 = class_824.method_4356(var1, var14);
                    break;
                case 6:
                    var8 = class_824.method_4348(var1, var14);
                    break;
                case 7:
                    var7 = class_824.method_4358(var1, var14);
                    break;
                case 8:
                    var3 = class_824.method_4343(var1, var14, ParticipantEntity.CREATOR);
                    break;
                case 9:
                    var2 = class_824.method_4348(var1, var14);
                    break;
                case 1000:
                    var13 = class_824.method_4348(var1, var14);
                    break;
                default:
                    class_824.method_4341(var1, var14);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new RoomEntity(var13, var12, var11, var5, var10, var9, var8, var7, var3, var2);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4075(var1);
    }

    // $FF: renamed from: dV (int) com.google.android.gms.games.multiplayer.realtime.RoomEntity[]
    public RoomEntity[] method_4076(int var1) {
        return new RoomEntity[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4076(var1);
    }
}
