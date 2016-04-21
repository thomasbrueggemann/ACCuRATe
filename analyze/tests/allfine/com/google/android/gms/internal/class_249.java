package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_250;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.bj
@ez
public final class class_249 implements SafeParcelable {
    public static final class_250 CREATOR = new class_250();
    public final int backgroundColor;
    // $FF: renamed from: oH int
    public final int field_684;
    // $FF: renamed from: oI int
    public final int field_685;
    // $FF: renamed from: oJ int
    public final int field_686;
    // $FF: renamed from: oK int
    public final int field_687;
    // $FF: renamed from: oL int
    public final int field_688;
    // $FF: renamed from: oM int
    public final int field_689;
    // $FF: renamed from: oN int
    public final int field_690;
    // $FF: renamed from: oO java.lang.String
    public final String field_691;
    // $FF: renamed from: oP int
    public final int field_692;
    // $FF: renamed from: oQ java.lang.String
    public final String field_693;
    // $FF: renamed from: oR int
    public final int field_694;
    // $FF: renamed from: oS int
    public final int field_695;
    // $FF: renamed from: oT java.lang.String
    public final String field_696;
    public final int versionCode;

    class_249(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, String var10, int var11, String var12, int var13, int var14, String var15) {
        this.versionCode = var1;
        this.field_684 = var2;
        this.backgroundColor = var3;
        this.field_685 = var4;
        this.field_686 = var5;
        this.field_687 = var6;
        this.field_688 = var7;
        this.field_689 = var8;
        this.field_690 = var9;
        this.field_691 = var10;
        this.field_692 = var11;
        this.field_693 = var12;
        this.field_694 = var13;
        this.field_695 = var14;
        this.field_696 = var15;
    }

    public class_249(SearchAdRequest var1) {
        this.versionCode = 1;
        this.field_684 = var1.getAnchorTextColor();
        this.backgroundColor = var1.getBackgroundColor();
        this.field_685 = var1.getBackgroundGradientBottom();
        this.field_686 = var1.getBackgroundGradientTop();
        this.field_687 = var1.getBorderColor();
        this.field_688 = var1.getBorderThickness();
        this.field_689 = var1.getBorderType();
        this.field_690 = var1.getCallButtonColor();
        this.field_691 = var1.getCustomChannels();
        this.field_692 = var1.getDescriptionTextColor();
        this.field_693 = var1.getFontFace();
        this.field_694 = var1.getHeaderTextColor();
        this.field_695 = var1.getHeaderTextSize();
        this.field_696 = var1.getQuery();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_250.method_1604(this, var1, var2);
    }
}
