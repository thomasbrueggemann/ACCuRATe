package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends Api.ApiOptions> {
   // $FF: renamed from: Dj com.google.android.gms.common.api.Api$b
   private final Api.class_1074<?, O> field_2955;
   // $FF: renamed from: Dk com.google.android.gms.common.api.Api$c
   private final Api.class_1077<?> field_2956;
   // $FF: renamed from: Dl java.util.ArrayList
   private final ArrayList<Scope> field_2957;

   public <C extends Api.class_1073> Api(Api.class_1074<C, O> var1, Api.class_1077<C> var2, Scope... var3) {
      this.field_2955 = var1;
      this.field_2956 = var2;
      this.field_2957 = new ArrayList(Arrays.asList(var3));
   }

   // $FF: renamed from: eu () com.google.android.gms.common.api.Api$b
   public Api.class_1074<?, O> method_3125() {
      return this.field_2955;
   }

   // $FF: renamed from: ev () java.util.List
   public List<Scope> method_3126() {
      return this.field_2957;
   }

   // $FF: renamed from: ew () com.google.android.gms.common.api.Api$c
   public Api.class_1077<?> method_3127() {
      return this.field_2956;
   }

   public interface ApiOptions {
   }

   public interface HasOptions extends Api.ApiOptions {
   }

   public static final class NoOptions implements Api.NotRequiredOptions {
   }

   public interface NotRequiredOptions extends Api.ApiOptions {
   }

   public interface Optional extends Api.HasOptions, Api.NotRequiredOptions {
   }

   public interface class_1073 {
      void connect();

      void disconnect();

      Looper getLooper();

      boolean isConnected();
   }

   public interface class_1074<T extends Api.class_1073, O> {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
      T method_400(Context var1, Looper var2, gz var3, O var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6);

      int getPriority();
   }

   public static final class class_1077<C extends Api.class_1073> {
   }
}
