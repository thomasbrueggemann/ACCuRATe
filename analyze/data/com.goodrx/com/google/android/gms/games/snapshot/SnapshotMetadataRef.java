package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

public final class SnapshotMetadataRef extends zzc implements SnapshotMetadata {
   private final Game zzaJc;
   private final Player zzaLc;

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return SnapshotMetadataEntity.zza(this, var1);
   }

   public SnapshotMetadata freeze() {
      return new SnapshotMetadataEntity(this);
   }

   public float getCoverImageAspectRatio() {
      float var1 = this.getFloat("cover_icon_image_height");
      float var2 = this.getFloat("cover_icon_image_width");
      return var1 == 0.0F?0.0F:var2 / var1;
   }

   public Uri getCoverImageUri() {
      return this.zzcA("cover_icon_image_uri");
   }

   public String getCoverImageUrl() {
      return this.getString("cover_icon_image_url");
   }

   public String getDescription() {
      return this.getString("description");
   }

   public String getDeviceName() {
      return this.getString("device_name");
   }

   public Game getGame() {
      return this.zzaJc;
   }

   public long getLastModifiedTimestamp() {
      return this.getLong("last_modified_timestamp");
   }

   public Player getOwner() {
      return this.zzaLc;
   }

   public long getPlayedTime() {
      return this.getLong("duration");
   }

   public long getProgressValue() {
      return this.getLong("progress_value");
   }

   public String getSnapshotId() {
      return this.getString("external_snapshot_id");
   }

   public String getTitle() {
      return this.getString("title");
   }

   public String getUniqueName() {
      return this.getString("unique_name");
   }

   public boolean hasChangePending() {
      return this.getInteger("pending_change_count") > 0;
   }

   public int hashCode() {
      return SnapshotMetadataEntity.zza(this);
   }

   public String toString() {
      return SnapshotMetadataEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((SnapshotMetadataEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
