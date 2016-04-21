package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// $FF: renamed from: com.google.android.gms.drive.internal.j
public class class_285 implements Creator<CreateFileRequest> {
    // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileRequest, android.os.Parcel, int) void
    static void method_1777(CreateFileRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_4613);
        class_823.method_4309(var1, 2, var0.field_4618, var2, false);
        class_823.method_4309(var1, 3, var0.field_4616, var2, false);
        class_823.method_4309(var1, 4, var0.field_4615, var2, false);
        class_823.method_4311(var1, 5, var0.field_4617, false);
        class_823.method_4316(var1, 6, var0.field_4619);
        class_823.method_4313(var1, 7, var0.field_4614, false);
        class_823.method_4325(var1, 8, var0.field_4620);
        class_823.method_4325(var1, 9, var0.field_4621);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: ac (android.os.Parcel) com.google.android.gms.drive.internal.CreateFileRequest
    public CreateFileRequest method_1778(Parcel var1) {
        int var2 = 0;
        String var3 = null;
        int var4 = class_824.method_4331(var1);
        int var5 = 0;
        boolean var6 = false;
        Integer var7 = null;
        Contents var8 = null;
        MetadataBundle var9 = null;
        DriveId var10 = null;
        int var11 = 0;

        while(var1.dataPosition() < var4) {
            int var12 = class_824.method_4329(var1);
            switch(class_824.method_4340(var12)) {
                case 1:
                    var11 = class_824.method_4348(var1, var12);
                    break;
                case 2:
                    var10 = (DriveId)class_824.method_4336(var1, var12, DriveId.CREATOR);
                    break;
                case 3:
                    var9 = (MetadataBundle)class_824.method_4336(var1, var12, MetadataBundle.CREATOR);
                    break;
                case 4:
                    var8 = (Contents)class_824.method_4336(var1, var12, Contents.CREATOR);
                    break;
                case 5:
                    var7 = class_824.method_4349(var1, var12);
                    break;
                case 6:
                    var6 = class_824.method_4344(var1, var12);
                    break;
                case 7:
                    var3 = class_824.method_4356(var1, var12);
                    break;
                case 8:
                    var5 = class_824.method_4348(var1, var12);
                    break;
                case 9:
                    var2 = class_824.method_4348(var1, var12);
                    break;
                default:
                    class_824.method_4341(var1, var12);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new CreateFileRequest(var11, var10, var9, var8, var7, var6, var3, var5, var2);
        }
    }

    // $FF: renamed from: bm (int) com.google.android.gms.drive.internal.CreateFileRequest[]
    public CreateFileRequest[] method_1779(int var1) {
        return new CreateFileRequest[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_1778(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_1779(var1);
    }
}
