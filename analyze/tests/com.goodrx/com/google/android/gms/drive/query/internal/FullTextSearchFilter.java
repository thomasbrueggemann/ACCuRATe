package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.zzf;
import com.google.android.gms.drive.query.internal.zzh;

public class FullTextSearchFilter extends AbstractFilter {
   public static final zzh CREATOR = new zzh();
   final String mValue;
   final int mVersionCode;

   FullTextSearchFilter(int var1, String var2) {
      this.mVersionCode = var1;
      this.mValue = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }

   public <F> F zza(zzf<F> var1) {
      return var1.zzdj(this.mValue);
   }
}
