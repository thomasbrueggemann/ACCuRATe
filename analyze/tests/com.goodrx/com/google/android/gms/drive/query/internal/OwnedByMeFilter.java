package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.zzf;
import com.google.android.gms.drive.query.internal.zzo;

public class OwnedByMeFilter extends AbstractFilter {
   public static final zzo CREATOR = new zzo();
   final int mVersionCode;

   public OwnedByMeFilter() {
      this(1);
   }

   OwnedByMeFilter(int var1) {
      this.mVersionCode = var1;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzo.zza(this, var1, var2);
   }

   public <F> F zza(zzf<F> var1) {
      return var1.zztP();
   }
}
