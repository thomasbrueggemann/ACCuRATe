package com.google.android.gms.vision.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.internal.client.zza;

public class FrameMetadataParcel implements SafeParcelable {
   public static final zza CREATOR = new zza();
   public int height;
   // $FF: renamed from: id int
   public int field_635;
   public int rotation;
   final int versionCode;
   public int width;
   public long zzboe;

   public FrameMetadataParcel() {
      this.versionCode = 1;
   }

   public FrameMetadataParcel(int var1, int var2, int var3, int var4, long var5, int var7) {
      this.versionCode = var1;
      this.width = var2;
      this.height = var3;
      this.field_635 = var4;
      this.zzboe = var5;
      this.rotation = var7;
   }

   public int describeContents() {
      zza var10000 = CREATOR;
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza var10000 = CREATOR;
      zza.zza(this, var1, var2);
   }
}
