package com.google.android.gms.cast;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_323;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.gi;
import java.io.IOException;

public final class Cast {
   public static final Api<Cast.CastOptions> API;
   public static final Cast.CastApi CastApi;
   public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
   public static final int MAX_MESSAGE_LENGTH = 65536;
   public static final int MAX_NAMESPACE_LENGTH = 128;
   // $FF: renamed from: yE com.google.android.gms.common.api.Api$c
   static final Api.class_1077<gi> field_3269 = new Api.class_1077();
   // $FF: renamed from: yF com.google.android.gms.common.api.Api$b
   private static final Api.class_1074<gi, Cast.CastOptions> field_3270 = new Api.class_1074() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, com.google.android.gms.cast.Cast$CastOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.gi
      public class_242 method_4280(Context var1, Looper var2, class_323 var3, Cast.CastOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         class_347.method_2166(var4, "Setting the API options is required.");
         return new class_242(var1, var2, var4.field_3928, (long)var4.field_3930, var4.field_3929, var5, var6);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };

   static {
      API = new Api(field_3270, field_3269, new Scope[0]);
      CastApi = new Cast.class_1213();
   }

   public interface ApplicationConnectionResult extends Result {
      ApplicationMetadata getApplicationMetadata();

      String getApplicationStatus();

      String getSessionId();

      boolean getWasLaunched();
   }

   public interface CastApi {
      ApplicationMetadata getApplicationMetadata(GoogleApiClient var1) throws IllegalStateException;

      String getApplicationStatus(GoogleApiClient var1) throws IllegalStateException;

      double getVolume(GoogleApiClient var1) throws IllegalStateException;

      boolean isMute(GoogleApiClient var1) throws IllegalStateException;

      PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1);

      PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1, String var2);

      PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1, String var2, String var3);

      PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, String var2);

      PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, String var2, LaunchOptions var3);

      @Deprecated
      PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, String var2, boolean var3);

      PendingResult<Status> leaveApplication(GoogleApiClient var1);

      void removeMessageReceivedCallbacks(GoogleApiClient var1, String var2) throws IOException, IllegalArgumentException;

      void requestStatus(GoogleApiClient var1) throws IOException, IllegalStateException;

      PendingResult<Status> sendMessage(GoogleApiClient var1, String var2, String var3);

      void setMessageReceivedCallbacks(GoogleApiClient var1, String var2, Cast.MessageReceivedCallback var3) throws IOException, IllegalStateException;

      void setMute(GoogleApiClient var1, boolean var2) throws IOException, IllegalStateException;

      void setVolume(GoogleApiClient var1, double var2) throws IOException, IllegalArgumentException, IllegalStateException;

      PendingResult<Status> stopApplication(GoogleApiClient var1);

      PendingResult<Status> stopApplication(GoogleApiClient var1, String var2);
   }

   public static final class class_1213 implements Cast.CastApi {
      public ApplicationMetadata getApplicationMetadata(GoogleApiClient var1) throws IllegalStateException {
         return ((class_242)var1.method_771(Cast.field_3269)).getApplicationMetadata();
      }

      public String getApplicationStatus(GoogleApiClient var1) throws IllegalStateException {
         return ((class_242)var1.method_771(Cast.field_3269)).getApplicationStatus();
      }

      public double getVolume(GoogleApiClient var1) throws IllegalStateException {
         return ((class_242)var1.method_771(Cast.field_3269)).method_1697();
      }

      public boolean isMute(GoogleApiClient var1) throws IllegalStateException {
         return ((class_242)var1.method_771(Cast.field_3269)).isMute();
      }

      public PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1) {
         return var1.method_773(new Cast.class_959(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.gi) void
            protected void method_1010(class_242 var1) throws RemoteException {
               try {
                  var1.method_1694((String)null, (String)null, this);
               } catch (IllegalStateException var3) {
                  this.N(2001);
               }
            }
         });
      }

      public PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1, final String var2) {
         return var1.method_773(new Cast.class_959(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.gi) void
            protected void method_1011(class_242 var1) throws RemoteException {
               try {
                  var1.method_1694(var2, (String)null, this);
               } catch (IllegalStateException var3) {
                  this.N(2001);
               }
            }
         });
      }

      public PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient var1, final String var2, final String var3) {
         return var1.method_773(new Cast.class_959(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.gi) void
            protected void method_1012(class_242 var1) throws RemoteException {
               try {
                  var1.method_1694(var2, var3, this);
               } catch (IllegalStateException var3x) {
                  this.N(2001);
               }
            }
         });
      }

      public PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, final String var2) {
         return var1.method_773(new Cast.class_959(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.gi) void
            protected void method_1014(class_242 var1) throws RemoteException {
               try {
                  var1.method_1692(var2, false, this);
               } catch (IllegalStateException var3) {
                  this.N(2001);
               }
            }
         });
      }

      public PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, final String var2, final LaunchOptions var3) {
         return var1.method_773(new Cast.class_959(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.gi) void
            protected void method_1013(class_242 var1) throws RemoteException {
               try {
                  var1.method_1689(var2, var3, this);
               } catch (IllegalStateException var3x) {
                  this.N(2001);
               }
            }
         });
      }

      @Deprecated
      public PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, String var2, boolean var3) {
         return this.launchApplication(var1, var2, (new LaunchOptions.Builder()).setRelaunchIfRunning(var3).build());
      }

      public PendingResult<Status> leaveApplication(GoogleApiClient var1) {
         return var1.method_773(new Cast.class_1215(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.gi) void
            protected void method_1018(class_242 var1) throws RemoteException {
               try {
                  var1.method_1695(this);
               } catch (IllegalStateException var3) {
                  this.N(2001);
               }
            }
         });
      }

      public void removeMessageReceivedCallbacks(GoogleApiClient var1, String var2) throws IOException, IllegalArgumentException {
         try {
            ((class_242)var1.method_771(Cast.field_3269)).method_1693(var2);
         } catch (RemoteException var4) {
            throw new IOException("service error");
         }
      }

      public void requestStatus(GoogleApiClient var1) throws IOException, IllegalStateException {
         try {
            ((class_242)var1.method_771(Cast.field_3269)).method_1696();
         } catch (RemoteException var3) {
            throw new IOException("service error");
         }
      }

      public PendingResult<Status> sendMessage(GoogleApiClient var1, final String var2, final String var3) {
         return var1.method_773(new Cast.class_1215(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.gi) void
            protected void method_1019(class_242 var1) throws RemoteException {
               try {
                  var1.method_1691(var2, var3, this);
               } catch (IllegalArgumentException var4) {
                  this.N(2001);
               } catch (IllegalStateException var5) {
                  this.N(2001);
               }
            }
         });
      }

      public void setMessageReceivedCallbacks(GoogleApiClient var1, String var2, Cast.MessageReceivedCallback var3) throws IOException, IllegalStateException {
         try {
            ((class_242)var1.method_771(Cast.field_3269)).method_1688(var2, var3);
         } catch (RemoteException var5) {
            throw new IOException("service error");
         }
      }

      public void setMute(GoogleApiClient var1, boolean var2) throws IOException, IllegalStateException {
         try {
            ((class_242)var1.method_771(Cast.field_3269)).method_1698(var2);
         } catch (RemoteException var4) {
            throw new IOException("service error");
         }
      }

      public void setVolume(GoogleApiClient var1, double var2) throws IOException, IllegalArgumentException, IllegalStateException {
         try {
            ((class_242)var1.method_771(Cast.field_3269)).method_1687(var2);
         } catch (RemoteException var5) {
            throw new IOException("service error");
         }
      }

      public PendingResult<Status> stopApplication(GoogleApiClient var1) {
         return var1.method_773(new Cast.class_1215(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.gi) void
            protected void method_1017(class_242 var1) throws RemoteException {
               try {
                  var1.method_1690("", this);
               } catch (IllegalStateException var3) {
                  this.N(2001);
               }
            }
         });
      }

      public PendingResult<Status> stopApplication(GoogleApiClient var1, final String var2) {
         return var1.method_773(new Cast.class_1215(null) {
            // $FF: renamed from: a (com.google.android.gms.internal.gi) void
            protected void method_1016(class_242 var1) throws RemoteException {
               if(TextUtils.isEmpty(var2)) {
                  this.c(2001, "IllegalArgument: sessionId cannot be null or empty");
               } else {
                  try {
                     var1.method_1690(var2, this);
                  } catch (IllegalStateException var3) {
                     this.N(2001);
                  }
               }
            }
         });
      }
   }

   public static final class CastOptions implements Api.HasOptions {
      // $FF: renamed from: zX com.google.android.gms.cast.CastDevice
      final CastDevice field_3928;
      // $FF: renamed from: zY com.google.android.gms.cast.Cast$Listener
      final Cast.Listener field_3929;
      // $FF: renamed from: zZ int
      private final int field_3930;

      private CastOptions(Cast.Builder var1) {
         this.field_3928 = var1.field_3997;
         this.field_3929 = var1.field_3998;
         this.field_3930 = var1.field_3999;
      }

      // $FF: synthetic method
      CastOptions(Cast.Builder var1, Object var2) {
         this(var1);
      }

      public static Cast.Builder builder(CastDevice var0, Cast.Listener var1) {
         return new Cast.Builder(var0, var1, null);
      }
   }

   public static final class Builder {
      // $FF: renamed from: Aa com.google.android.gms.cast.CastDevice
      CastDevice field_3997;
      // $FF: renamed from: Ab com.google.android.gms.cast.Cast$Listener
      Cast.Listener field_3998;
      // $FF: renamed from: Ac int
      private int field_3999;

      private Builder(CastDevice var1, Cast.Listener var2) {
         class_347.method_2166(var1, "CastDevice parameter cannot be null");
         class_347.method_2166(var2, "CastListener parameter cannot be null");
         this.field_3997 = var1;
         this.field_3998 = var2;
         this.field_3999 = 0;
      }

      // $FF: synthetic method
      Builder(CastDevice var1, Cast.Listener var2, Object var3) {
         this(var1, var2);
      }

      public Cast.CastOptions build() {
         return new Cast.CastOptions(this, null);
      }

      public Cast.Builder setVerboseLoggingEnabled(boolean var1) {
         if(var1) {
            this.field_3999 |= 1;
            return this;
         } else {
            this.field_3999 &= -2;
            return this;
         }
      }
   }

   public static class Listener {
      // $FF: renamed from: O (int) void
      public void method_3285(int var1) {
      }

      public void onApplicationDisconnected(int var1) {
      }

      public void onApplicationStatusChanged() {
      }

      public void onVolumeChanged() {
      }
   }

   public interface MessageReceivedCallback {
      void onMessageReceived(CastDevice var1, String var2, String var3);
   }

   protected abstract static class class_1214<R extends Result> extends class_797.class_1203<R, gi> {
      public class_1214() {
         super(Cast.field_3269);
      }

      // $FF: renamed from: N (int) void
      public void method_1007(int var1) {
         this.b(this.c(new Status(var1)));
      }

      // $FF: renamed from: c (int, java.lang.String) void
      public void method_1008(int var1, String var2) {
         this.b(this.c(new Status(var1, var2, (PendingIntent)null)));
      }
   }

   private abstract static class class_1215 extends Cast.class_1214<Status> {
      private class_1215() {
      }

      // $FF: synthetic method
      class_1215(Object var1) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1015(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1015(Status var1) {
         return var1;
      }
   }

   private abstract static class class_959 extends Cast.class_1214<Cast.ApplicationConnectionResult> {
      private class_959() {
      }

      // $FF: synthetic method
      class_959(Object var1) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1009(var1);
      }

      // $FF: renamed from: j (com.google.android.gms.common.api.Status) com.google.android.gms.cast.Cast$ApplicationConnectionResult
      public Cast.ApplicationConnectionResult method_1009(final Status var1) {
         return new Cast.ApplicationConnectionResult() {
            public ApplicationMetadata getApplicationMetadata() {
               return null;
            }

            public String getApplicationStatus() {
               return null;
            }

            public String getSessionId() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }

            public boolean getWasLaunched() {
               return false;
            }
         };
      }
   }
}
