package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {
   public void increment(final GoogleApiClient var1, final String var2, final int var3) {
      GamesClientImpl var4 = Games.method_3260(var1);
      if(var4.isConnected()) {
         var4.method_2011(var2, var3);
      } else {
         var1.method_944(new EventsImpl.UpdateImpl(var1, null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            public void method_1366(GamesClientImpl var1) {
               var1.method_2011(var2, var3);
            }
         });
      }
   }

   public PendingResult<Events.LoadEventsResult> load(final GoogleApiClient var1, final boolean var2) {
      return var1.method_942(new EventsImpl.LoadImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1368(GamesClientImpl var1) {
            var1.method_1958(this, var2);
         }
      });
   }

   public PendingResult<Events.LoadEventsResult> loadByIds(final GoogleApiClient var1, final boolean var2, final String... var3) {
      return var1.method_942(new EventsImpl.LoadImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         public void method_1369(GamesClientImpl var1) {
            var1.method_1911(this, var2, var3);
         }
      });
   }

   private abstract static class LoadImpl extends Games.BaseGamesApiMethodImpl<Events.LoadEventsResult> {
      private LoadImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: O (com.google.android.gms.common.api.Status) com.google.android.gms.games.event.Events$LoadEventsResult
      public Events.LoadEventsResult method_1367(final Status var1) {
         return new Events.LoadEventsResult() {
            public EventBuffer getEvents() {
               return new EventBuffer(DataHolder.method_5824(14));
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
         return this.method_1367(var1);
      }
   }

   private abstract static class UpdateImpl extends Games.BaseGamesApiMethodImpl<Result> {
      private UpdateImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      UpdateImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      public Result method_1109(final Status var1) {
         return new Result() {
            public Status getStatus() {
               return var1;
            }
         };
      }
   }
}
