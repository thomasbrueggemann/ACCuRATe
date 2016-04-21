package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestRef;

public final class GameRequestBuffer extends g<GameRequest> {
    public GameRequestBuffer(DataHolder var1) {
        super(var1);
    }

    // $FF: renamed from: f (int, int) java.lang.Object
    // $FF: synthetic method
    protected Object method_2903(int var1, int var2) {
        return this.method_2907(var1, var2);
    }

    // $FF: renamed from: gD () java.lang.String
    protected String method_2904() {
        return "external_request_id";
    }

    // $FF: renamed from: n (int, int) com.google.android.gms.games.request.GameRequest
    protected GameRequest method_2907(int var1, int var2) {
        return new GameRequestRef(this.II, var1, var2);
    }
}
