package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountRequest implements SafeParcelable {
   public static final Creator<ResolveAccountRequest> CREATOR = new zzy();
   final int mVersionCode;
   private final Account zzTI;
   private final int zzamq;
   private final GoogleSignInAccount zzamr;

   ResolveAccountRequest(int var1, Account var2, int var3, GoogleSignInAccount var4) {
      this.mVersionCode = var1;
      this.zzTI = var2;
      this.zzamq = var3;
      this.zzamr = var4;
   }

   public ResolveAccountRequest(Account var1, int var2, GoogleSignInAccount var3) {
      this(2, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   public Account getAccount() {
      return this.zzTI;
   }

   public int getSessionId() {
      return this.zzamq;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzy.zza(this, var1, var2);
   }

   @Nullable
   public GoogleSignInAccount zzqW() {
      return this.zzamr;
   }
}
