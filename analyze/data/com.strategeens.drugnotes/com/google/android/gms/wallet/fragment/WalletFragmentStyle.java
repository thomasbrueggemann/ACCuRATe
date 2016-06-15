package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.class_482;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.class_689;

public final class WalletFragmentStyle implements SafeParcelable {
   public static final Creator<WalletFragmentStyle> CREATOR = new class_689();
   // $FF: renamed from: CK int
   final int field_4508;
   Bundle awy;
   int awz;

   public WalletFragmentStyle() {
      this.field_4508 = 1;
      this.awy = new Bundle();
   }

   WalletFragmentStyle(int var1, Bundle var2, int var3) {
      this.field_4508 = var1;
      this.awy = var2;
      this.awz = var3;
   }

   // $FF: renamed from: a (android.content.res.TypedArray, int, java.lang.String) void
   private void method_5859(TypedArray var1, int var2, String var3) {
      if(!this.awy.containsKey(var3)) {
         TypedValue var4 = var1.peekValue(var2);
         if(var4 != null) {
            this.awy.putLong(var3, Dimension.method_3142(var4));
            return;
         }
      }

   }

   // $FF: renamed from: a (android.content.res.TypedArray, int, java.lang.String, java.lang.String) void
   private void method_5860(TypedArray var1, int var2, String var3, String var4) {
      if(!this.awy.containsKey(var3) && !this.awy.containsKey(var4)) {
         TypedValue var5 = var1.peekValue(var2);
         if(var5 != null) {
            if(var5.type >= 28 && var5.type <= 31) {
               this.awy.putInt(var3, var5.data);
               return;
            }

            this.awy.putInt(var4, var5.resourceId);
            return;
         }
      }

   }

   // $FF: renamed from: b (android.content.res.TypedArray, int, java.lang.String) void
   private void method_5861(TypedArray var1, int var2, String var3) {
      if(!this.awy.containsKey(var3)) {
         TypedValue var4 = var1.peekValue(var2);
         if(var4 != null) {
            this.awy.putInt(var3, var4.data);
            return;
         }
      }

   }

   // $FF: renamed from: a (java.lang.String, android.util.DisplayMetrics, int) int
   public int method_5862(String var1, DisplayMetrics var2, int var3) {
      if(this.awy.containsKey(var1)) {
         var3 = Dimension.method_3140(this.awy.getLong(var1), var2);
      }

      return var3;
   }

   // $FF: renamed from: ab (android.content.Context) void
   public void method_5863(Context var1) {
      int var2;
      if(this.awz <= 0) {
         var2 = class_482.style.WalletFragmentDefaultStyle;
      } else {
         var2 = this.awz;
      }

      TypedArray var3 = var1.obtainStyledAttributes(var2, class_482.styleable.WalletFragmentStyle);
      this.method_5859(var3, class_482.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
      this.method_5859(var3, class_482.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
      this.method_5861(var3, class_482.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
      this.method_5861(var3, class_482.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
      this.method_5861(var3, class_482.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
      this.method_5861(var3, class_482.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
      this.method_5860(var3, class_482.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
      this.method_5861(var3, class_482.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
      this.method_5860(var3, class_482.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
      this.method_5861(var3, class_482.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
      this.method_5861(var3, class_482.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
      var3.recycle();
   }

   public int describeContents() {
      return 0;
   }

   public WalletFragmentStyle setBuyButtonAppearance(int var1) {
      this.awy.putInt("buyButtonAppearance", var1);
      return this;
   }

   public WalletFragmentStyle setBuyButtonHeight(int var1) {
      this.awy.putLong("buyButtonHeight", Dimension.method_3143(var1));
      return this;
   }

   public WalletFragmentStyle setBuyButtonHeight(int var1, float var2) {
      this.awy.putLong("buyButtonHeight", Dimension.method_3141(var1, var2));
      return this;
   }

   public WalletFragmentStyle setBuyButtonText(int var1) {
      this.awy.putInt("buyButtonText", var1);
      return this;
   }

   public WalletFragmentStyle setBuyButtonWidth(int var1) {
      this.awy.putLong("buyButtonWidth", Dimension.method_3143(var1));
      return this;
   }

   public WalletFragmentStyle setBuyButtonWidth(int var1, float var2) {
      this.awy.putLong("buyButtonWidth", Dimension.method_3141(var1, var2));
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int var1) {
      this.awy.remove("maskedWalletDetailsBackgroundResource");
      this.awy.putInt("maskedWalletDetailsBackgroundColor", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int var1) {
      this.awy.remove("maskedWalletDetailsBackgroundColor");
      this.awy.putInt("maskedWalletDetailsBackgroundResource", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int var1) {
      this.awy.remove("maskedWalletDetailsButtonBackgroundResource");
      this.awy.putInt("maskedWalletDetailsButtonBackgroundColor", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int var1) {
      this.awy.remove("maskedWalletDetailsButtonBackgroundColor");
      this.awy.putInt("maskedWalletDetailsButtonBackgroundResource", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int var1) {
      this.awy.putInt("maskedWalletDetailsButtonTextAppearance", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int var1) {
      this.awy.putInt("maskedWalletDetailsHeaderTextAppearance", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int var1) {
      this.awy.putInt("maskedWalletDetailsLogoImageType", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int var1) {
      this.awy.putInt("maskedWalletDetailsLogoTextColor", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int var1) {
      this.awy.putInt("maskedWalletDetailsTextAppearance", var1);
      return this;
   }

   public WalletFragmentStyle setStyleResourceId(int var1) {
      this.awz = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_689.method_3883(this, var1, var2);
   }
}
