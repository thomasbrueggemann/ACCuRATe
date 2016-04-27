package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;

public final class NotificationsImpl implements Notifications {
    public void clear(GoogleApiClient var1, int var2) {
        Games.method_3257(var1).method_1975(var2);
    }

    public void clearAll(GoogleApiClient var1) {
        this.clear(var1, 31);
    }

    private abstract static class ContactSettingLoadImpl extends Games.BaseGamesApiMethodImpl<Notifications.ContactSettingLoadResult> {
        // $FF: renamed from: aa (com.google.android.gms.common.api.Status) com.google.android.gms.games.Notifications$ContactSettingLoadResult
        public Notifications.ContactSettingLoadResult method_1408(final Status var1) {
            return new Notifications.ContactSettingLoadResult() {
                public Status getStatus() {
                    return var1;
                }
            };
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1408(var1);
        }
    }

    private abstract static class ContactSettingUpdateImpl extends Games.BaseGamesApiMethodImpl<Status> {
        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1320(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        public Status method_1320(Status var1) {
            return var1;
        }
    }

    private abstract static class InboxCountImpl extends Games.BaseGamesApiMethodImpl<Notifications.InboxCountResult> {
        // $FF: renamed from: ab (com.google.android.gms.common.api.Status) com.google.android.gms.games.Notifications$InboxCountResult
        public Notifications.InboxCountResult method_1395(final Status var1) {
            return new Notifications.InboxCountResult() {
                public Status getStatus() {
                    return var1;
                }
            };
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1395(var1);
        }
    }
}