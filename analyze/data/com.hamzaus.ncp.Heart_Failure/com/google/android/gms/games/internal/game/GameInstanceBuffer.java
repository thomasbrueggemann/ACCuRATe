package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.game.GameInstance;
import com.google.android.gms.games.internal.game.GameInstanceRef;

public final class GameInstanceBuffer extends DataBuffer<GameInstance> {
   public GameInstanceBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: renamed from: cr (int) com.google.android.gms.games.internal.game.GameInstance
   public GameInstance method_2618(int var1) {
      return new GameInstanceRef(this.DD, var1);
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.method_2618(var1);
   }
}
