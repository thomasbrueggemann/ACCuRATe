package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;

public final class SnapshotsImpl implements Snapshots {
   public PendingResult<Snapshots.CommitSnapshotResult> commitAndClose(GoogleApiClient var1, final Snapshot var2, final SnapshotMetadataChange var3) {
      return var1.method_773(new SnapshotsImpl.CommitImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1210(GamesClientImpl var1) {
            var1.method_1519(this, var2, var3);
         }
      });
   }

   public PendingResult<Snapshots.DeleteSnapshotResult> delete(GoogleApiClient var1, final SnapshotMetadata var2) {
      return var1.method_773(new SnapshotsImpl.DeleteImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1205(GamesClientImpl var1) {
            var1.method_1635(this, var2.getSnapshotId());
         }
      });
   }

   public void discardAndClose(GoogleApiClient var1, Snapshot var2) {
      Games.method_2780(var1).method_1553(var2);
   }

   public int getMaxCoverImageSize(GoogleApiClient var1) {
      return Games.method_2780(var1).method_1630();
   }

   public int getMaxDataSize(GoogleApiClient var1) {
      return Games.method_2780(var1).method_1629();
   }

   public Intent getSelectSnapshotIntent(GoogleApiClient var1, String var2, boolean var3, boolean var4, int var5) {
      return Games.method_2780(var1).method_1510(var2, var3, var4, var5);
   }

   public SnapshotMetadata getSnapshotFromBundle(Bundle var1) {
      return var1 != null && var1.containsKey("com.google.android.gms.games.SNAPSHOT_METADATA")?(SnapshotMetadata)var1.getParcelable("com.google.android.gms.games.SNAPSHOT_METADATA"):null;
   }

   public PendingResult<Snapshots.LoadSnapshotsResult> load(GoogleApiClient var1, final boolean var2) {
      return var1.method_772(new SnapshotsImpl.LoadImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1213(GamesClientImpl var1) {
            var1.method_1597(this, var2);
         }
      });
   }

   public PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient var1, SnapshotMetadata var2) {
      return this.open(var1, var2.getUniqueName(), false);
   }

   public PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient var1, final String var2, final boolean var3) {
      return var1.method_773(new SnapshotsImpl.OpenImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1208(GamesClientImpl var1) {
            var1.method_1568(this, var2, var3);
         }
      });
   }

   public PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient var1, String var2, Snapshot var3) {
      SnapshotMetadata var4 = var3.getMetadata();
      SnapshotMetadataChange var5 = (new SnapshotMetadataChange.Builder()).fromMetadata(var4).build();
      return this.resolveConflict(var1, var2, var4.getSnapshotId(), var5, var3.getContents());
   }

   public PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient var1, final String var2, final String var3, final SnapshotMetadataChange var4, final Contents var5) {
      return var1.method_773(new SnapshotsImpl.OpenImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1207(GamesClientImpl var1) throws RemoteException {
            var1.method_1533(this, var2, var3, var4, var5);
         }
      });
   }

   private abstract static class CommitImpl extends Games.BaseGamesApiMethodImpl<Snapshots.CommitSnapshotResult> {
      private CommitImpl() {
      }

      // $FF: synthetic method
      CommitImpl(Object var1) {
         this();
      }

      // $FF: renamed from: Z (com.google.android.gms.common.api.Status) com.google.android.gms.games.snapshot.Snapshots$CommitSnapshotResult
      public Snapshots.CommitSnapshotResult method_1209(final Status var1) {
         return new Snapshots.CommitSnapshotResult() {
            public SnapshotMetadata getSnapshotMetadata() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1209(var1);
      }
   }

   private abstract static class DeleteImpl extends Games.BaseGamesApiMethodImpl<Snapshots.DeleteSnapshotResult> {
      private DeleteImpl() {
      }

      // $FF: synthetic method
      DeleteImpl(Object var1) {
         this();
      }

      // $FF: renamed from: aa (com.google.android.gms.common.api.Status) com.google.android.gms.games.snapshot.Snapshots$DeleteSnapshotResult
      public Snapshots.DeleteSnapshotResult method_1204(final Status var1) {
         return new Snapshots.DeleteSnapshotResult() {
            public String getSnapshotId() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1204(var1);
      }
   }

   private abstract static class LoadImpl extends Games.BaseGamesApiMethodImpl<Snapshots.LoadSnapshotsResult> {
      private LoadImpl() {
      }

      // $FF: synthetic method
      LoadImpl(Object var1) {
         this();
      }

      // $FF: renamed from: ab (com.google.android.gms.common.api.Status) com.google.android.gms.games.snapshot.Snapshots$LoadSnapshotsResult
      public Snapshots.LoadSnapshotsResult method_1211(final Status var1) {
         return new Snapshots.LoadSnapshotsResult() {
            public SnapshotMetadataBuffer getSnapshots() {
               return new SnapshotMetadataBuffer(DataHolder.method_4552(14));
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
         return this.method_1211(var1);
      }
   }

   private abstract static class OpenImpl extends Games.BaseGamesApiMethodImpl<Snapshots.OpenSnapshotResult> {
      private OpenImpl() {
      }

      // $FF: synthetic method
      OpenImpl(Object var1) {
         this();
      }

      // $FF: renamed from: ac (com.google.android.gms.common.api.Status) com.google.android.gms.games.snapshot.Snapshots$OpenSnapshotResult
      public Snapshots.OpenSnapshotResult method_1206(final Status var1) {
         return new Snapshots.OpenSnapshotResult() {
            public String getConflictId() {
               return null;
            }

            public Snapshot getConflictingSnapshot() {
               return null;
            }

            public Contents getResolutionContents() {
               return null;
            }

            public Snapshot getSnapshot() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1206(var1);
      }
   }
}
