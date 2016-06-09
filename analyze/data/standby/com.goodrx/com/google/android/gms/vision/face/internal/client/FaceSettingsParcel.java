package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.face.internal.client.zzb;

public class FaceSettingsParcel implements SafeParcelable {
   public static final zzb CREATOR = new zzb();
   public int mode;
   public final int versionCode;
   public int zzbnV;
   public int zzbnW;
   public boolean zzbnX;
   public boolean zzbnY;
   public float zzbnZ;

   public FaceSettingsParcel() {
      this.versionCode = 2;
   }

   public FaceSettingsParcel(int var1, int var2, int var3, int var4, boolean var5, boolean var6, float var7) {
      this.versionCode = var1;
      this.mode = var2;
      this.zzbnV = var3;
      this.zzbnW = var4;
      this.zzbnX = var5;
      this.zzbnY = var6;
      this.zzbnZ = var7;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
