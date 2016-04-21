package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.j;
import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.internal.kg
public class class_655 extends j<DriveId> {
    // $FF: renamed from: Qy com.google.android.gms.internal.kg
    public static final class_655 field_3192 = new class_655();

    private class_655() {
        super("driveId", Arrays.asList(new String[] {"sqlId", "resourceId"}), Arrays.asList(new String[] {"dbInstanceId"}), 4100000);
    }

    // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
    // $FF: synthetic method
    protected Object method_3645(DataHolder var1, int var2, int var3) {
        return this.method_3671(var1, var2, var3);
    }

    // $FF: renamed from: m (com.google.android.gms.common.data.DataHolder, int, int) com.google.android.gms.drive.DriveId
    protected DriveId method_3671(DataHolder var1, int var2, int var3) {
        long var4 = var1.method_5998().getLong("dbInstanceId");
        String var6 = var1.method_5989("resourceId", var2, var3);
        if(var6 != null && var6.startsWith("generated-android-")) {
            var6 = null;
        }

        return new DriveId(var6, Long.valueOf(var1.method_5984("sqlId", var2, var3)).longValue(), var4);
    }
}
