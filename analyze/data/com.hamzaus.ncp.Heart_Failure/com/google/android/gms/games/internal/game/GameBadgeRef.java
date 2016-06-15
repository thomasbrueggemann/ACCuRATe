package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeEntity;

public final class GameBadgeRef extends class_206 implements GameBadge {
   GameBadgeRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return GameBadgeEntity.method_2182(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1378();
   }

   public String getDescription() {
      return this.getString("badge_description");
   }

   public Uri getIconImageUri() {
      return this.aw("badge_icon_image_uri");
   }

   public String getTitle() {
      return this.getString("badge_title");
   }

   public int getType() {
      return this.getInteger("badge_type");
   }

   // $FF: renamed from: hX () com.google.android.gms.games.internal.game.GameBadge
   public GameBadge method_1378() {
      return new GameBadgeEntity(this);
   }

   public int hashCode() {
      return GameBadgeEntity.method_2181(this);
   }

   public String toString() {
      return GameBadgeEntity.method_2184(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((GameBadgeEntity)this.method_1378()).writeToParcel(var1, var2);
   }
}
