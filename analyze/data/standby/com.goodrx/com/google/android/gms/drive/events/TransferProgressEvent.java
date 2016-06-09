package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzn;
import com.google.android.gms.drive.events.internal.TransferProgressData;

public final class TransferProgressEvent implements DriveEvent {
   public static final Creator<TransferProgressEvent> CREATOR = new zzn();
   final int mVersionCode;
   final TransferProgressData zzapS;

   TransferProgressEvent(int var1, TransferProgressData var2) {
      this.mVersionCode = var1;
      this.zzapS = var2;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != null && var1.getClass() == this.getClass()) {
         if(var1 == this) {
            return true;
         } else {
            TransferProgressEvent var2 = (TransferProgressEvent)var1;
            return zzw.equal(this.zzapS, var2.zzapS);
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzapS};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{this.zzapS.toString()};
      return String.format("TransferProgressEvent[%s]", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzn.zza(this, var1, var2);
   }
}
