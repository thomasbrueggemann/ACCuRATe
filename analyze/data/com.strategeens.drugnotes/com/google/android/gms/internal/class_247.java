package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Build.VERSION;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.bl
@ey
public class class_247 {
   private final Context mContext;

   public class_247(Context var1) {
      class_335.method_2306(var1, "Context can not be null");
      this.mContext = var1;
   }

   // $FF: renamed from: bs () boolean
   public static boolean method_1619() {
      return "mounted".equals(Environment.getExternalStorageState());
   }

   // $FF: renamed from: a (android.content.Intent) boolean
   public boolean method_1620(Intent var1) {
      class_335.method_2306(var1, "Intent can not be null");
      boolean var3 = this.mContext.getPackageManager().queryIntentActivities(var1, 0).isEmpty();
      boolean var4 = false;
      if(!var3) {
         var4 = true;
      }

      return var4;
   }

   // $FF: renamed from: bo () boolean
   public boolean method_1621() {
      Intent var1 = new Intent("android.intent.action.DIAL");
      var1.setData(Uri.parse("tel:"));
      return this.method_1620(var1);
   }

   // $FF: renamed from: bp () boolean
   public boolean method_1622() {
      Intent var1 = new Intent("android.intent.action.VIEW");
      var1.setData(Uri.parse("sms:"));
      return this.method_1620(var1);
   }

   // $FF: renamed from: bq () boolean
   public boolean method_1623() {
      return method_1619() && this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
   }

   // $FF: renamed from: br () boolean
   public boolean method_1624() {
      return false;
   }

   // $FF: renamed from: bt () boolean
   public boolean method_1625() {
      Intent var1 = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.dir/event");
      return VERSION.SDK_INT >= 14 && this.method_1620(var1);
   }
}
