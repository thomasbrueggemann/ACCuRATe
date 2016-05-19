package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.video.VideoCapabilitiesCreator;

public final class VideoCapabilities implements SafeParcelable {
   public static final Creator<VideoCapabilities> CREATOR = new VideoCapabilitiesCreator();
   private final int mVersionCode;
   private final boolean zzaLm;
   private final boolean zzaLn;
   private final boolean zzaLo;
   private final boolean[] zzaLp;
   private final boolean[] zzaLq;

   public VideoCapabilities(int var1, boolean var2, boolean var3, boolean var4, boolean[] var5, boolean[] var6) {
      this.mVersionCode = var1;
      this.zzaLm = var2;
      this.zzaLn = var3;
      this.zzaLo = var4;
      this.zzaLp = var5;
      this.zzaLq = var6;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof VideoCapabilities)) {
         var2 = false;
      } else if(this != var1) {
         VideoCapabilities var3 = (VideoCapabilities)var1;
         if(!zzw.equal(var3.zzyb(), this.zzyb()) || !zzw.equal(var3.zzyc(), this.zzyc()) || !zzw.equal(Boolean.valueOf(var3.zzxZ()), Boolean.valueOf(this.zzxZ())) || !zzw.equal(Boolean.valueOf(var3.zzxY()), Boolean.valueOf(this.zzxY())) || !zzw.equal(Boolean.valueOf(var3.zzya()), Boolean.valueOf(this.zzya()))) {
            return false;
         }
      }

      return var2;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzyb(), this.zzyc(), Boolean.valueOf(this.zzxZ()), Boolean.valueOf(this.zzxY()), Boolean.valueOf(this.zzya())};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("SupportedCaptureModes", this.zzyb()).zzg("SupportedQualityLevels", this.zzyc()).zzg("CameraSupported", Boolean.valueOf(this.zzxZ())).zzg("MicSupported", Boolean.valueOf(this.zzxY())).zzg("StorageWriteSupported", Boolean.valueOf(this.zzya())).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      VideoCapabilitiesCreator.zza(this, var1, var2);
   }

   public boolean zzxY() {
      return this.zzaLn;
   }

   public boolean zzxZ() {
      return this.zzaLm;
   }

   public boolean zzya() {
      return this.zzaLo;
   }

   public boolean[] zzyb() {
      return this.zzaLp;
   }

   public boolean[] zzyc() {
      return this.zzaLq;
   }
}
