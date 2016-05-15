package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.class_54;
import com.google.android.gms.internal.zzmu;

public final class zzg {
   public static String zzc(Context var0, int var1, String var2) {
      Resources var3 = var0.getResources();
      switch(var1) {
      case 1:
         if(zzmu.zzb(var3)) {
            return var3.getString(class_54.string.common_google_play_services_install_text_tablet, new Object[]{var2});
         }

         return var3.getString(class_54.string.common_google_play_services_install_text_phone, new Object[]{var2});
      case 2:
         return var3.getString(class_54.string.common_google_play_services_update_text, new Object[]{var2});
      case 3:
         return var3.getString(class_54.string.common_google_play_services_enable_text, new Object[]{var2});
      case 5:
         return var3.getString(class_54.string.common_google_play_services_invalid_account_text);
      case 7:
         return var3.getString(class_54.string.common_google_play_services_network_error_text);
      case 9:
         return var3.getString(class_54.string.common_google_play_services_unsupported_text, new Object[]{var2});
      case 16:
         return var3.getString(class_54.string.common_google_play_services_api_unavailable_text, new Object[]{var2});
      case 17:
         return var3.getString(class_54.string.common_google_play_services_sign_in_failed_text);
      case 18:
         return var3.getString(class_54.string.common_google_play_services_updating_text, new Object[]{var2});
      case 20:
         return var3.getString(class_54.string.common_google_play_services_restricted_profile_text);
      case 42:
         return var3.getString(class_54.string.common_google_play_services_wear_update_text);
      default:
         return var3.getString(class_54.string.common_google_play_services_unknown_issue, new Object[]{var2});
      }
   }

   @Nullable
   public static final String zzg(Context var0, int var1) {
      Resources var2 = var0.getResources();
      switch(var1) {
      case 1:
         return var2.getString(class_54.string.common_google_play_services_install_title);
      case 2:
      case 42:
         return var2.getString(class_54.string.common_google_play_services_update_title);
      case 3:
         return var2.getString(class_54.string.common_google_play_services_enable_title);
      case 5:
         Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
         return var2.getString(class_54.string.common_google_play_services_invalid_account_title);
      case 7:
         Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
         return var2.getString(class_54.string.common_google_play_services_network_error_title);
      case 8:
         Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
         return null;
      case 9:
         Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
         return var2.getString(class_54.string.common_google_play_services_unsupported_title);
      case 10:
         Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
         return null;
      case 11:
         Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
         return null;
      case 16:
         Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
         return null;
      case 17:
         Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
         return var2.getString(class_54.string.common_google_play_services_sign_in_failed_title);
      case 18:
         return var2.getString(class_54.string.common_google_play_services_updating_title);
      case 20:
         Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
         return var2.getString(class_54.string.common_google_play_services_restricted_profile_title);
      default:
         Log.e("GoogleApiAvailability", "Unexpected error code " + var1);
      case 4:
      case 6:
         return null;
      }
   }

   public static String zzh(Context var0, int var1) {
      Resources var2 = var0.getResources();
      switch(var1) {
      case 1:
         return var2.getString(class_54.string.common_google_play_services_install_button);
      case 2:
         return var2.getString(class_54.string.common_google_play_services_update_button);
      case 3:
         return var2.getString(class_54.string.common_google_play_services_enable_button);
      default:
         return var2.getString(17039370);
      }
   }
}
