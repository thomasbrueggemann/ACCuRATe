package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.games.internal.game.GameBadgeEntity;

public class GameBadgeEntityCreator implements Creator<GameBadgeEntity> {
    // $FF: renamed from: a (com.google.android.gms.games.internal.game.GameBadgeEntity, android.os.Parcel, int) void
    static void method_5493(GameBadgeEntity var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.getType());
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.getTitle(), false);
        class_823.method_4313(var1, 3, var0.getDescription(), false);
        class_823.method_4309(var1, 4, var0.getIconImageUri(), var2, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: ch (android.os.Parcel) com.google.android.gms.games.internal.game.GameBadgeEntity
    public GameBadgeEntity method_5494(Parcel var1) {
        int var2 = 0;
        Uri var3 = null;
        int var4 = class_824.method_4331(var1);
        String var5 = null;
        String var6 = null;
        int var7 = 0;

        while(var1.dataPosition() < var4) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var2 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var6 = class_824.method_4356(var1, var8);
                    break;
                case 3:
                    var5 = class_824.method_4356(var1, var8);
                    break;
                case 4:
                    var3 = (Uri)class_824.method_4336(var1, var8, Uri.CREATOR);
                    break;
                case 1000:
                    var7 = class_824.method_4348(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new GameBadgeEntity(var7, var2, var6, var5, var3);
        }
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5494(var1);
    }

    // $FF: renamed from: dL (int) com.google.android.gms.games.internal.game.GameBadgeEntity[]
    public GameBadgeEntity[] method_5495(int var1) {
        return new GameBadgeEntity[var1];
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5495(var1);
    }
}
