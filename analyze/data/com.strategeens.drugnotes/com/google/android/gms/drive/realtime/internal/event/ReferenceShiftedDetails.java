package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_309;

public class ReferenceShiftedDetails implements SafeParcelable {
   public static final Creator<ReferenceShiftedDetails> CREATOR = new class_309();
   // $FF: renamed from: CK int
   final int field_3930;
   // $FF: renamed from: Te java.lang.String
   final String field_3931;
   // $FF: renamed from: Tf java.lang.String
   final String field_3932;
   // $FF: renamed from: Tg int
   final int field_3933;
   // $FF: renamed from: Th int
   final int field_3934;

   ReferenceShiftedDetails(int var1, String var2, String var3, int var4, int var5) {
      this.field_3930 = var1;
      this.field_3931 = var2;
      this.field_3932 = var3;
      this.field_3933 = var4;
      this.field_3934 = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_309.method_2184(this, var1, var2);
   }
}
