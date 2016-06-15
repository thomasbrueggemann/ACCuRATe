package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.internal.game.ExtendedGame;
import com.google.android.gms.games.internal.game.ExtendedGameRef;

public final class ExtendedGameBuffer extends g<ExtendedGame> {
   public ExtendedGameBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: renamed from: c (int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_2626(int var1, int var2) {
      return this.method_2629(var1, var2);
   }

   // $FF: renamed from: e (int, int) com.google.android.gms.games.internal.game.ExtendedGame
   protected ExtendedGame method_2629(int var1, int var2) {
      return new ExtendedGameRef(this.DD, var1, var2);
   }

   // $FF: renamed from: eU () java.lang.String
   protected String method_2627() {
      return "external_game_id";
   }
}
