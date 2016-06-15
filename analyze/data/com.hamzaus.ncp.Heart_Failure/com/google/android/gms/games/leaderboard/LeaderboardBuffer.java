package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardRef;

public final class LeaderboardBuffer extends g<Leaderboard> {
   public LeaderboardBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: renamed from: c (int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_2626(int var1, int var2) {
      return this.method_2637(var1, var2);
   }

   // $FF: renamed from: eU () java.lang.String
   protected String method_2627() {
      return "external_leaderboard_id";
   }

   // $FF: renamed from: f (int, int) com.google.android.gms.games.leaderboard.Leaderboard
   protected Leaderboard method_2637(int var1, int var2) {
      return new LeaderboardRef(this.DD, var1, var2);
   }
}
