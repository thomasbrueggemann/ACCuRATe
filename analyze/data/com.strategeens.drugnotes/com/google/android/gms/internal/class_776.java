package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.internal.class_777;
import com.google.android.gms.internal.ms;

// $FF: renamed from: com.google.android.gms.internal.ms
public class class_776 implements SafeParcelable {
   public static final Creator<ms> CREATOR = new class_777();
   // $FF: renamed from: CK int
   private final int field_3434;
   // $FF: renamed from: TN com.google.android.gms.fitness.data.DataSource
   private final DataSource field_3435;

   class_776(int var1, DataSource var2) {
      this.field_3434 = var1;
      this.field_3435 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public DataSource getDataSource() {
      return this.field_3435;
   }

   int getVersionCode() {
      return this.field_3434;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_3435};
      return String.format("ApplicationUnregistrationRequest{%s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_777.method_4395(this, var1, var2);
   }
}
