package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.class_494;
import com.google.android.gms.fitness.request.class_510;
import com.google.android.gms.fitness.request.class_512;
import com.google.android.gms.fitness.request.class_514;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.class_133;
import com.google.android.gms.internal.class_136;
import com.google.android.gms.internal.class_91;

// $FF: renamed from: com.google.android.gms.internal.mn
public class class_775 implements SessionsApi {
   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, java.lang.String, java.lang.String) com.google.android.gms.common.api.PendingResult
   private PendingResult<SessionStopResult> method_4394(final GoogleApiClient var1, final String var2, final String var3) {
      return var1.method_944(new class_91.class_1347(var1) {
         // $FF: renamed from: A (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.SessionStopResult
         protected SessionStopResult method_1263(Status var1) {
            return SessionStopResult.method_5447(var1);
         }

         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1264(class_91 var1) throws RemoteException {
            class_775.class_1668 var2x = new class_775.class_1668(this, null);
            String var3x = var1.getContext().getPackageName();
            var1.method_441().method_761((new class_510.class_1468()).method_5277(var2).method_5278(var3).method_5279(), var2x, var3x);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1263(var1);
         }
      });
   }

   public PendingResult<Status> insertSession(final GoogleApiClient var1, final SessionInsertRequest var2) {
      return var1.method_942(new class_91.class_1349(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1281(class_91 var1) throws RemoteException {
            class_91.class_1348 var2x = new class_91.class_1348(this);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_745(var2, var2x, var3);
         }
      });
   }

   public PendingResult<SessionReadResult> readSession(final GoogleApiClient var1, final SessionReadRequest var2) {
      return var1.method_942(new class_91.class_1347(var1) {
         // $FF: renamed from: B (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.SessionReadResult
         protected SessionReadResult method_1265(Status var1) {
            return SessionReadResult.method_3521(var1);
         }

         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1266(class_91 var1) throws RemoteException {
            class_775.class_1669 var2x = new class_775.class_1669(this, null);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_746(var2, var2x, var3);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1265(var1);
         }
      });
   }

   public PendingResult<Status> registerForSessions(final GoogleApiClient var1, final PendingIntent var2) {
      return var1.method_944(new class_91.class_1349(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1280(class_91 var1) throws RemoteException {
            class_91.class_1348 var2x = new class_91.class_1348(this);
            class_514 var3 = new class_514(var2);
            String var4 = var1.getContext().getPackageName();
            var1.method_441().method_759(var3, var2x, var4);
         }
      });
   }

   public PendingResult<Status> startSession(final GoogleApiClient var1, final Session var2) {
      return var1.method_944(new class_91.class_1349(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1278(class_91 var1) throws RemoteException {
            class_91.class_1348 var2x = new class_91.class_1348(this);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_760((new class_512.class_1467()).method_4126(var2).method_4127(), var2x, var3);
         }
      });
   }

   public PendingResult<SessionStopResult> stopSession(GoogleApiClient var1, String var2) {
      return this.method_4394(var1, (String)null, var2);
   }

   public PendingResult<Status> unregisterForSessions(final GoogleApiClient var1, final PendingIntent var2) {
      return var1.method_944(new class_91.class_1349(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1279(class_91 var1) throws RemoteException {
            class_91.class_1348 var2x = new class_91.class_1348(this);
            class_494 var3 = new class_494(var2);
            String var4 = var1.getContext().getPackageName();
            var1.method_441().method_748(var3, var2x, var4);
         }
      });
   }

   private static class class_1669 extends class_133.class_1407 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<SessionReadResult> field_3972;

      private class_1669(BaseImplementation.class_1058<SessionReadResult> var1) {
         this.field_3972 = var1;
      }

      // $FF: synthetic method
      class_1669(BaseImplementation.class_1058 var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.result.SessionReadResult) void
      public void method_735(SessionReadResult var1) throws RemoteException {
         this.field_3972.method_110(var1);
      }
   }

   private static class class_1668 extends class_136.class_1413 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<SessionStopResult> field_3971;

      private class_1668(BaseImplementation.class_1058<SessionStopResult> var1) {
         this.field_3971 = var1;
      }

      // $FF: synthetic method
      class_1668(BaseImplementation.class_1058 var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.result.SessionStopResult) void
      public void method_738(SessionStopResult var1) {
         this.field_3971.method_110(var1);
      }
   }
}
