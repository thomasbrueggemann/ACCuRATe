package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.TypedValue;
import com.google.android.gms.common.ErrorDialogFragment;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.SupportErrorDialogFragment;
import com.google.android.gms.common.zze;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzne;

public final class GooglePlayServicesUtil extends zze {
   @Deprecated
   public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;

   static {
      GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
   }

   @Deprecated
   public static Dialog getErrorDialog(int var0, Activity var1, int var2) {
      return getErrorDialog(var0, var1, var2, (OnCancelListener)null);
   }

   @Deprecated
   public static Dialog getErrorDialog(int var0, Activity var1, int var2, OnCancelListener var3) {
      return zza(var0, var1, (Fragment)null, var2, var3);
   }

   public static Context getRemoteContext(Context var0) {
      return zze.getRemoteContext(var0);
   }

   @Deprecated
   public static int isGooglePlayServicesAvailable(Context var0) {
      return zze.isGooglePlayServicesAvailable(var0);
   }

   public static boolean showErrorDialogFragment(int var0, Activity var1, Fragment var2, int var3, OnCancelListener var4) {
      Dialog var5 = zza(var0, var1, var2, var3, var4);
      if(var5 == null) {
         return false;
      } else {
         zza(var1, var4, "GooglePlayServicesErrorDialog", var5);
         return true;
      }
   }

   @TargetApi(14)
   private static Dialog zza(int var0, Activity var1, Fragment var2, int var3, OnCancelListener var4) {
      if(var0 == 0) {
         return null;
      } else {
         if(zzmu.zzaw(var1) && var0 == 2) {
            var0 = 42;
         }

         if(zzd(var1, var0)) {
            var0 = 18;
         }

         boolean var5 = zzne.zzsg();
         Builder var6 = null;
         if(var5) {
            TypedValue var7 = new TypedValue();
            var1.getTheme().resolveAttribute(16843529, var7, true);
            boolean var9 = "Theme.Dialog.Alert".equals(var1.getResources().getResourceEntryName(var7.resourceId));
            var6 = null;
            if(var9) {
               var6 = new Builder(var1, 5);
            }
         }

         if(var6 == null) {
            var6 = new Builder(var1);
         }

         var6.setMessage(zzg.zzc(var1, var0, zzao(var1)));
         if(var4 != null) {
            var6.setOnCancelListener(var4);
         }

         Intent var11 = GoogleApiAvailability.getInstance().zza(var1, var0, "d");
         zzh var12;
         if(var2 == null) {
            var12 = new zzh(var1, var11, var3);
         } else {
            var12 = new zzh(var2, var11, var3);
         }

         String var13 = zzg.zzh(var1, var0);
         if(var13 != null) {
            var6.setPositiveButton(var13, var12);
         }

         String var14 = zzg.zzg(var1, var0);
         if(var14 != null) {
            var6.setTitle(var14);
         }

         return var6.create();
      }
   }

   @TargetApi(11)
   public static void zza(Activity var0, OnCancelListener var1, String var2, @NonNull Dialog var3) {
      boolean var5;
      try {
         var5 = var0 instanceof FragmentActivity;
      } catch (NoClassDefFoundError var8) {
         var5 = false;
      }

      if(var5) {
         FragmentManager var7 = ((FragmentActivity)var0).getSupportFragmentManager();
         SupportErrorDialogFragment.newInstance(var3, var1).show(var7, var2);
      } else if(zzne.zzsd()) {
         android.app.FragmentManager var6 = var0.getFragmentManager();
         ErrorDialogFragment.newInstance(var3, var1).show(var6, var2);
      } else {
         throw new RuntimeException("This Activity does not support Fragments.");
      }
   }

   @Deprecated
   public static Intent zzbv(int var0) {
      return zze.zzbv(var0);
   }

   @Deprecated
   public static boolean zzd(Context var0, int var1) {
      return zze.zzd(var0, var1);
   }
}
