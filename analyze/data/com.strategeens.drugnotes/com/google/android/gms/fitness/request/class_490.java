package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ad;
import com.google.android.gms.fitness.request.class_338;
import com.google.android.gms.fitness.request.class_491;
import com.google.android.gms.fitness.request.class_54;

// $FF: renamed from: com.google.android.gms.fitness.request.ad
public class class_490 implements SafeParcelable {
   public static final Creator<ad> CREATOR = new class_491();
   // $FF: renamed from: CK int
   private final int field_1838;
   // $FF: renamed from: Wm com.google.android.gms.fitness.request.l
   private final class_54 field_1839;

   class_490(int var1, IBinder var2) {
      this.field_1838 = var1;
      this.field_1839 = class_54.class_1099.method_2318(var2);
   }

   public class_490(BleScanCallback var1) {
      this.field_1838 = 1;
      this.field_1839 = class_338.class_1321.method_3405().method_3407(var1);
   }

   public int describeContents() {
      return 0;
   }

   int getVersionCode() {
      return this.field_1838;
   }

   // $FF: renamed from: km () android.os.IBinder
   public IBinder method_3091() {
      return this.field_1839.asBinder();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_491.method_3093(this, var1, var2);
   }
}
