package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;
import com.google.android.gms.vision.face.internal.client.zza;

public class FaceParcel implements SafeParcelable {
   public static final zza CREATOR = new zza();
   public final float centerX;
   public final float centerY;
   public final float height;
   // $FF: renamed from: id int
   public final int field_136;
   public final int versionCode;
   public final float width;
   public final float zzbnP;
   public final float zzbnQ;
   public final LandmarkParcel[] zzbnR;
   public final float zzbnS;
   public final float zzbnT;
   public final float zzbnU;

   public FaceParcel(int var1, int var2, float var3, float var4, float var5, float var6, float var7, float var8, LandmarkParcel[] var9, float var10, float var11, float var12) {
      this.versionCode = var1;
      this.field_136 = var2;
      this.centerX = var3;
      this.centerY = var4;
      this.width = var5;
      this.height = var6;
      this.zzbnP = var7;
      this.zzbnQ = var8;
      this.zzbnR = var9;
      this.zzbnS = var10;
      this.zzbnT = var11;
      this.zzbnU = var12;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
