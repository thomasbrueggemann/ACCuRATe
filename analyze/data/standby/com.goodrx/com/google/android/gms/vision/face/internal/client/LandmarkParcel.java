package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.face.internal.client.zze;

public final class LandmarkParcel implements SafeParcelable {
   public static final zze CREATOR = new zze();
   public final int type;
   public final int versionCode;
   // $FF: renamed from: x float
   public final float field_455;
   // $FF: renamed from: y float
   public final float field_456;

   public LandmarkParcel(int var1, float var2, float var3, int var4) {
      this.versionCode = var1;
      this.field_455 = var2;
      this.field_456 = var3;
      this.type = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }
}
