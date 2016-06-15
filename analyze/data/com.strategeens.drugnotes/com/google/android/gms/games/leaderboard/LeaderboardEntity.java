package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.games.leaderboard.LeaderboardVariantEntity;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_719;
import java.util.ArrayList;

public final class LeaderboardEntity implements Leaderboard {
   // $FF: renamed from: OS java.lang.String
   private final String field_2897;
   // $FF: renamed from: WD android.net.Uri
   private final Uri field_2898;
   // $FF: renamed from: WO java.lang.String
   private final String field_2899;
   private final String adn;
   private final int ado;
   private final ArrayList<LeaderboardVariantEntity> adp;
   private final Game adq;

   public LeaderboardEntity(Leaderboard var1) {
      this.adn = var1.getLeaderboardId();
      this.field_2897 = var1.getDisplayName();
      this.field_2898 = var1.getIconImageUri();
      this.field_2899 = var1.getIconImageUrl();
      this.ado = var1.getScoreOrder();
      Game var2 = var1.getGame();
      GameEntity var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = new GameEntity(var2);
      }

      this.adq = var3;
      ArrayList var4 = var1.getVariants();
      int var5 = var4.size();
      this.adp = new ArrayList(var5);

      for(int var6 = 0; var6 < var5; ++var6) {
         this.adp.add((LeaderboardVariantEntity)((LeaderboardVariantEntity)((LeaderboardVariant)var4.get(var6)).freeze()));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.leaderboard.Leaderboard) int
   static int method_3804(Leaderboard var0) {
      Object[] var1 = new Object[]{var0.getLeaderboardId(), var0.getDisplayName(), var0.getIconImageUri(), Integer.valueOf(var0.getScoreOrder()), var0.getVariants()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.leaderboard.Leaderboard, java.lang.Object) boolean
   static boolean method_3805(Leaderboard var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Leaderboard)) {
         var2 = false;
      } else if(var0 != var1) {
         Leaderboard var3 = (Leaderboard)var1;
         if(!class_336.equal(var3.getLeaderboardId(), var0.getLeaderboardId()) || !class_336.equal(var3.getDisplayName(), var0.getDisplayName()) || !class_336.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_336.equal(Integer.valueOf(var3.getScoreOrder()), Integer.valueOf(var0.getScoreOrder())) || !class_336.equal(var3.getVariants(), var0.getVariants())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.leaderboard.Leaderboard) java.lang.String
   static String method_3806(Leaderboard var0) {
      return class_336.method_2312(var0).method_3424("LeaderboardId", var0.getLeaderboardId()).method_3424("DisplayName", var0.getDisplayName()).method_3424("IconImageUri", var0.getIconImageUri()).method_3424("IconImageUrl", var0.getIconImageUrl()).method_3424("ScoreOrder", Integer.valueOf(var0.getScoreOrder())).method_3424("Variants", var0.getVariants()).toString();
   }

   public boolean equals(Object var1) {
      return method_3805(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_3807();
   }

   public String getDisplayName() {
      return this.field_2897;
   }

   public void getDisplayName(CharArrayBuffer var1) {
      class_719.method_4197(this.field_2897, var1);
   }

   public Game getGame() {
      return this.adq;
   }

   public Uri getIconImageUri() {
      return this.field_2898;
   }

   public String getIconImageUrl() {
      return this.field_2899;
   }

   public String getLeaderboardId() {
      return this.adn;
   }

   public int getScoreOrder() {
      return this.ado;
   }

   public ArrayList<LeaderboardVariant> getVariants() {
      return new ArrayList(this.adp);
   }

   public int hashCode() {
      return method_3804(this);
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: mG () com.google.android.gms.games.leaderboard.Leaderboard
   public Leaderboard method_3807() {
      return this;
   }

   public String toString() {
      return method_3806(this);
   }
}
