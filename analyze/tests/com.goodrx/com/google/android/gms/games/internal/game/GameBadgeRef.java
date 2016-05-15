package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeEntity;

public final class GameBadgeRef extends zzc implements GameBadge {
   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return GameBadgeEntity.zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzxm();
   }

   public String getDescription() {
      return this.getString("badge_description");
   }

   public Uri getIconImageUri() {
      return this.zzcA("badge_icon_image_uri");
   }

   public String getTitle() {
      return this.getString("badge_title");
   }

   public int getType() {
      return this.getInteger("badge_type");
   }

   public int hashCode() {
      return GameBadgeEntity.zza(this);
   }

   public String toString() {
      return GameBadgeEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((GameBadgeEntity)this.zzxm()).writeToParcel(var1, var2);
   }

   public GameBadge zzxm() {
      return new GameBadgeEntity(this);
   }
}
