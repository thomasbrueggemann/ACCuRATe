package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.a;
import com.google.android.gms.fitness.request.class_54;
import com.google.android.gms.internal.class_335;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.fitness.request.a
public class class_338 extends class_54.class_1099 {
   // $FF: renamed from: VC com.google.android.gms.fitness.request.BleScanCallback
   private final BleScanCallback field_890;

   private class_338(BleScanCallback var1) {
      this.field_890 = (BleScanCallback)class_335.method_2311(var1);
   }

   // $FF: synthetic method
   class_338(BleScanCallback var1, Object var2) {
      this(var1);
   }

   public void onDeviceFound(BleDevice var1) throws RemoteException {
      this.field_890.onDeviceFound(var1);
   }

   public void onScanStopped() throws RemoteException {
      this.field_890.onScanStopped();
   }

   public static class class_1321 {
      // $FF: renamed from: VD com.google.android.gms.fitness.request.a$a
      private static final class_338.class_1321 field_2593 = new class_338.class_1321();
      // $FF: renamed from: VE java.util.Map
      private final Map<BleScanCallback, a> field_2594 = new HashMap();

      // $FF: renamed from: jP () com.google.android.gms.fitness.request.a$a
      public static class_338.class_1321 method_3405() {
         return field_2593;
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.BleScanCallback) com.google.android.gms.fitness.request.a
      public class_338 method_3406(BleScanCallback param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.fitness.request.BleScanCallback) com.google.android.gms.fitness.request.a
      public class_338 method_3407(BleScanCallback param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
