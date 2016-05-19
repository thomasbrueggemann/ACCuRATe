package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.internal.zzaq;
import java.util.List;

public class GetConnectedNodesResponse implements SafeParcelable {
   public static final Creator<GetConnectedNodesResponse> CREATOR = new zzaq();
   public final int statusCode;
   public final int versionCode;
   public final List<NodeParcelable> zzbsI;

   GetConnectedNodesResponse(int var1, int var2, List<NodeParcelable> var3) {
      this.versionCode = var1;
      this.statusCode = var2;
      this.zzbsI = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzaq.zza(this, var1, var2);
   }
}
