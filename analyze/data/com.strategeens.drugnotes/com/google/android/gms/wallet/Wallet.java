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
import com.google.android.gms.internal.class_162;
import com.google.android.gms.internal.class_288;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_790;
import com.google.android.gms.internal.class_824;
import com.google.android.gms.internal.class_825;
import com.google.android.gms.internal.qh;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.wobs.class_94;
import java.util.Locale;

public final class Wallet {
   public static final Api<Wallet.WalletOptions> API;
   // $FF: renamed from: DQ com.google.android.gms.common.api.Api$c
   private static final Api.class_1394<qh> field_4334 = new Api.class_1394();
   // $FF: renamed from: DR com.google.android.gms.common.api.Api$b
   private static final Api.class_1391<qh, Wallet.WalletOptions> field_4335 = new Api.class_1391() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.wallet.Wallet$WalletOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.qh
      public class_288 method_4669(Context var1, Looper var2, class_347 var3, Wallet.WalletOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         class_335.method_2308(var1 instanceof Activity, "An Activity must be used for Wallet APIs");
         Activity var7 = (Activity)var1;
         if(var4 == null) {
            var4 = new Wallet.WalletOptions(null);
         }

         return new class_288(var7, var2, var5, var6, var4.environment, var3.getAccountName(), var4.theme);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static final Payments Payments;
   public static final class_94 avT;
   public static final class_162 avU;

   static {
      API = new Api(field_4335, field_4334, new Scope[0]);
      Payments = new class_790();
      avT = new class_824();
      avU = new class_825();
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
         this.environment = var1.avV;
         this.theme = var1.mTheme;
      }

      // $FF: synthetic method
      WalletOptions(Wallet.Builder var1, Object var2) {
         this(var1);
      }
   }

   public static final class Builder {
      private int avV = 0;
      private int mTheme = 0;

      public Wallet.WalletOptions build() {
         return new Wallet.WalletOptions(this, null);
      }

      public Wallet.Builder setEnvironment(int var1) {
         if(var1 != 0 && var1 != 2 && var1 != 1) {
            Locale var2 = Locale.US;
            Object[] var3 = new Object[]{Integer.valueOf(var1)};
            throw new IllegalArgumentException(String.format(var2, "Invalid environment value %d", var3));
         } else {
            this.avV = var1;
            return this;
         }
      }

      public Wallet.Builder setTheme(int var1) {
         if(var1 != 0 && var1 != 1) {
            Locale var2 = Locale.US;
            Object[] var3 = new Object[]{Integer.valueOf(var1)};
            throw new IllegalArgumentException(String.format(var2, "Invalid theme value %d", var3));
         } else {
            this.mTheme = var1;
            return this;
         }
      }
   }

   public abstract static class class_1598<R extends Result> extends BaseImplementation.class_1057<R, qh> {
      public class_1598(GoogleApiClient var1) {
         super(Wallet.field_4334, var1);
      }
   }

   public abstract static class class_1597 extends Wallet.class_1598<Status> {
      public class_1597(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      protected Status method_1151(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      protected Result method_1109(Status var1) {
         return this.method_1151(var1);
      }
   }
}
