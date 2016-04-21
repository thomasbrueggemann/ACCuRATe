package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.class_614;
import com.google.android.gms.tagmanager.class_616;
import com.google.android.gms.tagmanager.class_69;

// $FF: renamed from: com.google.android.gms.tagmanager.bn
class class_611 {
    // $FF: renamed from: nP () int
    int method_3453() {
        return VERSION.SDK_INT;
    }

    // $FF: renamed from: ox () com.google.android.gms.tagmanager.bm
    public class_69 method_3454() {
        return (class_69)(this.method_3453() < 8?new class_614():new class_616());
    }
}
