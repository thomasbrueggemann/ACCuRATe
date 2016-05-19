package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.util.Iterator;
import java.util.Map;

@zzhb
public class zziu {
   private final Context mContext;
   private int mState;
   private final float zzDB;
   private String zzMh;
   private float zzMi;
   private float zzMj;
   private float zzMk;

   public zziu(Context var1) {
      this.mState = 0;
      this.mContext = var1;
      this.zzDB = var1.getResources().getDisplayMetrics().density;
   }

   public zziu(Context var1, String var2) {
      this(var1);
      this.zzMh = var2;
   }

   private void showDialog() {
      if(!(this.mContext instanceof Activity)) {
         zzin.zzaJ("Can not create dialog without Activity Context");
      } else {
         final String var1 = zzaG(this.zzMh);
         Builder var2 = new Builder(this.mContext);
         var2.setMessage(var1);
         var2.setTitle("Ad Information");
         var2.setPositiveButton("Share", new OnClickListener() {
            public void onClick(DialogInterface var1x, int var2) {
               com.google.android.gms.ads.internal.zzr.zzbC().zzb(zziu.this.mContext, Intent.createChooser((new Intent("android.intent.action.SEND")).setType("text/plain").putExtra("android.intent.extra.TEXT", var1), "Share via"));
            }
         });
         var2.setNegativeButton("Close", new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
            }
         });
         var2.create().show();
      }
   }

   static String zzaG(String var0) {
      String var6;
      if(TextUtils.isEmpty(var0)) {
         var6 = "No debug information";
      } else {
         String var1 = var0.replaceAll("\\+", "%20");
         Uri var2 = (new android.net.Uri.Builder()).encodedQuery(var1).build();
         StringBuilder var3 = new StringBuilder();
         Map var4 = com.google.android.gms.ads.internal.zzr.zzbC().zze(var2);
         Iterator var5 = var4.keySet().iterator();

         while(var5.hasNext()) {
            String var7 = (String)var5.next();
            var3.append(var7).append(" = ").append((String)var4.get(var7)).append("\n\n");
         }

         var6 = var3.toString().trim();
         if(TextUtils.isEmpty(var6)) {
            return "No debug information";
         }
      }

      return var6;
   }

   void zza(int var1, float var2, float var3) {
      if(var1 == 0) {
         this.mState = 0;
         this.zzMi = var2;
         this.zzMj = var3;
         this.zzMk = var3;
      } else if(this.mState != -1) {
         if(var1 == 2) {
            if(var3 > this.zzMj) {
               this.zzMj = var3;
            } else if(var3 < this.zzMk) {
               this.zzMk = var3;
            }

            if(this.zzMj - this.zzMk > 30.0F * this.zzDB) {
               this.mState = -1;
               return;
            }

            if(this.mState != 0 && this.mState != 2) {
               if((this.mState == 1 || this.mState == 3) && var2 - this.zzMi <= -50.0F * this.zzDB) {
                  this.zzMi = var2;
                  ++this.mState;
               }
            } else if(var2 - this.zzMi >= 50.0F * this.zzDB) {
               this.zzMi = var2;
               ++this.mState;
            }

            if(this.mState != 1 && this.mState != 3) {
               if(this.mState == 2 && var2 < this.zzMi) {
                  this.zzMi = var2;
                  return;
               }
            } else if(var2 > this.zzMi) {
               this.zzMi = var2;
               return;
            }
         } else if(var1 == 1 && this.mState == 4) {
            this.showDialog();
            return;
         }
      }

   }

   public void zze(MotionEvent var1) {
      int var2 = var1.getHistorySize();

      for(int var3 = 0; var3 < var2; ++var3) {
         this.zza(var1.getActionMasked(), var1.getHistoricalX(0, var3), var1.getHistoricalY(0, var3));
      }

      this.zza(var1.getActionMasked(), var1.getX(), var1.getY());
   }
}
