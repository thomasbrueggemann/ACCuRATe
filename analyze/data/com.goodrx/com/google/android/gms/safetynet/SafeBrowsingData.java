package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.safetynet.zzb;

public class SafeBrowsingData implements SafeParcelable {
   public static final Creator<SafeBrowsingData> CREATOR = new zzb();
   public final int mVersionCode;
   private String zzbgv;

   SafeBrowsingData(int var1, String var2) {
      this.mVersionCode = var1;
      this.zzbgv = var2;
   }

   public int describeContents() {
      return 0;
   }

   public String getMetadata() {
      return this.zzbgv;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
