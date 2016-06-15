package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.class_525;
import com.google.android.gms.maps.model.internal.class_526;

// $FF: renamed from: com.google.android.gms.maps.model.internal.e
public final class class_528 implements SafeParcelable {
   public static final class_525 CREATOR = new class_525();
   // $FF: renamed from: CK int
   private final int field_2486;
   private class_526 amM;

   public class_528() {
      this.field_2486 = 1;
   }

   class_528(int var1, class_526 var2) {
      this.field_2486 = var1;
      this.amM = var2;
   }

   public int describeContents() {
      return 0;
   }

   int getVersionCode() {
      return this.field_2486;
   }

   // $FF: renamed from: oj () com.google.android.gms.maps.model.internal.a
   public class_526 method_3252() {
      return this.amM;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_525.method_3239(this, var1, var2);
   }
}
