package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import com.google.android.gms.internal.class_854;

// $FF: renamed from: com.google.android.gms.internal.iw
public final class class_326 extends Drawable implements Callback {
    // $FF: renamed from: KL boolean
    private boolean field_1076;
    // $FF: renamed from: KR int
    private int field_1077;
    // $FF: renamed from: KS long
    private long field_1078;
    // $FF: renamed from: KT int
    private int field_1079;
    // $FF: renamed from: KU int
    private int field_1080;
    // $FF: renamed from: KV int
    private int field_1081;
    // $FF: renamed from: KW int
    private int field_1082;
    // $FF: renamed from: KX boolean
    private boolean field_1083;
    // $FF: renamed from: KY com.google.android.gms.internal.iw$b
    private class_326.class_1686 field_1084;
    // $FF: renamed from: KZ android.graphics.drawable.Drawable
    private Drawable field_1085;
    // $FF: renamed from: La android.graphics.drawable.Drawable
    private Drawable field_1086;
    // $FF: renamed from: Lb boolean
    private boolean field_1087;
    // $FF: renamed from: Lc boolean
    private boolean field_1088;
    // $FF: renamed from: Ld boolean
    private boolean field_1089;
    // $FF: renamed from: Le int
    private int field_1090;
    private int mFrom;

    public class_326(Drawable var1, Drawable var2) {
        this((class_326.class_1686)null);
        if(var1 == null) {
            var1 = class_326.class_1673.field_4041;
        }

        this.field_1085 = (Drawable)var1;
        ((Drawable)var1).setCallback(this);
        class_326.class_1686 var3 = this.field_1084;
        var3.field_4040 |= ((Drawable)var1).getChangingConfigurations();
        if(var2 == null) {
            var2 = class_326.class_1673.field_4041;
        }

        this.field_1086 = (Drawable)var2;
        ((Drawable)var2).setCallback(this);
        class_326.class_1686 var4 = this.field_1084;
        var4.field_4040 |= ((Drawable)var2).getChangingConfigurations();
    }

    class_326(class_326.class_1686 var1) {
        this.field_1077 = 0;
        this.field_1080 = 255;
        this.field_1082 = 0;
        this.field_1076 = true;
        this.field_1084 = new class_326.class_1686(var1);
    }

    public boolean canConstantState() {
        if(!this.field_1087) {
            boolean var1;
            if(this.field_1085.getConstantState() != null && this.field_1086.getConstantState() != null) {
                var1 = true;
            } else {
                var1 = false;
            }

            this.field_1088 = var1;
            this.field_1087 = true;
        }

        return this.field_1088;
    }

    public void draw(Canvas var1) {
        boolean var2 = true;
        boolean var5;
        switch(this.field_1077) {
            case 1:
                this.field_1078 = SystemClock.uptimeMillis();
                this.field_1077 = 2;
                var5 = false;
                break;
            case 2:
                if(this.field_1078 >= 0L) {
                    float var3 = (float)(SystemClock.uptimeMillis() - this.field_1078) / (float)this.field_1081;
                    if(var3 < 1.0F) {
                        var2 = false;
                    }

                    if(var2) {
                        this.field_1077 = 0;
                    }

                    float var4 = Math.min(var3, 1.0F);
                    this.field_1082 = (int)((float)this.mFrom + var4 * (float)(this.field_1079 - this.mFrom));
                }
            default:
                var5 = var2;
        }

        int var6 = this.field_1082;
        boolean var7 = this.field_1076;
        Drawable var8 = this.field_1085;
        Drawable var9 = this.field_1086;
        if(!var5) {
            if(var7) {
                var8.setAlpha(this.field_1080 - var6);
            }

            var8.draw(var1);
            if(var7) {
                var8.setAlpha(this.field_1080);
            }

            if(var6 > 0) {
                var9.setAlpha(var6);
                var9.draw(var1);
                var9.setAlpha(this.field_1080);
            }

            this.invalidateSelf();
        } else {
            if(!var7 || var6 == 0) {
                var8.draw(var1);
            }

            if(var6 == this.field_1080) {
                var9.setAlpha(this.field_1080);
                var9.draw(var1);
            }

        }
    }

    // $FF: renamed from: gK () android.graphics.drawable.Drawable
    public Drawable method_2242() {
        return this.field_1086;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.field_1084.field_4039 | this.field_1084.field_4040;
    }

    public ConstantState getConstantState() {
        if(this.canConstantState()) {
            this.field_1084.field_4039 = this.getChangingConfigurations();
            return this.field_1084;
        } else {
            return null;
        }
    }

    public int getIntrinsicHeight() {
        return Math.max(this.field_1085.getIntrinsicHeight(), this.field_1086.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.field_1085.getIntrinsicWidth(), this.field_1086.getIntrinsicWidth());
    }

    public int getOpacity() {
        if(!this.field_1089) {
            this.field_1090 = Drawable.resolveOpacity(this.field_1085.getOpacity(), this.field_1086.getOpacity());
            this.field_1089 = true;
        }

        return this.field_1090;
    }

    public void invalidateDrawable(Drawable var1) {
        if(class_854.method_4493()) {
            Callback var2 = this.getCallback();
            if(var2 != null) {
                var2.invalidateDrawable(this);
            }
        }

    }

    public Drawable mutate() {
        if(!this.field_1083 && super.mutate() == this) {
            if(!this.canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }

            this.field_1085.mutate();
            this.field_1086.mutate();
            this.field_1083 = true;
        }

        return this;
    }

    protected void onBoundsChange(Rect var1) {
        this.field_1085.setBounds(var1);
        this.field_1086.setBounds(var1);
    }

    public void scheduleDrawable(Drawable var1, Runnable var2, long var3) {
        if(class_854.method_4493()) {
            Callback var5 = this.getCallback();
            if(var5 != null) {
                var5.scheduleDrawable(this, var2, var3);
            }
        }

    }

    public void setAlpha(int var1) {
        if(this.field_1082 == this.field_1080) {
            this.field_1082 = var1;
        }

        this.field_1080 = var1;
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter var1) {
        this.field_1085.setColorFilter(var1);
        this.field_1086.setColorFilter(var1);
    }

    public void startTransition(int var1) {
        this.mFrom = 0;
        this.field_1079 = this.field_1080;
        this.field_1082 = 0;
        this.field_1081 = var1;
        this.field_1077 = 1;
        this.invalidateSelf();
    }

    public void unscheduleDrawable(Drawable var1, Runnable var2) {
        if(class_854.method_4493()) {
            Callback var3 = this.getCallback();
            if(var3 != null) {
                var3.unscheduleDrawable(this, var2);
            }
        }

    }

    private static final class class_1673 extends Drawable {
        // $FF: renamed from: Lf com.google.android.gms.internal.iw$a
        private static final class_326.class_1673 field_4041 = new class_326.class_1673();
        // $FF: renamed from: Lg com.google.android.gms.internal.iw$a$a
        private static final class_326.class_1674 field_4042 = new class_326.class_1674();

        public void draw(Canvas var1) {
        }

        public ConstantState getConstantState() {
            return field_4042;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int var1) {
        }

        public void setColorFilter(ColorFilter var1) {
        }
    }

    private static final class class_1674 extends ConstantState {
        private class_1674() {
        }

        // $FF: synthetic method
        class_1674(Object var1) {
            this();
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return class_326.class_1673.field_4041;
        }
    }

    static final class class_1686 extends ConstantState {
        // $FF: renamed from: Lh int
        int field_4039;
        // $FF: renamed from: Li int
        int field_4040;

        class_1686(class_326.class_1686 var1) {
            if(var1 != null) {
                this.field_4039 = var1.field_4039;
                this.field_4040 = var1.field_4040;
            }

        }

        public int getChangingConfigurations() {
            return this.field_4039;
        }

        public Drawable newDrawable() {
            return new class_326(this);
        }
    }
}
