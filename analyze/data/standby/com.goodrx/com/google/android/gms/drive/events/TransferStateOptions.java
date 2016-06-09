package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.events.zzr;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class TransferStateOptions implements SafeParcelable {
   public static final Creator<TransferStateOptions> CREATOR = new zzr();
   final int mVersionCode;
   final List<DriveSpace> zzapB;
   private final Set<DriveSpace> zzapC;

   TransferStateOptions(int var1, List<DriveSpace> var2) {
      HashSet var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = new HashSet(var2);
      }

      this(var1, var2, var3);
   }

   private TransferStateOptions(int var1, List<DriveSpace> var2, Set<DriveSpace> var3) {
      this.mVersionCode = var1;
      this.zzapB = var2;
      this.zzapC = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != null && var1.getClass() == this.getClass()) {
         if(var1 == this) {
            return true;
         } else {
            TransferStateOptions var2 = (TransferStateOptions)var1;
            return zzw.equal(this.zzapC, var2.zzapC);
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzapC};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{this.zzapB};
      return String.format(var1, "TransferStateOptions[Spaces=%s]", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzr.zza(this, var1, var2);
   }
}
