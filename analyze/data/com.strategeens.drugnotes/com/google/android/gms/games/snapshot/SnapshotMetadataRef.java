package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

public final class SnapshotMetadataRef extends class_251 implements SnapshotMetadata {
   private final Game adq;
   private final Player afn;

   public SnapshotMetadataRef(DataHolder var1, int var2) {
      super(var1, var2);
      this.adq = new GameRef(var1, var2);
      this.afn = new PlayerRef(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return SnapshotMetadataEntity.method_5179(this, var1);
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
      return this.aR("cover_icon_image_uri");
   }

   public String getCoverImageUrl() {
      return this.getString("cover_icon_image_url");
   }

   public String getDescription() {
      return this.getString("description");
   }

   public void getDescription(CharArrayBuffer var1) {
      this.a("description", var1);
   }

   public Game getGame() {
      return this.adq;
   }

   public long getLastModifiedTimestamp() {
      return this.getLong("last_modified_timestamp");
   }

   public Player getOwner() {
      return this.afn;
   }

   public long getPlayedTime() {
      return this.getLong("duration");
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
      return SnapshotMetadataEntity.method_5178(this);
   }

   public String toString() {
      return SnapshotMetadataEntity.method_5180(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((SnapshotMetadataEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
