package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class PlayerBuffer extends DataBuffer<Player> {
   public PlayerBuffer(DataHolder var1) {
      super(var1);
   }

   public Player get(int var1) {
      return new PlayerRef(this.JG, var1);
   }
}
