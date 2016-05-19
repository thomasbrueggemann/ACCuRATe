package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzbw;
import java.util.List;

public class StringListResponse implements SafeParcelable {
   public static final Creator<StringListResponse> CREATOR = new zzbw();
   private final int mVersionCode;
   private final List<String> zzasD;

   StringListResponse(int var1, List<String> var2) {
      this.mVersionCode = var1;
      this.zzasD = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbw.zza(this, var1, var2);
   }

   public List<String> zztx() {
      return this.zzasD;
   }
}
