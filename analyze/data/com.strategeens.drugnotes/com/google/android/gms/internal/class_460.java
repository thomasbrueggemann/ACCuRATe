package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_458;
import com.google.android.gms.internal.class_50;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.dm
@ey
public final class class_460 {
   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.do, com.google.android.gms.internal.dv) boolean
   public static boolean method_2926(Context var0, class_458 var1, class_50 var2) {
      if(var1 == null) {
         class_368.method_2506("No intent data for launcher overlay.");
         return false;
      } else {
         Intent var3 = new Intent();
         if(TextUtils.isEmpty(var1.field_1540)) {
            class_368.method_2506("Open GMSG did not contain a URL.");
            return false;
         } else {
            if(!TextUtils.isEmpty(var1.mimeType)) {
               var3.setDataAndType(Uri.parse(var1.field_1540), var1.mimeType);
            } else {
               var3.setData(Uri.parse(var1.field_1540));
            }

            var3.setAction("android.intent.action.VIEW");
            if(!TextUtils.isEmpty(var1.packageName)) {
               var3.setPackage(var1.packageName);
            }

            if(!TextUtils.isEmpty(var1.field_1541)) {
               String[] var7 = var1.field_1541.split("/", 2);
               if(var7.length < 2) {
                  class_368.method_2506("Could not parse component name from open GMSG: " + var1.field_1541);
                  return false;
               }

               var3.setClassName(var7[0], var7[1]);
            }

            try {
               class_368.method_2505("Launching an intent: " + var3);
               var0.startActivity(var3);
               var2.method_218();
               return true;
            } catch (ActivityNotFoundException var8) {
               class_368.method_2506(var8.getMessage());
               return false;
            }
         }
      }
   }
}
