package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_823;
import com.google.android.gms.common.internal.safeparcel.class_824;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION;

    // $FF: renamed from: a (com.google.android.gms.location.ActivityRecognitionResult, android.os.Parcel, int) void
    static void method_3358(ActivityRecognitionResult var0, Parcel var1, int var2) {
        int var3 = class_823.method_4298(var1);
        class_823.method_4326(var1, 1, var0.aeb, false);
        class_823.method_4325(var1, 1000, var0.getVersionCode());
        class_823.method_4305(var1, 2, var0.aec);
        class_823.method_4305(var1, 3, var0.aed);
        class_823.method_4301(var1, var3);
    }

    public ActivityRecognitionResult createFromParcel(Parcel var1) {
        long var2 = 0L;
        int var4 = class_824.method_4331(var1);
        int var5 = 0;
        ArrayList var6 = null;
        long var7 = var2;

        while(var1.dataPosition() < var4) {
            int var9 = class_824.method_4329(var1);
            switch(class_824.method_4340(var9)) {
                case 1:
                    var6 = class_824.method_4343(var1, var9, DetectedActivity.CREATOR);
                    break;
                case 2:
                    var7 = class_824.method_4350(var1, var9);
                    break;
                case 3:
                    var2 = class_824.method_4350(var1, var9);
                    break;
                case 1000:
                    var5 = class_824.method_4348(var1, var9);
                    break;
                default:
                    class_824.method_4341(var1, var9);
            }
        }

        if(var1.dataPosition() != var4) {
            throw new class_824.class_1307("Overread allowed size end=" + var4, var1);
        } else {
            return new ActivityRecognitionResult(var5, var6, var7, var2);
        }
    }

    public ActivityRecognitionResult[] newArray(int var1) {
        return new ActivityRecognitionResult[var1];
    }
}
