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
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.class_1090;
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
import java.util.ArrayList;

public final class Games {
    public static final Api<Games.GamesOptions> API;
    public static final Achievements Achievements;
    // $FF: renamed from: CU com.google.android.gms.common.api.Api$c
    static final Api.class_1482<GamesClientImpl> field_2855 = new Api.class_1482();
    // $FF: renamed from: CV com.google.android.gms.common.api.Api$b
    private static final Api.class_1479<GamesClientImpl, Games.GamesOptions> field_2856 = new Api.class_1479() {
        // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.games.Games$GamesOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.games.internal.GamesClientImpl
        public GamesClientImpl method_4391(Context var1, Looper var2, ClientSettings var3, Games.GamesOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            Games.GamesOptions var7;
            if(var4 == null) {
                var7 = new Games.GamesOptions(null);
            } else {
                var7 = var4;
            }

            return new GamesClientImpl(var1, var2, var3.getRealClientPackageName(), var3.getAccountNameOrDefault(), var5, var6, var3.getScopesArray(), var3.getGravityForPopups(), var3.getViewForPopups(), var7);
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
    // $FF: renamed from: VA com.google.android.gms.common.api.Api
    public static final Api<Games.GamesOptions> field_2857;
    // $FF: renamed from: VB com.google.android.gms.games.multiplayer.Multiplayer
    public static final Multiplayer field_2858;
    // $FF: renamed from: VC com.google.android.gms.games.internal.game.Acls
    public static final Acls field_2859;
    // $FF: renamed from: Vz com.google.android.gms.common.api.Scope
    public static final Scope field_2860;

    static {
        Api.class_1479 var0 = field_2856;
        Api.class_1482 var1 = field_2855;
        Scope[] var2 = new Scope[] {SCOPE_GAMES};
        API = new Api(var0, var1, var2);
        field_2860 = new Scope("https://www.googleapis.com/auth/games.firstparty");
        Api.class_1479 var3 = field_2856;
        Api.class_1482 var4 = field_2855;
        Scope[] var5 = new Scope[] {field_2860};
        field_2857 = new Api(var3, var4, var5);
        GamesMetadata = new GamesMetadataImpl();
        Achievements = new AchievementsImpl();
        Events = new EventsImpl();
        Leaderboards = new LeaderboardsImpl();
        Invitations = new InvitationsImpl();
        TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
        RealTimeMultiplayer = new RealTimeMultiplayerImpl();
        field_2858 = new MultiplayerImpl();
        Players = new PlayersImpl();
        Notifications = new NotificationsImpl();
        Quests = new QuestsImpl();
        Requests = new RequestsImpl();
        Snapshots = new SnapshotsImpl();
        field_2859 = new AclsImpl();
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.GoogleApiClient) com.google.android.gms.games.internal.GamesClientImpl
    public static GamesClientImpl method_3257(GoogleApiClient var0) {
        boolean var1;
        if(var0 != null) {
            var1 = true;
        } else {
            var1 = false;
        }

        class_1090.method_5683(var1, "GoogleApiClient parameter is required.");
        class_1090.method_5676(var0.isConnected(), "GoogleApiClient must be connected.");
        return method_3258(var0);
    }

    // $FF: renamed from: d (com.google.android.gms.common.api.GoogleApiClient) com.google.android.gms.games.internal.GamesClientImpl
    public static GamesClientImpl method_3258(GoogleApiClient var0) {
        GamesClientImpl var1 = (GamesClientImpl)var0.method_896(field_2855);
        boolean var2;
        if(var1 != null) {
            var2 = true;
        } else {
            var2 = false;
        }

        class_1090.method_5676(var2, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return var1;
    }

    public static String getAppId(GoogleApiClient var0) {
        return method_3257(var0).method_2014();
    }

    public static String getCurrentAccountName(GoogleApiClient var0) {
        return method_3257(var0).method_1999();
    }

    public static int getSdkVariant(GoogleApiClient var0) {
        return method_3257(var0).method_2013();
    }

    public static Intent getSettingsIntent(GoogleApiClient var0) {
        return method_3257(var0).method_2012();
    }

    public static void setGravityForPopups(GoogleApiClient var0, int var1) {
        method_3257(var0).method_1974(var1);
    }

    public static void setViewForPopups(GoogleApiClient var0, View var1) {
        class_1090.method_5685(var1);
        method_3257(var0).method_1997(var1);
    }

    public static PendingResult<Status> signOut(GoogleApiClient var0) {
        return var0.method_899(new Games.SignOutImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1378(GamesClientImpl var1) {
                var1.method_1938(this);
            }
        });
    }

    public abstract static class BaseGamesApiMethodImpl<R extends Result> extends BaseImplementation.class_1146<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl() {
            super(Games.field_2855);
        }
    }

    public static final class GamesOptions implements Api.Optional {
        // $FF: renamed from: VD boolean
        public final boolean field_2073;
        // $FF: renamed from: VE boolean
        public final boolean field_2074;
        // $FF: renamed from: VF int
        public final int field_2075;
        // $FF: renamed from: VG boolean
        public final boolean field_2076;
        // $FF: renamed from: VH int
        public final int field_2077;
        // $FF: renamed from: VI java.lang.String
        public final String field_2078;
        // $FF: renamed from: VJ java.util.ArrayList
        public final ArrayList<String> field_2079;

        private GamesOptions() {
            this.field_2073 = false;
            this.field_2074 = true;
            this.field_2075 = 17;
            this.field_2076 = false;
            this.field_2077 = 4368;
            this.field_2078 = null;
            this.field_2079 = new ArrayList();
        }

        // $FF: synthetic method
        GamesOptions(Object var1) {
            this();
        }

        private GamesOptions(Games.Builder var1) {
            this.field_2073 = var1.field_4057;
            this.field_2074 = var1.field_4058;
            this.field_2075 = var1.field_4059;
            this.field_2076 = var1.field_4060;
            this.field_2077 = var1.field_4061;
            this.field_2078 = var1.field_4062;
            this.field_2079 = var1.field_4063;
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
        // $FF: renamed from: VD boolean
        boolean field_4057;
        // $FF: renamed from: VE boolean
        boolean field_4058;
        // $FF: renamed from: VF int
        int field_4059;
        // $FF: renamed from: VG boolean
        boolean field_4060;
        // $FF: renamed from: VH int
        int field_4061;
        // $FF: renamed from: VI java.lang.String
        String field_4062;
        // $FF: renamed from: VJ java.util.ArrayList
        ArrayList<String> field_4063;

        private Builder() {
            this.field_4057 = false;
            this.field_4058 = true;
            this.field_4059 = 17;
            this.field_4060 = false;
            this.field_4061 = 4368;
            this.field_4062 = null;
            this.field_4063 = new ArrayList();
        }

        // $FF: synthetic method
        Builder(Object var1) {
            this();
        }

        public Games.GamesOptions build() {
            return new Games.GamesOptions(this, null);
        }

        public Games.Builder setSdkVariant(int var1) {
            this.field_4061 = var1;
            return this;
        }

        public Games.Builder setShowConnectingPopup(boolean var1) {
            this.field_4058 = var1;
            this.field_4059 = 17;
            return this;
        }

        public Games.Builder setShowConnectingPopup(boolean var1, int var2) {
            this.field_4058 = var1;
            this.field_4059 = var2;
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
        public Result method_1104(Status var1) {
            return this.method_1377(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        public Status method_1377(Status var1) {
            return var1;
        }
    }
}
