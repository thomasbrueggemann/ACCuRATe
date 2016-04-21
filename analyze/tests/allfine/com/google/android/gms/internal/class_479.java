package com.google.android.gms.internal;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.class_1045;
import com.google.android.gms.internal.class_223;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.ez;
import java.util.Date;
import java.util.HashSet;

// $FF: renamed from: com.google.android.gms.internal.db
@ez
public final class class_479 {
    // $FF: renamed from: a (com.google.ads.AdRequest$ErrorCode) int
    public static int method_2946(AdRequest.ErrorCode var0) {
        switch(null.field_4056[var0.ordinal()]) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
    }

    // $FF: renamed from: b (com.google.android.gms.internal.ay) com.google.ads.AdSize
    public static AdSize method_2947(class_242 var0) {
        int var1 = 0;

        for(AdSize[] var2 = new AdSize[] {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER}; var1 < var2.length; ++var1) {
            if(var2[var1].getWidth() == var0.width && var2[var1].getHeight() == var0.height) {
                return var2[var1];
            }
        }

        return new AdSize(class_1045.method_5424(var0.width, var0.height, var0.field_636));
    }

    // $FF: renamed from: d (com.google.android.gms.internal.av) com.google.ads.mediation.MediationAdRequest
    public static MediationAdRequest method_2948(class_223 var0) {
        HashSet var1;
        if(var0.field_552 != null) {
            var1 = new HashSet(var0.field_552);
        } else {
            var1 = null;
        }

        return new MediationAdRequest(new Date(var0.field_550), method_2949(var0.field_551), var1, var0.field_553, var0.field_558);
    }

    // $FF: renamed from: k (int) com.google.ads.AdRequest$Gender
    public static AdRequest.Gender method_2949(int var0) {
        switch(var0) {
            case 1:
                return AdRequest.Gender.MALE;
            case 2:
                return AdRequest.Gender.FEMALE;
            default:
                return AdRequest.Gender.UNKNOWN;
        }
    }
}
