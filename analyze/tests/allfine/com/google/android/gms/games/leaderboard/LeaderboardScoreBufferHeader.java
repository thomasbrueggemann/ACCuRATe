package com.google.android.gms.games.leaderboard;

import android.os.Bundle;

public final class LeaderboardScoreBufferHeader {
    // $FF: renamed from: Nh android.os.Bundle
    private final Bundle field_4356;

    public LeaderboardScoreBufferHeader(Bundle var1) {
        if(var1 == null) {
            var1 = new Bundle();
        }

        this.field_4356 = var1;
    }

    // $FF: renamed from: lB () android.os.Bundle
    public Bundle method_4925() {
        return this.field_4356;
    }

    public static final class Builder {
    }
}
