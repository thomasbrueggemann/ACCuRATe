package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.zzf;
import com.google.android.gms.drive.query.internal.zzl;

public class MatchAllFilter extends AbstractFilter {
   public static final zzl CREATOR = new zzl();
   final int mVersionCode;

   public MatchAllFilter() {
      this(1);
   }

   MatchAllFilter(int var1) {
      this.mVersionCode = var1;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzl.zza(this, var1, var2);
   }

   public <F> F zza(zzf<F> var1) {
      return var1.zztQ();
   }
}
