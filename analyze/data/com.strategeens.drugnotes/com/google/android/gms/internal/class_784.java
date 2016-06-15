package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.af;
import com.google.android.gms.fitness.request.aj;
import com.google.android.gms.fitness.request.class_483;
import com.google.android.gms.fitness.request.class_488;
import com.google.android.gms.fitness.request.class_495;
import com.google.android.gms.fitness.request.m;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.class_134;
import com.google.android.gms.internal.class_91;

// $FF: renamed from: com.google.android.gms.internal.ml
public class class_784 implements RecordingApi {
   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.fitness.request.m) com.google.android.gms.common.api.PendingResult
   private PendingResult<ListSubscriptionsResult> method_4405(final GoogleApiClient var1, final m var2) {
      return var1.method_942(new class_91.class_1347(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1261(class_91 var1) throws RemoteException {
            class_784.class_1707 var2x = new class_784.class_1707(this, null);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_756(var2, var2x, var3);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1262(var1);
         }

         // $FF: renamed from: y (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.ListSubscriptionsResult
         protected ListSubscriptionsResult method_1262(Status var1) {
            return ListSubscriptionsResult.method_3444(var1);
         }
      });
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.fitness.request.af) com.google.android.gms.common.api.PendingResult
   public PendingResult<Status> method_4406(final GoogleApiClient var1, final af var2) {
      return var1.method_942(new class_91.class_1349(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1276(class_91 var1) throws RemoteException {
            class_91.class_1348 var2x = new class_91.class_1348(this);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_750(var2, var2x, var3);
         }
      });
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.fitness.request.aj) com.google.android.gms.common.api.PendingResult
   public PendingResult<Status> method_4407(final GoogleApiClient var1, final aj var2) {
      return var1.method_944(new class_91.class_1349(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1277(class_91 var1) throws RemoteException {
            class_91.class_1348 var2x = new class_91.class_1348(this);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_752(var2, var2x, var3);
         }
      });
   }

   public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient var1) {
      return this.method_4405(var1, (new class_495.class_1283()).method_3244());
   }

   public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient var1, DataType var2) {
      return this.method_4405(var1, (new class_495.class_1283()).method_3243(var2).method_3244());
   }

   public PendingResult<Status> subscribe(GoogleApiClient var1, DataSource var2) {
      return this.method_4406(var1, (new class_488.class_1507()).method_3908((new Subscription.class_1614()).method_5070(var2).method_5072()).method_3909());
   }

   public PendingResult<Status> subscribe(GoogleApiClient var1, DataType var2) {
      return this.method_4406(var1, (new class_488.class_1507()).method_3908((new Subscription.class_1614()).method_5071(var2).method_5072()).method_3909());
   }

   public PendingResult<Status> unsubscribe(GoogleApiClient var1, DataSource var2) {
      return this.method_4407(var1, (new class_483.class_1517()).method_3973(var2).method_3975());
   }

   public PendingResult<Status> unsubscribe(GoogleApiClient var1, DataType var2) {
      return this.method_4407(var1, (new class_483.class_1517()).method_3974(var2).method_3975());
   }

   public PendingResult<Status> unsubscribe(GoogleApiClient var1, Subscription var2) {
      return var2.getDataType() == null?this.unsubscribe(var1, var2.getDataSource()):this.unsubscribe(var1, var2.getDataType());
   }

   private static class class_1707 extends class_134.class_1181 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<ListSubscriptionsResult> field_1769;

      private class_1707(BaseImplementation.class_1058<ListSubscriptionsResult> var1) {
         this.field_1769 = var1;
      }

      // $FF: synthetic method
      class_1707(BaseImplementation.class_1058 var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.result.ListSubscriptionsResult) void
      public void method_736(ListSubscriptionsResult var1) {
         this.field_1769.method_110(var1);
      }
   }
}
