package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.consent.zzb;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetConsentIntentRequest implements SafeParcelable {
   public static final Creator<GetConsentIntentRequest> CREATOR = new zzb();
   private final int mVersionCode;
   private final Account zzTI;
   private final String zzVO;
   private final int zzVP;
   private final String zzVQ;
   final ScopeDetail[] zzVR;
   private final boolean zzVS;
   private final int zzVT;
   private final String zzVU;

   GetConsentIntentRequest(int var1, String var2, int var3, String var4, Account var5, ScopeDetail[] var6, boolean var7, int var8, String var9) {
      this.mVersionCode = var1;
      this.zzVO = var2;
      this.zzVP = var3;
      this.zzVQ = var4;
      this.zzTI = (Account)zzx.zzz(var5);
      this.zzVR = var6;
      this.zzVS = var7;
      this.zzVT = var8;
      this.zzVU = var9;
   }

   public int describeContents() {
      return 0;
   }

   public Account getAccount() {
      return this.zzTI;
   }

   public String getCallingPackage() {
      return this.zzVO;
   }

   public int getCallingUid() {
      return this.zzVP;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }

   public String zzmt() {
      return this.zzVQ;
   }

   public boolean zzmu() {
      return this.zzVS;
   }

   public int zzmv() {
      return this.zzVT;
   }

   public String zzmw() {
      return this.zzVU;
   }
}
