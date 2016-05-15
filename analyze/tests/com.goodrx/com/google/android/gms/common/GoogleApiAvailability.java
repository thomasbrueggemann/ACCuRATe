package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.google.android.gms.class_54;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.zzc;

public class GoogleApiAvailability extends zzc {
   public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
   private static final GoogleApiAvailability zzafE = new GoogleApiAvailability();

   static {
      GOOGLE_PLAY_SERVICES_VERSION_CODE = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
   }

   public static GoogleApiAvailability getInstance() {
      return zzafE;
   }

   public int isGooglePlayServicesAvailable(Context var1) {
      return super.isGooglePlayServicesAvailable(var1);
   }

   public final boolean isUserResolvableError(int var1) {
      return super.isUserResolvableError(var1);
   }

   public Dialog zza(Activity var1, OnCancelListener var2) {
      ProgressBar var3 = new ProgressBar(var1, (AttributeSet)null, 16842874);
      var3.setIndeterminate(true);
      var3.setVisibility(0);
      Builder var4 = new Builder(var1);
      var4.setView(var3);
      String var6 = GooglePlayServicesUtil.zzao(var1);
      var4.setMessage(var1.getResources().getString(class_54.string.common_google_play_services_updating_text, new Object[]{var6}));
      var4.setTitle(class_54.string.common_google_play_services_updating_title);
      var4.setPositiveButton("", (OnClickListener)null);
      AlertDialog var10 = var4.create();
      GooglePlayServicesUtil.zza(var1, var2, "GooglePlayServicesUpdatingDialog", var10);
      return var10;
   }

   @Nullable
   public Intent zza(Context var1, int var2, @Nullable String var3) {
      return super.zza(var1, var2, var3);
   }

   @Deprecated
   @Nullable
   public Intent zzbu(int var1) {
      return super.zzbu(var1);
   }

   public boolean zzd(Context var1, int var2) {
      return super.zzd(var1, var2);
   }
}
