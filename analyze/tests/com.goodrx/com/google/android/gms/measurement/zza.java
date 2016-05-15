package com.google.android.gms.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.class_54;
import com.google.android.gms.common.api.Status;

public final class zza {
   private static volatile zza zzaUe;
   private final String zzaUa;
   private final Status zzaUb;
   private final boolean zzaUc;
   private final boolean zzaUd;

   zza(Context var1) {
      boolean var2 = true;
      super();
      Resources var3 = var1.getResources();
      String var4 = var3.getResourcePackageName(class_54.string.common_google_play_services_unknown_issue);
      int var5 = var3.getIdentifier("google_app_measurement_enable", "integer", var4);
      if(var5 != 0) {
         boolean var8;
         if(var3.getInteger(var5) != 0) {
            var8 = var2;
         } else {
            var8 = false;
         }

         if(var8) {
            var2 = false;
         }

         this.zzaUd = var2;
         var2 = var8;
      } else {
         this.zzaUd = false;
      }

      this.zzaUc = var2;
      int var6 = var3.getIdentifier("google_app_id", "string", var4);
      if(var6 == 0) {
         if(this.zzaUc) {
            this.zzaUb = new Status(10, "Missing an expected resource: \'R.string.google_app_id\' for initializing Google services.  Possible causes are missing google-services.json or com.google.gms.google-services gradle plugin.");
         } else {
            this.zzaUb = Status.zzagC;
         }

         this.zzaUa = null;
      } else {
         String var7 = var3.getString(var6);
         if(TextUtils.isEmpty(var7)) {
            if(this.zzaUc) {
               this.zzaUb = new Status(10, "The resource \'R.string.google_app_id\' is invalid, expected an app  identifier and found: \'" + var7 + "\'.");
            } else {
               this.zzaUb = Status.zzagC;
            }

            this.zzaUa = null;
         } else {
            this.zzaUa = var7;
            this.zzaUb = Status.zzagC;
         }
      }
   }

   zza(Context var1, String var2, boolean var3) {
      this.zzaUa = var2;
      this.zzaUb = Status.zzagC;
      this.zzaUc = var3;
      boolean var4;
      if(!var3) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.zzaUd = var4;
   }

   public static String zzAp() {
      // $FF: Couldn't be decompiled
   }

   public static boolean zzAr() {
      // $FF: Couldn't be decompiled
   }

   public static boolean zzAs() {
      // $FF: Couldn't be decompiled
   }

   public static Status zzaR(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static Status zzb(Context param0, String param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   String zzAq() {
      return this.zzaUa;
   }

   boolean zzAt() {
      return this.zzaUb.isSuccess() && this.zzaUc;
   }

   Status zzeu(String var1) {
      return this.zzaUa != null && !this.zzaUa.equals(var1)?new Status(10, "Initialize was called with two different Google App IDs.  Only the first app ID will be used: \'" + this.zzaUa + "\'."):Status.zzagC;
   }
}
