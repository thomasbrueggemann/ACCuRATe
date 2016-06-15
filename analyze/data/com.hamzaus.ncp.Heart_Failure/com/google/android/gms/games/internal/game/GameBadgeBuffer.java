package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeRef;

public final class GameBadgeBuffer extends DataBuffer<GameBadge> {
   // $FF: renamed from: cp (int) com.google.android.gms.games.internal.game.GameBadge
   public GameBadge method_2622(int var1) {
      return new GameBadgeRef(this.DD, var1);
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.method_2622(var1);
   }
}
