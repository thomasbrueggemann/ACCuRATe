package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.class_203;
import com.google.android.gms.wearable.internal.class_284;
import com.google.android.gms.wearable.internal.d;
import java.util.List;

// $FF: renamed from: com.google.android.gms.wearable.internal.ak
public final class class_986 implements NodeApi {
   public PendingResult<Status> addListener(GoogleApiClient var1, NodeApi.NodeListener var2) {
      return var1.method_942(new class_986.class_1634(var1, var2, null));
   }

   public PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(final GoogleApiClient var1) {
      return var1.method_942(new class_203(var1) {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
         protected void method_1175(class_284 var1) throws RemoteException {
            var1.method_1818(this);
         }

         // $FF: renamed from: aK (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.NodeApi$GetConnectedNodesResult
         protected NodeApi.GetConnectedNodesResult method_1176(Status var1) {
            return new class_986.class_1635(var1, (List)null);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1176(var1);
         }
      });
   }

   public PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(final GoogleApiClient var1) {
      return var1.method_942(new class_203(var1) {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
         protected void method_1179(class_284 var1) throws RemoteException {
            var1.method_1817(this);
         }

         // $FF: renamed from: aJ (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.NodeApi$GetLocalNodeResult
         protected NodeApi.GetLocalNodeResult method_1180(Status var1) {
            return new class_986.class_1636(var1, (Node)null);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1180(var1);
         }
      });
   }

   public PendingResult<Status> removeListener(final GoogleApiClient var1, final NodeApi.NodeListener var2) {
      return var1.method_942(new class_203(var1) {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
         protected void method_1177(class_284 var1) throws RemoteException {
            var1.method_1813(this, var2);
         }

         // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
         public Status method_1178(Status var1) {
            return var1;
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         public Result method_1109(Status var1) {
            return this.method_1178(var1);
         }
      });
   }

   private static final class class_1634 extends d<Status> {
      private NodeApi.NodeListener axZ;

      private class_1634(GoogleApiClient var1, NodeApi.NodeListener var2) {
         super(var1);
         this.axZ = var2;
      }

      // $FF: synthetic method
      class_1634(GoogleApiClient var1, NodeApi.NodeListener var2, Object var3) {
         this(var1, var2);
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
      protected void method_1173(class_284 var1) throws RemoteException {
         var1.method_1809(this, this.axZ);
         this.axZ = null;
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1174(Status var1) {
         this.axZ = null;
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1174(var1);
      }
   }

   public static class class_1635 implements NodeApi.GetConnectedNodesResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_4283;
      private final List<Node> aya;

      public class_1635(Status var1, List<Node> var2) {
         this.field_4283 = var1;
         this.aya = var2;
      }

      public List<Node> getNodes() {
         return this.aya;
      }

      public Status getStatus() {
         return this.field_4283;
      }
   }

   public static class class_1636 implements NodeApi.GetLocalNodeResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_4285;
      private final Node ayb;

      public class_1636(Status var1, Node var2) {
         this.field_4285 = var1;
         this.ayb = var2;
      }

      public Node getNode() {
         return this.ayb;
      }

      public Status getStatus() {
         return this.field_4285;
      }
   }
}
