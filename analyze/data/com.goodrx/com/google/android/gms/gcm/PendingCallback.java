package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PendingCallback implements Parcelable {
   public static final Creator<PendingCallback> CREATOR = new Creator() {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.zzeJ(var1);
      }

      // $FF: synthetic method
      public Object[] newArray(int var1) {
         return this.zzhg(var1);
      }

      public PendingCallback zzeJ(Parcel var1) {
         return new PendingCallback(var1);
      }

      public PendingCallback[] zzhg(int var1) {
         return new PendingCallback[var1];
      }
   };
   final IBinder zzakD;

   public PendingCallback(Parcel var1) {
      this.zzakD = var1.readStrongBinder();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeStrongBinder(this.zzakD);
   }
}
