package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_238;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;

// $FF: renamed from: com.google.android.gms.internal.lr
public class class_609 implements Payments {
   public void changeMaskedWallet(GoogleApiClient var1, final String var2, final String var3, final int var4) {
      var1.method_772(new Wallet.class_1252() {
         // $FF: renamed from: a (com.google.android.gms.internal.ls) void
         protected void method_928(class_238 var1) {
            var1.method_1498(var2, var3, var4);
            this.b(Status.field_3880);
         }
      });
   }

   public void checkForPreAuthorization(GoogleApiClient var1, final int var2) {
      var1.method_772(new Wallet.class_1252() {
         // $FF: renamed from: a (com.google.android.gms.internal.ls) void
         protected void method_926(class_238 var1) {
            var1.method_1499(var2);
            this.b(Status.field_3880);
         }
      });
   }

   public void loadFullWallet(GoogleApiClient var1, final FullWalletRequest var2, final int var3) {
      var1.method_772(new Wallet.class_1252() {
         // $FF: renamed from: a (com.google.android.gms.internal.ls) void
         protected void method_929(class_238 var1) {
            var1.method_1494(var2, var3);
            this.b(Status.field_3880);
         }
      });
   }

   public void loadMaskedWallet(GoogleApiClient var1, final MaskedWalletRequest var2, final int var3) {
      var1.method_772(new Wallet.class_1252() {
         // $FF: renamed from: a (com.google.android.gms.internal.ls) void
         protected void method_930(class_238 var1) {
            var1.method_1495(var2, var3);
            this.b(Status.field_3880);
         }
      });
   }

   public void notifyTransactionStatus(GoogleApiClient var1, final NotifyTransactionStatusRequest var2) {
      var1.method_772(new Wallet.class_1252() {
         // $FF: renamed from: a (com.google.android.gms.internal.ls) void
         protected void method_927(class_238 var1) {
            var1.method_1496(var2);
            this.b(Status.field_3880);
         }
      });
   }
}
