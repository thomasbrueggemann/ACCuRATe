package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.zzb;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialPickerConfig implements SafeParcelable {
   public static final Creator<CredentialPickerConfig> CREATOR = new zzb();
   private final boolean mShowCancelButton;
   final int mVersionCode;
   private final boolean zzWb;
   private final boolean zzWc;

   CredentialPickerConfig(int var1, boolean var2, boolean var3, boolean var4) {
      this.mVersionCode = var1;
      this.zzWb = var2;
      this.mShowCancelButton = var3;
      this.zzWc = var4;
   }

   private CredentialPickerConfig(CredentialPickerConfig.Builder var1) {
      this(1, var1.zzWb, var1.mShowCancelButton, var1.zzWc);
   }

   // $FF: synthetic method
   CredentialPickerConfig(CredentialPickerConfig.Builder var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public boolean isForNewAccount() {
      return this.zzWc;
   }

   public boolean shouldShowAddAccountButton() {
      return this.zzWb;
   }

   public boolean shouldShowCancelButton() {
      return this.mShowCancelButton;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }

   public static class Builder {
      private boolean mShowCancelButton = true;
      private boolean zzWb = false;
      private boolean zzWc = false;

      public CredentialPickerConfig build() {
         return new CredentialPickerConfig(this);
      }
   }
}
