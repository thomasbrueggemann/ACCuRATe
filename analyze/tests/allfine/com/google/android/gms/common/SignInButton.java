package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.class_1088;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.class_217;
import com.google.android.gms.dynamic.class_216;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    // $FF: renamed from: Im android.view.View
    private View field_1126;
    // $FF: renamed from: In android.view.View.OnClickListener
    private OnClickListener field_1127;
    private int mColor;
    private int mSize;

    public SignInButton(Context var1) {
        this(var1, (AttributeSet)null);
    }

    public SignInButton(Context var1, AttributeSet var2) {
        this(var1, var2, 0);
    }

    public SignInButton(Context var1, AttributeSet var2, int var3) {
        super(var1, var2, var3);
        this.field_1127 = null;
        this.setStyle(0, 0);
    }

    // $FF: renamed from: G (android.content.Context) void
    private void method_2289(Context var1) {
        if(this.field_1126 != null) {
            this.removeView(this.field_1126);
        }

        try {
            this.field_1126 = class_217.method_1507(var1, this.mSize, this.mColor);
        } catch (class_216.class_1677 var3) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.field_1126 = method_2290(var1, this.mSize, this.mColor);
        }

        this.addView(this.field_1126);
        this.field_1126.setEnabled(this.isEnabled());
        this.field_1126.setOnClickListener(this);
    }

    // $FF: renamed from: a (android.content.Context, int, int) android.widget.Button
    private static Button method_2290(Context var0, int var1, int var2) {
        class_1088 var3 = new class_1088(var0);
        var3.method_5672(var0.getResources(), var1, var2);
        return var3;
    }

    public void onClick(View var1) {
        if(this.field_1127 != null && var1 == this.field_1126) {
            this.field_1127.onClick(this);
        }

    }

    public void setColorScheme(int var1) {
        this.setStyle(this.mSize, var1);
    }

    public void setEnabled(boolean var1) {
        super.setEnabled(var1);
        this.field_1126.setEnabled(var1);
    }

    public void setOnClickListener(OnClickListener var1) {
        this.field_1127 = var1;
        if(this.field_1126 != null) {
            this.field_1126.setOnClickListener(this);
        }

    }

    public void setSize(int var1) {
        this.setStyle(var1, this.mColor);
    }

    public void setStyle(int var1, int var2) {
        boolean var3;
        if(var1 >= 0 && var1 < 3) {
            var3 = true;
        } else {
            var3 = false;
        }

        Object[] var4 = new Object[] {Integer.valueOf(var1)};
        class_1090.method_5677(var3, "Unknown button size %d", var4);
        boolean var5;
        if(var2 >= 0 && var2 < 2) {
            var5 = true;
        } else {
            var5 = false;
        }

        Object[] var6 = new Object[] {Integer.valueOf(var2)};
        class_1090.method_5677(var5, "Unknown color scheme %s", var6);
        this.mSize = var1;
        this.mColor = var2;
        this.method_2289(this.getContext());
    }
}
