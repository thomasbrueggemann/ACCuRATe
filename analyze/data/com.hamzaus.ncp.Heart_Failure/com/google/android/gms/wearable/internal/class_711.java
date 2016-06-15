package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.b;
import com.google.android.gms.wearable.internal.class_150;
import com.google.android.gms.wearable.internal.class_568;
import com.google.android.gms.wearable.internal.class_712;

// $FF: renamed from: com.google.android.gms.wearable.internal.b
public class class_711 implements SafeParcelable {
   public static final Creator<b> CREATOR = new class_712();
   public final class_150 alw;
   public final IntentFilter[] alx;
   // $FF: renamed from: xJ int
   final int field_3706;

   class_711(int var1, IBinder var2, IntentFilter[] var3) {
      this.field_3706 = var1;
      if(var2 != null) {
         this.alw = class_150.class_1306.method_3168(var2);
      } else {
         this.alw = null;
      }

      this.alx = var3;
   }

   public class_711(class_568 var1) {
      this.field_3706 = 1;
      this.alw = var1;
      this.alx = var1.method_3172();
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: nj () android.os.IBinder
   IBinder method_4045() {
      return this.alw == null?null:this.alw.asBinder();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_712.method_4046(this, var1, var2);
   }
}
