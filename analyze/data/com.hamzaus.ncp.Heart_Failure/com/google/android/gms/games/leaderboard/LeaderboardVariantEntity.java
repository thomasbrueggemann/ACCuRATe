package com.google.android.gms.games.leaderboard;

import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.internal.class_349;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
   // $FF: renamed from: SE int
   private final int field_3826;
   // $FF: renamed from: SF int
   private final int field_3827;
   // $FF: renamed from: SG boolean
   private final boolean field_3828;
   // $FF: renamed from: SH long
   private final long field_3829;
   // $FF: renamed from: SI java.lang.String
   private final String field_3830;
   // $FF: renamed from: SJ long
   private final long field_3831;
   // $FF: renamed from: SK java.lang.String
   private final String field_3832;
   // $FF: renamed from: SL java.lang.String
   private final String field_3833;
   // $FF: renamed from: SM long
   private final long field_3834;
   // $FF: renamed from: SN java.lang.String
   private final String field_3835;
   // $FF: renamed from: SO java.lang.String
   private final String field_3836;
   // $FF: renamed from: SP java.lang.String
   private final String field_3837;

   public LeaderboardVariantEntity(LeaderboardVariant var1) {
      this.field_3826 = var1.getTimeSpan();
      this.field_3827 = var1.getCollection();
      this.field_3828 = var1.hasPlayerInfo();
      this.field_3829 = var1.getRawPlayerScore();
      this.field_3830 = var1.getDisplayPlayerScore();
      this.field_3831 = var1.getPlayerRank();
      this.field_3832 = var1.getDisplayPlayerRank();
      this.field_3833 = var1.getPlayerScoreTag();
      this.field_3834 = var1.getNumScores();
      this.field_3835 = var1.method_230();
      this.field_3836 = var1.method_231();
      this.field_3837 = var1.method_229();
   }

   // $FF: renamed from: a (com.google.android.gms.games.leaderboard.LeaderboardVariant) int
   static int method_4065(LeaderboardVariant var0) {
      Object[] var1 = new Object[]{Integer.valueOf(var0.getTimeSpan()), Integer.valueOf(var0.getCollection()), Boolean.valueOf(var0.hasPlayerInfo()), Long.valueOf(var0.getRawPlayerScore()), var0.getDisplayPlayerScore(), Long.valueOf(var0.getPlayerRank()), var0.getDisplayPlayerRank(), Long.valueOf(var0.getNumScores()), var0.method_230(), var0.method_229(), var0.method_231()};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.leaderboard.LeaderboardVariant, java.lang.Object) boolean
   static boolean method_4066(LeaderboardVariant var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof LeaderboardVariant)) {
         var2 = false;
      } else if(var0 != var1) {
         LeaderboardVariant var3 = (LeaderboardVariant)var1;
         if(!class_349.equal(Integer.valueOf(var3.getTimeSpan()), Integer.valueOf(var0.getTimeSpan())) || !class_349.equal(Integer.valueOf(var3.getCollection()), Integer.valueOf(var0.getCollection())) || !class_349.equal(Boolean.valueOf(var3.hasPlayerInfo()), Boolean.valueOf(var0.hasPlayerInfo())) || !class_349.equal(Long.valueOf(var3.getRawPlayerScore()), Long.valueOf(var0.getRawPlayerScore())) || !class_349.equal(var3.getDisplayPlayerScore(), var0.getDisplayPlayerScore()) || !class_349.equal(Long.valueOf(var3.getPlayerRank()), Long.valueOf(var0.getPlayerRank())) || !class_349.equal(var3.getDisplayPlayerRank(), var0.getDisplayPlayerRank()) || !class_349.equal(Long.valueOf(var3.getNumScores()), Long.valueOf(var0.getNumScores())) || !class_349.equal(var3.method_230(), var0.method_230()) || !class_349.equal(var3.method_229(), var0.method_229()) || !class_349.equal(var3.method_231(), var0.method_231())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.leaderboard.LeaderboardVariant) java.lang.String
   static String method_4067(LeaderboardVariant var0) {
      class_349.class_1264 var1 = class_349.method_2174(var0).method_4301("TimeSpan", TimeSpan.method_4462(var0.getTimeSpan())).method_4301("Collection", LeaderboardCollection.method_3287(var0.getCollection()));
      Object var2;
      if(var0.hasPlayerInfo()) {
         var2 = Long.valueOf(var0.getRawPlayerScore());
      } else {
         var2 = "none";
      }

      class_349.class_1264 var3 = var1.method_4301("RawPlayerScore", var2);
      String var4;
      if(var0.hasPlayerInfo()) {
         var4 = var0.getDisplayPlayerScore();
      } else {
         var4 = "none";
      }

      class_349.class_1264 var5 = var3.method_4301("DisplayPlayerScore", var4);
      Object var6;
      if(var0.hasPlayerInfo()) {
         var6 = Long.valueOf(var0.getPlayerRank());
      } else {
         var6 = "none";
      }

      class_349.class_1264 var7 = var5.method_4301("PlayerRank", var6);
      String var8;
      if(var0.hasPlayerInfo()) {
         var8 = var0.getDisplayPlayerRank();
      } else {
         var8 = "none";
      }

      return var7.method_4301("DisplayPlayerRank", var8).method_4301("NumScores", Long.valueOf(var0.getNumScores())).method_4301("TopPageNextToken", var0.method_230()).method_4301("WindowPageNextToken", var0.method_229()).method_4301("WindowPagePrevToken", var0.method_231()).toString();
   }

   public boolean equals(Object var1) {
      return method_4066(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_4068();
   }

   public int getCollection() {
      return this.field_3827;
   }

   public String getDisplayPlayerRank() {
      return this.field_3832;
   }

   public String getDisplayPlayerScore() {
      return this.field_3830;
   }

   public long getNumScores() {
      return this.field_3834;
   }

   public long getPlayerRank() {
      return this.field_3831;
   }

   public String getPlayerScoreTag() {
      return this.field_3833;
   }

   public long getRawPlayerScore() {
      return this.field_3829;
   }

   public int getTimeSpan() {
      return this.field_3826;
   }

   public boolean hasPlayerInfo() {
      return this.field_3828;
   }

   public int hashCode() {
      return method_4065(this);
   }

   // $FF: renamed from: iA () java.lang.String
   public String method_229() {
      return this.field_3837;
   }

   // $FF: renamed from: iB () com.google.android.gms.games.leaderboard.LeaderboardVariant
   public LeaderboardVariant method_4068() {
      return this;
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: iy () java.lang.String
   public String method_230() {
      return this.field_3835;
   }

   // $FF: renamed from: iz () java.lang.String
   public String method_231() {
      return this.field_3836;
   }

   public String toString() {
      return method_4067(this);
   }
}
