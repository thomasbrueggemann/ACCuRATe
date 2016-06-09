package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzk;

public class CreateContentsRequest implements SafeParcelable {
   public static final Creator<CreateContentsRequest> CREATOR = new zzk();
   final int mVersionCode;
   final int zzaoy;

   CreateContentsRequest(int var1, int var2) {
      this.mVersionCode = var1;
      boolean var3;
      if(var2 != 536870912 && var2 != 805306368) {
         var3 = false;
      } else {
         var3 = true;
      }

      zzx.zzb(var3, "Cannot create a new read-only contents!");
      this.zzaoy = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzk.zza(this, var1, var2);
   }
}
