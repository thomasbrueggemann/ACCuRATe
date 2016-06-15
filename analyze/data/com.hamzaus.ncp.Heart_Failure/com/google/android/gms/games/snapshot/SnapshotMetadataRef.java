package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

public final class SnapshotMetadataRef extends class_206 implements SnapshotMetadata {
   // $FF: renamed from: Sp com.google.android.gms.games.Game
   private final Game field_686;
   // $FF: renamed from: Uo com.google.android.gms.games.Player
   private final Player field_687;

   public SnapshotMetadataRef(DataHolder var1, int var2) {
      super(var1, var2);
      this.field_686 = new GameRef(var1, var2);
      this.field_687 = new PlayerRef(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return SnapshotMetadataEntity.method_4073(this, var1);
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
      return this.aw("cover_icon_image_uri");
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
      return this.field_686;
   }

   public long getLastModifiedTimestamp() {
      return this.getLong("last_modified_timestamp");
   }

   public Player getOwner() {
      return this.field_687;
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

   public int hashCode() {
      return SnapshotMetadataEntity.method_4072(this);
   }

   public String toString() {
      return SnapshotMetadataEntity.method_4074(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((SnapshotMetadataEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
