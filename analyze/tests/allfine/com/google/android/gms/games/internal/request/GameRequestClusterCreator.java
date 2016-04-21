package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Creator<GameRequestCluster> {
    // $FF: renamed from: a (com.google.android.gms.games.internal.request.GameRequestCluster, android.os.Parcel, int) void
    static void method_5630(GameRequestCluster var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4326(var1, 1, var0.method_5551(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: ck (android.os.Parcel) com.google.android.gms.games.internal.request.GameRequestCluster
    public GameRequestCluster method_5631(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        ArrayList var4 = null;

        while(var1.dataPosition() < var2) {
            int var5 = class_824.method_4329(var1);
            switch(class_824.method_4340(var5)) {
                case 1:
                    var4 = class_824.method_4343(var1, var5, GameRequestEntity.CREATOR);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var5);
                    break;
                default:
                    class_824.method_4341(var1, var5);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new GameRequestCluster(var3, var4);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5631(var1);
    }

    // $FF: renamed from: dQ (int) com.google.android.gms.games.internal.request.GameRequestCluster[]
    public GameRequestCluster[] method_5632(int var1) {
        return new GameRequestCluster[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5632(var1);
    }
}
