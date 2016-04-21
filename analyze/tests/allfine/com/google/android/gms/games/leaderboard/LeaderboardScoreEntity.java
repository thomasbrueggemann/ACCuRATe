package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.internal.class_345;

public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final String abA;
    private final String abB;
    private final long abC;
    private final long abD;
    private final String abE;
    private final Uri abF;
    private final Uri abG;
    private final PlayerEntity abH;
    private final String abI;
    private final String abJ;
    private final String abK;
    private final long abz;

    public LeaderboardScoreEntity(LeaderboardScore var1) {
        this.abz = var1.getRank();
        this.abA = (String)class_1090.method_5685(var1.getDisplayRank());
        this.abB = (String)class_1090.method_5685(var1.getDisplayScore());
        this.abC = var1.getRawScore();
        this.abD = var1.getTimestampMillis();
        this.abE = var1.getScoreHolderDisplayName();
        this.abF = var1.getScoreHolderIconImageUri();
        this.abG = var1.getScoreHolderHiResImageUri();
        Player var2 = var1.getScoreHolder();
        PlayerEntity var3;
        if(var2 == null) {
            var3 = null;
        } else {
            var3 = (PlayerEntity)var2.freeze();
        }

        this.abH = var3;
        this.abI = var1.getScoreTag();
        this.abJ = var1.getScoreHolderIconImageUrl();
        this.abK = var1.getScoreHolderHiResImageUrl();
    }

    // $FF: renamed from: a (com.google.android.gms.games.leaderboard.LeaderboardScore) int
    static int method_5428(LeaderboardScore var0) {
        Object[] var1 = new Object[] {Long.valueOf(var0.getRank()), var0.getDisplayRank(), Long.valueOf(var0.getRawScore()), var0.getDisplayScore(), Long.valueOf(var0.getTimestampMillis()), var0.getScoreHolderDisplayName(), var0.getScoreHolderIconImageUri(), var0.getScoreHolderHiResImageUri(), var0.getScoreHolder()};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.leaderboard.LeaderboardScore, java.lang.Object) boolean
    static boolean method_5429(LeaderboardScore var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof LeaderboardScore)) {
            var2 = false;
        } else if(var0 != var1) {
            LeaderboardScore var3 = (LeaderboardScore)var1;
            if(!class_1089.equal(Long.valueOf(var3.getRank()), Long.valueOf(var0.getRank())) || !class_1089.equal(var3.getDisplayRank(), var0.getDisplayRank()) || !class_1089.equal(Long.valueOf(var3.getRawScore()), Long.valueOf(var0.getRawScore())) || !class_1089.equal(var3.getDisplayScore(), var0.getDisplayScore()) || !class_1089.equal(Long.valueOf(var3.getTimestampMillis()), Long.valueOf(var0.getTimestampMillis())) || !class_1089.equal(var3.getScoreHolderDisplayName(), var0.getScoreHolderDisplayName()) || !class_1089.equal(var3.getScoreHolderIconImageUri(), var0.getScoreHolderIconImageUri()) || !class_1089.equal(var3.getScoreHolderHiResImageUri(), var0.getScoreHolderHiResImageUri()) || !class_1089.equal(var3.getScoreHolder(), var0.getScoreHolder()) || !class_1089.equal(var3.getScoreTag(), var0.getScoreTag())) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.leaderboard.LeaderboardScore) java.lang.String
    static String method_5430(LeaderboardScore var0) {
        class_1089.class_1785 var1 = class_1089.method_5673(var0).method_5425("Rank", Long.valueOf(var0.getRank())).method_5425("DisplayRank", var0.getDisplayRank()).method_5425("Score", Long.valueOf(var0.getRawScore())).method_5425("DisplayScore", var0.getDisplayScore()).method_5425("Timestamp", Long.valueOf(var0.getTimestampMillis())).method_5425("DisplayName", var0.getScoreHolderDisplayName()).method_5425("IconImageUri", var0.getScoreHolderIconImageUri()).method_5425("IconImageUrl", var0.getScoreHolderIconImageUrl()).method_5425("HiResImageUri", var0.getScoreHolderHiResImageUri()).method_5425("HiResImageUrl", var0.getScoreHolderHiResImageUrl());
        Player var2;
        if(var0.getScoreHolder() == null) {
            var2 = null;
        } else {
            var2 = var0.getScoreHolder();
        }

        return var1.method_5425("Player", var2).method_5425("ScoreTag", var0.getScoreTag()).toString();
    }

    public boolean equals(Object var1) {
        return method_5429(this, var1);
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_5431();
    }

    public String getDisplayRank() {
        return this.abA;
    }

    public void getDisplayRank(CharArrayBuffer var1) {
        class_345.method_2325(this.abA, var1);
    }

    public String getDisplayScore() {
        return this.abB;
    }

    public void getDisplayScore(CharArrayBuffer var1) {
        class_345.method_2325(this.abB, var1);
    }

    public long getRank() {
        return this.abz;
    }

    public long getRawScore() {
        return this.abC;
    }

    public Player getScoreHolder() {
        return this.abH;
    }

    public String getScoreHolderDisplayName() {
        return this.abH == null?this.abE:this.abH.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer var1) {
        if(this.abH == null) {
            class_345.method_2325(this.abE, var1);
        } else {
            this.abH.getDisplayName(var1);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.abH == null?this.abG:this.abH.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return this.abH == null?this.abK:this.abH.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.abH == null?this.abF:this.abH.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return this.abH == null?this.abJ:this.abH.getIconImageUrl();
    }

    public String getScoreTag() {
        return this.abI;
    }

    public long getTimestampMillis() {
        return this.abD;
    }

    public int hashCode() {
        return method_5428(this);
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: lC () com.google.android.gms.games.leaderboard.LeaderboardScore
    public LeaderboardScore method_5431() {
        return this;
    }

    public String toString() {
        return method_5430(this);
    }
}
