package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Build.VERSION;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzbl {
   private final Context mContext;

   public zzbl(Context var1) {
      com.google.android.gms.common.internal.zzx.zzb(var1, "Context can not be null");
      this.mContext = var1;
   }

   public static boolean zzdn() {
      return "mounted".equals(Environment.getExternalStorageState());
   }

   public boolean zza(Intent var1) {
      com.google.android.gms.common.internal.zzx.zzb(var1, "Intent can not be null");
      boolean var3 = this.mContext.getPackageManager().queryIntentActivities(var1, 0).isEmpty();
      boolean var4 = false;
      if(!var3) {
         var4 = true;
      }

      return var4;
   }

   public boolean zzdj() {
      Intent var1 = new Intent("android.intent.action.DIAL");
      var1.setData(Uri.parse("tel:"));
      return this.zza(var1);
   }

   public boolean zzdk() {
      Intent var1 = new Intent("android.intent.action.VIEW");
      var1.setData(Uri.parse("sms:"));
      return this.zza(var1);
   }

   public boolean zzdl() {
      return zzdn() && this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
   }

   public boolean zzdm() {
      return true;
   }

   @TargetApi(14)
   public boolean zzdo() {
      Intent var1 = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.dir/event");
      return VERSION.SDK_INT >= 14 && this.zza(var1);
   }
}
