package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.games.leaderboard.LeaderboardVariantEntity;
import com.google.android.gms.internal.class_345;
import java.util.ArrayList;

public final class LeaderboardEntity implements Leaderboard {
    // $FF: renamed from: NH java.lang.String
    private final String field_3441;
    // $FF: renamed from: Vh android.net.Uri
    private final Uri field_3442;
    // $FF: renamed from: Vs java.lang.String
    private final String field_3443;
    private final String abu;
    private final int abv;
    private final ArrayList<LeaderboardVariantEntity> abw;
    private final Game abx;

    public LeaderboardEntity(Leaderboard var1) {
        this.abu = var1.getLeaderboardId();
        this.field_3441 = var1.getDisplayName();
        this.field_3442 = var1.getIconImageUri();
        this.field_3443 = var1.getIconImageUrl();
        this.abv = var1.getScoreOrder();
        Game var2 = var1.getGame();
        GameEntity var3;
        if(var2 == null) {
            var3 = null;
        } else {
            var3 = new GameEntity(var2);
        }

        this.abx = var3;
        ArrayList var4 = var1.getVariants();
        int var5 = var4.size();
        this.abw = new ArrayList(var5);

        for(int var6 = 0; var6 < var5; ++var6) {
            this.abw.add((LeaderboardVariantEntity)((LeaderboardVariantEntity)((LeaderboardVariant)var4.get(var6)).freeze()));
        }

    }

    // $FF: renamed from: a (com.google.android.gms.games.leaderboard.Leaderboard) int
    static int method_3894(Leaderboard var0) {
        Object[] var1 = new Object[] {var0.getLeaderboardId(), var0.getDisplayName(), var0.getIconImageUri(), Integer.valueOf(var0.getScoreOrder()), var0.getVariants()};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.leaderboard.Leaderboard, java.lang.Object) boolean
    static boolean method_3895(Leaderboard var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof Leaderboard)) {
            var2 = false;
        } else if(var0 != var1) {
            Leaderboard var3 = (Leaderboard)var1;
            if(!class_1089.equal(var3.getLeaderboardId(), var0.getLeaderboardId()) || !class_1089.equal(var3.getDisplayName(), var0.getDisplayName()) || !class_1089.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_1089.equal(Integer.valueOf(var3.getScoreOrder()), Integer.valueOf(var0.getScoreOrder())) || !class_1089.equal(var3.getVariants(), var0.getVariants())) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.leaderboard.Leaderboard) java.lang.String
    static String method_3896(Leaderboard var0) {
        return class_1089.method_5673(var0).method_5425("LeaderboardId", var0.getLeaderboardId()).method_5425("DisplayName", var0.getDisplayName()).method_5425("IconImageUri", var0.getIconImageUri()).method_5425("IconImageUrl", var0.getIconImageUrl()).method_5425("ScoreOrder", Integer.valueOf(var0.getScoreOrder())).method_5425("Variants", var0.getVariants()).toString();
    }

    public boolean equals(Object var1) {
        return method_3895(this, var1);
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_3897();
    }

    public String getDisplayName() {
        return this.field_3441;
    }

    public void getDisplayName(CharArrayBuffer var1) {
        class_345.method_2325(this.field_3441, var1);
    }

    public Game getGame() {
        return this.abx;
    }

    public Uri getIconImageUri() {
        return this.field_3442;
    }

    public String getIconImageUrl() {
        return this.field_3443;
    }

    public String getLeaderboardId() {
        return this.abu;
    }

    public int getScoreOrder() {
        return this.abv;
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList(this.abw);
    }

    public int hashCode() {
        return method_3894(this);
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: lz () com.google.android.gms.games.leaderboard.Leaderboard
    public Leaderboard method_3897() {
        return this;
    }

    public String toString() {
        return method_3896(this);
    }
}
