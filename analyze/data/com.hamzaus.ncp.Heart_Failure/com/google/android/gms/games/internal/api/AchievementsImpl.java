package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {
   public Intent getAchievementsIntent(GoogleApiClient var1) {
      return Games.method_2780(var1).method_1612();
   }

   public void increment(GoogleApiClient var1, final String var2, final int var3) {
      var1.method_773(new AchievementsImpl.UpdateImpl(var2) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1118(GamesClientImpl var1) {
            var1.method_1521((class_797.class_1206)null, var2, var3);
         }
      });
   }

   public PendingResult<Achievements.UpdateAchievementResult> incrementImmediate(GoogleApiClient var1, final String var2, final int var3) {
      return var1.method_773(new AchievementsImpl.UpdateImpl(var2) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1117(GamesClientImpl var1) {
            var1.method_1521(this, var2, var3);
         }
      });
   }

   public PendingResult<Achievements.LoadAchievementsResult> load(GoogleApiClient var1, final boolean var2) {
      return var1.method_772(new AchievementsImpl.LoadImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1069(GamesClientImpl var1) {
            var1.method_1581(this, var2);
         }
      });
   }

   public void reveal(GoogleApiClient var1, final String var2) {
      var1.method_773(new AchievementsImpl.UpdateImpl(var2) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1115(GamesClientImpl var1) {
            var1.method_1561((class_797.class_1206)null, var2);
         }
      });
   }

   public PendingResult<Achievements.UpdateAchievementResult> revealImmediate(GoogleApiClient var1, final String var2) {
      return var1.method_773(new AchievementsImpl.UpdateImpl(var2) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1114(GamesClientImpl var1) {
            var1.method_1561(this, var2);
         }
      });
   }

   public void setSteps(GoogleApiClient var1, final String var2, final int var3) {
      var1.method_773(new AchievementsImpl.UpdateImpl(var2) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1116(GamesClientImpl var1) {
            var1.method_1562((class_797.class_1206)null, var2, var3);
         }
      });
   }

   public PendingResult<Achievements.UpdateAchievementResult> setStepsImmediate(GoogleApiClient var1, final String var2, final int var3) {
      return var1.method_773(new AchievementsImpl.UpdateImpl(var2) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1120(GamesClientImpl var1) {
            var1.method_1562(this, var2, var3);
         }
      });
   }

   public void unlock(GoogleApiClient var1, final String var2) {
      var1.method_773(new AchievementsImpl.UpdateImpl(var2) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1113(GamesClientImpl var1) {
            var1.method_1575((class_797.class_1206)null, var2);
         }
      });
   }

   public PendingResult<Achievements.UpdateAchievementResult> unlockImmediate(GoogleApiClient var1, final String var2) {
      return var1.method_773(new AchievementsImpl.UpdateImpl(var2) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1119(GamesClientImpl var1) {
            var1.method_1575(this, var2);
         }
      });
   }

   private abstract static class LoadImpl extends Games.BaseGamesApiMethodImpl<Achievements.LoadAchievementsResult> {
      private LoadImpl() {
      }

      // $FF: synthetic method
      LoadImpl(Object var1) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1068(var1);
      }

      // $FF: renamed from: v (com.google.android.gms.common.api.Status) com.google.android.gms.games.achievement.Achievements$LoadAchievementsResult
      public Achievements.LoadAchievementsResult method_1068(final Status var1) {
         return new Achievements.LoadAchievementsResult() {
            public AchievementBuffer getAchievements() {
               return new AchievementBuffer(DataHolder.method_4552(14));
            }

            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }
   }

   private abstract static class UpdateImpl extends Games.BaseGamesApiMethodImpl<Achievements.UpdateAchievementResult> {
      // $FF: renamed from: xD java.lang.String
      private final String field_284;

      public UpdateImpl(String var1) {
         this.field_284 = var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1112(var1);
      }

      // $FF: renamed from: w (com.google.android.gms.common.api.Status) com.google.android.gms.games.achievement.Achievements$UpdateAchievementResult
      public Achievements.UpdateAchievementResult method_1112(final Status var1) {
         return new Achievements.UpdateAchievementResult() {
            public String getAchievementId() {
               return UpdateImpl.this.field_284;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }
   }
}
