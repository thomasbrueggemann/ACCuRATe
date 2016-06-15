package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.ConnectionInfoCreator;

public class ConnectionInfo implements SafeParcelable {
   public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
   // $FF: renamed from: Nk java.lang.String
   private final String field_2663;
   // $FF: renamed from: Nl int
   private final int field_2664;
   // $FF: renamed from: xJ int
   private final int field_2665;

   public ConnectionInfo(int var1, String var2, int var3) {
      this.field_2665 = var1;
      this.field_2663 = var2;
      this.field_2664 = var3;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: gR () java.lang.String
   public String method_2750() {
      return this.field_2663;
   }

   // $FF: renamed from: gS () int
   public int method_2751() {
      return this.field_2664;
   }

   public int getVersionCode() {
      return this.field_2665;
   }

   public void writeToParcel(Parcel var1, int var2) {
      ConnectionInfoCreator.method_4463(this, var1, var2);
   }
}
