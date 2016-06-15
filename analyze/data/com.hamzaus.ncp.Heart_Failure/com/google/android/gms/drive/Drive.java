package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.class_90;
import com.google.android.gms.drive.class_91;
import com.google.android.gms.drive.internal.class_213;
import com.google.android.gms.drive.internal.class_218;
import com.google.android.gms.drive.internal.class_233;
import com.google.android.gms.drive.internal.class_245;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.internal.gz;
import java.util.List;

public final class Drive {
   public static final Api<Api.NoOptions> API;
   public static final DriveApi DriveApi;
   // $FF: renamed from: HE com.google.android.gms.common.api.Scope
   public static final Scope field_3063 = new Scope("https://www.googleapis.com/auth/drive");
   // $FF: renamed from: HF com.google.android.gms.common.api.Scope
   public static final Scope field_3064 = new Scope("https://www.googleapis.com/auth/drive.apps");
   // $FF: renamed from: HG com.google.android.gms.common.api.Api
   public static final Api<Drive.class_847> field_3065;
   // $FF: renamed from: HH com.google.android.gms.drive.b
   public static final class_91 field_3066;
   // $FF: renamed from: HI com.google.android.gms.drive.d
   public static final class_90 field_3067;
   public static final Scope SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
   public static final Scope SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
   // $FF: renamed from: yE com.google.android.gms.common.api.Api$c
   public static final Api.class_1077<r> field_3068 = new Api.class_1077();

   static {
      API = new Api(new Drive.class_846() {
         // $FF: renamed from: a (com.google.android.gms.common.api.Api$ApiOptions$NoOptions) android.os.Bundle
         protected Bundle method_2505(Api.NoOptions var1) {
            return new Bundle();
         }
      }, field_3068, new Scope[0]);
      field_3065 = new Api(new Drive.class_846() {
         // $FF: renamed from: a (com.google.android.gms.drive.Drive$b) android.os.Bundle
         protected Bundle method_2506(Drive.class_847 var1) {
            return var1 == null?new Bundle():var1.method_2507();
         }
      }, field_3068, new Scope[0]);
      DriveApi = new class_233();
      field_3066 = new class_213();
      field_3067 = new class_218();
   }

   public abstract static class class_846<O extends Api.ApiOptions> implements Api.class_1074<r, O> {
      // $FF: renamed from: a (com.google.android.gms.common.api.Api$ApiOptions) android.os.Bundle
      protected abstract Bundle method_2503(O var1);

      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.drive.internal.r
      public r method_2504(Context var1, Looper var2, gz var3, O var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         List var7 = var3.method_2057();
         return new class_245(var1, var2, var3, var5, var6, (String[])var7.toArray(new String[var7.size()]), this.method_2503(var4));
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   }

   public static class class_847 implements Api.Optional {
      // $FF: renamed from: HJ android.os.Bundle
      private final Bundle field_1797;

      private class_847() {
         this(new Bundle());
      }

      private class_847(Bundle var1) {
         this.field_1797 = var1;
      }

      // $FF: renamed from: ge () android.os.Bundle
      public Bundle method_2507() {
         return this.field_1797;
      }
   }
}
