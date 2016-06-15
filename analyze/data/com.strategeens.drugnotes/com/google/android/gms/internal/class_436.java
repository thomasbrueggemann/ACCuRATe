package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.internal.class_356;
import com.google.android.gms.internal.class_358;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.fb
@ey
public class class_436 implements Runnable {
   // $FF: renamed from: li int
   private final int field_1431;
   // $FF: renamed from: lj int
   private final int field_1432;
   // $FF: renamed from: mo com.google.android.gms.internal.gu
   protected final class_371 field_1433;
   // $FF: renamed from: tr android.os.Handler
   private final Handler field_1434;
   // $FF: renamed from: ts long
   private final long field_1435;
   // $FF: renamed from: tt long
   private long field_1436;
   // $FF: renamed from: tu com.google.android.gms.internal.gv$a
   private class_356.class_1535 field_1437;
   // $FF: renamed from: tv boolean
   protected boolean field_1438;
   // $FF: renamed from: tw boolean
   protected boolean field_1439;

   public class_436(class_356.class_1535 var1, class_371 var2, int var3, int var4) {
      this(var1, var2, var3, var4, 200L, 50L);
   }

   public class_436(class_356.class_1535 var1, class_371 var2, int var3, int var4, long var5, long var7) {
      this.field_1435 = var5;
      this.field_1436 = var7;
      this.field_1434 = new Handler(Looper.getMainLooper());
      this.field_1433 = var2;
      this.field_1437 = var1;
      this.field_1438 = false;
      this.field_1439 = false;
      this.field_1432 = var4;
      this.field_1431 = var3;
   }

   // $FF: renamed from: c (com.google.android.gms.internal.fb) long
   // $FF: synthetic method
   static long method_2864(class_436 var0) {
      long var1 = var0.field_1436 - 1L;
      var0.field_1436 = var1;
      return var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.fj, com.google.android.gms.internal.gz) void
   public void method_2869(class_438 var1, class_358 var2) {
      this.field_1433.setWebViewClient(var2);
      class_371 var3 = this.field_1433;
      String var4;
      if(TextUtils.isEmpty(var1.field_1443)) {
         var4 = null;
      } else {
         var4 = class_375.method_2546(var1.field_1443);
      }

      var3.loadDataWithBaseURL(var4, var1.field_1445, "text/html", "UTF-8", (String)null);
   }

   // $FF: renamed from: b (com.google.android.gms.internal.fj) void
   public void method_2870(class_438 var1) {
      this.method_2869(var1, new class_358(this, this.field_1433, var1.field_1454));
   }

   // $FF: renamed from: cF () void
   public void method_2871() {
      this.field_1434.postDelayed(this, this.field_1435);
   }

   // $FF: renamed from: cG () void
   public void method_2872() {
      synchronized(this){}

      try {
         this.field_1438 = true;
      } finally {
         ;
      }

   }

   // $FF: renamed from: cH () boolean
   public boolean method_2873() {
      synchronized(this){}

      boolean var2;
      try {
         var2 = this.field_1438;
      } finally {
         ;
      }

      return var2;
   }

   // $FF: renamed from: cI () boolean
   public boolean method_2874() {
      return this.field_1439;
   }

   public void run() {
      if(this.field_1433 != null && !this.method_2873()) {
         (new class_436.class_1401(this.field_1433)).execute(new Void[0]);
      } else {
         this.field_1437.method_729(this.field_1433);
      }
   }

   protected final class class_1401 extends AsyncTask<Void, Void, Boolean> {
      // $FF: renamed from: tx android.webkit.WebView
      private final WebView field_2799;
      // $FF: renamed from: ty android.graphics.Bitmap
      private Bitmap field_2800;

      public class_1401(WebView var2) {
         this.field_2799 = var2;
      }

      // $FF: renamed from: a (java.lang.Boolean) void
      protected void method_3696(Boolean var1) {
         class_436.method_2864(class_436.this);
         if(!var1.booleanValue() && !class_436.this.method_2873() && class_436.this.field_1436 > 0L) {
            if(class_436.this.field_1436 > 0L) {
               if(class_368.method_2511(2)) {
                  class_368.method_2502("Ad not detected, scheduling another run.");
               }

               class_436.this.field_1434.postDelayed(class_436.this, class_436.this.field_1435);
               return;
            }
         } else {
            class_436.this.field_1439 = var1.booleanValue();
            class_436.this.field_1437.method_729(class_436.this.field_1433);
         }

      }

      // $FF: renamed from: b (java.lang.Void[]) java.lang.Boolean
      protected Boolean method_3697(Void... param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: synthetic method
      protected Object doInBackground(Object[] var1) {
         return this.method_3697((Void[])var1);
      }

      // $FF: synthetic method
      protected void onPostExecute(Object var1) {
         this.method_3696((Boolean)var1);
      }

      protected void onPreExecute() {
         synchronized(this){}

         try {
            this.field_2800 = Bitmap.createBitmap(class_436.this.field_1431, class_436.this.field_1432, Config.ARGB_8888);
            this.field_2799.setVisibility(0);
            this.field_2799.measure(MeasureSpec.makeMeasureSpec(class_436.this.field_1431, 0), MeasureSpec.makeMeasureSpec(class_436.this.field_1432, 0));
            this.field_2799.layout(0, 0, class_436.this.field_1431, class_436.this.field_1432);
            Canvas var2 = new Canvas(this.field_2800);
            this.field_2799.draw(var2);
            this.field_2799.invalidate();
         } finally {
            ;
         }

      }
   }
}
