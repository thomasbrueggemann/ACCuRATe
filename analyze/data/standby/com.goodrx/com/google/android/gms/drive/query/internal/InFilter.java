package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.zze;
import com.google.android.gms.drive.query.internal.zzf;
import com.google.android.gms.drive.query.internal.zzj;
import java.util.Collection;

public class InFilter<T> extends AbstractFilter {
   public static final zzj CREATOR = new zzj();
   final int mVersionCode;
   final MetadataBundle zzauh;
   private final com.google.android.gms.drive.metadata.zzb<T> zzauu;

   InFilter(int var1, MetadataBundle var2) {
      this.mVersionCode = var1;
      this.zzauh = var2;
      this.zzauu = (com.google.android.gms.drive.metadata.zzb)zze.zza(var2);
   }

   public int describeContents() {
      return 0;
   }

   public T getValue() {
      return ((Collection)this.zzauh.zza(this.zzauu)).iterator().next();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }

   public <F> F zza(zzf<F> var1) {
      return var1.zzb(this.zzauu, this.getValue());
   }
}
