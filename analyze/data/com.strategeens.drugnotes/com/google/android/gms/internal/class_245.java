package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.bj
@ey
public final class class_245 implements SafeParcelable {
   public static final class_246 CREATOR = new class_246();
   public final int backgroundColor;
   // $FF: renamed from: oQ int
   public final int field_491;
   // $FF: renamed from: oR int
   public final int field_492;
   // $FF: renamed from: oS int
   public final int field_493;
   // $FF: renamed from: oT int
   public final int field_494;
   // $FF: renamed from: oU int
   public final int field_495;
   // $FF: renamed from: oV int
   public final int field_496;
   // $FF: renamed from: oW int
   public final int field_497;
   // $FF: renamed from: oX java.lang.String
   public final String field_498;
   // $FF: renamed from: oY int
   public final int field_499;
   // $FF: renamed from: oZ java.lang.String
   public final String field_500;
   // $FF: renamed from: pa int
   public final int field_501;
   // $FF: renamed from: pb int
   public final int field_502;
   // $FF: renamed from: pc java.lang.String
   public final String field_503;
   public final int versionCode;

   class_245(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, String var10, int var11, String var12, int var13, int var14, String var15) {
      this.versionCode = var1;
      this.field_491 = var2;
      this.backgroundColor = var3;
      this.field_492 = var4;
      this.field_493 = var5;
      this.field_494 = var6;
      this.field_495 = var7;
      this.field_496 = var8;
      this.field_497 = var9;
      this.field_498 = var10;
      this.field_499 = var11;
      this.field_500 = var12;
      this.field_501 = var13;
      this.field_502 = var14;
      this.field_503 = var15;
   }

   public class_245(SearchAdRequest var1) {
      this.versionCode = 1;
      this.field_491 = var1.getAnchorTextColor();
      this.backgroundColor = var1.getBackgroundColor();
      this.field_492 = var1.getBackgroundGradientBottom();
      this.field_493 = var1.getBackgroundGradientTop();
      this.field_494 = var1.getBorderColor();
      this.field_495 = var1.getBorderThickness();
      this.field_496 = var1.getBorderType();
      this.field_497 = var1.getCallButtonColor();
      this.field_498 = var1.getCustomChannels();
      this.field_499 = var1.getDescriptionTextColor();
      this.field_500 = var1.getFontFace();
      this.field_501 = var1.getHeaderTextColor();
      this.field_502 = var1.getHeaderTextSize();
      this.field_503 = var1.getQuery();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_246.method_1616(this, var1, var2);
   }
}
