package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;

public abstract class RoomConfig {
   public static Bundle createAutoMatchCriteria(int var0, int var1, long var2) {
      Bundle var4 = new Bundle();
      var4.putInt("min_automatch_players", var0);
      var4.putInt("max_automatch_players", var1);
      var4.putLong("exclusive_bit_mask", var2);
      return var4;
   }
}
