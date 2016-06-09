package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.zzb;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
   public static final Creator<AccountChangeEventsRequest> CREATOR = new zzb();
   final int mVersion;
   Account zzTI;
   @Deprecated
   String zzVa;
   int zzVc;

   public AccountChangeEventsRequest() {
      this.mVersion = 1;
   }

   AccountChangeEventsRequest(int var1, int var2, String var3, Account var4) {
      this.mVersion = var1;
      this.zzVc = var2;
      this.zzVa = var3;
      if(var4 == null && !TextUtils.isEmpty(var3)) {
         this.zzTI = new Account(var3, "com.google");
      } else {
         this.zzTI = var4;
      }
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
