package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {
   public Intent getAchievementsIntent(GoogleApiClient var1) {
      return Games.method_3259(var1).method_1993();
   }

   public void increment(final GoogleApiClient var1, final String var2, final int var3) {
      var1.method_944(new AchievementsImpl.UpdateImpl(var2, var1) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1381(GamesClientImpl var1) {
            var1.method_1889((BaseImplementation.class_1058)null, var2, var3);
         }
      });
   }

   public PendingResult<Achievements.UpdateAchievementResult> incrementImmediate(final GoogleApiClient var1, final String var2, final int var3) {
      return var1.method_944(new AchievementsImpl.UpdateImpl(var2, var1) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1380(GamesClientImpl var1) {
            var1.method_1889(this, var2, var3);
         }
      });
   }

   public PendingResult<Achievements.LoadAchievementsResult> load(final GoogleApiClient var1, final boolean var2) {
      return var1.method_942(new AchievementsImpl.LoadImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1332(GamesClientImpl var1) {
            var1.method_1948(this, var2);
         }
      });
   }

   public void reveal(final GoogleApiClient var1, final String var2) {
      var1.method_944(new AchievementsImpl.UpdateImpl(var2, var1) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1378(GamesClientImpl var1) {
            var1.method_1888((BaseImplementation.class_1058)null, var2);
         }
      });
   }

   public PendingResult<Achievements.UpdateAchievementResult> revealImmediate(final GoogleApiClient var1, final String var2) {
      return var1.method_944(new AchievementsImpl.UpdateImpl(var2, var1) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1377(GamesClientImpl var1) {
            var1.method_1888(this, var2);
         }
      });
   }

   public void setSteps(final GoogleApiClient var1, final String var2, final int var3) {
      var1.method_944(new AchievementsImpl.UpdateImpl(var2, var1) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1379(GamesClientImpl var1) {
            var1.method_1924((BaseImplementation.class_1058)null, var2, var3);
         }
      });
   }

   public PendingResult<Achievements.UpdateAchievementResult> setStepsImmediate(final GoogleApiClient var1, final String var2, final int var3) {
      return var1.method_944(new AchievementsImpl.UpdateImpl(var2, var1) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1383(GamesClientImpl var1) {
            var1.method_1924(this, var2, var3);
         }
      });
   }

   public void unlock(final GoogleApiClient var1, final String var2) {
      var1.method_944(new AchievementsImpl.UpdateImpl(var2, var1) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1376(GamesClientImpl var1) {
            var1.method_1923((BaseImplementation.class_1058)null, var2);
         }
      });
   }

   public PendingResult<Achievements.UpdateAchievementResult> unlockImmediate(final GoogleApiClient var1, final String var2) {
      return var1.method_944(new AchievementsImpl.UpdateImpl(var2, var1) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1382(GamesClientImpl var1) {
            var1.method_1923(this, var2);
         }
      });
   }

   private abstract static class LoadImpl extends Games.BaseGamesApiMethodImpl<Achievements.LoadAchievementsResult> {
      private LoadImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: I (com.google.android.gms.common.api.Status) com.google.android.gms.games.achievement.Achievements$LoadAchievementsResult
      public Achievements.LoadAchievementsResult method_1331(final Status var1) {
         return new Achievements.LoadAchievementsResult() {
            public AchievementBuffer getAchievements() {
               return new AchievementBuffer(DataHolder.method_5824(14));
            }

            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1331(var1);
      }
   }

   private abstract static class UpdateImpl extends Games.BaseGamesApiMethodImpl<Achievements.UpdateAchievementResult> {
      // $FF: renamed from: CE java.lang.String
      private final String field_265;

      public UpdateImpl(String var1, GoogleApiClient var2) {
         super(var2);
         this.field_265 = var1;
      }

      // $FF: renamed from: J (com.google.android.gms.common.api.Status) com.google.android.gms.games.achievement.Achievements$UpdateAchievementResult
      public Achievements.UpdateAchievementResult method_1375(final Status var1) {
         return new Achievements.UpdateAchievementResult() {
            public String getAchievementId() {
               return UpdateImpl.this.field_265;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1375(var1);
      }
   }
}
