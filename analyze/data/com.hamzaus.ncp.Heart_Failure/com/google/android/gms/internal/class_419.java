package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_40;
import com.google.android.gms.internal.class_421;

// $FF: renamed from: com.google.android.gms.internal.cd
public final class class_419 {
   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.cf, com.google.android.gms.internal.cm) boolean
   public static boolean method_2549(Context var0, class_421 var1, class_40 var2) {
      if(var1 == null) {
         class_370.method_2358("No intent data for launcher overlay.");
         return false;
      } else {
         Intent var3 = new Intent();
         if(TextUtils.isEmpty(var1.field_1841)) {
            class_370.method_2358("Open GMSG did not contain a URL.");
            return false;
         } else {
            if(!TextUtils.isEmpty(var1.mimeType)) {
               var3.setDataAndType(Uri.parse(var1.field_1841), var1.mimeType);
            } else {
               var3.setData(Uri.parse(var1.field_1841));
            }

            var3.setAction("android.intent.action.VIEW");
            if(!TextUtils.isEmpty(var1.packageName)) {
               var3.setPackage(var1.packageName);
            }

            if(!TextUtils.isEmpty(var1.field_1842)) {
               String[] var7 = var1.field_1842.split("/", 2);
               if(var7.length < 2) {
                  class_370.method_2358("Could not parse component name from open GMSG: " + var1.field_1842);
                  return false;
               }

               var3.setClassName(var7[0], var7[1]);
            }

            try {
               class_370.method_2357("Launching an intent: " + var3);
               var0.startActivity(var3);
               var2.method_201();
               return true;
            } catch (ActivityNotFoundException var8) {
               class_370.method_2358(var8.getMessage());
               return false;
            }
         }
      }
   }
}
