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
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_442;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_749;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.Notifications;
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
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.hc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl extends hc<IGamesService> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
   // $FF: renamed from: NA java.lang.String
   private final String field_756;
   // $FF: renamed from: Nm com.google.android.gms.games.internal.events.EventIncrementManager
   EventIncrementManager field_757 = new EventIncrementManager() {
      // $FF: renamed from: hs () com.google.android.gms.games.internal.events.EventIncrementCache
      public EventIncrementCache method_2722() {
         return GamesClientImpl.this.new GameClientEventIncrementCache();
      }
   };
   // $FF: renamed from: Nn java.lang.String
   private final String field_758;
   // $FF: renamed from: No java.util.Map
   private final Map<String, RealTimeSocket> field_759;
   // $FF: renamed from: Np com.google.android.gms.games.PlayerEntity
   private PlayerEntity field_760;
   // $FF: renamed from: Nq com.google.android.gms.games.GameEntity
   private GameEntity field_761;
   // $FF: renamed from: Nr com.google.android.gms.games.internal.PopupManager
   private final PopupManager field_762;
   // $FF: renamed from: Ns boolean
   private boolean field_763 = false;
   // $FF: renamed from: Nt boolean
   private boolean field_764 = false;
   // $FF: renamed from: Nu int
   private int field_765;
   // $FF: renamed from: Nv android.os.Binder
   private final Binder field_766;
   // $FF: renamed from: Nw long
   private final long field_767;
   // $FF: renamed from: Nx boolean
   private final boolean field_768;
   // $FF: renamed from: Ny int
   private final int field_769;
   // $FF: renamed from: Nz boolean
   private final boolean field_770;
   // $FF: renamed from: yN java.lang.String
   private final String field_771;

   public GamesClientImpl(Context var1, Looper var2, String var3, String var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6, String[] var7, int var8, View var9, boolean var10, boolean var11, int var12, boolean var13, int var14, String var15) {
      super(var1, var2, var5, var6, var7);
      this.field_758 = var3;
      this.field_771 = (String)class_347.method_2170(var4);
      this.field_766 = new Binder();
      this.field_759 = new HashMap();
      this.field_762 = PopupManager.method_3697(this, var8);
      this.method_1598(var9);
      this.field_764 = var11;
      this.field_765 = var12;
      this.field_767 = (long)this.hashCode();
      this.field_768 = var10;
      this.field_770 = var13;
      this.field_769 = var14;
      this.field_756 = var15;
      this.registerConnectionCallbacks(this);
      this.registerConnectionFailedListener(this);
   }

   // $FF: renamed from: Q (com.google.android.gms.common.data.DataHolder) com.google.android.gms.games.multiplayer.realtime.Room
   private Room method_1500(DataHolder param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: aT (java.lang.String) com.google.android.gms.games.multiplayer.realtime.RealTimeSocket
   private RealTimeSocket method_1502(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: gT () void
   private void method_1503() {
      this.field_760 = null;
   }

   // $FF: renamed from: hq () void
   private void method_1504() {
      Iterator var1 = this.field_759.values().iterator();

      while(var1.hasNext()) {
         RealTimeSocket var2 = (RealTimeSocket)var1.next();

         try {
            var2.close();
         } catch (IOException var4) {
            GamesLog.method_4571("GamesClientImpl", "IOException:", var4);
         }
      }

      this.field_759.clear();
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer$ReliableMessageSentCallback, byte[], java.lang.String, java.lang.String) int
   public int method_1505(RealTimeMultiplayer.ReliableMessageSentCallback var1, byte[] var2, String var3, String var4) {
      try {
         int var6 = ((IGamesService)this.fo()).method_409(new GamesClientImpl.RealTimeReliableMessageBinderCallbacks(var1), var2, var3, var4);
         return var6;
      } catch (RemoteException var7) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: a (byte[], java.lang.String, java.lang.String[]) int
   public int method_1506(byte[] var1, String var2, String[] var3) {
      class_347.method_2166(var3, "Participant IDs must not be null");

      try {
         int var6 = ((IGamesService)this.fo()).method_474(var1, var2, var3);
         return var6;
      } catch (RemoteException var7) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: a (int, int, boolean) android.content.Intent
   public Intent method_1507(int var1, int var2, boolean var3) {
      try {
         Intent var5 = ((IGamesService)this.fo()).method_410(var1, var2, var3);
         return var5;
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: a (int, byte[], int, android.graphics.Bitmap, java.lang.String) android.content.Intent
   public Intent method_1508(int var1, byte[] var2, int var3, Bitmap var4, String var5) {
      try {
         Intent var7 = ((IGamesService)this.fo()).method_411(var1, var2, var3, var5);
         class_347.method_2166(var4, "Must provide a non null icon");
         var7.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", var4);
         return var7;
      } catch (RemoteException var8) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.Room, int) android.content.Intent
   public Intent method_1509(Room var1, int var2) {
      try {
         Intent var4 = ((IGamesService)this.fo()).method_414((RoomEntity)var1.freeze(), var2);
         return var4;
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: a (java.lang.String, boolean, boolean, int) android.content.Intent
   public Intent method_1510(String var1, boolean var2, boolean var3, int var4) {
      try {
         Intent var6 = ((IGamesService)this.fo()).method_415(var1, var2, var3, var4);
         return var6;
      } catch (RemoteException var7) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: a (int[]) android.content.Intent
   public Intent method_1511(int[] var1) {
      try {
         Intent var3 = ((IGamesService)this.fo()).method_416(var1);
         return var3;
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
   protected void method_1446(int var1, IBinder var2, Bundle var3) {
      if(var1 == 0 && var3 != null) {
         this.field_763 = var3.getBoolean("show_welcome_popup");
      }

      super.method_1446(var1, var2, var3);
   }

   // $FF: renamed from: a (android.os.IBinder, android.os.Bundle) void
   public void method_1512(IBinder var1, Bundle var2) {
      if(this.isConnected()) {
         try {
            ((IGamesService)this.fo()).method_419(var1, var2);
         } catch (RemoteException var4) {
            GamesLog.method_4573("GamesClientImpl", "service died");
            return;
         }
      }

   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, int, int, int) void
   public void method_1513(class_797.class_1206<Requests.LoadRequestsResult> var1, int var2, int var3, int var4) {
      try {
         ((IGamesService)this.fo()).method_423(new GamesClientImpl.RequestsLoadedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, int, int, boolean, boolean) void
   public void method_1514(class_797.class_1206<GamesMetadata.LoadExtendedGamesResult> var1, int var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.fo()).method_424(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, int, boolean, boolean) void
   public void method_1515(class_797.class_1206<Players.LoadPlayersResult> var1, int var2, boolean var3, boolean var4) {
      try {
         ((IGamesService)this.fo()).method_426(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, int, int[]) void
   public void method_1516(class_797.class_1206<TurnBasedMultiplayer.LoadMatchesResult> var1, int var2, int[] var3) {
      try {
         ((IGamesService)this.fo()).method_427(new GamesClientImpl.TurnBasedMatchesLoadedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer, int, int) void
   public void method_1517(class_797.class_1206<Leaderboards.LoadScoresResult> var1, LeaderboardScoreBuffer var2, int var3, int var4) {
      try {
         ((IGamesService)this.fo()).method_430(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2.method_2616().method_3806(), var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig) void
   public void method_1518(class_797.class_1206<TurnBasedMultiplayer.InitiateMatchResult> var1, TurnBasedMatchConfig var2) {
      try {
         ((IGamesService)this.fo()).method_425(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2.getVariant(), var2.method_4050(), var2.getInvitedPlayerIds(), var2.getAutoMatchCriteria());
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.games.snapshot.Snapshot, com.google.android.gms.games.snapshot.SnapshotMetadataChange) void
   public void method_1519(class_797.class_1206<Snapshots.CommitSnapshotResult> var1, Snapshot var2, SnapshotMetadataChange var3) {
      Contents var4 = var2.getContents();
      class_347.method_2166(var4, "Must provide a previously opened Snapshot");
      class_749 var6 = var3.method_2783();
      if(var6 != null) {
         var6.method_4287(this.getContext().getCacheDir());
      }

      var2.method_233();

      try {
         ((IGamesService)this.fo()).method_444(new GamesClientImpl.SnapshotCommittedBinderCallbacks(var1), var2.getMetadata().getSnapshotId(), var3, var4);
      } catch (RemoteException var8) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1520(class_797.class_1206<Players.LoadPlayersResult> var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_433(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, int) void
   public void method_1521(class_797.class_1206<Achievements.UpdateAchievementResult> param1, String param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, int, int, int, boolean) void
   public void method_1522(class_797.class_1206<Leaderboards.LoadScoresResult> var1, String var2, int var3, int var4, int var5, boolean var6) {
      try {
         ((IGamesService)this.fo()).method_435(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var8) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, int, boolean) void
   public void method_1523(class_797.class_1206<Players.LoadPlayersResult> var1, String var2, int var3, boolean var4) {
      try {
         ((IGamesService)this.fo()).method_437(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, int, boolean, boolean) void
   public void method_1524(class_797.class_1206<Players.LoadPlayersResult> var1, String var2, int var3, boolean var4, boolean var5) {
      if(!var2.equals("played_with")) {
         throw new IllegalArgumentException("Invalid player collection: " + var2);
      } else {
         try {
            ((IGamesService)this.fo()).method_519(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4, var5);
         } catch (RemoteException var7) {
            GamesLog.method_4573("GamesClientImpl", "service died");
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, int, boolean, boolean, boolean, boolean) void
   public void method_1525(class_797.class_1206<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      try {
         ((IGamesService)this.fo()).method_439(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5, var6, var7);
      } catch (RemoteException var9) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, int, int[]) void
   public void method_1526(class_797.class_1206<TurnBasedMultiplayer.LoadMatchesResult> var1, String var2, int var3, int[] var4) {
      try {
         ((IGamesService)this.fo()).method_440(new GamesClientImpl.TurnBasedMatchesLoadedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, long, java.lang.String) void
   public void method_1527(class_797.class_1206<Leaderboards.SubmitScoreResult> param1, String param2, long param3, String param5) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String) void
   public void method_1528(class_797.class_1206<TurnBasedMultiplayer.LeaveMatchResult> var1, String var2, String var3) {
      try {
         ((IGamesService)this.fo()).method_506(new GamesClientImpl.TurnBasedMatchLeftBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String, int, int) void
   public void method_1529(class_797.class_1206<Leaderboards.LoadPlayerScoreResult> var1, String var2, String var3, int var4, int var5) {
      try {
         ((IGamesService)this.fo()).method_446(new GamesClientImpl.PlayerLeaderboardScoreLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String, int, int, int) void
   public void method_1530(class_797.class_1206<Requests.LoadRequestsResult> var1, String var2, String var3, int var4, int var5, int var6) {
      try {
         ((IGamesService)this.fo()).method_447(new GamesClientImpl.RequestsLoadedBinderCallbacks(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var8) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String, int, int, int, boolean) void
   public void method_1531(class_797.class_1206<Leaderboards.LoadScoresResult> var1, String var2, String var3, int var4, int var5, int var6, boolean var7) {
      try {
         ((IGamesService)this.fo()).method_448(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6, var7);
      } catch (RemoteException var9) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String, int, boolean, boolean) void
   public void method_1532(class_797.class_1206<Players.LoadPlayersResult> var1, String var2, String var3, int var4, boolean var5, boolean var6) {
      if(!var2.equals("played_with") && !var2.equals("circled")) {
         throw new IllegalArgumentException("Invalid player collection: " + var2);
      } else {
         try {
            ((IGamesService)this.fo()).method_449(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4, var5, var6);
         } catch (RemoteException var8) {
            GamesLog.method_4573("GamesClientImpl", "service died");
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String, com.google.android.gms.games.snapshot.SnapshotMetadataChange, com.google.android.gms.drive.Contents) void
   public void method_1533(class_797.class_1206<Snapshots.OpenSnapshotResult> var1, String var2, String var3, SnapshotMetadataChange var4, Contents var5) {
      class_749 var6 = var4.method_2783();
      if(var6 != null) {
         var6.method_4287(this.getContext().getCacheDir());
      }

      try {
         ((IGamesService)this.fo()).method_450(new GamesClientImpl.SnapshotOpenedBinderCallbacks(var1), var2, var3, var4, var5);
      } catch (RemoteException var8) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String, boolean) void
   public void method_1534(class_797.class_1206<Leaderboards.LeaderboardMetadataResult> var1, String var2, String var3, boolean var4) {
      try {
         ((IGamesService)this.fo()).method_491(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String, boolean, java.lang.String[]) void
   public void method_1535(class_797.class_1206<Quests.LoadQuestsResult> var1, String var2, String var3, boolean var4, String[] var5) {
      try {
         ((IGamesService)this.fo()).method_454(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), var2, var3, var5, var4);
      } catch (RemoteException var7) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String, int[], int, boolean) void
   public void method_1536(class_797.class_1206<Quests.LoadQuestsResult> var1, String var2, String var3, int[] var4, int var5, boolean var6) {
      try {
         ((IGamesService)this.fo()).method_452(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var8) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String, java.lang.String[]) void
   public void method_1537(class_797.class_1206<Requests.UpdateRequestsResult> var1, String var2, String var3, String[] var4) {
      try {
         ((IGamesService)this.fo()).method_453(new GamesClientImpl.RequestsUpdatedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, boolean) void
   public void method_1538(class_797.class_1206<Leaderboards.LeaderboardMetadataResult> var1, String var2, boolean var3) {
      try {
         ((IGamesService)this.fo()).method_508(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, byte[], java.lang.String, com.google.android.gms.games.multiplayer.ParticipantResult[]) void
   public void method_1539(class_797.class_1206<TurnBasedMultiplayer.UpdateMatchResult> var1, String var2, byte[] var3, String var4, ParticipantResult[] var5) {
      try {
         ((IGamesService)this.fo()).method_456(new GamesClientImpl.TurnBasedMatchUpdatedBinderCallbacks(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, byte[], com.google.android.gms.games.multiplayer.ParticipantResult[]) void
   public void method_1540(class_797.class_1206<TurnBasedMultiplayer.UpdateMatchResult> var1, String var2, byte[] var3, ParticipantResult[] var4) {
      try {
         ((IGamesService)this.fo()).method_457(new GamesClientImpl.TurnBasedMatchUpdatedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String[], int, byte[], int) void
   public void method_1541(class_797.class_1206<Requests.SendRequestResult> var1, String var2, String[] var3, int var4, byte[] var5, int var6) {
      try {
         ((IGamesService)this.fo()).method_459(new GamesClientImpl.RequestSentBinderCallbacks(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var8) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, boolean) void
   public void method_1542(class_797.class_1206<Players.LoadPlayersResult> var1, boolean var2) {
      try {
         ((IGamesService)this.fo()).method_509(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, boolean, android.os.Bundle) void
   public void method_1543(class_797.class_1206<Status> var1, boolean var2, Bundle var3) {
      try {
         ((IGamesService)this.fo()).method_461(new GamesClientImpl.ContactSettingsUpdatedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, boolean, java.lang.String[]) void
   public void method_1544(class_797.class_1206<Events.LoadEventsResult> var1, boolean var2, String... var3) {
      try {
         this.field_757.flush();
         ((IGamesService)this.fo()).method_462(new GamesClientImpl.EventsLoadedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, int[], int, boolean) void
   public void method_1545(class_797.class_1206<Quests.LoadQuestsResult> var1, int[] var2, int var3, boolean var4) {
      try {
         this.field_757.flush();
         ((IGamesService)this.fo()).method_464(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String[]) void
   public void method_1546(class_797.class_1206<Players.LoadPlayersResult> var1, String[] var2) {
      try {
         ((IGamesService)this.fo()).method_510(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.OnInvitationReceivedListener) void
   public void method_1547(OnInvitationReceivedListener var1) {
      try {
         GamesClientImpl.InvitationReceivedBinderCallback var2 = new GamesClientImpl.InvitationReceivedBinderCallback(var1);
         ((IGamesService)this.fo()).method_428(var2, this.field_767);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomConfig) void
   public void method_1548(RoomConfig var1) {
      try {
         GamesClientImpl.RoomBinderCallbacks var2 = new GamesClientImpl.RoomBinderCallbacks(var1.getRoomUpdateListener(), var1.getRoomStatusUpdateListener(), var1.getMessageReceivedListener());
         ((IGamesService)this.fo()).method_431(var2, this.field_766, var1.getVariant(), var1.getInvitedPlayerIds(), var1.getAutoMatchCriteria(), var1.isSocketEnabled(), this.field_767);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, java.lang.String) void
   public void method_1549(RoomUpdateListener var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_503(new GamesClientImpl.RoomBinderCallbacks(var1), var2);
         this.method_1504();
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener) void
   public void method_1550(OnTurnBasedMatchUpdateReceivedListener var1) {
      try {
         GamesClientImpl.MatchUpdateReceivedBinderCallback var2 = new GamesClientImpl.MatchUpdateReceivedBinderCallback(var1);
         ((IGamesService)this.fo()).method_479(var2, this.field_767);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.games.quest.QuestUpdateListener) void
   public void method_1551(QuestUpdateListener var1) {
      try {
         GamesClientImpl.QuestUpdateBinderCallback var2 = new GamesClientImpl.QuestUpdateBinderCallback(var1);
         ((IGamesService)this.fo()).method_516(var2, this.field_767);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.games.request.OnRequestReceivedListener) void
   public void method_1552(OnRequestReceivedListener var1) {
      try {
         GamesClientImpl.RequestReceivedBinderCallback var2 = new GamesClientImpl.RequestReceivedBinderCallback(var1);
         ((IGamesService)this.fo()).method_501(var2, this.field_767);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.games.snapshot.Snapshot) void
   public void method_1553(Snapshot var1) {
      Contents var2 = var1.getContents();
      class_347.method_2166(var2, "Must provide a previously opened Snapshot");
      var1.method_233();

      try {
         ((IGamesService)this.fo()).method_420(var2);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hj, com.google.android.gms.internal.hc$e) void
   protected void method_1448(class_31 var1, class_234.class_911 var2) throws RemoteException {
      String var3 = this.getContext().getResources().getConfiguration().locale.toString();
      Bundle var4 = new Bundle();
      var4.putBoolean("com.google.android.gms.games.key.isHeadless", this.field_768);
      var4.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.field_764);
      var4.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.field_765);
      var4.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.field_770);
      var4.putInt("com.google.android.gms.games.key.sdkVariant", this.field_769);
      var4.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.field_756);
      var1.method_161(var2, 5077000, this.getContext().getPackageName(), this.field_771, this.fn(), this.field_758, this.field_762.method_3702(), var3, var4);
   }

   // $FF: renamed from: aR (java.lang.String) android.content.Intent
   public Intent method_1554(String var1) {
      try {
         Intent var3 = ((IGamesService)this.fo()).method_467(var1);
         return var3;
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: aS (java.lang.String) void
   public void method_1555(String var1) {
      try {
         ((IGamesService)this.fo()).method_496(var1);
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: aU (java.lang.String) android.content.Intent
   public Intent method_1556(String var1) {
      try {
         Intent var3 = ((IGamesService)this.fo()).method_468(var1);
         return var3;
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: ah (android.os.IBinder) com.google.android.gms.games.internal.IGamesService
   protected IGamesService method_1557(IBinder var1) {
      return IGamesService.Stub.method_4014(var1);
   }

   // $FF: renamed from: b (int, int, boolean) android.content.Intent
   public Intent method_1558(int var1, int var2, boolean var3) {
      try {
         Intent var5 = ((IGamesService)this.fo()).method_475(var1, var2, var3);
         return var5;
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d) void
   public void method_1559(class_797.class_1206<Status> var1) {
      try {
         this.field_757.flush();
         ((IGamesService)this.fo()).method_421(new GamesClientImpl.SignOutCompleteBinderCallbacks(var1));
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, int, boolean, boolean) void
   public void method_1560(class_797.class_1206<Players.LoadPlayersResult> var1, int var2, boolean var3, boolean var4) {
      try {
         ((IGamesService)this.fo()).method_478(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1561(class_797.class_1206<Achievements.UpdateAchievementResult> param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, java.lang.String, int) void
   public void method_1562(class_797.class_1206<Achievements.UpdateAchievementResult> param1, String param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, java.lang.String, int, int, int, boolean) void
   public void method_1563(class_797.class_1206<Leaderboards.LoadScoresResult> var1, String var2, int var3, int var4, int var5, boolean var6) {
      try {
         ((IGamesService)this.fo()).method_483(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var8) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, java.lang.String, int, boolean, boolean) void
   public void method_1564(class_797.class_1206<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.fo()).method_438(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String) void
   public void method_1565(class_797.class_1206<Quests.ClaimMilestoneResult> var1, String var2, String var3) {
      try {
         this.field_757.flush();
         ((IGamesService)this.fo()).method_534(new GamesClientImpl.QuestMilestoneClaimBinderCallbacks(var1, var3), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String, int, int, int, boolean) void
   public void method_1566(class_797.class_1206<Leaderboards.LoadScoresResult> var1, String var2, String var3, int var4, int var5, int var6, boolean var7) {
      try {
         ((IGamesService)this.fo()).method_489(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6, var7);
      } catch (RemoteException var9) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String, boolean) void
   public void method_1567(class_797.class_1206<Achievements.LoadAchievementsResult> var1, String var2, String var3, boolean var4) {
      try {
         ((IGamesService)this.fo()).method_451(new GamesClientImpl.AchievementsLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, java.lang.String, boolean) void
   public void method_1568(class_797.class_1206<Snapshots.OpenSnapshotResult> var1, String var2, boolean var3) {
      try {
         ((IGamesService)this.fo()).method_528(new GamesClientImpl.SnapshotOpenedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, boolean) void
   public void method_1569(class_797.class_1206<Leaderboards.LeaderboardMetadataResult> var1, boolean var2) {
      try {
         ((IGamesService)this.fo()).method_493(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, boolean, java.lang.String[]) void
   public void method_1570(class_797.class_1206<Quests.LoadQuestsResult> var1, boolean var2, String[] var3) {
      try {
         ((IGamesService)this.fo()).method_466(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), var3, var2);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, java.lang.String[]) void
   public void method_1571(class_797.class_1206<Requests.UpdateRequestsResult> var1, String[] var2) {
      try {
         ((IGamesService)this.fo()).method_465(new GamesClientImpl.RequestsUpdatedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.games.multiplayer.realtime.RoomConfig) void
   public void method_1572(RoomConfig var1) {
      try {
         GamesClientImpl.RoomBinderCallbacks var2 = new GamesClientImpl.RoomBinderCallbacks(var1.getRoomUpdateListener(), var1.getRoomStatusUpdateListener(), var1.getMessageReceivedListener());
         ((IGamesService)this.fo()).method_432(var2, this.field_766, var1.getInvitationId(), var1.isSocketEnabled(), this.field_767);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: b (java.lang.String[]) void
   protected void method_1450(String... var1) {
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

         class_347.method_2162(var5, "Cannot have both %s and %s!", new Object[]{"https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty"});
      } else {
         class_347.method_2162(var4, "Games APIs requires %s to function.", new Object[]{"https://www.googleapis.com/auth/games"});
      }
   }

   // $FF: renamed from: bp () java.lang.String
   protected String method_1451() {
      return "com.google.android.gms.games.service.START";
   }

   // $FF: renamed from: bq () java.lang.String
   protected String method_1452() {
      return "com.google.android.gms.games.internal.IGamesService";
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.a$d, int) void
   public void method_1573(class_797.class_1206<Invitations.LoadInvitationsResult> var1, int var2) {
      try {
         ((IGamesService)this.fo()).method_422(new GamesClientImpl.InvitationsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.a$d, int, boolean, boolean) void
   public void method_1574(class_797.class_1206<Players.LoadPlayersResult> var1, int var2, boolean var3, boolean var4) {
      try {
         ((IGamesService)this.fo()).method_500(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1575(class_797.class_1206<Achievements.UpdateAchievementResult> param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.a$d, java.lang.String, int) void
   public void method_1576(class_797.class_1206<Players.LoadXpStreamResult> var1, String var2, int var3) {
      try {
         ((IGamesService)this.fo()).method_482(new GamesClientImpl.PlayerXpStreamLoadedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.a$d, java.lang.String, int, boolean, boolean) void
   public void method_1577(class_797.class_1206<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.fo()).method_526(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String) void
   public void method_1578(class_797.class_1206<TurnBasedMultiplayer.InitiateMatchResult> var1, String var2, String var3) {
      try {
         ((IGamesService)this.fo()).method_520(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String, boolean) void
   public void method_1579(class_797.class_1206<Snapshots.LoadSnapshotsResult> var1, String var2, String var3, boolean var4) {
      try {
         ((IGamesService)this.fo()).method_507(new GamesClientImpl.SnapshotsLoadedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.a$d, java.lang.String, boolean) void
   public void method_1580(class_797.class_1206<Leaderboards.LeaderboardMetadataResult> var1, String var2, boolean var3) {
      try {
         ((IGamesService)this.fo()).method_521(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.a$d, boolean) void
   public void method_1581(class_797.class_1206<Achievements.LoadAchievementsResult> var1, boolean var2) {
      try {
         ((IGamesService)this.fo()).method_460(new GamesClientImpl.AchievementsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.a$d, java.lang.String[]) void
   public void method_1582(class_797.class_1206<Requests.UpdateRequestsResult> var1, String[] var2) {
      try {
         ((IGamesService)this.fo()).method_494(new GamesClientImpl.RequestsUpdatedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: cg (int) void
   public void method_1583(int var1) {
      this.field_762.setGravity(var1);
   }

   // $FF: renamed from: ch (int) void
   public void method_1584(int var1) {
      try {
         ((IGamesService)this.fo()).method_512(var1);
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   public void connect() {
      this.method_1503();
      super.connect();
   }

   // $FF: renamed from: d (byte[], java.lang.String) int
   public int method_1585(byte[] var1, String var2) {
      try {
         int var4 = ((IGamesService)this.fo()).method_474(var1, var2, (String[])null);
         return var4;
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.a$d, int, boolean, boolean) void
   public void method_1586(class_797.class_1206<Players.LoadPlayersResult> var1, int var2, boolean var3, boolean var4) {
      try {
         ((IGamesService)this.fo()).method_524(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1587(class_797.class_1206<TurnBasedMultiplayer.InitiateMatchResult> var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_570(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.a$d, java.lang.String, int) void
   public void method_1588(class_797.class_1206<Players.LoadXpStreamResult> var1, String var2, int var3) {
      try {
         ((IGamesService)this.fo()).method_504(new GamesClientImpl.PlayerXpStreamLoadedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.a$d, java.lang.String, int, boolean, boolean) void
   public void method_1589(class_797.class_1206<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.fo()).method_533(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String) void
   public void method_1590(class_797.class_1206<TurnBasedMultiplayer.InitiateMatchResult> var1, String var2, String var3) {
      try {
         ((IGamesService)this.fo()).method_527(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.a$d, java.lang.String, boolean) void
   public void method_1591(class_797.class_1206<Notifications.GameMuteStatusChangeResult> var1, String var2, boolean var3) {
      try {
         ((IGamesService)this.fo()).method_455(new GamesClientImpl.GameMuteStatusChangedBinderCallback(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.a$d, boolean) void
   public void method_1592(class_797.class_1206<Events.LoadEventsResult> var1, boolean var2) {
      try {
         this.field_757.flush();
         ((IGamesService)this.fo()).method_535(new GamesClientImpl.EventsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   public void disconnect() {
      this.field_763 = false;
      if(this.isConnected()) {
         try {
            IGamesService var2 = (IGamesService)this.fo();
            var2.method_557();
            this.field_757.flush();
            var2.method_581(this.field_767);
         } catch (RemoteException var3) {
            GamesLog.method_4573("GamesClientImpl", "Failed to notify client disconnect.");
         }
      }

      this.method_1504();
      super.disconnect();
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.a$d, int, boolean, boolean) void
   public void method_1593(class_797.class_1206<Players.LoadPlayersResult> var1, int var2, boolean var3, boolean var4) {
      try {
         ((IGamesService)this.fo()).method_515(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1594(class_797.class_1206<TurnBasedMultiplayer.InitiateMatchResult> var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_572(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.a$d, java.lang.String, int) void
   public void method_1595(class_797.class_1206<Invitations.LoadInvitationsResult> var1, String var2, int var3) {
      try {
         ((IGamesService)this.fo()).method_485(new GamesClientImpl.InvitationsLoadedBinderCallback(var1), var2, var3, false);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.a$d, java.lang.String, int, boolean, boolean) void
   public void method_1596(class_797.class_1206<GamesMetadata.LoadExtendedGamesResult> var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.fo()).method_505(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.a$d, boolean) void
   public void method_1597(class_797.class_1206<Snapshots.LoadSnapshotsResult> var1, boolean var2) {
      try {
         ((IGamesService)this.fo()).method_522(new GamesClientImpl.SnapshotsLoadedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: ea () android.os.Bundle
   public Bundle method_777() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: f (android.view.View) void
   public void method_1598(View var1) {
      this.field_762.method_3699(var1);
   }

   // $FF: renamed from: f (com.google.android.gms.common.api.a$d) void
   public void method_1599(class_797.class_1206<GamesMetadata.LoadGamesResult> var1) {
      try {
         ((IGamesService)this.fo()).method_514(new GamesClientImpl.GamesLoadedBinderCallback(var1));
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: f (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1600(class_797.class_1206<TurnBasedMultiplayer.LeaveMatchResult> var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_578(new GamesClientImpl.TurnBasedMatchLeftBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: f (com.google.android.gms.common.api.a$d, java.lang.String, int) void
   public void method_1601(class_797.class_1206<Requests.LoadRequestSummariesResult> var1, String var2, int var3) {
      try {
         ((IGamesService)this.fo()).method_434(new GamesClientImpl.RequestSummariesLoadedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var5) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: f (com.google.android.gms.common.api.a$d, java.lang.String, int, boolean, boolean) void
   public void method_1602(class_797.class_1206<Players.LoadPlayersResult> var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.fo()).method_486(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: f (com.google.android.gms.common.api.a$d, boolean) void
   public void method_1603(class_797.class_1206<Notifications.ContactSettingLoadResult> var1, boolean var2) {
      try {
         ((IGamesService)this.fo()).method_529(new GamesClientImpl.ContactSettingsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: g (com.google.android.gms.common.api.a$d) void
   public void method_1604(class_797.class_1206<Players.LoadOwnerCoverPhotoUrisResult> var1) {
      try {
         ((IGamesService)this.fo()).method_567(new GamesClientImpl.OwnerCoverPhotoUrisLoadedBinderCallback(var1));
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: g (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1605(class_797.class_1206<TurnBasedMultiplayer.CancelMatchResult> var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_575(new GamesClientImpl.TurnBasedMatchCanceledBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: g (com.google.android.gms.common.api.a$d, java.lang.String, int, boolean, boolean) void
   public void method_1606(class_797.class_1206<Players.LoadPlayersResult> var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.fo()).method_490(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, (String)null, var3, var4, var5);
      } catch (RemoteException var7) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: gU () java.lang.String
   public String method_1607() {
      try {
         String var2 = ((IGamesService)this.fo()).method_539();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: gV () java.lang.String
   public String method_1608() {
      try {
         String var2 = ((IGamesService)this.fo()).method_540();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: gW () com.google.android.gms.games.Player
   public Player method_1609() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: gX () com.google.android.gms.games.Game
   public Game method_1610() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: gY () android.content.Intent
   public Intent method_1611() {
      try {
         Intent var2 = ((IGamesService)this.fo()).method_541();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: gZ () android.content.Intent
   public Intent method_1612() {
      try {
         Intent var2 = ((IGamesService)this.fo()).method_542();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: h (com.google.android.gms.common.api.a$d) void
   public void method_1613(class_797.class_1206<Acls.LoadAclResult> var1) {
      try {
         ((IGamesService)this.fo()).method_544(new GamesClientImpl.NotifyAclLoadedBinderCallback(var1));
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: h (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1614(class_797.class_1206<TurnBasedMultiplayer.LoadMatchResult> var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_579(new GamesClientImpl.TurnBasedMatchLoadedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: ha () android.content.Intent
   public Intent method_1615() {
      try {
         Intent var2 = ((IGamesService)this.fo()).method_545();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: hb () android.content.Intent
   public Intent method_1616() {
      try {
         Intent var2 = ((IGamesService)this.fo()).method_546();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: hc () void
   public void method_1617() {
      try {
         ((IGamesService)this.fo()).method_584(this.field_767);
      } catch (RemoteException var2) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: hd () void
   public void method_1618() {
      try {
         ((IGamesService)this.fo()).method_586(this.field_767);
      } catch (RemoteException var2) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: he () void
   public void method_1619() {
      try {
         ((IGamesService)this.fo()).method_590(this.field_767);
      } catch (RemoteException var2) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: hf () void
   public void method_1620() {
      try {
         ((IGamesService)this.fo()).method_588(this.field_767);
      } catch (RemoteException var2) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: hg () android.content.Intent
   public Intent method_1621() {
      try {
         Intent var2 = ((IGamesService)this.fo()).method_547();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: hh () android.content.Intent
   public Intent method_1622() {
      try {
         Intent var2 = ((IGamesService)this.fo()).method_548();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: hi () int
   public int method_1623() {
      try {
         int var2 = ((IGamesService)this.fo()).method_549();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return 4368;
      }
   }

   // $FF: renamed from: hj () java.lang.String
   public String method_1624() {
      try {
         String var2 = ((IGamesService)this.fo()).method_550();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: hk () int
   public int method_1625() {
      try {
         int var2 = ((IGamesService)this.fo()).method_551();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: hl () android.content.Intent
   public Intent method_1626() {
      try {
         Intent var2 = ((IGamesService)this.fo()).method_552();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return null;
      }
   }

   // $FF: renamed from: hm () int
   public int method_1627() {
      try {
         int var2 = ((IGamesService)this.fo()).method_553();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: hn () int
   public int method_1628() {
      try {
         int var2 = ((IGamesService)this.fo()).method_554();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: ho () int
   public int method_1629() {
      try {
         int var2 = ((IGamesService)this.fo()).method_555();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: hp () int
   public int method_1630() {
      try {
         int var2 = ((IGamesService)this.fo()).method_556();
         return var2;
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
         return -1;
      }
   }

   // $FF: renamed from: hr () void
   public void method_1631() {
      if(this.isConnected()) {
         try {
            ((IGamesService)this.fo()).method_557();
         } catch (RemoteException var2) {
            GamesLog.method_4573("GamesClientImpl", "service died");
            return;
         }
      }

   }

   // $FF: renamed from: i (com.google.android.gms.common.api.a$d) void
   @Deprecated
   public void method_1632(class_797.class_1206<Notifications.ContactSettingLoadResult> var1) {
      try {
         ((IGamesService)this.fo()).method_529(new GamesClientImpl.ContactSettingsLoadedBinderCallback(var1), false);
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: i (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1633(class_797.class_1206<Quests.AcceptQuestResult> var1, String var2) {
      try {
         this.field_757.flush();
         ((IGamesService)this.fo()).method_591(new GamesClientImpl.QuestAcceptedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: j (com.google.android.gms.common.api.a$d) void
   public void method_1634(class_797.class_1206<Notifications.InboxCountResult> var1) {
      try {
         ((IGamesService)this.fo()).method_589(new GamesClientImpl.InboxCountsLoadedBinderCallback(var1), (String)null);
      } catch (RemoteException var3) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: j (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1635(class_797.class_1206<Snapshots.DeleteSnapshotResult> var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_585(new GamesClientImpl.SnapshotDeletedBinderCallbacks(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: k (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1636(class_797.class_1206<GamesMetadata.LoadExtendedGamesResult> var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_525(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: l (java.lang.String, java.lang.String) com.google.android.gms.games.multiplayer.realtime.RealTimeSocket
   public RealTimeSocket method_1637(String var1, String var2) {
      if(var2 != null && ParticipantUtils.method_3444(var2)) {
         RealTimeSocket var3 = (RealTimeSocket)this.field_759.get(var2);
         if(var3 == null || var3.isClosed()) {
            var3 = this.method_1502(var2);
         }

         return var3;
      } else {
         throw new IllegalArgumentException("Bad participant ID");
      }
   }

   // $FF: renamed from: l (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1638(class_797.class_1206<GamesMetadata.LoadGameInstancesResult> var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_532(new GamesClientImpl.GameInstancesLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: l (java.lang.String, int) void
   public void method_1639(String var1, int var2) {
      this.field_757.method_2723(var1, var2);
   }

   // $FF: renamed from: m (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1640(class_797.class_1206<GamesMetadata.LoadGameSearchSuggestionsResult> var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_582(new GamesClientImpl.GameSearchSuggestionsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: m (java.lang.String, int) void
   public void method_1641(String var1, int var2) {
      try {
         ((IGamesService)this.fo()).method_573(var1, var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: n (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1642(class_797.class_1206<Players.LoadXpForGameCategoriesResult> var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_587(new GamesClientImpl.PlayerXpForGameCategoriesLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: n (java.lang.String, int) void
   public void method_1643(String var1, int var2) {
      try {
         ((IGamesService)this.fo()).method_576(var1, var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: o (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1644(class_797.class_1206<Invitations.LoadInvitationsResult> var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_569(new GamesClientImpl.InvitationsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   public void onConnected(Bundle var1) {
      if(this.field_763) {
         this.field_762.method_3700();
         this.field_763 = false;
      }

   }

   public void onConnectionFailed(ConnectionResult var1) {
      this.field_763 = false;
   }

   public void onConnectionSuspended(int var1) {
   }

   // $FF: renamed from: p (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1645(class_797.class_1206<Status> var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_568(new GamesClientImpl.NotifyAclUpdatedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: q (com.google.android.gms.common.api.a$d, java.lang.String) void
   public void method_1646(class_797.class_1206<Notifications.GameMuteStatusLoadResult> var1, String var2) {
      try {
         ((IGamesService)this.fo()).method_566(new GamesClientImpl.GameMuteStatusLoadedBinderCallback(var1), var2);
      } catch (RemoteException var4) {
         GamesLog.method_4573("GamesClientImpl", "service died");
      }
   }

   // $FF: renamed from: x (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1456(IBinder var1) {
      return this.method_1557(var1);
   }

   private abstract class AbstractPeerStatusCallback extends GamesClientImpl.AbstractRoomStatusCallback {
      // $FF: renamed from: NC java.util.ArrayList
      private final ArrayList<String> field_1983 = new ArrayList();

      AbstractPeerStatusCallback(RoomStatusUpdateListener var2, DataHolder var3, String[] var4) {
         super();
         int var5 = 0;

         for(int var6 = var4.length; var5 < var6; ++var5) {
            this.field_1983.add(var4[var5]);
         }

      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
      protected void method_2663(RoomStatusUpdateListener var1, Room var2) {
         this.method_2664(var1, var2, this.field_1983);
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
      protected abstract void method_2664(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3);
   }

   private abstract class AbstractRoomCallback extends com/google/android/gms/internal/hc<IGamesService>.d<RoomUpdateListener> {
      AbstractRoomCallback(RoomUpdateListener var2, DataHolder var3) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.common.data.DataHolder) void
      protected void method_2665(RoomUpdateListener var1, DataHolder var2) {
         this.method_2666(var1, GamesClientImpl.this.method_1500(var2), var2.getStatusCode());
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, int) void
      protected abstract void method_2666(RoomUpdateListener var1, Room var2, int var3);
   }

   private abstract class AbstractRoomStatusCallback extends com/google/android/gms/internal/hc<IGamesService>.d<RoomStatusUpdateListener> {
      AbstractRoomStatusCallback(RoomStatusUpdateListener var2, DataHolder var3) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.common.data.DataHolder) void
      protected void method_2662(RoomStatusUpdateListener var1, DataHolder var2) {
         this.method_2663(var1, GamesClientImpl.this.method_1500(var2));
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
      protected abstract void method_2663(RoomStatusUpdateListener var1, Room var2);
   }

   private static final class AcceptQuestResultImpl extends class_442 implements Quests.AcceptQuestResult {
      // $FF: renamed from: ND com.google.android.gms.games.quest.Quest
      private final Quest field_2043;

      AcceptQuestResultImpl(DataHolder var1) {
         super(var1);
         QuestBuffer var2 = new QuestBuffer(var1);

         try {
            if(var2.getCount() > 0) {
               this.field_2043 = new QuestEntity((Quest)var2.get(0));
            } else {
               this.field_2043 = null;
            }
         } finally {
            var2.close();
         }

      }

      public Quest getQuest() {
         return this.field_2043;
      }
   }

   private final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Achievements.UpdateAchievementResult> field_1193;

      AchievementUpdatedBinderCallback(class_797.class_1206<Achievements.UpdateAchievementResult> var1) {
         this.field_1193 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: e (int, java.lang.String) void
      public void method_291(int var1, String var2) {
         this.field_1193.method_673(new GamesClientImpl.UpdateAchievementResultImpl(var1, var2));
      }
   }

   private final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Achievements.LoadAchievementsResult> field_1195;

      AchievementsLoadedBinderCallback(class_797.class_1206<Achievements.LoadAchievementsResult> var1) {
         this.field_1195 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder) void
      public void method_281(DataHolder var1) {
         this.field_1195.method_673(new GamesClientImpl.LoadAchievementsResultImpl(var1));
      }
   }

   private static final class CancelMatchResultImpl implements TurnBasedMultiplayer.CancelMatchResult {
      // $FF: renamed from: NE java.lang.String
      private final String field_3868;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_3869;

      CancelMatchResultImpl(Status var1, String var2) {
         this.field_3869 = var1;
         this.field_3868 = var2;
      }

      public String getMatchId() {
         return this.field_3868;
      }

      public Status getStatus() {
         return this.field_3869;
      }
   }

   private static final class ClaimMilestoneResultImpl extends class_442 implements Quests.ClaimMilestoneResult {
      // $FF: renamed from: ND com.google.android.gms.games.quest.Quest
      private final Quest field_2028;
      // $FF: renamed from: NF com.google.android.gms.games.quest.Milestone
      private final Milestone field_2029;

      ClaimMilestoneResultImpl(DataHolder param1, String param2) {
         // $FF: Couldn't be decompiled
      }

      public Milestone getMilestone() {
         return this.field_2029;
      }

      public Quest getQuest() {
         return this.field_2028;
      }
   }

   private static final class CommitSnapshotResultImpl extends class_442 implements Snapshots.CommitSnapshotResult {
      // $FF: renamed from: NG com.google.android.gms.games.snapshot.SnapshotMetadata
      private final SnapshotMetadata field_2030;

      CommitSnapshotResultImpl(DataHolder var1) {
         super(var1);
         SnapshotMetadataBuffer var2 = new SnapshotMetadataBuffer(var1);

         try {
            if(var2.getCount() > 0) {
               this.field_2030 = new SnapshotMetadataEntity(var2.get(0));
            } else {
               this.field_2030 = null;
            }
         } finally {
            var2.close();
         }

      }

      public SnapshotMetadata getSnapshotMetadata() {
         return this.field_2030;
      }
   }

   private final class ConnectedToRoomCallback extends GamesClientImpl.AbstractRoomStatusCallback {
      ConnectedToRoomCallback(RoomStatusUpdateListener var2, DataHolder var3) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
      public void method_2663(RoomStatusUpdateListener var1, Room var2) {
         var1.onConnectedToRoom(var2);
      }
   }

   private static final class ContactSettingLoadResultImpl extends class_442 implements Notifications.ContactSettingLoadResult {
      ContactSettingLoadResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Notifications.ContactSettingLoadResult> field_1234;

      ContactSettingsLoadedBinderCallback(class_797.class_1206<Notifications.ContactSettingLoadResult> var1) {
         this.field_1234 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: D (com.google.android.gms.common.data.DataHolder) void
      public void method_259(DataHolder var1) {
         this.field_1234.method_673(new GamesClientImpl.ContactSettingLoadResultImpl(var1));
      }
   }

   private final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Status> field_1177;

      ContactSettingsUpdatedBinderCallback(class_797.class_1206<Status> var1) {
         this.field_1177 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: ce (int) void
      public void method_284(int var1) {
         this.field_1177.method_673(new Status(var1));
      }
   }

   private static final class DeleteSnapshotResultImpl implements Snapshots.DeleteSnapshotResult {
      // $FF: renamed from: NH java.lang.String
      private final String field_670;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_671;

      DeleteSnapshotResultImpl(int var1, String var2) {
         this.field_671 = new Status(var1);
         this.field_670 = var2;
      }

      public String getSnapshotId() {
         return this.field_670;
      }

      public Status getStatus() {
         return this.field_671;
      }
   }

   private final class DisconnectedFromRoomCallback extends GamesClientImpl.AbstractRoomStatusCallback {
      DisconnectedFromRoomCallback(RoomStatusUpdateListener var2, DataHolder var3) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
      public void method_2663(RoomStatusUpdateListener var1, Room var2) {
         var1.onDisconnectedFromRoom(var2);
      }
   }

   private final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Events.LoadEventsResult> field_1199;

      EventsLoadedBinderCallback(class_797.class_1206<Events.LoadEventsResult> var1) {
         this.field_1199 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder) void
      public void method_287(DataHolder var1) {
         this.field_1199.method_673(new GamesClientImpl.LoadEventResultImpl(var1));
      }
   }

   private final class ExtendedGamesLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<GamesMetadata.LoadExtendedGamesResult> field_1205;

      ExtendedGamesLoadedBinderCallback(class_797.class_1206<GamesMetadata.LoadExtendedGamesResult> var1) {
         this.field_1205 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: j (com.google.android.gms.common.data.DataHolder) void
      public void method_302(DataHolder var1) {
         this.field_1205.method_673(new GamesClientImpl.LoadExtendedGamesResultImpl(var1));
      }
   }

   private class GameClientEventIncrementCache extends EventIncrementCache {
      public GameClientEventIncrementCache() {
         super(GamesClientImpl.this.getContext().getMainLooper(), 1000);
      }

      // $FF: renamed from: o (java.lang.String, int) void
      protected void method_3474(String var1, int var2) {
         try {
            ((IGamesService)GamesClientImpl.this.fo()).method_571(var1, var2);
         } catch (RemoteException var4) {
            GamesLog.method_4573("GamesClientImpl", "service died");
         }
      }
   }

   private final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<GamesMetadata.LoadGameInstancesResult> field_1254;

      GameInstancesLoadedBinderCallback(class_797.class_1206<GamesMetadata.LoadGameInstancesResult> var1) {
         this.field_1254 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: k (com.google.android.gms.common.data.DataHolder) void
      public void method_303(DataHolder var1) {
         this.field_1254.method_673(new GamesClientImpl.LoadGameInstancesResultImpl(var1));
      }
   }

   private static final class GameMuteStatusChangeResultImpl implements Notifications.GameMuteStatusChangeResult {
      // $FF: renamed from: NI java.lang.String
      private final String field_3703;
      // $FF: renamed from: NJ boolean
      private final boolean field_3704;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_3705;

      public GameMuteStatusChangeResultImpl(int var1, String var2, boolean var3) {
         this.field_3705 = new Status(var1);
         this.field_3703 = var2;
         this.field_3704 = var3;
      }

      public Status getStatus() {
         return this.field_3705;
      }
   }

   private final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Notifications.GameMuteStatusChangeResult> field_1228;

      GameMuteStatusChangedBinderCallback(class_797.class_1206<Notifications.GameMuteStatusChangeResult> var1) {
         this.field_1228 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: a (int, java.lang.String, boolean) void
      public void method_272(int var1, String var2, boolean var3) {
         this.field_1228.method_673(new GamesClientImpl.GameMuteStatusChangeResultImpl(var1, var2, var3));
      }
   }

   private static final class GameMuteStatusLoadResultImpl implements Notifications.GameMuteStatusLoadResult {
      // $FF: renamed from: NI java.lang.String
      private final String field_4326;
      // $FF: renamed from: NJ boolean
      private final boolean field_4327;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_4328;

      public GameMuteStatusLoadResultImpl(DataHolder var1) {
         try {
            this.field_4328 = new Status(var1.getStatusCode());
            if(var1.getCount() > 0) {
               this.field_4326 = var1.method_4560("external_game_id", 0, 0);
               this.field_4327 = var1.method_4561("muted", 0, 0);
            } else {
               this.field_4326 = null;
               this.field_4327 = false;
            }
         } finally {
            var1.close();
         }

      }

      public Status getStatus() {
         return this.field_4328;
      }
   }

   private final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Notifications.GameMuteStatusLoadResult> field_1183;

      GameMuteStatusLoadedBinderCallback(class_797.class_1206<Notifications.GameMuteStatusLoadResult> var1) {
         this.field_1183 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: B (com.google.android.gms.common.data.DataHolder) void
      public void method_257(DataHolder var1) {
         this.field_1183.method_673(new GamesClientImpl.GameMuteStatusLoadResultImpl(var1));
      }
   }

   private final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<GamesMetadata.LoadGameSearchSuggestionsResult> field_1189;

      GameSearchSuggestionsLoadedBinderCallback(class_797.class_1206<GamesMetadata.LoadGameSearchSuggestionsResult> var1) {
         this.field_1189 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: l (com.google.android.gms.common.data.DataHolder) void
      public void method_304(DataHolder var1) {
         this.field_1189.method_673(new GamesClientImpl.LoadGameSearchSuggestionsResultImpl(var1));
      }
   }

   private final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<GamesMetadata.LoadGamesResult> field_1169;

      GamesLoadedBinderCallback(class_797.class_1206<GamesMetadata.LoadGamesResult> var1) {
         this.field_1169 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: i (com.google.android.gms.common.data.DataHolder) void
      public void method_301(DataHolder var1) {
         this.field_1169.method_673(new GamesClientImpl.LoadGamesResultImpl(var1));
      }
   }

   private static final class InboxCountResultImpl implements Notifications.InboxCountResult {
      // $FF: renamed from: NK android.os.Bundle
      private final Bundle field_2159;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_2160;

      InboxCountResultImpl(Status var1, Bundle var2) {
         this.field_2160 = var1;
         this.field_2159 = var2;
      }

      public Status getStatus() {
         return this.field_2160;
      }
   }

   private final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Notifications.InboxCountResult> field_1171;

      InboxCountsLoadedBinderCallback(class_797.class_1206<Notifications.InboxCountResult> var1) {
         this.field_1171 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: f (int, android.os.Bundle) void
      public void method_294(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         Status var3 = new Status(var1);
         this.field_1171.method_673(new GamesClientImpl.InboxCountResultImpl(var3, var2));
      }
   }

   private static final class InitiateMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.InitiateMatchResult {
      InitiateMatchResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: NL com.google.android.gms.games.multiplayer.OnInvitationReceivedListener
      private final OnInvitationReceivedListener field_1179;

      InvitationReceivedBinderCallback(OnInvitationReceivedListener var2) {
         this.field_1179 = var2;
      }

      // $FF: renamed from: n (com.google.android.gms.common.data.DataHolder) void
      public void method_306(DataHolder param1) {
         // $FF: Couldn't be decompiled
      }

      public void onInvitationRemoved(String var1) {
         GamesClientImpl.this.a(GamesClientImpl.this.new InvitationRemovedCallback(this.field_1179, var1));
      }
   }

   private final class InvitationReceivedCallback extends com/google/android/gms/internal/hc<IGamesService>.b<OnInvitationReceivedListener> {
      // $FF: renamed from: NM com.google.android.gms.games.multiplayer.Invitation
      private final Invitation field_1965;

      InvitationReceivedCallback(OnInvitationReceivedListener var2, Invitation var3) {
         super();
         this.field_1965 = var3;
      }

      // $FF: renamed from: b (com.google.android.gms.games.multiplayer.OnInvitationReceivedListener) void
      protected void method_2656(OnInvitationReceivedListener var1) {
         var1.onInvitationReceived(this.field_1965);
      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      protected void method_2638(Object var1) {
         this.method_2656((OnInvitationReceivedListener)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }

   private final class InvitationRemovedCallback extends com/google/android/gms/internal/hc<IGamesService>.b<OnInvitationReceivedListener> {
      // $FF: renamed from: NN java.lang.String
      private final String field_1961;

      InvitationRemovedCallback(OnInvitationReceivedListener var2, String var3) {
         super();
         this.field_1961 = var3;
      }

      // $FF: renamed from: b (com.google.android.gms.games.multiplayer.OnInvitationReceivedListener) void
      protected void method_2654(OnInvitationReceivedListener var1) {
         var1.onInvitationRemoved(this.field_1961);
      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      protected void method_2638(Object var1) {
         this.method_2654((OnInvitationReceivedListener)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }

   private final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Invitations.LoadInvitationsResult> field_1197;

      InvitationsLoadedBinderCallback(class_797.class_1206<Invitations.LoadInvitationsResult> var1) {
         this.field_1197 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: m (com.google.android.gms.common.data.DataHolder) void
      public void method_305(DataHolder var1) {
         this.field_1197.method_673(new GamesClientImpl.LoadInvitationsResultImpl(var1));
      }
   }

   private final class JoinedRoomCallback extends GamesClientImpl.AbstractRoomCallback {
      public JoinedRoomCallback(RoomUpdateListener var2, DataHolder var3) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, int) void
      public void method_2666(RoomUpdateListener var1, Room var2, int var3) {
         var1.onJoinedRoom(var3, var2);
      }
   }

   private static final class LeaderboardMetadataResultImpl extends class_442 implements Leaderboards.LeaderboardMetadataResult {
      // $FF: renamed from: NO com.google.android.gms.games.leaderboard.LeaderboardBuffer
      private final LeaderboardBuffer field_2042;

      LeaderboardMetadataResultImpl(DataHolder var1) {
         super(var1);
         this.field_2042 = new LeaderboardBuffer(var1);
      }

      public LeaderboardBuffer getLeaderboards() {
         return this.field_2042;
      }
   }

   private final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Leaderboards.LoadScoresResult> field_1187;

      LeaderboardScoresLoadedBinderCallback(class_797.class_1206<Leaderboards.LoadScoresResult> var1) {
         this.field_1187 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.common.data.DataHolder) void
      public void method_273(DataHolder var1, DataHolder var2) {
         this.field_1187.method_673(new GamesClientImpl.LoadScoresResultImpl(var1, var2));
      }
   }

   private final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Leaderboards.LeaderboardMetadataResult> field_1220;

      LeaderboardsLoadedBinderCallback(class_797.class_1206<Leaderboards.LeaderboardMetadataResult> var1) {
         this.field_1220 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: e (com.google.android.gms.common.data.DataHolder) void
      public void method_292(DataHolder var1) {
         this.field_1220.method_673(new GamesClientImpl.LeaderboardMetadataResultImpl(var1));
      }
   }

   private static final class LeaveMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.LeaveMatchResult {
      LeaveMatchResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private final class LeftRoomCallback extends com/google/android/gms/internal/hc<IGamesService>.b<RoomUpdateListener> {
      // $FF: renamed from: CQ int
      private final int field_1940;
      // $FF: renamed from: NP java.lang.String
      private final String field_1942;

      LeftRoomCallback(RoomUpdateListener var2, int var3, String var4) {
         super();
         this.field_1940 = var3;
         this.field_1942 = var4;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener) void
      public void method_2647(RoomUpdateListener var1) {
         var1.onLeftRoom(this.field_1940, this.field_1942);
      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      public void method_2638(Object var1) {
         this.method_2647((RoomUpdateListener)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }

   private static final class LoadAchievementsResultImpl extends class_442 implements Achievements.LoadAchievementsResult {
      // $FF: renamed from: NQ com.google.android.gms.games.achievement.AchievementBuffer
      private final AchievementBuffer field_2018;

      LoadAchievementsResultImpl(DataHolder var1) {
         super(var1);
         this.field_2018 = new AchievementBuffer(var1);
      }

      public AchievementBuffer getAchievements() {
         return this.field_2018;
      }
   }

   private static final class LoadAclResultImpl extends class_442 implements Acls.LoadAclResult {
      LoadAclResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class LoadEventResultImpl extends class_442 implements Events.LoadEventsResult {
      // $FF: renamed from: NR com.google.android.gms.games.event.EventBuffer
      private final EventBuffer field_2022;

      LoadEventResultImpl(DataHolder var1) {
         super(var1);
         this.field_2022 = new EventBuffer(var1);
      }

      public EventBuffer getEvents() {
         return this.field_2022;
      }
   }

   private static final class LoadExtendedGamesResultImpl extends class_442 implements GamesMetadata.LoadExtendedGamesResult {
      // $FF: renamed from: NS com.google.android.gms.games.internal.game.ExtendedGameBuffer
      private final ExtendedGameBuffer field_2035;

      LoadExtendedGamesResultImpl(DataHolder var1) {
         super(var1);
         this.field_2035 = new ExtendedGameBuffer(var1);
      }
   }

   private static final class LoadGameInstancesResultImpl extends class_442 implements GamesMetadata.LoadGameInstancesResult {
      // $FF: renamed from: NT com.google.android.gms.games.internal.game.GameInstanceBuffer
      private final GameInstanceBuffer field_2040;

      LoadGameInstancesResultImpl(DataHolder var1) {
         super(var1);
         this.field_2040 = new GameInstanceBuffer(var1);
      }
   }

   private static final class LoadGameSearchSuggestionsResultImpl extends class_442 implements GamesMetadata.LoadGameSearchSuggestionsResult {
      LoadGameSearchSuggestionsResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class LoadGamesResultImpl extends class_442 implements GamesMetadata.LoadGamesResult {
      // $FF: renamed from: NU com.google.android.gms.games.GameBuffer
      private final GameBuffer field_2023;

      LoadGamesResultImpl(DataHolder var1) {
         super(var1);
         this.field_2023 = new GameBuffer(var1);
      }

      public GameBuffer getGames() {
         return this.field_2023;
      }
   }

   private static final class LoadInvitationsResultImpl extends class_442 implements Invitations.LoadInvitationsResult {
      // $FF: renamed from: NV com.google.android.gms.games.multiplayer.InvitationBuffer
      private final InvitationBuffer field_2033;

      LoadInvitationsResultImpl(DataHolder var1) {
         super(var1);
         this.field_2033 = new InvitationBuffer(var1);
      }

      public InvitationBuffer getInvitations() {
         return this.field_2033;
      }
   }

   private static final class LoadMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.LoadMatchResult {
      LoadMatchResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class LoadMatchesResultImpl implements TurnBasedMultiplayer.LoadMatchesResult {
      // $FF: renamed from: NW com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse
      private final LoadMatchesResponse field_4160;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_4161;

      LoadMatchesResultImpl(Status var1, Bundle var2) {
         this.field_4161 = var1;
         this.field_4160 = new LoadMatchesResponse(var2);
      }

      public LoadMatchesResponse getMatches() {
         return this.field_4160;
      }

      public Status getStatus() {
         return this.field_4161;
      }

      public void release() {
         this.field_4160.close();
      }
   }

   private static final class LoadOwnerCoverPhotoUrisResultImpl implements Players.LoadOwnerCoverPhotoUrisResult {
      // $FF: renamed from: HJ android.os.Bundle
      private final Bundle field_3673;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_3674;

      LoadOwnerCoverPhotoUrisResultImpl(int var1, Bundle var2) {
         this.field_3674 = new Status(var1);
         this.field_3673 = var2;
      }

      public Status getStatus() {
         return this.field_3674;
      }
   }

   private static final class LoadPlayerScoreResultImpl extends class_442 implements Leaderboards.LoadPlayerScoreResult {
      // $FF: renamed from: NX com.google.android.gms.games.leaderboard.LeaderboardScoreEntity
      private final LeaderboardScoreEntity field_2041;

      LoadPlayerScoreResultImpl(DataHolder var1) {
         super(var1);
         LeaderboardScoreBuffer var2 = new LeaderboardScoreBuffer(var1);

         try {
            if(var2.getCount() > 0) {
               this.field_2041 = (LeaderboardScoreEntity)var2.get(0).freeze();
            } else {
               this.field_2041 = null;
            }
         } finally {
            var2.close();
         }

      }

      public LeaderboardScore getScore() {
         return this.field_2041;
      }
   }

   private static final class LoadPlayersResultImpl extends class_442 implements Players.LoadPlayersResult {
      // $FF: renamed from: NY com.google.android.gms.games.PlayerBuffer
      private final PlayerBuffer field_2034;

      LoadPlayersResultImpl(DataHolder var1) {
         super(var1);
         this.field_2034 = new PlayerBuffer(var1);
      }

      public PlayerBuffer getPlayers() {
         return this.field_2034;
      }
   }

   private static final class LoadQuestsResultImpl extends class_442 implements Quests.LoadQuestsResult {
      // $FF: renamed from: DD com.google.android.gms.common.data.DataHolder
      private final DataHolder field_2027;

      LoadQuestsResultImpl(DataHolder var1) {
         super(var1);
         this.field_2027 = var1;
      }

      public QuestBuffer getQuests() {
         return new QuestBuffer(this.field_2027);
      }
   }

   private static final class LoadRequestSummariesResultImpl extends class_442 implements Requests.LoadRequestSummariesResult {
      LoadRequestSummariesResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class LoadRequestsResultImpl implements Requests.LoadRequestsResult {
      // $FF: renamed from: NZ android.os.Bundle
      private final Bundle field_4357;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_4358;

      LoadRequestsResultImpl(Status var1, Bundle var2) {
         this.field_4358 = var1;
         this.field_4357 = var2;
      }

      public GameRequestBuffer getRequests(int var1) {
         String var2 = RequestType.method_4063(var1);
         return !this.field_4357.containsKey(var2)?null:new GameRequestBuffer((DataHolder)this.field_4357.get(var2));
      }

      public Status getStatus() {
         return this.field_4358;
      }

      public void release() {
         Iterator var1 = this.field_4357.keySet().iterator();

         while(var1.hasNext()) {
            String var2 = (String)var1.next();
            DataHolder var3 = (DataHolder)this.field_4357.getParcelable(var2);
            if(var3 != null) {
               var3.close();
            }
         }

      }
   }

   private static final class LoadScoresResultImpl extends class_442 implements Leaderboards.LoadScoresResult {
      // $FF: renamed from: Oa com.google.android.gms.games.leaderboard.LeaderboardEntity
      private final LeaderboardEntity field_2020;
      // $FF: renamed from: Ob com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer
      private final LeaderboardScoreBuffer field_2021;

      LoadScoresResultImpl(DataHolder var1, DataHolder var2) {
         super(var2);
         LeaderboardBuffer var3 = new LeaderboardBuffer(var1);

         try {
            if(var3.getCount() > 0) {
               this.field_2020 = (LeaderboardEntity)((Leaderboard)var3.get(0)).freeze();
            } else {
               this.field_2020 = null;
            }
         } finally {
            var3.close();
         }

         this.field_2021 = new LeaderboardScoreBuffer(var2);
      }

      public Leaderboard getLeaderboard() {
         return this.field_2020;
      }

      public LeaderboardScoreBuffer getScores() {
         return this.field_2021;
      }
   }

   private static final class LoadSnapshotsResultImpl extends class_442 implements Snapshots.LoadSnapshotsResult {
      LoadSnapshotsResultImpl(DataHolder var1) {
         super(var1);
      }

      public SnapshotMetadataBuffer getSnapshots() {
         return new SnapshotMetadataBuffer(this.DD);
      }
   }

   private static final class LoadXpForGameCategoriesResultImpl implements Players.LoadXpForGameCategoriesResult {
      // $FF: renamed from: Oc java.util.List
      private final List<String> field_3518;
      // $FF: renamed from: Od android.os.Bundle
      private final Bundle field_3519;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_3520;

      LoadXpForGameCategoriesResultImpl(Status var1, Bundle var2) {
         this.field_3520 = var1;
         this.field_3518 = var2.getStringArrayList("game_category_list");
         this.field_3519 = var2;
      }

      public Status getStatus() {
         return this.field_3520;
      }
   }

   private static final class LoadXpStreamResultImpl extends class_442 implements Players.LoadXpStreamResult {
      // $FF: renamed from: Oe com.google.android.gms.games.internal.experience.ExperienceEventBuffer
      private final ExperienceEventBuffer field_2019;

      LoadXpStreamResultImpl(DataHolder var1) {
         super(var1);
         this.field_2019 = new ExperienceEventBuffer(var1);
      }
   }

   private final class MatchRemovedCallback extends com/google/android/gms/internal/hc<IGamesService>.b<OnTurnBasedMatchUpdateReceivedListener> {
      // $FF: renamed from: Of java.lang.String
      private final String field_1935;

      MatchRemovedCallback(OnTurnBasedMatchUpdateReceivedListener var2, String var3) {
         super();
         this.field_1935 = var3;
      }

      // $FF: renamed from: b (com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener) void
      protected void method_2643(OnTurnBasedMatchUpdateReceivedListener var1) {
         var1.onTurnBasedMatchRemoved(this.field_1935);
      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      protected void method_2638(Object var1) {
         this.method_2643((OnTurnBasedMatchUpdateReceivedListener)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }

   private final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Og com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener
      private final OnTurnBasedMatchUpdateReceivedListener field_1185;

      MatchUpdateReceivedBinderCallback(OnTurnBasedMatchUpdateReceivedListener var2) {
         this.field_1185 = var2;
      }

      public void onTurnBasedMatchRemoved(String var1) {
         GamesClientImpl.this.a(GamesClientImpl.this.new MatchRemovedCallback(this.field_1185, var1));
      }

      // $FF: renamed from: t (com.google.android.gms.common.data.DataHolder) void
      public void method_312(DataHolder param1) {
         // $FF: Couldn't be decompiled
      }
   }

   private final class MatchUpdateReceivedCallback extends com/google/android/gms/internal/hc<IGamesService>.b<OnTurnBasedMatchUpdateReceivedListener> {
      // $FF: renamed from: Oh com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
      private final TurnBasedMatch field_1950;

      MatchUpdateReceivedCallback(OnTurnBasedMatchUpdateReceivedListener var2, TurnBasedMatch var3) {
         super();
         this.field_1950 = var3;
      }

      // $FF: renamed from: b (com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener) void
      protected void method_2650(OnTurnBasedMatchUpdateReceivedListener var1) {
         var1.onTurnBasedMatchReceived(this.field_1950);
      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      protected void method_2638(Object var1) {
         this.method_2650((OnTurnBasedMatchUpdateReceivedListener)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }

   private final class MessageReceivedCallback extends com/google/android/gms/internal/hc<IGamesService>.b<RealTimeMessageReceivedListener> {
      // $FF: renamed from: Oi com.google.android.gms.games.multiplayer.realtime.RealTimeMessage
      private final RealTimeMessage field_1963;

      MessageReceivedCallback(RealTimeMessageReceivedListener var2, RealTimeMessage var3) {
         super();
         this.field_1963 = var3;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener) void
      public void method_2655(RealTimeMessageReceivedListener var1) {
         if(var1 != null) {
            var1.onRealTimeMessageReceived(this.field_1963);
         }

      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      public void method_2638(Object var1) {
         this.method_2655((RealTimeMessageReceivedListener)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }

   private final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Acls.LoadAclResult> field_1260;

      NotifyAclLoadedBinderCallback(class_797.class_1206<Acls.LoadAclResult> var1) {
         this.field_1260 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: C (com.google.android.gms.common.data.DataHolder) void
      public void method_258(DataHolder var1) {
         this.field_1260.method_673(new GamesClientImpl.LoadAclResultImpl(var1));
      }
   }

   private final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Status> field_1246;

      NotifyAclUpdatedBinderCallback(class_797.class_1206<Status> var1) {
         this.field_1246 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: cd (int) void
      public void method_283(int var1) {
         this.field_1246.method_673(new Status(var1));
      }
   }

   private static final class OpenSnapshotResultImpl extends class_442 implements Snapshots.OpenSnapshotResult {
      // $FF: renamed from: Oj com.google.android.gms.games.snapshot.Snapshot
      private final Snapshot field_2036;
      // $FF: renamed from: Ok java.lang.String
      private final String field_2037;
      // $FF: renamed from: Ol com.google.android.gms.games.snapshot.Snapshot
      private final Snapshot field_2038;
      // $FF: renamed from: Om com.google.android.gms.drive.Contents
      private final Contents field_2039;

      OpenSnapshotResultImpl(DataHolder var1, Contents var2) {
         this(var1, (String)null, var2, (Contents)null, (Contents)null);
      }

      OpenSnapshotResultImpl(DataHolder param1, String param2, Contents param3, Contents param4, Contents param5) {
         // $FF: Couldn't be decompiled
      }

      public String getConflictId() {
         return this.field_2037;
      }

      public Snapshot getConflictingSnapshot() {
         return this.field_2038;
      }

      public Contents getResolutionContents() {
         return this.field_2039;
      }

      public Snapshot getSnapshot() {
         return this.field_2036;
      }
   }

   private final class OwnerCoverPhotoUrisLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Players.LoadOwnerCoverPhotoUrisResult> field_1226;

      OwnerCoverPhotoUrisLoadedBinderCallback(class_797.class_1206<Players.LoadOwnerCoverPhotoUrisResult> var1) {
         this.field_1226 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: d (int, android.os.Bundle) void
      public void method_285(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         this.field_1226.method_673(new GamesClientImpl.LoadOwnerCoverPhotoUrisResultImpl(var1, var2));
      }
   }

   private final class P2PConnectedCallback extends com/google/android/gms/internal/hc<IGamesService>.b<RoomStatusUpdateListener> {
      // $FF: renamed from: On java.lang.String
      private final String field_1937;

      P2PConnectedCallback(RoomStatusUpdateListener var2, String var3) {
         super();
         this.field_1937 = var3;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener) void
      public void method_2644(RoomStatusUpdateListener var1) {
         if(var1 != null) {
            var1.onP2PConnected(this.field_1937);
         }

      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      public void method_2638(Object var1) {
         this.method_2644((RoomStatusUpdateListener)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }

   private final class P2PDisconnectedCallback extends com/google/android/gms/internal/hc<IGamesService>.b<RoomStatusUpdateListener> {
      // $FF: renamed from: On java.lang.String
      private final String field_1944;

      P2PDisconnectedCallback(RoomStatusUpdateListener var2, String var3) {
         super();
         this.field_1944 = var3;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener) void
      public void method_2648(RoomStatusUpdateListener var1) {
         if(var1 != null) {
            var1.onP2PDisconnected(this.field_1944);
         }

      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      public void method_2638(Object var1) {
         this.method_2648((RoomStatusUpdateListener)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }

   private final class PeerConnectedCallback extends GamesClientImpl.AbstractPeerStatusCallback {
      PeerConnectedCallback(RoomStatusUpdateListener var2, DataHolder var3, String[] var4) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
      protected void method_2664(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
         var1.onPeersConnected(var2, var3);
      }
   }

   private final class PeerDeclinedCallback extends GamesClientImpl.AbstractPeerStatusCallback {
      PeerDeclinedCallback(RoomStatusUpdateListener var2, DataHolder var3, String[] var4) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
      protected void method_2664(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
         var1.onPeerDeclined(var2, var3);
      }
   }

   private final class PeerDisconnectedCallback extends GamesClientImpl.AbstractPeerStatusCallback {
      PeerDisconnectedCallback(RoomStatusUpdateListener var2, DataHolder var3, String[] var4) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
      protected void method_2664(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
         var1.onPeersDisconnected(var2, var3);
      }
   }

   private final class PeerInvitedToRoomCallback extends GamesClientImpl.AbstractPeerStatusCallback {
      PeerInvitedToRoomCallback(RoomStatusUpdateListener var2, DataHolder var3, String[] var4) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
      protected void method_2664(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
         var1.onPeerInvitedToRoom(var2, var3);
      }
   }

   private final class PeerJoinedRoomCallback extends GamesClientImpl.AbstractPeerStatusCallback {
      PeerJoinedRoomCallback(RoomStatusUpdateListener var2, DataHolder var3, String[] var4) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
      protected void method_2664(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
         var1.onPeerJoined(var2, var3);
      }
   }

   private final class PeerLeftRoomCallback extends GamesClientImpl.AbstractPeerStatusCallback {
      PeerLeftRoomCallback(RoomStatusUpdateListener var2, DataHolder var3, String[] var4) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, java.util.ArrayList) void
      protected void method_2664(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3) {
         var1.onPeerLeft(var2, var3);
      }
   }

   private final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Leaderboards.LoadPlayerScoreResult> field_1256;

      PlayerLeaderboardScoreLoadedBinderCallback(class_797.class_1206<Leaderboards.LoadPlayerScoreResult> var1) {
         this.field_1256 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: E (com.google.android.gms.common.data.DataHolder) void
      public void method_260(DataHolder var1) {
         this.field_1256.method_673(new GamesClientImpl.LoadPlayerScoreResultImpl(var1));
      }
   }

   private final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Players.LoadXpForGameCategoriesResult> field_1201;

      PlayerXpForGameCategoriesLoadedBinderCallback(class_797.class_1206<Players.LoadXpForGameCategoriesResult> var1) {
         this.field_1201 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: e (int, android.os.Bundle) void
      public void method_290(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         Status var3 = new Status(var1);
         this.field_1201.method_673(new GamesClientImpl.LoadXpForGameCategoriesResultImpl(var3, var2));
      }
   }

   final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Players.LoadXpStreamResult> field_1218;

      PlayerXpStreamLoadedBinderCallback(class_797.class_1206<Players.LoadXpStreamResult> var1) {
         this.field_1218 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: P (com.google.android.gms.common.data.DataHolder) void
      public void method_271(DataHolder var1) {
         this.field_1218.method_673(new GamesClientImpl.LoadXpStreamResultImpl(var1));
      }
   }

   private final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Players.LoadPlayersResult> field_1252;

      PlayersLoadedBinderCallback(class_797.class_1206<Players.LoadPlayersResult> var1) {
         this.field_1252 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: g (com.google.android.gms.common.data.DataHolder) void
      public void method_299(DataHolder var1) {
         this.field_1252.method_673(new GamesClientImpl.LoadPlayersResultImpl(var1));
      }

      // $FF: renamed from: h (com.google.android.gms.common.data.DataHolder) void
      public void method_300(DataHolder var1) {
         this.field_1252.method_673(new GamesClientImpl.LoadPlayersResultImpl(var1));
      }
   }

   private final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Oo com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Quests.AcceptQuestResult> field_1264;

      public QuestAcceptedBinderCallbacks(class_797.class_1206<Quests.AcceptQuestResult> var1) {
         this.field_1264 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: L (com.google.android.gms.common.data.DataHolder) void
      public void method_267(DataHolder var1) {
         this.field_1264.method_673(new GamesClientImpl.AcceptQuestResultImpl(var1));
      }
   }

   private final class QuestCompletedCallback extends com/google/android/gms/internal/hc<IGamesService>.b<QuestUpdateListener> {
      // $FF: renamed from: ND com.google.android.gms.games.quest.Quest
      private final Quest field_1933;

      QuestCompletedCallback(QuestUpdateListener var2, Quest var3) {
         super();
         this.field_1933 = var3;
      }

      // $FF: renamed from: b (com.google.android.gms.games.quest.QuestUpdateListener) void
      protected void method_2642(QuestUpdateListener var1) {
         var1.onQuestCompleted(this.field_1933);
      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      protected void method_2638(Object var1) {
         this.method_2642((QuestUpdateListener)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }

   private final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Op com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Quests.ClaimMilestoneResult> field_1211;
      // $FF: renamed from: Oq java.lang.String
      private final String field_1212;

      public QuestMilestoneClaimBinderCallbacks(class_797.class_1206<Quests.ClaimMilestoneResult> var1, String var2) {
         this.field_1211 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
         this.field_1212 = (String)class_347.method_2166(var3, "MilestoneId must not be null");
      }

      // $FF: renamed from: K (com.google.android.gms.common.data.DataHolder) void
      public void method_266(DataHolder var1) {
         this.field_1211.method_673(new GamesClientImpl.ClaimMilestoneResultImpl(var1, this.field_1212));
      }
   }

   private final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Or com.google.android.gms.games.quest.QuestUpdateListener
      private final QuestUpdateListener field_1242;

      QuestUpdateBinderCallback(QuestUpdateListener var2) {
         this.field_1242 = var2;
      }

      // $FF: renamed from: R (com.google.android.gms.common.data.DataHolder) com.google.android.gms.games.quest.Quest
      private Quest method_2023(DataHolder param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: M (com.google.android.gms.common.data.DataHolder) void
      public void method_268(DataHolder var1) {
         Quest var2 = this.method_2023(var1);
         if(var2 != null) {
            GamesClientImpl.this.a(GamesClientImpl.this.new QuestCompletedCallback(this.field_1242, var2));
         }

      }
   }

   private final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Os com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Quests.LoadQuestsResult> field_1232;

      public QuestsLoadedBinderCallbacks(class_797.class_1206<Quests.LoadQuestsResult> var1) {
         this.field_1232 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: O (com.google.android.gms.common.data.DataHolder) void
      public void method_270(DataHolder var1) {
         this.field_1232.method_673(new GamesClientImpl.LoadQuestsResultImpl(var1));
      }
   }

   private final class RealTimeMessageSentCallback extends com/google/android/gms/internal/hc<IGamesService>.b<RealTimeMultiplayer.ReliableMessageSentCallback> {
      // $FF: renamed from: CQ int
      private final int field_1945;
      // $FF: renamed from: Ot java.lang.String
      private final String field_1947;
      // $FF: renamed from: Ou int
      private final int field_1948;

      RealTimeMessageSentCallback(RealTimeMultiplayer.ReliableMessageSentCallback var2, int var3, int var4, String var5) {
         super();
         this.field_1945 = var3;
         this.field_1948 = var4;
         this.field_1947 = var5;
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer$ReliableMessageSentCallback) void
      public void method_2649(RealTimeMultiplayer.ReliableMessageSentCallback var1) {
         if(var1 != null) {
            var1.onRealTimeMessageSent(this.field_1945, this.field_1948, this.field_1947);
         }

      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      public void method_2638(Object var1) {
         this.method_2649((RealTimeMultiplayer.ReliableMessageSentCallback)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }

   private final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Ov com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer$ReliableMessageSentCallback
      final RealTimeMultiplayer.ReliableMessageSentCallback field_1191;

      public RealTimeReliableMessageBinderCallbacks(RealTimeMultiplayer.ReliableMessageSentCallback var2) {
         this.field_1191 = var2;
      }

      // $FF: renamed from: b (int, int, java.lang.String) void
      public void method_277(int var1, int var2, String var3) {
         GamesClientImpl.this.a(GamesClientImpl.this.new RealTimeMessageSentCallback(this.field_1191, var1, var2, var3));
      }
   }

   private final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
      // $FF: renamed from: Ow com.google.android.gms.games.request.OnRequestReceivedListener
      private final OnRequestReceivedListener field_1175;

      RequestReceivedBinderCallback(OnRequestReceivedListener var2) {
         this.field_1175 = var2;
      }

      // $FF: renamed from: o (com.google.android.gms.common.data.DataHolder) void
      public void method_307(DataHolder param1) {
         // $FF: Couldn't be decompiled
      }

      public void onRequestRemoved(String var1) {
         GamesClientImpl.this.a(GamesClientImpl.this.new RequestRemovedCallback(this.field_1175, var1));
      }
   }

   private final class RequestReceivedCallback extends com/google/android/gms/internal/hc<IGamesService>.b<OnRequestReceivedListener> {
      // $FF: renamed from: Ox com.google.android.gms.games.request.GameRequest
      private final GameRequest field_1959;

      RequestReceivedCallback(OnRequestReceivedListener var2, GameRequest var3) {
         super();
         this.field_1959 = var3;
      }

      // $FF: renamed from: b (com.google.android.gms.games.request.OnRequestReceivedListener) void
      protected void method_2653(OnRequestReceivedListener var1) {
         var1.onRequestReceived(this.field_1959);
      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      protected void method_2638(Object var1) {
         this.method_2653((OnRequestReceivedListener)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }

   private final class RequestRemovedCallback extends com/google/android/gms/internal/hc<IGamesService>.b<OnRequestReceivedListener> {
      // $FF: renamed from: Oy java.lang.String
      private final String field_1967;

      RequestRemovedCallback(OnRequestReceivedListener var2, String var3) {
         super();
         this.field_1967 = var3;
      }

      // $FF: renamed from: b (com.google.android.gms.games.request.OnRequestReceivedListener) void
      protected void method_2657(OnRequestReceivedListener var1) {
         var1.onRequestRemoved(this.field_1967);
      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      protected void method_2638(Object var1) {
         this.method_2657((OnRequestReceivedListener)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }

   private final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: Oz com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Requests.SendRequestResult> field_1236;

      public RequestSentBinderCallbacks(class_797.class_1206<Requests.SendRequestResult> var1) {
         this.field_1236 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: G (com.google.android.gms.common.data.DataHolder) void
      public void method_262(DataHolder var1) {
         this.field_1236.method_673(new GamesClientImpl.SendRequestResultImpl(var1));
      }
   }

   private final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: OA com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Requests.LoadRequestSummariesResult> field_1258;

      public RequestSummariesLoadedBinderCallbacks(class_797.class_1206<Requests.LoadRequestSummariesResult> var1) {
         this.field_1258 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: H (com.google.android.gms.common.data.DataHolder) void
      public void method_263(DataHolder var1) {
         this.field_1258.method_673(new GamesClientImpl.LoadRequestSummariesResultImpl(var1));
      }
   }

   private final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: OB com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Requests.LoadRequestsResult> field_1181;

      public RequestsLoadedBinderCallbacks(class_797.class_1206<Requests.LoadRequestsResult> var1) {
         this.field_1181 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: c (int, android.os.Bundle) void
      public void method_280(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         Status var3 = new Status(var1);
         this.field_1181.method_673(new GamesClientImpl.LoadRequestsResultImpl(var3, var2));
      }
   }

   private final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: OC com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Requests.UpdateRequestsResult> field_1173;

      public RequestsUpdatedBinderCallbacks(class_797.class_1206<Requests.UpdateRequestsResult> var1) {
         this.field_1173 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: F (com.google.android.gms.common.data.DataHolder) void
      public void method_261(DataHolder var1) {
         this.field_1173.method_673(new GamesClientImpl.UpdateRequestsResultImpl(var1));
      }
   }

   private final class RoomAutoMatchingCallback extends GamesClientImpl.AbstractRoomStatusCallback {
      RoomAutoMatchingCallback(RoomStatusUpdateListener var2, DataHolder var3) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
      public void method_2663(RoomStatusUpdateListener var1, Room var2) {
         var1.onRoomAutoMatching(var2);
      }
   }

   private final class RoomBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: OD com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
      private final RoomUpdateListener field_1222;
      // $FF: renamed from: OE com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
      private final RoomStatusUpdateListener field_1223;
      // $FF: renamed from: OF com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener
      private final RealTimeMessageReceivedListener field_1224;

      public RoomBinderCallbacks(RoomUpdateListener var2) {
         this.field_1222 = (RoomUpdateListener)class_347.method_2166(var2, "Callbacks must not be null");
         this.field_1223 = null;
         this.field_1224 = null;
      }

      public RoomBinderCallbacks(RoomUpdateListener var2, RoomStatusUpdateListener var3, RealTimeMessageReceivedListener var4) {
         this.field_1222 = (RoomUpdateListener)class_347.method_2166(var2, "Callbacks must not be null");
         this.field_1223 = var3;
         this.field_1224 = var4;
      }

      // $FF: renamed from: A (com.google.android.gms.common.data.DataHolder) void
      public void method_256(DataHolder var1) {
         GamesClientImpl.this.a(GamesClientImpl.this.new DisconnectedFromRoomCallback(this.field_1223, var1));
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_276(DataHolder var1, String[] var2) {
         GamesClientImpl.this.a(GamesClientImpl.this.new PeerInvitedToRoomCallback(this.field_1223, var1, var2));
      }

      // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_279(DataHolder var1, String[] var2) {
         GamesClientImpl.this.a(GamesClientImpl.this.new PeerJoinedRoomCallback(this.field_1223, var1, var2));
      }

      // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_282(DataHolder var1, String[] var2) {
         GamesClientImpl.this.a(GamesClientImpl.this.new PeerLeftRoomCallback(this.field_1223, var1, var2));
      }

      // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_288(DataHolder var1, String[] var2) {
         GamesClientImpl.this.a(GamesClientImpl.this.new PeerDeclinedCallback(this.field_1223, var1, var2));
      }

      // $FF: renamed from: e (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_293(DataHolder var1, String[] var2) {
         GamesClientImpl.this.a(GamesClientImpl.this.new PeerConnectedCallback(this.field_1223, var1, var2));
      }

      // $FF: renamed from: f (com.google.android.gms.common.data.DataHolder, java.lang.String[]) void
      public void method_297(DataHolder var1, String[] var2) {
         GamesClientImpl.this.a(GamesClientImpl.this.new PeerDisconnectedCallback(this.field_1223, var1, var2));
      }

      public void onLeftRoom(int var1, String var2) {
         GamesClientImpl.this.a(GamesClientImpl.this.new LeftRoomCallback(this.field_1222, var1, var2));
      }

      public void onP2PConnected(String var1) {
         GamesClientImpl.this.a(GamesClientImpl.this.new P2PConnectedCallback(this.field_1223, var1));
      }

      public void onP2PDisconnected(String var1) {
         GamesClientImpl.this.a(GamesClientImpl.this.new P2PDisconnectedCallback(this.field_1223, var1));
      }

      public void onRealTimeMessageReceived(RealTimeMessage var1) {
         GamesClientImpl.this.a(GamesClientImpl.this.new MessageReceivedCallback(this.field_1224, var1));
      }

      // $FF: renamed from: u (com.google.android.gms.common.data.DataHolder) void
      public void method_313(DataHolder var1) {
         GamesClientImpl.this.a(GamesClientImpl.this.new RoomCreatedCallback(this.field_1222, var1));
      }

      // $FF: renamed from: v (com.google.android.gms.common.data.DataHolder) void
      public void method_314(DataHolder var1) {
         GamesClientImpl.this.a(GamesClientImpl.this.new JoinedRoomCallback(this.field_1222, var1));
      }

      // $FF: renamed from: w (com.google.android.gms.common.data.DataHolder) void
      public void method_315(DataHolder var1) {
         GamesClientImpl.this.a(GamesClientImpl.this.new RoomConnectingCallback(this.field_1223, var1));
      }

      // $FF: renamed from: x (com.google.android.gms.common.data.DataHolder) void
      public void method_316(DataHolder var1) {
         GamesClientImpl.this.a(GamesClientImpl.this.new RoomAutoMatchingCallback(this.field_1223, var1));
      }

      // $FF: renamed from: y (com.google.android.gms.common.data.DataHolder) void
      public void method_317(DataHolder var1) {
         GamesClientImpl.this.a(GamesClientImpl.this.new RoomConnectedCallback(this.field_1222, var1));
      }

      // $FF: renamed from: z (com.google.android.gms.common.data.DataHolder) void
      public void method_318(DataHolder var1) {
         GamesClientImpl.this.a(GamesClientImpl.this.new ConnectedToRoomCallback(this.field_1223, var1));
      }
   }

   private final class RoomConnectedCallback extends GamesClientImpl.AbstractRoomCallback {
      RoomConnectedCallback(RoomUpdateListener var2, DataHolder var3) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, int) void
      public void method_2666(RoomUpdateListener var1, Room var2, int var3) {
         var1.onRoomConnected(var3, var2);
      }
   }

   private final class RoomConnectingCallback extends GamesClientImpl.AbstractRoomStatusCallback {
      RoomConnectingCallback(RoomStatusUpdateListener var2, DataHolder var3) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room) void
      public void method_2663(RoomStatusUpdateListener var1, Room var2) {
         var1.onRoomConnecting(var2);
      }
   }

   private final class RoomCreatedCallback extends GamesClientImpl.AbstractRoomCallback {
      public RoomCreatedCallback(RoomUpdateListener var2, DataHolder var3) {
         super();
      }

      // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener, com.google.android.gms.games.multiplayer.realtime.Room, int) void
      public void method_2666(RoomUpdateListener var1, Room var2, int var3) {
         var1.onRoomCreated(var3, var2);
      }
   }

   private static final class SendRequestResultImpl extends class_442 implements Requests.SendRequestResult {
      // $FF: renamed from: Ox com.google.android.gms.games.request.GameRequest
      private final GameRequest field_2031;

      SendRequestResultImpl(DataHolder var1) {
         super(var1);
         GameRequestBuffer var2 = new GameRequestBuffer(var1);

         try {
            if(var2.getCount() > 0) {
               this.field_2031 = (GameRequest)((GameRequest)var2.get(0)).freeze();
            } else {
               this.field_2031 = null;
            }
         } finally {
            var2.close();
         }

      }
   }

   private final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Status> field_1248;

      public SignOutCompleteBinderCallbacks(class_797.class_1206<Status> var1) {
         this.field_1248 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: dO () void
      public void method_289() {
         Status var1 = new Status(0);
         this.field_1248.method_673(var1);
      }
   }

   private final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: OG com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Snapshots.CommitSnapshotResult> field_1238;

      public SnapshotCommittedBinderCallbacks(class_797.class_1206<Snapshots.CommitSnapshotResult> var1) {
         this.field_1238 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: J (com.google.android.gms.common.data.DataHolder) void
      public void method_265(DataHolder var1) {
         this.field_1238.method_673(new GamesClientImpl.CommitSnapshotResultImpl(var1));
      }
   }

   final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Snapshots.DeleteSnapshotResult> field_1262;

      public SnapshotDeletedBinderCallbacks(class_797.class_1206<Snapshots.DeleteSnapshotResult> var1) {
         this.field_1262 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: g (int, java.lang.String) void
      public void method_298(int var1, String var2) {
         this.field_1262.method_673(new GamesClientImpl.DeleteSnapshotResultImpl(var1, var2));
      }
   }

   private final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: OH com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Snapshots.OpenSnapshotResult> field_1240;

      public SnapshotOpenedBinderCallbacks(class_797.class_1206<Snapshots.OpenSnapshotResult> var1) {
         this.field_1240 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.Contents) void
      public void method_274(DataHolder var1, Contents var2) {
         this.field_1240.method_673(new GamesClientImpl.OpenSnapshotResultImpl(var1, var2));
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, java.lang.String, com.google.android.gms.drive.Contents, com.google.android.gms.drive.Contents, com.google.android.gms.drive.Contents) void
      public void method_275(DataHolder var1, String var2, Contents var3, Contents var4, Contents var5) {
         this.field_1240.method_673(new GamesClientImpl.OpenSnapshotResultImpl(var1, var2, var3, var4, var5));
      }
   }

   private final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: OI com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Snapshots.LoadSnapshotsResult> field_1214;

      public SnapshotsLoadedBinderCallbacks(class_797.class_1206<Snapshots.LoadSnapshotsResult> var1) {
         this.field_1214 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: I (com.google.android.gms.common.data.DataHolder) void
      public void method_264(DataHolder var1) {
         this.field_1214.method_673(new GamesClientImpl.LoadSnapshotsResultImpl(var1));
      }
   }

   private final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Leaderboards.SubmitScoreResult> field_1203;

      public SubmitScoreBinderCallbacks(class_797.class_1206<Leaderboards.SubmitScoreResult> var1) {
         this.field_1203 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: f (com.google.android.gms.common.data.DataHolder) void
      public void method_296(DataHolder var1) {
         this.field_1203.method_673(new GamesClientImpl.SubmitScoreResultImpl(var1));
      }
   }

   private static final class SubmitScoreResultImpl extends class_442 implements Leaderboards.SubmitScoreResult {
      // $FF: renamed from: OJ com.google.android.gms.games.leaderboard.ScoreSubmissionData
      private final ScoreSubmissionData field_2017;

      public SubmitScoreResultImpl(DataHolder var1) {
         super(var1);

         try {
            this.field_2017 = new ScoreSubmissionData(var1);
         } finally {
            var1.close();
         }

      }

      public ScoreSubmissionData getScoreData() {
         return this.field_2017;
      }
   }

   private final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: OK com.google.android.gms.common.api.a$d
      private final class_797.class_1206<TurnBasedMultiplayer.CancelMatchResult> field_1250;

      public TurnBasedMatchCanceledBinderCallbacks(class_797.class_1206<TurnBasedMultiplayer.CancelMatchResult> var1) {
         this.field_1250 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: f (int, java.lang.String) void
      public void method_295(int var1, String var2) {
         Status var3 = new Status(var1);
         this.field_1250.method_673(new GamesClientImpl.CancelMatchResultImpl(var3, var2));
      }
   }

   private final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: OL com.google.android.gms.common.api.a$d
      private final class_797.class_1206<TurnBasedMultiplayer.InitiateMatchResult> field_1209;

      public TurnBasedMatchInitiatedBinderCallbacks(class_797.class_1206<TurnBasedMultiplayer.InitiateMatchResult> var1) {
         this.field_1209 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: q (com.google.android.gms.common.data.DataHolder) void
      public void method_309(DataHolder var1) {
         this.field_1209.method_673(new GamesClientImpl.InitiateMatchResultImpl(var1));
      }
   }

   private final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: OM com.google.android.gms.common.api.a$d
      private final class_797.class_1206<TurnBasedMultiplayer.LeaveMatchResult> field_1244;

      public TurnBasedMatchLeftBinderCallbacks(class_797.class_1206<TurnBasedMultiplayer.LeaveMatchResult> var1) {
         this.field_1244 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: s (com.google.android.gms.common.data.DataHolder) void
      public void method_311(DataHolder var1) {
         this.field_1244.method_673(new GamesClientImpl.LeaveMatchResultImpl(var1));
      }
   }

   private final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: ON com.google.android.gms.common.api.a$d
      private final class_797.class_1206<TurnBasedMultiplayer.LoadMatchResult> field_1216;

      public TurnBasedMatchLoadedBinderCallbacks(class_797.class_1206<TurnBasedMultiplayer.LoadMatchResult> var1) {
         this.field_1216 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: p (com.google.android.gms.common.data.DataHolder) void
      public void method_308(DataHolder var1) {
         this.field_1216.method_673(new GamesClientImpl.LoadMatchResultImpl(var1));
      }
   }

   private abstract static class TurnBasedMatchResult extends class_442 {
      // $FF: renamed from: Oh com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
      final TurnBasedMatch field_2044;

      TurnBasedMatchResult(DataHolder var1) {
         super(var1);
         TurnBasedMatchBuffer var2 = new TurnBasedMatchBuffer(var1);

         try {
            if(var2.getCount() > 0) {
               this.field_2044 = (TurnBasedMatch)((TurnBasedMatch)var2.get(0)).freeze();
            } else {
               this.field_2044 = null;
            }
         } finally {
            var2.close();
         }

      }

      public TurnBasedMatch getMatch() {
         return this.field_2044;
      }
   }

   private final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: OO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<TurnBasedMultiplayer.UpdateMatchResult> field_1207;

      public TurnBasedMatchUpdatedBinderCallbacks(class_797.class_1206<TurnBasedMultiplayer.UpdateMatchResult> var1) {
         this.field_1207 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: r (com.google.android.gms.common.data.DataHolder) void
      public void method_310(DataHolder var1) {
         this.field_1207.method_673(new GamesClientImpl.UpdateMatchResultImpl(var1));
      }
   }

   private final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
      // $FF: renamed from: OP com.google.android.gms.common.api.a$d
      private final class_797.class_1206<TurnBasedMultiplayer.LoadMatchesResult> field_1230;

      public TurnBasedMatchesLoadedBinderCallbacks(class_797.class_1206<TurnBasedMultiplayer.LoadMatchesResult> var1) {
         this.field_1230 = (class_797.class_1206)class_347.method_2166(var2, "Holder must not be null");
      }

      // $FF: renamed from: b (int, android.os.Bundle) void
      public void method_278(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         Status var3 = new Status(var1);
         this.field_1230.method_673(new GamesClientImpl.LoadMatchesResultImpl(var3, var2));
      }
   }

   private static final class UpdateAchievementResultImpl implements Achievements.UpdateAchievementResult {
      // $FF: renamed from: OQ java.lang.String
      private final String field_4341;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_4342;

      UpdateAchievementResultImpl(int var1, String var2) {
         this.field_4342 = new Status(var1);
         this.field_4341 = var2;
      }

      public String getAchievementId() {
         return this.field_4341;
      }

      public Status getStatus() {
         return this.field_4342;
      }
   }

   private static final class UpdateMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.UpdateMatchResult {
      UpdateMatchResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class UpdateRequestsResultImpl extends class_442 implements Requests.UpdateRequestsResult {
      // $FF: renamed from: OR com.google.android.gms.games.internal.request.RequestUpdateOutcomes
      private final RequestUpdateOutcomes field_2032;

      UpdateRequestsResultImpl(DataHolder var1) {
         super(var1);
         this.field_2032 = RequestUpdateOutcomes.method_2732(var1);
      }

      public Set<String> getRequestIds() {
         return this.field_2032.getRequestIds();
      }

      public int getRequestOutcome(String var1) {
         return this.field_2032.getRequestOutcome(var1);
      }
   }
}
