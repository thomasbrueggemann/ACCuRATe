package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.class_443;
import com.google.android.gms.ads.AdSize;

// $FF: renamed from: com.google.android.gms.internal.ap
public final class class_171 {
   // $FF: renamed from: mg com.google.android.gms.ads.AdSize[]
   private final AdSize[] field_567;
   // $FF: renamed from: mh java.lang.String
   private final String field_568;

   public class_171(Context var1, AttributeSet var2) {
      byte var3 = 1;
      super();
      TypedArray var4 = var1.getResources().obtainAttributes(var2, class_443.styleable.AdsAttrs);
      String var5 = var4.getString(0);
      String var6 = var4.getString(var3);
      byte var7;
      if(!TextUtils.isEmpty(var5)) {
         var7 = var3;
      } else {
         var7 = 0;
      }

      if(TextUtils.isEmpty(var6)) {
         var3 = 0;
      }

      if(var7 != 0 && var3 == 0) {
         this.field_567 = method_1262(var5);
      } else {
         if(var7 != 0 || var3 == 0) {
            if(var7 != 0 && var3 != 0) {
               throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
            }

            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
         }

         this.field_567 = method_1262(var6);
      }

      this.field_568 = var4.getString(2);
      if(TextUtils.isEmpty(this.field_568)) {
         throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
      }
   }

   // $FF: renamed from: f (java.lang.String) com.google.android.gms.ads.AdSize[]
   private static AdSize[] method_1262(String param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: f (boolean) com.google.android.gms.ads.AdSize[]
   public AdSize[] method_1263(boolean var1) {
      if(!var1 && this.field_567.length != 1) {
         throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
      } else {
         return this.field_567;
      }
   }

   public String getAdUnitId() {
      return this.field_568;
   }
}
