package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;
import com.google.android.gms.drive.internal.zzbd;

public class OnListParentsResponse extends WriteAwareParcelable implements SafeParcelable {
   public static final Creator<OnListParentsResponse> CREATOR = new zzbd();
   final int mVersionCode;
   final DataHolder zzast;

   OnListParentsResponse(int var1, DataHolder var2) {
      this.mVersionCode = var1;
      this.zzast = var2;
   }

   public int describeContents() {
      return 0;
   }

   protected void zzJ(Parcel var1, int var2) {
      zzbd.zza(this, var1, var2);
   }
}
