package com.google.android.gms.internal;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.bd;
import com.google.android.gms.internal.class_10;
import com.google.android.gms.internal.class_183;
import com.google.android.gms.internal.class_185;
import com.google.android.gms.internal.class_186;
import com.google.android.gms.internal.class_187;
import com.google.android.gms.internal.class_365;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_40;
import com.google.android.gms.internal.class_421;
import com.google.android.gms.internal.class_422;
import com.google.android.gms.internal.class_424;
import com.google.android.gms.internal.class_43;
import com.google.android.gms.internal.class_63;
import com.google.android.gms.internal.class_7;
import com.google.android.gms.internal.class_8;
import com.google.android.gms.internal.class_9;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.ez
public class class_367 extends WebViewClient {
   // $FF: renamed from: lL com.google.android.gms.internal.ey
   protected final class_369 field_1583;
   // $FF: renamed from: lq java.lang.Object
   private final Object field_1584 = new Object();
   // $FF: renamed from: mQ com.google.android.gms.internal.bb
   private class_8 field_1585;
   // $FF: renamed from: na com.google.android.gms.internal.bg
   private class_7 field_1586;
   // $FF: renamed from: nb com.google.android.gms.internal.be
   private class_9 field_1587;
   // $FF: renamed from: pL com.google.android.gms.internal.ez$a
   private class_367.class_1262 field_1588;
   // $FF: renamed from: sE java.util.HashMap
   private final HashMap<String, bd> field_1589 = new HashMap();
   // $FF: renamed from: sF com.google.android.gms.internal.u
   private class_63 field_1590;
   // $FF: renamed from: sG com.google.android.gms.internal.cj
   private class_43 field_1591;
   // $FF: renamed from: sH boolean
   private boolean field_1592 = false;
   // $FF: renamed from: sI boolean
   private boolean field_1593;
   // $FF: renamed from: sJ com.google.android.gms.internal.cm
   private class_40 field_1594;

   public class_367(class_369 var1, boolean var2) {
      this.field_1583 = var1;
      this.field_1593 = var2;
   }

   // $FF: renamed from: c (android.net.Uri) boolean
   private static boolean method_2318(Uri var0) {
      String var1 = var0.getScheme();
      return "http".equalsIgnoreCase(var1) || "https".equalsIgnoreCase(var1);
   }

   // $FF: renamed from: d (android.net.Uri) void
   private void method_2319(Uri var1) {
      String var2 = var1.getPath();
      class_10 var3 = (class_10)this.field_1589.get(var2);
      if(var3 == null) {
         class_370.method_2357("No GMSG handler found for GMSG: " + var1);
      } else {
         Map var4 = class_365.method_2300(var1);
         if(class_370.method_2362(2)) {
            class_370.method_2357("Received GMSG: " + var2);
            Iterator var5 = var4.keySet().iterator();

            while(var5.hasNext()) {
               String var6 = (String)var5.next();
               class_370.method_2357("  " + var6 + ": " + (String)var4.get(var6));
            }
         }

         var3.method_19(this.field_1583, var4);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.cf) void
   public final void method_2320(class_421 var1) {
      boolean var2 = this.field_1583.method_2352();
      class_63 var3;
      if(var2 && !this.field_1583.method_2338().field_570) {
         var3 = null;
      } else {
         var3 = this.field_1590;
      }

      class_43 var4 = null;
      if(!var2) {
         var4 = this.field_1591;
      }

      this.method_2321(new class_424(var1, var3, var4, this.field_1594, this.field_1583.method_2351()));
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ci) void
   protected void method_2321(class_424 var1) {
      class_422.method_2555(this.field_1583.getContext(), var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ez$a) void
   public final void method_2322(class_367.class_1262 var1) {
      this.field_1588 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.u, com.google.android.gms.internal.cj, com.google.android.gms.internal.bb, com.google.android.gms.internal.cm, boolean, com.google.android.gms.internal.be) void
   public void method_2323(class_63 var1, class_43 var2, class_8 var3, class_40 var4, boolean var5, class_9 var6) {
      this.method_2325("/appEvent", new class_187(var3));
      this.method_2325("/canOpenURLs", class_186.field_593);
      this.method_2325("/click", class_186.field_594);
      this.method_2325("/close", class_186.field_595);
      this.method_2325("/customClose", class_186.field_596);
      this.method_2325("/httpTrack", class_186.field_597);
      this.method_2325("/log", class_186.field_598);
      this.method_2325("/open", new class_185(var6));
      this.method_2325("/touch", class_186.field_599);
      this.method_2325("/video", class_186.field_600);
      this.field_1590 = var1;
      this.field_1591 = var2;
      this.field_1585 = var3;
      this.field_1587 = var6;
      this.field_1594 = var4;
      this.method_2331(var5);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.u, com.google.android.gms.internal.cj, com.google.android.gms.internal.bb, com.google.android.gms.internal.cm, boolean, com.google.android.gms.internal.be, com.google.android.gms.internal.bg) void
   public void method_2324(class_63 var1, class_43 var2, class_8 var3, class_40 var4, boolean var5, class_9 var6, class_7 var7) {
      this.method_2323(var1, var2, var3, var4, var5, var6);
      this.method_2325("/setInterstitialProperties", new class_183(var7));
      this.field_1586 = var7;
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.bd) void
   public final void method_2325(String var1, class_10 var2) {
      this.field_1589.put(var1, var2);
   }

   // $FF: renamed from: a (boolean, int) void
   public final void method_2326(boolean var1, int var2) {
      class_63 var3;
      if(this.field_1583.method_2352() && !this.field_1583.method_2338().field_570) {
         var3 = null;
      } else {
         var3 = this.field_1590;
      }

      this.method_2321(new class_424(var3, this.field_1591, this.field_1594, this.field_1583, var1, var2, this.field_1583.method_2351()));
   }

   // $FF: renamed from: a (boolean, int, java.lang.String) void
   public final void method_2327(boolean var1, int var2, String var3) {
      boolean var4 = this.field_1583.method_2352();
      class_63 var5;
      if(var4 && !this.field_1583.method_2338().field_570) {
         var5 = null;
      } else {
         var5 = this.field_1590;
      }

      class_43 var6 = null;
      if(!var4) {
         var6 = this.field_1591;
      }

      this.method_2321(new class_424(var5, var6, this.field_1585, this.field_1594, this.field_1583, var1, var2, var3, this.field_1583.method_2351(), this.field_1587));
   }

   // $FF: renamed from: a (boolean, int, java.lang.String, java.lang.String) void
   public final void method_2328(boolean var1, int var2, String var3, String var4) {
      boolean var5 = this.field_1583.method_2352();
      class_63 var6;
      if(var5 && !this.field_1583.method_2338().field_570) {
         var6 = null;
      } else {
         var6 = this.field_1590;
      }

      class_43 var7;
      if(var5) {
         var7 = null;
      } else {
         var7 = this.field_1591;
      }

      this.method_2321(new class_424(var6, var7, this.field_1585, this.field_1594, this.field_1583, var1, var2, var3, var4, this.field_1583.method_2351(), this.field_1587));
   }

   // $FF: renamed from: aN () void
   public final void method_2329() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ce () boolean
   public boolean method_2330() {
      // $FF: Couldn't be decompiled
   }

   public final void onLoadResource(WebView var1, String var2) {
      class_370.method_2357("Loading resource: " + var2);
      Uri var3 = Uri.parse(var2);
      if("gmsg".equalsIgnoreCase(var3.getScheme()) && "mobileads.google.com".equalsIgnoreCase(var3.getHost())) {
         this.method_2319(var3);
      }

   }

   public final void onPageFinished(WebView var1, String var2) {
      if(this.field_1588 != null) {
         this.field_1588.method_756(this.field_1583);
         this.field_1588 = null;
      }

   }

   // $FF: renamed from: r (boolean) void
   public final void method_2331(boolean var1) {
      this.field_1592 = var1;
   }

   public final void reset() {
      // $FF: Couldn't be decompiled
   }

   public final boolean shouldOverrideUrlLoading(WebView param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public interface class_1262 {
      // $FF: renamed from: a (com.google.android.gms.internal.ey) void
      void method_756(class_369 var1);
   }
}
