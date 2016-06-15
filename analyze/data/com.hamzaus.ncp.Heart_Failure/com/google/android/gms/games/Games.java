package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
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
import com.google.android.gms.internal.class_323;
import com.google.android.gms.internal.class_347;

public final class Games {
   public static final Api<Games.GamesOptions> API;
   public static final Achievements Achievements;
   public static final String EXTRA_PLAYER_IDS = "players";
   public static final Events Events;
   public static final GamesMetadata GamesMetadata;
   public static final Invitations Invitations;
   public static final Leaderboards Leaderboards;
   // $FF: renamed from: MF com.google.android.gms.common.api.Scope
   public static final Scope field_2704;
   // $FF: renamed from: MG com.google.android.gms.common.api.Api
   public static final Api<Games.GamesOptions> field_2705;
   // $FF: renamed from: MH com.google.android.gms.games.multiplayer.Multiplayer
   public static final Multiplayer field_2706;
   // $FF: renamed from: MI com.google.android.gms.games.internal.game.Acls
   public static final Acls field_2707;
   public static final Notifications Notifications;
   public static final Players Players;
   public static final Quests Quests;
   public static final RealTimeMultiplayer RealTimeMultiplayer;
   public static final Requests Requests;
   public static final Scope SCOPE_GAMES = new Scope("https://www.googleapis.com/auth/games");
   public static final Snapshots Snapshots;
   public static final TurnBasedMultiplayer TurnBasedMultiplayer;
   // $FF: renamed from: yE com.google.android.gms.common.api.Api$c
   static final Api.class_1077<GamesClientImpl> field_2708 = new Api.class_1077();
   // $FF: renamed from: yF com.google.android.gms.common.api.Api$b
   private static final Api.class_1074<GamesClientImpl, Games.GamesOptions> field_2709 = new Api.class_1074() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, com.google.android.gms.games.Games$GamesOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.games.internal.GamesClientImpl
      public GamesClientImpl method_3447(Context var1, Looper var2, class_323 var3, Games.GamesOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         if(var4 == null) {
            var4 = new Games.GamesOptions(null);
         }

         return new GamesClientImpl(var1, var2, var3.method_2059(), var3.method_2055(), var5, var6, var3.method_2058(), var3.method_2056(), var3.method_2060(), var4.field_2074, var4.field_2075, var4.field_2076, var4.field_2077, var4.field_2078, var4.field_2079);
      }

      public int getPriority() {
         return 1;
      }
   };

   static {
      Api.class_1074 var0 = field_2709;
      Api.class_1077 var1 = field_2708;
      Scope[] var2 = new Scope[]{SCOPE_GAMES};
      API = new Api(var0, var1, var2);
      field_2704 = new Scope("https://www.googleapis.com/auth/games.firstparty");
      Api.class_1074 var3 = field_2709;
      Api.class_1077 var4 = field_2708;
      Scope[] var5 = new Scope[]{field_2704};
      field_2705 = new Api(var3, var4, var5);
      GamesMetadata = new GamesMetadataImpl();
      Achievements = new AchievementsImpl();
      Events = new EventsImpl();
      Leaderboards = new LeaderboardsImpl();
      Invitations = new InvitationsImpl();
      TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
      RealTimeMultiplayer = new RealTimeMultiplayerImpl();
      field_2706 = new MultiplayerImpl();
      Players = new PlayersImpl();
      Notifications = new NotificationsImpl();
      Quests = new QuestsImpl();
      Requests = new RequestsImpl();
      Snapshots = new SnapshotsImpl();
      field_2707 = new AclsImpl();
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.GoogleApiClient) com.google.android.gms.games.internal.GamesClientImpl
   public static GamesClientImpl method_2780(GoogleApiClient var0) {
      boolean var1;
      if(var0 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      class_347.method_2168(var1, "GoogleApiClient parameter is required.");
      class_347.method_2161(var0.isConnected(), "GoogleApiClient must be connected.");
      return method_2781(var0);
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.GoogleApiClient) com.google.android.gms.games.internal.GamesClientImpl
   public static GamesClientImpl method_2781(GoogleApiClient var0) {
      GamesClientImpl var1 = (GamesClientImpl)var0.method_771(field_2708);
      boolean var2;
      if(var1 != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      class_347.method_2161(var2, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
      return var1;
   }

   public static String getAppId(GoogleApiClient var0) {
      return method_2780(var0).method_1624();
   }

   public static String getCurrentAccountName(GoogleApiClient var0) {
      return method_2780(var0).method_1607();
   }

   public static int getSdkVariant(GoogleApiClient var0) {
      return method_2780(var0).method_1623();
   }

   public static Intent getSettingsIntent(GoogleApiClient var0) {
      return method_2780(var0).method_1622();
   }

   public static void setGravityForPopups(GoogleApiClient var0, int var1) {
      method_2780(var0).method_1583(var1);
   }

   public static void setViewForPopups(GoogleApiClient var0, View var1) {
      class_347.method_2170(var1);
      method_2780(var0).method_1598(var1);
   }

   public static PendingResult<Status> signOut(GoogleApiClient var0) {
      return var0.method_773(new Games.SignOutImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1122(GamesClientImpl var1) {
            var1.method_1559(this);
         }
      });
   }

   public abstract static class BaseGamesApiMethodImpl<R extends Result> extends class_797.class_1203<R, GamesClientImpl> {
      public BaseGamesApiMethodImpl() {
         super(Games.field_2708);
      }
   }

   public static final class GamesOptions implements Api.Optional {
      // $FF: renamed from: MJ boolean
      final boolean field_2074;
      // $FF: renamed from: MK boolean
      final boolean field_2075;
      // $FF: renamed from: ML int
      final int field_2076;
      // $FF: renamed from: MM boolean
      final boolean field_2077;
      // $FF: renamed from: MN int
      final int field_2078;
      // $FF: renamed from: MO java.lang.String
      final String field_2079;

      private GamesOptions() {
         this.field_2074 = false;
         this.field_2075 = true;
         this.field_2076 = 17;
         this.field_2077 = false;
         this.field_2078 = 4368;
         this.field_2079 = null;
      }

      // $FF: synthetic method
      GamesOptions(Object var1) {
         this();
      }

      private GamesOptions(Games.Builder var1) {
         this.field_2074 = var1.field_3283;
         this.field_2075 = var1.field_3284;
         this.field_2076 = var1.field_3285;
         this.field_2077 = var1.field_3286;
         this.field_2078 = var1.field_3287;
         this.field_2079 = var1.field_3288;
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
      // $FF: renamed from: MJ boolean
      boolean field_3283;
      // $FF: renamed from: MK boolean
      boolean field_3284;
      // $FF: renamed from: ML int
      int field_3285;
      // $FF: renamed from: MM boolean
      boolean field_3286;
      // $FF: renamed from: MN int
      int field_3287;
      // $FF: renamed from: MO java.lang.String
      String field_3288;

      private Builder() {
         this.field_3283 = false;
         this.field_3284 = true;
         this.field_3285 = 17;
         this.field_3286 = false;
         this.field_3287 = 4368;
         this.field_3288 = null;
      }

      // $FF: synthetic method
      Builder(Object var1) {
         this();
      }

      public Games.GamesOptions build() {
         return new Games.GamesOptions(this, null);
      }

      public Games.Builder setSdkVariant(int var1) {
         this.field_3287 = var1;
         return this;
      }

      public Games.Builder setShowConnectingPopup(boolean var1) {
         this.field_3284 = var1;
         this.field_3285 = 17;
         return this;
      }

      public Games.Builder setShowConnectingPopup(boolean var1, int var2) {
         this.field_3284 = var1;
         this.field_3285 = var2;
         return this;
      }
   }

   private abstract static class SignOutImpl extends Games.BaseGamesApiMethodImpl<Status> {
      private SignOutImpl() {
      }

      // $FF: synthetic method
      SignOutImpl(Object var1) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1121(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1121(Status var1) {
         return var1;
      }
   }
}
