package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.class_513;
import com.google.android.gms.fitness.request.u;
import com.google.android.gms.internal.class_336;

// $FF: renamed from: com.google.android.gms.fitness.request.u
public class class_514 implements SafeParcelable {
   public static final Creator<u> CREATOR = new class_513();
   // $FF: renamed from: CK int
   private final int field_1918;
   private final PendingIntent mPendingIntent;

   class_514(int var1, PendingIntent var2) {
      this.field_1918 = var1;
      this.mPendingIntent = var2;
   }

   public class_514(PendingIntent var1) {
      this.field_1918 = 3;
      this.mPendingIntent = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.request.u) boolean
   private boolean method_3205(class_514 var1) {
      return class_336.equal(this.mPendingIntent, var1.mPendingIntent);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof class_514 && this.method_3205((class_514)var1);
   }

   int getVersionCode() {
      return this.field_1918;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.mPendingIntent};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: kb () android.app.PendingIntent
   public PendingIntent method_3206() {
      return this.mPendingIntent;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("pendingIntent", this.mPendingIntent).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_513.method_3202(this, var1, var2);
   }
}
