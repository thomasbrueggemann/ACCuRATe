package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
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

// $FF: renamed from: com.google.android.gms.internal.dc
@ez
public class class_480 {
    private final Context mContext;
    // $FF: renamed from: md com.google.android.gms.internal.gv
    private final class_381 field_1910;
    // $FF: renamed from: qM java.util.Map
    private final Map<String, String> field_1911;
    // $FF: renamed from: qN java.lang.String
    private String field_1912;
    // $FF: renamed from: qO long
    private long field_1913;
    // $FF: renamed from: qP long
    private long field_1914;
    // $FF: renamed from: qQ java.lang.String
    private String field_1915;
    // $FF: renamed from: qR java.lang.String
    private String field_1916;

    public class_480(gv var1, Map<String, String> var2) {
        this.field_1910 = var1;
        this.field_1911 = var2;
        this.mContext = var1.method_2491();
        this.method_2953();
    }

    // $FF: renamed from: A (java.lang.String) java.lang.String
    private String method_2950(String var1) {
        return TextUtils.isEmpty((CharSequence)this.field_1911.get(var1))?"":(String)this.field_1911.get(var1);
    }

    // $FF: renamed from: bG () void
    private void method_2953() {
        this.field_1912 = this.method_2950("description");
        this.field_1915 = this.method_2950("summary");
        this.field_1913 = class_383.method_2502((String)this.field_1911.get("start"));
        this.field_1914 = class_383.method_2502((String)this.field_1911.get("end"));
        this.field_1916 = this.method_2950("location");
    }

    Intent createIntent() {
        Intent var1 = (new Intent("android.intent.action.EDIT")).setData(Events.CONTENT_URI);
        var1.putExtra("title", this.field_1915);
        var1.putExtra("eventLocation", this.field_1916);
        var1.putExtra("description", this.field_1912);
        var1.putExtra("beginTime", this.field_1913);
        var1.putExtra("endTime", this.field_1914);
        var1.setFlags(268435456);
        return var1;
    }

    public void execute() {
        if(!(new class_251(this.mContext)).method_1613()) {
            class_378.method_2461("This feature is not available on this version of the device.");
        } else {
            Builder var1 = new Builder(this.mContext);
            var1.setTitle(class_389.method_2554(class_492.string.create_calendar_title, "Create calendar event"));
            var1.setMessage(class_389.method_2554(class_492.string.create_calendar_message, "Allow Ad to create a calendar event?"));
            var1.setPositiveButton(class_389.method_2554(class_492.string.accept, "Accept"), new OnClickListener() {
                public void onClick(DialogInterface var1, int var2) {
                    Intent var3 = class_480.this.createIntent();
                    class_480.this.mContext.startActivity(var3);
                }
            });
            var1.setNegativeButton(class_389.method_2554(class_492.string.decline, "Decline"), new OnClickListener() {
                public void onClick(DialogInterface var1, int var2) {
                    class_480.this.field_1910.method_2481("onCalendarEventCanceled", new JSONObject());
                }
            });
            var1.create().show();
        }
    }
}
