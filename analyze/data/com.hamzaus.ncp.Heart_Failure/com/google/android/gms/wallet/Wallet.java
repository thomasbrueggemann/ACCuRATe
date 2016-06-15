package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.internal.class_130;
import com.google.android.gms.internal.class_238;
import com.google.android.gms.internal.class_323;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_606;
import com.google.android.gms.internal.class_608;
import com.google.android.gms.internal.class_609;
import com.google.android.gms.internal.ls;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.wobs.class_87;
import java.util.Locale;

public final class Wallet {
   public static final Api<Wallet.WalletOptions> API;
   public static final Payments Payments;
   public static final class_87 ajW;
   public static final class_130 ajX;
   // $FF: renamed from: yE com.google.android.gms.common.api.Api$c
   private static final Api.class_1077<ls> field_4185 = new Api.class_1077();
   // $FF: renamed from: yF com.google.android.gms.common.api.Api$b
   private static final Api.class_1074<ls, Wallet.WalletOptions> field_4186 = new Api.class_1074() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, com.google.android.gms.wallet.Wallet$WalletOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.ls
      public class_238 method_3737(Context var1, Looper var2, class_323 var3, Wallet.WalletOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         class_347.method_2168(var1 instanceof Activity, "An Activity must be used for Wallet APIs");
         Activity var7 = (Activity)var1;
         if(var4 == null) {
            var4 = new Wallet.WalletOptions(null);
         }

         return new class_238(var7, var2, var5, var6, var4.environment, var3.getAccountName(), var4.theme);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };

   static {
      API = new Api(field_4186, field_4185, new Scope[0]);
      Payments = new class_609();
      ajW = new class_608();
      ajX = new class_606();
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
         this.environment = var1.ajY;
         this.theme = var1.mTheme;
      }

      // $FF: synthetic method
      WalletOptions(Wallet.Builder var1, Object var2) {
         this(var1);
      }
   }

   public static final class Builder {
      private int ajY = 0;
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
            this.ajY = var1;
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

   public abstract static class class_1253<R extends Result> extends class_797.class_1203<R, ls> {
      public class_1253() {
         super(Wallet.field_4185);
      }
   }

   public abstract static class class_1252 extends Wallet.class_1253<Status> {
      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      protected Result method_884(Status var1) {
         return this.method_925(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      protected Status method_925(Status var1) {
         return var1;
      }
   }
}
