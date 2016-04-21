package com.google.android.gms.games.achievement;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.games.achievement.AchievementBuffer;

public interface Achievements {
    Intent getAchievementsIntent(GoogleApiClient var1);

    void increment(GoogleApiClient var1, String var2, int var3);

    PendingResult<Achievements.UpdateAchievementResult> incrementImmediate(GoogleApiClient var1, String var2, int var3);

    PendingResult<Achievements.LoadAchievementsResult> load(GoogleApiClient var1, boolean var2);

    void reveal(GoogleApiClient var1, String var2);

    PendingResult<Achievements.UpdateAchievementResult> revealImmediate(GoogleApiClient var1, String var2);

    void setSteps(GoogleApiClient var1, String var2, int var3);

    PendingResult<Achievements.UpdateAchievementResult> setStepsImmediate(GoogleApiClient var1, String var2, int var3);

    void unlock(GoogleApiClient var1, String var2);

    PendingResult<Achievements.UpdateAchievementResult> unlockImmediate(GoogleApiClient var1, String var2);

    public interface LoadAchievementsResult extends Releasable, Result {
        AchievementBuffer getAchievements();
    }

    public interface UpdateAchievementResult extends Result {
        String getAchievementId();
    }
}
