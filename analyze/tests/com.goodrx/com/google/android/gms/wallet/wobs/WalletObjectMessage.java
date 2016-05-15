package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.zzi;

public final class WalletObjectMessage implements SafeParcelable {
   public static final Creator<WalletObjectMessage> CREATOR = new zzi();
   String body;
   private final int mVersionCode;
   String zzbqO;
   TimeInterval zzbqR;
   UriData zzbqS;
   UriData zzbqT;

   WalletObjectMessage() {
      this.mVersionCode = 1;
   }

   WalletObjectMessage(int var1, String var2, String var3, TimeInterval var4, UriData var5, UriData var6) {
      this.mVersionCode = var1;
      this.zzbqO = var2;
      this.body = var3;
      this.zzbqR = var4;
      this.zzbqS = var5;
      this.zzbqT = var6;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi.zza(this, var1, var2);
   }
}
