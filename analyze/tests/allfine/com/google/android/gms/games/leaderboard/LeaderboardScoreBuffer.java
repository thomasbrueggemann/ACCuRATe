package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader;
import com.google.android.gms.games.leaderboard.LeaderboardScoreRef;

public final class LeaderboardScoreBuffer extends DataBuffer<LeaderboardScore> {
    private final LeaderboardScoreBufferHeader aby;

    public LeaderboardScoreBuffer(DataHolder var1) {
        super(var1);
        this.aby = new LeaderboardScoreBufferHeader(var1.method_5998());
    }

    public LeaderboardScore get(int var1) {
        return new LeaderboardScoreRef(this.II, var1);
    }

    // $FF: renamed from: lA () com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader
    public LeaderboardScoreBufferHeader method_2893() {
        return this.aby;
    }
}
