package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.class_200;
import com.google.android.gms.fitness.service.SensorEventDispatcher;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.fitness.service.b
class class_1052 implements SensorEventDispatcher {
    // $FF: renamed from: UA com.google.android.gms.fitness.data.k
    private final class_200 field_4985;

    class_1052(class_200 var1) {
        this.field_4985 = (class_200)class_1090.method_5685(var1);
    }

    public void publish(DataPoint var1) throws RemoteException {
        this.field_4985.method_1046(var1);
    }

    public void publish(List<DataPoint> var1) throws RemoteException {
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            this.publish((DataPoint)var2.next());
        }

    }
}
