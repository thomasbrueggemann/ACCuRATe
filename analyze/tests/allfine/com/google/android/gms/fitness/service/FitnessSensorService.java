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
import com.google.android.gms.internal.class_148;
import com.google.android.gms.internal.class_151;
import com.google.android.gms.internal.class_158;
import com.google.android.gms.internal.class_837;
import com.google.android.gms.internal.class_841;
import com.google.android.gms.internal.class_854;
import java.util.List;

public abstract class FitnessSensorService extends Service {
    public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
    // $FF: renamed from: Va com.google.android.gms.fitness.service.FitnessSensorService$a
    private FitnessSensorService.class_1758 field_4383;

    public final IBinder onBind(Intent var1) {
        if("com.google.android.gms.fitness.service.FitnessSensorService".equals(var1.getAction())) {
            if(Log.isLoggable("FitnessSensorService", 3)) {
                Log.d("FitnessSensorService", "Intent " + var1 + " received by " + this.getClass().getName());
            }

            return this.field_4383.asBinder();
        } else {
            return null;
        }
    }

    public void onCreate() {
        super.onCreate();
        this.field_4383 = new FitnessSensorService.class_1758(this);
    }

    public abstract List<DataSource> onFindDataSources(List<DataType> var1);

    public abstract boolean onRegister(FitnessSensorServiceRequest var1);

    public abstract boolean onUnregister(DataSource var1);

    private static class class_1758 extends class_148.class_1535 {
        // $FF: renamed from: Vb com.google.android.gms.fitness.service.FitnessSensorService
        private final FitnessSensorService field_3451;

        private class_1758(FitnessSensorService var1) {
            this.field_3451 = var1;
        }

        // $FF: synthetic method
        class_1758(FitnessSensorService var1, Object var2) {
            this(var1);
        }

        // $FF: renamed from: jM () void
        private void method_3903() throws SecurityException {
            int var1 = Binder.getCallingUid();
            if(class_854.method_4500()) {
                ((AppOpsManager)this.field_3451.getSystemService("appops")).checkPackage(var1, "com.google.android.gms");
            } else {
                String[] var2 = this.field_3451.getPackageManager().getPackagesForUid(var1);
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

        // $FF: renamed from: a (com.google.android.gms.fitness.service.FitnessSensorServiceRequest, com.google.android.gms.internal.kt) void
        public void method_754(FitnessSensorServiceRequest var1, class_151 var2) throws RemoteException {
            this.method_3903();
            if(this.field_3451.onRegister(var1)) {
                var2.method_759(Status.field_4739);
            } else {
                var2.method_759(new Status(13));
            }
        }

        // $FF: renamed from: a (com.google.android.gms.internal.lg, com.google.android.gms.internal.kn) void
        public void method_755(class_841 var1, class_158 var2) throws RemoteException {
            this.method_3903();
            var2.method_789(new DataSourcesResult(this.field_3451.onFindDataSources(var1.getDataTypes()), Status.field_4739));
        }

        // $FF: renamed from: a (com.google.android.gms.internal.li, com.google.android.gms.internal.kt) void
        public void method_756(class_837 var1, class_151 var2) throws RemoteException {
            this.method_3903();
            if(this.field_3451.onUnregister(var1.getDataSource())) {
                var2.method_759(Status.field_4739);
            } else {
                var2.method_759(new Status(13));
            }
        }
    }
}
