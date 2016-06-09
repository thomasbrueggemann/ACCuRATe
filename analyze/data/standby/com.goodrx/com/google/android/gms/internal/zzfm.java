package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.class_54;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;
import java.util.Map;

@zzhb
public class zzfm extends zzfs {
   private final Context mContext;
   private String zzCU;
   private long zzCV;
   private long zzCW;
   private String zzCX;
   private String zzCY;
   private final Map<String, String> zzxA;

   public zzfm(zzjp var1, Map<String, String> var2) {
      super(var1, "createCalendarEvent");
      this.zzxA = var2;
      this.mContext = var1.zzhP();
      this.zzeK();
   }

   private String zzaj(String var1) {
      return TextUtils.isEmpty((CharSequence)this.zzxA.get(var1))?"":(String)this.zzxA.get(var1);
   }

   private long zzak(String var1) {
      String var2 = (String)this.zzxA.get(var1);
      if(var2 == null) {
         return -1L;
      } else {
         try {
            long var4 = Long.parseLong(var2);
            return var4;
         } catch (NumberFormatException var6) {
            return -1L;
         }
      }
   }

   private void zzeK() {
      this.zzCU = this.zzaj("description");
      this.zzCX = this.zzaj("summary");
      this.zzCV = this.zzak("start_ticks");
      this.zzCW = this.zzak("end_ticks");
      this.zzCY = this.zzaj("location");
   }

   @TargetApi(14)
   Intent createIntent() {
      Intent var1 = (new Intent("android.intent.action.EDIT")).setData(Events.CONTENT_URI);
      var1.putExtra("title", this.zzCU);
      var1.putExtra("eventLocation", this.zzCY);
      var1.putExtra("description", this.zzCX);
      if(this.zzCV > -1L) {
         var1.putExtra("beginTime", this.zzCV);
      }

      if(this.zzCW > -1L) {
         var1.putExtra("endTime", this.zzCW);
      }

      var1.setFlags(268435456);
      return var1;
   }

   public void execute() {
      if(this.mContext == null) {
         this.zzam("Activity context is not available.");
      } else if(!com.google.android.gms.ads.internal.zzr.zzbC().zzM(this.mContext).zzdo()) {
         this.zzam("This feature is not available on the device.");
      } else {
         Builder var1 = com.google.android.gms.ads.internal.zzr.zzbC().zzL(this.mContext);
         var1.setTitle(com.google.android.gms.ads.internal.zzr.zzbF().zzd(class_54.string.create_calendar_title, "Create calendar event"));
         var1.setMessage(com.google.android.gms.ads.internal.zzr.zzbF().zzd(class_54.string.create_calendar_message, "Allow Ad to create a calendar event?"));
         var1.setPositiveButton(com.google.android.gms.ads.internal.zzr.zzbF().zzd(class_54.string.accept, "Accept"), new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
               Intent var3 = zzfm.this.createIntent();
               com.google.android.gms.ads.internal.zzr.zzbC().zzb(zzfm.this.mContext, var3);
            }
         });
         var1.setNegativeButton(com.google.android.gms.ads.internal.zzr.zzbF().zzd(class_54.string.decline, "Decline"), new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
               zzfm.this.zzam("Operation denied by user.");
            }
         });
         var1.create().show();
      }
   }
}
