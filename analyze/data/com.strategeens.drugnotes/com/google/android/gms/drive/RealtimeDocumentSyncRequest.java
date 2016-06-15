package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_683;
import com.google.android.gms.internal.class_335;
import java.util.List;

public class RealtimeDocumentSyncRequest implements SafeParcelable {
   public static final Creator<RealtimeDocumentSyncRequest> CREATOR = new class_683();
   // $FF: renamed from: CK int
   final int field_3890;
   // $FF: renamed from: OK java.util.List
   final List<String> field_3891;
   // $FF: renamed from: OL java.util.List
   final List<String> field_3892;

   RealtimeDocumentSyncRequest(int var1, List<String> var2, List<String> var3) {
      this.field_3890 = var1;
      this.field_3891 = (List)class_335.method_2311(var2);
      this.field_3892 = (List)class_335.method_2311(var3);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_683.method_3865(this, var1, var2);
   }
}
