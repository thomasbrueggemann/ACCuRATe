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
    protected Object method_2903(int var1, int var2) {
        return this.method_2906(var1, var2);
    }

    // $FF: renamed from: gD () java.lang.String
    protected String method_2904() {
        return "external_game_id";
    }

    // $FF: renamed from: h (int, int) com.google.android.gms.games.internal.game.ExtendedGame
    protected ExtendedGame method_2906(int var1, int var2) {
        return new ExtendedGameRef(this.II, var1, var2);
    }
}
