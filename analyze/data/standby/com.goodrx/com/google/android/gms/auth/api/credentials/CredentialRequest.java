package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialRequest implements SafeParcelable {
   public static final Creator<CredentialRequest> CREATOR = new zzc();
   final int mVersionCode;
   private final boolean zzWd;
   private final String[] zzWe;
   private final CredentialPickerConfig zzWf;
   private final CredentialPickerConfig zzWg;

   CredentialRequest(int var1, boolean var2, String[] var3, CredentialPickerConfig var4, CredentialPickerConfig var5) {
      this.mVersionCode = var1;
      this.zzWd = var2;
      this.zzWe = (String[])zzx.zzz(var3);
      if(var4 == null) {
         var4 = (new CredentialPickerConfig.Builder()).build();
      }

      this.zzWf = var4;
      if(var5 == null) {
         var5 = (new CredentialPickerConfig.Builder()).build();
      }

      this.zzWg = var5;
   }

   public int describeContents() {
      return 0;
   }

   @NonNull
   public String[] getAccountTypes() {
      return this.zzWe;
   }

   @NonNull
   public CredentialPickerConfig getCredentialHintPickerConfig() {
      return this.zzWg;
   }

   @NonNull
   public CredentialPickerConfig getCredentialPickerConfig() {
      return this.zzWf;
   }

   public boolean isPasswordLoginSupported() {
      return this.zzWd;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
