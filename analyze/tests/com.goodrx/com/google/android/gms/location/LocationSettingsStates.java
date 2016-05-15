package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzh;

public final class LocationSettingsStates implements SafeParcelable {
   public static final Creator<LocationSettingsStates> CREATOR = new zzh();
   private final int mVersionCode;
   private final boolean zzaOj;
   private final boolean zzaOk;
   private final boolean zzaOl;
   private final boolean zzaOm;
   private final boolean zzaOn;
   private final boolean zzaOo;

   LocationSettingsStates(int var1, boolean var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      this.mVersionCode = var1;
      this.zzaOj = var2;
      this.zzaOk = var3;
      this.zzaOl = var4;
      this.zzaOm = var5;
      this.zzaOn = var6;
      this.zzaOo = var7;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public boolean isBlePresent() {
      return this.zzaOo;
   }

   public boolean isBleUsable() {
      return this.zzaOl;
   }

   public boolean isGpsPresent() {
      return this.zzaOm;
   }

   public boolean isGpsUsable() {
      return this.zzaOj;
   }

   public boolean isNetworkLocationPresent() {
      return this.zzaOn;
   }

   public boolean isNetworkLocationUsable() {
      return this.zzaOk;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }
}
