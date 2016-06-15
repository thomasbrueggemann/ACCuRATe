package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_163;
import com.google.android.gms.internal.class_164;
import com.google.android.gms.internal.class_286;
import com.google.android.gms.internal.class_810;
import com.google.android.gms.internal.om;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;

// $FF: renamed from: com.google.android.gms.internal.ol
public class class_811 implements PanoramaApi {
   // $FF: renamed from: a (android.content.Context, android.net.Uri) void
   private static void method_4455(Context var0, Uri var1) {
      var0.revokeUriPermission(var1, 1);
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.ok, com.google.android.gms.internal.oj, android.net.Uri, android.os.Bundle) void
   private static void method_4456(final Context var0, class_163 var1, final class_164 var2, final Uri var3, Bundle var4) throws RemoteException {
      var0.grantUriPermission("com.google.android.gms", var3, 1);
      class_164.class_1281 var5 = new class_164.class_1281() {
         // $FF: renamed from: a (int, android.os.Bundle, int, android.content.Intent) void
         public void method_837(int var1, Bundle var2x, int var3x, Intent var4) throws RemoteException {
            class_811.method_4455(var0, var3);
            var2.method_837(var1, var2x, var3x, var4);
         }
      };

      try {
         var1.method_836(var5, var3, var4, true);
      } catch (RemoteException var8) {
         method_4455(var0, var3);
         throw var8;
      } catch (RuntimeException var9) {
         method_4455(var0, var3);
         throw var9;
      }
   }

   public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(final GoogleApiClient var1, final Uri var2) {
      return var1.method_942(new class_811.class_1697(var1) {
         // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.ok) void
         protected void method_1258(Context var1, class_163 var2x) throws RemoteException {
            var2x.method_836(new class_811.class_1698(this), var2, (Bundle)null, false);
         }
      });
   }

   public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(final GoogleApiClient var1, final Uri var2) {
      return var1.method_942(new class_811.class_1697(var1) {
         // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.ok) void
         protected void method_1258(Context var1, class_163 var2x) throws RemoteException {
            class_811.method_4456(var1, var2x, new class_811.class_1698(this), var2, (Bundle)null);
         }
      });
   }

   private abstract static class class_1697 extends class_811.class_1699<PanoramaApi.PanoramaResult> {
      public class_1697(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: ay (com.google.android.gms.common.api.Status) com.google.android.gms.panorama.PanoramaApi$PanoramaResult
      protected PanoramaApi.PanoramaResult method_1260(Status var1) {
         return new class_810(var1, (Intent)null);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      protected Result method_1109(Status var1) {
         return this.method_1260(var1);
      }
   }

   private static final class class_1698 extends class_164.class_1281 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<PanoramaApi.PanoramaResult> field_1887;

      public class_1698(BaseImplementation.class_1058<PanoramaApi.PanoramaResult> var1) {
         this.field_1887 = var1;
      }

      // $FF: renamed from: a (int, android.os.Bundle, int, android.content.Intent) void
      public void method_837(int var1, Bundle var2, int var3, Intent var4) {
         PendingIntent var5;
         if(var2 != null) {
            var5 = (PendingIntent)var2.getParcelable("pendingIntent");
         } else {
            var5 = null;
         }

         Status var6 = new Status(var1, (String)null, var5);
         this.field_1887.method_110(new class_810(var6, var4));
      }
   }

   private abstract static class class_1699<R extends Result> extends BaseImplementation.class_1057<R, om> {
      protected class_1699(GoogleApiClient var1) {
         super(Panorama.field_4292, var1);
      }

      // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.ok) void
      protected abstract void method_1258(Context var1, class_163 var2) throws RemoteException;

      // $FF: renamed from: a (com.google.android.gms.internal.om) void
      protected final void method_1259(class_286 var1) throws RemoteException {
         this.method_1258(var1.getContext(), (class_163)var1.hw());
      }
   }
}
