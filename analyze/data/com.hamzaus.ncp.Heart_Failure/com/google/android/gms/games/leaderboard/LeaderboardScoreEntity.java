package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.internal.class_284;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_349;

public final class LeaderboardScoreEntity implements LeaderboardScore {
   // $FF: renamed from: SA java.lang.String
   private final String field_3904;
   // $FF: renamed from: SB java.lang.String
   private final String field_3905;
   // $FF: renamed from: SC java.lang.String
   private final String field_3906;
   // $FF: renamed from: Sr long
   private final long field_3907;
   // $FF: renamed from: Ss java.lang.String
   private final String field_3908;
   // $FF: renamed from: St java.lang.String
   private final String field_3909;
   // $FF: renamed from: Su long
   private final long field_3910;
   // $FF: renamed from: Sv long
   private final long field_3911;
   // $FF: renamed from: Sw java.lang.String
   private final String field_3912;
   // $FF: renamed from: Sx android.net.Uri
   private final Uri field_3913;
   // $FF: renamed from: Sy android.net.Uri
   private final Uri field_3914;
   // $FF: renamed from: Sz com.google.android.gms.games.PlayerEntity
   private final PlayerEntity field_3915;

   public LeaderboardScoreEntity(LeaderboardScore var1) {
      this.field_3907 = var1.getRank();
      this.field_3908 = (String)class_347.method_2170(var1.getDisplayRank());
      this.field_3909 = (String)class_347.method_2170(var1.getDisplayScore());
      this.field_3910 = var1.getRawScore();
      this.field_3911 = var1.getTimestampMillis();
      this.field_3912 = var1.getScoreHolderDisplayName();
      this.field_3913 = var1.getScoreHolderIconImageUri();
      this.field_3914 = var1.getScoreHolderHiResImageUri();
      Player var2 = var1.getScoreHolder();
      PlayerEntity var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = (PlayerEntity)var2.freeze();
      }

      this.field_3915 = var3;
      this.field_3904 = var1.getScoreTag();
      this.field_3905 = var1.getScoreHolderIconImageUrl();
      this.field_3906 = var1.getScoreHolderHiResImageUrl();
   }

   // $FF: renamed from: a (com.google.android.gms.games.leaderboard.LeaderboardScore) int
   static int method_4168(LeaderboardScore var0) {
      Object[] var1 = new Object[]{Long.valueOf(var0.getRank()), var0.getDisplayRank(), Long.valueOf(var0.getRawScore()), var0.getDisplayScore(), Long.valueOf(var0.getTimestampMillis()), var0.getScoreHolderDisplayName(), var0.getScoreHolderIconImageUri(), var0.getScoreHolderHiResImageUri(), var0.getScoreHolder()};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.leaderboard.LeaderboardScore, java.lang.Object) boolean
   static boolean method_4169(LeaderboardScore var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof LeaderboardScore)) {
         var2 = false;
      } else if(var0 != var1) {
         LeaderboardScore var3 = (LeaderboardScore)var1;
         if(!class_349.equal(Long.valueOf(var3.getRank()), Long.valueOf(var0.getRank())) || !class_349.equal(var3.getDisplayRank(), var0.getDisplayRank()) || !class_349.equal(Long.valueOf(var3.getRawScore()), Long.valueOf(var0.getRawScore())) || !class_349.equal(var3.getDisplayScore(), var0.getDisplayScore()) || !class_349.equal(Long.valueOf(var3.getTimestampMillis()), Long.valueOf(var0.getTimestampMillis())) || !class_349.equal(var3.getScoreHolderDisplayName(), var0.getScoreHolderDisplayName()) || !class_349.equal(var3.getScoreHolderIconImageUri(), var0.getScoreHolderIconImageUri()) || !class_349.equal(var3.getScoreHolderHiResImageUri(), var0.getScoreHolderHiResImageUri()) || !class_349.equal(var3.getScoreHolder(), var0.getScoreHolder()) || !class_349.equal(var3.getScoreTag(), var0.getScoreTag())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.leaderboard.LeaderboardScore) java.lang.String
   static String method_4170(LeaderboardScore var0) {
      class_349.class_1264 var1 = class_349.method_2174(var0).method_4301("Rank", Long.valueOf(var0.getRank())).method_4301("DisplayRank", var0.getDisplayRank()).method_4301("Score", Long.valueOf(var0.getRawScore())).method_4301("DisplayScore", var0.getDisplayScore()).method_4301("Timestamp", Long.valueOf(var0.getTimestampMillis())).method_4301("DisplayName", var0.getScoreHolderDisplayName()).method_4301("IconImageUri", var0.getScoreHolderIconImageUri()).method_4301("IconImageUrl", var0.getScoreHolderIconImageUrl()).method_4301("HiResImageUri", var0.getScoreHolderHiResImageUri()).method_4301("HiResImageUrl", var0.getScoreHolderHiResImageUrl());
      Player var2;
      if(var0.getScoreHolder() == null) {
         var2 = null;
      } else {
         var2 = var0.getScoreHolder();
      }

      return var1.method_4301("Player", var2).method_4301("ScoreTag", var0.getScoreTag()).toString();
   }

   public boolean equals(Object var1) {
      return method_4169(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_4171();
   }

   public String getDisplayRank() {
      return this.field_3908;
   }

   public void getDisplayRank(CharArrayBuffer var1) {
      class_284.method_1876(this.field_3908, var1);
   }

   public String getDisplayScore() {
      return this.field_3909;
   }

   public void getDisplayScore(CharArrayBuffer var1) {
      class_284.method_1876(this.field_3909, var1);
   }

   public long getRank() {
      return this.field_3907;
   }

   public long getRawScore() {
      return this.field_3910;
   }

   public Player getScoreHolder() {
      return this.field_3915;
   }

   public String getScoreHolderDisplayName() {
      return this.field_3915 == null?this.field_3912:this.field_3915.getDisplayName();
   }

   public void getScoreHolderDisplayName(CharArrayBuffer var1) {
      if(this.field_3915 == null) {
         class_284.method_1876(this.field_3912, var1);
      } else {
         this.field_3915.getDisplayName(var1);
      }
   }

   public Uri getScoreHolderHiResImageUri() {
      return this.field_3915 == null?this.field_3914:this.field_3915.getHiResImageUri();
   }

   public String getScoreHolderHiResImageUrl() {
      return this.field_3915 == null?this.field_3906:this.field_3915.getHiResImageUrl();
   }

   public Uri getScoreHolderIconImageUri() {
      return this.field_3915 == null?this.field_3913:this.field_3915.getIconImageUri();
   }

   public String getScoreHolderIconImageUrl() {
      return this.field_3915 == null?this.field_3905:this.field_3915.getIconImageUrl();
   }

   public String getScoreTag() {
      return this.field_3904;
   }

   public long getTimestampMillis() {
      return this.field_3911;
   }

   public int hashCode() {
      return method_4168(this);
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: ix () com.google.android.gms.games.leaderboard.LeaderboardScore
   public LeaderboardScore method_4171() {
      return this;
   }

   public String toString() {
      return method_4170(this);
   }
}
