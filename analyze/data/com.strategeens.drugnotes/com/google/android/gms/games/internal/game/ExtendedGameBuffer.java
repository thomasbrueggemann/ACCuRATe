package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.internal.game.ExtendedGame;
import com.google.android.gms.games.internal.game.ExtendedGameRef;

public final class ExtendedGameBuffer extends g<ExtendedGame> {
   public ExtendedGameBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: renamed from: f (int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_2987(int var1, int var2) {
      return this.method_2990(var1, var2);
   }

   // $FF: renamed from: ha () java.lang.String
   protected String method_2988() {
      return "external_game_id";
   }

   // $FF: renamed from: i (int, int) com.google.android.gms.games.internal.game.ExtendedGame
   protected ExtendedGame method_2990(int var1, int var2) {
      return new ExtendedGameRef(this.JG, var1, var2);
   }
}
