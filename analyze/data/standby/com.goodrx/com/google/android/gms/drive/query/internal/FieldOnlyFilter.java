package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.zzb;
import com.google.android.gms.drive.query.internal.zze;
import com.google.android.gms.drive.query.internal.zzf;

public class FieldOnlyFilter extends AbstractFilter {
   public static final Creator<FieldOnlyFilter> CREATOR = new zzb();
   final int mVersionCode;
   final MetadataBundle zzauh;
   private final MetadataField<?> zzaui;

   FieldOnlyFilter(int var1, MetadataBundle var2) {
      this.mVersionCode = var1;
      this.zzauh = var2;
      this.zzaui = zze.zza(var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }

   public <T> T zza(zzf<T> var1) {
      return var1.zze(this.zzaui);
   }
}
