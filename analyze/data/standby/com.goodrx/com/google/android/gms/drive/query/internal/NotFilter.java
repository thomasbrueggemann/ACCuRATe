package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.zzf;
import com.google.android.gms.drive.query.internal.zzm;

public class NotFilter extends AbstractFilter {
   public static final Creator<NotFilter> CREATOR = new zzm();
   final int mVersionCode;
   final FilterHolder zzauw;

   NotFilter(int var1, FilterHolder var2) {
      this.mVersionCode = var1;
      this.zzauw = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzm.zza(this, var1, var2);
   }

   public <T> T zza(zzf<T> var1) {
      return var1.zzB(this.zzauw.getFilter().zza(var1));
   }
}
