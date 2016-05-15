package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.zzar;
import java.util.List;

public class LoadRealtimeRequest implements SafeParcelable {
   public static final Creator<LoadRealtimeRequest> CREATOR = new zzar();
   final int mVersionCode;
   final DriveId zzaoz;
   final boolean zzarQ;
   final List<String> zzarR;
   final boolean zzarS;
   final DataHolder zzarT;
   final String zzarU;

   LoadRealtimeRequest(int var1, DriveId var2, boolean var3, List<String> var4, boolean var5, DataHolder var6, String var7) {
      this.mVersionCode = var1;
      this.zzaoz = var2;
      this.zzarQ = var3;
      this.zzarR = var4;
      this.zzarS = var5;
      this.zzarT = var6;
      this.zzarU = var7;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzar.zza(this, var1, var2);
   }
}
