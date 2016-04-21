package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.internal.class_293;
import com.google.android.gms.plus.internal.class_957;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient implements GooglePlayServicesClient {
    final class_293 ald;

    PlusClient(class_293 var1) {
        this.ald = var1;
    }

    @Deprecated
    public void clearDefaultAccount() {
        this.ald.clearDefaultAccount();
    }

    @Deprecated
    public void connect() {
        this.ald.connect();
    }

    @Deprecated
    public void disconnect() {
        this.ald.disconnect();
    }

    @Deprecated
    public String getAccountName() {
        return this.ald.getAccountName();
    }

    @Deprecated
    public Person getCurrentPerson() {
        return this.ald.getCurrentPerson();
    }

    @Deprecated
    public boolean isConnected() {
        return this.ald.isConnected();
    }

    @Deprecated
    public boolean isConnecting() {
        return this.ald.isConnecting();
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks var1) {
        return this.ald.isConnectionCallbacksRegistered(var1);
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener var1) {
        return this.ald.isConnectionFailedListenerRegistered(var1);
    }

    @Deprecated
    public void loadMoments(final PlusClient.OnMomentsLoadedListener var1) {
        this.ald.method_1850(new BaseImplementation.class_1147() {
            // $FF: renamed from: a (com.google.android.gms.plus.Moments$LoadMomentsResult) void
            public void method_4545(Moments.LoadMomentsResult var1x) {
                var1.onMomentsLoaded(var1x.getStatus().method_5374(), var1x.getMomentBuffer(), var1x.getNextPageToken(), var1x.getUpdated());
            }

            // $FF: renamed from: b (java.lang.Object) void
            // $FF: synthetic method
            public void method_120(Object var1x) {
                this.method_4545((Moments.LoadMomentsResult)var1x);
            }
        });
    }

    @Deprecated
    public void loadMoments(final PlusClient.OnMomentsLoadedListener var1, int var2, String var3, Uri var4, String var5, String var6) {
        this.ald.method_1844(new BaseImplementation.class_1147() {
            // $FF: renamed from: a (com.google.android.gms.plus.Moments$LoadMomentsResult) void
            public void method_4541(Moments.LoadMomentsResult var1x) {
                var1.onMomentsLoaded(var1x.getStatus().method_5374(), var1x.getMomentBuffer(), var1x.getNextPageToken(), var1x.getUpdated());
            }

            // $FF: renamed from: b (java.lang.Object) void
            // $FF: synthetic method
            public void method_120(Object var1x) {
                this.method_4541((Moments.LoadMomentsResult)var1x);
            }
        }, var2, var3, var4, var5, var6);
    }

    @Deprecated
    public void loadPeople(final PlusClient.OnPeopleLoadedListener var1, Collection<String> var2) {
        this.ald.method_1846(new BaseImplementation.class_1147() {
            // $FF: renamed from: a (com.google.android.gms.plus.People$LoadPeopleResult) void
            public void method_4547(People.LoadPeopleResult var1x) {
                var1.onPeopleLoaded(var1x.getStatus().method_5374(), var1x.getPersonBuffer(), var1x.getNextPageToken());
            }

            // $FF: renamed from: b (java.lang.Object) void
            // $FF: synthetic method
            public void method_120(Object var1x) {
                this.method_4547((People.LoadPeopleResult)var1x);
            }
        }, var2);
    }

    @Deprecated
    public void loadPeople(final PlusClient.OnPeopleLoadedListener var1, String... var2) {
        this.ald.method_1849(new BaseImplementation.class_1147() {
            // $FF: renamed from: a (com.google.android.gms.plus.People$LoadPeopleResult) void
            public void method_4548(People.LoadPeopleResult var1x) {
                var1.onPeopleLoaded(var1x.getStatus().method_5374(), var1x.getPersonBuffer(), var1x.getNextPageToken());
            }

            // $FF: renamed from: b (java.lang.Object) void
            // $FF: synthetic method
            public void method_120(Object var1x) {
                this.method_4548((People.LoadPeopleResult)var1x);
            }
        }, var2);
    }

    @Deprecated
    public void loadVisiblePeople(final PlusClient.OnPeopleLoadedListener var1, int var2, String var3) {
        this.ald.method_1843(new BaseImplementation.class_1147() {
            // $FF: renamed from: a (com.google.android.gms.plus.People$LoadPeopleResult) void
            public void method_4537(People.LoadPeopleResult var1x) {
                var1.onPeopleLoaded(var1x.getStatus().method_5374(), var1x.getPersonBuffer(), var1x.getNextPageToken());
            }

            // $FF: renamed from: b (java.lang.Object) void
            // $FF: synthetic method
            public void method_120(Object var1x) {
                this.method_4537((People.LoadPeopleResult)var1x);
            }
        }, var2, var3);
    }

    @Deprecated
    public void loadVisiblePeople(final PlusClient.OnPeopleLoadedListener var1, String var2) {
        this.ald.method_1853(new BaseImplementation.class_1147() {
            // $FF: renamed from: a (com.google.android.gms.plus.People$LoadPeopleResult) void
            public void method_4546(People.LoadPeopleResult var1x) {
                var1.onPeopleLoaded(var1x.getStatus().method_5374(), var1x.getPersonBuffer(), var1x.getNextPageToken());
            }

            // $FF: renamed from: b (java.lang.Object) void
            // $FF: synthetic method
            public void method_120(Object var1x) {
                this.method_4546((People.LoadPeopleResult)var1x);
            }
        }, var2);
    }

    // $FF: renamed from: mZ () com.google.android.gms.plus.internal.e
    class_293 method_3261() {
        return this.ald;
    }

    @Deprecated
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
        this.ald.registerConnectionCallbacks(var1);
    }

    @Deprecated
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
        this.ald.registerConnectionFailedListener(var1);
    }

    @Deprecated
    public void removeMoment(String var1) {
        this.ald.removeMoment(var1);
    }

    @Deprecated
    public void revokeAccessAndDisconnect(final PlusClient.OnAccessRevokedListener var1) {
        this.ald.method_1852(new BaseImplementation.class_1147() {
            // $FF: renamed from: aA (com.google.android.gms.common.api.Status) void
            public void method_4549(Status var1x) {
                var1.onAccessRevoked(var1x.getStatus().method_5374());
            }

            // $FF: renamed from: b (java.lang.Object) void
            // $FF: synthetic method
            public void method_120(Object var1x) {
                this.method_4549((Status)var1x);
            }
        });
    }

    @Deprecated
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
        this.ald.unregisterConnectionCallbacks(var1);
    }

    @Deprecated
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
        this.ald.unregisterConnectionFailedListener(var1);
    }

    @Deprecated
    public void writeMoment(Moment var1) {
        this.ald.method_1845((BaseImplementation.class_1147)null, var1);
    }

    @Deprecated
    public static class Builder {
        private final GooglePlayServicesClient.ConnectionCallbacks ali;
        private final GooglePlayServicesClient.OnConnectionFailedListener alj;
        private final class_957 alk;
        private final Context mContext;

        public Builder(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3) {
            this.mContext = var1;
            this.ali = var2;
            this.alj = var3;
            this.alk = new class_957(this.mContext);
        }

        public PlusClient build() {
            return new PlusClient(new class_293(this.mContext, this.ali, this.alj, this.alk.method_5058()));
        }

        public PlusClient.Builder clearScopes() {
            this.alk.method_5057();
            return this;
        }

        public PlusClient.Builder setAccountName(String var1) {
            this.alk.method_5054(var1);
            return this;
        }

        public PlusClient.Builder setActions(String... var1) {
            this.alk.method_5056(var1);
            return this;
        }

        public PlusClient.Builder setScopes(String... var1) {
            this.alk.method_5055(var1);
            return this;
        }
    }

    @Deprecated
    public interface OnAccessRevokedListener {
        void onAccessRevoked(ConnectionResult var1);
    }

    @Deprecated
    public interface OnMomentsLoadedListener {
        @Deprecated
        void onMomentsLoaded(ConnectionResult var1, MomentBuffer var2, String var3, String var4);
    }

    @Deprecated
    public interface OnPeopleLoadedListener {
        void onPeopleLoaded(ConnectionResult var1, PersonBuffer var2, String var3);
    }

    @Deprecated
    public interface OrderBy {
        @Deprecated
        int ALPHABETICAL = 0;
        @Deprecated
        int BEST = 1;
    }
}
