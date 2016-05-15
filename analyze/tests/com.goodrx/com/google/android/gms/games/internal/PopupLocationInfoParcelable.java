package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.PopupLocationInfoParcelableCreator;

public final class PopupLocationInfoParcelable implements SafeParcelable {
   public static final PopupLocationInfoParcelableCreator CREATOR = new PopupLocationInfoParcelableCreator();
   private final int mVersionCode;
   private final Bundle zzaFH;
   private final IBinder zzaFI;

   PopupLocationInfoParcelable(int var1, Bundle var2, IBinder var3) {
      this.mVersionCode = var1;
      this.zzaFH = var2;
      this.zzaFI = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public IBinder getWindowToken() {
      return this.zzaFI;
   }

   public void writeToParcel(Parcel var1, int var2) {
      PopupLocationInfoParcelableCreator.zza(this, var1, var2);
   }

   public Bundle zzxg() {
      return this.zzaFH;
   }
}
