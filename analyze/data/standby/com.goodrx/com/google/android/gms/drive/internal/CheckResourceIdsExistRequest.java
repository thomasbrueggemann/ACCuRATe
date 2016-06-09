package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzg;
import java.util.List;

public class CheckResourceIdsExistRequest implements SafeParcelable {
   public static final Creator<CheckResourceIdsExistRequest> CREATOR = new zzg();
   private final int mVersionCode;
   private final List<String> zzaqi;

   CheckResourceIdsExistRequest(int var1, List<String> var2) {
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
      zzg.zza(this, var1, var2);
   }

   public List<String> zztc() {
      return this.zzaqi;
   }
}
