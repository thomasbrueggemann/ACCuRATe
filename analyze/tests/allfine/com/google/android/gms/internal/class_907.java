package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_294;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;

// $FF: renamed from: com.google.android.gms.internal.ox
public class class_907 implements Payments {
    public void changeMaskedWallet(GoogleApiClient var1, final String var2, final String var3, final int var4) {
        var1.method_897(new Wallet.class_1734() {
            // $FF: renamed from: a (com.google.android.gms.internal.oy) void
            protected void method_1151(class_294 var1) {
                var1.method_1861(var2, var3, var4);
                this.b(Status.field_4739);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient var1, final int var2) {
        var1.method_897(new Wallet.class_1734() {
            // $FF: renamed from: a (com.google.android.gms.internal.oy) void
            protected void method_1153(class_294 var1) {
                var1.method_1862(var2);
                this.b(Status.field_4739);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient var1, final FullWalletRequest var2, final int var3) {
        var1.method_897(new Wallet.class_1734() {
            // $FF: renamed from: a (com.google.android.gms.internal.oy) void
            protected void method_1150(class_294 var1) {
                var1.method_1857(var2, var3);
                this.b(Status.field_4739);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient var1, final MaskedWalletRequest var2, final int var3) {
        var1.method_897(new Wallet.class_1734() {
            // $FF: renamed from: a (com.google.android.gms.internal.oy) void
            protected void method_1152(class_294 var1) {
                var1.method_1858(var2, var3);
                this.b(Status.field_4739);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient var1, final NotifyTransactionStatusRequest var2) {
        var1.method_897(new Wallet.class_1734() {
            // $FF: renamed from: a (com.google.android.gms.internal.oy) void
            protected void method_1149(class_294 var1) {
                var1.method_1859(var2);
                this.b(Status.field_4739);
            }
        });
    }
}
