package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;

// $FF: renamed from: com.google.android.gms.drive.internal.aj
public class class_1114 implements Creator<OnDownloadProgressResponse> {
    // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDownloadProgressResponse, android.os.Parcel, int) void
    static void method_5766(OnDownloadProgressResponse var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4325(var1, 1, var0.field_3584);
        class_823.method_4305(var1, 2, var0.field_3585);
        class_823.method_4305(var1, 3, var0.field_3586);
        class_823.method_4301(var1, var3);
    }

    // $FF: renamed from: al (android.os.Parcel) com.google.android.gms.drive.internal.OnDownloadProgressResponse
    public OnDownloadProgressResponse method_5767(Parcel var1) {
        long var2 = 0L;
        int var4 = class_824.method_4331(var1);
        int var5 = 0;
        long var6 = var2;

        while(var1.dataPosition() < var4) {
            int var8 = class_824.method_4329(var1);
            switch(class_824.method_4340(var8)) {
                case 1:
                    var5 = class_824.method_4348(var1, var8);
                    break;
                case 2:
                    var6 = class_824.method_4350(var1, var8);
                    break;
                case 3:
                    var2 = class_824.method_4350(var1, var8);
                    break;
                default:
                    class_824.method_4341(var1, var8);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new OnDownloadProgressResponse(var5, var6, var2);
        }
    }

    // $FF: renamed from: bx (int) com.google.android.gms.drive.internal.OnDownloadProgressResponse[]
    public OnDownloadProgressResponse[] method_5768(int var1) {
        return new OnDownloadProgressResponse[var1];
    }

    // $FF: synthetic method
    public Object createFromParcel(Parcel var1) {
        return this.method_5767(var1);
    }

    // $FF: synthetic method
    public Object[] newArray(int var1) {
        return this.method_5768(var1);
    }
}
