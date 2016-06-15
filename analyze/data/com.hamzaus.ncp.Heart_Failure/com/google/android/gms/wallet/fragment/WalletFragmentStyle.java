package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.class_443;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.fragment.Dimension;
import com.google.android.gms.wallet.fragment.class_585;

public final class WalletFragmentStyle implements SafeParcelable {
   public static final Creator<WalletFragmentStyle> CREATOR = new class_585();
   Bundle akB;
   int akC;
   // $FF: renamed from: xJ int
   final int field_4365;

   public WalletFragmentStyle() {
      this.field_4365 = 1;
      this.akB = new Bundle();
   }

   WalletFragmentStyle(int var1, Bundle var2, int var3) {
      this.field_4365 = var1;
      this.akB = var2;
      this.akC = var3;
   }

   // $FF: renamed from: a (android.content.res.TypedArray, int, java.lang.String) void
   private void method_4597(TypedArray var1, int var2, String var3) {
      if(!this.akB.containsKey(var3)) {
         TypedValue var4 = var1.peekValue(var2);
         if(var4 != null) {
            this.akB.putLong(var3, Dimension.method_2729(var4));
            return;
         }
      }

   }

   // $FF: renamed from: a (android.content.res.TypedArray, int, java.lang.String, java.lang.String) void
   private void method_4598(TypedArray var1, int var2, String var3, String var4) {
      if(!this.akB.containsKey(var3) && !this.akB.containsKey(var4)) {
         TypedValue var5 = var1.peekValue(var2);
         if(var5 != null) {
            if(var5.type >= 28 && var5.type <= 31) {
               this.akB.putInt(var3, var5.data);
               return;
            }

            this.akB.putInt(var4, var5.resourceId);
            return;
         }
      }

   }

   // $FF: renamed from: b (android.content.res.TypedArray, int, java.lang.String) void
   private void method_4599(TypedArray var1, int var2, String var3) {
      if(!this.akB.containsKey(var3)) {
         TypedValue var4 = var1.peekValue(var2);
         if(var4 != null) {
            this.akB.putInt(var3, var4.data);
            return;
         }
      }

   }

   // $FF: renamed from: N (android.content.Context) void
   public void method_4600(Context var1) {
      int var2;
      if(this.akC <= 0) {
         var2 = class_443.style.WalletFragmentDefaultStyle;
      } else {
         var2 = this.akC;
      }

      TypedArray var3 = var1.obtainStyledAttributes(var2, class_443.styleable.WalletFragmentStyle);
      this.method_4597(var3, 1, "buyButtonWidth");
      this.method_4597(var3, 0, "buyButtonHeight");
      this.method_4599(var3, 2, "buyButtonText");
      this.method_4599(var3, 3, "buyButtonAppearance");
      this.method_4599(var3, 4, "maskedWalletDetailsTextAppearance");
      this.method_4599(var3, 5, "maskedWalletDetailsHeaderTextAppearance");
      this.method_4598(var3, 6, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
      this.method_4599(var3, 7, "maskedWalletDetailsButtonTextAppearance");
      this.method_4598(var3, 8, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
      this.method_4599(var3, 9, "maskedWalletDetailsLogoTextColor");
      this.method_4599(var3, 10, "maskedWalletDetailsLogoImageType");
      var3.recycle();
   }

   // $FF: renamed from: a (java.lang.String, android.util.DisplayMetrics, int) int
   public int method_4601(String var1, DisplayMetrics var2, int var3) {
      if(this.akB.containsKey(var1)) {
         var3 = Dimension.method_2727(this.akB.getLong(var1), var2);
      }

      return var3;
   }

   public int describeContents() {
      return 0;
   }

   public WalletFragmentStyle setBuyButtonAppearance(int var1) {
      this.akB.putInt("buyButtonAppearance", var1);
      return this;
   }

   public WalletFragmentStyle setBuyButtonHeight(int var1) {
      this.akB.putLong("buyButtonHeight", Dimension.method_2730(var1));
      return this;
   }

   public WalletFragmentStyle setBuyButtonHeight(int var1, float var2) {
      this.akB.putLong("buyButtonHeight", Dimension.method_2728(var1, var2));
      return this;
   }

   public WalletFragmentStyle setBuyButtonText(int var1) {
      this.akB.putInt("buyButtonText", var1);
      return this;
   }

   public WalletFragmentStyle setBuyButtonWidth(int var1) {
      this.akB.putLong("buyButtonWidth", Dimension.method_2730(var1));
      return this;
   }

   public WalletFragmentStyle setBuyButtonWidth(int var1, float var2) {
      this.akB.putLong("buyButtonWidth", Dimension.method_2728(var1, var2));
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int var1) {
      this.akB.remove("maskedWalletDetailsBackgroundResource");
      this.akB.putInt("maskedWalletDetailsBackgroundColor", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int var1) {
      this.akB.remove("maskedWalletDetailsBackgroundColor");
      this.akB.putInt("maskedWalletDetailsBackgroundResource", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int var1) {
      this.akB.remove("maskedWalletDetailsButtonBackgroundResource");
      this.akB.putInt("maskedWalletDetailsButtonBackgroundColor", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int var1) {
      this.akB.remove("maskedWalletDetailsButtonBackgroundColor");
      this.akB.putInt("maskedWalletDetailsButtonBackgroundResource", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int var1) {
      this.akB.putInt("maskedWalletDetailsButtonTextAppearance", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int var1) {
      this.akB.putInt("maskedWalletDetailsHeaderTextAppearance", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int var1) {
      this.akB.putInt("maskedWalletDetailsLogoImageType", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int var1) {
      this.akB.putInt("maskedWalletDetailsLogoTextColor", var1);
      return this;
   }

   public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int var1) {
      this.akB.putInt("maskedWalletDetailsTextAppearance", var1);
      return this;
   }

   public WalletFragmentStyle setStyleResourceId(int var1) {
      this.akC = var1;
      return this;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_585.method_3270(this, var1, var2);
   }
}
