package com.google.android.gms.fitness;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Build.VERSION;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.class_978;
import com.google.android.gms.internal.class_154;
import com.google.android.gms.internal.class_293;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_773;
import com.google.android.gms.internal.class_774;
import com.google.android.gms.internal.class_775;
import com.google.android.gms.internal.class_781;
import com.google.android.gms.internal.class_783;
import com.google.android.gms.internal.class_784;
import com.google.android.gms.internal.class_785;
import com.google.android.gms.internal.class_786;
import com.google.android.gms.internal.class_91;
import com.google.android.gms.internal.lu;
import java.util.concurrent.TimeUnit;

public class Fitness {
   public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
   public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
   public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
   public static final Api<Api.NoOptions> API;
   public static final BleApi BleApi;
   public static final ConfigApi ConfigApi;
   // $FF: renamed from: DQ com.google.android.gms.common.api.Api$c
   public static final Api.class_1394<lu> field_3856 = new Api.class_1394();
   // $FF: renamed from: DR com.google.android.gms.common.api.Api$b
   private static final Api.class_1391<lu, Api.NoOptions> field_3857 = new Api.class_1391() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
      // $FF: synthetic method
      public Api.class_1390 method_442(Context var1, Looper var2, class_347 var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.method_3042(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      // $FF: renamed from: d (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.lu
      public class_91 method_3042(Context var1, Looper var2, class_347 var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         String[] var7 = class_978.method_5443(var3.method_2420());
         return new class_293(var1, var2, var5, var6, var3.method_2418(), var7);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
   public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
   public static final HistoryApi HistoryApi;
   public static final RecordingApi RecordingApi;
   public static final Scope SCOPE_ACTIVITY_READ;
   public static final Scope SCOPE_ACTIVITY_READ_WRITE;
   public static final Scope SCOPE_BODY_READ;
   public static final Scope SCOPE_BODY_READ_WRITE;
   public static final Scope SCOPE_LOCATION_READ;
   public static final Scope SCOPE_LOCATION_READ_WRITE;
   public static final SensorsApi SensorsApi;
   public static final SessionsApi SessionsApi;
   // $FF: renamed from: TK com.google.android.gms.internal.mf
   public static final class_154 field_3858;

   static {
      API = new Api(field_3857, field_3856, new Scope[0]);
      SensorsApi = new class_774();
      RecordingApi = new class_784();
      SessionsApi = new class_775();
      HistoryApi = new class_786();
      ConfigApi = new class_785();
      BleApi = method_5102();
      field_3858 = new class_783();
      SCOPE_ACTIVITY_READ = new Scope("https://www.googleapis.com/auth/fitness.activity.read");
      SCOPE_ACTIVITY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.activity.write");
      SCOPE_LOCATION_READ = new Scope("https://www.googleapis.com/auth/fitness.location.read");
      SCOPE_LOCATION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.location.write");
      SCOPE_BODY_READ = new Scope("https://www.googleapis.com/auth/fitness.body.read");
      SCOPE_BODY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.body.write");
   }

   public static long getEndTime(Intent var0, TimeUnit var1) {
      long var2 = var0.getLongExtra("vnd.google.fitness.end_time", -1L);
      return var2 == -1L?-1L:var1.convert(var2, TimeUnit.MILLISECONDS);
   }

   public static long getStartTime(Intent var0, TimeUnit var1) {
      long var2 = var0.getLongExtra("vnd.google.fitness.start_time", -1L);
      return var2 == -1L?-1L:var1.convert(var2, TimeUnit.MILLISECONDS);
   }

   // $FF: renamed from: jj () com.google.android.gms.fitness.BleApi
   private static BleApi method_5102() {
      return (BleApi)(VERSION.SDK_INT >= 18?new class_781():new class_773());
   }
}
