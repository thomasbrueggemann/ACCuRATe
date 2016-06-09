package com.google.android.gms.drive.events.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.internal.zzc;

public class TransferProgressData implements SafeParcelable {
   public static final Creator<TransferProgressData> CREATOR = new zzc();
   final int mVersionCode;
   final int zzBc;
   final DriveId zzaoz;
   final int zzapT;
   final long zzapW;
   final long zzapX;

   TransferProgressData(int var1, int var2, DriveId var3, int var4, long var5, long var7) {
      this.mVersionCode = var1;
      this.zzapT = var2;
      this.zzaoz = var3;
      this.zzBc = var4;
      this.zzapW = var5;
      this.zzapX = var7;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(var1 != null && var1.getClass() == this.getClass()) {
         if(var1 != this) {
            TransferProgressData var3 = (TransferProgressData)var1;
            if(this.zzapT != var3.zzapT || !zzw.equal(this.zzaoz, var3.zzaoz) || this.zzBc != var3.zzBc || this.zzapW != var3.zzapW || this.zzapX != var3.zzapX) {
               return false;
            }
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzapT), this.zzaoz, Integer.valueOf(this.zzBc), Long.valueOf(this.zzapW), Long.valueOf(this.zzapX)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzapT), this.zzaoz, Integer.valueOf(this.zzBc), Long.valueOf(this.zzapW), Long.valueOf(this.zzapX)};
      return String.format("TransferProgressData[TransferType: %d, DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
