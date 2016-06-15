package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_802;
import com.google.android.gms.internal.class_803;
import com.google.android.gms.internal.class_807;
import com.google.android.gms.internal.class_808;
import com.google.android.gms.internal.class_809;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.class_176;
import com.google.android.gms.plus.class_177;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.class_285;
import com.google.android.gms.plus.internal.class_874;
import com.google.android.gms.plus.internal.e;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
   public static final Api<Plus.PlusOptions> API;
   public static final Account AccountApi;
   // $FF: renamed from: DQ com.google.android.gms.common.api.Api$c
   public static final Api.class_1394<e> field_741 = new Api.class_1394();
   // $FF: renamed from: DR com.google.android.gms.common.api.Api$b
   static final Api.class_1391<e, Plus.PlusOptions> field_742 = new Api.class_1391() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.plus.Plus$PlusOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.plus.internal.e
      public class_285 method_3409(Context var1, Looper var2, class_347 var3, Plus.PlusOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         if(var4 == null) {
            var4 = new Plus.PlusOptions(null);
         }

         class_285 var7 = new class_285(var1, var2, var5, var6, new class_874(var3.method_2418(), var3.method_2421(), (String[])var4.ans.toArray(new String[0]), new String[0], var1.getPackageName(), var1.getPackageName(), (String)null, new PlusCommonExtras()));
         return var7;
      }

      public int getPriority() {
         return 2;
      }
   };
   public static final Moments MomentsApi;
   public static final People PeopleApi;
   public static final Scope SCOPE_PLUS_LOGIN;
   public static final Scope SCOPE_PLUS_PROFILE;
   public static final class_177 anp;
   public static final class_176 anq;

   static {
      API = new Api(field_742, field_741, new Scope[0]);
      SCOPE_PLUS_LOGIN = new Scope("https://www.googleapis.com/auth/plus.login");
      SCOPE_PLUS_PROFILE = new Scope("https://www.googleapis.com/auth/plus.me");
      MomentsApi = new class_807();
      PeopleApi = new class_808();
      AccountApi = new class_802();
      anp = new class_809();
      anq = new class_803();
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.common.api.Api$c) com.google.android.gms.plus.internal.e
   public static e method_2168(GoogleApiClient var0, Api.class_1394<e> var1) {
      boolean var2 = true;
      boolean var3;
      if(var0 != null) {
         var3 = var2;
      } else {
         var3 = false;
      }

      class_335.method_2308(var3, "GoogleApiClient parameter is required.");
      class_335.method_2302(var0.isConnected(), "GoogleApiClient must be connected.");
      class_285 var4 = (class_285)var0.method_941(var1);
      if(var4 == null) {
         var2 = false;
      }

      class_335.method_2302(var2, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
      return var4;
   }

   public static final class PlusOptions implements Api.Optional {
      final String anr;
      final Set<String> ans;

      private PlusOptions() {
         this.anr = null;
         this.ans = new HashSet();
      }

      // $FF: synthetic method
      PlusOptions(Object var1) {
         this();
      }

      private PlusOptions(Plus.Builder var1) {
         this.anr = var1.anr;
         this.ans = var1.ans;
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
      String anr;
      final Set<String> ans = new HashSet();

      public Plus.Builder addActivityTypes(String... var1) {
         class_335.method_2306(var1, "activityTypes may not be null.");

         for(int var3 = 0; var3 < var1.length; ++var3) {
            this.ans.add(var1[var3]);
         }

         return this;
      }

      public Plus.PlusOptions build() {
         return new Plus.PlusOptions(this, null);
      }

      public Plus.Builder setServerClientId(String var1) {
         this.anr = var1;
         return this;
      }
   }

   public abstract static class class_1089<R extends Result> extends BaseImplementation.class_1057<R, e> {
      public class_1089(GoogleApiClient var1) {
         super(Plus.field_741, var1);
      }
   }
}
