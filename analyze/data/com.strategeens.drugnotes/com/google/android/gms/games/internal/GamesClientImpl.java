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
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.class_1033;
import com.google.android.gms.common.api.class_481;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_970;
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
import com.google.android.gms.games.appcontent.AppContents;
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
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
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
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_712;
import com.google.android.gms.internal.jl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl extends jl<IGamesService> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
   // $FF: renamed from: DZ java.lang.String
   private final String field_612;
   // $FF: renamed from: Yk com.google.android.gms.games.internal.events.EventIncrementManager
   EventIncrementManager field_613 = new EventIncrementManager() {
      // $FF: renamed from: lF () com.google.android.gms.games.internal.events.EventIncrementCache
      public EventIncrementCache method_3115() {
         return GamesClientImpl.this.new GameClientEventIncrementCache();
      }
   };
   // $FF: renamed from: Yl java.lang.String
   private final String field_614;
   // $FF: renamed from: Ym java.util.Map
   private final Map<String, RealTimeSocket> field_615;
   // $FF: renamed from: Yn com.google.android.gms.games.PlayerEntity
   private PlayerEntity field_616;
   // $FF: renamed from: Yo com.google.android.gms.games.GameEntity
   private GameEntity field_617;
   // $FF: renamed from: Yp com.google.android.gms.games.internal.PopupManager
   private final PopupManager field_618;
   // $FF: renamed from: Yq boolean
   private boolean field_619 = false;
   // $FF: renamed from: Yr android.os.Binder
   private final Binder field_620;
   // $FF: renamed from: Ys long
   private final long field_621;
   // $FF: renamed from: Yt com.google.android.gms.games.Games$GamesOptions
   private final Games.GamesOptions field_622;

   public GamesClientImpl(Context var1, Looper var2, String var3, String var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6, String[] var7, int var8, View var9, Games.GamesOptions var10) {
      super(var1, var2, var5, var6, var7);
      this.field_614 = var3;
      this.field_612 = (String)class_335.method_2311(var4);
      this.field_620 = new Binder();
      this.field_615 = new HashMap();
      this.field_618 = PopupManager.method_4661(this, var8);
      this.method_1981(var9);
      this.field_621 = (long)this.hashCode();
      this.field_622 = var10;
      this.registerConnectionCallbacks(this);
      this.registerConnectionFailedListener(this);
   }

   // $FF: renamed from: R (com.google.android.gms.common.data.DataHolder) com.google.android.gms.games.multiplayer.realtime.Room
   private static Room method_1866(DataHolder param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bB (java.lang.String) com.google.android.gms.games.multiplayer.realtime.RealTimeSocket
   private RealTimeSocket method_1868(String var1) {
      RealTimeSocket var2;
      if(class_712.method_4179()) {
         var2 = this.method_1870(var1);
      } else {
         var2 = this.method_1869(var1);
      }

      if(var2 != null) {
         this.field_615.put(var1, var2);
      }

      return var2;
   }

   // $FF: renamed from: bC (java.lang.String) com.google.android.gms.games.multiplayer.realtime.RealTimeSocket
   private RealTimeSocket method_1869(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bD (java.lang.String) com.google.android.gms.games.multiplayer.realtime.RealTimeSocket
   private RealTimeSocket method_1870(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: lD () void
   private void method_1871() {
      Iterator var1 = this.field_615.values().iterator();

      while(var1.hasNext()) {
         RealTimeSocket var2 = (RealTimeSocket)var1.next();

         try {
            var2.close();
         } catch (IOException var4) {
            GamesLog.method_5845("GamesClientImpl", "IOException:", var4);
         }
      }

      this.field_615.clear();
   }

   // $FF: renamed from: lg () void
   private void method_1872() {
      this.field_616 = null;
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.d, byte[], java.lang.String, java.lang.String) int
   public int method_1873(d<RealTimeMultiplayer.ReliableMessageSentCallback> var1, byte[] var2, String var3, String var4) {
      try {
         int var6 = ((IGamesService)this.hw()).method_450(new GamesClientImpl.RealTimeReliableMessageBinderCallbacks(var1), var2, var3, var4);
         return var6;
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: a (byte[], java.lang.String, java.lang.String[]) int
   public int method_1874(byte[] var1, String var2, String[] var3) {
      class_335.method_2306(var3, "Participant IDs must not be null");

      try {
         int var6 = ((IGamesService)this.hw()).method_511(var1, var2, var3);
         return var6;
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: a (int, int, boolean) android.content.Intent
   public Intent method_1875(int var1, int var2, boolean var3) {
      try {
         Intent var5 = ((IGamesService)this.hw()).method_451(var1, var2, var3);
         return var5;
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: a (int, byte[], int, android.graphics.Bitmap, java.lang.String) android.content.Intent
   public Intent method_1876(int var1, byte[] var2, int var3, Bitmap var4, String var5) {
      try {
         Intent var7 = ((IGamesService)this.hw()).method_452(var1, var2, var3, var5);
         class_335.method_2306(var4, "Must provide a non null icon");
         var7.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", var4);
         return var7;
      } catch (RemoteException var8) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.Room, int) android.content.Intent
   public Intent method_1877(Room var1, int var2) {
      try {
         Intent var4 = ((IGamesService)this.hw()).method_456((RoomEntity)var1.freeze(), var2);
         return var4;
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: a (java.lang.String, boolean, boolean, int) android.content.Intent
   public Intent method_1878(String var1, boolean var2, boolean var3, int var4) {
      try {
         Intent var6 = ((IGamesService)this.hw()).method_457(var1, var2, var3, var4);
         return var6;
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
   protected void method_1790(int var1, IBinder var2, Bundle var3) {
      if(var1 == 0 && var3 != null) {
         this.field_619 = var3.getBoolean("show_welcome_popup");
      }

      super.method_1790(var1, var2, var3);
   }

   // $FF: renamed from: a (android.os.IBinder, android.os.Bundle) void
   public void method_1879(IBinder var1, Bundle var2) {
      if(this.isConnected()) {
         try {
            ((IGamesService)this.hw()).method_461(var1, var2);
         } catch (RemoteException var4) {
            GamesLog.method_5847("GamesClientImpl", "service died");
            return;
         }
      }

   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, int, int) void
   public void method_1880(BaseImplementation.class_1058<Requests.LoadRequestsResult> var1, int var2, int var3, int var4) {
      try {
         ((IGamesService)this.hw()).method_465(new GamesClientImpl.RequestsLoadedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, int, boolean, boolean) void
   public void method_1881(BaseImplementation.class_1058<GamesMetadata.LoadExtendedGamesResult> var1, int var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.hw()).method_466(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, java.lang.String, java.lang.String[], boolean) void
   public void method_1882(BaseImplementation.class_1058<AppContents.LoadAppContentResult> var1, int var2, String var3, String[] var4, boolean var5) {
      try {
         ((IGamesService)this.hw()).method_468(new GamesClientImpl.AppContentLoadedBinderCallbacks(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, boolean, boolean) void
   public void method_1883(BaseImplementation.class_1058<Players.LoadPlayersResult> var1, int var2, boolean var3, boolean var4) {
      try {
         ((IGamesService)this.hw()).method_469(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, int[]) void
   public void method_1884(BaseImplementation.class_1058<TurnBasedMultiplayer.LoadMatchesResult> var1, int var2, int[] var3) {
      try {
         ((IGamesService)this.hw()).method_470(new GamesClientImpl.TurnBasedMatchesLoadedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer, int, int) void
   public void method_1885(BaseImplementation.class_1058<Leaderboards.LoadScoresResult> var1, LeaderboardScoreBuffer var2, int var3, int var4) {
      try {
         ((IGamesService)this.hw()).method_473(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2.method_2976().method_4764(), var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig) void
   public void method_1886(BaseImplementation.class_1058<TurnBasedMultiplayer.InitiateMatchResult> var1, TurnBasedMatchConfig var2) {
      try {
         ((IGamesService)this.hw()).method_467(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2.getVariant(), var2.method_5107(), var2.getInvitedPlayerIds(), var2.getAutoMatchCriteria());
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.games.snapshot.Snapshot, com.google.android.gms.games.snapshot.SnapshotMetadataChange) void
   public void method_1887(BaseImplementation.class_1058<Snapshots.CommitSnapshotResult> var1, Snapshot var2, SnapshotMetadataChange var3) {
      SnapshotContents var4 = var2.getSnapshotContents();
      boolean var5;
      if(!var4.isClosed()) {
         var5 = true;
      } else {
         var5 = false;
      }

      class_335.method_2302(var5, "Snapshot already closed");
      class_970 var6 = var3.method_3258();
      if(var6 != null) {
         var6.method_5399(this.getContext().getCacheDir());
      }

      Contents var7 = var4.method_1061();
      var4.close();

      try {
         ((IGamesService)this.hw()).method_487(new GamesClientImpl.SnapshotCommittedBinderCallbacks(var1), var2.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity)var3, var7);
      } catch (RemoteException var9) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_1888(BaseImplementation.class_1058<Achievements.UpdateAchievementResult> param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int) void
   public void method_1889(BaseImplementation.class_1058<Achievements.UpdateAchievementResult> param1, String param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, int, int, boolean) void
   public void method_1890(BaseImplementation.class_1058<Leaderboards.LoadScoresResult> var1, String var2, int var3, int var4, int var5, boolean var6) {
      try {
         ((IGamesService)this.hw()).method_478(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var8) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean) void
   public void method_1891(BaseImplementation.class_1058<Players.LoadPlayersResult> var1, String var2, int var3, boolean var4, boolean var5) {
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
               ((IGamesService)this.hw()).method_563(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4, var5);
               return;
            } catch (RemoteException var8) {
               GamesLog.method_5847("GamesClientImpl", "service died");
               return;
            }
         default:
            throw new IllegalArgumentException("Invalid player collection: " + var2);
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean, boolean, boolean) void
   public void method_1892(BaseImplementation.class_1058<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      try {
         ((IGamesService)this.hw()).method_482(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5, var6, var7);
      } catch (RemoteException var9) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, int[]) void
   public void method_1893(BaseImplementation.class_1058<TurnBasedMultiplayer.LoadMatchesResult> var1, String var2, int var3, int[] var4) {
      try {
         ((IGamesService)this.hw()).method_483(new GamesClientImpl.TurnBasedMatchesLoadedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, long, java.lang.String) void
   public void method_1894(BaseImplementation.class_1058<Leaderboards.SubmitScoreResult> param1, String param2, long param3, String param5) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String) void
   public void method_1895(BaseImplementation.class_1058<TurnBasedMultiplayer.LeaveMatchResult> var1, String var2, String var3) {
      try {
         ((IGamesService)this.hw()).method_551(new GamesClientImpl.TurnBasedMatchLeftBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, int, int) void
   public void method_1896(BaseImplementation.class_1058<Leaderboards.LoadPlayerScoreResult> var1, String var2, String var3, int var4, int var5) {
      try {
         ((IGamesService)this.hw()).method_489(new GamesClientImpl.PlayerLeaderboardScoreLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, int, int, int) void
   public void method_1897(BaseImplementation.class_1058<Requests.LoadRequestsResult> var1, String var2, String var3, int var4, int var5, int var6) {
      try {
         ((IGamesService)this.hw()).method_490(new GamesClientImpl.RequestsLoadedBinderCallbacks(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var8) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, int, int, int, boolean) void
   public void method_1898(BaseImplementation.class_1058<Leaderboards.LoadScoresResult> var1, String var2, String var3, int var4, int var5, int var6, boolean var7) {
      try {
         ((IGamesService)this.hw()).method_491(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6, var7);
      } catch (RemoteException var9) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, int, boolean, boolean) void
   public void method_1899(BaseImplementation.class_1058<Players.LoadPlayersResult> var1, String var2, String var3, int var4, boolean var5, boolean var6) {
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
            ((IGamesService)this.hw()).method_492(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4, var5, var6);
            return;
         } catch (RemoteException var9) {
            GamesLog.method_5847("GamesClientImpl", "service died");
            return;
         }
      default:
         throw new IllegalArgumentException("Invalid player collection: " + var2);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChange, com.google.android.gms.games.snapshot.SnapshotContents) void
   public void method_1900(BaseImplementation.class_1058<Snapshots.OpenSnapshotResult> var1, String var2, String var3, SnapshotMetadataChange var4, SnapshotContents var5) {
      boolean var6;
      if(!var5.isClosed()) {
         var6 = true;
      } else {
         var6 = false;
      }

      class_335.method_2302(var6, "SnapshotContents already closed");
      class_970 var7 = var4.method_3258();
      if(var7 != null) {
         var7.method_5399(this.getContext().getCacheDir());
      }

      Contents var8 = var5.method_1061();
      var5.close();

      try {
         ((IGamesService)this.hw()).method_493(new GamesClientImpl.SnapshotOpenedBinderCallbacks(var1), var2, var3, (SnapshotMetadataChangeEntity)var4, var8);
      } catch (RemoteException var10) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, boolean) void
   public void method_1901(BaseImplementation.class_1058<Leaderboards.LeaderboardMetadataResult> var1, String var2, String var3, boolean var4) {
      try {
         ((IGamesService)this.hw()).method_529(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, boolean, java.lang.String[]) void
   public void method_1902(BaseImplementation.class_1058<Quests.LoadQuestsResult> var1, String var2, String var3, boolean var4, String[] var5) {
      try {
         this.field_613.flush();
         ((IGamesService)this.hw()).method_497(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), var2, var3, var5, var4);
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, int[], int, boolean) void
   public void method_1903(BaseImplementation.class_1058<Quests.LoadQuestsResult> var1, String var2, String var3, int[] var4, int var5, boolean var6) {
      try {
         this.field_613.flush();
         ((IGamesService)this.hw()).method_495(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var8) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, java.lang.String[]) void
   public void method_1904(BaseImplementation.class_1058<Requests.UpdateRequestsResult> var1, String var2, String var3, String[] var4) {
      try {
         ((IGamesService)this.hw()).method_496(new GamesClientImpl.RequestsUpdatedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, boolean) void
   public void method_1905(BaseImplementation.class_1058<Players.LoadPlayersResult> var1, String var2, boolean var3) {
      try {
         ((IGamesService)this.hw()).method_579(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, byte[], java.lang.String, com.google.android.gms.games.multiplayer.ParticipantResult[]) void
   public void method_1906(BaseImplementation.class_1058<TurnBasedMultiplayer.UpdateMatchResult> var1, String var2, byte[] var3, String var4, ParticipantResult[] var5) {
      try {
         ((IGamesService)this.hw()).method_499(new GamesClientImpl.TurnBasedMatchUpdatedBinderCallbacks(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, byte[], com.google.android.gms.games.multiplayer.ParticipantResult[]) void
   public void method_1907(BaseImplementation.class_1058<TurnBasedMultiplayer.UpdateMatchResult> var1, String var2, byte[] var3, ParticipantResult[] var4) {
      try {
         ((IGamesService)this.hw()).method_500(new GamesClientImpl.TurnBasedMatchUpdatedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String[], int, byte[], int) void
   public void method_1908(BaseImplementation.class_1058<Requests.SendRequestResult> var1, String var2, String[] var3, int var4, byte[] var5, int var6) {
      try {
         ((IGamesService)this.hw()).method_502(new GamesClientImpl.RequestSentBinderCallbacks(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var8) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
   public void method_1909(BaseImplementation.class_1058<Players.LoadPlayersResult> var1, boolean var2) {
      try {
         ((IGamesService)this.hw()).method_554(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, boolean, android.os.Bundle) void
   public void method_1910(BaseImplementation.class_1058<Status> var1, boolean var2, Bundle var3) {
      try {
         ((IGamesService)this.hw()).method_504(new GamesClientImpl.ContactSettingsUpdatedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, boolean, java.lang.String[]) void
   public void method_1911(BaseImplementation.class_1058<Events.LoadEventsResult> var1, boolean var2, String... var3) {
      try {
         this.field_613.flush();
         ((IGamesService)this.hw()).method_505(new GamesClientImpl.EventsLoadedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int[], int, boolean) void
   public void method_1912(BaseImplementation.class_1058<Quests.LoadQuestsResult> var1, int[] var2, int var3, boolean var4) {
      try {
         this.field_613.flush();
         ((IGamesService)this.hw()).method_507(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String[]) void
   public void method_1913(BaseImplementation.class_1058<Players.LoadPlayersResult> var1, String[] var2) {
      try {
         ((IGamesService)this.hw()).method_555(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.d) void
   public void method_1914(d<OnInvitationReceivedListener> var1) {
      try {
         GamesClientImpl.InvitationReceivedBinderCallback var2 = new GamesClientImpl.InvitationReceivedBinderCallback(var1);
         ((IGamesService)this.hw()).method_471(var2, this.field_621);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.d, com.google.android.gms.common.api.d, com.google.android.gms.common.api.d, com.google.android.gms.games.multiplayer.realtime.RoomConfig) void
   public void method_1915(d<RoomUpdateListener> var1, d<RoomStatusUpdateListener> var2, d<RealTimeMessageReceivedListener> var3, RoomConfig var4) {
      this.method_1871();

      try {
         GamesClientImpl.RoomBinderCallbacks var5 = new GamesClientImpl.RoomBinderCallbacks(var1, var2, var3);
         ((IGamesService)this.hw()).method_474(var5, this.field_620, var4.getVariant(), var4.getInvitedPlayerIds(), var4.getAutoMatchCriteria(), var4.isSocketEnabled(), this.field_621);
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.d, java.lang.String) void
   public void method_1916(d<RoomUpdateListener> var1, String var2) {
      try {
         ((IGamesService)this.hw()).method_548(new GamesClientImpl.RoomBinderCallbacks(var1), var2);
         this.method_1871();
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.games.snapshot.Snapshot) void
   public void method_1917(Snapshot var1) {
      SnapshotContents var2 = var1.getSnapshotContents();
      boolean var3;
      if(!var2.isClosed()) {
         var3 = true;
      } else {
         var3 = false;
      }

      class_335.method_2302(var3, "Snapshot already closed");
      Contents var4 = var2.method_1061();
      var2.close();

      try {
         ((IGamesService)this.hw()).method_462(var4);
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      String var3 = this.getContext().getResources().getConfiguration().locale.toString();
      Bundle var4 = new Bundle();
      var4.putBoolean("com.google.android.gms.games.key.isHeadless", this.field_622.field_1749);
      var4.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.field_622.field_1750);
      var4.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.field_622.field_1751);
      var4.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.field_622.field_1752);
      var4.putInt("com.google.android.gms.games.key.sdkVariant", this.field_622.field_1753);
      var4.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.field_622.field_1754);
      var4.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.field_622.field_1755);
      var1.method_136(var2, 6587000, this.getContext().getPackageName(), this.field_612, this.hv(), this.field_614, this.field_618.method_4666(), var3, var4);
   }

   // $FF: renamed from: aC (android.os.IBinder) com.google.android.gms.games.internal.IGamesService
   protected IGamesService method_1918(IBinder var1) {
      return IGamesService.Stub.method_5052(var1);
   }

   // $FF: renamed from: b (int, int, boolean) android.content.Intent
   public Intent method_1919(int var1, int var2, boolean var3) {
      try {
         Intent var5 = ((IGamesService)this.hw()).method_512(var1, var2, var3);
         return var5;
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: b (int[]) android.content.Intent
   public Intent method_1920(int[] var1) {
      try {
         Intent var3 = ((IGamesService)this.hw()).method_513(var1);
         return var3;
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_1921(BaseImplementation.class_1058<Status> var1) {
      try {
         this.field_613.flush();
         ((IGamesService)this.hw()).method_463(new GamesClientImpl.SignOutCompleteBinderCallbacks(var1));
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, int, boolean, boolean) void
   public void method_1922(BaseImplementation.class_1058<Players.LoadPlayersResult> var1, int var2, boolean var3, boolean var4) {
      try {
         ((IGamesService)this.hw()).method_516(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_1923(BaseImplementation.class_1058<Achievements.UpdateAchievementResult> param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int) void
   public void method_1924(BaseImplementation.class_1058<Achievements.UpdateAchievementResult> param1, String param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, int, int, boolean) void
   public void method_1925(BaseImplementation.class_1058<Leaderboards.LoadScoresResult> var1, String var2, int var3, int var4, int var5, boolean var6) {
      try {
         ((IGamesService)this.hw()).method_521(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var8) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean) void
   public void method_1926(BaseImplementation.class_1058<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.hw()).method_481(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String) void
   public void method_1927(BaseImplementation.class_1058<Quests.ClaimMilestoneResult> var1, String var2, String var3) {
      try {
         this.field_613.flush();
         ((IGamesService)this.hw()).method_578(new GamesClientImpl.QuestMilestoneClaimBinderCallbacks(var1, var3), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, int, int, int, boolean) void
   public void method_1928(BaseImplementation.class_1058<Leaderboards.LoadScoresResult> var1, String var2, String var3, int var4, int var5, int var6, boolean var7) {
      try {
         ((IGamesService)this.hw()).method_527(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6, var7);
      } catch (RemoteException var9) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, int, boolean, boolean) void
   public void method_1929(BaseImplementation.class_1058<Players.LoadPlayersResult> var1, String var2, String var3, int var4, boolean var5, boolean var6) {
      try {
         ((IGamesService)this.hw()).method_528(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var8) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, boolean) void
   public void method_1930(BaseImplementation.class_1058<Achievements.LoadAchievementsResult> var1, String var2, String var3, boolean var4) {
      try {
         ((IGamesService)this.hw()).method_494(new GamesClientImpl.AchievementsLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, boolean) void
   public void method_1931(BaseImplementation.class_1058<Leaderboards.LeaderboardMetadataResult> var1, String var2, boolean var3) {
      try {
         ((IGamesService)this.hw()).method_553(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
   public void method_1932(BaseImplementation.class_1058<Leaderboards.LeaderboardMetadataResult> var1, boolean var2) {
      try {
         ((IGamesService)this.hw()).method_531(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, boolean, java.lang.String[]) void
   public void method_1933(BaseImplementation.class_1058<Quests.LoadQuestsResult> var1, boolean var2, String[] var3) {
      try {
         this.field_613.flush();
         ((IGamesService)this.hw()).method_509(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), var3, var2);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String[]) void
   public void method_1934(BaseImplementation.class_1058<Requests.UpdateRequestsResult> var1, String[] var2) {
      try {
         ((IGamesService)this.hw()).method_508(new GamesClientImpl.RequestsUpdatedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.d) void
   public void method_1935(d<OnTurnBasedMatchUpdateReceivedListener> var1) {
      try {
         GamesClientImpl.MatchUpdateReceivedBinderCallback var2 = new GamesClientImpl.MatchUpdateReceivedBinderCallback(var1);
         ((IGamesService)this.hw()).method_517(var2, this.field_621);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.d, com.google.android.gms.common.api.d, com.google.android.gms.common.api.d, com.google.android.gms.games.multiplayer.realtime.RoomConfig) void
   public void method_1936(d<RoomUpdateListener> var1, d<RoomStatusUpdateListener> var2, d<RealTimeMessageReceivedListener> var3, RoomConfig var4) {
      this.method_1871();

      try {
         GamesClientImpl.RoomBinderCallbacks var5 = new GamesClientImpl.RoomBinderCallbacks(var1, var2, var3);
         ((IGamesService)this.hw()).method_475(var5, this.field_620, var4.getInvitationId(), var4.isSocketEnabled(), this.field_621);
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: bA (java.lang.String) void
   public void method_1937(String var1) {
      try {
         ((IGamesService)this.hw()).method_540(var1);
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: bE (java.lang.String) android.content.Intent
   public Intent method_1938(String var1) {
      try {
         Intent var3 = ((IGamesService)this.hw()).method_534(var1);
         return var3;
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: bF (java.lang.String) void
   public void method_1939(String var1) {
      try {
         ((IGamesService)this.hw()).method_510(var1, this.field_618.method_4666(), this.field_618.method_4665());
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.gms.games.service.START";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.games.internal.IGamesService";
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, int) void
   public void method_1940(BaseImplementation.class_1058<Invitations.LoadInvitationsResult> var1, int var2) {
      try {
         ((IGamesService)this.hw()).method_464(new GamesClientImpl.InvitationsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, int, boolean, boolean) void
   public void method_1941(BaseImplementation.class_1058<Players.LoadPlayersResult> var1, int var2, boolean var3, boolean var4) {
      try {
         ((IGamesService)this.hw()).method_545(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_1942(BaseImplementation.class_1058<TurnBasedMultiplayer.InitiateMatchResult> var1, String var2) {
      try {
         ((IGamesService)this.hw()).method_594(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int) void
   public void method_1943(BaseImplementation.class_1058<Players.LoadXpStreamResult> var1, String var2, int var3) {
      try {
         ((IGamesService)this.hw()).method_520(new GamesClientImpl.PlayerXpStreamLoadedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean) void
   public void method_1944(BaseImplementation.class_1058<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.hw()).method_571(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String) void
   public void method_1945(BaseImplementation.class_1058<TurnBasedMultiplayer.InitiateMatchResult> var1, String var2, String var3) {
      try {
         ((IGamesService)this.hw()).method_564(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, boolean) void
   public void method_1946(BaseImplementation.class_1058<Snapshots.LoadSnapshotsResult> var1, String var2, String var3, boolean var4) {
      try {
         ((IGamesService)this.hw()).method_552(new GamesClientImpl.SnapshotsLoadedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, boolean) void
   public void method_1947(BaseImplementation.class_1058<Snapshots.OpenSnapshotResult> var1, String var2, boolean var3) {
      try {
         ((IGamesService)this.hw()).method_573(new GamesClientImpl.SnapshotOpenedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
   public void method_1948(BaseImplementation.class_1058<Achievements.LoadAchievementsResult> var1, boolean var2) {
      try {
         ((IGamesService)this.hw()).method_503(new GamesClientImpl.AchievementsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String[]) void
   public void method_1949(BaseImplementation.class_1058<Requests.UpdateRequestsResult> var1, String[] var2) {
      try {
         ((IGamesService)this.hw()).method_532(new GamesClientImpl.RequestsUpdatedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.d) void
   public void method_1950(d<QuestUpdateListener> var1) {
      try {
         GamesClientImpl.QuestUpdateBinderCallback var2 = new GamesClientImpl.QuestUpdateBinderCallback(var1);
         ((IGamesService)this.hw()).method_560(var2, this.field_621);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (java.lang.String[]) void
   protected void method_1796(String... var1) {
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

         class_335.method_2303(var5, "Cannot have both %s and %s!", new Object[]{"https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty"});
      } else {
         class_335.method_2303(var4, "Games APIs requires %s to function.", new Object[]{"https://www.googleapis.com/auth/games"});
      }
   }

   public void connect() {
      this.method_1872();
      super.connect();
   }

   // $FF: renamed from: d (byte[], java.lang.String) int
   public int method_1951(byte[] var1, String var2) {
      try {
         int var4 = ((IGamesService)this.hw()).method_511(var1, var2, (String[])null);
         return var4;
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, int, boolean, boolean) void
   public void method_1952(BaseImplementation.class_1058<Players.LoadPlayersResult> var1, int var2, boolean var3, boolean var4) {
      try {
         ((IGamesService)this.hw()).method_569(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_1953(BaseImplementation.class_1058<TurnBasedMultiplayer.InitiateMatchResult> var1, String var2) {
      try {
         ((IGamesService)this.hw()).method_619(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int) void
   public void method_1954(BaseImplementation.class_1058<Players.LoadXpStreamResult> var1, String var2, int var3) {
      try {
         ((IGamesService)this.hw()).method_549(new GamesClientImpl.PlayerXpStreamLoadedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean) void
   public void method_1955(BaseImplementation.class_1058<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.hw()).method_577(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String) void
   public void method_1956(BaseImplementation.class_1058<TurnBasedMultiplayer.InitiateMatchResult> var1, String var2, String var3) {
      try {
         ((IGamesService)this.hw()).method_572(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, boolean) void
   public void method_1957(BaseImplementation.class_1058<Leaderboards.LeaderboardMetadataResult> var1, String var2, boolean var3) {
      try {
         ((IGamesService)this.hw()).method_565(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
   public void method_1958(BaseImplementation.class_1058<Events.LoadEventsResult> var1, boolean var2) {
      try {
         this.field_613.flush();
         ((IGamesService)this.hw()).method_580(new GamesClientImpl.EventsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.d) void
   public void method_1959(d<OnRequestReceivedListener> var1) {
      try {
         GamesClientImpl.RequestReceivedBinderCallback var2 = new GamesClientImpl.RequestReceivedBinderCallback(var1);
         ((IGamesService)this.hw()).method_546(var2, this.field_621);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: dS (int) void
   public void method_1960(int var1) {
      this.field_618.setGravity(var1);
   }

   // $FF: renamed from: dT (int) void
   public void method_1961(int var1) {
      try {
         ((IGamesService)this.hw()).method_567(var1);
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   public void disconnect() {
      this.field_619 = false;
      if(this.isConnected()) {
         try {
            IGamesService var2 = (IGamesService)this.hw();
            var2.method_598();
            this.field_613.flush();
            var2.method_625(this.field_621);
         } catch (RemoteException var3) {
            GamesLog.method_5847("GamesClientImpl", "Failed to notify client disconnect.");
         }
      }

      this.method_1871();
      super.disconnect();
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_1962(BaseImplementation.class_1058<TurnBasedMultiplayer.LeaveMatchResult> var1, String var2) {
      try {
         ((IGamesService)this.hw()).method_621(new GamesClientImpl.TurnBasedMatchLeftBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int) void
   public void method_1963(BaseImplementation.class_1058<Invitations.LoadInvitationsResult> var1, String var2, int var3) {
      try {
         ((IGamesService)this.hw()).method_523(new GamesClientImpl.InvitationsLoadedBinderCallback(var1), var2, var3, false);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean) void
   public void method_1964(BaseImplementation.class_1058<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.hw()).method_550(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, boolean) void
   public void method_1965(BaseImplementation.class_1058<Notifications.GameMuteStatusChangeResult> var1, String var2, boolean var3) {
      try {
         ((IGamesService)this.hw()).method_498(new GamesClientImpl.GameMuteStatusChangedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
   public void method_1966(BaseImplementation.class_1058<Snapshots.LoadSnapshotsResult> var1, boolean var2) {
      try {
         ((IGamesService)this.hw()).method_566(new GamesClientImpl.SnapshotsLoadedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: f (com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_1967(BaseImplementation.class_1058<GamesMetadata.LoadGamesResult> var1) {
      try {
         ((IGamesService)this.hw()).method_558(new GamesClientImpl.GamesLoadedBinderCallback(var1));
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: f (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_1968(BaseImplementation.class_1058<TurnBasedMultiplayer.CancelMatchResult> var1, String var2) {
      try {
         ((IGamesService)this.hw()).method_620(new GamesClientImpl.TurnBasedMatchCanceledBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: f (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int) void
   public void method_1969(BaseImplementation.class_1058<Requests.LoadRequestSummariesResult> var1, String var2, int var3) {
      try {
         ((IGamesService)this.hw()).method_477(new GamesClientImpl.RequestSummariesLoadedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: f (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, int, boolean, boolean) void
   public void method_1970(BaseImplementation.class_1058<Players.LoadPlayersResult> var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.hw()).method_524(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: f (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
   public void method_1971(BaseImplementation.class_1058<Players.LoadProfileSettingsResult> var1, boolean var2) {
      try {
         ((IGamesService)this.hw()).method_584(new GamesClientImpl.ProfileSettingsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: fX () android.os.Bundle
   public Bundle method_948() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: g (com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_1972(BaseImplementation.class_1058<Players.LoadOwnerCoverPhotoUrisResult> var1) {
      try {
         ((IGamesService)this.hw()).method_591(new GamesClientImpl.OwnerCoverPhotoUrisLoadedBinderCallback(var1));
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: g (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_1973(BaseImplementation.class_1058<TurnBasedMultiplayer.LoadMatchResult> var1, String var2) {
      try {
         ((IGamesService)this.hw()).method_623(new GamesClientImpl.TurnBasedMatchLoadedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: g (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
   public void method_1974(BaseImplementation.class_1058<Status> var1, boolean var2) {
      try {
         ((IGamesService)this.hw()).method_588(new GamesClientImpl.ProfileSettingsUpdatedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: h (com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_1975(BaseImplementation.class_1058<Acls.LoadAclResult> var1) {
      try {
         ((IGamesService)this.hw()).method_587(new GamesClientImpl.NotifyAclLoadedBinderCallback(var1));
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: h (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_1976(BaseImplementation.class_1058<Quests.AcceptQuestResult> var1, String var2) {
      try {
         this.field_613.flush();
         ((IGamesService)this.hw()).method_639(new GamesClientImpl.QuestAcceptedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: h (com.google.android.gms.common.api.BaseImplementation$b, boolean) void
   public void method_1977(BaseImplementation.class_1058<Notifications.ContactSettingLoadResult> var1, boolean var2) {
      try {
         ((IGamesService)this.hw()).method_574(new GamesClientImpl.ContactSettingsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: i (com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_1978(BaseImplementation.class_1058<Notifications.InboxCountResult> var1) {
      try {
         ((IGamesService)this.hw()).method_634(new GamesClientImpl.InboxCountsLoadedBinderCallback(var1), (String)null);
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: i (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_1979(BaseImplementation.class_1058<Snapshots.DeleteSnapshotResult> var1, String var2) {
      try {
         ((IGamesService)this.hw()).method_629(new GamesClientImpl.SnapshotDeletedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: j (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_1980(BaseImplementation.class_1058<GamesMetadata.LoadExtendedGamesResult> var1, String var2) {
      try {
         ((IGamesService)this.hw()).method_570(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: k (android.view.View) void
   public void method_1981(View var1) {
      this.field_618.method_4663(var1);
   }

   // $FF: renamed from: k (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_1982(BaseImplementation.class_1058<GamesMetadata.LoadGameInstancesResult> var1, String var2) {
      try {
         ((IGamesService)this.hw()).method_576(new GamesClientImpl.GameInstancesLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_1918(var1);
   }

   // $FF: renamed from: l (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_1983(BaseImplementation.class_1058<GamesMetadata.LoadGameSearchSuggestionsResult> var1, String var2) {
      try {
         ((IGamesService)this.hw()).method_626(new GamesClientImpl.GameSearchSuggestionsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: lA () int
   public int method_1984() {
      try {
         int var2 = ((IGamesService)this.hw()).method_595();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: lB () int
   public int method_1985() {
      try {
         int var2 = ((IGamesService)this.hw()).method_596();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: lC () int
   public int method_1986() {
      try {
         int var2 = ((IGamesService)this.hw()).method_597();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: lE () void
   public void method_1987() {
      if(this.isConnected()) {
         try {
            ((IGamesService)this.hw()).method_598();
         } catch (RemoteException var2) {
            GamesLog.method_5847("GamesClientImpl", "service died");
            return;
         }
      }

   }

   // $FF: renamed from: lh () java.lang.String
   public String method_1988() {
      try {
         String var2 = ((IGamesService)this.hw()).method_606();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: li () java.lang.String
   public String method_1989() {
      try {
         String var2 = ((IGamesService)this.hw()).method_607();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: lj () com.google.android.gms.games.Player
   public Player method_1990() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: lk () com.google.android.gms.games.Game
   public Game method_1991() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ll () android.content.Intent
   public Intent method_1992() {
      try {
         Intent var2 = ((IGamesService)this.hw()).method_608();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: lm () android.content.Intent
   public Intent method_1993() {
      try {
         Intent var2 = ((IGamesService)this.hw()).method_609();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: ln () android.content.Intent
   public Intent method_1994() {
      try {
         Intent var2 = ((IGamesService)this.hw()).method_610();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: lo () android.content.Intent
   public Intent method_1995() {
      try {
         Intent var2 = ((IGamesService)this.hw()).method_611();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: lp () void
   public void method_1996() {
      try {
         ((IGamesService)this.hw()).method_628(this.field_621);
      } catch (RemoteException var2) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: lq () void
   public void method_1997() {
      try {
         ((IGamesService)this.hw()).method_630(this.field_621);
      } catch (RemoteException var2) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: lr () void
   public void method_1998() {
      try {
         ((IGamesService)this.hw()).method_638(this.field_621);
      } catch (RemoteException var2) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: ls () void
   public void method_1999() {
      try {
         ((IGamesService)this.hw()).method_633(this.field_621);
      } catch (RemoteException var2) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: lt () android.content.Intent
   public Intent method_2000() {
      try {
         Intent var2 = ((IGamesService)this.hw()).method_612();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: lu () android.content.Intent
   public Intent method_2001() {
      try {
         Intent var2 = ((IGamesService)this.hw()).method_613();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: lv () int
   public int method_2002() {
      try {
         int var2 = ((IGamesService)this.hw()).method_614();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return 4368;
      }
   }

   // $FF: renamed from: lw () java.lang.String
   public String method_2003() {
      try {
         String var2 = ((IGamesService)this.hw()).method_615();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: lx () int
   public int method_2004() {
      try {
         int var2 = ((IGamesService)this.hw()).method_616();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: ly () android.content.Intent
   public Intent method_2005() {
      try {
         Intent var2 = ((IGamesService)this.hw()).method_617();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: lz () int
   public int method_2006() {
      try {
         int var2 = ((IGamesService)this.hw()).method_618();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: m (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_2007(BaseImplementation.class_1058<Players.LoadXpForGameCategoriesResult> var1, String var2) {
      try {
         ((IGamesService)this.hw()).method_631(new GamesClientImpl.PlayerXpForGameCategoriesLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: n (java.lang.String, int) android.content.Intent
   public Intent method_2008(String var1, int var2) {
      try {
         Intent var4 = ((IGamesService)this.hw()).method_637(var1, var2);
         return var4;
      } catch (RemoteException var5) {
         GamesLog.method_5847("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: n (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_2009(BaseImplementation.class_1058<Invitations.LoadInvitationsResult> var1, String var2) {
      try {
         ((IGamesService)this.hw()).method_593(new GamesClientImpl.InvitationsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: o (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_2010(BaseImplementation.class_1058<Status> var1, String var2) {
      try {
         ((IGamesService)this.hw()).method_592(new GamesClientImpl.NotifyAclUpdatedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: o (java.lang.String, int) void
   public void method_2011(String var1, int var2) {
      this.field_613.method_3116(var1, var2);
   }

   public void onConnected(Bundle var1) {
      if(this.field_619) {
         this.field_618.method_4664();
         this.field_619 = false;
      }

   }

   public void onConnectionFailed(ConnectionResult var1) {
      this.field_619 = false;
   }

   public void onConnectionSuspended(int var1) {
   }

   // $FF: renamed from: p (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String) void
   public void method_2012(BaseImplementation.class_1058<Notifications.GameMuteStatusLoadResult> var1, String var2) {
      try {
         ((IGamesService)this.hw()).method_590(new GamesClientImpl.GameMuteStatusLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: p (java.lang.String, int) void
   public void method_2013(String var1, int var2) {
      try {
         ((IGamesService)this.hw()).method_624(var1, var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: q (java.lang.String, int) void
   public void method_2014(String var1, int var2) {
      try {
         ((IGamesService)this.hw()).method_627(var1, var2);
      } catch (RemoteException var4) {
         GamesLog.method_5847("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: s (java.lang.String, java.lang.String) com.google.android.gms.games.multiplayer.realtime.RealTimeSocket
   public RealTimeSocket method_2015(String var1, String var2) {
      if(var2 != null && ParticipantUtils.method_4120(var2)) {
         RealTimeSocket var3 = (RealTimeSocket)this.field_615.get(var2);
         if(var3 == null || var3.isClosed()) {
            var3 = this.method_1868(var2);
         }

         return var3;
      } else {
         throw new IllegalArgumentException("Bad participant ID");
      }
   }

   private abstract static class AbstractPeerStatusNotifier extends GamesClientImpl.AbstractRoomStatusNotifier {
      // $FF: renamed from: Yv java.util.ArrayList
      private final ArrayList<String> field_1325 = new ArrayList();

      AbstractPeerStatusNotifier(DataHolder var1, String[] var2) {
         super(var1);
         int var3 = 0;

         for(int var4 = var2.length; var3 < var4; ++var3) {
            this.field_1325.add(var2[var3]);
         }

      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
      protected void method_2788(RoomStatusUpdateListener var1, Room var2) {
         this.method_2789(var1, var2, this.field_1325);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
      protected abstract void method_2789(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3);
   }

   private abstract static class AbstractRoomNotifier extends a<RoomUpdateListener> {
      AbstractRoomNotifier(DataHolder var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.common.data.DataHolder) void
      protected void method_2785(RoomUpdateListener var1, DataHolder var2) {
         this.method_2786(var1, GamesClientImpl.method_1866(var2), var2.getStatusCode());
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, int) void
      protected abstract void method_2786(RoomUpdateListener var1, Room var2, int var3);
   }

   private abstract static class AbstractRoomStatusNotifier extends a<RoomStatusUpdateListener> {
      AbstractRoomStatusNotifier(DataHolder var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.common.data.DataHolder) void
      protected void method_2787(RoomStatusUpdateListener var1, DataHolder var2) {
         this.method_2788(var1, GamesClientImpl.method_1866(var2));
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
      protected abstract void method_2788(RoomStatusUpdateListener var1, Room var2);
   }

   private static final class AcceptQuestResultImpl extends class_481 implements Quests.AcceptQuestResult {
      // $FF: renamed from: Yw com.google.android.gms.games.quest.Quest
      private final Quest field_1698;

      AcceptQuestResultImpl(DataHolder var1) {
         super(var1);
         QuestBuffer var2 = new QuestBuffer(var1);

         try {
            if(var2.getCount() > 0) {
               this.field_1698 = new QuestEntity((Quest)var2.get(0));
            } else {
               this.field_1698 = null;
            }
         } finally {
            var2.release();
         }

      }

      public Quest getQuest() {
         return this.field_1698;
      }
   }

   private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Achievements.UpdateAchievementResult> field_925;

      AchievementUpdatedBinderCallback(BaseImplementation.class_1058<Achievements.UpdateAchievementResult> var1) {
         this.field_925 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: g (int, java.lang.String) void
      public void method_339(int var1, String var2) {
         this.field_925.method_110(new GamesClientImpl.UpdateAchievementResultImpl(var1, var2));
      }
   }

   private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Achievements.LoadAchievementsResult> field_926;

      AchievementsLoadedBinderCallback(BaseImplementation.class_1058<Achievements.LoadAchievementsResult> var1) {
         this.field_926 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder) void
      public void method_323(DataHolder var1) {
         this.field_926.method_110(new GamesClientImpl.LoadAchievementsResultImpl(var1));
      }
   }

   private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Yx com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<AppContents.LoadAppContentResult> field_951;

      public AppContentLoadedBinderCallbacks(BaseImplementation.class_1058<AppContents.LoadAppContentResult> var1) {
         this.field_951 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder[]) void
      public void method_318(DataHolder[] var1) {
         this.field_951.method_110(new GamesClientImpl.LoadAppContentsResultImpl(var1));
      }
   }

   private static final class CancelMatchResultImpl implements TurnBasedMultiplayer.CancelMatchResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_3951;
      // $FF: renamed from: Yy java.lang.String
      private final String field_3952;

      CancelMatchResultImpl(Status var1, String var2) {
         this.field_3951 = var1;
         this.field_3952 = var2;
      }

      public String getMatchId() {
         return this.field_3952;
      }

      public Status getStatus() {
         return this.field_3951;
      }
   }

   private static final class ClaimMilestoneResultImpl extends class_481 implements Quests.ClaimMilestoneResult {
      // $FF: renamed from: Yw com.google.android.gms.games.quest.Quest
      private final Quest field_1681;
      // $FF: renamed from: Yz com.google.android.gms.games.quest.Milestone
      private final Milestone field_1682;

      ClaimMilestoneResultImpl(DataHolder param1, String param2) {
         // $FF: Couldn't be decompiled
      }

      public Milestone getMilestone() {
         return this.field_1682;
      }

      public Quest getQuest() {
         return this.field_1681;
      }
   }

   private static final class CommitSnapshotResultImpl extends class_481 implements Snapshots.CommitSnapshotResult {
      // $FF: renamed from: YA com.google.android.gms.games.snapshot.SnapshotMetadata
      private final SnapshotMetadata field_1683;

      CommitSnapshotResultImpl(DataHolder var1) {
         super(var1);
         SnapshotMetadataBuffer var2 = new SnapshotMetadataBuffer(var1);

         try {
            if(var2.getCount() > 0) {
               this.field_1683 = new SnapshotMetadataEntity(var2.get(0));
            } else {
               this.field_1683 = null;
            }
         } finally {
            var2.release();
         }

      }

      public SnapshotMetadata getSnapshotMetadata() {
         return this.field_1683;
      }
   }

   private static final class ConnectedToRoomNotifier extends GamesClientImpl.AbstractRoomStatusNotifier {
      ConnectedToRoomNotifier(DataHolder var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
      public void method_2788(RoomStatusUpdateListener var1, Room var2) {
         var1.onConnectedToRoom(var2);
      }
   }

   private static final class ContactSettingLoadResultImpl extends class_481 implements Notifications.ContactSettingLoadResult {
      ContactSettingLoadResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Notifications.ContactSettingLoadResult> field_948;

      ContactSettingsLoadedBinderCallback(BaseImplementation.class_1058<Notifications.ContactSettingLoadResult> var1) {
         this.field_948 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: D (com.google.android.gms.common.data.DataHolder) void
      public void method_299(DataHolder var1) {
         this.field_948.method_110(new GamesClientImpl.ContactSettingLoadResultImpl(var1));
      }
   }

   private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Status> field_917;

      ContactSettingsUpdatedBinderCallback(BaseImplementation.class_1058<Status> var1) {
         this.field_917 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: dP (int) void
      public void method_329(int var1) {
         this.field_917.method_110(new Status(var1));
      }
   }

   private static final class DeleteSnapshotResultImpl implements Snapshots.DeleteSnapshotResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_522;
      // $FF: renamed from: YB java.lang.String
      private final String field_523;

      DeleteSnapshotResultImpl(int var1, String var2) {
         this.field_522 = new Status(var1);
         this.field_523 = var2;
      }

      public String getSnapshotId() {
         return this.field_523;
      }

      public Status getStatus() {
         return this.field_522;
      }
   }

   private static final class DisconnectedFromRoomNotifier extends GamesClientImpl.AbstractRoomStatusNotifier {
      DisconnectedFromRoomNotifier(DataHolder var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
      public void method_2788(RoomStatusUpdateListener var1, Room var2) {
         var1.onDisconnectedFromRoom(var2);
      }
   }

   private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Events.LoadEventsResult> field_928;

      EventsLoadedBinderCallback(BaseImplementation.class_1058<Events.LoadEventsResult> var1) {
         this.field_928 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder) void
      public void method_326(DataHolder var1) {
         this.field_928.method_110(new GamesClientImpl.LoadEventResultImpl(var1));
      }
   }

   private static final class ExtendedGamesLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<GamesMetadata.LoadExtendedGamesResult> field_931;

      ExtendedGamesLoadedBinderCallback(BaseImplementation.class_1058<GamesMetadata.LoadExtendedGamesResult> var1) {
         this.field_931 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: j (com.google.android.gms.common.data.DataHolder) void
      public void method_345(DataHolder var1) {
         this.field_931.method_110(new GamesClientImpl.LoadExtendedGamesResultImpl(var1));
      }
   }

   private class GameClientEventIncrementCache extends EventIncrementCache {
      public GameClientEventIncrementCache() {
         super(GamesClientImpl.this.getContext().getMainLooper(), 1000);
      }

      // $FF: renamed from: r (java.lang.String, int) void
      protected void method_4162(String var1, int var2) {
         try {
            if(GamesClientImpl.this.isConnected()) {
               ((IGamesService)GamesClientImpl.this.hw()).method_622(var1, var2);
            } else {
               GamesLog.method_5848("GamesClientImpl", "Unable to increment event " + var1 + " by " + var2 + " because the games client is no longer connected");
            }
         } catch (RemoteException var4) {
            GamesLog.method_5847("GamesClientImpl", "service died");
         }
      }
   }

   private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<GamesMetadata.LoadGameInstancesResult> field_960;

      GameInstancesLoadedBinderCallback(BaseImplementation.class_1058<GamesMetadata.LoadGameInstancesResult> var1) {
         this.field_960 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: k (com.google.android.gms.common.data.DataHolder) void
      public void method_346(DataHolder var1) {
         this.field_960.method_110(new GamesClientImpl.LoadGameInstancesResultImpl(var1));
      }
   }

   private static final class GameMuteStatusChangeResultImpl implements Notifications.GameMuteStatusChangeResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_3844;
      // $FF: renamed from: YC java.lang.String
      private final String field_3845;
      // $FF: renamed from: YD boolean
      private final boolean field_3846;

      public GameMuteStatusChangeResultImpl(int var1, String var2, boolean var3) {
         this.field_3844 = new Status(var1);
         this.field_3845 = var2;
         this.field_3846 = var3;
      }

      public Status getStatus() {
         return this.field_3844;
      }
   }

   private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Notifications.GameMuteStatusChangeResult> field_945;

      GameMuteStatusChangedBinderCallback(BaseImplementation.class_1058<Notifications.GameMuteStatusChangeResult> var1) {
         this.field_945 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: a (int, java.lang.String, boolean) void
      public void method_313(int var1, String var2, boolean var3) {
         this.field_945.method_110(new GamesClientImpl.GameMuteStatusChangeResultImpl(var1, var2, var3));
      }
   }

   private static final class GameMuteStatusLoadResultImpl implements Notifications.GameMuteStatusLoadResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_4478;
      // $FF: renamed from: YC java.lang.String
      private final String field_4479;
      // $FF: renamed from: YD boolean
      private final boolean field_4480;

      public GameMuteStatusLoadResultImpl(DataHolder var1) {
         try {
            this.field_4478 = new Status(var1.getStatusCode());
            if(var1.getCount() > 0) {
               this.field_4479 = var1.method_5831("external_game_id", 0, 0);
               this.field_4480 = var1.method_5832("muted", 0, 0);
            } else {
               this.field_4479 = null;
               this.field_4480 = false;
            }
         } finally {
            var1.close();
         }

      }

      public Status getStatus() {
         return this.field_4478;
      }
   }

   private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Notifications.GameMuteStatusLoadResult> field_920;

      GameMuteStatusLoadedBinderCallback(BaseImplementation.class_1058<Notifications.GameMuteStatusLoadResult> var1) {
         this.field_920 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: B (com.google.android.gms.common.data.DataHolder) void
      public void method_297(DataHolder var1) {
         this.field_920.method_110(new GamesClientImpl.GameMuteStatusLoadResultImpl(var1));
      }
   }

   private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<GamesMetadata.LoadGameSearchSuggestionsResult> field_923;

      GameSearchSuggestionsLoadedBinderCallback(BaseImplementation.class_1058<GamesMetadata.LoadGameSearchSuggestionsResult> var1) {
         this.field_923 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: l (com.google.android.gms.common.data.DataHolder) void
      public void method_347(DataHolder var1) {
         this.field_923.method_110(new GamesClientImpl.LoadGameSearchSuggestionsResultImpl(var1));
      }
   }

   private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<GamesMetadata.LoadGamesResult> field_913;

      GamesLoadedBinderCallback(BaseImplementation.class_1058<GamesMetadata.LoadGamesResult> var1) {
         this.field_913 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: i (com.google.android.gms.common.data.DataHolder) void
      public void method_344(DataHolder var1) {
         this.field_913.method_110(new GamesClientImpl.LoadGamesResultImpl(var1));
      }
   }

   private static final class InboxCountResultImpl implements Notifications.InboxCountResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_1855;
      // $FF: renamed from: YE android.os.Bundle
      private final Bundle field_1856;

      InboxCountResultImpl(Status var1, Bundle var2) {
         this.field_1855 = var1;
         this.field_1856 = var2;
      }

      public Status getStatus() {
         return this.field_1855;
      }
   }

   private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Notifications.InboxCountResult> field_914;

      InboxCountsLoadedBinderCallback(BaseImplementation.class_1058<Notifications.InboxCountResult> var1) {
         this.field_914 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: f (int, android.os.Bundle) void
      public void method_334(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         Status var3 = new Status(var1);
         this.field_914.method_110(new GamesClientImpl.InboxCountResultImpl(var3, var2));
      }
   }

   private static final class InitiateMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.InitiateMatchResult {
      InitiateMatchResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Qe com.google.android.gms.common.api.d
      private final d<OnInvitationReceivedListener> field_918;

      InvitationReceivedBinderCallback(d<OnInvitationReceivedListener> var1) {
         this.field_918 = var1;
      }

      // $FF: renamed from: n (com.google.android.gms.common.data.DataHolder) void
      public void method_349(DataHolder param1) {
         // $FF: Couldn't be decompiled
      }

      public void onInvitationRemoved(String var1) {
         this.field_918.method_5677(new GamesClientImpl.InvitationRemovedNotifier(var1));
      }
   }

   private static final class InvitationReceivedNotifier implements class_1033.class_1137<OnInvitationReceivedListener> {
      // $FF: renamed from: YF com.google.android.gms.games.multiplayer.Invitation
      private final Invitation field_2834;

      InvitationReceivedNotifier(Invitation var1) {
         this.field_2834 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.OnInvitationReceivedListener) void
      public void method_3734(OnInvitationReceivedListener var1) {
         var1.onInvitationReceived(this.field_2834);
      }

      // $FF: renamed from: c (java.lang.Object) void
      // $FF: synthetic method
      public void method_199(Object var1) {
         this.method_3734((OnInvitationReceivedListener)var1);
      }

      // $FF: renamed from: gG () void
      public void method_200() {
      }
   }

   private static final class InvitationRemovedNotifier implements class_1033.class_1137<OnInvitationReceivedListener> {
      // $FF: renamed from: YG java.lang.String
      private final String field_3043;

      InvitationRemovedNotifier(String var1) {
         this.field_3043 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.OnInvitationReceivedListener) void
      public void method_3905(OnInvitationReceivedListener var1) {
         var1.onInvitationRemoved(this.field_3043);
      }

      // $FF: renamed from: c (java.lang.Object) void
      // $FF: synthetic method
      public void method_199(Object var1) {
         this.method_3905((OnInvitationReceivedListener)var1);
      }

      // $FF: renamed from: gG () void
      public void method_200() {
      }
   }

   private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Invitations.LoadInvitationsResult> field_927;

      InvitationsLoadedBinderCallback(BaseImplementation.class_1058<Invitations.LoadInvitationsResult> var1) {
         this.field_927 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: m (com.google.android.gms.common.data.DataHolder) void
      public void method_348(DataHolder var1) {
         this.field_927.method_110(new GamesClientImpl.LoadInvitationsResultImpl(var1));
      }
   }

   private static final class JoinedRoomNotifier extends GamesClientImpl.AbstractRoomNotifier {
      public JoinedRoomNotifier(DataHolder var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, int) void
      public void method_2786(RoomUpdateListener var1, Room var2, int var3) {
         var1.onJoinedRoom(var3, var2);
      }
   }

   private static final class LeaderboardMetadataResultImpl extends class_481 implements Leaderboards.LeaderboardMetadataResult {
      // $FF: renamed from: YH com.google.android.gms.games.leaderboard.LeaderboardBuffer
      private final LeaderboardBuffer field_1697;

      LeaderboardMetadataResultImpl(DataHolder var1) {
         super(var1);
         this.field_1697 = new LeaderboardBuffer(var1);
      }

      public LeaderboardBuffer getLeaderboards() {
         return this.field_1697;
      }
   }

   private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Leaderboards.LoadScoresResult> field_922;

      LeaderboardScoresLoadedBinderCallback(BaseImplementation.class_1058<Leaderboards.LoadScoresResult> var1) {
         this.field_922 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.common.data.DataHolder) void
      public void method_314(DataHolder var1, DataHolder var2) {
         this.field_922.method_110(new GamesClientImpl.LoadScoresResultImpl(var1, var2));
      }
   }

   private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Leaderboards.LeaderboardMetadataResult> field_940;

      LeaderboardsLoadedBinderCallback(BaseImplementation.class_1058<Leaderboards.LeaderboardMetadataResult> var1) {
         this.field_940 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: e (com.google.android.gms.common.data.DataHolder) void
      public void method_332(DataHolder var1) {
         this.field_940.method_110(new GamesClientImpl.LeaderboardMetadataResultImpl(var1));
      }
   }

   private static final class LeaveMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.LeaveMatchResult {
      LeaveMatchResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class LeftRoomNotifier implements class_1033.class_1137<RoomUpdateListener> {
      // $FF: renamed from: Iv int
      private final int field_2961;
      // $FF: renamed from: YI java.lang.String
      private final String field_2962;

      LeftRoomNotifier(int var1, String var2) {
         this.field_2961 = var1;
         this.field_2962 = var2;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener) void
      public void method_3904(RoomUpdateListener var1) {
         var1.onLeftRoom(this.field_2961, this.field_2962);
      }

      // $FF: renamed from: c (java.lang.Object) void
      // $FF: synthetic method
      public void method_199(Object var1) {
         this.method_3904((RoomUpdateListener)var1);
      }

      // $FF: renamed from: gG () void
      public void method_200() {
      }
   }

   private static final class LoadAchievementsResultImpl extends class_481 implements Achievements.LoadAchievementsResult {
      // $FF: renamed from: YJ com.google.android.gms.games.achievement.AchievementBuffer
      private final AchievementBuffer field_1669;

      LoadAchievementsResultImpl(DataHolder var1) {
         super(var1);
         this.field_1669 = new AchievementBuffer(var1);
      }

      public AchievementBuffer getAchievements() {
         return this.field_1669;
      }
   }

   private static final class LoadAclResultImpl extends class_481 implements Acls.LoadAclResult {
      LoadAclResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class LoadAppContentsResultImpl extends class_481 implements AppContents.LoadAppContentResult {
      // $FF: renamed from: YK java.util.ArrayList
      private final ArrayList<DataHolder> field_1689;

      LoadAppContentsResultImpl(DataHolder[] var1) {
         super(var1[0]);
         this.field_1689 = new ArrayList(Arrays.asList(var1));
      }
   }

   private static final class LoadEventResultImpl extends class_481 implements Events.LoadEventsResult {
      // $FF: renamed from: YL com.google.android.gms.games.event.EventBuffer
      private final EventBuffer field_1673;

      LoadEventResultImpl(DataHolder var1) {
         super(var1);
         this.field_1673 = new EventBuffer(var1);
      }

      public EventBuffer getEvents() {
         return this.field_1673;
      }
   }

   private static final class LoadExtendedGamesResultImpl extends class_481 implements GamesMetadata.LoadExtendedGamesResult {
      // $FF: renamed from: YM com.google.android.gms.games.internal.game.ExtendedGameBuffer
      private final ExtendedGameBuffer field_1688;

      LoadExtendedGamesResultImpl(DataHolder var1) {
         super(var1);
         this.field_1688 = new ExtendedGameBuffer(var1);
      }
   }

   private static final class LoadGameInstancesResultImpl extends class_481 implements GamesMetadata.LoadGameInstancesResult {
      // $FF: renamed from: YN com.google.android.gms.games.internal.game.GameInstanceBuffer
      private final GameInstanceBuffer field_1695;

      LoadGameInstancesResultImpl(DataHolder var1) {
         super(var1);
         this.field_1695 = new GameInstanceBuffer(var1);
      }
   }

   private static final class LoadGameSearchSuggestionsResultImpl extends class_481 implements GamesMetadata.LoadGameSearchSuggestionsResult {
      // $FF: renamed from: YO com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer
      private final GameSearchSuggestionBuffer field_1699;

      LoadGameSearchSuggestionsResultImpl(DataHolder var1) {
         super(var1);
         this.field_1699 = new GameSearchSuggestionBuffer(var1);
      }
   }

   private static final class LoadGamesResultImpl extends class_481 implements GamesMetadata.LoadGamesResult {
      // $FF: renamed from: YP com.google.android.gms.games.GameBuffer
      private final GameBuffer field_1674;

      LoadGamesResultImpl(DataHolder var1) {
         super(var1);
         this.field_1674 = new GameBuffer(var1);
      }

      public GameBuffer getGames() {
         return this.field_1674;
      }
   }

   private static final class LoadInvitationsResultImpl extends class_481 implements Invitations.LoadInvitationsResult {
      // $FF: renamed from: YQ com.google.android.gms.games.multiplayer.InvitationBuffer
      private final InvitationBuffer field_1686;

      LoadInvitationsResultImpl(DataHolder var1) {
         super(var1);
         this.field_1686 = new InvitationBuffer(var1);
      }

      public InvitationBuffer getInvitations() {
         return this.field_1686;
      }
   }

   private static final class LoadMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.LoadMatchResult {
      LoadMatchResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class LoadMatchesResultImpl implements TurnBasedMultiplayer.LoadMatchesResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_4305;
      // $FF: renamed from: YR com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse
      private final LoadMatchesResponse field_4306;

      LoadMatchesResultImpl(Status var1, Bundle var2) {
         this.field_4305 = var1;
         this.field_4306 = new LoadMatchesResponse(var2);
      }

      public LoadMatchesResponse getMatches() {
         return this.field_4306;
      }

      public Status getStatus() {
         return this.field_4305;
      }

      public void release() {
         this.field_4306.release();
      }
   }

   private static final class LoadOwnerCoverPhotoUrisResultImpl implements Players.LoadOwnerCoverPhotoUrisResult {
      // $FF: renamed from: DJ android.os.Bundle
      private final Bundle field_3806;
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_3807;

      LoadOwnerCoverPhotoUrisResultImpl(int var1, Bundle var2) {
         this.field_3807 = new Status(var1);
         this.field_3806 = var2;
      }

      public Status getStatus() {
         return this.field_3807;
      }
   }

   private static final class LoadPlayerScoreResultImpl extends class_481 implements Leaderboards.LoadPlayerScoreResult {
      // $FF: renamed from: YS com.google.android.gms.games.leaderboard.LeaderboardScoreEntity
      private final LeaderboardScoreEntity field_1696;

      LoadPlayerScoreResultImpl(DataHolder var1) {
         super(var1);
         LeaderboardScoreBuffer var2 = new LeaderboardScoreBuffer(var1);

         try {
            if(var2.getCount() > 0) {
               this.field_1696 = (LeaderboardScoreEntity)var2.get(0).freeze();
            } else {
               this.field_1696 = null;
            }
         } finally {
            var2.release();
         }

      }

      public LeaderboardScore getScore() {
         return this.field_1696;
      }
   }

   private static final class LoadPlayersResultImpl extends class_481 implements Players.LoadPlayersResult {
      // $FF: renamed from: YT com.google.android.gms.games.PlayerBuffer
      private final PlayerBuffer field_1687;

      LoadPlayersResultImpl(DataHolder var1) {
         super(var1);
         this.field_1687 = new PlayerBuffer(var1);
      }

      public PlayerBuffer getPlayers() {
         return this.field_1687;
      }
   }

   private static final class LoadProfileSettingsResultImpl extends class_481 implements Players.LoadProfileSettingsResult {
      // $FF: renamed from: YU boolean
      private final boolean field_1676;
      // $FF: renamed from: Yh boolean
      private final boolean field_1677;

      LoadProfileSettingsResultImpl(DataHolder var1) {
         super(var1);

         try {
            if(var1.getCount() > 0) {
               int var3 = var1.method_5829(0);
               this.field_1677 = var1.method_5832("profile_visible", 0, var3);
               this.field_1676 = var1.method_5832("profile_visibility_explicitly_set", 0, var3);
            } else {
               this.field_1677 = true;
               this.field_1676 = false;
            }
         } finally {
            var1.close();
         }

      }

      public Status getStatus() {
         return this.Eb;
      }

      public boolean isProfileVisible() {
         return this.field_1677;
      }

      public boolean isVisibilityExplicitlySet() {
         return this.field_1676;
      }
   }

   private static final class LoadQuestsResultImpl extends class_481 implements Quests.LoadQuestsResult {
      // $FF: renamed from: JG com.google.android.gms.common.data.DataHolder
      private final DataHolder field_1675;

      LoadQuestsResultImpl(DataHolder var1) {
         super(var1);
         this.field_1675 = var1;
      }

      public QuestBuffer getQuests() {
         return new QuestBuffer(this.field_1675);
      }
   }

   private static final class LoadRequestSummariesResultImpl extends class_481 implements Requests.LoadRequestSummariesResult {
      LoadRequestSummariesResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class LoadRequestsResultImpl implements Requests.LoadRequestsResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_4499;
      // $FF: renamed from: YV android.os.Bundle
      private final Bundle field_4500;

      LoadRequestsResultImpl(Status var1, Bundle var2) {
         this.field_4499 = var1;
         this.field_4500 = var2;
      }

      public GameRequestBuffer getRequests(int var1) {
         String var2 = RequestType.method_5123(var1);
         return !this.field_4500.containsKey(var2)?null:new GameRequestBuffer((DataHolder)this.field_4500.get(var2));
      }

      public Status getStatus() {
         return this.field_4499;
      }

      public void release() {
         Iterator var1 = this.field_4500.keySet().iterator();

         while(var1.hasNext()) {
            String var2 = (String)var1.next();
            DataHolder var3 = (DataHolder)this.field_4500.getParcelable(var2);
            if(var3 != null) {
               var3.close();
            }
         }

      }
   }

   private static final class LoadScoresResultImpl extends class_481 implements Leaderboards.LoadScoresResult {
      // $FF: renamed from: YW com.google.android.gms.games.leaderboard.LeaderboardEntity
      private final LeaderboardEntity field_1671;
      // $FF: renamed from: YX com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer
      private final LeaderboardScoreBuffer field_1672;

      LoadScoresResultImpl(DataHolder var1, DataHolder var2) {
         super(var2);
         LeaderboardBuffer var3 = new LeaderboardBuffer(var1);

         try {
            if(var3.getCount() > 0) {
               this.field_1671 = (LeaderboardEntity)((Leaderboard)var3.get(0)).freeze();
            } else {
               this.field_1671 = null;
            }
         } finally {
            var3.release();
         }

         this.field_1672 = new LeaderboardScoreBuffer(var2);
      }

      public Leaderboard getLeaderboard() {
         return this.field_1671;
      }

      public LeaderboardScoreBuffer getScores() {
         return this.field_1672;
      }
   }

   private static final class LoadSnapshotsResultImpl extends class_481 implements Snapshots.LoadSnapshotsResult {
      LoadSnapshotsResultImpl(DataHolder var1) {
         super(var1);
      }

      public SnapshotMetadataBuffer getSnapshots() {
         return new SnapshotMetadataBuffer(this.JG);
      }
   }

   private static final class LoadXpForGameCategoriesResultImpl implements Players.LoadXpForGameCategoriesResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_3665;
      // $FF: renamed from: YY java.util.List
      private final List<String> field_3666;
      // $FF: renamed from: YZ android.os.Bundle
      private final Bundle field_3667;

      LoadXpForGameCategoriesResultImpl(Status var1, Bundle var2) {
         this.field_3665 = var1;
         this.field_3666 = var2.getStringArrayList("game_category_list");
         this.field_3667 = var2;
      }

      public Status getStatus() {
         return this.field_3665;
      }
   }

   private static final class LoadXpStreamResultImpl extends class_481 implements Players.LoadXpStreamResult {
      // $FF: renamed from: Za com.google.android.gms.games.internal.experience.ExperienceEventBuffer
      private final ExperienceEventBuffer field_1670;

      LoadXpStreamResultImpl(DataHolder var1) {
         super(var1);
         this.field_1670 = new ExperienceEventBuffer(var1);
      }
   }

   private static final class MatchRemovedNotifier implements class_1033.class_1137<OnTurnBasedMatchUpdateReceivedListener> {
      // $FF: renamed from: Zb java.lang.String
      private final String field_4115;

      MatchRemovedNotifier(String var1) {
         this.field_4115 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener) void
      public void method_5375(OnTurnBasedMatchUpdateReceivedListener var1) {
         var1.onTurnBasedMatchRemoved(this.field_4115);
      }

      // $FF: renamed from: c (java.lang.Object) void
      // $FF: synthetic method
      public void method_199(Object var1) {
         this.method_5375((OnTurnBasedMatchUpdateReceivedListener)var1);
      }

      // $FF: renamed from: gG () void
      public void method_200() {
      }
   }

   private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Qe com.google.android.gms.common.api.d
      private final d<OnTurnBasedMatchUpdateReceivedListener> field_921;

      MatchUpdateReceivedBinderCallback(d<OnTurnBasedMatchUpdateReceivedListener> var1) {
         this.field_921 = var1;
      }

      public void onTurnBasedMatchRemoved(String var1) {
         this.field_921.method_5677(new GamesClientImpl.MatchRemovedNotifier(var1));
      }

      // $FF: renamed from: t (com.google.android.gms.common.data.DataHolder) void
      public void method_355(DataHolder param1) {
         // $FF: Couldn't be decompiled
      }
   }

   private static final class MatchUpdateReceivedNotifier implements class_1033.class_1137<OnTurnBasedMatchUpdateReceivedListener> {
      // $FF: renamed from: Zc com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
      private final TurnBasedMatch field_2748;

      MatchUpdateReceivedNotifier(TurnBasedMatch var1) {
         this.field_2748 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener) void
      public void method_3563(OnTurnBasedMatchUpdateReceivedListener var1) {
         var1.onTurnBasedMatchReceived(this.field_2748);
      }

      // $FF: renamed from: c (java.lang.Object) void
      // $FF: synthetic method
      public void method_199(Object var1) {
         this.method_3563((OnTurnBasedMatchUpdateReceivedListener)var1);
      }

      // $FF: renamed from: gG () void
      public void method_200() {
      }
   }

   private static final class MessageReceivedNotifier implements class_1033.class_1137<RealTimeMessageReceivedListener> {
      // $FF: renamed from: Zd com.google.android.gms.games.multiplayer.realtime.RealTimeMessage
      private final RealTimeMessage field_4509;

      MessageReceivedNotifier(RealTimeMessage var1) {
         this.field_4509 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener) void
      public void method_5865(RealTimeMessageReceivedListener var1) {
         var1.onRealTimeMessageReceived(this.field_4509);
      }

      // $FF: renamed from: c (java.lang.Object) void
      // $FF: synthetic method
      public void method_199(Object var1) {
         this.method_5865((RealTimeMessageReceivedListener)var1);
      }

      // $FF: renamed from: gG () void
      public void method_200() {
      }
   }

   private static final class NearbyPlayerDetectedNotifier implements class_1033.class_1137<OnNearbyPlayerDetectedListener> {
      // $FF: renamed from: Ze com.google.android.gms.games.Player
      private final Player field_3917;

      // $FF: renamed from: a (com.google.android.gms.games.OnNearbyPlayerDetectedListener) void
      public void method_5139(OnNearbyPlayerDetectedListener var1) {
         var1.method_1004(this.field_3917);
      }

      // $FF: renamed from: c (java.lang.Object) void
      // $FF: synthetic method
      public void method_199(Object var1) {
         this.method_5139((OnNearbyPlayerDetectedListener)var1);
      }

      // $FF: renamed from: gG () void
      public void method_200() {
      }
   }

   private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Acls.LoadAclResult> field_963;

      NotifyAclLoadedBinderCallback(BaseImplementation.class_1058<Acls.LoadAclResult> var1) {
         this.field_963 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: C (com.google.android.gms.common.data.DataHolder) void
      public void method_298(DataHolder var1) {
         this.field_963.method_110(new GamesClientImpl.LoadAclResultImpl(var1));
      }
   }

   private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Status> field_955;

      NotifyAclUpdatedBinderCallback(BaseImplementation.class_1058<Status> var1) {
         this.field_955 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: dO (int) void
      public void method_328(int var1) {
         this.field_955.method_110(new Status(var1));
      }
   }

   private static final class OpenSnapshotResultImpl extends class_481 implements Snapshots.OpenSnapshotResult {
      // $FF: renamed from: Zf com.google.android.gms.games.snapshot.Snapshot
      private final Snapshot field_1690;
      // $FF: renamed from: Zg java.lang.String
      private final String field_1691;
      // $FF: renamed from: Zh com.google.android.gms.games.snapshot.Snapshot
      private final Snapshot field_1692;
      // $FF: renamed from: Zi com.google.android.gms.drive.Contents
      private final Contents field_1693;
      // $FF: renamed from: Zj com.google.android.gms.games.snapshot.SnapshotContents
      private final SnapshotContents field_1694;

      OpenSnapshotResultImpl(DataHolder var1, Contents var2) {
         this(var1, (String)null, var2, (Contents)null, (Contents)null);
      }

      OpenSnapshotResultImpl(DataHolder param1, String param2, Contents param3, Contents param4, Contents param5) {
         // $FF: Couldn't be decompiled
      }

      public String getConflictId() {
         return this.field_1691;
      }

      public Snapshot getConflictingSnapshot() {
         return this.field_1692;
      }

      public SnapshotContents getResolutionSnapshotContents() {
         return this.field_1694;
      }

      public Snapshot getSnapshot() {
         return this.field_1690;
      }
   }

   private static final class OwnerCoverPhotoUrisLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Players.LoadOwnerCoverPhotoUrisResult> field_944;

      OwnerCoverPhotoUrisLoadedBinderCallback(BaseImplementation.class_1058<Players.LoadOwnerCoverPhotoUrisResult> var1) {
         this.field_944 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: d (int, android.os.Bundle) void
      public void method_325(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         this.field_944.method_110(new GamesClientImpl.LoadOwnerCoverPhotoUrisResultImpl(var1, var2));
      }
   }

   private static final class P2PConnectedNotifier implements class_1033.class_1137<RoomStatusUpdateListener> {
      // $FF: renamed from: Zk java.lang.String
      private final String field_3570;

      P2PConnectedNotifier(String var1) {
         this.field_3570 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener) void
      public void method_4744(RoomStatusUpdateListener var1) {
         var1.onP2PConnected(this.field_3570);
      }

      // $FF: renamed from: c (java.lang.Object) void
      // $FF: synthetic method
      public void method_199(Object var1) {
         this.method_4744((RoomStatusUpdateListener)var1);
      }

      // $FF: renamed from: gG () void
      public void method_200() {
      }
   }

   private static final class P2PDisconnectedNotifier implements class_1033.class_1137<RoomStatusUpdateListener> {
      // $FF: renamed from: Zk java.lang.String
      private final String field_4010;

      P2PDisconnectedNotifier(String var1) {
         this.field_4010 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener) void
      public void method_5299(RoomStatusUpdateListener var1) {
         var1.onP2PDisconnected(this.field_4010);
      }

      // $FF: renamed from: c (java.lang.Object) void
      // $FF: synthetic method
      public void method_199(Object var1) {
         this.method_5299((RoomStatusUpdateListener)var1);
      }

      // $FF: renamed from: gG () void
      public void method_200() {
      }
   }

   private static final class PeerConnectedNotifier extends GamesClientImpl.AbstractPeerStatusNotifier {
      PeerConnectedNotifier(DataHolder var1, String[] var2) {
         super(var1, var2);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
      protected void method_2789(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
         var1.onPeersConnected(var2, var3);
      }
   }

   private static final class PeerDeclinedNotifier extends GamesClientImpl.AbstractPeerStatusNotifier {
      PeerDeclinedNotifier(DataHolder var1, String[] var2) {
         super(var1, var2);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
      protected void method_2789(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
         var1.onPeerDeclined(var2, var3);
      }
   }

   private static final class PeerDisconnectedNotifier extends GamesClientImpl.AbstractPeerStatusNotifier {
      PeerDisconnectedNotifier(DataHolder var1, String[] var2) {
         super(var1, var2);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
      protected void method_2789(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
         var1.onPeersDisconnected(var2, var3);
      }
   }

   private static final class PeerInvitedToRoomNotifier extends GamesClientImpl.AbstractPeerStatusNotifier {
      PeerInvitedToRoomNotifier(DataHolder var1, String[] var2) {
         super(var1, var2);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
      protected void method_2789(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
         var1.onPeerInvitedToRoom(var2, var3);
      }
   }

   private static final class PeerJoinedRoomNotifier extends GamesClientImpl.AbstractPeerStatusNotifier {
      PeerJoinedRoomNotifier(DataHolder var1, String[] var2) {
         super(var1, var2);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
      protected void method_2789(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
         var1.onPeerJoined(var2, var3);
      }
   }

   private static final class PeerLeftRoomNotifier extends GamesClientImpl.AbstractPeerStatusNotifier {
      PeerLeftRoomNotifier(DataHolder var1, String[] var2) {
         super(var1, var2);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
      protected void method_2789(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
         var1.onPeerLeft(var2, var3);
      }
   }

   private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Leaderboards.LoadPlayerScoreResult> field_961;

      PlayerLeaderboardScoreLoadedBinderCallback(BaseImplementation.class_1058<Leaderboards.LoadPlayerScoreResult> var1) {
         this.field_961 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: E (com.google.android.gms.common.data.DataHolder) void
      public void method_300(DataHolder var1) {
         this.field_961.method_110(new GamesClientImpl.LoadPlayerScoreResultImpl(var1));
      }
   }

   private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Players.LoadXpForGameCategoriesResult> field_929;

      PlayerXpForGameCategoriesLoadedBinderCallback(BaseImplementation.class_1058<Players.LoadXpForGameCategoriesResult> var1) {
         this.field_929 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: e (int, android.os.Bundle) void
      public void method_331(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         Status var3 = new Status(var1);
         this.field_929.method_110(new GamesClientImpl.LoadXpForGameCategoriesResultImpl(var3, var2));
      }
   }

   static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Players.LoadXpStreamResult> field_939;

      PlayerXpStreamLoadedBinderCallback(BaseImplementation.class_1058<Players.LoadXpStreamResult> var1) {
         this.field_939 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: P (com.google.android.gms.common.data.DataHolder) void
      public void method_311(DataHolder var1) {
         this.field_939.method_110(new GamesClientImpl.LoadXpStreamResultImpl(var1));
      }
   }

   private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Players.LoadPlayersResult> field_959;

      PlayersLoadedBinderCallback(BaseImplementation.class_1058<Players.LoadPlayersResult> var1) {
         this.field_959 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: g (com.google.android.gms.common.data.DataHolder) void
      public void method_340(DataHolder var1) {
         this.field_959.method_110(new GamesClientImpl.LoadPlayersResultImpl(var1));
      }

      // $FF: renamed from: h (com.google.android.gms.common.data.DataHolder) void
      public void method_342(DataHolder var1) {
         this.field_959.method_110(new GamesClientImpl.LoadPlayersResultImpl(var1));
      }
   }

   static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Players.LoadProfileSettingsResult> field_937;

      ProfileSettingsLoadedBinderCallback(BaseImplementation.class_1058<Players.LoadProfileSettingsResult> var1) {
         this.field_937 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: Q (com.google.android.gms.common.data.DataHolder) void
      public void method_312(DataHolder var1) {
         this.field_937.method_110(new GamesClientImpl.LoadProfileSettingsResultImpl(var1));
      }
   }

   private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Status> field_957;

      ProfileSettingsUpdatedBinderCallback(BaseImplementation.class_1058<Status> var1) {
         this.field_957 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: dQ (int) void
      public void method_330(int var1) {
         this.field_957.method_110(new Status(var1));
      }
   }

   private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Zl com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Quests.AcceptQuestResult> field_965;

      public QuestAcceptedBinderCallbacks(BaseImplementation.class_1058<Quests.AcceptQuestResult> var1) {
         this.field_965 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: L (com.google.android.gms.common.data.DataHolder) void
      public void method_307(DataHolder var1) {
         this.field_965.method_110(new GamesClientImpl.AcceptQuestResultImpl(var1));
      }
   }

   private static final class QuestCompletedNotifier implements class_1033.class_1137<QuestUpdateListener> {
      // $FF: renamed from: Yw com.google.android.gms.games.quest.Quest
      private final Quest field_4173;

      QuestCompletedNotifier(Quest var1) {
         this.field_4173 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.games.quest.QuestUpdateListener) void
      public void method_5422(QuestUpdateListener var1) {
         var1.onQuestCompleted(this.field_4173);
      }

      // $FF: renamed from: c (java.lang.Object) void
      // $FF: synthetic method
      public void method_199(Object var1) {
         this.method_5422((QuestUpdateListener)var1);
      }

      // $FF: renamed from: gG () void
      public void method_200() {
      }
   }

   private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Zm com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Quests.ClaimMilestoneResult> field_934;
      // $FF: renamed from: Zn java.lang.String
      private final String field_935;

      public QuestMilestoneClaimBinderCallbacks(BaseImplementation.class_1058<Quests.ClaimMilestoneResult> var1, String var2) {
         this.field_934 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
         this.field_935 = (String)class_335.method_2306(var2, "MilestoneId must not be null");
      }

      // $FF: renamed from: K (com.google.android.gms.common.data.DataHolder) void
      public void method_306(DataHolder var1) {
         this.field_934.method_110(new GamesClientImpl.ClaimMilestoneResultImpl(var1, this.field_935));
      }
   }

   private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Qe com.google.android.gms.common.api.d
      private final d<QuestUpdateListener> field_953;

      QuestUpdateBinderCallback(d<QuestUpdateListener> var1) {
         this.field_953 = var1;
      }

      // $FF: renamed from: T (com.google.android.gms.common.data.DataHolder) com.google.android.gms.games.quest.Quest
      private Quest method_2349(DataHolder param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: M (com.google.android.gms.common.data.DataHolder) void
      public void method_308(DataHolder var1) {
         Quest var2 = this.method_2349(var1);
         if(var2 != null) {
            this.field_953.method_5677(new GamesClientImpl.QuestCompletedNotifier(var2));
         }

      }
   }

   private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Zo com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Quests.LoadQuestsResult> field_947;

      public QuestsLoadedBinderCallbacks(BaseImplementation.class_1058<Quests.LoadQuestsResult> var1) {
         this.field_947 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: O (com.google.android.gms.common.data.DataHolder) void
      public void method_310(DataHolder var1) {
         this.field_947.method_110(new GamesClientImpl.LoadQuestsResultImpl(var1));
      }
   }

   private static final class RealTimeMessageSentNotifier implements class_1033.class_1137<RealTimeMultiplayer.ReliableMessageSentCallback> {
      // $FF: renamed from: Iv int
      private final int field_3448;
      // $FF: renamed from: Zp java.lang.String
      private final String field_3449;
      // $FF: renamed from: Zq int
      private final int field_3450;

      RealTimeMessageSentNotifier(int var1, int var2, String var3) {
         this.field_3448 = var1;
         this.field_3450 = var2;
         this.field_3449 = var3;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer$ReliableMessageSentCallback) void
      public void method_4478(RealTimeMultiplayer.ReliableMessageSentCallback var1) {
         if(var1 != null) {
            var1.onRealTimeMessageSent(this.field_3448, this.field_3450, this.field_3449);
         }

      }

      // $FF: renamed from: c (java.lang.Object) void
      // $FF: synthetic method
      public void method_199(Object var1) {
         this.method_4478((RealTimeMultiplayer.ReliableMessageSentCallback)var1);
      }

      // $FF: renamed from: gG () void
      public void method_200() {
      }
   }

   private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Zr com.google.android.gms.common.api.d
      final d<RealTimeMultiplayer.ReliableMessageSentCallback> field_924;

      public RealTimeReliableMessageBinderCallbacks(d<RealTimeMultiplayer.ReliableMessageSentCallback> var1) {
         this.field_924 = var1;
      }

      // $FF: renamed from: b (int, int, java.lang.String) void
      public void method_319(int var1, int var2, String var3) {
         if(this.field_924 != null) {
            this.field_924.method_5677(new GamesClientImpl.RealTimeMessageSentNotifier(var1, var2, var3));
         }

      }
   }

   private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Qe com.google.android.gms.common.api.d
      private final d<OnRequestReceivedListener> field_916;

      RequestReceivedBinderCallback(d<OnRequestReceivedListener> var1) {
         this.field_916 = var1;
      }

      // $FF: renamed from: o (com.google.android.gms.common.data.DataHolder) void
      public void method_350(DataHolder param1) {
         // $FF: Couldn't be decompiled
      }

      public void onRequestRemoved(String var1) {
         this.field_916.method_5677(new GamesClientImpl.RequestRemovedNotifier(var1));
      }
   }

   private static final class RequestReceivedNotifier implements class_1033.class_1137<OnRequestReceivedListener> {
      // $FF: renamed from: Zs com.google.android.gms.games.request.GameRequest
      private final GameRequest field_2718;

      RequestReceivedNotifier(GameRequest var1) {
         this.field_2718 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.games.request.OnRequestReceivedListener) void
      public void method_3504(OnRequestReceivedListener var1) {
         var1.onRequestReceived(this.field_2718);
      }

      // $FF: renamed from: c (java.lang.Object) void
      // $FF: synthetic method
      public void method_199(Object var1) {
         this.method_3504((OnRequestReceivedListener)var1);
      }

      // $FF: renamed from: gG () void
      public void method_200() {
      }
   }

   private static final class RequestRemovedNotifier implements class_1033.class_1137<OnRequestReceivedListener> {
      // $FF: renamed from: Zt java.lang.String
      private final String field_3576;

      RequestRemovedNotifier(String var1) {
         this.field_3576 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.games.request.OnRequestReceivedListener) void
      public void method_4752(OnRequestReceivedListener var1) {
         var1.onRequestRemoved(this.field_3576);
      }

      // $FF: renamed from: c (java.lang.Object) void
      // $FF: synthetic method
      public void method_199(Object var1) {
         this.method_4752((OnRequestReceivedListener)var1);
      }

      // $FF: renamed from: gG () void
      public void method_200() {
      }
   }

   private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Zu com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Requests.SendRequestResult> field_949;

      public RequestSentBinderCallbacks(BaseImplementation.class_1058<Requests.SendRequestResult> var1) {
         this.field_949 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: G (com.google.android.gms.common.data.DataHolder) void
      public void method_302(DataHolder var1) {
         this.field_949.method_110(new GamesClientImpl.SendRequestResultImpl(var1));
      }
   }

   private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Zv com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Requests.LoadRequestSummariesResult> field_962;

      public RequestSummariesLoadedBinderCallbacks(BaseImplementation.class_1058<Requests.LoadRequestSummariesResult> var1) {
         this.field_962 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: H (com.google.android.gms.common.data.DataHolder) void
      public void method_303(DataHolder var1) {
         this.field_962.method_110(new GamesClientImpl.LoadRequestSummariesResultImpl(var1));
      }
   }

   private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Zw com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Requests.LoadRequestsResult> field_919;

      public RequestsLoadedBinderCallbacks(BaseImplementation.class_1058<Requests.LoadRequestsResult> var1) {
         this.field_919 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: c (int, android.os.Bundle) void
      public void method_322(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         Status var3 = new Status(var1);
         this.field_919.method_110(new GamesClientImpl.LoadRequestsResultImpl(var3, var2));
      }
   }

   private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Zx com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Requests.UpdateRequestsResult> field_915;

      public RequestsUpdatedBinderCallbacks(BaseImplementation.class_1058<Requests.UpdateRequestsResult> var1) {
         this.field_915 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: F (com.google.android.gms.common.data.DataHolder) void
      public void method_301(DataHolder var1) {
         this.field_915.method_110(new GamesClientImpl.UpdateRequestsResultImpl(var1));
      }
   }

   private static final class RoomAutoMatchingNotifier extends GamesClientImpl.AbstractRoomStatusNotifier {
      RoomAutoMatchingNotifier(DataHolder var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
      public void method_2788(RoomStatusUpdateListener var1, Room var2) {
         var1.onRoomAutoMatching(var2);
      }
   }

   private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: ZA com.google.android.gms.common.api.d
      private final d<RealTimeMessageReceivedListener> field_941;
      // $FF: renamed from: Zy com.google.android.gms.common.api.d
      private final d<? extends RoomUpdateListener> field_942;
      // $FF: renamed from: Zz com.google.android.gms.common.api.d
      private final d<? extends RoomStatusUpdateListener> field_943;

      public RoomBinderCallbacks(d<RoomUpdateListener> var1) {
         this.field_942 = (class_1033)class_335.method_2306(var1, "Callbacks must not be null");
         this.field_943 = null;
         this.field_941 = null;
      }

      public RoomBinderCallbacks(d<? extends RoomUpdateListener> var1, d<? extends RoomStatusUpdateListener> var2, d<RealTimeMessageReceivedListener> var3) {
         this.field_942 = (class_1033)class_335.method_2306(var1, "Callbacks must not be null");
         this.field_943 = var2;
         this.field_941 = var3;
      }

      // $FF: renamed from: A (com.google.android.gms.common.data.DataHolder) void
      public void method_296(DataHolder var1) {
         if(this.field_943 != null) {
            this.field_943.method_5677(new GamesClientImpl.DisconnectedFromRoomNotifier(var1));
         }

      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_317(DataHolder var1, String[] var2) {
         if(this.field_943 != null) {
            this.field_943.method_5677(new GamesClientImpl.PeerInvitedToRoomNotifier(var1, var2));
         }

      }

      // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_321(DataHolder var1, String[] var2) {
         if(this.field_943 != null) {
            this.field_943.method_5677(new GamesClientImpl.PeerJoinedRoomNotifier(var1, var2));
         }

      }

      // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_324(DataHolder var1, String[] var2) {
         if(this.field_943 != null) {
            this.field_943.method_5677(new GamesClientImpl.PeerLeftRoomNotifier(var1, var2));
         }

      }

      // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_327(DataHolder var1, String[] var2) {
         if(this.field_943 != null) {
            this.field_943.method_5677(new GamesClientImpl.PeerDeclinedNotifier(var1, var2));
         }

      }

      // $FF: renamed from: e (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_333(DataHolder var1, String[] var2) {
         if(this.field_943 != null) {
            this.field_943.method_5677(new GamesClientImpl.PeerConnectedNotifier(var1, var2));
         }

      }

      // $FF: renamed from: f (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_337(DataHolder var1, String[] var2) {
         if(this.field_943 != null) {
            this.field_943.method_5677(new GamesClientImpl.PeerDisconnectedNotifier(var1, var2));
         }

      }

      public void onLeftRoom(int var1, String var2) {
         this.field_942.method_5677(new GamesClientImpl.LeftRoomNotifier(var1, var2));
      }

      public void onP2PConnected(String var1) {
         if(this.field_943 != null) {
            this.field_943.method_5677(new GamesClientImpl.P2PConnectedNotifier(var1));
         }

      }

      public void onP2PDisconnected(String var1) {
         if(this.field_943 != null) {
            this.field_943.method_5677(new GamesClientImpl.P2PDisconnectedNotifier(var1));
         }

      }

      public void onRealTimeMessageReceived(RealTimeMessage var1) {
         if(this.field_941 != null) {
            this.field_941.method_5677(new GamesClientImpl.MessageReceivedNotifier(var1));
         }

      }

      // $FF: renamed from: u (com.google.android.gms.common.data.DataHolder) void
      public void method_356(DataHolder var1) {
         this.field_942.method_5677(new GamesClientImpl.RoomCreatedNotifier(var1));
      }

      // $FF: renamed from: v (com.google.android.gms.common.data.DataHolder) void
      public void method_357(DataHolder var1) {
         this.field_942.method_5677(new GamesClientImpl.JoinedRoomNotifier(var1));
      }

      // $FF: renamed from: w (com.google.android.gms.common.data.DataHolder) void
      public void method_358(DataHolder var1) {
         if(this.field_943 != null) {
            this.field_943.method_5677(new GamesClientImpl.RoomConnectingNotifier(var1));
         }

      }

      // $FF: renamed from: x (com.google.android.gms.common.data.DataHolder) void
      public void method_359(DataHolder var1) {
         if(this.field_943 != null) {
            this.field_943.method_5677(new GamesClientImpl.RoomAutoMatchingNotifier(var1));
         }

      }

      // $FF: renamed from: y (com.google.android.gms.common.data.DataHolder) void
      public void method_360(DataHolder var1) {
         this.field_942.method_5677(new GamesClientImpl.RoomConnectedNotifier(var1));
      }

      // $FF: renamed from: z (com.google.android.gms.common.data.DataHolder) void
      public void method_361(DataHolder var1) {
         if(this.field_943 != null) {
            this.field_943.method_5677(new GamesClientImpl.ConnectedToRoomNotifier(var1));
         }

      }
   }

   private static final class RoomConnectedNotifier extends GamesClientImpl.AbstractRoomNotifier {
      RoomConnectedNotifier(DataHolder var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, int) void
      public void method_2786(RoomUpdateListener var1, Room var2, int var3) {
         var1.onRoomConnected(var3, var2);
      }
   }

   private static final class RoomConnectingNotifier extends GamesClientImpl.AbstractRoomStatusNotifier {
      RoomConnectingNotifier(DataHolder var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
      public void method_2788(RoomStatusUpdateListener var1, Room var2) {
         var1.onRoomConnecting(var2);
      }
   }

   private static final class RoomCreatedNotifier extends GamesClientImpl.AbstractRoomNotifier {
      public RoomCreatedNotifier(DataHolder var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, int) void
      public void method_2786(RoomUpdateListener var1, Room var2, int var3) {
         var1.onRoomCreated(var3, var2);
      }
   }

   private static final class SendRequestResultImpl extends class_481 implements Requests.SendRequestResult {
      // $FF: renamed from: Zs com.google.android.gms.games.request.GameRequest
      private final GameRequest field_1684;

      SendRequestResultImpl(DataHolder var1) {
         super(var1);
         GameRequestBuffer var2 = new GameRequestBuffer(var1);

         try {
            if(var2.getCount() > 0) {
               this.field_1684 = (GameRequest)((GameRequest)var2.get(0)).freeze();
            } else {
               this.field_1684 = null;
            }
         } finally {
            var2.release();
         }

      }
   }

   private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Status> field_956;

      public SignOutCompleteBinderCallbacks(BaseImplementation.class_1058<Status> var1) {
         this.field_956 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: fK () void
      public void method_338() {
         Status var1 = new Status(0);
         this.field_956.method_110(var1);
      }
   }

   private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: ZB com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Snapshots.CommitSnapshotResult> field_950;

      public SnapshotCommittedBinderCallbacks(BaseImplementation.class_1058<Snapshots.CommitSnapshotResult> var1) {
         this.field_950 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: J (com.google.android.gms.common.data.DataHolder) void
      public void method_305(DataHolder var1) {
         this.field_950.method_110(new GamesClientImpl.CommitSnapshotResultImpl(var1));
      }
   }

   static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Snapshots.DeleteSnapshotResult> field_964;

      public SnapshotDeletedBinderCallbacks(BaseImplementation.class_1058<Snapshots.DeleteSnapshotResult> var1) {
         this.field_964 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: i (int, java.lang.String) void
      public void method_343(int var1, String var2) {
         this.field_964.method_110(new GamesClientImpl.DeleteSnapshotResultImpl(var1, var2));
      }
   }

   private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: ZC com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Snapshots.OpenSnapshotResult> field_952;

      public SnapshotOpenedBinderCallbacks(BaseImplementation.class_1058<Snapshots.OpenSnapshotResult> var1) {
         this.field_952 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.Contents) void
      public void method_315(DataHolder var1, Contents var2) {
         this.field_952.method_110(new GamesClientImpl.OpenSnapshotResultImpl(var1, var2));
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String, com.google.android.gms.drive.Contents, com.google.android.gms.drive.Contents, com.google.android.gms.drive.Contents) void
      public void method_316(DataHolder var1, String var2, Contents var3, Contents var4, Contents var5) {
         this.field_952.method_110(new GamesClientImpl.OpenSnapshotResultImpl(var1, var2, var3, var4, var5));
      }
   }

   private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: ZD com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Snapshots.LoadSnapshotsResult> field_936;

      public SnapshotsLoadedBinderCallbacks(BaseImplementation.class_1058<Snapshots.LoadSnapshotsResult> var1) {
         this.field_936 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: I (com.google.android.gms.common.data.DataHolder) void
      public void method_304(DataHolder var1) {
         this.field_936.method_110(new GamesClientImpl.LoadSnapshotsResultImpl(var1));
      }
   }

   private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Leaderboards.SubmitScoreResult> field_930;

      public SubmitScoreBinderCallbacks(BaseImplementation.class_1058<Leaderboards.SubmitScoreResult> var1) {
         this.field_930 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: f (com.google.android.gms.common.data.DataHolder) void
      public void method_336(DataHolder var1) {
         this.field_930.method_110(new GamesClientImpl.SubmitScoreResultImpl(var1));
      }
   }

   private static final class SubmitScoreResultImpl extends class_481 implements Leaderboards.SubmitScoreResult {
      // $FF: renamed from: ZE com.google.android.gms.games.leaderboard.ScoreSubmissionData
      private final ScoreSubmissionData field_1668;

      public SubmitScoreResultImpl(DataHolder var1) {
         super(var1);

         try {
            this.field_1668 = new ScoreSubmissionData(var1);
         } finally {
            var1.close();
         }

      }

      public ScoreSubmissionData getScoreData() {
         return this.field_1668;
      }
   }

   private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: ZF com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<TurnBasedMultiplayer.CancelMatchResult> field_958;

      public TurnBasedMatchCanceledBinderCallbacks(BaseImplementation.class_1058<TurnBasedMultiplayer.CancelMatchResult> var1) {
         this.field_958 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: h (int, java.lang.String) void
      public void method_341(int var1, String var2) {
         Status var3 = new Status(var1);
         this.field_958.method_110(new GamesClientImpl.CancelMatchResultImpl(var3, var2));
      }
   }

   private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: ZG com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<TurnBasedMultiplayer.InitiateMatchResult> field_933;

      public TurnBasedMatchInitiatedBinderCallbacks(BaseImplementation.class_1058<TurnBasedMultiplayer.InitiateMatchResult> var1) {
         this.field_933 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: q (com.google.android.gms.common.data.DataHolder) void
      public void method_352(DataHolder var1) {
         this.field_933.method_110(new GamesClientImpl.InitiateMatchResultImpl(var1));
      }
   }

   private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: ZH com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<TurnBasedMultiplayer.LeaveMatchResult> field_954;

      public TurnBasedMatchLeftBinderCallbacks(BaseImplementation.class_1058<TurnBasedMultiplayer.LeaveMatchResult> var1) {
         this.field_954 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: s (com.google.android.gms.common.data.DataHolder) void
      public void method_354(DataHolder var1) {
         this.field_954.method_110(new GamesClientImpl.LeaveMatchResultImpl(var1));
      }
   }

   private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: ZI com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<TurnBasedMultiplayer.LoadMatchResult> field_938;

      public TurnBasedMatchLoadedBinderCallbacks(BaseImplementation.class_1058<TurnBasedMultiplayer.LoadMatchResult> var1) {
         this.field_938 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: p (com.google.android.gms.common.data.DataHolder) void
      public void method_351(DataHolder var1) {
         this.field_938.method_110(new GamesClientImpl.LoadMatchResultImpl(var1));
      }
   }

   private abstract static class TurnBasedMatchResult extends class_481 {
      // $FF: renamed from: Zc com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
      final TurnBasedMatch field_1700;

      TurnBasedMatchResult(DataHolder var1) {
         super(var1);
         TurnBasedMatchBuffer var2 = new TurnBasedMatchBuffer(var1);

         try {
            if(var2.getCount() > 0) {
               this.field_1700 = (TurnBasedMatch)((TurnBasedMatch)var2.get(0)).freeze();
            } else {
               this.field_1700 = null;
            }
         } finally {
            var2.release();
         }

      }

      public TurnBasedMatch getMatch() {
         return this.field_1700;
      }
   }

   private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: ZJ com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<TurnBasedMultiplayer.UpdateMatchResult> field_932;

      public TurnBasedMatchUpdatedBinderCallbacks(BaseImplementation.class_1058<TurnBasedMultiplayer.UpdateMatchResult> var1) {
         this.field_932 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: r (com.google.android.gms.common.data.DataHolder) void
      public void method_353(DataHolder var1) {
         this.field_932.method_110(new GamesClientImpl.UpdateMatchResultImpl(var1));
      }
   }

   private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: ZK com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<TurnBasedMultiplayer.LoadMatchesResult> field_946;

      public TurnBasedMatchesLoadedBinderCallbacks(BaseImplementation.class_1058<TurnBasedMultiplayer.LoadMatchesResult> var1) {
         this.field_946 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: b (int, android.os.Bundle) void
      public void method_320(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         Status var3 = new Status(var1);
         this.field_946.method_110(new GamesClientImpl.LoadMatchesResultImpl(var3, var2));
      }
   }

   private static final class UpdateAchievementResultImpl implements Achievements.UpdateAchievementResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_4494;
      // $FF: renamed from: Xx java.lang.String
      private final String field_4495;

      UpdateAchievementResultImpl(int var1, String var2) {
         this.field_4494 = new Status(var1);
         this.field_4495 = var2;
      }

      public String getAchievementId() {
         return this.field_4495;
      }

      public Status getStatus() {
         return this.field_4494;
      }
   }

   private static final class UpdateMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.UpdateMatchResult {
      UpdateMatchResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class UpdateRequestsResultImpl extends class_481 implements Requests.UpdateRequestsResult {
      // $FF: renamed from: ZL com.google.android.gms.games.internal.request.RequestUpdateOutcomes
      private final RequestUpdateOutcomes field_1685;

      UpdateRequestsResultImpl(DataHolder var1) {
         super(var1);
         this.field_1685 = RequestUpdateOutcomes.method_3145(var1);
      }

      public Set<String> getRequestIds() {
         return this.field_1685.getRequestIds();
      }

      public int getRequestOutcome(String var1) {
         return this.field_1685.getRequestOutcome(var1);
      }
   }
}
