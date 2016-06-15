package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends Api.ApiOptions> {
   // $FF: renamed from: Jm com.google.android.gms.common.api.Api$b
   private final Api.class_1391<?, O> field_2829;
   // $FF: renamed from: Jn com.google.android.gms.common.api.Api$c
   private final Api.class_1394<?> field_2830;
   // $FF: renamed from: Jo java.util.ArrayList
   private final ArrayList<Scope> field_2831;

   public <C extends Api.class_1390> Api(Api.class_1391<C, O> var1, Api.class_1394<C> var2, Scope... var3) {
      this.field_2829 = var1;
      this.field_2830 = var2;
      this.field_2831 = new ArrayList(Arrays.asList(var3));
   }

   // $FF: renamed from: gx () com.google.android.gms.common.api.Api$b
   public Api.class_1391<?, O> method_3731() {
      return this.field_2829;
   }

   // $FF: renamed from: gy () java.util.List
   public List<Scope> method_3732() {
      return this.field_2831;
   }

   // $FF: renamed from: gz () com.google.android.gms.common.api.Api$c
   public Api.class_1394<?> method_3733() {
      return this.field_2830;
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

   public interface class_1390 {
      void connect();

      void disconnect();

      boolean isConnected();
   }

   public interface class_1391<T extends Api.class_1390, O> {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
      T method_442(Context var1, Looper var2, jg var3, O var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6);

      int getPriority();
   }

   public static final class class_1394<C extends Api.class_1390> {
   }
}
