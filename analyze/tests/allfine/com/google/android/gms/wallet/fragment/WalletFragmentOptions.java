package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.class_492;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;
import com.google.android.gms.wallet.fragment.class_736;

public final class WalletFragmentOptions implements SafeParcelable {
    public static final Creator<WalletFragmentOptions> CREATOR = new class_736();
    // $FF: renamed from: BR int
    final int field_5235;
    // $FF: renamed from: MV int
    private int field_5236;
    private int atL;
    private WalletFragmentStyle aum;
    private int mTheme;

    private WalletFragmentOptions() {
        this.field_5235 = 1;
    }

    WalletFragmentOptions(int var1, int var2, int var3, WalletFragmentStyle var4, int var5) {
        this.field_5235 = var1;
        this.atL = var2;
        this.mTheme = var3;
        this.aum = var4;
        this.field_5236 = var5;
    }

    // $FF: renamed from: a (android.content.Context, android.util.AttributeSet) com.google.android.gms.wallet.fragment.WalletFragmentOptions
    public static WalletFragmentOptions method_5854(Context var0, AttributeSet var1) {
        TypedArray var2 = var0.obtainStyledAttributes(var1, class_492.styleable.WalletFragmentOptions);
        int var3 = var2.getInt(class_492.styleable.WalletFragmentOptions_appTheme, 0);
        int var4 = var2.getInt(class_492.styleable.WalletFragmentOptions_environment, 1);
        int var5 = var2.getResourceId(class_492.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int var6 = var2.getInt(class_492.styleable.WalletFragmentOptions_fragmentMode, 1);
        var2.recycle();
        WalletFragmentOptions var7 = new WalletFragmentOptions();
        var7.mTheme = var3;
        var7.atL = var4;
        var7.aum = (new WalletFragmentStyle()).setStyleResourceId(var5);
        var7.aum.method_6020(var0);
        var7.field_5236 = var6;
        return var7;
    }

    public static WalletFragmentOptions.Builder newBuilder() {
        WalletFragmentOptions var0 = new WalletFragmentOptions();
        return var0.new Builder();
    }

    // $FF: renamed from: aa (android.content.Context) void
    public void method_5858(Context var1) {
        if(this.aum != null) {
            this.aum.method_6020(var1);
        }

    }

    public int describeContents() {
        return 0;
    }

    public int getEnvironment() {
        return this.atL;
    }

    public WalletFragmentStyle getFragmentStyle() {
        return this.aum;
    }

    public int getMode() {
        return this.field_5236;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_736.method_3976(this, var1, var2);
    }

    public final class Builder {
        private Builder() {
        }

        // $FF: synthetic method
        Builder(Object var2) {
            this();
        }

        public WalletFragmentOptions build() {
            return WalletFragmentOptions.this;
        }

        public WalletFragmentOptions.Builder setEnvironment(int var1) {
            WalletFragmentOptions.this.atL = var1;
            return this;
        }

        public WalletFragmentOptions.Builder setFragmentStyle(int var1) {
            WalletFragmentOptions.this.aum = (new WalletFragmentStyle()).setStyleResourceId(var1);
            return this;
        }

        public WalletFragmentOptions.Builder setFragmentStyle(WalletFragmentStyle var1) {
            WalletFragmentOptions.this.aum = var1;
            return this;
        }

        public WalletFragmentOptions.Builder setMode(int var1) {
            WalletFragmentOptions.this.field_5236 = var1;
            return this;
        }

        public WalletFragmentOptions.Builder setTheme(int var1) {
            WalletFragmentOptions.this.mTheme = var1;
            return this;
        }
    }
}
