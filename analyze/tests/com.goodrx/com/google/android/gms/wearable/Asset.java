package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zze;

public class Asset implements SafeParcelable {
   public static final Creator<Asset> CREATOR = new zze();
   final int mVersionCode;
   public Uri uri;
   private byte[] zzaKm;
   private String zzbqU;
   public ParcelFileDescriptor zzbqV;

   Asset(int var1, byte[] var2, String var3, ParcelFileDescriptor var4, Uri var5) {
      this.mVersionCode = var1;
      this.zzaKm = var2;
      this.zzbqU = var3;
      this.zzbqV = var4;
      this.uri = var5;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof Asset)) {
            return false;
         }

         Asset var2 = (Asset)var1;
         if(!zzw.equal(this.zzaKm, var2.zzaKm) || !zzw.equal(this.zzbqU, var2.zzbqU) || !zzw.equal(this.zzbqV, var2.zzbqV) || !zzw.equal(this.uri, var2.uri)) {
            return false;
         }
      }

      return true;
   }

   public byte[] getData() {
      return this.zzaKm;
   }

   public String getDigest() {
      return this.zzbqU;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzaKm, this.zzbqU, this.zzbqV, this.uri};
      return zzw.hashCode(var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Asset[@");
      var1.append(Integer.toHexString(this.hashCode()));
      if(this.zzbqU == null) {
         var1.append(", nodigest");
      } else {
         var1.append(", ");
         var1.append(this.zzbqU);
      }

      if(this.zzaKm != null) {
         var1.append(", size=");
         var1.append(this.zzaKm.length);
      }

      if(this.zzbqV != null) {
         var1.append(", fd=");
         var1.append(this.zzbqV);
      }

      if(this.uri != null) {
         var1.append(", uri=");
         var1.append(this.uri);
      }

      var1.append("]");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2 | 1);
   }
}
