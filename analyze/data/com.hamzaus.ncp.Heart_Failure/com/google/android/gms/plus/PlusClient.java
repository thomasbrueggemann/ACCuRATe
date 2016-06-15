package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.internal.class_236;
import com.google.android.gms.plus.internal.class_674;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient implements GooglePlayServicesClient {
   final class_236 abq;

   PlusClient(class_236 var1) {
      this.abq = var1;
   }

   @Deprecated
   public void clearDefaultAccount() {
      this.abq.clearDefaultAccount();
   }

   @Deprecated
   public void connect() {
      this.abq.connect();
   }

   @Deprecated
   public void disconnect() {
      this.abq.disconnect();
   }

   @Deprecated
   public String getAccountName() {
      return this.abq.getAccountName();
   }

   @Deprecated
   public Person getCurrentPerson() {
      return this.abq.getCurrentPerson();
   }

   @Deprecated
   public boolean isConnected() {
      return this.abq.isConnected();
   }

   @Deprecated
   public boolean isConnecting() {
      return this.abq.isConnecting();
   }

   @Deprecated
   public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks var1) {
      return this.abq.isConnectionCallbacksRegistered(var1);
   }

   @Deprecated
   public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      return this.abq.isConnectionFailedListenerRegistered(var1);
   }

   // $FF: renamed from: jN () com.google.android.gms.plus.internal.e
   class_236 method_2784() {
      return this.abq;
   }

   @Deprecated
   public void loadMoments(final PlusClient.OnMomentsLoadedListener var1) {
      this.abq.method_1486(new class_797.class_1206() {
         // $FF: renamed from: a (com.google.android.gms.plus.Moments$LoadMomentsResult) void
         public void method_3637(Moments.LoadMomentsResult var1x) {
            var1.onMomentsLoaded(var1x.getStatus().method_4121(), var1x.getMomentBuffer(), var1x.getNextPageToken(), var1x.getUpdated());
         }
      });
   }

   @Deprecated
   public void loadMoments(final PlusClient.OnMomentsLoadedListener var1, int var2, String var3, Uri var4, String var5, String var6) {
      this.abq.method_1480(new class_797.class_1206() {
         // $FF: renamed from: a (com.google.android.gms.plus.Moments$LoadMomentsResult) void
         public void method_3635(Moments.LoadMomentsResult var1x) {
            var1.onMomentsLoaded(var1x.getStatus().method_4121(), var1x.getMomentBuffer(), var1x.getNextPageToken(), var1x.getUpdated());
         }
      }, var2, var3, var4, var5, var6);
   }

   @Deprecated
   public void loadPeople(final PlusClient.OnPeopleLoadedListener var1, Collection<String> var2) {
      this.abq.method_1482(new class_797.class_1206() {
         // $FF: renamed from: a (com.google.android.gms.plus.People$LoadPeopleResult) void
         public void method_3639(People.LoadPeopleResult var1x) {
            var1.onPeopleLoaded(var1x.getStatus().method_4121(), var1x.getPersonBuffer(), var1x.getNextPageToken());
         }
      }, var2);
   }

   @Deprecated
   public void loadPeople(final PlusClient.OnPeopleLoadedListener var1, String... var2) {
      this.abq.method_1485(new class_797.class_1206() {
         // $FF: renamed from: a (com.google.android.gms.plus.People$LoadPeopleResult) void
         public void method_3640(People.LoadPeopleResult var1x) {
            var1.onPeopleLoaded(var1x.getStatus().method_4121(), var1x.getPersonBuffer(), var1x.getNextPageToken());
         }
      }, var2);
   }

   @Deprecated
   public void loadVisiblePeople(final PlusClient.OnPeopleLoadedListener var1, int var2, String var3) {
      this.abq.method_1479(new class_797.class_1206() {
         // $FF: renamed from: a (com.google.android.gms.plus.People$LoadPeopleResult) void
         public void method_3634(People.LoadPeopleResult var1x) {
            var1.onPeopleLoaded(var1x.getStatus().method_4121(), var1x.getPersonBuffer(), var1x.getNextPageToken());
         }
      }, var2, var3);
   }

   @Deprecated
   public void loadVisiblePeople(final PlusClient.OnPeopleLoadedListener var1, String var2) {
      this.abq.method_1489(new class_797.class_1206() {
         // $FF: renamed from: a (com.google.android.gms.plus.People$LoadPeopleResult) void
         public void method_3638(People.LoadPeopleResult var1x) {
            var1.onPeopleLoaded(var1x.getStatus().method_4121(), var1x.getPersonBuffer(), var1x.getNextPageToken());
         }
      }, var2);
   }

   @Deprecated
   public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.abq.registerConnectionCallbacks(var1);
   }

   @Deprecated
   public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.abq.registerConnectionFailedListener(var1);
   }

   @Deprecated
   public void removeMoment(String var1) {
      this.abq.removeMoment(var1);
   }

   @Deprecated
   public void revokeAccessAndDisconnect(final PlusClient.OnAccessRevokedListener var1) {
      this.abq.method_1488(new class_797.class_1206() {
         // $FF: renamed from: a (java.lang.Object) void
         // $FF: synthetic method
         public void method_673(Object var1x) {
            this.method_3642((Status)var1x);
         }

         // $FF: renamed from: al (com.google.android.gms.common.api.Status) void
         public void method_3642(Status var1x) {
            var1.onAccessRevoked(var1x.getStatus().method_4121());
         }
      });
   }

   @Deprecated
   public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.abq.unregisterConnectionCallbacks(var1);
   }

   @Deprecated
   public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.abq.unregisterConnectionFailedListener(var1);
   }

   @Deprecated
   public void writeMoment(Moment var1) {
      this.abq.method_1481((class_797.class_1206)null, var1);
   }

   @Deprecated
   public static class Builder {
      private final GooglePlayServicesClient.ConnectionCallbacks abv;
      private final GooglePlayServicesClient.OnConnectionFailedListener abw;
      private final class_674 abx;
      private final Context mContext;

      public Builder(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3) {
         this.mContext = var1;
         this.abv = var2;
         this.abw = var3;
         this.abx = new class_674(this.mContext);
      }

      public PlusClient build() {
         return new PlusClient(new class_236(this.mContext, this.abv, this.abw, this.abx.method_3931()));
      }

      public PlusClient.Builder clearScopes() {
         this.abx.method_3930();
         return this;
      }

      public PlusClient.Builder setAccountName(String var1) {
         this.abx.method_3927(var1);
         return this;
      }

      public PlusClient.Builder setActions(String... var1) {
         this.abx.method_3929(var1);
         return this;
      }

      public PlusClient.Builder setScopes(String... var1) {
         this.abx.method_3928(var1);
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
