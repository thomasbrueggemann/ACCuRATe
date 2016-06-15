package com.google.android.gms.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.ey;
import java.util.Iterator;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.gl
@ey
public final class class_376 {
   private final Context mContext;
   private int mState;
   // $FF: renamed from: rz float
   private final float field_1150;
   // $FF: renamed from: wH java.lang.String
   private String field_1151;
   // $FF: renamed from: wI float
   private float field_1152;
   // $FF: renamed from: wJ float
   private float field_1153;
   // $FF: renamed from: wK float
   private float field_1154;

   public class_376(Context var1) {
      this.mState = 0;
      this.mContext = var1;
      this.field_1150 = var1.getResources().getDisplayMetrics().density;
   }

   public class_376(Context var1, String var2) {
      this(var1);
      this.field_1151 = var2;
   }

   // $FF: renamed from: a (int, float, float) void
   private void method_2585(int var1, float var2, float var3) {
      if(var1 == 0) {
         this.mState = 0;
         this.field_1152 = var2;
         this.field_1153 = var3;
         this.field_1154 = var3;
      } else if(this.mState != -1) {
         if(var1 == 2) {
            if(var3 > this.field_1153) {
               this.field_1153 = var3;
            } else if(var3 < this.field_1154) {
               this.field_1154 = var3;
            }

            if(this.field_1153 - this.field_1154 > 30.0F * this.field_1150) {
               this.mState = -1;
               return;
            }

            if(this.mState != 0 && this.mState != 2) {
               if((this.mState == 1 || this.mState == 3) && var2 - this.field_1152 <= -50.0F * this.field_1150) {
                  this.field_1152 = var2;
                  ++this.mState;
               }
            } else if(var2 - this.field_1152 >= 50.0F * this.field_1150) {
               this.field_1152 = var2;
               ++this.mState;
            }

            if(this.mState != 1 && this.mState != 3) {
               if(this.mState == 2 && var2 < this.field_1152) {
                  this.field_1152 = var2;
                  return;
               }
            } else if(var2 > this.field_1152) {
               this.field_1152 = var2;
               return;
            }
         } else if(var1 == 1 && this.mState == 4) {
            this.showDialog();
            return;
         }
      }

   }

   private void showDialog() {
      final String var1;
      if(!TextUtils.isEmpty(this.field_1151)) {
         Uri var7 = (new Builder()).encodedQuery(this.field_1151).build();
         StringBuilder var8 = new StringBuilder();
         Map var9 = class_375.method_2567(var7);
         Iterator var10 = var9.keySet().iterator();

         while(var10.hasNext()) {
            String var11 = (String)var10.next();
            var8.append(var11).append(" = ").append((String)var9.get(var11)).append("\n\n");
         }

         var1 = var8.toString().trim();
         if(TextUtils.isEmpty(var1)) {
            var1 = "No debug information";
         }
      } else {
         var1 = "No debug information";
      }

      android.app.AlertDialog.Builder var2 = new android.app.AlertDialog.Builder(this.mContext);
      var2.setMessage(var1);
      var2.setTitle("Ad Information");
      var2.setPositiveButton("Share", new OnClickListener() {
         public void onClick(DialogInterface var1x, int var2) {
            class_376.this.mContext.startActivity(Intent.createChooser((new Intent("android.intent.action.SEND")).setType("text/plain").putExtra("android.intent.extra.TEXT", var1), "Share via"));
         }
      });
      var2.setNegativeButton("Close", new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
         }
      });
      var2.create().show();
   }

   // $FF: renamed from: Q (java.lang.String) void
   public void method_2586(String var1) {
      this.field_1151 = var1;
   }

   // $FF: renamed from: c (android.view.MotionEvent) void
   public void method_2587(MotionEvent var1) {
      int var2 = var1.getHistorySize();

      for(int var3 = 0; var3 < var2; ++var3) {
         this.method_2585(var1.getActionMasked(), var1.getHistoricalX(0, var3), var1.getHistoricalY(0, var3));
      }

      this.method_2585(var1.getActionMasked(), var1.getX(), var1.getY());
   }
}
