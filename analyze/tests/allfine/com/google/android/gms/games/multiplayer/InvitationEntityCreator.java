package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class InvitationEntityCreator implements Creator<InvitationEntity> {
    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.InvitationEntity, android.os.Parcel, int) void
    static void method_4759(InvitationEntity var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.getGame(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.getInvitationId(), false);
        class_823.method_4305(var1, 3, var0.getCreationTimestamp());
        class_823.method_4325(var1, 4, var0.getInvitationType());
        class_823.method_4309(var1, 5, var0.getInviter(), var2, false);
        class_823.method_4326(var1, 6, var0.getParticipants(), false);
        class_823.method_4325(var1, 7, var0.getVariant());
        class_823.method_4325(var1, 8, var0.getAvailableAutoMatchSlots());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: cl (android.os.Parcel) com.google.android.gms.games.multiplayer.InvitationEntity
    public InvitationEntity method_4760(Parcel var1) {
        ArrayList var2 = null;
        int var3 = 0;
        int var4 = class_824.method_4331(var1);
        long var5 = 0L;
        int var7 = 0;
        ParticipantEntity var8 = null;
        int var9 = 0;
        String var10 = null;
        GameEntity var11 = null;
        int var12 = 0;

        while(var1.dataPosition() < var4) {
            int var13 = class_824.method_4329(var1);
            switch(class_824.method_4340(var13)) {
                case 1:
                    var11 = (GameEntity)class_824.method_4336(var1, var13, GameEntity.CREATOR);
                    break;
                case 2:
                    var10 = class_824.method_4356(var1, var13);
                    break;
                case 3:
                    var5 = class_824.method_4350(var1, var13);
                    break;
                case 4:
                    var9 = class_824.method_4348(var1, var13);
                    break;
                case 5:
                    var8 = (ParticipantEntity)class_824.method_4336(var1, var13, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    var2 = class_824.method_4343(var1, var13, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    var7 = class_824.method_4348(var1, var13);
                    break;
                case 8:
                    var3 = class_824.method_4348(var1, var13);
                    break;
                case 1000:
                    var12 = class_824.method_4348(var1, var13);
                    break;
                default:
                    class_824.method_4341(var1, var13);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new InvitationEntity(var12, var11, var10, var5, var9, var8, var2, var7, var3);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_4760(var1);
    }

    // $FF: renamed from: dS (int) com.google.android.gms.games.multiplayer.InvitationEntity[]
    public InvitationEntity[] method_4761(int var1) {
        return new InvitationEntity[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_4761(var1);
    }
}
