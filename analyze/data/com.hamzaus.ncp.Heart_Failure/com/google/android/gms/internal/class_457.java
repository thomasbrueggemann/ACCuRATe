package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_446;
import com.google.android.gms.internal.class_458;
import com.google.android.gms.internal.class_67;

// $FF: renamed from: com.google.android.gms.internal.l
public class class_457 {
   // $FF: renamed from: ke java.lang.String
   private String field_2740 = "googleads.g.doubleclick.net";
   // $FF: renamed from: kf java.lang.String
   private String field_2741 = "/pagead/ads";
   // $FF: renamed from: kg java.lang.String[]
   private String[] field_2742 = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
   // $FF: renamed from: kh com.google.android.gms.internal.h
   private class_67 field_2743;
   // $FF: renamed from: ki com.google.android.gms.internal.g
   private final class_446 field_2744 = new class_446();

   public class_457(class_67 var1) {
      this.field_2743 = var1;
   }

   // $FF: renamed from: a (android.net.Uri, android.content.Context, java.lang.String, boolean) android.net.Uri
   private Uri method_2827(Uri param1, Context param2, String param3, boolean param4) throws class_458 {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.net.Uri, java.lang.String, java.lang.String) android.net.Uri
   private Uri method_2828(Uri var1, String var2, String var3) throws UnsupportedOperationException {
      String var4 = var1.toString();
      int var5 = var4.indexOf("&adurl");
      if(var5 == -1) {
         var5 = var4.indexOf("?adurl");
      }

      return var5 != -1?Uri.parse(var4.substring(0, var5 + 1) + var2 + "=" + var3 + "&" + var4.substring(var5 + 1)):var1.buildUpon().appendQueryParameter(var2, var3).build();
   }

   // $FF: renamed from: a (android.net.Uri, android.content.Context) android.net.Uri
   public Uri method_2829(Uri var1, Context var2) throws class_458 {
      try {
         Uri var4 = this.method_2827(var1, var2, var1.getQueryParameter("ai"), true);
         return var4;
      } catch (UnsupportedOperationException var5) {
         throw new class_458("Provided Uri is not in a valid state");
      }
   }

   // $FF: renamed from: a (android.view.MotionEvent) void
   public void method_2830(MotionEvent var1) {
      this.field_2743.method_346(var1);
   }

   // $FF: renamed from: a (android.net.Uri) boolean
   public boolean method_2831(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: y () com.google.android.gms.internal.h
   public class_67 method_2832() {
      return this.field_2743;
   }
}
