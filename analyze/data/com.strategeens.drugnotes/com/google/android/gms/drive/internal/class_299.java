package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.c;
import com.google.android.gms.drive.events.class_693;
import com.google.android.gms.drive.internal.AddEventListenerRequest;
import com.google.android.gms.drive.internal.CancelPendingActionsRequest;
import com.google.android.gms.drive.internal.DisconnectRequest;
import com.google.android.gms.drive.internal.RemoveEventListenerRequest;
import com.google.android.gms.drive.internal.aa;
import com.google.android.gms.drive.internal.ae;
import com.google.android.gms.drive.internal.class_190;
import com.google.android.gms.drive.internal.class_192;
import com.google.android.gms.drive.internal.class_205;
import com.google.android.gms.drive.internal.class_268;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.jl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.drive.internal.r
public class class_299 extends jl<ae> {
   // $FF: renamed from: DZ java.lang.String
   private final String field_651;
   // $FF: renamed from: JK java.lang.String
   private final String field_652;
   // $FF: renamed from: PK android.os.Bundle
   private final Bundle field_653;
   // $FF: renamed from: PL boolean
   private final boolean field_654;
   // $FF: renamed from: PM com.google.android.gms.drive.DriveId
   private DriveId field_655;
   // $FF: renamed from: PN com.google.android.gms.drive.DriveId
   private DriveId field_656;
   // $FF: renamed from: PO com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
   final GoogleApiClient.ConnectionCallbacks field_657;
   // $FF: renamed from: PP java.util.Map
   final Map<DriveId, Map<c, aa>> field_658 = new HashMap();

   public class_299(Context var1, Looper var2, class_347 var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, String[] var6, Bundle var7) {
      super(var1, var2, var4, var5, var6);
      this.field_651 = (String)class_335.method_2306(var3.method_2418(), "Must call Api.ClientBuilder.setAccountName()");
      this.field_652 = var3.method_2422();
      this.field_657 = var4;
      this.field_653 = var7;
      Intent var8 = new Intent("com.google.android.gms.drive.events.HANDLE_EVENT");
      var8.setPackage(var1.getPackageName());
      List var10 = var1.getPackageManager().queryIntentServices(var8, 0);
      switch(var10.size()) {
      case 0:
         this.field_654 = false;
         return;
      case 1:
         ServiceInfo var11 = ((ResolveInfo)var10.get(0)).serviceInfo;
         if(!var11.exported) {
            throw new IllegalStateException("Drive event service " + var11.name + " must be exported in AndroidManifest.xml");
         }

         this.field_654 = true;
         return;
      default:
         throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + var8.getAction() + " action");
      }
   }

   // $FF: renamed from: W (android.os.IBinder) com.google.android.gms.drive.internal.ae
   protected class_192 method_2070(IBinder var1) {
      return class_192.class_1224.method_5801(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.DriveId, int) com.google.android.gms.common.api.PendingResult
   PendingResult<Status> method_2071(final GoogleApiClient var1, final DriveId var2, final int var3) {
      class_335.method_2308(class_693.method_3965(var3, var2), "id");
      class_335.method_2302(this.isConnected(), "Client must be connected");
      if(!this.field_654) {
         throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
      } else {
         return var1.method_944(new class_205.class_1096(var1) {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1313(class_299 var1) throws RemoteException {
               var1.method_2075().method_1028(new AddEventListenerRequest(var2, var3), (class_190)null, (String)null, new class_268(this));
            }
         });
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.DriveId, int, com.google.android.gms.drive.events.c) com.google.android.gms.common.api.PendingResult
   PendingResult<Status> method_2072(GoogleApiClient param1, DriveId param2, int param3, c param4) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
   protected void method_1790(int var1, IBinder var2, Bundle var3) {
      if(var3 != null) {
         var3.setClassLoader(this.getClass().getClassLoader());
         this.field_655 = (DriveId)var3.getParcelable("com.google.android.gms.drive.root_id");
         this.field_656 = (DriveId)var3.getParcelable("com.google.android.gms.drive.appdata_id");
      }

      super.method_1790(var1, var2, var3);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      String var3 = this.getContext().getPackageName();
      class_335.method_2311(var2);
      class_335.method_2311(var3);
      class_335.method_2311(this.hv());
      Bundle var7 = new Bundle();
      if(!var3.equals(this.field_652)) {
         var7.putString("proxy_package_name", this.field_652);
      }

      var7.putAll(this.field_653);
      var1.method_137(var2, 6587000, var3, this.hv(), this.field_651, var7);
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.DriveId, int) com.google.android.gms.common.api.PendingResult
   PendingResult<Status> method_2073(final GoogleApiClient var1, final DriveId var2, final int var3) {
      class_335.method_2308(class_693.method_3965(var3, var2), "id");
      class_335.method_2302(this.isConnected(), "Client must be connected");
      return var1.method_944(new class_205.class_1096(var1) {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1312(class_299 var1) throws RemoteException {
            var1.method_2075().method_1045(new RemoveEventListenerRequest(var2, var3), (class_190)null, (String)null, new class_268(this));
         }
      });
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.DriveId, int, com.google.android.gms.drive.events.c) com.google.android.gms.common.api.PendingResult
   PendingResult<Status> method_2074(GoogleApiClient param1, DriveId param2, int param3, c param4) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.gms.drive.ApiService.START";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.drive.internal.IDriveService";
   }

   PendingResult<Status> cancelPendingActions(final GoogleApiClient var1, final List<String> var2) {
      boolean var3 = true;
      boolean var4;
      if(var2 != null) {
         var4 = var3;
      } else {
         var4 = false;
      }

      class_335.method_2301(var4);
      if(var2.isEmpty()) {
         var3 = false;
      }

      class_335.method_2301(var3);
      class_335.method_2302(this.isConnected(), "Client must be connected");
      return var1.method_944(new class_205.class_1096(var1) {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1314(class_299 var1) throws RemoteException {
            var1.method_2075().method_1030(new CancelPendingActionsRequest(var2), new class_268(this));
         }
      });
   }

   public void disconnect() {
      if(this.isConnected()) {
         try {
            ((class_192)this.hw()).method_1038(new DisconnectRequest());
         } catch (RemoteException var2) {
            ;
         }
      }

      super.disconnect();
      this.field_658.clear();
   }

   // $FF: renamed from: iG () com.google.android.gms.drive.internal.ae
   public class_192 method_2075() throws DeadObjectException {
      return (class_192)this.hw();
   }

   // $FF: renamed from: iH () com.google.android.gms.drive.DriveId
   public DriveId method_2076() {
      return this.field_655;
   }

   // $FF: renamed from: iI () com.google.android.gms.drive.DriveId
   public DriveId method_2077() {
      return this.field_656;
   }

   // $FF: renamed from: iJ () boolean
   public boolean method_2078() {
      return this.field_654;
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_2070(var1);
   }
}
