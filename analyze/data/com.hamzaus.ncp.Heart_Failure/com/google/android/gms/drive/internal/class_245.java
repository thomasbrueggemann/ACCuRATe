package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.DisconnectRequest;
import com.google.android.gms.drive.internal.aa;
import com.google.android.gms.drive.internal.class_154;
import com.google.android.gms.drive.internal.x;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.class_323;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.hc;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.drive.internal.r
public class class_245 extends hc<aa> {
   // $FF: renamed from: IN java.lang.String
   private final String field_807;
   // $FF: renamed from: IO android.os.Bundle
   private final Bundle field_808;
   // $FF: renamed from: IP com.google.android.gms.drive.DriveId
   private DriveId field_809;
   // $FF: renamed from: IQ com.google.android.gms.drive.DriveId
   private DriveId field_810;
   // $FF: renamed from: IR com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
   final GoogleApiClient.ConnectionCallbacks field_811;
   // $FF: renamed from: IS java.util.Map
   Map<DriveId, Map<DriveEvent.Listener<?>, x<?>>> field_812 = new HashMap();
   // $FF: renamed from: yN java.lang.String
   private final String field_813;

   public class_245(Context var1, Looper var2, class_323 var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, String[] var6, Bundle var7) {
      super(var1, var2, var4, var5, var6);
      this.field_813 = (String)class_347.method_2166(var3.method_2055(), "Must call Api.ClientBuilder.setAccountName()");
      this.field_807 = var3.method_2059();
      this.field_811 = var4;
      this.field_808 = var7;
   }

   // $FF: renamed from: O (android.os.IBinder) com.google.android.gms.drive.internal.aa
   protected class_154 method_1705(IBinder var1) {
      return class_154.class_856.method_3459(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.DriveId, int, com.google.android.gms.drive.events.DriveEvent$Listener) com.google.android.gms.common.api.PendingResult
   <C extends DriveEvent> PendingResult<Status> method_1706(GoogleApiClient param1, DriveId param2, int param3, DriveEvent.Listener<C> param4) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
   protected void method_1446(int var1, IBinder var2, Bundle var3) {
      if(var3 != null) {
         var3.setClassLoader(this.getClass().getClassLoader());
         this.field_809 = (DriveId)var3.getParcelable("com.google.android.gms.drive.root_id");
         this.field_810 = (DriveId)var3.getParcelable("com.google.android.gms.drive.appdata_id");
      }

      super.method_1446(var1, var2, var3);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hj, com.google.android.gms.internal.hc$e) void
   protected void method_1448(class_31 var1, class_234.class_911 var2) throws RemoteException {
      String var3 = this.getContext().getPackageName();
      class_347.method_2170(var2);
      class_347.method_2170(var3);
      class_347.method_2170(this.fn());
      Bundle var7 = new Bundle();
      var7.putString("proxy_package_name", this.field_807);
      var7.putAll(this.field_808);
      var1.method_162(var2, 5077000, var3, this.fn(), this.field_813, var7);
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.drive.DriveId, int, com.google.android.gms.drive.events.DriveEvent$Listener) com.google.android.gms.common.api.PendingResult
   PendingResult<Status> method_1707(GoogleApiClient param1, DriveId param2, int param3, DriveEvent.Listener<?> param4) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bp () java.lang.String
   protected String method_1451() {
      return "com.google.android.gms.drive.ApiService.START";
   }

   // $FF: renamed from: bq () java.lang.String
   protected String method_1452() {
      return "com.google.android.gms.drive.internal.IDriveService";
   }

   public void disconnect() {
      class_154 var1 = (class_154)this.fo();
      if(var1 != null) {
         try {
            var1.method_848(new DisconnectRequest());
         } catch (RemoteException var3) {
            ;
         }
      }

      super.disconnect();
      this.field_812.clear();
   }

   // $FF: renamed from: gk () com.google.android.gms.drive.internal.aa
   public class_154 method_1708() {
      return (class_154)this.fo();
   }

   // $FF: renamed from: gl () com.google.android.gms.drive.DriveId
   public DriveId method_1709() {
      return this.field_809;
   }

   // $FF: renamed from: gm () com.google.android.gms.drive.DriveId
   public DriveId method_1710() {
      return this.field_810;
   }

   // $FF: renamed from: x (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1456(IBinder var1) {
      return this.method_1705(var1);
   }
}
