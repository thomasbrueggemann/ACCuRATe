package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_145;
import com.google.android.gms.internal.class_307;
import com.google.android.gms.internal.class_399;
import com.google.android.gms.internal.class_400;
import com.google.android.gms.internal.class_403;
import com.google.android.gms.internal.class_411;
import com.google.android.gms.internal.class_413;
import com.google.android.gms.internal.hi;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

// $FF: renamed from: com.google.android.gms.internal.hs
public class class_397 implements SafeParcelable {
    public static final class_400 CREATOR = new class_400();
    // $FF: renamed from: BR int
    final int field_1479;
    // $FF: renamed from: CD com.google.android.gms.internal.hg
    final class_411 field_1480;
    // $FF: renamed from: CE long
    final long field_1481;
    // $FF: renamed from: CF int
    final int field_1482;
    // $FF: renamed from: CG com.google.android.gms.internal.he
    final class_413 field_1483;
    // $FF: renamed from: oT java.lang.String
    public final String field_1484;

    class_397(int var1, class_411 var2, long var3, int var5, String var6, class_413 var7) {
        this.field_1479 = var1;
        this.field_1480 = var2;
        this.field_1481 = var3;
        this.field_1482 = var5;
        this.field_1484 = var6;
        this.field_1483 = var7;
    }

    public class_397(class_411 var1, long var2, int var4) {
        this(1, var1, var2, var4, (String)null, (class_413)null);
    }

    public class_397(String var1, Intent var2, String var3, Uri var4, String var5, List<AppIndexApi.AppIndexingLink> var6) {
        this(1, method_2616(var1, var2), System.currentTimeMillis(), 0, (String)null, method_2615(var2, var3, var4, var5, var6).method_5935());
    }

    // $FF: renamed from: a (android.content.Intent, java.lang.String, android.net.Uri, java.lang.String, java.util.List) com.google.android.gms.internal.he$a
    public static class_413.class_1646 method_2615(Intent var0, String var1, Uri var2, String var3, List<AppIndexApi.AppIndexingLink> var4) {
        class_413.class_1646 var5 = new class_413.class_1646();
        var5.method_5933(method_2617(var1));
        if(var2 != null) {
            var5.method_5933(method_2619(var2));
        }

        if(var4 != null) {
            var5.method_5933(method_2618(var4));
        }

        String var7 = var0.getAction();
        if(var7 != null) {
            var5.method_5933(method_2622("intent_action", var7));
        }

        String var8 = var0.getDataString();
        if(var8 != null) {
            var5.method_5933(method_2622("intent_data", var8));
        }

        ComponentName var9 = var0.getComponent();
        if(var9 != null) {
            var5.method_5933(method_2622("intent_activity", var9.getClassName()));
        }

        Bundle var10 = var0.getExtras();
        if(var10 != null) {
            String var11 = var10.getString("intent_extra_data_key");
            if(var11 != null) {
                var5.method_5933(method_2622("intent_extra_data", var11));
            }
        }

        return var5.method_5934(var3).method_5932(true);
    }

    // $FF: renamed from: a (java.lang.String, android.content.Intent) com.google.android.gms.internal.hg
    public static class_411 method_2616(String var0, Intent var1) {
        return method_2621(var0, method_2620(var1));
    }

    // $FF: renamed from: av (java.lang.String) com.google.android.gms.internal.hi
    private static class_403 method_2617(String var0) {
        return new class_403(var0, (new class_399.class_1737("title")).method_4921(1).method_4920(true).method_4923("name").method_4924(), "text1");
    }

    // $FF: renamed from: b (java.util.List) com.google.android.gms.internal.hi
    private static hi method_2618(List<AppIndexApi.AppIndexingLink> var0) {
        class_145.class_1538 var1 = new class_145.class_1538();
        class_145.class_1539[] var2 = new class_145.class_1539[var0.size()];

        for(int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3] = new class_145.class_1539();
            AppIndexApi.AppIndexingLink var4 = (AppIndexApi.AppIndexingLink)var0.get(var3);
            var2[var3].adG = var4.appIndexingUrl.toString();
            var2[var3].adH = var4.webUrl.toString();
            var2[var3].viewId = var4.viewId;
        }

        var1.adE = var2;
        return new class_403(class_307.method_2111(var1), (new class_399.class_1737("outlinks")).method_4919(true).method_4923(".private:outLinks").method_4922("blob").method_4924());
    }

    // $FF: renamed from: f (android.net.Uri) com.google.android.gms.internal.hi
    private static class_403 method_2619(Uri var0) {
        return new class_403(var0.toString(), (new class_399.class_1737("web_url")).method_4921(4).method_4919(true).method_4923("url").method_4924());
    }

    // $FF: renamed from: g (android.content.Intent) java.lang.String
    private static String method_2620(Intent var0) {
        String var1 = var0.toUri(1);
        CRC32 var2 = new CRC32();

        try {
            var2.update(var1.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException var4) {
            throw new IllegalStateException(var4);
        }

        return Long.toHexString(var2.getValue());
    }

    // $FF: renamed from: i (java.lang.String, java.lang.String) com.google.android.gms.internal.hg
    private static class_411 method_2621(String var0, String var1) {
        return new class_411(var0, "", var1);
    }

    // $FF: renamed from: j (java.lang.String, java.lang.String) com.google.android.gms.internal.hi
    private static class_403 method_2622(String var0, String var1) {
        return new class_403(var1, (new class_399.class_1737(var0)).method_4919(true).method_4924(), var0);
    }

    public int describeContents() {
        class_400 var10000 = CREATOR;
        return 0;
    }

    public String toString() {
        Object[] var1 = new Object[] {this.field_1480, Long.valueOf(this.field_1481), Integer.valueOf(this.field_1482)};
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_400 var10000 = CREATOR;
        class_400.method_2626(this, var1, var2);
    }
}
