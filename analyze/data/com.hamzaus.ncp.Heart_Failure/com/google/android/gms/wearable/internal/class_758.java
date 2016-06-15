package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ao;
import com.google.android.gms.wearable.internal.class_150;
import com.google.android.gms.wearable.internal.class_757;

// $FF: renamed from: com.google.android.gms.wearable.internal.ao
public class class_758 implements SafeParcelable {
   public static final Creator<ao> CREATOR = new class_757();
   public final class_150 alw;
   // $FF: renamed from: xJ int
   final int field_4111;

   class_758(int var1, IBinder var2) {
      this.field_4111 = var1;
      if(var2 != null) {
         this.alw = class_150.class_1306.method_3168(var2);
      } else {
         this.alw = null;
      }
   }

   public class_758(class_150 var1) {
      this.field_4111 = 1;
      this.alw = var1;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: nj () android.os.IBinder
   IBinder method_4330() {
      return this.alw == null?null:this.alw.asBinder();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_757.method_4327(this, var1, var2);
   }
}
