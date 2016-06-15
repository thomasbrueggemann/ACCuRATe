package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;

// $FF: renamed from: com.google.android.gms.internal.ka
public class class_332 {
   // $FF: renamed from: a (java.lang.String, java.lang.String, android.content.Context, android.util.AttributeSet, boolean, boolean, java.lang.String) java.lang.String
   public static String method_2293(String var0, String var1, Context var2, AttributeSet var3, boolean var4, boolean var5, String var6) {
      String var7;
      if(var3 == null) {
         var7 = null;
      } else {
         var7 = var3.getAttributeValue(var0, var1);
      }

      if(var7 != null && var7.startsWith("@string/") && var4) {
         String var9 = var7.substring("@string/".length());
         String var10 = var2.getPackageName();
         TypedValue var11 = new TypedValue();

         try {
            var2.getResources().getValue(var10 + ":string/" + var9, var11, true);
         } catch (NotFoundException var13) {
            Log.w(var6, "Could not find resource for " + var1 + ": " + var7);
         }

         if(var11.string != null) {
            var7 = var11.string.toString();
         } else {
            Log.w(var6, "Resource " + var1 + " was not a string: " + var11);
         }
      }

      if(var5 && var7 == null) {
         Log.w(var6, "Required XML attribute \"" + var1 + "\" missing");
      }

      return var7;
   }
}
