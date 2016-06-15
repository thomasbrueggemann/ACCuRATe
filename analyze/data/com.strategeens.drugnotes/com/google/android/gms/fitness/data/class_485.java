package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.class_193;
import com.google.android.gms.fitness.data.l;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.internal.class_335;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.fitness.data.l
public class class_485 extends class_193.class_1212 {
   // $FF: renamed from: UF com.google.android.gms.fitness.request.OnDataPointListener
   private final OnDataPointListener field_1830;

   private class_485(OnDataPointListener var1) {
      this.field_1830 = (OnDataPointListener)class_335.method_2311(var1);
   }

   // $FF: synthetic method
   class_485(OnDataPointListener var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: c (com.google.android.gms.fitness.data.DataPoint) void
   public void method_1063(DataPoint var1) throws RemoteException {
      this.field_1830.onDataPoint(var1);
   }

   public static class class_1611 {
      // $FF: renamed from: UG com.google.android.gms.fitness.data.l$a
      private static final class_485.class_1611 field_3574 = new class_485.class_1611();
      // $FF: renamed from: UH java.util.Map
      private final Map<OnDataPointListener, l> field_3575 = new HashMap();

      // $FF: renamed from: jG () com.google.android.gms.fitness.data.l$a
      public static class_485.class_1611 method_4748() {
         return field_3574;
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.request.OnDataPointListener) com.google.android.gms.fitness.data.l
      public class_485 method_4749(OnDataPointListener param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: b (com.google.android.gms.fitness.request.OnDataPointListener) com.google.android.gms.fitness.data.l
      public class_485 method_4750(OnDataPointListener param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.fitness.request.OnDataPointListener) com.google.android.gms.fitness.data.l
      public class_485 method_4751(OnDataPointListener param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
