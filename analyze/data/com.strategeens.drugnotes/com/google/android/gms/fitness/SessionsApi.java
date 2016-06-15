package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.class_703;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.class_335;

public interface SessionsApi {
   PendingResult<Status> insertSession(GoogleApiClient var1, SessionInsertRequest var2);

   PendingResult<SessionReadResult> readSession(GoogleApiClient var1, SessionReadRequest var2);

   PendingResult<Status> registerForSessions(GoogleApiClient var1, PendingIntent var2);

   PendingResult<Status> startSession(GoogleApiClient var1, Session var2);

   PendingResult<SessionStopResult> stopSession(GoogleApiClient var1, String var2);

   PendingResult<Status> unregisterForSessions(GoogleApiClient var1, PendingIntent var2);

   public static class ViewIntentBuilder {
      // $FF: renamed from: TP java.lang.String
      private String field_2951;
      // $FF: renamed from: TQ com.google.android.gms.fitness.data.Session
      private Session field_2952;
      // $FF: renamed from: TR boolean
      private boolean field_2953 = false;
      private final Context mContext;

      public ViewIntentBuilder(Context var1) {
         this.mContext = var1;
      }

      // $FF: renamed from: i (android.content.Intent) android.content.Intent
      private Intent method_3895(Intent var1) {
         if(this.field_2951 != null) {
            Intent var2 = (new Intent(var1)).setPackage(this.field_2951);
            ResolveInfo var3 = this.mContext.getPackageManager().resolveActivity(var2, 0);
            if(var3 != null) {
               String var4 = var3.activityInfo.name;
               var2.setComponent(new ComponentName(this.field_2951, var4));
               return var2;
            }
         }

         return var1;
      }

      public Intent build() {
         boolean var1;
         if(this.field_2952 != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         class_335.method_2302(var1, "Session must be set");
         Intent var2 = new Intent("vnd.google.fitness.VIEW");
         var2.setType(Session.getMimeType(this.field_2952.getActivity()));
         class_703.method_4021(this.field_2952, var2, "vnd.google.fitness.session");
         if(!this.field_2953) {
            this.field_2951 = this.field_2952.getAppPackageName();
         }

         return this.method_3895(var2);
      }

      public SessionsApi.ViewIntentBuilder setPreferredApplication(String var1) {
         this.field_2951 = var1;
         this.field_2953 = true;
         return this;
      }

      public SessionsApi.ViewIntentBuilder setSession(Session var1) {
         this.field_2952 = var1;
         return this;
      }
   }
}
