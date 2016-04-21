package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.game.Acls;

public final class AclsImpl implements Acls {
    // $FF: renamed from: L (com.google.android.gms.common.api.Status) com.google.android.gms.games.internal.game.Acls$LoadAclResult
    private static Acls.LoadAclResult method_5455(final Status var0) {
        return new Acls.LoadAclResult() {
            public Status getStatus() {
                return var0;
            }

            public void release() {
            }
        };
    }

    private abstract static class LoadNotifyAclImpl extends Games.BaseGamesApiMethodImpl<Acls.LoadAclResult> {
        // $FF: renamed from: N (com.google.android.gms.common.api.Status) com.google.android.gms.games.internal.game.Acls$LoadAclResult
        public Acls.LoadAclResult method_1363(Status var1) {
            return AclsImpl.method_5455(var1);
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1363(var1);
        }
    }

    private abstract static class UpdateNotifyAclImpl extends Games.BaseGamesApiMethodImpl<Status> {
        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1365(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        public Status method_1365(Status var1) {
            return var1;
        }
    }
}
