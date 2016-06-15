package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_552;
import com.google.android.gms.internal.class_56;

// $FF: renamed from: com.google.android.gms.internal.k
public class class_557 {
   // $FF: renamed from: kU java.lang.String
   private String field_2562 = "googleads.g.doubleclick.net";
   // $FF: renamed from: kV java.lang.String
   private String field_2563 = "/pagead/ads";
   // $FF: renamed from: kW java.lang.String
   private String field_2564 = "ad.doubleclick.net";
   // $FF: renamed from: kX java.lang.String[]
   private String[] field_2565 = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
   // $FF: renamed from: kY com.google.android.gms.internal.g
   private class_56 field_2566;

   public class_557(class_56 var1) {
      this.field_2566 = var1;
   }

   // $FF: renamed from: a (android.net.Uri, android.content.Context, java.lang.String, boolean) android.net.Uri
   private Uri method_3389(Uri param1, Context param2, String param3, boolean param4) throws class_552 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.net.Uri, java.lang.String, java.lang.String) android.net.Uri
   private Uri method_3390(Uri var1, String var2, String var3) throws UnsupportedOperationException {
      String var4 = var1.toString();
      int var5 = var4.indexOf("&adurl");
      if(var5 == -1) {
         var5 = var4.indexOf("?adurl");
      }

      return var5 != -1?Uri.parse(var4.substring(0, var5 + 1) + var2 + "=" + var3 + "&" + var4.substring(var5 + 1)):var1.buildUpon().appendQueryParameter(var2, var3).build();
   }

   // $FF: renamed from: b (android.net.Uri, java.lang.String, java.lang.String) android.net.Uri
   private Uri method_3391(Uri var1, String var2, String var3) {
      String var4 = var1.toString();
      int var5 = var4.indexOf(";adurl");
      if(var5 != -1) {
         return Uri.parse(var4.substring(0, var5 + 1) + var2 + "=" + var3 + ";" + var4.substring(var5 + 1));
      } else {
         String var6 = var1.getEncodedPath();
         int var7 = var4.indexOf(var6);
         return Uri.parse(var4.substring(0, var7 + var6.length()) + ";" + var2 + "=" + var3 + ";" + var4.substring(var7 + var6.length()));
      }
   }

   // $FF: renamed from: C () com.google.android.gms.internal.g
   public class_56 method_3392() {
      return this.field_2566;
   }

   // $FF: renamed from: a (android.net.Uri, android.content.Context) android.net.Uri
   public Uri method_3393(Uri var1, Context var2) throws class_552 {
      try {
         Uri var4 = this.method_3389(var1, var2, var1.getQueryParameter("ai"), true);
         return var4;
      } catch (UnsupportedOperationException var5) {
         throw new class_552("Provided Uri is not in a valid state");
      }
   }

   // $FF: renamed from: a (android.view.MotionEvent) void
   public void method_3394(MotionEvent var1) {
      this.field_2566.method_289(var1);
   }

   // $FF: renamed from: a (android.net.Uri) boolean
   public boolean method_3395(Uri var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         try {
            boolean var3 = var1.getHost().equals(this.field_2564);
            return var3;
         } catch (NullPointerException var4) {
            return false;
         }
      }
   }

   // $FF: renamed from: b (android.net.Uri) boolean
   public boolean method_3396(Uri param1) {
      // $FF: Couldn't be decompiled
   }
}
