package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.class_16;
import com.google.android.gms.internal.class_17;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.iz;

// $FF: renamed from: com.google.android.gms.internal.ix
public class class_244 extends hc<iz> {
   // $FF: renamed from: UD com.google.android.gms.internal.ix$a
   private class_244.class_926 field_804;
   private final int mTheme;
   // $FF: renamed from: oe android.app.Activity
   private Activity field_805;
   // $FF: renamed from: yN java.lang.String
   private final String field_806;

   public class_244(Activity var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, int var6) {
      super(var1, var2, var3, var4, new String[0]);
      this.field_806 = var5;
      this.field_805 = var1;
      this.mTheme = var6;
   }

   // $FF: renamed from: a (com.google.android.gms.identity.intents.UserAddressRequest, int) void
   public void method_1701(UserAddressRequest var1, int var2) {
      this.method_1704();
      this.field_804 = new class_244.class_926(var2, this.field_805);

      try {
         Bundle var3 = new Bundle();
         var3.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", this.getContext().getPackageName());
         if(!TextUtils.isEmpty(this.field_806)) {
            var3.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.field_806, "com.google"));
         }

         var3.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
         this.method_1703().method_70(this.field_804, var1, var3);
      } catch (RemoteException var7) {
         Log.e("AddressClientImpl", "Exception requesting user address", var7);
         Bundle var6 = new Bundle();
         var6.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
         this.field_804.method_69(1, var6);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hj, com.google.android.gms.internal.hc$e) void
   protected void method_1448(class_31 var1, class_234.class_911 var2) throws RemoteException {
      var1.method_168(var2, 5077000, this.getContext().getPackageName());
   }

   // $FF: renamed from: an (android.os.IBinder) com.google.android.gms.internal.iz
   protected class_17 method_1702(IBinder var1) {
      return class_17.class_1033.method_4299(var1);
   }

   // $FF: renamed from: bp () java.lang.String
   protected String method_1451() {
      return "com.google.android.gms.identity.service.BIND";
   }

   // $FF: renamed from: bq () java.lang.String
   protected String method_1452() {
      return "com.google.android.gms.identity.intents.internal.IAddressService";
   }

   public void disconnect() {
      super.disconnect();
      if(this.field_804 != null) {
         this.field_804.setActivity((Activity)null);
         this.field_804 = null;
      }

   }

   // $FF: renamed from: iO () com.google.android.gms.internal.iz
   protected class_17 method_1703() {
      return (class_17)super.method_1455();
   }

   // $FF: renamed from: iP () void
   protected void method_1704() {
      super.method_1453();
   }

   // $FF: renamed from: x (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1456(IBinder var1) {
      return this.method_1702(var1);
   }

   public static final class class_926 extends class_16.class_1085 {
      // $FF: renamed from: FT int
      private final int field_3562;
      // $FF: renamed from: oe android.app.Activity
      private Activity field_3563;

      public class_926(int var1, Activity var2) {
         this.field_3562 = var1;
         this.field_3563 = var2;
      }

      private void setActivity(Activity var1) {
         this.field_3563 = var1;
      }

      // $FF: renamed from: g (int, android.os.Bundle) void
      public void method_69(int param1, Bundle param2) {
         // $FF: Couldn't be decompiled
      }
   }
}
