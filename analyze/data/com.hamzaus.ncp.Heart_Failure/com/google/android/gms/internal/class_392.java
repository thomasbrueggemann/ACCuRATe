package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.internal.class_240;
import com.google.android.gms.internal.class_36;
import com.google.android.gms.internal.class_38;
import com.google.android.gms.internal.class_386;
import com.google.android.gms.internal.class_404;
import com.google.android.gms.internal.fs;
import com.google.android.gms.internal.fx;
import com.google.android.gms.internal.fy;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.fz
public final class class_392 implements AppIndexApi, class_36 {
   // $FF: renamed from: a (java.lang.String, android.net.Uri) android.net.Uri
   static Uri method_2473(String var0, Uri var1) {
      if(!"android-app".equals(var1.getScheme())) {
         throw new IllegalArgumentException("Uri scheme must be android-app: " + var1);
      } else if(!var0.equals(var1.getHost())) {
         throw new IllegalArgumentException("Uri host must match package name: " + var1);
      } else {
         List var2 = var1.getPathSegments();
         if(!var2.isEmpty() && !((String)var2.get(0)).isEmpty()) {
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
            return var4.build();
         } else {
            throw new IllegalArgumentException("Uri path must exist: " + var1);
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.internal.fs[]) com.google.android.gms.common.api.PendingResult
   public PendingResult<Status> method_2474(GoogleApiClient var1, final fs... var2) {
      return var1.method_772(new class_392.class_1259(null) {
         // $FF: renamed from: yt java.lang.String
         // $FF: synthetic field
         final String field_54;

         {
            this.field_54 = var2x;
         }

         // $FF: renamed from: a (com.google.android.gms.internal.fv) void
         protected void method_918(class_38 var1) throws RemoteException {
            var1.method_196(new class_392.class_1260(this), this.field_54, var2);
         }
      });
   }

   public PendingResult<Status> view(GoogleApiClient var1, Activity var2, Intent var3, String var4, Uri var5, List<AppIndexApi.AppIndexingLink> var6) {
      String var7 = ((class_240)var1.method_771(class_404.field_1785)).getContext().getPackageName();
      class_386[] var8 = new class_386[]{new class_386(var7, var3, var4, var5, (String)null, var6)};
      return this.method_2474(var1, var8);
   }

   public PendingResult<Status> view(GoogleApiClient var1, Activity var2, Uri var3, String var4, Uri var5, List<AppIndexApi.AppIndexingLink> var6) {
      return this.view(var1, var2, new Intent("android.intent.action.VIEW", method_2473(((class_240)var1.method_771(class_404.field_1785)).getContext().getPackageName(), var3)), var4, var5, var6);
   }

   public PendingResult<Status> viewEnd(GoogleApiClient var1, Activity var2, Intent var3) {
      return this.method_2474(var1, new class_386[]{new class_386(class_386.method_2458(((class_240)var1.method_771(class_404.field_1785)).getContext().getPackageName(), var3), System.currentTimeMillis(), 3)});
   }

   public PendingResult<Status> viewEnd(GoogleApiClient var1, Activity var2, Uri var3) {
      return this.viewEnd(var1, var2, new Intent("android.intent.action.VIEW", method_2473(((class_240)var1.method_771(class_404.field_1785)).getContext().getPackageName(), var3)));
   }

   private abstract static class class_1256<T> implements Result {
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_4197;
      // $FF: renamed from: yx java.lang.Object
      protected final T field_4198;

      public class_1256(Status var1, T var2) {
         this.field_4197 = var1;
         this.field_4198 = var2;
      }

      public Status getStatus() {
         return this.field_4197;
      }
   }

   static class class_1257 extends class_392.class_1256<ParcelFileDescriptor> implements class_36.class_1068 {
      public class_1257(Status var1, ParcelFileDescriptor var2) {
         super(var1, var2);
      }
   }

   private abstract static class class_1258<T extends Result> extends class_797.class_1203<T, fy> {
      public class_1258() {
         super(class_404.field_1785);
      }

      // $FF: renamed from: a (com.google.android.gms.internal.fv) void
      protected abstract void method_918(class_38 var1) throws RemoteException;

      // $FF: renamed from: a (com.google.android.gms.internal.fy) void
      protected final void method_919(class_240 var1) throws RemoteException {
         this.method_918(var1.method_1650());
      }
   }

   private abstract static class class_1259<T extends Result> extends class_392.class_1258<Status> {
      private class_1259() {
      }

      // $FF: synthetic method
      class_1259(Object var1) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      protected Result method_884(Status var1) {
         return this.method_921(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      protected Status method_921(Status var1) {
         return var1;
      }
   }

   private static final class class_1260 extends fx<Status> {
      public class_1260(class_797.class_1206<Status> var1) {
         super(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
      public void method_192(Status var1) {
         this.yr.method_673(var1);
      }
   }
}
