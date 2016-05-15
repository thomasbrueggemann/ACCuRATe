package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.zzb;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.List;
import java.util.Locale;

public class SortOrder implements SafeParcelable {
   public static final Creator<SortOrder> CREATOR = new zzb();
   final int mVersionCode;
   final List<FieldWithSortOrder> zzaud;
   final boolean zzaue;

   SortOrder(int var1, List<FieldWithSortOrder> var2, boolean var3) {
      this.mVersionCode = var1;
      this.zzaud = var2;
      this.zzaue = var3;
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{TextUtils.join(",", this.zzaud), Boolean.valueOf(this.zzaue)};
      return String.format(var1, "SortOrder[%s, %s]", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
