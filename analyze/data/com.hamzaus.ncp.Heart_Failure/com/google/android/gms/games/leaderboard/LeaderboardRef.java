package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.games.leaderboard.LeaderboardVariantRef;
import java.util.ArrayList;

public final class LeaderboardRef extends class_206 implements Leaderboard {
   // $FF: renamed from: RD int
   private final int field_703;
   // $FF: renamed from: Sp com.google.android.gms.games.Game
   private final Game field_704;

   LeaderboardRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.field_703 = var3;
      this.field_704 = new GameRef(var1, var2);
   }

   public boolean equals(Object var1) {
      return LeaderboardEntity.method_3175(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1376();
   }

   public String getDisplayName() {
      return this.getString("name");
   }

   public void getDisplayName(CharArrayBuffer var1) {
      this.a("name", var1);
   }

   public Game getGame() {
      return this.field_704;
   }

   public Uri getIconImageUri() {
      return this.aw("board_icon_image_uri");
   }

   public String getIconImageUrl() {
      return this.getString("board_icon_image_url");
   }

   public String getLeaderboardId() {
      return this.getString("external_leaderboard_id");
   }

   public int getScoreOrder() {
      return this.getInteger("score_order");
   }

   public ArrayList<LeaderboardVariant> getVariants() {
      ArrayList var1 = new ArrayList(this.field_703);

      for(int var2 = 0; var2 < this.field_703; ++var2) {
         var1.add(new LeaderboardVariantRef(this.DD, var2 + this.Ez));
      }

      return var1;
   }

   public int hashCode() {
      return LeaderboardEntity.method_3174(this);
   }

   // $FF: renamed from: iu () com.google.android.gms.games.leaderboard.Leaderboard
   public Leaderboard method_1376() {
      return new LeaderboardEntity(this);
   }

   public String toString() {
      return LeaderboardEntity.method_3176(this);
   }
}
