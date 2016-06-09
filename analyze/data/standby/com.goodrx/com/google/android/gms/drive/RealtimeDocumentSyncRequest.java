package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zzk;
import java.util.List;

public class RealtimeDocumentSyncRequest implements SafeParcelable {
   public static final Creator<RealtimeDocumentSyncRequest> CREATOR = new zzk();
   final int mVersionCode;
   final List<String> zzapq;
   final List<String> zzapr;

   RealtimeDocumentSyncRequest(int var1, List<String> var2, List<String> var3) {
      this.mVersionCode = var1;
      this.zzapq = (List)zzx.zzz(var2);
      this.zzapr = (List)zzx.zzz(var3);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzk.zza(this, var1, var2);
   }
}
