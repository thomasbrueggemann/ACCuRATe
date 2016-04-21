package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public class ParticipantResultCreator implements Creator<ParticipantResult> {
    public static final int CONTENT_DESCRIPTION;

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.ParticipantResult, android.os.Parcel, int) void
    static void method_2807(ParticipantResult var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.getParticipantId(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4325(var1, 2, var0.getResult());
        class_823.method_4325(var1, 3, var0.getPlacing());
        class_823.method_4301(var1, var3);
    }

    public ParticipantResult createFromParcel(Parcel var1) {
        int var2 = 0;
        int var3 = class_824.method_4331(var1);
        String var4 = null;
        int var5 = 0;
        int var6 = 0;

        while(var1.dataPosition() < var3) {
            int var7 = class_824.method_4329(var1);
            switch(class_824.method_4340(var7)) {
                case 1:
                    var4 = class_824.method_4356(var1, var7);
                    break;
                case 2:
                    var5 = class_824.method_4348(var1, var7);
                    break;
                case 3:
                    var2 = class_824.method_4348(var1, var7);
                    break;
                case 1000:
                    var6 = class_824.method_4348(var1, var7);
                    break;
                default:
                    class_824.method_4341(var1, var7);
            }
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new ParticipantResult(var6, var4, var5, var2);
        }
    }

    public ParticipantResult[] newArray(int var1) {
        return new ParticipantResult[var1];
    }
}
