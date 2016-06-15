package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_26;
import com.google.android.gms.internal.class_27;
import com.google.android.gms.internal.class_296;
import com.google.android.gms.internal.class_385;
import com.google.android.gms.internal.class_386;
import com.google.android.gms.internal.class_399;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.hw;
import com.google.android.gms.internal.hx;
import com.google.android.gms.internal.hz;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.hz
public final class class_384 implements AppIndexApi, class_26 {
   // $FF: renamed from: a (java.lang.String, android.net.Uri) android.content.Intent
   public static Intent method_2637(String var0, Uri var1) {
      method_2638(var0, var1);
      List var2 = var1.getPathSegments();
      String var3 = (String)var2.get(0);
      Builder var4 = new Builder();
      var4.scheme(var3);
      if(var2.size() > 1) {
         var4.authority((String)var2.get(1));

         for(int var9 = 2; var9 < var2.size(); ++var9) {
            var4.appendPath((String)var2.get(var9));
         }
      }

      var4.encodedQuery(var1.getEncodedQuery());
      var4.encodedFragment(var1.getEncodedFragment());
      return new Intent("android.intent.action.VIEW", var4.build());
   }

   // $FF: renamed from: b (java.lang.String, android.net.Uri) void
   private static void method_2638(String var0, Uri var1) {
      if(!"android-app".equals(var1.getScheme())) {
         throw new IllegalArgumentException("AppIndex: The URI scheme must be \'android-app\' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + var1);
      } else {
         String var2 = var1.getHost();
         if(var0 != null && !var0.equals(var2)) {
            throw new IllegalArgumentException("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + var1);
         } else {
            List var3 = var1.getPathSegments();
            if(var3.isEmpty() || ((String)var3.get(0)).isEmpty()) {
               throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + var1);
            }
         }
      }
   }

   // $FF: renamed from: c (java.util.List) void
   public static void method_2639(List<AppIndexApi.AppIndexingLink> var0) {
      if(var0 != null) {
         Iterator var1 = var0.iterator();

         while(var1.hasNext()) {
            method_2638((String)null, ((AppIndexApi.AppIndexingLink)var1.next()).appIndexingUrl);
         }
      }

   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.internal.hr[]) com.google.android.gms.common.api.PendingResult
   public PendingResult<Status> method_2640(final GoogleApiClient var1, final hr... var2) {
      return var1.method_942(new class_384.class_1472(var1) {
         // $FF: renamed from: DB java.lang.String
         // $FF: synthetic field
         final String field_100;

         {
            this.field_100 = var3;
         }

         // $FF: renamed from: a (com.google.android.gms.internal.hu) void
         protected void method_1170(class_27 var1) throws RemoteException {
            var1.method_183(new class_384.class_1471(this), this.field_100, var2);
         }
      });
   }

   public AppIndexApi.ActionResult action(GoogleApiClient var1, Action var2) {
      String var3 = ((class_296)var1.method_941(class_399.field_1235)).getContext().getPackageName();
      long var4 = System.currentTimeMillis();
      String var6 = String.valueOf(var4);
      class_386[] var7 = new class_386[]{class_385.method_2653(var2, var6, var4, var3, 0)};
      return new class_384.class_1474(this, this.method_2640(var1, var7), var2, var6);
   }

   public PendingResult<Status> view(GoogleApiClient var1, Activity var2, Intent var3, String var4, Uri var5, List<AppIndexApi.AppIndexingLink> var6) {
      String var7 = ((class_296)var1.method_941(class_399.field_1235)).getContext().getPackageName();
      method_2639(var6);
      class_386[] var8 = new class_386[]{new class_386(var7, var3, var4, var5, (String)null, var6)};
      return this.method_2640(var1, var8);
   }

   public PendingResult<Status> view(GoogleApiClient var1, Activity var2, Uri var3, String var4, Uri var5, List<AppIndexApi.AppIndexingLink> var6) {
      String var7 = ((class_296)var1.method_941(class_399.field_1235)).getContext().getPackageName();
      method_2638(var7, var3);
      return this.view(var1, var2, method_2637(var7, var3), var4, var5, var6);
   }

   public PendingResult<Status> viewEnd(GoogleApiClient var1, Activity var2, Intent var3) {
      return this.method_2640(var1, new class_386[]{new class_386(class_386.method_2657(((class_296)var1.method_941(class_399.field_1235)).getContext().getPackageName(), var3), System.currentTimeMillis(), 3)});
   }

   public PendingResult<Status> viewEnd(GoogleApiClient var1, Activity var2, Uri var3) {
      return this.viewEnd(var1, var2, method_2637(((class_296)var1.method_941(class_399.field_1235)).getContext().getPackageName(), var3));
   }

   private static final class class_1474 implements AppIndexApi.ActionResult {
      // $FF: renamed from: DE com.google.android.gms.internal.hz
      private class_384 field_2916;
      // $FF: renamed from: DF com.google.android.gms.common.api.PendingResult
      private PendingResult<Status> field_2917;
      // $FF: renamed from: DG com.google.android.gms.appindexing.Action
      private Action field_2918;
      // $FF: renamed from: DH java.lang.String
      private String field_2919;

      class_1474(hz var1, PendingResult<Status> var2, Action var3, String var4) {
         this.field_2916 = var1;
         this.field_2917 = var2;
         this.field_2918 = var3;
         this.field_2919 = var4;
      }

      public PendingResult<Status> end(GoogleApiClient var1) {
         String var2 = ((class_296)var1.method_941(class_399.field_1235)).getContext().getPackageName();
         long var3 = System.currentTimeMillis();
         class_386 var5 = class_385.method_2653(this.field_2918, this.field_2919, var3, var2, 3);
         return this.field_2916.method_2640(var1, new class_386[]{var5});
      }

      public PendingResult<Status> getPendingResult() {
         return this.field_2917;
      }
   }

   private abstract static class class_1473<T extends Result> extends BaseImplementation.class_1057<T, hx> {
      public class_1473(GoogleApiClient var1) {
         super(class_399.field_1235, var1);
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hu) void
      protected abstract void method_1170(class_27 var1) throws RemoteException;

      // $FF: renamed from: a (com.google.android.gms.internal.hx) void
      protected final void method_1171(class_296 var1) throws RemoteException {
         this.method_1170(var1.method_2021());
      }
   }

   private abstract static class class_1472<T extends Result> extends class_384.class_1473<Status> {
      class_1472(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      protected Status method_1172(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      protected Result method_1109(Status var1) {
         return this.method_1172(var1);
      }
   }

   private static final class class_1471 extends hw<Status> {
      public class_1471(BaseImplementation.class_1058<Status> var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
      public void method_177(Status var1) {
         this.DA.method_110(var1);
      }
   }
}
