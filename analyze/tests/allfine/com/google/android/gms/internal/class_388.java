package com.google.android.gms.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.ez;
import java.util.Iterator;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.gm
@ez
public final class class_388 {
    private final Context mContext;
    private int mState;
    // $FF: renamed from: ri float
    private final float field_1415;
    // $FF: renamed from: ws java.lang.String
    private String field_1416;
    // $FF: renamed from: wt float
    private float field_1417;
    // $FF: renamed from: wu float
    private float field_1418;
    // $FF: renamed from: wv float
    private float field_1419;

    public class_388(Context var1) {
        this.mState = 0;
        this.mContext = var1;
        this.field_1415 = var1.getResources().getDisplayMetrics().density;
    }

    public class_388(Context var1, String var2) {
        this(var1);
        this.field_1416 = var2;
    }

    // $FF: renamed from: a (int, float, float) void
    private void method_2546(int var1, float var2, float var3) {
        if(var1 == 0) {
            this.mState = 0;
            this.field_1417 = var2;
            this.field_1418 = var3;
            this.field_1419 = var3;
        } else if(this.mState != -1) {
            if(var1 == 2) {
                if(var3 > this.field_1418) {
                    this.field_1418 = var3;
                } else if(var3 < this.field_1419) {
                    this.field_1419 = var3;
                }

                if(this.field_1418 - this.field_1419 > 30.0F * this.field_1415) {
                    this.mState = -1;
                    return;
                }

                if(this.mState != 0 && this.mState != 2) {
                    if((this.mState == 1 || this.mState == 3) && var2 - this.field_1417 <= -50.0F * this.field_1415) {
                        this.field_1417 = var2;
                        ++this.mState;
                    }
                } else if(var2 - this.field_1417 >= 50.0F * this.field_1415) {
                    this.field_1417 = var2;
                    ++this.mState;
                }

                if(this.mState != 1 && this.mState != 3) {
                    if(this.mState == 2 && var2 < this.field_1417) {
                        this.field_1417 = var2;
                        return;
                    }
                } else if(var2 > this.field_1417) {
                    this.field_1417 = var2;
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
        if(!TextUtils.isEmpty(this.field_1416)) {
            Uri var7 = (new Builder()).encodedQuery(this.field_1416).build();
            StringBuilder var8 = new StringBuilder();
            Map var9 = class_383.method_2520(var7);
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
                class_388.this.mContext.startActivity(Intent.createChooser((new Intent("android.intent.action.SEND")).setType("text/plain").putExtra("android.intent.extra.TEXT", var1), "Share via"));
            }
        });
        var2.setNegativeButton("Close", new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
            }
        });
        var2.create().show();
    }

    // $FF: renamed from: Q (java.lang.String) void
    public void method_2547(String var1) {
        this.field_1416 = var1;
    }

    // $FF: renamed from: c (android.view.MotionEvent) void
    public void method_2548(MotionEvent var1) {
        int var2 = var1.getHistorySize();

        for(int var3 = 0; var3 < var2; ++var3) {
            this.method_2546(var1.getActionMasked(), var1.getHistoricalX(0, var3), var1.getHistoricalY(0, var3));
        }

        this.method_2546(var1.getActionMasked(), var1.getX(), var1.getY());
    }
}
