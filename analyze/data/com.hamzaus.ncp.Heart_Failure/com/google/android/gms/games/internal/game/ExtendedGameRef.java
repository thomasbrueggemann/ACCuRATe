package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.internal.game.ExtendedGame;
import com.google.android.gms.games.internal.game.ExtendedGameEntity;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeRef;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataRef;
import java.util.ArrayList;

public class ExtendedGameRef extends class_206 implements ExtendedGame {
   // $FF: renamed from: RB com.google.android.gms.games.GameRef
   private final GameRef field_697;
   // $FF: renamed from: RC com.google.android.gms.games.snapshot.SnapshotMetadataRef
   private final SnapshotMetadataRef field_698;
   // $FF: renamed from: RD int
   private final int field_699;

   ExtendedGameRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.field_697 = new GameRef(var1, var2);
      this.field_699 = var3;
      if(this.av("external_snapshot_id") && !this.ax("external_snapshot_id")) {
         this.field_698 = new SnapshotMetadataRef(var1, var2);
      } else {
         this.field_698 = null;
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return ExtendedGameEntity.method_2189(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1375();
   }

   public Game getGame() {
      return this.field_697;
   }

   // $FF: renamed from: hL () java.util.ArrayList
   public ArrayList<GameBadge> method_236() {
      int var1 = 0;
      if(this.DD.method_4560("badge_title", this.Ez, this.DD.method_4556(this.Ez)) == null) {
         return new ArrayList(0);
      } else {
         ArrayList var2;
         for(var2 = new ArrayList(this.field_699); var1 < this.field_699; ++var1) {
            var2.add(new GameBadgeRef(this.DD, var1 + this.Ez));
         }

         return var2;
      }
   }

   // $FF: renamed from: hM () int
   public int method_237() {
      return this.getInteger("availability");
   }

   // $FF: renamed from: hN () boolean
   public boolean method_238() {
      return this.getBoolean("owned");
   }

   // $FF: renamed from: hO () int
   public int method_239() {
      return this.getInteger("achievement_unlocked_count");
   }

   // $FF: renamed from: hP () long
   public long method_240() {
      return this.getLong("last_played_server_time");
   }

   // $FF: renamed from: hQ () long
   public long method_241() {
      return this.getLong("price_micros");
   }

   // $FF: renamed from: hR () java.lang.String
   public String method_242() {
      return this.getString("formatted_price");
   }

   // $FF: renamed from: hS () long
   public long method_243() {
      return this.getLong("full_price_micros");
   }

   // $FF: renamed from: hT () java.lang.String
   public String method_244() {
      return this.getString("formatted_full_price");
   }

   // $FF: renamed from: hU () com.google.android.gms.games.snapshot.SnapshotMetadata
   public SnapshotMetadata method_245() {
      return this.field_698;
   }

   // $FF: renamed from: hW () com.google.android.gms.games.internal.game.ExtendedGame
   public ExtendedGame method_1375() {
      return new ExtendedGameEntity(this);
   }

   public int hashCode() {
      return ExtendedGameEntity.method_2188(this);
   }

   public String toString() {
      return ExtendedGameEntity.method_2191(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((ExtendedGameEntity)this.method_1375()).writeToParcel(var1, var2);
   }
}
