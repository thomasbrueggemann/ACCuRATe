package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int abM;
    private final int abN;
    private final boolean abO;
    private final long abP;
    private final String abQ;
    private final long abR;
    private final String abS;
    private final String abT;
    private final long abU;
    private final String abV;
    private final String abW;
    private final String abX;

    public LeaderboardVariantEntity(LeaderboardVariant var1) {
        this.abM = var1.getTimeSpan();
        this.abN = var1.getCollection();
        this.abO = var1.hasPlayerInfo();
        this.abP = var1.getRawPlayerScore();
        this.abQ = var1.getDisplayPlayerScore();
        this.abR = var1.getPlayerRank();
        this.abS = var1.getDisplayPlayerRank();
        this.abT = var1.getPlayerScoreTag();
        this.abU = var1.getNumScores();
        this.abV = var1.method_204();
        this.abW = var1.method_205();
        this.abX = var1.method_206();
    }

    // $FF: renamed from: a (com.google.android.gms.games.leaderboard.LeaderboardVariant) int
    static int method_5307(LeaderboardVariant var0) {
        Object[] var1 = new Object[] {Integer.valueOf(var0.getTimeSpan()), Integer.valueOf(var0.getCollection()), Boolean.valueOf(var0.hasPlayerInfo()), Long.valueOf(var0.getRawPlayerScore()), var0.getDisplayPlayerScore(), Long.valueOf(var0.getPlayerRank()), var0.getDisplayPlayerRank(), Long.valueOf(var0.getNumScores()), var0.method_204(), var0.method_206(), var0.method_205()};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.leaderboard.LeaderboardVariant, java.lang.Object) boolean
    static boolean method_5308(LeaderboardVariant var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof LeaderboardVariant)) {
            var2 = false;
        } else if(var0 != var1) {
            LeaderboardVariant var3 = (LeaderboardVariant)var1;
            if(!class_1089.equal(Integer.valueOf(var3.getTimeSpan()), Integer.valueOf(var0.getTimeSpan())) || !class_1089.equal(Integer.valueOf(var3.getCollection()), Integer.valueOf(var0.getCollection())) || !class_1089.equal(Boolean.valueOf(var3.hasPlayerInfo()), Boolean.valueOf(var0.hasPlayerInfo())) || !class_1089.equal(Long.valueOf(var3.getRawPlayerScore()), Long.valueOf(var0.getRawPlayerScore())) || !class_1089.equal(var3.getDisplayPlayerScore(), var0.getDisplayPlayerScore()) || !class_1089.equal(Long.valueOf(var3.getPlayerRank()), Long.valueOf(var0.getPlayerRank())) || !class_1089.equal(var3.getDisplayPlayerRank(), var0.getDisplayPlayerRank()) || !class_1089.equal(Long.valueOf(var3.getNumScores()), Long.valueOf(var0.getNumScores())) || !class_1089.equal(var3.method_204(), var0.method_204()) || !class_1089.equal(var3.method_206(), var0.method_206()) || !class_1089.equal(var3.method_205(), var0.method_205())) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.leaderboard.LeaderboardVariant) java.lang.String
    static String method_5309(LeaderboardVariant var0) {
        class_1089.class_1785 var1 = class_1089.method_5673(var0).method_5425("TimeSpan", TimeSpan.method_5842(var0.getTimeSpan())).method_5425("Collection", LeaderboardCollection.method_4199(var0.getCollection()));
        Object var2;
        if(var0.hasPlayerInfo()) {
            var2 = Long.valueOf(var0.getRawPlayerScore());
        } else {
            var2 = "none";
        }

        class_1089.class_1785 var3 = var1.method_5425("RawPlayerScore", var2);
        String var4;
        if(var0.hasPlayerInfo()) {
            var4 = var0.getDisplayPlayerScore();
        } else {
            var4 = "none";
        }

        class_1089.class_1785 var5 = var3.method_5425("DisplayPlayerScore", var4);
        Object var6;
        if(var0.hasPlayerInfo()) {
            var6 = Long.valueOf(var0.getPlayerRank());
        } else {
            var6 = "none";
        }

        class_1089.class_1785 var7 = var5.method_5425("PlayerRank", var6);
        String var8;
        if(var0.hasPlayerInfo()) {
            var8 = var0.getDisplayPlayerRank();
        } else {
            var8 = "none";
        }

        return var7.method_5425("DisplayPlayerRank", var8).method_5425("NumScores", Long.valueOf(var0.getNumScores())).method_5425("TopPageNextToken", var0.method_204()).method_5425("WindowPageNextToken", var0.method_206()).method_5425("WindowPagePrevToken", var0.method_205()).toString();
    }

    public boolean equals(Object var1) {
        return method_5308(this, var1);
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_5310();
    }

    public int getCollection() {
        return this.abN;
    }

    public String getDisplayPlayerRank() {
        return this.abS;
    }

    public String getDisplayPlayerScore() {
        return this.abQ;
    }

    public long getNumScores() {
        return this.abU;
    }

    public long getPlayerRank() {
        return this.abR;
    }

    public String getPlayerScoreTag() {
        return this.abT;
    }

    public long getRawPlayerScore() {
        return this.abP;
    }

    public int getTimeSpan() {
        return this.abM;
    }

    public boolean hasPlayerInfo() {
        return this.abO;
    }

    public int hashCode() {
        return method_5307(this);
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: lD () java.lang.String
    public String method_204() {
        return this.abV;
    }

    // $FF: renamed from: lE () java.lang.String
    public String method_205() {
        return this.abW;
    }

    // $FF: renamed from: lF () java.lang.String
    public String method_206() {
        return this.abX;
    }

    // $FF: renamed from: lG () com.google.android.gms.games.leaderboard.LeaderboardVariant
    public LeaderboardVariant method_5310() {
        return this;
    }

    public String toString() {
        return method_5309(this);
    }
}
