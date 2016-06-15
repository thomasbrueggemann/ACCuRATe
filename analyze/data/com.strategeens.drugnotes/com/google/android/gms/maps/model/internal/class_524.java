package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.class_523;
import com.google.android.gms.maps.model.internal.class_526;

// $FF: renamed from: com.google.android.gms.maps.model.internal.p
public final class class_524 implements SafeParcelable {
   public static final class_523 CREATOR = new class_523();
   // $FF: renamed from: CK int
   private final int field_2475;
   private class_526 amN;

   public class_524() {
      this.field_2475 = 1;
   }

   class_524(int var1, class_526 var2) {
      this.field_2475 = var1;
      this.amN = var2;
   }

   public int describeContents() {
      return 0;
   }

   int getVersionCode() {
      return this.field_2475;
   }

   // $FF: renamed from: ol () com.google.android.gms.maps.model.internal.a
   public class_526 method_3237() {
      return this.amN;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_523.method_3234(this, var1, var2);
   }
}
