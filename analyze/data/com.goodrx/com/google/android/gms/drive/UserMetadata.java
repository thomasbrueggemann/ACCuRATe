package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zzl;

public class UserMetadata implements SafeParcelable {
   public static final Creator<UserMetadata> CREATOR = new zzl();
   final int mVersionCode;
   final String zzWQ;
   final String zzaps;
   final String zzapt;
   final boolean zzapu;
   final String zzapv;

   UserMetadata(int var1, String var2, String var3, String var4, boolean var5, String var6) {
      this.mVersionCode = var1;
      this.zzaps = var2;
      this.zzWQ = var3;
      this.zzapt = var4;
      this.zzapu = var5;
      this.zzapv = var6;
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.zzaps, this.zzWQ, this.zzapt, Boolean.valueOf(this.zzapu), this.zzapv};
      return String.format("Permission ID: \'%s\', Display Name: \'%s\', Picture URL: \'%s\', Authenticated User: %b, Email: \'%s\'", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzl.zza(this, var1, var2);
   }
}
