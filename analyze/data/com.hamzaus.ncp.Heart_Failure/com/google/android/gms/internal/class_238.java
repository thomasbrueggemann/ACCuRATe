package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_124;
import com.google.android.gms.internal.class_127;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_612;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.ln;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

// $FF: renamed from: com.google.android.gms.internal.ls
public class class_238 extends hc<ln> {
   private final int ajY;
   private final int mTheme;
   // $FF: renamed from: oe android.app.Activity
   private final Activity field_754;
   // $FF: renamed from: yN java.lang.String
   private final String field_755;

   public class_238(Activity var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, int var5, String var6, int var7) {
      super(var1, var2, var3, var4, new String[0]);
      this.field_754 = var1;
      this.ajY = var5;
      this.field_755 = var6;
      this.mTheme = var7;
   }

   // $FF: renamed from: a (int, java.lang.String, java.lang.String, int) android.os.Bundle
   public static Bundle method_1491(int var0, String var1, String var2, int var3) {
      Bundle var4 = new Bundle();
      var4.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", var0);
      var4.putString("androidPackageName", var1);
      if(!TextUtils.isEmpty(var2)) {
         var4.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(var2, "com.google"));
      }

      var4.putInt("com.google.android.gms.wallet.EXTRA_THEME", var3);
      return var4;
   }

   // $FF: renamed from: nd () android.os.Bundle
   private Bundle method_1493() {
      return method_1491(this.ajY, this.field_754.getPackageName(), this.field_755, this.mTheme);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hj, com.google.android.gms.internal.hc$e) void
   protected void method_1448(class_31 var1, class_234.class_911 var2) throws RemoteException {
      var1.method_152(var2, 5077000);
   }

   // $FF: renamed from: a (com.google.android.gms.wallet.FullWalletRequest, int) void
   public void method_1494(FullWalletRequest var1, int var2) {
      class_238.class_916 var3 = new class_238.class_916(var2);
      Bundle var4 = this.method_1493();

      try {
         ((class_127)this.fo()).method_688(var1, var4, var3);
      } catch (RemoteException var6) {
         Log.e("WalletClientImpl", "RemoteException getting full wallet", var6);
         var3.method_679(8, (FullWallet)null, Bundle.EMPTY);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, int) void
   public void method_1495(MaskedWalletRequest var1, int var2) {
      Bundle var3 = this.method_1493();
      class_238.class_916 var4 = new class_238.class_916(var2);

      try {
         ((class_127)this.fo()).method_690(var1, var3, var4);
      } catch (RemoteException var6) {
         Log.e("WalletClientImpl", "RemoteException getting masked wallet", var6);
         var4.method_680(8, (MaskedWallet)null, Bundle.EMPTY);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.wallet.NotifyTransactionStatusRequest) void
   public void method_1496(NotifyTransactionStatusRequest var1) {
      Bundle var2 = this.method_1493();

      try {
         ((class_127)this.fo()).method_691(var1, var2);
      } catch (RemoteException var4) {
         ;
      }
   }

   // $FF: renamed from: bp () java.lang.String
   protected String method_1451() {
      return "com.google.android.gms.wallet.service.BIND";
   }

   // $FF: renamed from: bq () java.lang.String
   protected String method_1452() {
      return "com.google.android.gms.wallet.internal.IOwService";
   }

   // $FF: renamed from: bu (android.os.IBinder) com.google.android.gms.internal.ln
   protected class_127 method_1497(IBinder var1) {
      return class_127.class_1083.method_4547(var1);
   }

   // $FF: renamed from: d (java.lang.String, java.lang.String, int) void
   public void method_1498(String var1, String var2, int var3) {
      Bundle var4 = this.method_1493();
      class_238.class_916 var5 = new class_238.class_916(var3);

      try {
         ((class_127)this.fo()).method_693(var1, var2, var4, var5);
      } catch (RemoteException var7) {
         Log.e("WalletClientImpl", "RemoteException changing masked wallet", var7);
         var5.method_680(8, (MaskedWallet)null, Bundle.EMPTY);
      }
   }

   // $FF: renamed from: dQ (int) void
   public void method_1499(int var1) {
      Bundle var2 = this.method_1493();
      class_238.class_916 var3 = new class_238.class_916(var1);

      try {
         ((class_127)this.fo()).method_686(var2, var3);
      } catch (RemoteException var5) {
         Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", var5);
         var3.method_681(8, false, Bundle.EMPTY);
      }
   }

   // $FF: renamed from: x (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1456(IBinder var1) {
      return this.method_1497(var1);
   }

   private static class class_915 extends class_124.class_823 {
      private class_915() {
      }

      // $FF: synthetic method
      class_915(Object var1) {
         this();
      }

      // $FF: renamed from: a (int, com.google.android.gms.wallet.FullWallet, android.os.Bundle) void
      public void method_679(int var1, FullWallet var2, Bundle var3) {
      }

      // $FF: renamed from: a (int, com.google.android.gms.wallet.MaskedWallet, android.os.Bundle) void
      public void method_680(int var1, MaskedWallet var2, Bundle var3) {
      }

      // $FF: renamed from: a (int, boolean, android.os.Bundle) void
      public void method_681(int var1, boolean var2, Bundle var3) {
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status, com.google.android.gms.internal.lj, android.os.Bundle) void
      public void method_682(Status var1, class_612 var2, Bundle var3) {
      }

      // $FF: renamed from: i (int, android.os.Bundle) void
      public void method_683(int var1, Bundle var2) {
      }
   }

   final class class_916 extends class_238.class_915 {
      // $FF: renamed from: FT int
      private final int field_902;

      public class_916(int var2) {
         super(null);
         this.field_902 = var2;
      }

      // $FF: renamed from: a (int, com.google.android.gms.wallet.FullWallet, android.os.Bundle) void
      public void method_679(int var1, FullWallet var2, Bundle var3) {
         PendingIntent var4 = null;
         if(var3 != null) {
            var4 = (PendingIntent)var3.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
         }

         ConnectionResult var5 = new ConnectionResult(var1, var4);
         if(var5.hasResolution()) {
            try {
               var5.startResolutionForResult(class_238.this.field_754, this.field_902);
            } catch (SendIntentException var15) {
               Log.w("WalletClientImpl", "Exception starting pending intent", var15);
            }
         } else {
            Intent var6 = new Intent();
            byte var7;
            if(var5.isSuccess()) {
               var7 = -1;
               var6.putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", var2);
            } else {
               if(var1 == 408) {
                  var7 = 0;
               } else {
                  var7 = 1;
               }

               var6.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", var1);
            }

            PendingIntent var9 = class_238.this.field_754.createPendingResult(this.field_902, var6, 1073741824);
            if(var9 == null) {
               Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
            } else {
               try {
                  var9.send(var7);
               } catch (CanceledException var16) {
                  Log.w("WalletClientImpl", "Exception setting pending result", var16);
               }
            }
         }
      }

      // $FF: renamed from: a (int, com.google.android.gms.wallet.MaskedWallet, android.os.Bundle) void
      public void method_680(int var1, MaskedWallet var2, Bundle var3) {
         PendingIntent var4 = null;
         if(var3 != null) {
            var4 = (PendingIntent)var3.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
         }

         ConnectionResult var5 = new ConnectionResult(var1, var4);
         if(var5.hasResolution()) {
            try {
               var5.startResolutionForResult(class_238.this.field_754, this.field_902);
            } catch (SendIntentException var15) {
               Log.w("WalletClientImpl", "Exception starting pending intent", var15);
            }
         } else {
            Intent var6 = new Intent();
            byte var7;
            if(var5.isSuccess()) {
               var7 = -1;
               var6.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", var2);
            } else {
               if(var1 == 408) {
                  var7 = 0;
               } else {
                  var7 = 1;
               }

               var6.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", var1);
            }

            PendingIntent var9 = class_238.this.field_754.createPendingResult(this.field_902, var6, 1073741824);
            if(var9 == null) {
               Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
            } else {
               try {
                  var9.send(var7);
               } catch (CanceledException var16) {
                  Log.w("WalletClientImpl", "Exception setting pending result", var16);
               }
            }
         }
      }

      // $FF: renamed from: a (int, boolean, android.os.Bundle) void
      public void method_681(int var1, boolean var2, Bundle var3) {
         Intent var4 = new Intent();
         var4.putExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", var2);
         PendingIntent var6 = class_238.this.field_754.createPendingResult(this.field_902, var4, 1073741824);
         if(var6 == null) {
            Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
         } else {
            try {
               var6.send(-1);
            } catch (CanceledException var8) {
               Log.w("WalletClientImpl", "Exception setting pending result", var8);
            }
         }
      }

      // $FF: renamed from: i (int, android.os.Bundle) void
      public void method_683(int var1, Bundle var2) {
         class_347.method_2166(var2, "Bundle should not be null");
         ConnectionResult var4 = new ConnectionResult(var1, (PendingIntent)var2.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
         if(var4.hasResolution()) {
            try {
               var4.startResolutionForResult(class_238.this.field_754, this.field_902);
            } catch (SendIntentException var13) {
               Log.w("WalletClientImpl", "Exception starting pending intent", var13);
            }
         } else {
            Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + var4);
            Intent var6 = new Intent();
            var6.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", 413);
            PendingIntent var8 = class_238.this.field_754.createPendingResult(this.field_902, var6, 1073741824);
            if(var8 == null) {
               Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
            } else {
               try {
                  var8.send(1);
               } catch (CanceledException var14) {
                  Log.w("WalletClientImpl", "Exception setting pending result", var14);
               }
            }
         }
      }
   }
}
