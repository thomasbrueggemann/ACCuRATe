package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.internal.class_323;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_626;
import com.google.android.gms.internal.class_627;
import com.google.android.gms.internal.class_628;
import com.google.android.gms.internal.class_629;
import com.google.android.gms.internal.class_632;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.class_141;
import com.google.android.gms.plus.class_142;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.class_236;
import com.google.android.gms.plus.internal.class_677;
import com.google.android.gms.plus.internal.e;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
   public static final Api<Plus.PlusOptions> API;
   public static final Account AccountApi;
   public static final Moments MomentsApi;
   public static final People PeopleApi;
   public static final Scope SCOPE_PLUS_LOGIN;
   public static final Scope SCOPE_PLUS_PROFILE;
   public static final class_142 abm;
   public static final class_141 abn;
   // $FF: renamed from: yE com.google.android.gms.common.api.Api$c
   public static final Api.class_1077<e> field_896 = new Api.class_1077();
   // $FF: renamed from: yF com.google.android.gms.common.api.Api$b
   static final Api.class_1074<e, Plus.PlusOptions> field_897 = new Api.class_1074() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, com.google.android.gms.plus.Plus$PlusOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.plus.internal.e
      public class_236 method_2858(Context var1, Looper var2, class_323 var3, Plus.PlusOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         if(var4 == null) {
            var4 = new Plus.PlusOptions(null);
         }

         class_236 var7 = new class_236(var1, var2, var5, var6, new class_677(var3.method_2055(), var3.method_2058(), (String[])var4.abp.toArray(new String[0]), new String[0], var1.getPackageName(), var1.getPackageName(), (String)null, new PlusCommonExtras()));
         return var7;
      }

      public int getPriority() {
         return 2;
      }
   };

   static {
      API = new Api(field_897, field_896, new Scope[0]);
      SCOPE_PLUS_LOGIN = new Scope("https://www.googleapis.com/auth/plus.login");
      SCOPE_PLUS_PROFILE = new Scope("https://www.googleapis.com/auth/plus.me");
      MomentsApi = new class_626();
      PeopleApi = new class_627();
      AccountApi = new class_632();
      abm = new class_629();
      abn = new class_628();
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.common.api.Api$c) com.google.android.gms.plus.internal.e
   public static e method_1780(GoogleApiClient var0, Api.class_1077<e> var1) {
      boolean var2 = true;
      boolean var3;
      if(var0 != null) {
         var3 = var2;
      } else {
         var3 = false;
      }

      class_347.method_2168(var3, "GoogleApiClient parameter is required.");
      class_347.method_2161(var0.isConnected(), "GoogleApiClient must be connected.");
      class_236 var4 = (class_236)var0.method_771(var1);
      if(var4 == null) {
         var2 = false;
      }

      class_347.method_2161(var2, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
      return var4;
   }

   public static final class PlusOptions implements Api.Optional {
      final String abo;
      final Set<String> abp;

      private PlusOptions() {
         this.abo = null;
         this.abp = new HashSet();
      }

      // $FF: synthetic method
      PlusOptions(Object var1) {
         this();
      }

      private PlusOptions(Plus.Builder var1) {
         this.abo = var1.abo;
         this.abp = var1.abp;
      }

      // $FF: synthetic method
      PlusOptions(Plus.Builder var1, Object var2) {
         this(var1);
      }

      public static Plus.Builder builder() {
         return new Plus.Builder();
      }
   }

   public static final class Builder {
      String abo;
      final Set<String> abp = new HashSet();

      public Plus.Builder addActivityTypes(String... var1) {
         class_347.method_2166(var1, "activityTypes may not be null.");

         for(int var3 = 0; var3 < var1.length; ++var3) {
            this.abp.add(var1[var3]);
         }

         return this;
      }

      public Plus.PlusOptions build() {
         return new Plus.PlusOptions(this, null);
      }

      public Plus.Builder setServerClientId(String var1) {
         this.abo = var1;
         return this;
      }
   }

   public abstract static class class_817<R extends Result> extends class_797.class_1203<R, e> {
      public class_817() {
         super(Plus.field_896);
      }
   }
}
