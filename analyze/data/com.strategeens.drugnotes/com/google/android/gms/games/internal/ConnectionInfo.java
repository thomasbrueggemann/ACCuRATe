package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.ConnectionInfoCreator;

public class ConnectionInfo implements SafeParcelable {
   public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
   // $FF: renamed from: CK int
   private final int field_2472;
   // $FF: renamed from: Yi java.lang.String
   private final String field_2473;
   // $FF: renamed from: Yj int
   private final int field_2474;

   public ConnectionInfo(int var1, String var2, int var3) {
      this.field_2472 = var1;
      this.field_2473 = var2;
      this.field_2474 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2472;
   }

   // $FF: renamed from: le () java.lang.String
   public String method_3231() {
      return this.field_2473;
   }

   // $FF: renamed from: lf () int
   public int method_3232() {
      return this.field_2474;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ConnectionInfoCreator.method_5690(this, var1, var2);
   }
}
