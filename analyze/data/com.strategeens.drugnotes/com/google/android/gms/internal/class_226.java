package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.internal.class_225;
import com.google.android.gms.internal.class_227;
import com.google.android.gms.internal.class_228;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_409;
import com.google.android.gms.internal.class_712;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.an
@ey
public class class_226 extends Thread {
   // $FF: renamed from: mH java.lang.Object
   private final Object field_379;
   private boolean mStarted = false;
   // $FF: renamed from: nC boolean
   private boolean field_380 = false;
   // $FF: renamed from: nD boolean
   private boolean field_381 = false;
   // $FF: renamed from: nE com.google.android.gms.internal.am
   private final class_225 field_382;
   // $FF: renamed from: nF com.google.android.gms.internal.al
   private final class_228 field_383;
   // $FF: renamed from: nG com.google.android.gms.internal.ex
   private final class_409 field_384;
   // $FF: renamed from: nH int
   private final int field_385;
   // $FF: renamed from: nI int
   private final int field_386;
   // $FF: renamed from: nJ int
   private final int field_387;
   // $FF: renamed from: np int
   private final int field_388;
   // $FF: renamed from: nr int
   private final int field_389;

   public class_226(class_225 var1, class_228 var2, Bundle var3, class_409 var4) {
      this.field_382 = var1;
      this.field_383 = var2;
      this.field_384 = var4;
      this.field_379 = new Object();
      this.field_388 = var3.getInt(class_242.field_480.getKey());
      this.field_386 = var3.getInt(class_242.field_481.getKey());
      this.field_389 = var3.getInt(class_242.field_482.getKey());
      this.field_387 = var3.getInt(class_242.field_483.getKey());
      this.field_385 = var3.getInt(class_242.field_484.getKey(), 10);
      this.setName("ContentFetchTask");
   }

   // $FF: renamed from: a (android.app.Activity) void
   private void method_1550(Activity var1) {
      if(var1 != null) {
         Window var2 = var1.getWindow();
         View var3 = null;
         if(var2 != null) {
            View var5 = var1.getWindow().getDecorView();
            var3 = null;
            if(var5 != null) {
               var3 = var1.getWindow().getDecorView().findViewById(16908290);
            }
         }

         if(var3 != null) {
            this.method_1559(var3);
            return;
         }
      }

   }

   // $FF: renamed from: a (android.webkit.WebView, com.google.android.gms.internal.ak) boolean
   private boolean method_1551(final WebView var1, final class_227 var2) {
      if(!class_712.method_4183()) {
         return false;
      } else {
         var2.method_1568();
         var1.post(new Runnable() {
            // $FF: renamed from: nM android.webkit.ValueCallback
            ValueCallback<String> field_4005 = new ValueCallback() {
               // $FF: renamed from: k (java.lang.String) void
               public void method_5849(String var1x) {
                  class_226.this.method_1554(var2, var1, var1x);
               }

               // $FF: synthetic method
               public void onReceiveValue(Object var1x) {
                  this.method_5849((String)var1x);
               }
            };

            public void run() {
               if(var1.getSettings().getJavaScriptEnabled()) {
                  var1.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.field_4005);
               }

            }
         });
         return true;
      }
   }

   // $FF: renamed from: bb () boolean
   private boolean method_1552() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.view.View, com.google.android.gms.internal.ak) com.google.android.gms.internal.an$a
   class_226.class_1209 method_1553(View var1, class_227 var2) {
      int var3 = 0;
      if(var1 == null) {
         return new class_226.class_1209(0, 0);
      } else if(var1 instanceof TextView && !(var1 instanceof EditText)) {
         var2.method_1573(((TextView)var1).getText().toString());
         return new class_226.class_1209(1, 0);
      } else if(var1 instanceof WebView && !(var1 instanceof class_371)) {
         var2.method_1568();
         return this.method_1551((WebView)var1, var2)?new class_226.class_1209(0, 1):new class_226.class_1209(0, 0);
      } else if(!(var1 instanceof ViewGroup)) {
         return new class_226.class_1209(0, 0);
      } else {
         ViewGroup var4 = (ViewGroup)var1;
         int var5 = 0;

         int var6;
         for(var6 = 0; var3 < var4.getChildCount(); ++var3) {
            class_226.class_1209 var7 = this.method_1553(var4.getChildAt(var3), var2);
            var6 += var7.field_3999;
            var5 += var7.field_4000;
         }

         return new class_226.class_1209(var6, var5);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ak, android.webkit.WebView, java.lang.String) void
   void method_1554(class_227 param1, WebView param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ba () void
   public void method_1555() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bc () com.google.android.gms.internal.ak
   public class_227 method_1556() {
      return this.field_383.method_1575();
   }

   // $FF: renamed from: bd () void
   public void method_1557() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: be () boolean
   public boolean method_1558() {
      return this.field_380;
   }

   // $FF: renamed from: g (android.view.View) boolean
   boolean method_1559(final View var1) {
      if(var1 == null) {
         return false;
      } else {
         var1.post(new Runnable() {
            public void run() {
               class_226.this.method_1560(var1);
            }
         });
         return true;
      }
   }

   // $FF: renamed from: h (android.view.View) void
   void method_1560(View var1) {
      try {
         class_227 var2 = new class_227(this.field_388, this.field_386, this.field_389, this.field_387);
         class_226.class_1209 var4 = this.method_1553(var1, var2);
         var2.method_1569();
         if(var4.field_3999 == 0 && var4.field_4000 == 0) {
            return;
         }

         if((var4.field_4000 != 0 || var2.method_1570() != 0) && (var4.field_4000 != 0 || !this.field_383.method_1574(var2))) {
            this.field_383.method_1577(var2);
            return;
         }
      } catch (Exception var5) {
         class_368.method_2508("Exception in fetchContentOnUIThread", var5);
         this.field_384.method_2722(var5);
      }

   }

   public void run() {
      // $FF: Couldn't be decompiled
   }

   public void wakeup() {
      // $FF: Couldn't be decompiled
   }

   @ey
   class class_1209 {
      // $FF: renamed from: nQ int
      final int field_3999;
      // $FF: renamed from: nR int
      final int field_4000;

      class_1209(int var2, int var3) {
         this.field_3999 = var2;
         this.field_4000 = var3;
      }
   }
}
