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
import com.google.android.gms.internal.class_365;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_394;
import com.google.android.gms.internal.class_431;

// $FF: renamed from: com.google.android.gms.internal.dp
public class class_429 implements Runnable {
   // $FF: renamed from: ks int
   private final int field_1876;
   // $FF: renamed from: kt int
   private final int field_1877;
   // $FF: renamed from: lL com.google.android.gms.internal.ey
   protected final class_369 field_1878;
   // $FF: renamed from: pI android.os.Handler
   private final Handler field_1879;
   // $FF: renamed from: pJ long
   private final long field_1880;
   // $FF: renamed from: pK long
   private long field_1881;
   // $FF: renamed from: pL com.google.android.gms.internal.ez$a
   private class_367.class_1262 field_1882;
   // $FF: renamed from: pM boolean
   protected boolean field_1883;
   // $FF: renamed from: pN boolean
   protected boolean field_1884;

   public class_429(class_367.class_1262 var1, class_369 var2, int var3, int var4) {
      this(var1, var2, var3, var4, 200L, 50L);
   }

   public class_429(class_367.class_1262 var1, class_369 var2, int var3, int var4, long var5, long var7) {
      this.field_1880 = var5;
      this.field_1881 = var7;
      this.field_1879 = new Handler(Looper.getMainLooper());
      this.field_1878 = var2;
      this.field_1882 = var1;
      this.field_1883 = false;
      this.field_1884 = false;
      this.field_1877 = var4;
      this.field_1876 = var3;
   }

   // $FF: renamed from: c (com.google.android.gms.internal.dp) long
   // $FF: synthetic method
   static long method_2584(class_429 var0) {
      long var1 = var0.field_1881 - 1L;
      var0.field_1881 = var1;
      return var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.dv, com.google.android.gms.internal.fd) void
   public void method_2589(class_431 var1, class_394 var2) {
      this.field_1878.setWebViewClient(var2);
      class_369 var3 = this.field_1878;
      String var4;
      if(TextUtils.isEmpty(var1.field_1888)) {
         var4 = null;
      } else {
         var4 = class_365.method_2316(var1.field_1888);
      }

      var3.loadDataWithBaseURL(var4, var1.field_1889, "text/html", "UTF-8", (String)null);
   }

   // $FF: renamed from: b (com.google.android.gms.internal.dv) void
   public void method_2590(class_431 var1) {
      this.method_2589(var1, new class_394(this, this.field_1878, var1.field_1898));
   }

   // $FF: renamed from: bj () void
   public void method_2591() {
      this.field_1879.postDelayed(this, this.field_1880);
   }

   // $FF: renamed from: bk () void
   public void method_2592() {
      synchronized(this){}

      try {
         this.field_1883 = true;
      } finally {
         ;
      }

   }

   // $FF: renamed from: bl () boolean
   public boolean method_2593() {
      synchronized(this){}

      boolean var2;
      try {
         var2 = this.field_1883;
      } finally {
         ;
      }

      return var2;
   }

   // $FF: renamed from: bm () boolean
   public boolean method_2594() {
      return this.field_1884;
   }

   public void run() {
      if(this.field_1878 != null && !this.method_2593()) {
         (new class_429.class_1151(this.field_1878)).execute(new Void[0]);
      } else {
         this.field_1882.method_756(this.field_1878);
      }
   }

   protected final class class_1151 extends AsyncTask<Void, Void, Boolean> {
      // $FF: renamed from: pO android.webkit.WebView
      private final WebView field_4220;
      // $FF: renamed from: pP android.graphics.Bitmap
      private Bitmap field_4221;

      public class_1151(WebView var2) {
         this.field_4220 = var2;
      }

      // $FF: renamed from: a (java.lang.Void[]) java.lang.Boolean
      protected Boolean method_4476(Void... param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.Boolean) void
      protected void method_4477(Boolean var1) {
         class_429.method_2584(class_429.this);
         if(!var1.booleanValue() && !class_429.this.method_2593() && class_429.this.field_1881 > 0L) {
            if(class_429.this.field_1881 > 0L) {
               if(class_370.method_2362(2)) {
                  class_370.method_2363("Ad not detected, scheduling another run.");
               }

               class_429.this.field_1879.postDelayed(class_429.this, class_429.this.field_1880);
               return;
            }
         } else {
            class_429.this.field_1884 = var1.booleanValue();
            class_429.this.field_1882.method_756(class_429.this.field_1878);
         }

      }

      // $FF: synthetic method
      protected Object doInBackground(Object[] var1) {
         return this.method_4476((Void[])var1);
      }

      // $FF: synthetic method
      protected void onPostExecute(Object var1) {
         this.method_4477((Boolean)var1);
      }

      protected void onPreExecute() {
         synchronized(this){}

         try {
            this.field_4221 = Bitmap.createBitmap(class_429.this.field_1876, class_429.this.field_1877, Config.ARGB_8888);
            this.field_4220.setVisibility(0);
            this.field_4220.measure(MeasureSpec.makeMeasureSpec(class_429.this.field_1876, 0), MeasureSpec.makeMeasureSpec(class_429.this.field_1877, 0));
            this.field_4220.layout(0, 0, class_429.this.field_1876, class_429.this.field_1877);
            Canvas var2 = new Canvas(this.field_4221);
            this.field_4220.draw(var2);
            this.field_4220.invalidate();
         } finally {
            ;
         }

      }
   }
}
