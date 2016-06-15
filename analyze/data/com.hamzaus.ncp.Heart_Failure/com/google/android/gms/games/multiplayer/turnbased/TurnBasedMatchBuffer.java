package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchRef;

public final class TurnBasedMatchBuffer extends g<TurnBasedMatch> {
   public TurnBasedMatchBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: renamed from: c (int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_2626(int var1, int var2) {
      return this.method_2634(var1, var2);
   }

   // $FF: renamed from: eU () java.lang.String
   protected String method_2627() {
      return "external_match_id";
   }

   // $FF: renamed from: i (int, int) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
   protected TurnBasedMatch method_2634(int var1, int var2) {
      return new TurnBasedMatchRef(this.DD, var1, var2);
   }
}
