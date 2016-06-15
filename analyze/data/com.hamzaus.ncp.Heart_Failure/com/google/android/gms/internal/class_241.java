package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_442;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_28;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.gd;
import com.google.android.gms.internal.hc;

// $FF: renamed from: com.google.android.gms.internal.gb
public final class class_241 extends hc<gd> {
   // $FF: renamed from: yN java.lang.String
   private final String field_773;

   public class_241(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, String[] var6) {
      super(var1, var2, var3, var4, var6);
      this.field_773 = (String)class_347.method_2170(var5);
   }

   // $FF: renamed from: D (android.os.IBinder) com.google.android.gms.internal.gd
   protected class_28 method_1651(IBinder var1) {
      return class_28.class_1056.method_4461(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d) void
   public void method_1652(class_797.class_1206<AppStateManager.StateListResult> var1) {
      try {
         ((class_28)this.fo()).method_137(new class_241.class_921(var1));
      } catch (RemoteException var3) {
         Log.w("AppStateClient", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, int) void
   public void method_1653(class_797.class_1206<AppStateManager.StateDeletedResult> var1, int var2) {
      try {
         ((class_28)this.fo()).method_142(new class_241.class_919(var1), var2);
      } catch (RemoteException var4) {
         Log.w("AppStateClient", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, int, java.lang.String, byte[]) void
   public void method_1654(class_797.class_1206<AppStateManager.StateResult> var1, int var2, String var3, byte[] var4) {
      try {
         ((class_28)this.fo()).method_139(new class_241.class_923(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         Log.w("AppStateClient", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, int, byte[]) void
   public void method_1655(class_797.class_1206<AppStateManager.StateResult> param1, int param2, byte[] param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hj, com.google.android.gms.internal.hc$e) void
   protected void method_1448(class_31 var1, class_234.class_911 var2) throws RemoteException {
      var1.method_158(var2, 5077000, this.getContext().getPackageName(), this.field_773, this.fn());
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d) void
   public void method_1656(class_797.class_1206<Status> var1) {
      try {
         ((class_28)this.fo()).method_141(new class_241.class_925(var1));
      } catch (RemoteException var3) {
         Log.w("AppStateClient", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, int) void
   public void method_1657(class_797.class_1206<AppStateManager.StateResult> var1, int var2) {
      try {
         ((class_28)this.fo()).method_138(new class_241.class_923(var1), var2);
      } catch (RemoteException var4) {
         Log.w("AppStateClient", "service died");
      }
   }

   // $FF: renamed from: b (java.lang.String[]) void
   protected void method_1450(String... var1) {
      int var2 = 0;

      boolean var3;
      for(var3 = false; var2 < var1.length; ++var2) {
         if(var1[var2].equals("https://www.googleapis.com/auth/appstate")) {
            var3 = true;
         }
      }

      class_347.method_2161(var3, String.format("App State APIs requires %s to function.", new Object[]{"https://www.googleapis.com/auth/appstate"}));
   }

   // $FF: renamed from: bp () java.lang.String
   protected String method_1451() {
      return "com.google.android.gms.appstate.service.START";
   }

   // $FF: renamed from: bq () java.lang.String
   protected String method_1452() {
      return "com.google.android.gms.appstate.internal.IAppStateService";
   }

   // $FF: renamed from: dP () int
   public int method_1658() {
      try {
         int var3 = ((class_28)this.fo()).method_144();
         return var3;
      } catch (RemoteException var4) {
         Log.w("AppStateClient", "service died");
         return 2;
      }
   }

   // $FF: renamed from: dQ () int
   public int method_1659() {
      try {
         int var3 = ((class_28)this.fo()).method_145();
         return var3;
      } catch (RemoteException var4) {
         Log.w("AppStateClient", "service died");
         return 2;
      }
   }

   // $FF: renamed from: x (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1456(IBinder var1) {
      return this.method_1651(var1);
   }

   private static final class class_919 extends class_335 {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<AppStateManager.StateDeletedResult> field_1362;

      public class_919(class_797.class_1206<AppStateManager.StateDeletedResult> var1) {
         this.field_1362 = (class_797.class_1206)class_347.method_2166(var1, "Result holder must not be null");
      }

      // $FF: renamed from: b (int, int) void
      public void method_149(int var1, int var2) {
         Status var3 = new Status(var1);
         this.field_1362.method_673(new class_241.class_920(var3, var2));
      }
   }

   private static final class class_920 implements AppStateManager.StateDeletedResult {
      // $FF: renamed from: yP int
      private final int field_3735;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_3736;

      public class_920(Status var1, int var2) {
         this.field_3736 = var1;
         this.field_3735 = var2;
      }

      public int getStateKey() {
         return this.field_3735;
      }

      public Status getStatus() {
         return this.field_3736;
      }
   }

   private static final class class_921 extends class_335 {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<AppStateManager.StateListResult> field_1361;

      public class_921(class_797.class_1206<AppStateManager.StateListResult> var1) {
         this.field_1361 = (class_797.class_1206)class_347.method_2166(var1, "Result holder must not be null");
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder) void
      public void method_148(DataHolder var1) {
         this.field_1361.method_673(new class_241.class_922(var1));
      }
   }

   private static final class class_922 extends class_442 implements AppStateManager.StateListResult {
      // $FF: renamed from: yQ com.google.android.gms.appstate.AppStateBuffer
      private final AppStateBuffer field_2026;

      public class_922(DataHolder var1) {
         super(var1);
         this.field_2026 = new AppStateBuffer(var1);
      }

      public AppStateBuffer getStateBuffer() {
         return this.field_2026;
      }
   }

   private static final class class_923 extends class_335 {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<AppStateManager.StateResult> field_1360;

      public class_923(class_797.class_1206<AppStateManager.StateResult> var1) {
         this.field_1360 = (class_797.class_1206)class_347.method_2166(var1, "Result holder must not be null");
      }

      // $FF: renamed from: a (int, com.google.android.gms.common.data.DataHolder) void
      public void method_147(int var1, DataHolder var2) {
         this.field_1360.method_673(new class_241.class_924(var1, var2));
      }
   }

   private static final class class_924 extends class_442 implements AppStateManager.StateConflictResult, AppStateManager.StateLoadedResult, AppStateManager.StateResult {
      // $FF: renamed from: yP int
      private final int field_2024;
      // $FF: renamed from: yQ com.google.android.gms.appstate.AppStateBuffer
      private final AppStateBuffer field_2025;

      public class_924(int var1, DataHolder var2) {
         super(var2);
         this.field_2024 = var1;
         this.field_2025 = new AppStateBuffer(var2);
      }

      // $FF: renamed from: dR () boolean
      private boolean method_2678() {
         return this.yw.getStatusCode() == 2000;
      }

      public AppStateManager.StateConflictResult getConflictResult() {
         return this.method_2678()?this:null;
      }

      public AppStateManager.StateLoadedResult getLoadedResult() {
         if(this.method_2678()) {
            this = null;
         }

         return this;
      }

      public byte[] getLocalData() {
         return this.field_2025.getCount() == 0?null:this.field_2025.get(0).getLocalData();
      }

      public String getResolvedVersion() {
         return this.field_2025.getCount() == 0?null:this.field_2025.get(0).getConflictVersion();
      }

      public byte[] getServerData() {
         return this.field_2025.getCount() == 0?null:this.field_2025.get(0).getConflictData();
      }

      public int getStateKey() {
         return this.field_2024;
      }

      public void release() {
         this.field_2025.close();
      }
   }

   private static final class class_925 extends class_335 {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<Status> field_1359;

      public class_925(class_797.class_1206<Status> var1) {
         this.field_1359 = (class_797.class_1206)class_347.method_2166(var1, "Holder must not be null");
      }

      // $FF: renamed from: dO () void
      public void method_150() {
         Status var1 = new Status(0);
         this.field_1359.method_673(var1);
      }
   }
}
