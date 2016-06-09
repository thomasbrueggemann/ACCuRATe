package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Permission;
import com.google.android.gms.drive.internal.zzal;
import java.util.List;

public class GetPermissionsResponse implements SafeParcelable {
   public static final Creator<GetPermissionsResponse> CREATOR = new zzal();
   final int mVersionCode;
   final List<Permission> zzarO;
   final int zzzw;

   GetPermissionsResponse(int var1, List<Permission> var2, int var3) {
      this.mVersionCode = var1;
      this.zzarO = var2;
      this.zzzw = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzal.zza(this, var1, var2);
   }
}
