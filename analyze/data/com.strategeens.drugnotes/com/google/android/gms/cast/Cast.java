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
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_298;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.im;
import java.io.IOException;

public final class Cast {
   public static final Api<Cast.CastOptions> API;
   public static final Cast.CastApi CastApi;
   // $FF: renamed from: DQ com.google.android.gms.common.api.Api$c
   static final Api.class_1394<im> field_3219 = new Api.class_1394();
   // $FF: renamed from: DR com.google.android.gms.common.api.Api$b
   private static final Api.class_1391<im, Cast.CastOptions> field_3220 = new Api.class_1391() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.cast.Cast$CastOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.im
      public class_298 method_5390(Context var1, Looper var2, class_347 var3, Cast.CastOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         class_335.method_2306(var4, "Setting the API options is required.");
         return new class_298(var1, var2, var4.field_3994, (long)var4.field_3993, var4.field_3992, var5, var6);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
   public static final int MAX_MESSAGE_LENGTH = 65536;
   public static final int MAX_NAMESPACE_LENGTH = 128;

   static {
      API = new Api(field_3220, field_3219, new Scope[0]);
      CastApi = new Cast.class_1578();
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

   public static final class class_1578 implements Cast.CastApi {
      public ApplicationMetadata getApplicationMetadata(GoogleApiClient var1) throws IllegalStateException {
         return ((class_298)var1.method_941(Cast.field_3219)).getApplicationMetadata();
      }

      public String getApplicationStatus(GoogleApiClient var1) throws IllegalStateException {
         return ((class_298)var1.method_941(Cast.field_3219)).getApplicationStatus();
      }

      public double getVolume(GoogleApiClient var1) throws IllegalStateException {
         return ((class_298)var1.method_941(Cast.field_3219)).method_2069();
      }

      public boolean isMute(GoogleApiClient var1) throws IllegalStateException {
         return ((class_298)var1.method_941(Cast.field_3219)).isMute();
      }

      public PendingResult<Cast.ApplicationConnectionResult> joinApplication(final GoogleApiClient var1) {
         return var1.method_944(new Cast.class_1257(var1) {
            // $FF: renamed from: a (com.google.android.gms.internal.im) void
            protected void method_1237(class_298 var1) throws RemoteException {
               try {
                  var1.method_2066((String)null, (String)null, this);
               } catch (IllegalStateException var3) {
                  this.W(2001);
               }
            }
         });
      }

      public PendingResult<Cast.ApplicationConnectionResult> joinApplication(final GoogleApiClient var1, final String var2) {
         return var1.method_944(new Cast.class_1257(var1) {
            // $FF: renamed from: a (com.google.android.gms.internal.im) void
            protected void method_1238(class_298 var1) throws RemoteException {
               try {
                  var1.method_2066(var2, (String)null, this);
               } catch (IllegalStateException var3) {
                  this.W(2001);
               }
            }
         });
      }

      public PendingResult<Cast.ApplicationConnectionResult> joinApplication(final GoogleApiClient var1, final String var2, final String var3) {
         return var1.method_944(new Cast.class_1257(var1) {
            // $FF: renamed from: a (com.google.android.gms.internal.im) void
            protected void method_1239(class_298 var1) throws RemoteException {
               try {
                  var1.method_2066(var2, var3, this);
               } catch (IllegalStateException var3x) {
                  this.W(2001);
               }
            }
         });
      }

      public PendingResult<Cast.ApplicationConnectionResult> launchApplication(final GoogleApiClient var1, final String var2) {
         return var1.method_944(new Cast.class_1257(var1) {
            // $FF: renamed from: a (com.google.android.gms.internal.im) void
            protected void method_1241(class_298 var1) throws RemoteException {
               try {
                  var1.method_2064(var2, false, this);
               } catch (IllegalStateException var3) {
                  this.W(2001);
               }
            }
         });
      }

      public PendingResult<Cast.ApplicationConnectionResult> launchApplication(final GoogleApiClient var1, final String var2, final LaunchOptions var3) {
         return var1.method_944(new Cast.class_1257(var1) {
            // $FF: renamed from: a (com.google.android.gms.internal.im) void
            protected void method_1240(class_298 var1) throws RemoteException {
               try {
                  var1.method_2061(var2, var3, this);
               } catch (IllegalStateException var3x) {
                  this.W(2001);
               }
            }
         });
      }

      @Deprecated
      public PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient var1, String var2, boolean var3) {
         return this.launchApplication(var1, var2, (new LaunchOptions.Builder()).setRelaunchIfRunning(var3).build());
      }

      public PendingResult<Status> leaveApplication(final GoogleApiClient var1) {
         return var1.method_944(new Cast.class_1580(var1) {
            // $FF: renamed from: a (com.google.android.gms.internal.im) void
            protected void method_1245(class_298 var1) throws RemoteException {
               try {
                  var1.method_2067(this);
               } catch (IllegalStateException var3) {
                  this.W(2001);
               }
            }
         });
      }

      public void removeMessageReceivedCallbacks(GoogleApiClient var1, String var2) throws IOException, IllegalArgumentException {
         try {
            ((class_298)var1.method_941(Cast.field_3219)).method_2065(var2);
         } catch (RemoteException var4) {
            throw new IOException("service error");
         }
      }

      public void requestStatus(GoogleApiClient var1) throws IOException, IllegalStateException {
         try {
            ((class_298)var1.method_941(Cast.field_3219)).method_2068();
         } catch (RemoteException var3) {
            throw new IOException("service error");
         }
      }

      public PendingResult<Status> sendMessage(final GoogleApiClient var1, final String var2, final String var3) {
         return var1.method_944(new Cast.class_1580(var1) {
            // $FF: renamed from: a (com.google.android.gms.internal.im) void
            protected void method_1246(class_298 var1) throws RemoteException {
               try {
                  var1.method_2063(var2, var3, this);
               } catch (IllegalArgumentException var4) {
                  this.W(2001);
               } catch (IllegalStateException var5) {
                  this.W(2001);
               }
            }
         });
      }

      public void setMessageReceivedCallbacks(GoogleApiClient var1, String var2, Cast.MessageReceivedCallback var3) throws IOException, IllegalStateException {
         try {
            ((class_298)var1.method_941(Cast.field_3219)).method_2060(var2, var3);
         } catch (RemoteException var5) {
            throw new IOException("service error");
         }
      }

      public void setMute(GoogleApiClient var1, boolean var2) throws IOException, IllegalStateException {
         try {
            ((class_298)var1.method_941(Cast.field_3219)).method_2057(var2);
         } catch (RemoteException var4) {
            throw new IOException("service error");
         }
      }

      public void setVolume(GoogleApiClient var1, double var2) throws IOException, IllegalArgumentException, IllegalStateException {
         try {
            ((class_298)var1.method_941(Cast.field_3219)).method_2059(var2);
         } catch (RemoteException var5) {
            throw new IOException("service error");
         }
      }

      public PendingResult<Status> stopApplication(final GoogleApiClient var1) {
         return var1.method_944(new Cast.class_1580(var1) {
            // $FF: renamed from: a (com.google.android.gms.internal.im) void
            protected void method_1244(class_298 var1) throws RemoteException {
               try {
                  var1.method_2062("", this);
               } catch (IllegalStateException var3) {
                  this.W(2001);
               }
            }
         });
      }

      public PendingResult<Status> stopApplication(final GoogleApiClient var1, final String var2) {
         return var1.method_944(new Cast.class_1580(var1) {
            // $FF: renamed from: a (com.google.android.gms.internal.im) void
            protected void method_1243(class_298 var1) throws RemoteException {
               if(TextUtils.isEmpty(var2)) {
                  this.e(2001, "IllegalArgument: sessionId cannot be null or empty");
               } else {
                  try {
                     var1.method_2062(var2, this);
                  } catch (IllegalStateException var3) {
                     this.W(2001);
                  }
               }
            }
         });
      }
   }

   public static final class CastOptions implements Api.HasOptions {
      // $FF: renamed from: FA com.google.android.gms.cast.Cast$Listener
      final Cast.Listener field_3992;
      // $FF: renamed from: FB int
      private final int field_3993;
      // $FF: renamed from: Fz com.google.android.gms.cast.CastDevice
      final CastDevice field_3994;

      private CastOptions(Cast.Builder var1) {
         this.field_3994 = var1.field_4091;
         this.field_3992 = var1.field_4092;
         this.field_3993 = var1.field_4093;
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
      // $FF: renamed from: FC com.google.android.gms.cast.CastDevice
      CastDevice field_4091;
      // $FF: renamed from: FD com.google.android.gms.cast.Cast$Listener
      Cast.Listener field_4092;
      // $FF: renamed from: FE int
      private int field_4093;

      private Builder(CastDevice var1, Cast.Listener var2) {
         class_335.method_2306(var1, "CastDevice parameter cannot be null");
         class_335.method_2306(var2, "CastListener parameter cannot be null");
         this.field_4091 = var1;
         this.field_4092 = var2;
         this.field_4093 = 0;
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
            this.field_4093 |= 1;
            return this;
         } else {
            this.field_4093 &= -2;
            return this;
         }
      }
   }

   public static class Listener {
      // $FF: renamed from: X (int) void
      public void method_3900(int var1) {
      }

      // $FF: renamed from: Y (int) void
      public void method_3901(int var1) {
      }

      public void onApplicationDisconnected(int var1) {
      }

      public void onApplicationMetadataChanged(ApplicationMetadata var1) {
      }

      public void onApplicationStatusChanged() {
      }

      public void onVolumeChanged() {
      }
   }

   public interface MessageReceivedCallback {
      void onMessageReceived(CastDevice var1, String var2, String var3);
   }

   protected abstract static class class_1579<R extends Result> extends BaseImplementation.class_1057<R, im> {
      public class_1579(GoogleApiClient var1) {
         super(Cast.field_3219, var1);
      }

      // $FF: renamed from: W (int) void
      public void method_1234(int var1) {
         this.b(this.c(new Status(var1)));
      }

      // $FF: renamed from: e (int, java.lang.String) void
      public void method_1235(int var1, String var2) {
         this.b(this.c(new Status(var1, var2, (PendingIntent)null)));
      }
   }

   private abstract static class class_1580 extends Cast.class_1579<Status> {
      class_1580(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1242(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1242(var1);
      }
   }

   private abstract static class class_1257 extends Cast.class_1579<Cast.ApplicationConnectionResult> {
      public class_1257(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1236(var1);
      }

      // $FF: renamed from: i (com.google.android.gms.common.api.Status) com.google.android.gms.cast.Cast$ApplicationConnectionResult
      public Cast.ApplicationConnectionResult method_1236(final Status var1) {
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
