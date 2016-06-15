package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_1030;
import com.google.android.gms.drive.query.Query;

public class QueryRequest implements SafeParcelable {
   public static final Creator<QueryRequest> CREATOR = new class_1030();
   // $FF: renamed from: CK int
   final int field_4294;
   // $FF: renamed from: QV com.google.android.gms.drive.query.Query
   final Query field_4295;

   QueryRequest(int var1, Query var2) {
      this.field_4294 = var1;
      this.field_4295 = var2;
   }

   public QueryRequest(Query var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1030.method_5643(this, var1, var2);
   }
}
