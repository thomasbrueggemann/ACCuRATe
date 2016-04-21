package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// $FF: renamed from: com.google.android.gms.drive.internal.e
public class class_280 implements Creator<CloseContentsAndUpdateMetadataRequest> {
    // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest, android.os.Parcel, int) void
    static void method_1761(CloseContentsAndUpdateMetadataRequest var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_5255);
        class_823.method_4309(var1, 2, var0.field_5258, var2, false);
        class_823.method_4309(var1, 3, var0.field_5259, var2, false);
        class_823.method_4309(var1, 4, var0.field_5260, var2, false);
        class_823.method_4316(var1, 5, var0.field_5257);
        class_823.method_4313(var1, 6, var0.field_5256, false);
        class_823.method_4325(var1, 7, var0.field_5261);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: Y (android.os.Parcel) com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest
    public CloseContentsAndUpdateMetadataRequest method_1762(Parcel var1) {
        int var2 = 0;
        String var3 = null;
        int var4 = class_824.method_4331(var1);
        boolean var5 = false;
        Contents var6 = null;
        MetadataBundle var7 = null;
        DriveId var8 = null;
        int var9 = 0;

        while(var1.dataPosition() < var4) {
            int var10 = class_824.method_4329(var1);
            switch(class_824.method_4340(var10)) {
                case 1:
                    var9 = class_824.method_4348(var1, var10);
                    break;
                case 2:
                    var8 = (DriveId)class_824.method_4336(var1, var10, DriveId.CREATOR);
                    break;
                case 3:
                    var7 = (MetadataBundle)class_824.method_4336(var1, var10, MetadataBundle.CREATOR);
                    break;
                case 4:
                    var6 = (Contents)class_824.method_4336(var1, var10, Contents.CREATOR);
                    break;
                case 5:
                    var5 = class_824.method_4344(var1, var10);
                    break;
                case 6:
                    var3 = class_824.method_4356(var1, var10);
                    break;
                case 7:
                    var2 = class_824.method_4348(var1, var10);
                    break;
                default:
                    class_824.method_4341(var1, var10);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new CloseContentsAndUpdateMetadataRequest(var9, var8, var7, var6, var5, var3, var2);
        }
    }

    // $FF: renamed from: bh (int) com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest[]
    public CloseContentsAndUpdateMetadataRequest[] method_1763(int var1) {
        return new CloseContentsAndUpdateMetadataRequest[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_1762(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_1763(var1);
    }
}
