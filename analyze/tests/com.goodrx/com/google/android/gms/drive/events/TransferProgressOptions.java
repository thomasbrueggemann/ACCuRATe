package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.zzo;
import java.util.Locale;

public final class TransferProgressOptions implements SafeParcelable {
   public static final Creator<TransferProgressOptions> CREATOR = new zzo();
   final int mVersionCode;
   final int zzapT;

   TransferProgressOptions(int var1, int var2) {
      this.mVersionCode = var1;
      this.zzapT = var2;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != null && var1.getClass() == this.getClass()) {
         if(var1 == this) {
            return true;
         } else {
            TransferProgressOptions var2 = (TransferProgressOptions)var1;
            return zzw.equal(Integer.valueOf(this.zzapT), Integer.valueOf(var2.zzapT));
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzapT)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{Integer.valueOf(this.zzapT)};
      return String.format(var1, "TransferProgressOptions[type=%d]", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzo.zza(this, var1, var2);
   }
}
