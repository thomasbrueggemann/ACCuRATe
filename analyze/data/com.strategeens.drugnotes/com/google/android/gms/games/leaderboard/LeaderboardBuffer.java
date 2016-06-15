package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardRef;

public final class LeaderboardBuffer extends g<Leaderboard> {
   public LeaderboardBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: renamed from: f (int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_2987(int var1, int var2) {
      return this.method_2999(var1, var2);
   }

   // $FF: renamed from: ha () java.lang.String
   protected String method_2988() {
      return "external_leaderboard_id";
   }

   // $FF: renamed from: j (int, int) com.google.android.gms.games.leaderboard.Leaderboard
   protected Leaderboard method_2999(int var1, int var2) {
      return new LeaderboardRef(this.JG, var1, var2);
   }
}
