package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ResourceEvent;
import com.google.android.gms.drive.events.zza;
import java.util.Locale;

public final class ChangeEvent implements SafeParcelable, ResourceEvent {
   public static final Creator<ChangeEvent> CREATOR = new zza();
   final int mVersionCode;
   final DriveId zzaoz;
   final int zzapx;

   ChangeEvent(int var1, DriveId var2, int var3) {
      this.mVersionCode = var1;
      this.zzaoz = var2;
      this.zzapx = var3;
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{this.zzaoz, Integer.valueOf(this.zzapx)};
      return String.format(var1, "ChangeEvent [id=%s,changeFlags=%x]", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
