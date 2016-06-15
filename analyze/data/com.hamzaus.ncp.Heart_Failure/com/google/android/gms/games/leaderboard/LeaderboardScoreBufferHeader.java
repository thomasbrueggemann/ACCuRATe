package com.google.android.gms.games.leaderboard;

import android.os.Bundle;

public final class LeaderboardScoreBufferHeader {
   // $FF: renamed from: HJ android.os.Bundle
   private final Bundle field_3476;

   public LeaderboardScoreBufferHeader(Bundle var1) {
      if(var1 == null) {
         var1 = new Bundle();
      }

      this.field_3476 = var1;
   }

   // $FF: renamed from: iw () android.os.Bundle
   public Bundle method_3806() {
      return this.field_3476;
   }

   public static final class Builder {
   }
}
