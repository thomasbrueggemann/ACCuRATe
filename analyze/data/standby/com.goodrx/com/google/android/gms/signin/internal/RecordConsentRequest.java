package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.signin.internal.zzf;

public class RecordConsentRequest implements SafeParcelable {
   public static final Creator<RecordConsentRequest> CREATOR = new zzf();
   final int mVersionCode;
   private final Account zzTI;
   private final String zzXd;
   private final Scope[] zzbhh;

   RecordConsentRequest(int var1, Account var2, Scope[] var3, String var4) {
      this.mVersionCode = var1;
      this.zzTI = var2;
      this.zzbhh = var3;
      this.zzXd = var4;
   }

   public int describeContents() {
      return 0;
   }

   public Account getAccount() {
      return this.zzTI;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }

   public Scope[] zzFM() {
      return this.zzbhh;
   }

   public String zzmR() {
      return this.zzXd;
   }
}
