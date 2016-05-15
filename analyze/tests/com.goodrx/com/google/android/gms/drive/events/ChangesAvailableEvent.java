package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzb;
import java.util.Locale;

public final class ChangesAvailableEvent implements SafeParcelable, DriveEvent {
   public static final Creator<ChangesAvailableEvent> CREATOR = new zzb();
   final int mVersionCode;
   final String zzVa;
   final ChangesAvailableOptions zzapy;

   ChangesAvailableEvent(int var1, String var2, ChangesAvailableOptions var3) {
      this.mVersionCode = var1;
      this.zzVa = var2;
      this.zzapy = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(var1 != null && var1.getClass() == this.getClass()) {
         if(var1 != this) {
            ChangesAvailableEvent var3 = (ChangesAvailableEvent)var1;
            if(!zzw.equal(this.zzapy, var3.zzapy) || !zzw.equal(this.zzVa, var3.zzVa)) {
               return false;
            }
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzapy, this.zzVa};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{this.zzapy};
      return String.format(var1, "ChangesAvailableEvent [changesAvailableOptions=%s]", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
