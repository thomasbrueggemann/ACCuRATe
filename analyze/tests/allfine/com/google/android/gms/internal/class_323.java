package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

// $FF: renamed from: com.google.android.gms.internal.iy
public final class class_323 extends ImageView {
    // $FF: renamed from: Lj android.net.Uri
    private Uri field_1062;
    // $FF: renamed from: Lk int
    private int field_1063;
    // $FF: renamed from: Ll int
    private int field_1064;
    // $FF: renamed from: Lm com.google.android.gms.internal.iy$a
    private class_323.class_1697 field_1065;
    // $FF: renamed from: Ln int
    private int field_1066;
    // $FF: renamed from: Lo float
    private float field_1067;

    // $FF: renamed from: ay (int) void
    public void method_2228(int var1) {
        this.field_1063 = var1;
    }

    // $FF: renamed from: g (android.net.Uri) void
    public void method_2229(Uri var1) {
        this.field_1062 = var1;
    }

    // $FF: renamed from: gM () int
    public int method_2230() {
        return this.field_1063;
    }

    protected void onDraw(Canvas var1) {
        if(this.field_1065 != null) {
            var1.clipPath(this.field_1065.method_879(this.getWidth(), this.getHeight()));
        }

        super.onDraw(var1);
        if(this.field_1064 != 0) {
            var1.drawColor(this.field_1064);
        }

    }

    protected void onMeasure(int var1, int var2) {
        super.onMeasure(var1, var2);
        int var3;
        int var4;
        switch(this.field_1066) {
            case 1:
                var4 = this.getMeasuredHeight();
                var3 = (int)((float)var4 * this.field_1067);
                break;
            case 2:
                var3 = this.getMeasuredWidth();
                var4 = (int)((float)var3 / this.field_1067);
                break;
            default:
                return;
        }

        this.setMeasuredDimension(var3, var4);
    }

    public interface class_1697 {
        // $FF: renamed from: g (int, int) android.graphics.Path
        Path method_879(int var1, int var2);
    }
}
