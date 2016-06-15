package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ar;
import com.google.android.gms.wearable.internal.class_187;
import com.google.android.gms.wearable.internal.class_994;

// $FF: renamed from: com.google.android.gms.wearable.internal.ar
public class class_983 implements SafeParcelable {
   public static final Creator<ar> CREATOR = new class_994();
   // $FF: renamed from: CK int
   final int field_4251;
   public final class_187 axv;

   class_983(int var1, IBinder var2) {
      this.field_4251 = var1;
      if(var2 != null) {
         this.axv = class_187.class_1336.method_3413(var2);
      } else {
         this.axv = null;
      }
   }

   public class_983(class_187 var1) {
      this.field_4251 = 1;
      this.axv = var1;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: rm () android.os.IBinder
   IBinder method_5476() {
      return this.axv == null?null:this.axv.asBinder();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_994.method_5488(this, var1, var2);
   }
}
