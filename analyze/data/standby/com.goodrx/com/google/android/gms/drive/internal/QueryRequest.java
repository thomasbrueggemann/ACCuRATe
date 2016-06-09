package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzbo;
import com.google.android.gms.drive.query.Query;

public class QueryRequest implements SafeParcelable {
   public static final Creator<QueryRequest> CREATOR = new zzbo();
   final int mVersionCode;
   final Query zzasB;

   QueryRequest(int var1, Query var2) {
      this.mVersionCode = var1;
      this.zzasB = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbo.zza(this, var1, var2);
   }
}
