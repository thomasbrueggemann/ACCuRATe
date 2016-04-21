package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

public class SnapshotMetadataEntityCreator implements Creator<SnapshotMetadataEntity> {
    public static final int CONTENT_DESCRIPTION;

    // $FF: renamed from: a (com.google.android.gms.games.snapshot.SnapshotMetadataEntity, android.os.Parcel, int) void
    static void method_5439(SnapshotMetadataEntity var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.getGame(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.getOwner(), var2, false);
        class_823.method_4313(var1, 3, var0.getSnapshotId(), false);
        class_823.method_4309(var1, 5, var0.getCoverImageUri(), var2, false);
        class_823.method_4313(var1, 6, var0.getCoverImageUrl(), false);
        class_823.method_4313(var1, 7, var0.getTitle(), false);
        class_823.method_4313(var1, 8, var0.getDescription(), false);
        class_823.method_4305(var1, 9, var0.getLastModifiedTimestamp());
        class_823.method_4305(var1, 10, var0.getPlayedTime());
        class_823.method_4304(var1, 11, var0.getCoverImageAspectRatio());
        class_823.method_4313(var1, 12, var0.getUniqueName(), false);
        class_823.method_4301(var1, var3);
    }

    public SnapshotMetadataEntity createFromParcel(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        GameEntity var4 = null;
        PlayerEntity var5 = null;
        String var6 = null;
        Uri var7 = null;
        String var8 = null;
        String var9 = null;
        String var10 = null;
        long var11 = 0L;
        long var13 = 0L;
        float var15 = 0.0F;
        String var16 = null;

        while(var1.dataPosition() < var2) {
            int var17 = class_824.method_4329(var1);
            switch(class_824.method_4340(var17)) {
                case 1:
                    var4 = (GameEntity)class_824.method_4336(var1, var17, GameEntity.CREATOR);
                    break;
                case 2:
                    var5 = (PlayerEntity)class_824.method_4336(var1, var17, PlayerEntity.CREATOR);
                    break;
                case 3:
                    var6 = class_824.method_4356(var1, var17);
                    break;
                case 5:
                    var7 = (Uri)class_824.method_4336(var1, var17, Uri.CREATOR);
                    break;
                case 6:
                    var8 = class_824.method_4356(var1, var17);
                    break;
                case 7:
                    var9 = class_824.method_4356(var1, var17);
                    break;
                case 8:
                    var10 = class_824.method_4356(var1, var17);
                    break;
                case 9:
                    var11 = class_824.method_4350(var1, var17);
                    break;
                case 10:
                    var13 = class_824.method_4350(var1, var17);
                    break;
                case 11:
                    var15 = class_824.method_4353(var1, var17);
                    break;
                case 12:
                    var16 = class_824.method_4356(var1, var17);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var17);
                    break;
                default:
                    class_824.method_4341(var1, var17);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new SnapshotMetadataEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var13, var15, var16);
        }
    }

    public SnapshotMetadataEntity[] newArray(int var1) {
        return new SnapshotMetadataEntity[var1];
    }
}
