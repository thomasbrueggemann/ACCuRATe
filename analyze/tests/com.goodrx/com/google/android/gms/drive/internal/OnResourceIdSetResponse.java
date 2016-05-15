package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzbh;
import java.util.List;

public class OnResourceIdSetResponse implements SafeParcelable {
   public static final Creator<OnResourceIdSetResponse> CREATOR = new zzbh();
   private final int mVersionCode;
   private final List<String> zzaqi;

   OnResourceIdSetResponse(int var1, List<String> var2) {
      this.mVersionCode = var1;
      this.zzaqi = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbh.zza(this, var1, var2);
   }

   public List<String> zztc() {
      return this.zzaqi;
   }
}
