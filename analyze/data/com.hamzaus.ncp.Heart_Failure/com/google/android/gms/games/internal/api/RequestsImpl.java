package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {
   public PendingResult<Requests.UpdateRequestsResult> acceptRequest(GoogleApiClient var1, String var2) {
      ArrayList var3 = new ArrayList();
      var3.add(var2);
      return this.acceptRequests(var1, var3);
   }

   public PendingResult<Requests.UpdateRequestsResult> acceptRequests(GoogleApiClient var1, List<String> var2) {
      final String[] var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = (String[])var2.toArray(new String[var2.size()]);
      }

      return var1.method_773(new RequestsImpl.UpdateRequestsImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1084(GamesClientImpl var1) {
            var1.method_1571(this, var3);
         }
      });
   }

   public PendingResult<Requests.UpdateRequestsResult> dismissRequest(GoogleApiClient var1, String var2) {
      ArrayList var3 = new ArrayList();
      var3.add(var2);
      return this.dismissRequests(var1, var3);
   }

   public PendingResult<Requests.UpdateRequestsResult> dismissRequests(GoogleApiClient var1, List<String> var2) {
      final String[] var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = (String[])var2.toArray(new String[var2.size()]);
      }

      return var1.method_773(new RequestsImpl.UpdateRequestsImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1083(GamesClientImpl var1) {
            var1.method_1582(this, var3);
         }
      });
   }

   public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle var1) {
      if(var1 != null && var1.containsKey("requests")) {
         ArrayList var2 = (ArrayList)var1.get("requests");
         ArrayList var3 = new ArrayList();
         int var4 = var2.size();

         for(int var5 = 0; var5 < var4; ++var5) {
            var3.add((GameRequest)var2.get(var5));
         }

         return var3;
      } else {
         return new ArrayList();
      }
   }

   public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent var1) {
      return var1 == null?new ArrayList():this.getGameRequestsFromBundle(var1.getExtras());
   }

   public Intent getInboxIntent(GoogleApiClient var1) {
      return Games.method_2780(var1).method_1626();
   }

   public int getMaxLifetimeDays(GoogleApiClient var1) {
      return Games.method_2780(var1).method_1628();
   }

   public int getMaxPayloadSize(GoogleApiClient var1) {
      return Games.method_2780(var1).method_1627();
   }

   public Intent getSendIntent(GoogleApiClient var1, int var2, byte[] var3, int var4, Bitmap var5, String var6) {
      return Games.method_2780(var1).method_1508(var2, var3, var4, var5, var6);
   }

   public PendingResult<Requests.LoadRequestsResult> loadRequests(GoogleApiClient var1, final int var2, final int var3, final int var4) {
      return var1.method_772(new RequestsImpl.LoadRequestsImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1080(GamesClientImpl var1) {
            var1.method_1513(this, var2, var3, var4);
         }
      });
   }

   public void registerRequestListener(GoogleApiClient var1, OnRequestReceivedListener var2) {
      Games.method_2780(var1).method_1552(var2);
   }

   public void unregisterRequestListener(GoogleApiClient var1) {
      Games.method_2780(var1).method_1620();
   }

   private abstract static class LoadRequestSummariesImpl extends Games.BaseGamesApiMethodImpl<Requests.LoadRequestSummariesResult> {
      // $FF: renamed from: V (com.google.android.gms.common.api.Status) com.google.android.gms.games.request.Requests$LoadRequestSummariesResult
      public Requests.LoadRequestSummariesResult method_1077(final Status var1) {
         return new Requests.LoadRequestSummariesResult() {
            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1077(var1);
      }
   }

   private abstract static class LoadRequestsImpl extends Games.BaseGamesApiMethodImpl<Requests.LoadRequestsResult> {
      private LoadRequestsImpl() {
      }

      // $FF: synthetic method
      LoadRequestsImpl(Object var1) {
         this();
      }

      // $FF: renamed from: W (com.google.android.gms.common.api.Status) com.google.android.gms.games.request.Requests$LoadRequestsResult
      public Requests.LoadRequestsResult method_1079(final Status var1) {
         return new Requests.LoadRequestsResult() {
            public GameRequestBuffer getRequests(int var1x) {
               return null;
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
      public Result method_884(Status var1) {
         return this.method_1079(var1);
      }
   }

   private abstract static class SendRequestImpl extends Games.BaseGamesApiMethodImpl<Requests.SendRequestResult> {
      // $FF: renamed from: X (com.google.android.gms.common.api.Status) com.google.android.gms.games.request.Requests$SendRequestResult
      public Requests.SendRequestResult method_1086(final Status var1) {
         return new Requests.SendRequestResult() {
            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1086(var1);
      }
   }

   private abstract static class UpdateRequestsImpl extends Games.BaseGamesApiMethodImpl<Requests.UpdateRequestsResult> {
      private UpdateRequestsImpl() {
      }

      // $FF: synthetic method
      UpdateRequestsImpl(Object var1) {
         this();
      }

      // $FF: renamed from: Y (com.google.android.gms.common.api.Status) com.google.android.gms.games.request.Requests$UpdateRequestsResult
      public Requests.UpdateRequestsResult method_1082(final Status var1) {
         return new Requests.UpdateRequestsResult() {
            public Set<String> getRequestIds() {
               return null;
            }

            public int getRequestOutcome(String var1x) {
               throw new IllegalArgumentException("Unknown request ID " + var1x);
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
      public Result method_884(Status var1) {
         return this.method_1082(var1);
      }
   }
}
