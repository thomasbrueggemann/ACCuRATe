package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.request.zzn;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public class StringParcel implements SafeParcelable {
   public static final Creator<StringParcel> CREATOR = new zzn();
   final int mVersionCode;
   String zzxG;

   StringParcel(int var1, String var2) {
      this.mVersionCode = var1;
      this.zzxG = var2;
   }

   public StringParcel(String var1) {
      this.mVersionCode = 1;
      this.zzxG = var1;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzn.zza(this, var1, var2);
   }

   public String zzgz() {
      return this.zzxG;
   }
}
