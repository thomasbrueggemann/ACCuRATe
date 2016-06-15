package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_189;

// $FF: renamed from: com.google.android.gms.internal.ax
public final class class_167 implements SafeParcelable {
   public static final class_189 CREATOR = new class_189();
   public final int backgroundColor;
   // $FF: renamed from: mB int
   public final int field_530;
   // $FF: renamed from: mC int
   public final int field_531;
   // $FF: renamed from: mD int
   public final int field_532;
   // $FF: renamed from: mE int
   public final int field_533;
   // $FF: renamed from: mF int
   public final int field_534;
   // $FF: renamed from: mG int
   public final int field_535;
   // $FF: renamed from: mH int
   public final int field_536;
   // $FF: renamed from: mI java.lang.String
   public final String field_537;
   // $FF: renamed from: mJ int
   public final int field_538;
   // $FF: renamed from: mK java.lang.String
   public final String field_539;
   // $FF: renamed from: mL int
   public final int field_540;
   // $FF: renamed from: mM int
   public final int field_541;
   // $FF: renamed from: mN java.lang.String
   public final String field_542;
   public final int versionCode;

   class_167(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, String var10, int var11, String var12, int var13, int var14, String var15) {
      this.versionCode = var1;
      this.field_530 = var2;
      this.backgroundColor = var3;
      this.field_531 = var4;
      this.field_532 = var5;
      this.field_533 = var6;
      this.field_534 = var7;
      this.field_535 = var8;
      this.field_536 = var9;
      this.field_537 = var10;
      this.field_538 = var11;
      this.field_539 = var12;
      this.field_540 = var13;
      this.field_541 = var14;
      this.field_542 = var15;
   }

   public class_167(SearchAdRequest var1) {
      this.versionCode = 1;
      this.field_530 = var1.getAnchorTextColor();
      this.backgroundColor = var1.getBackgroundColor();
      this.field_531 = var1.getBackgroundGradientBottom();
      this.field_532 = var1.getBackgroundGradientTop();
      this.field_533 = var1.getBorderColor();
      this.field_534 = var1.getBorderThickness();
      this.field_535 = var1.getBorderType();
      this.field_536 = var1.getCallButtonColor();
      this.field_537 = var1.getCustomChannels();
      this.field_538 = var1.getDescriptionTextColor();
      this.field_539 = var1.getFontFace();
      this.field_540 = var1.getHeaderTextColor();
      this.field_541 = var1.getHeaderTextSize();
      this.field_542 = var1.getQuery();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_189.method_1302(this, var1, var2);
   }
}
