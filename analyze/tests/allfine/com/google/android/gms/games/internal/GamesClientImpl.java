package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_491;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_1056;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_291;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.AbstractGamesCallbacks;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.games.internal.IGamesService;
import com.google.android.gms.games.internal.PopupManager;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.internal.class_854;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl extends e<IGamesService> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    // $FF: renamed from: Dd java.lang.String
    private final String field_897;
    // $FF: renamed from: WA long
    private final long field_898;
    // $FF: renamed from: WB com.google.android.gms.games.Games$GamesOptions
    private final Games.GamesOptions field_899;
    // $FF: renamed from: Ws com.google.android.gms.games.internal.events.EventIncrementManager
    EventIncrementManager field_900 = new EventIncrementManager() {
        // $FF: renamed from: ky () com.google.android.gms.games.internal.events.EventIncrementCache
        public EventIncrementCache method_3073() {
            return GamesClientImpl.this.new GameClientEventIncrementCache();
        }
    };
    // $FF: renamed from: Wt java.lang.String
    private final String field_901;
    // $FF: renamed from: Wu java.util.Map
    private final Map<String, RealTimeSocket> field_902;
    // $FF: renamed from: Wv com.google.android.gms.games.PlayerEntity
    private PlayerEntity field_903;
    // $FF: renamed from: Ww com.google.android.gms.games.GameEntity
    private GameEntity field_904;
    // $FF: renamed from: Wx com.google.android.gms.games.internal.PopupManager
    private final PopupManager field_905;
    // $FF: renamed from: Wy boolean
    private boolean field_906 = false;
    // $FF: renamed from: Wz android.os.Binder
    private final Binder field_907;

    public GamesClientImpl(Context var1, Looper var2, String var3, String var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6, String[] var7, int var8, View var9, Games.GamesOptions var10) {
        super(var1, var2, var5, var6, var7);
        this.field_901 = var3;
        this.field_897 = (String)class_1090.method_5685(var4);
        this.field_907 = new Binder();
        this.field_902 = new HashMap();
        this.field_905 = PopupManager.method_4801(this, var8);
        this.method_1997(var9);
        this.field_898 = (long)this.hashCode();
        this.field_899 = var10;
        this.registerConnectionCallbacks(this);
        this.registerConnectionFailedListener(this);
    }

    // $FF: renamed from: R (com.google.android.gms.common.data.DataHolder) com.google.android.gms.games.multiplayer.realtime.Room
    private Room method_1880(DataHolder param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: bA (java.lang.String) com.google.android.gms.games.multiplayer.realtime.RealTimeSocket
    private RealTimeSocket method_1882(String param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: bB (java.lang.String) com.google.android.gms.games.multiplayer.realtime.RealTimeSocket
    private RealTimeSocket method_1883(String param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: bz (java.lang.String) com.google.android.gms.games.multiplayer.realtime.RealTimeSocket
    private RealTimeSocket method_1884(String var1) {
        RealTimeSocket var2;
        if(class_854.method_4495()) {
            var2 = this.method_1883(var1);
        } else {
            var2 = this.method_1882(var1);
        }

        if(var2 != null) {
            this.field_902.put(var1, var2);
        }

        return var2;
    }

    // $FF: renamed from: jZ () void
    private void method_1885() {
        this.field_903 = null;
    }

    // $FF: renamed from: kw () void
    private void method_1886() {
        Iterator var1 = this.field_902.values().iterator();

        while(var1.hasNext()) {
            RealTimeSocket var2 = (RealTimeSocket)var1.next();

            try {
                var2.close();
            } catch (IOException var4) {
                GamesLog.method_6003("GamesClientImpl", "IOException:", var4);
            }
        }

        this.field_902.clear();
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer$ReliableMessageSentCallback, byte[], java.lang.String, java.lang.String) int
    public int method_1887(RealTimeMultiplayer.ReliableMessageSentCallback var1, byte[] var2, String var3, String var4) {
        try {
            int var6 = ((IGamesService)this.gS()).method_444(new GamesClientImpl.RealTimeReliableMessageBinderCallbacks(var1), var2, var3, var4);
            return var6;
        } catch (RemoteException var7) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return -1;
        }
    }

    // $FF: renamed from: a (byte[], java.lang.String, java.lang.String[]) int
    public int method_1888(byte[] var1, String var2, String[] var3) {
        class_1090.method_5681(var3, "Participant IDs must not be null");

        try {
            int var6 = ((IGamesService)this.gS()).method_503(var1, var2, var3);
            return var6;
        } catch (RemoteException var7) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return -1;
        }
    }

    // $FF: renamed from: a (int, int, boolean) android.content.Intent
    public Intent method_1889(int var1, int var2, boolean var3) {
        try {
            Intent var5 = ((IGamesService)this.gS()).method_445(var1, var2, var3);
            return var5;
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: a (int, byte[], int, android.graphics.Bitmap, java.lang.String) android.content.Intent
    public Intent method_1890(int var1, byte[] var2, int var3, Bitmap var4, String var5) {
        try {
            Intent var7 = ((IGamesService)this.gS()).method_446(var1, var2, var3, var5);
            class_1090.method_5681(var4, "Must provide a non null icon");
            var7.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", var4);
            return var7;
        } catch (RemoteException var8) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.Room, int) android.content.Intent
    public Intent method_1891(Room var1, int var2) {
        try {
            Intent var4 = ((IGamesService)this.gS()).method_450((RoomEntity)var1.freeze(), var2);
            return var4;
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: a (java.lang.String, boolean, boolean, int) android.content.Intent
    public Intent method_1892(String var1, boolean var2, boolean var3, int var4) {
        try {
            Intent var6 = ((IGamesService)this.gS()).method_451(var1, var2, var3, var4);
            return var6;
        } catch (RemoteException var7) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
    protected void method_1812(int var1, IBinder var2, Bundle var3) {
        if(var1 == 0 && var3 != null) {
            this.field_906 = var3.getBoolean("show_welcome_popup");
        }

        super.method_1812(var1, var2, var3);
    }

    // $FF: renamed from: a (android.os.IBinder, android.os.Bundle) void
    public void method_1893(IBinder var1, Bundle var2) {
        if(this.isConnected()) {
            try {
                ((IGamesService)this.gS()).method_454(var1, var2);
            } catch (RemoteException var4) {
                GamesLog.method_6005("GamesClientImpl", "service died");
                return;
            }
        }

    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, int, int) void
    public void method_1894(BaseImplementation.class_1147<Requests.LoadRequestsResult> var1, int var2, int var3, int var4) {
        try {
            ((IGamesService)this.gS()).method_458(new GamesClientImpl.RequestsLoadedBinderCallbacks(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, int, boolean, boolean) void
    public void method_1895(BaseImplementation.class_1147<GamesMetadata.LoadExtendedGamesResult> var1, int var2, int var3, boolean var4, boolean var5) {
        try {
            ((IGamesService)this.gS()).method_459(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
        } catch (RemoteException var7) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, boolean, boolean) void
    public void method_1896(BaseImplementation.class_1147<Players.LoadPlayersResult> var1, int var2, boolean var3, boolean var4) {
        try {
            ((IGamesService)this.gS()).method_461(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, int[]) void
    public void method_1897(BaseImplementation.class_1147<TurnBasedMultiplayer.LoadMatchesResult> var1, int var2, int[] var3) {
        try {
            ((IGamesService)this.gS()).method_462(new GamesClientImpl.TurnBasedMatchesLoadedBinderCallbacks(var1), var2, var3);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer, int, int) void
    public void method_1898(BaseImplementation.class_1147<Leaderboards.LoadScoresResult> var1, LeaderboardScoreBuffer var2, int var3, int var4) {
        try {
            ((IGamesService)this.gS()).method_465(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2.method_2893().method_4925(), var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig) void
    public void method_1899(BaseImplementation.class_1147<TurnBasedMultiplayer.InitiateMatchResult> var1, TurnBasedMatchConfig var2) {
        try {
            ((IGamesService)this.gS()).method_460(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2.getVariant(), var2.method_5253(), var2.getInvitedPlayerIds(), var2.getAutoMatchCriteria());
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.games.snapshot.Snapshot, com.google.android.gms.games.snapshot.SnapshotMetadataChange) void
    public void method_1900(BaseImplementation.class_1147<Snapshots.CommitSnapshotResult> var1, Snapshot var2, SnapshotMetadataChange var3) {
        SnapshotContents var4 = var2.getSnapshotContents();
        boolean var5;
        if(!var4.isClosed()) {
            var5 = true;
        } else {
            var5 = false;
        }

        class_1090.method_5676(var5, "Snapshot already closed");
        class_1056 var6 = var3.method_3260();
        if(var6 != null) {
            var6.method_5525(this.getContext().getCacheDir());
        }

        Contents var7 = var4.getContents();
        var4.close();

        try {
            ((IGamesService)this.gS()).method_479(new GamesClientImpl.SnapshotCommittedBinderCallbacks(var1), var2.getMetadata().getSnapshotId(), var3, var7);
        } catch (RemoteException var9) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_1901(BaseImplementation.class_1147<Players.LoadPlayersResult> var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_468(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int) void
    public void method_1902(BaseImplementation.class_1147<Achievements.UpdateAchievementResult> param1, String param2, int param3) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, int, int, boolean) void
    public void method_1903(BaseImplementation.class_1147<Leaderboards.LoadScoresResult> var1, String var2, int var3, int var4, int var5, boolean var6) {
        try {
            ((IGamesService)this.gS()).method_470(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6);
        } catch (RemoteException var8) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean) void
    public void method_1904(BaseImplementation.class_1147<Players.LoadPlayersResult> var1, String var2, int var3, boolean var4) {
        try {
            ((IGamesService)this.gS()).method_472(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean) void
    public void method_1905(BaseImplementation.class_1147<Players.LoadPlayersResult> var1, String var2, int var3, boolean var4, boolean var5) {
        byte var6 = -1;
        switch(var2.hashCode()) {
            case 156408498:
                if(var2.equals("played_with")) {
                    var6 = 0;
                }
            default:
                switch(var6) {
                    case 0:
                        try {
                            ((IGamesService)this.gS()).method_555(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4, var5);
                            return;
                        } catch (RemoteException var8) {
                            GamesLog.method_6005("GamesClientImpl", "service died");
                            return;
                        }
                    default:
                        throw new IllegalArgumentException("Invalid player collection: " + var2);
                }
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean, boolean, boolean) void
    public void method_1906(BaseImplementation.class_1147<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7) {
        try {
            ((IGamesService)this.gS()).method_474(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5, var6, var7);
        } catch (RemoteException var9) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, int[]) void
    public void method_1907(BaseImplementation.class_1147<TurnBasedMultiplayer.LoadMatchesResult> var1, String var2, int var3, int[] var4) {
        try {
            ((IGamesService)this.gS()).method_475(new GamesClientImpl.TurnBasedMatchesLoadedBinderCallbacks(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, long, java.lang.String) void
    public void method_1908(BaseImplementation.class_1147<Leaderboards.SubmitScoreResult> param1, String param2, long param3, String param5) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String) void
    public void method_1909(BaseImplementation.class_1147<TurnBasedMultiplayer.LeaveMatchResult> var1, String var2, String var3) {
        try {
            ((IGamesService)this.gS()).method_543(new GamesClientImpl.TurnBasedMatchLeftBinderCallbacks(var1), var2, var3);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, int, int) void
    public void method_1910(BaseImplementation.class_1147<Leaderboards.LoadPlayerScoreResult> var1, String var2, String var3, int var4, int var5) {
        try {
            ((IGamesService)this.gS()).method_481(new GamesClientImpl.PlayerLeaderboardScoreLoadedBinderCallback(var1), var2, var3, var4, var5);
        } catch (RemoteException var7) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, int, int, int) void
    public void method_1911(BaseImplementation.class_1147<Requests.LoadRequestsResult> var1, String var2, String var3, int var4, int var5, int var6) {
        try {
            ((IGamesService)this.gS()).method_482(new GamesClientImpl.RequestsLoadedBinderCallbacks(var1), var2, var3, var4, var5, var6);
        } catch (RemoteException var8) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, int, int, int, boolean) void
    public void method_1912(BaseImplementation.class_1147<Leaderboards.LoadScoresResult> var1, String var2, String var3, int var4, int var5, int var6, boolean var7) {
        try {
            ((IGamesService)this.gS()).method_483(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6, var7);
        } catch (RemoteException var9) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, int, boolean, boolean) void
    public void method_1913(BaseImplementation.class_1147<Players.LoadPlayersResult> var1, String var2, String var3, int var4, boolean var5, boolean var6) {
        byte var7 = -1;
        switch(var2.hashCode()) {
            case -1049482625:
                if(var2.equals("nearby")) {
                    var7 = 2;
                }
                break;
            case 156408498:
                if(var2.equals("played_with")) {
                    var7 = 1;
                }
                break;
            case 782949780:
                if(var2.equals("circled")) {
                    var7 = 0;
                }
        }

        switch(var7) {
            case 0:
            case 1:
            case 2:
                try {
                    ((IGamesService)this.gS()).method_484(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4, var5, var6);
                    return;
                } catch (RemoteException var9) {
                    GamesLog.method_6005("GamesClientImpl", "service died");
                    return;
                }
            default:
                throw new IllegalArgumentException("Invalid player collection: " + var2);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChange, com.google.android.gms.games.snapshot.SnapshotContents) void
    public void method_1914(BaseImplementation.class_1147<Snapshots.OpenSnapshotResult> var1, String var2, String var3, SnapshotMetadataChange var4, SnapshotContents var5) {
        boolean var6;
        if(!var5.isClosed()) {
            var6 = true;
        } else {
            var6 = false;
        }

        class_1090.method_5676(var6, "SnapshotContents already closed");
        class_1056 var7 = var4.method_3260();
        if(var7 != null) {
            var7.method_5525(this.getContext().getCacheDir());
        }

        Contents var8 = var5.getContents();
        var5.close();

        try {
            ((IGamesService)this.gS()).method_485(new GamesClientImpl.SnapshotOpenedBinderCallbacks(var1), var2, var3, var4, var8);
        } catch (RemoteException var10) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, boolean) void
    public void method_1915(BaseImplementation.class_1147<Leaderboards.LeaderboardMetadataResult> var1, String var2, String var3, boolean var4) {
        try {
            ((IGamesService)this.gS()).method_521(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, boolean, java.lang.String[]) void
    public void method_1916(BaseImplementation.class_1147<Quests.LoadQuestsResult> var1, String var2, String var3, boolean var4, String[] var5) {
        try {
            this.field_900.flush();
            ((IGamesService)this.gS()).method_489(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), var2, var3, var5, var4);
        } catch (RemoteException var7) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, int[], int, boolean) void
    public void method_1917(BaseImplementation.class_1147<Quests.LoadQuestsResult> var1, String var2, String var3, int[] var4, int var5, boolean var6) {
        try {
            this.field_900.flush();
            ((IGamesService)this.gS()).method_487(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), var2, var3, var4, var5, var6);
        } catch (RemoteException var8) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, java.lang.String[]) void
    public void method_1918(BaseImplementation.class_1147<Requests.UpdateRequestsResult> var1, String var2, String var3, String[] var4) {
        try {
            ((IGamesService)this.gS()).method_488(new GamesClientImpl.RequestsUpdatedBinderCallbacks(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, boolean) void
    public void method_1919(BaseImplementation.class_1147<Leaderboards.LeaderboardMetadataResult> var1, String var2, boolean var3) {
        try {
            ((IGamesService)this.gS()).method_545(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2, var3);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, byte[], java.lang.String, com.google.android.gms.games.multiplayer.ParticipantResult[]) void
    public void method_1920(BaseImplementation.class_1147<TurnBasedMultiplayer.UpdateMatchResult> var1, String var2, byte[] var3, String var4, ParticipantResult[] var5) {
        try {
            ((IGamesService)this.gS()).method_491(new GamesClientImpl.TurnBasedMatchUpdatedBinderCallbacks(var1), var2, var3, var4, var5);
        } catch (RemoteException var7) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, byte[], com.google.android.gms.games.multiplayer.ParticipantResult[]) void
    public void method_1921(BaseImplementation.class_1147<TurnBasedMultiplayer.UpdateMatchResult> var1, String var2, byte[] var3, ParticipantResult[] var4) {
        try {
            ((IGamesService)this.gS()).method_492(new GamesClientImpl.TurnBasedMatchUpdatedBinderCallbacks(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String[], int, byte[], int) void
    public void method_1922(BaseImplementation.class_1147<Requests.SendRequestResult> var1, String var2, String[] var3, int var4, byte[] var5, int var6) {
        try {
            ((IGamesService)this.gS()).method_494(new GamesClientImpl.RequestSentBinderCallbacks(var1), var2, var3, var4, var5, var6);
        } catch (RemoteException var8) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
    public void method_1923(BaseImplementation.class_1147<Players.LoadPlayersResult> var1, boolean var2) {
        try {
            ((IGamesService)this.gS()).method_546(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, boolean, android.os.Bundle) void
    public void method_1924(BaseImplementation.class_1147<Status> var1, boolean var2, Bundle var3) {
        try {
            ((IGamesService)this.gS()).method_496(new GamesClientImpl.ContactSettingsUpdatedBinderCallback(var1), var2, var3);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, boolean, java.lang.String[]) void
    public void method_1925(BaseImplementation.class_1147<Events.LoadEventsResult> var1, boolean var2, String... var3) {
        try {
            this.field_900.flush();
            ((IGamesService)this.gS()).method_497(new GamesClientImpl.EventsLoadedBinderCallback(var1), var2, var3);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int[], int, boolean) void
    public void method_1926(BaseImplementation.class_1147<Quests.LoadQuestsResult> var1, int[] var2, int var3, boolean var4) {
        try {
            this.field_900.flush();
            ((IGamesService)this.gS()).method_499(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String[]) void
    public void method_1927(BaseImplementation.class_1147<Players.LoadPlayersResult> var1, String[] var2) {
        try {
            ((IGamesService)this.gS()).method_547(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        String var3 = this.getContext().getResources().getConfiguration().locale.toString();
        Bundle var4 = new Bundle();
        var4.putBoolean("com.google.android.gms.games.key.isHeadless", this.field_899.field_2073);
        var4.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.field_899.field_2074);
        var4.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.field_899.field_2075);
        var4.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.field_899.field_2076);
        var4.putInt("com.google.android.gms.games.key.sdkVariant", this.field_899.field_2077);
        var4.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.field_899.field_2078);
        var4.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.field_899.field_2079);
        var1.method_964(var2, 6171000, this.getContext().getPackageName(), this.field_897, this.gR(), this.field_901, this.field_905.method_4805(), var3, var4);
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.OnInvitationReceivedListener) void
    public void method_1928(OnInvitationReceivedListener var1) {
        try {
            GamesClientImpl.InvitationReceivedBinderCallback var2 = new GamesClientImpl.InvitationReceivedBinderCallback(var1);
            ((IGamesService)this.gS()).method_463(var2, this.field_898);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomConfig) void
    public void method_1929(RoomConfig var1) {
        this.method_1886();

        try {
            GamesClientImpl.RoomBinderCallbacks var2 = new GamesClientImpl.RoomBinderCallbacks(var1.getRoomUpdateListener(), var1.getRoomStatusUpdateListener(), var1.getMessageReceivedListener());
            ((IGamesService)this.gS()).method_466(var2, this.field_907, var1.getVariant(), var1.getInvitedPlayerIds(), var1.getAutoMatchCriteria(), var1.isSocketEnabled(), this.field_898);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, java.lang.String) void
    public void method_1930(RoomUpdateListener var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_540(new GamesClientImpl.RoomBinderCallbacks(var1), var2);
            this.method_1886();
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener) void
    public void method_1931(OnTurnBasedMatchUpdateReceivedListener var1) {
        try {
            GamesClientImpl.MatchUpdateReceivedBinderCallback var2 = new GamesClientImpl.MatchUpdateReceivedBinderCallback(var1);
            ((IGamesService)this.gS()).method_509(var2, this.field_898);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.games.quest.QuestUpdateListener) void
    public void method_1932(QuestUpdateListener var1) {
        try {
            GamesClientImpl.QuestUpdateBinderCallback var2 = new GamesClientImpl.QuestUpdateBinderCallback(var1);
            ((IGamesService)this.gS()).method_552(var2, this.field_898);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.games.request.OnRequestReceivedListener) void
    public void method_1933(OnRequestReceivedListener var1) {
        try {
            GamesClientImpl.RequestReceivedBinderCallback var2 = new GamesClientImpl.RequestReceivedBinderCallback(var1);
            ((IGamesService)this.gS()).method_538(var2, this.field_898);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: a (com.google.android.gms.games.snapshot.Snapshot) void
    public void method_1934(Snapshot var1) {
        SnapshotContents var2 = var1.getSnapshotContents();
        boolean var3;
        if(!var2.isClosed()) {
            var3 = true;
        } else {
            var3 = false;
        }

        class_1090.method_5676(var3, "Snapshot already closed");
        Contents var4 = var2.getContents();
        var2.close();

        try {
            ((IGamesService)this.gS()).method_455(var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: az (android.os.IBinder) com.google.android.gms.games.internal.IGamesService
    protected IGamesService method_1935(IBinder var1) {
        return IGamesService.Stub.method_5204(var1);
    }

    // $FF: renamed from: b (int, int, boolean) android.content.Intent
    public Intent method_1936(int var1, int var2, boolean var3) {
        try {
            Intent var5 = ((IGamesService)this.gS()).method_504(var1, var2, var3);
            return var5;
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: b (int[]) android.content.Intent
    public Intent method_1937(int[] var1) {
        try {
            Intent var3 = ((IGamesService)this.gS()).method_505(var1);
            return var3;
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_1938(BaseImplementation.class_1147<Status> var1) {
        try {
            this.field_900.flush();
            ((IGamesService)this.gS()).method_456(new GamesClientImpl.SignOutCompleteBinderCallbacks(var1));
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, int, boolean, boolean) void
    public void method_1939(BaseImplementation.class_1147<Players.LoadPlayersResult> var1, int var2, boolean var3, boolean var4) {
        try {
            ((IGamesService)this.gS()).method_508(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_1940(BaseImplementation.class_1147<Achievements.UpdateAchievementResult> param1, String param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int) void
    public void method_1941(BaseImplementation.class_1147<Achievements.UpdateAchievementResult> param1, String param2, int param3) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, int, int, boolean) void
    public void method_1942(BaseImplementation.class_1147<Leaderboards.LoadScoresResult> var1, String var2, int var3, int var4, int var5, boolean var6) {
        try {
            ((IGamesService)this.gS()).method_513(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6);
        } catch (RemoteException var8) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean) void
    public void method_1943(BaseImplementation.class_1147<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5) {
        try {
            ((IGamesService)this.gS()).method_473(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
        } catch (RemoteException var7) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String) void
    public void method_1944(BaseImplementation.class_1147<Quests.ClaimMilestoneResult> var1, String var2, String var3) {
        try {
            this.field_900.flush();
            ((IGamesService)this.gS()).method_570(new GamesClientImpl.QuestMilestoneClaimBinderCallbacks(var1, var3), var2, var3);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, int, int, int, boolean) void
    public void method_1945(BaseImplementation.class_1147<Leaderboards.LoadScoresResult> var1, String var2, String var3, int var4, int var5, int var6, boolean var7) {
        try {
            ((IGamesService)this.gS()).method_519(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6, var7);
        } catch (RemoteException var9) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, boolean) void
    public void method_1946(BaseImplementation.class_1147<Achievements.LoadAchievementsResult> var1, String var2, String var3, boolean var4) {
        try {
            ((IGamesService)this.gS()).method_486(new GamesClientImpl.AchievementsLoadedBinderCallback(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, boolean) void
    public void method_1947(BaseImplementation.class_1147<Snapshots.OpenSnapshotResult> var1, String var2, boolean var3) {
        try {
            ((IGamesService)this.gS()).method_565(new GamesClientImpl.SnapshotOpenedBinderCallbacks(var1), var2, var3);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
    public void method_1948(BaseImplementation.class_1147<Leaderboards.LeaderboardMetadataResult> var1, boolean var2) {
        try {
            ((IGamesService)this.gS()).method_523(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, boolean, java.lang.String[]) void
    public void method_1949(BaseImplementation.class_1147<Quests.LoadQuestsResult> var1, boolean var2, String[] var3) {
        try {
            this.field_900.flush();
            ((IGamesService)this.gS()).method_501(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), var3, var2);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String[]) void
    public void method_1950(BaseImplementation.class_1147<Requests.UpdateRequestsResult> var1, String[] var2) {
        try {
            ((IGamesService)this.gS()).method_500(new GamesClientImpl.RequestsUpdatedBinderCallbacks(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: b (com.google.android.gms.games.multiplayer.realtime.RoomConfig) void
    public void method_1951(RoomConfig var1) {
        this.method_1886();

        try {
            GamesClientImpl.RoomBinderCallbacks var2 = new GamesClientImpl.RoomBinderCallbacks(var1.getRoomUpdateListener(), var1.getRoomStatusUpdateListener(), var1.getMessageReceivedListener());
            ((IGamesService)this.gS()).method_467(var2, this.field_907, var1.getInvitationId(), var1.isSocketEnabled(), this.field_898);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: bC (java.lang.String) android.content.Intent
    public Intent method_1952(String var1) {
        try {
            Intent var3 = ((IGamesService)this.gS()).method_526(var1);
            return var3;
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: bD (java.lang.String) void
    public void method_1953(String var1) {
        try {
            ((IGamesService)this.gS()).method_502(var1, this.field_905.method_4805(), this.field_905.method_4804());
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: bx (java.lang.String) android.content.Intent
    public Intent method_1954(String var1) {
        try {
            Intent var3 = ((IGamesService)this.gS()).method_534(var1);
            return var3;
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: by (java.lang.String) void
    public void method_1955(String var1) {
        try {
            ((IGamesService)this.gS()).method_532(var1);
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, int) void
    public void method_1956(BaseImplementation.class_1147<Invitations.LoadInvitationsResult> var1, int var2) {
        try {
            ((IGamesService)this.gS()).method_457(new GamesClientImpl.InvitationsLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, int, boolean, boolean) void
    public void method_1957(BaseImplementation.class_1147<Players.LoadPlayersResult> var1, int var2, boolean var3, boolean var4) {
        try {
            ((IGamesService)this.gS()).method_537(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_1958(BaseImplementation.class_1147<Achievements.UpdateAchievementResult> param1, String param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int) void
    public void method_1959(BaseImplementation.class_1147<Players.LoadXpStreamResult> var1, String var2, int var3) {
        try {
            ((IGamesService)this.gS()).method_512(new GamesClientImpl.PlayerXpStreamLoadedBinderCallback(var1), var2, var3);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean) void
    public void method_1960(BaseImplementation.class_1147<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5) {
        try {
            ((IGamesService)this.gS()).method_563(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
        } catch (RemoteException var7) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String) void
    public void method_1961(BaseImplementation.class_1147<TurnBasedMultiplayer.InitiateMatchResult> var1, String var2, String var3) {
        try {
            ((IGamesService)this.gS()).method_556(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2, var3);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, boolean) void
    public void method_1962(BaseImplementation.class_1147<Snapshots.LoadSnapshotsResult> var1, String var2, String var3, boolean var4) {
        try {
            ((IGamesService)this.gS()).method_544(new GamesClientImpl.SnapshotsLoadedBinderCallbacks(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, boolean) void
    public void method_1963(BaseImplementation.class_1147<Leaderboards.LeaderboardMetadataResult> var1, String var2, boolean var3) {
        try {
            ((IGamesService)this.gS()).method_557(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2, var3);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
    public void method_1964(BaseImplementation.class_1147<Achievements.LoadAchievementsResult> var1, boolean var2) {
        try {
            ((IGamesService)this.gS()).method_495(new GamesClientImpl.AchievementsLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String[]) void
    public void method_1965(BaseImplementation.class_1147<Requests.UpdateRequestsResult> var1, String[] var2) {
        try {
            ((IGamesService)this.gS()).method_524(new GamesClientImpl.RequestsUpdatedBinderCallbacks(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: c (java.lang.String[]) void
    protected void method_1816(String... var1) {
        int var2 = 0;
        boolean var3 = false;

        boolean var4;
        for(var4 = false; var2 < var1.length; ++var2) {
            String var6 = var1[var2];
            if(var6.equals("https://www.googleapis.com/auth/games")) {
                var4 = true;
            } else if(var6.equals("https://www.googleapis.com/auth/games.firstparty")) {
                var3 = true;
            }
        }

        if(var3) {
            boolean var5;
            if(!var4) {
                var5 = true;
            } else {
                var5 = false;
            }

            class_1090.method_5677(var5, "Cannot have both %s and %s!", new Object[] {"https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty"});
        } else {
            class_1090.method_5677(var4, "Games APIs requires %s to function.", new Object[] {"https://www.googleapis.com/auth/games"});
        }
    }

    public void connect() {
        this.method_1885();
        super.connect();
    }

    // $FF: renamed from: d (byte[], java.lang.String) int
    public int method_1966(byte[] var1, String var2) {
        try {
            int var4 = ((IGamesService)this.gS()).method_503(var1, var2, (String[])null);
            return var4;
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return -1;
        }
    }

    // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, int, boolean, boolean) void
    public void method_1967(BaseImplementation.class_1147<Players.LoadPlayersResult> var1, int var2, boolean var3, boolean var4) {
        try {
            ((IGamesService)this.gS()).method_561(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_1968(BaseImplementation.class_1147<TurnBasedMultiplayer.InitiateMatchResult> var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_609(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int) void
    public void method_1969(BaseImplementation.class_1147<Players.LoadXpStreamResult> var1, String var2, int var3) {
        try {
            ((IGamesService)this.gS()).method_541(new GamesClientImpl.PlayerXpStreamLoadedBinderCallback(var1), var2, var3);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean) void
    public void method_1970(BaseImplementation.class_1147<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5) {
        try {
            ((IGamesService)this.gS()).method_569(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
        } catch (RemoteException var7) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String) void
    public void method_1971(BaseImplementation.class_1147<TurnBasedMultiplayer.InitiateMatchResult> var1, String var2, String var3) {
        try {
            ((IGamesService)this.gS()).method_564(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2, var3);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, boolean) void
    public void method_1972(BaseImplementation.class_1147<Notifications.GameMuteStatusChangeResult> var1, String var2, boolean var3) {
        try {
            ((IGamesService)this.gS()).method_490(new GamesClientImpl.GameMuteStatusChangedBinderCallback(var1), var2, var3);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
    public void method_1973(BaseImplementation.class_1147<Events.LoadEventsResult> var1, boolean var2) {
        try {
            this.field_900.flush();
            ((IGamesService)this.gS()).method_571(new GamesClientImpl.EventsLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: dB (int) void
    public void method_1974(int var1) {
        this.field_905.setGravity(var1);
    }

    // $FF: renamed from: dC (int) void
    public void method_1975(int var1) {
        try {
            ((IGamesService)this.gS()).method_559(var1);
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    public void disconnect() {
        this.field_906 = false;
        if(this.isConnected()) {
            try {
                IGamesService var2 = (IGamesService)this.gS();
                var2.method_607();
                this.field_900.flush();
                var2.method_617(this.field_898);
            } catch (RemoteException var3) {
                GamesLog.method_6005("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }

        this.method_1886();
        super.disconnect();
    }

    // $FF: renamed from: e (com.google.android.gms.common.api.BaseImplementation$b, int, boolean, boolean) void
    public void method_1976(BaseImplementation.class_1147<Players.LoadPlayersResult> var1, int var2, boolean var3, boolean var4) {
        try {
            ((IGamesService)this.gS()).method_551(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
        } catch (RemoteException var6) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: e (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_1977(BaseImplementation.class_1147<TurnBasedMultiplayer.InitiateMatchResult> var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_610(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: e (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int) void
    public void method_1978(BaseImplementation.class_1147<Invitations.LoadInvitationsResult> var1, String var2, int var3) {
        try {
            ((IGamesService)this.gS()).method_515(new GamesClientImpl.InvitationsLoadedBinderCallback(var1), var2, var3, false);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: e (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean) void
    public void method_1979(BaseImplementation.class_1147<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5) {
        try {
            ((IGamesService)this.gS()).method_542(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
        } catch (RemoteException var7) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: e (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
    public void method_1980(BaseImplementation.class_1147<Snapshots.LoadSnapshotsResult> var1, boolean var2) {
        try {
            ((IGamesService)this.gS()).method_558(new GamesClientImpl.SnapshotsLoadedBinderCallbacks(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: f (com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_1981(BaseImplementation.class_1147<GamesMetadata.LoadGamesResult> var1) {
        try {
            ((IGamesService)this.gS()).method_550(new GamesClientImpl.GamesLoadedBinderCallback(var1));
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: f (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_1982(BaseImplementation.class_1147<TurnBasedMultiplayer.LeaveMatchResult> var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_613(new GamesClientImpl.TurnBasedMatchLeftBinderCallbacks(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: f (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int) void
    public void method_1983(BaseImplementation.class_1147<Requests.LoadRequestSummariesResult> var1, String var2, int var3) {
        try {
            ((IGamesService)this.gS()).method_469(new GamesClientImpl.RequestSummariesLoadedBinderCallbacks(var1), var2, var3);
        } catch (RemoteException var5) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: f (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean) void
    public void method_1984(BaseImplementation.class_1147<Players.LoadPlayersResult> var1, String var2, int var3, boolean var4, boolean var5) {
        try {
            ((IGamesService)this.gS()).method_516(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4, var5);
        } catch (RemoteException var7) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: f (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
    public void method_1985(BaseImplementation.class_1147<Players.LoadProfileSettingsResult> var1, boolean var2) {
        try {
            ((IGamesService)this.gS()).method_575(new GamesClientImpl.ProfileSettingsLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: fC () android.os.Bundle
    public Bundle method_950() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: g (com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_1986(BaseImplementation.class_1147<Players.LoadOwnerCoverPhotoUrisResult> var1) {
        try {
            ((IGamesService)this.gS()).method_582(new GamesClientImpl.OwnerCoverPhotoUrisLoadedBinderCallback(var1));
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: g (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_1987(BaseImplementation.class_1147<TurnBasedMultiplayer.CancelMatchResult> var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_611(new GamesClientImpl.TurnBasedMatchCanceledBinderCallbacks(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: g (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean) void
    public void method_1988(BaseImplementation.class_1147<Players.LoadPlayersResult> var1, String var2, int var3, boolean var4, boolean var5) {
        try {
            ((IGamesService)this.gS()).method_520(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, (String)null, var3, var4, var5);
        } catch (RemoteException var7) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: g (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
    public void method_1989(BaseImplementation.class_1147<Status> var1, boolean var2) {
        try {
            ((IGamesService)this.gS()).method_579(new GamesClientImpl.ProfileSettingsUpdatedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    // $FF: renamed from: h (com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_1990(BaseImplementation.class_1147<Acls.LoadAclResult> var1) {
        try {
            ((IGamesService)this.gS()).method_578(new GamesClientImpl.NotifyAclLoadedBinderCallback(var1));
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: h (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_1991(BaseImplementation.class_1147<TurnBasedMultiplayer.LoadMatchResult> var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_615(new GamesClientImpl.TurnBasedMatchLoadedBinderCallbacks(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: h (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
    public void method_1992(BaseImplementation.class_1147<Notifications.ContactSettingLoadResult> var1, boolean var2) {
        try {
            ((IGamesService)this.gS()).method_566(new GamesClientImpl.ContactSettingsLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: i (com.google.android.gms.common.api.BaseImplementation$b) void
    @Deprecated
    public void method_1993(BaseImplementation.class_1147<Notifications.ContactSettingLoadResult> var1) {
        try {
            ((IGamesService)this.gS()).method_566(new GamesClientImpl.ContactSettingsLoadedBinderCallback(var1), false);
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: i (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_1994(BaseImplementation.class_1147<Quests.AcceptQuestResult> var1, String var2) {
        try {
            this.field_900.flush();
            ((IGamesService)this.gS()).method_628(new GamesClientImpl.QuestAcceptedBinderCallbacks(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.method_1935(var1);
    }

    // $FF: renamed from: j (com.google.android.gms.common.api.BaseImplementation$b) void
    public void method_1995(BaseImplementation.class_1147<Notifications.InboxCountResult> var1) {
        try {
            ((IGamesService)this.gS()).method_626(new GamesClientImpl.InboxCountsLoadedBinderCallback(var1), (String)null);
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: j (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_1996(BaseImplementation.class_1147<Snapshots.DeleteSnapshotResult> var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_620(new GamesClientImpl.SnapshotDeletedBinderCallbacks(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: k (android.view.View) void
    public void method_1997(View var1) {
        this.field_905.method_4806(var1);
    }

    // $FF: renamed from: k (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_1998(BaseImplementation.class_1147<GamesMetadata.LoadExtendedGamesResult> var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_562(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: ka () java.lang.String
    public String method_1999() {
        try {
            String var2 = ((IGamesService)this.gS()).method_591();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: kb () java.lang.String
    public String method_2000() {
        try {
            String var2 = ((IGamesService)this.gS()).method_592();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: kc () com.google.android.gms.games.Player
    public Player method_2001() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: kd () com.google.android.gms.games.Game
    public Game method_2002() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: ke () android.content.Intent
    public Intent method_2003() {
        try {
            Intent var2 = ((IGamesService)this.gS()).method_593();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: kf () android.content.Intent
    public Intent method_2004() {
        try {
            Intent var2 = ((IGamesService)this.gS()).method_594();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: kg () android.content.Intent
    public Intent method_2005() {
        try {
            Intent var2 = ((IGamesService)this.gS()).method_595();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: kh () android.content.Intent
    public Intent method_2006() {
        try {
            Intent var2 = ((IGamesService)this.gS()).method_596();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: ki () void
    public void method_2007() {
        try {
            ((IGamesService)this.gS()).method_619(this.field_898);
        } catch (RemoteException var2) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: kj () void
    public void method_2008() {
        try {
            ((IGamesService)this.gS()).method_622(this.field_898);
        } catch (RemoteException var2) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: kk () void
    public void method_2009() {
        try {
            ((IGamesService)this.gS()).method_627(this.field_898);
        } catch (RemoteException var2) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: kl () void
    public void method_2010() {
        try {
            ((IGamesService)this.gS()).method_625(this.field_898);
        } catch (RemoteException var2) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: km () android.content.Intent
    public Intent method_2011() {
        try {
            Intent var2 = ((IGamesService)this.gS()).method_597();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: kn () android.content.Intent
    public Intent method_2012() {
        try {
            Intent var2 = ((IGamesService)this.gS()).method_598();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: ko () int
    public int method_2013() {
        try {
            int var2 = ((IGamesService)this.gS()).method_599();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return 4368;
        }
    }

    // $FF: renamed from: kp () java.lang.String
    public String method_2014() {
        try {
            String var2 = ((IGamesService)this.gS()).method_600();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: kq () int
    public int method_2015() {
        try {
            int var2 = ((IGamesService)this.gS()).method_601();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return -1;
        }
    }

    // $FF: renamed from: kr () android.content.Intent
    public Intent method_2016() {
        try {
            Intent var2 = ((IGamesService)this.gS()).method_602();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return null;
        }
    }

    // $FF: renamed from: ks () int
    public int method_2017() {
        try {
            int var2 = ((IGamesService)this.gS()).method_603();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return -1;
        }
    }

    // $FF: renamed from: kt () int
    public int method_2018() {
        try {
            int var2 = ((IGamesService)this.gS()).method_604();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return -1;
        }
    }

    // $FF: renamed from: ku () int
    public int method_2019() {
        try {
            int var2 = ((IGamesService)this.gS()).method_605();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return -1;
        }
    }

    // $FF: renamed from: kv () int
    public int method_2020() {
        try {
            int var2 = ((IGamesService)this.gS()).method_606();
            return var2;
        } catch (RemoteException var3) {
            GamesLog.method_6005("GamesClientImpl", "service died");
            return -1;
        }
    }

    // $FF: renamed from: kx () void
    public void method_2021() {
        if(this.isConnected()) {
            try {
                ((IGamesService)this.gS()).method_607();
            } catch (RemoteException var2) {
                GamesLog.method_6005("GamesClientImpl", "service died");
                return;
            }
        }

    }

    // $FF: renamed from: l (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_2022(BaseImplementation.class_1147<GamesMetadata.LoadGameInstancesResult> var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_568(new GamesClientImpl.GameInstancesLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: m (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_2023(BaseImplementation.class_1147<GamesMetadata.LoadGameSearchSuggestionsResult> var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_618(new GamesClientImpl.GameSearchSuggestionsLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: n (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_2024(BaseImplementation.class_1147<Players.LoadXpForGameCategoriesResult> var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_623(new GamesClientImpl.PlayerXpForGameCategoriesLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: n (java.lang.String, int) void
    public void method_2025(String var1, int var2) {
        this.field_900.method_3074(var1, var2);
    }

    // $FF: renamed from: o (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_2026(BaseImplementation.class_1147<Invitations.LoadInvitationsResult> var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_584(new GamesClientImpl.InvitationsLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: o (java.lang.String, int) void
    public void method_2027(String var1, int var2) {
        try {
            ((IGamesService)this.gS()).method_614(var1, var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    public void onConnected(Bundle var1) {
        if(this.field_906) {
            this.field_905.method_4803();
            this.field_906 = false;
        }

    }

    public void onConnectionFailed(ConnectionResult var1) {
        this.field_906 = false;
    }

    public void onConnectionSuspended(int var1) {
    }

    // $FF: renamed from: p (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_2028(BaseImplementation.class_1147<Status> var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_583(new GamesClientImpl.NotifyAclUpdatedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: p (java.lang.String, int) void
    public void method_2029(String var1, int var2) {
        try {
            ((IGamesService)this.gS()).method_616(var1, var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: q (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
    public void method_2030(BaseImplementation.class_1147<Notifications.GameMuteStatusLoadResult> var1, String var2) {
        try {
            ((IGamesService)this.gS()).method_581(new GamesClientImpl.GameMuteStatusLoadedBinderCallback(var1), var2);
        } catch (RemoteException var4) {
            GamesLog.method_6005("GamesClientImpl", "service died");
        }
    }

    // $FF: renamed from: t (java.lang.String, java.lang.String) com.google.android.gms.games.multiplayer.realtime.RealTimeSocket
    public RealTimeSocket method_2031(String var1, String var2) {
        if(var2 != null && ParticipantUtils.method_4388(var2)) {
            RealTimeSocket var3 = (RealTimeSocket)this.field_902.get(var2);
            if(var3 == null || var3.isClosed()) {
                var3 = this.method_1884(var2);
            }

            return var3;
        } else {
            throw new IllegalArgumentException("Bad participant ID");
        }
    }

    private abstract class AbstractPeerStatusCallback extends GamesClientImpl.AbstractRoomStatusCallback {
        // $FF: renamed from: WD java.util.ArrayList
        private final ArrayList<String> field_1897 = new ArrayList();

        AbstractPeerStatusCallback(RoomStatusUpdateListener var2, DataHolder var3, String[] var4) {
            super();
            int var5 = 0;

            for(int var6 = var4.length; var5 < var6; ++var5) {
                this.field_1897.add(var4[var5]);
            }

        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
        protected void method_2941(RoomStatusUpdateListener var1, Room var2) {
            this.method_2942(var1, var2, this.field_1897);
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
        protected abstract void method_2942(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3);
    }

    private abstract class AbstractRoomCallback extends com/google/android/gms/common/internal/e<IGamesService>.d<RoomUpdateListener> {
        AbstractRoomCallback(RoomUpdateListener var2, DataHolder var3) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.common.data.DataHolder) void
        protected void method_2943(RoomUpdateListener var1, DataHolder var2) {
            this.method_2944(var1, GamesClientImpl.this.method_1880(var2), var2.getStatusCode());
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, int) void
        protected abstract void method_2944(RoomUpdateListener var1, Room var2, int var3);
    }

    private abstract class AbstractRoomStatusCallback extends com/google/android/gms/common/internal/e<IGamesService>.d<RoomStatusUpdateListener> {
        AbstractRoomStatusCallback(RoomStatusUpdateListener var2, DataHolder var3) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.common.data.DataHolder) void
        protected void method_2940(RoomStatusUpdateListener var1, DataHolder var2) {
            this.method_2941(var1, GamesClientImpl.this.method_1880(var2));
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
        protected abstract void method_2941(RoomStatusUpdateListener var1, Room var2);
    }

    private static final class AcceptQuestResultImpl extends class_491 implements Quests.AcceptQuestResult {
        // $FF: renamed from: WE com.google.android.gms.games.quest.Quest
        private final Quest field_2020;

        AcceptQuestResultImpl(DataHolder var1) {
            super(var1);
            QuestBuffer var2 = new QuestBuffer(var1);

            try {
                if(var2.getCount() > 0) {
                    this.field_2020 = new QuestEntity((Quest)var2.get(0));
                } else {
                    this.field_2020 = null;
                }
            } finally {
                var2.release();
            }

        }

        public Quest getQuest() {
            return this.field_2020;
        }
    }

    private final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Achievements.UpdateAchievementResult> field_1240;

        AchievementUpdatedBinderCallback(BaseImplementation.class_1147<Achievements.UpdateAchievementResult> var1) {
            this.field_1240 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: g (int, java.lang.String) void
        public void method_276(int var1, String var2) {
            this.field_1240.method_120(new GamesClientImpl.UpdateAchievementResultImpl(var1, var2));
        }
    }

    private final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Achievements.LoadAchievementsResult> field_1242;

        AchievementsLoadedBinderCallback(BaseImplementation.class_1147<Achievements.LoadAchievementsResult> var1) {
            this.field_1242 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder) void
        public void method_260(DataHolder var1) {
            this.field_1242.method_120(new GamesClientImpl.LoadAchievementsResultImpl(var1));
        }
    }

    private static final class CancelMatchResultImpl implements TurnBasedMultiplayer.CancelMatchResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4721;
        // $FF: renamed from: WF java.lang.String
        private final String field_4722;

        CancelMatchResultImpl(Status var1, String var2) {
            this.field_4721 = var1;
            this.field_4722 = var2;
        }

        public String getMatchId() {
            return this.field_4722;
        }

        public Status getStatus() {
            return this.field_4721;
        }
    }

    private static final class ClaimMilestoneResultImpl extends class_491 implements Quests.ClaimMilestoneResult {
        // $FF: renamed from: WE com.google.android.gms.games.quest.Quest
        private final Quest field_2004;
        // $FF: renamed from: WG com.google.android.gms.games.quest.Milestone
        private final Milestone field_2005;

        ClaimMilestoneResultImpl(DataHolder param1, String param2) {
            // $FF: Couldn't be decompiled
        }

        public Milestone getMilestone() {
            return this.field_2005;
        }

        public Quest getQuest() {
            return this.field_2004;
        }
    }

    private static final class CommitSnapshotResultImpl extends class_491 implements Snapshots.CommitSnapshotResult {
        // $FF: renamed from: WH com.google.android.gms.games.snapshot.SnapshotMetadata
        private final SnapshotMetadata field_2006;

        CommitSnapshotResultImpl(DataHolder var1) {
            super(var1);
            SnapshotMetadataBuffer var2 = new SnapshotMetadataBuffer(var1);

            try {
                if(var2.getCount() > 0) {
                    this.field_2006 = new SnapshotMetadataEntity(var2.get(0));
                } else {
                    this.field_2006 = null;
                }
            } finally {
                var2.release();
            }

        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.field_2006;
        }
    }

    private final class ConnectedToRoomCallback extends GamesClientImpl.AbstractRoomStatusCallback {
        ConnectedToRoomCallback(RoomStatusUpdateListener var2, DataHolder var3) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
        public void method_2941(RoomStatusUpdateListener var1, Room var2) {
            var1.onConnectedToRoom(var2);
        }
    }

    private static final class ContactSettingLoadResultImpl extends class_491 implements Notifications.ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder var1) {
            super(var1);
        }
    }

    private final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Notifications.ContactSettingLoadResult> field_1283;

        ContactSettingsLoadedBinderCallback(BaseImplementation.class_1147<Notifications.ContactSettingLoadResult> var1) {
            this.field_1283 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: D (com.google.android.gms.common.data.DataHolder) void
        public void method_237(DataHolder var1) {
            this.field_1283.method_120(new GamesClientImpl.ContactSettingLoadResultImpl(var1));
        }
    }

    private final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Status> field_1224;

        ContactSettingsUpdatedBinderCallback(BaseImplementation.class_1147<Status> var1) {
            this.field_1224 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: dy (int) void
        public void method_266(int var1) {
            this.field_1224.method_120(new Status(var1));
        }
    }

    private static final class DeleteSnapshotResultImpl implements Snapshots.DeleteSnapshotResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_718;
        // $FF: renamed from: WI java.lang.String
        private final String field_719;

        DeleteSnapshotResultImpl(int var1, String var2) {
            this.field_718 = new Status(var1);
            this.field_719 = var2;
        }

        public String getSnapshotId() {
            return this.field_719;
        }

        public Status getStatus() {
            return this.field_718;
        }
    }

    private final class DisconnectedFromRoomCallback extends GamesClientImpl.AbstractRoomStatusCallback {
        DisconnectedFromRoomCallback(RoomStatusUpdateListener var2, DataHolder var3) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
        public void method_2941(RoomStatusUpdateListener var1, Room var2) {
            var1.onDisconnectedFromRoom(var2);
        }
    }

    private final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Events.LoadEventsResult> field_1246;

        EventsLoadedBinderCallback(BaseImplementation.class_1147<Events.LoadEventsResult> var1) {
            this.field_1246 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder) void
        public void method_263(DataHolder var1) {
            this.field_1246.method_120(new GamesClientImpl.LoadEventResultImpl(var1));
        }
    }

    private final class ExtendedGamesLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<GamesMetadata.LoadExtendedGamesResult> field_1252;

        ExtendedGamesLoadedBinderCallback(BaseImplementation.class_1147<GamesMetadata.LoadExtendedGamesResult> var1) {
            this.field_1252 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: j (com.google.android.gms.common.data.DataHolder) void
        public void method_282(DataHolder var1) {
            this.field_1252.method_120(new GamesClientImpl.LoadExtendedGamesResultImpl(var1));
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        public GameClientEventIncrementCache() {
            super(GamesClientImpl.this.getContext().getMainLooper(), 1000);
        }

        // $FF: renamed from: q (java.lang.String, int) void
        protected void method_4421(String var1, int var2) {
            try {
                if(GamesClientImpl.this.isConnected()) {
                    ((IGamesService)GamesClientImpl.this.gS()).method_612(var1, var2);
                } else {
                    GamesLog.method_6006("GamesClientImpl", "Unable to increment event " + var1 + " by " + var2 + " because the games client is no longer connected");
                }
            } catch (RemoteException var4) {
                GamesLog.method_6005("GamesClientImpl", "service died");
            }
        }
    }

    private final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<GamesMetadata.LoadGameInstancesResult> field_1305;

        GameInstancesLoadedBinderCallback(BaseImplementation.class_1147<GamesMetadata.LoadGameInstancesResult> var1) {
            this.field_1305 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: k (com.google.android.gms.common.data.DataHolder) void
        public void method_283(DataHolder var1) {
            this.field_1305.method_120(new GamesClientImpl.LoadGameInstancesResultImpl(var1));
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements Notifications.GameMuteStatusChangeResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4593;
        // $FF: renamed from: WJ java.lang.String
        private final String field_4594;
        // $FF: renamed from: WK boolean
        private final boolean field_4595;

        public GameMuteStatusChangeResultImpl(int var1, String var2, boolean var3) {
            this.field_4593 = new Status(var1);
            this.field_4594 = var2;
            this.field_4595 = var3;
        }

        public Status getStatus() {
            return this.field_4593;
        }
    }

    private final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Notifications.GameMuteStatusChangeResult> field_1277;

        GameMuteStatusChangedBinderCallback(BaseImplementation.class_1147<Notifications.GameMuteStatusChangeResult> var1) {
            this.field_1277 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: a (int, java.lang.String, boolean) void
        public void method_251(int var1, String var2, boolean var3) {
            this.field_1277.method_120(new GamesClientImpl.GameMuteStatusChangeResultImpl(var1, var2, var3));
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements Notifications.GameMuteStatusLoadResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_5328;
        // $FF: renamed from: WJ java.lang.String
        private final String field_5329;
        // $FF: renamed from: WK boolean
        private final boolean field_5330;

        public GameMuteStatusLoadResultImpl(DataHolder var1) {
            try {
                this.field_5328 = new Status(var1.getStatusCode());
                if(var1.getCount() > 0) {
                    this.field_5329 = var1.method_5989("external_game_id", 0, 0);
                    this.field_5330 = var1.method_5990("muted", 0, 0);
                } else {
                    this.field_5329 = null;
                    this.field_5330 = false;
                }
            } finally {
                var1.close();
            }

        }

        public Status getStatus() {
            return this.field_5328;
        }
    }

    private final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Notifications.GameMuteStatusLoadResult> field_1230;

        GameMuteStatusLoadedBinderCallback(BaseImplementation.class_1147<Notifications.GameMuteStatusLoadResult> var1) {
            this.field_1230 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: B (com.google.android.gms.common.data.DataHolder) void
        public void method_235(DataHolder var1) {
            this.field_1230.method_120(new GamesClientImpl.GameMuteStatusLoadResultImpl(var1));
        }
    }

    private final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<GamesMetadata.LoadGameSearchSuggestionsResult> field_1236;

        GameSearchSuggestionsLoadedBinderCallback(BaseImplementation.class_1147<GamesMetadata.LoadGameSearchSuggestionsResult> var1) {
            this.field_1236 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: l (com.google.android.gms.common.data.DataHolder) void
        public void method_284(DataHolder var1) {
            this.field_1236.method_120(new GamesClientImpl.LoadGameSearchSuggestionsResultImpl(var1));
        }
    }

    private final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<GamesMetadata.LoadGamesResult> field_1216;

        GamesLoadedBinderCallback(BaseImplementation.class_1147<GamesMetadata.LoadGamesResult> var1) {
            this.field_1216 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: i (com.google.android.gms.common.data.DataHolder) void
        public void method_281(DataHolder var1) {
            this.field_1216.method_120(new GamesClientImpl.LoadGamesResultImpl(var1));
        }
    }

    private static final class InboxCountResultImpl implements Notifications.InboxCountResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_2158;
        // $FF: renamed from: WL android.os.Bundle
        private final Bundle field_2159;

        InboxCountResultImpl(Status var1, Bundle var2) {
            this.field_2158 = var1;
            this.field_2159 = var2;
        }

        public Status getStatus() {
            return this.field_2158;
        }
    }

    private final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Notifications.InboxCountResult> field_1218;

        InboxCountsLoadedBinderCallback(BaseImplementation.class_1147<Notifications.InboxCountResult> var1) {
            this.field_1218 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: f (int, android.os.Bundle) void
        public void method_271(int var1, Bundle var2) {
            var2.setClassLoader(this.getClass().getClassLoader());
            Status var3 = new Status(var1);
            this.field_1218.method_120(new GamesClientImpl.InboxCountResultImpl(var3, var2));
        }
    }

    private static final class InitiateMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder var1) {
            super(var1);
        }
    }

    private final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: WM com.google.android.gms.games.multiplayer.OnInvitationReceivedListener
        private final OnInvitationReceivedListener field_1227;

        InvitationReceivedBinderCallback(OnInvitationReceivedListener var2) {
            this.field_1227 = var2;
        }

        // $FF: renamed from: n (com.google.android.gms.common.data.DataHolder) void
        public void method_286(DataHolder param1) {
            // $FF: Couldn't be decompiled
        }

        public void onInvitationRemoved(String var1) {
            GamesClientImpl.this.a(GamesClientImpl.this.new InvitationRemovedCallback(this.field_1227, var1));
        }
    }

    private final class InvitationReceivedCallback extends com/google/android/gms/common/internal/e<IGamesService>.b<OnInvitationReceivedListener> {
        // $FF: renamed from: WN com.google.android.gms.games.multiplayer.Invitation
        private final Invitation field_1882;

        InvitationReceivedCallback(OnInvitationReceivedListener var2, Invitation var3) {
            super();
            this.field_1882 = var3;
        }

        // $FF: renamed from: b (com.google.android.gms.games.multiplayer.OnInvitationReceivedListener) void
        protected void method_2935(OnInvitationReceivedListener var1) {
            var1.onInvitationReceived(this.field_1882);
        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        protected void method_2915(Object var1) {
            this.method_2935((OnInvitationReceivedListener)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }

    private final class InvitationRemovedCallback extends com/google/android/gms/common/internal/e<IGamesService>.b<OnInvitationReceivedListener> {
        // $FF: renamed from: WO java.lang.String
        private final String field_1878;

        InvitationRemovedCallback(OnInvitationReceivedListener var2, String var3) {
            super();
            this.field_1878 = var3;
        }

        // $FF: renamed from: b (com.google.android.gms.games.multiplayer.OnInvitationReceivedListener) void
        protected void method_2933(OnInvitationReceivedListener var1) {
            var1.onInvitationRemoved(this.field_1878);
        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        protected void method_2915(Object var1) {
            this.method_2933((OnInvitationReceivedListener)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }

    private final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Invitations.LoadInvitationsResult> field_1244;

        InvitationsLoadedBinderCallback(BaseImplementation.class_1147<Invitations.LoadInvitationsResult> var1) {
            this.field_1244 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: m (com.google.android.gms.common.data.DataHolder) void
        public void method_285(DataHolder var1) {
            this.field_1244.method_120(new GamesClientImpl.LoadInvitationsResultImpl(var1));
        }
    }

    private final class JoinedRoomCallback extends GamesClientImpl.AbstractRoomCallback {
        public JoinedRoomCallback(RoomUpdateListener var2, DataHolder var3) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, int) void
        public void method_2944(RoomUpdateListener var1, Room var2, int var3) {
            var1.onJoinedRoom(var3, var2);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends class_491 implements Leaderboards.LeaderboardMetadataResult {
        // $FF: renamed from: WP com.google.android.gms.games.leaderboard.LeaderboardBuffer
        private final LeaderboardBuffer field_2019;

        LeaderboardMetadataResultImpl(DataHolder var1) {
            super(var1);
            this.field_2019 = new LeaderboardBuffer(var1);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.field_2019;
        }
    }

    private final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Leaderboards.LoadScoresResult> field_1234;

        LeaderboardScoresLoadedBinderCallback(BaseImplementation.class_1147<Leaderboards.LoadScoresResult> var1) {
            this.field_1234 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.common.data.DataHolder) void
        public void method_252(DataHolder var1, DataHolder var2) {
            this.field_1234.method_120(new GamesClientImpl.LoadScoresResultImpl(var1, var2));
        }
    }

    private final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Leaderboards.LeaderboardMetadataResult> field_1269;

        LeaderboardsLoadedBinderCallback(BaseImplementation.class_1147<Leaderboards.LeaderboardMetadataResult> var1) {
            this.field_1269 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: e (com.google.android.gms.common.data.DataHolder) void
        public void method_269(DataHolder var1) {
            this.field_1269.method_120(new GamesClientImpl.LeaderboardMetadataResultImpl(var1));
        }
    }

    private static final class LeaveMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder var1) {
            super(var1);
        }
    }

    private final class LeftRoomCallback extends com/google/android/gms/common/internal/e<IGamesService>.b<RoomUpdateListener> {
        // $FF: renamed from: HF int
        private final int field_1863;
        // $FF: renamed from: WQ java.lang.String
        private final String field_1865;

        LeftRoomCallback(RoomUpdateListener var2, int var3, String var4) {
            super();
            this.field_1863 = var3;
            this.field_1865 = var4;
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener) void
        public void method_2927(RoomUpdateListener var1) {
            var1.onLeftRoom(this.field_1863, this.field_1865);
        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        public void method_2915(Object var1) {
            this.method_2927((RoomUpdateListener)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }

    private static final class LoadAchievementsResultImpl extends class_491 implements Achievements.LoadAchievementsResult {
        // $FF: renamed from: WR com.google.android.gms.games.achievement.AchievementBuffer
        private final AchievementBuffer field_1992;

        LoadAchievementsResultImpl(DataHolder var1) {
            super(var1);
            this.field_1992 = new AchievementBuffer(var1);
        }

        public AchievementBuffer getAchievements() {
            return this.field_1992;
        }
    }

    private static final class LoadAclResultImpl extends class_491 implements Acls.LoadAclResult {
        LoadAclResultImpl(DataHolder var1) {
            super(var1);
        }
    }

    private static final class LoadEventResultImpl extends class_491 implements Events.LoadEventsResult {
        // $FF: renamed from: WS com.google.android.gms.games.event.EventBuffer
        private final EventBuffer field_1996;

        LoadEventResultImpl(DataHolder var1) {
            super(var1);
            this.field_1996 = new EventBuffer(var1);
        }

        public EventBuffer getEvents() {
            return this.field_1996;
        }
    }

    private static final class LoadExtendedGamesResultImpl extends class_491 implements GamesMetadata.LoadExtendedGamesResult {
        // $FF: renamed from: WT com.google.android.gms.games.internal.game.ExtendedGameBuffer
        private final ExtendedGameBuffer field_2011;

        LoadExtendedGamesResultImpl(DataHolder var1) {
            super(var1);
            this.field_2011 = new ExtendedGameBuffer(var1);
        }
    }

    private static final class LoadGameInstancesResultImpl extends class_491 implements GamesMetadata.LoadGameInstancesResult {
        // $FF: renamed from: WU com.google.android.gms.games.internal.game.GameInstanceBuffer
        private final GameInstanceBuffer field_2017;

        LoadGameInstancesResultImpl(DataHolder var1) {
            super(var1);
            this.field_2017 = new GameInstanceBuffer(var1);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends class_491 implements GamesMetadata.LoadGameSearchSuggestionsResult {
        LoadGameSearchSuggestionsResultImpl(DataHolder var1) {
            super(var1);
        }
    }

    private static final class LoadGamesResultImpl extends class_491 implements GamesMetadata.LoadGamesResult {
        // $FF: renamed from: WV com.google.android.gms.games.GameBuffer
        private final GameBuffer field_1997;

        LoadGamesResultImpl(DataHolder var1) {
            super(var1);
            this.field_1997 = new GameBuffer(var1);
        }

        public GameBuffer getGames() {
            return this.field_1997;
        }
    }

    private static final class LoadInvitationsResultImpl extends class_491 implements Invitations.LoadInvitationsResult {
        // $FF: renamed from: WW com.google.android.gms.games.multiplayer.InvitationBuffer
        private final InvitationBuffer field_2009;

        LoadInvitationsResultImpl(DataHolder var1) {
            super(var1);
            this.field_2009 = new InvitationBuffer(var1);
        }

        public InvitationBuffer getInvitations() {
            return this.field_2009;
        }
    }

    private static final class LoadMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.LoadMatchResult {
        LoadMatchResultImpl(DataHolder var1) {
            super(var1);
        }
    }

    private static final class LoadMatchesResultImpl implements TurnBasedMultiplayer.LoadMatchesResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_5164;
        // $FF: renamed from: WX com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse
        private final LoadMatchesResponse field_5165;

        LoadMatchesResultImpl(Status var1, Bundle var2) {
            this.field_5164 = var1;
            this.field_5165 = new LoadMatchesResponse(var2);
        }

        public LoadMatchesResponse getMatches() {
            return this.field_5165;
        }

        public Status getStatus() {
            return this.field_5164;
        }

        public void release() {
            this.field_5165.close();
        }
    }

    private static final class LoadOwnerCoverPhotoUrisResultImpl implements Players.LoadOwnerCoverPhotoUrisResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4553;
        // $FF: renamed from: Nh android.os.Bundle
        private final Bundle field_4554;

        LoadOwnerCoverPhotoUrisResultImpl(int var1, Bundle var2) {
            this.field_4553 = new Status(var1);
            this.field_4554 = var2;
        }

        public Status getStatus() {
            return this.field_4553;
        }
    }

    private static final class LoadPlayerScoreResultImpl extends class_491 implements Leaderboards.LoadPlayerScoreResult {
        // $FF: renamed from: WY com.google.android.gms.games.leaderboard.LeaderboardScoreEntity
        private final LeaderboardScoreEntity field_2018;

        LoadPlayerScoreResultImpl(DataHolder var1) {
            super(var1);
            LeaderboardScoreBuffer var2 = new LeaderboardScoreBuffer(var1);

            try {
                if(var2.getCount() > 0) {
                    this.field_2018 = (LeaderboardScoreEntity)var2.get(0).freeze();
                } else {
                    this.field_2018 = null;
                }
            } finally {
                var2.release();
            }

        }

        public LeaderboardScore getScore() {
            return this.field_2018;
        }
    }

    private static final class LoadPlayersResultImpl extends class_491 implements Players.LoadPlayersResult {
        // $FF: renamed from: WZ com.google.android.gms.games.PlayerBuffer
        private final PlayerBuffer field_2010;

        LoadPlayersResultImpl(DataHolder var1) {
            super(var1);
            this.field_2010 = new PlayerBuffer(var1);
        }

        public PlayerBuffer getPlayers() {
            return this.field_2010;
        }
    }

    private static final class LoadProfileSettingsResultImpl extends class_491 implements Players.LoadProfileSettingsResult {
        // $FF: renamed from: Wp boolean
        private final boolean field_1999;
        // $FF: renamed from: Xa boolean
        private final boolean field_2000;

        LoadProfileSettingsResultImpl(DataHolder var1) {
            super(var1);

            try {
                if(var1.getCount() > 0) {
                    int var3 = var1.method_5987(0);
                    this.field_1999 = var1.method_5990("profile_visible", 0, var3);
                    this.field_2000 = var1.method_5990("profile_visibility_explicitly_set", 0, var3);
                } else {
                    this.field_1999 = true;
                    this.field_2000 = false;
                }
            } finally {
                var1.close();
            }

        }

        public Status getStatus() {
            return this.CM;
        }

        public boolean isProfileVisible() {
            return this.field_1999;
        }

        public boolean isVisibilityExplicitlySet() {
            return this.field_2000;
        }
    }

    private static final class LoadQuestsResultImpl extends class_491 implements Quests.LoadQuestsResult {
        // $FF: renamed from: II com.google.android.gms.common.data.DataHolder
        private final DataHolder field_1998;

        LoadQuestsResultImpl(DataHolder var1) {
            super(var1);
            this.field_1998 = var1;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.field_1998);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends class_491 implements Requests.LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder var1) {
            super(var1);
        }
    }

    private static final class LoadRequestsResultImpl implements Requests.LoadRequestsResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_5357;
        // $FF: renamed from: Xb android.os.Bundle
        private final Bundle field_5358;

        LoadRequestsResultImpl(Status var1, Bundle var2) {
            this.field_5357 = var1;
            this.field_5358 = var2;
        }

        public GameRequestBuffer getRequests(int var1) {
            String var2 = RequestType.method_5265(var1);
            return !this.field_5358.containsKey(var2)?null:new GameRequestBuffer((DataHolder)this.field_5358.get(var2));
        }

        public Status getStatus() {
            return this.field_5357;
        }

        public void release() {
            Iterator var1 = this.field_5358.keySet().iterator();

            while(var1.hasNext()) {
                String var2 = (String)var1.next();
                DataHolder var3 = (DataHolder)this.field_5358.getParcelable(var2);
                if(var3 != null) {
                    var3.close();
                }
            }

        }
    }

    private static final class LoadScoresResultImpl extends class_491 implements Leaderboards.LoadScoresResult {
        // $FF: renamed from: Xc com.google.android.gms.games.leaderboard.LeaderboardEntity
        private final LeaderboardEntity field_1994;
        // $FF: renamed from: Xd com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer
        private final LeaderboardScoreBuffer field_1995;

        LoadScoresResultImpl(DataHolder var1, DataHolder var2) {
            super(var2);
            LeaderboardBuffer var3 = new LeaderboardBuffer(var1);

            try {
                if(var3.getCount() > 0) {
                    this.field_1994 = (LeaderboardEntity)((Leaderboard)var3.get(0)).freeze();
                } else {
                    this.field_1994 = null;
                }
            } finally {
                var3.release();
            }

            this.field_1995 = new LeaderboardScoreBuffer(var2);
        }

        public Leaderboard getLeaderboard() {
            return this.field_1994;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.field_1995;
        }
    }

    private static final class LoadSnapshotsResultImpl extends class_491 implements Snapshots.LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder var1) {
            super(var1);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.II);
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements Players.LoadXpForGameCategoriesResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_4429;
        // $FF: renamed from: Xe java.util.List
        private final List<String> field_4430;
        // $FF: renamed from: Xf android.os.Bundle
        private final Bundle field_4431;

        LoadXpForGameCategoriesResultImpl(Status var1, Bundle var2) {
            this.field_4429 = var1;
            this.field_4430 = var2.getStringArrayList("game_category_list");
            this.field_4431 = var2;
        }

        public Status getStatus() {
            return this.field_4429;
        }
    }

    private static final class LoadXpStreamResultImpl extends class_491 implements Players.LoadXpStreamResult {
        // $FF: renamed from: Xg com.google.android.gms.games.internal.experience.ExperienceEventBuffer
        private final ExperienceEventBuffer field_1993;

        LoadXpStreamResultImpl(DataHolder var1) {
            super(var1);
            this.field_1993 = new ExperienceEventBuffer(var1);
        }
    }

    private final class MatchRemovedCallback extends com/google/android/gms/common/internal/e<IGamesService>.b<OnTurnBasedMatchUpdateReceivedListener> {
        // $FF: renamed from: Xh java.lang.String
        private final String field_1858;

        MatchRemovedCallback(OnTurnBasedMatchUpdateReceivedListener var2, String var3) {
            super();
            this.field_1858 = var3;
        }

        // $FF: renamed from: b (com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener) void
        protected void method_2923(OnTurnBasedMatchUpdateReceivedListener var1) {
            var1.onTurnBasedMatchRemoved(this.field_1858);
        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        protected void method_2915(Object var1) {
            this.method_2923((OnTurnBasedMatchUpdateReceivedListener)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }

    private final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: Xi com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener
        private final OnTurnBasedMatchUpdateReceivedListener field_1233;

        MatchUpdateReceivedBinderCallback(OnTurnBasedMatchUpdateReceivedListener var2) {
            this.field_1233 = var2;
        }

        public void onTurnBasedMatchRemoved(String var1) {
            GamesClientImpl.this.a(GamesClientImpl.this.new MatchRemovedCallback(this.field_1233, var1));
        }

        // $FF: renamed from: t (com.google.android.gms.common.data.DataHolder) void
        public void method_292(DataHolder param1) {
            // $FF: Couldn't be decompiled
        }
    }

    private final class MatchUpdateReceivedCallback extends com/google/android/gms/common/internal/e<IGamesService>.b<OnTurnBasedMatchUpdateReceivedListener> {
        // $FF: renamed from: Xj com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
        private final TurnBasedMatch field_1874;

        MatchUpdateReceivedCallback(OnTurnBasedMatchUpdateReceivedListener var2, TurnBasedMatch var3) {
            super();
            this.field_1874 = var3;
        }

        // $FF: renamed from: b (com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener) void
        protected void method_2931(OnTurnBasedMatchUpdateReceivedListener var1) {
            var1.onTurnBasedMatchReceived(this.field_1874);
        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        protected void method_2915(Object var1) {
            this.method_2931((OnTurnBasedMatchUpdateReceivedListener)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }

    private final class MessageReceivedCallback extends com/google/android/gms/common/internal/e<IGamesService>.b<RealTimeMessageReceivedListener> {
        // $FF: renamed from: Xk com.google.android.gms.games.multiplayer.realtime.RealTimeMessage
        private final RealTimeMessage field_1880;

        MessageReceivedCallback(RealTimeMessageReceivedListener var2, RealTimeMessage var3) {
            super();
            this.field_1880 = var3;
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener) void
        public void method_2934(RealTimeMessageReceivedListener var1) {
            if(var1 != null) {
                var1.onRealTimeMessageReceived(this.field_1880);
            }

        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        public void method_2915(Object var1) {
            this.method_2934((RealTimeMessageReceivedListener)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }

    private final class NearbyPlayerDetectedCallback extends com/google/android/gms/common/internal/e<IGamesService>.b<OnNearbyPlayerDetectedListener> {
        // $FF: renamed from: Xl com.google.android.gms.games.Player
        private final Player field_1866;

        // $FF: renamed from: a (com.google.android.gms.games.OnNearbyPlayerDetectedListener) void
        protected void method_2928(OnNearbyPlayerDetectedListener var1) {
            var1.method_949(this.field_1866);
        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        protected void method_2915(Object var1) {
            this.method_2928((OnNearbyPlayerDetectedListener)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }

    private final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Acls.LoadAclResult> field_1311;

        NotifyAclLoadedBinderCallback(BaseImplementation.class_1147<Acls.LoadAclResult> var1) {
            this.field_1311 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: C (com.google.android.gms.common.data.DataHolder) void
        public void method_236(DataHolder var1) {
            this.field_1311.method_120(new GamesClientImpl.LoadAclResultImpl(var1));
        }
    }

    private final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Status> field_1295;

        NotifyAclUpdatedBinderCallback(BaseImplementation.class_1147<Status> var1) {
            this.field_1295 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: dx (int) void
        public void method_265(int var1) {
            this.field_1295.method_120(new Status(var1));
        }
    }

    private static final class OpenSnapshotResultImpl extends class_491 implements Snapshots.OpenSnapshotResult {
        // $FF: renamed from: Xm com.google.android.gms.games.snapshot.Snapshot
        private final Snapshot field_2012;
        // $FF: renamed from: Xn java.lang.String
        private final String field_2013;
        // $FF: renamed from: Xo com.google.android.gms.games.snapshot.Snapshot
        private final Snapshot field_2014;
        // $FF: renamed from: Xp com.google.android.gms.drive.Contents
        private final Contents field_2015;
        // $FF: renamed from: Xq com.google.android.gms.games.snapshot.SnapshotContents
        private final SnapshotContents field_2016;

        OpenSnapshotResultImpl(DataHolder var1, Contents var2) {
            this(var1, (String)null, var2, (Contents)null, (Contents)null);
        }

        OpenSnapshotResultImpl(DataHolder param1, String param2, Contents param3, Contents param4, Contents param5) {
            // $FF: Couldn't be decompiled
        }

        public String getConflictId() {
            return this.field_2013;
        }

        public Snapshot getConflictingSnapshot() {
            return this.field_2014;
        }

        @Deprecated
        public Contents getResolutionContents() {
            return this.field_2015;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.field_2016;
        }

        public Snapshot getSnapshot() {
            return this.field_2012;
        }
    }

    private final class OwnerCoverPhotoUrisLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Players.LoadOwnerCoverPhotoUrisResult> field_1275;

        OwnerCoverPhotoUrisLoadedBinderCallback(BaseImplementation.class_1147<Players.LoadOwnerCoverPhotoUrisResult> var1) {
            this.field_1275 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: d (int, android.os.Bundle) void
        public void method_262(int var1, Bundle var2) {
            var2.setClassLoader(this.getClass().getClassLoader());
            this.field_1275.method_120(new GamesClientImpl.LoadOwnerCoverPhotoUrisResultImpl(var1, var2));
        }
    }

    private final class P2PConnectedCallback extends com/google/android/gms/common/internal/e<IGamesService>.b<RoomStatusUpdateListener> {
        // $FF: renamed from: Xr java.lang.String
        private final String field_1860;

        P2PConnectedCallback(RoomStatusUpdateListener var2, String var3) {
            super();
            this.field_1860 = var3;
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener) void
        public void method_2924(RoomStatusUpdateListener var1) {
            if(var1 != null) {
                var1.onP2PConnected(this.field_1860);
            }

        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        public void method_2915(Object var1) {
            this.method_2924((RoomStatusUpdateListener)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }

    private final class P2PDisconnectedCallback extends com/google/android/gms/common/internal/e<IGamesService>.b<RoomStatusUpdateListener> {
        // $FF: renamed from: Xr java.lang.String
        private final String field_1868;

        P2PDisconnectedCallback(RoomStatusUpdateListener var2, String var3) {
            super();
            this.field_1868 = var3;
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener) void
        public void method_2929(RoomStatusUpdateListener var1) {
            if(var1 != null) {
                var1.onP2PDisconnected(this.field_1868);
            }

        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        public void method_2915(Object var1) {
            this.method_2929((RoomStatusUpdateListener)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }

    private final class PeerConnectedCallback extends GamesClientImpl.AbstractPeerStatusCallback {
        PeerConnectedCallback(RoomStatusUpdateListener var2, DataHolder var3, String[] var4) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
        protected void method_2942(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
            var1.onPeersConnected(var2, var3);
        }
    }

    private final class PeerDeclinedCallback extends GamesClientImpl.AbstractPeerStatusCallback {
        PeerDeclinedCallback(RoomStatusUpdateListener var2, DataHolder var3, String[] var4) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
        protected void method_2942(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
            var1.onPeerDeclined(var2, var3);
        }
    }

    private final class PeerDisconnectedCallback extends GamesClientImpl.AbstractPeerStatusCallback {
        PeerDisconnectedCallback(RoomStatusUpdateListener var2, DataHolder var3, String[] var4) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
        protected void method_2942(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
            var1.onPeersDisconnected(var2, var3);
        }
    }

    private final class PeerInvitedToRoomCallback extends GamesClientImpl.AbstractPeerStatusCallback {
        PeerInvitedToRoomCallback(RoomStatusUpdateListener var2, DataHolder var3, String[] var4) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
        protected void method_2942(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
            var1.onPeerInvitedToRoom(var2, var3);
        }
    }

    private final class PeerJoinedRoomCallback extends GamesClientImpl.AbstractPeerStatusCallback {
        PeerJoinedRoomCallback(RoomStatusUpdateListener var2, DataHolder var3, String[] var4) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
        protected void method_2942(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
            var1.onPeerJoined(var2, var3);
        }
    }

    private final class PeerLeftRoomCallback extends GamesClientImpl.AbstractPeerStatusCallback {
        PeerLeftRoomCallback(RoomStatusUpdateListener var2, DataHolder var3, String[] var4) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
        protected void method_2942(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
            var1.onPeerLeft(var2, var3);
        }
    }

    private final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Leaderboards.LoadPlayerScoreResult> field_1307;

        PlayerLeaderboardScoreLoadedBinderCallback(BaseImplementation.class_1147<Leaderboards.LoadPlayerScoreResult> var1) {
            this.field_1307 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: E (com.google.android.gms.common.data.DataHolder) void
        public void method_238(DataHolder var1) {
            this.field_1307.method_120(new GamesClientImpl.LoadPlayerScoreResultImpl(var1));
        }
    }

    private final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Players.LoadXpForGameCategoriesResult> field_1248;

        PlayerXpForGameCategoriesLoadedBinderCallback(BaseImplementation.class_1147<Players.LoadXpForGameCategoriesResult> var1) {
            this.field_1248 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: e (int, android.os.Bundle) void
        public void method_268(int var1, Bundle var2) {
            var2.setClassLoader(this.getClass().getClassLoader());
            Status var3 = new Status(var1);
            this.field_1248.method_120(new GamesClientImpl.LoadXpForGameCategoriesResultImpl(var3, var2));
        }
    }

    final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Players.LoadXpStreamResult> field_1267;

        PlayerXpStreamLoadedBinderCallback(BaseImplementation.class_1147<Players.LoadXpStreamResult> var1) {
            this.field_1267 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: P (com.google.android.gms.common.data.DataHolder) void
        public void method_249(DataHolder var1) {
            this.field_1267.method_120(new GamesClientImpl.LoadXpStreamResultImpl(var1));
        }
    }

    private final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Players.LoadPlayersResult> field_1303;

        PlayersLoadedBinderCallback(BaseImplementation.class_1147<Players.LoadPlayersResult> var1) {
            this.field_1303 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: g (com.google.android.gms.common.data.DataHolder) void
        public void method_277(DataHolder var1) {
            this.field_1303.method_120(new GamesClientImpl.LoadPlayersResultImpl(var1));
        }

        // $FF: renamed from: h (com.google.android.gms.common.data.DataHolder) void
        public void method_279(DataHolder var1) {
            this.field_1303.method_120(new GamesClientImpl.LoadPlayersResultImpl(var1));
        }
    }

    final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Players.LoadProfileSettingsResult> field_1263;

        ProfileSettingsLoadedBinderCallback(BaseImplementation.class_1147<Players.LoadProfileSettingsResult> var1) {
            this.field_1263 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: Q (com.google.android.gms.common.data.DataHolder) void
        public void method_250(DataHolder var1) {
            this.field_1263.method_120(new GamesClientImpl.LoadProfileSettingsResultImpl(var1));
        }
    }

    private final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Status> field_1299;

        ProfileSettingsUpdatedBinderCallback(BaseImplementation.class_1147<Status> var1) {
            this.field_1299 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: dz (int) void
        public void method_267(int var1) {
            this.field_1299.method_120(new Status(var1));
        }
    }

    private final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: Xs com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Quests.AcceptQuestResult> field_1316;

        public QuestAcceptedBinderCallbacks(BaseImplementation.class_1147<Quests.AcceptQuestResult> var1) {
            this.field_1316 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: L (com.google.android.gms.common.data.DataHolder) void
        public void method_245(DataHolder var1) {
            this.field_1316.method_120(new GamesClientImpl.AcceptQuestResultImpl(var1));
        }
    }

    private final class QuestCompletedCallback extends com/google/android/gms/common/internal/e<IGamesService>.b<QuestUpdateListener> {
        // $FF: renamed from: WE com.google.android.gms.games.quest.Quest
        private final Quest field_1854;

        QuestCompletedCallback(QuestUpdateListener var2, Quest var3) {
            super();
            this.field_1854 = var3;
        }

        // $FF: renamed from: b (com.google.android.gms.games.quest.QuestUpdateListener) void
        protected void method_2920(QuestUpdateListener var1) {
            var1.onQuestCompleted(this.field_1854);
        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        protected void method_2915(Object var1) {
            this.method_2920((QuestUpdateListener)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }

    private final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: Xt com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Quests.ClaimMilestoneResult> field_1259;
        // $FF: renamed from: Xu java.lang.String
        private final String field_1260;

        public QuestMilestoneClaimBinderCallbacks(BaseImplementation.class_1147<Quests.ClaimMilestoneResult> var1, String var2) {
            this.field_1259 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
            this.field_1260 = (String)class_1090.method_5681(var3, "MilestoneId must not be null");
        }

        // $FF: renamed from: K (com.google.android.gms.common.data.DataHolder) void
        public void method_244(DataHolder var1) {
            this.field_1259.method_120(new GamesClientImpl.ClaimMilestoneResultImpl(var1, this.field_1260));
        }
    }

    private final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: Xv com.google.android.gms.games.quest.QuestUpdateListener
        private final QuestUpdateListener field_1292;

        QuestUpdateBinderCallback(QuestUpdateListener var2) {
            this.field_1292 = var2;
        }

        // $FF: renamed from: S (com.google.android.gms.common.data.DataHolder) com.google.android.gms.games.quest.Quest
        private Quest method_2365(DataHolder param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: M (com.google.android.gms.common.data.DataHolder) void
        public void method_246(DataHolder var1) {
            Quest var2 = this.method_2365(var1);
            if(var2 != null) {
                GamesClientImpl.this.a(GamesClientImpl.this.new QuestCompletedCallback(this.field_1292, var2));
            }

        }
    }

    private final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: Xw com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Quests.LoadQuestsResult> field_1282;

        public QuestsLoadedBinderCallbacks(BaseImplementation.class_1147<Quests.LoadQuestsResult> var1) {
            this.field_1282 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: O (com.google.android.gms.common.data.DataHolder) void
        public void method_248(DataHolder var1) {
            this.field_1282.method_120(new GamesClientImpl.LoadQuestsResultImpl(var1));
        }
    }

    private final class RealTimeMessageSentCallback extends com/google/android/gms/common/internal/e<IGamesService>.b<RealTimeMultiplayer.ReliableMessageSentCallback> {
        // $FF: renamed from: HF int
        private final int field_1869;
        // $FF: renamed from: Xx java.lang.String
        private final String field_1871;
        // $FF: renamed from: Xy int
        private final int field_1872;

        RealTimeMessageSentCallback(RealTimeMultiplayer.ReliableMessageSentCallback var2, int var3, int var4, String var5) {
            super();
            this.field_1869 = var3;
            this.field_1872 = var4;
            this.field_1871 = var5;
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer$ReliableMessageSentCallback) void
        public void method_2930(RealTimeMultiplayer.ReliableMessageSentCallback var1) {
            if(var1 != null) {
                var1.onRealTimeMessageSent(this.field_1869, this.field_1872, this.field_1871);
            }

        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        public void method_2915(Object var1) {
            this.method_2930((RealTimeMultiplayer.ReliableMessageSentCallback)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }

    private final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: Xz com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer$ReliableMessageSentCallback
        final RealTimeMultiplayer.ReliableMessageSentCallback field_1239;

        public RealTimeReliableMessageBinderCallbacks(RealTimeMultiplayer.ReliableMessageSentCallback var2) {
            this.field_1239 = var2;
        }

        // $FF: renamed from: b (int, int, java.lang.String) void
        public void method_256(int var1, int var2, String var3) {
            GamesClientImpl.this.a(GamesClientImpl.this.new RealTimeMessageSentCallback(this.field_1239, var1, var2, var3));
        }
    }

    private final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        // $FF: renamed from: XA com.google.android.gms.games.request.OnRequestReceivedListener
        private final OnRequestReceivedListener field_1223;

        RequestReceivedBinderCallback(OnRequestReceivedListener var2) {
            this.field_1223 = var2;
        }

        // $FF: renamed from: o (com.google.android.gms.common.data.DataHolder) void
        public void method_287(DataHolder param1) {
            // $FF: Couldn't be decompiled
        }

        public void onRequestRemoved(String var1) {
            GamesClientImpl.this.a(GamesClientImpl.this.new RequestRemovedCallback(this.field_1223, var1));
        }
    }

    private final class RequestReceivedCallback extends com/google/android/gms/common/internal/e<IGamesService>.b<OnRequestReceivedListener> {
        // $FF: renamed from: XB com.google.android.gms.games.request.GameRequest
        private final GameRequest field_1876;

        RequestReceivedCallback(OnRequestReceivedListener var2, GameRequest var3) {
            super();
            this.field_1876 = var3;
        }

        // $FF: renamed from: b (com.google.android.gms.games.request.OnRequestReceivedListener) void
        protected void method_2932(OnRequestReceivedListener var1) {
            var1.onRequestReceived(this.field_1876);
        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        protected void method_2915(Object var1) {
            this.method_2932((OnRequestReceivedListener)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }

    private final class RequestRemovedCallback extends com/google/android/gms/common/internal/e<IGamesService>.b<OnRequestReceivedListener> {
        // $FF: renamed from: XC java.lang.String
        private final String field_1884;

        RequestRemovedCallback(OnRequestReceivedListener var2, String var3) {
            super();
            this.field_1884 = var3;
        }

        // $FF: renamed from: b (com.google.android.gms.games.request.OnRequestReceivedListener) void
        protected void method_2936(OnRequestReceivedListener var1) {
            var1.onRequestRemoved(this.field_1884);
        }

        // $FF: renamed from: g (java.lang.Object) void
        // $FF: synthetic method
        protected void method_2915(Object var1) {
            this.method_2936((OnRequestReceivedListener)var1);
        }

        // $FF: renamed from: gT () void
        protected void method_2916() {
        }
    }

    private final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: XD com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Requests.SendRequestResult> field_1286;

        public RequestSentBinderCallbacks(BaseImplementation.class_1147<Requests.SendRequestResult> var1) {
            this.field_1286 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: G (com.google.android.gms.common.data.DataHolder) void
        public void method_240(DataHolder var1) {
            this.field_1286.method_120(new GamesClientImpl.SendRequestResultImpl(var1));
        }
    }

    private final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: XE com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Requests.LoadRequestSummariesResult> field_1310;

        public RequestSummariesLoadedBinderCallbacks(BaseImplementation.class_1147<Requests.LoadRequestSummariesResult> var1) {
            this.field_1310 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: H (com.google.android.gms.common.data.DataHolder) void
        public void method_241(DataHolder var1) {
            this.field_1310.method_120(new GamesClientImpl.LoadRequestSummariesResultImpl(var1));
        }
    }

    private final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: XF com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Requests.LoadRequestsResult> field_1229;

        public RequestsLoadedBinderCallbacks(BaseImplementation.class_1147<Requests.LoadRequestsResult> var1) {
            this.field_1229 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: c (int, android.os.Bundle) void
        public void method_259(int var1, Bundle var2) {
            var2.setClassLoader(this.getClass().getClassLoader());
            Status var3 = new Status(var1);
            this.field_1229.method_120(new GamesClientImpl.LoadRequestsResultImpl(var3, var2));
        }
    }

    private final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: XG com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Requests.UpdateRequestsResult> field_1221;

        public RequestsUpdatedBinderCallbacks(BaseImplementation.class_1147<Requests.UpdateRequestsResult> var1) {
            this.field_1221 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: F (com.google.android.gms.common.data.DataHolder) void
        public void method_239(DataHolder var1) {
            this.field_1221.method_120(new GamesClientImpl.UpdateRequestsResultImpl(var1));
        }
    }

    private final class RoomAutoMatchingCallback extends GamesClientImpl.AbstractRoomStatusCallback {
        RoomAutoMatchingCallback(RoomStatusUpdateListener var2, DataHolder var3) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
        public void method_2941(RoomStatusUpdateListener var1, Room var2) {
            var1.onRoomAutoMatching(var2);
        }
    }

    private final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: XH com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
        private final RoomUpdateListener field_1272;
        // $FF: renamed from: XI com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
        private final RoomStatusUpdateListener field_1273;
        // $FF: renamed from: XJ com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener
        private final RealTimeMessageReceivedListener field_1274;

        public RoomBinderCallbacks(RoomUpdateListener var2) {
            this.field_1272 = (RoomUpdateListener)class_1090.method_5681(var2, "Callbacks must not be null");
            this.field_1273 = null;
            this.field_1274 = null;
        }

        public RoomBinderCallbacks(RoomUpdateListener var2, RoomStatusUpdateListener var3, RealTimeMessageReceivedListener var4) {
            this.field_1272 = (RoomUpdateListener)class_1090.method_5681(var2, "Callbacks must not be null");
            this.field_1273 = var3;
            this.field_1274 = var4;
        }

        // $FF: renamed from: A (com.google.android.gms.common.data.DataHolder) void
        public void method_234(DataHolder var1) {
            GamesClientImpl.this.a(GamesClientImpl.this.new DisconnectedFromRoomCallback(this.field_1273, var1));
        }

        // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
        public void method_255(DataHolder var1, String[] var2) {
            GamesClientImpl.this.a(GamesClientImpl.this.new PeerInvitedToRoomCallback(this.field_1273, var1, var2));
        }

        // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
        public void method_258(DataHolder var1, String[] var2) {
            GamesClientImpl.this.a(GamesClientImpl.this.new PeerJoinedRoomCallback(this.field_1273, var1, var2));
        }

        // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
        public void method_261(DataHolder var1, String[] var2) {
            GamesClientImpl.this.a(GamesClientImpl.this.new PeerLeftRoomCallback(this.field_1273, var1, var2));
        }

        // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
        public void method_264(DataHolder var1, String[] var2) {
            GamesClientImpl.this.a(GamesClientImpl.this.new PeerDeclinedCallback(this.field_1273, var1, var2));
        }

        // $FF: renamed from: e (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
        public void method_270(DataHolder var1, String[] var2) {
            GamesClientImpl.this.a(GamesClientImpl.this.new PeerConnectedCallback(this.field_1273, var1, var2));
        }

        // $FF: renamed from: f (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
        public void method_274(DataHolder var1, String[] var2) {
            GamesClientImpl.this.a(GamesClientImpl.this.new PeerDisconnectedCallback(this.field_1273, var1, var2));
        }

        public void onLeftRoom(int var1, String var2) {
            GamesClientImpl.this.a(GamesClientImpl.this.new LeftRoomCallback(this.field_1272, var1, var2));
        }

        public void onP2PConnected(String var1) {
            GamesClientImpl.this.a(GamesClientImpl.this.new P2PConnectedCallback(this.field_1273, var1));
        }

        public void onP2PDisconnected(String var1) {
            GamesClientImpl.this.a(GamesClientImpl.this.new P2PDisconnectedCallback(this.field_1273, var1));
        }

        public void onRealTimeMessageReceived(RealTimeMessage var1) {
            GamesClientImpl.this.a(GamesClientImpl.this.new MessageReceivedCallback(this.field_1274, var1));
        }

        // $FF: renamed from: u (com.google.android.gms.common.data.DataHolder) void
        public void method_293(DataHolder var1) {
            GamesClientImpl.this.a(GamesClientImpl.this.new RoomCreatedCallback(this.field_1272, var1));
        }

        // $FF: renamed from: v (com.google.android.gms.common.data.DataHolder) void
        public void method_294(DataHolder var1) {
            GamesClientImpl.this.a(GamesClientImpl.this.new JoinedRoomCallback(this.field_1272, var1));
        }

        // $FF: renamed from: w (com.google.android.gms.common.data.DataHolder) void
        public void method_295(DataHolder var1) {
            GamesClientImpl.this.a(GamesClientImpl.this.new RoomConnectingCallback(this.field_1273, var1));
        }

        // $FF: renamed from: x (com.google.android.gms.common.data.DataHolder) void
        public void method_296(DataHolder var1) {
            GamesClientImpl.this.a(GamesClientImpl.this.new RoomAutoMatchingCallback(this.field_1273, var1));
        }

        // $FF: renamed from: y (com.google.android.gms.common.data.DataHolder) void
        public void method_297(DataHolder var1) {
            GamesClientImpl.this.a(GamesClientImpl.this.new RoomConnectedCallback(this.field_1272, var1));
        }

        // $FF: renamed from: z (com.google.android.gms.common.data.DataHolder) void
        public void method_298(DataHolder var1) {
            GamesClientImpl.this.a(GamesClientImpl.this.new ConnectedToRoomCallback(this.field_1273, var1));
        }
    }

    private final class RoomConnectedCallback extends GamesClientImpl.AbstractRoomCallback {
        RoomConnectedCallback(RoomUpdateListener var2, DataHolder var3) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, int) void
        public void method_2944(RoomUpdateListener var1, Room var2, int var3) {
            var1.onRoomConnected(var3, var2);
        }
    }

    private final class RoomConnectingCallback extends GamesClientImpl.AbstractRoomStatusCallback {
        RoomConnectingCallback(RoomStatusUpdateListener var2, DataHolder var3) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
        public void method_2941(RoomStatusUpdateListener var1, Room var2) {
            var1.onRoomConnecting(var2);
        }
    }

    private final class RoomCreatedCallback extends GamesClientImpl.AbstractRoomCallback {
        public RoomCreatedCallback(RoomUpdateListener var2, DataHolder var3) {
            super();
        }

        // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, int) void
        public void method_2944(RoomUpdateListener var1, Room var2, int var3) {
            var1.onRoomCreated(var3, var2);
        }
    }

    private static final class SendRequestResultImpl extends class_491 implements Requests.SendRequestResult {
        // $FF: renamed from: XB com.google.android.gms.games.request.GameRequest
        private final GameRequest field_2007;

        SendRequestResultImpl(DataHolder var1) {
            super(var1);
            GameRequestBuffer var2 = new GameRequestBuffer(var1);

            try {
                if(var2.getCount() > 0) {
                    this.field_2007 = (GameRequest)((GameRequest)var2.get(0)).freeze();
                } else {
                    this.field_2007 = null;
                }
            } finally {
                var2.release();
            }

        }
    }

    private final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Status> field_1297;

        public SignOutCompleteBinderCallbacks(BaseImplementation.class_1147<Status> var1) {
            this.field_1297 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: fp () void
        public void method_275() {
            Status var1 = new Status(0);
            this.field_1297.method_120(var1);
        }
    }

    private final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: XK com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Snapshots.CommitSnapshotResult> field_1288;

        public SnapshotCommittedBinderCallbacks(BaseImplementation.class_1147<Snapshots.CommitSnapshotResult> var1) {
            this.field_1288 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: J (com.google.android.gms.common.data.DataHolder) void
        public void method_243(DataHolder var1) {
            this.field_1288.method_120(new GamesClientImpl.CommitSnapshotResultImpl(var1));
        }
    }

    final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Snapshots.DeleteSnapshotResult> field_1313;

        public SnapshotDeletedBinderCallbacks(BaseImplementation.class_1147<Snapshots.DeleteSnapshotResult> var1) {
            this.field_1313 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: i (int, java.lang.String) void
        public void method_280(int var1, String var2) {
            this.field_1313.method_120(new GamesClientImpl.DeleteSnapshotResultImpl(var1, var2));
        }
    }

    private final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: XL com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Snapshots.OpenSnapshotResult> field_1290;

        public SnapshotOpenedBinderCallbacks(BaseImplementation.class_1147<Snapshots.OpenSnapshotResult> var1) {
            this.field_1290 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.Contents) void
        public void method_253(DataHolder var1, Contents var2) {
            this.field_1290.method_120(new GamesClientImpl.OpenSnapshotResultImpl(var1, var2));
        }

        // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String, com.google.android.gms.drive.Contents, com.google.android.gms.drive.Contents, com.google.android.gms.drive.Contents) void
        public void method_254(DataHolder var1, String var2, Contents var3, Contents var4, Contents var5) {
            this.field_1290.method_120(new GamesClientImpl.OpenSnapshotResultImpl(var1, var2, var3, var4, var5));
        }
    }

    private final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: XM com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Snapshots.LoadSnapshotsResult> field_1262;

        public SnapshotsLoadedBinderCallbacks(BaseImplementation.class_1147<Snapshots.LoadSnapshotsResult> var1) {
            this.field_1262 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: I (com.google.android.gms.common.data.DataHolder) void
        public void method_242(DataHolder var1) {
            this.field_1262.method_120(new GamesClientImpl.LoadSnapshotsResultImpl(var1));
        }
    }

    private final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<Leaderboards.SubmitScoreResult> field_1250;

        public SubmitScoreBinderCallbacks(BaseImplementation.class_1147<Leaderboards.SubmitScoreResult> var1) {
            this.field_1250 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: f (com.google.android.gms.common.data.DataHolder) void
        public void method_273(DataHolder var1) {
            this.field_1250.method_120(new GamesClientImpl.SubmitScoreResultImpl(var1));
        }
    }

    private static final class SubmitScoreResultImpl extends class_491 implements Leaderboards.SubmitScoreResult {
        // $FF: renamed from: XN com.google.android.gms.games.leaderboard.ScoreSubmissionData
        private final ScoreSubmissionData field_1991;

        public SubmitScoreResultImpl(DataHolder var1) {
            super(var1);

            try {
                this.field_1991 = new ScoreSubmissionData(var1);
            } finally {
                var1.close();
            }

        }

        public ScoreSubmissionData getScoreData() {
            return this.field_1991;
        }
    }

    private final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: XO com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<TurnBasedMultiplayer.CancelMatchResult> field_1302;

        public TurnBasedMatchCanceledBinderCallbacks(BaseImplementation.class_1147<TurnBasedMultiplayer.CancelMatchResult> var1) {
            this.field_1302 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: h (int, java.lang.String) void
        public void method_278(int var1, String var2) {
            Status var3 = new Status(var1);
            this.field_1302.method_120(new GamesClientImpl.CancelMatchResultImpl(var3, var2));
        }
    }

    private final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: XP com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<TurnBasedMultiplayer.InitiateMatchResult> field_1257;

        public TurnBasedMatchInitiatedBinderCallbacks(BaseImplementation.class_1147<TurnBasedMultiplayer.InitiateMatchResult> var1) {
            this.field_1257 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: q (com.google.android.gms.common.data.DataHolder) void
        public void method_289(DataHolder var1) {
            this.field_1257.method_120(new GamesClientImpl.InitiateMatchResultImpl(var1));
        }
    }

    private final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: XQ com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<TurnBasedMultiplayer.LeaveMatchResult> field_1294;

        public TurnBasedMatchLeftBinderCallbacks(BaseImplementation.class_1147<TurnBasedMultiplayer.LeaveMatchResult> var1) {
            this.field_1294 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: s (com.google.android.gms.common.data.DataHolder) void
        public void method_291(DataHolder var1) {
            this.field_1294.method_120(new GamesClientImpl.LeaveMatchResultImpl(var1));
        }
    }

    private final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: XR com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<TurnBasedMultiplayer.LoadMatchResult> field_1266;

        public TurnBasedMatchLoadedBinderCallbacks(BaseImplementation.class_1147<TurnBasedMultiplayer.LoadMatchResult> var1) {
            this.field_1266 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: p (com.google.android.gms.common.data.DataHolder) void
        public void method_288(DataHolder var1) {
            this.field_1266.method_120(new GamesClientImpl.LoadMatchResultImpl(var1));
        }
    }

    private abstract static class TurnBasedMatchResult extends class_491 {
        // $FF: renamed from: Xj com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
        final TurnBasedMatch field_2021;

        TurnBasedMatchResult(DataHolder var1) {
            super(var1);
            TurnBasedMatchBuffer var2 = new TurnBasedMatchBuffer(var1);

            try {
                if(var2.getCount() > 0) {
                    this.field_2021 = (TurnBasedMatch)((TurnBasedMatch)var2.get(0)).freeze();
                } else {
                    this.field_2021 = null;
                }
            } finally {
                var2.release();
            }

        }

        public TurnBasedMatch getMatch() {
            return this.field_2021;
        }
    }

    private final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: XS com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<TurnBasedMultiplayer.UpdateMatchResult> field_1255;

        public TurnBasedMatchUpdatedBinderCallbacks(BaseImplementation.class_1147<TurnBasedMultiplayer.UpdateMatchResult> var1) {
            this.field_1255 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: r (com.google.android.gms.common.data.DataHolder) void
        public void method_290(DataHolder var1) {
            this.field_1255.method_120(new GamesClientImpl.UpdateMatchResultImpl(var1));
        }
    }

    private final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        // $FF: renamed from: XT com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<TurnBasedMultiplayer.LoadMatchesResult> field_1280;

        public TurnBasedMatchesLoadedBinderCallbacks(BaseImplementation.class_1147<TurnBasedMultiplayer.LoadMatchesResult> var1) {
            this.field_1280 = (BaseImplementation.class_1147)class_1090.method_5681(var2, "Holder must not be null");
        }

        // $FF: renamed from: b (int, android.os.Bundle) void
        public void method_257(int var1, Bundle var2) {
            var2.setClassLoader(this.getClass().getClassLoader());
            Status var3 = new Status(var1);
            this.field_1280.method_120(new GamesClientImpl.LoadMatchesResultImpl(var3, var2));
        }
    }

    private static final class UpdateAchievementResultImpl implements Achievements.UpdateAchievementResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_5347;
        // $FF: renamed from: Wa java.lang.String
        private final String field_5348;

        UpdateAchievementResultImpl(int var1, String var2) {
            this.field_5347 = new Status(var1);
            this.field_5348 = var2;
        }

        public String getAchievementId() {
            return this.field_5348;
        }

        public Status getStatus() {
            return this.field_5347;
        }
    }

    private static final class UpdateMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder var1) {
            super(var1);
        }
    }

    private static final class UpdateRequestsResultImpl extends class_491 implements Requests.UpdateRequestsResult {
        // $FF: renamed from: XU com.google.android.gms.games.internal.request.RequestUpdateOutcomes
        private final RequestUpdateOutcomes field_2008;

        UpdateRequestsResultImpl(DataHolder var1) {
            super(var1);
            this.field_2008 = RequestUpdateOutcomes.method_3102(var1);
        }

        public Set<String> getRequestIds() {
            return this.field_2008.getRequestIds();
        }

        public int getRequestOutcome(String var1) {
            return this.field_2008.getRequestOutcome(var1);
        }
    }
}
