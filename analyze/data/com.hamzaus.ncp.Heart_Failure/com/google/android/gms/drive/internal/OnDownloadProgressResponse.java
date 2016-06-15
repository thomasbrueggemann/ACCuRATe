package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_793;

public class OnDownloadProgressResponse implements SafeParcelable {
   public static final Creator<OnDownloadProgressResponse> CREATOR = new class_793();
   // $FF: renamed from: Jt long
   final long field_3069;
   // $FF: renamed from: Ju long
   final long field_3070;
   // $FF: renamed from: xJ int
   final int field_3071;

   OnDownloadProgressResponse(int var1, long var2, long var4) {
      this.field_3071 = var1;
      this.field_3069 = var2;
      this.field_3070 = var4;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: gp () long
   public long method_3273() {
      return this.field_3069;
   }

   // $FF: renamed from: gq () long
   public long method_3274() {
      return this.field_3070;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_793.method_4416(this, var1, var2);
   }
}
