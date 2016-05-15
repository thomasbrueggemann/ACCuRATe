package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.zza;
import com.google.android.gms.drive.query.internal.zze;
import com.google.android.gms.drive.query.internal.zzf;

public class ComparisonFilter<T> extends AbstractFilter {
   public static final zza CREATOR = new zza();
   final int mVersionCode;
   final Operator zzaug;
   final MetadataBundle zzauh;
   final MetadataField<T> zzaui;

   ComparisonFilter(int var1, Operator var2, MetadataBundle var3) {
      this.mVersionCode = var1;
      this.zzaug = var2;
      this.zzauh = var3;
      this.zzaui = zze.zza(var3);
   }

   public int describeContents() {
      return 0;
   }

   public T getValue() {
      return this.zzauh.zza(this.zzaui);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public <F> F zza(zzf<F> var1) {
      return var1.zzb(this.zzaug, this.zzaui, this.getValue());
   }
}
