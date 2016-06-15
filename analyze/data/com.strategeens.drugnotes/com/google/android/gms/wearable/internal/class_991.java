package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.a;
import com.google.android.gms.wearable.internal.class_706;
import com.google.android.gms.wearable.internal.class_907;
import com.google.android.gms.wearable.internal.class_912;
import com.google.android.gms.wearable.internal.class_918;
import com.google.android.gms.wearable.internal.class_920;
import com.google.android.gms.wearable.internal.class_922;
import com.google.android.gms.wearable.internal.class_981;
import com.google.android.gms.wearable.internal.class_986;
import com.google.android.gms.wearable.internal.class_993;
import com.google.android.gms.wearable.internal.class_995;
import com.google.android.gms.wearable.internal.class_998;
import com.google.android.gms.wearable.internal.class_999;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

// $FF: renamed from: com.google.android.gms.wearable.internal.az
final class class_991 {
   abstract static class class_1567<T> extends a {
      // $FF: renamed from: DA com.google.android.gms.common.api.BaseImplementation$b
      private BaseImplementation.class_1058<T> field_3211;

      public class_1567(BaseImplementation.class_1058<T> var1) {
         this.field_3211 = var1;
      }

      // $FF: renamed from: A (java.lang.Object) void
      public void method_4133(T var1) {
         BaseImplementation.class_1058 var2 = this.field_3211;
         if(var2 != null) {
            var2.method_110(var1);
            this.field_3211 = null;
         }

      }
   }

   static final class class_1566 extends class_991.class_1567<DataApi.DeleteDataItemsResult> {
      public class_1566(BaseImplementation.class_1058<DataApi.DeleteDataItemsResult> var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.p) void
      public void method_969(class_912 var1) {
         this.A(new class_907.class_1532(class_995.method_5491(var1.statusCode), var1.axI));
      }
   }

   static final class class_1569 extends class_991.class_1567<NodeApi.GetConnectedNodesResult> {
      public class_1569(BaseImplementation.class_1058<NodeApi.GetConnectedNodesResult> var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.v) void
      public void method_972(class_920 var1) {
         ArrayList var2 = new ArrayList();
         var2.addAll(var1.axL);
         this.A(new class_986.class_1635(class_995.method_5491(var1.statusCode), var2));
      }
   }

   static final class class_1568 extends class_991.class_1567<DataApi.DataItemResult> {
      public class_1568(BaseImplementation.class_1058<DataApi.DataItemResult> var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.x) void
      public void method_973(class_918 var1) {
         this.A(new class_907.class_1531(class_995.method_5491(var1.statusCode), var1.axM));
      }
   }

   static final class class_1576 extends class_991.class_1567<DataItemBuffer> {
      public class_1576(BaseImplementation.class_1058<DataItemBuffer> var1) {
         super(var1);
      }

      // $FF: renamed from: ab (com.google.android.gms.common.data.DataHolder) void
      public void method_975(DataHolder var1) {
         this.A(new DataItemBuffer(var1));
      }
   }

   static final class class_1577 extends class_991.class_1567<DataApi.GetFdForAssetResult> {
      public class_1577(BaseImplementation.class_1058<DataApi.GetFdForAssetResult> var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.z) void
      public void method_974(class_922 var1) {
         this.A(new class_907.class_1528(class_995.method_5491(var1.statusCode), var1.axN));
      }
   }

   static final class class_1574 extends class_991.class_1567<NodeApi.GetLocalNodeResult> {
      public class_1574(BaseImplementation.class_1058<NodeApi.GetLocalNodeResult> var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab) void
      public void method_965(class_998 var1) {
         this.A(new class_986.class_1636(class_995.method_5491(var1.statusCode), var1.axO));
      }
   }

   static final class class_1575 extends class_706 {
      // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
      public void method_964(Status var1) {
      }
   }

   static final class class_1570 extends class_991.class_1567<DataApi.DataItemResult> {
      private final List<FutureTask<Boolean>> ayf;

      class_1570(BaseImplementation.class_1058<DataApi.DataItemResult> var1, List<FutureTask<Boolean>> var2) {
         super(var1);
         this.ayf = var2;
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ap) void
      public void method_966(class_981 var1) {
         this.A(new class_907.class_1531(class_995.method_5491(var1.statusCode), var1.axM));
         if(var1.statusCode != 0) {
            Iterator var2 = this.ayf.iterator();

            while(var2.hasNext()) {
               ((FutureTask)var2.next()).cancel(true);
            }
         }

      }
   }

   static final class class_1573 extends class_991.class_1567<MessageApi.SendMessageResult> {
      public class_1573(BaseImplementation.class_1058<MessageApi.SendMessageResult> var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.at) void
      public void method_967(class_993 var1) {
         this.A(new class_999.class_1495(class_995.method_5491(var1.statusCode), var1.ayd));
      }
   }
}
