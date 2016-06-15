package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.app.AlertDialog.Builder;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.class_482;
import com.google.android.gms.internal.class_247;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_712;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gu;
import java.util.Map;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.dj
@ey
public class class_476 {
   private final Context mContext;
   // $FF: renamed from: mo com.google.android.gms.internal.gu
   private final class_371 field_1623;
   // $FF: renamed from: rd java.util.Map
   private final Map<String, String> field_1624;

   public class_476(gu var1, Map<String, String> var2) {
      this.field_1623 = var1;
      this.field_1624 = var2;
      this.mContext = var1.method_2536();
   }

   // $FF: renamed from: B (java.lang.String) java.lang.String
   String method_3012(String var1) {
      return Uri.parse(var1).getLastPathSegment();
   }

   // $FF: renamed from: b (java.lang.String, java.lang.String) android.app.DownloadManager.Request
   Request method_3013(String var1, String var2) {
      Request var3 = new Request(Uri.parse(var1));
      var3.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, var2);
      if(class_712.method_4177()) {
         var3.allowScanningByMediaScanner();
         var3.setNotificationVisibility(1);
         return var3;
      } else {
         var3.setShowRunningNotification(true);
         return var3;
      }
   }

   public void execute() {
      if(!(new class_247(this.mContext)).method_1623()) {
         class_368.method_2506("Store picture feature is not supported on this device.");
      } else if(TextUtils.isEmpty((CharSequence)this.field_1624.get("iurl"))) {
         class_368.method_2506("Image url cannot be empty.");
      } else {
         final String var1 = (String)this.field_1624.get("iurl");
         if(!URLUtil.isValidUrl(var1)) {
            class_368.method_2506("Invalid image url:" + var1);
         } else {
            final String var2 = this.method_3012(var1);
            if(!class_375.method_2548(var2)) {
               class_368.method_2506("Image type not recognized:");
            } else {
               Builder var3 = new Builder(this.mContext);
               var3.setTitle(class_381.method_2606(class_482.string.store_picture_title, "Save image"));
               var3.setMessage(class_381.method_2606(class_482.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
               var3.setPositiveButton(class_381.method_2606(class_482.string.accept, "Accept"), new OnClickListener() {
                  public void onClick(DialogInterface var1x, int var2x) {
                     DownloadManager var3 = (DownloadManager)class_476.this.mContext.getSystemService("download");

                     try {
                        var3.enqueue(class_476.this.method_3013(var1, var2));
                     } catch (IllegalStateException var5) {
                        class_368.method_2504("Could not store picture.");
                     }
                  }
               });
               var3.setNegativeButton(class_381.method_2606(class_482.string.decline, "Decline"), new OnClickListener() {
                  public void onClick(DialogInterface var1, int var2) {
                     class_476.this.field_1623.method_2526("onStorePictureCanceled", new JSONObject());
                  }
               });
               var3.create().show();
            }
         }
      }
   }
}
