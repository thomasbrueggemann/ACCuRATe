package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.class_482;
import com.google.android.gms.internal.class_247;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gu;
import java.util.Map;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.dh
@ey
public class class_478 {
   private final Context mContext;
   // $FF: renamed from: mo com.google.android.gms.internal.gu
   private final class_371 field_1641;
   // $FF: renamed from: rd java.util.Map
   private final Map<String, String> field_1642;
   // $FF: renamed from: re java.lang.String
   private String field_1643;
   // $FF: renamed from: rf long
   private long field_1644;
   // $FF: renamed from: rg long
   private long field_1645;
   // $FF: renamed from: rh java.lang.String
   private String field_1646;
   // $FF: renamed from: ri java.lang.String
   private String field_1647;

   public class_478(gu var1, Map<String, String> var2) {
      this.field_1641 = var1;
      this.field_1642 = var2;
      this.mContext = var1.method_2536();
      this.method_3017();
   }

   // $FF: renamed from: A (java.lang.String) java.lang.String
   private String method_3014(String var1) {
      return TextUtils.isEmpty((CharSequence)this.field_1642.get(var1))?"":(String)this.field_1642.get(var1);
   }

   // $FF: renamed from: bQ () void
   private void method_3017() {
      this.field_1643 = this.method_3014("description");
      this.field_1646 = this.method_3014("summary");
      this.field_1644 = class_375.method_2549((String)this.field_1642.get("start"));
      this.field_1645 = class_375.method_2549((String)this.field_1642.get("end"));
      this.field_1647 = this.method_3014("location");
   }

   Intent createIntent() {
      Intent var1 = (new Intent("android.intent.action.EDIT")).setData(Events.CONTENT_URI);
      var1.putExtra("title", this.field_1646);
      var1.putExtra("eventLocation", this.field_1647);
      var1.putExtra("description", this.field_1643);
      var1.putExtra("beginTime", this.field_1644);
      var1.putExtra("endTime", this.field_1645);
      var1.setFlags(268435456);
      return var1;
   }

   public void execute() {
      if(!(new class_247(this.mContext)).method_1625()) {
         class_368.method_2506("This feature is not available on this version of the device.");
      } else {
         Builder var1 = new Builder(this.mContext);
         var1.setTitle(class_381.method_2606(class_482.string.create_calendar_title, "Create calendar event"));
         var1.setMessage(class_381.method_2606(class_482.string.create_calendar_message, "Allow Ad to create a calendar event?"));
         var1.setPositiveButton(class_381.method_2606(class_482.string.accept, "Accept"), new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
               Intent var3 = class_478.this.createIntent();
               class_478.this.mContext.startActivity(var3);
            }
         });
         var1.setNegativeButton(class_381.method_2606(class_482.string.decline, "Decline"), new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
               class_478.this.field_1641.method_2526("onCalendarEventCanceled", new JSONObject());
            }
         });
         var1.create().show();
      }
   }
}
