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
import com.google.android.gms.class_492;
import com.google.android.gms.internal.class_251;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_389;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.gv;
import java.util.Map;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.de
@ez
public class class_485 {
    private final Context mContext;
    // $FF: renamed from: md com.google.android.gms.internal.gv
    private final class_381 field_1943;
    // $FF: renamed from: qM java.util.Map
    private final Map<String, String> field_1944;

    public class_485(gv var1, Map<String, String> var2) {
        this.field_1943 = var1;
        this.field_1944 = var2;
        this.mContext = var1.method_2491();
    }

    // $FF: renamed from: B (java.lang.String) java.lang.String
    String method_2973(String var1) {
        return Uri.parse(var1).getLastPathSegment();
    }

    // $FF: renamed from: b (java.lang.String, java.lang.String) android.app.DownloadManager.Request
    Request method_2974(String var1, String var2) {
        Request var3 = new Request(Uri.parse(var1));
        var3.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, var2);
        var3.allowScanningByMediaScanner();
        var3.setNotificationVisibility(1);
        return var3;
    }

    public void execute() {
        if(!(new class_251(this.mContext)).method_1611()) {
            class_378.method_2461("Store picture feature is not supported on this device.");
        } else if(TextUtils.isEmpty((CharSequence)this.field_1944.get("iurl"))) {
            class_378.method_2461("Image url cannot be empty.");
        } else {
            final String var1 = (String)this.field_1944.get("iurl");
            if(!URLUtil.isValidUrl(var1)) {
                class_378.method_2461("Invalid image url:" + var1);
            } else {
                final String var2 = this.method_2973(var1);
                if(!class_383.method_2501(var2)) {
                    class_378.method_2461("Image type not recognized:");
                } else {
                    Builder var3 = new Builder(this.mContext);
                    var3.setTitle(class_389.method_2554(class_492.string.store_picture_title, "Save image"));
                    var3.setMessage(class_389.method_2554(class_492.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                    var3.setPositiveButton(class_389.method_2554(class_492.string.accept, "Accept"), new OnClickListener() {
                        public void onClick(DialogInterface var1x, int var2x) {
                            DownloadManager var3 = (DownloadManager)class_485.this.mContext.getSystemService("download");

                            try {
                                var3.enqueue(class_485.this.method_2974(var1, var2));
                            } catch (IllegalStateException var5) {
                                class_378.method_2459("Could not store picture.");
                            }
                        }
                    });
                    var3.setNegativeButton(class_389.method_2554(class_492.string.decline, "Decline"), new OnClickListener() {
                        public void onClick(DialogInterface var1, int var2) {
                            class_485.this.field_1943.method_2481("onStorePictureCanceled", new JSONObject());
                        }
                    });
                    var3.create().show();
                }
            }
        }
    }
}
