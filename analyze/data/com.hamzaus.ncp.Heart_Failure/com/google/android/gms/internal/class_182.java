package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ax;
import com.google.android.gms.internal.class_167;
import com.google.android.gms.internal.class_174;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.aj
public final class class_182 implements SafeParcelable {
   public static final class_174 CREATOR = new class_174();
   public final Bundle extras;
   // $FF: renamed from: lQ long
   public final long field_579;
   // $FF: renamed from: lR int
   public final int field_580;
   // $FF: renamed from: lS java.util.List
   public final List<String> field_581;
   // $FF: renamed from: lT boolean
   public final boolean field_582;
   // $FF: renamed from: lU int
   public final int field_583;
   // $FF: renamed from: lV boolean
   public final boolean field_584;
   // $FF: renamed from: lW java.lang.String
   public final String field_585;
   // $FF: renamed from: lX com.google.android.gms.internal.ax
   public final class_167 field_586;
   // $FF: renamed from: lY android.location.Location
   public final Location field_587;
   // $FF: renamed from: lZ java.lang.String
   public final String field_588;
   // $FF: renamed from: ma android.os.Bundle
   public final Bundle field_589;
   public final int versionCode;

   public class_182(int var1, long var2, Bundle var4, int var5, List<String> var6, boolean var7, int var8, boolean var9, String var10, ax var11, Location var12, String var13, Bundle var14) {
      this.versionCode = var1;
      this.field_579 = var2;
      this.extras = var4;
      this.field_580 = var5;
      this.field_581 = var6;
      this.field_582 = var7;
      this.field_583 = var8;
      this.field_584 = var9;
      this.field_585 = var10;
      this.field_586 = var11;
      this.field_587 = var12;
      this.field_588 = var13;
      this.field_589 = var14;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_174.method_1271(this, var1, var2);
   }
}
