package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.zzn;

public final class NotifyTransactionStatusRequest implements SafeParcelable {
   public static final Creator<NotifyTransactionStatusRequest> CREATOR = new zzn();
   final int mVersionCode;
   int status;
   String zzboo;
   String zzbpz;

   NotifyTransactionStatusRequest() {
      this.mVersionCode = 1;
   }

   NotifyTransactionStatusRequest(int var1, String var2, int var3, String var4) {
      this.mVersionCode = var1;
      this.zzboo = var2;
      this.status = var3;
      this.zzbpz = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzn.zza(this, var1, var2);
   }
}
