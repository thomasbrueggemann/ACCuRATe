package com.google.android.gms.games;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;

public final class GameBuffer extends DataBuffer<Game> {
   public GameBuffer(DataHolder var1) {
      super(var1);
   }

   public Game get(int var1) {
      return new GameRef(this.DD, var1);
   }
}
