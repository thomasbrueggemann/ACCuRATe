package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;
import com.google.android.gms.drive.internal.zzbc;

public class OnListEntriesResponse extends WriteAwareParcelable implements SafeParcelable {
   public static final Creator<OnListEntriesResponse> CREATOR = new zzbc();
   final int mVersionCode;
   final boolean zzaqJ;
   final DataHolder zzass;

   OnListEntriesResponse(int var1, DataHolder var2, boolean var3) {
      this.mVersionCode = var1;
      this.zzass = var2;
      this.zzaqJ = var3;
   }

   public int describeContents() {
      return 0;
   }

   protected void zzJ(Parcel var1, int var2) {
      zzbc.zza(this, var1, var2);
   }
}
