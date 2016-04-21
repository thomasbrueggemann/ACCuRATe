package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.class_166;
import com.google.android.gms.internal.class_294;
import com.google.android.gms.internal.class_907;
import com.google.android.gms.internal.class_911;
import com.google.android.gms.internal.class_913;
import com.google.android.gms.internal.oy;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.wobs.class_90;
import java.util.Locale;

public final class Wallet {
    public static final Api<Wallet.WalletOptions> API;
    // $FF: renamed from: CU com.google.android.gms.common.api.Api$c
    private static final Api.class_1482<oy> field_5193 = new Api.class_1482();
    // $FF: renamed from: CV com.google.android.gms.common.api.Api$b
    private static final Api.class_1479<oy, Wallet.WalletOptions> field_5194 = new Api.class_1479() {
        // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.wallet.Wallet$WalletOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.oy
        public class_294 method_4849(Context var1, Looper var2, ClientSettings var3, Wallet.WalletOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
            class_1090.method_5683(var1 instanceof Activity, "An Activity must be used for Wallet APIs");
            Activity var7 = (Activity)var1;
            if(var4 == null) {
                var4 = new Wallet.WalletOptions(null);
            }

            return new class_294(var7, var2, var5, var6, var4.environment, var3.getAccountName(), var4.theme);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };
    public static final Payments Payments;
    public static final class_90 atJ;
    public static final class_166 atK;

    static {
        API = new Api(field_5194, field_5193, new Scope[0]);
        Payments = new class_907();
        atJ = new class_911();
        atK = new class_913();
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient var0, String var1, String var2, int var3) {
        Payments.changeMaskedWallet(var0, var1, var2, var3);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient var0, int var1) {
        Payments.checkForPreAuthorization(var0, var1);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient var0, FullWalletRequest var1, int var2) {
        Payments.loadFullWallet(var0, var1, var2);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient var0, MaskedWalletRequest var1, int var2) {
        Payments.loadMaskedWallet(var0, var1, var2);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient var0, NotifyTransactionStatusRequest var1) {
        Payments.notifyTransactionStatus(var0, var1);
    }

    public static final class WalletOptions implements Api.HasOptions {
        public final int environment;
        public final int theme;

        private WalletOptions() {
            this(new Wallet.Builder());
        }

        // $FF: synthetic method
        WalletOptions(Object var1) {
            this();
        }

        private WalletOptions(Wallet.Builder var1) {
            this.environment = var1.atL;
            this.theme = var1.mTheme;
        }

        // $FF: synthetic method
        WalletOptions(Wallet.Builder var1, Object var2) {
            this(var1);
        }
    }

    public static final class Builder {
        private int atL = 0;
        private int mTheme = 0;

        public Wallet.WalletOptions build() {
            return new Wallet.WalletOptions(this, null);
        }

        public Wallet.Builder setEnvironment(int var1) {
            if(var1 != 0 && var1 != 2 && var1 != 1) {
                Locale var2 = Locale.US;
                Object[] var3 = new Object[] {Integer.valueOf(var1)};
                throw new IllegalArgumentException(String.format(var2, "Invalid environment value %d", var3));
            } else {
                this.atL = var1;
                return this;
            }
        }

        public Wallet.Builder setTheme(int var1) {
            if(var1 != 0 && var1 != 1) {
                Locale var2 = Locale.US;
                Object[] var3 = new Object[] {Integer.valueOf(var1)};
                throw new IllegalArgumentException(String.format(var2, "Invalid theme value %d", var3));
            } else {
                this.mTheme = var1;
                return this;
            }
        }
    }

    public abstract static class class_1735<R extends Result> extends BaseImplementation.class_1146<R, oy> {
        public class_1735() {
            super(Wallet.field_5193);
        }
    }

    public abstract static class class_1734 extends Wallet.class_1735<Status> {
        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        protected Result method_1104(Status var1) {
            return this.method_1148(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        protected Status method_1148(Status var1) {
            return var1;
        }
    }
}
