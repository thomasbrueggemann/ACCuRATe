package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.video.Video;
import com.google.android.gms.games.video.VideoEntityCreator;

public final class VideoEntity implements SafeParcelable, Video {
   public static final Creator<VideoEntity> CREATOR = new VideoEntityCreator();
   private final int mVersionCode;
   private final long zzCv;
   private final String zzTJ;
   private final String zzaLv;
   private final long zzaLw;
   private final int zzakd;

   VideoEntity(int var1, int var2, String var3, long var4, long var6, String var8) {
      this.mVersionCode = var1;
      this.zzakd = var2;
      this.zzaLv = var3;
      this.zzaLw = var4;
      this.zzCv = var6;
      this.zzTJ = var8;
   }

   public VideoEntity(Video var1) {
      this.mVersionCode = 1;
      this.zzakd = var1.getDuration();
      this.zzaLv = var1.zzxX();
      this.zzaLw = var1.getFileSize();
      this.zzCv = var1.getStartTime();
      this.zzTJ = var1.getPackageName();
      zzb.zzv(this.zzaLv);
      zzb.zzv(this.zzTJ);
   }

   static int zza(Video var0) {
      Object[] var1 = new Object[]{Integer.valueOf(var0.getDuration()), var0.zzxX(), Long.valueOf(var0.getFileSize()), Long.valueOf(var0.getStartTime()), var0.getPackageName()};
      return zzw.hashCode(var1);
   }

   static boolean zza(Video var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Video)) {
         var2 = false;
      } else if(var0 != var1) {
         Video var3 = (Video)var1;
         if(!zzw.equal(Integer.valueOf(var3.getDuration()), Integer.valueOf(var0.getDuration())) || !zzw.equal(var3.zzxX(), var0.zzxX()) || !zzw.equal(Long.valueOf(var3.getFileSize()), Long.valueOf(var0.getFileSize())) || !zzw.equal(Long.valueOf(var3.getStartTime()), Long.valueOf(var0.getStartTime())) || !zzw.equal(var3.getPackageName(), var0.getPackageName())) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(Video var0) {
      return zzw.zzy(var0).zzg("Duration", Integer.valueOf(var0.getDuration())).zzg("File path", var0.zzxX()).zzg("File size", Long.valueOf(var0.getFileSize())).zzg("Start time", Long.valueOf(var0.getStartTime())).zzg("Package name", var0.getPackageName()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzyg();
   }

   public int getDuration() {
      return this.zzakd;
   }

   public long getFileSize() {
      return this.zzaLw;
   }

   public String getPackageName() {
      return this.zzTJ;
   }

   public long getStartTime() {
      return this.zzCv;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return zza(this);
   }

   public String toString() {
      return zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      VideoEntityCreator.zza(this, var1, var2);
   }

   public String zzxX() {
      return this.zzaLv;
   }

   public Video zzyg() {
      return this;
   }
}
