package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.internal.game.ExtendedGame;
import com.google.android.gms.games.internal.game.ExtendedGameEntity;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeRef;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataRef;
import java.util.ArrayList;

public class ExtendedGameRef extends class_251 implements ExtendedGame {
   // $FF: renamed from: Ya int
   private final int field_538;
   private final SnapshotMetadataRef acD;
   private final GameRef acr;

   ExtendedGameRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.acr = new GameRef(var1, var2);
      this.field_538 = var3;
      if(this.aQ("external_snapshot_id") && !this.aS("external_snapshot_id")) {
         this.acD = new SnapshotMetadataRef(var1, var2);
      } else {
         this.acD = null;
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return ExtendedGameEntity.method_2377(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1682();
   }

   public Game getGame() {
      return this.acr;
   }

   public int hashCode() {
      return ExtendedGameEntity.method_2376(this);
   }

   // $FF: renamed from: lY () java.util.ArrayList
   public ArrayList<GameBadge> method_266() {
      int var1 = 0;
      if(this.JG.method_5831("badge_title", this.KZ, this.JG.method_5829(this.KZ)) == null) {
         return new ArrayList(0);
      } else {
         ArrayList var2;
         for(var2 = new ArrayList(this.field_538); var1 < this.field_538; ++var1) {
            var2.add(new GameBadgeRef(this.JG, var1 + this.KZ));
         }

         return var2;
      }
   }

   // $FF: renamed from: lZ () int
   public int method_267() {
      return this.getInteger("availability");
   }

   // $FF: renamed from: ma () boolean
   public boolean method_268() {
      return this.getBoolean("owned");
   }

   // $FF: renamed from: mb () int
   public int method_269() {
      return this.getInteger("achievement_unlocked_count");
   }

   // $FF: renamed from: mc () long
   public long method_270() {
      return this.getLong("last_played_server_time");
   }

   // $FF: renamed from: md () long
   public long method_271() {
      return this.getLong("price_micros");
   }

   // $FF: renamed from: me () java.lang.String
   public String method_272() {
      return this.getString("formatted_price");
   }

   // $FF: renamed from: mf () long
   public long method_273() {
      return this.getLong("full_price_micros");
   }

   // $FF: renamed from: mg () java.lang.String
   public String method_274() {
      return this.getString("formatted_full_price");
   }

   // $FF: renamed from: mh () com.google.android.gms.games.snapshot.SnapshotMetadata
   public SnapshotMetadata method_275() {
      return this.acD;
   }

   // $FF: renamed from: mj () com.google.android.gms.games.internal.game.ExtendedGame
   public ExtendedGame method_1682() {
      return new ExtendedGameEntity(this);
   }

   public String toString() {
      return ExtendedGameEntity.method_2378(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((ExtendedGameEntity)this.method_1682()).writeToParcel(var1, var2);
   }
}
