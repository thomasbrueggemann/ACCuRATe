package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.class_193;
import com.google.android.gms.fitness.data.class_485;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.class_497;
import com.google.android.gms.fitness.request.class_518;
import com.google.android.gms.fitness.request.o;
import com.google.android.gms.fitness.request.q;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.class_135;
import com.google.android.gms.internal.class_138;
import com.google.android.gms.internal.class_782;
import com.google.android.gms.internal.class_91;
import com.google.android.gms.internal.lu;

// $FF: renamed from: com.google.android.gms.internal.mm
public class class_774 implements SensorsApi {
   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.fitness.request.o) com.google.android.gms.common.api.PendingResult
   private PendingResult<Status> method_4392(final GoogleApiClient var1, final o var2) {
      return var1.method_942(new class_774.class_1654(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1147(class_91 var1) throws RemoteException {
            class_91.class_1348 var2x = new class_91.class_1348(this);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_757(var2, var2x, var3);
         }

         // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
         protected Status method_1148(Status var1) {
            return var1;
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1148(var1);
         }
      });
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.fitness.request.q, com.google.android.gms.internal.mm$b) com.google.android.gms.common.api.PendingResult
   private PendingResult<Status> method_4393(final GoogleApiClient var1, final q var2, final class_774.class_1652 var3) {
      return var1.method_944(new class_774.class_1654(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1145(class_91 var1) throws RemoteException {
            class_774.class_1651 var2x = new class_774.class_1651(this, var3, null);
            String var3x = var1.getContext().getPackageName();
            var1.method_441().method_758(var2, var2x, var3x);
         }

         // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
         protected Status method_1146(Status var1) {
            return var1;
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1146(var1);
         }
      });
   }

   public PendingResult<Status> add(GoogleApiClient var1, SensorRequest var2, PendingIntent var3) {
      return this.method_4392(var1, new class_497(var2, (class_193)null, var3));
   }

   public PendingResult<Status> add(GoogleApiClient var1, SensorRequest var2, OnDataPointListener var3) {
      return this.method_4392(var1, new class_497(var2, class_485.class_1611.method_4748().method_4749(var3), (PendingIntent)null));
   }

   public PendingResult<DataSourcesResult> findDataSources(final GoogleApiClient var1, final DataSourcesRequest var2) {
      return var1.method_942(new class_774.class_1654(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1149(class_91 var1) throws RemoteException {
            class_774.class_1653 var2x = new class_774.class_1653(this, null);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_743(var2, var2x, var3);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1150(var1);
         }

         // $FF: renamed from: z (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.DataSourcesResult
         protected DataSourcesResult method_1150(Status var1) {
            return DataSourcesResult.method_3610(var1);
         }
      });
   }

   public PendingResult<Status> remove(GoogleApiClient var1, PendingIntent var2) {
      return this.method_4393(var1, new class_518((class_193)null, var2), (class_774.class_1652)null);
   }

   public PendingResult<Status> remove(GoogleApiClient var1, final OnDataPointListener var2) {
      class_485 var3 = class_485.class_1611.method_4748().method_4750(var2);
      return (PendingResult)(var3 == null?new class_782(Status.field_3960):this.method_4393(var1, new class_518(var3, (PendingIntent)null), new class_774.class_1652() {
         // $FF: renamed from: jO () void
         public void method_920() {
            class_485.class_1611.method_4748().method_4751(var2);
         }
      }));
   }

   private abstract static class class_1654<R extends Result> extends BaseImplementation.class_1057<R, lu> {
      public class_1654(GoogleApiClient var1) {
         super(Fitness.field_3856, var1);
      }
   }

   private interface class_1652 {
      // $FF: renamed from: jO () void
      void method_920();
   }

   private static class class_1653 extends class_138.class_1198 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<DataSourcesResult> field_1795;

      private class_1653(BaseImplementation.class_1058<DataSourcesResult> var1) {
         this.field_1795 = var1;
      }

      // $FF: synthetic method
      class_1653(BaseImplementation.class_1058 var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.result.DataSourcesResult) void
      public void method_740(DataSourcesResult var1) {
         this.field_1795.method_110(var1);
      }
   }

   private static class class_1651 extends class_135.class_1365 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Status> field_2937;
      // $FF: renamed from: Vu com.google.android.gms.internal.mm$b
      private final class_774.class_1652 field_2938;

      private class_1651(BaseImplementation.class_1058<Status> var1, class_774.class_1652 var2) {
         this.field_2937 = var1;
         this.field_2938 = var2;
      }

      // $FF: synthetic method
      class_1651(BaseImplementation.class_1058 var1, class_774.class_1652 var2, Object var3) {
         this(var1, var2);
      }

      // $FF: renamed from: j (com.google.android.gms.common.api.Status) void
      public void method_737(Status var1) {
         if(this.field_2938 != null && var1.isSuccess()) {
            this.field_2938.method_920();
         }

         this.field_2937.method_110(var1);
      }
   }
}
