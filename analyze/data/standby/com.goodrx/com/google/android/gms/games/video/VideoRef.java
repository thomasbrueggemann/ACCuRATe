package com.google.android.gms.games.video;

import android.os.Parcel;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.video.Video;
import com.google.android.gms.games.video.VideoEntity;

public final class VideoRef extends zzc implements Video {
   public int describeContents() {
      return 0;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzyg();
   }

   public int getDuration() {
      return this.getInteger("duration");
   }

   public long getFileSize() {
      return this.getLong("filesize");
   }

   public String getPackageName() {
      return this.getString("package");
   }

   public long getStartTime() {
      return this.getLong("start_time");
   }

   public String toString() {
      return VideoEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((VideoEntity)this.zzyg()).writeToParcel(var1, var2);
   }

   public String zzxX() {
      return this.getString("filepath");
   }

   public Video zzyg() {
      return new VideoEntity(this);
   }
}
