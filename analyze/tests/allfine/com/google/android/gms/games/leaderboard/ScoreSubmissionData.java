package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.games.internal.constants.TimeSpan;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] abs = new String[] {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    // $FF: renamed from: HF int
    private int field_1789;
    // $FF: renamed from: VK java.lang.String
    private String field_1790;
    private HashMap<Integer, ScoreSubmissionData.Result> abY;
    private String abu;

    public ScoreSubmissionData(DataHolder var1) {
        this.field_1789 = var1.getStatusCode();
        this.abY = new HashMap();
        int var2 = var1.getCount();
        boolean var3;
        if(var2 == 3) {
            var3 = true;
        } else {
            var3 = false;
        }

        class_1090.method_5675(var3);

        for(int var4 = 0; var4 < var2; ++var4) {
            int var5 = var1.method_5987(var4);
            if(var4 == 0) {
                this.abu = var1.method_5989("leaderboardId", var4, var5);
                this.field_1790 = var1.method_5989("playerId", var4, var5);
            }

            if(var1.method_5990("hasResult", var4, var5)) {
                this.method_2846(new ScoreSubmissionData.Result(var1.method_5984("rawScore", var4, var5), var1.method_5989("formattedScore", var4, var5), var1.method_5989("scoreTag", var4, var5), var1.method_5990("newBest", var4, var5)), var1.method_5988("timeSpan", var4, var5));
            }
        }

    }

    // $FF: renamed from: a (com.google.android.gms.games.leaderboard.ScoreSubmissionData$Result, int) void
    private void method_2846(ScoreSubmissionData.Result var1, int var2) {
        this.abY.put(Integer.valueOf(var2), var1);
    }

    public String getLeaderboardId() {
        return this.abu;
    }

    public String getPlayerId() {
        return this.field_1790;
    }

    public ScoreSubmissionData.Result getScoreResult(int var1) {
        return (ScoreSubmissionData.Result)this.abY.get(Integer.valueOf(var1));
    }

    public String toString() {
        class_1089.class_1785 var1 = class_1089.method_5673(this).method_5425("PlayerId", this.field_1790).method_5425("StatusCode", Integer.valueOf(this.field_1789));

        for(int var2 = 0; var2 < 3; ++var2) {
            ScoreSubmissionData.Result var3 = (ScoreSubmissionData.Result)this.abY.get(Integer.valueOf(var2));
            var1.method_5425("TimesSpan", TimeSpan.method_5842(var2));
            String var5;
            if(var3 == null) {
                var5 = "null";
            } else {
                var5 = var3.toString();
            }

            var1.method_5425("Result", var5);
        }

        return var1.toString();
    }

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long var1, String var3, String var4, boolean var5) {
            this.rawScore = var1;
            this.formattedScore = var3;
            this.scoreTag = var4;
            this.newBest = var5;
        }

        public String toString() {
            return class_1089.method_5673(this).method_5425("RawScore", Long.valueOf(this.rawScore)).method_5425("FormattedScore", this.formattedScore).method_5425("ScoreTag", this.scoreTag).method_5425("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }
}
