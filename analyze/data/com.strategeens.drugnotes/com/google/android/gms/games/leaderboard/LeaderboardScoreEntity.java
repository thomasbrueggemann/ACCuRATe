package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_719;

public final class LeaderboardScoreEntity implements LeaderboardScore {
   private final PlayerEntity adA;
   private final String adB;
   private final String adC;
   private final String adD;
   private final long ads;
   private final String adt;
   private final String adu;
   private final long adv;
   private final long adw;
   private final String adx;
   private final Uri ady;
   private final Uri adz;

   public LeaderboardScoreEntity(LeaderboardScore var1) {
      this.ads = var1.getRank();
      this.adt = (String)class_335.method_2311(var1.getDisplayRank());
      this.adu = (String)class_335.method_2311(var1.getDisplayScore());
      this.adv = var1.getRawScore();
      this.adw = var1.getTimestampMillis();
      this.adx = var1.getScoreHolderDisplayName();
      this.ady = var1.getScoreHolderIconImageUri();
      this.adz = var1.getScoreHolderHiResImageUri();
      Player var2 = var1.getScoreHolder();
      PlayerEntity var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = (PlayerEntity)var2.freeze();
      }

      this.adA = var3;
      this.adB = var1.getScoreTag();
      this.adC = var1.getScoreHolderIconImageUrl();
      this.adD = var1.getScoreHolderHiResImageUrl();
   }

   // $FF: renamed from: a (com.google.android.gms.games.leaderboard.LeaderboardScore) int
   static int method_5285(LeaderboardScore var0) {
      Object[] var1 = new Object[]{Long.valueOf(var0.getRank()), var0.getDisplayRank(), Long.valueOf(var0.getRawScore()), var0.getDisplayScore(), Long.valueOf(var0.getTimestampMillis()), var0.getScoreHolderDisplayName(), var0.getScoreHolderIconImageUri(), var0.getScoreHolderHiResImageUri(), var0.getScoreHolder()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.leaderboard.LeaderboardScore, java.lang.Object) boolean
   static boolean method_5286(LeaderboardScore var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof LeaderboardScore)) {
         var2 = false;
      } else if(var0 != var1) {
         LeaderboardScore var3 = (LeaderboardScore)var1;
         if(!class_336.equal(Long.valueOf(var3.getRank()), Long.valueOf(var0.getRank())) || !class_336.equal(var3.getDisplayRank(), var0.getDisplayRank()) || !class_336.equal(Long.valueOf(var3.getRawScore()), Long.valueOf(var0.getRawScore())) || !class_336.equal(var3.getDisplayScore(), var0.getDisplayScore()) || !class_336.equal(Long.valueOf(var3.getTimestampMillis()), Long.valueOf(var0.getTimestampMillis())) || !class_336.equal(var3.getScoreHolderDisplayName(), var0.getScoreHolderDisplayName()) || !class_336.equal(var3.getScoreHolderIconImageUri(), var0.getScoreHolderIconImageUri()) || !class_336.equal(var3.getScoreHolderHiResImageUri(), var0.getScoreHolderHiResImageUri()) || !class_336.equal(var3.getScoreHolder(), var0.getScoreHolder()) || !class_336.equal(var3.getScoreTag(), var0.getScoreTag())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.leaderboard.LeaderboardScore) java.lang.String
   static String method_5287(LeaderboardScore var0) {
      class_336.class_1339 var1 = class_336.method_2312(var0).method_3424("Rank", Long.valueOf(var0.getRank())).method_3424("DisplayRank", var0.getDisplayRank()).method_3424("Score", Long.valueOf(var0.getRawScore())).method_3424("DisplayScore", var0.getDisplayScore()).method_3424("Timestamp", Long.valueOf(var0.getTimestampMillis())).method_3424("DisplayName", var0.getScoreHolderDisplayName()).method_3424("IconImageUri", var0.getScoreHolderIconImageUri()).method_3424("IconImageUrl", var0.getScoreHolderIconImageUrl()).method_3424("HiResImageUri", var0.getScoreHolderHiResImageUri()).method_3424("HiResImageUrl", var0.getScoreHolderHiResImageUrl());
      Player var2;
      if(var0.getScoreHolder() == null) {
         var2 = null;
      } else {
         var2 = var0.getScoreHolder();
      }

      return var1.method_3424("Player", var2).method_3424("ScoreTag", var0.getScoreTag()).toString();
   }

   public boolean equals(Object var1) {
      return method_5286(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_5288();
   }

   public String getDisplayRank() {
      return this.adt;
   }

   public void getDisplayRank(CharArrayBuffer var1) {
      class_719.method_4197(this.adt, var1);
   }

   public String getDisplayScore() {
      return this.adu;
   }

   public void getDisplayScore(CharArrayBuffer var1) {
      class_719.method_4197(this.adu, var1);
   }

   public long getRank() {
      return this.ads;
   }

   public long getRawScore() {
      return this.adv;
   }

   public Player getScoreHolder() {
      return this.adA;
   }

   public String getScoreHolderDisplayName() {
      return this.adA == null?this.adx:this.adA.getDisplayName();
   }

   public void getScoreHolderDisplayName(CharArrayBuffer var1) {
      if(this.adA == null) {
         class_719.method_4197(this.adx, var1);
      } else {
         this.adA.getDisplayName(var1);
      }
   }

   public Uri getScoreHolderHiResImageUri() {
      return this.adA == null?this.adz:this.adA.getHiResImageUri();
   }

   public String getScoreHolderHiResImageUrl() {
      return this.adA == null?this.adD:this.adA.getHiResImageUrl();
   }

   public Uri getScoreHolderIconImageUri() {
      return this.adA == null?this.ady:this.adA.getIconImageUri();
   }

   public String getScoreHolderIconImageUrl() {
      return this.adA == null?this.adC:this.adA.getIconImageUrl();
   }

   public String getScoreTag() {
      return this.adB;
   }

   public long getTimestampMillis() {
      return this.adw;
   }

   public int hashCode() {
      return method_5285(this);
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: mJ () com.google.android.gms.games.leaderboard.LeaderboardScore
   public LeaderboardScore method_5288() {
      return this;
   }

   public String toString() {
      return method_5287(this);
   }
}
