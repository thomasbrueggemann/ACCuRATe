package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.class_443;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;
import com.google.android.gms.wallet.fragment.class_583;

public final class WalletFragmentOptions implements SafeParcelable {
   public static final Creator<WalletFragmentOptions> CREATOR = new class_583();
   // $FF: renamed from: Hv int
   private int field_4235;
   private int ajY;
   private WalletFragmentStyle akz;
   private int mTheme;
   // $FF: renamed from: xJ int
   final int field_4236;

   private WalletFragmentOptions() {
      this.field_4236 = 1;
   }

   WalletFragmentOptions(int var1, int var2, int var3, WalletFragmentStyle var4, int var5) {
      this.field_4236 = var1;
      this.ajY = var2;
      this.mTheme = var3;
      this.akz = var4;
      this.field_4235 = var5;
   }

   // $FF: renamed from: a (android.content.Context, android.util.AttributeSet) com.google.android.gms.wallet.fragment.WalletFragmentOptions
   public static WalletFragmentOptions method_4480(Context var0, AttributeSet var1) {
      TypedArray var2 = var0.obtainStyledAttributes(var1, class_443.styleable.WalletFragmentOptions);
      int var3 = var2.getInt(0, 0);
      int var4 = var2.getInt(1, 1);
      int var5 = var2.getResourceId(2, 0);
      int var6 = var2.getInt(3, 1);
      var2.recycle();
      WalletFragmentOptions var7 = new WalletFragmentOptions();
      var7.mTheme = var3;
      var7.ajY = var4;
      var7.akz = (new WalletFragmentStyle()).setStyleResourceId(var5);
      var7.akz.method_4600(var0);
      var7.field_4235 = var6;
      return var7;
   }

   public static WalletFragmentOptions.Builder newBuilder() {
      WalletFragmentOptions var0 = new WalletFragmentOptions();
      return var0.new Builder();
   }

   // $FF: renamed from: N (android.content.Context) void
   public void method_4484(Context var1) {
      if(this.akz != null) {
         this.akz.method_4600(var1);
      }

   }

   public int describeContents() {
      return 0;
   }

   public int getEnvironment() {
      return this.ajY;
   }

   public WalletFragmentStyle getFragmentStyle() {
      return this.akz;
   }

   public int getMode() {
      return this.field_4235;
   }

   public int getTheme() {
      return this.mTheme;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_583.method_3264(this, var1, var2);
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
         WalletFragmentOptions.this.ajY = var1;
         return this;
      }

      public WalletFragmentOptions.Builder setFragmentStyle(int var1) {
         WalletFragmentOptions.this.akz = (new WalletFragmentStyle()).setStyleResourceId(var1);
         return this;
      }

      public WalletFragmentOptions.Builder setFragmentStyle(WalletFragmentStyle var1) {
         WalletFragmentOptions.this.akz = var1;
         return this;
      }

      public WalletFragmentOptions.Builder setMode(int var1) {
         WalletFragmentOptions.this.field_4235 = var1;
         return this;
      }

      public WalletFragmentOptions.Builder setTheme(int var1) {
         WalletFragmentOptions.this.mTheme = var1;
         return this;
      }
   }
}
