package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.class_956;
import com.google.android.gms.drive.query.internal.f;

public class MatchAllFilter extends AbstractFilter {
   public static final class_956 CREATOR = new class_956();
   // $FF: renamed from: CK int
   final int field_1718;

   public MatchAllFilter() {
      this(1);
   }

   MatchAllFilter(int var1) {
      this.field_1718 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.f) java.lang.Object
   public <F> F method_7(f<F> var1) {
      return var1.method_931();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_956.method_5265(this, var1, var2);
   }
}
