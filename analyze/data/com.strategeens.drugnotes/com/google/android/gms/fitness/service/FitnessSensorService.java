package com.google.android.gms.fitness.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.class_135;
import com.google.android.gms.internal.class_138;
import com.google.android.gms.internal.class_151;
import com.google.android.gms.internal.class_712;
import com.google.android.gms.internal.class_776;
import com.google.android.gms.internal.class_778;
import java.util.List;

public abstract class FitnessSensorService extends Service {
   public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
   // $FF: renamed from: Ww com.google.android.gms.fitness.service.FitnessSensorService$a
   private FitnessSensorService.class_1624 field_3618;

   public final IBinder onBind(Intent var1) {
      if("com.google.android.gms.fitness.service.FitnessSensorService".equals(var1.getAction())) {
         if(Log.isLoggable("FitnessSensorService", 3)) {
            Log.d("FitnessSensorService", "Intent " + var1 + " received by " + this.getClass().getName());
         }

         return this.field_3618.asBinder();
      } else {
         return null;
      }
   }

   public void onCreate() {
      super.onCreate();
      this.field_3618 = new FitnessSensorService.class_1624(this);
   }

   public abstract List<DataSource> onFindDataSources(List<DataType> var1);

   public abstract boolean onRegister(FitnessSensorServiceRequest var1);

   public abstract boolean onUnregister(DataSource var1);

   private static class class_1624 extends class_151.class_1443 {
      // $FF: renamed from: Wx com.google.android.gms.fitness.service.FitnessSensorService
      private final FitnessSensorService field_3843;

      private class_1624(FitnessSensorService var1) {
         this.field_3843 = var1;
      }

      // $FF: synthetic method
      class_1624(FitnessSensorService var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: kw () void
      private void method_5095() throws SecurityException {
         int var1 = Binder.getCallingUid();
         if(class_712.method_4183()) {
            ((AppOpsManager)this.field_3843.getSystemService("appops")).checkPackage(var1, "com.google.android.gms");
         } else {
            String[] var2 = this.field_3843.getPackageManager().getPackagesForUid(var1);
            if(var2 != null) {
               int var3 = var2.length;

               for(int var4 = 0; var4 < var3; ++var4) {
                  if(var2[var4].equals("com.google.android.gms")) {
                     return;
                  }
               }
            }

            throw new SecurityException("Unauthorized caller");
         }
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.service.FitnessSensorServiceRequest, com.google.android.gms.internal.md) void
      public void method_812(FitnessSensorServiceRequest var1, class_135 var2) throws RemoteException {
         this.method_5095();
         if(this.field_3843.onRegister(var1)) {
            var2.method_737(Status.field_3960);
         } else {
            var2.method_737(new Status(13));
         }
      }

      // $FF: renamed from: a (com.google.android.gms.internal.mq, com.google.android.gms.internal.lx) void
      public void method_813(class_778 var1, class_138 var2) throws RemoteException {
         this.method_5095();
         var2.method_740(new DataSourcesResult(this.field_3843.onFindDataSources(var1.getDataTypes()), Status.field_3960));
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ms, com.google.android.gms.internal.md) void
      public void method_814(class_776 var1, class_135 var2) throws RemoteException {
         this.method_5095();
         if(this.field_3843.onUnregister(var1.getDataSource())) {
            var2.method_737(Status.field_3960);
         } else {
            var2.method_737(new Status(13));
         }
      }
   }
}
