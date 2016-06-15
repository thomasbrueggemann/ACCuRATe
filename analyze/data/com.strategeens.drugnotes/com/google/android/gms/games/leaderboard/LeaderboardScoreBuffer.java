package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader;
import com.google.android.gms.games.leaderboard.LeaderboardScoreRef;

public final class LeaderboardScoreBuffer extends DataBuffer<LeaderboardScore> {
   private final LeaderboardScoreBufferHeader adr;

   public LeaderboardScoreBuffer(DataHolder var1) {
      super(var1);
      this.adr = new LeaderboardScoreBufferHeader(var1.method_5837());
   }

   public LeaderboardScore get(int var1) {
      return new LeaderboardScoreRef(this.JG, var1);
   }

   // $FF: renamed from: mH () com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader
   public LeaderboardScoreBufferHeader method_2976() {
      return this.adr;
   }
}
