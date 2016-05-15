package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zza;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.List;

public class GeofencingRequest implements SafeParcelable {
   public static final Creator<GeofencingRequest> CREATOR = new zza();
   private final int mVersionCode;
   private final List<ParcelableGeofence> zzaNN;
   private final int zzaNO;

   GeofencingRequest(int var1, List<ParcelableGeofence> var2, int var3) {
      this.mVersionCode = var1;
      this.zzaNN = var2;
      this.zzaNO = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getInitialTrigger() {
      return this.zzaNO;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public List<ParcelableGeofence> zzyI() {
      return this.zzaNN;
   }
}
