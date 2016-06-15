package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.class_149;
import com.google.android.gms.internal.class_152;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.my;

// $FF: renamed from: com.google.android.gms.internal.mw
public class class_289 extends jl<my> {
   // $FF: renamed from: DZ java.lang.String
   private final String field_608;
   private class_289.class_1241 afJ;
   private final int mTheme;
   // $FF: renamed from: nB android.app.Activity
   private Activity field_609;

   public class_289(Activity var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, int var6) {
      super(var1, var2, var3, var4, new String[0]);
      this.field_608 = var5;
      this.field_609 = var1;
      this.mTheme = var6;
   }

   // $FF: renamed from: a (com.google.android.gms.identity.intents.UserAddressRequest, int) void
   public void method_1846(UserAddressRequest var1, int var2) {
      this.method_1849();
      this.afJ = new class_289.class_1241(var2, this.field_609);

      try {
         Bundle var3 = new Bundle();
         var3.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", this.getContext().getPackageName());
         if(!TextUtils.isEmpty(this.field_608)) {
            var3.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.field_608, "com.google"));
         }

         var3.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
         this.method_1848().method_815(this.afJ, var1, var3);
      } catch (RemoteException var7) {
         Log.e("AddressClientImpl", "Exception requesting user address", var7);
         Bundle var6 = new Bundle();
         var6.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
         this.afJ.method_811(1, var6);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      var1.method_144(var2, 6587000, this.getContext().getPackageName());
   }

   // $FF: renamed from: aI (android.os.IBinder) com.google.android.gms.internal.my
   protected class_152 method_1847(IBinder var1) {
      return class_152.class_1440.method_4128(var1);
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.gms.identity.service.BIND";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.identity.intents.internal.IAddressService";
   }

   public void disconnect() {
      super.disconnect();
      if(this.afJ != null) {
         this.afJ.setActivity((Activity)null);
         this.afJ = null;
      }

   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_1847(var1);
   }

   // $FF: renamed from: nd () com.google.android.gms.internal.my
   protected class_152 method_1848() throws DeadObjectException {
      return (class_152)super.method_1799();
   }

   // $FF: renamed from: ne () void
   protected void method_1849() {
      super.method_1797();
   }

   public static final class class_1241 extends class_149.class_1085 {
      // $FF: renamed from: My int
      private final int field_739;
      // $FF: renamed from: nB android.app.Activity
      private Activity field_740;

      public class_1241(int var1, Activity var2) {
         this.field_739 = var1;
         this.field_740 = var2;
      }

      private void setActivity(Activity var1) {
         this.field_740 = var1;
      }

      // $FF: renamed from: g (int, android.os.Bundle) void
      public void method_811(int param1, Bundle param2) {
         // $FF: Couldn't be decompiled
      }
   }
}
