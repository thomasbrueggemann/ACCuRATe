package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.zza;
import com.google.android.gms.drive.internal.zzas;
import com.google.android.gms.internal.zzsu;

public class ChangeSequenceNumber implements SafeParcelable {
   public static final Creator<ChangeSequenceNumber> CREATOR = new zza();
   final int mVersionCode;
   final long zzaot;
   final long zzaou;
   final long zzaov;
   private volatile String zzaow;

   ChangeSequenceNumber(int var1, long var2, long var4, long var6) {
      boolean var8 = true;
      super();
      this.zzaow = null;
      boolean var9;
      if(var2 != -1L) {
         var9 = var8;
      } else {
         var9 = false;
      }

      zzx.zzac(var9);
      boolean var10;
      if(var4 != -1L) {
         var10 = var8;
      } else {
         var10 = false;
      }

      zzx.zzac(var10);
      if(var6 == -1L) {
         var8 = false;
      }

      zzx.zzac(var8);
      this.mVersionCode = var1;
      this.zzaot = var2;
      this.zzaou = var4;
      this.zzaov = var6;
   }

   public int describeContents() {
      return 0;
   }

   public final String encodeToString() {
      if(this.zzaow == null) {
         String var1 = Base64.encodeToString(this.zzsu(), 10);
         this.zzaow = "ChangeSequenceNumber:" + var1;
      }

      return this.zzaow;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof ChangeSequenceNumber) {
         ChangeSequenceNumber var2 = (ChangeSequenceNumber)var1;
         if(var2.zzaou == this.zzaou && var2.zzaov == this.zzaov && var2.zzaot == this.zzaot) {
            return true;
         }
      }

      return false;
   }

   public int hashCode() {
      return (this.zzaot + String.valueOf(this.zzaou) + this.zzaov).hashCode();
   }

   public String toString() {
      return this.encodeToString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   final byte[] zzsu() {
      zzas var1 = new zzas();
      var1.versionCode = this.mVersionCode;
      var1.zzarV = this.zzaot;
      var1.zzarW = this.zzaou;
      var1.zzarX = this.zzaov;
      return zzsu.toByteArray(var1);
   }
}
