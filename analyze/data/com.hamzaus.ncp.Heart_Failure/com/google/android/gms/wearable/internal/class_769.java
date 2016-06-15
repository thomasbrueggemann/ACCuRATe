package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.class_161;
import com.google.android.gms.wearable.internal.class_235;
import java.util.List;

// $FF: renamed from: com.google.android.gms.wearable.internal.ah
public final class class_769 implements NodeApi {
   public PendingResult<Status> addListener(GoogleApiClient var1, final NodeApi.NodeListener var2) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_981(class_235 var1) throws RemoteException {
            var1.method_1468(this, var2);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         public Result method_884(Status var1) {
            return this.method_982(var1);
         }

         // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
         public Status method_982(Status var1) {
            return new Status(13);
         }
      });
   }

   public PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient var1) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_979(class_235 var1) throws RemoteException {
            var1.method_1478(this);
         }

         // $FF: renamed from: aw (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.NodeApi$GetConnectedNodesResult
         protected NodeApi.GetConnectedNodesResult method_980(Status var1) {
            return new class_769.class_1128(var1, (List)null);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_884(Status var1) {
            return this.method_980(var1);
         }
      });
   }

   public PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient var1) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_977(class_235 var1) throws RemoteException {
            var1.method_1477(this);
         }

         // $FF: renamed from: av (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.NodeApi$GetLocalNodeResult
         protected NodeApi.GetLocalNodeResult method_978(Status var1) {
            return new class_769.class_1129(var1, (Node)null);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_884(Status var1) {
            return this.method_978(var1);
         }
      });
   }

   public PendingResult<Status> removeListener(GoogleApiClient var1, final NodeApi.NodeListener var2) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_983(class_235 var1) throws RemoteException {
            var1.method_1473(this, var2);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         public Result method_884(Status var1) {
            return this.method_984(var1);
         }

         // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
         public Status method_984(Status var1) {
            return new Status(13);
         }
      });
   }

   public static class class_1128 implements NodeApi.GetConnectedNodesResult {
      private final List<Node> alW;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_3095;

      public class_1128(Status var1, List<Node> var2) {
         this.field_3095 = var1;
         this.alW = var2;
      }

      public List<Node> getNodes() {
         return this.alW;
      }

      public Status getStatus() {
         return this.field_3095;
      }
   }

   public static class class_1129 implements NodeApi.GetLocalNodeResult {
      private final Node alX;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_3093;

      public class_1129(Status var1, Node var2) {
         this.field_3093 = var1;
         this.alX = var2;
      }

      public Node getNode() {
         return this.alX;
      }

      public Status getStatus() {
         return this.field_3093;
      }
   }
}
