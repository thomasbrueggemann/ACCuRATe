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
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_291;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.internal.class_165;
import com.google.android.gms.internal.class_170;
import com.google.android.gms.internal.class_920;
import com.google.android.gms.internal.ot;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

// $FF: renamed from: com.google.android.gms.internal.oy
public class class_294 extends e<ot> {
    // $FF: renamed from: Dd java.lang.String
    private final String field_889;
    private final int atL;
    private final int mTheme;
    // $FF: renamed from: nr android.app.Activity
    private final Activity field_890;

    public class_294(Activity var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, int var5, String var6, int var7) {
        super(var1, var2, var3, var4, new String[0]);
        this.field_890 = var1;
        this.atL = var5;
        this.field_889 = var6;
        this.mTheme = var7;
    }

    // $FF: renamed from: a (int, java.lang.String, java.lang.String, int) android.os.Bundle
    public static Bundle method_1854(int var0, String var1, String var2, int var3) {
        Bundle var4 = new Bundle();
        var4.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", var0);
        var4.putString("androidPackageName", var1);
        if(!TextUtils.isEmpty(var2)) {
            var4.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(var2, "com.google"));
        }

        var4.putInt("com.google.android.gms.wallet.EXTRA_THEME", var3);
        return var4;
    }

    // $FF: renamed from: pO () android.os.Bundle
    private Bundle method_1856() {
        return method_1854(this.atL, this.field_890.getPackageName(), this.field_889, this.mTheme);
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        var1.method_985(var2, 6171000, this.getContext().getPackageName());
    }

    // $FF: renamed from: a (com.google.android.gms.wallet.FullWalletRequest, int) void
    public void method_1857(FullWalletRequest var1, int var2) {
        class_294.class_1311 var3 = new class_294.class_1311(var2);
        Bundle var4 = this.method_1856();

        try {
            ((class_170)this.gS()).method_809(var1, var4, var3);
        } catch (RemoteException var6) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", var6);
            var3.method_800(8, (FullWallet)null, Bundle.EMPTY);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.wallet.MaskedWalletRequest, int) void
    public void method_1858(MaskedWalletRequest var1, int var2) {
        Bundle var3 = this.method_1856();
        class_294.class_1311 var4 = new class_294.class_1311(var2);

        try {
            ((class_170)this.gS()).method_811(var1, var3, var4);
        } catch (RemoteException var6) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", var6);
            var4.method_801(8, (MaskedWallet)null, Bundle.EMPTY);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.wallet.NotifyTransactionStatusRequest) void
    public void method_1859(NotifyTransactionStatusRequest var1) {
        Bundle var2 = this.method_1856();

        try {
            ((class_170)this.gS()).method_812(var1, var2);
        } catch (RemoteException var4) {
            ;
        }
    }

    // $FF: renamed from: bP (android.os.IBinder) com.google.android.gms.internal.ot
    protected class_170 method_1860(IBinder var1) {
        return class_170.class_1237.method_3247(var1);
    }

    // $FF: renamed from: d (java.lang.String, java.lang.String, int) void
    public void method_1861(String var1, String var2, int var3) {
        Bundle var4 = this.method_1856();
        class_294.class_1311 var5 = new class_294.class_1311(var3);

        try {
            ((class_170)this.gS()).method_814(var1, var2, var4, var5);
        } catch (RemoteException var7) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", var7);
            var5.method_801(8, (MaskedWallet)null, Bundle.EMPTY);
        }
    }

    // $FF: renamed from: fI (int) void
    public void method_1862(int var1) {
        Bundle var2 = this.method_1856();
        class_294.class_1311 var3 = new class_294.class_1311(var1);

        try {
            ((class_170)this.gS()).method_807(var2, var3);
        } catch (RemoteException var5) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", var5);
            var3.method_802(8, false, Bundle.EMPTY);
        }
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.method_1860(var1);
    }

    private static class class_1310 extends class_165.class_1511 {
        private class_1310() {
        }

        // $FF: synthetic method
        class_1310(Object var1) {
            this();
        }

        // $FF: renamed from: a (int, com.google.android.gms.wallet.FullWallet, android.os.Bundle) void
        public void method_800(int var1, FullWallet var2, Bundle var3) {
        }

        // $FF: renamed from: a (int, com.google.android.gms.wallet.MaskedWallet, android.os.Bundle) void
        public void method_801(int var1, MaskedWallet var2, Bundle var3) {
        }

        // $FF: renamed from: a (int, boolean, android.os.Bundle) void
        public void method_802(int var1, boolean var2, Bundle var3) {
        }

        // $FF: renamed from: a (com.google.android.gms.common.api.Status, com.google.android.gms.internal.op, android.os.Bundle) void
        public void method_803(Status var1, class_920 var2, Bundle var3) {
        }

        // $FF: renamed from: i (int, android.os.Bundle) void
        public void method_804(int var1, Bundle var2) {
        }
    }

    final class class_1311 extends class_294.class_1310 {
        // $FF: renamed from: Lu int
        private final int field_3473;

        public class_1311(int var2) {
            super(null);
            this.field_3473 = var2;
        }

        // $FF: renamed from: a (int, com.google.android.gms.wallet.FullWallet, android.os.Bundle) void
        public void method_800(int var1, FullWallet var2, Bundle var3) {
            PendingIntent var4 = null;
            if(var3 != null) {
                var4 = (PendingIntent)var3.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }

            ConnectionResult var5 = new ConnectionResult(var1, var4);
            if(var5.hasResolution()) {
                try {
                    var5.startResolutionForResult(class_294.this.field_890, this.field_3473);
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

                PendingIntent var9 = class_294.this.field_890.createPendingResult(this.field_3473, var6, 1073741824);
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
        public void method_801(int var1, MaskedWallet var2, Bundle var3) {
            PendingIntent var4 = null;
            if(var3 != null) {
                var4 = (PendingIntent)var3.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }

            ConnectionResult var5 = new ConnectionResult(var1, var4);
            if(var5.hasResolution()) {
                try {
                    var5.startResolutionForResult(class_294.this.field_890, this.field_3473);
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

                PendingIntent var9 = class_294.this.field_890.createPendingResult(this.field_3473, var6, 1073741824);
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
        public void method_802(int var1, boolean var2, Bundle var3) {
            Intent var4 = new Intent();
            var4.putExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", var2);
            PendingIntent var6 = class_294.this.field_890.createPendingResult(this.field_3473, var4, 1073741824);
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
        public void method_804(int var1, Bundle var2) {
            class_1090.method_5681(var2, "Bundle should not be null");
            ConnectionResult var4 = new ConnectionResult(var1, (PendingIntent)var2.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if(var4.hasResolution()) {
                try {
                    var4.startResolutionForResult(class_294.this.field_890, this.field_3473);
                } catch (SendIntentException var13) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", var13);
                }
            } else {
                Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + var4);
                Intent var6 = new Intent();
                var6.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", 413);
                PendingIntent var8 = class_294.this.field_890.createPendingResult(this.field_3473, var6, 1073741824);
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
