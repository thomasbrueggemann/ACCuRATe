package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

// $FF: renamed from: com.google.android.gms.drive.events.d
public class class_813 {
    // $FF: renamed from: a (int, com.google.android.gms.drive.DriveId) boolean
    public static boolean method_4212(int var0, DriveId var1) {
        return var1 != null || method_4213(var0);
    }

    // $FF: renamed from: bd (int) boolean
    public static boolean method_4213(int var0) {
        return (2L & (long)(1 << var0)) != 0L;
    }
}
