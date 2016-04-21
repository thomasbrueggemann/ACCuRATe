package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.event.EventEntity;

public class EventEntityCreator implements Creator<EventEntity> {
    public static final int CONTENT_DESCRIPTION;

    // $FF: renamed from: a (com.google.android.gms.games.event.EventEntity, android.os.Parcel, int) void
    static void method_5948(EventEntity var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4313(var1, 1, var0.getEventId(), false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4313(var1, 2, var0.getName(), false);
        class_823.method_4313(var1, 3, var0.getDescription(), false);
        class_823.method_4309(var1, 4, var0.getIconImageUri(), var2, false);
        class_823.method_4313(var1, 5, var0.getIconImageUrl(), false);
        class_823.method_4309(var1, 6, var0.getPlayer(), var2, false);
        class_823.method_4305(var1, 7, var0.getValue());
        class_823.method_4313(var1, 8, var0.getFormattedValue(), false);
        class_823.method_4316(var1, 9, var0.isVisible());
        class_823.method_4301(var1, var3);
    }

    public EventEntity createFromParcel(Parcel var1) {
        boolean var2 = false;
        String var3 = null;
        int var4 = class_824.method_4331(var1);
        long var5 = 0L;
        PlayerEntity var7 = null;
        String var8 = null;
        Uri var9 = null;
        String var10 = null;
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
                    var10 = class_824.method_4356(var1, var14);
                    break;
                case 4:
                    var9 = (Uri)class_824.method_4336(var1, var14, Uri.CREATOR);
                    break;
                case 5:
                    var8 = class_824.method_4356(var1, var14);
                    break;
                case 6:
                    var7 = (PlayerEntity)class_824.method_4336(var1, var14, PlayerEntity.CREATOR);
                    break;
                case 7:
                    var5 = class_824.method_4350(var1, var14);
                    break;
                case 8:
                    var3 = class_824.method_4356(var1, var14);
                    break;
                case 9:
                    var2 = class_824.method_4344(var1, var14);
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
            return new EventEntity(var13, var12, var11, var10, var9, var8, var7, var5, var3, var2);
        }
    }

    public EventEntity[] newArray(int var1) {
        return new EventEntity[var1];
    }
}
