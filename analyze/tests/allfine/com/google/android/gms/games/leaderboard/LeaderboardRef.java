package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.games.leaderboard.LeaderboardVariantRef;
import java.util.ArrayList;

public final class LeaderboardRef extends class_255 implements Leaderboard {
    private final int aaK;
    private final Game abx;

    LeaderboardRef(DataHolder var1, int var2, int var3) {
        super(var1, var2);
        this.aaK = var3;
        this.abx = new GameRef(var1, var2);
    }

    public boolean equals(Object var1) {
        return LeaderboardEntity.method_3895(this, var1);
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_1675();
    }

    public String getDisplayName() {
        return this.getString("name");
    }

    public void getDisplayName(CharArrayBuffer var1) {
        this.a("name", var1);
    }

    public Game getGame() {
        return this.abx;
    }

    public Uri getIconImageUri() {
        return this.aR("board_icon_image_uri");
    }

    public String getIconImageUrl() {
        return this.getString("board_icon_image_url");
    }

    public String getLeaderboardId() {
        return this.getString("external_leaderboard_id");
    }

    public int getScoreOrder() {
        return this.getInteger("score_order");
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        ArrayList var1 = new ArrayList(this.aaK);

        for(int var2 = 0; var2 < this.aaK; ++var2) {
            var1.add(new LeaderboardVariantRef(this.II, var2 + this.JX));
        }

        return var1;
    }

    public int hashCode() {
        return LeaderboardEntity.method_3894(this);
    }

    // $FF: renamed from: lz () com.google.android.gms.games.leaderboard.Leaderboard
    public Leaderboard method_1675() {
        return new LeaderboardEntity(this);
    }

    public String toString() {
        return LeaderboardEntity.method_3896(this);
    }
}
