package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.internal.zzat;

public class GetLocalNodeResponse implements SafeParcelable {
   public static final Creator<GetLocalNodeResponse> CREATOR = new zzat();
   public final int statusCode;
   public final int versionCode;
   public final NodeParcelable zzbsL;

   GetLocalNodeResponse(int var1, int var2, NodeParcelable var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.zzbsL = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzat.zza(this, var1, var2);
   }
}
