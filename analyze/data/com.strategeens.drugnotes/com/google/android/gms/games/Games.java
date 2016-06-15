package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_347;
import java.util.ArrayList;

public final class Games {
   public static final Api<Games.GamesOptions> API;
   public static final Achievements Achievements;
   // $FF: renamed from: DQ com.google.android.gms.common.api.Api$c
   static final Api.class_1394<GamesClientImpl> field_2497 = new Api.class_1394();
   // $FF: renamed from: DR com.google.android.gms.common.api.Api$b
   private static final Api.class_1391<GamesClientImpl, Games.GamesOptions> field_2498 = new Api.class_1391() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.games.Games$GamesOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.games.internal.GamesClientImpl
      public GamesClientImpl method_4123(Context var1, Looper var2, class_347 var3, Games.GamesOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         Games.GamesOptions var7;
         if(var4 == null) {
            var7 = new Games.GamesOptions(null);
         } else {
            var7 = var4;
         }

         return new GamesClientImpl(var1, var2, var3.method_2422(), var3.method_2418(), var5, var6, var3.method_2421(), var3.method_2419(), var3.method_2423(), var7);
      }

      public int getPriority() {
         return 1;
      }
   };
   public static final String EXTRA_PLAYER_IDS = "players";
   public static final Events Events;
   public static final GamesMetadata GamesMetadata;
   public static final Invitations Invitations;
   public static final Leaderboards Leaderboards;
   public static final Notifications Notifications;
   public static final Players Players;
   public static final Quests Quests;
   public static final RealTimeMultiplayer RealTimeMultiplayer;
   public static final Requests Requests;
   public static final Scope SCOPE_GAMES = new Scope("https://www.googleapis.com/auth/games");
   public static final Snapshots Snapshots;
   public static final TurnBasedMultiplayer TurnBasedMultiplayer;
   // $FF: renamed from: WV com.google.android.gms.common.api.Scope
   public static final Scope field_2499;
   // $FF: renamed from: WW com.google.android.gms.common.api.Api
   public static final Api<Games.GamesOptions> field_2500;
   // $FF: renamed from: WX com.google.android.gms.games.appcontent.AppContents
   public static final AppContents field_2501;
   // $FF: renamed from: WY com.google.android.gms.games.multiplayer.Multiplayer
   public static final Multiplayer field_2502;
   // $FF: renamed from: WZ com.google.android.gms.games.internal.game.Acls
   public static final Acls field_2503;

   static {
      Api.class_1391 var0 = field_2498;
      Api.class_1394 var1 = field_2497;
      Scope[] var2 = new Scope[]{SCOPE_GAMES};
      API = new Api(var0, var1, var2);
      field_2499 = new Scope("https://www.googleapis.com/auth/games.firstparty");
      Api.class_1391 var3 = field_2498;
      Api.class_1394 var4 = field_2497;
      Scope[] var5 = new Scope[]{field_2499};
      field_2500 = new Api(var3, var4, var5);
      GamesMetadata = new GamesMetadataImpl();
      Achievements = new AchievementsImpl();
      field_2501 = new AppContentsImpl();
      Events = new EventsImpl();
      Leaderboards = new LeaderboardsImpl();
      Invitations = new InvitationsImpl();
      TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
      RealTimeMultiplayer = new RealTimeMultiplayerImpl();
      field_2502 = new MultiplayerImpl();
      Players = new PlayersImpl();
      Notifications = new NotificationsImpl();
      Quests = new QuestsImpl();
      Requests = new RequestsImpl();
      Snapshots = new SnapshotsImpl();
      field_2503 = new AclsImpl();
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.GoogleApiClient) com.google.android.gms.games.internal.GamesClientImpl
   public static GamesClientImpl method_3259(GoogleApiClient var0) {
      boolean var1;
      if(var0 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      class_335.method_2308(var1, "GoogleApiClient parameter is required.");
      class_335.method_2302(var0.isConnected(), "GoogleApiClient must be connected.");
      return method_3260(var0);
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.GoogleApiClient) com.google.android.gms.games.internal.GamesClientImpl
   public static GamesClientImpl method_3260(GoogleApiClient var0) {
      GamesClientImpl var1 = (GamesClientImpl)var0.method_941(field_2497);
      boolean var2;
      if(var1 != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      class_335.method_2302(var2, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
      return var1;
   }

   public static String getAppId(GoogleApiClient var0) {
      return method_3259(var0).method_2003();
   }

   public static String getCurrentAccountName(GoogleApiClient var0) {
      return method_3259(var0).method_1988();
   }

   public static int getSdkVariant(GoogleApiClient var0) {
      return method_3259(var0).method_2002();
   }

   public static Intent getSettingsIntent(GoogleApiClient var0) {
      return method_3259(var0).method_2001();
   }

   public static void setGravityForPopups(GoogleApiClient var0, int var1) {
      method_3259(var0).method_1960(var1);
   }

   public static void setViewForPopups(GoogleApiClient var0, View var1) {
      class_335.method_2311(var1);
      method_3259(var0).method_1981(var1);
   }

   public static PendingResult<Status> signOut(final GoogleApiClient var0) {
      return var0.method_944(new Games.SignOutImpl(var0, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1385(GamesClientImpl var1) {
            var1.method_1921(this);
         }
      });
   }

   public abstract static class BaseGamesApiMethodImpl<R extends Result> extends BaseImplementation.class_1057<R, GamesClientImpl> {
      public BaseGamesApiMethodImpl(GoogleApiClient var1) {
         super(Games.field_2497, var1);
      }
   }

   public static final class GamesOptions implements Api.Optional {
      // $FF: renamed from: Xa boolean
      public final boolean field_1749;
      // $FF: renamed from: Xb boolean
      public final boolean field_1750;
      // $FF: renamed from: Xc int
      public final int field_1751;
      // $FF: renamed from: Xd boolean
      public final boolean field_1752;
      // $FF: renamed from: Xe int
      public final int field_1753;
      // $FF: renamed from: Xf java.lang.String
      public final String field_1754;
      // $FF: renamed from: Xg java.util.ArrayList
      public final ArrayList<String> field_1755;

      private GamesOptions() {
         this.field_1749 = false;
         this.field_1750 = true;
         this.field_1751 = 17;
         this.field_1752 = false;
         this.field_1753 = 4368;
         this.field_1754 = null;
         this.field_1755 = new ArrayList();
      }

      // $FF: synthetic method
      GamesOptions(Object var1) {
         this();
      }

      private GamesOptions(Games.Builder var1) {
         this.field_1749 = var1.field_3235;
         this.field_1750 = var1.field_3236;
         this.field_1751 = var1.field_3237;
         this.field_1752 = var1.field_3238;
         this.field_1753 = var1.field_3239;
         this.field_1754 = var1.field_3240;
         this.field_1755 = var1.field_3241;
      }

      // $FF: synthetic method
      GamesOptions(Games.Builder var1, Object var2) {
         this(var1);
      }

      public static Games.Builder builder() {
         return new Games.Builder(null);
      }
   }

   public static final class Builder {
      // $FF: renamed from: Xa boolean
      boolean field_3235;
      // $FF: renamed from: Xb boolean
      boolean field_3236;
      // $FF: renamed from: Xc int
      int field_3237;
      // $FF: renamed from: Xd boolean
      boolean field_3238;
      // $FF: renamed from: Xe int
      int field_3239;
      // $FF: renamed from: Xf java.lang.String
      String field_3240;
      // $FF: renamed from: Xg java.util.ArrayList
      ArrayList<String> field_3241;

      private Builder() {
         this.field_3235 = false;
         this.field_3236 = true;
         this.field_3237 = 17;
         this.field_3238 = false;
         this.field_3239 = 4368;
         this.field_3240 = null;
         this.field_3241 = new ArrayList();
      }

      // $FF: synthetic method
      Builder(Object var1) {
         this();
      }

      public Games.GamesOptions build() {
         return new Games.GamesOptions(this, null);
      }

      public Games.Builder setSdkVariant(int var1) {
         this.field_3239 = var1;
         return this;
      }

      public Games.Builder setShowConnectingPopup(boolean var1) {
         this.field_3236 = var1;
         this.field_3237 = 17;
         return this;
      }

      public Games.Builder setShowConnectingPopup(boolean var1, int var2) {
         this.field_3236 = var1;
         this.field_3237 = var2;
         return this;
      }
   }

   private abstract static class SignOutImpl extends Games.BaseGamesApiMethodImpl<Status> {
      private SignOutImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      SignOutImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1384(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1384(var1);
      }
   }
}
