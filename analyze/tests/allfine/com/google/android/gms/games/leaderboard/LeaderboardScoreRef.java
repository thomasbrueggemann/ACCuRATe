package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;

public final class LeaderboardScoreRef extends class_255 implements LeaderboardScore {
    private final PlayerRef abL;

    LeaderboardScoreRef(DataHolder var1, int var2) {
        super(var1, var2);
        this.abL = new PlayerRef(var1, var2);
    }

    public boolean equals(Object var1) {
        return LeaderboardScoreEntity.method_5429(this, var1);
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_1652();
    }

    public String getDisplayRank() {
        return this.getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer var1) {
        this.a("display_rank", var1);
    }

    public String getDisplayScore() {
        return this.getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer var1) {
        this.a("display_score", var1);
    }

    public long getRank() {
        return this.getLong("rank");
    }

    public long getRawScore() {
        return this.getLong("raw_score");
    }

    public Player getScoreHolder() {
        return this.aS("external_player_id")?null:this.abL;
    }

    public String getScoreHolderDisplayName() {
        return this.aS("external_player_id")?this.getString("default_display_name"):this.abL.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer var1) {
        if(this.aS("external_player_id")) {
            this.a("default_display_name", var1);
        } else {
            this.abL.getDisplayName(var1);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.aS("external_player_id")?null:this.abL.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return this.aS("external_player_id")?null:this.abL.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.aS("external_player_id")?this.aR("default_display_image_uri"):this.abL.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return this.aS("external_player_id")?this.getString("default_display_image_url"):this.abL.getIconImageUrl();
    }

    public String getScoreTag() {
        return this.getString("score_tag");
    }

    public long getTimestampMillis() {
        return this.getLong("achieved_timestamp");
    }

    public int hashCode() {
        return LeaderboardScoreEntity.method_5428(this);
    }

    // $FF: renamed from: lC () com.google.android.gms.games.leaderboard.LeaderboardScore
    public LeaderboardScore method_1652() {
        return new LeaderboardScoreEntity(this);
    }

    public String toString() {
        return LeaderboardScoreEntity.method_5430(this);
    }
}
