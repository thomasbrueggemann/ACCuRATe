package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class HintRequest implements SafeParcelable {
   public static final Creator<HintRequest> CREATOR = new zzd();
   final int mVersionCode;
   private final String[] zzWe;
   private final CredentialPickerConfig zzWh;
   private final boolean zzWi;
   private final boolean zzWj;

   HintRequest(int var1, CredentialPickerConfig var2, boolean var3, boolean var4, String[] var5) {
      this.mVersionCode = var1;
      this.zzWh = (CredentialPickerConfig)zzx.zzz(var2);
      this.zzWi = var3;
      this.zzWj = var4;
      this.zzWe = (String[])zzx.zzz(var5);
   }

   public int describeContents() {
      return 0;
   }

   @NonNull
   public String[] getAccountTypes() {
      return this.zzWe;
   }

   @NonNull
   public CredentialPickerConfig getHintPickerConfig() {
      return this.zzWh;
   }

   public boolean isEmailAddressIdentifierSupported() {
      return this.zzWi;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }

   public boolean zzmy() {
      return this.zzWj;
   }
}
