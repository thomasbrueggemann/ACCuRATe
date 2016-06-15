package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_288;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;

// $FF: renamed from: com.google.android.gms.internal.qg
public class class_790 implements Payments {
   public void changeMaskedWallet(final GoogleApiClient var1, final String var2, final String var3, final int var4) {
      var1.method_942(new Wallet.class_1597(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.qh) void
         protected void method_1152(class_288 var1) {
            var1.method_1844(var2, var3, var4);
            this.b(Status.field_3960);
         }
      });
   }

   public void checkForPreAuthorization(final GoogleApiClient var1, final int var2) {
      var1.method_942(new Wallet.class_1597(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.qh) void
         protected void method_1156(class_288 var1) {
            var1.method_1845(var2);
            this.b(Status.field_3960);
         }
      });
   }

   public void loadFullWallet(final GoogleApiClient var1, final FullWalletRequest var2, final int var3) {
      var1.method_942(new Wallet.class_1597(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.qh) void
         protected void method_1155(class_288 var1) {
            var1.method_1840(var2, var3);
            this.b(Status.field_3960);
         }
      });
   }

   public void loadMaskedWallet(final GoogleApiClient var1, final MaskedWalletRequest var2, final int var3) {
      var1.method_942(new Wallet.class_1597(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.qh) void
         protected void method_1154(class_288 var1) {
            var1.method_1841(var2, var3);
            this.b(Status.field_3960);
         }
      });
   }

   public void notifyTransactionStatus(final GoogleApiClient var1, final NotifyTransactionStatusRequest var2) {
      var1.method_942(new Wallet.class_1597(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.qh) void
         protected void method_1153(class_288 var1) {
            var1.method_1842(var2);
            this.b(Status.field_3960);
         }
      });
   }
}
