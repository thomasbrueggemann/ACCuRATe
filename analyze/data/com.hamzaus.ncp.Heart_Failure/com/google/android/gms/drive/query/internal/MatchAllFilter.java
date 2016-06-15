package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.class_738;

public class MatchAllFilter implements SafeParcelable, Filter {
   public static final class_738 CREATOR = new class_738();
   // $FF: renamed from: xJ int
   final int field_3475;

   public MatchAllFilter() {
      this(1);
   }

   MatchAllFilter(int var1) {
      this.field_3475 = var1;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_738.method_4155(this, var1, var2);
   }
}
