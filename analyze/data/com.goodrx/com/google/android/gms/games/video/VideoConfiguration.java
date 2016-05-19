package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.video.VideoConfigurationCreator;

public final class VideoConfiguration implements SafeParcelable {
   public static final Creator<VideoConfiguration> CREATOR = new VideoConfigurationCreator();
   private final int mVersionCode;
   private final int zzaLr;
   private final int zzaLs;
   private final String zzaLt;
   private final String zzaLu;

   public VideoConfiguration(int var1, int var2, int var3, String var4, String var5) {
      byte var6 = 1;
      super();
      this.mVersionCode = var1;
      zzx.zzac(zzgZ(var2));
      zzx.zzac(zzha(var3));
      this.zzaLr = var2;
      this.zzaLs = var3;
      if(var3 == var6) {
         this.zzaLu = var5;
         this.zzaLt = var4;
      } else {
         byte var7;
         if(var5 == null) {
            var7 = var6;
         } else {
            var7 = 0;
         }

         zzx.zzb((boolean)var7, "Stream key should be null when not streaming");
         if(var4 != null) {
            var6 = 0;
         }

         zzx.zzb((boolean)var6, "Stream url should be null when not streaming");
         this.zzaLu = null;
         this.zzaLt = null;
      }
   }

   public static boolean zzgZ(int var0) {
      switch(var0) {
      case 0:
      case 1:
      case 2:
      case 3:
         return true;
      default:
         return false;
      }
   }

   public static boolean zzha(int var0) {
      switch(var0) {
      case 0:
      case 1:
         return true;
      default:
         return false;
      }
   }

   public int describeContents() {
      return 0;
   }

   public String getStreamUrl() {
      return this.zzaLt;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      VideoConfigurationCreator.zza(this, var1, var2);
   }

   public int zzyd() {
      return this.zzaLr;
   }

   public int zzye() {
      return this.zzaLs;
   }

   public String zzyf() {
      return this.zzaLu;
   }
}
