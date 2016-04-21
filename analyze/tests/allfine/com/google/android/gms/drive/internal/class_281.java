package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.CloseContentsRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.f
public class class_281 implements Creator<CloseContentsRequest> {
    // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsRequest, android.os.Parcel, int) void
    static void method_1764(CloseContentsRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4694);
        class_823.method_4309(var1, 2, var0.field_4695, var2, false);
        class_823.method_4310(var1, 3, var0.field_4696, false);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: Z (android.os.Parcel) com.google.android.gms.drive.internal.CloseContentsRequest
    public CloseContentsRequest method_1765(Parcel var1) {
        Boolean var2 = null;
        int var3 = class_824.method_4331(var1);
        int var4 = 0;

        Contents var5;
        Boolean var7;
        for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
            int var6 = class_824.method_4329(var1);
            Contents var8;
            int var9;
            switch(class_824.method_4340(var6)) {
                case 1:
                    int var11 = class_824.method_4348(var1, var6);
                    var8 = var5;
                    var9 = var11;
                    var7 = var2;
                    break;
                case 2:
                    Contents var10 = (Contents)class_824.method_4336(var1, var6, Contents.CREATOR);
                    var9 = var4;
                    var7 = var2;
                    var8 = var10;
                    break;
                case 3:
                    var7 = class_824.method_4345(var1, var6);
                    var8 = var5;
                    var9 = var4;
                    break;
                default:
                    class_824.method_4341(var1, var6);
                    var7 = var2;
                    var8 = var5;
                    var9 = var4;
            }

            var4 = var9;
            var5 = var8;
        }

        if(var1.dataPosition() != var3) {
            throw new class_824.class_1307("Overread allowed size end=" + var3, var1);
        } else {
            return new CloseContentsRequest(var4, var5, var2);
        }
    }

    // $FF: renamed from: bi (int) com.google.android.gms.drive.internal.CloseContentsRequest[]
    public CloseContentsRequest[] method_1766(int var1) {
        return new CloseContentsRequest[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_1765(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_1766(var1);
    }
}
