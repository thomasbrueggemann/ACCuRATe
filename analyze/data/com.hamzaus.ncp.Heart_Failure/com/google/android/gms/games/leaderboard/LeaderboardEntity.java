package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.games.leaderboard.LeaderboardVariantEntity;
import com.google.android.gms.internal.class_284;
import com.google.android.gms.internal.class_349;
import java.util.ArrayList;

public final class LeaderboardEntity implements Leaderboard {
   // $FF: renamed from: Lk java.lang.String
   private final String field_2996;
   // $FF: renamed from: Mo android.net.Uri
   private final Uri field_2997;
   // $FF: renamed from: Mz java.lang.String
   private final String field_2998;
   // $FF: renamed from: Sm java.lang.String
   private final String field_2999;
   // $FF: renamed from: Sn int
   private final int field_3000;
   // $FF: renamed from: So java.util.ArrayList
   private final ArrayList<LeaderboardVariantEntity> field_3001;
   // $FF: renamed from: Sp com.google.android.gms.games.Game
   private final Game field_3002;

   public LeaderboardEntity(Leaderboard var1) {
      this.field_2999 = var1.getLeaderboardId();
      this.field_2996 = var1.getDisplayName();
      this.field_2997 = var1.getIconImageUri();
      this.field_2998 = var1.getIconImageUrl();
      this.field_3000 = var1.getScoreOrder();
      Game var2 = var1.getGame();
      GameEntity var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = new GameEntity(var2);
      }

      this.field_3002 = var3;
      ArrayList var4 = var1.getVariants();
      int var5 = var4.size();
      this.field_3001 = new ArrayList(var5);

      for(int var6 = 0; var6 < var5; ++var6) {
         this.field_3001.add((LeaderboardVariantEntity)((LeaderboardVariantEntity)((LeaderboardVariant)var4.get(var6)).freeze()));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.leaderboard.Leaderboard) int
   static int method_3174(Leaderboard var0) {
      Object[] var1 = new Object[]{var0.getLeaderboardId(), var0.getDisplayName(), var0.getIconImageUri(), Integer.valueOf(var0.getScoreOrder()), var0.getVariants()};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.leaderboard.Leaderboard, java.lang.Object) boolean
   static boolean method_3175(Leaderboard var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Leaderboard)) {
         var2 = false;
      } else if(var0 != var1) {
         Leaderboard var3 = (Leaderboard)var1;
         if(!class_349.equal(var3.getLeaderboardId(), var0.getLeaderboardId()) || !class_349.equal(var3.getDisplayName(), var0.getDisplayName()) || !class_349.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_349.equal(Integer.valueOf(var3.getScoreOrder()), Integer.valueOf(var0.getScoreOrder())) || !class_349.equal(var3.getVariants(), var0.getVariants())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.leaderboard.Leaderboard) java.lang.String
   static String method_3176(Leaderboard var0) {
      return class_349.method_2174(var0).method_4301("LeaderboardId", var0.getLeaderboardId()).method_4301("DisplayName", var0.getDisplayName()).method_4301("IconImageUri", var0.getIconImageUri()).method_4301("IconImageUrl", var0.getIconImageUrl()).method_4301("ScoreOrder", Integer.valueOf(var0.getScoreOrder())).method_4301("Variants", var0.getVariants()).toString();
   }

   public boolean equals(Object var1) {
      return method_3175(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_3177();
   }

   public String getDisplayName() {
      return this.field_2996;
   }

   public void getDisplayName(CharArrayBuffer var1) {
      class_284.method_1876(this.field_2996, var1);
   }

   public Game getGame() {
      return this.field_3002;
   }

   public Uri getIconImageUri() {
      return this.field_2997;
   }

   public String getIconImageUrl() {
      return this.field_2998;
   }

   public String getLeaderboardId() {
      return this.field_2999;
   }

   public int getScoreOrder() {
      return this.field_3000;
   }

   public ArrayList<LeaderboardVariant> getVariants() {
      return new ArrayList(this.field_3001);
   }

   public int hashCode() {
      return method_3174(this);
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: iu () com.google.android.gms.games.leaderboard.Leaderboard
   public Leaderboard method_3177() {
      return this;
   }

   public String toString() {
      return method_3176(this);
   }
}
