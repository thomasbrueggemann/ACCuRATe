package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.b;
import com.google.android.gms.wearable.internal.class_187;
import com.google.android.gms.wearable.internal.class_558;
import com.google.android.gms.wearable.internal.class_924;

// $FF: renamed from: com.google.android.gms.wearable.internal.b
public class class_923 implements SafeParcelable {
   public static final Creator<b> CREATOR = new class_924();
   // $FF: renamed from: CK int
   final int field_3847;
   public final class_187 axv;
   public final IntentFilter[] axw;

   class_923(int var1, IBinder var2, IntentFilter[] var3) {
      this.field_3847 = var1;
      if(var2 != null) {
         this.axv = class_187.class_1336.method_3413(var2);
      } else {
         this.axv = null;
      }

      this.axw = var3;
   }

   public class_923(class_558 var1) {
      this.field_3847 = 1;
      this.axv = var1;
      this.axw = var1.method_3417();
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: rm () android.os.IBinder
   IBinder method_5096() {
      return this.axv == null?null:this.axv.asBinder();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_924.method_5097(this, var1, var2);
   }
}
