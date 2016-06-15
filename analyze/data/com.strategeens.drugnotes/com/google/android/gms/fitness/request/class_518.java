package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.class_193;
import com.google.android.gms.fitness.request.class_517;
import com.google.android.gms.fitness.request.q;

// $FF: renamed from: com.google.android.gms.fitness.request.q
public class class_518 implements SafeParcelable {
   public static final Creator<q> CREATOR = new class_517();
   // $FF: renamed from: CK int
   private final int field_1919;
   // $FF: renamed from: VW com.google.android.gms.fitness.data.k
   private final class_193 field_1920;
   private final PendingIntent mPendingIntent;

   class_518(int var1, IBinder var2, PendingIntent var3) {
      this.field_1919 = var1;
      class_193 var4;
      if(var2 == null) {
         var4 = null;
      } else {
         var4 = class_193.class_1212.method_3082(var2);
      }

      this.field_1920 = var4;
      this.mPendingIntent = var3;
   }

   public class_518(class_193 var1, PendingIntent var2) {
      this.field_1919 = 2;
      this.field_1920 = var1;
      this.mPendingIntent = var2;
   }

   public int describeContents() {
      return 0;
   }

   int getVersionCode() {
      return this.field_1919;
   }

   // $FF: renamed from: kb () android.app.PendingIntent
   public PendingIntent method_3216() {
      return this.mPendingIntent;
   }

   // $FF: renamed from: kg () android.os.IBinder
   IBinder method_3217() {
      return this.field_1920 == null?null:this.field_1920.asBinder();
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_1920};
      return String.format("SensorUnregistrationRequest{%s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_517.method_3213(this, var1, var2);
   }
}
