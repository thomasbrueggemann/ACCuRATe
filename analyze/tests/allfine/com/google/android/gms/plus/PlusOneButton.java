package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.class_1087;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.plus.internal.class_218;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private View all;
    private int alm;
    private int aln;
    private PlusOneButton.OnPlusOneClickListener alo;
    private int mSize;
    // $FF: renamed from: uR java.lang.String
    private String field_4813;

    public PlusOneButton(Context var1) {
        this(var1, (AttributeSet)null);
    }

    public PlusOneButton(Context var1, AttributeSet var2) {
        super(var1, var2);
        this.mSize = getSize(var1, var2);
        this.alm = getAnnotation(var1, var2);
        this.aln = -1;
        this.method_5443(this.getContext());
        if(this.isInEditMode()) {
            ;
        }

    }

    // $FF: renamed from: G (android.content.Context) void
    private void method_5443(Context var1) {
        if(this.all != null) {
            this.removeView(this.all);
        }

        this.all = class_218.method_1510(var1, this.mSize, this.alm, this.field_4813, this.aln);
        this.setOnPlusOneClickListener(this.alo);
        this.addView(this.all);
    }

    protected static int getAnnotation(Context var0, AttributeSet var1) {
        String var2 = class_1087.method_5667("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", var0, var1, true, false, "PlusOneButton");
        byte var4;
        if("INLINE".equalsIgnoreCase(var2)) {
            var4 = 2;
        } else {
            boolean var3 = "NONE".equalsIgnoreCase(var2);
            var4 = 0;
            if(!var3) {
                return 1;
            }
        }

        return var4;
    }

    protected static int getSize(Context var0, AttributeSet var1) {
        String var2 = class_1087.method_5667("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", var0, var1, true, false, "PlusOneButton");
        return "SMALL".equalsIgnoreCase(var2)?0:("MEDIUM".equalsIgnoreCase(var2)?1:("TALL".equalsIgnoreCase(var2)?2:3));
    }

    public void initialize(String var1, int var2) {
        class_1090.method_5676(this.getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.field_4813 = var1;
        this.aln = var2;
        this.method_5443(this.getContext());
    }

    public void initialize(String var1, PlusOneButton.OnPlusOneClickListener var2) {
        this.field_4813 = var1;
        this.aln = 0;
        this.method_5443(this.getContext());
        this.setOnPlusOneClickListener(var2);
    }

    protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
        this.all.layout(0, 0, var4 - var2, var5 - var3);
    }

    protected void onMeasure(int var1, int var2) {
        View var3 = this.all;
        this.measureChild(var3, var1, var2);
        this.setMeasuredDimension(var3.getMeasuredWidth(), var3.getMeasuredHeight());
    }

    public void setAnnotation(int var1) {
        this.alm = var1;
        this.method_5443(this.getContext());
    }

    public void setOnPlusOneClickListener(PlusOneButton.OnPlusOneClickListener var1) {
        this.alo = var1;
        this.all.setOnClickListener(new PlusOneButton.DefaultOnPlusOneClickListener(var1));
    }

    public void setSize(int var1) {
        this.mSize = var1;
        this.method_5443(this.getContext());
    }

    protected class DefaultOnPlusOneClickListener implements OnClickListener, PlusOneButton.OnPlusOneClickListener {
        private final PlusOneButton.OnPlusOneClickListener alp;

        public DefaultOnPlusOneClickListener(PlusOneButton.OnPlusOneClickListener var2) {
            this.alp = var2;
        }

        public void onClick(View var1) {
            Intent var2 = (Intent)PlusOneButton.this.all.getTag();
            if(this.alp != null) {
                this.alp.onPlusOneClick(var2);
            } else {
                this.onPlusOneClick(var2);
            }
        }

        public void onPlusOneClick(Intent var1) {
            Context var2 = PlusOneButton.this.getContext();
            if(var2 instanceof Activity && var1 != null) {
                ((Activity)var2).startActivityForResult(var1, PlusOneButton.this.aln);
            }

        }
    }

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent var1);
    }
}
