package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzp;
import com.google.android.gms.drive.events.internal.TransferProgressData;
import java.util.List;

public final class TransferStateEvent implements DriveEvent {
   public static final Creator<TransferStateEvent> CREATOR = new zzp();
   final int mVersionCode;
   final String zzVa;
   final List<TransferProgressData> zzapU;

   TransferStateEvent(int var1, String var2, List<TransferProgressData> var3) {
      this.mVersionCode = var1;
      this.zzVa = var2;
      this.zzapU = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(var1 != null && var1.getClass() == this.getClass()) {
         if(var1 != this) {
            TransferStateEvent var3 = (TransferStateEvent)var1;
            if(!zzw.equal(this.zzVa, var3.zzVa) || !zzw.equal(this.zzapU, var3.zzapU)) {
               return false;
            }
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzVa, this.zzapU};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{TextUtils.join("\',\'", this.zzapU)};
      return String.format("TransferStateEvent[%s]", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzp.zza(this, var1, var2);
   }
}
