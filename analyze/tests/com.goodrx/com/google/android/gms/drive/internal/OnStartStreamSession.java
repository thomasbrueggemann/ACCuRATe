package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzbi;

public class OnStartStreamSession implements SafeParcelable {
   public static final Creator<OnStartStreamSession> CREATOR = new zzbi();
   final int mVersionCode;
   final ParcelFileDescriptor zzasv;
   final IBinder zzasw;
   final String zzsU;

   OnStartStreamSession(int var1, ParcelFileDescriptor var2, IBinder var3, String var4) {
      this.mVersionCode = var1;
      this.zzasv = var2;
      this.zzasw = var3;
      this.zzsU = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbi.zza(this, var1, var2 | 1);
   }
}
