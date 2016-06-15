package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.class_737;

public class NotFilter implements SafeParcelable, Filter {
   public static final Creator<NotFilter> CREATOR = new class_737();
   // $FF: renamed from: KW com.google.android.gms.drive.query.internal.FilterHolder
   final FilterHolder field_2045;
   // $FF: renamed from: xJ int
   final int field_2046;

   NotFilter(int var1, FilterHolder var2) {
      this.field_2046 = var1;
      this.field_2045 = var2;
   }

   public NotFilter(Filter var1) {
      this(1, new FilterHolder(var1));
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_737.method_4152(this, var1, var2);
   }
}
