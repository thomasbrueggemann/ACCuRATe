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
import com.google.android.gms.class_54;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;
import java.util.Map;

@zzhb
public class zzfp extends zzfs {
   private final Context mContext;
   private final Map<String, String> zzxA;

   public zzfp(zzjp var1, Map<String, String> var2) {
      super(var1, "storePicture");
      this.zzxA = var2;
      this.mContext = var1.zzhP();
   }

   public void execute() {
      if(this.mContext == null) {
         this.zzam("Activity context is not available");
      } else if(!com.google.android.gms.ads.internal.zzr.zzbC().zzM(this.mContext).zzdl()) {
         this.zzam("Feature is not supported by the device.");
      } else {
         final String var1 = (String)this.zzxA.get("iurl");
         if(TextUtils.isEmpty(var1)) {
            this.zzam("Image url cannot be empty.");
         } else if(!URLUtil.isValidUrl(var1)) {
            this.zzam("Invalid image url: " + var1);
         } else {
            final String var2 = this.zzal(var1);
            if(!com.google.android.gms.ads.internal.zzr.zzbC().zzaE(var2)) {
               this.zzam("Image type not recognized: " + var2);
            } else {
               Builder var3 = com.google.android.gms.ads.internal.zzr.zzbC().zzL(this.mContext);
               var3.setTitle(com.google.android.gms.ads.internal.zzr.zzbF().zzd(class_54.string.store_picture_title, "Save image"));
               var3.setMessage(com.google.android.gms.ads.internal.zzr.zzbF().zzd(class_54.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
               var3.setPositiveButton(com.google.android.gms.ads.internal.zzr.zzbF().zzd(class_54.string.accept, "Accept"), new OnClickListener() {
                  public void onClick(DialogInterface var1x, int var2x) {
                     DownloadManager var3 = (DownloadManager)zzfp.this.mContext.getSystemService("download");

                     try {
                        var3.enqueue(zzfp.this.zzf(var1, var2));
                     } catch (IllegalStateException var5) {
                        zzfp.this.zzam("Could not store picture.");
                     }
                  }
               });
               var3.setNegativeButton(com.google.android.gms.ads.internal.zzr.zzbF().zzd(class_54.string.decline, "Decline"), new OnClickListener() {
                  public void onClick(DialogInterface var1, int var2) {
                     zzfp.this.zzam("User canceled the download.");
                  }
               });
               var3.create().show();
            }
         }
      }
   }

   String zzal(String var1) {
      return Uri.parse(var1).getLastPathSegment();
   }

   Request zzf(String var1, String var2) {
      Request var3 = new Request(Uri.parse(var1));
      var3.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, var2);
      com.google.android.gms.ads.internal.zzr.zzbE().zza(var3);
      return var3;
   }
}
