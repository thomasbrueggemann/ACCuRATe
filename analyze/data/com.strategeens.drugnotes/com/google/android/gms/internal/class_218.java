package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.bj;
import com.google.android.gms.internal.class_209;
import com.google.android.gms.internal.class_245;
import com.google.android.gms.internal.ey;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.av
@ey
public final class class_218 implements SafeParcelable {
   public static final class_209 CREATOR = new class_209();
   public final Bundle extras;
   // $FF: renamed from: od long
   public final long field_357;
   // $FF: renamed from: oe int
   public final int field_358;
   // $FF: renamed from: of java.util.List
   public final List<String> field_359;
   // $FF: renamed from: og boolean
   public final boolean field_360;
   // $FF: renamed from: oh int
   public final int field_361;
   // $FF: renamed from: oi boolean
   public final boolean field_362;
   // $FF: renamed from: oj java.lang.String
   public final String field_363;
   // $FF: renamed from: ok com.google.android.gms.internal.bj
   public final class_245 field_364;
   // $FF: renamed from: ol android.location.Location
   public final Location field_365;
   // $FF: renamed from: om java.lang.String
   public final String field_366;
   // $FF: renamed from: on android.os.Bundle
   public final Bundle field_367;
   public final int versionCode;

   public class_218(int var1, long var2, Bundle var4, int var5, List<String> var6, boolean var7, int var8, boolean var9, String var10, bj var11, Location var12, String var13, Bundle var14) {
      this.versionCode = var1;
      this.field_357 = var2;
      this.extras = var4;
      this.field_358 = var5;
      this.field_359 = var6;
      this.field_360 = var7;
      this.field_361 = var8;
      this.field_362 = var9;
      this.field_363 = var10;
      this.field_364 = var11;
      this.field_365 = var12;
      this.field_366 = var13;
      this.field_367 = var14;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_209.method_1505(this, var1, var2);
   }
}
