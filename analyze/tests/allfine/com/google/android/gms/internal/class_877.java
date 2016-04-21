package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.panorama.PanoramaApi;

// $FF: renamed from: com.google.android.gms.internal.ne
class class_877 implements PanoramaApi.PanoramaResult {
    // $FF: renamed from: CM com.google.android.gms.common.api.Status
    private final Status field_4198;
    private final Intent akC;

    public class_877(Status var1, Intent var2) {
        this.field_4198 = (Status)class_1090.method_5685(var1);
        this.akC = var2;
    }

    public Status getStatus() {
        return this.field_4198;
    }

    public Intent getViewerIntent() {
        return this.akC;
    }
}
