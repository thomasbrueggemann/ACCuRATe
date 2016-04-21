package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl implements Invitations {
    public Intent getInvitationInboxIntent(GoogleApiClient var1) {
        return Games.method_3257(var1).method_2006();
    }

    public PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient var1) {
        return this.loadInvitations(var1, 0);
    }

    public PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient var1, final int var2) {
        return var1.method_897(new InvitationsImpl.LoadInvitationsImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1346(GamesClientImpl var1) {
                var1.method_1956(this, var2);
            }
        });
    }

    public void registerInvitationListener(GoogleApiClient var1, OnInvitationReceivedListener var2) {
        Games.method_3257(var1).method_1928(var2);
    }

    public void unregisterInvitationListener(GoogleApiClient var1) {
        Games.method_3257(var1).method_2007();
    }

    private abstract static class LoadInvitationsImpl extends Games.BaseGamesApiMethodImpl<Invitations.LoadInvitationsResult> {
        private LoadInvitationsImpl() {
        }

        // $FF: synthetic method
        LoadInvitationsImpl(Object var1) {
            this();
        }

        // $FF: renamed from: T (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.Invitations$LoadInvitationsResult
        public Invitations.LoadInvitationsResult method_1345(final Status var1) {
            return new Invitations.LoadInvitationsResult() {
                public InvitationBuffer getInvitations() {
                    return new InvitationBuffer(DataHolder.method_5982(14));
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
        public Result method_1104(Status var1) {
            return this.method_1345(var1);
        }
    }
}
