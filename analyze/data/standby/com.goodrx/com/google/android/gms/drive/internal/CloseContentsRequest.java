package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.zzi;

public class CloseContentsRequest implements SafeParcelable {
   public static final Creator<CloseContentsRequest> CREATOR = new zzi();
   final int mVersionCode;
   final Contents zzaql;
   final int zzaqn;
   final Boolean zzaqp;

   CloseContentsRequest(int var1, Contents var2, Boolean var3, int var4) {
      this.mVersionCode = var1;
      this.zzaql = var2;
      this.zzaqp = var3;
      this.zzaqn = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi.zza(this, var1, var2);
   }
}
