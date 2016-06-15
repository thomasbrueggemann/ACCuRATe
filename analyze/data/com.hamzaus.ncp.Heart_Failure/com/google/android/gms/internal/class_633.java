package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.internal.class_131;
import com.google.android.gms.internal.class_132;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_630;
import com.google.android.gms.internal.class_631;
import com.google.android.gms.internal.kh;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;

// $FF: renamed from: com.google.android.gms.internal.kg
public class class_633 implements PanoramaApi {
   // $FF: renamed from: a (android.content.Context, android.net.Uri) void
   private static void method_3627(Context var0, Uri var1) {
      var0.revokeUriPermission(var1, 1);
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.kf, com.google.android.gms.internal.ke, android.net.Uri, android.os.Bundle) void
   private static void method_3628(final Context var0, class_132 var1, final class_131 var2, final Uri var3, Bundle var4) throws RemoteException {
      var0.grantUriPermission("com.google.android.gms", var3, 1);
      class_131.class_1005 var5 = new class_131.class_1005() {
         // $FF: renamed from: a (int, android.os.Bundle, int, android.content.Intent) void
         public void method_696(int var1, Bundle var2x, int var3x, Intent var4) throws RemoteException {
            class_633.method_3627(var0, var3);
            var2.method_696(var1, var2x, var3x, var4);
         }
      };

      try {
         var1.method_697(var5, var3, var4, true);
      } catch (RemoteException var8) {
         method_3627(var0, var3);
         throw var8;
      } catch (RuntimeException var9) {
         method_3627(var0, var3);
         throw var9;
      }
   }

   public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient var1, final Uri var2) {
      return var1.method_772(new class_633.class_992(null) {
         // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.kf) void
         protected void method_1003(Context var1, class_132 var2x) throws RemoteException {
            var2x.method_697(new class_633.class_995(this), var2, (Bundle)null, false);
         }
      });
   }

   public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient var1, final Uri var2) {
      return var1.method_772(new class_633.class_992(null) {
         // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.kf) void
         protected void method_1003(Context var1, class_132 var2x) throws RemoteException {
            class_633.method_3628(var1, var2x, new class_633.class_995(this), var2, (Bundle)null);
         }
      });
   }

   private static final class class_991 extends class_131.class_1005 {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<PanoramaApi.class_1201> field_2773;

      public class_991(class_797.class_1206<PanoramaApi.class_1201> var1) {
         this.field_2773 = var1;
      }

      // $FF: renamed from: a (int, android.os.Bundle, int, android.content.Intent) void
      public void method_696(int var1, Bundle var2, int var3, Intent var4) {
         PendingIntent var5;
         if(var2 != null) {
            var5 = (PendingIntent)var2.getParcelable("pendingIntent");
         } else {
            var5 = null;
         }

         Status var6 = new Status(var1, (String)null, var5);
         this.field_2773.method_673(new class_631(var6, var4, var3));
      }
   }

   private abstract static class class_992 extends class_633.class_990<PanoramaApi.PanoramaResult> {
      private class_992() {
      }

      // $FF: synthetic method
      class_992(Object var1) {
         this();
      }

      // $FF: renamed from: ak (com.google.android.gms.common.api.Status) com.google.android.gms.panorama.PanoramaApi$PanoramaResult
      protected PanoramaApi.PanoramaResult method_1006(Status var1) {
         return new class_630(var1, (Intent)null);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      protected Result method_884(Status var1) {
         return this.method_1006(var1);
      }
   }

   private static final class class_995 extends class_131.class_1005 {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<PanoramaApi.PanoramaResult> field_2772;

      public class_995(class_797.class_1206<PanoramaApi.PanoramaResult> var1) {
         this.field_2772 = var1;
      }

      // $FF: renamed from: a (int, android.os.Bundle, int, android.content.Intent) void
      public void method_696(int var1, Bundle var2, int var3, Intent var4) {
         PendingIntent var5;
         if(var2 != null) {
            var5 = (PendingIntent)var2.getParcelable("pendingIntent");
         } else {
            var5 = null;
         }

         Status var6 = new Status(var1, (String)null, var5);
         this.field_2772.method_673(new class_630(var6, var4));
      }
   }

   private abstract static class class_990<R extends Result> extends class_797.class_1203<R, kh> {
      protected class_990() {
         super(Panorama.field_4144);
      }

      // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.kf) void
      protected abstract void method_1003(Context var1, class_132 var2) throws RemoteException;

      // $FF: renamed from: a (com.google.android.gms.internal.kh) void
      protected final void method_1004(class_237 var1) throws RemoteException {
         this.method_1003(var1.getContext(), (class_132)var1.fo());
      }
   }
}
