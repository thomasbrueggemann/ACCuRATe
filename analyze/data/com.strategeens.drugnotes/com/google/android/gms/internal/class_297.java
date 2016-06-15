package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_481;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.class_17;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.class_331;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.id;
import com.google.android.gms.internal.jl;

// $FF: renamed from: com.google.android.gms.internal.ib
public final class class_297 extends jl<id> {
   // $FF: renamed from: DZ java.lang.String
   private final String field_625;

   public class_297(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, String[] var6) {
      super(var1, var2, var3, var4, var6);
      this.field_625 = (String)class_335.method_2311(var5);
   }

   // $FF: renamed from: H (android.os.IBinder) com.google.android.gms.internal.id
   protected class_17 method_2022(IBinder var1) {
      return class_17.class_1397.method_3813(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_2023(BaseImplementation.class_1058<AppStateManager.StateListResult> var1) {
      try {
         ((class_17)this.hw()).method_113(new class_297.class_1252(var1));
      } catch (RemoteException var3) {
         Log.w("AppStateClient", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int) void
   public void method_2024(BaseImplementation.class_1058<AppStateManager.StateDeletedResult> var1, int var2) {
      try {
         ((class_17)this.hw()).method_118(new class_297.class_1250(var1), var2);
      } catch (RemoteException var4) {
         Log.w("AppStateClient", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, java.lang.String, byte[]) void
   public void method_2025(BaseImplementation.class_1058<AppStateManager.StateResult> var1, int var2, String var3, byte[] var4) {
      try {
         ((class_17)this.hw()).method_115(new class_297.class_1254(var1), var2, var3, var4);
      } catch (RemoteException var6) {
         Log.w("AppStateClient", "service died");
      }
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, int, byte[]) void
   public void method_2026(BaseImplementation.class_1058<AppStateManager.StateResult> param1, int param2, byte[] param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      var1.method_133(var2, 6587000, this.getContext().getPackageName(), this.field_625, this.hv());
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_2027(BaseImplementation.class_1058<Status> var1) {
      try {
         ((class_17)this.hw()).method_117(new class_297.class_1256(var1));
      } catch (RemoteException var3) {
         Log.w("AppStateClient", "service died");
      }
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, int) void
   public void method_2028(BaseImplementation.class_1058<AppStateManager.StateResult> var1, int var2) {
      try {
         ((class_17)this.hw()).method_114(new class_297.class_1254(var1), var2);
      } catch (RemoteException var4) {
         Log.w("AppStateClient", "service died");
      }
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.gms.appstate.service.START";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.appstate.internal.IAppStateService";
   }

   // $FF: renamed from: c (java.lang.String[]) void
   protected void method_1796(String... var1) {
      int var2 = 0;

      boolean var3;
      for(var3 = false; var2 < var1.length; ++var2) {
         if(var1[var2].equals("https://www.googleapis.com/auth/appstate")) {
            var3 = true;
         }
      }

      class_335.method_2302(var3, String.format("App State APIs requires %s to function.", new Object[]{"https://www.googleapis.com/auth/appstate"}));
   }

   // $FF: renamed from: fL () int
   public int method_2029() {
      try {
         int var3 = ((class_17)this.hw()).method_120();
         return var3;
      } catch (RemoteException var4) {
         Log.w("AppStateClient", "service died");
         return 2;
      }
   }

   // $FF: renamed from: fM () int
   public int method_2030() {
      try {
         int var3 = ((class_17)this.hw()).method_121();
         return var3;
      } catch (RemoteException var4) {
         Log.w("AppStateClient", "service died");
         return 2;
      }
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_2022(var1);
   }

   private static final class class_1250 extends class_331 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<AppStateManager.StateDeletedResult> field_888;

      public class_1250(BaseImplementation.class_1058<AppStateManager.StateDeletedResult> var1) {
         this.field_888 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Result holder must not be null");
      }

      // $FF: renamed from: e (int, int) void
      public void method_125(int var1, int var2) {
         Status var3 = new Status(var1);
         this.field_888.method_110(new class_297.class_1251(var3, var2));
      }
   }

   private static final class class_1251 implements AppStateManager.StateDeletedResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_3460;
      // $FF: renamed from: Ec int
      private final int field_3461;

      public class_1251(Status var1, int var2) {
         this.field_3460 = var1;
         this.field_3461 = var2;
      }

      public int getStateKey() {
         return this.field_3461;
      }

      public Status getStatus() {
         return this.field_3460;
      }
   }

   private static final class class_1252 extends class_331 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<AppStateManager.StateListResult> field_887;

      public class_1252(BaseImplementation.class_1058<AppStateManager.StateListResult> var1) {
         this.field_887 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Result holder must not be null");
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder) void
      public void method_124(DataHolder var1) {
         this.field_887.method_110(new class_297.class_1253(var1));
      }
   }

   private static final class class_1253 extends class_481 implements AppStateManager.StateListResult {
      // $FF: renamed from: Ed com.google.android.gms.appstate.AppStateBuffer
      private final AppStateBuffer field_1680;

      public class_1253(DataHolder var1) {
         super(var1);
         this.field_1680 = new AppStateBuffer(var1);
      }

      public AppStateBuffer getStateBuffer() {
         return this.field_1680;
      }
   }

   private static final class class_1254 extends class_331 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<AppStateManager.StateResult> field_886;

      public class_1254(BaseImplementation.class_1058<AppStateManager.StateResult> var1) {
         this.field_886 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Result holder must not be null");
      }

      // $FF: renamed from: a (int, com.google.android.gms.common.data.DataHolder) void
      public void method_123(int var1, DataHolder var2) {
         this.field_886.method_110(new class_297.class_1255(var1, var2));
      }
   }

   private static final class class_1255 extends class_481 implements AppStateManager.StateConflictResult, AppStateManager.StateLoadedResult, AppStateManager.StateResult {
      // $FF: renamed from: Ec int
      private final int field_1678;
      // $FF: renamed from: Ed com.google.android.gms.appstate.AppStateBuffer
      private final AppStateBuffer field_1679;

      public class_1255(int var1, DataHolder var2) {
         super(var2);
         this.field_1678 = var1;
         this.field_1679 = new AppStateBuffer(var2);
      }

      // $FF: renamed from: fN () boolean
      private boolean method_3031() {
         return this.Eb.getStatusCode() == 2000;
      }

      public AppStateManager.StateConflictResult getConflictResult() {
         return this.method_3031()?this:null;
      }

      public AppStateManager.StateLoadedResult getLoadedResult() {
         if(this.method_3031()) {
            this = null;
         }

         return this;
      }

      public byte[] getLocalData() {
         return this.field_1679.getCount() == 0?null:this.field_1679.get(0).getLocalData();
      }

      public String getResolvedVersion() {
         return this.field_1679.getCount() == 0?null:this.field_1679.get(0).getConflictVersion();
      }

      public byte[] getServerData() {
         return this.field_1679.getCount() == 0?null:this.field_1679.get(0).getConflictData();
      }

      public int getStateKey() {
         return this.field_1678;
      }

      public void release() {
         this.field_1679.release();
      }
   }

   private static final class class_1256 extends class_331 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Status> field_885;

      public class_1256(BaseImplementation.class_1058<Status> var1) {
         this.field_885 = (BaseImplementation.class_1058)class_335.method_2306(var1, "Holder must not be null");
      }

      // $FF: renamed from: fK () void
      public void method_126() {
         Status var1 = new Status(0);
         this.field_885.method_110(var1);
      }
   }
}
