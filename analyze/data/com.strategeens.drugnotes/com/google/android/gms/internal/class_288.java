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
import com.google.android.gms.internal.class_156;
import com.google.android.gms.internal.class_159;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_788;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.qc;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

// $FF: renamed from: com.google.android.gms.internal.qh
public class class_288 extends jl<qc> {
   // $FF: renamed from: DZ java.lang.String
   private final String field_606;
   private final int avV;
   private final int mTheme;
   // $FF: renamed from: nB android.app.Activity
   private final Activity field_607;

   public class_288(Activity var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, int var5, String var6, int var7) {
      super(var1, var2, var3, var4, new String[0]);
      this.field_607 = var1;
      this.avV = var5;
      this.field_606 = var6;
      this.mTheme = var7;
   }

   // $FF: renamed from: a (int, java.lang.String, java.lang.String, int) android.os.Bundle
   public static Bundle method_1837(int var0, String var1, String var2, int var3) {
      Bundle var4 = new Bundle();
      var4.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", var0);
      var4.putString("androidPackageName", var1);
      if(!TextUtils.isEmpty(var2)) {
         var4.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(var2, "com.google"));
      }

      var4.putInt("com.google.android.gms.wallet.EXTRA_THEME", var3);
      return var4;
   }

   // $FF: renamed from: rf () android.os.Bundle
   private Bundle method_1839() {
      return method_1837(this.avV, this.field_607.getPackageName(), this.field_606, this.mTheme);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      var1.method_158(var2, 6587000, this.getContext().getPackageName());
   }

   // $FF: renamed from: a (com.google.android.gms.wallet.FullWalletRequest, int) void
   public void method_1840(FullWalletRequest var1, int var2) {
      class_288.class_1240 var3 = new class_288.class_1240(var2);
      Bundle var4 = this.method_1839();

      try {
         ((class_159)this.hw()).method_827(var1, var4, var3);
      } catch (RemoteException var6) {
         Log.e("WalletClientImpl", "RemoteException getting full wallet", var6);
         var3.method_818(8, (FullWallet)null, Bundle.EMPTY);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, int) void
   public void method_1841(MaskedWalletRequest var1, int var2) {
      Bundle var3 = this.method_1839();
      class_288.class_1240 var4 = new class_288.class_1240(var2);

      try {
         ((class_159)this.hw()).method_829(var1, var3, var4);
      } catch (RemoteException var6) {
         Log.e("WalletClientImpl", "RemoteException getting masked wallet", var6);
         var4.method_819(8, (MaskedWallet)null, Bundle.EMPTY);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.wallet.NotifyTransactionStatusRequest) void
   public void method_1842(NotifyTransactionStatusRequest var1) {
      Bundle var2 = this.method_1839();

      try {
         ((class_159)this.hw()).method_830(var1, var2);
      } catch (RemoteException var4) {
         ;
      }
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.gms.wallet.service.BIND";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.wallet.internal.IOwService";
   }

   // $FF: renamed from: bV (android.os.IBinder) com.google.android.gms.internal.qc
   protected class_159 method_1843(IBinder var1) {
      return class_159.class_1405.method_3698(var1);
   }

   // $FF: renamed from: d (java.lang.String, java.lang.String, int) void
   public void method_1844(String var1, String var2, int var3) {
      Bundle var4 = this.method_1839();
      class_288.class_1240 var5 = new class_288.class_1240(var3);

      try {
         ((class_159)this.hw()).method_832(var1, var2, var4, var5);
      } catch (RemoteException var7) {
         Log.e("WalletClientImpl", "RemoteException changing masked wallet", var7);
         var5.method_819(8, (MaskedWallet)null, Bundle.EMPTY);
      }
   }

   // $FF: renamed from: gk (int) void
   public void method_1845(int var1) {
      Bundle var2 = this.method_1839();
      class_288.class_1240 var3 = new class_288.class_1240(var1);

      try {
         ((class_159)this.hw()).method_825(var2, var3);
      } catch (RemoteException var5) {
         Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", var5);
         var3.method_820(8, false, Bundle.EMPTY);
      }
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_1843(var1);
   }

   private static class class_1239 extends class_156.class_1449 {
      private class_1239() {
      }

      // $FF: synthetic method
      class_1239(Object var1) {
         this();
      }

      // $FF: renamed from: a (int, com.google.android.gms.wallet.FullWallet, android.os.Bundle) void
      public void method_818(int var1, FullWallet var2, Bundle var3) {
      }

      // $FF: renamed from: a (int, com.google.android.gms.wallet.MaskedWallet, android.os.Bundle) void
      public void method_819(int var1, MaskedWallet var2, Bundle var3) {
      }

      // $FF: renamed from: a (int, boolean, android.os.Bundle) void
      public void method_820(int var1, boolean var2, Bundle var3) {
      }

      // $FF: renamed from: a (com.google.android.gms.common.api.Status, com.google.android.gms.internal.py, android.os.Bundle) void
      public void method_821(Status var1, class_788 var2, Bundle var3) {
      }

      // $FF: renamed from: i (int, android.os.Bundle) void
      public void method_822(int var1, Bundle var2) {
      }
   }

   final class class_1240 extends class_288.class_1239 {
      // $FF: renamed from: My int
      private final int field_3787;

      public class_1240(int var2) {
         super(null);
         this.field_3787 = var2;
      }

      // $FF: renamed from: a (int, com.google.android.gms.wallet.FullWallet, android.os.Bundle) void
      public void method_818(int var1, FullWallet var2, Bundle var3) {
         PendingIntent var4 = null;
         if(var3 != null) {
            var4 = (PendingIntent)var3.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
         }

         ConnectionResult var5 = new ConnectionResult(var1, var4);
         if(var5.hasResolution()) {
            try {
               var5.startResolutionForResult(class_288.this.field_607, this.field_3787);
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

            PendingIntent var9 = class_288.this.field_607.createPendingResult(this.field_3787, var6, 1073741824);
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
      public void method_819(int var1, MaskedWallet var2, Bundle var3) {
         PendingIntent var4 = null;
         if(var3 != null) {
            var4 = (PendingIntent)var3.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
         }

         ConnectionResult var5 = new ConnectionResult(var1, var4);
         if(var5.hasResolution()) {
            try {
               var5.startResolutionForResult(class_288.this.field_607, this.field_3787);
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

            PendingIntent var9 = class_288.this.field_607.createPendingResult(this.field_3787, var6, 1073741824);
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
      public void method_820(int var1, boolean var2, Bundle var3) {
         Intent var4 = new Intent();
         var4.putExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", var2);
         PendingIntent var6 = class_288.this.field_607.createPendingResult(this.field_3787, var4, 1073741824);
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
      public void method_822(int var1, Bundle var2) {
         class_335.method_2306(var2, "Bundle should not be null");
         ConnectionResult var4 = new ConnectionResult(var1, (PendingIntent)var2.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
         if(var4.hasResolution()) {
            try {
               var4.startResolutionForResult(class_288.this.field_607, this.field_3787);
            } catch (SendIntentException var13) {
               Log.w("WalletClientImpl", "Exception starting pending intent", var13);
            }
         } else {
            Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + var4);
            Intent var6 = new Intent();
            var6.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", 413);
            PendingIntent var8 = class_288.this.field_607.createPendingResult(this.field_3787, var6, 1073741824);
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
