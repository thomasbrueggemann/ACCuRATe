package com.google.android.gms.games.leaderboard;

import android.os.Bundle;

public final class LeaderboardScoreBufferHeader {
   // $FF: renamed from: DJ android.os.Bundle
   private final Bundle field_3598;

   public LeaderboardScoreBufferHeader(Bundle var1) {
      if(var1 == null) {
         var1 = new Bundle();
      }

      this.field_3598 = var1;
   }

   // $FF: renamed from: mI () android.os.Bundle
   public Bundle method_4764() {
      return this.field_3598;
   }

   public static final class Builder {
   }
}
