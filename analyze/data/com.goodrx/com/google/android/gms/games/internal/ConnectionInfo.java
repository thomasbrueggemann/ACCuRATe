package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.ConnectionInfoCreator;

public class ConnectionInfo implements SafeParcelable {
   public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
   private final int mVersionCode;
   private final String zzaDX;
   private final int zzaDY;

   public ConnectionInfo(int var1, String var2, int var3) {
      this.mVersionCode = var1;
      this.zzaDX = var2;
      this.zzaDY = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ConnectionInfoCreator.zza(this, var1, var2);
   }

   public String zzwt() {
      return this.zzaDX;
   }

   public int zzwu() {
      return this.zzaDY;
   }
}
