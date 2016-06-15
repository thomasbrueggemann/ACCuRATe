package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.class_241;
import com.google.android.gms.internal.class_323;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.gb;

public final class AppStateManager {
   public static final Api<Api.NoOptions> API;
   public static final Scope SCOPE_APP_STATE = new Scope("https://www.googleapis.com/auth/appstate");
   // $FF: renamed from: yE com.google.android.gms.common.api.Api$c
   static final Api.class_1077<gb> field_2953 = new Api.class_1077();
   // $FF: renamed from: yF com.google.android.gms.common.api.Api$b
   private static final Api.class_1074<gb, Api.NoOptions> field_2954 = new Api.class_1074() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
      // $FF: synthetic method
      public Api.class_1073 method_400(Context var1, Looper var2, class_323 var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.method_3281(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      // $FF: renamed from: b (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.gb
      public class_241 method_3281(Context var1, Looper var2, class_323 var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new class_241(var1, var2, var5, var6, var3.method_2055(), (String[])var3.method_2057().toArray(new String[0]));
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };

   static {
      Api.class_1074 var0 = field_2954;
      Api.class_1077 var1 = field_2953;
      Scope[] var2 = new Scope[]{SCOPE_APP_STATE};
      API = new Api(var0, var1, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient) com.google.android.gms.internal.gb
   public static class_241 method_3122(GoogleApiClient var0) {
      boolean var1 = true;
      boolean var2;
      if(var0 != null) {
         var2 = var1;
      } else {
         var2 = false;
      }

      class_347.method_2168(var2, "GoogleApiClient parameter is required.");
      class_347.method_2161(var0.isConnected(), "GoogleApiClient must be connected.");
      class_241 var3 = (class_241)var0.method_771(field_2953);
      if(var3 == null) {
         var1 = false;
      }

      class_347.method_2161(var1, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
      return var3;
   }

   public static PendingResult<AppStateManager.StateDeletedResult> delete(GoogleApiClient var0, final int var1) {
      return var0.method_773(new AppStateManager.class_1096(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.gb) void
         protected void method_957(class_241 var1x) {
            var1x.method_1653(this, var1);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         public Result method_884(Status var1x) {
            return this.method_958(var1x);
         }

         // $FF: renamed from: g (com.google.android.gms.common.api.Status) com.google.android.gms.appstate.AppStateManager$StateDeletedResult
         public AppStateManager.StateDeletedResult method_958(final Status var1x) {
            return new AppStateManager.StateDeletedResult() {
               public int getStateKey() {
                  return var1;
               }

               public Status getStatus() {
                  return var1x;
               }
            };
         }
      });
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.Status) com.google.android.gms.appstate.AppStateManager$StateResult
   private static AppStateManager.StateResult method_3123(final Status var0) {
      return new AppStateManager.StateResult() {
         public AppStateManager.StateConflictResult getConflictResult() {
            return null;
         }

         public AppStateManager.StateLoadedResult getLoadedResult() {
            return null;
         }

         public Status getStatus() {
            return var0;
         }

         public void release() {
         }
      };
   }

   public static int getMaxNumKeys(GoogleApiClient var0) {
      return method_3122(var0).method_1659();
   }

   public static int getMaxStateSize(GoogleApiClient var0) {
      return method_3122(var0).method_1658();
   }

   public static PendingResult<AppStateManager.StateListResult> list(GoogleApiClient var0) {
      return var0.method_772(new AppStateManager.class_1032(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.gb) void
         protected void method_956(class_241 var1) {
            var1.method_1652(this);
         }
      });
   }

   public static PendingResult<AppStateManager.StateResult> load(GoogleApiClient var0, final int var1) {
      return var0.method_772(new AppStateManager.class_1098(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.gb) void
         protected void method_949(class_241 var1x) {
            var1x.method_1657(this, var1);
         }
      });
   }

   public static PendingResult<AppStateManager.StateResult> resolve(GoogleApiClient var0, final int var1, final String var2, final byte[] var3) {
      return var0.method_773(new AppStateManager.class_1098(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.gb) void
         protected void method_951(class_241 var1x) {
            var1x.method_1654(this, var1, var2, var3);
         }
      });
   }

   public static PendingResult<Status> signOut(GoogleApiClient var0) {
      return var0.method_773(new AppStateManager.class_1097(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.gb) void
         protected void method_954(class_241 var1) {
            var1.method_1656(this);
         }
      });
   }

   public static void update(GoogleApiClient var0, final int var1, final byte[] var2) {
      var0.method_773(new AppStateManager.class_1098(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.gb) void
         protected void method_952(class_241 var1x) {
            var1x.method_1655((class_797.class_1206)null, var1, var2);
         }
      });
   }

   public static PendingResult<AppStateManager.StateResult> updateImmediate(GoogleApiClient var0, final int var1, final byte[] var2) {
      return var0.method_773(new AppStateManager.class_1098(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.gb) void
         protected void method_950(class_241 var1x) {
            var1x.method_1655(this, var1, var2);
         }
      });
   }

   public interface StateConflictResult extends Releasable, Result {
      byte[] getLocalData();

      String getResolvedVersion();

      byte[] getServerData();

      int getStateKey();
   }

   public interface StateDeletedResult extends Result {
      int getStateKey();
   }

   public interface StateListResult extends Result {
      AppStateBuffer getStateBuffer();
   }

   public interface StateLoadedResult extends Releasable, Result {
      byte[] getLocalData();

      int getStateKey();
   }

   public interface StateResult extends Releasable, Result {
      AppStateManager.StateConflictResult getConflictResult();

      AppStateManager.StateLoadedResult getLoadedResult();
   }

   public abstract static class class_1095<R extends Result> extends class_797.class_1203<R, gb> {
      public class_1095() {
         super(AppStateManager.field_2953);
      }
   }

   private abstract static class class_1096 extends AppStateManager.class_1095<AppStateManager.StateDeletedResult> {
      private class_1096() {
      }

      // $FF: synthetic method
      class_1096(Object var1) {
         this();
      }
   }

   private abstract static class class_1032 extends AppStateManager.class_1095<AppStateManager.StateListResult> {
      private class_1032() {
      }

      // $FF: synthetic method
      class_1032(Object var1) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_955(var1);
      }

      // $FF: renamed from: h (com.google.android.gms.common.api.Status) com.google.android.gms.appstate.AppStateManager$StateListResult
      public AppStateManager.StateListResult method_955(final Status var1) {
         return new AppStateManager.StateListResult() {
            public AppStateBuffer getStateBuffer() {
               return new AppStateBuffer((DataHolder)null);
            }

            public Status getStatus() {
               return var1;
            }
         };
      }
   }

   private abstract static class class_1097 extends AppStateManager.class_1095<Status> {
      private class_1097() {
      }

      // $FF: synthetic method
      class_1097(Object var1) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_953(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_953(Status var1) {
         return var1;
      }
   }

   private abstract static class class_1098 extends AppStateManager.class_1095<AppStateManager.StateResult> {
      private class_1098() {
      }

      // $FF: synthetic method
      class_1098(Object var1) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_948(var1);
      }

      // $FF: renamed from: i (com.google.android.gms.common.api.Status) com.google.android.gms.appstate.AppStateManager$StateResult
      public AppStateManager.StateResult method_948(Status var1) {
         return AppStateManager.method_3123(var1);
      }
   }
}
