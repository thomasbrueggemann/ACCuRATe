package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.class_492;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.class_739;

public final class WalletFragmentStyle implements SafeParcelable {
    public static final Creator<WalletFragmentStyle> CREATOR = new class_739();
    // $FF: renamed from: BR int
    final int field_5365;
    Bundle auo;
    int aup;

    public WalletFragmentStyle() {
        this.field_5365 = 1;
        this.auo = new Bundle();
    }

    WalletFragmentStyle(int var1, Bundle var2, int var3) {
        this.field_5365 = var1;
        this.auo = var2;
        this.aup = var3;
    }

    // $FF: renamed from: a (android.content.res.TypedArray, int, java.lang.String) void
    private void method_6016(TypedArray var1, int var2, String var3) {
        if(!this.auo.containsKey(var3)) {
            TypedValue var4 = var1.peekValue(var2);
            if(var4 != null) {
                this.auo.putLong(var3, Dimension.method_3099(var4));
                return;
            }
        }

    }

    // $FF: renamed from: a (android.content.res.TypedArray, int, java.lang.String, java.lang.String) void
    private void method_6017(TypedArray var1, int var2, String var3, String var4) {
        if(!this.auo.containsKey(var3) && !this.auo.containsKey(var4)) {
            TypedValue var5 = var1.peekValue(var2);
            if(var5 != null) {
                if(var5.type >= 28 && var5.type <= 31) {
                    this.auo.putInt(var3, var5.data);
                    return;
                }

                this.auo.putInt(var4, var5.resourceId);
                return;
            }
        }

    }

    // $FF: renamed from: b (android.content.res.TypedArray, int, java.lang.String) void
    private void method_6018(TypedArray var1, int var2, String var3) {
        if(!this.auo.containsKey(var3)) {
            TypedValue var4 = var1.peekValue(var2);
            if(var4 != null) {
                this.auo.putInt(var3, var4.data);
                return;
            }
        }

    }

    // $FF: renamed from: a (java.lang.String, android.util.DisplayMetrics, int) int
    public int method_6019(String var1, DisplayMetrics var2, int var3) {
        if(this.auo.containsKey(var1)) {
            var3 = Dimension.method_3097(this.auo.getLong(var1), var2);
        }

        return var3;
    }

    // $FF: renamed from: aa (android.content.Context) void
    public void method_6020(Context var1) {
        int var2;
        if(this.aup <= 0) {
            var2 = class_492.style.WalletFragmentDefaultStyle;
        } else {
            var2 = this.aup;
        }

        TypedArray var3 = var1.obtainStyledAttributes(var2, class_492.styleable.WalletFragmentStyle);
        this.method_6016(var3, class_492.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
        this.method_6016(var3, class_492.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
        this.method_6018(var3, class_492.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
        this.method_6018(var3, class_492.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
        this.method_6018(var3, class_492.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
        this.method_6018(var3, class_492.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
        this.method_6017(var3, class_492.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
        this.method_6018(var3, class_492.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
        this.method_6017(var3, class_492.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
        this.method_6018(var3, class_492.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
        this.method_6018(var3, class_492.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
        var3.recycle();
    }

    public int describeContents() {
        return 0;
    }

    public WalletFragmentStyle setBuyButtonAppearance(int var1) {
        this.auo.putInt("buyButtonAppearance", var1);
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int var1) {
        this.auo.putLong("buyButtonHeight", Dimension.method_3100(var1));
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int var1, float var2) {
        this.auo.putLong("buyButtonHeight", Dimension.method_3098(var1, var2));
        return this;
    }

    public WalletFragmentStyle setBuyButtonText(int var1) {
        this.auo.putInt("buyButtonText", var1);
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int var1) {
        this.auo.putLong("buyButtonWidth", Dimension.method_3100(var1));
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int var1, float var2) {
        this.auo.putLong("buyButtonWidth", Dimension.method_3098(var1, var2));
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int var1) {
        this.auo.remove("maskedWalletDetailsBackgroundResource");
        this.auo.putInt("maskedWalletDetailsBackgroundColor", var1);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int var1) {
        this.auo.remove("maskedWalletDetailsBackgroundColor");
        this.auo.putInt("maskedWalletDetailsBackgroundResource", var1);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int var1) {
        this.auo.remove("maskedWalletDetailsButtonBackgroundResource");
        this.auo.putInt("maskedWalletDetailsButtonBackgroundColor", var1);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int var1) {
        this.auo.remove("maskedWalletDetailsButtonBackgroundColor");
        this.auo.putInt("maskedWalletDetailsButtonBackgroundResource", var1);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int var1) {
        this.auo.putInt("maskedWalletDetailsButtonTextAppearance", var1);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int var1) {
        this.auo.putInt("maskedWalletDetailsHeaderTextAppearance", var1);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int var1) {
        this.auo.putInt("maskedWalletDetailsLogoImageType", var1);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int var1) {
        this.auo.putInt("maskedWalletDetailsLogoTextColor", var1);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int var1) {
        this.auo.putInt("maskedWalletDetailsTextAppearance", var1);
        return this;
    }

    public WalletFragmentStyle setStyleResourceId(int var1) {
        this.aup = var1;
        return this;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_739.method_3982(this, var1, var2);
    }
}
