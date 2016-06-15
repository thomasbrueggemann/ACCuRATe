package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.class_297;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.ib;

@Deprecated
public final class AppStateManager {
   public static final Api<Api.NoOptions> API;
   // $FF: renamed from: DQ com.google.android.gms.common.api.Api$c
   static final Api.class_1394<ib> field_2825 = new Api.class_1394();
   // $FF: renamed from: DR com.google.android.gms.common.api.Api$b
   private static final Api.class_1391<ib, Api.NoOptions> field_2826 = new Api.class_1391() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
      // $FF: synthetic method
      public Api.class_1390 method_442(Context var1, Looper var2, class_347 var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.method_3896(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      // $FF: renamed from: b (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.ib
      public class_297 method_3896(Context var1, Looper var2, class_347 var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new class_297(var1, var2, var5, var6, var3.method_2418(), (String[])var3.method_2420().toArray(new String[0]));
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static final Scope SCOPE_APP_STATE = new Scope("https://www.googleapis.com/auth/appstate");

   static {
      Api.class_1391 var0 = field_2826;
      Api.class_1394 var1 = field_2825;
      Scope[] var2 = new Scope[]{SCOPE_APP_STATE};
      API = new Api(var0, var1, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient) com.google.android.gms.internal.ib
   public static class_297 method_3727(GoogleApiClient var0) {
      boolean var1 = true;
      boolean var2;
      if(var0 != null) {
         var2 = var1;
      } else {
         var2 = false;
      }

      class_335.method_2308(var2, "GoogleApiClient parameter is required.");
      class_335.method_2302(var0.isConnected(), "GoogleApiClient must be connected.");
      class_297 var3 = (class_297)var0.method_941(field_2825);
      if(var3 == null) {
         var1 = false;
      }

      class_335.method_2302(var1, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
      return var3;
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.appstate.AppStateManager$StateResult
   private static AppStateManager.StateResult method_3728(final Status var0) {
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

   public static PendingResult<AppStateManager.StateDeletedResult> delete(final GoogleApiClient var0, final int var1) {
      return var0.method_944(new AppStateManager.class_1417(var0) {
         // $FF: renamed from: a (com.google.android.gms.internal.ib) void
         protected void method_1168(class_297 var1x) {
            var1x.method_2024(this, var1);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         public Result method_1109(Status var1x) {
            return this.method_1169(var1x);
         }

         // $FF: renamed from: f (com.google.android.gms.common.api.Status) com.google.android.gms.appstate.AppStateManager$StateDeletedResult
         public AppStateManager.StateDeletedResult method_1169(final Status var1x) {
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

   public static int getMaxNumKeys(GoogleApiClient var0) {
      return method_3727(var0).method_2030();
   }

   public static int getMaxStateSize(GoogleApiClient var0) {
      return method_3727(var0).method_2029();
   }

   public static PendingResult<AppStateManager.StateListResult> list(final GoogleApiClient var0) {
      return var0.method_942(new AppStateManager.class_1369(var0) {
         // $FF: renamed from: a (com.google.android.gms.internal.ib) void
         protected void method_1167(class_297 var1) {
            var1.method_2023(this);
         }
      });
   }

   public static PendingResult<AppStateManager.StateResult> load(final GoogleApiClient var0, final int var1) {
      return var0.method_942(new AppStateManager.class_1419(var0) {
         // $FF: renamed from: a (com.google.android.gms.internal.ib) void
         protected void method_1160(class_297 var1x) {
            var1x.method_2028(this, var1);
         }
      });
   }

   public static PendingResult<AppStateManager.StateResult> resolve(final GoogleApiClient var0, final int var1, final String var2, final byte[] var3) {
      return var0.method_944(new AppStateManager.class_1419(var0) {
         // $FF: renamed from: a (com.google.android.gms.internal.ib) void
         protected void method_1162(class_297 var1x) {
            var1x.method_2025(this, var1, var2, var3);
         }
      });
   }

   public static PendingResult<Status> signOut(final GoogleApiClient var0) {
      return var0.method_944(new AppStateManager.class_1418(var0) {
         // $FF: renamed from: a (com.google.android.gms.internal.ib) void
         protected void method_1165(class_297 var1) {
            var1.method_2027(this);
         }
      });
   }

   public static void update(final GoogleApiClient var0, final int var1, final byte[] var2) {
      var0.method_944(new AppStateManager.class_1419(var0) {
         // $FF: renamed from: a (com.google.android.gms.internal.ib) void
         protected void method_1163(class_297 var1x) {
            var1x.method_2026((BaseImplementation.class_1058)null, var1, var2);
         }
      });
   }

   public static PendingResult<AppStateManager.StateResult> updateImmediate(final GoogleApiClient var0, final int var1, final byte[] var2) {
      return var0.method_944(new AppStateManager.class_1419(var0) {
         // $FF: renamed from: a (com.google.android.gms.internal.ib) void
         protected void method_1161(class_297 var1x) {
            var1x.method_2026(this, var1, var2);
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

   public abstract static class class_1416<R extends Result> extends BaseImplementation.class_1057<R, ib> {
      public class_1416(GoogleApiClient var1) {
         super(AppStateManager.field_2825, var1);
      }
   }

   private abstract static class class_1417 extends AppStateManager.class_1416<AppStateManager.StateDeletedResult> {
      class_1417(GoogleApiClient var1) {
         super(var1);
      }
   }

   private abstract static class class_1369 extends AppStateManager.class_1416<AppStateManager.StateListResult> {
      public class_1369(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1166(var1);
      }

      // $FF: renamed from: g (com.google.android.gms.common.api.Status) com.google.android.gms.appstate.AppStateManager$StateListResult
      public AppStateManager.StateListResult method_1166(final Status var1) {
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

   private abstract static class class_1418 extends AppStateManager.class_1416<Status> {
      public class_1418(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1164(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1164(var1);
      }
   }

   private abstract static class class_1419 extends AppStateManager.class_1416<AppStateManager.StateResult> {
      public class_1419(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1159(var1);
      }

      // $FF: renamed from: h (com.google.android.gms.common.api.Status) com.google.android.gms.appstate.AppStateManager$StateResult
      public AppStateManager.StateResult method_1159(Status var1) {
         return AppStateManager.method_3728(var1);
      }
   }
}
