package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.ag;
import com.google.android.gms.wearable.internal.ba;
import com.google.android.gms.wearable.internal.bb;
import com.google.android.gms.wearable.internal.class_284;
import com.google.android.gms.wearable.internal.class_558;
import com.google.android.gms.wearable.internal.class_991;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.wearable.internal.ag
abstract class class_707<T> {
   private final HashMap<T, bb> agU = new HashMap();

   // $FF: renamed from: a (java.lang.Object, android.content.IntentFilter[]) com.google.android.gms.wearable.internal.bb
   abstract bb method_4144(T var1, IntentFilter[] var2);

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba, com.google.android.gms.common.api.BaseImplementation$b, java.lang.Object) void
   public void method_4145(ba param1, BaseImplementation.class_1058<Status> param2, T param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba, com.google.android.gms.common.api.BaseImplementation$b, java.lang.Object, android.content.IntentFilter[]) void
   public void method_4146(ba param1, BaseImplementation.class_1058<Status> param2, T param3, IntentFilter[] param4) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.wearable.internal.ba) void
   public void method_4147(class_284 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ca (android.os.IBinder) void
   public void method_4148(IBinder param1) {
      // $FF: Couldn't be decompiled
   }

   private static class class_1511<T> extends class_991.class_1567<Status> {
      private WeakReference<Map<T, bb>> axP;
      private WeakReference<T> axQ;

      class_1511(Map<T, bb> var1, T var2, BaseImplementation.class_1058<Status> var3) {
         super(var3);
         this.axP = new WeakReference(var1);
         this.axQ = new WeakReference(var2);
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
      public void method_964(Status param1) {
         // $FF: Couldn't be decompiled
      }
   }

   static final class class_1512 extends ag<DataApi.DataListener> {
      // $FF: renamed from: a (com.google.android.gms.wearable.DataApi$DataListener, android.content.IntentFilter[]) com.google.android.gms.wearable.internal.bb
      class_558 method_4149(DataApi.DataListener var1, IntentFilter[] var2) {
         return class_558.method_3415(var1, var2);
      }
   }

   static final class class_1513 extends ag<MessageApi.MessageListener> {
      // $FF: renamed from: a (com.google.android.gms.wearable.MessageApi$MessageListener, android.content.IntentFilter[]) com.google.android.gms.wearable.internal.bb
      class_558 method_4150(MessageApi.MessageListener var1, IntentFilter[] var2) {
         return class_558.method_3416(var1, var2);
      }
   }

   static final class class_1514 extends ag<NodeApi.NodeListener> {
      // $FF: renamed from: a (com.google.android.gms.wearable.NodeApi$NodeListener, android.content.IntentFilter[]) com.google.android.gms.wearable.internal.bb
      class_558 method_4151(NodeApi.NodeListener var1, IntentFilter[] var2) {
         return class_558.method_3414(var1);
      }
   }

   private static class class_1515<T> extends class_991.class_1567<Status> {
      private WeakReference<Map<T, bb>> axP;
      private WeakReference<T> axQ;

      class_1515(Map<T, bb> var1, T var2, BaseImplementation.class_1058<Status> var3) {
         super(var3);
         this.axP = new WeakReference(var1);
         this.axQ = new WeakReference(var2);
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
      public void method_964(Status param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
