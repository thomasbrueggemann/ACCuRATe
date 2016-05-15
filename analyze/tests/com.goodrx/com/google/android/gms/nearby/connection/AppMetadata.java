package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.connection.AppIdentifier;
import com.google.android.gms.nearby.connection.zzb;
import java.util.List;

public final class AppMetadata implements SafeParcelable {
   public static final Creator<AppMetadata> CREATOR = new zzb();
   private final int mVersionCode;
   private final List<AppIdentifier> zzbaZ;

   AppMetadata(int var1, List<AppIdentifier> var2) {
      this.mVersionCode = var1;
      this.zzbaZ = (List)zzx.zzb(var2, "Must specify application identifiers");
      zzx.zza(var2.size(), "Application identifiers cannot be empty");
   }

   public int describeContents() {
      return 0;
   }

   public List<AppIdentifier> getAppIdentifiers() {
      return this.zzbaZ;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
