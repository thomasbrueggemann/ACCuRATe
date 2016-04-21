package org.apache.cordova;

import android.view.View;

public class ScrollEvent {
    // $FF: renamed from: l int
    public int field_5078;
    // $FF: renamed from: nl int
    public int field_5079;
    // $FF: renamed from: nt int
    public int field_5080;
    // $FF: renamed from: t int
    public int field_5081;
    private View targetView;

    ScrollEvent(int var1, int var2, int var3, int var4, View var5) {
        this.field_5078 = var3;
        int var10000 = this.field_5081;
        this.field_5079 = var1;
        this.field_5080 = var2;
        this.targetView = var5;
    }

    // $FF: renamed from: dl () int
    public int method_5575() {
        return this.field_5079 - this.field_5078;
    }

    // $FF: renamed from: dt () int
    public int method_5576() {
        return this.field_5080 - this.field_5081;
    }

    public View getTargetView() {
        return this.targetView;
    }
}
