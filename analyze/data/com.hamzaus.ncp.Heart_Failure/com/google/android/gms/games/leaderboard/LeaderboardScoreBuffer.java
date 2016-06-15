package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader;
import com.google.android.gms.games.leaderboard.LeaderboardScoreRef;

public final class LeaderboardScoreBuffer extends DataBuffer<LeaderboardScore> {
   // $FF: renamed from: Sq com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader
   private final LeaderboardScoreBufferHeader field_1920;

   public LeaderboardScoreBuffer(DataHolder var1) {
      super(var1);
      this.field_1920 = new LeaderboardScoreBufferHeader(var1.method_4563());
   }

   public LeaderboardScore get(int var1) {
      return new LeaderboardScoreRef(this.DD, var1);
   }

   // $FF: renamed from: iv () com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader
   public LeaderboardScoreBufferHeader method_2616() {
      return this.field_1920;
   }
}
