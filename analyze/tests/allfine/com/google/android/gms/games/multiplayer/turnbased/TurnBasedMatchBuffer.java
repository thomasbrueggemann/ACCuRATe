package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchRef;

public final class TurnBasedMatchBuffer extends g<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder var1) {
        super(var1);
    }

    // $FF: renamed from: f (int, int) java.lang.Object
    // $FF: synthetic method
    protected Object method_2903(int var1, int var2) {
        return this.method_2911(var1, var2);
    }

    // $FF: renamed from: gD () java.lang.String
    protected String method_2904() {
        return "external_match_id";
    }

    // $FF: renamed from: l (int, int) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
    protected TurnBasedMatch method_2911(int var1, int var2) {
        return new TurnBasedMatchRef(this.II, var1, var2);
    }
}
