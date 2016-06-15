package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.class_193;
import com.google.android.gms.fitness.service.SensorEventDispatcher;
import com.google.android.gms.internal.class_335;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.fitness.service.b
class class_966 implements SensorEventDispatcher {
   // $FF: renamed from: VW com.google.android.gms.fitness.data.k
   private final class_193 field_4124;

   class_966(class_193 var1) {
      this.field_4124 = (class_193)class_335.method_2311(var1);
   }

   public void publish(DataPoint var1) throws RemoteException {
      this.field_4124.method_1063(var1);
   }

   public void publish(List<DataPoint> var1) throws RemoteException {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         this.publish((DataPoint)var2.next());
      }

   }
}
