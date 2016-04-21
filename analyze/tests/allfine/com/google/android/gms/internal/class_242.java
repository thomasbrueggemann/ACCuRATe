package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.class_1045;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_241;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.ay
@ez
public final class class_242 implements SafeParcelable {
    public static final class_241 CREATOR = new class_241();
    public final int height;
    public final int heightPixels;
    // $FF: renamed from: of java.lang.String
    public final String field_636;
    // $FF: renamed from: og boolean
    public final boolean field_637;
    // $FF: renamed from: oh com.google.android.gms.internal.ay[]
    public final class_242[] field_638;
    public final int versionCode;
    public final int width;
    public final int widthPixels;

    public class_242() {
        this(2, "interstitial_mb", 0, 0, true, 0, 0, (class_242[])null);
    }

    class_242(int var1, String var2, int var3, int var4, boolean var5, int var6, int var7, class_242[] var8) {
        this.versionCode = var1;
        this.field_636 = var2;
        this.height = var3;
        this.heightPixels = var4;
        this.field_637 = var5;
        this.width = var6;
        this.widthPixels = var7;
        this.field_638 = var8;
    }

    public class_242(Context var1, AdSize var2) {
        this(var1, new AdSize[] {var2});
    }

    public class_242(Context var1, AdSize[] var2) {
        int var3 = 0;
        super();
        AdSize var4 = var2[0];
        this.versionCode = 2;
        this.field_637 = false;
        this.width = var4.getWidth();
        this.height = var4.getHeight();
        boolean var5;
        if(this.width == -1) {
            var5 = true;
        } else {
            var5 = false;
        }

        boolean var6;
        if(this.height == -2) {
            var6 = true;
        } else {
            var6 = false;
        }

        DisplayMetrics var7 = var1.getResources().getDisplayMetrics();
        int var9;
        if(var5) {
            this.widthPixels = method_1594(var7);
            var9 = (int)((float)this.widthPixels / var7.density);
        } else {
            int var8 = this.width;
            this.widthPixels = class_377.method_2450(var7, this.width);
            var9 = var8;
        }

        int var10;
        if(var6) {
            var10 = method_1596(var7);
        } else {
            var10 = this.height;
        }

        this.heightPixels = class_377.method_2450(var7, var10);
        if(!var5 && !var6) {
            this.field_636 = var4.toString();
        } else {
            this.field_636 = var9 + "x" + var10 + "_as";
        }

        if(var2.length > 1) {
            for(this.field_638 = new class_242[var2.length]; var3 < var2.length; ++var3) {
                this.field_638[var3] = new class_242(var1, var2[var3]);
            }
        } else {
            this.field_638 = null;
        }

    }

    public class_242(class_242 var1, class_242[] var2) {
        this(2, var1.field_636, var1.height, var1.heightPixels, var1.field_637, var1.width, var1.widthPixels, var2);
    }

    // $FF: renamed from: a (android.util.DisplayMetrics) int
    public static int method_1594(DisplayMetrics var0) {
        return var0.widthPixels;
    }

    // $FF: renamed from: b (android.util.DisplayMetrics) int
    public static int method_1595(DisplayMetrics var0) {
        return (int)((float)method_1596(var0) * var0.density);
    }

    // $FF: renamed from: c (android.util.DisplayMetrics) int
    private static int method_1596(DisplayMetrics var0) {
        int var1 = (int)((float)var0.heightPixels / var0.density);
        return var1 <= 400?32:(var1 <= 720?50:90);
    }

    // $FF: renamed from: bc () com.google.android.gms.ads.AdSize
    public AdSize method_1597() {
        return class_1045.method_5424(this.width, this.height, this.field_636);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_241.method_1591(this, var1, var2);
    }
}
