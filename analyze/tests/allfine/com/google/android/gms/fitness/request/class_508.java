package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.class_507;
import com.google.android.gms.fitness.request.o;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.request.p
public class class_508 implements Creator<o> {
    // $FF: renamed from: a (com.google.android.gms.fitness.request.o, android.os.Parcel, int) void
    static void method_3114(class_507 var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4309(var1, 1, var0.getDataSource(), var2, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4309(var1, 2, var0.getDataType(), var2, false);
        class_823.method_4307(var1, 3, var0.method_3113(), false);
        class_823.method_4325(var1, 4, var0.field_2198);
        class_823.method_4325(var1, 5, var0.field_2199);
        class_823.method_4305(var1, 6, var0.method_3107());
        class_823.method_4305(var1, 7, var0.method_3110());
        class_823.method_4309(var1, 8, var0.method_3108(), var2, false);
        class_823.method_4305(var1, 9, var0.method_3109());
        class_823.method_4325(var1, 10, var0.getAccuracyMode());
        class_823.method_4326(var1, 11, var0.method_3111(), false);
        class_823.method_4305(var1, 12, var0.method_3112());
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: bI (android.os.Parcel) com.google.android.gms.fitness.request.o
    public class_507 method_3115(Parcel var1) {
        int var2 = class_824.method_4331(var1);
        int var3 = 0;
        DataSource var4 = null;
        DataType var5 = null;
        IBinder var6 = null;
        int var7 = 0;
        int var8 = 0;
        long var9 = 0L;
        long var11 = 0L;
        PendingIntent var13 = null;
        long var14 = 0L;
        int var16 = 0;
        ArrayList var17 = null;
        long var18 = 0L;

        while(var1.dataPosition() < var2) {
            int var20 = class_824.method_4329(var1);
            switch(class_824.method_4340(var20)) {
                case 1:
                    var4 = (DataSource)class_824.method_4336(var1, var20, DataSource.CREATOR);
                    break;
                case 2:
                    var5 = (DataType)class_824.method_4336(var1, var20, DataType.CREATOR);
                    break;
                case 3:
                    var6 = class_824.method_4357(var1, var20);
                    break;
                case 4:
                    var7 = class_824.method_4348(var1, var20);
                    break;
                case 5:
                    var8 = class_824.method_4348(var1, var20);
                    break;
                case 6:
                    var9 = class_824.method_4350(var1, var20);
                    break;
                case 7:
                    var11 = class_824.method_4350(var1, var20);
                    break;
                case 8:
                    var13 = (PendingIntent)class_824.method_4336(var1, var20, PendingIntent.CREATOR);
                    break;
                case 9:
                    var14 = class_824.method_4350(var1, var20);
                    break;
                case 10:
                    var16 = class_824.method_4348(var1, var20);
                    break;
                case 11:
                    var17 = class_824.method_4343(var1, var20, LocationRequest.CREATOR);
                    break;
                case 12:
                    var18 = class_824.method_4350(var1, var20);
                    break;
                case 1000:
                    var3 = class_824.method_4348(var1, var20);
                    break;
                default:
                    class_824.method_4341(var1, var20);
            }
        }

        if(var1.dataPosition() != var2) {
            throw new class_824.class_1307("Overread allowed size end=" + var2, var1);
        } else {
            return new class_507(var3, var4, var5, var6, var7, var8, var9, var11, var13, var14, var16, var17, var18);
        }
    }

    // $FF: renamed from: cZ (int) com.google.android.gms.fitness.request.o[]
    public class_507[] method_3116(int var1) {
        return new class_507[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_3115(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_3116(var1);
    }
}
