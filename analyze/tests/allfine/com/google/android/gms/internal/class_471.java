package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.dp
@ez
public final class class_471 extends FrameLayout implements OnClickListener {
    // $FF: renamed from: nr android.app.Activity
    private final Activity field_1817;
    // $FF: renamed from: sg android.widget.ImageButton
    private final ImageButton field_1818;

    public class_471(Activity var1, int var2) {
        super(var1);
        this.field_1817 = var1;
        this.setOnClickListener(this);
        this.field_1818 = new ImageButton(var1);
        this.field_1818.setImageResource(17301527);
        this.field_1818.setBackgroundColor(0);
        this.field_1818.setOnClickListener(this);
        this.field_1818.setPadding(0, 0, 0, 0);
        this.field_1818.setContentDescription("Interstitial close button");
        int var3 = class_377.method_2449(var1, var2);
        this.addView(this.field_1818, new LayoutParams(var3, var3, 17));
    }

    // $FF: renamed from: o (boolean) void
    public void method_2871(boolean var1) {
        ImageButton var2 = this.field_1818;
        byte var3;
        if(var1) {
            var3 = 4;
        } else {
            var3 = 0;
        }

        var2.setVisibility(var3);
    }

    public void onClick(View var1) {
        this.field_1817.finish();
    }
}
