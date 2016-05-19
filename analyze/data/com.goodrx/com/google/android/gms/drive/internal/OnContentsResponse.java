package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.zzaw;

public class OnContentsResponse implements SafeParcelable {
   public static final Creator<OnContentsResponse> CREATOR = new zzaw();
   final int mVersionCode;
   final Contents zzara;
   final boolean zzasf;

   OnContentsResponse(int var1, Contents var2, boolean var3) {
      this.mVersionCode = var1;
      this.zzara = var2;
      this.zzasf = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzaw.zza(this, var1, var2);
   }
}
