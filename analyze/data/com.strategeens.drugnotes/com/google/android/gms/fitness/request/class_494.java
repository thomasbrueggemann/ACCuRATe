package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.aa;
import com.google.android.gms.fitness.request.class_492;
import com.google.android.gms.internal.class_336;

// $FF: renamed from: com.google.android.gms.fitness.request.aa
public class class_494 implements SafeParcelable {
   public static final Creator<aa> CREATOR = new class_492();
   // $FF: renamed from: CK int
   private final int field_1851;
   private final PendingIntent mPendingIntent;

   class_494(int var1, PendingIntent var2) {
      this.field_1851 = var1;
      this.mPendingIntent = var2;
   }

   public class_494(PendingIntent var1) {
      this.field_1851 = 3;
      this.mPendingIntent = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.request.aa) boolean
   private boolean method_3113(class_494 var1) {
      return class_336.equal(this.mPendingIntent, var1.mPendingIntent);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof class_494 && this.method_3113((class_494)var1);
   }

   int getVersionCode() {
      return this.field_1851;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.mPendingIntent};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: kb () android.app.PendingIntent
   public PendingIntent method_3114() {
      return this.mPendingIntent;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("pendingIntent", this.mPendingIntent).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_492.method_3096(this, var1, var2);
   }
}
