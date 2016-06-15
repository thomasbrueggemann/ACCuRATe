package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.game.GameSearchSuggestion;
import com.google.android.gms.games.internal.game.GameSearchSuggestionRef;

public final class GameSearchSuggestionBuffer extends DataBuffer<GameSearchSuggestion> {
   public GameSearchSuggestionBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: renamed from: ef (int) com.google.android.gms.games.internal.game.GameSearchSuggestion
   public GameSearchSuggestion method_2983(int var1) {
      return new GameSearchSuggestionRef(this.JG, var1);
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.method_2983(var1);
   }
}
