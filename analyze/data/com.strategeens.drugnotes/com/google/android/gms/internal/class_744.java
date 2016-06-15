package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_142;
import com.google.android.gms.internal.class_144;
import com.google.android.gms.internal.class_204;
import com.google.android.gms.internal.class_292;
import com.google.android.gms.internal.class_333;

// $FF: renamed from: com.google.android.gms.internal.ke
public final class class_744 implements class_144 {
   // $FF: renamed from: c (com.google.android.gms.common.api.GoogleApiClient) com.google.android.gms.common.api.PendingResult
   public PendingResult<Status> method_768(final GoogleApiClient var1) {
      return (new class_204.class_1201(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.kg) void
         protected void method_1206(class_292 var1) throws RemoteException {
            ((class_142)var1.hw()).method_766(new class_744.class_1522(this));
         }
      }).gE();
   }

   private static class class_1522 extends class_333 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Status> field_889;

      public class_1522(BaseImplementation.class_1058<Status> var1) {
         this.field_889 = var1;
      }

      // $FF: renamed from: aI (int) void
      public void method_767(int var1) throws RemoteException {
         this.field_889.method_110(new Status(var1));
      }
   }
}
