package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.class_955;
import com.google.android.gms.drive.query.internal.f;

public class NotFilter extends AbstractFilter {
   public static final Creator<NotFilter> CREATOR = new class_955();
   // $FF: renamed from: CK int
   final int field_1719;
   // $FF: renamed from: Sv com.google.android.gms.drive.query.internal.FilterHolder
   final FilterHolder field_1720;

   NotFilter(int var1, FilterHolder var2) {
      this.field_1719 = var1;
      this.field_1720 = var2;
   }

   public NotFilter(Filter var1) {
      this(1, new FilterHolder(var1));
   }

   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.f) java.lang.Object
   public <T> T method_7(f<T> var1) {
      return var1.method_930(this.field_1720.getFilter().method_7(var1));
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_955.method_5262(this, var1, var2);
   }
}
