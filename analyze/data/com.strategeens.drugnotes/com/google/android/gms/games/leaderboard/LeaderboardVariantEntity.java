package com.google.android.gms.games.leaderboard;

import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.internal.class_336;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
   private final int adF;
   private final int adG;
   private final boolean adH;
   private final long adI;
   private final String adJ;
   private final long adK;
   private final String adL;
   private final String adM;
   private final long adN;
   private final String adO;
   private final String adP;
   private final String adQ;

   public LeaderboardVariantEntity(LeaderboardVariant var1) {
      this.adF = var1.getTimeSpan();
      this.adG = var1.getCollection();
      this.adH = var1.hasPlayerInfo();
      this.adI = var1.getRawPlayerScore();
      this.adJ = var1.getDisplayPlayerScore();
      this.adK = var1.getPlayerRank();
      this.adL = var1.getDisplayPlayerRank();
      this.adM = var1.getPlayerScoreTag();
      this.adN = var1.getNumScores();
      this.adO = var1.method_254();
      this.adP = var1.method_255();
      this.adQ = var1.method_256();
   }

   // $FF: renamed from: a (com.google.android.gms.games.leaderboard.LeaderboardVariant) int
   static int method_5164(LeaderboardVariant var0) {
      Object[] var1 = new Object[]{Integer.valueOf(var0.getTimeSpan()), Integer.valueOf(var0.getCollection()), Boolean.valueOf(var0.hasPlayerInfo()), Long.valueOf(var0.getRawPlayerScore()), var0.getDisplayPlayerScore(), Long.valueOf(var0.getPlayerRank()), var0.getDisplayPlayerRank(), Long.valueOf(var0.getNumScores()), var0.method_254(), var0.method_256(), var0.method_255()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.leaderboard.LeaderboardVariant, java.lang.Object) boolean
   static boolean method_5165(LeaderboardVariant var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof LeaderboardVariant)) {
         var2 = false;
      } else if(var0 != var1) {
         LeaderboardVariant var3 = (LeaderboardVariant)var1;
         if(!class_336.equal(Integer.valueOf(var3.getTimeSpan()), Integer.valueOf(var0.getTimeSpan())) || !class_336.equal(Integer.valueOf(var3.getCollection()), Integer.valueOf(var0.getCollection())) || !class_336.equal(Boolean.valueOf(var3.hasPlayerInfo()), Boolean.valueOf(var0.hasPlayerInfo())) || !class_336.equal(Long.valueOf(var3.getRawPlayerScore()), Long.valueOf(var0.getRawPlayerScore())) || !class_336.equal(var3.getDisplayPlayerScore(), var0.getDisplayPlayerScore()) || !class_336.equal(Long.valueOf(var3.getPlayerRank()), Long.valueOf(var0.getPlayerRank())) || !class_336.equal(var3.getDisplayPlayerRank(), var0.getDisplayPlayerRank()) || !class_336.equal(Long.valueOf(var3.getNumScores()), Long.valueOf(var0.getNumScores())) || !class_336.equal(var3.method_254(), var0.method_254()) || !class_336.equal(var3.method_256(), var0.method_256()) || !class_336.equal(var3.method_255(), var0.method_255())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.leaderboard.LeaderboardVariant) java.lang.String
   static String method_5166(LeaderboardVariant var0) {
      class_336.class_1339 var1 = class_336.method_2312(var0).method_3424("TimeSpan", TimeSpan.method_5689(var0.getTimeSpan())).method_3424("Collection", LeaderboardCollection.method_3922(var0.getCollection()));
      Object var2;
      if(var0.hasPlayerInfo()) {
         var2 = Long.valueOf(var0.getRawPlayerScore());
      } else {
         var2 = "none";
      }

      class_336.class_1339 var3 = var1.method_3424("RawPlayerScore", var2);
      String var4;
      if(var0.hasPlayerInfo()) {
         var4 = var0.getDisplayPlayerScore();
      } else {
         var4 = "none";
      }

      class_336.class_1339 var5 = var3.method_3424("DisplayPlayerScore", var4);
      Object var6;
      if(var0.hasPlayerInfo()) {
         var6 = Long.valueOf(var0.getPlayerRank());
      } else {
         var6 = "none";
      }

      class_336.class_1339 var7 = var5.method_3424("PlayerRank", var6);
      String var8;
      if(var0.hasPlayerInfo()) {
         var8 = var0.getDisplayPlayerRank();
      } else {
         var8 = "none";
      }

      return var7.method_3424("DisplayPlayerRank", var8).method_3424("NumScores", Long.valueOf(var0.getNumScores())).method_3424("TopPageNextToken", var0.method_254()).method_3424("WindowPageNextToken", var0.method_256()).method_3424("WindowPagePrevToken", var0.method_255()).toString();
   }

   public boolean equals(Object var1) {
      return method_5165(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_5167();
   }

   public int getCollection() {
      return this.adG;
   }

   public String getDisplayPlayerRank() {
      return this.adL;
   }

   public String getDisplayPlayerScore() {
      return this.adJ;
   }

   public long getNumScores() {
      return this.adN;
   }

   public long getPlayerRank() {
      return this.adK;
   }

   public String getPlayerScoreTag() {
      return this.adM;
   }

   public long getRawPlayerScore() {
      return this.adI;
   }

   public int getTimeSpan() {
      return this.adF;
   }

   public boolean hasPlayerInfo() {
      return this.adH;
   }

   public int hashCode() {
      return method_5164(this);
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: mK () java.lang.String
   public String method_254() {
      return this.adO;
   }

   // $FF: renamed from: mL () java.lang.String
   public String method_255() {
      return this.adP;
   }

   // $FF: renamed from: mM () java.lang.String
   public String method_256() {
      return this.adQ;
   }

   // $FF: renamed from: mN () com.google.android.gms.games.leaderboard.LeaderboardVariant
   public LeaderboardVariant method_5167() {
      return this;
   }

   public String toString() {
      return method_5166(this);
   }
}
