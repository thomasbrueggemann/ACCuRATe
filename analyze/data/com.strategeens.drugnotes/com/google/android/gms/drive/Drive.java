package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.class_97;
import com.google.android.gms.drive.class_98;
import com.google.android.gms.drive.internal.class_263;
import com.google.android.gms.drive.internal.class_264;
import com.google.android.gms.drive.internal.class_266;
import com.google.android.gms.drive.internal.class_282;
import com.google.android.gms.drive.internal.class_299;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.internal.jg;
import java.util.List;

public final class Drive {
   public static final Api<Api.NoOptions> API;
   // $FF: renamed from: DQ com.google.android.gms.common.api.Api$c
   public static final Api.class_1394<r> field_2928 = new Api.class_1394();
   public static final DriveApi DriveApi;
   public static final DrivePreferencesApi DrivePreferencesApi;
   // $FF: renamed from: Oo com.google.android.gms.common.api.Scope
   public static final Scope field_2929 = new Scope("https://www.googleapis.com/auth/drive");
   // $FF: renamed from: Op com.google.android.gms.common.api.Scope
   public static final Scope field_2930 = new Scope("https://www.googleapis.com/auth/drive.apps");
   // $FF: renamed from: Oq com.google.android.gms.common.api.Api
   public static final Api<Drive.class_1149> field_2931;
   // $FF: renamed from: Or com.google.android.gms.drive.b
   public static final class_98 field_2932;
   // $FF: renamed from: Os com.google.android.gms.drive.e
   public static final class_97 field_2933;
   public static final Scope SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
   public static final Scope SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");

   static {
      API = new Api(new Drive.class_1148() {
         // $FF: renamed from: a (com.google.android.gms.common.api.Api$ApiOptions$NoOptions) android.os.Bundle
         protected Bundle method_2890(Api.NoOptions var1) {
            return new Bundle();
         }
      }, field_2928, new Scope[0]);
      field_2931 = new Api(new Drive.class_1148() {
         // $FF: renamed from: a (com.google.android.gms.drive.Drive$b) android.os.Bundle
         protected Bundle method_2891(Drive.class_1149 var1) {
            return var1 == null?new Bundle():var1.method_2892();
         }
      }, field_2928, new Scope[0]);
      DriveApi = new class_282();
      field_2932 = new class_263();
      field_2933 = new class_266();
      DrivePreferencesApi = new class_264();
   }

   public abstract static class class_1148<O extends Api.ApiOptions> implements Api.class_1391<r, O> {
      // $FF: renamed from: a (com.google.android.gms.common.api.Api$ApiOptions) android.os.Bundle
      protected abstract Bundle method_2888(O var1);

      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.drive.internal.r
      public r method_2889(Context var1, Looper var2, jg var3, O var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         List var7 = var3.method_2420();
         return new class_299(var1, var2, var3, var5, var6, (String[])var7.toArray(new String[var7.size()]), this.method_2888(var4));
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   }

   public static class class_1149 implements Api.Optional {
      // $FF: renamed from: DJ android.os.Bundle
      private final Bundle field_1480;

      private class_1149() {
         this(new Bundle());
      }

      private class_1149(Bundle var1) {
         this.field_1480 = var1;
      }

      // $FF: renamed from: iq () android.os.Bundle
      public Bundle method_2892() {
         return this.field_1480;
      }
   }
}
