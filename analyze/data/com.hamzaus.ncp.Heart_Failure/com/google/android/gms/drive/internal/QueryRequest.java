package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_780;
import com.google.android.gms.drive.query.Query;

public class QueryRequest implements SafeParcelable {
   public static final Creator<QueryRequest> CREATOR = new class_780();
   // $FF: renamed from: JB com.google.android.gms.drive.query.Query
   final Query field_4146;
   // $FF: renamed from: xJ int
   final int field_4147;

   QueryRequest(int var1, Query var2) {
      this.field_4147 = var1;
      this.field_4146 = var2;
   }

   public QueryRequest(Query var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_780.method_4377(this, var1, var2);
   }
}
