package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.zze;
import com.google.android.gms.drive.query.internal.zzf;
import com.google.android.gms.drive.query.internal.zzi;

public class HasFilter<T> extends AbstractFilter {
   public static final zzi CREATOR = new zzi();
   final int mVersionCode;
   final MetadataBundle zzauh;
   final MetadataField<T> zzaui;

   HasFilter(int var1, MetadataBundle var2) {
      this.mVersionCode = var1;
      this.zzauh = var2;
      this.zzaui = zze.zza(var2);
   }

   public int describeContents() {
      return 0;
   }

   public T getValue() {
      return this.zzauh.zza(this.zzaui);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi.zza(this, var1, var2);
   }

   public <F> F zza(zzf<F> var1) {
      return var1.zze(this.zzaui, this.getValue());
   }
}
