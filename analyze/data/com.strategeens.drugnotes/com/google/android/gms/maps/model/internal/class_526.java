package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.class_529;

// $FF: renamed from: com.google.android.gms.maps.model.internal.a
public final class class_526 implements SafeParcelable {
   public static final class_529 CREATOR = new class_529();
   // $FF: renamed from: CK int
   private final int field_2479;
   private byte amJ;
   private Bundle amK;
   private Bitmap amL;

   class_526(int var1, byte var2, Bundle var3, Bitmap var4) {
      this.field_2479 = var1;
      this.amJ = var2;
      this.amK = var3;
      this.amL = var4;
   }

   public int describeContents() {
      return 0;
   }

   public Bitmap getBitmap() {
      return this.amL;
   }

   public int getVersionCode() {
      return this.field_2479;
   }

   // $FF: renamed from: oh () byte
   public byte method_3245() {
      return this.amJ;
   }

   // $FF: renamed from: oi () android.os.Bundle
   public Bundle method_3246() {
      return this.amK;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_529.method_3253(this, var1, var2);
   }
}
