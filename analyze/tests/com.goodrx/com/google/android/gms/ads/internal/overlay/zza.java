package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
public class zza {
   public boolean zza(Context param1, Intent param2, zzp param3) {
      // $FF: Couldn't be decompiled
   }

   public boolean zza(Context var1, AdLauncherIntentInfoParcel var2, zzp var3) {
      if(var2 == null) {
         zzin.zzaK("No intent data for launcher overlay.");
         return false;
      } else if(var2.intent != null) {
         return this.zza(var1, var2.intent, var3);
      } else {
         Intent var4 = new Intent();
         if(TextUtils.isEmpty(var2.url)) {
            zzin.zzaK("Open GMSG did not contain a URL.");
            return false;
         } else {
            if(!TextUtils.isEmpty(var2.mimeType)) {
               var4.setDataAndType(Uri.parse(var2.url), var2.mimeType);
            } else {
               var4.setData(Uri.parse(var2.url));
            }

            var4.setAction("android.intent.action.VIEW");
            if(!TextUtils.isEmpty(var2.packageName)) {
               var4.setPackage(var2.packageName);
            }

            if(!TextUtils.isEmpty(var2.zzDK)) {
               String[] var12 = var2.zzDK.split("/", 2);
               if(var12.length < 2) {
                  zzin.zzaK("Could not parse component name from open GMSG: " + var2.zzDK);
                  return false;
               }

               var4.setClassName(var12[0], var12[1]);
            }

            String var7 = var2.zzDL;
            if(!TextUtils.isEmpty(var7)) {
               int var9;
               label34: {
                  int var11;
                  try {
                     var11 = Integer.parseInt(var7);
                  } catch (NumberFormatException var13) {
                     zzin.zzaK("Could not parse intent flags.");
                     var9 = 0;
                     break label34;
                  }

                  var9 = var11;
               }

               var4.addFlags(var9);
            }

            return this.zza(var1, var4, var3);
         }
      }
   }
}
