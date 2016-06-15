package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.ah;
import com.google.android.gms.fitness.request.class_487;

// $FF: renamed from: com.google.android.gms.fitness.request.ah
public class class_486 implements SafeParcelable {
   public static final Creator<ah> CREATOR = new class_487();
   // $FF: renamed from: CK int
   private final int field_1831;
   // $FF: renamed from: VF java.lang.String
   private final String field_1832;

   class_486(int var1, String var2) {
      this.field_1831 = var1;
      this.field_1832 = var2;
   }

   public class_486(String var1) {
      this(3, var1);
   }

   public int describeContents() {
      return 0;
   }

   public String getDeviceAddress() {
      return this.field_1832;
   }

   int getVersionCode() {
      return this.field_1831;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_1832};
      return String.format("UnclaimBleDeviceRequest{%s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_487.method_3083(this, var1, var2);
   }
}
