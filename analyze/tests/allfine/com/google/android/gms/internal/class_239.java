package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.class_492;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.bb
@ez
public final class class_239 {
    // $FF: renamed from: oj com.google.android.gms.ads.AdSize[]
    private final AdSize[] field_633;
    // $FF: renamed from: ok java.lang.String
    private final String field_634;

    public class_239(Context var1, AttributeSet var2) {
        boolean var3 = true;
        super();
        TypedArray var4 = var1.getResources().obtainAttributes(var2, class_492.styleable.AdsAttrs);
        String var5 = var4.getString(class_492.styleable.AdsAttrs_adSize);
        String var6 = var4.getString(class_492.styleable.AdsAttrs_adSizes);
        boolean var7;
        if(!TextUtils.isEmpty(var5)) {
            var7 = var3;
        } else {
            var7 = false;
        }

        if(TextUtils.isEmpty(var6)) {
            var3 = false;
        }

        if(var7 && !var3) {
            this.field_633 = method_1587(var5);
        } else {
            if(var7 || !var3) {
                if(var7 && var3) {
                    throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
                }

                throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
            }

            this.field_633 = method_1587(var6);
        }

        this.field_634 = var4.getString(class_492.styleable.AdsAttrs_adUnitId);
        if(TextUtils.isEmpty(this.field_634)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    // $FF: renamed from: q (java.lang.String) com.google.android.gms.ads.AdSize[]
    private static AdSize[] method_1587(String param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: f (boolean) com.google.android.gms.ads.AdSize[]
    public AdSize[] method_1588(boolean var1) {
        if(!var1 && this.field_633.length != 1) {
            throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
        } else {
            return this.field_633;
        }
    }

    public String getAdUnitId() {
        return this.field_634;
    }
}
