package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.class_527;

// $FF: renamed from: com.google.android.gms.maps.model.internal.c
public final class class_530 implements SafeParcelable {
   public static final class_527 CREATOR = new class_527();
   // $FF: renamed from: CK int
   private final int field_2487;
   private Bundle amK;
   private int type;

   class_530(int var1, int var2, Bundle var3) {
      this.field_2487 = var1;
      this.type = var2;
      this.amK = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getType() {
      return this.type;
   }

   public int getVersionCode() {
      return this.field_2487;
   }

   // $FF: renamed from: oi () android.os.Bundle
   public Bundle method_3256() {
      return this.amK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_527.method_3247(this, var1, var2);
   }
}
