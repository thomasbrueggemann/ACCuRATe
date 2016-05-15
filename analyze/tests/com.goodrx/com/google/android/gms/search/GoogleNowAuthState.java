package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.search.zza;

public class GoogleNowAuthState implements SafeParcelable {
   public static final Creator<GoogleNowAuthState> CREATOR = new zza();
   final int mVersionCode;
   String zzXI;
   String zzbgG;
   long zzbgH;

   GoogleNowAuthState(int var1, String var2, String var3, long var4) {
      this.mVersionCode = var1;
      this.zzbgG = var2;
      this.zzXI = var3;
      this.zzbgH = var4;
   }

   public int describeContents() {
      return 0;
   }

   public String getAccessToken() {
      return this.zzXI;
   }

   public String getAuthCode() {
      return this.zzbgG;
   }

   public long getNextAllowedTimeMillis() {
      return this.zzbgH;
   }

   public String toString() {
      return "mAuthCode = " + this.zzbgG + "\nmAccessToken = " + this.zzXI + "\nmNextAllowedTimeMillis = " + this.zzbgH;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
