package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.bl
@ez
public class class_251 {
    private final Context mContext;

    public class_251(Context var1) {
        class_1090.method_5681(var1, "Context can not be null");
        this.mContext = var1;
    }

    // $FF: renamed from: bn () boolean
    public static boolean method_1607() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    // $FF: renamed from: a (android.content.Intent) boolean
    public boolean method_1608(Intent var1) {
        class_1090.method_5681(var1, "Intent can not be null");
        boolean var3 = this.mContext.getPackageManager().queryIntentActivities(var1, 0).isEmpty();
        boolean var4 = false;
        if(!var3) {
            var4 = true;
        }

        return var4;
    }

    // $FF: renamed from: bj () boolean
    public boolean method_1609() {
        Intent var1 = new Intent("android.intent.action.DIAL");
        var1.setData(Uri.parse("tel:"));
        return this.method_1608(var1);
    }

    // $FF: renamed from: bk () boolean
    public boolean method_1610() {
        Intent var1 = new Intent("android.intent.action.VIEW");
        var1.setData(Uri.parse("sms:"));
        return this.method_1608(var1);
    }

    // $FF: renamed from: bl () boolean
    public boolean method_1611() {
        return method_1607() && this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    // $FF: renamed from: bm () boolean
    public boolean method_1612() {
        return false;
    }

    // $FF: renamed from: bo () boolean
    public boolean method_1613() {
        Intent var1 = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.dir/event");
        return VERSION.SDK_INT >= 14 && this.method_1608(var1);
    }
}
