package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.class_482;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;
import com.google.android.gms.wallet.fragment.class_687;

public final class WalletFragmentOptions implements SafeParcelable {
   public static final Creator<WalletFragmentOptions> CREATOR = new class_687();
   // $FF: renamed from: CK int
   final int field_4388;
   // $FF: renamed from: Oi int
   private int field_4389;
   private int avV;
   private WalletFragmentStyle aww;
   private int mTheme;

   private WalletFragmentOptions() {
      this.field_4388 = 1;
   }

   WalletFragmentOptions(int var1, int var2, int var3, WalletFragmentStyle var4, int var5) {
      this.field_4388 = var1;
      this.avV = var2;
      this.mTheme = var3;
      this.aww = var4;
      this.field_4389 = var5;
   }

   // $FF: renamed from: a (android.content.Context, android.util.AttributeSet) com.google.android.gms.wallet.fragment.WalletFragmentOptions
   public static WalletFragmentOptions method_5704(Context var0, AttributeSet var1) {
      TypedArray var2 = var0.obtainStyledAttributes(var1, class_482.styleable.WalletFragmentOptions);
      int var3 = var2.getInt(class_482.styleable.WalletFragmentOptions_appTheme, 0);
      int var4 = var2.getInt(class_482.styleable.WalletFragmentOptions_environment, 1);
      int var5 = var2.getResourceId(class_482.styleable.WalletFragmentOptions_fragmentStyle, 0);
      int var6 = var2.getInt(class_482.styleable.WalletFragmentOptions_fragmentMode, 1);
      var2.recycle();
      WalletFragmentOptions var7 = new WalletFragmentOptions();
      var7.mTheme = var3;
      var7.avV = var4;
      var7.aww = (new WalletFragmentStyle()).setStyleResourceId(var5);
      var7.aww.method_5863(var0);
      var7.field_4389 = var6;
      return var7;
   }

   public static WalletFragmentOptions.Builder newBuilder() {
      WalletFragmentOptions var0 = new WalletFragmentOptions();
      return var0.new Builder();
   }

   // $FF: renamed from: ab (android.content.Context) void
   public void method_5708(Context var1) {
      if(this.aww != null) {
         this.aww.method_5863(var1);
      }

   }

   public int describeContents() {
      return 0;
   }

   public int getEnvironment() {
      return this.avV;
   }

   public WalletFragmentStyle getFragmentStyle() {
      return this.aww;
   }

   public int getMode() {
      return this.field_4389;
   }

   public int getTheme() {
      return this.mTheme;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_687.method_3877(this, var1, var2);
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
         WalletFragmentOptions.this.avV = var1;
         return this;
      }

      public WalletFragmentOptions.Builder setFragmentStyle(int var1) {
         WalletFragmentOptions.this.aww = (new WalletFragmentStyle()).setStyleResourceId(var1);
         return this;
      }

      public WalletFragmentOptions.Builder setFragmentStyle(WalletFragmentStyle var1) {
         WalletFragmentOptions.this.aww = var1;
         return this;
      }

      public WalletFragmentOptions.Builder setMode(int var1) {
         WalletFragmentOptions.this.field_4389 = var1;
         return this;
      }

      public WalletFragmentOptions.Builder setTheme(int var1) {
         WalletFragmentOptions.this.mTheme = var1;
         return this;
      }
   }
}
