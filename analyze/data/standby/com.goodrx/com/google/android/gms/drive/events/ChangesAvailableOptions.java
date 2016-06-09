package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.events.zzd;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class ChangesAvailableOptions implements SafeParcelable {
   public static final Creator<ChangesAvailableOptions> CREATOR = new zzd();
   final int mVersionCode;
   final boolean zzapA;
   final List<DriveSpace> zzapB;
   private final Set<DriveSpace> zzapC;
   final int zzapz;

   ChangesAvailableOptions(int var1, int var2, boolean var3, List<DriveSpace> var4) {
      HashSet var5;
      if(var4 == null) {
         var5 = null;
      } else {
         var5 = new HashSet(var4);
      }

      this(var1, var2, var3, var4, var5);
   }

   private ChangesAvailableOptions(int var1, int var2, boolean var3, List<DriveSpace> var4, Set<DriveSpace> var5) {
      this.mVersionCode = var1;
      this.zzapz = var2;
      this.zzapA = var3;
      this.zzapB = var4;
      this.zzapC = var5;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(var1 != null && var1.getClass() == this.getClass()) {
         if(var1 != this) {
            ChangesAvailableOptions var3 = (ChangesAvailableOptions)var1;
            if(!zzw.equal(this.zzapC, var3.zzapC) || this.zzapz != var3.zzapz || this.zzapA != var3.zzapA) {
               return false;
            }
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzapC, Integer.valueOf(this.zzapz), Boolean.valueOf(this.zzapA)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{Integer.valueOf(this.zzapz), Boolean.valueOf(this.zzapA), this.zzapB};
      return String.format(var1, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }
}
