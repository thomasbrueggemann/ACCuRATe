package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.class_167;
import com.google.android.gms.internal.class_168;
import com.google.android.gms.internal.class_182;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.al
public class class_175 {
   // $FF: renamed from: mb com.google.android.gms.internal.al
   public static final class_175 field_572 = new class_175();

   // $FF: renamed from: aA () com.google.android.gms.internal.al
   public static class_175 method_1274() {
      return field_572;
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.au) com.google.android.gms.internal.aj
   public class_182 method_1275(Context var1, class_168 var2) {
      Date var3 = var2.getBirthday();
      long var4;
      if(var3 != null) {
         var4 = var3.getTime();
      } else {
         var4 = -1L;
      }

      String var6 = var2.getContentUrl();
      int var7 = var2.getGender();
      Set var8 = var2.getKeywords();
      List var9;
      if(!var8.isEmpty()) {
         var9 = Collections.unmodifiableList(new ArrayList(var8));
      } else {
         var9 = null;
      }

      boolean var10 = var2.isTestDevice(var1);
      int var11 = var2.method_1256();
      Location var12 = var2.getLocation();
      Bundle var13 = var2.getNetworkExtrasBundle(AdMobAdapter.class);
      boolean var14 = var2.getManualImpressionsEnabled();
      String var15 = var2.getPublisherProvidedId();
      SearchAdRequest var16 = var2.method_1253();
      class_167 var17;
      if(var16 != null) {
         var17 = new class_167(var16);
      } else {
         var17 = null;
      }

      return new class_182(4, var4, var13, var7, var9, var10, var11, var14, var15, var17, var12, var6, var2.method_1255());
   }
}
