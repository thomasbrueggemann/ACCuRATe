package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.appcontent.AppContents;

public final class AppContentsImpl implements AppContents {
   private abstract static class LoadsImpl extends Games.BaseGamesApiMethodImpl<AppContents.LoadAppContentResult> {
      // $FF: renamed from: N (com.google.android.gms.common.api.Status) com.google.android.gms.games.appcontent.AppContents$LoadAppContentResult
      public AppContents.LoadAppContentResult method_1449(final Status var1) {
         return new AppContents.LoadAppContentResult() {
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
         return this.method_1449(var1);
      }
   }
}
