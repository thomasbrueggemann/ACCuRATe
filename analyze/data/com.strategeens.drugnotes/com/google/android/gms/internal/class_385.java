package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.internal.class_150;
import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_384;
import com.google.android.gms.internal.class_386;
import com.google.android.gms.internal.class_388;
import com.google.android.gms.internal.class_394;
import com.google.android.gms.internal.class_404;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.hy
public class class_385 {
   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.mv$c) com.google.android.gms.internal.hh
   private static class_394 method_2652(String var0, class_150.class_1437 var1) {
      class_388 var2 = (new class_388.class_1553(var0)).method_4110(true).method_4114(var0).method_4113("blob").method_4115();
      return new class_394(class_300.method_2088(var1), var2);
   }

   // $FF: renamed from: a (com.google.android.gms.appindexing.Action, java.lang.String, long, java.lang.String, int) com.google.android.gms.internal.hr
   public static class_386 method_2653(Action var0, String var1, long var2, String var4, int var5) {
      Bundle var6 = new Bundle();
      var6.putAll(var0.fI());
      Bundle var7 = var6.getBundle("object");
      Uri var8;
      if(var7.containsKey("id")) {
         var8 = Uri.parse(var7.getString("id"));
      } else {
         var8 = null;
      }

      String var9 = var7.getString("name");
      String var10 = var7.getString("type");
      Intent var11 = class_384.method_2637(var4, Uri.parse(var7.getString("url")));
      class_404.class_1530 var12 = class_386.method_2656(var11, var9, var8, var10, (List)null);
      var12.method_5425(method_2652(".private:action", method_2655(var0.fI())));
      var12.method_5425(method_2654(var1));
      return new class_386(class_386.method_2657(var4, var11), var2, var5, (String)null, var12.method_5427());
   }

   // $FF: renamed from: aw (java.lang.String) com.google.android.gms.internal.hh
   private static class_394 method_2654(String var0) {
      return new class_394(var0, (new class_388.class_1553(".private:actionId")).method_4110(true).method_4114(".private:actionId").method_4113("blob").method_4115());
   }

   // $FF: renamed from: d (android.os.Bundle) com.google.android.gms.internal.mv$c
   static class_150.class_1437 method_2655(Bundle var0) {
      class_150.class_1437 var1 = new class_150.class_1437();
      ArrayList var2 = new ArrayList();

      class_150.class_1436 var6;
      for(Iterator var3 = var0.keySet().iterator(); var3.hasNext(); var2.add(var6)) {
         String var4 = (String)var3.next();
         Object var5 = var0.get(var4);
         var6 = new class_150.class_1436();
         var6.name = var4;
         var6.afz = new class_150.class_1438();
         if(var5 instanceof String) {
            var6.afz.field_664 = (String)var5;
         } else if(var5 instanceof Bundle) {
            var6.afz.afE = method_2655((Bundle)var5);
         } else {
            Log.e("AppDataSearchClient", "Unsupported value: " + var5);
         }
      }

      if(var0.containsKey("type")) {
         var1.type = var0.getString("type");
      }

      var1.afA = (class_150.class_1436[])var2.toArray(new class_150.class_1436[var2.size()]);
      return var1;
   }
}
