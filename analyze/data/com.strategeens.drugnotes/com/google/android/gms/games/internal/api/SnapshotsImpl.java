package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;

public final class SnapshotsImpl implements Snapshots {
   public PendingResult<Snapshots.CommitSnapshotResult> commitAndClose(final GoogleApiClient var1, final Snapshot var2, final SnapshotMetadataChange var3) {
      return var1.method_944(new SnapshotsImpl.CommitImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1478(GamesClientImpl var1) {
            var1.method_1887(this, var2, var3);
         }
      });
   }

   public PendingResult<Snapshots.DeleteSnapshotResult> delete(final GoogleApiClient var1, final SnapshotMetadata var2) {
      return var1.method_944(new SnapshotsImpl.DeleteImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1473(GamesClientImpl var1) {
            var1.method_1979(this, var2.getSnapshotId());
         }
      });
   }

   public void discardAndClose(GoogleApiClient var1, Snapshot var2) {
      Games.method_3259(var1).method_1917(var2);
   }

   public int getMaxCoverImageSize(GoogleApiClient var1) {
      return Games.method_3259(var1).method_1986();
   }

   public int getMaxDataSize(GoogleApiClient var1) {
      return Games.method_3259(var1).method_1985();
   }

   public Intent getSelectSnapshotIntent(GoogleApiClient var1, String var2, boolean var3, boolean var4, int var5) {
      return Games.method_3259(var1).method_1878(var2, var3, var4, var5);
   }

   public SnapshotMetadata getSnapshotFromBundle(Bundle var1) {
      return var1 != null && var1.containsKey("com.google.android.gms.games.SNAPSHOT_METADATA")?(SnapshotMetadata)var1.getParcelable("com.google.android.gms.games.SNAPSHOT_METADATA"):null;
   }

   public PendingResult<Snapshots.LoadSnapshotsResult> load(final GoogleApiClient var1, final boolean var2) {
      return var1.method_942(new SnapshotsImpl.LoadImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1481(GamesClientImpl var1) {
            var1.method_1966(this, var2);
         }
      });
   }

   public PendingResult<Snapshots.OpenSnapshotResult> open(GoogleApiClient var1, SnapshotMetadata var2) {
      return this.open(var1, var2.getUniqueName(), false);
   }

   public PendingResult<Snapshots.OpenSnapshotResult> open(final GoogleApiClient var1, final String var2, final boolean var3) {
      return var1.method_944(new SnapshotsImpl.OpenImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1476(GamesClientImpl var1) {
            var1.method_1947(this, var2, var3);
         }
      });
   }

   public PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(GoogleApiClient var1, String var2, Snapshot var3) {
      SnapshotMetadata var4 = var3.getMetadata();
      SnapshotMetadataChange var5 = (new SnapshotMetadataChange.Builder()).fromMetadata(var4).build();
      return this.resolveConflict(var1, var2, var4.getSnapshotId(), var5, var3.getSnapshotContents());
   }

   public PendingResult<Snapshots.OpenSnapshotResult> resolveConflict(final GoogleApiClient var1, final String var2, final String var3, final SnapshotMetadataChange var4, final SnapshotContents var5) {
      return var1.method_944(new SnapshotsImpl.OpenImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1475(GamesClientImpl var1) throws RemoteException {
            var1.method_1900(this, var2, var3, var4, var5);
         }
      });
   }

   private abstract static class CommitImpl extends Games.BaseGamesApiMethodImpl<Snapshots.CommitSnapshotResult> {
      private CommitImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      CommitImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: ao (com.google.android.gms.common.api.Status) com.google.android.gms.games.snapshot.Snapshots$CommitSnapshotResult
      public Snapshots.CommitSnapshotResult method_1477(final Status var1) {
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
      public Result method_1109(Status var1) {
         return this.method_1477(var1);
      }
   }

   private abstract static class DeleteImpl extends Games.BaseGamesApiMethodImpl<Snapshots.DeleteSnapshotResult> {
      private DeleteImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      DeleteImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: ap (com.google.android.gms.common.api.Status) com.google.android.gms.games.snapshot.Snapshots$DeleteSnapshotResult
      public Snapshots.DeleteSnapshotResult method_1472(final Status var1) {
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
      public Result method_1109(Status var1) {
         return this.method_1472(var1);
      }
   }

   private abstract static class LoadImpl extends Games.BaseGamesApiMethodImpl<Snapshots.LoadSnapshotsResult> {
      private LoadImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: aq (com.google.android.gms.common.api.Status) com.google.android.gms.games.snapshot.Snapshots$LoadSnapshotsResult
      public Snapshots.LoadSnapshotsResult method_1479(final Status var1) {
         return new Snapshots.LoadSnapshotsResult() {
            public SnapshotMetadataBuffer getSnapshots() {
               return new SnapshotMetadataBuffer(DataHolder.method_5824(14));
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
         return this.method_1479(var1);
      }
   }

   private abstract static class OpenImpl extends Games.BaseGamesApiMethodImpl<Snapshots.OpenSnapshotResult> {
      private OpenImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      OpenImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: ar (com.google.android.gms.common.api.Status) com.google.android.gms.games.snapshot.Snapshots$OpenSnapshotResult
      public Snapshots.OpenSnapshotResult method_1474(final Status var1) {
         return new Snapshots.OpenSnapshotResult() {
            public String getConflictId() {
               return null;
            }

            public Snapshot getConflictingSnapshot() {
               return null;
            }

            public SnapshotContents getResolutionSnapshotContents() {
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
      public Result method_1109(Status var1) {
         return this.method_1474(var1);
      }
   }
}
